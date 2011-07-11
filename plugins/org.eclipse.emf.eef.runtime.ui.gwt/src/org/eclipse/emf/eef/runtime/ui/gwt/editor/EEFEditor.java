/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.gwt.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.part.EEFEditorToolbar;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.part.EEFPropertiesPanel;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.util.EditorToolbarListener;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.util.NavigationManager;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.widget.EEFTreeViewer;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.widget.EEFTreeViewerContentProvider;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.view.client.SelectionChangeEvent;

/**
 * @author glefur
 *
 */
public class EEFEditor extends DockLayoutPanel {

	private EditingDomain editingDomain;
	private AdapterFactory adapterFactory;
	private List<Resource> originalResources;
	private NavigationManager navigationManager;
	
	private EEFEditorToolbar toolBar;
	private EEFTreeViewer treeviewer;
	private EEFPropertiesPanel propertiesPanel;
	private AdapterFactoryItemDelegator itemDelegator;

	/**
	 * @param unit
	 */
	public EEFEditor(EditingDomain editingDomain, AdapterFactory adapterFactory, String applicationTitle, Unit unit) {
		super(unit);
		this.editingDomain = editingDomain;
		this.adapterFactory = adapterFactory;
		this.itemDelegator = new AdapterFactoryItemDelegator(adapterFactory);
		headerPanel(applicationTitle);
		bodyPanel();
		toolBar.setEnabledButton(false, EEFEditorToolbar.SAVE);
		toolBar.setEnabledButton(false, EEFEditorToolbar.UNDO);
		toolBar.setEnabledButton(false, EEFEditorToolbar.REDO);
		final EditorToolbarListener listener = new EditorToolbarListener(this);
		toolBar.addListener(listener);
		treeviewer.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			public void onSelectionChange(SelectionChangeEvent event) {
				final Object object = ((EEFTreeViewerContentProvider)treeviewer.getTreeViewModel()).getTreeSelection();
				listener.update(object);
				toolBar.setEnabledButton(object instanceof Resource || object instanceof ResourceSet || !EEFEditor.this.editingDomain.getNewChildDescriptors(object, null).isEmpty(), EEFEditorToolbar.CREATE);
				propertiesPanel.updateProperties(object);

			}
		});

		editingDomain.getCommandStack().addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(EventObject event) {
				toolBar.setEnabledButton(((BasicCommandStack)EEFEditor.this.editingDomain.getCommandStack()).isSaveNeeded(), EEFEditorToolbar.SAVE);
				toolBar.setEnabledButton(EEFEditor.this.editingDomain.getCommandStack().canUndo(), EEFEditorToolbar.UNDO);
				toolBar.setEnabledButton(EEFEditor.this.editingDomain.getCommandStack().canRedo(), EEFEditorToolbar.REDO);

				Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
				if (mostRecentCommand != null) {
					Collection<?> affectedObjects = mostRecentCommand.getAffectedObjects();
					if (!affectedObjects.isEmpty()) {
						Object newSelection = affectedObjects.iterator().next();
						navigationManager.setSelection(newSelection);
						navigationManager.navigate();
					}
				}
			}
		});

	}

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @return the adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @param originalResources the originalResources to set
	 */
	public void setOriginalResources(List<Resource> originalResources) {
		this.originalResources = originalResources;
	}

	/**
	 * @return the itemDelegator
	 */
	public AdapterFactoryItemDelegator getItemDelegator() {
		return itemDelegator;
	}

	/**
	 * @return
	 */
	public EEFEditorToolbar getToolbar() {
		return toolBar;
	}
	
	/**
	 * @return the propertiesPanel
	 */
	public EEFPropertiesPanel getPropertiesPanel() {
		return propertiesPanel;
	}

	/**
	 * @return
	 */
	public NavigationManager getNavigationManager() {
		return navigationManager;
	}


	/**
	 * @return
	 */
	public List<Resource> getOriginalResources() {
		return originalResources;
	}

	/**
	 * Create the editor header panel
	 * @param applicationTitle application title
	 */
	private void headerPanel(String applicationTitle) {
		this.setStyleName("Main", true);
		this.setHeight("100%");

		FlowPanel headerPanel = new FlowPanel();
		headerPanel.setStyleName("Header", true);

		final Label header = new Label(applicationTitle);
		header.setStyleName("HeaderLabel", true);

		headerPanel.add(header);

		this.addNorth(headerPanel, 56.0);
	}

	/**
	 * Create the editor body panel
	 */
	private void bodyPanel() {
		DockLayoutPanel bodyPanel = new DockLayoutPanel(Unit.PX);
		bodyPanel.setStyleName("Body", true);
		bodyPanel.setHeight("100%");

		this.add(bodyPanel);

		toolBar = new EEFEditorToolbar();

		SplitLayoutPanel contentPanel = new SplitLayoutPanel();
		contentPanel.setStyleName("Content", true);


		EEFTreeViewerContentProvider contentProvider = new EEFTreeViewerContentProvider(this);
		contentProvider.setEditingDomain(editingDomain);
		contentProvider.setSelected(editingDomain.getResourceSet(), true);
	    treeviewer = new EEFTreeViewer(contentProvider, new ItemProvider(Collections.singleton(editingDomain.getResourceSet())));
		ScrollPanel treeScrollPanel = new ScrollPanel();
		treeScrollPanel.add(treeviewer);
		navigationManager = new NavigationManager(editingDomain, treeviewer);
		
		propertiesPanel = new EEFPropertiesPanel(this, Unit.PX);
		
		contentPanel.addWest(treeScrollPanel, 400);
		contentPanel.add(propertiesPanel);

		bodyPanel.addNorth(toolBar, 28.0);
		bodyPanel.add(contentPanel);
	}


}
