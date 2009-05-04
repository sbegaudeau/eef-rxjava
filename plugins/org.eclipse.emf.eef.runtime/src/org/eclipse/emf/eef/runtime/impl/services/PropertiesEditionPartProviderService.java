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
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProviderFactory;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory;
import org.eclipse.emf.eef.runtime.impl.providers.StandardPropertiesEditionPartProviderFactory;
import org.eclipse.emf.eef.runtime.impl.providers.StandardPropertiesEditionProviderFactory;

/**
 * Service that manage all the registered {@link IPropertiesEditionPartProviderFactory}.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionPartProviderService implements IPropertiesEditionPartProviderFactory {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "PropertiesEditionPartProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "PropertiesEditionPartProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "providerClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static PropertiesEditionPartProviderService instance = new PropertiesEditionPartProviderService();

	/**
	 * The factory where the providers are registered.
	 */
	private IPropertiesEditionPartProviderFactory editPropertiesPartProviderFactory;

	/**
	 * Default constructor.
	 */
	private PropertiesEditionPartProviderService() {
		editPropertiesPartProviderFactory = new StandardPropertiesEditionPartProviderFactory();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static PropertiesEditionPartProviderService getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * fr.unedic.sumatra.donnees.common.properties.providers.IEditPropertiesProviderFactory#getProvider(org
	 * .eclipse.emf.ecore.EObject)
	 */
	public IPropertiesEditionPartProvider getProvider(Class key) {
		return editPropertiesPartProviderFactory.getProvider(key);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * fr.unedic.sumatra.donnees.common.properties.providers.IEditPropertiesProviderFactory#provides(org.eclipse
	 * .emf.ecore.EObject)
	 */
	public boolean provides(Class key) {
		return editPropertiesPartProviderFactory.provides(key);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * fr.unedic.sumatra.donnees.common.properties.providers.IEditPropertiesProviderFactory#register(fr.unedic
	 * .sumatra.donnees.common.properties.providers.IPropertiesEditionProvider)
	 */
	public void register(IPropertiesEditionPartProvider editPropertiesProvider) {
		editPropertiesPartProviderFactory.register(editPropertiesProvider);
	}

	/**
	 * Load all the providers registered by extension point.
	 */
	private void configureService() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				EMFPropertiesRuntime.PLUGIN_ID, EXTENSION_NAME);

		IExtension[] extensions = extensionPoint.getExtensions();
		for (int extensionIndex = 0; extensionIndex < extensions.length; extensionIndex++) {
			IExtension extension = extensions[extensionIndex];
			IConfigurationElement[] configurationElements = extension.getConfigurationElements();
			for (int i = 0; i < configurationElements.length; i++) {
				IConfigurationElement cfg = configurationElements[i];

				if (EXTENSION_ELEMENT_NAME.equals(cfg.getName())) {
					try {
						register((IPropertiesEditionPartProvider)cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
