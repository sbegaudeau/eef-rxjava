/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.eclipse.worldcupforecast.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import org.eclipse.worldcupforecast.WorldCupGroup;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class WorldCupForecastGroupPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, WorldCupForecastGroupPropertiesEditionPart {

	protected EMFListEditUtil groupEditUtil;
		protected ReferencesTable<? extends EObject> group;
		protected List<ViewerFilter> groupBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> groupFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorldCupForecastGroupPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createGroupTableComposition(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * @param container
	 * 
	 */
	protected void createGroupTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.group = new ReferencesTable<WorldCupGroup>(WorldcupforecastMessages.WorldCupForecastGroupPropertiesEditionPart_GroupLabel, new ReferencesTableListener<WorldCupGroup>() {			
			public void handleAdd() { addToGroup();}
			public void handleEdit(WorldCupGroup element) { editGroup(element); }
			public void handleMove(WorldCupGroup element, int oldIndex, int newIndex) { moveGroup(element, oldIndex, newIndex); }
			public void handleRemove(WorldCupGroup element) { removeFromGroup(element); }
			public void navigateTo(WorldCupGroup element) { }
		});
		this.group.setHelpText(propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.WorldCupForecastGroup.group, WorldcupforecastViewsRepository.FORM_KIND));
		this.group.createControls(parent, widgetFactory);
		GridData groupData = new GridData(GridData.FILL_HORIZONTAL);
		groupData.horizontalSpan = 3;
		this.group.setLayoutData(groupData);
		this.group.setLowerBound(0);
		this.group.setUpperBound(-1);
	}

	/**
	 * 
	 */
	protected void moveGroup(WorldCupGroup element, int oldIndex, int newIndex) {
		EObject editedElement = groupEditUtil.foundCorrespondingEObject(element);
		groupEditUtil.moveElement(element, oldIndex, newIndex);
		group.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastGroup.group, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToGroup() {
		// Start of user code addToGroup() method body
				WorldCupGroup eObject = WorldcupforecastFactory.eINSTANCE.createWorldCupGroup();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						groupEditUtil.addElement(propertiesEditionObject);
						group.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastGroup.group, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
		
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromGroup(WorldCupGroup element) {
		// Start of user code for the removeFromGroup() method body
				EObject editedElement = groupEditUtil.foundCorrespondingEObject(element);
				groupEditUtil.removeElement(element);
				group.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastGroup.group, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
				
		// End of user code

	}

	/**
	 * 
	 */
	protected void editGroup(WorldCupGroup element) {
		// Start of user code editGroup() method body
				EObject editedElement = groupEditUtil.foundCorrespondingEObject(element);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
					if (propertiesEditionObject != null) {
						groupEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						group.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastGroup.group, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
					}
				}
				
		// End of user code

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
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#getGroupToAdd()
	 * 
	 */
	public List getGroupToAdd() {
		return groupEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#getGroupToRemove()
	 * 
	 */
	public List getGroupToRemove() {
		return groupEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#getGroupToEdit()
	 * 
	 */
	public Map getGroupToEdit() {
		return groupEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#getGroupToMove()
	 * 
	 */
	public List getGroupToMove() {
		return groupEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#getGroupTable()
	 * 
	 */
	public List getGroupTable() {
		return groupEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#initGroup(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initGroup(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			groupEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			groupEditUtil = new EMFListEditUtil(current, feature);
		this.group.setInput(groupEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#updateGroup(EObject newValue)
	 * 
	 */
	public void updateGroup(EObject newValue) {
		if(groupEditUtil != null){
			groupEditUtil.reinit(newValue);
			group.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#addFilterGroup(ViewerFilter filter)
	 * 
	 */
	public void addFilterToGroup(ViewerFilter filter) {
		groupFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#addBusinessFilterGroup(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToGroup(ViewerFilter filter) {
		groupBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart#isContainedInGroupTable(EObject element)
	 * 
	 */
	public boolean isContainedInGroupTable(EObject element) {
		return groupEditUtil.contains(element);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.WorldCupForecastGroup_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
