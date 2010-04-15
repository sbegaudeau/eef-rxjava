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
package org.eclipse.emf.eef.eefnr.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EefnrPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public EefnrPackagePropertiesEditionProvider() {
		super();
		append(createRootPropertiesEditionProvider());
		append(createTotalSamplePropertiesEditionProvider());
		append(createTextSamplePropertiesEditionProvider());
		append(createCheckboxSamplePropertiesEditionProvider());
		append(createTextareaSamplePropertiesEditionProvider());
		append(createRadioSamplePropertiesEditionProvider());
		append(createEObjectFlatComboViewerSamplePropertiesEditionProvider());
		append(createReferencesTableSamplePropertiesEditionProvider());
		append(createEMFComboViewerSamplePropertiesEditionProvider());
		append(createMultiValuedEditorSamplePropertiesEditionProvider());
		append(createTableCompositionEditorSamplePropertiesEditionProvider());
		append(createAdvancedReferencesTableSamplePropertiesEditionProvider());
		append(createAdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider());
		append(createAdvancedTableCompositionEditorSamplePropertiesEditionProvider());
		append(createFlatReferenceTableSamplePropertiesEditionProvider());
		append(createSamplePropertiesEditionProvider());
		append(createTextSampleWithTwoTabsPropertiesEditionProvider());
		append(createTableCompositionExtensionEditorSamplePropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Root instances.
	 * 
	 */
	protected RootPropertiesEditionProvider rootPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Root
	 * 
	 */
	public RootPropertiesEditionProvider createRootPropertiesEditionProvider() {
		if (rootPropertiesEditionProvider == null)
			rootPropertiesEditionProvider = new RootPropertiesEditionProvider();
		return rootPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TotalSample instances.
	 * 
	 */
	protected TotalSamplePropertiesEditionProvider totalSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TotalSample
	 * 
	 */
	public TotalSamplePropertiesEditionProvider createTotalSamplePropertiesEditionProvider() {
		if (totalSamplePropertiesEditionProvider == null)
			totalSamplePropertiesEditionProvider = new TotalSamplePropertiesEditionProvider();
		return totalSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TextSample instances.
	 * 
	 */
	protected TextSamplePropertiesEditionProvider textSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TextSample
	 * 
	 */
	public TextSamplePropertiesEditionProvider createTextSamplePropertiesEditionProvider() {
		if (textSamplePropertiesEditionProvider == null)
			textSamplePropertiesEditionProvider = new TextSamplePropertiesEditionProvider();
		return textSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CheckboxSample instances.
	 * 
	 */
	protected CheckboxSamplePropertiesEditionProvider checkboxSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CheckboxSample
	 * 
	 */
	public CheckboxSamplePropertiesEditionProvider createCheckboxSamplePropertiesEditionProvider() {
		if (checkboxSamplePropertiesEditionProvider == null)
			checkboxSamplePropertiesEditionProvider = new CheckboxSamplePropertiesEditionProvider();
		return checkboxSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TextareaSample instances.
	 * 
	 */
	protected TextareaSamplePropertiesEditionProvider textareaSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TextareaSample
	 * 
	 */
	public TextareaSamplePropertiesEditionProvider createTextareaSamplePropertiesEditionProvider() {
		if (textareaSamplePropertiesEditionProvider == null)
			textareaSamplePropertiesEditionProvider = new TextareaSamplePropertiesEditionProvider();
		return textareaSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * RadioSample instances.
	 * 
	 */
	protected RadioSamplePropertiesEditionProvider radioSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a RadioSample
	 * 
	 */
	public RadioSamplePropertiesEditionProvider createRadioSamplePropertiesEditionProvider() {
		if (radioSamplePropertiesEditionProvider == null)
			radioSamplePropertiesEditionProvider = new RadioSamplePropertiesEditionProvider();
		return radioSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EObjectFlatComboViewerSample instances.
	 * 
	 */
	protected EObjectFlatComboViewerSamplePropertiesEditionProvider eObjectFlatComboViewerSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EObjectFlatComboViewerSample
	 * 
	 */
	public EObjectFlatComboViewerSamplePropertiesEditionProvider createEObjectFlatComboViewerSamplePropertiesEditionProvider() {
		if (eObjectFlatComboViewerSamplePropertiesEditionProvider == null)
			eObjectFlatComboViewerSamplePropertiesEditionProvider = new EObjectFlatComboViewerSamplePropertiesEditionProvider();
		return eObjectFlatComboViewerSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReferencesTableSample instances.
	 * 
	 */
	protected ReferencesTableSamplePropertiesEditionProvider referencesTableSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReferencesTableSample
	 * 
	 */
	public ReferencesTableSamplePropertiesEditionProvider createReferencesTableSamplePropertiesEditionProvider() {
		if (referencesTableSamplePropertiesEditionProvider == null)
			referencesTableSamplePropertiesEditionProvider = new ReferencesTableSamplePropertiesEditionProvider();
		return referencesTableSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EMFComboViewerSample instances.
	 * 
	 */
	protected EMFComboViewerSamplePropertiesEditionProvider eMFComboViewerSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EMFComboViewerSample
	 * 
	 */
	public EMFComboViewerSamplePropertiesEditionProvider createEMFComboViewerSamplePropertiesEditionProvider() {
		if (eMFComboViewerSamplePropertiesEditionProvider == null)
			eMFComboViewerSamplePropertiesEditionProvider = new EMFComboViewerSamplePropertiesEditionProvider();
		return eMFComboViewerSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * MultiValuedEditorSample instances.
	 * 
	 */
	protected MultiValuedEditorSamplePropertiesEditionProvider multiValuedEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a MultiValuedEditorSample
	 * 
	 */
	public MultiValuedEditorSamplePropertiesEditionProvider createMultiValuedEditorSamplePropertiesEditionProvider() {
		if (multiValuedEditorSamplePropertiesEditionProvider == null)
			multiValuedEditorSamplePropertiesEditionProvider = new MultiValuedEditorSamplePropertiesEditionProvider();
		return multiValuedEditorSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TableCompositionEditorSample instances.
	 * 
	 */
	protected TableCompositionEditorSamplePropertiesEditionProvider tableCompositionEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TableCompositionEditorSample
	 * 
	 */
	public TableCompositionEditorSamplePropertiesEditionProvider createTableCompositionEditorSamplePropertiesEditionProvider() {
		if (tableCompositionEditorSamplePropertiesEditionProvider == null)
			tableCompositionEditorSamplePropertiesEditionProvider = new TableCompositionEditorSamplePropertiesEditionProvider();
		return tableCompositionEditorSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AdvancedReferencesTableSample instances.
	 * 
	 */
	protected AdvancedReferencesTableSamplePropertiesEditionProvider advancedReferencesTableSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AdvancedReferencesTableSample
	 * 
	 */
	public AdvancedReferencesTableSamplePropertiesEditionProvider createAdvancedReferencesTableSamplePropertiesEditionProvider() {
		if (advancedReferencesTableSamplePropertiesEditionProvider == null)
			advancedReferencesTableSamplePropertiesEditionProvider = new AdvancedReferencesTableSamplePropertiesEditionProvider();
		return advancedReferencesTableSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AdvancedEObjectFlatComboViewerSample instances.
	 * 
	 */
	protected AdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider advancedEObjectFlatComboViewerSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AdvancedEObjectFlatComboViewerSample
	 * 
	 */
	public AdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider createAdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider() {
		if (advancedEObjectFlatComboViewerSamplePropertiesEditionProvider == null)
			advancedEObjectFlatComboViewerSamplePropertiesEditionProvider = new AdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider();
		return advancedEObjectFlatComboViewerSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AdvancedTableCompositionEditorSample instances.
	 * 
	 */
	protected AdvancedTableCompositionEditorSamplePropertiesEditionProvider advancedTableCompositionEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AdvancedTableCompositionEditorSample
	 * 
	 */
	public AdvancedTableCompositionEditorSamplePropertiesEditionProvider createAdvancedTableCompositionEditorSamplePropertiesEditionProvider() {
		if (advancedTableCompositionEditorSamplePropertiesEditionProvider == null)
			advancedTableCompositionEditorSamplePropertiesEditionProvider = new AdvancedTableCompositionEditorSamplePropertiesEditionProvider();
		return advancedTableCompositionEditorSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * FlatReferencesTableSample instances.
	 * 
	 */
	protected FlatReferenceTableSamplePropertiesEditionProvider flatReferenceTableSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a FlatReferencesTableSample
	 * 
	 */
	public FlatReferenceTableSamplePropertiesEditionProvider createFlatReferenceTableSamplePropertiesEditionProvider() {
		if (flatReferenceTableSamplePropertiesEditionProvider == null)
			flatReferenceTableSamplePropertiesEditionProvider = new FlatReferenceTableSamplePropertiesEditionProvider();
		return flatReferenceTableSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Sample instances.
	 * 
	 */
	protected SamplePropertiesEditionProvider samplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Sample
	 * 
	 */
	public SamplePropertiesEditionProvider createSamplePropertiesEditionProvider() {
		if (samplePropertiesEditionProvider == null)
			samplePropertiesEditionProvider = new SamplePropertiesEditionProvider();
		return samplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TextSampleWithTwoTabs instances.
	 * 
	 */
	protected TextSampleWithTwoTabsPropertiesEditionProvider textSampleWithTwoTabsPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TextSampleWithTwoTabs
	 * 
	 */
	public TextSampleWithTwoTabsPropertiesEditionProvider createTextSampleWithTwoTabsPropertiesEditionProvider() {
		if (textSampleWithTwoTabsPropertiesEditionProvider == null)
			textSampleWithTwoTabsPropertiesEditionProvider = new TextSampleWithTwoTabsPropertiesEditionProvider();
		return textSampleWithTwoTabsPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TableCompositionExtensionEditorSample instances.
	 * 
	 */
	protected TableCompositionExtensionEditorSamplePropertiesEditionProvider tableCompositionExtensionEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TableCompositionExtensionEditorSample
	 * 
	 */
	public TableCompositionExtensionEditorSamplePropertiesEditionProvider createTableCompositionExtensionEditorSamplePropertiesEditionProvider() {
		if (tableCompositionExtensionEditorSamplePropertiesEditionProvider == null)
			tableCompositionExtensionEditorSamplePropertiesEditionProvider = new TableCompositionExtensionEditorSamplePropertiesEditionProvider();
		return tableCompositionExtensionEditorSamplePropertiesEditionProvider;
	}

}
