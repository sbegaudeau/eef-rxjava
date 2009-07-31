/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: PropertiesEditionElementPropertiesEditionPartImpl.java,v 1.11 2009/07/31 14:14:18 glefur Exp $
 */
package org.eclipse.emf.eef.components.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart;
import org.eclipse.emf.eef.components.providers.ComponentsMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;




// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropertiesEditionElementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PropertiesEditionElementPropertiesEditionPart {

	protected Text name;
	protected Text helpID;
	protected EObjectFlatComboViewer model;
	protected EMFListEditUtil viewsEditUtil;
	protected TableViewer views;
	protected Button addViews;
	protected Button removeViews;
	protected List<ViewerFilter> viewsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> viewsFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PropertiesEditionElementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);
		createBindingGroup(view);

		// Start of user code for additional ui definition
		model.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {

			@Override
			public String getText(Object object) {
				if (object instanceof EStructuralFeature) {
					return ((EStructuralFeature)object).getName();
				}
				return super.getText(object);
			}
			
		});
		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ComponentsMessages.PropertiesEditionElementPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
		createHelpIDText(propertiesGroup);
	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ComponentsMessages.PropertiesEditionElementPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(ComponentsViewsRepository.PropertiesEditionElement.name, ComponentsViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertiesEditionElementPropertiesEditionPartImpl.this, ComponentsViewsRepository.PropertiesEditionElement.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentsViewsRepository.PropertiesEditionElement.name, ComponentsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createHelpIDText(Composite parent) {
		SWTUtils.createPartLabel(parent, ComponentsMessages.PropertiesEditionElementPropertiesEditionPart_HelpIDLabel, propertiesEditionComponent.isRequired(ComponentsViewsRepository.PropertiesEditionElement.helpID, ComponentsViewsRepository.SWT_KIND));
		helpID = new Text(parent, SWT.BORDER);
		GridData helpIDData = new GridData(GridData.FILL_HORIZONTAL);
		helpID.setLayoutData(helpIDData);
		helpID.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertiesEditionElementPropertiesEditionPartImpl.this, ComponentsViewsRepository.PropertiesEditionElement.helpID, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, helpID.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentsViewsRepository.PropertiesEditionElement.helpID, ComponentsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createBindingGroup(Composite parent) {
		Group bindingGroup = new Group(parent, SWT.NONE);
		bindingGroup.setText(ComponentsMessages.PropertiesEditionElementPropertiesEditionPart_BindingGroupLabel);
		GridData bindingGroupData = new GridData(GridData.FILL_HORIZONTAL);
		bindingGroupData.horizontalSpan = 3;
		bindingGroup.setLayoutData(bindingGroupData);
		GridLayout bindingGroupLayout = new GridLayout();
		bindingGroupLayout.numColumns = 3;
		bindingGroup.setLayout(bindingGroupLayout);
		createModelFlatComboViewer(bindingGroup);
		createViewsReferencesTable(bindingGroup);
	}
	/**
	 * @param bindingGroup
	 */
	protected void createModelFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ComponentsMessages.PropertiesEditionElementPropertiesEditionPart_ModelLabel, propertiesEditionComponent.isRequired(ComponentsViewsRepository.PropertiesEditionElement.model, ComponentsViewsRepository.SWT_KIND));
		model = new EObjectFlatComboViewer(parent, false);
		model.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		model.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertiesEditionElementPropertiesEditionPartImpl.this, ComponentsViewsRepository.PropertiesEditionElement.model, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getModel()));
			}

		});
		GridData modelData = new GridData(GridData.FILL_HORIZONTAL);
		model.setLayoutData(modelData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentsViewsRepository.PropertiesEditionElement.model, ComponentsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param parent
	 */
	protected void createViewsReferencesTable(Composite parent) {
		Label viewsLabel = SWTUtils.createPartLabel(parent, ComponentsMessages.PropertiesEditionElementPropertiesEditionPart_ViewsLabel, propertiesEditionComponent.isRequired(ComponentsViewsRepository.PropertiesEditionElement.views, ComponentsViewsRepository.SWT_KIND));
		GridData viewsLabelData = new GridData();
		viewsLabelData.horizontalSpan = 3;
		viewsLabel.setLayoutData(viewsLabelData);
		views = createViewsViewer(parent, adapterFactory);
		GridData viewsData = new GridData(GridData.FILL_HORIZONTAL);
		viewsData.horizontalSpan = 2;
		viewsData.minimumHeight = 120;
		viewsData.heightHint = 120;
		views.getTable().setLayoutData(viewsData);
		createViewsControlPanel(parent);
	}

	protected TableViewer createViewsViewer(Composite container, AdapterFactory adapter) {
		org.eclipse.swt.widgets.Table table = new org.eclipse.swt.widgets.Table(container, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		table.setLayoutData(gd);
		table.setLinesVisible(true);
		// Start of user code for table views s columns definition
		
		TableColumn name = new TableColumn(table, SWT.NONE);
		name.setWidth(80);
		name.setText("Views"); //$NON-NLS-1$
		// End of user code
		
		TableViewer result = new TableViewer(table);
		result.setContentProvider(new ArrayContentProvider());
		result.setLabelProvider(new ITableLabelProvider() {
	
			// Start of user code for table views label provider
			
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
			// End of user code

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
		return result;
	}

	protected void createViewsControlPanel(Composite container) {
		Composite result = new Composite(container, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		result.setLayout(layout);
		addViews = new Button(result, SWT.NONE);
		addViews.setText(ComponentsMessages.PropertiesEditionPart_AddListViewerLabel);
		GridData addData = new GridData(GridData.FILL_HORIZONTAL);
		addViews.setLayoutData(addData);
		addViews.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addViews();
				views.refresh();
			}

		});
		removeViews = new Button(result, SWT.NONE);
		removeViews.setText(ComponentsMessages.PropertiesEditionPart_RemoveListViewerLabel);
		GridData removeData = new GridData(GridData.FILL_HORIZONTAL);
		removeViews.setLayoutData(removeData);
		removeViews.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (views.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) views.getSelection();
					removeViews(selection);
					views.refresh();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertiesEditionElementPropertiesEditionPartImpl.this, ComponentsViewsRepository.PropertiesEditionElement.views, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, selection.getFirstElement()));
				}
			}

		});
	}

	/**
	 *
	 */
	protected void addViews() {
		EMFModelViewerDialog dialog = new EMFModelViewerDialog(new AdapterFactoryLabelProvider(adapterFactory), resourceSet, viewsFilters, viewsBusinessFilters, false, true) {

			public void process(IStructuredSelection selection) {
				for (Iterator iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					if (!viewsEditUtil.getVirtualList().contains(elem))
						viewsEditUtil.addElement(elem);
				}
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertiesEditionElementPropertiesEditionPartImpl.this, ComponentsViewsRepository.PropertiesEditionElement.views, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, selection));
			}

		};
		dialog.open();
	}

	/**
	 * @param selection the views to remove 
	 */
	protected void removeViews(IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof EObject) {
			EObject selectedElement = (EObject) selection.getFirstElement();
			viewsEditUtil.removeElement(selectedElement);
		}
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForName(String msg, int msgLevel) {

	}

	public void unsetMessageForName() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#getHelpID()
	 */
	public String getHelpID() {
		return helpID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#setHelpID(String newValue)
	 */
	public void setHelpID(String newValue) {
		if (newValue != null) {
			helpID.setText(newValue);
		} else {
			helpID.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForHelpID(String msg, int msgLevel) {

	}

	public void unsetMessageForHelpID() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#getModel()
	 */
	public EObject getModel() {
		if (model.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) model.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#initModel(ResourceSet allResources, EObject current)
	 */
	public void initModel(ResourceSet allResources, EObject current) {
		model.setInput(allResources);
		if (current != null) {
			model.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#setModel(EObject newValue)
	 */
	public void setModel(EObject newValue) {
		if (newValue != null) {
			model.setSelection(new StructuredSelection(newValue));
		} else {
			model.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#setModelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setModelButtonMode(ButtonsModeEnum newValue) {
		model.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#addFilterModel(ViewerFilter filter)
	 */
	public void addFilterToModel(ViewerFilter filter) {
		model.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#addBusinessFilterModel(ViewerFilter filter)
	 */
	public void addBusinessFilterToModel(ViewerFilter filter) {
		model.addBusinessRuleFilter(filter);
	}

	public void setMessageForModel(String msg, int msgLevel) {

	}

	public void unsetMessageForModel() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#getViewsToAdd()
	 */
	public List getViewsToAdd() {
		return viewsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#getViewsToRemove()
	 */
	public List getViewsToRemove() {
		return viewsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#getViewsTable()
	 */
	public List getViewsTable() {
		return viewsEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#initViews(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initViews(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			viewsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			viewsEditUtil = new EMFListEditUtil(current, feature);
		this.views.setInput(viewsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#updateViews(EObject newValue)
	 */
	public void updateViews(EObject newValue) {
		if(viewsEditUtil != null){
			viewsEditUtil.reinit(newValue);
			views.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#addFilterViews(ViewerFilter filter)
	 */
	public void addFilterToViews(ViewerFilter filter) {
		viewsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#addBusinessFilterViews(ViewerFilter filter)
	 */
	public void addBusinessFilterToViews(ViewerFilter filter) {
		viewsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart#isContainedInViewsTable(EObject element)
	 */
	public boolean isContainedInViewsTable(EObject element) {
		return viewsEditUtil.contains(element);
	}

	public void setMessageForViews(String msg, int msgLevel) {

	}

	public void unsetMessageForViews() {

	}








	// Start of user code additional methods
 	
	// End of user code

}
