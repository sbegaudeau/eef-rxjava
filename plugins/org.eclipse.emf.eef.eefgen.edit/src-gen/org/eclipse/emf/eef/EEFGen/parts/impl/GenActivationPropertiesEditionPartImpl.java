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
 * $Id: GenActivationPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:12:37 glefur Exp $
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
import org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenActivationPropertiesEditionPartImpl;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenActivationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenActivationPropertiesEditionPart {

	private Button descriptorsGenericPropertiesViews;
	private Button formViews;
	private Button gmfPropertiesViews;
	private Button swtViews;
		
	public GenActivationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createActivationGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createActivationGroup(Composite parent) {
		Group activationGroup = new Group(parent, SWT.NONE);
		activationGroup.setText(EEFGenMessages.GenActivationPropertiesEditionPart_ActivationGroupLabel);
		GridData activationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		activationGroupData.horizontalSpan = 3;
		activationGroup.setLayoutData(activationGroupData);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createDescriptorsGenericPropertiesViewsCheckbox(activationGroup);
		createFormViewsCheckbox(activationGroup);
		createGmfPropertiesViewsCheckbox(activationGroup);
		createSwtViewsCheckbox(activationGroup);
   	}

	protected void createDescriptorsGenericPropertiesViewsCheckbox(Composite parent) {
		descriptorsGenericPropertiesViews = new Button(parent, SWT.CHECK);
		descriptorsGenericPropertiesViews.setText(EEFGenMessages.GenActivationPropertiesEditionPart_DescriptorsGenericPropertiesViewsLabel);
		GridData descriptorsGenericPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsGenericPropertiesViewsData.horizontalSpan = 2;
		descriptorsGenericPropertiesViews.setLayoutData(descriptorsGenericPropertiesViewsData);
		SWTUtils.createHelpButton(parent, "Whether to include a sample configuration for plugin.xml to use a generic EEF properties view", null); //$NON-NLS-1$
	}

	protected void createFormViewsCheckbox(Composite parent) {
		formViews = new Button(parent, SWT.CHECK);
		formViews.setText(EEFGenMessages.GenActivationPropertiesEditionPart_FormViewsLabel);
		GridData formViewsData = new GridData(GridData.FILL_HORIZONTAL);
		formViewsData.horizontalSpan = 2;
		formViews.setLayoutData(formViewsData);
		SWTUtils.createHelpButton(parent, "Whether to include the Eclipse Forms implementation of views", null); //$NON-NLS-1$
	}

	protected void createGmfPropertiesViewsCheckbox(Composite parent) {
		gmfPropertiesViews = new Button(parent, SWT.CHECK);
		gmfPropertiesViews.setText(EEFGenMessages.GenActivationPropertiesEditionPart_GmfPropertiesViewsLabel);
		GridData gmfPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		gmfPropertiesViewsData.horizontalSpan = 2;
		gmfPropertiesViews.setLayoutData(gmfPropertiesViewsData);
		SWTUtils.createHelpButton(parent, "Whether to include a views implementation and a sample configuration for plugin.xml to use EEF on a GMF modeler", null); //$NON-NLS-1$
	}

	protected void createSwtViewsCheckbox(Composite parent) {
		swtViews = new Button(parent, SWT.CHECK);
		swtViews.setText(EEFGenMessages.GenActivationPropertiesEditionPart_SwtViewsLabel);
		GridData swtViewsData = new GridData(GridData.FILL_HORIZONTAL);
		swtViewsData.horizontalSpan = 2;
		swtViews.setLayoutData(swtViewsData);
		SWTUtils.createHelpButton(parent, "Whether to include the SWT implementation of views", null); //$NON-NLS-1$
	}


	public void initComponent(EObject eObject, ResourceSet allResources) {
		GenEditionContext genEditionContext = (GenEditionContext)eObject;
		swtViews.setSelection(genEditionContext.isSwtViews());	
		formViews.setSelection(genEditionContext.isFormViews());	
		descriptorsGenericPropertiesViews.setSelection(genEditionContext.isDescriptorsGenericPropertiesViews());	
		gmfPropertiesViews.setSelection(genEditionContext.isGmfPropertiesViews());	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getDescriptorsGenericPropertiesViews()
	 */
	public Boolean getDescriptorsGenericPropertiesViews() {
		return Boolean.valueOf(descriptorsGenericPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setDescriptorsGenericPropertiesViews(Boolean newValue)
	 */
	public void setDescriptorsGenericPropertiesViews(Boolean newValue) {
		descriptorsGenericPropertiesViews.setSelection(newValue.booleanValue());
	}

	public void setMessageForDescriptorsGenericPropertiesViews (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForDescriptorsGenericPropertiesViews () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getFormViews()
	 */
	public Boolean getFormViews() {
		return Boolean.valueOf(formViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setFormViews(Boolean newValue)
	 */
	public void setFormViews(Boolean newValue) {
		formViews.setSelection(newValue.booleanValue());
	}

	public void setMessageForFormViews (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForFormViews () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getGmfPropertiesViews()
	 */
	public Boolean getGmfPropertiesViews() {
		return Boolean.valueOf(gmfPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setGmfPropertiesViews(Boolean newValue)
	 */
	public void setGmfPropertiesViews(Boolean newValue) {
		gmfPropertiesViews.setSelection(newValue.booleanValue());
	}

	public void setMessageForGmfPropertiesViews (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForGmfPropertiesViews () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getSwtViews()
	 */
	public Boolean getSwtViews() {
		return Boolean.valueOf(swtViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setSwtViews(Boolean newValue)
	 */
	public void setSwtViews(Boolean newValue) {
		swtViews.setSelection(newValue.booleanValue());
	}

	public void setMessageForSwtViews (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForSwtViews () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
