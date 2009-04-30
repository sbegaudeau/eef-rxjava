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
 * $Id: GenParametersPropertiesEditionPartForm.java,v 1.1 2009/04/30 17:12:37 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.emf.eef.runtime.ui.widgets.EENumViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;




// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenParametersPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, GenParametersPropertiesEditionPart {

	private Text basePackage;
	private Text genDirectory;
	private Text descriptorsContributorID;
	private EENumViewer helpStrategy;
	private Text author;
	private Text license;
		
	public GenParametersPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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

	private void createParametersGroup(FormToolkit widgetFactory, final Composite view) {
		Section parametersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		parametersSection.setText(EEFGenMessages.GenParametersPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		parametersSectionData.horizontalSpan = 3;
		parametersSection.setLayoutData(parametersSectionData);
		Composite parametersGroup = widgetFactory.createComposite(parametersSection);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(widgetFactory, parametersGroup);
		createGenDirectoryText(widgetFactory, parametersGroup);
		createDescriptorsContributorIDText(widgetFactory, parametersGroup);
		createHelpStrategyEEnumViewer(widgetFactory, parametersGroup);
		parametersSection.setClient(parametersGroup);
	}   		

	private void createBasePackageText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenParametersPropertiesEditionPart_BasePackageLabel, false);
		basePackage = widgetFactory.createText(parent, "");  //$NON-NLS-1$
		basePackage.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData basePackageData = new GridData(GridData.FILL_HORIZONTAL);
		basePackage.setLayoutData(basePackageData);
		basePackage.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.basePackage, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, basePackage.getText()));
			}
			
		});
		basePackage.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.basePackage, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, basePackage.getText()));
			}
			
		});
		basePackage.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.basePackage, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, basePackage.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, "The base package for all the generated code", null); //$NON-NLS-1$
	}

	private void createGenDirectoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenParametersPropertiesEditionPart_GenDirectoryLabel, true);
		genDirectory = widgetFactory.createText(parent, "");  //$NON-NLS-1$
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.genDirectory, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, genDirectory.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.genDirectory, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, genDirectory.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.genDirectory, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, genDirectory.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, "The target directory for the generated code", null); //$NON-NLS-1$
	}

	private void createDescriptorsContributorIDText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenParametersPropertiesEditionPart_DescriptorsContributorIDLabel, false);
		descriptorsContributorID = widgetFactory.createText(parent, "");  //$NON-NLS-1$
		descriptorsContributorID.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptorsContributorIDData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsContributorID.setLayoutData(descriptorsContributorIDData);
		descriptorsContributorID.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.descriptorsContributorID, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
			}
			
		});
		descriptorsContributorID.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.descriptorsContributorID, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
			}
			
		});
		descriptorsContributorID.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.descriptorsContributorID, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, "Override if necessary the contributorID to use for generic descriptors", null); //$NON-NLS-1$
	}

	private void createHelpStrategyEEnumViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenParametersPropertiesEditionPart_HelpStrategyLabel, true);
		helpStrategy = new EENumViewer(parent);
		GridData helpStrategyData = new GridData(GridData.FILL_HORIZONTAL);
		helpStrategy.getCombo().setLayoutData(helpStrategyData);
		helpStrategy.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.helpStrategy, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, getHelpStrategy()));
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, "Defines where the generators have to search the help entries", null); //$NON-NLS-1$
	}

	private void createLegalGroup(FormToolkit widgetFactory, final Composite view) {
		Section legalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		legalSection.setText(EEFGenMessages.GenParametersPropertiesEditionPart_LegalGroupLabel);
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

	private void createAuthorText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenParametersPropertiesEditionPart_AuthorLabel, false);
		author = widgetFactory.createText(parent, "");  //$NON-NLS-1$
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.author, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, author.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.author, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, author.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.author, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, author.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, "The string that must be generated for the @author tag", null); //$NON-NLS-1$
	}

	private void createLicenseTextarea(FormToolkit widgetFactory, Composite parent) {
		Label licenseLabel = FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenParametersPropertiesEditionPart_LicenseLabel, false);
		GridData licenseLabelData = new GridData(GridData.FILL_HORIZONTAL);
		licenseLabelData.horizontalSpan = 3;
		licenseLabel.setLayoutData(licenseLabelData);
		license = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI); //$NON-NLS-1$
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		licenseData.horizontalSpan = 3;
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.license, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, license.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenParametersPropertiesEditionPartForm.this, EEFGenViewsRepository.GenParameters.license, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, license.getText()));
				}
			}
			
		});
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
		
		// Nothing to do
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
	messageManager.addMessage("BasePackage_key", msg, null, msgLevel, basePackage);
}	
	
	public void unsetMessageForBasePackage () {
	messageManager.removeMessage("BasePackage_key", basePackage);
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
	messageManager.addMessage("GenDirectory_key", msg, null, msgLevel, genDirectory);
}	
	
	public void unsetMessageForGenDirectory () {
	messageManager.removeMessage("GenDirectory_key", genDirectory);
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
	messageManager.addMessage("DescriptorsContributorID_key", msg, null, msgLevel, descriptorsContributorID);
}	
	
	public void unsetMessageForDescriptorsContributorID () {
	messageManager.removeMessage("DescriptorsContributorID_key", descriptorsContributorID);
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
	messageManager.addMessage("Author_key", msg, null, msgLevel, author);
}	
	
	public void unsetMessageForAuthor () {
	messageManager.removeMessage("Author_key", author);
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
	messageManager.addMessage("License_key", msg, null, msgLevel, license);
}	
	
	public void unsetMessageForLicense () {
	messageManager.removeMessage("License_key", license);
}	



	
	// Start of user code additional methods
 	
	// End of user code

}	
