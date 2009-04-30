/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EEFGenPackageImpl.java,v 1.1 2009/04/30 17:11:46 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.eef.EEFGen.EEFGenFactory;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;

import org.eclipse.emf.eef.components.ComponentsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EEFGenPackageImpl extends EPackageImpl implements EEFGenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genEditionContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum helP_STRATEGYEEnum = null;

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
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EEFGenPackageImpl() {
		super(eNS_URI, EEFGenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EEFGenPackage init() {
		if (isInited) return (EEFGenPackage)EPackage.Registry.INSTANCE.getEPackage(EEFGenPackage.eNS_URI);

		// Obtain or create and register package
		EEFGenPackageImpl theEEFGenPackage = (EEFGenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EEFGenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EEFGenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ComponentsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEEFGenPackage.createPackageContents();

		// Initialize created meta-data
		theEEFGenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEEFGenPackage.freeze();

		return theEEFGenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenEditionContext() {
		return genEditionContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenEditionContext_PropertiesEditionContext() {
		return (EReference)genEditionContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_BasePackage() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_GenDirectory() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_SwtViews() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_FormViews() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_DescriptorsGenericPropertiesViews() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_GmfPropertiesViews() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_HelpStrategy() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_DescriptorsContributorID() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_Author() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenEditionContext_License() {
		return (EAttribute)genEditionContextEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHELP_STRATEGY() {
		return helP_STRATEGYEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFGenFactory getEEFGenFactory() {
		return (EEFGenFactory)getEFactoryInstance();
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
		genEditionContextEClass = createEClass(GEN_EDITION_CONTEXT);
		createEReference(genEditionContextEClass, GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__BASE_PACKAGE);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__GEN_DIRECTORY);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__SWT_VIEWS);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__FORM_VIEWS);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__HELP_STRATEGY);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__AUTHOR);
		createEAttribute(genEditionContextEClass, GEN_EDITION_CONTEXT__LICENSE);

		// Create enums
		helP_STRATEGYEEnum = createEEnum(HELP_STRATEGY);
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
		ComponentsPackage theComponentsPackage = (ComponentsPackage)EPackage.Registry.INSTANCE.getEPackage(ComponentsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(genEditionContextEClass, GenEditionContext.class, "GenEditionContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenEditionContext_PropertiesEditionContext(), theComponentsPackage.getPropertiesEditionContext(), null, "PropertiesEditionContext", null, 1, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_BasePackage(), ecorePackage.getEString(), "basePackage", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_GenDirectory(), ecorePackage.getEString(), "genDirectory", null, 1, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_SwtViews(), ecorePackage.getEBoolean(), "swtViews", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_FormViews(), ecorePackage.getEBoolean(), "formViews", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_DescriptorsGenericPropertiesViews(), ecorePackage.getEBoolean(), "descriptorsGenericPropertiesViews", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_GmfPropertiesViews(), ecorePackage.getEBoolean(), "gmfPropertiesViews", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_HelpStrategy(), this.getHELP_STRATEGY(), "helpStrategy", null, 1, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_DescriptorsContributorID(), ecorePackage.getEString(), "descriptorsContributorID", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_Author(), ecorePackage.getEString(), "author", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenEditionContext_License(), ecorePackage.getEString(), "license", null, 0, 1, GenEditionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(helP_STRATEGYEEnum, org.eclipse.emf.eef.EEFGen.HELP_STRATEGY.class, "HELP_STRATEGY");
		addEEnumLiteral(helP_STRATEGYEEnum, org.eclipse.emf.eef.EEFGen.HELP_STRATEGY.GENMODEL);
		addEEnumLiteral(helP_STRATEGYEEnum, org.eclipse.emf.eef.EEFGen.HELP_STRATEGY.ECOREMODEL);

		// Create resource
		createResource(eNS_URI);
	}

} //EEFGenPackageImpl
