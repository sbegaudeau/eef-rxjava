/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart;

import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor;

import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor.SingleCompositionListener;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SingleCompositionEditorSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SingleCompositionEditorSamplePropertiesEditionPart {

	private SingleCompositionEditor singlecompositionviewerRequiredProperty;
	private SingleCompositionEditor singlecompositionviewerOptionalProperty;
	private SingleCompositionEditor singlecompositionviewerROProperty;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SingleCompositionEditorSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence singleCompositionEditorSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = singleCompositionEditorSampleStep.addStep(EefnrViewsRepository.SingleCompositionEditorSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty);
		propertiesStep.addStep(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty);
		propertiesStep.addStep(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty);
		
		
		composer = new PartComposer(singleCompositionEditorSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.SingleCompositionEditorSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty) {
					return createSinglecompositionviewerRequiredPropertySingleCompositionEditor(parent);
				}
				if (key == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty) {
					return createSinglecompositionviewerOptionalPropertySingleCompositionEditor(parent);
				}
				if (key == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty) {
					return createSinglecompositionviewerROPropertySingleCompositionEditor(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EefnrMessages.SingleCompositionEditorSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSinglecompositionviewerRequiredPropertySingleCompositionEditor(Composite parent) {
		createDescription(parent, EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty, EefnrMessages.SingleCompositionEditorSamplePropertiesEditionPart_SinglecompositionviewerRequiredPropertyLabel);
		//create widget
		singlecompositionviewerRequiredProperty = new SingleCompositionEditor(parent, SWT.NONE);
		GridData singlecompositionviewerRequiredPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		singlecompositionviewerRequiredProperty.setLayoutData(singlecompositionviewerRequiredPropertyData);
		singlecompositionviewerRequiredProperty.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SingleCompositionEditorSamplePropertiesEditionPartImpl.this,  EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				singlecompositionviewerRequiredProperty.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SingleCompositionEditorSamplePropertiesEditionPartImpl.this,  EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				singlecompositionviewerRequiredProperty.refresh();
			}
		});
		singlecompositionviewerRequiredProperty.setID(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty, EefnrViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSinglecompositionviewerOptionalPropertySingleCompositionEditor(Composite parent) {
		createDescription(parent, EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty, EefnrMessages.SingleCompositionEditorSamplePropertiesEditionPart_SinglecompositionviewerOptionalPropertyLabel);
		//create widget
		singlecompositionviewerOptionalProperty = new SingleCompositionEditor(parent, SWT.NONE);
		GridData singlecompositionviewerOptionalPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		singlecompositionviewerOptionalProperty.setLayoutData(singlecompositionviewerOptionalPropertyData);
		singlecompositionviewerOptionalProperty.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SingleCompositionEditorSamplePropertiesEditionPartImpl.this,  EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				singlecompositionviewerOptionalProperty.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SingleCompositionEditorSamplePropertiesEditionPartImpl.this,  EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				singlecompositionviewerOptionalProperty.refresh();
			}
		});
		singlecompositionviewerOptionalProperty.setID(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty, EefnrViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSinglecompositionviewerROPropertySingleCompositionEditor(Composite parent) {
		createDescription(parent, EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty, EefnrMessages.SingleCompositionEditorSamplePropertiesEditionPart_SinglecompositionviewerROPropertyLabel);
		//create widget
		singlecompositionviewerROProperty = new SingleCompositionEditor(parent, SWT.NONE);
		GridData singlecompositionviewerROPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		singlecompositionviewerROProperty.setLayoutData(singlecompositionviewerROPropertyData);
		singlecompositionviewerROProperty.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SingleCompositionEditorSamplePropertiesEditionPartImpl.this,  EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				singlecompositionviewerROProperty.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SingleCompositionEditorSamplePropertiesEditionPartImpl.this,  EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				singlecompositionviewerROProperty.refresh();
			}
		});
		singlecompositionviewerROProperty.setID(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty, EefnrViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
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
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#getSinglecompositionviewerRequiredProperty()
	 * 
	 */
	public EObject getSinglecompositionviewerRequiredProperty() {
		return (EObject) singlecompositionviewerRequiredProperty.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#initSinglecompositionviewerRequiredProperty(EObjectFlatComboSettings)
	 */
	public void initSinglecompositionviewerRequiredProperty(EObjectFlatComboSettings settings) {
		singlecompositionviewerRequiredProperty.setAdapterFactory(adapterFactory);
		singlecompositionviewerRequiredProperty.setInput(settings);
		boolean readOnly = isReadOnly(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty);
		if (readOnly && singlecompositionviewerRequiredProperty.isEnabled()) {
			singlecompositionviewerRequiredProperty.setEnabled(false);
			singlecompositionviewerRequiredProperty.setToolTipText(EefnrMessages.SingleCompositionEditorSample_ReadOnly);
		} else if (!readOnly && !singlecompositionviewerRequiredProperty.isEnabled()) {
			singlecompositionviewerRequiredProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#setSinglecompositionviewerRequiredProperty(EObject newValue)
	 * 
	 */
	public void setSinglecompositionviewerRequiredProperty(EObject newValue) {
		singlecompositionviewerRequiredProperty.refresh();
		boolean readOnly = isReadOnly(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty);
		if (readOnly && singlecompositionviewerRequiredProperty.isEnabled()) {
			singlecompositionviewerRequiredProperty.setEnabled(false);
			singlecompositionviewerRequiredProperty.setToolTipText(EefnrMessages.SingleCompositionEditorSample_ReadOnly);
		} else if (!readOnly && !singlecompositionviewerRequiredProperty.isEnabled()) {
			singlecompositionviewerRequiredProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#getSinglecompositionviewerOptionalProperty()
	 * 
	 */
	public EObject getSinglecompositionviewerOptionalProperty() {
		return (EObject) singlecompositionviewerOptionalProperty.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#initSinglecompositionviewerOptionalProperty(EObjectFlatComboSettings)
	 */
	public void initSinglecompositionviewerOptionalProperty(EObjectFlatComboSettings settings) {
		singlecompositionviewerOptionalProperty.setAdapterFactory(adapterFactory);
		singlecompositionviewerOptionalProperty.setInput(settings);
		boolean readOnly = isReadOnly(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty);
		if (readOnly && singlecompositionviewerOptionalProperty.isEnabled()) {
			singlecompositionviewerOptionalProperty.setEnabled(false);
			singlecompositionviewerOptionalProperty.setToolTipText(EefnrMessages.SingleCompositionEditorSample_ReadOnly);
		} else if (!readOnly && !singlecompositionviewerOptionalProperty.isEnabled()) {
			singlecompositionviewerOptionalProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#setSinglecompositionviewerOptionalProperty(EObject newValue)
	 * 
	 */
	public void setSinglecompositionviewerOptionalProperty(EObject newValue) {
		singlecompositionviewerOptionalProperty.refresh();
		boolean readOnly = isReadOnly(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty);
		if (readOnly && singlecompositionviewerOptionalProperty.isEnabled()) {
			singlecompositionviewerOptionalProperty.setEnabled(false);
			singlecompositionviewerOptionalProperty.setToolTipText(EefnrMessages.SingleCompositionEditorSample_ReadOnly);
		} else if (!readOnly && !singlecompositionviewerOptionalProperty.isEnabled()) {
			singlecompositionviewerOptionalProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#getSinglecompositionviewerROProperty()
	 * 
	 */
	public EObject getSinglecompositionviewerROProperty() {
		return (EObject) singlecompositionviewerROProperty.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#initSinglecompositionviewerROProperty(EObjectFlatComboSettings)
	 */
	public void initSinglecompositionviewerROProperty(EObjectFlatComboSettings settings) {
		singlecompositionviewerROProperty.setAdapterFactory(adapterFactory);
		singlecompositionviewerROProperty.setInput(settings);
		singlecompositionviewerROProperty.setEnabled(false);
		singlecompositionviewerROProperty.setToolTipText(EefnrMessages.SingleCompositionEditorSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart#setSinglecompositionviewerROProperty(EObject newValue)
	 * 
	 */
	public void setSinglecompositionviewerROProperty(EObject newValue) {
		singlecompositionviewerROProperty.refresh();
		singlecompositionviewerROProperty.setEnabled(false);
		singlecompositionviewerROProperty.setToolTipText(EefnrMessages.SingleCompositionEditorSample_ReadOnly);
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.SingleCompositionEditorSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
