/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.mapping.settings;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.mapping.settings.SettingsFactory
 * @model kind="package"
 * @generated
 */
public interface SettingsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "settings";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/eef/mapping/settings/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eef-mapping-settings";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SettingsPackage eINSTANCE = org.eclipse.emf.eef.mapping.settings.impl.SettingsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.mapping.settings.impl.EditorSettingsImpl <em>Editor Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.mapping.settings.impl.EditorSettingsImpl
	 * @see org.eclipse.emf.eef.mapping.settings.impl.SettingsPackageImpl#getEditorSettings()
	 * @generated
	 */
	int EDITOR_SETTINGS = 0;

	/**
	 * The number of structural features of the '<em>Editor Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_SETTINGS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.mapping.settings.impl.EReferenceViewerSettingsImpl <em>EReference Viewer Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.mapping.settings.impl.EReferenceViewerSettingsImpl
	 * @see org.eclipse.emf.eef.mapping.settings.impl.SettingsPackageImpl#getEReferenceViewerSettings()
	 * @generated
	 */
	int EREFERENCE_VIEWER_SETTINGS = 1;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_VIEWER_SETTINGS__MODEL = EDITOR_SETTINGS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_VIEWER_SETTINGS__FILTER = EDITOR_SETTINGS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EReference Viewer Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_VIEWER_SETTINGS_FEATURE_COUNT = EDITOR_SETTINGS_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.mapping.settings.EditorSettings <em>Editor Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Settings</em>'.
	 * @see org.eclipse.emf.eef.mapping.settings.EditorSettings
	 * @generated
	 */
	EClass getEditorSettings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings <em>EReference Viewer Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Viewer Settings</em>'.
	 * @see org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings
	 * @generated
	 */
	EClass getEReferenceViewerSettings();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getModel()
	 * @see #getEReferenceViewerSettings()
	 * @generated
	 */
	EReference getEReferenceViewerSettings_Model();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter</em>'.
	 * @see org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings#getFilter()
	 * @see #getEReferenceViewerSettings()
	 * @generated
	 */
	EReference getEReferenceViewerSettings_Filter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SettingsFactory getSettingsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.mapping.settings.impl.EditorSettingsImpl <em>Editor Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.mapping.settings.impl.EditorSettingsImpl
		 * @see org.eclipse.emf.eef.mapping.settings.impl.SettingsPackageImpl#getEditorSettings()
		 * @generated
		 */
		EClass EDITOR_SETTINGS = eINSTANCE.getEditorSettings();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.mapping.settings.impl.EReferenceViewerSettingsImpl <em>EReference Viewer Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.mapping.settings.impl.EReferenceViewerSettingsImpl
		 * @see org.eclipse.emf.eef.mapping.settings.impl.SettingsPackageImpl#getEReferenceViewerSettings()
		 * @generated
		 */
		EClass EREFERENCE_VIEWER_SETTINGS = eINSTANCE
				.getEReferenceViewerSettings();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_VIEWER_SETTINGS__MODEL = eINSTANCE
				.getEReferenceViewerSettings_Model();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_VIEWER_SETTINGS__FILTER = eINSTANCE
				.getEReferenceViewerSettings_Filter();

	}

} //SettingsPackage
