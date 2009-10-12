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


		public static String basePackage = "EEFGen::GenEditionContext::Base package";	

	public static String descriptorsContributorID = "EEFGen::GenEditionContext::Descriptors contributorID";	


		public static String genericPropertiesViewsDescriptors = "EEFGen::GenEditionContext::Generic properties views descriptors";	

	public static String gMFSpecificPropertiesViews = "EEFGen::GenEditionContext::GMF specific properties views";	

	public static String jUnitTestCases = "EEFGen::GenEditionContext::JUnit test cases";	


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
		public static String generationDirectory = "EEFGen::EEFGenModel::Generation directory";	

	public static String testsGenerationDirectory = "EEFGen::EEFGenModel::Tests generation directory";	


		public static String author = "EEFGen::EEFGenModel::author";	

	public static String license = "EEFGen::EEFGenModel::license";	


	}

	/**
	 * GenViewsRepository view descriptor
	 */
	public static class GenViewsRepository {
		public static String viewsRepository = "EEFGen::GenViewsRepository::Views repository";	


		public static String basePackage = "EEFGen::GenViewsRepository::Base package";	

	public static String helpStrategy = "EEFGen::GenViewsRepository::Help strategy";	


		public static String sWTViews = "EEFGen::GenViewsRepository::SWT views";	

	public static String formsViews = "EEFGen::GenViewsRepository::Forms views";	


	}

}
