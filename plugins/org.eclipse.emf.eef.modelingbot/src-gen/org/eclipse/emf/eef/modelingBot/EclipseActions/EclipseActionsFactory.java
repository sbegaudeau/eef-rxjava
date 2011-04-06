/**
 * <copyright>
 * </copyright>
 *
 * $Id: EclipseActionsFactory.java,v 1.1 2011/04/06 13:07:27 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EclipseActions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage
 * @generated
 */
public interface EclipseActionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EclipseActionsFactory eINSTANCE = org.eclipse.emf.eef.modelingBot.EclipseActions.impl.EclipseActionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Create Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Project</em>'.
	 * @generated
	 */
	CreateProject createCreateProject();

	/**
	 * Returns a new object of class '<em>Open Perspective</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Perspective</em>'.
	 * @generated
	 */
	OpenPerspective createOpenPerspective();

	/**
	 * Returns a new object of class '<em>Close Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Project</em>'.
	 * @generated
	 */
	CloseProject createCloseProject();

	/**
	 * Returns a new object of class '<em>Save</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Save</em>'.
	 * @generated
	 */
	Save createSave();

	/**
	 * Returns a new object of class '<em>Undo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Undo</em>'.
	 * @generated
	 */
	Undo createUndo();

	/**
	 * Returns a new object of class '<em>Redo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Redo</em>'.
	 * @generated
	 */
	Redo createRedo();

	/**
	 * Returns a new object of class '<em>Open Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Project</em>'.
	 * @generated
	 */
	OpenProject createOpenProject();

	/**
	 * Returns a new object of class '<em>Remove Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Project</em>'.
	 * @generated
	 */
	RemoveProject createRemoveProject();

	/**
	 * Returns a new object of class '<em>Close Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Editor</em>'.
	 * @generated
	 */
	CloseEditor createCloseEditor();

	/**
	 * Returns a new object of class '<em>Create Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Model</em>'.
	 * @generated
	 */
	CreateModel createCreateModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EclipseActionsPackage getEclipseActionsPackage();

} //EclipseActionsFactory
