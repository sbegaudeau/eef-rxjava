/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.htm
 * Contributors: Obeo - initial API and implementation
 */
package org.eclipse.eef.impl;

import org.eclipse.eef.EEFContainerDescription;
import org.eclipse.eef.EEFGroupDescription;
import org.eclipse.eef.EefPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEF Group Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getLabelExpression <em>Label Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getDomainClass <em>Domain Class</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getSemanticCandidateExpression <em>Semantic Candidate Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getCollapsibleExpression <em>Collapsible Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getCollapsedByDefaultExpression <em>Collapsed By Default Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFGroupDescriptionImpl#getValidationExpression <em>Validation Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EEFGroupDescriptionImpl extends ContextableElementImpl implements EEFGroupDescription {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabelExpression() <em>Label Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabelExpression() <em>Label Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelExpression()
	 * @generated
	 * @ordered
	 */
	protected String labelExpression = LABEL_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainClass() <em>Domain Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainClass()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainClass() <em>Domain Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainClass()
	 * @generated
	 * @ordered
	 */
	protected String domainClass = DOMAIN_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSemanticCandidateExpression() <em>Semantic Candidate Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticCandidateExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String SEMANTIC_CANDIDATE_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSemanticCandidateExpression() <em>Semantic Candidate Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticCandidateExpression()
	 * @generated
	 * @ordered
	 */
	protected String semanticCandidateExpression = SEMANTIC_CANDIDATE_EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected EEFContainerDescription container;

	/**
	 * The default value of the '{@link #getCollapsibleExpression() <em>Collapsible Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapsibleExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String COLLAPSIBLE_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCollapsibleExpression() <em>Collapsible Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapsibleExpression()
	 * @generated
	 * @ordered
	 */
	protected String collapsibleExpression = COLLAPSIBLE_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCollapsedByDefaultExpression() <em>Collapsed By Default Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapsedByDefaultExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String COLLAPSED_BY_DEFAULT_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCollapsedByDefaultExpression() <em>Collapsed By Default Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapsedByDefaultExpression()
	 * @generated
	 * @ordered
	 */
	protected String collapsedByDefaultExpression = COLLAPSED_BY_DEFAULT_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationExpression() <em>Validation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String VALIDATION_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidationExpression() <em>Validation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationExpression()
	 * @generated
	 * @ordered
	 */
	protected String validationExpression = VALIDATION_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEFGroupDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefPackage.Literals.EEF_GROUP_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabelExpression() {
		return labelExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabelExpression(String newLabelExpression) {
		String oldLabelExpression = labelExpression;
		labelExpression = newLabelExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__LABEL_EXPRESSION, oldLabelExpression,
					labelExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainClass() {
		return domainClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainClass(String newDomainClass) {
		String oldDomainClass = domainClass;
		domainClass = newDomainClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__DOMAIN_CLASS, oldDomainClass, domainClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSemanticCandidateExpression() {
		return semanticCandidateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSemanticCandidateExpression(String newSemanticCandidateExpression) {
		String oldSemanticCandidateExpression = semanticCandidateExpression;
		semanticCandidateExpression = newSemanticCandidateExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__SEMANTIC_CANDIDATE_EXPRESSION,
					oldSemanticCandidateExpression, semanticCandidateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEFContainerDescription getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject) container;
			container = (EEFContainerDescription) eResolveProxy(oldContainer);
			if (container != oldContainer) {
				InternalEObject newContainer = (InternalEObject) container;
				NotificationChain msgs = oldContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, null,
						null);
				if (newContainer.eInternalContainer() == null) {
					msgs = newContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFContainerDescription basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(EEFContainerDescription newContainer, NotificationChain msgs) {
		EEFContainerDescription oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, oldContainer,
					newContainer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(EEFContainerDescription newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject) container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, null,
						msgs);
			if (newContainer != null)
				msgs = ((InternalEObject) newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, null,
						msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCollapsibleExpression() {
		return collapsibleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCollapsibleExpression(String newCollapsibleExpression) {
		String oldCollapsibleExpression = collapsibleExpression;
		collapsibleExpression = newCollapsibleExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSIBLE_EXPRESSION, oldCollapsibleExpression,
					collapsibleExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCollapsedByDefaultExpression() {
		return collapsedByDefaultExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCollapsedByDefaultExpression(String newCollapsedByDefaultExpression) {
		String oldCollapsedByDefaultExpression = collapsedByDefaultExpression;
		collapsedByDefaultExpression = newCollapsedByDefaultExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSED_BY_DEFAULT_EXPRESSION,
					oldCollapsedByDefaultExpression, collapsedByDefaultExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValidationExpression() {
		return validationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationExpression(String newValidationExpression) {
		String oldValidationExpression = validationExpression;
		validationExpression = newValidationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_GROUP_DESCRIPTION__VALIDATION_EXPRESSION, oldValidationExpression,
					validationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER:
			return basicSetContainer(null, msgs);
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
		case EefPackage.EEF_GROUP_DESCRIPTION__IDENTIFIER:
			return getIdentifier();
		case EefPackage.EEF_GROUP_DESCRIPTION__LABEL_EXPRESSION:
			return getLabelExpression();
		case EefPackage.EEF_GROUP_DESCRIPTION__DOMAIN_CLASS:
			return getDomainClass();
		case EefPackage.EEF_GROUP_DESCRIPTION__SEMANTIC_CANDIDATE_EXPRESSION:
			return getSemanticCandidateExpression();
		case EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER:
			if (resolve)
				return getContainer();
			return basicGetContainer();
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSIBLE_EXPRESSION:
			return getCollapsibleExpression();
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSED_BY_DEFAULT_EXPRESSION:
			return getCollapsedByDefaultExpression();
		case EefPackage.EEF_GROUP_DESCRIPTION__VALIDATION_EXPRESSION:
			return getValidationExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EefPackage.EEF_GROUP_DESCRIPTION__IDENTIFIER:
			setIdentifier((String) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__LABEL_EXPRESSION:
			setLabelExpression((String) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__DOMAIN_CLASS:
			setDomainClass((String) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__SEMANTIC_CANDIDATE_EXPRESSION:
			setSemanticCandidateExpression((String) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER:
			setContainer((EEFContainerDescription) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSIBLE_EXPRESSION:
			setCollapsibleExpression((String) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSED_BY_DEFAULT_EXPRESSION:
			setCollapsedByDefaultExpression((String) newValue);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__VALIDATION_EXPRESSION:
			setValidationExpression((String) newValue);
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
		case EefPackage.EEF_GROUP_DESCRIPTION__IDENTIFIER:
			setIdentifier(IDENTIFIER_EDEFAULT);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__LABEL_EXPRESSION:
			setLabelExpression(LABEL_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__DOMAIN_CLASS:
			setDomainClass(DOMAIN_CLASS_EDEFAULT);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__SEMANTIC_CANDIDATE_EXPRESSION:
			setSemanticCandidateExpression(SEMANTIC_CANDIDATE_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER:
			setContainer((EEFContainerDescription) null);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSIBLE_EXPRESSION:
			setCollapsibleExpression(COLLAPSIBLE_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSED_BY_DEFAULT_EXPRESSION:
			setCollapsedByDefaultExpression(COLLAPSED_BY_DEFAULT_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_GROUP_DESCRIPTION__VALIDATION_EXPRESSION:
			setValidationExpression(VALIDATION_EXPRESSION_EDEFAULT);
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
		case EefPackage.EEF_GROUP_DESCRIPTION__IDENTIFIER:
			return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
		case EefPackage.EEF_GROUP_DESCRIPTION__LABEL_EXPRESSION:
			return LABEL_EXPRESSION_EDEFAULT == null ? labelExpression != null : !LABEL_EXPRESSION_EDEFAULT.equals(labelExpression);
		case EefPackage.EEF_GROUP_DESCRIPTION__DOMAIN_CLASS:
			return DOMAIN_CLASS_EDEFAULT == null ? domainClass != null : !DOMAIN_CLASS_EDEFAULT.equals(domainClass);
		case EefPackage.EEF_GROUP_DESCRIPTION__SEMANTIC_CANDIDATE_EXPRESSION:
			return SEMANTIC_CANDIDATE_EXPRESSION_EDEFAULT == null ? semanticCandidateExpression != null
					: !SEMANTIC_CANDIDATE_EXPRESSION_EDEFAULT.equals(semanticCandidateExpression);
		case EefPackage.EEF_GROUP_DESCRIPTION__CONTAINER:
			return container != null;
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSIBLE_EXPRESSION:
			return COLLAPSIBLE_EXPRESSION_EDEFAULT == null ? collapsibleExpression != null
					: !COLLAPSIBLE_EXPRESSION_EDEFAULT.equals(collapsibleExpression);
		case EefPackage.EEF_GROUP_DESCRIPTION__COLLAPSED_BY_DEFAULT_EXPRESSION:
			return COLLAPSED_BY_DEFAULT_EXPRESSION_EDEFAULT == null ? collapsedByDefaultExpression != null
					: !COLLAPSED_BY_DEFAULT_EXPRESSION_EDEFAULT.equals(collapsedByDefaultExpression);
		case EefPackage.EEF_GROUP_DESCRIPTION__VALIDATION_EXPRESSION:
			return VALIDATION_EXPRESSION_EDEFAULT == null ? validationExpression != null
					: !VALIDATION_EXPRESSION_EDEFAULT.equals(validationExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (identifier: "); //$NON-NLS-1$
		result.append(identifier);
		result.append(", labelExpression: "); //$NON-NLS-1$
		result.append(labelExpression);
		result.append(", domainClass: "); //$NON-NLS-1$
		result.append(domainClass);
		result.append(", semanticCandidateExpression: "); //$NON-NLS-1$
		result.append(semanticCandidateExpression);
		result.append(", collapsibleExpression: "); //$NON-NLS-1$
		result.append(collapsibleExpression);
		result.append(", collapsedByDefaultExpression: "); //$NON-NLS-1$
		result.append(collapsedByDefaultExpression);
		result.append(", validationExpression: "); //$NON-NLS-1$
		result.append(validationExpression);
		result.append(')');
		return result.toString();
	}

} //EEFGroupDescriptionImpl
