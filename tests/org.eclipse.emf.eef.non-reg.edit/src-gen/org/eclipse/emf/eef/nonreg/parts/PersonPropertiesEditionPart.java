/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import java.util.List;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;


// End of user code
/**
 * 
 */
public interface PersonPropertiesEditionPart {

	/**
	 * @return the firstname
	 */
	public String getFirstname();

	/**
	 * Defines a new firstname
	 * @param newValue the new firstname to set
	 */
	public void setFirstname(String newValue);

	public void setMessageForFirstname(String msg, int msgLevel);

	public void unsetMessageForFirstname();

	/**
	 * @return the lastname
	 */
	public String getLastname();

	/**
	 * Defines a new lastname
	 * @param newValue the new lastname to set
	 */
	public void setLastname(String newValue);

	public void setMessageForLastname(String msg, int msgLevel);

	public void unsetMessageForLastname();

	/**
	 * @return the age
	 */
	public String getAge();

	/**
	 * Defines a new age
	 * @param newValue the new age to set
	 */
	public void setAge(String newValue);

	public void setMessageForAge(String msg, int msgLevel);

	public void unsetMessageForAge();

	/**
	 * @return the eclipseCommiter
	 */
	public Boolean getEclipseCommiter();

	/**
	 * Defines a new eclipseCommiter
	 * @param newValue the new eclipseCommiter to set
	 */
	public void setEclipseCommiter(Boolean newValue);





	/**
	 * @return the isRegistered
	 */
	public Boolean getIsRegistered();

	/**
	 * Defines a new isRegistered
	 * @param newValue the new isRegistered to set
	 */
	public void setIsRegistered(Boolean newValue);





	/**
	 * @return the gender
	 */
	public Object getGender();

	/**
	 * Init the gender
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initGender(EEnum eenum, Enumerator current);

	/**
	 * Defines a new gender
	 * @param newValue the new gender to set
	 */
	public void setGender(Object newValue);





	/**
	 * @return the workFor
	 */
	public EObject getWorkFor();

	/**
	 * Init the workFor
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initWorkFor(ResourceSet allResources, EObject current);

	/**
	 * Defines a new workFor
	 * @param newValue the new workFor to set
	 */
	public void setWorkFor(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setWorkForButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the workFor edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToWorkFor(ViewerFilter filter);

	/**
	 * Adds the given filter to the workFor edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToWorkFor(ViewerFilter filter);








	/**
	 * @return the Accreditations referenced view
	 */
	public IPropertiesEditionPart getAccreditationsReferencedView();
	/**
	 * @return the accreditations to add
	 */
	public List getAccreditationsToAdd();

	/**
	 * @return the accreditations to remove
	 */
	public List getAccreditationsToRemove();

	/**
	 * @return the current accreditations table
	 */
	public List getAccreditationsTable();

	/**
	 * Init the accreditations
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAccreditations(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the accreditations
	 * @param newValue the accreditations to update
	 */
	public void updateAccreditations(EObject newValue);

	/**
	 * Adds the given filter to the accreditations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAccreditations(ViewerFilter filter);

	/**
	 * Adds the given filter to the accreditations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAccreditations(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the accreditations table
	 */
	public boolean isContainedInAccreditationsTable(EObject element);







	// Start of user code for additional methods
	
	// End of user code
}

