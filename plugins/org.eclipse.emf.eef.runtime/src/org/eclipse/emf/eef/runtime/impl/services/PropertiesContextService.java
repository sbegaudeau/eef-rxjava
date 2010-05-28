/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.context.ContextEntry;

/**
 * A service to store edition context
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesContextService {

	/**
	 * The navigation stack.
	 */
	private Stack<ContextEntry> navigationStack;

	/**
	 * A singleton for the service.
	 */
	private static PropertiesContextService contextService = new PropertiesContextService();

	/**
	 * Default constructor.
	 */
	private PropertiesContextService() {
		super();
		navigationStack = new Stack<ContextEntry>();
	}

	/**
	 * Singleton constructor.
	 * 
	 * @return the contextService
	 */
	public static PropertiesContextService getInstance() {
		return contextService;
	}

	/**
	 * Push a new {@link ContextEntry} in the navigation stack.
	 * 
	 * @param element
	 *            the edited element
	 * @param component
	 *            the component that edit this element
	 */
	public void push(EObject element, IPropertiesEditionComponent component) {
		navigationStack.push(new ContextEntry(element, component));
	}

	/**
	 * Pop the last {@link ContextEntry}
	 */
	public void pop() {
		if (!navigationStack.empty())
			navigationStack.pop();
	}

	/**
	 * Returns the first edited element in this edition context.
	 * 
	 * @return the first edited element
	 */
	public EObject entryPointElement() {
		if (!navigationStack.isEmpty())
			return navigationStack.get(0).getElement();
		return null;
	}

	/**
	 * Returns the first edition component in this edition context.
	 * 
	 * @return the first editon component
	 */
	public IPropertiesEditionComponent entryPointComponent() {
		if (!navigationStack.isEmpty())
			return navigationStack.get(0).getPropertiesEditionComponent();
		return null;
	}

	/**
	 * Returns the last edited element in this edition context.
	 * 
	 * @return the last edited component
	 */
	public EObject lastElement() {
		if (!navigationStack.isEmpty())
			return navigationStack.peek().getElement();
		return null;
	}

	/**
	 * Returns the last edition component in this edition context.
	 * 
	 * @return the last editon component
	 */
	public IPropertiesEditionComponent lastComponent() {
		if (!navigationStack.isEmpty())
			return navigationStack.peek().getPropertiesEditionComponent();
		return null;
	}

	/**
	 * Returns a list of all edition component of the specified kind in the context.
	 * 
	 * @param kind
	 *            the searched kind of edition component
	 * @return all the corresponding edition component in the context
	 */
	public List<IPropertiesEditionComponent> getComponentsInContext(Class kind) {
		List<IPropertiesEditionComponent> result = new ArrayList<IPropertiesEditionComponent>();
		for (ContextEntry entry : navigationStack) {
			if (entry.getPropertiesEditionComponent().getClass().equals(kind))
				result.add(0, entry.getPropertiesEditionComponent());
		}
		return result;
	}

	/**
	 * Return an {@link Iterator} on the navigation stack.
	 * 
	 * @return an {@link Iterator} on the navigation stack
	 */
	public Iterator<ContextEntry> iterator() {
		return navigationStack.iterator();
	}

}
