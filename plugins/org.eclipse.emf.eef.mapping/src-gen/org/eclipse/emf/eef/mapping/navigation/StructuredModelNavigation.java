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
 * $Id: StructuredModelNavigation.java,v 1.2 2009/09/10 10:27:16 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.navigation;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structured Model Navigation</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.eef.mapping.navigation.NavigationPackage#getStructuredModelNavigation()
 * @model abstract="true"
 * @generated
 */
public interface StructuredModelNavigation extends ModelNavigation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClass evaluate();

} // StructuredModelNavigation
