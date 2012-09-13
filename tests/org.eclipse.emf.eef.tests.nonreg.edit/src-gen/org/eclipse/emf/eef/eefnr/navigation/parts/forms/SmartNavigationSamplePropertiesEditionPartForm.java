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
package org.eclipse.emf.eef.eefnr.navigation.parts.forms;

// Start of user code for imports
import org.eclipse.emf.eef.eefnr.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSamplePropertiesEditionPart;

import org.eclipse.emf.eef.eefnr.navigation.providers.NavigationMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

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
public class SmartNavigationSamplePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SmartNavigationSamplePropertiesEditionPart {

	protected Text name;
	protected Text firstModelNavigationSingleValue;
	protected Text secondModelNavigationSingleValue;
	protected Text firstModelNavigationMultiValue;
	protected Text secondModelNavigationMultiValue;
	protected Text secondModelNavigationSingleValue2;
	protected Text secondModelNavigationMultiValue2;
	protected Text secondModelNavigationMultiValueFilter;



	/**
	 * For {@link ISection} use only.
	 */
	public SmartNavigationSamplePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SmartNavigationSamplePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue) {
					return createFirstModelNavigationSingleValueText(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue) {
					return createSecondModelNavigationSingleValueText(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue) {
					return createFirstModelNavigationMultiValueText(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue) {
					return createSecondModelNavigationMultiValueText(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2) {
					return createSecondModelNavigationSingleValue2Text(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2) {
					return createSecondModelNavigationMultiValue2Text(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter) {
					return createSecondModelNavigationMultiValueFilterText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(NavigationMessages.SmartNavigationSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.name, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, NavigationViewsRepository.SmartNavigationSample.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.name, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFirstModelNavigationSingleValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_FirstModelNavigationSingleValueLabel);
		firstModelNavigationSingleValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		firstModelNavigationSingleValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData firstModelNavigationSingleValueData = new GridData(GridData.FILL_HORIZONTAL);
		firstModelNavigationSingleValue.setLayoutData(firstModelNavigationSingleValueData);
		firstModelNavigationSingleValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationSingleValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, firstModelNavigationSingleValue.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		firstModelNavigationSingleValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationSingleValue.getText()));
				}
			}
		});
		EditingUtils.setID(firstModelNavigationSingleValue, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue);
		EditingUtils.setEEFtype(firstModelNavigationSingleValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationSingleValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationSingleValueLabel);
		secondModelNavigationSingleValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		secondModelNavigationSingleValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData secondModelNavigationSingleValueData = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationSingleValue.setLayoutData(secondModelNavigationSingleValueData);
		secondModelNavigationSingleValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, secondModelNavigationSingleValue.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		secondModelNavigationSingleValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue.getText()));
				}
			}
		});
		EditingUtils.setID(secondModelNavigationSingleValue, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue);
		EditingUtils.setEEFtype(secondModelNavigationSingleValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFirstModelNavigationMultiValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_FirstModelNavigationMultiValueLabel);
		firstModelNavigationMultiValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		firstModelNavigationMultiValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData firstModelNavigationMultiValueData = new GridData(GridData.FILL_HORIZONTAL);
		firstModelNavigationMultiValue.setLayoutData(firstModelNavigationMultiValueData);
		firstModelNavigationMultiValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationMultiValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, firstModelNavigationMultiValue.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		firstModelNavigationMultiValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstModelNavigationMultiValue.getText()));
				}
			}
		});
		EditingUtils.setID(firstModelNavigationMultiValue, NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue);
		EditingUtils.setEEFtype(firstModelNavigationMultiValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationMultiValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationMultiValueLabel);
		secondModelNavigationMultiValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		secondModelNavigationMultiValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData secondModelNavigationMultiValueData = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationMultiValue.setLayoutData(secondModelNavigationMultiValueData);
		secondModelNavigationMultiValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, secondModelNavigationMultiValue.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		secondModelNavigationMultiValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue.getText()));
				}
			}
		});
		EditingUtils.setID(secondModelNavigationMultiValue, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue);
		EditingUtils.setEEFtype(secondModelNavigationMultiValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationSingleValue2Text(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationSingleValue2Label);
		secondModelNavigationSingleValue2 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		secondModelNavigationSingleValue2.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData secondModelNavigationSingleValue2Data = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationSingleValue2.setLayoutData(secondModelNavigationSingleValue2Data);
		secondModelNavigationSingleValue2.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue2.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, secondModelNavigationSingleValue2.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		secondModelNavigationSingleValue2.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationSingleValue2.getText()));
				}
			}
		});
		EditingUtils.setID(secondModelNavigationSingleValue2, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2);
		EditingUtils.setEEFtype(secondModelNavigationSingleValue2, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationMultiValue2Text(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationMultiValue2Label);
		secondModelNavigationMultiValue2 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		secondModelNavigationMultiValue2.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData secondModelNavigationMultiValue2Data = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationMultiValue2.setLayoutData(secondModelNavigationMultiValue2Data);
		secondModelNavigationMultiValue2.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue2.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, secondModelNavigationMultiValue2.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		secondModelNavigationMultiValue2.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValue2.getText()));
				}
			}
		});
		EditingUtils.setID(secondModelNavigationMultiValue2, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2);
		EditingUtils.setEEFtype(secondModelNavigationMultiValue2, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSecondModelNavigationMultiValueFilterText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, NavigationMessages.SmartNavigationSamplePropertiesEditionPart_SecondModelNavigationMultiValueFilterLabel);
		secondModelNavigationMultiValueFilter = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		secondModelNavigationMultiValueFilter.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData secondModelNavigationMultiValueFilterData = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationMultiValueFilter.setLayoutData(secondModelNavigationMultiValueFilterData);
		secondModelNavigationMultiValueFilter.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmartNavigationSamplePropertiesEditionPartForm.this,
							NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValueFilter.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, secondModelNavigationMultiValueFilter.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmartNavigationSamplePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		secondModelNavigationMultiValueFilter.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSamplePropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, secondModelNavigationMultiValueFilter.getText()));
				}
			}
		});
		EditingUtils.setID(secondModelNavigationMultiValueFilter, NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter);
		EditingUtils.setEEFtype(secondModelNavigationMultiValueFilter, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
