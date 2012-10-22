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

package org.eclipse.emf.eef.cdo.runtime;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.session.remote.CDORemoteSessionManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFCDORuntimePlugin extends AbstractUIPlugin {

	/**
	 * The extension name.
	 */
	public static final String EXTENSION_NAME = "CDOPolicyProvider"; //$NON-NLS-1$

	/**
	 * The element's attribute name.
	 */
	private static final String EXTENSION_ATTRIBUTE_NAME = "policyClass"; //$NON-NLS-1$

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.eef.cdo.runtime"; //$NON-NLS-1$

	// The shared instance
	private static EEFCDORuntimePlugin plugin;

	/**
	 * CDO Listeners
	 */
	private List<CDORemoteSessionManager.EventAdapter> cdoListeners;

	/**
	 * The constructor
	 */
	public EEFCDORuntimePlugin() {
		cdoListeners = new ArrayList<CDORemoteSessionManager.EventAdapter>();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		initCDOListeners();
	}

	/**
	 * Load all the providers registered by extension point.
	 */
	private void initCDOListeners() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint(EEFCDORuntimePlugin.PLUGIN_ID, EXTENSION_NAME);

		IExtension[] extensions = extensionPoint.getExtensions();
		for (int extensionIndex = 0; extensionIndex < extensions.length; extensionIndex++) {
			IExtension extension = extensions[extensionIndex];
			IConfigurationElement[] configurationElements = extension
					.getConfigurationElements();
			for (int i = 0; i < configurationElements.length; i++) {
				IConfigurationElement cfg = configurationElements[i];

				if (EXTENSION_NAME.equals(cfg.getName())) {
					try {
						register((CDORemoteSessionManager.EventAdapter) cfg
								.createExecutableExtension(EXTENSION_ATTRIBUTE_NAME));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Regiter the cdo policy.
	 * 
	 * @param policy
	 *            CDORemoteSessionManager.EventAdapter
	 */
	private void register(CDORemoteSessionManager.EventAdapter policy) {
		cdoListeners.add(policy);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		cdoListeners.clear();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static EEFCDORuntimePlugin getDefault() {
		return plugin;
	}

	/**
	 * @return the cdo listeners
	 */
	public List<CDORemoteSessionManager.EventAdapter> getCDOListeners() {
		return cdoListeners;
	}
}
