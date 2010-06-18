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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;

// End of user code

/**
 * 
 * 
 */
public class ForecastPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ForecastPropertiesEditionPart {

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
	public ForecastPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createMatchGroup(widgetFactory, view);

		createForecastGroup(widgetFactory, view);

		createForecastScoreGroup(widgetFactory, view);

		// Start of user code for additional ui definition

		// End of user code
	}
	/**
	 * 
	 */
	protected void createMatchGroup(FormToolkit widgetFactory, final Composite view) {
		Section matchSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		matchSection.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_MatchGroupLabel);
		GridData matchSectionData = new GridData(GridData.FILL_HORIZONTAL);
		matchSectionData.horizontalSpan = 3;
		matchSection.setLayoutData(matchSectionData);
		Composite matchGroup = widgetFactory.createComposite(matchSection);
		GridLayout matchGroupLayout = new GridLayout();
		matchGroupLayout.numColumns = 3;
		matchGroup.setLayout(matchGroupLayout);
		createMatchFlatComboViewer(matchGroup, widgetFactory);
		matchSection.setClient(matchGroup);
	}

	/**
	 * @param matchGroup
	 * 
	 */
	protected void createMatchFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_MatchLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.match, WorldcupforecastViewsRepository.FORM_KIND));
		match = new EObjectFlatComboViewer(parent, false);
		match.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		match.setEnabled(false);
		match.setToolTipText(WorldcupforecastMessages.Forecast_ReadOnly);
		GridData matchData = new GridData(GridData.FILL_HORIZONTAL);
		match.setLayoutData(matchData);
		match.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.match, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMatch()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.match, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createForecastGroup(FormToolkit widgetFactory, final Composite view) {
		Section forecastSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		forecastSection.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_ForecastGroupLabel);
		GridData forecastSectionData = new GridData(GridData.FILL_HORIZONTAL);
		forecastSectionData.horizontalSpan = 3;
		forecastSection.setLayoutData(forecastSectionData);
		Composite forecastGroup = widgetFactory.createComposite(forecastSection);
		GridLayout forecastGroupLayout = new GridLayout();
		forecastGroupLayout.numColumns = 3;
		forecastGroup.setLayout(forecastGroupLayout);
		createScoreTeam1Text(widgetFactory, forecastGroup);
		createScoreTeam2Text(widgetFactory, forecastGroup);
		createWinnerFlatComboViewer(forecastGroup, widgetFactory);
		forecastSection.setClient(forecastGroup);
	}

	
	protected void createScoreTeam1Text(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.scoreTeam1, WorldcupforecastViewsRepository.FORM_KIND));
		scoreTeam1 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		scoreTeam1.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData scoreTeam1Data = new GridData(GridData.FILL_HORIZONTAL);
		scoreTeam1.setLayoutData(scoreTeam1Data);
		scoreTeam1.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
			}
		});
		scoreTeam1.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.scoreTeam1, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createScoreTeam2Text(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.scoreTeam2, WorldcupforecastViewsRepository.FORM_KIND));
		scoreTeam2 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		scoreTeam2.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData scoreTeam2Data = new GridData(GridData.FILL_HORIZONTAL);
		scoreTeam2.setLayoutData(scoreTeam2Data);
		scoreTeam2.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
			}
		});
		scoreTeam2.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.scoreTeam2, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param forecastGroup
	 * 
	 */
	protected void createWinnerFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_WinnerLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.winner, WorldcupforecastViewsRepository.FORM_KIND));
		winner = new EObjectFlatComboViewer(parent, true);
		winner.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData winnerData = new GridData(GridData.FILL_HORIZONTAL);
		winner.setLayoutData(winnerData);
		winner.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.winner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWinner()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.winner, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createForecastScoreGroup(FormToolkit widgetFactory, final Composite view) {
		Section forecastScoreSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		forecastScoreSection.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_ForecastScoreGroupLabel);
		GridData forecastScoreSectionData = new GridData(GridData.FILL_HORIZONTAL);
		forecastScoreSectionData.horizontalSpan = 3;
		forecastScoreSection.setLayoutData(forecastScoreSectionData);
		Composite forecastScoreGroup = widgetFactory.createComposite(forecastScoreSection);
		GridLayout forecastScoreGroupLayout = new GridLayout();
		forecastScoreGroupLayout.numColumns = 3;
		forecastScoreGroup.setLayout(forecastScoreGroupLayout);
		createScoreText(widgetFactory, forecastScoreGroup);
		forecastScoreSection.setClient(forecastScoreGroup);
	}

	
	protected void createScoreText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.score, WorldcupforecastViewsRepository.FORM_KIND));
		score = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		score.setEnabled(false);
		score.setToolTipText(WorldcupforecastMessages.Forecast_ReadOnly);
		score.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData scoreData = new GridData(GridData.FILL_HORIZONTAL);
		score.setLayoutData(scoreData);
		score.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
			}
		});
		score.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Forecast.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.score, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
