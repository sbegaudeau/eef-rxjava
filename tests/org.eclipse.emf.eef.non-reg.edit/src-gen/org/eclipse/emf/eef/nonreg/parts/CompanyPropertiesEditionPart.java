/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 */
public interface CompanyPropertiesEditionPart {

	/**
	 * @return the Adress
	 */
	public EObject getAdress();

	/**
	 * Init the Adress
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initAdress(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Adress
	 * @param newValue the new Adress to set
	 */
	public void setAdress(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setAdressButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Adress edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAdress(ViewerFilter filter);

	/**
	 * Adds the given filter to the Adress edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAdress(ViewerFilter filter);







	/**
	 * @return the NamedElement referenced view
	 */
	public IPropertiesEditionPart getNamedElementReferencedView();
	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 */
	public void setName(String newValue);

	public void setMessageForName(String msg, int msgLevel);

	public void unsetMessageForName();

	/**
	 * @return the documentation
	 */
	public String getDocumentation();

	/**
	 * Defines a new documentation
	 * @param newValue the new documentation to set
	 */
	public void setDocumentation(String newValue);

	public void setMessageForDocumentation(String msg, int msgLevel);

	public void unsetMessageForDocumentation();






	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
