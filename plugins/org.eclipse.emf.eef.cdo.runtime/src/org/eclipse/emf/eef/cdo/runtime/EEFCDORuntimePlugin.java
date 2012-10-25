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

import org.eclipse.emf.eef.cdo.runtime.provider.ICDOLockStrategyProvider;
import org.eclipse.emf.eef.cdo.runtime.service.CDOLockStrategyProviderService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFCDORuntimePlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.eef.cdo.runtime"; //$NON-NLS-1$

	// The shared instance
	private static EEFCDORuntimePlugin plugin;

	/**
	 * CDO Listeners
	 */
	private List<ICDOLockStrategyProvider> lockStrategyProvider;

	/**
	 * The constructor
	 */
	public EEFCDORuntimePlugin() {
		lockStrategyProvider = new ArrayList<ICDOLockStrategyProvider>();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		initCDOLockStrategyProvider();
	}
	
	/**
	 * Init Properties Edition Component listeners : find the extension point
	 */
	private void initCDOLockStrategyProvider() {
		lockStrategyProvider.addAll(CDOLockStrategyProviderService.getInstance().getProviders());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		lockStrategyProvider.clear();
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
	 * @return the cdo lock strategy provider
	 */
	public List<ICDOLockStrategyProvider> getLockStrategyProvider() {
		return lockStrategyProvider;
	}
}
