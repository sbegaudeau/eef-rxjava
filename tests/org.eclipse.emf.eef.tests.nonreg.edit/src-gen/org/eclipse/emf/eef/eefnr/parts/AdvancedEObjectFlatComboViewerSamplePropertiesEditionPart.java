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
public interface AdvancedEObjectFlatComboViewerSamplePropertiesEditionPart {

	/**
	 * @return the advancedeobjectflatcomboviewerRequiredProperty
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerRequiredProperty();

	/**
	 * Init the advancedeobjectflatcomboviewerRequiredProperty
	 * @param settings the combo setting
	 */
	public void initAdvancedeobjectflatcomboviewerRequiredProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new advancedeobjectflatcomboviewerRequiredProperty
	 * @param newValue the new advancedeobjectflatcomboviewerRequiredProperty to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerRequiredProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerRequiredPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerRequiredProperty(ViewerFilter filter);


	/**
	 * @return the advancedeobjectflatcomboviewerOptionalProperty
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerOptionalProperty();

	/**
	 * Init the advancedeobjectflatcomboviewerOptionalProperty
	 * @param settings the combo setting
	 */
	public void initAdvancedeobjectflatcomboviewerOptionalProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new advancedeobjectflatcomboviewerOptionalProperty
	 * @param newValue the new advancedeobjectflatcomboviewerOptionalProperty to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerOptionalProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerOptionalPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerOptionalProperty(ViewerFilter filter);


	/**
	 * @return the advancedeobjectflatcomboviewerROProperty
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerROProperty();

	/**
	 * Init the advancedeobjectflatcomboviewerROProperty
	 * @param settings the combo setting
	 */
	public void initAdvancedeobjectflatcomboviewerROProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new advancedeobjectflatcomboviewerROProperty
	 * @param newValue the new advancedeobjectflatcomboviewerROProperty to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerROProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerROPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerROProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerROProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerROProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerROProperty(ViewerFilter filter);


	/**
	 * @return the advancedeobjectflatcomboviewerCompoRequiredProperty
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerCompoRequiredProperty();

	/**
	 * Init the advancedeobjectflatcomboviewerCompoRequiredProperty
	 * @param settings the combo setting
	 */
	public void initAdvancedeobjectflatcomboviewerCompoRequiredProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new advancedeobjectflatcomboviewerCompoRequiredProperty
	 * @param newValue the new advancedeobjectflatcomboviewerCompoRequiredProperty to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerCompoRequiredProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerCompoRequiredPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerCompoRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerCompoRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerCompoRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerCompoRequiredProperty(ViewerFilter filter);


	/**
	 * @return the advancedeobjectflatcomboviewerCompoOptionalProperty
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerCompoOptionalProperty();

	/**
	 * Init the advancedeobjectflatcomboviewerCompoOptionalProperty
	 * @param settings the combo setting
	 */
	public void initAdvancedeobjectflatcomboviewerCompoOptionalProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new advancedeobjectflatcomboviewerCompoOptionalProperty
	 * @param newValue the new advancedeobjectflatcomboviewerCompoOptionalProperty to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerCompoOptionalProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerCompoOptionalPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerCompoOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerCompoOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerCompoOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerCompoOptionalProperty(ViewerFilter filter);





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
