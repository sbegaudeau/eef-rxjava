/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code
/**
 * 
 */
public interface TalkPropertiesEditionPart {

	/**
	 * @return the title
	 */
	public String getTitle();

	/**
	 * Defines a new title
	 * @param newValue the new title to set
	 */
	public void setTitle(String newValue);

	public void setMessageForTitle(String msg, int msgLevel);

	public void unsetMessageForTitle();

	/**
	 * @return the type
	 */
	public Enumerator getType();

	/**
	 * Init the type
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initType(EEnum eenum, Enumerator current);

	/**
	 * Defines a new type
	 * @param newValue the new type to set
	 */
	public void setType(Enumerator newValue);





	/**
	 * @return the presenter
	 */
	public EObject getPresenter();

	/**
	 * Init the presenter
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initPresenter(ResourceSet allResources, EObject current);

	/**
	 * Defines a new presenter
	 * @param newValue the new presenter to set
	 */
	public void setPresenter(EObject newValue);

	/**
	 * Adds the given filter to the presenter edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPresenter(ViewerFilter filter);

	/**
	 * Adds the given filter to the presenter edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPresenter(ViewerFilter filter);





	/**
	 * @return the creator
	 */
	public Object getCreator();

	/**
	 * Init the creator
	 * @param eClass the eClass to manage
	 * @param current the current value
	 */
	public void initCreator(ResourceSet allResources, EObject current);

	/**
	 * Defines a new creator
	 * @param newValue the new creator to set
	 */
	public void setCreator(Object newValue);

	/**
	 * Adds the given filter to the creator edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToCreator(ViewerFilter filter);








	/**
	 * @return the DocumentedElement referenced view
	 */
	public IPropertiesEditionPart getDocumentedElementReferencedView();
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



	// Start of user code for additional methods
	
	// End of user code
}

