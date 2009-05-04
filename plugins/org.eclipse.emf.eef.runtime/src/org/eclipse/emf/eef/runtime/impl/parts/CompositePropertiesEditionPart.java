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
package org.eclipse.emf.eef.runtime.impl.parts;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IMessageManager;

/**
 * A standard implementation of the {@link IPropertiesEditionPart} by a SWT {@link Composite}.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public abstract class CompositePropertiesEditionPart implements IPropertiesEditionPart {

	/**
	 * The component that manage this part.
	 */
	protected IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * The part view.
	 */
	protected Composite view;

	/**
	 * The message manager.
	 */
	protected IMessageManager messageManager;
	
	/**
	 * The adapter factory.
	 */
	protected AdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * The edited element
	 */
	protected EObject current;
	
	/**
	 * the current ResourceSet
	 */
	protected ResourceSet resourceSet;
	
	/**
	 * Defines if part has changed
	 */
	protected boolean partHasChanged = false;

	/**
	 * Parameterized constructeur.
	 * 
	 * @param editionComponent
	 *            the component that manage this part
	 */
	public CompositePropertiesEditionPart(IPropertiesEditionComponent editionComponent) {
		this.propertiesEditionComponent = editionComponent;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#setContext(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void setContext(EObject eObject, ResourceSet allResources) {
		this.current = eObject;
		this.resourceSet = allResources;
	}

	/**
	 * Getter for the view
	 * 
	 * @return the part view
	 */
	public Composite getFigure() {
		return view;
	}

	/**
	 * @param event
	 */
	public void handleNotificationEvent(Notification event) {
		partHasChanged = true;
	}
	
	/**
	 * Return <code>true</code> if part has changed
	 * 
	 * @return the hasChanged
	 */
	public boolean hasChanged() {
		return partHasChanged;
	}

	/**
	 * @param partHasChanged
	 *            the partHasChanged to set
	 */
	protected void setHasChanged(boolean partHasChanged) {
		this.partHasChanged = partHasChanged;
	}
	
}
