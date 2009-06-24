/**
 * <copyright>
 * </copyright>
 *
 * $Id: Talk.java,v 1.2 2009/06/24 16:33:38 sbouchet Exp $
 */
package org.eclipse.emf.eef.nonreg;

import org.eclipse.emf.eef.ab.abstractnonreg.DocumentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Talk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Talk#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Talk#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Talk#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Talk#getPresenter <em>Presenter</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Talk#getCreator <em>Creator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getTalk()
 * @model
 * @generated
 */
public interface Talk extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getTalk_Title()
	 * @model required="true"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Talk#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Topic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topic</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic</em>' reference.
	 * @see #setTopic(Topic)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getTalk_Topic()
	 * @model required="true"
	 * @generated
	 */
	Topic getTopic();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Talk#getTopic <em>Topic</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic</em>' reference.
	 * @see #getTopic()
	 * @generated
	 */
	void setTopic(Topic value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.eef.nonreg.TALK_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.eef.nonreg.TALK_TYPE
	 * @see #setType(TALK_TYPE)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getTalk_Type()
	 * @model
	 * @generated
	 */
	TALK_TYPE getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Talk#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.eef.nonreg.TALK_TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(TALK_TYPE value);

	/**
	 * Returns the value of the '<em><b>Presenter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presenter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presenter</em>' reference.
	 * @see #setPresenter(Person)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getTalk_Presenter()
	 * @model required="true"
	 *        annotation="genConstraint significant='true'"
	 * @generated
	 */
	Person getPresenter();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Talk#getPresenter <em>Presenter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presenter</em>' reference.
	 * @see #getPresenter()
	 * @generated
	 */
	void setPresenter(Person value);

	/**
	 * Returns the value of the '<em><b>Creator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creator</em>' reference.
	 * @see #setCreator(Person)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getTalk_Creator()
	 * @model
	 * @generated
	 */
	Person getCreator();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Talk#getCreator <em>Creator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creator</em>' reference.
	 * @see #getCreator()
	 * @generated
	 */
	void setCreator(Person value);

} // Talk
