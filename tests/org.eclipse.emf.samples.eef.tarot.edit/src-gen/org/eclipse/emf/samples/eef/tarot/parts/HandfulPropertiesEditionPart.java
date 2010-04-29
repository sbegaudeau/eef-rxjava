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
public interface HandfulPropertiesEditionPart {

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
	 * @return the size
	 * 
	 */
	public Enumerator getSize();

	/**
	 * Init the size
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initSize(EEnum eenum, Enumerator current);

	/**
	 * Defines a new size
	 * @param newValue the new size to set
	 * 
	 */
	public void setSize(Enumerator newValue);





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
