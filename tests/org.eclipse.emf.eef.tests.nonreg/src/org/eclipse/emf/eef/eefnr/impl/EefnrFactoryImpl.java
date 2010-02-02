/**
 * <copyright>
 * </copyright>
 *
 * $Id: EefnrFactoryImpl.java,v 1.2 2010/02/02 09:29:38 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.eef.eefnr.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EefnrFactoryImpl extends EFactoryImpl implements EefnrFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EefnrFactory init() {
		try {
			EefnrFactory theEefnrFactory = (EefnrFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/eef/nonreg/1.0.0"); 
			if (theEefnrFactory != null) {
				return theEefnrFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EefnrFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EefnrFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EefnrPackage.ROOT: return createRoot();
			case EefnrPackage.TOTAL_SAMPLE: return createTotalSample();
			case EefnrPackage.TEXT_SAMPLE: return createTextSample();
			case EefnrPackage.CHECKBOX_SAMPLE: return createCheckboxSample();
			case EefnrPackage.TEXTAREA_SAMPLE: return createTextareaSample();
			case EefnrPackage.RADIO_SAMPLE: return createRadioSample();
			case EefnrPackage.EOBJECT_FLAT_COMBO_VIEWER_SAMPLE: return createEObjectFlatComboViewerSample();
			case EefnrPackage.REFERENCES_TABLE_SAMPLE: return createReferencesTableSample();
			case EefnrPackage.EMF_COMBO_VIEWER_SAMPLE: return createEMFComboViewerSample();
			case EefnrPackage.MULTI_VALUED_EDITOR_SAMPLE: return createMultiValuedEditorSample();
			case EefnrPackage.TABLE_COMPOSITION_EDITOR_SAMPLE: return createTableCompositionEditorSample();
			case EefnrPackage.ADVANCED_REFERENCES_TABLE_SAMPLE: return createAdvancedReferencesTableSample();
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE: return createAdvancedEObjectFlatComboViewerSample();
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE: return createAdvancedTableCompositionEditorSample();
			case EefnrPackage.FLAT_REFERENCES_TABLE_SAMPLE: return createFlatReferencesTableSample();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EefnrPackage.ENUM_SAMPLE:
				return createENUM_SAMPLEFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EefnrPackage.ENUM_SAMPLE:
				return convertENUM_SAMPLEToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample createTotalSample() {
		TotalSampleImpl totalSample = new TotalSampleImpl();
		return totalSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample createTextSample() {
		TextSampleImpl textSample = new TextSampleImpl();
		return textSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckboxSample createCheckboxSample() {
		CheckboxSampleImpl checkboxSample = new CheckboxSampleImpl();
		return checkboxSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextareaSample createTextareaSample() {
		TextareaSampleImpl textareaSample = new TextareaSampleImpl();
		return textareaSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RadioSample createRadioSample() {
		RadioSampleImpl radioSample = new RadioSampleImpl();
		return radioSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectFlatComboViewerSample createEObjectFlatComboViewerSample() {
		EObjectFlatComboViewerSampleImpl eObjectFlatComboViewerSample = new EObjectFlatComboViewerSampleImpl();
		return eObjectFlatComboViewerSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencesTableSample createReferencesTableSample() {
		ReferencesTableSampleImpl referencesTableSample = new ReferencesTableSampleImpl();
		return referencesTableSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFComboViewerSample createEMFComboViewerSample() {
		EMFComboViewerSampleImpl emfComboViewerSample = new EMFComboViewerSampleImpl();
		return emfComboViewerSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiValuedEditorSample createMultiValuedEditorSample() {
		MultiValuedEditorSampleImpl multiValuedEditorSample = new MultiValuedEditorSampleImpl();
		return multiValuedEditorSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableCompositionEditorSample createTableCompositionEditorSample() {
		TableCompositionEditorSampleImpl tableCompositionEditorSample = new TableCompositionEditorSampleImpl();
		return tableCompositionEditorSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedReferencesTableSample createAdvancedReferencesTableSample() {
		AdvancedReferencesTableSampleImpl advancedReferencesTableSample = new AdvancedReferencesTableSampleImpl();
		return advancedReferencesTableSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedEObjectFlatComboViewerSample createAdvancedEObjectFlatComboViewerSample() {
		AdvancedEObjectFlatComboViewerSampleImpl advancedEObjectFlatComboViewerSample = new AdvancedEObjectFlatComboViewerSampleImpl();
		return advancedEObjectFlatComboViewerSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedTableCompositionEditorSample createAdvancedTableCompositionEditorSample() {
		AdvancedTableCompositionEditorSampleImpl advancedTableCompositionEditorSample = new AdvancedTableCompositionEditorSampleImpl();
		return advancedTableCompositionEditorSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlatReferencesTableSample createFlatReferencesTableSample() {
		FlatReferencesTableSampleImpl flatReferencesTableSample = new FlatReferencesTableSampleImpl();
		return flatReferencesTableSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENUM_SAMPLE createENUM_SAMPLEFromString(EDataType eDataType, String initialValue) {
		ENUM_SAMPLE result = ENUM_SAMPLE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertENUM_SAMPLEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EefnrPackage getEefnrPackage() {
		return (EefnrPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EefnrPackage getPackage() {
		return EefnrPackage.eINSTANCE;
	}

} //EefnrFactoryImpl
