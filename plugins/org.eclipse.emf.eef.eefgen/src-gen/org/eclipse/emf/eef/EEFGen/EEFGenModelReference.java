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
 * $Id: EEFGenModelReference.java,v 1.1 2009/04/30 17:49:10 nlepine Exp $
 */
package org.eclipse.emf.eef.EEFGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.EEFGenModelReference#getReferencedContext <em>Referenced Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getEEFGenModelReference()
 * @model
 * @generated
 */
public interface EEFGenModelReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Referenced Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Context</em>' reference.
	 * @see #setReferencedContext(EEFGenModel)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getEEFGenModelReference_ReferencedContext()
	 * @model required="true"
	 * @generated
	 */
	EEFGenModel getReferencedContext();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.EEFGenModelReference#getReferencedContext <em>Referenced Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Context</em>' reference.
	 * @see #getReferencedContext()
	 * @generated
	 */
	void setReferencedContext(EEFGenModel value);

} // EEFGenModelReference
