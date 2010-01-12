/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 */
public interface SourcePropertiesEditionPart {

	/**
	 * @return the AdvancedUniqueRef
	 */
	public EObject getAdvancedUniqueRef();

	/**
	 * Init the AdvancedUniqueRef
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initAdvancedUniqueRef(ResourceSet allResources, EObject current);

	/**
	 * Defines a new AdvancedUniqueRef
	 * @param newValue the new AdvancedUniqueRef to set
	 */
	public void setAdvancedUniqueRef(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setAdvancedUniqueRefButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the AdvancedUniqueRef edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedUniqueRef(ViewerFilter filter);

	/**
	 * Adds the given filter to the AdvancedUniqueRef edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedUniqueRef(ViewerFilter filter);






	/**
	 * @return the AdvancedMultipleContainment to add
	 */
	public List getAdvancedMultipleContainmentToAdd();

	/**
	 * @return the AdvancedMultipleContainment to remove
	 */
	public List getAdvancedMultipleContainmentToRemove();

	/**
	 * @return the current AdvancedMultipleContainment table
	 */
	public List getAdvancedMultipleContainmentTable();

	/**
	 * Init the AdvancedMultipleContainment
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAdvancedMultipleContainment(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the AdvancedMultipleContainment
	 * @param newValue the AdvancedMultipleContainment to update
	 */
	public void updateAdvancedMultipleContainment(EObject newValue);

	/**
	 * Adds the given filter to the AdvancedMultipleContainment edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdvancedMultipleContainment(ViewerFilter filter);

	/**
	 * Adds the given filter to the AdvancedMultipleContainment edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdvancedMultipleContainment(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the AdvancedMultipleContainment table
	 */
	public boolean isContainedInAdvancedMultipleContainmentTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
