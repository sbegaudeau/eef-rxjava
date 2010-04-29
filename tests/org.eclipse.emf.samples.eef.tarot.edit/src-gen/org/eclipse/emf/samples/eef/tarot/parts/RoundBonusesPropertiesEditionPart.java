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
 * 
 */
public interface RoundBonusesPropertiesEditionPart {

	/**
	 * @return the bonuses to add
	 * 
	 */
	public List getBonusesToAdd();

	/**
	 * @return the bonuses to remove
	 * 
	 */
	public List getBonusesToRemove();

	/**
	 * @return the bonuses to move
	 * 
	 */
	public List getBonusesToMove();

	/**
	 * @return the bonuses to edit
	 * 
	 */
	public Map getBonusesToEdit();

	/**
	 * @return the current bonuses table
	 * 
	 */
	public List getBonusesTable();

	/**
	 * Init the bonuses
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initBonuses(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the bonuses
	 * @param newValue the bonuses to update
	 * 
	 */
	public void updateBonuses(EObject newValue);

	/**
	 * Adds the given filter to the bonuses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToBonuses(ViewerFilter filter);

	/**
	 * Adds the given filter to the bonuses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToBonuses(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the bonuses table
	 * 
	 */
	public boolean isContainedInBonusesTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
