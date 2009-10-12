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
package org.eclipse.emf.eef.runtime.api.component;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

/**
 * A stateful element to edit an EObject divided in one or more parts.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionComponent extends IPropertiesEditionListener {

	public static final String BATCH_MODE = "Batch";

	public static final String LIVE_MODE = "Live";

	/**
	 * Returns the Edition Parts list.
	 * 
	 * @return a String array with all parts keys
	 */
	public abstract String[] partsList();

	/**
	 * Return the Edition Part in the given context.
	 * 
	 * @param parent
	 *            the context - the composite where the part will be used
	 * @param allResources
	 *            the resourceSet where is the EObject
	 * @param kind
	 *            the kind ot the expected Part
	 * @param key
	 *            the Part key
	 * @return the Part created in the parent
	 */
	public abstract IPropertiesEditionPart getPropertiesEditionPart(int kind, String key);

	/**
	 * Return the command to update the EObject.
	 * 
	 * @param editingDomain
	 *            the editingDomain where the command will be applied
	 * @return a command to update the edited EObject with the values defined in the different parts OR null
	 *         if nothing to do
	 */
	public abstract CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain);

	/**
	 * @param key
	 *            the key identifying the ElementEditor
	 * @param kind
	 *            the kind of the part
	 * @param element
	 *            the element which initialize the part
	 * @param allResource
	 *            the resource where the part has to process
	 */
	public abstract void initPart(Class key, int kind, EObject element, ResourceSet allResource);

	/**
	 * @param key
	 *            the key identifying the ElementEditor
	 * @param kind
	 *            the kind of the part
	 * @param element
	 *            the element which initialize the part
	 * @param allResource
	 *            the resource where the part has to process
	 */
	public abstract void initPart(Class key, int kind, EObject element);

	/**
	 * Return a copy of the EObject updated.
	 * 
	 * @return a copy of the edited EObject with features updated with the values defined in the sub-component
	 *         parts
	 */
	public abstract EObject getPropertiesEditionObject(EObject source);

	/**
	 * Return the diagnostic object linked to the current state validation.
	 * 
	 * @return a list of errors message
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event);

	/**
	 * Return the diagnostic object linked to the edited element.
	 * 
	 * @return a list of errors message
	 */
	public Diagnostic validate();

	/**
	 * Listening management - Adding a new listener.
	 * 
	 * @param listener
	 *            the new listener to notify
	 */
	public void addListener(IPropertiesEditionListener listener);

	/**
	 * Listening management - Removing a new listener.
	 * 
	 * @param listener
	 *            the listener to no longer notify
	 */
	public void removeListener(IPropertiesEditionListener listener);

	/**
	 * Allows to define editingDomain for live synchronization
	 * 
	 * @param editingDomain
	 *            the editingDomain to define
	 */
	public void setLiveEditingDomain(EditingDomain editingDomain);

	/**
	 * Dispose the component
	 */
	public void dispose();

	/**
	 * Set a part of the Component
	 * 
	 * @param key
	 *            the key identifying the part
	 * @param kind
	 *            the kind of the part
	 * @param propertiesEditionPart
	 *            the part to set
	 */
	public void setPropertiesEditionPart(Class key, int kind, IPropertiesEditionPart propertiesEditionPart);

	/**
	 * In dynamic case, managed PropertiesEditionPart can ask the component do decide if they compose a
	 * sub-view or not
	 * 
	 * @param key
	 *            the sub-view to check
	 * @param kind
	 *            the of the view
	 * @return <code>true</code> if the sub-view must be composed
	 */
	public boolean mustBeComposed(Class key, int kind);

	/**
	 * This method allow managed PropertiesEditionPart to ask the component if a elementEditor is required or
	 * not
	 * 
	 * @param key
	 *            the key identifying the ElementEditor
	 * @param kind
	 *            the kind of the part
	 * @return <code>true</code> if the given ElementEditor if required
	 */
	public boolean isRequired(String key, int kind);

	/**
	 * This method allow managed PropertiesEditionPart to ask the component for an ElementEditor help
	 * documentation
	 * 
	 * @param key
	 *            the key identifying the ElementEditor
	 * @param kind
	 *            the kind of the part
	 * @return the help content for the given ElementEditor according the help strategy
	 */
	public String getHelpContent(String key, int kind);

	/**
	 * This method translate a Part name into his identifier
	 * 
	 * @param key
	 *            the part name
	 * @return the key identifying the part
	 */
	public Class translatePart(String key);
}
