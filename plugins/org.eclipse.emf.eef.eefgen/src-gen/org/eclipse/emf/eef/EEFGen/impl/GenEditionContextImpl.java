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
 * $Id: GenEditionContextImpl.java,v 1.1 2009/04/30 17:11:46 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;

import org.eclipse.emf.eef.EEFGen.HELP_STRATEGY;
import org.eclipse.emf.eef.components.PropertiesEditionContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Edition Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getPropertiesEditionContext <em>Properties Edition Context</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getGenDirectory <em>Gen Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#isSwtViews <em>Swt Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#isFormViews <em>Form Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#isDescriptorsGenericPropertiesViews <em>Descriptors Generic Properties Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#isGmfPropertiesViews <em>Gmf Properties Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getHelpStrategy <em>Help Strategy</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getDescriptorsContributorID <em>Descriptors Contributor ID</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.impl.GenEditionContextImpl#getLicense <em>License</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenEditionContextImpl extends EObjectImpl implements GenEditionContext {
	/**
	 * The cached value of the '{@link #getPropertiesEditionContext() <em>Properties Edition Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertiesEditionContext()
	 * @generated
	 * @ordered
	 */
	protected PropertiesEditionContext propertiesEditionContext;

	/**
	 * The default value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePackage()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePackage()
	 * @generated
	 * @ordered
	 */
	protected String basePackage = BASE_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenDirectory() <em>Gen Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String GEN_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenDirectory() <em>Gen Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenDirectory()
	 * @generated
	 * @ordered
	 */
	protected String genDirectory = GEN_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isSwtViews() <em>Swt Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSwtViews()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SWT_VIEWS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSwtViews() <em>Swt Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSwtViews()
	 * @generated
	 * @ordered
	 */
	protected boolean swtViews = SWT_VIEWS_EDEFAULT;

	/**
	 * The default value of the '{@link #isFormViews() <em>Form Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFormViews()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORM_VIEWS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFormViews() <em>Form Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFormViews()
	 * @generated
	 * @ordered
	 */
	protected boolean formViews = FORM_VIEWS_EDEFAULT;

	/**
	 * The default value of the '{@link #isDescriptorsGenericPropertiesViews() <em>Descriptors Generic Properties Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDescriptorsGenericPropertiesViews()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DESCRIPTORS_GENERIC_PROPERTIES_VIEWS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDescriptorsGenericPropertiesViews() <em>Descriptors Generic Properties Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDescriptorsGenericPropertiesViews()
	 * @generated
	 * @ordered
	 */
	protected boolean descriptorsGenericPropertiesViews = DESCRIPTORS_GENERIC_PROPERTIES_VIEWS_EDEFAULT;

	/**
	 * The default value of the '{@link #isGmfPropertiesViews() <em>Gmf Properties Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGmfPropertiesViews()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GMF_PROPERTIES_VIEWS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGmfPropertiesViews() <em>Gmf Properties Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGmfPropertiesViews()
	 * @generated
	 * @ordered
	 */
	protected boolean gmfPropertiesViews = GMF_PROPERTIES_VIEWS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHelpStrategy() <em>Help Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final HELP_STRATEGY HELP_STRATEGY_EDEFAULT = HELP_STRATEGY.GENMODEL;

	/**
	 * The cached value of the '{@link #getHelpStrategy() <em>Help Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpStrategy()
	 * @generated
	 * @ordered
	 */
	protected HELP_STRATEGY helpStrategy = HELP_STRATEGY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptorsContributorID() <em>Descriptors Contributor ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorsContributorID()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTORS_CONTRIBUTOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptorsContributorID() <em>Descriptors Contributor ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorsContributorID()
	 * @generated
	 * @ordered
	 */
	protected String descriptorsContributorID = DESCRIPTORS_CONTRIBUTOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenEditionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EEFGenPackage.Literals.GEN_EDITION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesEditionContext getPropertiesEditionContext() {
		if (propertiesEditionContext != null && propertiesEditionContext.eIsProxy()) {
			InternalEObject oldPropertiesEditionContext = (InternalEObject)propertiesEditionContext;
			propertiesEditionContext = (PropertiesEditionContext)eResolveProxy(oldPropertiesEditionContext);
			if (propertiesEditionContext != oldPropertiesEditionContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFGenPackage.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT, oldPropertiesEditionContext, propertiesEditionContext));
			}
		}
		return propertiesEditionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesEditionContext basicGetPropertiesEditionContext() {
		return propertiesEditionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertiesEditionContext(PropertiesEditionContext newPropertiesEditionContext) {
		PropertiesEditionContext oldPropertiesEditionContext = propertiesEditionContext;
		propertiesEditionContext = newPropertiesEditionContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT, oldPropertiesEditionContext, propertiesEditionContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasePackage() {
		return basePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePackage(String newBasePackage) {
		String oldBasePackage = basePackage;
		basePackage = newBasePackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__BASE_PACKAGE, oldBasePackage, basePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGenDirectory() {
		return genDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenDirectory(String newGenDirectory) {
		String oldGenDirectory = genDirectory;
		genDirectory = newGenDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__GEN_DIRECTORY, oldGenDirectory, genDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSwtViews() {
		return swtViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwtViews(boolean newSwtViews) {
		boolean oldSwtViews = swtViews;
		swtViews = newSwtViews;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__SWT_VIEWS, oldSwtViews, swtViews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFormViews() {
		return formViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormViews(boolean newFormViews) {
		boolean oldFormViews = formViews;
		formViews = newFormViews;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__FORM_VIEWS, oldFormViews, formViews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDescriptorsGenericPropertiesViews() {
		return descriptorsGenericPropertiesViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptorsGenericPropertiesViews(boolean newDescriptorsGenericPropertiesViews) {
		boolean oldDescriptorsGenericPropertiesViews = descriptorsGenericPropertiesViews;
		descriptorsGenericPropertiesViews = newDescriptorsGenericPropertiesViews;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS, oldDescriptorsGenericPropertiesViews, descriptorsGenericPropertiesViews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGmfPropertiesViews() {
		return gmfPropertiesViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGmfPropertiesViews(boolean newGmfPropertiesViews) {
		boolean oldGmfPropertiesViews = gmfPropertiesViews;
		gmfPropertiesViews = newGmfPropertiesViews;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS, oldGmfPropertiesViews, gmfPropertiesViews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HELP_STRATEGY getHelpStrategy() {
		return helpStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelpStrategy(HELP_STRATEGY newHelpStrategy) {
		HELP_STRATEGY oldHelpStrategy = helpStrategy;
		helpStrategy = newHelpStrategy == null ? HELP_STRATEGY_EDEFAULT : newHelpStrategy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__HELP_STRATEGY, oldHelpStrategy, helpStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptorsContributorID() {
		return descriptorsContributorID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptorsContributorID(String newDescriptorsContributorID) {
		String oldDescriptorsContributorID = descriptorsContributorID;
		descriptorsContributorID = newDescriptorsContributorID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID, oldDescriptorsContributorID, descriptorsContributorID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFGenPackage.GEN_EDITION_CONTEXT__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EEFGenPackage.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT:
				if (resolve) return getPropertiesEditionContext();
				return basicGetPropertiesEditionContext();
			case EEFGenPackage.GEN_EDITION_CONTEXT__BASE_PACKAGE:
				return getBasePackage();
			case EEFGenPackage.GEN_EDITION_CONTEXT__GEN_DIRECTORY:
				return getGenDirectory();
			case EEFGenPackage.GEN_EDITION_CONTEXT__SWT_VIEWS:
				return isSwtViews() ? Boolean.TRUE : Boolean.FALSE;
			case EEFGenPackage.GEN_EDITION_CONTEXT__FORM_VIEWS:
				return isFormViews() ? Boolean.TRUE : Boolean.FALSE;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS:
				return isDescriptorsGenericPropertiesViews() ? Boolean.TRUE : Boolean.FALSE;
			case EEFGenPackage.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS:
				return isGmfPropertiesViews() ? Boolean.TRUE : Boolean.FALSE;
			case EEFGenPackage.GEN_EDITION_CONTEXT__HELP_STRATEGY:
				return getHelpStrategy();
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID:
				return getDescriptorsContributorID();
			case EEFGenPackage.GEN_EDITION_CONTEXT__AUTHOR:
				return getAuthor();
			case EEFGenPackage.GEN_EDITION_CONTEXT__LICENSE:
				return getLicense();
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
			case EEFGenPackage.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT:
				setPropertiesEditionContext((PropertiesEditionContext)newValue);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__BASE_PACKAGE:
				setBasePackage((String)newValue);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__GEN_DIRECTORY:
				setGenDirectory((String)newValue);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__SWT_VIEWS:
				setSwtViews(((Boolean)newValue).booleanValue());
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__FORM_VIEWS:
				setFormViews(((Boolean)newValue).booleanValue());
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS:
				setDescriptorsGenericPropertiesViews(((Boolean)newValue).booleanValue());
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS:
				setGmfPropertiesViews(((Boolean)newValue).booleanValue());
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__HELP_STRATEGY:
				setHelpStrategy((HELP_STRATEGY)newValue);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID:
				setDescriptorsContributorID((String)newValue);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__AUTHOR:
				setAuthor((String)newValue);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__LICENSE:
				setLicense((String)newValue);
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
			case EEFGenPackage.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT:
				setPropertiesEditionContext((PropertiesEditionContext)null);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__BASE_PACKAGE:
				setBasePackage(BASE_PACKAGE_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__GEN_DIRECTORY:
				setGenDirectory(GEN_DIRECTORY_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__SWT_VIEWS:
				setSwtViews(SWT_VIEWS_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__FORM_VIEWS:
				setFormViews(FORM_VIEWS_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS:
				setDescriptorsGenericPropertiesViews(DESCRIPTORS_GENERIC_PROPERTIES_VIEWS_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS:
				setGmfPropertiesViews(GMF_PROPERTIES_VIEWS_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__HELP_STRATEGY:
				setHelpStrategy(HELP_STRATEGY_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID:
				setDescriptorsContributorID(DESCRIPTORS_CONTRIBUTOR_ID_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case EEFGenPackage.GEN_EDITION_CONTEXT__LICENSE:
				setLicense(LICENSE_EDEFAULT);
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
			case EEFGenPackage.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT:
				return propertiesEditionContext != null;
			case EEFGenPackage.GEN_EDITION_CONTEXT__BASE_PACKAGE:
				return BASE_PACKAGE_EDEFAULT == null ? basePackage != null : !BASE_PACKAGE_EDEFAULT.equals(basePackage);
			case EEFGenPackage.GEN_EDITION_CONTEXT__GEN_DIRECTORY:
				return GEN_DIRECTORY_EDEFAULT == null ? genDirectory != null : !GEN_DIRECTORY_EDEFAULT.equals(genDirectory);
			case EEFGenPackage.GEN_EDITION_CONTEXT__SWT_VIEWS:
				return swtViews != SWT_VIEWS_EDEFAULT;
			case EEFGenPackage.GEN_EDITION_CONTEXT__FORM_VIEWS:
				return formViews != FORM_VIEWS_EDEFAULT;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS:
				return descriptorsGenericPropertiesViews != DESCRIPTORS_GENERIC_PROPERTIES_VIEWS_EDEFAULT;
			case EEFGenPackage.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS:
				return gmfPropertiesViews != GMF_PROPERTIES_VIEWS_EDEFAULT;
			case EEFGenPackage.GEN_EDITION_CONTEXT__HELP_STRATEGY:
				return helpStrategy != HELP_STRATEGY_EDEFAULT;
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID:
				return DESCRIPTORS_CONTRIBUTOR_ID_EDEFAULT == null ? descriptorsContributorID != null : !DESCRIPTORS_CONTRIBUTOR_ID_EDEFAULT.equals(descriptorsContributorID);
			case EEFGenPackage.GEN_EDITION_CONTEXT__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case EEFGenPackage.GEN_EDITION_CONTEXT__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (basePackage: ");
		result.append(basePackage);
		result.append(", genDirectory: ");
		result.append(genDirectory);
		result.append(", swtViews: ");
		result.append(swtViews);
		result.append(", formViews: ");
		result.append(formViews);
		result.append(", descriptorsGenericPropertiesViews: ");
		result.append(descriptorsGenericPropertiesViews);
		result.append(", gmfPropertiesViews: ");
		result.append(gmfPropertiesViews);
		result.append(", helpStrategy: ");
		result.append(helpStrategy);
		result.append(", descriptorsContributorID: ");
		result.append(descriptorsContributorID);
		result.append(", author: ");
		result.append(author);
		result.append(", license: ");
		result.append(license);
		result.append(')');
		return result.toString();
	}

} //GenEditionContextImpl
