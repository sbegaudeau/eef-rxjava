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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.imageviewer.EEFImageViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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

import org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class TeamPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TeamPropertiesEditionPart {

	protected Text name;
	protected EEFImageViewer pics;
	protected Text points;
	protected Text goalsFor;
	protected Text goalsAgainst;
	protected Text goalDifference;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TeamPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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

		createGroupStageRankGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(WorldcupforecastMessages.TeamPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
		createPicsImageViewer(propertiesGroup);
	}

	
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.TeamPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.name, WorldcupforecastViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.name, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createPicsImageViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.TeamPropertiesEditionPart_PicsLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.pics, WorldcupforecastViewsRepository.SWT_KIND));
		pics = new EEFImageViewer(parent, SWT.BORDER);
		GridData picsData = new GridData();
		// Start of user code for pics layout data customization
				picsData.widthHint = 170;
				picsData.heightHint = 100;
				picsData.horizontalAlignment = SWT.CENTER;
				picsData.verticalAlignment = SWT.CENTER;
		 		
		// End of user code
		pics.setLayoutData(picsData);
		pics.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.pics, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPics()));
			}
		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.pics, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createGroupStageRankGroup(Composite parent) {
		Group groupStageRankGroup = new Group(parent, SWT.NONE);
		groupStageRankGroup.setText(WorldcupforecastMessages.TeamPropertiesEditionPart_GroupStageRankGroupLabel);
		GridData groupStageRankGroupData = new GridData(GridData.FILL_HORIZONTAL);
		groupStageRankGroupData.horizontalSpan = 3;
		groupStageRankGroup.setLayoutData(groupStageRankGroupData);
		GridLayout groupStageRankGroupLayout = new GridLayout();
		groupStageRankGroupLayout.numColumns = 3;
		groupStageRankGroup.setLayout(groupStageRankGroupLayout);
		createPointsText(groupStageRankGroup);
		createGoalsForText(groupStageRankGroup);
		createGoalsAgainstText(groupStageRankGroup);
		createGoalDifferenceText(groupStageRankGroup);
	}

	
	protected void createPointsText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.TeamPropertiesEditionPart_PointsLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.points, WorldcupforecastViewsRepository.SWT_KIND));
		points = new Text(parent, SWT.BORDER);
		GridData pointsData = new GridData(GridData.FILL_HORIZONTAL);
		points.setLayoutData(pointsData);
		points.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.points, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, points.getText()));
			}

		});
		points.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.points, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, points.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.points, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGoalsForText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.TeamPropertiesEditionPart_GoalsForLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.goalsFor, WorldcupforecastViewsRepository.SWT_KIND));
		goalsFor = new Text(parent, SWT.BORDER);
		GridData goalsForData = new GridData(GridData.FILL_HORIZONTAL);
		goalsFor.setLayoutData(goalsForData);
		goalsFor.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.goalsFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsFor.getText()));
			}

		});
		goalsFor.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.goalsFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsFor.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.goalsFor, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGoalsAgainstText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.TeamPropertiesEditionPart_GoalsAgainstLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.goalsAgainst, WorldcupforecastViewsRepository.SWT_KIND));
		goalsAgainst = new Text(parent, SWT.BORDER);
		GridData goalsAgainstData = new GridData(GridData.FILL_HORIZONTAL);
		goalsAgainst.setLayoutData(goalsAgainstData);
		goalsAgainst.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.goalsAgainst, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsAgainst.getText()));
			}

		});
		goalsAgainst.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.goalsAgainst, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsAgainst.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.goalsAgainst, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGoalDifferenceText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.TeamPropertiesEditionPart_GoalDifferenceLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.goalDifference, WorldcupforecastViewsRepository.SWT_KIND));
		goalDifference = new Text(parent, SWT.BORDER);
		GridData goalDifferenceData = new GridData(GridData.FILL_HORIZONTAL);
		goalDifference.setLayoutData(goalDifferenceData);
		goalDifference.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.goalDifference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalDifference.getText()));
			}

		});
		goalDifference.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Team.goalDifference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalDifference.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.goalDifference, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#getPics()
	 * 
	 */
	public String getPics() {
		ISelection selection = pics.getSelection();
		if (selection instanceof StructuredSelection && ((StructuredSelection)selection).getFirstElement() instanceof String) {
			return (String)((StructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#initPics(String key, String newValue)
	 */
	public void initPics(String key, String newValue) {
		if (newValue != null) {
			pics.initViewer(key, newValue);
		} else {
			pics.initViewer(key, "");  //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#setPics(String newValue)
	 * 
	 */
	public void setPics(String newValue) {
		if (newValue != null) {
			pics.setSelection(new StructuredSelection(newValue));
		} else {
			pics.setSelection(new StructuredSelection(""));  //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#getPoints()
	 * 
	 */
	public String getPoints() {
		return points.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#setPoints(String newValue)
	 * 
	 */
	public void setPoints(String newValue) {
		if (newValue != null) {
			points.setText(newValue);
		} else {
			points.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#getGoalsFor()
	 * 
	 */
	public String getGoalsFor() {
		return goalsFor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#setGoalsFor(String newValue)
	 * 
	 */
	public void setGoalsFor(String newValue) {
		if (newValue != null) {
			goalsFor.setText(newValue);
		} else {
			goalsFor.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#getGoalsAgainst()
	 * 
	 */
	public String getGoalsAgainst() {
		return goalsAgainst.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#setGoalsAgainst(String newValue)
	 * 
	 */
	public void setGoalsAgainst(String newValue) {
		if (newValue != null) {
			goalsAgainst.setText(newValue);
		} else {
			goalsAgainst.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#getGoalDifference()
	 * 
	 */
	public String getGoalDifference() {
		return goalDifference.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart#setGoalDifference(String newValue)
	 * 
	 */
	public void setGoalDifference(String newValue) {
		if (newValue != null) {
			goalDifference.setText(newValue);
		} else {
			goalDifference.setText(""); //$NON-NLS-1$
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.Team_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
