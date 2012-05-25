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
package org.eclipse.emf.eef.runtime.ui.gwt.editor.widget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.EEFEditor;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;


/**
 * @author glefur
 *
 */

public class EEFTreeViewerContentProvider implements TreeViewModel {


	private SingleSelectionModel<Object> treeSelection;

	private EEFEditor editor;
	private EditingDomain editingDomain;

	public <T> EEFTreeViewerContentProvider(EEFEditor editor) {
		this.treeSelection = new SingleSelectionModel<Object>();
		this.editor = editor;
	}

	/**
	 * @param editingDomain the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}
	
	/**
	 * @param newSelection
	 */
	public void setSelected(Object selection, boolean state) {
		treeSelection.setSelected(selection, state);
	}
	
	/**
	 * @param handler
	 */
	public void addSelectionChangeHandler(SelectionChangeEvent.Handler handler) {
		treeSelection.addSelectionChangeHandler(handler);
	}
	
	/**
	 * @return the selection
	 */
	public Object getTreeSelection() {
		return treeSelection.getSelectedObject();
	}

	public <T> NodeInfo<?> getNodeInfo(final T value) {
		final ListDataProvider<Object> abstractListViewAdapter = new ListDataProvider<Object>() {
			int size;

			class NodeAdapter extends AdapterImpl implements INotifyChangedListener {
				Set<Object> children = new HashSet<Object>();

				@Override
				public void notifyChanged(Notification msg) {
					if (msg.getEventType() != Notification.REMOVING_ADAPTER) {
						update();
						if (!(msg.getNotifier() instanceof EObject)) {
							for (Runnable runnable : editor.getPropertiesPanel().getPropertyUpdater()) {
								runnable.run();
							}
						}
					}
				}

				public void listenTo(Object target) {
					if (target instanceof Notifier) {
						((Notifier) target).eAdapters().add(this);
					} else if (target instanceof IChangeNotifier) {
						((IChangeNotifier) target).addListener(this);
					}
				}

				public void stopListeningTo(Object target) {
					if (target instanceof Notifier) {
						((Notifier) target).eAdapters().remove(this);
					} else if (target instanceof IChangeNotifier) {
						((IChangeNotifier) target).removeListener(this);
					}
				}

				public void listenTo(List<Object> children) {
					// TODO
					// I don't know how to update just one child. :-(

					boolean isListeningToValue = !this.children.isEmpty();
					Set<Object> oldChildren = new HashSet<Object>(this.children);
					for (Object child : children) {
						if (this.children.contains(child)) {
							oldChildren.remove(child);
						} else {
							this.children.add(child);
							listenTo(child);
						}
					}
					for (Object child : oldChildren) {
						stopListeningTo(child);
						this.children.remove(child);
					}
					if (isListeningToValue) {
						if (children.isEmpty()) {
							stopListeningTo(value);
						}
					} else if (!children.isEmpty()) {
						listenTo(value);
					}
				}
			}

			protected NodeAdapter nodeAdapter = new NodeAdapter();

			@Override
			protected void onRangeChanged(HasData<Object> display) {
				if (value instanceof Resource) {
					Resource resource = (Resource) value;
					if (!resource.isLoaded()) {
						try {
							resource.load(editingDomain.getResourceSet().getLoadOptions());
						} catch (IOException e) {
							// Ignore.
						}
					}
				}
				update();
			}

			protected void update() {
				Collection<?> children = editor.getItemDelegator().getChildren(value);
				ArrayList<Object> childrenList = new ArrayList<Object>(children);
				nodeAdapter.listenTo(childrenList);
				int size = children.size();
				if (this.size < size) {
					updateRowCount(size, true);
					this.size = size;
				} else {
					// Pad with dummy objects.
					for (int i = size; i < this.size; ++i) {
						childrenList.add(new Object());
					}
				}
				updateRowData(0, childrenList);
				if (this.size > size) {
					updateRowCount(size, true);
					this.size = size;
				}
			}
		};

		return new DefaultNodeInfo<Object>(abstractListViewAdapter, new ModelViewerCell(editor.getItemDelegator()), treeSelection, null);
	}

	public boolean isLeaf(Object value) {
		return !editor.getItemDelegator().hasChildren(value);
	}
}
