/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.extended.editor.parts;

// Start of user code for imports



// End of user code

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen LeFur</a>
 * 
 */
public interface TreeMasterPagePropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the title
	 * 
	 */
	public String getTitle_();

	/**
	 * Defines a new title
	 * @param newValue the new title to set
	 * 
	 */
	public void setTitle_(String newValue);


	/**
	 * @return the toolbarVisible
	 * 
	 */
	public Boolean getToolbarVisible();

	/**
	 * Defines a new toolbarVisible
	 * @param newValue the new toolbarVisible to set
	 * 
	 */
	public void setToolbarVisible(Boolean newValue);





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
