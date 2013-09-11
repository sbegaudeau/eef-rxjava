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
public interface LinkEObjectFlatComboViewerSamplePropertiesEditionPart {

	/**
	 * @return the linkeobjectflatcomboviewerRequiredPropery
	 * 
	 */
	public EObject getLinkeobjectflatcomboviewerRequiredPropery();

	/**
	 * Init the linkeobjectflatcomboviewerRequiredPropery
	 * @param settings the combo setting
	 */
	public void initLinkeobjectflatcomboviewerRequiredPropery(EObjectFlatComboSettings settings);

	/**
	 * Defines a new linkeobjectflatcomboviewerRequiredPropery
	 * @param newValue the new linkeobjectflatcomboviewerRequiredPropery to set
	 * 
	 */
	public void setLinkeobjectflatcomboviewerRequiredPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLinkeobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the linkeobjectflatcomboviewerRequiredPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLinkeobjectflatcomboviewerRequiredPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the linkeobjectflatcomboviewerRequiredPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLinkeobjectflatcomboviewerRequiredPropery(ViewerFilter filter);


	/**
	 * @return the linkeobjectflatcomboviewerOptionalPropery
	 * 
	 */
	public EObject getLinkeobjectflatcomboviewerOptionalPropery();

	/**
	 * Init the linkeobjectflatcomboviewerOptionalPropery
	 * @param settings the combo setting
	 */
	public void initLinkeobjectflatcomboviewerOptionalPropery(EObjectFlatComboSettings settings);

	/**
	 * Defines a new linkeobjectflatcomboviewerOptionalPropery
	 * @param newValue the new linkeobjectflatcomboviewerOptionalPropery to set
	 * 
	 */
	public void setLinkeobjectflatcomboviewerOptionalPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLinkeobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the linkeobjectflatcomboviewerOptionalPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLinkeobjectflatcomboviewerOptionalPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the linkeobjectflatcomboviewerOptionalPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLinkeobjectflatcomboviewerOptionalPropery(ViewerFilter filter);


	/**
	 * @return the linkeobjectflatcomboviewerROPropery
	 * 
	 */
	public EObject getLinkeobjectflatcomboviewerROPropery();

	/**
	 * Init the linkeobjectflatcomboviewerROPropery
	 * @param settings the combo setting
	 */
	public void initLinkeobjectflatcomboviewerROPropery(EObjectFlatComboSettings settings);

	/**
	 * Defines a new linkeobjectflatcomboviewerROPropery
	 * @param newValue the new linkeobjectflatcomboviewerROPropery to set
	 * 
	 */
	public void setLinkeobjectflatcomboviewerROPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLinkeobjectflatcomboviewerROProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the linkeobjectflatcomboviewerROPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLinkeobjectflatcomboviewerROPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the linkeobjectflatcomboviewerROPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLinkeobjectflatcomboviewerROPropery(ViewerFilter filter);





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
