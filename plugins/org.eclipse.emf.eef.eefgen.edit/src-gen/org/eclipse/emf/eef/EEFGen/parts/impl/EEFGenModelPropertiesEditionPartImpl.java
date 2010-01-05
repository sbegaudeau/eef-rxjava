/**
 *  Copyright (c) 2008-2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.EEFGen.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenModelPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EEFGenModelPropertiesEditionPart {

	protected Text generationDirectory;
	protected Text testsGenerationDirectory;
	protected Text author;
	protected Text license;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EEFGenModelPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createParametersGroup(view);

		createLegalGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createGenerationDirectoryText(parametersGroup);
		createTestsGenerationDirectoryText(parametersGroup);
	}

	protected void createGenerationDirectoryText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_GenerationDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.generationDirectory, EEFGenViewsRepository.SWT_KIND));
		generationDirectory = new Text(parent, SWT.BORDER);
		GridData generationDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		generationDirectory.setLayoutData(generationDirectoryData);
		generationDirectory.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartImpl.this, EEFGenViewsRepository.EEFGenModel.generationDirectory, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, generationDirectory.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.generationDirectory, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createTestsGenerationDirectoryText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_TestsGenerationDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, EEFGenViewsRepository.SWT_KIND));
		testsGenerationDirectory = new Text(parent, SWT.BORDER);
		GridData testsGenerationDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		testsGenerationDirectory.setLayoutData(testsGenerationDirectoryData);
		testsGenerationDirectory.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartImpl.this, EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, testsGenerationDirectory.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createLegalGroup(Composite parent) {
		Group legalGroup = new Group(parent, SWT.NONE);
		legalGroup.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_LegalGroupLabel);
		GridData legalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		legalGroupData.horizontalSpan = 3;
		legalGroup.setLayoutData(legalGroupData);
		GridLayout legalGroupLayout = new GridLayout();
		legalGroupLayout.numColumns = 3;
		legalGroup.setLayout(legalGroupLayout);
		createAuthorText(legalGroup);
		createLicenseTextarea(legalGroup);
	}

	protected void createAuthorText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_AuthorLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.author, EEFGenViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartImpl.this, EEFGenViewsRepository.EEFGenModel.author, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, author.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.author, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createLicenseTextarea(Composite parent) {
		Label licenseLabel = SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_LicenseLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.SWT_KIND));
		GridData licenseLabelData = new GridData(GridData.FILL_HORIZONTAL);
		licenseLabelData.horizontalSpan = 3;
		licenseLabel.setLayoutData(licenseLabelData);
		license = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		licenseData.horizontalSpan = 2;
		licenseData.heightHint = 80;
		license.setLayoutData(licenseData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getGenerationDirectory()
	 */
	public String getGenerationDirectory() {
		return generationDirectory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setGenerationDirectory(String newValue)
	 */
	public void setGenerationDirectory(String newValue) {
		if (newValue != null) {
			generationDirectory.setText(newValue);
		} else {
			generationDirectory.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForGenerationDirectory(String msg, int msgLevel) {

	}

	public void unsetMessageForGenerationDirectory() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getTestsGenerationDirectory()
	 */
	public String getTestsGenerationDirectory() {
		return testsGenerationDirectory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setTestsGenerationDirectory(String newValue)
	 */
	public void setTestsGenerationDirectory(String newValue) {
		if (newValue != null) {
			testsGenerationDirectory.setText(newValue);
		} else {
			testsGenerationDirectory.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForTestsGenerationDirectory(String msg, int msgLevel) {

	}

	public void unsetMessageForTestsGenerationDirectory() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getAuthor()
	 */
	public String getAuthor() {
		return author.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setAuthor(String newValue)
	 */
	public void setAuthor(String newValue) {
		if (newValue != null) {
			author.setText(newValue);
		} else {
			author.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForAuthor(String msg, int msgLevel) {

	}

	public void unsetMessageForAuthor() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getLicense()
	 */
	public String getLicense() {
		return license.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setLicense(String newValue)
	 */
	public void setLicense(String newValue) {
		if (newValue != null) {
			license.setText(newValue);
		} else {
			license.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForLicense(String msg, int msgLevel) {

	}

	public void unsetMessageForLicense() {

	}








	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return EEFGenMessages.EEFGenModel_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code

}
