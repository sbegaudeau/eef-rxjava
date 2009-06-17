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










	// Start of user code for additional methods
	
	// End of user code
}

