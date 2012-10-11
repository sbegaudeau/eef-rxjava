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
package org.eclipse.emf.eef.eefnr.navigation.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.eefnr.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSamplePropertiesEditionPart;

import org.eclipse.emf.eef.eefnr.navigation.providers.NavigationMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SmartNavigationSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SmartNavigationSamplePropertiesEditionPart {

	protected Text name;
	protected Text firstModelNavigationSingleValue;
	protected Text secondModelNavigationSingleValue;
	protected Text firstModelNavigationMultiValue;
	protected Text secondModelNavigationMultiValue;
	protected Text secondModelNavigationSingleValue2;
	protected Text secondModelNavigationMultiValue2;
	protected Text secondModelNavigationMultiValueFilter;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SmartNavigationSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence smartNavigationSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = smartNavigationSampleStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.class);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.name);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2);
		propertiesStep.addStep(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter);
		
		
		composer = new PartComposer(smartNavigationSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.name) {
					return createNameText(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue) {
					return createFirstModelNavigationSingleValueText(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue) {
					return createSecondModelNavigationSingleValueText(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue) {
					return createFirstModelNavigationMultiValueText(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue) {
					return createSecondModelNavigationMultiValueText(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2) {
					return createSecondModelNavigationSingleValue2Text(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2) {
					return createSecondModelNavigationMultiValue2Text(parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter) {
					return createSecondModelNavigationMultiValueFilterText(parent);
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
		propertiesGroup.setText(NavigationMessages.SmartNavigationSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.name, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(name)) {
			name.setEnabled(false);
			name.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, NavigationViewsRepository.SmartNavigationSample.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.name, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFirstModelNavigationSingleValueText(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_FirstModelNavigationSingleValueLabel);
		firstModelNavigationSingleValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(firstModelNavigationSingleValue)) {
			firstModelNavigationSingleValue.setEnabled(false);
			firstModelNavigationSingleValue.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData firstModelNavigationSingleValueData = new GridData(GridData.FILL_HORIZONTAL);
		firstModelNavigationSingleValue.setLayoutData(firstModelNavigationSingleValueData);
		firstModelNavigationSingleValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationSingleValue.getText()));
			}

		});
		firstModelNavigationSingleValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationSingleValue.getText()));
				}
			}

		});
		EditingUtils.setID(firstModelNavigationSingleValue, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue);
		EditingUtils.setEEFtype(firstModelNavigationSingleValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationSingleValueText(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationSingleValueLabel);
		secondModelNavigationSingleValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(secondModelNavigationSingleValue)) {
			secondModelNavigationSingleValue.setEnabled(false);
			secondModelNavigationSingleValue.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData secondModelNavigationSingleValueData = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationSingleValue.setLayoutData(secondModelNavigationSingleValueData);
		secondModelNavigationSingleValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue.getText()));
			}

		});
		secondModelNavigationSingleValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue.getText()));
				}
			}

		});
		EditingUtils.setID(secondModelNavigationSingleValue, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue);
		EditingUtils.setEEFtype(secondModelNavigationSingleValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFirstModelNavigationMultiValueText(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_FirstModelNavigationMultiValueLabel);
		firstModelNavigationMultiValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(firstModelNavigationMultiValue)) {
			firstModelNavigationMultiValue.setEnabled(false);
			firstModelNavigationMultiValue.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData firstModelNavigationMultiValueData = new GridData(GridData.FILL_HORIZONTAL);
		firstModelNavigationMultiValue.setLayoutData(firstModelNavigationMultiValueData);
		firstModelNavigationMultiValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationMultiValue.getText()));
			}

		});
		firstModelNavigationMultiValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationMultiValue.getText()));
				}
			}

		});
		EditingUtils.setID(firstModelNavigationMultiValue, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue);
		EditingUtils.setEEFtype(firstModelNavigationMultiValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationMultiValueText(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationMultiValueLabel);
		secondModelNavigationMultiValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(secondModelNavigationMultiValue)) {
			secondModelNavigationMultiValue.setEnabled(false);
			secondModelNavigationMultiValue.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData secondModelNavigationMultiValueData = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationMultiValue.setLayoutData(secondModelNavigationMultiValueData);
		secondModelNavigationMultiValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue.getText()));
			}

		});
		secondModelNavigationMultiValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue.getText()));
				}
			}

		});
		EditingUtils.setID(secondModelNavigationMultiValue, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue);
		EditingUtils.setEEFtype(secondModelNavigationMultiValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationSingleValue2Text(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationSingleValue2Label);
		secondModelNavigationSingleValue2 = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(secondModelNavigationSingleValue2)) {
			secondModelNavigationSingleValue2.setEnabled(false);
			secondModelNavigationSingleValue2.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData secondModelNavigationSingleValue2Data = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationSingleValue2.setLayoutData(secondModelNavigationSingleValue2Data);
		secondModelNavigationSingleValue2.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue2.getText()));
			}

		});
		secondModelNavigationSingleValue2.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue2.getText()));
				}
			}

		});
		EditingUtils.setID(secondModelNavigationSingleValue2, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2);
		EditingUtils.setEEFtype(secondModelNavigationSingleValue2, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationMultiValue2Text(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationMultiValue2Label);
		secondModelNavigationMultiValue2 = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(secondModelNavigationMultiValue2)) {
			secondModelNavigationMultiValue2.setEnabled(false);
			secondModelNavigationMultiValue2.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData secondModelNavigationMultiValue2Data = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationMultiValue2.setLayoutData(secondModelNavigationMultiValue2Data);
		secondModelNavigationMultiValue2.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue2.getText()));
			}

		});
		secondModelNavigationMultiValue2.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue2.getText()));
				}
			}

		});
		EditingUtils.setID(secondModelNavigationMultiValue2, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2);
		EditingUtils.setEEFtype(secondModelNavigationMultiValue2, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationMultiValueFilterText(Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationMultiValueFilterLabel);
		secondModelNavigationMultiValueFilter = SWTUtils.createScrollableText(parent, SWT.BORDER);
		if (isReadOnly(secondModelNavigationMultiValueFilter)) {
			secondModelNavigationMultiValueFilter.setEnabled(false);
			secondModelNavigationMultiValueFilter.setToolTipText(NavigationMessages.SmartNavigationSample_ReadOnly);
		}		
		
		GridData secondModelNavigationMultiValueFilterData = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationMultiValueFilter.setLayoutData(secondModelNavigationMultiValueFilterData);
		secondModelNavigationMultiValueFilter.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValueFilter.getText()));
			}

		});
		secondModelNavigationMultiValueFilter.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartImpl.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValueFilter.getText()));
				}
			}

		});
		EditingUtils.setID(secondModelNavigationMultiValueFilter, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter);
		EditingUtils.setEEFtype(secondModelNavigationMultiValueFilter, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, NavigationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getFirstModelNavigationSingleValue()
	 * 
	 */
	public String getFirstModelNavigationSingleValue() {
		return firstModelNavigationSingleValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setFirstModelNavigationSingleValue(String newValue)
	 * 
	 */
	public void setFirstModelNavigationSingleValue(String newValue) {
		if (newValue != null) {
			firstModelNavigationSingleValue.setText(newValue);
		} else {
			firstModelNavigationSingleValue.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getSecondModelNavigationSingleValue()
	 * 
	 */
	public String getSecondModelNavigationSingleValue() {
		return secondModelNavigationSingleValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setSecondModelNavigationSingleValue(String newValue)
	 * 
	 */
	public void setSecondModelNavigationSingleValue(String newValue) {
		if (newValue != null) {
			secondModelNavigationSingleValue.setText(newValue);
		} else {
			secondModelNavigationSingleValue.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getFirstModelNavigationMultiValue()
	 * 
	 */
	public String getFirstModelNavigationMultiValue() {
		return firstModelNavigationMultiValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setFirstModelNavigationMultiValue(String newValue)
	 * 
	 */
	public void setFirstModelNavigationMultiValue(String newValue) {
		if (newValue != null) {
			firstModelNavigationMultiValue.setText(newValue);
		} else {
			firstModelNavigationMultiValue.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getSecondModelNavigationMultiValue()
	 * 
	 */
	public String getSecondModelNavigationMultiValue() {
		return secondModelNavigationMultiValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setSecondModelNavigationMultiValue(String newValue)
	 * 
	 */
	public void setSecondModelNavigationMultiValue(String newValue) {
		if (newValue != null) {
			secondModelNavigationMultiValue.setText(newValue);
		} else {
			secondModelNavigationMultiValue.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getSecondModelNavigationSingleValue2()
	 * 
	 */
	public String getSecondModelNavigationSingleValue2() {
		return secondModelNavigationSingleValue2.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setSecondModelNavigationSingleValue2(String newValue)
	 * 
	 */
	public void setSecondModelNavigationSingleValue2(String newValue) {
		if (newValue != null) {
			secondModelNavigationSingleValue2.setText(newValue);
		} else {
			secondModelNavigationSingleValue2.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getSecondModelNavigationMultiValue2()
	 * 
	 */
	public String getSecondModelNavigationMultiValue2() {
		return secondModelNavigationMultiValue2.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setSecondModelNavigationMultiValue2(String newValue)
	 * 
	 */
	public void setSecondModelNavigationMultiValue2(String newValue) {
		if (newValue != null) {
			secondModelNavigationMultiValue2.setText(newValue);
		} else {
			secondModelNavigationMultiValue2.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#getSecondModelNavigationMultiValueFilter()
	 * 
	 */
	public String getSecondModelNavigationMultiValueFilter() {
		return secondModelNavigationMultiValueFilter.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSamplePropertiesEditionPart#setSecondModelNavigationMultiValueFilter(String newValue)
	 * 
	 */
	public void setSecondModelNavigationMultiValueFilter(String newValue) {
		if (newValue != null) {
			secondModelNavigationMultiValueFilter.setText(newValue);
		} else {
			secondModelNavigationMultiValueFilter.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return NavigationMessages.SmartNavigationSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
