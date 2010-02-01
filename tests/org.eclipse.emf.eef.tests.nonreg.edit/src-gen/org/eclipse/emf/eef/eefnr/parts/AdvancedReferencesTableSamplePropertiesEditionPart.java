/*******************************************************************************
 * Copyright (c) 2009 Obeo.
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
 */
public interface AdvancedReferencesTableSamplePropertiesEditionPart {

	/**
	 * @return the advancedreferencestableRequiredProperty to add
	 */
	public List getAdvancedreferencestableRequiredPropertyToAdd();

	/**
	 * @return the advancedreferencestableRequiredProperty to remove
	 */
	public List getAdvancedreferencestableRequiredPropertyToRemove();

	/**
	 * @return the current advancedreferencestableRequiredProperty table
	 */
	public List getAdvancedreferencestableRequiredPropertyTable();

	/**
	 * Init the advancedreferencestableRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedreferencestableRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedreferencestableRequiredProperty
	 * @param newValue the advancedreferencestableRequiredProperty to update
	 */
	public void updateAdvancedreferencestableRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedreferencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedreferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedreferencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedreferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedreferencestableRequiredProperty table
	 */
	public boolean isContainedInAdvancedreferencestableRequiredPropertyTable(EObject element);






	/**
	 * @return the advancedreferencestableOptionalProperty to add
	 */
	public List getAdvancedreferencestableOptionalPropertyToAdd();

	/**
	 * @return the advancedreferencestableOptionalProperty to remove
	 */
	public List getAdvancedreferencestableOptionalPropertyToRemove();

	/**
	 * @return the current advancedreferencestableOptionalProperty table
	 */
	public List getAdvancedreferencestableOptionalPropertyTable();

	/**
	 * Init the advancedreferencestableOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedreferencestableOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedreferencestableOptionalProperty
	 * @param newValue the advancedreferencestableOptionalProperty to update
	 */
	public void updateAdvancedreferencestableOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedreferencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedreferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedreferencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedreferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedreferencestableOptionalProperty table
	 */
	public boolean isContainedInAdvancedreferencestableOptionalPropertyTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
