/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports




// End of user code

/**
 * 
 */
public interface TextPropertiesEditionPart {

	/**
	 * @return the text
	 */
	public String getText();

	/**
	 * Defines a new text
	 * @param newValue the new text to set
	 */
	public void setText(String newValue);

	public void setMessageForText(String msg, int msgLevel);

	public void unsetMessageForText();


	/**
	 * @return the textRO
	 */
	public String getTextRO();

	/**
	 * Defines a new textRO
	 * @param newValue the new textRO to set
	 */
	public void setTextRO(String newValue);

	public void setMessageForTextRO(String msg, int msgLevel);

	public void unsetMessageForTextRO();






	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
