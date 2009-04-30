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
 * $Id: ViewsRepositoryPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:16:52 glefur Exp $
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

import org.eclipse.emf.eef.views.ViewsRepository	;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.providers.ViewsMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.emf.eef.views.parts.ViewsRepositoryPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.impl.ViewsRepositoryPropertiesEditionPartImpl;




// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewsRepositoryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ViewsRepositoryPropertiesEditionPart {

	private Text name;
	private Text repositoryKind;
		
	public ViewsRepositoryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(ViewsMessages.ViewsRepositoryPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
		createRepositoryKindText(propertiesGroup);
   	}

	private void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ViewsMessages.ViewsRepositoryPropertiesEditionPart_NameLabel, true);
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ViewsRepositoryPropertiesEditionPartImpl.this, ViewsViewsRepository.ViewsRepository.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The repository name", null); //$NON-NLS-1$
	}

	private void createRepositoryKindText(Composite parent) {
		SWTUtils.createPartLabel(parent, ViewsMessages.ViewsRepositoryPropertiesEditionPart_RepositoryKindLabel, true);
		repositoryKind = new Text(parent, SWT.BORDER);
		GridData repositoryKindData = new GridData(GridData.FILL_HORIZONTAL);
		repositoryKind.setLayoutData(repositoryKindData);
		repositoryKind.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ViewsRepositoryPropertiesEditionPartImpl.this, ViewsViewsRepository.ViewsRepository.repositoryKind, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, repositoryKind.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The kind of the repository (available values)", null); //$NON-NLS-1$
	}


	public void initComponent(EObject eObject, ResourceSet allResources) {
		ViewsRepository viewsRepository = (ViewsRepository)eObject;
		if (viewsRepository.getRepositoryKind() != null){
			repositoryKind.setText(viewsRepository.getRepositoryKind());
		}	
		if (viewsRepository.getName() != null){
			name.setText(viewsRepository.getName());
		}	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewsRepositoryPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewsRepositoryPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.eef.views.parts.ViewsRepositoryPropertiesEditionPart#getRepositoryKind()
	 */
	public String getRepositoryKind() {
		return repositoryKind.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewsRepositoryPropertiesEditionPart#setRepositoryKind(String newValue)
	 */
	public void setRepositoryKind(String newValue) {
		repositoryKind.setText(newValue);
	}

	public void setMessageForRepositoryKind (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRepositoryKind () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
