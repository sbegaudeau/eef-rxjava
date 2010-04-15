/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.references.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferencesViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * ReferenceEnabledSample view descriptor
	 * 
	 */
	public static class ReferenceEnabledSample {
		
		public static String reference = "references::ReferenceEnabledSample::reference";
		
	
	
	}

	/**
	 * AbstractEnabledSample view descriptor
	 * 
	 */
	public static class AbstractEnabledSample {
		
		public static String enabled = "references::AbstractEnabledSample::enabled";
		
	
	
	}

	/**
	 * AbstractSample view descriptor
	 * 
	 */
	public static class AbstractSample {
		
		public static String name = "references::AbstractSample::name";
		
	
	}

}
