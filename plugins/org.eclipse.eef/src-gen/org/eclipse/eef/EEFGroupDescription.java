/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.htm
 * Contributors: Obeo - initial API and implementation
 */
package org.eclipse.eef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEF Group Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Group is used to structure the user interface within a Page. It groups multiple widgets together.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getLabelExpression <em>Label Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getDomainClass <em>Domain Class</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getSemanticCandidateExpression <em>Semantic Candidate Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getCollapsibleExpression <em>Collapsible Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getCollapsedByDefaultExpression <em>Collapsed By Default Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFGroupDescription#getValidationExpression <em>Validation Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription()
 * @model
 * @generated
 */
public interface EEFGroupDescription extends ContextableElement {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to identify a specific Group in a Page.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_Identifier()
	 * @model required="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Label Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The label of the Group visible by the end users. If not specified, the Group is not drawn only its contained widgets are shown, else it is visible as a section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label Expression</em>' attribute.
	 * @see #setLabelExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_LabelExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getLabelExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getLabelExpression <em>Label Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Expression</em>' attribute.
	 * @see #getLabelExpression()
	 * @generated
	 */
	void setLabelExpression(String value);

	/**
	 * Returns the value of the '<em><b>Domain Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines the context in which the Group is used. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Class</em>' attribute.
	 * @see #setDomainClass(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_DomainClass()
	 * @model dataType="org.eclipse.eef.TypeName"
	 * @generated
	 */
	String getDomainClass();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getDomainClass <em>Domain Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Class</em>' attribute.
	 * @see #getDomainClass()
	 * @generated
	 */
	void setDomainClass(String value);

	/**
	 * Returns the value of the '<em><b>Semantic Candidate Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The elements that are represented. If not specified, the EEF runtime reuses the context of the Page for the Group.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Semantic Candidate Expression</em>' attribute.
	 * @see #setSemanticCandidateExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_SemanticCandidateExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getSemanticCandidateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getSemanticCandidateExpression <em>Semantic Candidate Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Candidate Expression</em>' attribute.
	 * @see #getSemanticCandidateExpression()
	 * @generated
	 */
	void setSemanticCandidateExpression(String value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains the container related to a group.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(EEFContainerDescription)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_Container()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EEFContainerDescription getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EEFContainerDescription value);

	/**
	 * Returns the value of the '<em><b>Collapsible Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines if a group is collapsible or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Collapsible Expression</em>' attribute.
	 * @see #setCollapsibleExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_CollapsibleExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getCollapsibleExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getCollapsibleExpression <em>Collapsible Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapsible Expression</em>' attribute.
	 * @see #getCollapsibleExpression()
	 * @generated
	 */
	void setCollapsibleExpression(String value);

	/**
	 * Returns the value of the '<em><b>Collapsed By Default Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines if a collapsible group must be collapsed by default or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Collapsed By Default Expression</em>' attribute.
	 * @see #setCollapsedByDefaultExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_CollapsedByDefaultExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getCollapsedByDefaultExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getCollapsedByDefaultExpression <em>Collapsed By Default Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapsed By Default Expression</em>' attribute.
	 * @see #getCollapsedByDefaultExpression()
	 * @generated
	 */
	void setCollapsedByDefaultExpression(String value);

	/**
	 * Returns the value of the '<em><b>Validation Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines if a group value is valid or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation Expression</em>' attribute.
	 * @see #setValidationExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFGroupDescription_ValidationExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getValidationExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFGroupDescription#getValidationExpression <em>Validation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Expression</em>' attribute.
	 * @see #getValidationExpression()
	 * @generated
	 */
	void setValidationExpression(String value);

} // EEFGroupDescription
