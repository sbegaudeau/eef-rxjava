/**
 * <copyright>
 * </copyright>
 *
 * $Id: EclipseActionsPackageImpl.java,v 1.2 2011/04/11 16:48:02 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EclipseActions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.eef.extended.editor.EditorPackage;

import org.eclipse.emf.eef.extended.query.QueryPackage;

import org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage;

import org.eclipse.emf.eef.modelingBot.EEFActions.impl.EEFActionsPackageImpl;

import org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseAction;
import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsFactory;
import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage;
import org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective;
import org.eclipse.emf.eef.modelingBot.EclipseActions.OpenProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Redo;
import org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Save;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Undo;

import org.eclipse.emf.eef.modelingBot.ModelingBotPackage;

import org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EclipseActionsPackageImpl extends EPackageImpl implements EclipseActionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclipseActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openPerspectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass undoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createModelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EclipseActionsPackageImpl() {
		super(eNS_URI, EclipseActionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EclipseActionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EclipseActionsPackage init() {
		if (isInited) return (EclipseActionsPackage)EPackage.Registry.INSTANCE.getEPackage(EclipseActionsPackage.eNS_URI);

		// Obtain or create and register package
		EclipseActionsPackageImpl theEclipseActionsPackage = (EclipseActionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EclipseActionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EclipseActionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditorPackage.eINSTANCE.eClass();
		QueryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelingBotPackageImpl theModelingBotPackage = (ModelingBotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingBotPackage.eNS_URI) instanceof ModelingBotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingBotPackage.eNS_URI) : ModelingBotPackage.eINSTANCE);
		EEFActionsPackageImpl theEEFActionsPackage = (EEFActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EEFActionsPackage.eNS_URI) instanceof EEFActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EEFActionsPackage.eNS_URI) : EEFActionsPackage.eINSTANCE);

		// Create package meta-data objects
		theEclipseActionsPackage.createPackageContents();
		theModelingBotPackage.createPackageContents();
		theEEFActionsPackage.createPackageContents();

		// Initialize created meta-data
		theEclipseActionsPackage.initializePackageContents();
		theModelingBotPackage.initializePackageContents();
		theEEFActionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEclipseActionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EclipseActionsPackage.eNS_URI, theEclipseActionsPackage);
		return theEclipseActionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEclipseAction() {
		return eclipseActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateProject() {
		return createProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateProject_ProjectName() {
		return (EAttribute)createProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenPerspective() {
		return openPerspectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenPerspective_Type() {
		return (EAttribute)openPerspectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseProject() {
		return closeProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloseProject_ProjectName() {
		return (EAttribute)closeProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSave() {
		return saveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUndo() {
		return undoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedo() {
		return redoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenProject() {
		return openProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenProject_ProjectName() {
		return (EAttribute)openProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveProject() {
		return removeProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoveProject_ProjectName() {
		return (EAttribute)removeProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseEditor() {
		return closeEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloseEditor_Path() {
		return (EAttribute)closeEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateModel() {
		return createModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateModel_ModelName() {
		return (EAttribute)createModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateModel_Path() {
		return (EAttribute)createModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateModel_Root() {
		return (EReference)createModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseActionsFactory getEclipseActionsFactory() {
		return (EclipseActionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eclipseActionEClass = createEClass(ECLIPSE_ACTION);

		createProjectEClass = createEClass(CREATE_PROJECT);
		createEAttribute(createProjectEClass, CREATE_PROJECT__PROJECT_NAME);

		openPerspectiveEClass = createEClass(OPEN_PERSPECTIVE);
		createEAttribute(openPerspectiveEClass, OPEN_PERSPECTIVE__TYPE);

		closeProjectEClass = createEClass(CLOSE_PROJECT);
		createEAttribute(closeProjectEClass, CLOSE_PROJECT__PROJECT_NAME);

		saveEClass = createEClass(SAVE);

		undoEClass = createEClass(UNDO);

		redoEClass = createEClass(REDO);

		openProjectEClass = createEClass(OPEN_PROJECT);
		createEAttribute(openProjectEClass, OPEN_PROJECT__PROJECT_NAME);

		removeProjectEClass = createEClass(REMOVE_PROJECT);
		createEAttribute(removeProjectEClass, REMOVE_PROJECT__PROJECT_NAME);

		closeEditorEClass = createEClass(CLOSE_EDITOR);
		createEAttribute(closeEditorEClass, CLOSE_EDITOR__PATH);

		createModelEClass = createEClass(CREATE_MODEL);
		createEAttribute(createModelEClass, CREATE_MODEL__MODEL_NAME);
		createEAttribute(createModelEClass, CREATE_MODEL__PATH);
		createEReference(createModelEClass, CREATE_MODEL__ROOT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelingBotPackage theModelingBotPackage = (ModelingBotPackage)EPackage.Registry.INSTANCE.getEPackage(ModelingBotPackage.eNS_URI);
		EditorPackage theEditorPackage = (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eclipseActionEClass.getESuperTypes().add(theModelingBotPackage.getAction());
		createProjectEClass.getESuperTypes().add(this.getEclipseAction());
		openPerspectiveEClass.getESuperTypes().add(this.getEclipseAction());
		closeProjectEClass.getESuperTypes().add(this.getEclipseAction());
		saveEClass.getESuperTypes().add(this.getEclipseAction());
		undoEClass.getESuperTypes().add(this.getEclipseAction());
		redoEClass.getESuperTypes().add(this.getEclipseAction());
		openProjectEClass.getESuperTypes().add(this.getEclipseAction());
		removeProjectEClass.getESuperTypes().add(this.getEclipseAction());
		closeEditorEClass.getESuperTypes().add(this.getEclipseAction());
		createModelEClass.getESuperTypes().add(this.getEclipseAction());
		createModelEClass.getESuperTypes().add(theEditorPackage.getReferenceableObject());

		// Initialize classes and features; add operations and parameters
		initEClass(eclipseActionEClass, EclipseAction.class, "EclipseAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createProjectEClass, CreateProject.class, "CreateProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateProject_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, CreateProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openPerspectiveEClass, OpenPerspective.class, "OpenPerspective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenPerspective_Type(), ecorePackage.getEString(), "type", null, 0, 1, OpenPerspective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closeProjectEClass, CloseProject.class, "CloseProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloseProject_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, CloseProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(saveEClass, Save.class, "Save", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(undoEClass, Undo.class, "Undo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(redoEClass, Redo.class, "Redo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openProjectEClass, OpenProject.class, "OpenProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenProject_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, OpenProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeProjectEClass, RemoveProject.class, "RemoveProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRemoveProject_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, RemoveProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closeEditorEClass, CloseEditor.class, "CloseEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloseEditor_Path(), ecorePackage.getEString(), "path", null, 0, 1, CloseEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createModelEClass, CreateModel.class, "CreateModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateModel_ModelName(), ecorePackage.getEString(), "modelName", null, 0, 1, CreateModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateModel_Path(), ecorePackage.getEString(), "path", null, 0, 1, CreateModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateModel_Root(), theEcorePackage.getEClass(), null, "root", null, 0, 1, CreateModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //EclipseActionsPackageImpl
