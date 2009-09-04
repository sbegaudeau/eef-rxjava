/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.parts;

// Start of user code for imports

import org.eclipse.emf.common.util.EList;


// End of user code

/**
 * 
 */
public interface TopicPropertiesEditionPart {

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 */
	public void setDescription(String newValue);

	public void setMessageForDescription(String msg, int msgLevel);

	public void unsetMessageForDescription();

	/**
	 * @return the references
	 */
	public EList getReferences();

	/**
	 * Defines a new references
	 * @param newValue the new references to set
	 */
	public void setReferences(EList newValue);





	/**
	 * @return the documentation
	 */
	public String getDocumentation();

	/**
	 * Defines a new documentation
	 * @param newValue the new documentation to set
	 */
	public void setDocumentation(String newValue);

	public void setMessageForDocumentation(String msg, int msgLevel);

	public void unsetMessageForDocumentation();






	// Start of user code for additional methods
	
	// End of user code

}
