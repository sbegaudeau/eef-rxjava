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
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface TableCompositionEditorSamplePropertiesEditionPart {

	/**
	 * @return the tablecompositionRequiredProperty to add
	 * 
	 */
	public List getTablecompositionRequiredPropertyToAdd();

	/**
	 * @return the tablecompositionRequiredProperty to remove
	 * 
	 */
	public List getTablecompositionRequiredPropertyToRemove();

	/**
	 * @return the tablecompositionRequiredProperty to move
	 * 
	 */
	public List getTablecompositionRequiredPropertyToMove();

	/**
	 * @return the tablecompositionRequiredProperty to edit
	 * 
	 */
	public Map getTablecompositionRequiredPropertyToEdit();

	/**
	 * @return the current tablecompositionRequiredProperty table
	 * 
	 */
	public List getTablecompositionRequiredPropertyTable();

	/**
	 * Init the tablecompositionRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTablecompositionRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the tablecompositionRequiredProperty
	 * @param newValue the tablecompositionRequiredProperty to update
	 * 
	 */
	public void updateTablecompositionRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the tablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the tablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tablecompositionRequiredProperty table
	 * 
	 */
	public boolean isContainedInTablecompositionRequiredPropertyTable(EObject element);


	/**
	 * @return the tablecompositionOptionalProperty to add
	 * 
	 */
	public List getTablecompositionOptionalPropertyToAdd();

	/**
	 * @return the tablecompositionOptionalProperty to remove
	 * 
	 */
	public List getTablecompositionOptionalPropertyToRemove();

	/**
	 * @return the tablecompositionOptionalProperty to move
	 * 
	 */
	public List getTablecompositionOptionalPropertyToMove();

	/**
	 * @return the tablecompositionOptionalProperty to edit
	 * 
	 */
	public Map getTablecompositionOptionalPropertyToEdit();

	/**
	 * @return the current tablecompositionOptionalProperty table
	 * 
	 */
	public List getTablecompositionOptionalPropertyTable();

	/**
	 * Init the tablecompositionOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTablecompositionOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the tablecompositionOptionalProperty
	 * @param newValue the tablecompositionOptionalProperty to update
	 * 
	 */
	public void updateTablecompositionOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the tablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the tablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tablecompositionOptionalProperty table
	 * 
	 */
	public boolean isContainedInTablecompositionOptionalPropertyTable(EObject element);





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
