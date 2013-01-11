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
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.eefnr.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart;

import org.eclipse.emf.eef.eefnr.navigation.providers.NavigationMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SmartNavigationSampleOnglet2PropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SmartNavigationSampleOnglet2PropertiesEditionPart {

	protected EObjectFlatComboViewer secondModelNavigationSingleValueOnglet2;



	/**
	 * For {@link ISection} use only.
	 */
	public SmartNavigationSampleOnglet2PropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SmartNavigationSampleOnglet2PropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence smartNavigationSampleOnglet2Step = new BindingCompositionSequence(propertiesEditionComponent);
		smartNavigationSampleOnglet2Step
			.addStep(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.class)
			.addStep(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2);
		
		
		composer = new PartComposer(smartNavigationSampleOnglet2Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2) {
					return createSecondModelNavigationSingleValueOnglet2FlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(NavigationMessages.SmartNavigationSampleOnglet2PropertiesEditionPart_PropertiesGroupLabel);
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

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSecondModelNavigationSingleValueOnglet2FlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2, NavigationMessages.SmartNavigationSampleOnglet2PropertiesEditionPart_SecondModelNavigationSingleValueOnglet2Label);
		secondModelNavigationSingleValueOnglet2 = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2, NavigationViewsRepository.FORM_KIND));
		widgetFactory.adapt(secondModelNavigationSingleValueOnglet2);
		secondModelNavigationSingleValueOnglet2.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData secondModelNavigationSingleValueOnglet2Data = new GridData(GridData.FILL_HORIZONTAL);
		secondModelNavigationSingleValueOnglet2.setLayoutData(secondModelNavigationSingleValueOnglet2Data);
		secondModelNavigationSingleValueOnglet2.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmartNavigationSampleOnglet2PropertiesEditionPartForm.this, NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSecondModelNavigationSingleValueOnglet2()));
			}

		});
		secondModelNavigationSingleValueOnglet2.setID(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecondModelNavigationSingleValueOnglet2FlatComboViewer

		// End of user code
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
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart#getSecondModelNavigationSingleValueOnglet2()
	 * 
	 */
	public EObject getSecondModelNavigationSingleValueOnglet2() {
		if (secondModelNavigationSingleValueOnglet2.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) secondModelNavigationSingleValueOnglet2.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart#initSecondModelNavigationSingleValueOnglet2(EObjectFlatComboSettings)
	 */
	public void initSecondModelNavigationSingleValueOnglet2(EObjectFlatComboSettings settings) {
		secondModelNavigationSingleValueOnglet2.setInput(settings);
		if (current != null) {
			secondModelNavigationSingleValueOnglet2.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2);
		if (eefElementEditorReadOnlyState && secondModelNavigationSingleValueOnglet2.isEnabled()) {
			secondModelNavigationSingleValueOnglet2.setEnabled(false);
			secondModelNavigationSingleValueOnglet2.setToolTipText(NavigationMessages.SmartNavigationSampleOnglet2_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !secondModelNavigationSingleValueOnglet2.isEnabled()) {
			secondModelNavigationSingleValueOnglet2.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart#setSecondModelNavigationSingleValueOnglet2(EObject newValue)
	 * 
	 */
	public void setSecondModelNavigationSingleValueOnglet2(EObject newValue) {
		if (newValue != null) {
			secondModelNavigationSingleValueOnglet2.setSelection(new StructuredSelection(newValue));
		} else {
			secondModelNavigationSingleValueOnglet2.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2);
		if (eefElementEditorReadOnlyState && secondModelNavigationSingleValueOnglet2.isEnabled()) {
			secondModelNavigationSingleValueOnglet2.setEnabled(false);
			secondModelNavigationSingleValueOnglet2.setToolTipText(NavigationMessages.SmartNavigationSampleOnglet2_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !secondModelNavigationSingleValueOnglet2.isEnabled()) {
			secondModelNavigationSingleValueOnglet2.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart#setSecondModelNavigationSingleValueOnglet2ButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSecondModelNavigationSingleValueOnglet2ButtonMode(ButtonsModeEnum newValue) {
		secondModelNavigationSingleValueOnglet2.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart#addFilterSecondModelNavigationSingleValueOnglet2(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSecondModelNavigationSingleValueOnglet2(ViewerFilter filter) {
		secondModelNavigationSingleValueOnglet2.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart#addBusinessFilterSecondModelNavigationSingleValueOnglet2(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSecondModelNavigationSingleValueOnglet2(ViewerFilter filter) {
		secondModelNavigationSingleValueOnglet2.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return NavigationMessages.SmartNavigationSampleOnglet2_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
