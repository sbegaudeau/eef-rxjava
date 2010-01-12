/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 */
public interface ReferencesTablePropertiesEditionPart {

	/**
	 * @return the referencestable to add
	 */
	public List getReferencestableToAdd();

	/**
	 * @return the referencestable to remove
	 */
	public List getReferencestableToRemove();

	/**
	 * @return the current referencestable table
	 */
	public List getReferencestableTable();

	/**
	 * Init the referencestable
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReferencestable(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the referencestable
	 * @param newValue the referencestable to update
	 */
	public void updateReferencestable(EObject newValue);

	/**
	 * Adds the given filter to the referencestable edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToReferencestable(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencestable edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToReferencestable(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencestable table
	 */
	public boolean isContainedInReferencestableTable(EObject element);






	/**
	 * @return the referencestableRO to add
	 */
	public List getReferencestableROToAdd();

	/**
	 * @return the referencestableRO to remove
	 */
	public List getReferencestableROToRemove();

	/**
	 * @return the current referencestableRO table
	 */
	public List getReferencestableROTable();

	/**
	 * Init the referencestableRO
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initReferencestableRO(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the referencestableRO
	 * @param newValue the referencestableRO to update
	 */
	public void updateReferencestableRO(EObject newValue);

	/**
	 * Adds the given filter to the referencestableRO edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToReferencestableRO(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencestableRO edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToReferencestableRO(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencestableRO table
	 */
	public boolean isContainedInReferencestableROTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
