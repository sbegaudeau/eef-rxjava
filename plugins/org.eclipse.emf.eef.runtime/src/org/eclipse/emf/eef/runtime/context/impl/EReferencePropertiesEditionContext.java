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
package org.eclipse.emf.eef.runtime.context.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EReferencePropertiesEditionContext extends EObjectPropertiesEditionContext {

	/**
	 * the EReference to edit
	 */
	protected EReference eReference;
	
	/**
	 * EEF editor settings to use.
	 */
	private EEFEditorSettings settings;
	
	protected Collection<InstanciableTypeFilter> instanciableTypeFilters = new ArrayList<InstanciableTypeFilter>();

	/**
	 * @param parentContext
	 * @param propertiesEditionComponent
	 * @param settings
	 * @param adapterFactory
	 */
	public EReferencePropertiesEditionContext(PropertiesEditingContext parentContext, IPropertiesEditionComponent propertiesEditionComponent, EEFEditorSettings settings, AdapterFactory adapterFactory) {
		super(parentContext, propertiesEditionComponent, settings.getSource(), adapterFactory);
		this.settings = settings;
		this.eReference = settings.getLastReference();
	}

	/**
	 * @return the eReference
	 */
	public EReference getEReference() {
		return eReference;
	}

	/**
	 * @return the settings to use.
	 */
	public EEFEditorSettings getSettings() {
		return settings;
	}
	
	/**
	 * @return the filters
	 */
	public Collection<InstanciableTypeFilter> getInstanciableTypeFilters() {
		return instanciableTypeFilters;
	}
	
	/**
	 * Add a filter to the list
	 * @param filter
	 */
	public void addInstanciableTypeFilter(InstanciableTypeFilter filter) {
		instanciableTypeFilters.add(filter);
	}

	public interface InstanciableTypeFilter {
		/**
		 * Tests if the provided type can be instantiated
		 * @param instanciableType Tested type
		 * @return True if the type can be instantiate
		 */
		public boolean select(EClass instanciableType);
	}
}
