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
package org.eclipse.emf.eef.cdo.runtime.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.eef.cdo.runtime.EEFCDORuntimePlugin;
import org.eclipse.emf.eef.cdo.runtime.provider.ICDOLockStrategyProvider;

/**
 * Service that manage all the registered
 * {@link ICDOLockStrategyProvider}.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class CDOLockStrategyProviderService {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "CDOLockStrategyProvider"; //$NON-NLS-1$

	/**
	 * The extension's element name.
	 */
	private static final String EXTENSION_ELEMENT_NAME = "CDOLockStrategyProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "policyClass"; //$NON-NLS-1$

	/**
	 * A singleton for the service.
	 */
	private static CDOLockStrategyProviderService instance = new CDOLockStrategyProviderService();

	/**
	 * The factory where the providers are registered.
	 */
	private List<ICDOLockStrategyProvider> cdoLockStrategyProviders;

	/**
	 * Default constructor.
	 */
	private CDOLockStrategyProviderService() {
		cdoLockStrategyProviders = new ArrayList<ICDOLockStrategyProvider>();
		configureService();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the Singleton instance
	 */
	public static CDOLockStrategyProviderService getInstance() {
		return instance;
	}

	/**
	 * @return all the registered policies
	 */
	public List<ICDOLockStrategyProvider> getProviders() {
		return cdoLockStrategyProviders;
	}

	/**
	 * Register a listener.
	 * 
	 * @param lockStrategy
	 *            ICDOLockStrategyProvider
	 */
	public void register(ICDOLockStrategyProvider lockStrategy) {
		cdoLockStrategyProviders.add(lockStrategy);
	}

	/**
	 * Load all the providers registered by extension point.
	 */
	private void configureService() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint(EEFCDORuntimePlugin.PLUGIN_ID,
						EXTENSION_NAME);

		IExtension[] extensions = extensionPoint.getExtensions();
		for (int extensionIndex = 0; extensionIndex < extensions.length; extensionIndex++) {
			IExtension extension = extensions[extensionIndex];
			IConfigurationElement[] configurationElements = extension
					.getConfigurationElements();
			for (int i = 0; i < configurationElements.length; i++) {
				IConfigurationElement cfg = configurationElements[i];

				if (EXTENSION_ELEMENT_NAME.equals(cfg.getName())) {
					try {
						register((ICDOLockStrategyProvider) cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
