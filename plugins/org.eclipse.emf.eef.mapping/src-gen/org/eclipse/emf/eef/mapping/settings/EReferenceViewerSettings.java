/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.mapping.settings;

import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.eef.mapping.filters.StepFilter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EReference Viewer Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getFilter <em>Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.settings.SettingsPackage#getEReferenceViewerSettings()
 * @model
 * @generated
 */
public interface EReferenceViewerSettings extends EditorSettings {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(EReference)
	 * @see org.eclipse.emf.eef.mapping.settings.SettingsPackage#getEReferenceViewerSettings_Model()
	 * @model required="true"
	 * @generated
	 */
	EReference getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EReference value);

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' containment reference.
	 * @see #setFilter(StepFilter)
	 * @see org.eclipse.emf.eef.mapping.settings.SettingsPackage#getEReferenceViewerSettings_Filter()
	 * @model containment="true"
	 * @generated
	 */
	StepFilter getFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getFilter <em>Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' containment reference.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(StepFilter value);

} // EReferenceViewerSettings
