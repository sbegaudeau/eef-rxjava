/**
 * 
 */
package org.eclipse.emf.eef.runtime.tests.swtbot.finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsResourceUtils;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
  *
 */
public class SWTEEFBot extends SWTWorkbenchBot {
	
	/*****************************************************************************
	 *																			 *
	 * UI Constants																 *
	 * 																			 *
	 *****************************************************************************/
	
	public static final String PACKAGE_EXPLORER_VIEW_NAME = "Package Explorer";
	public static final String NAVIGATE_MENU_LABEL = "Navigate";
	public static final String OPEN_MENU_LABEL = "Open";
	public static final String FINISH_BUTTON_LABEL = "Finish";

	/*****************************************************************************
	 *																			 *
	 * Bot members																 *
	 * 																			 *
	 *****************************************************************************/

	private Resource activeResource = null;
	
	/**
	 * @return the URI of the input model
	 */
	public String getInputModelURI() {
		if (activeResource != null)
			return activeResource.getURI().toString();
		else
			return null;
	}

	/**
	 * @return the active resource
	 */
	public Resource getActiveResource() {
		return activeResource;
	}

	/*****************************************************************************
	 *																			 *
	 * Bot settings																 *
	 * 																			 *
	 *****************************************************************************/
	
	public void defineActiveModel(Resource resource) {
		this.activeResource = resource;
	}
	
	public void unloadActiveModel() {
		this.activeResource.unload();
	}
	
	public void reloadActiveModel() throws IOException {
		this.activeResource.unload();
		this.activeResource.load(Collections.EMPTY_MAP);
	}

	/*****************************************************************************
	 *																			 *
	 * Bot operation															 *
	 * 																			 *
	 *****************************************************************************/
	
	/**
	 * @param file the file to open
	 * @return the editor editing the file
	 */
	public SWTBotEditor openFile(IFile file) {
		SWTBotTree wizardTree = viewByTitle(PACKAGE_EXPLORER_VIEW_NAME).bot().tree();
		sleep(500);
		List<IResource> expansionPath = getExpansionPath(file);
		Iterator<IResource> iter = expansionPath.iterator();
		if (iter.hasNext()) {
			String text = getNodeText(iter.next());
			SWTBotTreeItem treeItem = wizardTree.expandNode(text).expand();
			while (iter.hasNext()) {
				text = getNodeText(iter.next());
				treeItem = treeItem.getNode(text);
				treeItem.expand();
			}
			treeItem.select();
			menu(NAVIGATE_MENU_LABEL).menu(OPEN_MENU_LABEL).click();
			sleep(500);
			SWTBotEditor editor = editorByTitle(activeResource.getURI().lastSegment());
			return editor;
		}
		return null;
	}
	
	/**
	 * Open the editor on the input model
	 * @return the associated editor
	 */
	public SWTBotEditor openActiveModel() {
		IFile file = EEFTestsResourceUtils.workspaceFile(activeResource);
		return openFile(file);
	}
	
	/**
	 * Prepare the model editing
	 * @param elementType The EClass of the edited element
	 * @param element the element to edit
	 * @return the shell of the opened wizard
	 */
	public SWTBotShell prepareBatchEditing(SWTBotEditor editor, EClass elementType, EObject element) {
		SWTBotTreeItem node2 = selectNode(editor, element);
		node2.doubleClick();
		sleep(1000);
		return shell(elementType.getName());
	}

	/**
	 * Select the given element in the given editor
	 * @param editor the editor where the bot must process
	 * @param element the element to select
	 * @return the selected node
	 */
	public SWTBotTreeItem selectNode(SWTBotEditor editor, EObject element) {
		List<Object> expansionPath = getExpansionPath(element);
		Iterator<Object> iterator = expansionPath.iterator();
		Object next = null;
		SWTBotTreeItem node2 = editor.bot().tree().getTreeItem(getInputModelURI());
		while (iterator.hasNext()) {
			node2.expand();
			next = iterator.next();
			node2 = selectSubNode(node2, next);
		}
		return node2;
	}

	/**
	 * This method save the model and close the editor
	 * @param editor the modelEditor
	 */
	public void finalizeEdition(SWTBotEditor editor) {
		activateEclipseShell();
		menu("File").menu("Save").click();
		sleep(3000);
		editor.close();
	}
	
	/*****************************************************************************
	 *																			 *
	 * EEF features editing testing												 *
	 * 																			 *
	 *****************************************************************************/
	
	/**
	 * Edit the value of the EEF Wizard to give the <i>feature</i> the value <i>newValue</i>
	 * @param shell the shell of the edited wizard 
	 * @param feature the feature to edit
 	 * @param newValue the new value to set to the feature
	 */
	public void editTextFeature(SWTBotShell shell, String feature, Object newValue) {
		shell.activate();
		sleep(500);
		textWithLabel(feature).setText(newValue.toString());
		sleep(1000);
		button(FINISH_BUTTON_LABEL).click();
		waitUntil(Conditions.shellCloses(shell));
	}
	
	/**
	 * Edit the value of the EEF Wizard to give the <i>feature</i> the value <i>newValue</i>
	 * @param shell the shell of the edited wizard 
	 * @param feature the feature to edit
 	 * @param newValue the new value to set to the feature
	 */
	public void editCheckboxFeature(SWTBotShell shell, String feature) {
		shell.activate();
		sleep(500);
		checkBox(feature).click();
		sleep(1000);
		button(FINISH_BUTTON_LABEL).click();
		waitUntil(Conditions.shellCloses(shell));
	}
	
	/*****************************************************************************
	 *																			 *
	 * Bot utils																 *
	 * 																			 *
	 *****************************************************************************/
	
	/**
	 * Active the main shell (Workbench shell)
	 */
	protected void activateEclipseShell() {
		SWTBotShell[] shells = shells();
		if (shells.length > 0)
			// Heuristic : the eclipse shell is the first shell
			shells[0].activate();
	}
	
	/**
	 * @param modelElement the element to process
	 * @return a list containing the element to expand
	 */
	private List<Object> getExpansionPath(EObject modelElement) {
		List<Object> result = new ArrayList<Object>();
		result.add(modelElement);
		EObject container = modelElement.eContainer();
		while (container != null) {
			result.add(0,container);
			container = container.eContainer();
		}
		return result;
	}
	
	/**
	 * @param file the file to process
	 * @return a list containing the element to expand
	 */
	private List<IResource> getExpansionPath(IFile file) {
		List<IResource> result = new ArrayList<IResource>();
		result.add(file);
		IContainer container = file.getParent();
		while (container != null && !(container instanceof IProject)) {
			result.add(0, container);
			container = container.getParent();
		}
		if (container instanceof IProject)
			result.add(0, container);
		return result;
	}

	/**
	 * Return the label of the given IResource
	 * @param resource the resource to process
	 * @return the label of the resource
	 */
	private String getNodeText(IResource resource) {
		return resource.getName();
	}

	/**
	 * Select the object <code>next</code> as a subnode of the <code>currentNode</code>
	 * @param currentNode the currentNode
	 * @param next the subnode to select
	 * @return the selected node
	 */
	private SWTBotTreeItem selectSubNode(SWTBotTreeItem currentNode, Object next) {
		AdapterFactory adapterFactory = EMFPropertiesRuntime.getDefault().getAdapterFactory();
		IItemLabelProvider labelProvider = (IItemLabelProvider)adapterFactory.adapt(next, IItemLabelProvider.class);
		String text = labelProvider.getText(next);
		SWTBotTreeItem node2 = currentNode.getNode(text);
		node2.select();
		sleep(500);
		return node2;
	}
}

