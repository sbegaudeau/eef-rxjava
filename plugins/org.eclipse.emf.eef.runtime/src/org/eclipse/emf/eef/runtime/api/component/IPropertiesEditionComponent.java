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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;

/**
 * A statefull element to edit an EObject divied in one or more parts.
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
	 * Return A Edition Part in the given context.
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
	public abstract IPropertiesEditionPart getPropertiesEditionPart(String kind, String key);

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
	public Diagnostic validateValue(PathedPropertiesEditionEvent event);

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

}
