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
package org.eclipse.emf.eef.eefnr.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EefnrEEFAdapterFactory extends EefnrAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createRootAdapter()
	 * 
	 */
	public Adapter createRootAdapter() {
		return new RootPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createTotalSampleAdapter()
	 * 
	 */
	public Adapter createTotalSampleAdapter() {
		return new TotalSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createTextSampleAdapter()
	 * 
	 */
	public Adapter createTextSampleAdapter() {
		return new TextSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createCheckboxSampleAdapter()
	 * 
	 */
	public Adapter createCheckboxSampleAdapter() {
		return new CheckboxSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createTextareaSampleAdapter()
	 * 
	 */
	public Adapter createTextareaSampleAdapter() {
		return new TextareaSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createRadioSampleAdapter()
	 * 
	 */
	public Adapter createRadioSampleAdapter() {
		return new RadioSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createEObjectFlatComboViewerSampleAdapter()
	 * 
	 */
	public Adapter createEObjectFlatComboViewerSampleAdapter() {
		return new EObjectFlatComboViewerSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createReferencesTableSampleAdapter()
	 * 
	 */
	public Adapter createReferencesTableSampleAdapter() {
		return new ReferencesTableSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createEMFComboViewerSampleAdapter()
	 * 
	 */
	public Adapter createEMFComboViewerSampleAdapter() {
		return new EMFComboViewerSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createMultiValuedEditorSampleAdapter()
	 * 
	 */
	public Adapter createMultiValuedEditorSampleAdapter() {
		return new MultiValuedEditorSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createTableCompositionEditorSampleAdapter()
	 * 
	 */
	public Adapter createTableCompositionEditorSampleAdapter() {
		return new TableCompositionEditorSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createAdvancedReferencesTableSampleAdapter()
	 * 
	 */
	public Adapter createAdvancedReferencesTableSampleAdapter() {
		return new AdvancedReferencesTableSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createAdvancedEObjectFlatComboViewerSampleAdapter()
	 * 
	 */
	public Adapter createAdvancedEObjectFlatComboViewerSampleAdapter() {
		return new AdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createAdvancedTableCompositionEditorSampleAdapter()
	 * 
	 */
	public Adapter createAdvancedTableCompositionEditorSampleAdapter() {
		return new AdvancedTableCompositionEditorSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createFlatReferencesTableSampleAdapter()
	 * 
	 */
	public Adapter createFlatReferencesTableSampleAdapter() {
		return new FlatReferenceTableSamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createSampleAdapter()
	 * 
	 */
	public Adapter createSampleAdapter() {
		return new SamplePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createTextSampleWithTwoTabsAdapter()
	 * 
	 */
	public Adapter createTextSampleWithTwoTabsAdapter() {
		return new TextSampleWithTwoTabsPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Eefnr#createTableCompositionExtensionEditorSampleAdapter()
	 * 
	 */
	public Adapter createTableCompositionExtensionEditorSampleAdapter() {
		return new TableCompositionExtensionEditorSamplePropertiesEditionProvider();
	}

}
