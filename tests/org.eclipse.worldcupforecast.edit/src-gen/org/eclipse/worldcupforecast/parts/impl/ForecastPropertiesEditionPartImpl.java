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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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

import org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class ForecastPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ForecastPropertiesEditionPart {

	protected EObjectFlatComboViewer match;
	protected Text scoreTeam1;
	protected Text scoreTeam2;
	protected EObjectFlatComboViewer winner;
	protected Text score;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ForecastPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createMatchGroup(view);

		createForecastGroup(view);

		createForecastScoreGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createMatchGroup(Composite parent) {
		Group matchGroup = new Group(parent, SWT.NONE);
		matchGroup.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_MatchGroupLabel);
		GridData matchGroupData = new GridData(GridData.FILL_HORIZONTAL);
		matchGroupData.horizontalSpan = 3;
		matchGroup.setLayoutData(matchGroupData);
		GridLayout matchGroupLayout = new GridLayout();
		matchGroupLayout.numColumns = 3;
		matchGroup.setLayout(matchGroupLayout);
		createMatchFlatComboViewer(matchGroup);
	}

	/**
	 * @param matchGroup
	 * 
	 */
	protected void createMatchFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_MatchLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.match, WorldcupforecastViewsRepository.SWT_KIND));
		match = new EObjectFlatComboViewer(parent, false);
		match.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		match.setEnabled(false);
		match.setToolTipText(WorldcupforecastMessages.Forecast_ReadOnly);

		match.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.match, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getMatch()));
			}

		});
		GridData matchData = new GridData(GridData.FILL_HORIZONTAL);
		match.setLayoutData(matchData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.match, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createForecastGroup(Composite parent) {
		Group forecastGroup = new Group(parent, SWT.NONE);
		forecastGroup.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_ForecastGroupLabel);
		GridData forecastGroupData = new GridData(GridData.FILL_HORIZONTAL);
		forecastGroupData.horizontalSpan = 3;
		forecastGroup.setLayoutData(forecastGroupData);
		GridLayout forecastGroupLayout = new GridLayout();
		forecastGroupLayout.numColumns = 3;
		forecastGroup.setLayout(forecastGroupLayout);
		createScoreTeam1Text(forecastGroup);
		createScoreTeam2Text(forecastGroup);
		createWinnerFlatComboViewer(forecastGroup);
	}

	
	protected void createScoreTeam1Text(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.scoreTeam1, WorldcupforecastViewsRepository.SWT_KIND));
		scoreTeam1 = new Text(parent, SWT.BORDER);
		GridData scoreTeam1Data = new GridData(GridData.FILL_HORIZONTAL);
		scoreTeam1.setLayoutData(scoreTeam1Data);
		scoreTeam1.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
			}

		});
		scoreTeam1.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.scoreTeam1, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createScoreTeam2Text(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.scoreTeam2, WorldcupforecastViewsRepository.SWT_KIND));
		scoreTeam2 = new Text(parent, SWT.BORDER);
		GridData scoreTeam2Data = new GridData(GridData.FILL_HORIZONTAL);
		scoreTeam2.setLayoutData(scoreTeam2Data);
		scoreTeam2.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
			}

		});
		scoreTeam2.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.scoreTeam2, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param forecastGroup
	 * 
	 */
	protected void createWinnerFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_WinnerLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.winner, WorldcupforecastViewsRepository.SWT_KIND));
		winner = new EObjectFlatComboViewer(parent, true);
		winner.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		winner.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.winner, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getWinner()));
			}

		});
		GridData winnerData = new GridData(GridData.FILL_HORIZONTAL);
		winner.setLayoutData(winnerData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.winner, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createForecastScoreGroup(Composite parent) {
		Group forecastScoreGroup = new Group(parent, SWT.NONE);
		forecastScoreGroup.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_ForecastScoreGroupLabel);
		GridData forecastScoreGroupData = new GridData(GridData.FILL_HORIZONTAL);
		forecastScoreGroupData.horizontalSpan = 3;
		forecastScoreGroup.setLayoutData(forecastScoreGroupData);
		GridLayout forecastScoreGroupLayout = new GridLayout();
		forecastScoreGroupLayout.numColumns = 3;
		forecastScoreGroup.setLayout(forecastScoreGroupLayout);
		createScoreText(forecastScoreGroup);
	}

	
	protected void createScoreText(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.score, WorldcupforecastViewsRepository.SWT_KIND));
		score = new Text(parent, SWT.BORDER);
		score.setEnabled(false);
		score.setToolTipText(WorldcupforecastMessages.Forecast_ReadOnly);
		GridData scoreData = new GridData(GridData.FILL_HORIZONTAL);
		score.setLayoutData(scoreData);
		score.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
			}

		});
		score.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.Forecast.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.score, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#getMatch()
	 * 
	 */
	public EObject getMatch() {
		if (match.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) match.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#initMatch(ResourceSet allResources, EObject current)
	 */
	public void initMatch(ResourceSet allResources, EObject current) {
		match.setInput(allResources);
		if (current != null) {
			match.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setMatch(EObject newValue)
	 * 
	 */
	public void setMatch(EObject newValue) {
		if (newValue != null) {
			match.setSelection(new StructuredSelection(newValue));
		} else {
			match.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setMatchButtonMode(ButtonsModeEnum newValue)
	 */
	public void setMatchButtonMode(ButtonsModeEnum newValue) {
		match.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#addFilterMatch(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMatch(ViewerFilter filter) {
		match.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#addBusinessFilterMatch(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMatch(ViewerFilter filter) {
		match.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#getScoreTeam1()
	 * 
	 */
	public String getScoreTeam1() {
		return scoreTeam1.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setScoreTeam1(String newValue)
	 * 
	 */
	public void setScoreTeam1(String newValue) {
		if (newValue != null) {
			scoreTeam1.setText(newValue);
		} else {
			scoreTeam1.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#getScoreTeam2()
	 * 
	 */
	public String getScoreTeam2() {
		return scoreTeam2.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setScoreTeam2(String newValue)
	 * 
	 */
	public void setScoreTeam2(String newValue) {
		if (newValue != null) {
			scoreTeam2.setText(newValue);
		} else {
			scoreTeam2.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#getWinner()
	 * 
	 */
	public EObject getWinner() {
		if (winner.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) winner.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#initWinner(ResourceSet allResources, EObject current)
	 */
	public void initWinner(ResourceSet allResources, EObject current) {
		winner.setInput(allResources);
		if (current != null) {
			winner.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setWinner(EObject newValue)
	 * 
	 */
	public void setWinner(EObject newValue) {
		if (newValue != null) {
			winner.setSelection(new StructuredSelection(newValue));
		} else {
			winner.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setWinnerButtonMode(ButtonsModeEnum newValue)
	 */
	public void setWinnerButtonMode(ButtonsModeEnum newValue) {
		winner.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#addFilterWinner(ViewerFilter filter)
	 * 
	 */
	public void addFilterToWinner(ViewerFilter filter) {
		winner.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#addBusinessFilterWinner(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToWinner(ViewerFilter filter) {
		winner.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#getScore()
	 * 
	 */
	public String getScore() {
		return score.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart#setScore(String newValue)
	 * 
	 */
	public void setScore(String newValue) {
		if (newValue != null) {
			score.setText(newValue);
		} else {
			score.setText(""); //$NON-NLS-1$
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.Forecast_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
