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
 * $Id: EEFGenPackage.java,v 1.1 2009/04/30 17:11:46 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.EEFGen.EEFGenFactory
 * @model kind="package"
 * @generated
 */
public interface EEFGenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EEFGen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/eef/generation/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eef-gen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EEFGenPackage eINSTANCE = org.eclipse.emf.eef.EEFGen.impl.EEFGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl <em>Gen Edition Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl
	 * @see org.eclipse.emf.eef.EEFGen.impl.EEFGenPackageImpl#getGenEditionContext()
	 * @generated
	 */
	int GEN_EDITION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Properties Edition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__BASE_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Gen Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__GEN_DIRECTORY = 2;

	/**
	 * The feature id for the '<em><b>Swt Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__SWT_VIEWS = 3;

	/**
	 * The feature id for the '<em><b>Form Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__FORM_VIEWS = 4;

	/**
	 * The feature id for the '<em><b>Descriptors Generic Properties Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS = 5;

	/**
	 * The feature id for the '<em><b>Gmf Properties Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS = 6;

	/**
	 * The feature id for the '<em><b>Help Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__HELP_STRATEGY = 7;

	/**
	 * The feature id for the '<em><b>Descriptors Contributor ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID = 8;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__AUTHOR = 9;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT__LICENSE = 10;

	/**
	 * The number of structural features of the '<em>Gen Edition Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_EDITION_CONTEXT_FEATURE_COUNT = 11;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.EEFGen.HELP_STRATEGY <em>HELP STRATEGY</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.EEFGen.HELP_STRATEGY
	 * @see org.eclipse.emf.eef.EEFGen.impl.EEFGenPackageImpl#getHELP_STRATEGY()
	 * @generated
	 */
	int HELP_STRATEGY = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext <em>Gen Edition Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Edition Context</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext
	 * @generated
	 */
	EClass getGenEditionContext();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getPropertiesEditionContext <em>Properties Edition Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Properties Edition Context</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getPropertiesEditionContext()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EReference getGenEditionContext_PropertiesEditionContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getBasePackage <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Package</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getBasePackage()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_BasePackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getGenDirectory <em>Gen Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gen Directory</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getGenDirectory()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_GenDirectory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isSwtViews <em>Swt Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Swt Views</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#isSwtViews()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_SwtViews();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isFormViews <em>Form Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Form Views</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#isFormViews()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_FormViews();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isDescriptorsGenericPropertiesViews <em>Descriptors Generic Properties Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descriptors Generic Properties Views</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#isDescriptorsGenericPropertiesViews()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_DescriptorsGenericPropertiesViews();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isGmfPropertiesViews <em>Gmf Properties Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gmf Properties Views</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#isGmfPropertiesViews()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_GmfPropertiesViews();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getHelpStrategy <em>Help Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Help Strategy</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getHelpStrategy()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_HelpStrategy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getDescriptorsContributorID <em>Descriptors Contributor ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descriptors Contributor ID</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getDescriptorsContributorID()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_DescriptorsContributorID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getAuthor()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.GenEditionContext#getLicense()
	 * @see #getGenEditionContext()
	 * @generated
	 */
	EAttribute getGenEditionContext_License();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.eef.EEFGen.HELP_STRATEGY <em>HELP STRATEGY</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HELP STRATEGY</em>'.
	 * @see org.eclipse.emf.eef.EEFGen.HELP_STRATEGY
	 * @generated
	 */
	EEnum getHELP_STRATEGY();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EEFGenFactory getEEFGenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl <em>Gen Edition Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl
		 * @see org.eclipse.emf.eef.EEFGen.impl.EEFGenPackageImpl#getGenEditionContext()
		 * @generated
		 */
		EClass GEN_EDITION_CONTEXT = eINSTANCE.getGenEditionContext();

		/**
		 * The meta object literal for the '<em><b>Properties Edition Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT = eINSTANCE.getGenEditionContext_PropertiesEditionContext();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__BASE_PACKAGE = eINSTANCE.getGenEditionContext_BasePackage();

		/**
		 * The meta object literal for the '<em><b>Gen Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__GEN_DIRECTORY = eINSTANCE.getGenEditionContext_GenDirectory();

		/**
		 * The meta object literal for the '<em><b>Swt Views</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__SWT_VIEWS = eINSTANCE.getGenEditionContext_SwtViews();

		/**
		 * The meta object literal for the '<em><b>Form Views</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__FORM_VIEWS = eINSTANCE.getGenEditionContext_FormViews();

		/**
		 * The meta object literal for the '<em><b>Descriptors Generic Properties Views</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS = eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews();

		/**
		 * The meta object literal for the '<em><b>Gmf Properties Views</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS = eINSTANCE.getGenEditionContext_GmfPropertiesViews();

		/**
		 * The meta object literal for the '<em><b>Help Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__HELP_STRATEGY = eINSTANCE.getGenEditionContext_HelpStrategy();

		/**
		 * The meta object literal for the '<em><b>Descriptors Contributor ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID = eINSTANCE.getGenEditionContext_DescriptorsContributorID();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__AUTHOR = eINSTANCE.getGenEditionContext_Author();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_EDITION_CONTEXT__LICENSE = eINSTANCE.getGenEditionContext_License();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.EEFGen.HELP_STRATEGY <em>HELP STRATEGY</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.EEFGen.HELP_STRATEGY
		 * @see org.eclipse.emf.eef.EEFGen.impl.EEFGenPackageImpl#getHELP_STRATEGY()
		 * @generated
		 */
		EEnum HELP_STRATEGY = eINSTANCE.getHELP_STRATEGY();

	}

} //EEFGenPackage
