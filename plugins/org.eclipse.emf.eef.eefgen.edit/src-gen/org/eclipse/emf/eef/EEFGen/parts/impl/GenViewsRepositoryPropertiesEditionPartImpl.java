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
 * $Id: GenViewsRepositoryPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:49:29 nlepine Exp $
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
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.views.ViewsRepository;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenViewsRepositoryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenViewsRepositoryPropertiesEditionPart {

	protected EObjectFlatComboViewer viewsRepository;
	private Text basePackage;
	private EMFComboViewer helpStrategy;
	private Button swtViews;
	private Button formViews;




	
	public GenViewsRepositoryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createReferenceGroup(view);
		createParametersGroup(view);
		createActivationGroup(view);
		
		// Start of user code for additional ui definition
		
		// End of user code		
	}

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
	 */
	protected void createViewsRepositoryFlatComboViewer(Composite parent) {

		SWTUtils.createPartLabel(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ViewsRepositoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.viewsRepository, EEFGenViewsRepository.SWT_KIND));
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
		viewsRepository.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.viewsRepository, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getViewsRepository()));
			}

		});
		GridData viewsRepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		viewsRepository.setLayoutData(viewsRepositoryData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.viewsRepository, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
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
		createHelpStrategyEEnumViewer(parametersGroup);
	}
	protected void createBasePackageText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_BasePackageLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.basePackage, EEFGenViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenViewsRepositoryPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenViewsRepository.basePackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, basePackage.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.basePackage, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createHelpStrategyEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_HelpStrategyLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenViewsRepository.helpStrategy, EEFGenViewsRepository.SWT_KIND));
		helpStrategy = new EMFComboViewer(parent);
		helpStrategy.setContentProvider(new ArrayContentProvider());
		helpStrategy.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData helpStrategyData = new GridData(GridData.FILL_HORIZONTAL);
		helpStrategy.getCombo().setLayoutData(helpStrategyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.helpStrategy, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createActivationGroup(Composite parent) {
		Group activationGroup = new Group(parent, SWT.NONE);
		activationGroup.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_ActivationGroupLabel);
		GridData activationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		activationGroupData.horizontalSpan = 3;
		activationGroup.setLayoutData(activationGroupData);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createSwtViewsCheckbox(activationGroup);
		createFormViewsCheckbox(activationGroup);
	}
	protected void createSwtViewsCheckbox(Composite parent) {
		swtViews = new Button(parent, SWT.CHECK);
		swtViews.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_SwtViewsLabel);
		GridData swtViewsData = new GridData(GridData.FILL_HORIZONTAL);
		swtViewsData.horizontalSpan = 2;
		swtViews.setLayoutData(swtViewsData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.swtViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createFormViewsCheckbox(Composite parent) {
		formViews = new Button(parent, SWT.CHECK);
		formViews.setText(EEFGenMessages.GenViewsRepositoryPropertiesEditionPart_FormViewsLabel);
		GridData formViewsData = new GridData(GridData.FILL_HORIZONTAL);
		formViewsData.horizontalSpan = 2;
		formViews.setLayoutData(formViewsData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenViewsRepository.formViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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

	public void setMessageForViewsRepository(String msg, int msgLevel) {

	}

	public void unsetMessageForViewsRepository() {

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

	}

	public void unsetMessageForBasePackage() {

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

	public void setMessageForHelpStrategy(String msg, int msgLevel) {

	}

	public void unsetMessageForHelpStrategy() {

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

	public void setMessageForSwtViews(String msg, int msgLevel) {

	}

	public void unsetMessageForSwtViews() {

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

	public void setMessageForFormViews(String msg, int msgLevel) {

	}

	public void unsetMessageForFormViews() {

	}








	// Start of user code additional methods
 	
	// End of user code
}
