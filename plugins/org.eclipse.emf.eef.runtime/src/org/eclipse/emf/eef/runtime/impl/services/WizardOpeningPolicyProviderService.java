/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy;
import org.eclipse.emf.eef.runtime.ui.wizards.impl.StandardWizardOpeningPolicy;

/**
 * Service that manage all the registered {@link IWizardOpeningPolicy}.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class WizardOpeningPolicyProviderService {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "WizardOpeningPolicyProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "WizardOpeningPolicyProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "policyClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static WizardOpeningPolicyProviderService instance = new WizardOpeningPolicyProviderService();

	/**
	 * The factory where the providers are registered.
	 */
	private List<IWizardOpeningPolicy> wizardOpeningPolicies;

	/**
	 * Default constructor.
	 */
	private WizardOpeningPolicyProviderService() {
		wizardOpeningPolicies = new ArrayList<IWizardOpeningPolicy>();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static WizardOpeningPolicyProviderService getInstance() {
		return instance;
	}

	/**
	 * @return all the registered policies
	 */
	public List<IWizardOpeningPolicy> getPolicies() {
		return wizardOpeningPolicies;
	}


	/**
	 * Register a policy.
	 * 
	 * @param wizardOpeningPolicy IWizardOpeningPolicy
	 */
	public void register(IWizardOpeningPolicy wizardOpeningPolicy) {
		wizardOpeningPolicies.add(wizardOpeningPolicy);
	}

	/**
	 * Load all the providers registered by extension point.
	 */
	private void configureService() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				EEFRuntimePlugin.PLUGIN_ID, EXTENSION_NAME);

		IExtension[] extensions = extensionPoint.getExtensions();
		for (int extensionIndex = 0; extensionIndex < extensions.length; extensionIndex++) {
			IExtension extension = extensions[extensionIndex];
			IConfigurationElement[] configurationElements = extension.getConfigurationElements();
			for (int i = 0; i < configurationElements.length; i++) {
				IConfigurationElement cfg = configurationElements[i];

				if (EXTENSION_ELEMENT_NAME.equals(cfg.getName())) {
					try {
						register((IWizardOpeningPolicy)cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
	
	/**
	 * @param eObject EObject
	 * @return the first IWizardOpeningPolicy providing eObject
	 */
	public static IWizardOpeningPolicy provide(EObject eObject) {
		IWizardOpeningPolicy wizardOpeningPolicy = getWizardOpeningPolicy(eObject);
		if (wizardOpeningPolicy == null) {
			wizardOpeningPolicy = new StandardWizardOpeningPolicy();
		}
		return wizardOpeningPolicy;
	}

	private static IWizardOpeningPolicy getWizardOpeningPolicy(EObject eObject) {
		for (IWizardOpeningPolicy openingPolicy : EEFRuntimePlugin.getDefault().getWizardOpeningPolicies()) {
			if (openingPolicy.provide(eObject)) {
				return openingPolicy;
			}
		}
		return null;
	}

}
