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
import org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart;

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
import org.eclipse.emf.eef.runtime.ui.widgets.LinkEReferenceViewer;

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
public class LinkEReferenceViewerSamplePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, LinkEReferenceViewerSamplePropertiesEditionPart {

	protected LinkEReferenceViewer linkereferenceviewerRequiredPropery;
	protected ViewerFilter linkereferenceviewerRequiredProperyFilter;
	protected LinkEReferenceViewer linkereferenceviewerOptionalPropery;
	protected ViewerFilter linkereferenceviewerOptionalProperyFilter;
	protected LinkEReferenceViewer linkereferenceviewerROPropery;
	protected ViewerFilter linkereferenceviewerROProperyFilter;



	/**
	 * For {@link ISection} use only.
	 */
	public LinkEReferenceViewerSamplePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LinkEReferenceViewerSamplePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence linkEReferenceViewerSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = linkEReferenceViewerSampleStep.addStep(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery);
		propertiesStep.addStep(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery);
		propertiesStep.addStep(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery);
		
		
		composer = new PartComposer(linkEReferenceViewerSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery) {
					return createLinkereferenceviewerRequiredProperyLinkEReferenceViewer(parent, widgetFactory);
				}
				if (key == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery) {
					return createLinkereferenceviewerOptionalProperyLinkEReferenceViewer(parent, widgetFactory);
				}
				if (key == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery) {
					return createLinkereferenceviewerROProperyLinkEReferenceViewer(parent, widgetFactory);
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
		propertiesSection.setText(EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createLinkereferenceviewerRequiredProperyLinkEReferenceViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery, EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_LinkereferenceviewerRequiredProperyLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getLinkereferenceviewerRequiredPropery();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		linkereferenceviewerRequiredPropery = new LinkEReferenceViewer(EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_LinkereferenceviewerRequiredProperyLabel, resourceSet, linkereferenceviewerRequiredProperyFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		linkereferenceviewerRequiredPropery.createControls(parent, widgetFactory);
		GridData linkereferenceviewerRequiredProperyData = new GridData(GridData.FILL_HORIZONTAL);
		linkereferenceviewerRequiredPropery.setLayoutData(linkereferenceviewerRequiredProperyData);
		linkereferenceviewerRequiredPropery.setID(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkereferenceviewerRequiredProperyLinkEReferenceViewer

		// End of user code
		return parent;
	}


	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createLinkereferenceviewerOptionalProperyLinkEReferenceViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery, EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_LinkereferenceviewerOptionalProperyLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getLinkereferenceviewerOptionalPropery();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		linkereferenceviewerOptionalPropery = new LinkEReferenceViewer(EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_LinkereferenceviewerOptionalProperyLabel, resourceSet, linkereferenceviewerOptionalProperyFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		linkereferenceviewerOptionalPropery.createControls(parent, widgetFactory);
		GridData linkereferenceviewerOptionalProperyData = new GridData(GridData.FILL_HORIZONTAL);
		linkereferenceviewerOptionalPropery.setLayoutData(linkereferenceviewerOptionalProperyData);
		linkereferenceviewerOptionalPropery.setID(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkereferenceviewerOptionalProperyLinkEReferenceViewer

		// End of user code
		return parent;
	}


	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createLinkereferenceviewerROProperyLinkEReferenceViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery, EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_LinkereferenceviewerROProperyLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getLinkereferenceviewerROPropery();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LinkEReferenceViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		linkereferenceviewerROPropery = new LinkEReferenceViewer(EefnrMessages.LinkEReferenceViewerSamplePropertiesEditionPart_LinkereferenceviewerROProperyLabel, resourceSet, linkereferenceviewerROProperyFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		linkereferenceviewerROPropery.createControls(parent, widgetFactory);
		GridData linkereferenceviewerROProperyData = new GridData(GridData.FILL_HORIZONTAL);
		linkereferenceviewerROPropery.setLayoutData(linkereferenceviewerROProperyData);
		linkereferenceviewerROPropery.setID(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkereferenceviewerROProperyLinkEReferenceViewer

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
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#getLinkereferenceviewerRequiredPropery()
	 * 
	 */
	public EObject getLinkereferenceviewerRequiredPropery() {
		return linkereferenceviewerRequiredPropery.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#initLinkereferenceviewerRequiredPropery(EObjectFlatComboSettings)
	 */
	public void initLinkereferenceviewerRequiredPropery(EObjectFlatComboSettings settings) {
		linkereferenceviewerRequiredPropery.setInput(settings);
		if (current != null) {
			linkereferenceviewerRequiredPropery.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery);
		if (eefElementEditorReadOnlyState && linkereferenceviewerRequiredPropery.isEnabled()) {
			linkereferenceviewerRequiredPropery.setEnabled(false);
			linkereferenceviewerRequiredPropery.setToolTipText(EefnrMessages.LinkEReferenceViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkereferenceviewerRequiredPropery.isEnabled()) {
			linkereferenceviewerRequiredPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#setLinkereferenceviewerRequiredPropery(EObject newValue)
	 * 
	 */
	public void setLinkereferenceviewerRequiredPropery(EObject newValue) {
		if (newValue != null) {
			linkereferenceviewerRequiredPropery.setSelection(new StructuredSelection(newValue));
		} else {
			linkereferenceviewerRequiredPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery);
		if (eefElementEditorReadOnlyState && linkereferenceviewerRequiredPropery.isEnabled()) {
			linkereferenceviewerRequiredPropery.setEnabled(false);
			linkereferenceviewerRequiredPropery.setToolTipText(EefnrMessages.LinkEReferenceViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkereferenceviewerRequiredPropery.isEnabled()) {
			linkereferenceviewerRequiredPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#setLinkereferenceviewerRequiredProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLinkereferenceviewerRequiredProperyButtonMode(ButtonsModeEnum newValue) {
		linkereferenceviewerRequiredPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#addFilterLinkereferenceviewerRequiredPropery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLinkereferenceviewerRequiredPropery(ViewerFilter filter) {
		linkereferenceviewerRequiredPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#addBusinessFilterLinkereferenceviewerRequiredPropery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLinkereferenceviewerRequiredPropery(ViewerFilter filter) {
		linkereferenceviewerRequiredPropery.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#getLinkereferenceviewerOptionalPropery()
	 * 
	 */
	public EObject getLinkereferenceviewerOptionalPropery() {
		return linkereferenceviewerOptionalPropery.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#initLinkereferenceviewerOptionalPropery(EObjectFlatComboSettings)
	 */
	public void initLinkereferenceviewerOptionalPropery(EObjectFlatComboSettings settings) {
		linkereferenceviewerOptionalPropery.setInput(settings);
		if (current != null) {
			linkereferenceviewerOptionalPropery.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery);
		if (eefElementEditorReadOnlyState && linkereferenceviewerOptionalPropery.isEnabled()) {
			linkereferenceviewerOptionalPropery.setEnabled(false);
			linkereferenceviewerOptionalPropery.setToolTipText(EefnrMessages.LinkEReferenceViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkereferenceviewerOptionalPropery.isEnabled()) {
			linkereferenceviewerOptionalPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#setLinkereferenceviewerOptionalPropery(EObject newValue)
	 * 
	 */
	public void setLinkereferenceviewerOptionalPropery(EObject newValue) {
		if (newValue != null) {
			linkereferenceviewerOptionalPropery.setSelection(new StructuredSelection(newValue));
		} else {
			linkereferenceviewerOptionalPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery);
		if (eefElementEditorReadOnlyState && linkereferenceviewerOptionalPropery.isEnabled()) {
			linkereferenceviewerOptionalPropery.setEnabled(false);
			linkereferenceviewerOptionalPropery.setToolTipText(EefnrMessages.LinkEReferenceViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkereferenceviewerOptionalPropery.isEnabled()) {
			linkereferenceviewerOptionalPropery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#setLinkereferenceviewerOptionalProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLinkereferenceviewerOptionalProperyButtonMode(ButtonsModeEnum newValue) {
		linkereferenceviewerOptionalPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#addFilterLinkereferenceviewerOptionalPropery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLinkereferenceviewerOptionalPropery(ViewerFilter filter) {
		linkereferenceviewerOptionalPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#addBusinessFilterLinkereferenceviewerOptionalPropery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLinkereferenceviewerOptionalPropery(ViewerFilter filter) {
		linkereferenceviewerOptionalPropery.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#getLinkereferenceviewerROPropery()
	 * 
	 */
	public EObject getLinkereferenceviewerROPropery() {
		return linkereferenceviewerROPropery.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#initLinkereferenceviewerROPropery(EObjectFlatComboSettings)
	 */
	public void initLinkereferenceviewerROPropery(EObjectFlatComboSettings settings) {
		linkereferenceviewerROPropery.setInput(settings);
		if (current != null) {
			linkereferenceviewerROPropery.setSelection(new StructuredSelection(settings.getValue()));
		}
		linkereferenceviewerROPropery.setEnabled(false);
		linkereferenceviewerROPropery.setToolTipText(EefnrMessages.LinkEReferenceViewerSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#setLinkereferenceviewerROPropery(EObject newValue)
	 * 
	 */
	public void setLinkereferenceviewerROPropery(EObject newValue) {
		if (newValue != null) {
			linkereferenceviewerROPropery.setSelection(new StructuredSelection(newValue));
		} else {
			linkereferenceviewerROPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		linkereferenceviewerROPropery.setEnabled(false);
		linkereferenceviewerROPropery.setToolTipText(EefnrMessages.LinkEReferenceViewerSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#setLinkereferenceviewerROProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLinkereferenceviewerROProperyButtonMode(ButtonsModeEnum newValue) {
		linkereferenceviewerROPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#addFilterLinkereferenceviewerROPropery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLinkereferenceviewerROPropery(ViewerFilter filter) {
		linkereferenceviewerROPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart#addBusinessFilterLinkereferenceviewerROPropery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLinkereferenceviewerROPropery(ViewerFilter filter) {
		linkereferenceviewerROPropery.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.LinkEReferenceViewerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
