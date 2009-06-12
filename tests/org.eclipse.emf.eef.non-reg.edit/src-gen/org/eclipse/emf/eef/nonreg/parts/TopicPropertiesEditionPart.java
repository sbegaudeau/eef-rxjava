/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
 


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
	 * @return the DocumentedElement referenced view
	 */
	public IPropertiesEditionPart getDocumentedElementReferencedView();
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

