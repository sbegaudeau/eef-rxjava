/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConcreteReferenceOwnerSample.java,v 1.1 2011/02/01 09:54:40 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.filters;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Reference Owner Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceOwnerSample#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceOwnerSample#getStrictTyping <em>Strict Typing</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceOwnerSample#getStrictTyping2 <em>Strict Typing2</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceOwnerSample#getStrictTyping3 <em>Strict Typing3</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.filters.FiltersPackage#getConcreteReferenceOwnerSample()
 * @model
 * @generated
 */
public interface ConcreteReferenceOwnerSample extends AbstractReferenceOwnerSample {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceTargetSample1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.filters.FiltersPackage#getConcreteReferenceOwnerSample_Target()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ConcreteReferenceTargetSample1> getTarget();

	/**
	 * Returns the value of the '<em><b>Strict Typing</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.filters.AbstractReferenceTargetSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Typing</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Typing</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.filters.FiltersPackage#getConcreteReferenceOwnerSample_StrictTyping()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractReferenceTargetSample> getStrictTyping();

	/**
	 * Returns the value of the '<em><b>Strict Typing2</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.filters.AbstractReferenceTargetSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Typing2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Typing2</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.filters.FiltersPackage#getConcreteReferenceOwnerSample_StrictTyping2()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractReferenceTargetSample> getStrictTyping2();

	/**
	 * Returns the value of the '<em><b>Strict Typing3</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.filters.AbstractReferenceTargetSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Typing3</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Typing3</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.filters.FiltersPackage#getConcreteReferenceOwnerSample_StrictTyping3()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractReferenceTargetSample> getStrictTyping3();

} // ConcreteReferenceOwnerSample
