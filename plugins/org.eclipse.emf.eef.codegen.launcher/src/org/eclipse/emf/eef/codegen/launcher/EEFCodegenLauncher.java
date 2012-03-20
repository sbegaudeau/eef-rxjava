/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.launcher;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EEFCodegenLauncher extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.eef.codegen.launcher"; //$NON-NLS-1$

	// The shared instance
	private static EEFCodegenLauncher plugin;
	
	/**
	 * The constructor
	 */
	public EEFCodegenLauncher() {
	}

	public void logError(Exception e) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e);
		getLog().log(status);
	}

	public void logWarning(Exception e) {
		IStatus status = new Status(IStatus.WARNING, PLUGIN_ID, e.getMessage(), e);
		getLog().log(status);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EEFCodegenLauncher getDefault() {
		return plugin;
	}

}
