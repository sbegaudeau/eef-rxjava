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
 * $Id: EEFGenViewsRepository.java,v 1.3 2009/05/05 12:06:11 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenViewsRepository {

	public static final int SWT_KIND = 0;
		
	public static final int FORM_KIND = 1;

	
	/**
	 * GenEditionContext view descriptor
	 */
	public static class GenEditionContext {

		public static String propertiesEditionContext = "EEFGen::GenEditionContext::properties Edition Context";



		public static String basePackage = "EEFGen::GenEditionContext::basePackage";


		public static String descriptorsContributorID = "EEFGen::GenEditionContext::descriptorsContributorID";



		public static String descriptorsGenericPropertiesViews = "EEFGen::GenEditionContext::descriptorsGenericPropertiesViews";


		public static String gmfPropertiesViews = "EEFGen::GenEditionContext::gmfPropertiesViews";



	}

	/**
	 * EEFGenModelReference view descriptor
	 */
	public static class EEFGenModelReference {

		public static String referencedEEFGenModel = "EEFGen::EEFGenModelReference::Referenced EEFGenModel";



	}

	/**
	 * EEFGenModel view descriptor
	 */
	public static class EEFGenModel {

		public static String genDirectory = "EEFGen::EEFGenModel::genDirectory";



		public static String author = "EEFGen::EEFGenModel::author";


		public static String license = "EEFGen::EEFGenModel::license";



	}

	/**
	 * GenViewsRepository view descriptor
	 */
	public static class GenViewsRepository {

		public static String viewsRepository = "EEFGen::GenViewsRepository::Views repository";



		public static String basePackage = "EEFGen::GenViewsRepository::basePackage";


		public static String helpStrategy = "EEFGen::GenViewsRepository::helpStrategy";



		public static String swtViews = "EEFGen::GenViewsRepository::swtViews";


		public static String formViews = "EEFGen::GenViewsRepository::formViews";



	}

}

