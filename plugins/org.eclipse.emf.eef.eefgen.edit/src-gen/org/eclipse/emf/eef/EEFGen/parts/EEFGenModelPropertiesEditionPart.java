/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EEFGenModelPropertiesEditionPart.java,v 1.7 2009/08/22 11:15:37 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

// Start of user code for imports


 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface EEFGenModelPropertiesEditionPart {

	/**
	 * @return the Generation directory
	 */
	public String getGenerationDirectory();

	/**
	 * Defines a new Generation directory
	 * @param newValue the new Generation directory to set
	 */
	public void setGenerationDirectory(String newValue);

	public void setMessageForGenerationDirectory(String msg, int msgLevel);

	public void unsetMessageForGenerationDirectory();

	/**
	 * @return the Tests generation directory
	 */
	public String getTestsGenerationDirectory();

	/**
	 * Defines a new Tests generation directory
	 * @param newValue the new Tests generation directory to set
	 */
	public void setTestsGenerationDirectory(String newValue);

	public void setMessageForTestsGenerationDirectory(String msg, int msgLevel);

	public void unsetMessageForTestsGenerationDirectory();

	/**
	 * @return the author
	 */
	public String getAuthor();

	/**
	 * Defines a new author
	 * @param newValue the new author to set
	 */
	public void setAuthor(String newValue);

	public void setMessageForAuthor(String msg, int msgLevel);

	public void unsetMessageForAuthor();

	/**
	 * @return the license
	 */
	public String getLicense();

	/**
	 * Defines a new license
	 * @param newValue the new license to set
	 */
	public void setLicense(String newValue);

	public void setMessageForLicense(String msg, int msgLevel);

	public void unsetMessageForLicense();






	// Start of user code for additional methods
 	
	// End of user code

}

