/**
 * 
 */
package org.eclipse.emf.eef.eefnr.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EefnrEEFAdapterFactory extends EefnrAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createRootAdapter()
	 */
	@Override
	public Adapter createRootAdapter() {
		return new RootPropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createTotalSampleAdapter()
	 */
	@Override
	public Adapter createTotalSampleAdapter() {
		return new TotalSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createTextSampleAdapter()
	 */
	@Override
	public Adapter createTextSampleAdapter() {
		return new TextSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createCheckboxSampleAdapter()
	 */
	@Override
	public Adapter createCheckboxSampleAdapter() {
		return new CheckboxSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createTextareaSampleAdapter()
	 */
	@Override
	public Adapter createTextareaSampleAdapter() {
		return new TextareaSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createRadioSampleAdapter()
	 */
	@Override
	public Adapter createRadioSampleAdapter() {
		return new RadioSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createEObjectFlatComboViewerSampleAdapter()
	 */
	@Override
	public Adapter createEObjectFlatComboViewerSampleAdapter() {
		return new EObjectFlatComboViewerSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createReferencesTableSampleAdapter()
	 */
	@Override
	public Adapter createReferencesTableSampleAdapter() {
		return new ReferencesTableSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createEMFComboViewerSampleAdapter()
	 */
	@Override
	public Adapter createEMFComboViewerSampleAdapter() {
		return new EMFComboViewerSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createMultiValuedEditorSampleAdapter()
	 */
	@Override
	public Adapter createMultiValuedEditorSampleAdapter() {
		return new MultiValuedEditorSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createTableCompositionEditorSampleAdapter()
	 */
	@Override
	public Adapter createTableCompositionEditorSampleAdapter() {
		return new TableCompositionEditorSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createAdvancedReferencesTableSampleAdapter()
	 */
	@Override
	public Adapter createAdvancedReferencesTableSampleAdapter() {
		return new AdvancedReferencesTableSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createAdvancedEObjectFlatComboViewerSampleAdapter()
	 */
	@Override
	public Adapter createAdvancedEObjectFlatComboViewerSampleAdapter() {
		return new AdvancedEObjectFlatComboViewerSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createAdvancedTableCompositionEditorSampleAdapter()
	 */
	@Override
	public Adapter createAdvancedTableCompositionEditorSampleAdapter() {
		return new AdvancedTableCompositionEditorSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createFlatReferencesTableSampleAdapter()
	 */
	@Override
	public Adapter createFlatReferencesTableSampleAdapter() {
		return new FlatReferenceTableSamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createSampleAdapter()
	 */
	@Override
	public Adapter createSampleAdapter() {
		return new SamplePropertiesEditionProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.EefnrAdapterFactory#createTextSampleWithTwoTabsAdapter()
	 */
	@Override
	public Adapter createTextSampleWithTwoTabsAdapter() {
		return new TextSampleWithTwoTabsPropertiesEditionProvider();
	}


}
