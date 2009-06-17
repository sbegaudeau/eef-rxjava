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
 

// End of user code
/**
 * 
 */
public interface EclipseSummitPropertiesEditionPart {

	/**
	 * @return the place
	 */
	public String getPlace();

	/**
	 * Defines a new place
	 * @param newValue the new place to set
	 */
	public void setPlace(String newValue);

	public void setMessageForPlace(String msg, int msgLevel);

	public void unsetMessageForPlace();

	/**
	 * @return the sites to add
	 */
	public List getSitesToAdd();

	/**
	 * @return the sites to remove
	 */
	public List getSitesToRemove();

	/**
	 * @return the sites to move
	 */
	public List getSitesToMove();

	/**
	 * @return the sites to edit
	 */
	public Map getSitesToEdit();

	/**
	 * @return the current sites table
	 */
	public List getSitesTable();

	/**
	 * Init the sites
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSites(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the sites
	 * @param newValue the sites to update
	 */
	public void updateSites(EObject newValue);

	/**
	 * Adds the given filter to the sites edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToSites(ViewerFilter filter);

	/**
	 * Adds the given filter to the sites edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToSites(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the sites table
	 */
	public boolean isContainedInSitesTable(EObject element);










	// Start of user code for additional methods
	
	// End of user code
}

