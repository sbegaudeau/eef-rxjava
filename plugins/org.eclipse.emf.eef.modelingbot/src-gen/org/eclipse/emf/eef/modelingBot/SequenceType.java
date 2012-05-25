/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sequence Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getSequenceType()
 * @model
 * @generated
 */
public enum SequenceType implements Enumerator {
	/**
	 * The '<em><b>DETAILS PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DETAILS_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	DETAILS_PAGE(0, "DETAILS_PAGE", "DETAILS_PAGE"),

	/**
	 * The '<em><b>WIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIZARD_VALUE
	 * @generated
	 * @ordered
	 */
	WIZARD(1, "WIZARD", "WIZARD"),

	/**
	 * The '<em><b>PROPERTIES VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROPERTIES_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	PROPERTIES_VIEW(2, "PROPERTIES_VIEW", "PROPERTIES_VIEW");

	/**
	 * The '<em><b>DETAILS PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DETAILS PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DETAILS_PAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DETAILS_PAGE_VALUE = 0;

	/**
	 * The '<em><b>WIZARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WIZARD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WIZARD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIZARD_VALUE = 1;

	/**
	 * The '<em><b>PROPERTIES VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROPERTIES VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROPERTIES_VIEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTIES_VIEW_VALUE = 2;

	/**
	 * An array of all the '<em><b>Sequence Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SequenceType[] VALUES_ARRAY =
		new SequenceType[] {
			DETAILS_PAGE,
			WIZARD,
			PROPERTIES_VIEW,
		};

	/**
	 * A public read-only list of all the '<em><b>Sequence Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SequenceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sequence Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SequenceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SequenceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sequence Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SequenceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SequenceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sequence Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SequenceType get(int value) {
		switch (value) {
			case DETAILS_PAGE_VALUE: return DETAILS_PAGE;
			case WIZARD_VALUE: return WIZARD;
			case PROPERTIES_VIEW_VALUE: return PROPERTIES_VIEW;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SequenceType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SequenceType
