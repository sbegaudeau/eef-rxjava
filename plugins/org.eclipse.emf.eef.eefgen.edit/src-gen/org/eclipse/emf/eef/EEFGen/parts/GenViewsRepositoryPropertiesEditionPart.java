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
 * $Id: GenViewsRepositoryPropertiesEditionPart.java,v 1.1 2009/04/30 17:49:29 nlepine Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface GenViewsRepositoryPropertiesEditionPart {

	/**
	 * @return the Views repository
	 */
	public EObject getViewsRepository();
	
	/**
	 * Init the Views repository
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initViewsRepository(ResourceSet allResources, EObject current);

/**
	 * Defines a new Views repository
	 * @param newValue the new Views repository to set
	 */
	public void setViewsRepository(EObject newValue);
	
	
	
	
	
	/**
	 * @return the basePackage
	 */
	public String getBasePackage();
	
	/**
	 * Defines a new basePackage
	 * @param newValue the new basePackage to set
	 */
	public void setBasePackage(String newValue);
	
	public void setMessageForBasePackage(String msg, int msgLevel);
	
	public void unsetMessageForBasePackage();
	
	/**
	 * @return the helpStrategy
	 */
	public Enumerator getHelpStrategy();
	
	/**
	 * Init the helpStrategy
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initHelpStrategy(EEnum eenum, Enumerator current);

/**
	 * Defines a new helpStrategy
	 * @param newValue the new helpStrategy to set
	 */
	public void setHelpStrategy(Enumerator newValue);
	
	
	
	
	
	/**
	 * @return the swtViews
	 */
	public Boolean getSwtViews();
	
	/**
	 * Defines a new swtViews
	 * @param newValue the new swtViews to set
	 */
	public void setSwtViews(Boolean newValue);
	
	
	
	
	
	/**
	 * @return the formViews
	 */
	public Boolean getFormViews();
	
	/**
	 * Defines a new formViews
	 * @param newValue the new formViews to set
	 */
	public void setFormViews(Boolean newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}

