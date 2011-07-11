package org.eclipse.emf.eef.runtime.ui.gwt.editor.widget;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.TreeViewModel;

public class EEFTreeViewer extends CellTree {
	public <T> EEFTreeViewer(TreeViewModel viewModel, T rootValue) {
		super(viewModel, rootValue, (Resources) GWT.create(CellTree.BasicResources.class));
	}

	public void expand(List<?> path) {
		TreeNode node = getRootTreeNode();
		if (node != null) {
			LOOP: for (int i = 0, size = path.size(); i < size; ++i) {
				Object segment = path.get(i);
				for (int j = 0, count = node.getChildCount(); j < count; ++j) {
					Object childValue = node.getChildValue(j);
					if (childValue.equals(segment)) {
						node = node.setChildOpen(j, true);
						continue LOOP;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * @param handler
	 */
	public void addSelectionChangeHandler(SelectionChangeEvent.Handler handler) {
		((EEFTreeViewerContentProvider)getTreeViewModel()).addSelectionChangeHandler(handler);
	}
	
}
