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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
public class GenEditionContextPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GenEditionContextPropertiesEditionPart {

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
	public GenEditionContextPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		referenceGroup.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		referenceGroupData.horizontalSpan = 3;
		referenceGroup.setLayoutData(referenceGroupData);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createPropertiesEditionContextFlatComboViewer(referenceGroup);
	}

	/**
	 * @param referenceGroup
	 * 
	 */
	protected void createPropertiesEditionContextFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_PropertiesEditionContextLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, EEFGenViewsRepository.SWT_KIND));
		propertiesEditionContext = new EObjectFlatComboViewer(parent, false);
		propertiesEditionContext.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		propertiesEditionContext.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getPropertiesEditionContext()));
			}

		});
		GridData propertiesEditionContextData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesEditionContext.setLayoutData(propertiesEditionContextData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.propertiesEditionContext, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createBasePackageText(parametersGroup);
		createDescriptorsContributorIDText(parametersGroup);
	}

	
	protected void createBasePackageText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_BasePackageLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.basePackage, EEFGenViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.basePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, basePackage.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.basePackage, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createDescriptorsContributorIDText(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.GenEditionContextPropertiesEditionPart_DescriptorsContributorIDLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.SWT_KIND));
		descriptorsContributorID = new Text(parent, SWT.BORDER);
		GridData descriptorsContributorIDData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsContributorID.setLayoutData(descriptorsContributorIDData);
		descriptorsContributorID.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
			}

		});
		descriptorsContributorID.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GenEditionContextPropertiesEditionPartImpl.this, EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, descriptorsContributorID.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.descriptorsContributorID, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createActivationGroup(Composite parent) {
		Group activationGroup = new Group(parent, SWT.NONE);
		activationGroup.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_ActivationGroupLabel);
		GridData activationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		activationGroupData.horizontalSpan = 3;
		activationGroup.setLayoutData(activationGroupData);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createGenericPropertiesViewsDescriptorsCheckbox(activationGroup);
		createGMFSpecificPropertiesViewsCheckbox(activationGroup);
		createJUnitTestCasesCheckbox(activationGroup);
	}

	
	protected void createGenericPropertiesViewsDescriptorsCheckbox(Composite parent) {
		genericPropertiesViewsDescriptors = new Button(parent, SWT.CHECK);
		genericPropertiesViewsDescriptors.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_GenericPropertiesViewsDescriptorsLabel);
		GridData genericPropertiesViewsDescriptorsData = new GridData(GridData.FILL_HORIZONTAL);
		genericPropertiesViewsDescriptorsData.horizontalSpan = 2;
		genericPropertiesViewsDescriptors.setLayoutData(genericPropertiesViewsDescriptorsData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.genericPropertiesViewsDescriptors, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGMFSpecificPropertiesViewsCheckbox(Composite parent) {
		gMFSpecificPropertiesViews = new Button(parent, SWT.CHECK);
		gMFSpecificPropertiesViews.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_GMFSpecificPropertiesViewsLabel);
		GridData gMFSpecificPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		gMFSpecificPropertiesViewsData.horizontalSpan = 2;
		gMFSpecificPropertiesViews.setLayoutData(gMFSpecificPropertiesViewsData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.gMFSpecificPropertiesViews, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createJUnitTestCasesCheckbox(Composite parent) {
		jUnitTestCases = new Button(parent, SWT.CHECK);
		jUnitTestCases.setText(EEFGenMessages.GenEditionContextPropertiesEditionPart_JUnitTestCasesLabel);
		GridData jUnitTestCasesData = new GridData(GridData.FILL_HORIZONTAL);
		jUnitTestCasesData.horizontalSpan = 2;
		jUnitTestCases.setLayoutData(jUnitTestCasesData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.GenEditionContext.jUnitTestCases, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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

	public void setMessageForPropertiesEditionContext(String msg, int msgLevel) {

	}

	public void unsetMessageForPropertiesEditionContext() {

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

	public void setMessageForBasePackage(String msg, int msgLevel) {

	}

	public void unsetMessageForBasePackage() {

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

	public void setMessageForDescriptorsContributorID(String msg, int msgLevel) {

	}

	public void unsetMessageForDescriptorsContributorID() {

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

	public void setMessageForGenericPropertiesViewsDescriptors(String msg, int msgLevel) {

	}

	public void unsetMessageForGenericPropertiesViewsDescriptors() {

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

	public void setMessageForGMFSpecificPropertiesViews(String msg, int msgLevel) {

	}

	public void unsetMessageForGMFSpecificPropertiesViews() {

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

	public void setMessageForJUnitTestCases(String msg, int msgLevel) {

	}

	public void unsetMessageForJUnitTestCases() {

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
