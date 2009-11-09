/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.tree;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterPart;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EEFTreeMasterPart extends AbstractEEFMasterPart {

	/**
	 * @param managedForm the form where this part will be
	 * @param container the composite where to create the part
	 * @param editingDomain the editingDomain where to performs the model edition
	 * @param adapterFactory the adapterFactory for the edited model
	 */
	public EEFTreeMasterPart(FormToolkit toolkit, Composite container,
			EditingDomain editingDomain, AdapterFactory adapterFactory) {
		super(toolkit, container, editingDomain, adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterPart#createSectionClientContents(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	protected TreeViewer createSectionClientContents(Composite sectionContainer, FormToolkit toolkit) {
		Tree tree = toolkit.createTree(sectionContainer, SWT.MULTI | SWT.BORDER);
		TreeViewer result =  new TreeViewer(tree);
		result.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

		result.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		result.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
		new AdapterFactoryTreeEditor(result.getTree(), adapterFactory);
		GridData gd = new GridData(GridData.FILL_BOTH);
		tree.setLayoutData(gd);
		return result;
	}

}
