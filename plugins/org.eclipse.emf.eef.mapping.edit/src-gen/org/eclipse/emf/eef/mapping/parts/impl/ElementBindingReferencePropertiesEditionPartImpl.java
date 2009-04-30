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
 * $Id: ElementBindingReferencePropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:14:44 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.parts.impl;

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

import org.eclipse.emf.eef.mapping.ElementBindingReference	;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.impl.ElementBindingReferencePropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.mapping.AbstractElementBinding;	



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ElementBindingReferencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ElementBindingReferencePropertiesEditionPart {

	protected ElementBindingReference current;
	protected ResourceSet resourceSet;
	private EObjectFlatComboViewer binding;
		
	public ElementBindingReferencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createReferenceGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createReferenceGroup(Composite parent) {
		Group referenceGroup = new Group(parent, SWT.NONE);
		referenceGroup.setText(MappingMessages.ElementBindingReferencePropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		referenceGroupData.horizontalSpan = 3;
		referenceGroup.setLayoutData(referenceGroupData);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createBindingFlatComboViewer(referenceGroup);
   	}

	/**
	 * @param referenceGroup
	 */
	protected void createBindingFlatComboViewer(Composite parent) {
	
		SWTUtils.createPartLabel(parent, MappingMessages.ElementBindingReferencePropertiesEditionPart_BindingLabel, true);		
		binding = new EObjectFlatComboViewer(parent, false);
		binding.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		binding.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof AbstractElementBinding);			
			}

		});
		binding.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ElementBindingReferencePropertiesEditionPartImpl.this, MappingViewsRepository.ElementBindingReference.binding, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, getBinding()));
			}

		});
		GridData bindingData = new GridData(GridData.FILL_HORIZONTAL);
		binding.setLayoutData(bindingData);
		SWTUtils.createHelpButton(parent, "The referenced element binding", null); //$NON-NLS-1$
	}


	public void initComponent(EObject eObject, ResourceSet allResources) {
		ElementBindingReference elementBindingReference = (ElementBindingReference)eObject;
		current = elementBindingReference;
		resourceSet = allResources;
		binding.setInput(allResources);
		if (elementBindingReference.getBinding() != null){
			binding.setSelection(new StructuredSelection(elementBindingReference.getBinding()));
		}
		// Start of user code for binding filters initialisation

 		// End of user code
	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#getBinding()
	 */
	public EObject getBinding() {
		if (binding.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) binding.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#setBinding(EObject newValue)
	 */
	public void setBinding(EObject newValue) {
		if (newValue != null)
			binding.setSelection(new StructuredSelection(newValue));
		else
			binding.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForBinding (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForBinding () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
