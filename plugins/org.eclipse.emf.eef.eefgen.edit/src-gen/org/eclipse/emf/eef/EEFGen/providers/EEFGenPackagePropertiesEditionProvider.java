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
 * $Id: EEFGenPackagePropertiesEditionProvider.java,v 1.7 2009/08/22 11:15:38 glefur Exp $
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
		append(createEEFGenModelReferencePropertiesEditionProvider());
		append(createEEFGenModelPropertiesEditionProvider());
		append(createGenViewsRepositoryPropertiesEditionProvider());
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
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EEFGenModelReference instances.
	 */
	protected EEFGenModelReferencePropertiesEditionProvider eEFGenModelReferencePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EEFGenModelReference
	 */
	public EEFGenModelReferencePropertiesEditionProvider createEEFGenModelReferencePropertiesEditionProvider() {
		if (eEFGenModelReferencePropertiesEditionProvider == null)
			eEFGenModelReferencePropertiesEditionProvider = new EEFGenModelReferencePropertiesEditionProvider();
		return eEFGenModelReferencePropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EEFGenModel instances.
	 */
	protected EEFGenModelPropertiesEditionProvider eEFGenModelPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EEFGenModel
	 */
	public EEFGenModelPropertiesEditionProvider createEEFGenModelPropertiesEditionProvider() {
		if (eEFGenModelPropertiesEditionProvider == null)
			eEFGenModelPropertiesEditionProvider = new EEFGenModelPropertiesEditionProvider();
		return eEFGenModelPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * GenViewsRepository instances.
	 */
	protected GenViewsRepositoryPropertiesEditionProvider genViewsRepositoryPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a GenViewsRepository
	 */
	public GenViewsRepositoryPropertiesEditionProvider createGenViewsRepositoryPropertiesEditionProvider() {
		if (genViewsRepositoryPropertiesEditionProvider == null)
			genViewsRepositoryPropertiesEditionProvider = new GenViewsRepositoryPropertiesEditionProvider();
		return genViewsRepositoryPropertiesEditionProvider;
	}
	
}	
