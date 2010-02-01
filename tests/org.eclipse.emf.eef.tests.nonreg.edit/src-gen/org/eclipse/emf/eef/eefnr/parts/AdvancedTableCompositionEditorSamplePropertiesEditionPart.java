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
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface AdvancedTableCompositionEditorSamplePropertiesEditionPart {

	/**
	 * @return the advancedtablecompositionRequiredProperty to add
	 */
	public List getAdvancedtablecompositionRequiredPropertyToAdd();

	/**
	 * @return the advancedtablecompositionRequiredProperty to remove
	 */
	public List getAdvancedtablecompositionRequiredPropertyToRemove();

	/**
	 * @return the advancedtablecompositionRequiredProperty to move
	 */
	public List getAdvancedtablecompositionRequiredPropertyToMove();

	/**
	 * @return the advancedtablecompositionRequiredProperty to edit
	 */
	public Map getAdvancedtablecompositionRequiredPropertyToEdit();

	/**
	 * @return the current advancedtablecompositionRequiredProperty table
	 */
	public List getAdvancedtablecompositionRequiredPropertyTable();

	/**
	 * Init the advancedtablecompositionRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionRequiredProperty
	 * @param newValue the advancedtablecompositionRequiredProperty to update
	 */
	public void updateAdvancedtablecompositionRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedtablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedtablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionRequiredProperty table
	 */
	public boolean isContainedInAdvancedtablecompositionRequiredPropertyTable(EObject element);






	/**
	 * @return the advancedtablecompositionOptionalProperty to add
	 */
	public List getAdvancedtablecompositionOptionalPropertyToAdd();

	/**
	 * @return the advancedtablecompositionOptionalProperty to remove
	 */
	public List getAdvancedtablecompositionOptionalPropertyToRemove();

	/**
	 * @return the advancedtablecompositionOptionalProperty to move
	 */
	public List getAdvancedtablecompositionOptionalPropertyToMove();

	/**
	 * @return the advancedtablecompositionOptionalProperty to edit
	 */
	public Map getAdvancedtablecompositionOptionalPropertyToEdit();

	/**
	 * @return the current advancedtablecompositionOptionalProperty table
	 */
	public List getAdvancedtablecompositionOptionalPropertyTable();

	/**
	 * Init the advancedtablecompositionOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionOptionalProperty
	 * @param newValue the advancedtablecompositionOptionalProperty to update
	 */
	public void updateAdvancedtablecompositionOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedtablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedtablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionOptionalProperty table
	 */
	public boolean isContainedInAdvancedtablecompositionOptionalPropertyTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
