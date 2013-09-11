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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;

import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.ElementSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EReferencesViewerSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EReferencesViewerSamplePropertiesEditionPart {

	protected ReferencesTable ereferencesviewerRequiredProperty;
	protected List<ViewerFilter> ereferencesviewerRequiredPropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ereferencesviewerRequiredPropertyFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable ereferencesviewerOptionalProperty;
	protected List<ViewerFilter> ereferencesviewerOptionalPropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ereferencesviewerOptionalPropertyFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable ereferencesviewerROProperty;
	protected List<ViewerFilter> ereferencesviewerROPropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ereferencesviewerROPropertyFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EReferencesViewerSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eReferencesViewerSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eReferencesViewerSampleStep.addStep(EefnrViewsRepository.EReferencesViewerSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty);
		propertiesStep.addStep(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty);
		propertiesStep.addStep(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty);
		
		
		composer = new PartComposer(eReferencesViewerSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.EReferencesViewerSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty) {
					return createEreferencesviewerRequiredPropertyAdvancedReferencesTable(parent);
				}
				if (key == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty) {
					return createEreferencesviewerOptionalPropertyAdvancedReferencesTable(parent);
				}
				if (key == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty) {
					return createEreferencesviewerROPropertyAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(EefnrMessages.EReferencesViewerSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * 
	 */
	protected Composite createEreferencesviewerRequiredPropertyAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty, EefnrMessages.EReferencesViewerSamplePropertiesEditionPart_EreferencesviewerRequiredPropertyLabel);		 
		this.ereferencesviewerRequiredProperty = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEreferencesviewerRequiredProperty(); }
			public void handleEdit(EObject element) { editEreferencesviewerRequiredProperty(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEreferencesviewerRequiredProperty(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEreferencesviewerRequiredProperty(element); }
			public void navigateTo(EObject element) { }
		});
		this.ereferencesviewerRequiredProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty, EefnrViewsRepository.SWT_KIND));
		this.ereferencesviewerRequiredProperty.createControls(parent);
		this.ereferencesviewerRequiredProperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ereferencesviewerRequiredPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		ereferencesviewerRequiredPropertyData.horizontalSpan = 3;
		this.ereferencesviewerRequiredProperty.setLayoutData(ereferencesviewerRequiredPropertyData);
		this.ereferencesviewerRequiredProperty.disableMove();
		ereferencesviewerRequiredProperty.setID(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty);
		ereferencesviewerRequiredProperty.setEEFType("eef::EReferencesViewer"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEreferencesviewerRequiredProperty() {
		ElementSelectionDialog dialog = new ElementSelectionDialog(ereferencesviewerRequiredProperty.getInput(), ereferencesviewerRequiredPropertyFilters, ereferencesviewerRequiredPropertyBusinessFilters,
		"ereferencesviewerRequiredProperty", propertiesEditionComponent.getEditingContext().getAdapterFactory()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				ereferencesviewerRequiredProperty.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEreferencesviewerRequiredProperty(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		ereferencesviewerRequiredProperty.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEreferencesviewerRequiredProperty(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		ereferencesviewerRequiredProperty.refresh();
	}

	/**
	 * 
	 */
	protected void editEreferencesviewerRequiredProperty(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				ereferencesviewerRequiredProperty.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createEreferencesviewerOptionalPropertyAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty, EefnrMessages.EReferencesViewerSamplePropertiesEditionPart_EreferencesviewerOptionalPropertyLabel);		 
		this.ereferencesviewerOptionalProperty = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEreferencesviewerOptionalProperty(); }
			public void handleEdit(EObject element) { editEreferencesviewerOptionalProperty(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEreferencesviewerOptionalProperty(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEreferencesviewerOptionalProperty(element); }
			public void navigateTo(EObject element) { }
		});
		this.ereferencesviewerOptionalProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty, EefnrViewsRepository.SWT_KIND));
		this.ereferencesviewerOptionalProperty.createControls(parent);
		this.ereferencesviewerOptionalProperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ereferencesviewerOptionalPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		ereferencesviewerOptionalPropertyData.horizontalSpan = 3;
		this.ereferencesviewerOptionalProperty.setLayoutData(ereferencesviewerOptionalPropertyData);
		this.ereferencesviewerOptionalProperty.disableMove();
		ereferencesviewerOptionalProperty.setID(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty);
		ereferencesviewerOptionalProperty.setEEFType("eef::EReferencesViewer"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEreferencesviewerOptionalProperty() {
		ElementSelectionDialog dialog = new ElementSelectionDialog(ereferencesviewerOptionalProperty.getInput(), ereferencesviewerOptionalPropertyFilters, ereferencesviewerOptionalPropertyBusinessFilters,
		"ereferencesviewerOptionalProperty", propertiesEditionComponent.getEditingContext().getAdapterFactory()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				ereferencesviewerOptionalProperty.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEreferencesviewerOptionalProperty(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		ereferencesviewerOptionalProperty.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEreferencesviewerOptionalProperty(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		ereferencesviewerOptionalProperty.refresh();
	}

	/**
	 * 
	 */
	protected void editEreferencesviewerOptionalProperty(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				ereferencesviewerOptionalProperty.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createEreferencesviewerROPropertyAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty, EefnrMessages.EReferencesViewerSamplePropertiesEditionPart_EreferencesviewerROPropertyLabel);		 
		this.ereferencesviewerROProperty = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEreferencesviewerROProperty(); }
			public void handleEdit(EObject element) { editEreferencesviewerROProperty(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEreferencesviewerROProperty(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEreferencesviewerROProperty(element); }
			public void navigateTo(EObject element) { }
		});
		this.ereferencesviewerROProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty, EefnrViewsRepository.SWT_KIND));
		this.ereferencesviewerROProperty.createControls(parent);
		this.ereferencesviewerROProperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ereferencesviewerROPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		ereferencesviewerROPropertyData.horizontalSpan = 3;
		this.ereferencesviewerROProperty.setLayoutData(ereferencesviewerROPropertyData);
		this.ereferencesviewerROProperty.disableMove();
		ereferencesviewerROProperty.setID(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty);
		ereferencesviewerROProperty.setEEFType("eef::EReferencesViewer"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEreferencesviewerROProperty() {
		ElementSelectionDialog dialog = new ElementSelectionDialog(ereferencesviewerROProperty.getInput(), ereferencesviewerROPropertyFilters, ereferencesviewerROPropertyBusinessFilters,
		"ereferencesviewerROProperty", propertiesEditionComponent.getEditingContext().getAdapterFactory()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				ereferencesviewerROProperty.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEreferencesviewerROProperty(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		ereferencesviewerROProperty.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEreferencesviewerROProperty(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencesViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		ereferencesviewerROProperty.refresh();
	}

	/**
	 * 
	 */
	protected void editEreferencesviewerROProperty(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				ereferencesviewerROProperty.refresh();
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
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#initEreferencesviewerRequiredProperty(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEreferencesviewerRequiredProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ereferencesviewerRequiredProperty.setContentProvider(contentProvider);
		ereferencesviewerRequiredProperty.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty);
		if (eefElementEditorReadOnlyState && ereferencesviewerRequiredProperty.getTable().isEnabled()) {
			ereferencesviewerRequiredProperty.setEnabled(false);
			ereferencesviewerRequiredProperty.setToolTipText(EefnrMessages.EReferencesViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ereferencesviewerRequiredProperty.getTable().isEnabled()) {
			ereferencesviewerRequiredProperty.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#updateEreferencesviewerRequiredProperty()
	 * 
	 */
	public void updateEreferencesviewerRequiredProperty() {
	ereferencesviewerRequiredProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#addFilterEreferencesviewerRequiredProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEreferencesviewerRequiredProperty(ViewerFilter filter) {
		ereferencesviewerRequiredPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#addBusinessFilterEreferencesviewerRequiredProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEreferencesviewerRequiredProperty(ViewerFilter filter) {
		ereferencesviewerRequiredPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#isContainedInEreferencesviewerRequiredPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInEreferencesviewerRequiredPropertyTable(EObject element) {
		return ((ReferencesTableSettings)ereferencesviewerRequiredProperty.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#initEreferencesviewerOptionalProperty(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEreferencesviewerOptionalProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ereferencesviewerOptionalProperty.setContentProvider(contentProvider);
		ereferencesviewerOptionalProperty.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty);
		if (eefElementEditorReadOnlyState && ereferencesviewerOptionalProperty.getTable().isEnabled()) {
			ereferencesviewerOptionalProperty.setEnabled(false);
			ereferencesviewerOptionalProperty.setToolTipText(EefnrMessages.EReferencesViewerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ereferencesviewerOptionalProperty.getTable().isEnabled()) {
			ereferencesviewerOptionalProperty.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#updateEreferencesviewerOptionalProperty()
	 * 
	 */
	public void updateEreferencesviewerOptionalProperty() {
	ereferencesviewerOptionalProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#addFilterEreferencesviewerOptionalProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEreferencesviewerOptionalProperty(ViewerFilter filter) {
		ereferencesviewerOptionalPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#addBusinessFilterEreferencesviewerOptionalProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEreferencesviewerOptionalProperty(ViewerFilter filter) {
		ereferencesviewerOptionalPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#isContainedInEreferencesviewerOptionalPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInEreferencesviewerOptionalPropertyTable(EObject element) {
		return ((ReferencesTableSettings)ereferencesviewerOptionalProperty.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#initEreferencesviewerROProperty(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEreferencesviewerROProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ereferencesviewerROProperty.setContentProvider(contentProvider);
		ereferencesviewerROProperty.setInput(settings);
		ereferencesviewerROProperty.setEnabled(false);
		ereferencesviewerROProperty.setToolTipText(EefnrMessages.EReferencesViewerSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#updateEreferencesviewerROProperty()
	 * 
	 */
	public void updateEreferencesviewerROProperty() {
	ereferencesviewerROProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#addFilterEreferencesviewerROProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEreferencesviewerROProperty(ViewerFilter filter) {
		ereferencesviewerROPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#addBusinessFilterEreferencesviewerROProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEreferencesviewerROProperty(ViewerFilter filter) {
		ereferencesviewerROPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart#isContainedInEreferencesviewerROPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInEreferencesviewerROPropertyTable(EObject element) {
		return ((ReferencesTableSettings)ereferencesviewerROProperty.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.EReferencesViewerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
