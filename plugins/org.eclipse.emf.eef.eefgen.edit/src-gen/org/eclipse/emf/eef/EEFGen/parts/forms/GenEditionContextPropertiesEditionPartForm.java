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
 * $Id: GenEditionContextPropertiesEditionPartForm.java,v 1.5 2009/05/19 14:25:47 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
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
public class GenEditionContextPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, GenEditionContextPropertiesEditionPart {

	protected EObjectFlatComboViewer propertiesEditionContext;
	private Text basePackage;
	private Text descriptorsContributorID;
	private Button descriptorsGenericPropertiesViews;
	private Button gmfPropertiesViews;




	
	public GenEditionContextPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createReferenceGroup(widgetFactory, view);
		createParametersGroup(widgetFactory, view);
		createActivationGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createReferenceGroup(FormToolkit widgetFactory, final Composite view) {
		Section referenceSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		referenceSection.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		referenceSectionData.horizontalSpan = 3;
		referenceSection.setLayoutData(referenceSectionData);
		Composite referenceGroup = widgetFactory.createComposite(referenceSection);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createPropertiesEditionContextFlatComboViewer(referenceGroup, widgetFactory);
		referenceSection.setClient(referenceGroup);
	}
	/**
	 * @param referenceGroup
	 */
	protected void createPropertiesEditionContextFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
	
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_PropertiesEditionContextLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, EEFGenViewsRepository.FORM_KIND));
		propertiesEditionContext = new EObjectFlatComboViewer(parent, false);
		propertiesEditionContext.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		GridData propertiesEditionContextData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesEditionContext.setLayoutData(propertiesEditionContextData);
		propertiesEditionContext.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertiesEditionContext()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createParametersGroup(FormToolkit widgetFactory, final Composite view) {
		Section parametersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		parametersSection.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		parametersSectionData.horizontalSpan = 3;
		parametersSection.setLayoutData(parametersSectionData);
		Composite parametersGroup = widgetFactory.createComposite(parametersSection);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(widgetFactory, parametersGroup);
		createDescriptorsContributorIDText(widgetFactory, parametersGroup);
		parametersSection.setClient(parametersGroup);
	}
	protected void createBasePackageText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_BasePackageLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.basePackage, EEFGenViewsRepository.FORM_KIND));
		basePackage = widgetFactory.createText(parent, ""); //$NON-NLS-1$
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, basePackage.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.basePackage, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createDescriptorsContributorIDText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_DescriptorsContributorIDLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.FORM_KIND));
		descriptorsContributorID = widgetFactory.createText(parent, ""); //$NON-NLS-1$
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createActivationGroup(FormToolkit widgetFactory, final Composite view) {
		Section activationSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		activationSection.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ActivationGroupLabel);
		GridData activationSectionData = new GridData(GridData.FILL_HORIZONTAL);
		activationSectionData.horizontalSpan = 3;
		activationSection.setLayoutData(activationSectionData);
		Composite activationGroup = widgetFactory.createComposite(activationSection);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createDescriptorsGenericPropertiesViewsCheckbox(widgetFactory, activationGroup);
		createGmfPropertiesViewsCheckbox(widgetFactory, activationGroup);
		activationSection.setClient(activationGroup);
	}
	protected void createDescriptorsGenericPropertiesViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		descriptorsGenericPropertiesViews = widgetFactory.createButton(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_DescriptorsGenericPropertiesViewsLabel, SWT.CHECK);
		descriptorsGenericPropertiesViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.descriptorsGenericPropertiesViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(descriptorsGenericPropertiesViews.getSelection())));
			}
			
		});
		GridData descriptorsGenericPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsGenericPropertiesViewsData.horizontalSpan = 2;
		descriptorsGenericPropertiesViews.setLayoutData(descriptorsGenericPropertiesViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.descriptorsGenericPropertiesViews, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createGmfPropertiesViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		gmfPropertiesViews = widgetFactory.createButton(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_GmfPropertiesViewsLabel, SWT.CHECK);
		gmfPropertiesViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.gmfPropertiesViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(gmfPropertiesViews.getSelection())));
			}
			
		});
		GridData gmfPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		gmfPropertiesViewsData.horizontalSpan = 2;
		gmfPropertiesViews.setLayoutData(gmfPropertiesViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.gmfPropertiesViews, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#addFilterPropertiesEditionContext(ViewerFilter filter)
	 */
	public void addFilterToPropertiesEditionContext(ViewerFilter filter) {
		propertiesEditionContext.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#addBusinessFilterPropertiesEditionContext(ViewerFilter filter)
	 */
	public void addBusinessFilterToPropertiesEditionContext(ViewerFilter filter) {
		propertiesEditionContext.addBusinessRuleFilter(filter);
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
		messageManager.addMessage("BasePackage_key", msg, null, msgLevel, basePackage);
	}

	public void unsetMessageForBasePackage() {
		messageManager.removeMessage("BasePackage_key", basePackage);
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
		messageManager.addMessage("DescriptorsContributorID_key", msg, null, msgLevel, descriptorsContributorID);
	}

	public void unsetMessageForDescriptorsContributorID() {
		messageManager.removeMessage("DescriptorsContributorID_key", descriptorsContributorID);
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











	
	// Start of user code additional methods
 	
	// End of user code
}	
