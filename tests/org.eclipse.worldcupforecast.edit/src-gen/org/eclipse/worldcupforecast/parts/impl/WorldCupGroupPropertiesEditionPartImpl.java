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
package org.eclipse.worldcupforecast.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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

import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class WorldCupGroupPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, WorldCupGroupPropertiesEditionPart {

	protected Text name;
	protected EMFListEditUtil teamsEditUtil;
	protected TableViewer teams;
	protected List<ViewerFilter> teamsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> teamsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorldCupGroupPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(WorldcupforecastMessages.WorldCupGroupPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
		createTeamsTableComposition(propertiesGroup);
	}

	
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.WorldCupGroupPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.WorldCupGroup.name, WorldcupforecastViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupGroup.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupGroup.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.WorldCupGroup.name, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 * 
	 */
	protected void createTeamsTableComposition(Composite container) {
		Composite tableContainer = new Composite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableTeams = new org.eclipse.swt.widgets.Table(tableContainer, SWT.FULL_SELECTION);
		tableTeams.setHeaderVisible(true);
		GridData gdTeams = new GridData();
		gdTeams.grabExcessHorizontalSpace = true;
		gdTeams.horizontalAlignment = GridData.FILL;
		gdTeams.grabExcessVerticalSpace = true;
		gdTeams.verticalAlignment = GridData.FILL;
		tableTeams.setLayoutData(gdTeams);
		tableTeams.setLinesVisible(true);
		
		// Start of user code for columns definition for Teams
				TableColumn name = new TableColumn(tableTeams, SWT.NONE);
				name.setWidth(80);
				name.setText("Label"); //$NON-NLS-1$		
		// End of user code

		teams = new TableViewer(tableTeams);
		teams.setContentProvider(new ArrayContentProvider());
		teams.setLabelProvider(new ITableLabelProvider() {
			//Start of user code for label provider definition for Teams
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
		teams.getTable().addListener(SWT.MouseDoubleClick, new Listener(){

			public void handleEvent(Event event) {
				editTeams();
			}
	
		});
		GridData teamsData = new GridData(GridData.FILL_HORIZONTAL);
		teamsData.minimumHeight = 120;
		teamsData.heightHint = 120;
		teams.getTable().setLayoutData(teamsData);
		createTeamsPanel(tableContainer);
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTeamsPanel(Composite container) {
		Composite teamsPanel = new Composite(container, SWT.NONE);
		GridLayout teamsPanelLayout = new GridLayout();
		teamsPanelLayout.numColumns = 1;
		teamsPanel.setLayout(teamsPanelLayout);
		Button addTeams = new Button(teamsPanel, SWT.NONE);
		addTeams.setText(WorldcupforecastMessages.PropertiesEditionPart_AddTableViewerLabel);
		GridData addTeamsData = new GridData(GridData.FILL_HORIZONTAL);
		addTeams.setLayoutData(addTeamsData);
		addTeams.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addToTeams();
			}
		});
		Button removeTeams = new Button(teamsPanel, SWT.NONE);
		removeTeams.setText(WorldcupforecastMessages.PropertiesEditionPart_RemoveTableViewerLabel);
		GridData removeTeamsData = new GridData(GridData.FILL_HORIZONTAL);
		removeTeams.setLayoutData(removeTeamsData);
		removeTeams.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				removeFromTeams();
			}

		});
		Button editTeams = new Button(teamsPanel, SWT.NONE);
		editTeams.setText(WorldcupforecastMessages.PropertiesEditionPart_EditTableViewerLabel);
		GridData editTeamsData = new GridData(GridData.FILL_HORIZONTAL);
		editTeams.setLayoutData(editTeamsData);
		editTeams.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				editTeams();
			}

		});
		return teamsPanel;
	}

	/**
	 *  
	 */
	protected void addToTeams() {
		// Start of user code addToTeams() method body
				Team eObject = WorldcupforecastFactory.eINSTANCE.createTeam();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						teamsEditUtil.addElement(propertiesEditionObject);
						teams.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupGroup.teams, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
				
		// End of user code

	}

	/**
	 *  
	 */
	protected void removeFromTeams() {
		// Start of user code removeFromTeams() method body
				if (teams.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) teams.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						EObject editedElement = teamsEditUtil.foundCorrespondingEObject(selectedElement);
						teamsEditUtil.removeElement(selectedElement);
						teams.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupGroup.teams, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
					}
				}
				
		// End of user code

	}

	/**
	 *  
	 */
	protected void editTeams() {
		// Start of user code editTeams() method body
				if (teams.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) teams.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						EObject editedElement = teamsEditUtil.foundCorrespondingEObject(selectedElement);
						IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(editedElement);
						IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
						if (editionPolicy != null) {
							EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
							if (propertiesEditionObject != null) {
								teamsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
								teams.refresh();
								propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupGroup.teams, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
							}
						}
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
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#getTeamsToAdd()
	 * 
	 */
	public List getTeamsToAdd() {
		return teamsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#getTeamsToRemove()
	 * 
	 */
	public List getTeamsToRemove() {
		return teamsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#getTeamsToEdit()
	 * 
	 */
	public Map getTeamsToEdit() {
		return teamsEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#getTeamsToMove()
	 * 
	 */
	public List getTeamsToMove() {
		return teamsEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#getTeamsTable()
	 * 
	 */
	public List getTeamsTable() {
		return teamsEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#initTeams(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTeams(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			teamsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			teamsEditUtil = new EMFListEditUtil(current, feature);
		this.teams.setInput(teamsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#updateTeams(EObject newValue)
	 * 
	 */
	public void updateTeams(EObject newValue) {
		if(teamsEditUtil != null){
			teamsEditUtil.reinit(newValue);
			teams.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#addFilterTeams(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTeams(ViewerFilter filter) {
		teamsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#addBusinessFilterTeams(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTeams(ViewerFilter filter) {
		teamsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart#isContainedInTeamsTable(EObject element)
	 * 
	 */
	public boolean isContainedInTeamsTable(EObject element) {
		return teamsEditUtil.contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.WorldCupGroup_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
