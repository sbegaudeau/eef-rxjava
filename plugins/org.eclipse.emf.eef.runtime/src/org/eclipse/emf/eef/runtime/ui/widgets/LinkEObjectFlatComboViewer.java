/*******************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *     Obeo - Some improvements
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * This is an Abstract class use to display a label with the referenced named
 * Element For example type of a property
 * 
 * @author Patrick Tessier
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class LinkEObjectFlatComboViewer extends AbstractAdvancedEObjectFlatComboViewer {


	/** Associated link. */
	protected Link valueLink;

	/**
	 * the constructor of this display
	 * 
	 * @param labeltoDisplay
	 *            use to display the name is the label
	 * @param filter
	 *            use to look for the good element
	 */
	public LinkEObjectFlatComboViewer(String dialogTitle, Object input,
			ViewerFilter filter, AdapterFactory adapterFactory,
			EObjectFlatComboViewerListener callback) {
		super(dialogTitle, input, filter, adapterFactory, callback);
	}

	protected void createLabels(Composite parent) {
		// Display label
		// final Label displayLabel = createLabel(parent, dialogTitle,
		// SWT.NONE);
		// FormData data = new FormData();
		// data.left = new FormAttachment(0, 0);
		// data.top = new FormAttachment(0, 0);
		// displayLabel.setLayoutData(data);

		// Value Label
		String value = UNDEFINED_VALUE;
		if (selection != null) {
			value = labelProvider.getText(selection);
		}
		this.valueLink = createLink(parent, value, SWT.NONE);
		// valueText.setEditable(false);
		// TODO set background color and dispose!
		// valueText.setEnabled(false);
		// valueText.setBackground(...);
		FormData data = new FormData();
		// data.left = new FormAttachment(displayLabel, 5);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(browseButton, 0);
		data.top = new FormAttachment(0, 1);
		valueLink.setLayoutData(data);
		// valueText.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseDoubleClick(MouseEvent e) {
		// callback.navigateTo(selection);
		// }
		// });
		valueLink.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				EObject editedElement = getSelection();
				handleEdit(editedElement);
			}
		});
	}

	private Link createLink(Composite parent, String value, int style) {
		Link link = new Link(parent, style);
		link.setText(value);
		EditingUtils.setEEFtype(field,
		"eef::LinkEObjectFlatComboViewer::link");
		return link;
	}

	@SuppressWarnings("unchecked")
	public void setSelection(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection) selection;
			if (!structuredSelection.isEmpty()
					&& !"".equals(structuredSelection.getFirstElement())) {
				setSelection((EObject) structuredSelection.getFirstElement());
			} else {
				this.valueLink.setText(UNDEFINED_VALUE);
				// this.parent.pack();
			}
		}
	}

	public void setSelection(EObject selection) {
		this.selection = selection;
		String text = labelProvider.getText(selection);
		if ("".equals(text)) //$NON-NLS-1$
			this.valueLink.setText(UNDEFINED_VALUE);
		else
			this.valueLink.setText("<a>" + text + "</a>");
		// this.parent.pack();
	}

	/**
	 * Sets the viewer readonly
	 * 
	 * @param enabled
	 *            sets the viewer read only or not.
	 */
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		valueLink.setEnabled(enabled);
	}
	
	/**
	 * @return if the table is enabled
	 */
	public boolean isEnabled() {
		return super.isEnabled() && valueLink.isEnabled();
	}

	/**
	 * Sets the tooltip text on the viewer
	 * 
	 * @param tooltip
	 *            the tooltip text
	 */
	public void setToolTipText(String tooltip) {
		super.setToolTipText(tooltip);
		valueLink.setToolTipText(tooltip);
	}


}
