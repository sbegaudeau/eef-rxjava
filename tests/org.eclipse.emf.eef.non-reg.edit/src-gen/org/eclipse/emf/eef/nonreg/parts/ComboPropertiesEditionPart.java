/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 */
public interface ComboPropertiesEditionPart {

	/**
	 * @return the combo
	 */
	public Object getCombo();

	/**
	 * Init the combo
	 * @param eClass the eClass to manage
	 * @param current the current value
	 */
	public void initCombo(ResourceSet allResources, EObject current);

	/**
	 * Defines a new combo
	 * @param newValue the new combo to set
	 */
	public void setCombo(Object newValue);

	/**
	 * Adds the given filter to the combo edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToCombo(ViewerFilter filter);





	/**
	 * @return the comboRO
	 */
	public Object getComboRO();

	/**
	 * Init the comboRO
	 * @param eClass the eClass to manage
	 * @param current the current value
	 */
	public void initComboRO(ResourceSet allResources, EObject current);

	/**
	 * Defines a new comboRO
	 * @param newValue the new comboRO to set
	 */
	public void setComboRO(Object newValue);

	/**
	 * Adds the given filter to the comboRO edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToComboRO(ViewerFilter filter);










	// Start of user code for additional methods
	
	// End of user code

}

