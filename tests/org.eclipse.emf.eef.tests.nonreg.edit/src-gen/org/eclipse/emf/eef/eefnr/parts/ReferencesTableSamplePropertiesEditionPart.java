/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.parts;

// Start of user code for imports
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface ReferencesTableSamplePropertiesEditionPart {

	/**
	 * @return the referencestableRequiredProperty to add
	 * 
	 */
	public List getReferencestableRequiredPropertyToAdd();

	/**
	 * @return the referencestableRequiredProperty to remove
	 * 
	 */
	public List getReferencestableRequiredPropertyToRemove();

	/**
	 * @return the current referencestableRequiredProperty table
	 * 
	 */
	public List getReferencestableRequiredPropertyTable();

	/**
	 * Init the referencestableRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReferencestableRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the referencestableRequiredProperty
	 * @param newValue the referencestableRequiredProperty to update
	 * 
	 */
	public void updateReferencestableRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the referencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencestableRequiredProperty table
	 * 
	 */
	public boolean isContainedInReferencestableRequiredPropertyTable(EObject element);


	/**
	 * @return the referencestableOptionalProperty to add
	 * 
	 */
	public List getReferencestableOptionalPropertyToAdd();

	/**
	 * @return the referencestableOptionalProperty to remove
	 * 
	 */
	public List getReferencestableOptionalPropertyToRemove();

	/**
	 * @return the current referencestableOptionalProperty table
	 * 
	 */
	public List getReferencestableOptionalPropertyTable();

	/**
	 * Init the referencestableOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReferencestableOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the referencestableOptionalProperty
	 * @param newValue the referencestableOptionalProperty to update
	 * 
	 */
	public void updateReferencestableOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the referencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencestableOptionalProperty table
	 * 
	 */
	public boolean isContainedInReferencestableOptionalPropertyTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
