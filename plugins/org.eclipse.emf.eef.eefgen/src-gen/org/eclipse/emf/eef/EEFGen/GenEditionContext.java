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
 * $Id: GenEditionContext.java,v 1.1 2009/04/30 17:11:46 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.components.PropertiesEditionContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Edition Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getPropertiesEditionContext <em>Properties Edition Context</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getGenDirectory <em>Gen Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isSwtViews <em>Swt Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isFormViews <em>Form Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isDescriptorsGenericPropertiesViews <em>Descriptors Generic Properties Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isGmfPropertiesViews <em>Gmf Properties Views</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getHelpStrategy <em>Help Strategy</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getDescriptorsContributorID <em>Descriptors Contributor ID</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getLicense <em>License</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext()
 * @model
 * @generated
 */
public interface GenEditionContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties Edition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties Edition Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties Edition Context</em>' reference.
	 * @see #setPropertiesEditionContext(PropertiesEditionContext)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_PropertiesEditionContext()
	 * @model required="true"
	 * @generated
	 */
	PropertiesEditionContext getPropertiesEditionContext();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getPropertiesEditionContext <em>Properties Edition Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties Edition Context</em>' reference.
	 * @see #getPropertiesEditionContext()
	 * @generated
	 */
	void setPropertiesEditionContext(PropertiesEditionContext value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' attribute.
	 * @see #setBasePackage(String)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_BasePackage()
	 * @model
	 * @generated
	 */
	String getBasePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getBasePackage <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' attribute.
	 * @see #getBasePackage()
	 * @generated
	 */
	void setBasePackage(String value);

	/**
	 * Returns the value of the '<em><b>Gen Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Directory</em>' attribute.
	 * @see #setGenDirectory(String)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_GenDirectory()
	 * @model required="true"
	 * @generated
	 */
	String getGenDirectory();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getGenDirectory <em>Gen Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Directory</em>' attribute.
	 * @see #getGenDirectory()
	 * @generated
	 */
	void setGenDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Swt Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Swt Views</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swt Views</em>' attribute.
	 * @see #setSwtViews(boolean)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_SwtViews()
	 * @model
	 * @generated
	 */
	boolean isSwtViews();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isSwtViews <em>Swt Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swt Views</em>' attribute.
	 * @see #isSwtViews()
	 * @generated
	 */
	void setSwtViews(boolean value);

	/**
	 * Returns the value of the '<em><b>Form Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Views</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Views</em>' attribute.
	 * @see #setFormViews(boolean)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_FormViews()
	 * @model
	 * @generated
	 */
	boolean isFormViews();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isFormViews <em>Form Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Form Views</em>' attribute.
	 * @see #isFormViews()
	 * @generated
	 */
	void setFormViews(boolean value);

	/**
	 * Returns the value of the '<em><b>Descriptors Generic Properties Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors Generic Properties Views</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors Generic Properties Views</em>' attribute.
	 * @see #setDescriptorsGenericPropertiesViews(boolean)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_DescriptorsGenericPropertiesViews()
	 * @model
	 * @generated
	 */
	boolean isDescriptorsGenericPropertiesViews();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isDescriptorsGenericPropertiesViews <em>Descriptors Generic Properties Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptors Generic Properties Views</em>' attribute.
	 * @see #isDescriptorsGenericPropertiesViews()
	 * @generated
	 */
	void setDescriptorsGenericPropertiesViews(boolean value);

	/**
	 * Returns the value of the '<em><b>Gmf Properties Views</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmf Properties Views</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gmf Properties Views</em>' attribute.
	 * @see #setGmfPropertiesViews(boolean)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_GmfPropertiesViews()
	 * @model
	 * @generated
	 */
	boolean isGmfPropertiesViews();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#isGmfPropertiesViews <em>Gmf Properties Views</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gmf Properties Views</em>' attribute.
	 * @see #isGmfPropertiesViews()
	 * @generated
	 */
	void setGmfPropertiesViews(boolean value);

	/**
	 * Returns the value of the '<em><b>Help Strategy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.eef.EEFGen.HELP_STRATEGY}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Help Strategy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Help Strategy</em>' attribute.
	 * @see org.eclipse.emf.eef.EEFGen.HELP_STRATEGY
	 * @see #setHelpStrategy(HELP_STRATEGY)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_HelpStrategy()
	 * @model required="true"
	 * @generated
	 */
	HELP_STRATEGY getHelpStrategy();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getHelpStrategy <em>Help Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help Strategy</em>' attribute.
	 * @see org.eclipse.emf.eef.EEFGen.HELP_STRATEGY
	 * @see #getHelpStrategy()
	 * @generated
	 */
	void setHelpStrategy(HELP_STRATEGY value);

	/**
	 * Returns the value of the '<em><b>Descriptors Contributor ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors Contributor ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors Contributor ID</em>' attribute.
	 * @see #setDescriptorsContributorID(String)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_DescriptorsContributorID()
	 * @model
	 * @generated
	 */
	String getDescriptorsContributorID();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getDescriptorsContributorID <em>Descriptors Contributor ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptors Contributor ID</em>' attribute.
	 * @see #getDescriptorsContributorID()
	 * @generated
	 */
	void setDescriptorsContributorID(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License</em>' attribute.
	 * @see #setLicense(String)
	 * @see org.eclipse.emf.eef.EEFGen.EEFGenPackage#getGenEditionContext_License()
	 * @model
	 * @generated
	 */
	String getLicense();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.EEFGen.GenEditionContext#getLicense <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License</em>' attribute.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(String value);

} // GenEditionContext
