/**
 *  Copyright (c) 2008 - 2010 Obeo.
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
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code	

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class GenViewsRepositoryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenViewsRepositoryPropertiesEditionPart {

	protected EObjectFlatComboViewer viewsRepository;
	protected Text basePackage;
	protected EMFComboViewer helpStrategy;
	protected Button sWTViews;
	protected Button formsViews;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public GenViewsRepositoryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
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
	 * 
	 */
	public void createControls(Composite view) { 
		createReferenceGroup(view);

		createParametersGroup(view);

		createActivationGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createReferenceGroup(Composite parent) {
		Group referenceGroup = new Group(parent, SWT.NONE);
		referenceGroup.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		referenceGroupData.horizontalSpan = 3;
		referenceGroup.setLayoutData(referenceGroupData);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createViewsRepositoryFlatComboViewer(referenceGroup);
	}

	/**
	 * @param referenceGroup
	 * 
	 */
	protected void createViewsRepositoryFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ViewsRepositoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.viewsRepository, EEFGenViewsRepository.SWT_KIND));
		viewsRepository = new EObjectFlatComboViewer(parent, false);
		viewsRepository.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		viewsRepository.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.viewsRepository, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getViewsRepository()));
			}

		});
		GridData viewsRepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		viewsRepository.setLayoutData(viewsRepositoryData);
		viewsRepository.setID(EEFGenViewsRepository.GenViewsRepository.viewsRepository);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.viewsRepository, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(parametersGroup);
		createHelpStrategyEMFComboViewer(parametersGroup);
	}

	
	protected void createBasePackageText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_BasePackageLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.basePackage, EEFGenViewsRepository.SWT_KIND));
		basePackage = new Text(parent, SWT.BORDER);
		GridData basePackageData = new GridData(GridData.FILL_HORIZONTAL);
		basePackage.setLayoutData(basePackageData);
		basePackage.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
			}

		});
		basePackage.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
				}
			}

		});
		EditingUtils.setID(basePackage, EEFGenViewsRepository.GenViewsRepository.basePackage);
		EditingUtils.setEEFtype(basePackage, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.basePackage, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createHelpStrategyEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_HelpStrategyLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.helpStrategy, EEFGenViewsRepository.SWT_KIND));
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
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.helpStrategy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getHelpStrategy()));
			}

		});
		helpStrategy.setID(EEFGenViewsRepository.GenViewsRepository.helpStrategy);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.helpStrategy, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createActivationGroup(Composite parent) {
		Group activationGroup = new Group(parent, SWT.NONE);
		activationGroup.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ActivationGroupLabel);
		GridData activationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		activationGroupData.horizontalSpan = 3;
		activationGroup.setLayoutData(activationGroupData);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createSWTViewsCheckbox(activationGroup);
		createFormsViewsCheckbox(activationGroup);
	}

	
	protected void createSWTViewsCheckbox(Composite parent) {
		sWTViews = new Button(parent, SWT.CHECK);
		sWTViews.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_SWTViewsLabel);
		sWTViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.sWTViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(sWTViews.getSelection())));
			}

		});
		GridData sWTViewsData = new GridData(GridData.FILL_HORIZONTAL);
		sWTViewsData.horizontalSpan = 2;
		sWTViews.setLayoutData(sWTViewsData);
		EditingUtils.setID(sWTViews, EEFGenViewsRepository.GenViewsRepository.sWTViews);
		EditingUtils.setEEFtype(sWTViews, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.sWTViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createFormsViewsCheckbox(Composite parent) {
		formsViews = new Button(parent, SWT.CHECK);
		formsViews.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_FormsViewsLabel);
		formsViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.formsViews, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(formsViews.getSelection())));
			}

		});
		GridData formsViewsData = new GridData(GridData.FILL_HORIZONTAL);
		formsViewsData.horizontalSpan = 2;
		formsViews.setLayoutData(formsViewsData);
		EditingUtils.setID(formsViews, EEFGenViewsRepository.GenViewsRepository.formsViews);
		EditingUtils.setEEFtype(formsViews, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.formsViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getViewsRepository()
	 * 
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
		if (current != null) {
			viewsRepository.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setViewsRepository(EObject newValue)
	 * 
	 */
	public void setViewsRepository(EObject newValue) {
		if (newValue != null) {
			viewsRepository.setSelection(new StructuredSelection(newValue));
		} else {
			viewsRepository.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setViewsRepositoryButtonMode(ButtonsModeEnum newValue)
	 */
	public void setViewsRepositoryButtonMode(ButtonsModeEnum newValue) {
		viewsRepository.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#addFilterViewsRepository(ViewerFilter filter)
	 * 
	 */
	public void addFilterToViewsRepository(ViewerFilter filter) {
		viewsRepository.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#addBusinessFilterViewsRepository(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToViewsRepository(ViewerFilter filter) {
		viewsRepository.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getBasePackage()
	 * 
	 */
	public String getBasePackage() {
		return basePackage.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setBasePackage(String newValue)
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
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getHelpStrategy()
	 * 
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
		helpStrategy.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setHelpStrategy(Enumerator newValue)
	 * 
	 */
	public void setHelpStrategy(Enumerator newValue) {
		helpStrategy.modelUpdating(new StructuredSelection(newValue));
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getSWTViews()
	 * 
	 */
	public Boolean getSWTViews() {
		return Boolean.valueOf(sWTViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setSWTViews(Boolean newValue)
	 * 
	 */
	public void setSWTViews(Boolean newValue) {
		if (newValue != null) {
			sWTViews.setSelection(newValue.booleanValue());
		} else {
			sWTViews.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#getFormsViews()
	 * 
	 */
	public Boolean getFormsViews() {
		return Boolean.valueOf(formsViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart#setFormsViews(Boolean newValue)
	 * 
	 */
	public void setFormsViews(Boolean newValue) {
		if (newValue != null) {
			formsViews.setSelection(newValue.booleanValue());
		} else {
			formsViews.setSelection(false);
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EEFGenMessages.GenViewsRepository_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code


}
