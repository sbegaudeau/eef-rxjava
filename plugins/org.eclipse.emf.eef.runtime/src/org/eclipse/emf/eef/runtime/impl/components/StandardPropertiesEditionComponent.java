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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public abstract class StandardPropertiesEditionComponent implements IPropertiesEditionComponent {

	/**
	 * List of IPropertiesEditionComponentListeners
	 */
	protected List listeners;

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
	protected String mode;

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#addListener(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener)
	 */
	public void addListener(IPropertiesEditionListener listener) {
		if (listeners != null)
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
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		event.addHolder(this);
		for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
			IPropertiesEditionListener listener = (IPropertiesEditionListener) iterator.next();
			if (!event.hold(listener))
				listener.firePropertiesChanged(event);
		}
	}

}
