/**
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 *
 * $Id: BID.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>BID</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getBID()
 * @model
 * @generated
 */
public enum BID implements Enumerator {
	/**
	 * The '<em><b>SMALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALL_VALUE
	 * @generated
	 * @ordered
	 */
	SMALL(0, "SMALL", "SMALL"),

	/**
	 * The '<em><b>GUARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUARD_VALUE
	 * @generated
	 * @ordered
	 */
	GUARD(1, "GUARD", "GUARD"),

	/**
	 * The '<em><b>GUARD WITHOUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUARD_WITHOUT_VALUE
	 * @generated
	 * @ordered
	 */
	GUARD_WITHOUT(2, "GUARD_WITHOUT", "GUARD_WITHOUT"),

	/**
	 * The '<em><b>GUARD AGAINST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUARD_AGAINST_VALUE
	 * @generated
	 * @ordered
	 */
	GUARD_AGAINST(3, "GUARD_AGAINST", "GUARD_AGAINST");

	/**
	 * The '<em><b>SMALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMALL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMALL_VALUE = 0;

	/**
	 * The '<em><b>GUARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GUARD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUARD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_VALUE = 1;

	/**
	 * The '<em><b>GUARD WITHOUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GUARD WITHOUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUARD_WITHOUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_WITHOUT_VALUE = 2;

	/**
	 * The '<em><b>GUARD AGAINST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GUARD AGAINST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUARD_AGAINST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_AGAINST_VALUE = 3;

	/**
	 * An array of all the '<em><b>BID</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BID[] VALUES_ARRAY =
		new BID[] {
			SMALL,
			GUARD,
			GUARD_WITHOUT,
			GUARD_AGAINST,
		};

	/**
	 * A public read-only list of all the '<em><b>BID</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BID> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>BID</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BID get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BID result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>BID</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BID getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BID result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>BID</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BID get(int value) {
		switch (value) {
			case SMALL_VALUE: return SMALL;
			case GUARD_VALUE: return GUARD;
			case GUARD_WITHOUT_VALUE: return GUARD_WITHOUT;
			case GUARD_AGAINST_VALUE: return GUARD_AGAINST;
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
	private BID(int value, String name, String literal) {
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
	
} //BID
