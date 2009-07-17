/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import java.util.List;
import org.eclipse.emf.ecore.EReference;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;


// End of user code

/**
 * 
 */
public interface AdvancedTableCompositionPropertiesEditionPart {

	/**
	 * @return the advancedtablecomposition to add
	 */
	public List getAdvancedtablecompositionToAdd();

	/**
	 * @return the advancedtablecomposition to remove
	 */
	public List getAdvancedtablecompositionToRemove();

	/**
	 * @return the advancedtablecomposition to move
	 */
	public List getAdvancedtablecompositionToMove();

	/**
	 * @return the advancedtablecomposition to edit
	 */
	public Map getAdvancedtablecompositionToEdit();

	/**
	 * @return the current advancedtablecomposition table
	 */
	public List getAdvancedtablecompositionTable();

	/**
	 * Init the advancedtablecomposition
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecomposition(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecomposition
	 * @param newValue the advancedtablecomposition to update
	 */
	public void updateAdvancedtablecomposition(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecomposition edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedtablecomposition(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecomposition edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedtablecomposition(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecomposition table
	 */
	public boolean isContainedInAdvancedtablecompositionTable(EObject element);





	/**
	 * @return the advancedtablecompositionRO to add
	 */
	public List getAdvancedtablecompositionROToAdd();

	/**
	 * @return the advancedtablecompositionRO to remove
	 */
	public List getAdvancedtablecompositionROToRemove();

	/**
	 * @return the advancedtablecompositionRO to move
	 */
	public List getAdvancedtablecompositionROToMove();

	/**
	 * @return the advancedtablecompositionRO to edit
	 */
	public Map getAdvancedtablecompositionROToEdit();

	/**
	 * @return the current advancedtablecompositionRO table
	 */
	public List getAdvancedtablecompositionROTable();

	/**
	 * Init the advancedtablecompositionRO
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedtablecompositionRO(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the advancedtablecompositionRO
	 * @param newValue the advancedtablecompositionRO to update
	 */
	public void updateAdvancedtablecompositionRO(EObject newValue);

	/**
	 * Adds the given filter to the advancedtablecompositionRO edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedtablecompositionRO(ViewerFilter filter);

	/**
	 * Adds the given filter to the advancedtablecompositionRO edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedtablecompositionRO(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the advancedtablecompositionRO table
	 */
	public boolean isContainedInAdvancedtablecompositionROTable(EObject element);










	// Start of user code for additional methods
	
	// End of user code

}

