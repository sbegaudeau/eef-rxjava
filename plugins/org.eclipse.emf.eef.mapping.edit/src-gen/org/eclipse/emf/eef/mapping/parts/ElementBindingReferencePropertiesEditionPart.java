/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ElementBindingReferencePropertiesEditionPart.java,v 1.11 2009/07/31 14:10:32 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;
 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface ElementBindingReferencePropertiesEditionPart {

	/**
	 * @return the binding
	 */
	public EObject getBinding();

	/**
	 * Init the binding
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initBinding(ResourceSet allResources, EObject current);

	/**
	 * Defines a new binding
	 * @param newValue the new binding to set
	 */
	public void setBinding(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setBindingButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the binding edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToBinding(ViewerFilter filter);

	/**
	 * Adds the given filter to the binding edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToBinding(ViewerFilter filter);










	// Start of user code for additional methods
 	
	// End of user code

}

