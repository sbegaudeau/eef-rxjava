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
 * $Id: GenParametersPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:12:37 glefur Exp $
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
import org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenParametersPropertiesEditionPartImpl;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.emf.eef.runtime.ui.widgets.EENumViewer;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenParametersPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenParametersPropertiesEditionPart {

	private Text basePackage;
	private Text genDirectory;
	private Text descriptorsContributorID;
	private EENumViewer helpStrategy;
	private Text author;
	private Text license;
		
	public GenParametersPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createParametersGroup(view);
		createLegalGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EEFGenMessages.GenParametersPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(parametersGroup);
		createGenDirectoryText(parametersGroup);
		createDescriptorsContributorIDText(parametersGroup);
		createHelpStrategyEEnumViewer(parametersGroup);
   	}

	private void createBasePackageText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenParametersPropertiesEditionPart_BasePackageLabel, false);
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenParameters.basePackage, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, basePackage.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The base package for all the generated code", null); //$NON-NLS-1$
	}

	private void createGenDirectoryText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenParametersPropertiesEditionPart_GenDirectoryLabel, true);
		genDirectory = new Text(parent, SWT.BORDER);
		GridData genDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		genDirectory.setLayoutData(genDirectoryData);
		genDirectory.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenParameters.genDirectory, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, genDirectory.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The target directory for the generated code", null); //$NON-NLS-1$
	}

	private void createDescriptorsContributorIDText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenParametersPropertiesEditionPart_DescriptorsContributorIDLabel, false);
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenParameters.descriptorsContributorID, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "Override if necessary the contributorID to use for generic descriptors", null); //$NON-NLS-1$
	}

	protected void createHelpStrategyEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenParametersPropertiesEditionPart_HelpStrategyLabel, true);
		helpStrategy = new EENumViewer(parent);
		GridData helpStrategyData = new GridData(GridData.FILL_HORIZONTAL);
		helpStrategy.getCombo().setLayoutData(helpStrategyData);
		SWTUtils.createHelpButton(parent, "Defines where the generators have to search the help entries", null); //$NON-NLS-1$
	}

	private void createLegalGroup(Composite parent) {
		Group legalGroup = new Group(parent, SWT.NONE);
		legalGroup.setText(EEFGenMessages.GenParametersPropertiesEditionPart_LegalGroupLabel);
		GridData legalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		legalGroupData.horizontalSpan = 3;
		legalGroup.setLayoutData(legalGroupData);
		GridLayout legalGroupLayout = new GridLayout();
		legalGroupLayout.numColumns = 3;
		legalGroup.setLayout(legalGroupLayout);
		createAuthorText(legalGroup);
		createLicenseTextarea(legalGroup);
   	}

	private void createAuthorText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenParametersPropertiesEditionPart_AuthorLabel, false);
		author = new Text(parent, SWT.BORDER);
		GridData authorData = new GridData(GridData.FILL_HORIZONTAL);
		author.setLayoutData(authorData);
		author.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenParameters.author, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, author.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The string that must be generated for the @author tag", null); //$NON-NLS-1$
	}

	protected void createLicenseTextarea(Composite parent) {
		Label licenseLabel = SWTUtils.createPartLabel(parent, EEFGenMessages.GenParametersPropertiesEditionPart_LicenseLabel, false);
		GridData licenseLabelData = new GridData(GridData.FILL_HORIZONTAL);
		licenseLabelData.horizontalSpan = 3;
		licenseLabel.setLayoutData(licenseLabelData);
		license = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		licenseData.horizontalSpan = 2;
		licenseData.heightHint = 80;
		license.setLayoutData(licenseData);
		SWTUtils.createHelpButton(parent, "The license text of the generated code", null); //$NON-NLS-1$
	}		


	public void initComponent(EObject eObject, ResourceSet allResources) {
		GenEditionContext genEditionContext = (GenEditionContext)eObject;
		if (genEditionContext.getBasePackage() != null){
			basePackage.setText(genEditionContext.getBasePackage());
		}	
		if (genEditionContext.getGenDirectory() != null){
			genDirectory.setText(genEditionContext.getGenDirectory());
		}	
		if (genEditionContext.getDescriptorsContributorID() != null){
			descriptorsContributorID.setText(genEditionContext.getDescriptorsContributorID());
		}	
		helpStrategy.setContentProvider(new ArrayContentProvider());
		helpStrategy.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		helpStrategy.setInput(((EEnum) EEFGenPackage.eINSTANCE.getGenEditionContext_HelpStrategy().getEType()).getELiterals());
		helpStrategy.setSelection(new StructuredSelection(genEditionContext.getHelpStrategy()));	
		if (genEditionContext.getAuthor() != null){
			author.setText(genEditionContext.getAuthor());
		}	
		if (genEditionContext.getLicense() != null){
			license.setText(genEditionContext.getLicense());
		}	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#getBasePackage()
	 */
	public String getBasePackage() {
		return basePackage.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#setBasePackage(String newValue)
	 */
	public void setBasePackage(String newValue) {
		basePackage.setText(newValue);
	}

	public void setMessageForBasePackage (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForBasePackage () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#getGenDirectory()
	 */
	public String getGenDirectory() {
		return genDirectory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#setGenDirectory(String newValue)
	 */
	public void setGenDirectory(String newValue) {
		genDirectory.setText(newValue);
	}

	public void setMessageForGenDirectory (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForGenDirectory () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#getDescriptorsContributorID()
	 */
	public String getDescriptorsContributorID() {
		return descriptorsContributorID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#setDescriptorsContributorID(String newValue)
	 */
	public void setDescriptorsContributorID(String newValue) {
		descriptorsContributorID.setText(newValue);
	}

	public void setMessageForDescriptorsContributorID (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForDescriptorsContributorID () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#getHelpStrategy()
	 */
	public Enumerator getHelpStrategy() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) helpStrategy.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#setHelpStrategy(Enumerator newValue)
	 */
	public void setHelpStrategy(Enumerator newValue) {
		helpStrategy.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForHelpStrategy (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForHelpStrategy () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#getAuthor()
	 */
	public String getAuthor() {
		return author.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#setAuthor(String newValue)
	 */
	public void setAuthor(String newValue) {
		author.setText(newValue);
	}

	public void setMessageForAuthor (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForAuthor () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#getLicense()
	 */
	public String getLicense() {
		return license.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart#setLicense(String newValue)
	 */
	public void setLicense(String newValue) {
		license.setText(newValue);
	}

	public void setMessageForLicense (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForLicense () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
