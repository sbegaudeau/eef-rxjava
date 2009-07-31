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
 * $Id: SimpleModelNavigationPropertiesEditionPart.java,v 1.9 2009/07/31 14:07:30 glefur Exp $
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
public interface SimpleModelNavigationPropertiesEditionPart {

	/**
	 * @return the index
	 */
	public String getIndex();

	/**
	 * Defines a new index
	 * @param newValue the new index to set
	 */
	public void setIndex(String newValue);

	public void setMessageForIndex(String msg, int msgLevel);

	public void unsetMessageForIndex();

	/**
	 * @return the feature
	 */
	public EObject getFeature();

	/**
	 * Init the feature
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initFeature(ResourceSet allResources, EObject current);

	/**
	 * Defines a new feature
	 * @param newValue the new feature to set
	 */
	public void setFeature(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setFeatureButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the feature edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToFeature(ViewerFilter filter);

	/**
	 * Adds the given filter to the feature edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToFeature(ViewerFilter filter);





	/**
	 * @return the discriminatorType
	 */
	public EObject getDiscriminatorType();

	/**
	 * Init the discriminatorType
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initDiscriminatorType(ResourceSet allResources, EObject current);

	/**
	 * Defines a new discriminatorType
	 * @param newValue the new discriminatorType to set
	 */
	public void setDiscriminatorType(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setDiscriminatorTypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the discriminatorType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToDiscriminatorType(ViewerFilter filter);

	/**
	 * Adds the given filter to the discriminatorType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToDiscriminatorType(ViewerFilter filter);










	// Start of user code for additional methods
 	
	// End of user code

}

