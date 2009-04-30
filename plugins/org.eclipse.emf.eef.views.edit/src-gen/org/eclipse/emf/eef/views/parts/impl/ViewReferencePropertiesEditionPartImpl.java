/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ViewReferencePropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:16:52 glefur Exp $
 */
package org.eclipse.emf.eef.views.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.eef.views.ViewReference	;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.providers.ViewsMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.impl.ViewReferencePropertiesEditionPartImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.views.ViewElement;	





// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewReferencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ViewReferencePropertiesEditionPart {

	protected ViewReference current;
	protected ResourceSet resourceSet;
	private Text name;
	private EObjectFlatComboViewer referencedView;
		
	public ViewReferencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);	
		
		createControls(view);
		
		return view;
	}
	
	public void createControls(Composite view) { 
		createPropertiesGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ViewsMessages.ViewReferencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
		createReferencedViewFlatComboViewer(propertiesGroup);
   	}

	private void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ViewsMessages.ViewReferencePropertiesEditionPart_NameLabel, true);
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ViewReferencePropertiesEditionPartImpl.this, ViewsViewsRepository.ViewReference.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The element name", null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createReferencedViewFlatComboViewer(Composite parent) {
	
		SWTUtils.createPartLabel(parent, ViewsMessages.ViewReferencePropertiesEditionPart_ReferencedViewLabel, true);		
		referencedView = new EObjectFlatComboViewer(parent, false);
		referencedView.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		referencedView.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof ViewElement);			
			}

		});
		referencedView.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ViewReferencePropertiesEditionPartImpl.this, ViewsViewsRepository.ViewReference.referencedView, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, getReferencedView()));
			}

		});
		GridData referencedViewData = new GridData(GridData.FILL_HORIZONTAL);
		referencedView.setLayoutData(referencedViewData);
		SWTUtils.createHelpButton(parent, "The referenced view", null); //$NON-NLS-1$
	}


	public void initComponent(EObject eObject, ResourceSet allResources) {
		ViewReference viewReference = (ViewReference)eObject;
		current = viewReference;
		resourceSet = allResources;
		if (viewReference.getName() != null){
			name.setText(viewReference.getName());
		}	
		referencedView.setInput(allResources);
		if (viewReference.getView() != null){
			referencedView.setSelection(new StructuredSelection(viewReference.getView()));
		}
		// Start of user code for referencedView filters initialisation

 		// End of user code
	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		name.setText(newValue);
	}

	public void setMessageForName (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForName () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#getReferencedView()
	 */
	public EObject getReferencedView() {
		if (referencedView.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) referencedView.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#setReferencedView(EObject newValue)
	 */
	public void setReferencedView(EObject newValue) {
		if (newValue != null)
			referencedView.setSelection(new StructuredSelection(newValue));
		else
			referencedView.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForReferencedView (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForReferencedView () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
