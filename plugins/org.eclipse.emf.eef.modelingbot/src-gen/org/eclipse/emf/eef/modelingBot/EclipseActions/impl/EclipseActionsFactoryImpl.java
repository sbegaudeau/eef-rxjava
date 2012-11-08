/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot.EclipseActions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.eef.modelingBot.EclipseActions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EclipseActionsFactoryImpl extends EFactoryImpl implements EclipseActionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EclipseActionsFactory init() {
		try {
			EclipseActionsFactory theEclipseActionsFactory = (EclipseActionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/eef/test/EclipseActions/1.0.0"); 
			if (theEclipseActionsFactory != null) {
				return theEclipseActionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EclipseActionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseActionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EclipseActionsPackage.CREATE_PROJECT: return createCreateProject();
			case EclipseActionsPackage.OPEN_PERSPECTIVE: return createOpenPerspective();
			case EclipseActionsPackage.CLOSE_PROJECT: return createCloseProject();
			case EclipseActionsPackage.SAVE: return createSave();
			case EclipseActionsPackage.UNDO: return createUndo();
			case EclipseActionsPackage.REDO: return createRedo();
			case EclipseActionsPackage.OPEN_PROJECT: return createOpenProject();
			case EclipseActionsPackage.REMOVE_PROJECT: return createRemoveProject();
			case EclipseActionsPackage.CLOSE_EDITOR: return createCloseEditor();
			case EclipseActionsPackage.OPEN_EDITOR: return createOpenEditor();
			case EclipseActionsPackage.CREATE_MODEL: return createCreateModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateProject createCreateProject() {
		CreateProjectImpl createProject = new CreateProjectImpl();
		return createProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenPerspective createOpenPerspective() {
		OpenPerspectiveImpl openPerspective = new OpenPerspectiveImpl();
		return openPerspective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseProject createCloseProject() {
		CloseProjectImpl closeProject = new CloseProjectImpl();
		return closeProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Save createSave() {
		SaveImpl save = new SaveImpl();
		return save;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Undo createUndo() {
		UndoImpl undo = new UndoImpl();
		return undo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Redo createRedo() {
		RedoImpl redo = new RedoImpl();
		return redo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenProject createOpenProject() {
		OpenProjectImpl openProject = new OpenProjectImpl();
		return openProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveProject createRemoveProject() {
		RemoveProjectImpl removeProject = new RemoveProjectImpl();
		return removeProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseEditor createCloseEditor() {
		CloseEditorImpl closeEditor = new CloseEditorImpl();
		return closeEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenEditor createOpenEditor() {
		OpenEditorImpl openEditor = new OpenEditorImpl();
		return openEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateModel createCreateModel() {
		CreateModelImpl createModel = new CreateModelImpl();
		return createModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseActionsPackage getEclipseActionsPackage() {
		return (EclipseActionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EclipseActionsPackage getPackage() {
		return EclipseActionsPackage.eINSTANCE;
	}

} //EclipseActionsFactoryImpl
