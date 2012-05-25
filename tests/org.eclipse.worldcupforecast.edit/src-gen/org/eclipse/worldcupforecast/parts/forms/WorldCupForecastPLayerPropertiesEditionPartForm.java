/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class WorldCupForecastPLayerPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, WorldCupForecastPLayerPropertiesEditionPart {

	protected EMFListEditUtil playerEditUtil;
		protected ReferencesTable<? extends EObject> player;
		protected List<ViewerFilter> playerBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> playerFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorldCupForecastPLayerPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPlayerTableComposition(widgetFactory, view);

		// Start of user code for additional ui definition

		this.player.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPLayerPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, playerEditUtil.foundCorrespondingEObject((EObject)e.item.getData()), -1));
			}
			
		});
		
		
		// End of user code
	}
	/**
	 * @param container
	 * 
	 */
	protected void createPlayerTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.player = new ReferencesTable<Player>(WorldcupforecastMessages.WorldCupForecastPLayerPropertiesEditionPart_PlayerLabel, new ReferencesTableListener<Player>() {			
			public void handleAdd() { addToPlayer();}
			public void handleEdit(Player element) { editPlayer(element); }
			public void handleMove(Player element, int oldIndex, int newIndex) { movePlayer(element, oldIndex, newIndex); }
			public void handleRemove(Player element) { removeFromPlayer(element); }
			public void navigateTo(Player element) { }
		});
		this.player.setHelpText(propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, WorldcupforecastViewsRepository.FORM_KIND));
		this.player.createControls(parent, widgetFactory);
		GridData playerData = new GridData(GridData.FILL_HORIZONTAL);
		playerData.horizontalSpan = 3;
		this.player.setLayoutData(playerData);
		this.player.setLowerBound(0);
		this.player.setUpperBound(-1);
	}

	/**
	 * 
	 */
	protected void movePlayer(Player element, int oldIndex, int newIndex) {
		EObject editedElement = playerEditUtil.foundCorrespondingEObject(element);
		playerEditUtil.moveElement(element, oldIndex, newIndex);
		player.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPLayerPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToPlayer() {
		// Start of user code addToPlayer() method body
				Player eObject = WorldcupforecastFactory.eINSTANCE.createPlayer();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						playerEditUtil.addElement(propertiesEditionObject);
						player.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPLayerPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
		
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromPlayer(Player element) {
		// Start of user code for the removeFromPlayer() method body
				EObject editedElement = playerEditUtil.foundCorrespondingEObject(element);
				playerEditUtil.removeElement(element);
				player.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPLayerPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
				
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPlayer(Player element) {
		// Start of user code editPlayer() method body
				EObject editedElement = playerEditUtil.foundCorrespondingEObject(element);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
					if (propertiesEditionObject != null) {
						playerEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						player.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPLayerPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#getPlayerToAdd()
	 * 
	 */
	public List getPlayerToAdd() {
		return playerEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#getPlayerToRemove()
	 * 
	 */
	public List getPlayerToRemove() {
		return playerEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#getPlayerToEdit()
	 * 
	 */
	public Map getPlayerToEdit() {
		return playerEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#getPlayerToMove()
	 * 
	 */
	public List getPlayerToMove() {
		return playerEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#getPlayerTable()
	 * 
	 */
	public List getPlayerTable() {
		return playerEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#initPlayer(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPlayer(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			playerEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			playerEditUtil = new EMFListEditUtil(current, feature);
		this.player.setInput(playerEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#updatePlayer(EObject newValue)
	 * 
	 */
	public void updatePlayer(EObject newValue) {
		if(playerEditUtil != null){
			playerEditUtil.reinit(newValue);
			player.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#addFilterPlayer(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPlayer(ViewerFilter filter) {
		playerFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#addBusinessFilterPlayer(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPlayer(ViewerFilter filter) {
		playerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart#isContainedInPlayerTable(EObject element)
	 * 
	 */
	public boolean isContainedInPlayerTable(EObject element) {
		return playerEditUtil.contains(element);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.WorldCupForecastPLayer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
