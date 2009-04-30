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
 * $Id: EEFGenModelPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:49:28 nlepine Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
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
import org.eclipse.swt.widgets.Text;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenModelPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EEFGenModelPropertiesEditionPart {

	private Text genDirectory;
	private Text author;
	private Text license;




	
	public EEFGenModelPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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

	protected void createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createGenDirectoryText(parametersGroup);
	}
	protected void createGenDirectoryText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_GenDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.genDirectory, EEFGenViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartImpl.this, EEFGenViewsRepository.EEFGenModel.genDirectory, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, genDirectory.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.genDirectory, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
		createLicenseText(legalGroup);
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
	protected void createLicenseText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_LicenseLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.SWT_KIND));
		license = new Text(parent, SWT.BORDER);
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		license.setLayoutData(licenseData);
		license.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartImpl.this, EEFGenViewsRepository.EEFGenModel.license, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, license.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getGenDirectory()
	 */
	public String getGenDirectory() {
		return genDirectory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setGenDirectory(String newValue)
	 */
	public void setGenDirectory(String newValue) {
		genDirectory.setText(newValue);
	}

	public void setMessageForGenDirectory(String msg, int msgLevel) {

	}

	public void unsetMessageForGenDirectory() {

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
		author.setText(newValue);
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
		license.setText(newValue);
	}

	public void setMessageForLicense(String msg, int msgLevel) {

	}

	public void unsetMessageForLicense() {

	}








	// Start of user code additional methods
 	
	// End of user code
}
