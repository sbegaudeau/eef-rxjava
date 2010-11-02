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
package org.eclipse.emf.eef.eefnrext.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.eefnrext.util.EefnrextAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EefnrextEEFAdapterFactory extends EefnrextAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnrext#createTableCompositionTargetExtensionEditorSampleAdapter()
	 * 
	 */
	public Adapter createTableCompositionTargetExtensionEditorSampleAdapter() {
		return new TableCompositionTargetExtensionEditorSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnrext#createCheckBoxExtendedEditorSampleAdapter()
	 * 
	 */
	public Adapter createCheckBoxExtendedEditorSampleAdapter() {
		return new CheckBoxExtendedEditorSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnrext#createFlatReferenceExtendedEditorSampleAdapter()
	 * 
	 */
	public Adapter createFlatReferenceExtendedEditorSampleAdapter() {
		return new FlatReferenceExtendedEditorSamplePropertiesEditionProvider();
	}

}
