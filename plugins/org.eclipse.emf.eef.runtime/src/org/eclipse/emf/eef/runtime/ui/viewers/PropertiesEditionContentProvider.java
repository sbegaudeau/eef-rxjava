/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.viewers;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionContentProvider implements IStructuredContentProvider {

	private IPropertiesEditionProvider propertiesEditionProvider;

	private IPropertiesEditionComponent propertiesEditionComponent;

	private String mode;

	private EditingDomain editingDomain;

	/**
	 * @param propertiesEditionProvider
	 */
	public PropertiesEditionContentProvider(IPropertiesEditionProvider propertiesEditionProvider, String mode)
			throws InstantiationException {
		if (mode == IPropertiesEditionComponent.LIVE_MODE)
			throw new InstantiationException(EEFRuntimeUIMessages.PropertiesEditionContentProvider_editingDomain_not_defined);
		this.propertiesEditionProvider = propertiesEditionProvider;
		this.mode = mode;
	}

	/**
	 * @param propertiesEditionProvider
	 */
	public PropertiesEditionContentProvider(IPropertiesEditionProvider propertiesEditionProvider,
			String mode, EditingDomain editingDomain) {
		this.propertiesEditionProvider = propertiesEditionProvider;
		this.mode = mode;
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		if (propertiesEditionComponent != null) {
			PropertiesContextService.getInstance().pop();
			propertiesEditionComponent.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (propertiesEditionComponent != null) {
			PropertiesContextService.getInstance().pop();
			propertiesEditionComponent.dispose();
		}
		this.propertiesEditionComponent = propertiesEditionProvider.getPropertiesEditionComponent(
				(EObject)newInput, mode);
		if (propertiesEditionComponent != null && mode == IPropertiesEditionComponent.LIVE_MODE)
			propertiesEditionComponent.setLiveEditingDomain(editingDomain);

		// FIXME: find a better way to manage the context
		PropertiesContextService.getInstance().push((EObject)newInput, propertiesEditionComponent);
	}

	/**
	 * @param listener
	 *            the properties listener to add
	 */
	public void addPropertiesListener(IPropertiesEditionListener listener) {
		if (propertiesEditionComponent != null)
			propertiesEditionComponent.addListener(listener);
	}

	/**
	 * Compute the edition command to perform to update the model
	 * 
	 * @param editingDomain
	 *            the editingDomain where the command have to be performed
	 * @return the command to perform
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		if (propertiesEditionComponent != null)
			return propertiesEditionComponent.getPropertiesEditionCommand(editingDomain);
		return null;
	}

	/**
	 * Update and return the given EObject
	 * 
	 * @param eObject
	 *            the EObject to update
	 * @return the updated EObject
	 */
	public EObject getPropertiesEditionObject(EObject eObject) {
		if (propertiesEditionComponent != null)
			return propertiesEditionComponent.getPropertiesEditionObject(eObject);
		return null;
	}

	/**
	 * Validate the model and return the resulting Diagnostic
	 * 
	 * @param event
	 *            the event triggering the validation
	 * @return the resulting value
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		if (propertiesEditionComponent != null)
			return propertiesEditionComponent.validateValue(event);
		return null;
	}

	/**
	 * Returns the Edition Parts list.
	 * 
	 * @return a String array with all parts keys
	 */
	public String[] partsList() {
		if (propertiesEditionComponent != null)
			return propertiesEditionComponent.partsList();
		return new String[0];
	}

	/**
	 * Return the Edition Part in the given context.
	 * 
	 * @param kind
	 *            the kind of the expected Part
	 * @param key
	 *            the Part key
	 * @return the Part created in the parent
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (propertiesEditionComponent != null)
			return propertiesEditionComponent.getPropertiesEditionPart(kind, key);
		return null;
	}

	/**
	 * This method translate a Part name into his identifier
	 * 
	 * @param key
	 *            the part name
	 * @return the key identifying the part
	 */
	public Class translatePart(String key) {
		if (propertiesEditionComponent != null)
			return propertiesEditionComponent.translatePart(key);
		return null;
	}

	/**
	 * @param key
	 *            the key identifying the ElementEditor
	 * @param kind
	 *            the kind of the part
	 * @param element
	 *            the element which initialize the part
	 */
	public void initPart(Class key, int kind, EObject element) {
		if (propertiesEditionComponent != null)
			propertiesEditionComponent.initPart(key, kind, element);
	}

	/**
	 * @param key
	 *            the key identifying the ElementEditor
	 * @param kind
	 *            the kind of the part
	 * @param element
	 *            the element which initialize the part
	 * @param allResources
	 *            the resource where the part has to process
	 */
	public void initPart(Class key, int kind, EObject element, ResourceSet allResources) {
		if (propertiesEditionComponent != null)
			propertiesEditionComponent.initPart(key, kind, element, allResources);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return new Object[] {inputElement};
	}

}
