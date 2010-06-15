/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class GenEditionContextPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, GenEditionContextPropertiesEditionPart {

	protected EObjectFlatComboViewer propertiesEditionContext;
	protected Text basePackage;
	protected Text descriptorsContributorID;
	protected Button genericPropertiesViewsDescriptors;
	protected Button gMFSpecificPropertiesViews;
	protected Button jUnitTestCases;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public GenEditionContextPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		createReferenceGroup(widgetFactory, view);

		createParametersGroup(widgetFactory, view);

		createActivationGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
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
	 * 
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

	/**
	 * 
	 */
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
		basePackage.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
			}
		});
		basePackage.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
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
		descriptorsContributorID.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
			}
		});
		descriptorsContributorID.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
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
		createGenericPropertiesViewsDescriptorsCheckbox(widgetFactory, activationGroup);
		createGMFSpecificPropertiesViewsCheckbox(widgetFactory, activationGroup);
		createJUnitTestCasesCheckbox(widgetFactory, activationGroup);
		activationSection.setClient(activationGroup);
	}

	
	protected void createGenericPropertiesViewsDescriptorsCheckbox(FormToolkit widgetFactory, Composite parent) {
		genericPropertiesViewsDescriptors = widgetFactory.createButton(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_GenericPropertiesViewsDescriptorsLabel, SWT.CHECK);
		genericPropertiesViewsDescriptors.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.genericPropertiesViewsDescriptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(genericPropertiesViewsDescriptors.getSelection())));
			}

		});
		GridData genericPropertiesViewsDescriptorsData = new GridData(GridData.FILL_HORIZONTAL);
		genericPropertiesViewsDescriptorsData.horizontalSpan = 2;
		genericPropertiesViewsDescriptors.setLayoutData(genericPropertiesViewsDescriptorsData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.genericPropertiesViewsDescriptors, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGMFSpecificPropertiesViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		gMFSpecificPropertiesViews = widgetFactory.createButton(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_GMFSpecificPropertiesViewsLabel, SWT.CHECK);
		gMFSpecificPropertiesViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.gMFSpecificPropertiesViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(gMFSpecificPropertiesViews.getSelection())));
			}

		});
		GridData gMFSpecificPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		gMFSpecificPropertiesViewsData.horizontalSpan = 2;
		gMFSpecificPropertiesViews.setLayoutData(gMFSpecificPropertiesViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.gMFSpecificPropertiesViews, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createJUnitTestCasesCheckbox(FormToolkit widgetFactory, Composite parent) {
		jUnitTestCases = widgetFactory.createButton(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_JUnitTestCasesLabel, SWT.CHECK);
		jUnitTestCases.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartForm.this, EEFGenViewsRepository.GenEditionContext.jUnitTestCases, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(jUnitTestCases.getSelection())));
			}

		});
		GridData jUnitTestCasesData = new GridData(GridData.FILL_HORIZONTAL);
		jUnitTestCasesData.horizontalSpan = 2;
		jUnitTestCases.setLayoutData(jUnitTestCasesData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.jUnitTestCases, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getPropertiesEditionContext()
	 * 
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
		if (current != null) {
			propertiesEditionContext.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setPropertiesEditionContext(EObject newValue)
	 * 
	 */
	public void setPropertiesEditionContext(EObject newValue) {
		if (newValue != null) {
			propertiesEditionContext.setSelection(new StructuredSelection(newValue));
		} else {
			propertiesEditionContext.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setPropertiesEditionContextButtonMode(ButtonsModeEnum newValue)
	 */
	public void setPropertiesEditionContextButtonMode(ButtonsModeEnum newValue) {
		propertiesEditionContext.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#addFilterPropertiesEditionContext(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPropertiesEditionContext(ViewerFilter filter) {
		propertiesEditionContext.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#addBusinessFilterPropertiesEditionContext(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPropertiesEditionContext(ViewerFilter filter) {
		propertiesEditionContext.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getBasePackage()
	 * 
	 */
	public String getBasePackage() {
		return basePackage.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setBasePackage(String newValue)
	 * 
	 */
	public void setBasePackage(String newValue) {
		if (newValue != null) {
			basePackage.setText(newValue);
		} else {
			basePackage.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getDescriptorsContributorID()
	 * 
	 */
	public String getDescriptorsContributorID() {
		return descriptorsContributorID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setDescriptorsContributorID(String newValue)
	 * 
	 */
	public void setDescriptorsContributorID(String newValue) {
		if (newValue != null) {
			descriptorsContributorID.setText(newValue);
		} else {
			descriptorsContributorID.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getGenericPropertiesViewsDescriptors()
	 * 
	 */
	public Boolean getGenericPropertiesViewsDescriptors() {
		return Boolean.valueOf(genericPropertiesViewsDescriptors.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setGenericPropertiesViewsDescriptors(Boolean newValue)
	 * 
	 */
	public void setGenericPropertiesViewsDescriptors(Boolean newValue) {
		if (newValue != null) {
			genericPropertiesViewsDescriptors.setSelection(newValue.booleanValue());
		} else {
			genericPropertiesViewsDescriptors.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getGMFSpecificPropertiesViews()
	 * 
	 */
	public Boolean getGMFSpecificPropertiesViews() {
		return Boolean.valueOf(gMFSpecificPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setGMFSpecificPropertiesViews(Boolean newValue)
	 * 
	 */
	public void setGMFSpecificPropertiesViews(Boolean newValue) {
		if (newValue != null) {
			gMFSpecificPropertiesViews.setSelection(newValue.booleanValue());
		} else {
			gMFSpecificPropertiesViews.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#getJUnitTestCases()
	 * 
	 */
	public Boolean getJUnitTestCases() {
		return Boolean.valueOf(jUnitTestCases.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart#setJUnitTestCases(Boolean newValue)
	 * 
	 */
	public void setJUnitTestCases(Boolean newValue) {
		if (newValue != null) {
			jUnitTestCases.setSelection(newValue.booleanValue());
		} else {
			jUnitTestCases.setSelection(false);
		}
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EEFGenMessages.GenEditionContext_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code


}
