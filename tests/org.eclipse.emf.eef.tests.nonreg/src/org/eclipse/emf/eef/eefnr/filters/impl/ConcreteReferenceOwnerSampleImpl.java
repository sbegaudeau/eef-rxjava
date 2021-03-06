/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConcreteReferenceOwnerSampleImpl.java,v 1.1 2011/02/01 09:54:40 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.filters.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.eef.eefnr.filters.AbstractReferenceTargetSample;
import org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceOwnerSample;
import org.eclipse.emf.eef.eefnr.filters.ConcreteReferenceTargetSample1;
import org.eclipse.emf.eef.eefnr.filters.FiltersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Reference Owner Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.impl.ConcreteReferenceOwnerSampleImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.impl.ConcreteReferenceOwnerSampleImpl#getStrictTyping <em>Strict Typing</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.impl.ConcreteReferenceOwnerSampleImpl#getStrictTyping2 <em>Strict Typing2</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.filters.impl.ConcreteReferenceOwnerSampleImpl#getStrictTyping3 <em>Strict Typing3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteReferenceOwnerSampleImpl extends AbstractReferenceOwnerSampleImpl implements ConcreteReferenceOwnerSample {
	/**
	 * The cached value of the '{@link #getStrictTyping() <em>Strict Typing</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrictTyping()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractReferenceTargetSample> strictTyping;

	/**
	 * The cached value of the '{@link #getStrictTyping2() <em>Strict Typing2</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrictTyping2()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractReferenceTargetSample> strictTyping2;
	/**
	 * The cached value of the '{@link #getStrictTyping3() <em>Strict Typing3</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrictTyping3()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractReferenceTargetSample> strictTyping3;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteReferenceOwnerSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FiltersPackage.Literals.CONCRETE_REFERENCE_OWNER_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteReferenceTargetSample1> getTarget() {
		// TODO: implement this method to return the 'Target' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractReferenceTargetSample> getStrictTyping() {
		if (strictTyping == null) {
			strictTyping = new EObjectContainmentEList<AbstractReferenceTargetSample>(AbstractReferenceTargetSample.class, this, FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING);
		}
		return strictTyping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractReferenceTargetSample> getStrictTyping2() {
		if (strictTyping2 == null) {
			strictTyping2 = new EObjectContainmentEList<AbstractReferenceTargetSample>(AbstractReferenceTargetSample.class, this, FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING2);
		}
		return strictTyping2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractReferenceTargetSample> getStrictTyping3() {
		if (strictTyping3 == null) {
			strictTyping3 = new EObjectContainmentEList<AbstractReferenceTargetSample>(AbstractReferenceTargetSample.class, this, FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING3);
		}
		return strictTyping3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING:
				return ((InternalEList<?>)getStrictTyping()).basicRemove(otherEnd, msgs);
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING2:
				return ((InternalEList<?>)getStrictTyping2()).basicRemove(otherEnd, msgs);
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING3:
				return ((InternalEList<?>)getStrictTyping3()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__TARGET:
				return getTarget();
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING:
				return getStrictTyping();
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING2:
				return getStrictTyping2();
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING3:
				return getStrictTyping3();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING:
				getStrictTyping().clear();
				getStrictTyping().addAll((Collection<? extends AbstractReferenceTargetSample>)newValue);
				return;
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING2:
				getStrictTyping2().clear();
				getStrictTyping2().addAll((Collection<? extends AbstractReferenceTargetSample>)newValue);
				return;
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING3:
				getStrictTyping3().clear();
				getStrictTyping3().addAll((Collection<? extends AbstractReferenceTargetSample>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING:
				getStrictTyping().clear();
				return;
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING2:
				getStrictTyping2().clear();
				return;
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING3:
				getStrictTyping3().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__TARGET:
				return !getTarget().isEmpty();
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING:
				return strictTyping != null && !strictTyping.isEmpty();
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING2:
				return strictTyping2 != null && !strictTyping2.isEmpty();
			case FiltersPackage.CONCRETE_REFERENCE_OWNER_SAMPLE__STRICT_TYPING3:
				return strictTyping3 != null && !strictTyping3.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConcreteReferenceOwnerSampleImpl
