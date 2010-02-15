/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 */
public interface GamePlayersPropertiesEditionPart {

	/**
	 * @return the players to add
	 */
	public List getPlayersToAdd();

	/**
	 * @return the players to remove
	 */
	public List getPlayersToRemove();

	/**
	 * @return the players to move
	 */
	public List getPlayersToMove();

	/**
	 * @return the players to edit
	 */
	public Map getPlayersToEdit();

	/**
	 * @return the current players table
	 */
	public List getPlayersTable();

	/**
	 * Init the players
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPlayers(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the players
	 * @param newValue the players to update
	 */
	public void updatePlayers(EObject newValue);

	/**
	 * Adds the given filter to the players edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPlayers(ViewerFilter filter);

	/**
	 * Adds the given filter to the players edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPlayers(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the players table
	 */
	public boolean isContainedInPlayersTable(EObject element);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
