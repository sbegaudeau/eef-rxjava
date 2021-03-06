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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;

import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
public class AdvancedReferencesTableSamplePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AdvancedReferencesTableSamplePropertiesEditionPart {

	protected ReferencesTable advancedreferencestableRequiredProperty;
	protected List<ViewerFilter> advancedreferencestableRequiredPropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedreferencestableRequiredPropertyFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable advancedreferencestableOptionalProperty;
	protected List<ViewerFilter> advancedreferencestableOptionalPropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedreferencestableOptionalPropertyFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable advancedreferencestableROProperty;
	protected List<ViewerFilter> advancedreferencestableROPropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedreferencestableROPropertyFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public AdvancedReferencesTableSamplePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AdvancedReferencesTableSamplePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence advancedReferencesTableSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = advancedReferencesTableSampleStep.addStep(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty);
		propertiesStep.addStep(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty);
		propertiesStep.addStep(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty);
		
		
		composer = new PartComposer(advancedReferencesTableSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.AdvancedReferencesTableSample.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty) {
					return createAdvancedreferencestableRequiredPropertyReferencesTable(widgetFactory, parent);
				}
				if (key == EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty) {
					return createAdvancedreferencestableOptionalPropertyReferencesTable(widgetFactory, parent);
				}
				if (key == EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty) {
					return createAdvancedreferencestableROPropertyReferencesTable(widgetFactory, parent);
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
		propertiesSection.setText(EefnrMessages.AdvancedReferencesTableSamplePropertiesEditionPart_PropertiesGroupLabel);
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
	 * 
	 */
	protected Composite createAdvancedreferencestableRequiredPropertyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.advancedreferencestableRequiredProperty = new ReferencesTable(getDescription(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty, EefnrMessages.AdvancedReferencesTableSamplePropertiesEditionPart_AdvancedreferencestableRequiredPropertyLabel), new ReferencesTableListener	() {
			public void handleAdd() { addAdvancedreferencestableRequiredProperty(); }
			public void handleEdit(EObject element) { editAdvancedreferencestableRequiredProperty(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAdvancedreferencestableRequiredProperty(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAdvancedreferencestableRequiredProperty(element); }
			public void navigateTo(EObject element) { }
		});
		this.advancedreferencestableRequiredProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty, EefnrViewsRepository.FORM_KIND));
		this.advancedreferencestableRequiredProperty.createControls(parent, widgetFactory);
		this.advancedreferencestableRequiredProperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData advancedreferencestableRequiredPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		advancedreferencestableRequiredPropertyData.horizontalSpan = 3;
		this.advancedreferencestableRequiredProperty.setLayoutData(advancedreferencestableRequiredPropertyData);
		this.advancedreferencestableRequiredProperty.disableMove();
		advancedreferencestableRequiredProperty.setID(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty);
		advancedreferencestableRequiredProperty.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createAdvancedreferencestableRequiredPropertyReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addAdvancedreferencestableRequiredProperty() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(advancedreferencestableRequiredProperty.getInput(), advancedreferencestableRequiredPropertyFilters, advancedreferencestableRequiredPropertyBusinessFilters,
		"advancedreferencestableRequiredProperty", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				advancedreferencestableRequiredProperty.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAdvancedreferencestableRequiredProperty(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		advancedreferencestableRequiredProperty.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedreferencestableRequiredProperty(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		advancedreferencestableRequiredProperty.refresh();
	}

	/**
	 * 
	 */
	protected void editAdvancedreferencestableRequiredProperty(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				advancedreferencestableRequiredProperty.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createAdvancedreferencestableOptionalPropertyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.advancedreferencestableOptionalProperty = new ReferencesTable(getDescription(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty, EefnrMessages.AdvancedReferencesTableSamplePropertiesEditionPart_AdvancedreferencestableOptionalPropertyLabel), new ReferencesTableListener	() {
			public void handleAdd() { addAdvancedreferencestableOptionalProperty(); }
			public void handleEdit(EObject element) { editAdvancedreferencestableOptionalProperty(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAdvancedreferencestableOptionalProperty(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAdvancedreferencestableOptionalProperty(element); }
			public void navigateTo(EObject element) { }
		});
		this.advancedreferencestableOptionalProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty, EefnrViewsRepository.FORM_KIND));
		this.advancedreferencestableOptionalProperty.createControls(parent, widgetFactory);
		this.advancedreferencestableOptionalProperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData advancedreferencestableOptionalPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		advancedreferencestableOptionalPropertyData.horizontalSpan = 3;
		this.advancedreferencestableOptionalProperty.setLayoutData(advancedreferencestableOptionalPropertyData);
		this.advancedreferencestableOptionalProperty.disableMove();
		advancedreferencestableOptionalProperty.setID(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty);
		advancedreferencestableOptionalProperty.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createAdvancedreferencestableOptionalPropertyReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addAdvancedreferencestableOptionalProperty() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(advancedreferencestableOptionalProperty.getInput(), advancedreferencestableOptionalPropertyFilters, advancedreferencestableOptionalPropertyBusinessFilters,
		"advancedreferencestableOptionalProperty", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				advancedreferencestableOptionalProperty.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAdvancedreferencestableOptionalProperty(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		advancedreferencestableOptionalProperty.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedreferencestableOptionalProperty(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		advancedreferencestableOptionalProperty.refresh();
	}

	/**
	 * 
	 */
	protected void editAdvancedreferencestableOptionalProperty(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				advancedreferencestableOptionalProperty.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createAdvancedreferencestableROPropertyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.advancedreferencestableROProperty = new ReferencesTable(getDescription(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty, EefnrMessages.AdvancedReferencesTableSamplePropertiesEditionPart_AdvancedreferencestableROPropertyLabel), new ReferencesTableListener	() {
			public void handleAdd() { addAdvancedreferencestableROProperty(); }
			public void handleEdit(EObject element) { editAdvancedreferencestableROProperty(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAdvancedreferencestableROProperty(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAdvancedreferencestableROProperty(element); }
			public void navigateTo(EObject element) { }
		});
		this.advancedreferencestableROProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty, EefnrViewsRepository.FORM_KIND));
		this.advancedreferencestableROProperty.createControls(parent, widgetFactory);
		this.advancedreferencestableROProperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData advancedreferencestableROPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		advancedreferencestableROPropertyData.horizontalSpan = 3;
		this.advancedreferencestableROProperty.setLayoutData(advancedreferencestableROPropertyData);
		this.advancedreferencestableROProperty.disableMove();
		advancedreferencestableROProperty.setID(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty);
		advancedreferencestableROProperty.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createAdvancedreferencestableROPropertyReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addAdvancedreferencestableROProperty() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(advancedreferencestableROProperty.getInput(), advancedreferencestableROPropertyFilters, advancedreferencestableROPropertyBusinessFilters,
		"advancedreferencestableROProperty", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				advancedreferencestableROProperty.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAdvancedreferencestableROProperty(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		advancedreferencestableROProperty.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedreferencestableROProperty(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTableSamplePropertiesEditionPartForm.this, EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		advancedreferencestableROProperty.refresh();
	}

	/**
	 * 
	 */
	protected void editAdvancedreferencestableROProperty(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				advancedreferencestableROProperty.refresh();
			}
		}
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
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#initAdvancedreferencestableRequiredProperty(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAdvancedreferencestableRequiredProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		advancedreferencestableRequiredProperty.setContentProvider(contentProvider);
		advancedreferencestableRequiredProperty.setInput(settings);
		advancedreferencestableRequiredPropertyBusinessFilters.clear();
		advancedreferencestableRequiredPropertyFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableRequiredProperty);
		if (eefElementEditorReadOnlyState && advancedreferencestableRequiredProperty.getTable().isEnabled()) {
			advancedreferencestableRequiredProperty.setEnabled(false);
			advancedreferencestableRequiredProperty.setToolTipText(EefnrMessages.AdvancedReferencesTableSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !advancedreferencestableRequiredProperty.getTable().isEnabled()) {
			advancedreferencestableRequiredProperty.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#updateAdvancedreferencestableRequiredProperty()
	 * 
	 */
	public void updateAdvancedreferencestableRequiredProperty() {
	advancedreferencestableRequiredProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#addFilterAdvancedreferencestableRequiredProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAdvancedreferencestableRequiredProperty(ViewerFilter filter) {
		advancedreferencestableRequiredPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#addBusinessFilterAdvancedreferencestableRequiredProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAdvancedreferencestableRequiredProperty(ViewerFilter filter) {
		advancedreferencestableRequiredPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#isContainedInAdvancedreferencestableRequiredPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInAdvancedreferencestableRequiredPropertyTable(EObject element) {
		return ((ReferencesTableSettings)advancedreferencestableRequiredProperty.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#initAdvancedreferencestableOptionalProperty(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAdvancedreferencestableOptionalProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		advancedreferencestableOptionalProperty.setContentProvider(contentProvider);
		advancedreferencestableOptionalProperty.setInput(settings);
		advancedreferencestableOptionalPropertyBusinessFilters.clear();
		advancedreferencestableOptionalPropertyFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.AdvancedReferencesTableSample.Properties.advancedreferencestableOptionalProperty);
		if (eefElementEditorReadOnlyState && advancedreferencestableOptionalProperty.getTable().isEnabled()) {
			advancedreferencestableOptionalProperty.setEnabled(false);
			advancedreferencestableOptionalProperty.setToolTipText(EefnrMessages.AdvancedReferencesTableSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !advancedreferencestableOptionalProperty.getTable().isEnabled()) {
			advancedreferencestableOptionalProperty.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#updateAdvancedreferencestableOptionalProperty()
	 * 
	 */
	public void updateAdvancedreferencestableOptionalProperty() {
	advancedreferencestableOptionalProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#addFilterAdvancedreferencestableOptionalProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAdvancedreferencestableOptionalProperty(ViewerFilter filter) {
		advancedreferencestableOptionalPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#addBusinessFilterAdvancedreferencestableOptionalProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAdvancedreferencestableOptionalProperty(ViewerFilter filter) {
		advancedreferencestableOptionalPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#isContainedInAdvancedreferencestableOptionalPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInAdvancedreferencestableOptionalPropertyTable(EObject element) {
		return ((ReferencesTableSettings)advancedreferencestableOptionalProperty.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#initAdvancedreferencestableROProperty(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAdvancedreferencestableROProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		advancedreferencestableROProperty.setContentProvider(contentProvider);
		advancedreferencestableROProperty.setInput(settings);
		advancedreferencestableROPropertyBusinessFilters.clear();
		advancedreferencestableROPropertyFilters.clear();
		advancedreferencestableROProperty.setEnabled(false);
		advancedreferencestableROProperty.setToolTipText(EefnrMessages.AdvancedReferencesTableSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#updateAdvancedreferencestableROProperty()
	 * 
	 */
	public void updateAdvancedreferencestableROProperty() {
	advancedreferencestableROProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#addFilterAdvancedreferencestableROProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAdvancedreferencestableROProperty(ViewerFilter filter) {
		advancedreferencestableROPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#addBusinessFilterAdvancedreferencestableROProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAdvancedreferencestableROProperty(ViewerFilter filter) {
		advancedreferencestableROPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart#isContainedInAdvancedreferencestableROPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInAdvancedreferencestableROPropertyTable(EObject element) {
		return ((ReferencesTableSettings)advancedreferencestableROProperty.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.AdvancedReferencesTableSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
