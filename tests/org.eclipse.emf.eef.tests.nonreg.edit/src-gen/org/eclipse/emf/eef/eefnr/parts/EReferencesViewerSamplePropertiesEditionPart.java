/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
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
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface EReferencesViewerSamplePropertiesEditionPart {



	/**
	 * Init the ereferencesviewerRequiredProperty
	 * @param settings settings for the ereferencesviewerRequiredProperty ReferencesTable 
	 */
	public void initEreferencesviewerRequiredProperty(ReferencesTableSettings settings);

	/**
	 * Update the ereferencesviewerRequiredProperty
	 * @param newValue the ereferencesviewerRequiredProperty to update
	 * 
	 */
	public void updateEreferencesviewerRequiredProperty();

	/**
	 * Adds the given filter to the ereferencesviewerRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEreferencesviewerRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the ereferencesviewerRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEreferencesviewerRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ereferencesviewerRequiredProperty table
	 * 
	 */
	public boolean isContainedInEreferencesviewerRequiredPropertyTable(EObject element);




	/**
	 * Init the ereferencesviewerOptionalProperty
	 * @param settings settings for the ereferencesviewerOptionalProperty ReferencesTable 
	 */
	public void initEreferencesviewerOptionalProperty(ReferencesTableSettings settings);

	/**
	 * Update the ereferencesviewerOptionalProperty
	 * @param newValue the ereferencesviewerOptionalProperty to update
	 * 
	 */
	public void updateEreferencesviewerOptionalProperty();

	/**
	 * Adds the given filter to the ereferencesviewerOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEreferencesviewerOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the ereferencesviewerOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEreferencesviewerOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ereferencesviewerOptionalProperty table
	 * 
	 */
	public boolean isContainedInEreferencesviewerOptionalPropertyTable(EObject element);




	/**
	 * Init the ereferencesviewerROProperty
	 * @param settings settings for the ereferencesviewerROProperty ReferencesTable 
	 */
	public void initEreferencesviewerROProperty(ReferencesTableSettings settings);

	/**
	 * Update the ereferencesviewerROProperty
	 * @param newValue the ereferencesviewerROProperty to update
	 * 
	 */
	public void updateEreferencesviewerROProperty();

	/**
	 * Adds the given filter to the ereferencesviewerROProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEreferencesviewerROProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the ereferencesviewerROProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEreferencesviewerROProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ereferencesviewerROProperty table
	 * 
	 */
	public boolean isContainedInEreferencesviewerROPropertyTable(EObject element);





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
