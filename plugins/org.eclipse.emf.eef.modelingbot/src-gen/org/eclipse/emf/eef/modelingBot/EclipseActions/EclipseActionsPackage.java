/**
 * <copyright>
 * </copyright>
 *
 * $Id: EclipseActionsPackage.java,v 1.2 2011/04/11 16:48:02 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EclipseActions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.modelingBot.ModelingBotPackage;

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
 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsFactory
 * @model kind="package"
 * @generated
 */
public interface EclipseActionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EclipseActions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/eef/test/EclipseActions/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eef-test";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EclipseActionsPackage eINSTANCE = org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionImpl <em>Eclipse Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getEclipseAction()
	 * @generated
	 */
	int ECLIPSE_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_ACTION__NAME = ModelingBotPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_ACTION__DOCUMENTATION = ModelingBotPackage.ACTION__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>Eclipse Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_ACTION_FEATURE_COUNT = ModelingBotPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateProjectImpl <em>Create Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateProjectImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCreateProject()
	 * @generated
	 */
	int CREATE_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT__PROJECT_NAME = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenPerspectiveImpl <em>Open Perspective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenPerspectiveImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getOpenPerspective()
	 * @generated
	 */
	int OPEN_PERSPECTIVE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PERSPECTIVE__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PERSPECTIVE__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PERSPECTIVE__TYPE = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open Perspective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PERSPECTIVE_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseProjectImpl <em>Close Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseProjectImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCloseProject()
	 * @generated
	 */
	int CLOSE_PROJECT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_PROJECT__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_PROJECT__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_PROJECT__PROJECT_NAME = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Close Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_PROJECT_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.SaveImpl <em>Save</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.SaveImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getSave()
	 * @generated
	 */
	int SAVE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>Save</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.UndoImpl <em>Undo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.UndoImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getUndo()
	 * @generated
	 */
	int UNDO = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDO__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDO__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>Undo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDO_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RedoImpl <em>Redo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RedoImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getRedo()
	 * @generated
	 */
	int REDO = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDO__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDO__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>Redo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDO_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenProjectImpl <em>Open Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenProjectImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getOpenProject()
	 * @generated
	 */
	int OPEN_PROJECT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PROJECT__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PROJECT__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PROJECT__PROJECT_NAME = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_PROJECT_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RemoveProjectImpl <em>Remove Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RemoveProjectImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getRemoveProject()
	 * @generated
	 */
	int REMOVE_PROJECT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PROJECT__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PROJECT__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PROJECT__PROJECT_NAME = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PROJECT_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseEditorImpl <em>Close Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseEditorImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCloseEditor()
	 * @generated
	 */
	int CLOSE_EDITOR = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR__PATH = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Close Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl <em>Create Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCreateModel()
	 * @generated
	 */
	int CREATE_MODEL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MODEL__NAME = ECLIPSE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MODEL__DOCUMENTATION = ECLIPSE_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MODEL__MODEL_NAME = ECLIPSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MODEL__PATH = ECLIPSE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MODEL__ROOT = ECLIPSE_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MODEL_FEATURE_COUNT = ECLIPSE_ACTION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseAction <em>Eclipse Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eclipse Action</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseAction
	 * @generated
	 */
	EClass getEclipseAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject <em>Create Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Project</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject
	 * @generated
	 */
	EClass getCreateProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject#getProjectName()
	 * @see #getCreateProject()
	 * @generated
	 */
	EAttribute getCreateProject_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective <em>Open Perspective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Perspective</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective
	 * @generated
	 */
	EClass getOpenPerspective();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective#getType()
	 * @see #getOpenPerspective()
	 * @generated
	 */
	EAttribute getOpenPerspective_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject <em>Close Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Project</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject
	 * @generated
	 */
	EClass getCloseProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject#getProjectName()
	 * @see #getCloseProject()
	 * @generated
	 */
	EAttribute getCloseProject_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.Save <em>Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Save</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.Save
	 * @generated
	 */
	EClass getSave();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.Undo <em>Undo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Undo</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.Undo
	 * @generated
	 */
	EClass getUndo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.Redo <em>Redo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redo</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.Redo
	 * @generated
	 */
	EClass getRedo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.OpenProject <em>Open Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Project</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.OpenProject
	 * @generated
	 */
	EClass getOpenProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.OpenProject#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.OpenProject#getProjectName()
	 * @see #getOpenProject()
	 * @generated
	 */
	EAttribute getOpenProject_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject <em>Remove Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Project</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject
	 * @generated
	 */
	EClass getRemoveProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject#getProjectName()
	 * @see #getRemoveProject()
	 * @generated
	 */
	EAttribute getRemoveProject_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor <em>Close Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Editor</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor
	 * @generated
	 */
	EClass getCloseEditor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor#getPath()
	 * @see #getCloseEditor()
	 * @generated
	 */
	EAttribute getCloseEditor_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel <em>Create Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Model</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel
	 * @generated
	 */
	EClass getCreateModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel#getModelName()
	 * @see #getCreateModel()
	 * @generated
	 */
	EAttribute getCreateModel_ModelName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel#getPath()
	 * @see #getCreateModel()
	 * @generated
	 */
	EAttribute getCreateModel_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel#getRoot()
	 * @see #getCreateModel()
	 * @generated
	 */
	EReference getCreateModel_Root();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EclipseActionsFactory getEclipseActionsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionImpl <em>Eclipse Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getEclipseAction()
		 * @generated
		 */
		EClass ECLIPSE_ACTION = eINSTANCE.getEclipseAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateProjectImpl <em>Create Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateProjectImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCreateProject()
		 * @generated
		 */
		EClass CREATE_PROJECT = eINSTANCE.getCreateProject();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_PROJECT__PROJECT_NAME = eINSTANCE.getCreateProject_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenPerspectiveImpl <em>Open Perspective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenPerspectiveImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getOpenPerspective()
		 * @generated
		 */
		EClass OPEN_PERSPECTIVE = eINSTANCE.getOpenPerspective();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_PERSPECTIVE__TYPE = eINSTANCE.getOpenPerspective_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseProjectImpl <em>Close Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseProjectImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCloseProject()
		 * @generated
		 */
		EClass CLOSE_PROJECT = eINSTANCE.getCloseProject();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSE_PROJECT__PROJECT_NAME = eINSTANCE.getCloseProject_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.SaveImpl <em>Save</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.SaveImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getSave()
		 * @generated
		 */
		EClass SAVE = eINSTANCE.getSave();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.UndoImpl <em>Undo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.UndoImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getUndo()
		 * @generated
		 */
		EClass UNDO = eINSTANCE.getUndo();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RedoImpl <em>Redo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RedoImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getRedo()
		 * @generated
		 */
		EClass REDO = eINSTANCE.getRedo();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenProjectImpl <em>Open Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenProjectImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getOpenProject()
		 * @generated
		 */
		EClass OPEN_PROJECT = eINSTANCE.getOpenProject();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_PROJECT__PROJECT_NAME = eINSTANCE.getOpenProject_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RemoveProjectImpl <em>Remove Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.RemoveProjectImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getRemoveProject()
		 * @generated
		 */
		EClass REMOVE_PROJECT = eINSTANCE.getRemoveProject();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOVE_PROJECT__PROJECT_NAME = eINSTANCE.getRemoveProject_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseEditorImpl <em>Close Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CloseEditorImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCloseEditor()
		 * @generated
		 */
		EClass CLOSE_EDITOR = eINSTANCE.getCloseEditor();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSE_EDITOR__PATH = eINSTANCE.getCloseEditor_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl <em>Create Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl
		 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsPackageImpl#getCreateModel()
		 * @generated
		 */
		EClass CREATE_MODEL = eINSTANCE.getCreateModel();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_MODEL__MODEL_NAME = eINSTANCE.getCreateModel_ModelName();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_MODEL__PATH = eINSTANCE.getCreateModel_Path();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_MODEL__ROOT = eINSTANCE.getCreateModel_Root();

	}

} //EclipseActionsPackage
