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
package org.eclipse.worldcupforecast.parts.forms;


import java.util.Collection;


import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;


import org.eclipse.worldcupforecast.Player;

import org.eclipse.worldcupforecast.helper.PlayerHelper;


/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class WorldCupForecastPlayersRatingPropertiesEditionPartFormCustom
		extends WorldCupForecastPlayersRatingPropertiesEditionPartForm {

	public WorldCupForecastPlayersRatingPropertiesEditionPartFormCustom(
			IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void createRatingTableComposition(FormToolkit widgetFactory,
			Composite container) {
		Composite tableContainer = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 1;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableRating = widgetFactory.createTable(tableContainer, SWT.FULL_SELECTION | SWT.BORDER);
		tableRating.setHeaderVisible(true);
		GridData gdRating = new GridData(GridData.FILL_BOTH);
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
	}

}
