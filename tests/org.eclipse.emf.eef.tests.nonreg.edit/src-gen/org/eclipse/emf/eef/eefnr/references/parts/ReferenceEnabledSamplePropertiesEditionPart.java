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
package org.eclipse.emf.eef.eefnr.references.parts;

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
public interface ReferenceEnabledSamplePropertiesEditionPart {

	/**
	 * @return the reference to add
	 * 
	 */
	public List getReferenceToAdd();

	/**
	 * @return the reference to remove
	 * 
	 */
	public List getReferenceToRemove();

	/**
	 * @return the current reference table
	 * 
	 */
	public List getReferenceTable();

	/**
	 * Init the reference
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReference(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the reference
	 * @param newValue the reference to update
	 * 
	 */
	public void updateReference(EObject newValue);

	/**
	 * Adds the given filter to the reference edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReference(ViewerFilter filter);

	/**
	 * Adds the given filter to the reference edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReference(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the reference table
	 * 
	 */
	public boolean isContainedInReferenceTable(EObject element);


	/**
		 * @return the AbstractEnabledSample referenced view
		 * 
		 */
		public IPropertiesEditionPart getAbstractEnabledSampleReferencedView();
	/**
	 * @return the enabled
	 * 
	 */
	public Boolean getEnabled();

	/**
	 * Defines a new enabled
	 * @param newValue the new enabled to set
	 * 
	 */
	public void setEnabled(Boolean newValue);

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
