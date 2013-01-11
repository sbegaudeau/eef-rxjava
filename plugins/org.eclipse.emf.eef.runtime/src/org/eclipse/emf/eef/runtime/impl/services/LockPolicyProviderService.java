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
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.policies.ILockPolicy;

/**
 * Service that manage all the registered {@link ILockPolicy}.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class LockPolicyProviderService {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "LockPolicyProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "LockPolicyProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "policyClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static LockPolicyProviderService instance = new LockPolicyProviderService();

	/**
	 * The factory where the providers are registered.
	 */
	private List<ILockPolicy> lockPolicies;

	/**
	 * Default constructor.
	 */
	private LockPolicyProviderService() {
		lockPolicies = new ArrayList<ILockPolicy>();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static LockPolicyProviderService getInstance() {
		return instance;
	}

	/**
	 * @return all the registered policies
	 */
	public List<ILockPolicy> getPolicies() {
		return lockPolicies;
	}


	/**
	 * Register a policy.
	 * 
	 * @param lockPolicy LockPolicy
	 */
	public void register(ILockPolicy lockPolicy) {
		lockPolicies.add(lockPolicy);
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
						register((ILockPolicy)cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
