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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public interface PresencePropertiesEditionPart {

	/**
	 * @return the assists to add
	 */
	public List getAssistsToAdd();

	/**
	 * @return the assists to remove
	 */
	public List getAssistsToRemove();

	/**
	 * @return the current assists table
	 */
	public List getAssistsTable();

	/**
	 * Init the assists
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAssists(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the assists
	 * @param newValue the assists to update
	 */
	public void updateAssists(EObject newValue);

	/**
	 * Adds the given filter to the assists edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAssists(ViewerFilter filter);

	/**
	 * Adds the given filter to the assists edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAssists(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the assists table
	 */
	public boolean isContainedInAssistsTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
