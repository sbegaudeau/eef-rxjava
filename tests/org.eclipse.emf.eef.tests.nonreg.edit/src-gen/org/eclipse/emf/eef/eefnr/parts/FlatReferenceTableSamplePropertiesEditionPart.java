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
public interface FlatReferenceTableSamplePropertiesEditionPart {

	/**
	 * @return the flatreferencetableRequiredProperty to add
	 * 
	 */
	public List getFlatreferencetableRequiredPropertyToAdd();

	/**
	 * @return the flatreferencetableRequiredProperty to remove
	 * 
	 */
	public List getFlatreferencetableRequiredPropertyToRemove();

	/**
	 * @return the current flatreferencetableRequiredProperty table
	 * 
	 */
	public List getFlatreferencetableRequiredPropertyTable();

	/**
	 * Init the flatreferencetableRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initFlatreferencetableRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the flatreferencetableRequiredProperty
	 * @param newValue the flatreferencetableRequiredProperty to update
	 * 
	 */
	public void updateFlatreferencetableRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the flatreferencetableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFlatreferencetableRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the flatreferencetableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFlatreferencetableRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the flatreferencetableRequiredProperty table
	 * 
	 */
	public boolean isContainedInFlatreferencetableRequiredPropertyTable(EObject element);


	/**
	 * @return the flatreferencetableOptionalProperty to add
	 * 
	 */
	public List getFlatreferencetableOptionalPropertyToAdd();

	/**
	 * @return the flatreferencetableOptionalProperty to remove
	 * 
	 */
	public List getFlatreferencetableOptionalPropertyToRemove();

	/**
	 * @return the current flatreferencetableOptionalProperty table
	 * 
	 */
	public List getFlatreferencetableOptionalPropertyTable();

	/**
	 * Init the flatreferencetableOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initFlatreferencetableOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the flatreferencetableOptionalProperty
	 * @param newValue the flatreferencetableOptionalProperty to update
	 * 
	 */
	public void updateFlatreferencetableOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the flatreferencetableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFlatreferencetableOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the flatreferencetableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFlatreferencetableOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the flatreferencetableOptionalProperty table
	 * 
	 */
	public boolean isContainedInFlatreferencetableOptionalPropertyTable(EObject element);





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
