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
package org.eclipse.emf.eef.eefnrext.parts;

// Start of user code for imports
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface FlatReferenceExtendedEditorSamplePropertiesEditionPart {

	/**
	 * @return the flatReferenceEditorSample to add
	 * 
	 */
	public List getFlatReferenceEditorSampleToAdd();

	/**
	 * @return the flatReferenceEditorSample to remove
	 * 
	 */
	public List getFlatReferenceEditorSampleToRemove();

	/**
	 * @return the current flatReferenceEditorSample table
	 * 
	 */
	public List getFlatReferenceEditorSampleTable();

	/**
	 * Init the flatReferenceEditorSample
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initFlatReferenceEditorSample(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the flatReferenceEditorSample
	 * @param newValue the flatReferenceEditorSample to update
	 * 
	 */
	public void updateFlatReferenceEditorSample(EObject newValue);

	/**
	 * Adds the given filter to the flatReferenceEditorSample edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFlatReferenceEditorSample(ViewerFilter filter);

	/**
	 * Adds the given filter to the flatReferenceEditorSample edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFlatReferenceEditorSample(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the flatReferenceEditorSample table
	 * 
	 */
	public boolean isContainedInFlatReferenceEditorSampleTable(EObject element);


	/**
		 * @return the CheckBoxExtendedEditorSample referenced view
		 * 
		 */
		public IPropertiesEditionPart getCheckBoxExtendedEditorSampleReferencedView();
	/**
	 * @return the checkboxEditorSample
	 * 
	 */
	public Boolean getCheckboxEditorSample();

	/**
	 * Defines a new checkboxEditorSample
	 * @param newValue the new checkboxEditorSample to set
	 * 
	 */
	public void setCheckboxEditorSample(Boolean newValue);

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);






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
