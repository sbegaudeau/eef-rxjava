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
 * $Id: EEFGenModelPropertiesEditionPartForm.java,v 1.2 2009/05/05 12:06:10 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenModelPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EEFGenModelPropertiesEditionPart {

	private Text genDirectory;
	private Text author;
	private Text license;




	
	public EEFGenModelPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createParametersGroup(widgetFactory, view);
		createLegalGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createParametersGroup(FormToolkit widgetFactory, final Composite view) {
		Section parametersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		parametersSection.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		parametersSectionData.horizontalSpan = 3;
		parametersSection.setLayoutData(parametersSectionData);
		Composite parametersGroup = widgetFactory.createComposite(parametersSection);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createGenDirectoryText(widgetFactory, parametersGroup);
		parametersSection.setClient(parametersGroup);
	}
	protected void createGenDirectoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_GenDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.genDirectory, EEFGenViewsRepository.FORM_KIND));
		genDirectory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		genDirectory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData genDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		genDirectory.setLayoutData(genDirectoryData);
		genDirectory.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.genDirectory, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, genDirectory.getText()));
			}
			
		});
		genDirectory.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.genDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, genDirectory.getText()));
			}

		});
		genDirectory.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.genDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, genDirectory.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.genDirectory, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createLegalGroup(FormToolkit widgetFactory, final Composite view) {
		Section legalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		legalSection.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_LegalGroupLabel);
		GridData legalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		legalSectionData.horizontalSpan = 3;
		legalSection.setLayoutData(legalSectionData);
		Composite legalGroup = widgetFactory.createComposite(legalSection);
		GridLayout legalGroupLayout = new GridLayout();
		legalGroupLayout.numColumns = 3;
		legalGroup.setLayout(legalGroupLayout);
		createAuthorText(widgetFactory, legalGroup);
		createLicenseText(widgetFactory, legalGroup);
		legalSection.setClient(legalGroup);
	}
	protected void createAuthorText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_AuthorLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.author, EEFGenViewsRepository.FORM_KIND));
		author = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		author.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData authorData = new GridData(GridData.FILL_HORIZONTAL);
		author.setLayoutData(authorData);
		author.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.author, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, author.getText()));
			}
			
		});
		author.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.author, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, author.getText()));
			}

		});
		author.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.author, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, author.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.author, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createLicenseText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_LicenseLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.FORM_KIND));
		license = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		license.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		license.setLayoutData(licenseData);
		license.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.license, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, license.getText()));
			}
			
		});
		license.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.license, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, license.getText()));
			}

		});
		license.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.license, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, license.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$

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
		messageManager.addMessage("GenDirectory_key", msg, null, msgLevel, genDirectory);
	}

	public void unsetMessageForGenDirectory() {
		messageManager.removeMessage("GenDirectory_key", genDirectory);
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
		messageManager.addMessage("Author_key", msg, null, msgLevel, author);
	}

	public void unsetMessageForAuthor() {
		messageManager.removeMessage("Author_key", author);
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
		messageManager.addMessage("License_key", msg, null, msgLevel, license);
	}

	public void unsetMessageForLicense() {
		messageManager.removeMessage("License_key", license);
	}







	
	// Start of user code additional methods
 	
	// End of user code
}	
