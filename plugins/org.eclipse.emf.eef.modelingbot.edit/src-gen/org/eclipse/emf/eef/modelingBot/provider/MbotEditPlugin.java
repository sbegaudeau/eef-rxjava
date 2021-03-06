/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot.provider;

import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.eclipse.emf.eef.components.provider.ComponentsEditPlugin;

import org.eclipse.emf.eef.extended.editor.provider.ExtendedEditPlugin;

import org.eclipse.emf.eef.mapping.provider.MappingEditPlugin;

import org.eclipse.emf.eef.views.provider.ViewsEditPlugin;

/**
 * This is the central singleton for the Mbot edit plugin.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public final class MbotEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final MbotEditPlugin INSTANCE = new MbotEditPlugin();

	/**
	 * EEF Editor ID
	 * 
	 * @generated NOT
	 */
	public static final String INTERACTIVE_EEF_EDITOR_ID = "org.eclipse.emf.eef.runtime.ui.editor.InteractiveEEFEditorID";

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MbotEditPlugin() {
		super
		  (new ResourceLocator [] {
		     ComponentsEditPlugin.INSTANCE,
		     EcoreEditPlugin.INSTANCE,
		     ExtendedEditPlugin.INSTANCE,
		     GenModelEditPlugin.INSTANCE,
		     MappingEditPlugin.INSTANCE,
		     ViewsEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
