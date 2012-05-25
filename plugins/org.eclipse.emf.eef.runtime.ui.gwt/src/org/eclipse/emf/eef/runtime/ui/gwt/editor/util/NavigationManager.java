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
package org.eclipse.emf.eef.runtime.ui.gwt.editor.util;

import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.widget.EEFTreeViewer;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.widget.EEFTreeViewerContentProvider;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author glefur
 * 
 */
public class NavigationManager {

	private Object selection;

	private EditingDomain editingDomain;
	private EEFTreeViewer treeviewer;	
	private NavigationListener navigationListener;


	/**
	 * @param editingDomain
	 * @param treeviewer
	 */
	public NavigationManager(EditingDomain editingDomain, EEFTreeViewer treeviewer) {
		this.editingDomain = editingDomain;
		this.treeviewer = treeviewer;
		this.navigationListener = new NavigationListener();
	}

	/**
	 * @return the selection
	 */
	public Object getSelection() {
		return selection;
	}

	/**
	 * @param selection
	 *            the selection to set
	 */
	public void setSelection(Object selection) {
		this.selection = selection;
		//TODO: if selection == null => disabling Navigation button
	}

	/**
	 * 
	 */
	public void navigate() {
		EEFTreeViewerContentProvider contentProvider = (EEFTreeViewerContentProvider) treeviewer.getTreeViewModel();
		final Object oldSelection = contentProvider.getTreeSelection();
		focus();
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			public void execute() {
				setSelection(oldSelection);
			}
		});

	}

	public void focus() {
		treeviewer.expand(editingDomain.getTreePath(editingDomain.getParent(selection)));
		((EEFTreeViewerContentProvider) treeviewer.getTreeViewModel()).setSelected(selection, true);

	}
	
	
	public void listenTo(ListBox listBox, List<?> values) {
		navigationListener.listenTo(listBox, values);
	}

	/**
	 * @return the navigationListener
	 */
	public NavigationListener getNavigationListener() {
		return navigationListener;
	}

	private class NavigationListener {

		public void listenTo(final ListBox listBox, final List<?> values) {
			listBox.addFocusHandler(new FocusHandler() {
				protected HandlerRegistration changeHandlerRegistration;

				{
					listBox.addBlurHandler(new BlurHandler() {
						public void onBlur(BlurEvent event) {
							if (changeHandlerRegistration != null) {
								changeHandlerRegistration.removeHandler();
								changeHandlerRegistration = null;
							}
						}
					});
				}

				public void onFocus(FocusEvent event) {
					updateSelection();
					changeHandlerRegistration = listBox.addChangeHandler(new ChangeHandler() {
						public void onChange(ChangeEvent event) {
							updateSelection();
						}
					});
				}

				void updateSelection() {
					int selectedIndex = listBox.getSelectedIndex();
					setSelection(selectedIndex == -1 || selectedIndex >= values.size() ? null : values.get(selectedIndex));
				}
			});
		}
	}

}
