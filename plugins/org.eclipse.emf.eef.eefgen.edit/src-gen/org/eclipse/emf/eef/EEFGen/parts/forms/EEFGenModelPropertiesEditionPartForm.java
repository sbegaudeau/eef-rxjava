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
import org.eclipse.swt.widgets.Label;
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

	protected Text generationDirectory;
	protected Text testsGenerationDirectory;
	protected Text author;
	protected Text license;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EEFGenModelPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
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

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
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
		createGenerationDirectoryText(widgetFactory, parametersGroup);
		createTestsGenerationDirectoryText(widgetFactory, parametersGroup);
		parametersSection.setClient(parametersGroup);
	}
	protected void createGenerationDirectoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_GenerationDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.generationDirectory, EEFGenViewsRepository.FORM_KIND));
		generationDirectory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		generationDirectory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData generationDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		generationDirectory.setLayoutData(generationDirectoryData);
		generationDirectory.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.generationDirectory, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, generationDirectory.getText()));
			}

		});
		generationDirectory.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.generationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, generationDirectory.getText()));
			}

		});
		generationDirectory.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.generationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, generationDirectory.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.generationDirectory, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createTestsGenerationDirectoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_TestsGenerationDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, EEFGenViewsRepository.FORM_KIND));
		testsGenerationDirectory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		testsGenerationDirectory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData testsGenerationDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		testsGenerationDirectory.setLayoutData(testsGenerationDirectoryData);
		testsGenerationDirectory.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, testsGenerationDirectory.getText()));
			}

		});
		testsGenerationDirectory.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, testsGenerationDirectory.getText()));
			}

		});
		testsGenerationDirectory.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, testsGenerationDirectory.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createLicenseTextarea(widgetFactory, legalGroup);
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
	protected void createLicenseTextarea(FormToolkit widgetFactory, Composite parent) {
		Label licenseLabel = FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_LicenseLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.FORM_KIND));
		GridData licenseLabelData = new GridData(GridData.FILL_HORIZONTAL);
		licenseLabelData.horizontalSpan = 3;
		licenseLabel.setLayoutData(licenseLabelData);
		license = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI); //$NON-NLS-1$
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		licenseData.horizontalSpan = 2;
		licenseData.heightHint = 80;
		license.setLayoutData(licenseData);
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
		messageManager.addMessage("GenerationDirectory_key", msg, null, msgLevel, generationDirectory);
	}

	public void unsetMessageForGenerationDirectory() {
		messageManager.removeMessage("GenerationDirectory_key", generationDirectory);
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
		messageManager.addMessage("TestsGenerationDirectory_key", msg, null, msgLevel, testsGenerationDirectory);
	}

	public void unsetMessageForTestsGenerationDirectory() {
		messageManager.removeMessage("TestsGenerationDirectory_key", testsGenerationDirectory);
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
		if (newValue != null) {
			license.setText(newValue);
		} else {
			license.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForLicense(String msg, int msgLevel) {
		messageManager.addMessage("License_key", msg, null, msgLevel, license);
	}

	public void unsetMessageForLicense() {
		messageManager.removeMessage("License_key", license);
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
