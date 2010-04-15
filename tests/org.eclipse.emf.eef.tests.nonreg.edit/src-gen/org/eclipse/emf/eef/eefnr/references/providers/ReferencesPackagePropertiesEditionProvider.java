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
package org.eclipse.emf.eef.eefnr.references.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferencesPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public ReferencesPackagePropertiesEditionProvider() {
		super();
		append(createReferenceEnabledSamplePropertiesEditionProvider());
		append(createAbstractSamplePropertiesEditionProvider());
		append(createAbstractEnabledSamplePropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReferenceEnabledSample instances.
	 * 
	 */
	protected ReferenceEnabledSamplePropertiesEditionProvider referenceEnabledSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReferenceEnabledSample
	 * 
	 */
	public ReferenceEnabledSamplePropertiesEditionProvider createReferenceEnabledSamplePropertiesEditionProvider() {
		if (referenceEnabledSamplePropertiesEditionProvider == null)
			referenceEnabledSamplePropertiesEditionProvider = new ReferenceEnabledSamplePropertiesEditionProvider();
		return referenceEnabledSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AbstractSample instances.
	 * 
	 */
	protected AbstractSamplePropertiesEditionProvider abstractSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AbstractSample
	 * 
	 */
	public AbstractSamplePropertiesEditionProvider createAbstractSamplePropertiesEditionProvider() {
		if (abstractSamplePropertiesEditionProvider == null)
			abstractSamplePropertiesEditionProvider = new AbstractSamplePropertiesEditionProvider();
		return abstractSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AbstractEnabledSample instances.
	 * 
	 */
	protected AbstractEnabledSamplePropertiesEditionProvider abstractEnabledSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AbstractEnabledSample
	 * 
	 */
	public AbstractEnabledSamplePropertiesEditionProvider createAbstractEnabledSamplePropertiesEditionProvider() {
		if (abstractEnabledSamplePropertiesEditionProvider == null)
			abstractEnabledSamplePropertiesEditionProvider = new AbstractEnabledSamplePropertiesEditionProvider();
		return abstractEnabledSamplePropertiesEditionProvider;
	}

}
