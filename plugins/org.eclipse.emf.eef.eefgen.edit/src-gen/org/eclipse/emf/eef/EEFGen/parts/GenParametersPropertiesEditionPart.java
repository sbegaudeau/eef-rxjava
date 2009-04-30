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
 * $Id: GenParametersPropertiesEditionPart.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface GenParametersPropertiesEditionPart {

	/**
	 * @return the basePackage
	 */
	public String getBasePackage();
	
	/**
	 * Defines a new basePackage
	 * @param newValue the new basePackage to set
	 */
	public void setBasePackage(String newValue);
	
	public void setMessageForBasePackage (String msg, int msgLevel);	
	
	public void unsetMessageForBasePackage ();
	
	/**
	 * @return the genDirectory
	 */
	public String getGenDirectory();
	
	/**
	 * Defines a new genDirectory
	 * @param newValue the new genDirectory to set
	 */
	public void setGenDirectory(String newValue);
	
	public void setMessageForGenDirectory (String msg, int msgLevel);	
	
	public void unsetMessageForGenDirectory ();
	
	/**
	 * @return the descriptorsContributorID
	 */
	public String getDescriptorsContributorID();
	
	/**
	 * Defines a new descriptorsContributorID
	 * @param newValue the new descriptorsContributorID to set
	 */
	public void setDescriptorsContributorID(String newValue);
	
	public void setMessageForDescriptorsContributorID (String msg, int msgLevel);	
	
	public void unsetMessageForDescriptorsContributorID ();
	
	/**
	 * @return the helpStrategy
	 */
	public Enumerator getHelpStrategy();
	
	/**
	 * Defines a new helpStrategy
	 * @param newValue the new helpStrategy to set
	 */
	public void setHelpStrategy(Enumerator newValue);
	
	
	
	
	
	/**
	 * @return the author
	 */
	public String getAuthor();
	
	/**
	 * Defines a new author
	 * @param newValue the new author to set
	 */
	public void setAuthor(String newValue);
	
	public void setMessageForAuthor (String msg, int msgLevel);	
	
	public void unsetMessageForAuthor ();
	
	/**
	 * @return the license
	 */
	public String getLicense();
	
	/**
	 * Defines a new license
	 * @param newValue the new license to set
	 */
	public void setLicense(String newValue);
	
	public void setMessageForLicense (String msg, int msgLevel);	
	
	public void unsetMessageForLicense ();
	
	// Start of user code for additional methods
 	
	// End of user code

}

