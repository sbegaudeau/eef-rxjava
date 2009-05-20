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
package org.eclipse.emf.eef.runtime.impl.components;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.StringTools;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public abstract class StandardPropertiesEditionComponent implements IPropertiesEditionComponent {

	/**
	 * List of IPropertiesEditionComponentListeners
	 */
	private List<IPropertiesEditionListener> listeners;

	/**
	 * the semantic listener dedicated to update view
	 */
	protected Adapter semanticAdapter;

	/**
	 * the editing domain where to perform live update
	 */
	protected EditingDomain liveEditingDomain;

	/**
	 * the editing mode
	 */
	protected String editing_mode;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class,
	 *      int, org.eclipse.emf.ecore.EObject)
	 */
	public void initPart(Class key, int kind, EObject element) {
		this.initPart(key, kind, element, element.eResource().getResourceSet());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#addListener(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener)
	 */
	public void addListener(IPropertiesEditionListener listener) {
		if (listeners == null)
			listeners = new ArrayList<IPropertiesEditionListener>();
		listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#removeListener(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener)
	 */
	public void removeListener(IPropertiesEditionListener listener) {
		if (listeners != null)
			listeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#setLiveEditingDomain(org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public void setLiveEditingDomain(EditingDomain editingDomain) {
		this.liveEditingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		event.addHolder(this);
		for (IPropertiesEditionListener listener : listeners) {
			if (!event.hold(listener))
				listener.firePropertiesChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#mustBeComposed(java.lang.Class,
	 *      int)
	 */
	public boolean mustBeComposed(Class key, int kind) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#isRequired(java.lang.Class,
	 *      int)
	 */
	public boolean isRequired(String key, int kind) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getHelpContent(java.lang.String,
	 *      int)
	 */
	public String getHelpContent(String key, int kind) {
		return StringTools.EMPTY_STRING;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public Class translatePart(String key) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#setPropertiesEditionPart(java.lang.Class,
	 *      int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		// Default case : nothing to do
	}

}
