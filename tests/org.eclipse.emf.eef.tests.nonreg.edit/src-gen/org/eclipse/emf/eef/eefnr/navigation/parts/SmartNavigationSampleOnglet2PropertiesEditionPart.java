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
package org.eclipse.emf.eef.eefnr.navigation.parts;

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
public interface SmartNavigationSampleOnglet2PropertiesEditionPart {

	/**
	 * @return the secondModelNavigationSingleValueOnglet2
	 * 
	 */
	public EObject getSecondModelNavigationSingleValueOnglet2();

	/**
	 * Init the secondModelNavigationSingleValueOnglet2
	 * @param settings the combo setting
	 */
	public void initSecondModelNavigationSingleValueOnglet2(EObjectFlatComboSettings settings);

	/**
	 * Defines a new secondModelNavigationSingleValueOnglet2
	 * @param newValue the new secondModelNavigationSingleValueOnglet2 to set
	 * 
	 */
	public void setSecondModelNavigationSingleValueOnglet2(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSecondModelNavigationSingleValueOnglet2ButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the secondModelNavigationSingleValueOnglet2 edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSecondModelNavigationSingleValueOnglet2(ViewerFilter filter);

	/**
	 * Adds the given filter to the secondModelNavigationSingleValueOnglet2 edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSecondModelNavigationSingleValueOnglet2(ViewerFilter filter);





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
