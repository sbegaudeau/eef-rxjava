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
package org.eclipse.emf.eef.codegen.ecore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class EMFCodegenPlugin extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.eclipse.emf.eef.codegen.ecore";

	/**
	 * The shared instance.
	 */
	private static EMFCodegenPlugin plugin;

	/**
	 * The constructor.
	 */
	public EMFCodegenPlugin() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static EMFCodegenPlugin getDefault() {
		return plugin;
	}

	public void logError(Exception e) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e);
		getLog().log(status);
	}

	public void logWarning(Exception e) {
		IStatus status = new Status(IStatus.WARNING, PLUGIN_ID, e.getMessage(), e);
		getLog().log(status);
	}

	public void createGIF(byte[] result, Path itemIconFilePath) {
		OutputStream outputStream;
		try {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(itemIconFilePath);
			File f = new File(file.getLocation().toString());
			if (!f.exists()) {
				f.getParentFile().mkdirs();
				f.createNewFile();
				
				outputStream = new FileOutputStream(f);
				outputStream.write(result);
				outputStream.close();
			}
		} catch (IOException e) {
			EMFCodegenPlugin.getDefault().logError(e);
		}
	}
}
