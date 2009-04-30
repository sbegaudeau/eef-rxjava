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
 * $Id: EEFGenPackagePropertiesEditionProvider.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;
 	
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 */
	public EEFGenPackagePropertiesEditionProvider() {
		super();
		append(createGenEditionContextPropertiesEditionProvider());
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * GenEditionContext instances.
	 */
	protected GenEditionContextPropertiesEditionProvider genEditionContextPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a GenEditionContext
	 */
	public GenEditionContextPropertiesEditionProvider createGenEditionContextPropertiesEditionProvider() {
		if (genEditionContextPropertiesEditionProvider == null)
			genEditionContextPropertiesEditionProvider = new GenEditionContextPropertiesEditionProvider();
		return genEditionContextPropertiesEditionProvider;
	}
	

}	
