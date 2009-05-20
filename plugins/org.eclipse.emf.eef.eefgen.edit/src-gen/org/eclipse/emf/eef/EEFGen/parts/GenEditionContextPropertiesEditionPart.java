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
 * $Id: GenEditionContextPropertiesEditionPart.java,v 1.5 2009/05/20 15:51:51 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface GenEditionContextPropertiesEditionPart {

	/**
	 * @return the properties Edition Context
	 */
	public EObject getPropertiesEditionContext();

	/**
	 * Init the properties Edition Context
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initPropertiesEditionContext(ResourceSet allResources, EObject current);

	/**
	 * Defines a new properties Edition Context
	 * @param newValue the new properties Edition Context to set
	 */
	public void setPropertiesEditionContext(EObject newValue);

	/**
	 * Adds the given filter to the properties Edition Context edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPropertiesEditionContext(ViewerFilter filter);

	/**
	 * Adds the given filter to the properties Edition Context edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPropertiesEditionContext(ViewerFilter filter);





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
	 * @return the descriptorsContributorID
	 */
	public String getDescriptorsContributorID();

	/**
	 * Defines a new descriptorsContributorID
	 * @param newValue the new descriptorsContributorID to set
	 */
	public void setDescriptorsContributorID(String newValue);

	public void setMessageForDescriptorsContributorID(String msg, int msgLevel);

	public void unsetMessageForDescriptorsContributorID();

	/**
	 * @return the descriptorsGenericPropertiesViews
	 */
	public Boolean getDescriptorsGenericPropertiesViews();

	/**
	 * Defines a new descriptorsGenericPropertiesViews
	 * @param newValue the new descriptorsGenericPropertiesViews to set
	 */
	public void setDescriptorsGenericPropertiesViews(Boolean newValue);





	/**
	 * @return the gmfPropertiesViews
	 */
	public Boolean getGmfPropertiesViews();

	/**
	 * Defines a new gmfPropertiesViews
	 * @param newValue the new gmfPropertiesViews to set
	 */
	public void setGmfPropertiesViews(Boolean newValue);










	// Start of user code for additional methods
 	
	// End of user code
}

