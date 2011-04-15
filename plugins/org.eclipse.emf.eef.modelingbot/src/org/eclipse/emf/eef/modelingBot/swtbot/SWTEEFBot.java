/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.eef.modelingBot.swtbot;

import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.helper.EEFModelHelper;
import org.eclipse.emf.eef.modelingBot.helper.PropertiesEditionHelper;
import org.eclipse.emf.eef.modelingBot.helper.SWTBotHelper;
import org.eclipse.emf.eef.modelingBot.helper.SWTEEFBotHelper;
import org.eclipse.emf.eef.modelingBot.helper.StringHelper;
import org.eclipse.emf.eef.modelingBot.helper.UIConstants;
import org.eclipse.emf.eef.modelingBot.interpreter.EEFInterpreter;
import org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter;
import org.eclipse.emf.eef.modelingBot.uri.EEFURIConverter;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.View;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

/**
 * SWTBot bor for EEF editor.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SWTEEFBot extends SWTWorkbenchBot implements IModelingBot {

	/**
	 * EEF Interpreter
	 */
	private EEFInterpreter interpreter;

	/**
	 * The ResourceSet where to operate.
	 */
	protected EditingDomain editingDomain = new AdapterFactoryEditingDomain(
			EEFRuntimePlugin.getDefault().getAdapterFactory(),
			new BasicCommandStack());

	/**
	 * The swtbot editor.
	 */
	private SWTBotEditor editor;

	/**
	 * The test model resource.
	 */
	private Resource testModelResource;

	/**
	 * Helper to edit feature.
	 */
	private PropertiesEditionHelper propertiesEdition;

	/**
	 * Sequence type : wizard, detail page, properties view...
	 */
	private SequenceType sequenceType;

	/**
	 * Bot Helper.
	 */
	private SWTEEFBotHelper helper;

	/**
	 * Create a SWTEEFBot.
	 */
	public SWTEEFBot() {
		super();
		editingDomain.getResourceSet().setURIConverter(new EEFURIConverter());
		interpreter = new EEFInterpreter(this, editingDomain);
		propertiesEdition = new PropertiesEditionHelper(this);
		helper = new SWTEEFBotHelper(this);
	}

	/**
	 * Open the properties view
	 */
	public void openPropertiesView() {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.SHOW_VIEW_MENU)
				.menu(UIConstants.OTHER_MENU).click();

		SWTBotShell shell = shell(UIConstants.SHOW_VIEW_MENU);
		activateShell(shell);

		SWTBotTree viewSelectionTree = tree();
		viewSelectionTree.expandNode(UIConstants.GENERAL_MENU).select(
				UIConstants.PROPERTIES_VIEW_NAME);
		button(UIConstants.OK_BUTTON).click();
		waitUntil(Conditions.shellCloses(shell));
	}

	/**
	 * Open Java Perspective
	 */
	public void openJavaPerspective() {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.OPEN_PERSPECTIVE_MENU)
				.menu(UIConstants.OTHER_MENU).click();
		SWTBotShell openPerspectiveShell = shell(UIConstants.OPEN_PERSPECTIVE_MENU);
		activateShell(openPerspectiveShell);

		try {
			table().select(UIConstants.JAVA_LABEL);
		} catch (IllegalArgumentException e) {
			table().select(UIConstants.JAVA_DEFAULT_LABEL);
		}
		button(UIConstants.OK_BUTTON).click();
	}

	/**
	 * Activate the shell
	 * 
	 * @param shell SWTBotShell
	 */
	public void activateShell(SWTBotShell shell) {
		shell.activate();
	}

	/**
	 * This method close the welcome page if we use the workspace of test for
	 * the first time
	 */
	public void closeWelcomePage() {
		try {
			viewByTitle(UIConstants.WELCOME_LABEL).close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#createProject(java.lang.String)
	 */
	public void createProject(String projectName) {
		activateShell(shells()[0]);
		menu(UIConstants.FILE_MENU).menu(UIConstants.PROJECT_MENU).click();
		SWTBotShell openProjectShell = shell(UIConstants.NEW_PROJECT_MENU);
		activateShell(openProjectShell);

		tree().expandNode(UIConstants.GENERAL_MENU).select(
				UIConstants.PROJECT_CREATION_MENU);
		button(UIConstants.NEXT_BUTTON).click();
		text().setText(projectName);
		button(UIConstants.FINISH_BUTTON).click();
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openProject(java.lang.String)
	 */
	public void openProject(String projectName) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(projectName);
		SWTBotHelper.clickContextMenu(treeItem, UIConstants.OPEN_PROJECT_MENU);
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#closeProject(java.lang.String)
	 */
	public void closeProject(String projectName) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(projectName);
		SWTBotHelper.clickContextMenu(treeItem, UIConstants.CLOSE_PROJECT_MENU);
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#removeProject(java.lang.String)
	 */
	public void removeProject(String projectName) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(projectName);
		SWTBotHelper.clickContextMenu(treeItem, UIConstants.DELETE_MENU);
		checkBox().select();
		button(UIConstants.OK_BUTTON).click();
		SWTBotHelper.waitAllUiEvents();
		sleep(3000);
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openPerspective(java.lang.String)
	 */
	public void openPerspective(String name) {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.OPEN_PERSPECTIVE_MENU)
				.menu(UIConstants.OTHER_MENU).click();
		SWTBotShell openPerspectiveShell = shell(UIConstants.OPEN_PERSPECTIVE_MENU);
		activateShell(openPerspectiveShell);

		try {
			table().select(name);
		} catch (IllegalArgumentException e) {
			table().select(UIConstants.JAVA_DEFAULT_LABEL);
		}
		button(UIConstants.OK_BUTTON).click();

	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openEEFEditor(java.lang.String)
	 */
	public void openEEFEditor(String path) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(path);
		SWTBotHelper.clickContextMenu(treeItem,
				UIConstants.INTERACTIVE_EEF_EDITOR_MENU);
	}

	private SWTBotTreeItem selectInProjectExplorer(String path) {
		SWTBotTree wizardTree = viewByTitle(
				UIConstants.PACKAGE_EXPLORER_VIEW_NAME).bot().tree();
		String[] split = path.split("/");
		SWTBotTreeItem treeItem = wizardTree.expandNode(split[0]).select();
		for (int i = 1; i < split.length; i++) {
			treeItem = treeItem.expandNode(split[i]).select();
		}
		return treeItem;
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#closeEditor(java.lang.String)
	 */
	public void closeEditor(String path) {
		selectInProjectExplorer(path);
		menu(UIConstants.FILE_MENU).menu(UIConstants.CLOSE_MENU).click();
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#save()
	 */
	public void save() {
		SWTBotHelper.waitAllUiEvents();
		sleep(1000);
		menu(UIConstants.FILE_MENU).menu(UIConstants.SAVE_MENU).click();
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#add(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EClass)
	 */
	public EObject add(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			final EStructuralFeature eContainingFeature, EClass type) {
		if (propertiesEditionElement != null) {
			// work on table composition
			return add(propertiesEditionElement, referenceableObject);
		} else {
			// work on context menu
			return add(referenceableObject, eContainingFeature);
		}

	}

	/**
	 * Add PropertiesEditionElement
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 * @return
	 */
	private EObject add(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		SWTBotHelper.waitAllUiEvents();
		assertNotNull("The editeur is not opened.", editor);
		EObject container = getEObjectFromReferenceableEObject(referenceableObject);
		assertNotNull("No container is found to launch wizard.", container);
		SWTBotHelper.waitAllUiEvents();
		final SWTBotTreeItem selectNode = selectNode(editor, container);
		assertNotNull("No element is selected in the editor", selectNode);
		initTab(propertiesEditionElement);
		assertFalse("The set action must be define in a sequence.",
				sequenceType == null);
		propertiesEdition.addFeature(selectNode, propertiesEditionElement,
				sequenceType);
		SWTBotHelper.waitAllUiEvents();
		return (EObject) EEFModelHelper.eGet(container,
				propertiesEditionElement.getModel());
	}

	/**
	 * Add ReferenceableObject
	 * @param referenceableObject
	 * @param eContainingFeature
	 * @return
	 */
	private EObject add(ReferenceableObject referenceableObject,
			final EStructuralFeature eContainingFeature) {
		assertNotNull("The editeur is not opened.", editor);
		final EObject container = getEObjectFromReferenceableEObject(referenceableObject);
		assertNotNull("No container is found to launch add action.",
				container);
		SWTBotTreeItem selectNode = selectNode(editor, container);
		assertNotNull("No element is selected in the editor", selectNode);
		SWTBotHelper.clickContextMenu(selectNode, eContainingFeature
				.getEType().getName());
		SWTBotHelper.waitAllUiEvents();
		return (EObject) EEFModelHelper.eGet(container, eContainingFeature);
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#remove(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject)
	 */
	public void remove(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		if (propertiesEditionElement != null) {
			// work on table composition
			removePropertiesEditionElement(propertiesEditionElement,
					referenceableObject);
		} else {
			// work on context menu
			remove(referenceableObject);
		}
	}

	/**
	 * Remove propertiesEditionElement
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 */
	private void removePropertiesEditionElement(
			PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		SWTBotHelper.waitAllUiEvents();
		assertNotNull("The editeur is not opened.", editor);
		EObject remove = getEObjectFromReferenceableEObject(referenceableObject);
		assertNotNull("Element to remove does not exist.", remove);
		EObject container = remove.eContainer();
		assertNotNull("The container of the element to remove does not exist.", container);
		SWTBotHelper.waitAllUiEvents();
		final SWTBotTreeItem selectNode = selectNode(editor, container);
		assertNotNull("No element is selected in the editor", selectNode);
		initTab(propertiesEditionElement);
		assertFalse("The set action must be define in a sequence.",
				sequenceType == null);
		propertiesEdition.removeFeature(remove, propertiesEditionElement,
				sequenceType);
		SWTBotHelper.waitAllUiEvents();
	}

	/**
	 * Remove referenceableObject
	 * @param referenceableObject
	 */
	private void remove(ReferenceableObject referenceableObject) {
		assertNotNull("The editeur is not opened.", editor);
		final EObject container = getEObjectFromReferenceableEObject(referenceableObject);
		assertNotNull("No container is found to launch add action.",
				container);
		SWTBotTreeItem selectNode = selectNode(editor, container);
		assertNotNull("No element is selected in the editor", selectNode);
		SWTBotHelper.clickContextMenu(selectNode, UIConstants.DELETE_MENU);
		SWTBotHelper.waitAllUiEvents();
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#set(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.String)
	 */
	public void set(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, String value) {
		SWTBotHelper.waitAllUiEvents();
		assertNotNull("The properties edition element is not set.",
				propertiesEditionElement);
		assertNotNull("The editeur is not opened.", editor);
		EObject container = getEObjectFromReferenceableEObject(referenceableObject);
		assertNotNull("No container is found to launch add action.", container);
		SWTBotHelper.waitAllUiEvents();
		assertFalse("The set action must be define in a sequence.",
				sequenceType == null);
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			final SWTBotTreeItem selectNode = selectNode(editor, container);
			assertNotNull("No element is selected in the editor", selectNode);
			initTab(propertiesEditionElement);
			propertiesEdition.updateFeature(selectNode,
					propertiesEditionElement, value, sequenceType);
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
			propertiesEdition.updateFeature(null, propertiesEditionElement,
					value, sequenceType);
		}
	}

	/**
	 * Select the tab defined in the PEE
	 * @param propertiesEditionElement PropertiesEditionElement
	 */
	protected void initTab(PropertiesEditionElement propertiesEditionElement) {
		assertFalse(propertiesEditionElement.getViews().isEmpty());
		ElementEditor elementEditor = propertiesEditionElement.getViews()
				.get(0);
		View view = EEFModelHelper.getView(elementEditor);
		if (view.getName() != null) {
			cTabItem(view.getName()).activate();
			cTabItem(view.getName()).setFocus();
		}
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#set(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.eef.extended.editor.ReferenceableObject)
	 */
	public void set(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, ReferenceableObject value) {
		// TODO Auto-generated method stub

	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#unset(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void unset(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature) {
		set(propertiesEditionElement, referenceableObject, eContainingFeature,
				"");
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#runModelingBot(java.lang.String)
	 */
	public void runModelingBot(String path) throws CoreException, IOException {
		interpreter.runModelingBot(path);
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#createModel(java.lang.String, java.lang.String, org.eclipse.emf.ecore.EClass)
	 */
	public EObject createModel(String path, String modelName, EClass root) {
		String[] split = modelName.split("\\.");
		final String extension = split[split.length - 1];

		selectInProjectExplorer(path);

		menu(UIConstants.FILE_MENU).menu(UIConstants.OTHER_MENU).click();
		SWTBotShell newFileShell = shell(UIConstants.NEW);
		activateShell(newFileShell);

		createModel(modelName, root, extension);

		// close the default editor
		menu(UIConstants.FILE_MENU).menu(UIConstants.CLOSE_MENU).click();

		// open with EEF Editor
		openWithEEFEditor(path, modelName);

		editor = editorByTitle(modelName);
		return getRoot(path, modelName);
	}

	/**
	 * @param path
	 * @param modelName
	 * @return the root of the new resource
	 */
	private EObject getRoot(String path, String modelName) {
		URI fileURI = URI.createPlatformResourceURI(path + "/" + modelName,
				true);
		Resource resource = editingDomain.getResourceSet().getResource(fileURI,
				true);
		setTestModelResource(resource);
		final SWTBotTreeItem modelTreeItem = editor.bot().tree()
				.getTreeItem(testModelResource.getURI().toString());

		resource = (Resource) syncExec(new Result<Object>() {

			public Object run() {
				return modelTreeItem.widget.getData();
			}
		});
		setTestModelResource(resource);
		assertFalse("The model is empty.", resource.getContents().isEmpty());
		return resource.getContents().get(0);
	}

	/**
	 * Open eef editor
	 * @param path
	 * @param modelName
	 */
	private void openWithEEFEditor(String path, String modelName) {
		SWTBotTree wizardTree = viewByTitle(
				UIConstants.PACKAGE_EXPLORER_VIEW_NAME).bot().tree();
		SWTBotTreeItem treeItem = wizardTree.expandNode(path)
				.expandNode(modelName).select();
		SWTBotHelper.clickContextMenu(treeItem,
				UIConstants.OPEN_WITH_INTERACTIVE_EEF_EDITOR_MENU);
	}

	/**
	 * Create the new model
	 * @param modelName
	 * @param root
	 * @param extension
	 */
	private void createModel(String modelName, EClass root,
			final String extension) {
		String modelType = StringHelper.toU1Case(extension) + " Model";
		SWTBotTreeItem item = tree().expandNode("EMF Editing Framework").expandNode(
		"EMF Model").select();
		assertNotNull("The model " + modelType + " can not be created.",
				item);
		button(UIConstants.NEXT_BUTTON).click();
		
		button("Browse Registered Packages...").click();
		String nsURI = interpreter.getPropertiesEditionContext().getModel().getEcorePackage().getNsURI();
		table().getTableItem(nsURI).select();
		button(UIConstants.OK_BUTTON).click();
		button(UIConstants.NEXT_BUTTON).click();

		textWithLabel(IDEWorkbenchMessages.WizardNewFileCreationPage_fileLabel)
				.setText(modelName);
		button(UIConstants.NEXT_BUTTON).click();
		assertNotNull("The class " + root.toString() + " can not be loaded",
				root.getName());

		comboBox().setSelection(root.getName());
		button(UIConstants.FINISH_BUTTON).click();
	}

	/**
	 * @param ref ReferenceableObject
	 * @return the object corresponding to the ReferenceableObject
	 */
	public EObject getEObjectFromReferenceableEObject(ReferenceableObject ref) {
		return interpreter.getEObjectFromReferenceableEObject(ref);
	}

	/**
	 * Select the given element in the given editor
	 * 
	 * @param editor
	 *            the editor where the bot must process
	 * @param element
	 *            the element to select
	 * @return the selected node
	 */
	public SWTBotTreeItem selectNode(SWTBotEditor editor, EObject element) {
		assertNotNull("The model has not been initialized.", testModelResource);
		List<Object> expansionPath = EEFModelHelper.getExpansionPath(element);
		Iterator<Object> iterator = expansionPath.iterator();
		Object next = null;
		SWTBotTreeItem node2 = editor.bot().tree()
				.getTreeItem(testModelResource.getURI().toString());
		while (iterator.hasNext()) {
			sleep(1000);
			node2.expand();
			next = iterator.next();
			node2 = selectSubNode(node2, next);
		}
		return node2;
	}

	/**
	 * Select the given element in the given editor
	 * 
	 * @param editor
	 *            the editor where the bot must process
	 * @param element
	 *            the element to select
	 * @return the selected node
	 */
	public SWTBotTreeItem selectNode(SWTBotTree tree, EObject element) {
		assertNotNull("The model has not been initialized.", testModelResource);
		List<Object> expansionPath = EEFModelHelper.getExpansionPath(element);
		Iterator<Object> iterator = expansionPath.iterator();
		Object next = null;
		SWTBotTreeItem node2 = tree.getTreeItem(testModelResource.getURI()
				.toString());
		while (iterator.hasNext()) {
			node2.expand();
			next = iterator.next();
			node2 = selectSubNode(node2, next);
		}
		return node2;
	}

	/**
	 * Select the object <code>next</code> as a subnode of the
	 * <code>currentNode</code>
	 * 
	 * @param currentNode
	 *            the currentNode
	 * @param next
	 *            the subnode to select
	 * @return the selected node
	 */
	private SWTBotTreeItem selectSubNode(SWTBotTreeItem currentNode, Object next) {
		AdapterFactory adapterFactory = EEFRuntimePlugin.getDefault()
				.getAdapterFactory();
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory
				.adapt(next, IItemLabelProvider.class);
		String text = labelProvider.getText(next);
		SWTBotTreeItem node2 = currentNode.getNode(text);
		node2.select();
		return node2;
	}

	/**
	 * Set the test model resource.
	 * @param resource Resource
	 */
	public void setTestModelResource(Resource resource) {
		this.testModelResource = resource;
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#getActiveResource()
	 */
	public Resource getActiveResource() {
		return testModelResource;
	}

	/**
	 * @param viewID
	 *            the edited advEOFCV
	 * @return the browse button of the given advEOFCV
	 */
	public SWTBotButton addButtonAdvancedTableComposition(String viewID) {
		return helper.addButtonAdvancedTableComposition(viewID);
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#cancel()
	 */
	public void cancel() {
		button(UIConstants.CANCEL_BUTTON).click();
	}

	/**
	 * Dispose the interpreter.
	 */
	public void dispose() {
		interpreter.dispose();
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#validateBatchEditing()
	 */
	public void validateBatchEditing() {
		button(UIConstants.FINISH_BUTTON).click();
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#setSequenceType(org.eclipse.emf.eef.modelingBot.SequenceType)
	 */
	public void setSequenceType(SequenceType sequenceType) {
		this.sequenceType = sequenceType;
	}
	
	/**
	 * @param viewID the edited advEOFCV
	 * @return the remove button of the given advEOFCV
	 */
	public SWTBotButton removeButtonAdvancedTableComposition(String viewID) {
		return helper.removeButtonAdvancedTableComposition(viewID);
	}

	/**
	 * Select the object in the advanced table composition
	 * @param eefWidgetIdKey widget key
	 * @param qualifiedIdentifier identifier of the PEE
	 * @param selected object to select
	 */
	public void selectInTableWithId(String eefWidgetIdKey,
			String qualifiedIdentifier, EObject selected) {
		SWTBotTable table = tableWithId(eefWidgetIdKey, qualifiedIdentifier);
		SWTBotTableItem tableItem = getTableItem(table, selected);
		assertNotNull("No table item is found.", tableItem);
		tableItem.select();
	}

	/**
	 * @param table
	 * @param object
	 * @return the table item corresponding to the object
	 */
	private SWTBotTableItem getTableItem(SWTBotTable table, EObject object) {
		for (int i = 0; i < table.rowCount(); i++) {
			final SWTBotTableItem tableItem = table.getTableItem(i);
			Object data = syncExec(new Result<Object>() {

				public Object run() {
					return tableItem.widget.getData();
				}
			});
			if (data.equals(object)) {
				return table.getTableItem(i);
			}
		}
		return null;
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#check()
	 */
	public void check() {
		
	}
	
	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#getModelingBotInterpreter()
	 */
	public IModelingBotInterpreter getModelingBotInterpreter() {
		return interpreter;
	}
}
