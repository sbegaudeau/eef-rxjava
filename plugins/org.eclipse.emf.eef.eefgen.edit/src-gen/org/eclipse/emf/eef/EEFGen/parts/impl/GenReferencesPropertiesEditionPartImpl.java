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
 * $Id: GenReferencesPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:12:37 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.impl;

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

import org.eclipse.emf.eef.EEFGen.GenEditionContext	;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenReferencesPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenReferencesPropertiesEditionPartImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.components.PropertiesEditionContext;	



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenReferencesPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenReferencesPropertiesEditionPart {

	protected GenEditionContext current;
	protected ResourceSet resourceSet;
	private EObjectFlatComboViewer propertiesEditionContext;
		
	public GenReferencesPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createReferencesGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createReferencesGroup(Composite parent) {
		Group referencesGroup = new Group(parent, SWT.NONE);
		referencesGroup.setText(EEFGenMessages.GenReferencesPropertiesEditionPart_ReferencesGroupLabel);
		GridData referencesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		referencesGroupData.horizontalSpan = 3;
		referencesGroup.setLayoutData(referencesGroupData);
		GridLayout referencesGroupLayout = new GridLayout();
		referencesGroupLayout.numColumns = 3;
		referencesGroup.setLayout(referencesGroupLayout);
		createPropertiesEditionContextFlatComboViewer(referencesGroup);
   	}

	/**
	 * @param referencesGroup
	 */
	protected void createPropertiesEditionContextFlatComboViewer(Composite parent) {
	
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenReferencesPropertiesEditionPart_PropertiesEditionContextLabel, true);		
		propertiesEditionContext = new EObjectFlatComboViewer(parent, false);
		propertiesEditionContext.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		propertiesEditionContext.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof PropertiesEditionContext);			
			}

		});
		propertiesEditionContext.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenReferencesPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenReferences.propertiesEditionContext, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, getPropertiesEditionContext()));
			}

		});
		GridData propertiesEditionContextData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesEditionContext.setLayoutData(propertiesEditionContextData);
		SWTUtils.createHelpButton(parent, "The PropertiesEditioContext to describe", null); //$NON-NLS-1$
	}


	public void initComponent(EObject eObject, ResourceSet allResources) {
		GenEditionContext genEditionContext = (GenEditionContext)eObject;
		current = genEditionContext;
		resourceSet = allResources;
		propertiesEditionContext.setInput(allResources);
		if (genEditionContext.getPropertiesEditionContext() != null){
			propertiesEditionContext.setSelection(new StructuredSelection(genEditionContext.getPropertiesEditionContext()));
		}
		// Start of user code for propertiesEditionContext filters initialisation

 		// End of user code
	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenReferencesPropertiesEditionPart#getPropertiesEditionContext()
	 */
	public EObject getPropertiesEditionContext() {
		if (propertiesEditionContext.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) propertiesEditionContext.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenReferencesPropertiesEditionPart#setPropertiesEditionContext(EObject newValue)
	 */
	public void setPropertiesEditionContext(EObject newValue) {
		if (newValue != null)
			propertiesEditionContext.setSelection(new StructuredSelection(newValue));
		else
			propertiesEditionContext.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForPropertiesEditionContext (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForPropertiesEditionContext () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
