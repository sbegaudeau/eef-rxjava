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
 * $Id: GenViewsRepositoryPropertiesEditionPartForm.java,v 1.1 2009/04/30 17:49:28 nlepine Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.views.ViewsRepository;
import org.eclipse.jface.viewers.ArrayContentProvider;
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
public class GenViewsRepositoryPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, GenViewsRepositoryPropertiesEditionPart {

	protected EObjectFlatComboViewer viewsRepository;
	private Text basePackage;
	private EMFComboViewer helpStrategy;
	private Button swtViews;
	private Button formViews;




	
	public GenViewsRepositoryPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		referenceSection.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		referenceSectionData.horizontalSpan = 3;
		referenceSection.setLayoutData(referenceSectionData);
		Composite referenceGroup = widgetFactory.createComposite(referenceSection);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createViewsRepositoryFlatComboViewer(referenceGroup, widgetFactory);
		referenceSection.setClient(referenceGroup);
	}
	/**
	 * @param referenceGroup
	 */
	protected void createViewsRepositoryFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
	
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ViewsRepositoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.viewsRepository, EEFGenViewsRepository.FORM_KIND));
		viewsRepository = new EObjectFlatComboViewer(parent, false);
		viewsRepository.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		// Start of user code for viewsRepository filters initialisation

 		// End of user code
		viewsRepository.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof ViewsRepository); 				
			}

		});

		GridData viewsRepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		viewsRepository.setLayoutData(viewsRepositoryData);
		viewsRepository.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.viewsRepository, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getViewsRepository()));
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.viewsRepository, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createParametersGroup(FormToolkit widgetFactory, final Composite view) {
		Section parametersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		parametersSection.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		parametersSectionData.horizontalSpan = 3;
		parametersSection.setLayoutData(parametersSectionData);
		Composite parametersGroup = widgetFactory.createComposite(parametersSection);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(widgetFactory, parametersGroup);
		createHelpStrategyEEnumViewer(widgetFactory, parametersGroup);
		parametersSection.setClient(parametersGroup);
	}
	protected void createBasePackageText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_BasePackageLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.basePackage, EEFGenViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.basePackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, basePackage.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.basePackage, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createHelpStrategyEEnumViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_HelpStrategyLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.helpStrategy, EEFGenViewsRepository.FORM_KIND));
		helpStrategy = new EMFComboViewer(parent);
		helpStrategy.setContentProvider(new ArrayContentProvider());
		helpStrategy.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.helpStrategy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getHelpStrategy()));
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.helpStrategy, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createActivationGroup(FormToolkit widgetFactory, final Composite view) {
		Section activationSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		activationSection.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ActivationGroupLabel);
		GridData activationSectionData = new GridData(GridData.FILL_HORIZONTAL);
		activationSectionData.horizontalSpan = 3;
		activationSection.setLayoutData(activationSectionData);
		Composite activationGroup = widgetFactory.createComposite(activationSection);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createSwtViewsCheckbox(widgetFactory, activationGroup);
		createFormViewsCheckbox(widgetFactory, activationGroup);
		activationSection.setClient(activationGroup);
	}
	protected void createSwtViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		swtViews = widgetFactory.createButton(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_SwtViewsLabel, SWT.CHECK);
		swtViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.swtViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(swtViews.getSelection())));
			}
			
		});
		GridData swtViewsData = new GridData(GridData.FILL_HORIZONTAL);
		swtViewsData.horizontalSpan = 2;
		swtViews.setLayoutData(swtViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.swtViews, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createFormViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		formViews = widgetFactory.createButton(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_FormViewsLabel, SWT.CHECK);
		formViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartForm.this, EEFGenViewsRepository.GenViewsRepository.formViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(formViews.getSelection())));
			}
			
		});
		GridData formViewsData = new GridData(GridData.FILL_HORIZONTAL);
		formViewsData.horizontalSpan = 2;
		formViews.setLayoutData(formViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.formViews, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getViewsRepository()
	 */
	public EObject getViewsRepository() {
		if (viewsRepository.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) viewsRepository.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#initViewsRepository(ResourceSet allResources, EObject current)
	 */
	public void initViewsRepository(ResourceSet allResources, EObject current) {
		viewsRepository.setInput(allResources);
		if (current != null)
			viewsRepository.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setViewsRepository(EObject newValue)
	 */
	public void setViewsRepository(EObject newValue) {
		if (newValue != null)
			viewsRepository.setSelection(new StructuredSelection(newValue));
		else
			viewsRepository.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getBasePackage()
	 */
	public String getBasePackage() {
		return basePackage.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setBasePackage(String newValue)
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
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getHelpStrategy()
	 */
	public Enumerator getHelpStrategy() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) helpStrategy.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#initHelpStrategy(EEnum eenum, Enumerator current)
	 */
	public void initHelpStrategy(EEnum eenum, Enumerator current) {
		helpStrategy.setInput(eenum.getELiterals());
		helpStrategy.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setHelpStrategy(Enumerator newValue)
	 */
	public void setHelpStrategy(Enumerator newValue) {
		helpStrategy.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getSwtViews()
	 */
	public Boolean getSwtViews() {
		return Boolean.valueOf(swtViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setSwtViews(Boolean newValue)
	 */
	public void setSwtViews(Boolean newValue) {
		if (newValue != null) {
			swtViews.setSelection(newValue.booleanValue());
		} else {
			swtViews.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getFormViews()
	 */
	public Boolean getFormViews() {
		return Boolean.valueOf(formViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setFormViews(Boolean newValue)
	 */
	public void setFormViews(Boolean newValue) {
		if (newValue != null) {
			formViews.setSelection(newValue.booleanValue());
		} else {
			formViews.setSelection(false);
		}
	}











	
	// Start of user code additional methods
 	
	// End of user code
}	
