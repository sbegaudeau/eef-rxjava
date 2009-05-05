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
 * $Id: EEFGenModelReferencePropertiesEditionPart.java,v 1.2 2009/05/05 12:06:11 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface EEFGenModelReferencePropertiesEditionPart {

	/**
	 * @return the Referenced EEFGenModel
	 */
	public EObject getReferencedEEFGenModel();
	
	/**
	 * Init the Referenced EEFGenModel
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initReferencedEEFGenModel(ResourceSet allResources, EObject current);

/**
	 * Defines a new Referenced EEFGenModel
	 * @param newValue the new Referenced EEFGenModel to set
	 */
	public void setReferencedEEFGenModel(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
	
	// End of user code
}

