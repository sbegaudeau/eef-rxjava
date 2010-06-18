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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.helper.PlayerHelper;
import org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class WorldCupForecastPlayersRatingPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, WorldCupForecastPlayersRatingPropertiesEditionPart {

	protected EMFListEditUtil ratingEditUtil;
		protected TableViewer rating;
		protected List<ViewerFilter> ratingBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> ratingFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorldCupForecastPlayersRatingPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createRatingTableComposition(widgetFactory, view);

		// Start of user code for additional ui definition
		
		ViewerSorter sorter = new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
				e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
				if(((Player)e1).getScore() > ((Player)e2).getScore()) {
					return -1;
				}
				else if(((Player)e1).getScore() < ((Player)e2).getScore()) {
					return 1;
				}
				return 0;
			}
			
		};
		rating.setSorter(sorter);
		
		// End of user code
	}
	/**
	 * @param container
	 * 
	 */
	protected void createRatingTableComposition(FormToolkit widgetFactory, Composite container) {
		Composite tableContainer = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableRating = widgetFactory.createTable(tableContainer, SWT.FULL_SELECTION | SWT.BORDER);
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
				name.addSelectionListener(new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						ViewerSorter sorter = new ViewerSorter() {
							@Override
							public int compare(Viewer viewer, Object e1, Object e2) {
								e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
								e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
								return ((Player)e1).getName().compareTo(((Player)e2).getName());
							}
							
						};
						rating.setSorter(sorter);
						
					}
					
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				name.setWidth(200);
				name.setText("Player name"); //$NON-NLS-1$
				
				TableColumn score = new TableColumn(tableRating, SWT.NONE);
				score.addSelectionListener(new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						ViewerSorter sorter = new ViewerSorter() {
							@Override
							public int compare(Viewer viewer, Object e1, Object e2) {
								e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
								e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
								if(((Player)e1).getScore() > ((Player)e2).getScore()) {
									return -1;
								}
								else if(((Player)e1).getScore() < ((Player)e2).getScore()) {
									return 1;
								}
								return 0;
							}
							
						};
						rating.setSorter(sorter);
						
					}
					
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				score.setWidth(60);
				score.setText("Score");

				TableColumn goodwinner = new TableColumn(tableRating, SWT.NONE);
				goodwinner.setWidth(180);
				goodwinner.addSelectionListener(new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						ViewerSorter sorter = new ViewerSorter() {
							@Override
							public int compare(Viewer viewer, Object e1, Object e2) {
								e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
								e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
								
								if(PlayerHelper.getGoodWinnerForecastNumber((Player)e1) > PlayerHelper.getGoodWinnerForecastNumber((Player)e2)) {
									return -1;
								}
								else if(PlayerHelper.getGoodWinnerForecastNumber((Player)e1) < PlayerHelper.getGoodWinnerForecastNumber((Player)e2)) {
									return 1;
								}
								return 0;
							}
							
						};
						rating.setSorter(sorter);
						
					}
					
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				goodwinner.setText("Good winner forecasts");
				
				TableColumn goodwinnerPercent = new TableColumn(tableRating, SWT.NONE);
				goodwinnerPercent.addSelectionListener(new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						ViewerSorter sorter = new ViewerSorter() {
							@Override
							public int compare(Viewer viewer, Object e1, Object e2) {
								e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
								e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
								
								if(PlayerHelper.getGoodWinnerForecastNumberPercent((Player)e1).floatValue() > PlayerHelper.getGoodWinnerForecastNumberPercent((Player)e2).floatValue()) {
									return -1;
								}
								else if(PlayerHelper.getGoodWinnerForecastNumberPercent((Player)e1).floatValue() < PlayerHelper.getGoodWinnerForecastNumberPercent((Player)e2).floatValue()) {
									return 1;
								}
								return 0;
							}
							
						};
						rating.setSorter(sorter);
						
					}
					
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				goodwinnerPercent.setWidth(80);
				goodwinnerPercent.setText("Percent");
				
				TableColumn perfect = new TableColumn(tableRating, SWT.NONE);
				perfect.addSelectionListener(new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						ViewerSorter sorter = new ViewerSorter() {
							@Override
							public int compare(Viewer viewer, Object e1, Object e2) {
								e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
								e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
								
								if(PlayerHelper.getPerfectForecastNumber((Player)e1) > PlayerHelper.getPerfectForecastNumber((Player)e2)) {
									return -1;
								}
								else if(PlayerHelper.getPerfectForecastNumber((Player)e1) < PlayerHelper.getPerfectForecastNumber((Player)e2)) {
									return 1;
								}
								return 0;
							}
							
						};
						rating.setSorter(sorter);
						
					}
					
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				perfect.setWidth(180);
				perfect.setText("Perfect forecasts");
				
				TableColumn perfectPercent = new TableColumn(tableRating, SWT.NONE);
				perfectPercent.addSelectionListener(new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						ViewerSorter sorter = new ViewerSorter() {
							@Override
							public int compare(Viewer viewer, Object e1, Object e2) {
								e1 = ratingEditUtil.foundCorrespondingEObject((EObject)e1);
								e2 = ratingEditUtil.foundCorrespondingEObject((EObject)e2);
								
								if(PlayerHelper.getPerfectForecastNumberPercent((Player)e1).floatValue() > PlayerHelper.getPerfectForecastNumberPercent((Player)e2).floatValue()) {
									return -1;
								}
								else if(PlayerHelper.getPerfectForecastNumberPercent((Player)e1).floatValue() < PlayerHelper.getPerfectForecastNumberPercent((Player)e2).floatValue()) {
									return 1;
								}
								return 0;
							}
							
						};
						rating.setSorter(sorter);
						
					}
					
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				perfectPercent.setWidth(80);
				perfectPercent.setText("Percent");
		
		// End of user code

		rating = new TableViewer(tableRating);
		rating.setContentProvider(new AdapterFactoryContentProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {

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
		rating.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {
		
			//Start of user code for label provider definition for Rating
						public String getColumnText(Object object, int columnIndex) {
							
							AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
							if (object instanceof EObject) {
								object = ratingEditUtil.foundCorrespondingEObject((EObject)object);
								switch (columnIndex) {
								case 0:
									if(object instanceof Player)
										return ((Player) object).getName();
									return labelProvider.getText(object);
								
								case 1:
									if(object instanceof Player) {
										Player player = (Player)  object;
										return new Integer(player.getScore()).toString();
									}
									return "";
								
								case 2:
									if(object instanceof Player) {
										Player player = (Player)  object;
										return new Integer(player.goodForecastNumber()).toString();
									}
									return "";
								
								case 3:
									if(object instanceof Player) {
										Player player = (Player)  object;
										return PlayerHelper.getGoodWinnerForecastNumberPercent(player).toString();
										
									}
									return "";

								case 4:
									if(object instanceof Player) {
										Player player = (Player)  object;
										return new Integer(player.perfectForecastsNumber()).toString();
									}
									return "";
								
							case 5:
								if(object instanceof Player) {
									Player player = (Player)  object;
									return PlayerHelper.getPerfectForecastNumberPercent(player).toString();
								}
								return "";
							}


							}
							return ""; //$NON-NLS-1$
						}
			
						public Image getColumnImage(Object element, int columnIndex) {
							AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
							if (element instanceof EObject) {
								switch (columnIndex) {
								case 0:
									return labelProvider.getImage(element);
								}
							}
							return null; //$NON-NLS-1$
						}
						
			//End of user code

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
		createRatingPanel(widgetFactory, tableContainer);
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRatingPanel(FormToolkit widgetFactory, Composite container) {
		Composite ratingPanel = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout ratingPanelLayout = new GridLayout();
		ratingPanelLayout.numColumns = 1;
		ratingPanel.setLayout(ratingPanelLayout);
		Button addRating = widgetFactory.createButton(ratingPanel, WorldcupforecastMessages.PropertiesEditionPart_AddTableViewerLabel, SWT.NONE);
		GridData addRatingData = new GridData(GridData.FILL_HORIZONTAL);
		addRating.setLayoutData(addRatingData);
		addRating.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				addToRating();
			}
		});
		Button removeRating = widgetFactory.createButton(ratingPanel, WorldcupforecastMessages.PropertiesEditionPart_RemoveTableViewerLabel, SWT.NONE);
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
		Button editRating = widgetFactory.createButton(ratingPanel, WorldcupforecastMessages.PropertiesEditionPart_EditTableViewerLabel, SWT.NONE);
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPlayersRatingPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.rating, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
				
		// End of user code
	}

	/**
	 * 
	 */
	protected void removeFromRating() {
		// Start of user code for the removeFromRating() method body
				if (rating.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) rating.getSelection();
					EObject editedElement = null;
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						editedElement = ratingEditUtil.foundCorrespondingEObject(selectedElement);
						ratingEditUtil.removeElement(selectedElement);
					}
					rating.refresh();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPlayersRatingPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.rating, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
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
						IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(selectedElement);
						IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
						if (editionPolicy != null) {
							EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
							if (propertiesEditionObject != null) {
								ratingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
								rating.refresh();
								propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPlayersRatingPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.rating, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
