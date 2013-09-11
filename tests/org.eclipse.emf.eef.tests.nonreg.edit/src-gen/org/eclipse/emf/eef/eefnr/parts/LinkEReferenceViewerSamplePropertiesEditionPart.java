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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface LinkEReferenceViewerSamplePropertiesEditionPart {

	/**
	 * @return the linkereferenceviewerRequiredPropery
	 * 
	 */
	public EObject getLinkereferenceviewerRequiredPropery();

	/**
	 * Init the linkereferenceviewerRequiredPropery
	 * @param settings the combo setting
	 */
	public void initLinkereferenceviewerRequiredPropery(EObjectFlatComboSettings settings);

	/**
	 * Defines a new linkereferenceviewerRequiredPropery
	 * @param newValue the new linkereferenceviewerRequiredPropery to set
	 * 
	 */
	public void setLinkereferenceviewerRequiredPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLinkereferenceviewerRequiredProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the linkereferenceviewerRequiredPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLinkereferenceviewerRequiredPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the linkereferenceviewerRequiredPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLinkereferenceviewerRequiredPropery(ViewerFilter filter);


	/**
	 * @return the linkereferenceviewerOptionalPropery
	 * 
	 */
	public EObject getLinkereferenceviewerOptionalPropery();

	/**
	 * Init the linkereferenceviewerOptionalPropery
	 * @param settings the combo setting
	 */
	public void initLinkereferenceviewerOptionalPropery(EObjectFlatComboSettings settings);

	/**
	 * Defines a new linkereferenceviewerOptionalPropery
	 * @param newValue the new linkereferenceviewerOptionalPropery to set
	 * 
	 */
	public void setLinkereferenceviewerOptionalPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLinkereferenceviewerOptionalProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the linkereferenceviewerOptionalPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLinkereferenceviewerOptionalPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the linkereferenceviewerOptionalPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLinkereferenceviewerOptionalPropery(ViewerFilter filter);


	/**
	 * @return the linkereferenceviewerROPropery
	 * 
	 */
	public EObject getLinkereferenceviewerROPropery();

	/**
	 * Init the linkereferenceviewerROPropery
	 * @param settings the combo setting
	 */
	public void initLinkereferenceviewerROPropery(EObjectFlatComboSettings settings);

	/**
	 * Defines a new linkereferenceviewerROPropery
	 * @param newValue the new linkereferenceviewerROPropery to set
	 * 
	 */
	public void setLinkereferenceviewerROPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLinkereferenceviewerROProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the linkereferenceviewerROPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLinkereferenceviewerROPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the linkereferenceviewerROPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLinkereferenceviewerROPropery(ViewerFilter filter);





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
