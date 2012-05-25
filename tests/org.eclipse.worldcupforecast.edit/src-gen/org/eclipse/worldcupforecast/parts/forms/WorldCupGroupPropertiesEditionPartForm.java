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
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.helper.GroupHelper;
import org.eclipse.worldcupforecast.parts.WorldCupGroupPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class WorldCupGroupPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, WorldCupGroupPropertiesEditionPart {

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
	public WorldCupGroupPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition	
		ViewerSorter sorter = new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return -GroupHelper.compare((Team) teamsEditUtil.foundCorrespondingEObject((EObject) e1),(Team) teamsEditUtil.foundCorrespondingEObject((EObject) e2));
			}
			
		};
		teams.setSorter(sorter);
		
		//teams.getTable().addListener(SWT.MouseDoubleClick, new OpenWizardOnDoubleClick(get));
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(WorldcupforecastMessages.WorldCupGroupPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(widgetFactory, propertiesGroup);
		createTeamsTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.WorldCupGroupPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.WorldCupGroup.name, WorldcupforecastViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupGroup.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupGroup.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.WorldCupGroup.name, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 * 
	 */
	protected void createTeamsTableComposition(FormToolkit widgetFactory, Composite container) {
		Composite tableContainer = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableTeams = widgetFactory.createTable(tableContainer, SWT.FULL_SELECTION | SWT.BORDER);
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
		name.setWidth(120);
		name.setText("Name"); //$NON-NLS-1$
		
		TableColumn points = new TableColumn(tableTeams, SWT.NONE);
		points.setWidth(80);
		points.setText("Points");
		
		TableColumn goalsFor = new TableColumn(tableTeams, SWT.NONE);
		goalsFor.setWidth(80);
		goalsFor.setText("Goals for");
		
		TableColumn goalsAgainst = new TableColumn(tableTeams, SWT.NONE);
		goalsAgainst.setWidth(100);
		goalsAgainst.setText("Goals against");
		
		TableColumn goalDiff = new TableColumn(tableTeams, SWT.NONE);
		goalDiff.setWidth(80);
		goalDiff.setText("Goal difference");
				
		
		// End of user code

		teams = new TableViewer(tableTeams);
		teams.setContentProvider(new AdapterFactoryContentProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
			 * 
			 */
			@Override
			public Object[] getElements(Object object) {
				if (object instanceof Collection)
					return ((Collection) object).toArray();
				else
					return super.getElements(object);
			}
			
		});
		teams.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {
		
			//Start of user code for label provider definition for Teams
						public String getColumnText(Object object, int columnIndex) {
							AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
							if (object instanceof EObject) {
								Team team = (Team) teamsEditUtil.foundCorrespondingEObject((EObject) object);
								switch (columnIndex) {
								case 0:
									return labelProvider.getText(object);
									
								case 1:
									return Integer.toString(team.getPoints());
									
								case 2:
									return Integer.toString(team.getGoalsFor());
									
								case 3:
									return Integer.toString(team.getGoalsAgainst());
									
								case 4:
									return Integer.toString(team.getGoalDifference());
								}
							}
							return ""; //$NON-NLS-1$
						}
			
						public Image getColumnImage(Object element, int columnIndex) {
							
							AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
							if (element instanceof EObject) {
								switch (columnIndex) {
								case 0:
									return labelProvider.getImage(teamsEditUtil.foundCorrespondingEObject((EObject) element));
								}
							}
							return null;
						}
						
			//End of user code

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
		createTeamsPanel(widgetFactory, tableContainer);
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTeamsPanel(FormToolkit widgetFactory, Composite container) {
		Composite teamsPanel = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout teamsPanelLayout = new GridLayout();
		teamsPanelLayout.numColumns = 1;
		teamsPanel.setLayout(teamsPanelLayout);
		Button addTeams = widgetFactory.createButton(teamsPanel, WorldcupforecastMessages.PropertiesEditionPart_AddTableViewerLabel, SWT.NONE);
		GridData addTeamsData = new GridData(GridData.FILL_HORIZONTAL);
		addTeams.setLayoutData(addTeamsData);
		addTeams.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				addToTeams();
			}
		});
		Button removeTeams = widgetFactory.createButton(teamsPanel, WorldcupforecastMessages.PropertiesEditionPart_RemoveTableViewerLabel, SWT.NONE);
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
		Button editTeams = widgetFactory.createButton(teamsPanel, WorldcupforecastMessages.PropertiesEditionPart_EditTableViewerLabel, SWT.NONE);
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupGroup.teams, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
				
		// End of user code
	}

	/**
	 * 
	 */
	protected void removeFromTeams() {
		// Start of user code for the removeFromTeams() method body
				if (teams.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) teams.getSelection();
					EObject editedElement = null;
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						editedElement = teamsEditUtil.foundCorrespondingEObject(selectedElement);
						teamsEditUtil.removeElement(selectedElement);
					}
					teams.refresh();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupGroup.teams, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
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
						IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(selectedElement);
						IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
						if (editionPolicy != null) {
							EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
							if (propertiesEditionObject != null) {
								teamsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
								teams.refresh();
								propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupGroupPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupGroup.teams, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
