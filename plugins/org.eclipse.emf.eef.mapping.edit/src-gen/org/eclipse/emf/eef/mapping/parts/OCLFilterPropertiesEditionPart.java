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
 * $Id$
 */
package org.eclipse.emf.eef.mapping.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface OCLFilterPropertiesEditionPart {

	/**
	 * @return the OCLExpressionBody
	 */
	public String getOCLExpressionBody();

	/**
	 * Defines a new OCLExpressionBody
	 * @param newValue the new OCLExpressionBody to set
	 */
	public void setOCLExpressionBody(String newValue);

	public void setMessageForOCLExpressionBody(String msg, int msgLevel);

	public void unsetMessageForOCLExpressionBody();






	// Start of user code for additional methods
	
	// End of user code
}

