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
package org.eclipse.emf.eef.runtime.ui.gwt.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author glefur
 *
 */
public class ErrorDialog extends DialogBox {

	private Tree tree;
	private Object selection;

	public ErrorDialog(String errorText, Throwable caught) {
		super();
		this.setText(errorText);
		List<Throwable> throwables = new ArrayList<Throwable>();
		throwables.add(caught);
		createDialogControl();
		tree.addItem(createTreeItems(caught));
	}

	public ErrorDialog(String errorText, Diagnostic diagnostic) {
		this.setText(errorText);
		createDialogControl();
		tree.addItem(createTreeItems(diagnostic));
	}

	public ErrorDialog(String errorText, List<Diagnostic> children) {
		this.setText(errorText);
		createDialogControl();
		for (Diagnostic diagnostic : children) {
			tree.addItem(createTreeItems(diagnostic));
		}
	}

	public void open() {
		this.show();
	}

	protected void createDialogControl() {
		final Button okButton = new Button("OK");
		tree = new Tree();
		Grid grid = new Grid();
		grid.setWidth("150em");
		grid.resize(2, 1);
		grid.setWidget(0, 0, tree);
		grid.setWidget(1, 0, okButton);
		this.setWidget(grid);
		okButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				TreeItem selectedItem = tree.getSelectedItem();
				ErrorDialog.this.hide();
				processError(selectedItem);
			}
		});
	}

	private TreeItem createTreeItems(Throwable throwable) {
		return new TreeItem(throwable.getLocalizedMessage());
	}

	private TreeItem createTreeItems(Diagnostic diagnostic) {
		if (diagnostic.getSeverity() == Diagnostic.OK) {
			return new TreeItem("No problems detected");
		} else {
			TreeItem treeItem = new TreeItem(diagnostic.getMessage());
			List<?> data = diagnostic.getData();
			if (!data.isEmpty()) {
				treeItem.setUserObject(data.get(0));
			}
			for (Diagnostic child : diagnostic.getChildren()) {
				treeItem.addItem(createTreeItems(child));
			}
			return treeItem;
		}
	}

	protected Object processError(TreeItem selection) {
		return null;
	}

	/**
	 * @return the selection
	 */
	public Object getSelection() {
		return selection;
	}
	
}
