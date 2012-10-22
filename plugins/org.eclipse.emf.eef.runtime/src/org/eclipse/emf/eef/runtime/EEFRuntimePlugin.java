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
package org.eclipse.emf.eef.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionComponentListener;
import org.eclipse.emf.eef.runtime.api.providers.IReadOnlyPolicy;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentListenerProviderService;
import org.eclipse.emf.eef.runtime.impl.services.ReadOnlyPolicyProviderService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EEFRuntimePlugin extends AbstractUIPlugin {

	/** The icons path. */
	public static final String ICONS_16x16 = "icons/16x16/"; //$NON-NLS-1$

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "org.eclipse.emf.eef.runtime"; //$NON-NLS-1$

	/** The shared instance. */
	private static EEFRuntimePlugin plugin;

	/** The shared adapterFactory. */
	private static AdapterFactory adapterFactory;

	/** The shared diagnostician. */
	private static Diagnostician diagnostician;

	/** The shared imageRegistry. */
	private static ImageRegistry imageRegistry = null;
	
	/**
	 * Read only policies
	 */
	private List<IReadOnlyPolicy> readOnlyPolicies = null;
	
	/**
	 * Read only policies
	 */
	private List<IPropertiesEditionComponentListener> pecListeners = null;


	/**
	 * @return the Image associated to the key
	 */
	public Image getRegisteredImage(String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * @param key
	 * @param path
	 */
	public void registerImage(String key, String path) {
		if (getImageRegistry().get(key) != null)
			getImageRegistry().remove(key);
		getImageRegistry().put(key, ImageDescriptor.createFromFile(null, path));
	}

	public ImageRegistry getImageRegistry() {
		if (imageRegistry == null)
			imageRegistry = new ImageRegistry();
		return imageRegistry;
	}

	/**
	 * The constructor.
	 */
	public EEFRuntimePlugin() {
		plugin = this;
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		diagnostician = new Diagnostician() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.ecore.util.Diagnostician#doValidateContents(org.eclipse.emf.ecore.EObject,
			 *      org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
			 */
			@Override
			protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				return true;
			}

		};
		readOnlyPolicies = new ArrayList<IReadOnlyPolicy>(1);
		pecListeners = new ArrayList<IPropertiesEditionComponentListener>(1);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		initReadOnlyPolicies();
		initPECListeners();
	}

	/**
	 * Init read only policies : use the service and find the extension point
	 */
	private void initReadOnlyPolicies() {
		readOnlyPolicies.addAll(ReadOnlyPolicyProviderService.getInstance().getPolicies());
		
	}
	
	/**
	 * Init Properties Edition Component listeners : find the extension point
	 */
	private void initPECListeners() {
		pecListeners.addAll(PropertiesEditionComponentListenerProviderService.getInstance().getListeners());
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (imageRegistry != null)
			imageRegistry.dispose();
		pecListeners.clear();
		readOnlyPolicies.clear();
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static EEFRuntimePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the shared adapterFactory.
	 * 
	 * @return the shared adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @return the diagnostician
	 */
	public static Diagnostician getEEFValidator() {
		return diagnostician;
	}

	/**
	 * @param msg
	 *            a description message
	 * @param e
	 *            the error
	 */
	public void logError(String msg, Exception e) {
		getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory
	 * <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * @return the Image
	 */
	public static Image getImage(String key) {
		final ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if (image == null) {
			final ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory
	 * <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * @return the Image
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
	}
	
	/**
	 * @return the read only policies
	 */
	public List<IReadOnlyPolicy> getReadOnlyPolicies() {
		return readOnlyPolicies;
	}

	/**
	 * @return the properties edition component listeners
	 */
	public List<IPropertiesEditionComponentListener> getPecListeners() {
		return pecListeners;
	}

}
