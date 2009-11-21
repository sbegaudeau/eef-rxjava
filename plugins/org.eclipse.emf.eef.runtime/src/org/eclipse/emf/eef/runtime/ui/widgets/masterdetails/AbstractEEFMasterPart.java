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
package org.eclipse.emf.eef.runtime.ui.widgets.masterdetails;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class AbstractEEFMasterPart extends SectionPart {

	private TreeViewer modelViewer;
	private AdapterFactory adapterFactory;
	
	/**
	 * @param managedForm the form where this part will be
	 * @param container the composite where to create the part
	 * @param adapterFactory the adapterFactory for the edited model
	 */
	public AbstractEEFMasterPart(FormToolkit toolkit, Composite container) {
		super(container, toolkit, ExpandableComposite.TITLE_BAR);
		Composite sectionContainer = toolkit.createComposite(getSection());
		createSectionClient(sectionContainer, toolkit);
		getSection().setText("Model");
		getSection().setClient(sectionContainer);
		
	}
	
	/**
	 * Create the content of the master part
	 * @param sectionContainer the parent
	 * @param toolkit the toolkit to use
	 */
	private void createSectionClient(Composite sectionContainer, FormToolkit toolkit) {
		sectionContainer.setLayout(new GridLayout());
		modelViewer = null;
		modelViewer = createSectionClientContents(sectionContainer, toolkit);
		assert modelViewer != null : "The viewer of the master part cannot be null";
	}

	/**
	 * Create the content of the master part
	 * @param sectionContainer the parent
	 * @param toolkit the toolkit to use
	 */
	protected abstract TreeViewer createSectionClientContents(Composite sectionContainer, FormToolkit toolkit);
	
	/**
	 * @return the adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		if (adapterFactory == null)
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		return adapterFactory;
	}

	/**
	 * @param adapterFactory the adapterFactory to set
	 */
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.IEEFMasterPart#getModelViewer()
	 */
	public TreeViewer getModelViewer() {
		return modelViewer;
	}
	
	/**
	 * @param input the input of the model viewer
	 */
	public void setInput(Object input) {
		assert modelViewer != null : "The viewer cannot be null when defining the input model";
		modelViewer.setInput(input);
	}
	
	/**
	 * @param listener add a listener to the mode viewer
	 */
	public void addSelectionChangeListener(ISelectionChangedListener listener) {
		assert modelViewer != null : "The viewer cannot be null when adding selection change listeners";
		modelViewer.addSelectionChangedListener(listener);
	}
	
	/**
	 * @param listener remove a listener to the mode viewer
	 */
	public void removeSelectionChangeListener(ISelectionChangedListener listener) {
		assert modelViewer != null : "The viewer cannot be null when adding selection change listeners";
		modelViewer.removeSelectionChangedListener(listener);
	}

	/**
	 * @param filter add a filter to the model viewer
	 */
	public void addFilter(ViewerFilter filter) {
		assert modelViewer != null : "The viewer cannot be null when adding filters";
		modelViewer.addFilter(filter);
	}
		
}
