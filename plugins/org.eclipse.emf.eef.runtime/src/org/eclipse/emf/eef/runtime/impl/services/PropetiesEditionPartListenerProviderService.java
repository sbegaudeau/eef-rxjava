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
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionComponentListener;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionPartListener;

/**
 * Service that manage all the registered {@link IPropertiesEditionPartListener}.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropetiesEditionPartListenerProviderService {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "PropertiesEditionPartListenerProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "PropertiesEditionPartListenerProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "listenerClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static PropetiesEditionPartListenerProviderService instance = new PropetiesEditionPartListenerProviderService();

	/**
	 * The factory where the providers are registered.
	 */
	private List<IPropertiesEditionPartListener> partListeners;

	/**
	 * Default constructor.
	 */
	private PropetiesEditionPartListenerProviderService() {
		partListeners = new ArrayList<IPropertiesEditionPartListener>();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static PropetiesEditionPartListenerProviderService getInstance() {
		return instance;
	}

	/**
	 * @return all the registered policies
	 */
	public List<IPropertiesEditionPartListener> getListeners() {
		return partListeners;
	}


	/**
	 * Register a listener.
	 * 
	 * @param pecListener IPropertiesEditionPartListener
	 */
	public void register(IPropertiesEditionPartListener pecListener) {
		partListeners.add(pecListener);
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
						register((IPropertiesEditionPartListener)cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
