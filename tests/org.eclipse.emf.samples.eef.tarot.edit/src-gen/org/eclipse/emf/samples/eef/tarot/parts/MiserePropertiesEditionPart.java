/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 */
public interface MiserePropertiesEditionPart {

	/**
	 * @return the declarer
	 */
	public EObject getDeclarer();

	/**
	 * Init the declarer
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initDeclarer(ResourceSet allResources, EObject current);

	/**
	 * Defines a new declarer
	 * @param newValue the new declarer to set
	 */
	public void setDeclarer(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setDeclarerButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the declarer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToDeclarer(ViewerFilter filter);

	/**
	 * Adds the given filter to the declarer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToDeclarer(ViewerFilter filter);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
