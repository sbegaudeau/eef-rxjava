/**
 * <copyright>
 * </copyright>
 *
 * $Id: ENUM_SAMPLE.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ENUM SAMPLE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getENUM_SAMPLE()
 * @model
 * @generated
 */
public enum ENUM_SAMPLE implements Enumerator {
	/**
	 * The '<em><b>Literal1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LITERAL1_VALUE
	 * @generated
	 * @ordered
	 */
	LITERAL1(0, "literal1", "literal1"),

	/**
	 * The '<em><b>Literal2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LITERAL2_VALUE
	 * @generated
	 * @ordered
	 */
	LITERAL2(1, "literal2", "literal2"),

	/**
	 * The '<em><b>Literal3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LITERAL3_VALUE
	 * @generated
	 * @ordered
	 */
	LITERAL3(2, "literal3", "literal3");

	/**
	 * The '<em><b>Literal1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Literal1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LITERAL1
	 * @model name="literal1"
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL1_VALUE = 0;

	/**
	 * The '<em><b>Literal2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Literal2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LITERAL2
	 * @model name="literal2"
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL2_VALUE = 1;

	/**
	 * The '<em><b>Literal3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Literal3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LITERAL3
	 * @model name="literal3"
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL3_VALUE = 2;

	/**
	 * An array of all the '<em><b>ENUM SAMPLE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ENUM_SAMPLE[] VALUES_ARRAY =
		new ENUM_SAMPLE[] {
			LITERAL1,
			LITERAL2,
			LITERAL3,
		};

	/**
	 * A public read-only list of all the '<em><b>ENUM SAMPLE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ENUM_SAMPLE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ENUM SAMPLE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ENUM_SAMPLE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ENUM_SAMPLE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ENUM SAMPLE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ENUM_SAMPLE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ENUM_SAMPLE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ENUM SAMPLE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ENUM_SAMPLE get(int value) {
		switch (value) {
			case LITERAL1_VALUE: return LITERAL1;
			case LITERAL2_VALUE: return LITERAL2;
			case LITERAL3_VALUE: return LITERAL3;
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
	private ENUM_SAMPLE(int value, String name, String literal) {
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
	
} //ENUM_SAMPLE
