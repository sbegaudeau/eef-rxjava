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
 * $Id: EMFMultiPropertiesBindingPropertiesEditionPartImpl.java,v 1.9 2009/05/20 14:32:05 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFMultiPropertiesBindingPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EMFMultiPropertiesBindingPropertiesEditionPart {

	private Text name;
	private EMFListEditUtil modelEditUtil;
	private ReferencesTable<?> model;
	protected List<ViewerFilter> modelBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> modelFilters = new ArrayList<ViewerFilter>();
	private EMFListEditUtil viewsEditUtil;
	private ReferencesTable<?> views;
	protected List<ViewerFilter> viewsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> viewsFilters = new ArrayList<ViewerFilter>();




	
	public EMFMultiPropertiesBindingPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	public void createControls(Composite view) { 
		createPropertiesGroup(view);
		createBindingGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(MappingMessages.EMFMultiPropertiesBindingPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, MappingMessages.EMFMultiPropertiesBindingPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.EMFMultiPropertiesBinding.name, MappingViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.EMFMultiPropertiesBinding.name, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createBindingGroup(Composite parent) {
		Group bindingGroup = new Group(parent, SWT.NONE);
		bindingGroup.setText(MappingMessages.EMFMultiPropertiesBindingPropertiesEditionPart_BindingGroupLabel);
		GridData bindingGroupData = new GridData(GridData.FILL_HORIZONTAL);
		bindingGroupData.horizontalSpan = 3;
		bindingGroup.setLayoutData(bindingGroupData);
		GridLayout bindingGroupLayout = new GridLayout();
		bindingGroupLayout.numColumns = 3;
		bindingGroup.setLayout(bindingGroupLayout);
		createModelAdvancedReferencesTable(bindingGroup);
		createViewsAdvancedReferencesTable(bindingGroup);
	}
	protected void createModelAdvancedReferencesTable(Composite parent) {
		this.model = new ReferencesTable<EStructuralFeature>(MappingMessages.EMFMultiPropertiesBindingPropertiesEditionPart_ModelLabel, new ReferencesTableListener<EStructuralFeature>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<EStructuralFeature> dialog = new TabElementTreeSelectionDialog<EStructuralFeature>(resourceSet, modelFilters, modelBusinessFilters,
				"EStructuralFeature", EcorePackage.eINSTANCE.getEStructuralFeature()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!modelEditUtil.getVirtualList().contains(elem))
								modelEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.model,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						model.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(EStructuralFeature element) { editModel(element); }
			public void handleMove(EStructuralFeature element, int oldIndex, int newIndex) { moveModel(element, oldIndex, newIndex); }
			public void handleRemove(EStructuralFeature element) { removeFromModel(element); }
			public void navigateTo(EStructuralFeature element) { }
		});
		this.model.setHelpText(propertiesEditionComponent.getHelpContent(MappingViewsRepository.EMFMultiPropertiesBinding.model, MappingViewsRepository.SWT_KIND));
		this.model.createControls(parent);
		GridData modelData = new GridData(GridData.FILL_HORIZONTAL);
		modelData.horizontalSpan = 3;
		this.model.setLayoutData(modelData);
		this.model.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveModel(EStructuralFeature element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	private void removeFromModel(EStructuralFeature element) {

		// Start of user code removeFromModel() method body

		EObject editedElement = modelEditUtil.foundCorrespondingEObject(element);
		modelEditUtil.removeElement(element);
		model.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.model, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editModel(EStructuralFeature element) {

		// Start of user code editModel() method body
				 
		EObject editedElement = modelEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				modelEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				model.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.model, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createViewsAdvancedReferencesTable(Composite parent) {
		this.views = new ReferencesTable<ElementEditor>(MappingMessages.EMFMultiPropertiesBindingPropertiesEditionPart_ViewsLabel, new ReferencesTableListener<ElementEditor>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<ElementEditor> dialog = new TabElementTreeSelectionDialog<ElementEditor>(resourceSet, viewsFilters, viewsBusinessFilters,
				"ElementEditor", ViewsPackage.eINSTANCE.getElementEditor()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!viewsEditUtil.getVirtualList().contains(elem))
								viewsEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.views,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						views.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(ElementEditor element) { editViews(element); }
			public void handleMove(ElementEditor element, int oldIndex, int newIndex) { moveViews(element, oldIndex, newIndex); }
			public void handleRemove(ElementEditor element) { removeFromViews(element); }
			public void navigateTo(ElementEditor element) { }
		});
		this.views.setHelpText(propertiesEditionComponent.getHelpContent(MappingViewsRepository.EMFMultiPropertiesBinding.views, MappingViewsRepository.SWT_KIND));
		this.views.createControls(parent);
		GridData viewsData = new GridData(GridData.FILL_HORIZONTAL);
		viewsData.horizontalSpan = 3;
		this.views.setLayoutData(viewsData);
		this.views.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveViews(ElementEditor element, int oldIndex, int newIndex) {
		EObject editedElement = viewsEditUtil.foundCorrespondingEObject(element);
		viewsEditUtil.moveElement(element, oldIndex, newIndex);
		views.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.views, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}
	
	/**
	 * 
	 */
	private void removeFromViews(ElementEditor element) {

		// Start of user code removeFromViews() method body

		EObject editedElement = viewsEditUtil.foundCorrespondingEObject(element);
		viewsEditUtil.removeElement(element);
		views.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.views, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editViews(ElementEditor element) {

		// Start of user code editViews() method body
				 
		EObject editedElement = viewsEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				viewsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				views.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFMultiPropertiesBindingPropertiesEditionPartImpl.this, MappingViewsRepository.EMFMultiPropertiesBinding.views, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		name.setText(newValue);
	}

	public void setMessageForName(String msg, int msgLevel) {

	}

	public void unsetMessageForName() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getModelToAdd()
	 */
	public List getModelToAdd() {
		return modelEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getModelToRemove()
	 */
	public List getModelToRemove() {
		return modelEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getModelTable()
	 */
	public List getModelTable() {
		return modelEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#initModel(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initModel(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			modelEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			modelEditUtil = new EMFListEditUtil(current, feature);
		this.model.setInput(modelEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#updateModel(EObject newValue)
	 */
	public void updateModel(EObject newValue) {
		if(modelEditUtil!=null){
			modelEditUtil.reinit(newValue);
			model.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#addFilterModel(ViewerFilter filter)
	 */
	public void addFilterToModel(ViewerFilter filter) {
		modelFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#addBusinessFilterModel(ViewerFilter filter)
	 */
	public void addBusinessFilterToModel(ViewerFilter filter) {
		modelBusinessFilters.add(filter);
	}

	public void setMessageForModel(String msg, int msgLevel) {

	}

	public void unsetMessageForModel() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getViewsToAdd()
	 */
	public List getViewsToAdd() {
		return viewsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getViewsToRemove()
	 */
	public List getViewsToRemove() {
		return viewsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#getViewsTable()
	 */
	public List getViewsTable() {
		return viewsEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#initViews(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#updateViews(EObject newValue)
	 */
	public void updateViews(EObject newValue) {
		if(viewsEditUtil!=null){
			viewsEditUtil.reinit(newValue);
			views.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#addFilterViews(ViewerFilter filter)
	 */
	public void addFilterToViews(ViewerFilter filter) {
		viewsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart#addBusinessFilterViews(ViewerFilter filter)
	 */
	public void addBusinessFilterToViews(ViewerFilter filter) {
		viewsBusinessFilters.add(filter);
	}

	public void setMessageForViews(String msg, int msgLevel) {

	}

	public void unsetMessageForViews() {

	}








	// Start of user code additional methods
 	
	// End of user code
}
