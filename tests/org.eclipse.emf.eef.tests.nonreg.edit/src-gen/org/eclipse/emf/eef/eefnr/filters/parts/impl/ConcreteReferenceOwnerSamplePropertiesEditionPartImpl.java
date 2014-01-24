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
package org.eclipse.emf.eef.eefnr.filters.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.eefnr.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.filters.parts.FiltersViewsRepository;
import org.eclipse.emf.eef.eefnr.filters.providers.FiltersMessages;
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
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ConcreteReferenceOwnerSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConcreteReferenceOwnerSamplePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable abstractTarget;
	protected List<ViewerFilter> abstractTargetBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> abstractTargetFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable strictTyping;
	protected List<ViewerFilter> strictTypingBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> strictTypingFilters = new ArrayList<ViewerFilter>();
	protected TableViewer strictTypingMultipleOnTableComposition;
	protected List<ViewerFilter> strictTypingMultipleOnTableCompositionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> strictTypingMultipleOnTableCompositionFilters = new ArrayList<ViewerFilter>();
	protected Button addStrictTypingMultipleOnTableComposition;
	protected Button removeStrictTypingMultipleOnTableComposition;
	protected Button editStrictTypingMultipleOnTableComposition;
	protected ReferencesTable strictTypingMultipleOnAdvancedTableComposition;
	protected List<ViewerFilter> strictTypingMultipleOnAdvancedTableCompositionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> strictTypingMultipleOnAdvancedTableCompositionFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConcreteReferenceOwnerSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence concreteReferenceOwnerSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = concreteReferenceOwnerSampleStep.addStep(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.class);
		propertiesStep.addStep(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name);
		propertiesStep.addStep(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget);
		propertiesStep.addStep(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping);
		propertiesStep.addStep(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition);
		propertiesStep.addStep(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition);
		
		
		composer = new PartComposer(concreteReferenceOwnerSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name) {
					return createNameText(parent);
				}
				if (key == FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget) {
					return createAbstractTargetAdvancedReferencesTable(parent);
				}
				if (key == FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping) {
					return createStrictTypingAdvancedTableComposition(parent);
				}
				if (key == FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition) {
					return createStrictTypingMultipleOnTableCompositionTableComposition(parent);
				}
				if (key == FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition) {
					return createStrictTypingMultipleOnAdvancedTableCompositionAdvancedTableComposition(parent);
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
		propertiesGroup.setText(FiltersMessages.ConcreteReferenceOwnerSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name, FiltersMessages.ConcreteReferenceOwnerSamplePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name, FiltersViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createAbstractTargetAdvancedReferencesTable(Composite parent) {
		String label = getDescription(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget, FiltersMessages.ConcreteReferenceOwnerSamplePropertiesEditionPart_AbstractTargetLabel);		 
		this.abstractTarget = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addAbstractTarget(); }
			public void handleEdit(EObject element) { editAbstractTarget(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAbstractTarget(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAbstractTarget(element); }
			public void navigateTo(EObject element) { }
		});
		this.abstractTarget.setHelpText(propertiesEditionComponent.getHelpContent(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget, FiltersViewsRepository.SWT_KIND));
		this.abstractTarget.createControls(parent);
		this.abstractTarget.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData abstractTargetData = new GridData(GridData.FILL_HORIZONTAL);
		abstractTargetData.horizontalSpan = 3;
		this.abstractTarget.setLayoutData(abstractTargetData);
		this.abstractTarget.disableMove();
		abstractTarget.setID(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget);
		abstractTarget.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addAbstractTarget() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(abstractTarget.getInput(), abstractTargetFilters, abstractTargetBusinessFilters,
		"abstractTarget", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				abstractTarget.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAbstractTarget(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		abstractTarget.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAbstractTarget(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		abstractTarget.refresh();
	}

	/**
	 * 
	 */
	protected void editAbstractTarget(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				abstractTarget.refresh();
			}
		}
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createStrictTypingAdvancedTableComposition(Composite parent) {
		this.strictTyping = new ReferencesTable(getDescription(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, FiltersMessages.ConcreteReferenceOwnerSamplePropertiesEditionPart_StrictTypingLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				strictTyping.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				strictTyping.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				strictTyping.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				strictTyping.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.strictTypingFilters) {
			this.strictTyping.addFilter(filter);
		}
		this.strictTyping.setHelpText(propertiesEditionComponent.getHelpContent(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, FiltersViewsRepository.SWT_KIND));
		this.strictTyping.createControls(parent);
		this.strictTyping.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData strictTypingData = new GridData(GridData.FILL_HORIZONTAL);
		strictTypingData.horizontalSpan = 3;
		this.strictTyping.setLayoutData(strictTypingData);
		this.strictTyping.setLowerBound(0);
		this.strictTyping.setUpperBound(-1);
		strictTyping.setID(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping);
		strictTyping.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createStrictTypingAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createStrictTypingMultipleOnTableCompositionTableComposition(Composite container) {
		Composite tableContainer = new Composite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableStrictTypingMultipleOnTableComposition = new org.eclipse.swt.widgets.Table(tableContainer, SWT.FULL_SELECTION);
		tableStrictTypingMultipleOnTableComposition.setHeaderVisible(true);
		GridData gdStrictTypingMultipleOnTableComposition = new GridData();
		gdStrictTypingMultipleOnTableComposition.grabExcessHorizontalSpace = true;
		gdStrictTypingMultipleOnTableComposition.horizontalAlignment = GridData.FILL;
		gdStrictTypingMultipleOnTableComposition.grabExcessVerticalSpace = true;
		gdStrictTypingMultipleOnTableComposition.verticalAlignment = GridData.FILL;
		tableStrictTypingMultipleOnTableComposition.setLayoutData(gdStrictTypingMultipleOnTableComposition);
		tableStrictTypingMultipleOnTableComposition.setLinesVisible(true);

		// Start of user code for columns definition for StrictTypingMultipleOnTableComposition
				TableColumn name = new TableColumn(tableStrictTypingMultipleOnTableComposition, SWT.NONE);
				name.setWidth(80);
				name.setText("Label"); //$NON-NLS-1$
		// End of user code

		strictTypingMultipleOnTableComposition = new TableViewer(tableStrictTypingMultipleOnTableComposition);
		strictTypingMultipleOnTableComposition.setContentProvider(new ArrayContentProvider());
		strictTypingMultipleOnTableComposition.setLabelProvider(new ITableLabelProvider() {
			//Start of user code for label provider definition for StrictTypingMultipleOnTableComposition
						public String getColumnText(Object object, int columnIndex) {
							AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
							if (object instanceof EObject) {
								switch (columnIndex) {
								case 0:
									return labelProvider.getText(object);
								}
							}
							return ""; //$NON-NLS-1$
						}
			
						public Image getColumnImage(Object element, int columnIndex) {
							return null;
						}
			
			//End of user code

			public void addListener(ILabelProviderListener listener) {
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}

		});
		strictTypingMultipleOnTableComposition.getTable().addListener(SWT.MouseDoubleClick, new Listener(){

			public void handleEvent(Event event) {
				if (strictTypingMultipleOnTableComposition.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) strictTypingMultipleOnTableComposition.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, selection.getFirstElement()));
						strictTypingMultipleOnTableComposition.refresh();
					}
				}
			}

		});
		GridData strictTypingMultipleOnTableCompositionData = new GridData(GridData.FILL_HORIZONTAL);
		strictTypingMultipleOnTableCompositionData.minimumHeight = 120;
		strictTypingMultipleOnTableCompositionData.heightHint = 120;
		strictTypingMultipleOnTableComposition.getTable().setLayoutData(strictTypingMultipleOnTableCompositionData);
		for (ViewerFilter filter : this.strictTypingMultipleOnTableCompositionFilters) {
			strictTypingMultipleOnTableComposition.addFilter(filter);
		}
		EditingUtils.setID(strictTypingMultipleOnTableComposition.getTable(), FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition);
		EditingUtils.setEEFtype(strictTypingMultipleOnTableComposition.getTable(), "eef::TableComposition::field"); //$NON-NLS-1$
		createStrictTypingMultipleOnTableCompositionPanel(tableContainer);
		// Start of user code for createStrictTypingMultipleOnTableCompositionTableComposition

		// End of user code
		return container;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createStrictTypingMultipleOnTableCompositionPanel(Composite container) {
		Composite strictTypingMultipleOnTableCompositionPanel = new Composite(container, SWT.NONE);
		GridLayout strictTypingMultipleOnTableCompositionPanelLayout = new GridLayout();
		strictTypingMultipleOnTableCompositionPanelLayout.numColumns = 1;
		strictTypingMultipleOnTableCompositionPanel.setLayout(strictTypingMultipleOnTableCompositionPanelLayout);
		addStrictTypingMultipleOnTableComposition = new Button(strictTypingMultipleOnTableCompositionPanel, SWT.NONE);
		addStrictTypingMultipleOnTableComposition.setText(FiltersMessages.PropertiesEditionPart_AddTableViewerLabel);
		GridData addStrictTypingMultipleOnTableCompositionData = new GridData(GridData.FILL_HORIZONTAL);
		addStrictTypingMultipleOnTableComposition.setLayoutData(addStrictTypingMultipleOnTableCompositionData);
		addStrictTypingMultipleOnTableComposition.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				strictTypingMultipleOnTableComposition.refresh();
			}
		});
		EditingUtils.setID(addStrictTypingMultipleOnTableComposition, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition);
		EditingUtils.setEEFtype(addStrictTypingMultipleOnTableComposition, "eef::TableComposition::addbutton"); //$NON-NLS-1$
		removeStrictTypingMultipleOnTableComposition = new Button(strictTypingMultipleOnTableCompositionPanel, SWT.NONE);
		removeStrictTypingMultipleOnTableComposition.setText(FiltersMessages.PropertiesEditionPart_RemoveTableViewerLabel);
		GridData removeStrictTypingMultipleOnTableCompositionData = new GridData(GridData.FILL_HORIZONTAL);
		removeStrictTypingMultipleOnTableComposition.setLayoutData(removeStrictTypingMultipleOnTableCompositionData);
		removeStrictTypingMultipleOnTableComposition.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				if (strictTypingMultipleOnTableComposition.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) strictTypingMultipleOnTableComposition.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, selectedElement));
						strictTypingMultipleOnTableComposition.refresh();
					}
				}
			}

		});
		EditingUtils.setID(removeStrictTypingMultipleOnTableComposition, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition);
		EditingUtils.setEEFtype(removeStrictTypingMultipleOnTableComposition, "eef::TableComposition::removebutton"); //$NON-NLS-1$
		editStrictTypingMultipleOnTableComposition = new Button(strictTypingMultipleOnTableCompositionPanel, SWT.NONE);
		editStrictTypingMultipleOnTableComposition.setText(FiltersMessages.PropertiesEditionPart_EditTableViewerLabel);
		GridData editStrictTypingMultipleOnTableCompositionData = new GridData(GridData.FILL_HORIZONTAL);
		editStrictTypingMultipleOnTableComposition.setLayoutData(editStrictTypingMultipleOnTableCompositionData);
		editStrictTypingMultipleOnTableComposition.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				if (strictTypingMultipleOnTableComposition.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) strictTypingMultipleOnTableComposition.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, selection.getFirstElement()));
						strictTypingMultipleOnTableComposition.refresh();
					}
				}
			}

		});
		EditingUtils.setID(editStrictTypingMultipleOnTableComposition, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition);
		EditingUtils.setEEFtype(editStrictTypingMultipleOnTableComposition, "eef::TableComposition::editbutton"); //$NON-NLS-1$
		// Start of user code for createStrictTypingMultipleOnTableCompositionPanel

		// End of user code
		return strictTypingMultipleOnTableCompositionPanel;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createStrictTypingMultipleOnAdvancedTableCompositionAdvancedTableComposition(Composite parent) {
		this.strictTypingMultipleOnAdvancedTableComposition = new ReferencesTable(getDescription(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, FiltersMessages.ConcreteReferenceOwnerSamplePropertiesEditionPart_StrictTypingMultipleOnAdvancedTableCompositionLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				strictTypingMultipleOnAdvancedTableComposition.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				strictTypingMultipleOnAdvancedTableComposition.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				strictTypingMultipleOnAdvancedTableComposition.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				strictTypingMultipleOnAdvancedTableComposition.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.strictTypingMultipleOnAdvancedTableCompositionFilters) {
			this.strictTypingMultipleOnAdvancedTableComposition.addFilter(filter);
		}
		this.strictTypingMultipleOnAdvancedTableComposition.setHelpText(propertiesEditionComponent.getHelpContent(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, FiltersViewsRepository.SWT_KIND));
		this.strictTypingMultipleOnAdvancedTableComposition.createControls(parent);
		this.strictTypingMultipleOnAdvancedTableComposition.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConcreteReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData strictTypingMultipleOnAdvancedTableCompositionData = new GridData(GridData.FILL_HORIZONTAL);
		strictTypingMultipleOnAdvancedTableCompositionData.horizontalSpan = 3;
		this.strictTypingMultipleOnAdvancedTableComposition.setLayoutData(strictTypingMultipleOnAdvancedTableCompositionData);
		this.strictTypingMultipleOnAdvancedTableComposition.setLowerBound(0);
		this.strictTypingMultipleOnAdvancedTableComposition.setUpperBound(-1);
		strictTypingMultipleOnAdvancedTableComposition.setID(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition);
		strictTypingMultipleOnAdvancedTableComposition.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createStrictTypingMultipleOnAdvancedTableCompositionAdvancedTableComposition

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
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#initAbstractTarget(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAbstractTarget(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		abstractTarget.setContentProvider(contentProvider);
		abstractTarget.setInput(settings);
		abstractTargetBusinessFilters.clear();
		abstractTargetFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.abstractTarget);
		if (eefElementEditorReadOnlyState && abstractTarget.getTable().isEnabled()) {
			abstractTarget.setEnabled(false);
			abstractTarget.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !abstractTarget.getTable().isEnabled()) {
			abstractTarget.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#updateAbstractTarget()
	 * 
	 */
	public void updateAbstractTarget() {
	abstractTarget.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addFilterAbstractTarget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAbstractTarget(ViewerFilter filter) {
		abstractTargetFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addBusinessFilterAbstractTarget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAbstractTarget(ViewerFilter filter) {
		abstractTargetBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#isContainedInAbstractTargetTable(EObject element)
	 * 
	 */
	public boolean isContainedInAbstractTargetTable(EObject element) {
		return ((ReferencesTableSettings)abstractTarget.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#initStrictTyping(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initStrictTyping(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		strictTyping.setContentProvider(contentProvider);
		strictTyping.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTyping);
		if (eefElementEditorReadOnlyState && strictTyping.isEnabled()) {
			strictTyping.setEnabled(false);
			strictTyping.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !strictTyping.isEnabled()) {
			strictTyping.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#updateStrictTyping()
	 * 
	 */
	public void updateStrictTyping() {
	strictTyping.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addFilterStrictTyping(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStrictTyping(ViewerFilter filter) {
		strictTypingFilters.add(filter);
		if (this.strictTyping != null) {
			this.strictTyping.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addBusinessFilterStrictTyping(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStrictTyping(ViewerFilter filter) {
		strictTypingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#isContainedInStrictTypingTable(EObject element)
	 * 
	 */
	public boolean isContainedInStrictTypingTable(EObject element) {
		return ((ReferencesTableSettings)strictTyping.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#initStrictTypingMultipleOnTableComposition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initStrictTypingMultipleOnTableComposition(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		strictTypingMultipleOnTableComposition.setContentProvider(contentProvider);
		strictTypingMultipleOnTableComposition.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnTableComposition);
		if (eefElementEditorReadOnlyState && strictTypingMultipleOnTableComposition.getTable().isEnabled()) {
			strictTypingMultipleOnTableComposition.getTable().setEnabled(false);
			strictTypingMultipleOnTableComposition.getTable().setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
			addStrictTypingMultipleOnTableComposition.setEnabled(false);
			addStrictTypingMultipleOnTableComposition.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
			removeStrictTypingMultipleOnTableComposition.setEnabled(false);
			removeStrictTypingMultipleOnTableComposition.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
			editStrictTypingMultipleOnTableComposition.setEnabled(false);
			editStrictTypingMultipleOnTableComposition.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !strictTypingMultipleOnTableComposition.getTable().isEnabled()) {
			strictTypingMultipleOnTableComposition.getTable().setEnabled(true);
			addStrictTypingMultipleOnTableComposition.setEnabled(true);
			removeStrictTypingMultipleOnTableComposition.setEnabled(true);
			editStrictTypingMultipleOnTableComposition.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#updateStrictTypingMultipleOnTableComposition()
	 * 
	 */
	public void updateStrictTypingMultipleOnTableComposition() {
	strictTypingMultipleOnTableComposition.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addFilterStrictTypingMultipleOnTableComposition(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStrictTypingMultipleOnTableComposition(ViewerFilter filter) {
		strictTypingMultipleOnTableCompositionFilters.add(filter);
		if (this.strictTypingMultipleOnTableComposition != null) {
			this.strictTypingMultipleOnTableComposition.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addBusinessFilterStrictTypingMultipleOnTableComposition(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStrictTypingMultipleOnTableComposition(ViewerFilter filter) {
		strictTypingMultipleOnTableCompositionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#isContainedInStrictTypingMultipleOnTableCompositionTable(EObject element)
	 * 
	 */
	public boolean isContainedInStrictTypingMultipleOnTableCompositionTable(EObject element) {
		return ((ReferencesTableSettings)strictTypingMultipleOnTableComposition.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#initStrictTypingMultipleOnAdvancedTableComposition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initStrictTypingMultipleOnAdvancedTableComposition(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		strictTypingMultipleOnAdvancedTableComposition.setContentProvider(contentProvider);
		strictTypingMultipleOnAdvancedTableComposition.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FiltersViewsRepository.ConcreteReferenceOwnerSample.Properties.strictTypingMultipleOnAdvancedTableComposition);
		if (eefElementEditorReadOnlyState && strictTypingMultipleOnAdvancedTableComposition.isEnabled()) {
			strictTypingMultipleOnAdvancedTableComposition.setEnabled(false);
			strictTypingMultipleOnAdvancedTableComposition.setToolTipText(FiltersMessages.ConcreteReferenceOwnerSample_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !strictTypingMultipleOnAdvancedTableComposition.isEnabled()) {
			strictTypingMultipleOnAdvancedTableComposition.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#updateStrictTypingMultipleOnAdvancedTableComposition()
	 * 
	 */
	public void updateStrictTypingMultipleOnAdvancedTableComposition() {
	strictTypingMultipleOnAdvancedTableComposition.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addFilterStrictTypingMultipleOnAdvancedTableComposition(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStrictTypingMultipleOnAdvancedTableComposition(ViewerFilter filter) {
		strictTypingMultipleOnAdvancedTableCompositionFilters.add(filter);
		if (this.strictTypingMultipleOnAdvancedTableComposition != null) {
			this.strictTypingMultipleOnAdvancedTableComposition.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#addBusinessFilterStrictTypingMultipleOnAdvancedTableComposition(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStrictTypingMultipleOnAdvancedTableComposition(ViewerFilter filter) {
		strictTypingMultipleOnAdvancedTableCompositionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.ConcreteReferenceOwnerSamplePropertiesEditionPart#isContainedInStrictTypingMultipleOnAdvancedTableCompositionTable(EObject element)
	 * 
	 */
	public boolean isContainedInStrictTypingMultipleOnAdvancedTableCompositionTable(EObject element) {
		return ((ReferencesTableSettings)strictTypingMultipleOnAdvancedTableComposition.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return FiltersMessages.ConcreteReferenceOwnerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
