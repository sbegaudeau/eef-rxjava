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
package org.eclipse.emf.eef.runtime.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.eef.runtime.impl.utils.ModelViewerHelper;
import org.eclipse.emf.eef.runtime.ui.utils.EEFLabelProvider;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.AdvancedEEFEditorContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * This dialog shows the tree of all owned element by taking in account a filter
 * 
 * @author Patrick Tessier
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 */
public abstract class ElementSelectionDialog extends Dialog implements IPropertiesFilteredWidget {

	/**
	 * the label
	 */
	protected Label label;

	/**
	 * The selection tree.
	 */
	protected Tree tree;

	/** title of the window */
	protected String title = EEFRuntimeUIMessages.TabElementTreeSelectionDialog_title;

	/**
	 * filters
	 */
	private List<ViewerFilter> viewerFilters;

	/**
	 * business rules filters
	 */
	private List<ViewerFilter> brFilters;

	/**
	 * The adapter factory.
	 */
	protected AdapterFactory adapterFactory;

	private Composite parent;

	private Object input;

	private IStructuredSelection selection;

	/**
	 * Constructor with parent shell and Element.
	 * 
	 * @param parentElement
	 *            the element where we look for a children
	 * @param filters
	 *            this is an array of filter see {@link ViewerFilter} or an example {@link OperationFilter}
	 * @param title
	 *            title of the window
	 * @param createElement
	 *            this is the listener to create an element
	 * @param abstractElement
	 *            it used to inform about if the element is abstract in this case the creation button does not
	 *            appear
	 * @param mainResource
	 *            the main resource.
	 */
	public ElementSelectionDialog(Object input, List<ViewerFilter> filters,
			List<ViewerFilter> brFilters, String title, AdapterFactory adapterFactory) {
		super(Display.getDefault().getActiveShell());
		// add the resize ability to the window
		setShellStyle(SWT.RESIZE | super.getShellStyle());
		this.input = input;
		this.viewerFilters = filters;
		this.brFilters = brFilters;
		this.title = title;
		this.adapterFactory = adapterFactory;
	}

	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *            composite.
	 * @return control Control.
	 */
	protected Control createDialogArea(Composite parent) {
		this.parent = parent;

		return fillModelpage(parent);
	}

	/**
	 * Used to display a page
	 * 
	 * @param parent
	 *            composite which contains the tree
	 * @return the composite of this page
	 */
	public Control fillModelpage(Composite parent) {
		Composite composite = new Composite(parent, SWT.None);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);

		// use pattern filter
		PatternFilter patternFilter = new TreeSelectionPatternFilter();
		patternFilter.setIncludeLeadingWildcard(true);

		FilteredTree filteredTree = new FilteredTree(composite, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL
				| SWT.RESIZE, patternFilter, true);
		// use of EMF facilities
		final TreeViewer treeViewer = filteredTree.getViewer();
		treeViewer.setFilters(new ViewerFilter[0]);
		treeViewer.setUseHashlookup(true);
		if (input instanceof EEFEditorSettings)
			treeViewer.setContentProvider(new HideResourcesContentProvider(new AdvancedEEFEditorContentProvider(adapterFactory)));
		else
			treeViewer.setContentProvider(new HideResourcesContentProvider(new AdapterFactoryContentProvider(adapterFactory)));

		ArrayList<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		if (viewerFilters != null && !viewerFilters.isEmpty()) {
			for (ViewerFilter filter : viewerFilters) {
				filters.add(filter);
			}
		}
		// for now, add the businessRuleFilters to the 'normal' filters
		if (brFilters != null && !brFilters.isEmpty()) {
			for (ViewerFilter filter : brFilters) {
				filters.add(filter);
			}
		}
		filters.add(patternFilter);
		ViewerFilter[] v = filters.toArray(new ViewerFilter[filters.size()]);
		treeViewer.setFilters(v);
		treeViewer.setLabelProvider(new EEFLabelProvider() {
			
			@Override
			public Color getForeground(Object element) {
				if (input instanceof ReferencesTableSettings && element instanceof EObject && ((ReferencesTableSettings) input).contains((EObject) element)) {
					return getShell().getDisplay()
							.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW);
				}
				
				return super.getForeground(element);
			}

		});

		filteredTree.setLayoutData(new GridData(550, 300));
		// handle selection change
		if (input instanceof EEFEditorSettings) {
			treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					if (event.getSelection() instanceof IStructuredSelection) {
						// Check selection
						IStructuredSelection structuredSelection = (IStructuredSelection)event.getSelection();
						if (structuredSelection != null && !structuredSelection.isEmpty()) {
							Object o = structuredSelection.getFirstElement();
							// Check type matching
							Button okButton = getButton(IDialogConstants.OK_ID);
							if (((List<?>)((EEFEditorSettings)input).choiceOfValues(adapterFactory)).contains(o)) {
								if (input instanceof ReferencesTableSettings) {
									if (o instanceof EObject && !((ReferencesTableSettings) input).contains((EObject) o)) {
										selection = structuredSelection;
										if (okButton != null) {
											okButton.setEnabled(true);
										}
									} else {
										// Reject selection
										if (okButton != null) {
											okButton.setEnabled(false);
										}
									}
								} else {
									selection = structuredSelection;
									if (okButton != null) {
										okButton.setEnabled(true);
									}
								}
							} else {
								// Reject selection
								if (okButton != null) {
									okButton.setEnabled(false);
								}
							}
						}

					}
				}
			});

			// handle double click to validate
			treeViewer.addDoubleClickListener(new IDoubleClickListener() {
				public void doubleClick(DoubleClickEvent event) {
					if (selection != null && !selection.isEmpty()) {
						Object o = selection.getFirstElement();
						if (((List<?>)((EEFEditorSettings)input).choiceOfValues(adapterFactory)).contains(o) && input instanceof ReferencesTableSettings && o instanceof EObject && !((ReferencesTableSettings) input).contains((EObject) o)) {
							okPressed();
						}
					}
				}
			});
		}
		treeViewer.setInput(input);

		// Init selected element
		if (selection != null) {
			treeViewer.setSelection(selection);
		}

		return composite;

	}
	
	/**
	 * ContentProvider which delegates almost everything to another ContentProvider.
	 * The purpose is to hide the Resource and display only their contents
	 *
	 */
	private class HideResourcesContentProvider implements ITreeContentProvider {
		private ITreeContentProvider delegateContentProvider;

		public HideResourcesContentProvider(ITreeContentProvider delegateContentProvider) {
			this.delegateContentProvider = delegateContentProvider;
		}
		
		public Object[] getElements(Object inputElement) {
			// Retrieve elements provided by the delegate content provider
			Object[] elements = delegateContentProvider.getElements(inputElement);
			List<Object> newElements = new ArrayList<Object>();
			for (Object element : elements) {
				// When an element is a resource, return its contents instead of the resource itself
				if (element instanceof Resource) {
					newElements.addAll(((Resource)element).getContents());
				} else {
					newElements.add(element);
				}
			}
			return newElements.toArray();
		}
		
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			delegateContentProvider.inputChanged(viewer, oldInput, newInput);
		}
		
		public Object[] getChildren(Object parentElement) {
			return delegateContentProvider.getChildren(parentElement);
		}
		
		public Object getParent(Object element) {
			return delegateContentProvider.getParent(element);
		}
		
		public boolean hasChildren(Object element) {
			return delegateContentProvider.hasChildren(element);
		}

		public void dispose() {
			delegateContentProvider.dispose();
		}
	}

	private class TreeSelectionPatternFilter extends PatternFilter {
		@Override
		protected boolean isParentMatch(Viewer viewer, Object element) {
			Object[] children = ((ITreeContentProvider)((AbstractTreeViewer)viewer).getContentProvider())
					.getChildren(element);
			// apply all filters
			if (viewerFilters != null && !viewerFilters.isEmpty() && children != null) {
				// if one child match, show the parent in tree
				for (ViewerFilter viewerFilter : viewerFilters) {
					for (Object child : children) {
						if (viewerFilter.select(viewer, null, child)) {
							return super.isParentMatch(viewer, element);
						}
					}
				}
				return false;
			} else {
				return super.isParentMatch(viewer, element);
			}
		}

		@Override
		protected boolean isLeafMatch(Viewer viewer, Object element) {
			if (element instanceof EObject) {
				String labelText = ((EObject)element).toString();
				if (labelText != null) {
					return wordMatches(labelText);
				}
			}
			return false;
		}
	}

	/**
	 * Sets or clears the input for this dialog.
	 */
	public void setInput(Object input) {
		this.input = input;
		this.refresh();
	}

	public void refresh() {
		parent.pack();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(EEFRuntimeUIMessages.TabElementTreeSelectionDialog_shell_title + this.title);
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		if (selection != null && !selection.isEmpty()) {
			process(selection);
			ModelViewerHelper.setLastSelection(selection);
		}
		super.okPressed();
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public abstract void process(IStructuredSelection selection);

	public void addBusinessRuleFilter(ViewerFilter filter) {
		this.brFilters.add(filter);
	}

	public void addFilter(ViewerFilter filter) {
		this.viewerFilters.add(filter);
	}

	public void removeBusinessRuleFilter(ViewerFilter filter) {
		this.brFilters.remove(filter);
	}

	public void removeFilter(ViewerFilter filter) {
		this.viewerFilters.remove(filter);
	}

}
