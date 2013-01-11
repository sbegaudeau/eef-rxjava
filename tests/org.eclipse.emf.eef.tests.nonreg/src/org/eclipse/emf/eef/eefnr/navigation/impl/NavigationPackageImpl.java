/**
 * <copyright>
 * </copyright>
 *
 * $Id: NavigationPackageImpl.java,v 1.7 2011/11/14 14:00:00 sbouchet Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.filters.FiltersPackage;
import org.eclipse.emf.eef.eefnr.filters.impl.FiltersPackageImpl;
import org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl;
import org.eclipse.emf.eef.eefnr.interface_.InterfacePackage;
import org.eclipse.emf.eef.eefnr.interface_.impl.InterfacePackageImpl;
import org.eclipse.emf.eef.eefnr.naming.CustomNamingPackage;
import org.eclipse.emf.eef.eefnr.naming.impl.CustomNamingPackageImpl;
import org.eclipse.emf.eef.eefnr.navigation.AnotherSubType;
import org.eclipse.emf.eef.eefnr.navigation.AttributeDelegate;
import org.eclipse.emf.eef.eefnr.navigation.AttributeNavigationSample;
import org.eclipse.emf.eef.eefnr.navigation.DeferedFlatReferenceTableEditorSample;
import org.eclipse.emf.eef.eefnr.navigation.DeferedReference;
import org.eclipse.emf.eef.eefnr.navigation.DeferedReferenceTableEditorSample;
import org.eclipse.emf.eef.eefnr.navigation.Element;
import org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.MultipleReferencer;
import org.eclipse.emf.eef.eefnr.navigation.NavigationFactory;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.Owner;
import org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.SingleReferencer;
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;
import org.eclipse.emf.eef.eefnr.navigation.Subtype;
import org.eclipse.emf.eef.eefnr.references.ReferencesPackage;
import org.eclipse.emf.eef.eefnr.references.impl.ReferencesPackageImpl;
import org.eclipse.emf.eef.eefnrext.EefnrextPackage;
import org.eclipse.emf.eef.eefnrext.impl.EefnrextPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NavigationPackageImpl extends EPackageImpl implements NavigationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deferedFlatReferenceTableEditorSampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deferedReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deferedReferenceTableEditorSampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ownerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleReferencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anotherSubTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNavigationSampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDelegateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smartModelNavigationSampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass firstModelNavigationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass secondModelNavigationEClass = null;

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
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NavigationPackageImpl() {
		super(eNS_URI, NavigationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NavigationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NavigationPackage init() {
		if (isInited) return (NavigationPackage)EPackage.Registry.INSTANCE.getEPackage(NavigationPackage.eNS_URI);

		// Obtain or create and register package
		NavigationPackageImpl theNavigationPackage = (NavigationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NavigationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NavigationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EefnrPackageImpl theEefnrPackage = (EefnrPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EefnrPackage.eNS_URI) instanceof EefnrPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EefnrPackage.eNS_URI) : EefnrPackage.eINSTANCE);
		ReferencesPackageImpl theReferencesPackage = (ReferencesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI) instanceof ReferencesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI) : ReferencesPackage.eINSTANCE);
		FiltersPackageImpl theFiltersPackage = (FiltersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FiltersPackage.eNS_URI) instanceof FiltersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FiltersPackage.eNS_URI) : FiltersPackage.eINSTANCE);
		CustomNamingPackageImpl theCustomNamingPackage = (CustomNamingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CustomNamingPackage.eNS_URI) instanceof CustomNamingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CustomNamingPackage.eNS_URI) : CustomNamingPackage.eINSTANCE);
		InterfacePackageImpl theInterfacePackage = (InterfacePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InterfacePackage.eNS_URI) instanceof InterfacePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InterfacePackage.eNS_URI) : InterfacePackage.eINSTANCE);
		EefnrextPackageImpl theEefnrextPackage = (EefnrextPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EefnrextPackage.eNS_URI) instanceof EefnrextPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EefnrextPackage.eNS_URI) : EefnrextPackage.eINSTANCE);

		// Create package meta-data objects
		theNavigationPackage.createPackageContents();
		theEefnrPackage.createPackageContents();
		theReferencesPackage.createPackageContents();
		theFiltersPackage.createPackageContents();
		theCustomNamingPackage.createPackageContents();
		theInterfacePackage.createPackageContents();
		theEefnrextPackage.createPackageContents();

		// Initialize created meta-data
		theNavigationPackage.initializePackageContents();
		theEefnrPackage.initializePackageContents();
		theReferencesPackage.initializePackageContents();
		theFiltersPackage.initializePackageContents();
		theCustomNamingPackage.initializePackageContents();
		theInterfacePackage.initializePackageContents();
		theEefnrextPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNavigationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NavigationPackage.eNS_URI, theNavigationPackage);
		return theNavigationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeferedFlatReferenceTableEditorSample() {
		return deferedFlatReferenceTableEditorSampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferedFlatReferenceTableEditorSample_References() {
		return (EReference)deferedFlatReferenceTableEditorSampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeferedReference() {
		return deferedReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferedReference_FlatreferenceEditor() {
		return (EReference)deferedReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeferedReferenceTableEditorSample() {
		return deferedReferenceTableEditorSampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferedReferenceTableEditorSample_References() {
		return (EReference)deferedReferenceTableEditorSampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOwner() {
		return ownerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOwner_MultipleReferencers() {
		return (EReference)ownerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOwner_SingleReferencers() {
		return (EReference)ownerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleReferencer() {
		return multipleReferencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleReferencer_MultipleSampleForTableComposition() {
		return (EReference)multipleReferencerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleReferencer_MultipleSampleForAdvancedTableComposition() {
		return (EReference)multipleReferencerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleReferencer_MultipleSampleForReferencesTable() {
		return (EReference)multipleReferencerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleReferencer_MultipleSampleAdvancedReferencesTable() {
		return (EReference)multipleReferencerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleReferencer_MultipleSampleForFlatReferencesTable() {
		return (EReference)multipleReferencerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubtype() {
		return subtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubtype_SpecialisedElement() {
		return (EAttribute)subtypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferencer() {
		return singleReferencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleSampleForTableComposition() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleSampleForAdvancedTableComposition() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleSampleForReferencesTable() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleSampleAdvancedReferencesTable() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleSampleForFlatReferencesTable() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleContainmentForEObjectFlatComboViewer() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleReferenceForEObjectFlatComboViewer() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleContainmentForAdvancedEObjectFlatComboViewer() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferencer_SingleReferenceForAdvancedEObjectFlatComboViewer() {
		return (EReference)singleReferencerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleReferencer_BooleanAttribute() {
		return (EAttribute)singleReferencerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleReferencer_EenumAttribute() {
		return (EAttribute)singleReferencerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleReferencer_StringAttribute() {
		return (EAttribute)singleReferencerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleReferencer_ListAttribute() {
		return (EAttribute)singleReferencerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnotherSubType() {
		return anotherSubTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnotherSubType_AnotherSpecialisation() {
		return (EAttribute)anotherSubTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Visible() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeNavigationSample() {
		return attributeNavigationSampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeNavigationSample_SingleValuedAttributeDelegate() {
		return (EReference)attributeNavigationSampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeNavigationSample_MultiValuedAttributeDelegate() {
		return (EReference)attributeNavigationSampleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeDelegate() {
		return attributeDelegateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeDelegate_Delegate1() {
		return (EAttribute)attributeDelegateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeDelegate_Delegate2() {
		return (EAttribute)attributeDelegateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmartModelNavigationSample() {
		return smartModelNavigationSampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartModelNavigationSample_FirstModelNavigation() {
		return (EReference)smartModelNavigationSampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartModelNavigationSample_SeveralFirstModelNavigation() {
		return (EReference)smartModelNavigationSampleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartModelNavigationSample_FirstModelNavigation2() {
		return (EReference)smartModelNavigationSampleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartModelNavigationSample_SeveralFirstModelNavigation2() {
		return (EReference)smartModelNavigationSampleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFirstModelNavigation() {
		return firstModelNavigationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirstModelNavigation_SecondModelNavigation() {
		return (EReference)firstModelNavigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirstModelNavigation_SeveralSecondModelNavigation() {
		return (EReference)firstModelNavigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirstModelNavigation_Filter1() {
		return (EAttribute)firstModelNavigationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirstModelNavigation_Filter2() {
		return (EAttribute)firstModelNavigationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecondModelNavigation() {
		return secondModelNavigationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecondModelNavigation_Filter3() {
		return (EAttribute)secondModelNavigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecondModelNavigation_Filter4() {
		return (EAttribute)secondModelNavigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationFactory getNavigationFactory() {
		return (NavigationFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		deferedFlatReferenceTableEditorSampleEClass = createEClass(DEFERED_FLAT_REFERENCE_TABLE_EDITOR_SAMPLE);
		createEReference(deferedFlatReferenceTableEditorSampleEClass, DEFERED_FLAT_REFERENCE_TABLE_EDITOR_SAMPLE__REFERENCES);

		deferedReferenceEClass = createEClass(DEFERED_REFERENCE);
		createEReference(deferedReferenceEClass, DEFERED_REFERENCE__FLATREFERENCE_EDITOR);

		deferedReferenceTableEditorSampleEClass = createEClass(DEFERED_REFERENCE_TABLE_EDITOR_SAMPLE);
		createEReference(deferedReferenceTableEditorSampleEClass, DEFERED_REFERENCE_TABLE_EDITOR_SAMPLE__REFERENCES);

		ownerEClass = createEClass(OWNER);
		createEReference(ownerEClass, OWNER__MULTIPLE_REFERENCERS);
		createEReference(ownerEClass, OWNER__SINGLE_REFERENCERS);

		multipleReferencerEClass = createEClass(MULTIPLE_REFERENCER);
		createEReference(multipleReferencerEClass, MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION);
		createEReference(multipleReferencerEClass, MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION);
		createEReference(multipleReferencerEClass, MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE);
		createEReference(multipleReferencerEClass, MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE);
		createEReference(multipleReferencerEClass, MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE);

		subtypeEClass = createEClass(SUBTYPE);
		createEAttribute(subtypeEClass, SUBTYPE__SPECIALISED_ELEMENT);

		singleReferencerEClass = createEClass(SINGLE_REFERENCER);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_SAMPLE_FOR_TABLE_COMPOSITION);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_SAMPLE_FOR_REFERENCES_TABLE);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_SAMPLE_ADVANCED_REFERENCES_TABLE);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_CONTAINMENT_FOR_EOBJECT_FLAT_COMBO_VIEWER);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_REFERENCE_FOR_EOBJECT_FLAT_COMBO_VIEWER);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_CONTAINMENT_FOR_ADVANCED_EOBJECT_FLAT_COMBO_VIEWER);
		createEReference(singleReferencerEClass, SINGLE_REFERENCER__SINGLE_REFERENCE_FOR_ADVANCED_EOBJECT_FLAT_COMBO_VIEWER);
		createEAttribute(singleReferencerEClass, SINGLE_REFERENCER__BOOLEAN_ATTRIBUTE);
		createEAttribute(singleReferencerEClass, SINGLE_REFERENCER__EENUM_ATTRIBUTE);
		createEAttribute(singleReferencerEClass, SINGLE_REFERENCER__STRING_ATTRIBUTE);
		createEAttribute(singleReferencerEClass, SINGLE_REFERENCER__LIST_ATTRIBUTE);

		anotherSubTypeEClass = createEClass(ANOTHER_SUB_TYPE);
		createEAttribute(anotherSubTypeEClass, ANOTHER_SUB_TYPE__ANOTHER_SPECIALISATION);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__VISIBLE);

		attributeNavigationSampleEClass = createEClass(ATTRIBUTE_NAVIGATION_SAMPLE);
		createEReference(attributeNavigationSampleEClass, ATTRIBUTE_NAVIGATION_SAMPLE__SINGLE_VALUED_ATTRIBUTE_DELEGATE);
		createEReference(attributeNavigationSampleEClass, ATTRIBUTE_NAVIGATION_SAMPLE__MULTI_VALUED_ATTRIBUTE_DELEGATE);

		attributeDelegateEClass = createEClass(ATTRIBUTE_DELEGATE);
		createEAttribute(attributeDelegateEClass, ATTRIBUTE_DELEGATE__DELEGATE1);
		createEAttribute(attributeDelegateEClass, ATTRIBUTE_DELEGATE__DELEGATE2);

		smartModelNavigationSampleEClass = createEClass(SMART_MODEL_NAVIGATION_SAMPLE);
		createEReference(smartModelNavigationSampleEClass, SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION);
		createEReference(smartModelNavigationSampleEClass, SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION);
		createEReference(smartModelNavigationSampleEClass, SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2);
		createEReference(smartModelNavigationSampleEClass, SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2);

		firstModelNavigationEClass = createEClass(FIRST_MODEL_NAVIGATION);
		createEReference(firstModelNavigationEClass, FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION);
		createEReference(firstModelNavigationEClass, FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION);
		createEAttribute(firstModelNavigationEClass, FIRST_MODEL_NAVIGATION__FILTER1);
		createEAttribute(firstModelNavigationEClass, FIRST_MODEL_NAVIGATION__FILTER2);

		secondModelNavigationEClass = createEClass(SECOND_MODEL_NAVIGATION);
		createEAttribute(secondModelNavigationEClass, SECOND_MODEL_NAVIGATION__FILTER3);
		createEAttribute(secondModelNavigationEClass, SECOND_MODEL_NAVIGATION__FILTER4);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EefnrPackage theEefnrPackage = (EefnrPackage)EPackage.Registry.INSTANCE.getEPackage(EefnrPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		deferedFlatReferenceTableEditorSampleEClass.getESuperTypes().add(theEefnrPackage.getAbstractSample());
		deferedReferenceTableEditorSampleEClass.getESuperTypes().add(theEefnrPackage.getAbstractSample());
		ownerEClass.getESuperTypes().add(theEefnrPackage.getAbstractSample());
		subtypeEClass.getESuperTypes().add(this.getOwner());
		anotherSubTypeEClass.getESuperTypes().add(this.getSubtype());
		elementEClass.getESuperTypes().add(theEefnrPackage.getNamedElement());
		attributeNavigationSampleEClass.getESuperTypes().add(theEefnrPackage.getAbstractSample());
		smartModelNavigationSampleEClass.getESuperTypes().add(theEefnrPackage.getNamedElement());
		firstModelNavigationEClass.getESuperTypes().add(theEefnrPackage.getNamedElement());
		secondModelNavigationEClass.getESuperTypes().add(theEefnrPackage.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(deferedFlatReferenceTableEditorSampleEClass, DeferedFlatReferenceTableEditorSample.class, "DeferedFlatReferenceTableEditorSample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeferedFlatReferenceTableEditorSample_References(), this.getDeferedReference(), null, "references", null, 0, -1, DeferedFlatReferenceTableEditorSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deferedReferenceEClass, DeferedReference.class, "DeferedReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeferedReference_FlatreferenceEditor(), theEefnrPackage.getTotalSample(), null, "flatreferenceEditor", null, 1, 1, DeferedReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deferedReferenceTableEditorSampleEClass, DeferedReferenceTableEditorSample.class, "DeferedReferenceTableEditorSample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeferedReferenceTableEditorSample_References(), this.getDeferedReference(), null, "references", null, 0, -1, DeferedReferenceTableEditorSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ownerEClass, Owner.class, "Owner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOwner_MultipleReferencers(), this.getMultipleReferencer(), null, "multipleReferencers", null, 0, -1, Owner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOwner_SingleReferencers(), this.getSingleReferencer(), null, "singleReferencers", null, 0, 1, Owner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleReferencerEClass, MultipleReferencer.class, "MultipleReferencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultipleReferencer_MultipleSampleForTableComposition(), this.getOwner(), null, "multipleSampleForTableComposition", null, 0, 1, MultipleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultipleReferencer_MultipleSampleForAdvancedTableComposition(), this.getOwner(), null, "multipleSampleForAdvancedTableComposition", null, 0, 1, MultipleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultipleReferencer_MultipleSampleForReferencesTable(), this.getOwner(), null, "multipleSampleForReferencesTable", null, 0, 1, MultipleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultipleReferencer_MultipleSampleAdvancedReferencesTable(), this.getOwner(), null, "multipleSampleAdvancedReferencesTable", null, 0, 1, MultipleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultipleReferencer_MultipleSampleForFlatReferencesTable(), this.getOwner(), null, "multipleSampleForFlatReferencesTable", null, 0, 1, MultipleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subtypeEClass, Subtype.class, "Subtype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubtype_SpecialisedElement(), ecorePackage.getEBoolean(), "specialisedElement", null, 0, 1, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleReferencerEClass, SingleReferencer.class, "SingleReferencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferencer_SingleSampleForTableComposition(), this.getOwner(), null, "singleSampleForTableComposition", null, 0, -1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleSampleForAdvancedTableComposition(), this.getOwner(), null, "singleSampleForAdvancedTableComposition", null, 0, -1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleSampleForReferencesTable(), this.getOwner(), null, "singleSampleForReferencesTable", null, 0, -1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleSampleAdvancedReferencesTable(), this.getOwner(), null, "singleSampleAdvancedReferencesTable", null, 0, -1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleSampleForFlatReferencesTable(), this.getOwner(), null, "singleSampleForFlatReferencesTable", null, 0, -1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleContainmentForEObjectFlatComboViewer(), this.getOwner(), null, "singleContainmentForEObjectFlatComboViewer", null, 0, 1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleReferenceForEObjectFlatComboViewer(), this.getOwner(), null, "singleReferenceForEObjectFlatComboViewer", null, 0, 1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleContainmentForAdvancedEObjectFlatComboViewer(), this.getOwner(), null, "singleContainmentForAdvancedEObjectFlatComboViewer", null, 0, 1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferencer_SingleReferenceForAdvancedEObjectFlatComboViewer(), this.getOwner(), null, "singleReferenceForAdvancedEObjectFlatComboViewer", null, 0, 1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleReferencer_BooleanAttribute(), ecorePackage.getEBoolean(), "booleanAttribute", null, 0, 1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleReferencer_EenumAttribute(), ecorePackage.getEEnumerator(), "eenumAttribute", null, 0, 1, SingleReferencer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleReferencer_StringAttribute(), ecorePackage.getEString(), "stringAttribute", null, 0, 1, SingleReferencer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getSingleReferencer_ListAttribute(), g1, "listAttribute", null, 0, 1, SingleReferencer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anotherSubTypeEClass, AnotherSubType.class, "AnotherSubType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnotherSubType_AnotherSpecialisation(), ecorePackage.getEBoolean(), "anotherSpecialisation", null, 0, 1, AnotherSubType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Visible(), ecorePackage.getEBoolean(), "visible", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeNavigationSampleEClass, AttributeNavigationSample.class, "AttributeNavigationSample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeNavigationSample_SingleValuedAttributeDelegate(), this.getAttributeDelegate(), null, "singleValuedAttributeDelegate", null, 0, 1, AttributeNavigationSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeNavigationSample_MultiValuedAttributeDelegate(), this.getAttributeDelegate(), null, "multiValuedAttributeDelegate", null, 0, -1, AttributeNavigationSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeDelegateEClass, AttributeDelegate.class, "AttributeDelegate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeDelegate_Delegate1(), ecorePackage.getEString(), "delegate1", null, 1, 1, AttributeDelegate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeDelegate_Delegate2(), ecorePackage.getEInt(), "delegate2", null, 0, 1, AttributeDelegate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smartModelNavigationSampleEClass, SmartModelNavigationSample.class, "SmartModelNavigationSample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmartModelNavigationSample_FirstModelNavigation(), this.getFirstModelNavigation(), null, "firstModelNavigation", null, 0, 1, SmartModelNavigationSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartModelNavigationSample_SeveralFirstModelNavigation(), this.getFirstModelNavigation(), null, "severalFirstModelNavigation", null, 0, -1, SmartModelNavigationSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartModelNavigationSample_FirstModelNavigation2(), this.getFirstModelNavigation(), null, "firstModelNavigation2", null, 0, 1, SmartModelNavigationSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartModelNavigationSample_SeveralFirstModelNavigation2(), this.getFirstModelNavigation(), null, "severalFirstModelNavigation2", null, 0, -1, SmartModelNavigationSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(firstModelNavigationEClass, FirstModelNavigation.class, "FirstModelNavigation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFirstModelNavigation_SecondModelNavigation(), this.getSecondModelNavigation(), null, "secondModelNavigation", null, 0, 1, FirstModelNavigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFirstModelNavigation_SeveralSecondModelNavigation(), this.getSecondModelNavigation(), null, "severalSecondModelNavigation", null, 0, -1, FirstModelNavigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFirstModelNavigation_Filter1(), ecorePackage.getEBoolean(), "filter1", null, 0, 1, FirstModelNavigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFirstModelNavigation_Filter2(), ecorePackage.getEBoolean(), "filter2", null, 0, 1, FirstModelNavigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(secondModelNavigationEClass, SecondModelNavigation.class, "SecondModelNavigation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecondModelNavigation_Filter3(), ecorePackage.getEBoolean(), "filter3", null, 0, 1, SecondModelNavigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecondModelNavigation_Filter4(), ecorePackage.getEBoolean(), "filter4", null, 0, 1, SecondModelNavigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //NavigationPackageImpl
