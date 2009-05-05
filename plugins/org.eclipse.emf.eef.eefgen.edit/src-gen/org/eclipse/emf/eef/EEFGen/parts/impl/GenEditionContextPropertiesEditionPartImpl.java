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
 * $Id: GenEditionContextPropertiesEditionPartImpl.java,v 1.2 2009/05/05 12:06:11 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.impl;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenEditionContextPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenEditionContextPropertiesEditionPart {

	protected EObjectFlatComboViewer propertiesEditionContext;
	private Text basePackage;
	private Text descriptorsContributorID;
	private Button descriptorsGenericPropertiesViews;
	private Button gmfPropertiesViews;




	
	public GenEditionContextPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createParametersGroup(view);
		createActivationGroup(view);
		
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createReferenceGroup(Composite parent) {
		Group referenceGroup = new Group(parent, SWT.NONE);
		referenceGroup.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		referenceGroupData.horizontalSpan = 3;
		referenceGroup.setLayoutData(referenceGroupData);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createPropertiesEditionContextFlatComboViewer(referenceGroup);
	}
	/**
	 * @param referenceGroup
	 */
	protected void createPropertiesEditionContextFlatComboViewer(Composite parent) {

		SWTUtils.createPartLabel(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_PropertiesEditionContextLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, EEFGenViewsRepository.SWT_KIND));
		propertiesEditionContext = new EObjectFlatComboViewer(parent, false);
		propertiesEditionContext.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		// Start of user code for propertiesEditionContext filters initialisation

 		// End of user code		
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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getPropertiesEditionContext()));
			}

		});
		GridData propertiesEditionContextData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesEditionContext.setLayoutData(propertiesEditionContextData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(parametersGroup);
		createDescriptorsContributorIDText(parametersGroup);
	}
	protected void createBasePackageText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_BasePackageLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.basePackage, EEFGenViewsRepository.SWT_KIND));
		basePackage = new Text(parent, SWT.BORDER);
		GridData basePackageData = new GridData(GridData.FILL_HORIZONTAL);
		basePackage.setLayoutData(basePackageData);
		basePackage.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, basePackage.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.basePackage, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createDescriptorsContributorIDText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_DescriptorsContributorIDLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.SWT_KIND));
		descriptorsContributorID = new Text(parent, SWT.BORDER);
		GridData descriptorsContributorIDData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsContributorID.setLayoutData(descriptorsContributorIDData);
		descriptorsContributorID.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createActivationGroup(Composite parent) {
		Group activationGroup = new Group(parent, SWT.NONE);
		activationGroup.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ActivationGroupLabel);
		GridData activationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		activationGroupData.horizontalSpan = 3;
		activationGroup.setLayoutData(activationGroupData);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createDescriptorsGenericPropertiesViewsCheckbox(activationGroup);
		createGmfPropertiesViewsCheckbox(activationGroup);
	}
	protected void createDescriptorsGenericPropertiesViewsCheckbox(Composite parent) {
		descriptorsGenericPropertiesViews = new Button(parent, SWT.CHECK);
		descriptorsGenericPropertiesViews.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_DescriptorsGenericPropertiesViewsLabel);
		GridData descriptorsGenericPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsGenericPropertiesViewsData.horizontalSpan = 2;
		descriptorsGenericPropertiesViews.setLayoutData(descriptorsGenericPropertiesViewsData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.descriptorsGenericPropertiesViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createGmfPropertiesViewsCheckbox(Composite parent) {
		gmfPropertiesViews = new Button(parent, SWT.CHECK);
		gmfPropertiesViews.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_GmfPropertiesViewsLabel);
		GridData gmfPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		gmfPropertiesViewsData.horizontalSpan = 2;
		gmfPropertiesViews.setLayoutData(gmfPropertiesViewsData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.gmfPropertiesViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getPropertiesEditionContext()
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
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#initPropertiesEditionContext(ResourceSet allResources, EObject current)
	 */
	public void initPropertiesEditionContext(ResourceSet allResources, EObject current) {
		propertiesEditionContext.setInput(allResources);
		if (current != null)
			propertiesEditionContext.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setPropertiesEditionContext(EObject newValue)
	 */
	public void setPropertiesEditionContext(EObject newValue) {
		if (newValue != null)
			propertiesEditionContext.setSelection(new StructuredSelection(newValue));
		else
			propertiesEditionContext.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForPropertiesEditionContext(String msg, int msgLevel) {

	}

	public void unsetMessageForPropertiesEditionContext() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getBasePackage()
	 */
	public String getBasePackage() {
		return basePackage.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setBasePackage(String newValue)
	 */
	public void setBasePackage(String newValue) {
		basePackage.setText(newValue);
	}

	public void setMessageForBasePackage(String msg, int msgLevel) {

	}

	public void unsetMessageForBasePackage() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getDescriptorsContributorID()
	 */
	public String getDescriptorsContributorID() {
		return descriptorsContributorID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setDescriptorsContributorID(String newValue)
	 */
	public void setDescriptorsContributorID(String newValue) {
		descriptorsContributorID.setText(newValue);
	}

	public void setMessageForDescriptorsContributorID(String msg, int msgLevel) {

	}

	public void unsetMessageForDescriptorsContributorID() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getDescriptorsGenericPropertiesViews()
	 */
	public Boolean getDescriptorsGenericPropertiesViews() {
		return Boolean.valueOf(descriptorsGenericPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setDescriptorsGenericPropertiesViews(Boolean newValue)
	 */
	public void setDescriptorsGenericPropertiesViews(Boolean newValue) {
		if (newValue != null) {
			descriptorsGenericPropertiesViews.setSelection(newValue.booleanValue());
		} else {
			descriptorsGenericPropertiesViews.setSelection(false);
		}
	}

	public void setMessageForDescriptorsGenericPropertiesViews(String msg, int msgLevel) {

	}

	public void unsetMessageForDescriptorsGenericPropertiesViews() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getGmfPropertiesViews()
	 */
	public Boolean getGmfPropertiesViews() {
		return Boolean.valueOf(gmfPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setGmfPropertiesViews(Boolean newValue)
	 */
	public void setGmfPropertiesViews(Boolean newValue) {
		if (newValue != null) {
			gmfPropertiesViews.setSelection(newValue.booleanValue());
		} else {
			gmfPropertiesViews.setSelection(false);
		}
	}

	public void setMessageForGmfPropertiesViews(String msg, int msgLevel) {

	}

	public void unsetMessageForGmfPropertiesViews() {

	}








	// Start of user code additional methods
 	
	// End of user code
}
