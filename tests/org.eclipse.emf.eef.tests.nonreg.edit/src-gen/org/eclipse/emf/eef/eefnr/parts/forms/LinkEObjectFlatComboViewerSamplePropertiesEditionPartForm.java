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
package org.eclipse.emf.eef.eefnr.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart;

import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.AbstractAdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.LinkEObjectFlatComboViewer;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

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
public class LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, LinkEObjectFlatComboViewerSamplePropertiesEditionPart {

	protected LinkEObjectFlatComboViewer linkeobjectflatcomboviewerRequiredPropery;
	protected ViewerFilter linkeobjectflatcomboviewerRequiredProperyFilter;
	protected LinkEObjectFlatComboViewer linkeobjectflatcomboviewerOptionalPropery;
	protected ViewerFilter linkeobjectflatcomboviewerOptionalProperyFilter;
	protected LinkEObjectFlatComboViewer linkeobjectflatcomboviewerROPropery;
	protected ViewerFilter linkeobjectflatcomboviewerROProperyFilter;



	/**
	 * For {@link ISection} use only.
	 */
	public LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence linkEObjectFlatComboViewerSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = linkEObjectFlatComboViewerSampleStep.addStep(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery);
		propertiesStep.addStep(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery);
		propertiesStep.addStep(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery);
		
		
		composer = new PartComposer(linkEObjectFlatComboViewerSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery) {
					return createLinkeobjectflatcomboviewerRequiredProperyLinkFlatComboViewer(parent, widgetFactory);
				}
				if (key == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery) {
					return createLinkeobjectflatcomboviewerOptionalProperyLinkFlatComboViewer(parent, widgetFactory);
				}
				if (key == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery) {
					return createLinkeobjectflatcomboviewerROProperyLinkFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createLinkeobjectflatcomboviewerRequiredProperyLinkFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery, EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_LinkeobjectflatcomboviewerRequiredProperyLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getLinkeobjectflatcomboviewerRequiredPropery();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		linkeobjectflatcomboviewerRequiredPropery = new LinkEObjectFlatComboViewer(EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_LinkeobjectflatcomboviewerRequiredProperyLabel, resourceSet, linkeobjectflatcomboviewerRequiredProperyFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		linkeobjectflatcomboviewerRequiredPropery.createControls(parent, widgetFactory);
		GridData linkeobjectflatcomboviewerRequiredProperyData = new GridData(GridData.FILL_HORIZONTAL);
		linkeobjectflatcomboviewerRequiredPropery.setLayoutData(linkeobjectflatcomboviewerRequiredProperyData);
		linkeobjectflatcomboviewerRequiredPropery.setID(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkeobjectflatcomboviewerRequiredProperyLinkFlatComboViewer

		// End of user code
		return parent;
	}


	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createLinkeobjectflatcomboviewerOptionalProperyLinkFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery, EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_LinkeobjectflatcomboviewerOptionalProperyLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getLinkeobjectflatcomboviewerOptionalPropery();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		linkeobjectflatcomboviewerOptionalPropery = new LinkEObjectFlatComboViewer(EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_LinkeobjectflatcomboviewerOptionalProperyLabel, resourceSet, linkeobjectflatcomboviewerOptionalProperyFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		linkeobjectflatcomboviewerOptionalPropery.createControls(parent, widgetFactory);
		GridData linkeobjectflatcomboviewerOptionalProperyData = new GridData(GridData.FILL_HORIZONTAL);
		linkeobjectflatcomboviewerOptionalPropery.setLayoutData(linkeobjectflatcomboviewerOptionalProperyData);
		linkeobjectflatcomboviewerOptionalPropery.setID(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkeobjectflatcomboviewerOptionalProperyLinkFlatComboViewer

		// End of user code
		return parent;
	}


	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createLinkeobjectflatcomboviewerROProperyLinkFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery, EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_LinkeobjectflatcomboviewerROProperyLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getLinkeobjectflatcomboviewerROPropery();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		linkeobjectflatcomboviewerROPropery = new LinkEObjectFlatComboViewer(EefnrMessages.LinkEObjectFlatComboViewerSamplePropertiesEditionPart_LinkeobjectflatcomboviewerROProperyLabel, resourceSet, linkeobjectflatcomboviewerROProperyFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		linkeobjectflatcomboviewerROPropery.createControls(parent, widgetFactory);
		GridData linkeobjectflatcomboviewerROProperyData = new GridData(GridData.FILL_HORIZONTAL);
		linkeobjectflatcomboviewerROPropery.setLayoutData(linkeobjectflatcomboviewerROProperyData);
		linkeobjectflatcomboviewerROPropery.setID(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkeobjectflatcomboviewerROProperyLinkFlatComboViewer

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
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#getLinkeobjectflatcomboviewerRequiredPropery()
	 * 
	 */
	public EObject getLinkeobjectflatcomboviewerRequiredPropery() {
		return linkeobjectflatcomboviewerRequiredPropery.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#initLinkeobjectflatcomboviewerRequiredPropery(EObjectFlatComboSettings)
	 */
	public void initLinkeobjectflatcomboviewerRequiredPropery(EObjectFlatComboSettings settings) {
		linkeobjectflatcomboviewerRequiredPropery.setInput(settings);
		if (current != null) {
			linkeobjectflatcomboviewerRequiredPropery.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery);
		if (eefElementEditorReadOnlyState && linkeobjectflatcomboviewerRequiredPropery.isEnabled()) {
			linkeobjectflatcomboviewerRequiredPropery.setEnabled(false);
			linkeobjectflatcomboviewerRequiredPropery.setToolTipText(EefnrMessages.LinkEObjectFlatComboViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkeobjectflatcomboviewerRequiredPropery.isEnabled()) {
			linkeobjectflatcomboviewerRequiredPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#setLinkeobjectflatcomboviewerRequiredPropery(EObject newValue)
	 * 
	 */
	public void setLinkeobjectflatcomboviewerRequiredPropery(EObject newValue) {
		if (newValue != null) {
			linkeobjectflatcomboviewerRequiredPropery.setSelection(new StructuredSelection(newValue));
		} else {
			linkeobjectflatcomboviewerRequiredPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery);
		if (eefElementEditorReadOnlyState && linkeobjectflatcomboviewerRequiredPropery.isEnabled()) {
			linkeobjectflatcomboviewerRequiredPropery.setEnabled(false);
			linkeobjectflatcomboviewerRequiredPropery.setToolTipText(EefnrMessages.LinkEObjectFlatComboViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkeobjectflatcomboviewerRequiredPropery.isEnabled()) {
			linkeobjectflatcomboviewerRequiredPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#setLinkeobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLinkeobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum newValue) {
		linkeobjectflatcomboviewerRequiredPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#addFilterLinkeobjectflatcomboviewerRequiredPropery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLinkeobjectflatcomboviewerRequiredPropery(ViewerFilter filter) {
		linkeobjectflatcomboviewerRequiredPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#addBusinessFilterLinkeobjectflatcomboviewerRequiredPropery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLinkeobjectflatcomboviewerRequiredPropery(ViewerFilter filter) {
		linkeobjectflatcomboviewerRequiredPropery.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#getLinkeobjectflatcomboviewerOptionalPropery()
	 * 
	 */
	public EObject getLinkeobjectflatcomboviewerOptionalPropery() {
		return linkeobjectflatcomboviewerOptionalPropery.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#initLinkeobjectflatcomboviewerOptionalPropery(EObjectFlatComboSettings)
	 */
	public void initLinkeobjectflatcomboviewerOptionalPropery(EObjectFlatComboSettings settings) {
		linkeobjectflatcomboviewerOptionalPropery.setInput(settings);
		if (current != null) {
			linkeobjectflatcomboviewerOptionalPropery.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery);
		if (eefElementEditorReadOnlyState && linkeobjectflatcomboviewerOptionalPropery.isEnabled()) {
			linkeobjectflatcomboviewerOptionalPropery.setEnabled(false);
			linkeobjectflatcomboviewerOptionalPropery.setToolTipText(EefnrMessages.LinkEObjectFlatComboViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkeobjectflatcomboviewerOptionalPropery.isEnabled()) {
			linkeobjectflatcomboviewerOptionalPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#setLinkeobjectflatcomboviewerOptionalPropery(EObject newValue)
	 * 
	 */
	public void setLinkeobjectflatcomboviewerOptionalPropery(EObject newValue) {
		if (newValue != null) {
			linkeobjectflatcomboviewerOptionalPropery.setSelection(new StructuredSelection(newValue));
		} else {
			linkeobjectflatcomboviewerOptionalPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery);
		if (eefElementEditorReadOnlyState && linkeobjectflatcomboviewerOptionalPropery.isEnabled()) {
			linkeobjectflatcomboviewerOptionalPropery.setEnabled(false);
			linkeobjectflatcomboviewerOptionalPropery.setToolTipText(EefnrMessages.LinkEObjectFlatComboViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkeobjectflatcomboviewerOptionalPropery.isEnabled()) {
			linkeobjectflatcomboviewerOptionalPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#setLinkeobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLinkeobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum newValue) {
		linkeobjectflatcomboviewerOptionalPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#addFilterLinkeobjectflatcomboviewerOptionalPropery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLinkeobjectflatcomboviewerOptionalPropery(ViewerFilter filter) {
		linkeobjectflatcomboviewerOptionalPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#addBusinessFilterLinkeobjectflatcomboviewerOptionalPropery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLinkeobjectflatcomboviewerOptionalPropery(ViewerFilter filter) {
		linkeobjectflatcomboviewerOptionalPropery.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#getLinkeobjectflatcomboviewerROPropery()
	 * 
	 */
	public EObject getLinkeobjectflatcomboviewerROPropery() {
		return linkeobjectflatcomboviewerROPropery.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#initLinkeobjectflatcomboviewerROPropery(EObjectFlatComboSettings)
	 */
	public void initLinkeobjectflatcomboviewerROPropery(EObjectFlatComboSettings settings) {
		linkeobjectflatcomboviewerROPropery.setInput(settings);
		if (current != null) {
			linkeobjectflatcomboviewerROPropery.setSelection(new StructuredSelection(settings.getValue()));
		}
		linkeobjectflatcomboviewerROPropery.setEnabled(false);
		linkeobjectflatcomboviewerROPropery.setToolTipText(EefnrMessages.LinkEObjectFlatComboViewerSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#setLinkeobjectflatcomboviewerROPropery(EObject newValue)
	 * 
	 */
	public void setLinkeobjectflatcomboviewerROPropery(EObject newValue) {
		if (newValue != null) {
			linkeobjectflatcomboviewerROPropery.setSelection(new StructuredSelection(newValue));
		} else {
			linkeobjectflatcomboviewerROPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		linkeobjectflatcomboviewerROPropery.setEnabled(false);
		linkeobjectflatcomboviewerROPropery.setToolTipText(EefnrMessages.LinkEObjectFlatComboViewerSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#setLinkeobjectflatcomboviewerROProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLinkeobjectflatcomboviewerROProperyButtonMode(ButtonsModeEnum newValue) {
		linkeobjectflatcomboviewerROPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#addFilterLinkeobjectflatcomboviewerROPropery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLinkeobjectflatcomboviewerROPropery(ViewerFilter filter) {
		linkeobjectflatcomboviewerROPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart#addBusinessFilterLinkeobjectflatcomboviewerROPropery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLinkeobjectflatcomboviewerROPropery(ViewerFilter filter) {
		linkeobjectflatcomboviewerROPropery.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.LinkEObjectFlatComboViewerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
