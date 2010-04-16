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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface TotalSamplePropertiesEditionPart {

	/**
	 * @return the textRequiredProperty
	 * 
	 */
	public String getTextRequiredProperty();

	/**
	 * Defines a new textRequiredProperty
	 * @param newValue the new textRequiredProperty to set
	 * 
	 */
	public void setTextRequiredProperty(String newValue);


	/**
	 * @return the textOptionalProperty
	 * 
	 */
	public String getTextOptionalProperty();

	/**
	 * Defines a new textOptionalProperty
	 * @param newValue the new textOptionalProperty to set
	 * 
	 */
	public void setTextOptionalProperty(String newValue);


	/**
	 * @return the checkboxRequiredProperty
	 * 
	 */
	public Boolean getCheckboxRequiredProperty();

	/**
	 * Defines a new checkboxRequiredProperty
	 * @param newValue the new checkboxRequiredProperty to set
	 * 
	 */
	public void setCheckboxRequiredProperty(Boolean newValue);


	/**
	 * @return the checkboxOptionalProperty
	 * 
	 */
	public Boolean getCheckboxOptionalProperty();

	/**
	 * Defines a new checkboxOptionalProperty
	 * @param newValue the new checkboxOptionalProperty to set
	 * 
	 */
	public void setCheckboxOptionalProperty(Boolean newValue);


	/**
	 * @return the textareaRequiredProperty
	 * 
	 */
	public String getTextareaRequiredProperty();

	/**
	 * Defines a new textareaRequiredProperty
	 * @param newValue the new textareaRequiredProperty to set
	 * 
	 */
	public void setTextareaRequiredProperty(String newValue);


	/**
	 * @return the textareaOptionalProperty
	 * 
	 */
	public String getTextareaOptionalProperty();

	/**
	 * Defines a new textareaOptionalProperty
	 * @param newValue the new textareaOptionalProperty to set
	 * 
	 */
	public void setTextareaOptionalProperty(String newValue);


	/**
	 * @return the radioRequiredProperty
	 * 
	 */
	public Enumerator getRadioRequiredProperty();

	/**
	 * Init the radioRequiredProperty
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initRadioRequiredProperty(EEnum eenum, Enumerator current);

	/**
	 * Defines a new radioRequiredProperty
	 * @param newValue the new radioRequiredProperty to set
	 * 
	 */
	public void setRadioRequiredProperty(Enumerator newValue);


	/**
	 * @return the radioOptionalProperty
	 * 
	 */
	public Enumerator getRadioOptionalProperty();

	/**
	 * Init the radioOptionalProperty
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initRadioOptionalProperty(EEnum eenum, Enumerator current);

	/**
	 * Defines a new radioOptionalProperty
	 * @param newValue the new radioOptionalProperty to set
	 * 
	 */
	public void setRadioOptionalProperty(Enumerator newValue);


	/**
	 * @return the eobjectflatcomboviewerRequiredProperty
	 * 
	 */
	public EObject getEobjectflatcomboviewerRequiredProperty();

	/**
	 * Init the eobjectflatcomboviewerRequiredProperty
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initEobjectflatcomboviewerRequiredProperty(ResourceSet allResources, EObject current);

	/**
	 * Defines a new eobjectflatcomboviewerRequiredProperty
	 * @param newValue the new eobjectflatcomboviewerRequiredProperty to set
	 * 
	 */
	public void setEobjectflatcomboviewerRequiredProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEobjectflatcomboviewerRequiredPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eobjectflatcomboviewerRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEobjectflatcomboviewerRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the eobjectflatcomboviewerRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEobjectflatcomboviewerRequiredProperty(ViewerFilter filter);


	/**
	 * @return the eobjectflatcomboviewerOptionalProperty
	 * 
	 */
	public EObject getEobjectflatcomboviewerOptionalProperty();

	/**
	 * Init the eobjectflatcomboviewerOptionalProperty
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initEobjectflatcomboviewerOptionalProperty(ResourceSet allResources, EObject current);

	/**
	 * Defines a new eobjectflatcomboviewerOptionalProperty
	 * @param newValue the new eobjectflatcomboviewerOptionalProperty to set
	 * 
	 */
	public void setEobjectflatcomboviewerOptionalProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEobjectflatcomboviewerOptionalPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eobjectflatcomboviewerOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEobjectflatcomboviewerOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the eobjectflatcomboviewerOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEobjectflatcomboviewerOptionalProperty(ViewerFilter filter);


	/**
	 * @return the referencestableRequiredProperty to add
	 * 
	 */
	public List getReferencestableRequiredPropertyToAdd();

	/**
	 * @return the referencestableRequiredProperty to remove
	 * 
	 */
	public List getReferencestableRequiredPropertyToRemove();

	/**
	 * @return the current referencestableRequiredProperty table
	 * 
	 */
	public List getReferencestableRequiredPropertyTable();

	/**
	 * Init the referencestableRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReferencestableRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the referencestableRequiredProperty
	 * @param newValue the referencestableRequiredProperty to update
	 * 
	 */
	public void updateReferencestableRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the referencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencestableRequiredProperty table
	 * 
	 */
	public boolean isContainedInReferencestableRequiredPropertyTable(EObject element);


	/**
	 * @return the referencestableOptionalProperty to add
	 * 
	 */
	public List getReferencestableOptionalPropertyToAdd();

	/**
	 * @return the referencestableOptionalProperty to remove
	 * 
	 */
	public List getReferencestableOptionalPropertyToRemove();

	/**
	 * @return the current referencestableOptionalProperty table
	 * 
	 */
	public List getReferencestableOptionalPropertyTable();

	/**
	 * Init the referencestableOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReferencestableOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the referencestableOptionalProperty
	 * @param newValue the referencestableOptionalProperty to update
	 * 
	 */
	public void updateReferencestableOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the referencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencestableOptionalProperty table
	 * 
	 */
	public boolean isContainedInReferencestableOptionalPropertyTable(EObject element);


	/**
	 * @return the emfcomboviewerRequiredProperty
	 * 
	 */
	public Enumerator getEmfcomboviewerRequiredProperty();

	/**
	 * Init the emfcomboviewerRequiredProperty
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initEmfcomboviewerRequiredProperty(EEnum eenum, Enumerator current);

	/**
	 * Defines a new emfcomboviewerRequiredProperty
	 * @param newValue the new emfcomboviewerRequiredProperty to set
	 * 
	 */
	public void setEmfcomboviewerRequiredProperty(Enumerator newValue);


	/**
	 * @return the emfcomboviewerOptionalProperty
	 * 
	 */
	public Enumerator getEmfcomboviewerOptionalProperty();

	/**
	 * Init the emfcomboviewerOptionalProperty
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initEmfcomboviewerOptionalProperty(EEnum eenum, Enumerator current);

	/**
	 * Defines a new emfcomboviewerOptionalProperty
	 * @param newValue the new emfcomboviewerOptionalProperty to set
	 * 
	 */
	public void setEmfcomboviewerOptionalProperty(Enumerator newValue);


	/**
	 * @return the multivaluededitorRequiredProperty
	 * 
	 */
	public EList getMultivaluededitorRequiredProperty();

	/**
	 * Defines a new multivaluededitorRequiredProperty
	 * @param newValue the new multivaluededitorRequiredProperty to set
	 * 
	 */
	public void setMultivaluededitorRequiredProperty(EList newValue);


	/**
	 * @return the multivaluededitorOptionalProperty
	 * 
	 */
	public EList getMultivaluededitorOptionalProperty();

	/**
	 * Defines a new multivaluededitorOptionalProperty
	 * @param newValue the new multivaluededitorOptionalProperty to set
	 * 
	 */
	public void setMultivaluededitorOptionalProperty(EList newValue);


	/**
	 * @return the tablecompositionRequiredProperty to add
	 * 
	 */
	public List getTablecompositionRequiredPropertyToAdd();

	/**
	 * @return the tablecompositionRequiredProperty to remove
	 * 
	 */
	public List getTablecompositionRequiredPropertyToRemove();

	/**
	 * @return the tablecompositionRequiredProperty to move
	 * 
	 */
	public List getTablecompositionRequiredPropertyToMove();

	/**
	 * @return the tablecompositionRequiredProperty to edit
	 * 
	 */
	public Map getTablecompositionRequiredPropertyToEdit();

	/**
	 * @return the current tablecompositionRequiredProperty table
	 * 
	 */
	public List getTablecompositionRequiredPropertyTable();

	/**
	 * Init the tablecompositionRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTablecompositionRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the tablecompositionRequiredProperty
	 * @param newValue the tablecompositionRequiredProperty to update
	 * 
	 */
	public void updateTablecompositionRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the tablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the tablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tablecompositionRequiredProperty table
	 * 
	 */
	public boolean isContainedInTablecompositionRequiredPropertyTable(EObject element);


	/**
	 * @return the tablecompositionOptionalProperty to add
	 * 
	 */
	public List getTablecompositionOptionalPropertyToAdd();

	/**
	 * @return the tablecompositionOptionalProperty to remove
	 * 
	 */
	public List getTablecompositionOptionalPropertyToRemove();

	/**
	 * @return the tablecompositionOptionalProperty to move
	 * 
	 */
	public List getTablecompositionOptionalPropertyToMove();

	/**
	 * @return the tablecompositionOptionalProperty to edit
	 * 
	 */
	public Map getTablecompositionOptionalPropertyToEdit();

	/**
	 * @return the current tablecompositionOptionalProperty table
	 * 
	 */
	public List getTablecompositionOptionalPropertyTable();

	/**
	 * Init the tablecompositionOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTablecompositionOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the tablecompositionOptionalProperty
	 * @param newValue the tablecompositionOptionalProperty to update
	 * 
	 */
	public void updateTablecompositionOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the tablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the tablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tablecompositionOptionalProperty table
	 * 
	 */
	public boolean isContainedInTablecompositionOptionalPropertyTable(EObject element);


	/**
	 * @return the advancedreferencestableRequiredProperty to add
	 * 
	 */
	public List getAdvancedreferencestableRequiredPropertyToAdd();

	/**
	 * @return the advancedreferencestableRequiredProperty to remove
	 * 
	 */
	public List getAdvancedreferencestableRequiredPropertyToRemove();

	/**
	 * @return the current advancedreferencestableRequiredProperty table
	 * 
	 */
	public List getAdvancedreferencestableRequiredPropertyTable();

	/**
	 * Init the advancedreferencestableRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedreferencestableRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedreferencestableRequiredProperty
	 * @param newValue the advancedreferencestableRequiredProperty to update
	 * 
	 */
	public void updateAdvancedreferencestableRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedreferencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedreferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedreferencestableRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedreferencestableRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedreferencestableRequiredProperty table
	 * 
	 */
	public boolean isContainedInAdvancedreferencestableRequiredPropertyTable(EObject element);


	/**
	 * @return the advancedreferencestableOptionalProperty to add
	 * 
	 */
	public List getAdvancedreferencestableOptionalPropertyToAdd();

	/**
	 * @return the advancedreferencestableOptionalProperty to remove
	 * 
	 */
	public List getAdvancedreferencestableOptionalPropertyToRemove();

	/**
	 * @return the current advancedreferencestableOptionalProperty table
	 * 
	 */
	public List getAdvancedreferencestableOptionalPropertyTable();

	/**
	 * Init the advancedreferencestableOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedreferencestableOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedreferencestableOptionalProperty
	 * @param newValue the advancedreferencestableOptionalProperty to update
	 * 
	 */
	public void updateAdvancedreferencestableOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedreferencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedreferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedreferencestableOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedreferencestableOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedreferencestableOptionalProperty table
	 * 
	 */
	public boolean isContainedInAdvancedreferencestableOptionalPropertyTable(EObject element);


	/**
	 * @return the advancedeobjectflatcomboviewerRequiredPropery
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerRequiredPropery();

	/**
	 * Init the advancedeobjectflatcomboviewerRequiredPropery
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initAdvancedeobjectflatcomboviewerRequiredPropery(ResourceSet allResources, EObject current);

	/**
	 * Defines a new advancedeobjectflatcomboviewerRequiredPropery
	 * @param newValue the new advancedeobjectflatcomboviewerRequiredPropery to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerRequiredPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerRequiredPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerRequiredPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerRequiredPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerRequiredPropery(ViewerFilter filter);


	/**
	 * @return the advancedeobjectflatcomboviewerOptionalPropery
	 * 
	 */
	public EObject getAdvancedeobjectflatcomboviewerOptionalPropery();

	/**
	 * Init the advancedeobjectflatcomboviewerOptionalPropery
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initAdvancedeobjectflatcomboviewerOptionalPropery(ResourceSet allResources, EObject current);

	/**
	 * Defines a new advancedeobjectflatcomboviewerOptionalPropery
	 * @param newValue the new advancedeobjectflatcomboviewerOptionalPropery to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerOptionalPropery(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setAdvancedeobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerOptionalPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerOptionalPropery(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedeobjectflatcomboviewerOptionalPropery edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerOptionalPropery(ViewerFilter filter);


	/**
	 * @return the advancedtablecompositionRequiredProperty to add
	 * 
	 */
	public List getAdvancedtablecompositionRequiredPropertyToAdd();

	/**
	 * @return the advancedtablecompositionRequiredProperty to remove
	 * 
	 */
	public List getAdvancedtablecompositionRequiredPropertyToRemove();

	/**
	 * @return the advancedtablecompositionRequiredProperty to move
	 * 
	 */
	public List getAdvancedtablecompositionRequiredPropertyToMove();

	/**
	 * @return the advancedtablecompositionRequiredProperty to edit
	 * 
	 */
	public Map getAdvancedtablecompositionRequiredPropertyToEdit();

	/**
	 * @return the current advancedtablecompositionRequiredProperty table
	 * 
	 */
	public List getAdvancedtablecompositionRequiredPropertyTable();

	/**
	 * Init the advancedtablecompositionRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionRequiredProperty
	 * @param newValue the advancedtablecompositionRequiredProperty to update
	 * 
	 */
	public void updateAdvancedtablecompositionRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedtablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedtablecompositionRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionRequiredProperty table
	 * 
	 */
	public boolean isContainedInAdvancedtablecompositionRequiredPropertyTable(EObject element);


	/**
	 * @return the advancedtablecompositionOptionalProperty to add
	 * 
	 */
	public List getAdvancedtablecompositionOptionalPropertyToAdd();

	/**
	 * @return the advancedtablecompositionOptionalProperty to remove
	 * 
	 */
	public List getAdvancedtablecompositionOptionalPropertyToRemove();

	/**
	 * @return the advancedtablecompositionOptionalProperty to move
	 * 
	 */
	public List getAdvancedtablecompositionOptionalPropertyToMove();

	/**
	 * @return the advancedtablecompositionOptionalProperty to edit
	 * 
	 */
	public Map getAdvancedtablecompositionOptionalPropertyToEdit();

	/**
	 * @return the current advancedtablecompositionOptionalProperty table
	 * 
	 */
	public List getAdvancedtablecompositionOptionalPropertyTable();

	/**
	 * Init the advancedtablecompositionOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionOptionalProperty
	 * @param newValue the advancedtablecompositionOptionalProperty to update
	 * 
	 */
	public void updateAdvancedtablecompositionOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedtablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedtablecompositionOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionOptionalProperty table
	 * 
	 */
	public boolean isContainedInAdvancedtablecompositionOptionalPropertyTable(EObject element);


	/**
	 * @return the tablecompositionWithSameTypeRequiredProperty to add
	 * 
	 */
	public List getTablecompositionWithSameTypeRequiredPropertyToAdd();

	/**
	 * @return the tablecompositionWithSameTypeRequiredProperty to remove
	 * 
	 */
	public List getTablecompositionWithSameTypeRequiredPropertyToRemove();

	/**
	 * @return the tablecompositionWithSameTypeRequiredProperty to move
	 * 
	 */
	public List getTablecompositionWithSameTypeRequiredPropertyToMove();

	/**
	 * @return the tablecompositionWithSameTypeRequiredProperty to edit
	 * 
	 */
	public Map getTablecompositionWithSameTypeRequiredPropertyToEdit();

	/**
	 * @return the current tablecompositionWithSameTypeRequiredProperty table
	 * 
	 */
	public List getTablecompositionWithSameTypeRequiredPropertyTable();

	/**
	 * Init the tablecompositionWithSameTypeRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTablecompositionWithSameTypeRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the tablecompositionWithSameTypeRequiredProperty
	 * @param newValue the tablecompositionWithSameTypeRequiredProperty to update
	 * 
	 */
	public void updateTablecompositionWithSameTypeRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the tablecompositionWithSameTypeRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTablecompositionWithSameTypeRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the tablecompositionWithSameTypeRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTablecompositionWithSameTypeRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tablecompositionWithSameTypeRequiredProperty table
	 * 
	 */
	public boolean isContainedInTablecompositionWithSameTypeRequiredPropertyTable(EObject element);


	/**
	 * @return the tablecompositionWithSameTypeOptionalProperty to add
	 * 
	 */
	public List getTablecompositionWithSameTypeOptionalPropertyToAdd();

	/**
	 * @return the tablecompositionWithSameTypeOptionalProperty to remove
	 * 
	 */
	public List getTablecompositionWithSameTypeOptionalPropertyToRemove();

	/**
	 * @return the tablecompositionWithSameTypeOptionalProperty to move
	 * 
	 */
	public List getTablecompositionWithSameTypeOptionalPropertyToMove();

	/**
	 * @return the tablecompositionWithSameTypeOptionalProperty to edit
	 * 
	 */
	public Map getTablecompositionWithSameTypeOptionalPropertyToEdit();

	/**
	 * @return the current tablecompositionWithSameTypeOptionalProperty table
	 * 
	 */
	public List getTablecompositionWithSameTypeOptionalPropertyTable();

	/**
	 * Init the tablecompositionWithSameTypeOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTablecompositionWithSameTypeOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the tablecompositionWithSameTypeOptionalProperty
	 * @param newValue the tablecompositionWithSameTypeOptionalProperty to update
	 * 
	 */
	public void updateTablecompositionWithSameTypeOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the tablecompositionWithSameTypeOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTablecompositionWithSameTypeOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the tablecompositionWithSameTypeOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTablecompositionWithSameTypeOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tablecompositionWithSameTypeOptionalProperty table
	 * 
	 */
	public boolean isContainedInTablecompositionWithSameTypeOptionalPropertyTable(EObject element);


	/**
	 * @return the advancedtablecompositionWithSameTypeRequiredProperty to add
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeRequiredPropertyToAdd();

	/**
	 * @return the advancedtablecompositionWithSameTypeRequiredProperty to remove
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeRequiredPropertyToRemove();

	/**
	 * @return the advancedtablecompositionWithSameTypeRequiredProperty to move
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeRequiredPropertyToMove();

	/**
	 * @return the advancedtablecompositionWithSameTypeRequiredProperty to edit
	 * 
	 */
	public Map getAdvancedtablecompositionWithSameTypeRequiredPropertyToEdit();

	/**
	 * @return the current advancedtablecompositionWithSameTypeRequiredProperty table
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeRequiredPropertyTable();

	/**
	 * Init the advancedtablecompositionWithSameTypeRequiredProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionWithSameTypeRequiredProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionWithSameTypeRequiredProperty
	 * @param newValue the advancedtablecompositionWithSameTypeRequiredProperty to update
	 * 
	 */
	public void updateAdvancedtablecompositionWithSameTypeRequiredProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionWithSameTypeRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedtablecompositionWithSameTypeRequiredProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionWithSameTypeRequiredProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedtablecompositionWithSameTypeRequiredProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionWithSameTypeRequiredProperty table
	 * 
	 */
	public boolean isContainedInAdvancedtablecompositionWithSameTypeRequiredPropertyTable(EObject element);


	/**
	 * @return the advancedtablecompositionWithSameTypeOptionalProperty to add
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeOptionalPropertyToAdd();

	/**
	 * @return the advancedtablecompositionWithSameTypeOptionalProperty to remove
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeOptionalPropertyToRemove();

	/**
	 * @return the advancedtablecompositionWithSameTypeOptionalProperty to move
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeOptionalPropertyToMove();

	/**
	 * @return the advancedtablecompositionWithSameTypeOptionalProperty to edit
	 * 
	 */
	public Map getAdvancedtablecompositionWithSameTypeOptionalPropertyToEdit();

	/**
	 * @return the current advancedtablecompositionWithSameTypeOptionalProperty table
	 * 
	 */
	public List getAdvancedtablecompositionWithSameTypeOptionalPropertyTable();

	/**
	 * Init the advancedtablecompositionWithSameTypeOptionalProperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionWithSameTypeOptionalProperty(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionWithSameTypeOptionalProperty
	 * @param newValue the advancedtablecompositionWithSameTypeOptionalProperty to update
	 * 
	 */
	public void updateAdvancedtablecompositionWithSameTypeOptionalProperty(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionWithSameTypeOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAdvancedtablecompositionWithSameTypeOptionalProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionWithSameTypeOptionalProperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAdvancedtablecompositionWithSameTypeOptionalProperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionWithSameTypeOptionalProperty table
	 * 
	 */
	public boolean isContainedInAdvancedtablecompositionWithSameTypeOptionalPropertyTable(EObject element);


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
