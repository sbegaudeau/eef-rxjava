/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;



// End of user code

/**
 * 
 * 
 */
public interface SlamPropertiesEditionPart {

	/**
	 * @return the side
	 * 
	 */
	public Enumerator getSide();

	/**
	 * Init the side
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initSide(EEnum eenum, Enumerator current);

	/**
	 * Defines a new side
	 * @param newValue the new side to set
	 * 
	 */
	public void setSide(Enumerator newValue);


	/**
	 * @return the announced
	 * 
	 */
	public Boolean getAnnounced();

	/**
	 * Defines a new announced
	 * @param newValue the new announced to set
	 * 
	 */
	public void setAnnounced(Boolean newValue);


	/**
	 * @return the achieved
	 * 
	 */
	public Boolean getAchieved();

	/**
	 * Defines a new achieved
	 * @param newValue the new achieved to set
	 * 
	 */
	public void setAchieved(Boolean newValue);





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
