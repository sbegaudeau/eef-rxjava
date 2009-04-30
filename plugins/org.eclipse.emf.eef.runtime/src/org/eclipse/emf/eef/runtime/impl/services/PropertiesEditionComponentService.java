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
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory;
import org.eclipse.emf.eef.runtime.impl.providers.StandardPropertiesEditionProviderFactory;

/**
 * Service that manage all the registered {@link IPropertiesEditionProviderFactory}.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionComponentService implements IPropertiesEditionProviderFactory {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "PropertiesEditionProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "PropertiesEditionComponentProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "providerClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static PropertiesEditionComponentService instance = new PropertiesEditionComponentService();

	/**
	 * The factory where the providers are registered.
	 */
	private IPropertiesEditionProviderFactory editPropertiesProviderFactory;

	/**
	 * Default constructor.
	 */
	private PropertiesEditionComponentService() {
		editPropertiesProviderFactory = new StandardPropertiesEditionProviderFactory();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static PropertiesEditionComponentService getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * fr.unedic.sumatra.donnees.common.properties.providers.IEditPropertiesProviderFactory#getProvider(org
	 * .eclipse.emf.ecore.EObject)
	 */
	public IPropertiesEditionProvider getProvider(EObject eObject) {
		return editPropertiesProviderFactory.getProvider(eObject);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * fr.unedic.sumatra.donnees.common.properties.providers.IEditPropertiesProviderFactory#provides(org.eclipse
	 * .emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return editPropertiesProviderFactory.provides(eObject);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * fr.unedic.sumatra.donnees.common.properties.providers.IEditPropertiesProviderFactory#register(fr.unedic
	 * .sumatra.donnees.common.properties.providers.IPropertiesEditionProvider)
	 */
	public void register(IPropertiesEditionProvider editPropertiesProvider) {
		editPropertiesProviderFactory.register(editPropertiesProvider);
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
						register((IPropertiesEditionProvider)cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
