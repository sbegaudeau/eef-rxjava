/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.services;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory;
import org.eclipse.emf.eef.runtime.impl.providers.StandardPropertiesEditionPolicyProviderFactory;

/**
 * Service that manage all the registered {@link IPropertiesEditionPolicyProvider}.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionPolicyProviderService implements IPropertiesEditionPolicyProviderFactory {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "PropertiesEditionPolicyProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "PropertiesEditionPolicyProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "providerClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static PropertiesEditionPolicyProviderService instance = new PropertiesEditionPolicyProviderService();

	/**
	 * The factory where the providers are registered.
	 */
	private IPropertiesEditionPolicyProviderFactory editPropertiesProviderFactory;

	/**
	 * Default constructor.
	 */
	private PropertiesEditionPolicyProviderService() {
		editPropertiesProviderFactory = new StandardPropertiesEditionPolicyProviderFactory();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static PropertiesEditionPolicyProviderService getInstance() {
		return instance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#getProvider(org.eclipse.emf.ecore.EObject)
	 */
	public IPropertiesEditionPolicyProvider getProvider(EObject eObject) {
		return editPropertiesProviderFactory.getProvider(eObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return editPropertiesProviderFactory.provides(eObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#register(org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider)
	 */
	public void register(IPropertiesEditionPolicyProvider editPropertiesProvider) {
		editPropertiesProviderFactory.register(editPropertiesProvider);
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
						register((IPropertiesEditionPolicyProvider)cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
