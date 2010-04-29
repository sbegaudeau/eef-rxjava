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
package org.eclipse.emf.samples.conference.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public interface ConferencePropertiesEditionPart {

	/**
	 * @return the place
	 * 
	 */
	public String getPlace();

	/**
	 * Defines a new place
	 * @param newValue the new place to set
	 * 
	 */
	public void setPlace(String newValue);


	/**
	 * @return the sites to add
	 * 
	 */
	public List getSitesToAdd();

	/**
	 * @return the sites to remove
	 * 
	 */
	public List getSitesToRemove();

	/**
	 * @return the sites to move
	 * 
	 */
	public List getSitesToMove();

	/**
	 * @return the sites to edit
	 * 
	 */
	public Map getSitesToEdit();

	/**
	 * @return the current sites table
	 * 
	 */
	public List getSitesTable();

	/**
	 * Init the sites
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSites(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the sites
	 * @param newValue the sites to update
	 * 
	 */
	public void updateSites(EObject newValue);

	/**
	 * Adds the given filter to the sites edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSites(ViewerFilter filter);

	/**
	 * Adds the given filter to the sites edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSites(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the sites table
	 * 
	 */
	public boolean isContainedInSitesTable(EObject element);





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
