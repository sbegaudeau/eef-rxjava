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
 * $Id: EEFGenViewsRepository.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenViewsRepository {
	
    /**
     * Gen Parameters view descriptor
     *
     */
	public static class GenParameters {

		public static String basePackage = "EEFGen::Gen Parameters::basePackage";

		public static String genDirectory = "EEFGen::Gen Parameters::genDirectory";

		public static String descriptorsContributorID = "EEFGen::Gen Parameters::descriptorsContributorID";

		public static String helpStrategy = "EEFGen::Gen Parameters::helpStrategy";

		public static String author = "EEFGen::Gen Parameters::author";

		public static String license = "EEFGen::Gen Parameters::license";
	
	}
	
    /**
     * Gen Activation view descriptor
     *
     */
	public static class GenActivation {

		public static String descriptorsGenericPropertiesViews = "EEFGen::Gen Activation::descriptorsGenericPropertiesViews";

		public static String formViews = "EEFGen::Gen Activation::formViews";

		public static String gmfPropertiesViews = "EEFGen::Gen Activation::gmfPropertiesViews";

		public static String swtViews = "EEFGen::Gen Activation::swtViews";
	
	}
	
    /**
     * Gen References view descriptor
     *
     */
	public static class GenReferences {

		public static String propertiesEditionContext = "EEFGen::Gen References::propertiesEditionContext";
	
	}
	

}

