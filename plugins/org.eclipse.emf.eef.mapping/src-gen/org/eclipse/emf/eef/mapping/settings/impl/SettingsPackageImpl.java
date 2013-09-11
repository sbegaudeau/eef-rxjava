/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.mapping.settings.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.eef.mapping.MappingPackage;

import org.eclipse.emf.eef.mapping.filters.FiltersPackage;

import org.eclipse.emf.eef.mapping.filters.impl.FiltersPackageImpl;

import org.eclipse.emf.eef.mapping.impl.MappingPackageImpl;

import org.eclipse.emf.eef.mapping.navigation.NavigationPackage;

import org.eclipse.emf.eef.mapping.navigation.impl.NavigationPackageImpl;

import org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings;
import org.eclipse.emf.eef.mapping.settings.EditorSettings;
import org.eclipse.emf.eef.mapping.settings.SettingsFactory;
import org.eclipse.emf.eef.mapping.settings.SettingsPackage;

import org.eclipse.emf.eef.views.ViewsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SettingsPackageImpl extends EPackageImpl implements
		SettingsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReferenceViewerSettingsEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.eef.mapping.settings.SettingsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SettingsPackageImpl() {
		super(eNS_URI, SettingsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SettingsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SettingsPackage init() {
		if (isInited)
			return (SettingsPackage) EPackage.Registry.INSTANCE
					.getEPackage(SettingsPackage.eNS_URI);

		// Obtain or create and register package
		SettingsPackageImpl theSettingsPackage = (SettingsPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof SettingsPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new SettingsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ViewsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MappingPackageImpl theMappingPackage = (MappingPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		NavigationPackageImpl theNavigationPackage = (NavigationPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(NavigationPackage.eNS_URI) instanceof NavigationPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(NavigationPackage.eNS_URI)
				: NavigationPackage.eINSTANCE);
		FiltersPackageImpl theFiltersPackage = (FiltersPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(FiltersPackage.eNS_URI) instanceof FiltersPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(FiltersPackage.eNS_URI) : FiltersPackage.eINSTANCE);

		// Create package meta-data objects
		theSettingsPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theNavigationPackage.createPackageContents();
		theFiltersPackage.createPackageContents();

		// Initialize created meta-data
		theSettingsPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theNavigationPackage.initializePackageContents();
		theFiltersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSettingsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SettingsPackage.eNS_URI,
				theSettingsPackage);
		return theSettingsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditorSettings() {
		return editorSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEReferenceViewerSettings() {
		return eReferenceViewerSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceViewerSettings_Model() {
		return (EReference) eReferenceViewerSettingsEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceViewerSettings_Filter() {
		return (EReference) eReferenceViewerSettingsEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingsFactory getSettingsFactory() {
		return (SettingsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		editorSettingsEClass = createEClass(EDITOR_SETTINGS);

		eReferenceViewerSettingsEClass = createEClass(EREFERENCE_VIEWER_SETTINGS);
		createEReference(eReferenceViewerSettingsEClass,
				EREFERENCE_VIEWER_SETTINGS__MODEL);
		createEReference(eReferenceViewerSettingsEClass,
				EREFERENCE_VIEWER_SETTINGS__FILTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		FiltersPackage theFiltersPackage = (FiltersPackage) EPackage.Registry.INSTANCE
				.getEPackage(FiltersPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eReferenceViewerSettingsEClass.getESuperTypes().add(
				this.getEditorSettings());

		// Initialize classes and features; add operations and parameters
		initEClass(editorSettingsEClass, EditorSettings.class,
				"EditorSettings", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(eReferenceViewerSettingsEClass,
				EReferenceViewerSettings.class, "EReferenceViewerSettings",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEReferenceViewerSettings_Model(),
				theEcorePackage.getEReference(), null, "model", null, 1, 1,
				EReferenceViewerSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEReferenceViewerSettings_Filter(),
				theFiltersPackage.getStepFilter(), null, "filter", null, 0, 1,
				EReferenceViewerSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //SettingsPackageImpl
