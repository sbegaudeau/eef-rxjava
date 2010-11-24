/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.references.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.eefnr.references.util.ReferencesAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferencesEEFAdapterFactory extends ReferencesAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.References#createReferenceEnabledSampleAdapter()
	 * 
	 */
	public Adapter createReferenceEnabledSampleAdapter() {
		return new ReferenceEnabledSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.References#createAbstractEnabledSampleAdapter()
	 * 
	 */
	public Adapter createAbstractEnabledSampleAdapter() {
		return new AbstractEnabledSamplePropertiesEditionProvider();
	}

}
