/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.referencestable;


/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IReferencesTableListener {

	/**
	 * An element must be added.
	 * @param toAdd the element to add
	 */
	void handleAdd(Object toAdd);
	
	/**
	 * An element must be removed.
	 * @param toRemove the element to remove
	 */
	void handleRemove(Object toRemove);
	
	/**
	 * An element must be set to a new index.
	 * @param toMove the element to move
	 * @param newIndex the new place of the element 
	 */
	void handleMove(Object toMove, int newIndex);
	
}

