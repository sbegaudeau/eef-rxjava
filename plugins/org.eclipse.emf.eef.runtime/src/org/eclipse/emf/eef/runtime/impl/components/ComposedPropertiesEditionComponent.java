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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.NullCompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.StringTools;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ComposedPropertiesEditionComponent implements IPropertiesEditionComponent {

	/**
	 * List of managed components
	 */
	private List subComponents;

	/**
	 * List of this component listeners
	 */
	private List listeners;

	/**
	 * Default constructor
	 */
	public ComposedPropertiesEditionComponent(String mode) {
		this.subComponents = new ArrayList();
		this.listeners = new ArrayList();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param subComponents
	 *            list of the managed components
	 */
	public ComposedPropertiesEditionComponent(List subComponents) {
		this.subComponents = subComponents;
		this.listeners = new ArrayList();
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			listeners.add(component);
			component.addListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#setLiveEditingDomain(org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public void setLiveEditingDomain(EditingDomain editingDomain) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			component.setLiveEditingDomain(editingDomain);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		List partsList = new ArrayList();
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent subComponent = (IPropertiesEditionComponent)iterator.next();
			String[] partsList2 = subComponent.partsList();
			for (int i = 0; i < partsList2.length; i++) {
				String string = partsList2[i];
				if (!partsList.contains(string))
					partsList.add(string);
			}
		}
		String[] result = new String[partsList.size()];
		int i = 0;
		for (Iterator iterator = partsList.iterator(); iterator.hasNext();) {
			String nextPart = (String)iterator.next();
			result[i++] = nextPart;
		}
		return result;
	}

	
	
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(Class key, int kind, EObject element, ResourceSet allResource) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			component.initPart(key, kind, element, allResource);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject)
	 */
	public void initPart(Class key, int kind, EObject element) {
		this.initPart(key, kind, element, element.eResource().getResourceSet());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart(java.lang.String,
	 *      java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent subComponent = (IPropertiesEditionComponent)iterator.next();
			IPropertiesEditionPart propertiesEditionPart = subComponent.getPropertiesEditionPart(kind, key);
			if (propertiesEditionPart != null
					&& !(propertiesEditionPart instanceof NullCompositePropertiesEditionPart))
				return propertiesEditionPart;
		}
		return new NullCompositePropertiesEditionPart(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand(org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent subComponent = (IPropertiesEditionComponent)iterator.next();
			CompoundCommand command = subComponent.getPropertiesEditionCommand(editingDomain);
			if (command != null && command.canExecute()) {
				cc.append(command);
			} else {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform command.", null);
			}

		}
		if (cc.isEmpty())
			cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent subComponent = (IPropertiesEditionComponent)iterator.next();
			source = subComponent.getPropertiesEditionObject(source);
		}
		return source;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		event.addHolder(this);
		for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
			IPropertiesEditionListener listener = (IPropertiesEditionListener)iterator.next();
			if (!event.hold(listener))
				listener.firePropertiesChanged(event);
		}
	}

	/**
	 * Add a new component of the managed components
	 * 
	 * @param component
	 *            the component to add
	 */
	public void addSubComponent(IPropertiesEditionComponent component) {
		if (subComponents != null && listeners != null) {
			subComponents.add(component);
			listeners.add(component);
			component.addListener(this);
		}
	}

	/**
	 * Remove a component from the managed components
	 * 
	 * @param component
	 *            the component to removed
	 */
	public void removeSubComponent(IPropertiesEditionComponent component) {
		if (subComponents != null && listeners != null) {
			component.removeListener(this);
			subComponents.remove(component);
			listeners.remove(component);
		}
	}

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
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "EEF validation", 0,
				"No problem detected", null);
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			Diagnostic validateValue = component.validateValue(event);
			if (validateValue != null)
				diagnostic.add(validateValue);
		}
		diagnostic.recomputeSeverity();
		return diagnostic;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "EEF Validation", Status.OK,
				"No problem detected", null);
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			diagnostic.getChildren().add(component.validate());
		}
		return diagnostic;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			component.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#mustBeComposed(java.lang.Class, int)
	 * Very strange case ... shouldn't be invoke ...
	 */
	public boolean mustBeComposed(Class key, int kind) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			if (!component.mustBeComposed(key, kind))
				return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#isRequired(java.lang.Class, int)
	 */
	public boolean isRequired(String key, int kind) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			if (component.isRequired(key, kind))
				return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			if (component.getHelpContent(key, kind) != StringTools.EMPTY_STRING)
				return component.getHelpContent(key, kind);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public Class translatePart(String key) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			if (component.translatePart(key) != null)
				return component.translatePart(key);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		for (Iterator iterator = subComponents.iterator(); iterator.hasNext();) {
			IPropertiesEditionComponent component = (IPropertiesEditionComponent)iterator.next();
			component.setPropertiesEditionPart(key, kind, propertiesEditionPart);
		}		
	}
	
	

}
