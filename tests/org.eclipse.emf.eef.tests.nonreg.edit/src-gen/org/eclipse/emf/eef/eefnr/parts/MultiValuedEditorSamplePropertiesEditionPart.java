/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface MultiValuedEditorSamplePropertiesEditionPart {

	/**
	 * @return the multivaluededitorRequiredProperty
	 * 
	 */
	public EList getMultivaluededitorRequiredProperty();

	/**
	 * Defines a new multivaluededitorRequiredProperty
	 * @param newValue the new multivaluededitorRequiredProperty to set
	 * 
	 */
	public void setMultivaluededitorRequiredProperty(EList newValue);


	/**
	 * @return the multivaluededitorOptionalProperty
	 * 
	 */
	public EList getMultivaluededitorOptionalProperty();

	/**
	 * Defines a new multivaluededitorOptionalProperty
	 * @param newValue the new multivaluededitorOptionalProperty to set
	 * 
	 */
	public void setMultivaluededitorOptionalProperty(EList newValue);





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
