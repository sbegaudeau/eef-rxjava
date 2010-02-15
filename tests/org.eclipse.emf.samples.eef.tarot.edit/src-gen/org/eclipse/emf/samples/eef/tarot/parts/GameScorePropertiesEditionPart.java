/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 */
public interface GameScorePropertiesEditionPart {

	/**
	 * @return the entries to add
	 */
	public List getEntriesToAdd();

	/**
	 * @return the entries to remove
	 */
	public List getEntriesToRemove();

	/**
	 * @return the entries to move
	 */
	public List getEntriesToMove();

	/**
	 * @return the entries to edit
	 */
	public Map getEntriesToEdit();

	/**
	 * @return the current entries table
	 */
	public List getEntriesTable();

	/**
	 * Init the entries
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initEntries(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the entries
	 * @param newValue the entries to update
	 */
	public void updateEntries(EObject newValue);

	/**
	 * Adds the given filter to the entries edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToEntries(ViewerFilter filter);

	/**
	 * Adds the given filter to the entries edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToEntries(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the entries table
	 */
	public boolean isContainedInEntriesTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	public void updatePlayerColumns(Notification msg);
	
	// End of user code

}
