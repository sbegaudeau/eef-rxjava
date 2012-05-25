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
package org.eclipse.worldcupforecast.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class WorldCupForecastMatchDayPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, WorldCupForecastMatchDayPropertiesEditionPart {

	protected EMFListEditUtil gameEditUtil;
	protected ReferencesTable<? extends EObject> game;
	protected List<ViewerFilter> gameBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> gameFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorldCupForecastMatchDayPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createGameAdvancedTableComposition(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * @param container
	 * 
	 */
	protected void createGameAdvancedTableComposition(Composite parent) {
		this.game = new ReferencesTable<MatchDay>(WorldcupforecastMessages.WorldCupForecastMatchDayPropertiesEditionPart_GameLabel, new ReferencesTableListener<MatchDay>() {			
			public void handleAdd() { addToGame();}
			public void handleEdit(MatchDay element) { editGame(element); }
			public void handleMove(MatchDay element, int oldIndex, int newIndex) { moveGame(element, oldIndex, newIndex); }
			public void handleRemove(MatchDay element) { removeFromGame(element); }
			public void navigateTo(MatchDay element) { }
		});
		this.game.setHelpText(propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.WorldCupForecastMatchDay.game, WorldcupforecastViewsRepository.SWT_KIND));
		this.game.createControls(parent);
		GridData gameData = new GridData(GridData.FILL_HORIZONTAL);
		gameData.horizontalSpan = 3;
		this.game.setLayoutData(gameData);
		this.game.setLowerBound(0);
		this.game.setUpperBound(-1);
	}

	/**
	 *  
	 */
	protected void moveGame(MatchDay element, int oldIndex, int newIndex) {
		EObject editedElement = gameEditUtil.foundCorrespondingEObject(element);
		gameEditUtil.moveElement(element, oldIndex, newIndex);
		game.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastMatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastMatchDay.game, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 *  
	 */
	protected void addToGame() {
		// Start of user code addToGame() method body
				MatchDay eObject = WorldcupforecastFactory.eINSTANCE.createMatchDay();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						gameEditUtil.addElement(propertiesEditionObject);
						game.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastMatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastMatchDay.game, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
				
		// End of user code

	}

	/**
	 *  
	 */
	protected void removeFromGame(MatchDay element) {
		// Start of user code removeFromGame() method body
				EObject editedElement = gameEditUtil.foundCorrespondingEObject(element);
				gameEditUtil.removeElement(element);
				game.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastMatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastMatchDay.game, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));		
		// End of user code

	}

	/**
	 *  
	 */
	protected void editGame(MatchDay element) {
		// Start of user code editGame() method body
				EObject editedElement = gameEditUtil.foundCorrespondingEObject(element);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
					if (propertiesEditionObject != null) {
						gameEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						game.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastMatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastMatchDay.game, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#getGameToAdd()
	 * 
	 */
	public List getGameToAdd() {
		return gameEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#getGameToRemove()
	 * 
	 */
	public List getGameToRemove() {
		return gameEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#getGameToEdit()
	 * 
	 */
	public Map getGameToEdit() {
		return gameEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#getGameToMove()
	 * 
	 */
	public List getGameToMove() {
		return gameEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#getGameTable()
	 * 
	 */
	public List getGameTable() {
		return gameEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#initGame(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initGame(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			gameEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			gameEditUtil = new EMFListEditUtil(current, feature);
		this.game.setInput(gameEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#updateGame(EObject newValue)
	 * 
	 */
	public void updateGame(EObject newValue) {
		if(gameEditUtil != null){
			gameEditUtil.reinit(newValue);
			game.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#addFilterGame(ViewerFilter filter)
	 * 
	 */
	public void addFilterToGame(ViewerFilter filter) {
		gameFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#addBusinessFilterGame(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToGame(ViewerFilter filter) {
		gameBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart#isContainedInGameTable(EObject element)
	 * 
	 */
	public boolean isContainedInGameTable(EObject element) {
		return gameEditUtil.contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.WorldCupForecastMatchDay_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
