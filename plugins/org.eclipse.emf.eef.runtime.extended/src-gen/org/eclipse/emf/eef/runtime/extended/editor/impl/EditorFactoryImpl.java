/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorFactoryImpl.java,v 1.1 2010/12/22 14:23:48 glefur Exp $
 */
package org.eclipse.emf.eef.runtime.extended.editor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.eef.runtime.extended.editor.AllResourcesRootsRelativeInput;
import org.eclipse.emf.eef.runtime.extended.editor.EEFEditorContribution;
import org.eclipse.emf.eef.runtime.extended.editor.EEFEditorContributions;
import org.eclipse.emf.eef.runtime.extended.editor.EEFEditorPages;
import org.eclipse.emf.eef.runtime.extended.editor.EEFMasterPage;
import org.eclipse.emf.eef.runtime.extended.editor.EditorFactory;
import org.eclipse.emf.eef.runtime.extended.editor.EditorPackage;
import org.eclipse.emf.eef.runtime.extended.editor.FirstResourceRootRelativeInput;
import org.eclipse.emf.eef.runtime.extended.editor.PartFilter;
import org.eclipse.emf.eef.runtime.extended.editor.StandardFormPage;
import org.eclipse.emf.eef.runtime.extended.editor.TreeMasterPage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditorFactoryImpl extends EFactoryImpl implements EditorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EditorFactory init() {
		try {
			EditorFactory theEditorFactory = (EditorFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/eef/extended/editor/1.0.0"); 
			if (theEditorFactory != null) {
				return theEditorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EditorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorFactoryImpl() {
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
			case EditorPackage.EEF_EDITOR_CONTRIBUTION: return createEEFEditorContribution();
			case EditorPackage.STANDARD_FORM_PAGE: return createStandardFormPage();
			case EditorPackage.EEF_MASTER_PAGE: return createEEFMasterPage();
			case EditorPackage.TREE_MASTER_PAGE: return createTreeMasterPage();
			case EditorPackage.ALL_RESOURCES_ROOTS_RELATIVE_INPUT: return createAllResourcesRootsRelativeInput();
			case EditorPackage.FIRST_RESOURCE_ROOT_RELATIVE_INPUT: return createFirstResourceRootRelativeInput();
			case EditorPackage.PART_FILTER: return createPartFilter();
			case EditorPackage.EEF_EDITOR_CONTRIBUTIONS: return createEEFEditorContributions();
			case EditorPackage.EEF_EDITOR_PAGES: return createEEFEditorPages();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFEditorContribution createEEFEditorContribution() {
		EEFEditorContributionImpl eefEditorContribution = new EEFEditorContributionImpl();
		return eefEditorContribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardFormPage createStandardFormPage() {
		StandardFormPageImpl standardFormPage = new StandardFormPageImpl();
		return standardFormPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFMasterPage createEEFMasterPage() {
		EEFMasterPageImpl eefMasterPage = new EEFMasterPageImpl();
		return eefMasterPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeMasterPage createTreeMasterPage() {
		TreeMasterPageImpl treeMasterPage = new TreeMasterPageImpl();
		return treeMasterPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllResourcesRootsRelativeInput createAllResourcesRootsRelativeInput() {
		AllResourcesRootsRelativeInputImpl allResourcesRootsRelativeInput = new AllResourcesRootsRelativeInputImpl();
		return allResourcesRootsRelativeInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FirstResourceRootRelativeInput createFirstResourceRootRelativeInput() {
		FirstResourceRootRelativeInputImpl firstResourceRootRelativeInput = new FirstResourceRootRelativeInputImpl();
		return firstResourceRootRelativeInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartFilter createPartFilter() {
		PartFilterImpl partFilter = new PartFilterImpl();
		return partFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFEditorContributions createEEFEditorContributions() {
		EEFEditorContributionsImpl eefEditorContributions = new EEFEditorContributionsImpl();
		return eefEditorContributions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFEditorPages createEEFEditorPages() {
		EEFEditorPagesImpl eefEditorPages = new EEFEditorPagesImpl();
		return eefEditorPages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorPackage getEditorPackage() {
		return (EditorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EditorPackage getPackage() {
		return EditorPackage.eINSTANCE;
	}

} //EditorFactoryImpl
