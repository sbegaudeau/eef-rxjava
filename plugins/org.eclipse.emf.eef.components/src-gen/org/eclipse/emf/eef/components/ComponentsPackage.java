/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.components;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.eef.mapping.MappingPackage;

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
 * @see org.eclipse.emf.eef.components.ComponentsFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "components";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/eef/components/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eef-components";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsPackage eINSTANCE = org.eclipse.emf.eef.components.impl.ComponentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.components.impl.PropertiesEditionContextImpl <em>Properties Edition Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.components.impl.PropertiesEditionContextImpl
	 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesEditionContext()
	 * @generated
	 */
	int PROPERTIES_EDITION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_CONTEXT__DOCUMENTATION = MappingPackage.DATABINDING__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_CONTEXT__BINDINGS = MappingPackage.DATABINDING__BINDINGS;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_CONTEXT__CATEGORIES = MappingPackage.DATABINDING__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_CONTEXT__MODEL = MappingPackage.DATABINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Properties Edition Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_CONTEXT_FEATURE_COUNT = MappingPackage.DATABINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.components.impl.PropertiesEditionComponentImpl <em>Properties Edition Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.components.impl.PropertiesEditionComponentImpl
	 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesEditionComponent()
	 * @generated
	 */
	int PROPERTIES_EDITION_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__DOCUMENTATION = MappingPackage.EMF_ELEMENT_BINDING__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Sub Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__SUB_ELEMENTS = MappingPackage.EMF_ELEMENT_BINDING__SUB_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__PROPERTIES = MappingPackage.EMF_ELEMENT_BINDING__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Databinding</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__DATABINDING = MappingPackage.EMF_ELEMENT_BINDING__DATABINDING;

	/**
	 * The feature id for the '<em><b>Super Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__SUPER_ELEMENT = MappingPackage.EMF_ELEMENT_BINDING__SUPER_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__NAME = MappingPackage.EMF_ELEMENT_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>Referenced Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__REFERENCED_BINDING = MappingPackage.EMF_ELEMENT_BINDING__REFERENCED_BINDING;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__VIEWS = MappingPackage.EMF_ELEMENT_BINDING__VIEWS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__CATEGORY = MappingPackage.EMF_ELEMENT_BINDING__CATEGORY;

	/**
	 * The feature id for the '<em><b>Binding Filters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__BINDING_FILTERS = MappingPackage.EMF_ELEMENT_BINDING__BINDING_FILTERS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__MODEL = MappingPackage.EMF_ELEMENT_BINDING__MODEL;

	/**
	 * The feature id for the '<em><b>Help ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__HELP_ID = MappingPackage.EMF_ELEMENT_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Explicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT__EXPLICIT = MappingPackage.EMF_ELEMENT_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Properties Edition Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_COMPONENT_FEATURE_COUNT = MappingPackage.EMF_ELEMENT_BINDING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.components.impl.PropertiesEditionElementImpl <em>Properties Edition Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.components.impl.PropertiesEditionElementImpl
	 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesEditionElement()
	 * @generated
	 */
	int PROPERTIES_EDITION_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__DOCUMENTATION = MappingPackage.EMF_PROPERTY_BINDING__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__NAME = MappingPackage.EMF_PROPERTY_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__VIEWS = MappingPackage.EMF_PROPERTY_BINDING__VIEWS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__ELEMENT = MappingPackage.EMF_PROPERTY_BINDING__ELEMENT;

	/**
	 * The feature id for the '<em><b>Binding Filters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__BINDING_FILTERS = MappingPackage.EMF_PROPERTY_BINDING__BINDING_FILTERS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__MODEL = MappingPackage.EMF_PROPERTY_BINDING__MODEL;

	/**
	 * The feature id for the '<em><b>Navigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__NAVIGATION = MappingPackage.EMF_PROPERTY_BINDING__NAVIGATION;

	/**
	 * The feature id for the '<em><b>Help ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT__HELP_ID = MappingPackage.EMF_PROPERTY_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Properties Edition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITION_ELEMENT_FEATURE_COUNT = MappingPackage.EMF_PROPERTY_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.components.impl.PropertiesMultiEditionElementImpl <em>Properties Multi Edition Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.components.impl.PropertiesMultiEditionElementImpl
	 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesMultiEditionElement()
	 * @generated
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__DOCUMENTATION = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__NAME = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__VIEWS = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__VIEWS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__ELEMENT = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__ELEMENT;

	/**
	 * The feature id for the '<em><b>Binding Filters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__BINDING_FILTERS = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__BINDING_FILTERS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__MODEL = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__MODEL;

	/**
	 * The feature id for the '<em><b>Navigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__NAVIGATION = MappingPackage.EMF_MULTI_PROPERTIES_BINDING__NAVIGATION;

	/**
	 * The feature id for the '<em><b>Help ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT__HELP_ID = MappingPackage.EMF_MULTI_PROPERTIES_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Properties Multi Edition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_MULTI_EDITION_ELEMENT_FEATURE_COUNT = MappingPackage.EMF_MULTI_PROPERTIES_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.components.impl.EEFElementImpl <em>EEF Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.components.impl.EEFElementImpl
	 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getEEFElement()
	 * @generated
	 */
	int EEF_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Help ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEF_ELEMENT__HELP_ID = 0;

	/**
	 * The number of structural features of the '<em>EEF Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEF_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.components.PropertiesEditionContext <em>Properties Edition Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Edition Context</em>'.
	 * @see org.eclipse.emf.eef.components.PropertiesEditionContext
	 * @generated
	 */
	EClass getPropertiesEditionContext();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.components.PropertiesEditionContext#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.emf.eef.components.PropertiesEditionContext#getModel()
	 * @see #getPropertiesEditionContext()
	 * @generated
	 */
	EReference getPropertiesEditionContext_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.components.PropertiesEditionComponent <em>Properties Edition Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Edition Component</em>'.
	 * @see org.eclipse.emf.eef.components.PropertiesEditionComponent
	 * @generated
	 */
	EClass getPropertiesEditionComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.components.PropertiesEditionComponent#isExplicit <em>Explicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit</em>'.
	 * @see org.eclipse.emf.eef.components.PropertiesEditionComponent#isExplicit()
	 * @see #getPropertiesEditionComponent()
	 * @generated
	 */
	EAttribute getPropertiesEditionComponent_Explicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.components.PropertiesEditionElement <em>Properties Edition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Edition Element</em>'.
	 * @see org.eclipse.emf.eef.components.PropertiesEditionElement
	 * @generated
	 */
	EClass getPropertiesEditionElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.components.PropertiesMultiEditionElement <em>Properties Multi Edition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Multi Edition Element</em>'.
	 * @see org.eclipse.emf.eef.components.PropertiesMultiEditionElement
	 * @generated
	 */
	EClass getPropertiesMultiEditionElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.components.EEFElement <em>EEF Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEF Element</em>'.
	 * @see org.eclipse.emf.eef.components.EEFElement
	 * @generated
	 */
	EClass getEEFElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.components.EEFElement#getHelpID <em>Help ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Help ID</em>'.
	 * @see org.eclipse.emf.eef.components.EEFElement#getHelpID()
	 * @see #getEEFElement()
	 * @generated
	 */
	EAttribute getEEFElement_HelpID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentsFactory getComponentsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.eef.components.impl.PropertiesEditionContextImpl <em>Properties Edition Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.components.impl.PropertiesEditionContextImpl
		 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesEditionContext()
		 * @generated
		 */
		EClass PROPERTIES_EDITION_CONTEXT = eINSTANCE.getPropertiesEditionContext();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_EDITION_CONTEXT__MODEL = eINSTANCE.getPropertiesEditionContext_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.components.impl.PropertiesEditionComponentImpl <em>Properties Edition Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.components.impl.PropertiesEditionComponentImpl
		 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesEditionComponent()
		 * @generated
		 */
		EClass PROPERTIES_EDITION_COMPONENT = eINSTANCE.getPropertiesEditionComponent();

		/**
		 * The meta object literal for the '<em><b>Explicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_EDITION_COMPONENT__EXPLICIT = eINSTANCE
				.getPropertiesEditionComponent_Explicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.components.impl.PropertiesEditionElementImpl <em>Properties Edition Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.components.impl.PropertiesEditionElementImpl
		 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesEditionElement()
		 * @generated
		 */
		EClass PROPERTIES_EDITION_ELEMENT = eINSTANCE.getPropertiesEditionElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.components.impl.PropertiesMultiEditionElementImpl <em>Properties Multi Edition Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.components.impl.PropertiesMultiEditionElementImpl
		 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getPropertiesMultiEditionElement()
		 * @generated
		 */
		EClass PROPERTIES_MULTI_EDITION_ELEMENT = eINSTANCE.getPropertiesMultiEditionElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.components.impl.EEFElementImpl <em>EEF Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.components.impl.EEFElementImpl
		 * @see org.eclipse.emf.eef.components.impl.ComponentsPackageImpl#getEEFElement()
		 * @generated
		 */
		EClass EEF_ELEMENT = eINSTANCE.getEEFElement();

		/**
		 * The meta object literal for the '<em><b>Help ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EEF_ELEMENT__HELP_ID = eINSTANCE.getEEFElement_HelpID();

	}

} //ComponentsPackage
