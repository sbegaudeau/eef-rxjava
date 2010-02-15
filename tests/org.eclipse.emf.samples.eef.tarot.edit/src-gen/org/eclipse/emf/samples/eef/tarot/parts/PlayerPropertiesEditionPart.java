/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts;

// Start of user code for imports





// End of user code

/**
 * 
 */
public interface PlayerPropertiesEditionPart {

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
	 * @return the pics
	 */
	public String getPics();

	/**
	 * Init the pics
	 * @param key the key of the editor 
	 * @param current the new path of the pics
	 */
	public void initPics(String key, String newValue);

	/**
	 * Defines a new pics
	 * @param newValue the new pics to set
	 */
	public void setPics(String newValue);










	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
