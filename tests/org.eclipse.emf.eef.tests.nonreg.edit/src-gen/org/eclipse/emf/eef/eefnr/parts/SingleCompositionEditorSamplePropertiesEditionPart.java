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

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface SingleCompositionEditorSamplePropertiesEditionPart {

	/**
	 * @return the singlecompositionviewerRequiredProperty
	 * 
	 */
	public EObject getSinglecompositionviewerRequiredProperty();

	/**
	 * Init the singlecompositionviewerRequiredProperty
	 * @param settings the combo setting
	 */
	public void initSinglecompositionviewerRequiredProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new singlecompositionviewerRequiredProperty
	 * @param newValue the new singlecompositionviewerRequiredProperty to set
	 * 
	 */
	public void setSinglecompositionviewerRequiredProperty(EObject newValue);


	/**
	 * @return the singlecompositionviewerOptionalProperty
	 * 
	 */
	public EObject getSinglecompositionviewerOptionalProperty();

	/**
	 * Init the singlecompositionviewerOptionalProperty
	 * @param settings the combo setting
	 */
	public void initSinglecompositionviewerOptionalProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new singlecompositionviewerOptionalProperty
	 * @param newValue the new singlecompositionviewerOptionalProperty to set
	 * 
	 */
	public void setSinglecompositionviewerOptionalProperty(EObject newValue);


	/**
	 * @return the singlecompositionviewerROProperty
	 * 
	 */
	public EObject getSinglecompositionviewerROProperty();

	/**
	 * Init the singlecompositionviewerROProperty
	 * @param settings the combo setting
	 */
	public void initSinglecompositionviewerROProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new singlecompositionviewerROProperty
	 * @param newValue the new singlecompositionviewerROProperty to set
	 * 
	 */
	public void setSinglecompositionviewerROProperty(EObject newValue);


	/**
	 * @return the singlecompositionviewerOnAbstractOptionalProperty
	 * 
	 */
	public EObject getSinglecompositionviewerOnAbstractOptionalProperty();

	/**
	 * Init the singlecompositionviewerOnAbstractOptionalProperty
	 * @param settings the combo setting
	 */
	public void initSinglecompositionviewerOnAbstractOptionalProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new singlecompositionviewerOnAbstractOptionalProperty
	 * @param newValue the new singlecompositionviewerOnAbstractOptionalProperty to set
	 * 
	 */
	public void setSinglecompositionviewerOnAbstractOptionalProperty(EObject newValue);





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
