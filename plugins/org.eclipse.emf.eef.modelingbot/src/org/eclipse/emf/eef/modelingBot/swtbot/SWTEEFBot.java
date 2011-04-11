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
import java.util.ArrayList;
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
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.interpreter.EEFInterpreter;
import org.eclipse.emf.eef.modelingBot.uri.EEFURIConverter;
import org.eclipse.emf.eef.modelingBot.utils.EEFModelUtils;
import org.eclipse.emf.eef.modelingBot.utils.SWTBotUtils;
import org.eclipse.emf.eef.modelingBot.utils.StringUtils;
import org.eclipse.emf.eef.modelingBot.utils.UIConstants;
import org.eclipse.emf.eef.modelingBot.widget.PropertiesEditionHelper;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.View;
import org.eclipse.emf.eef.views.ViewsRepository;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

/**
 * @author nlepine
 *
 */
public class SWTEEFBot extends SWTWorkbenchBot implements IModelingBot {
	
	private EEFInterpreter interpreter;
	
	/**
	 * The ResourceSet where to operate
	 */
	protected AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
			EEFRuntimePlugin.getDefault().getAdapterFactory(),
			new BasicCommandStack());

	private SWTBotEditor editor;

	private Resource testModelResource;

	private PropertiesEditionHelper propertiesEdition;
	
	private SequenceType sequenceType;
	
	private SWTEEFBotHelper helper;

	private String modelingBotPath;

	public String getModelingBotPath() {
		return modelingBotPath;
	}

	public void setSequenceType(SequenceType sequenceType) {
		this.sequenceType = sequenceType;
	}

	public SWTEEFBot() {
		super();
		editingDomain.getResourceSet().setURIConverter(new EEFURIConverter());
		interpreter = new EEFInterpreter(editingDomain);
		propertiesEdition = new PropertiesEditionHelper(this);
		helper = new SWTEEFBotHelper(this);
	}

	public void openPropertiesView() {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.SHOW_VIEW_MENU).menu(UIConstants.OTHER_MENU).click();

		SWTBotShell shell = shell(UIConstants.SHOW_VIEW_MENU);
		activateShell(shell);

		SWTBotTree viewSelectionTree = tree();
		viewSelectionTree.expandNode(UIConstants.GENERAL_MENU).select(UIConstants.PROPERTIES_VIEW_NAME);
		button(UIConstants.OK_BUTTON).click();
		waitUntil(Conditions.shellCloses(shell));
	}

	public void openJavaPerspective() {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.OPEN_PERSPECTIVE_MENU).menu(UIConstants.OTHER_MENU)
				.click();
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
	 * @param shell
	 */
	public void activateShell(SWTBotShell shell) {
		shell.activate();
	}

	/**
	 * This method close the welcome page if we use the workspace of test for the first time
	 */
	public void closeWelcomePage() {
		try {
			viewByTitle(UIConstants.WELCOME_LABEL).close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}

	public void createProject(String projectName) {
		activateShell(shells()[0]);
		menu(UIConstants.FILE_MENU).menu("Project...").click();
		SWTBotShell openProjectShell = shell("New Project");
		activateShell(openProjectShell);

		tree().expandNode("General").select("Project");
		button("Next >").click();
		text().setText(projectName);
		button(UIConstants.FINISH_BUTTON).click();
	}

	public void openProject(String projectName) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(projectName);
		SWTBotUtils.clickContextMenu(treeItem, "Open Project");
	}

	public void closeProject(String projectName) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(projectName);
		SWTBotUtils.clickContextMenu(treeItem, "Close Project");
	}

	public void removeProject(String projectName) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(projectName);
		SWTBotUtils.clickContextMenu(treeItem, "Delete");
		checkBox().select();
		button(UIConstants.OK_BUTTON).click();
		SWTBotUtils.waitAllUiEvents();
		sleep(1000);
	}

	public void openPerspective(String name) {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.OPEN_PERSPECTIVE_MENU).menu(UIConstants.OTHER_MENU)
		.click();
		SWTBotShell openPerspectiveShell = shell(UIConstants.OPEN_PERSPECTIVE_MENU);
		activateShell(openPerspectiveShell);

		try {
			table().select(name);
		} catch (IllegalArgumentException e) {
			table().select(UIConstants.JAVA_DEFAULT_LABEL);
		}
		button(UIConstants.OK_BUTTON).click();

	}

	public void openEEFEditor(String path) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(path);
		SWTBotUtils.clickContextMenu(treeItem, "Interactive EEF Editor");
	}

	private SWTBotTreeItem selectInProjectExplorer(String path) {
		SWTBotTree wizardTree = viewByTitle(UIConstants.PACKAGE_EXPLORER_VIEW_NAME).bot().tree();
		String[] split = path.split("/");
		SWTBotTreeItem treeItem = wizardTree.expandNode(split[0]).select();
		for (int i = 1; i < split.length; i++) {
			treeItem = treeItem.expandNode(split[i]).select();
		}
		return treeItem;
	}

	public void closeEditor(String path) {
		SWTBotTreeItem treeItem = selectInProjectExplorer(path);
		menu(UIConstants.FILE_MENU).menu("Close").click();
	}

	public void save() {
		SWTBotUtils.waitAllUiEvents();
		sleep(1000);
		menu(UIConstants.FILE_MENU).menu(UIConstants.SAVE_MENU).click();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#add(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EClass)
	 */
	public EObject add(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			final EStructuralFeature eContainingFeature, EClass type) {
		if (propertiesEditionElement!=null) {
			// work on table composition
			SWTBotUtils.waitAllUiEvents();
			assertNotNull("The editeur is not opened.", editor);
			EObject container = getEObjectFromReferenceableEObject(referenceableObject);
			assertNotNull("No container is found to launch wizard.",container);
			SWTBotUtils.waitAllUiEvents();
			final SWTBotTreeItem selectNode = selectNode(editor, container);
			assertNotNull("No element is selected in the editor",selectNode);
			initTab(propertiesEditionElement);
			assertFalse("The set action must be define in a sequence.", sequenceType==null);
			propertiesEdition.addFeature(selectNode, propertiesEditionElement, sequenceType);
			SWTBotUtils.waitAllUiEvents();
			return (EObject) EEFModelUtils.eGet(container, propertiesEditionElement.getModel());
		} else {
			// work on the model
			assertNotNull("The editeur is not opened.", editor);
			final EObject container = getEObjectFromReferenceableEObject(referenceableObject);
			assertNotNull("No container is found to launch add action.",container);
			SWTBotTreeItem selectNode = selectNode(editor, container);
			assertNotNull("No element is selected in the editor",selectNode);
			SWTBotUtils.clickContextMenu(selectNode, eContainingFeature.getEType().getName());
			SWTBotUtils.waitAllUiEvents();
			return (EObject) EEFModelUtils.eGet(container, eContainingFeature);
		}
		
	}

	public void remove(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		if (propertiesEditionElement!=null) {
			// work on widget
		} else {
			// work on the model
			assertNotNull("The editeur is not opened.", editor);
			final EObject container = getEObjectFromReferenceableEObject(referenceableObject);
			assertNotNull("No container is found to launch add action.",container);
			SWTBotTreeItem selectNode = selectNode(editor, container);
			assertNotNull("No element is selected in the editor",selectNode);
			SWTBotUtils.clickContextMenu(selectNode, "Delete");
			SWTBotUtils.waitAllUiEvents();
		}
	}

	public void set(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, String value) {
		SWTBotUtils.waitAllUiEvents();
		assertNotNull("The properties edition element is not set.", propertiesEditionElement);
		assertNotNull("The editeur is not opened.", editor);
		EObject container = getEObjectFromReferenceableEObject(referenceableObject);
		assertNotNull("No container is found to launch add action.",container);
		SWTBotUtils.waitAllUiEvents();
		assertFalse("The set action must be define in a sequence.", sequenceType==null);
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			final SWTBotTreeItem selectNode = selectNode(editor, container);
			assertNotNull("No element is selected in the editor",selectNode);
			initTab(propertiesEditionElement);
			propertiesEdition.updateFeature(selectNode, propertiesEditionElement, value, sequenceType);
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
			propertiesEdition.updateFeature(null, propertiesEditionElement, value, sequenceType);
		}
	}
	
	public void initTab(PropertiesEditionElement propertiesEditionElement){
		assertFalse(propertiesEditionElement.getViews().isEmpty());
		ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
		View view = getView(elementEditor);
		if (view.getName() != null) {
			cTabItem(view.getName()).activate();
			cTabItem(view.getName()).setFocus();
		}
	}
	
	private View getView(ElementEditor obj) {
		EObject container  = obj.eContainer();
		while (container != null) {
			if (container instanceof View) {
				return (View) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public void set(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, ReferenceableObject value) {
		// TODO Auto-generated method stub
		
	}

	public void unset(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature) {
		set(propertiesEditionElement, referenceableObject, eContainingFeature, "");
	}

	public void runModelingBot(String path) throws CoreException,
			IOException {
		this.modelingBotPath = path;
			interpreter.runModelingBot(path, this);
	}


	public EObject createModel(String path, String modelName, EClass root) {
		String[] split = modelName.split("\\.");
		final String extension = split[split.length-1];
		
		selectInProjectExplorer(path);
		
		menu(UIConstants.FILE_MENU).menu(UIConstants.OTHER_MENU).click();
		SWTBotShell newFileShell = shell("New");
		activateShell(newFileShell);

		text().setText(extension + " Model");
		SWTBotTreeItem[] allItems = tree().getAllItems();
		List<SWTBotTreeItem> visibleItems = getVisibleItems(allItems);
		SWTBotUtils.waitAllUiEvents();
		String modelType = StringUtils.toU1Case(extension) + " Model";
		SWTBotTreeItem item = getItem(allItems, modelType);
		//TODO
		if (item==null) {
			tree().expandNode("Example EMF Model Creation Wizards").select(modelType);
		} else {
		assertNotNull("The model " + modelType + " can not be created.", item);
		item.select();
		}
		button("Next >").click();
		
		textWithLabel(IDEWorkbenchMessages.WizardNewFileCreationPage_fileLabel).setText(modelName);
		button("Next >").click();
		assertNotNull("The class "+ root.toString() + " can not be loaded", root.getName());
		
		comboBox().setSelection(root.getName());
		button(UIConstants.FINISH_BUTTON).click();
		
		// close the default editor
		menu(UIConstants.FILE_MENU).menu("Close").click();
		
		// open with EEF Editor
		SWTBotTree wizardTree = viewByTitle(UIConstants.PACKAGE_EXPLORER_VIEW_NAME).bot().tree();
		SWTBotTreeItem treeItem = wizardTree.expandNode(path).expandNode(modelName).select();
		SWTBotUtils.clickContextMenu(treeItem, "Open With Interactive EEF Editor");
//		openEEFEditor(path+"/"+modelName);
		
		editor = editorByTitle(modelName);
		URI fileURI = URI.createPlatformResourceURI(path+"/"+modelName, true);
		Resource resource = editingDomain.getResourceSet().getResource(fileURI,
				true);
		setTestModelResource(resource);
		final SWTBotTreeItem modelTreeItem = editor.bot().tree().getTreeItem(testModelResource.getURI().toString());
				
		resource = (Resource) syncExec(new Result<Object>() {

			public Object run() {
				return modelTreeItem.widget.getData();
			}
		});
		setTestModelResource(resource);
		assertFalse("The model is empty.", resource.getContents().isEmpty());
		return resource.getContents().get(0);
	}

	private SWTBotTreeItem getItem(SWTBotTreeItem[] allItems, String string) {
		for (int i = 0; i < allItems.length; i++) {
			SWTBotTreeItem swtBotTreeItem = allItems[i];
			if (swtBotTreeItem.widget.isDisposed()) {
				break;
			}
			if (swtBotTreeItem.getText().equals(string)) {
				return swtBotTreeItem;
			}
			try {
			SWTBotTreeItem item = getItem(swtBotTreeItem.getNodes(string), string);
			if (item != null) {
				return item;
			}
			}catch (WidgetNotFoundException e) {
				// TODO: handle exception
			}
			
		}
		return null;
		
	}
	
	private SWTBotTreeItem getItem(List<SWTBotTreeItem> allItems, String string) {
		for (SWTBotTreeItem swtBotTreeItem : allItems) {
			if (swtBotTreeItem.widget.isDisposed()) {
				break;
			}
			if (swtBotTreeItem.getText().equals(string)) {
				return swtBotTreeItem;
			}
			SWTBotTreeItem item = getItem(swtBotTreeItem.getNodes(string), string);
			if (item != null) {
				return item;
			}
		}
		return null;
		
	}
	
	private List<SWTBotTreeItem> getVisibleItems(SWTBotTreeItem[] allItems) {
		List<SWTBotTreeItem> list = new ArrayList<SWTBotTreeItem>();
		for (int i = 0; i < allItems.length; i++) {
			SWTBotTreeItem swtBotTreeItem = allItems[i];
			if (!swtBotTreeItem.widget.isDisposed() && swtBotTreeItem.isExpanded()) {
				list .add(swtBotTreeItem);
			}
		}
		return list;
	}

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
		List<Object> expansionPath = EEFModelUtils.getExpansionPath(element);
		Iterator<Object> iterator = expansionPath.iterator();
		Object next = null;
		SWTBotTreeItem node2 = editor.bot().tree().getTreeItem(testModelResource.getURI().toString());
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
		List<Object> expansionPath = EEFModelUtils.getExpansionPath(element);
		Iterator<Object> iterator = expansionPath.iterator();
		Object next = null;
		SWTBotTreeItem node2 = tree.getTreeItem(testModelResource.getURI().toString());
		while (iterator.hasNext()) {
			node2.expand();
			next = iterator.next();
			node2 = selectSubNode(node2, next);
		}
		return node2;
	}
	
	
	
	/**
	 * Select the object <code>next</code> as a subnode of the <code>currentNode</code>
	 * 
	 * @param currentNode
	 *            the currentNode
	 * @param next
	 *            the subnode to select
	 * @return the selected node
	 */
	private SWTBotTreeItem selectSubNode(SWTBotTreeItem currentNode, Object next) {
		AdapterFactory adapterFactory = EEFRuntimePlugin.getDefault().getAdapterFactory();
		IItemLabelProvider labelProvider = (IItemLabelProvider)adapterFactory.adapt(next,
				IItemLabelProvider.class);
		String text = labelProvider.getText(next);
		SWTBotTreeItem node2 = currentNode.getNode(text);
		node2.select();
		return node2;
	}

	public void setTestModelResource(Resource resource) {
		this.testModelResource =  resource;		
	}
	

	/**
	 * @param viewID the edited advEOFCV
	 * @return the browse button of the given advEOFCV
	 */
	public SWTBotButton addButtonAdvancedTableComposition(String viewID) {
		return helper.addButtonAdvancedTableComposition(viewID);
	}

	public void cancel() {
		button(UIConstants.CANCEL_BUTTON).click();
	}
	
    /**
     * Toggle Active view/editor maximize.
     */
    public void maximizeEditor() {
        menu("Window").menu("Navigation").menu("Maximize Active View or Editor").click();
    }
    
    public void dispose() {
    	interpreter.dispose();
    }

	public void validateBatchEditing() {
		button(UIConstants.FINISH_BUTTON).click();
	}
}
