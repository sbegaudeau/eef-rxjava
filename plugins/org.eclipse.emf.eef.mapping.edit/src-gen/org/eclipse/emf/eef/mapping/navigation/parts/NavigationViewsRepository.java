/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.mapping.navigation.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class NavigationViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * ModelNavigation view descriptor
	 * 
	 */
	public static class ModelNavigation {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * SimpleModelNavigation view descriptor
	 * 
	 */
	public static class SimpleModelNavigation {
		public static class Properties {
	
			
			public static String index = "navigation::SimpleModelNavigation::Properties::index";
			
			
			public static String feature = "navigation::SimpleModelNavigation::Properties::feature";
			
			
			public static String discriminatorType = "navigation::SimpleModelNavigation::Properties::discriminatorType";
			
	
		}
	
	}

}
