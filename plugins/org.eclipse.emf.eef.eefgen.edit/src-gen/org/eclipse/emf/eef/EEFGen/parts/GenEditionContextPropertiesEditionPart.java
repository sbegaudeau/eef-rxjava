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
 */
package org.eclipse.emf.eef.EEFGen.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
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
	 * Defines the button mode
	 * @param newValue the new mode to set
	 */
	public void setPropertiesEditionContextButtonMode(ButtonsModeEnum newValue);

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
	 * @return the Base package
	 */
	public String getBasePackage();

	/**
	 * Defines a new Base package
	 * @param newValue the new Base package to set
	 */
	public void setBasePackage(String newValue);

	public void setMessageForBasePackage(String msg, int msgLevel);

	public void unsetMessageForBasePackage();

	/**
	 * @return the Descriptors contributorID
	 */
	public String getDescriptorsContributorID();

	/**
	 * Defines a new Descriptors contributorID
	 * @param newValue the new Descriptors contributorID to set
	 */
	public void setDescriptorsContributorID(String newValue);

	public void setMessageForDescriptorsContributorID(String msg, int msgLevel);

	public void unsetMessageForDescriptorsContributorID();

	/**
	 * @return the Generic properties views descriptors
	 */
	public Boolean getGenericPropertiesViewsDescriptors();

	/**
	 * Defines a new Generic properties views descriptors
	 * @param newValue the new Generic properties views descriptors to set
	 */
	public void setGenericPropertiesViewsDescriptors(Boolean newValue);





	/**
	 * @return the GMF specific properties views
	 */
	public Boolean getGMFSpecificPropertiesViews();

	/**
	 * Defines a new GMF specific properties views
	 * @param newValue the new GMF specific properties views to set
	 */
	public void setGMFSpecificPropertiesViews(Boolean newValue);





	/**
	 * @return the JUnit test cases
	 */
	public Boolean getJUnitTestCases();

	/**
	 * Defines a new JUnit test cases
	 * @param newValue the new JUnit test cases to set
	 */
	public void setJUnitTestCases(Boolean newValue);










	// Start of user code for additional methods
 	
	// End of user code

}
