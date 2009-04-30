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
 * $Id: ComponentsFactory.java,v 1.1 2009/04/30 17:08:53 glefur Exp $
 */
package org.eclipse.emf.eef.components;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.components.ComponentsPackage
 * @generated
 */
public interface ComponentsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsFactory eINSTANCE = org.eclipse.emf.eef.components.impl.ComponentsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Properties Edition Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Properties Edition Context</em>'.
	 * @generated
	 */
	PropertiesEditionContext createPropertiesEditionContext();

	/**
	 * Returns a new object of class '<em>Properties Edition Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Properties Edition Component</em>'.
	 * @generated
	 */
	PropertiesEditionComponent createPropertiesEditionComponent();

	/**
	 * Returns a new object of class '<em>Properties Edition Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Properties Edition Element</em>'.
	 * @generated
	 */
	PropertiesEditionElement createPropertiesEditionElement();

	/**
	 * Returns a new object of class '<em>Properties Multi Edition Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Properties Multi Edition Element</em>'.
	 * @generated
	 */
	PropertiesMultiEditionElement createPropertiesMultiEditionElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComponentsPackage getComponentsPackage();

} //ComponentsFactory
