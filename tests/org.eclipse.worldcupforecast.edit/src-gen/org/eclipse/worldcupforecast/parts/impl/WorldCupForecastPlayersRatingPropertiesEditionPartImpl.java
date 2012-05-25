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
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
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

import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class WorldCupForecastPlayersRatingPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, WorldCupForecastPlayersRatingPropertiesEditionPart {

	protected EMFListEditUtil ratingEditUtil;
	protected TableViewer rating;
	protected List<ViewerFilter> ratingBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ratingFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorldCupForecastPlayersRatingPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createRatingTableComposition(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * @param container
	 * 
	 */
	protected void createRatingTableComposition(Composite container) {
		Composite tableContainer = new Composite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableRating = new org.eclipse.swt.widgets.Table(tableContainer, SWT.FULL_SELECTION);
		tableRating.setHeaderVisible(true);
		GridData gdRating = new GridData();
		gdRating.grabExcessHorizontalSpace = true;
		gdRating.horizontalAlignment = GridData.FILL;
		gdRating.grabExcessVerticalSpace = true;
		gdRating.verticalAlignment = GridData.FILL;
		tableRating.setLayoutData(gdRating);
		tableRating.setLinesVisible(true);
		
		// Start of user code for columns definition for Rating
				TableColumn name = new TableColumn(tableRating, SWT.NONE);
				name.setWidth(80);
				name.setText("Label"); //$NON-NLS-1$		
		// End of user code

		rating = new TableViewer(tableRating);
		rating.setContentProvider(new ArrayContentProvider());
		rating.setLabelProvider(new ITableLabelProvider() {
			//Start of user code for label provider definition for Rating
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
		rating.getTable().addListener(SWT.MouseDoubleClick, new Listener(){

			public void handleEvent(Event event) {
				editRating();
			}
	
		});
		GridData ratingData = new GridData(GridData.FILL_HORIZONTAL);
		ratingData.minimumHeight = 120;
		ratingData.heightHint = 120;
		rating.getTable().setLayoutData(ratingData);
		createRatingPanel(tableContainer);
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRatingPanel(Composite container) {
		Composite ratingPanel = new Composite(container, SWT.NONE);
		GridLayout ratingPanelLayout = new GridLayout();
		ratingPanelLayout.numColumns = 1;
		ratingPanel.setLayout(ratingPanelLayout);
		Button addRating = new Button(ratingPanel, SWT.NONE);
		addRating.setText(WorldcupforecastMessages.PropertiesEditionPart_AddTableViewerLabel);
		GridData addRatingData = new GridData(GridData.FILL_HORIZONTAL);
		addRating.setLayoutData(addRatingData);
		addRating.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addToRating();
			}
		});
		Button removeRating = new Button(ratingPanel, SWT.NONE);
		removeRating.setText(WorldcupforecastMessages.PropertiesEditionPart_RemoveTableViewerLabel);
		GridData removeRatingData = new GridData(GridData.FILL_HORIZONTAL);
		removeRating.setLayoutData(removeRatingData);
		removeRating.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				removeFromRating();
			}

		});
		Button editRating = new Button(ratingPanel, SWT.NONE);
		editRating.setText(WorldcupforecastMessages.PropertiesEditionPart_EditTableViewerLabel);
		GridData editRatingData = new GridData(GridData.FILL_HORIZONTAL);
		editRating.setLayoutData(editRatingData);
		editRating.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				editRating();
			}

		});
		return ratingPanel;
	}

	/**
	 *  
	 */
	protected void addToRating() {
		// Start of user code addToRating() method body
				Player eObject = WorldcupforecastFactory.eINSTANCE.createPlayer();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						ratingEditUtil.addElement(propertiesEditionObject);
						rating.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPlayersRatingPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.rating, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
				
		// End of user code

	}

	/**
	 *  
	 */
	protected void removeFromRating() {
		// Start of user code removeFromRating() method body
				if (rating.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) rating.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						EObject editedElement = ratingEditUtil.foundCorrespondingEObject(selectedElement);
						ratingEditUtil.removeElement(selectedElement);
						rating.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPlayersRatingPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.rating, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
					}
				}
				
		// End of user code

	}

	/**
	 *  
	 */
	protected void editRating() {
		// Start of user code editRating() method body
				if (rating.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) rating.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						EObject editedElement = ratingEditUtil.foundCorrespondingEObject(selectedElement);
						IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(editedElement);
						IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
						if (editionPolicy != null) {
							EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
							if (propertiesEditionObject != null) {
								ratingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
								rating.refresh();
								propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPlayersRatingPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.rating, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#getRatingToAdd()
	 * 
	 */
	public List getRatingToAdd() {
		return ratingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#getRatingToRemove()
	 * 
	 */
	public List getRatingToRemove() {
		return ratingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#getRatingToEdit()
	 * 
	 */
	public Map getRatingToEdit() {
		return ratingEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#getRatingToMove()
	 * 
	 */
	public List getRatingToMove() {
		return ratingEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#getRatingTable()
	 * 
	 */
	public List getRatingTable() {
		return ratingEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#initRating(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRating(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ratingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ratingEditUtil = new EMFListEditUtil(current, feature);
		this.rating.setInput(ratingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#updateRating(EObject newValue)
	 * 
	 */
	public void updateRating(EObject newValue) {
		if(ratingEditUtil != null){
			ratingEditUtil.reinit(newValue);
			rating.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#addFilterRating(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRating(ViewerFilter filter) {
		ratingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#addBusinessFilterRating(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRating(ViewerFilter filter) {
		ratingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart#isContainedInRatingTable(EObject element)
	 * 
	 */
	public boolean isContainedInRatingTable(EObject element) {
		return ratingEditUtil.contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.WorldCupForecastPlayersRating_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
