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
public interface JavaExpressionFilterPropertiesEditionPart {

	/**
	 * @return the javaExpressionBody
	 */
	public String getJavaExpressionBody();

	/**
	 * Defines a new javaExpressionBody
	 * @param newValue the new javaExpressionBody to set
	 */
	public void setJavaExpressionBody(String newValue);

	public void setMessageForJavaExpressionBody(String msg, int msgLevel);

	public void unsetMessageForJavaExpressionBody();






	// Start of user code for additional methods
	
	// End of user code
}

