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
import org.eclipse.emf.eef.runtime.impl.policies.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class MatchDayPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MatchDayPropertiesEditionPart {

	protected Text date;
	protected EMFListEditUtil matchesEditUtil;
	protected ReferencesTable<? extends EObject> matches;
	protected List<ViewerFilter> matchesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> matchesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MatchDayPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(WorldcupforecastMessages.MatchDayPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createDateText(propertiesGroup);
		createMatchesAdvancedTableComposition(propertiesGroup);
	}

	
	protected void createDateText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.MatchDayPropertiesEditionPart_DateLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.MatchDay.date, WorldcupforecastViewsRepository.SWT_KIND));
		date = new Text(parent, SWT.BORDER);
		GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		date.setLayoutData(dateData);
		date.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.MatchDay.date, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, date.getText()));
			}

		});
		date.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.MatchDay.date, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, date.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.MatchDay.date, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 * 
	 */
	protected void createMatchesAdvancedTableComposition(Composite parent) {
		this.matches = new ReferencesTable<Match>(WorldcupforecastMessages.MatchDayPropertiesEditionPart_MatchesLabel, new ReferencesTableListener<Match>() {			
			public void handleAdd() { addToMatches();}
			public void handleEdit(Match element) { editMatches(element); }
			public void handleMove(Match element, int oldIndex, int newIndex) { moveMatches(element, oldIndex, newIndex); }
			public void handleRemove(Match element) { removeFromMatches(element); }
			public void navigateTo(Match element) { }
		});
		this.matches.setHelpText(propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.MatchDay.matches, WorldcupforecastViewsRepository.SWT_KIND));
		this.matches.createControls(parent);
		GridData matchesData = new GridData(GridData.FILL_HORIZONTAL);
		matchesData.horizontalSpan = 3;
		this.matches.setLayoutData(matchesData);
		this.matches.setLowerBound(0);
		this.matches.setUpperBound(-1);
	}

	/**
	 *  
	 */
	protected void moveMatches(Match element, int oldIndex, int newIndex) {
	}

	/**
	 *  
	 */
	protected void addToMatches() {
		// Start of user code addToMatches() method body
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(current);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(current);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EReferencePropertiesEditionContext(propertiesEditionComponent, WorldcupforecastPackage.eINSTANCE.getMatchDay_Matches(), resourceSet));
					if (propertiesEditionObject != null) {
						matchesEditUtil.addElement(propertiesEditionObject);
						matches.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.MatchDay.matches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
				
		// End of user code

	}

	/**
	 *  
	 */
	protected void removeFromMatches(Match element) {
		// Start of user code removeFromMatches() method body
				EObject editedElement = matchesEditUtil.foundCorrespondingEObject(element);
				matchesEditUtil.removeElement(element);
				matches.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.MatchDay.matches, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));		
		// End of user code

	}

	/**
	 *  
	 */
	protected void editMatches(Match element) {
		// Start of user code editMatches() method body
				EObject editedElement = matchesEditUtil.foundCorrespondingEObject(element);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
					if (propertiesEditionObject != null) {
						matchesEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						matches.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MatchDayPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.MatchDay.matches, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#getDate()
	 * 
	 */
	public String getDate() {
		return date.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#setDate(String newValue)
	 * 
	 */
	public void setDate(String newValue) {
		if (newValue != null) {
			date.setText(newValue);
		} else {
			date.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#getMatchesToAdd()
	 * 
	 */
	public List getMatchesToAdd() {
		return matchesEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#getMatchesToRemove()
	 * 
	 */
	public List getMatchesToRemove() {
		return matchesEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#getMatchesToEdit()
	 * 
	 */
	public Map getMatchesToEdit() {
		return matchesEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#getMatchesToMove()
	 * 
	 */
	public List getMatchesToMove() {
		return matchesEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#getMatchesTable()
	 * 
	 */
	public List getMatchesTable() {
		return matchesEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#initMatches(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initMatches(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			matchesEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			matchesEditUtil = new EMFListEditUtil(current, feature);
		this.matches.setInput(matchesEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#updateMatches(EObject newValue)
	 * 
	 */
	public void updateMatches(EObject newValue) {
		if(matchesEditUtil != null){
			matchesEditUtil.reinit(newValue);
			matches.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#addFilterMatches(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMatches(ViewerFilter filter) {
		matchesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#addBusinessFilterMatches(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMatches(ViewerFilter filter) {
		matchesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.MatchDayPropertiesEditionPart#isContainedInMatchesTable(EObject element)
	 * 
	 */
	public boolean isContainedInMatchesTable(EObject element) {
		return matchesEditUtil.contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.MatchDay_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
