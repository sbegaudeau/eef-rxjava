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
public interface RootPropertiesEditionPart {

	/**
	 * @return the samples to add
	 * 
	 */
	public List getSamplesToAdd();

	/**
	 * @return the samples to remove
	 * 
	 */
	public List getSamplesToRemove();

	/**
	 * @return the samples to move
	 * 
	 */
	public List getSamplesToMove();

	/**
	 * @return the samples to edit
	 * 
	 */
	public Map getSamplesToEdit();

	/**
	 * @return the current samples table
	 * 
	 */
	public List getSamplesTable();

	/**
	 * Init the samples
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSamples(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the samples
	 * @param newValue the samples to update
	 * 
	 */
	public void updateSamples(EObject newValue);

	/**
	 * Adds the given filter to the samples edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSamples(ViewerFilter filter);

	/**
	 * Adds the given filter to the samples edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSamples(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the samples table
	 * 
	 */
	public boolean isContainedInSamplesTable(EObject element);





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
