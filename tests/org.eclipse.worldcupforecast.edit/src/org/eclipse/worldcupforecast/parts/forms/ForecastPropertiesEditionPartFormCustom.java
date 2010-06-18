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
package org.eclipse.worldcupforecast.parts.forms;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.imageviewer.EEFImageViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.provider.WorldcupforecastEditPlugin;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ForecastPropertiesEditionPartFormCustom extends
		ForecastPropertiesEditionPartForm {
	
	private Label labelWinner;
	
	private Label labelscoreteam1;
	private Label labelscoreteam2;
	protected EEFImageViewer pics;
	protected EEFImageViewer pics2;

	public ForecastPropertiesEditionPartFormCustom(
			IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initWinner(ResourceSet allResources, EObject current) {
		// TODO Auto-generated method stub
		super.initWinner(allResources, current);

		try {
			int team1 = Integer.valueOf(getScoreTeam1());
			int team2 = Integer.valueOf(getScoreTeam2());
			if(getMatch() != null) {
				if(team1 > team2) {
					if(((Match)getMatch()).getTeam1() != null) {
						setWinner(((Match)getMatch()).getTeam1());
					}
				}
				else if (team2 > team1) {
					if(((Match)getMatch()).getTeam2() != null) {
						setWinner(((Match)getMatch()).getTeam2());
					}
				}
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	@Override
	public void initMatch(ResourceSet allResources, EObject current) {
		// TODO Auto-generated method stub
		String newValue = null;
		String key = null;
		String newValue2 = null;
		String key2 = null;
		super.initMatch(allResources, current);
		if(current instanceof GroupStageMatch) {
			winner.setVisible(false);
			labelWinner.setVisible(false);
		}
		Match match = ((Forecast) this.current).getMatch();

		String label = WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam1Label;
		String label2 = WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam2Label;
		if (match != null) {
			Team team = match.getTeam1();
			if (team != null) {
				label = team.getName() + " :";
				newValue = team.getPics();
				key = EcoreUtil.getIdentification(team);
			}
			Team team2 = match.getTeam2();
			if (team2 != null) {
				label2 = team2.getName() + " :";
				newValue2 = team2.getPics();
				key2 = EcoreUtil.getIdentification(team2);
			}
		}
		labelscoreteam1.setText(label);
		labelscoreteam2.setText(label2);
		
		if (newValue != null) {
			try {
				URL url = WorldcupforecastEditPlugin.getPlugin().getBundle()
						.getEntry("flags/" + newValue);
				url = FileLocator.toFileURL(url);
				newValue = url.getPath();

				pics.initViewer(key, newValue);
				
				url = WorldcupforecastEditPlugin.getPlugin().getBundle()
				.getEntry("flags/" + newValue2);
				url = FileLocator.toFileURL(url);
				newValue2 = url.getPath();

		pics2.initViewer(key2, newValue2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	@Override
	protected void createWinnerFlatComboViewer(Composite parent,
			FormToolkit widgetFactory) {
		labelWinner = FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastPropertiesEditionPart_WinnerLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Forecast.winner, WorldcupforecastViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastPropertiesEditionPartFormCustom.this, WorldcupforecastViewsRepository.Forecast.winner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWinner()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Forecast.winner, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	
	}
	
	/**
	 * 
	 */
	protected void createPicsImageViewer(FormToolkit widgetFactory,
			Composite parent) {
		/*FormUtils.createPartLabel(widgetFactory, parent,
				WorldcupforecastMessages.TeamPropertiesEditionPart_PicsLabel,
				propertiesEditionComponent.isRequired(
						WorldcupforecastViewsRepository.Team.pics,
						WorldcupforecastViewsRepository.FORM_KIND));*/
		pics = new EEFImageViewer(parent, SWT.BORDER);
		GridData picsData = new GridData();
		// Start of user code for pics layout data customization
		picsData.widthHint = 170;
		picsData.heightHint = 100;
		picsData.horizontalAlignment = SWT.CENTER;
		picsData.verticalAlignment = SWT.CENTER;

		// End of user code
		pics.setLayoutData(picsData);
		FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						WorldcupforecastViewsRepository.Team.pics,
						WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createPics2ImageViewer(FormToolkit widgetFactory,
			Composite parent) {
		/*FormUtils.createPartLabel(widgetFactory, parent,
				WorldcupforecastMessages.TeamPropertiesEditionPart_PicsLabel,
				propertiesEditionComponent.isRequired(
						WorldcupforecastViewsRepository.Team.pics,
						WorldcupforecastViewsRepository.FORM_KIND));*/
		pics2 = new EEFImageViewer(parent, SWT.BORDER);
		GridData picsData = new GridData();
		// Start of user code for pics layout data customization
		picsData.widthHint = 170;
		picsData.heightHint = 100;
		picsData.horizontalAlignment = SWT.CENTER;
		picsData.verticalAlignment = SWT.CENTER;

		// End of user code
		pics2.setLayoutData(picsData);
		FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						WorldcupforecastViewsRepository.Team.pics,
						WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	
	@Override
	protected void createScoreTeam1Text(FormToolkit widgetFactory,
			Composite parent) {
		labelscoreteam1 = FormUtils
		.createPartLabel(
				widgetFactory,
				parent,
				WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam1Label,
				propertiesEditionComponent
						.isRequired(
								WorldcupforecastViewsRepository.Forecast.scoreTeam1,
								WorldcupforecastViewsRepository.FORM_KIND));
		scoreTeam1 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		scoreTeam1
				.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
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
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForecastPropertiesEditionPartFormCustom.this,
									WorldcupforecastViewsRepository.Forecast.scoreTeam1,
									PropertiesEditionEvent.COMMIT,
									PropertiesEditionEvent.SET, null,
									scoreTeam1.getText()));
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
						propertiesEditionComponent
								.firePropertiesChanged(new PropertiesEditionEvent(
										ForecastPropertiesEditionPartFormCustom.this,
										WorldcupforecastViewsRepository.Forecast.scoreTeam1,
										PropertiesEditionEvent.COMMIT,
										PropertiesEditionEvent.SET, null,
										scoreTeam1.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						WorldcupforecastViewsRepository.Forecast.scoreTeam1,
						WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	
	
	
	@Override
	protected void createScoreTeam2Text(FormToolkit widgetFactory,
			Composite parent) {
		labelscoreteam2 = FormUtils
		.createPartLabel(
				widgetFactory,
				parent,
				WorldcupforecastMessages.ForecastPropertiesEditionPart_ScoreTeam2Label,
				propertiesEditionComponent
						.isRequired(
								WorldcupforecastViewsRepository.Forecast.scoreTeam2,
								WorldcupforecastViewsRepository.FORM_KIND));
		scoreTeam2 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		scoreTeam2
				.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
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
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForecastPropertiesEditionPartFormCustom.this,
									WorldcupforecastViewsRepository.Forecast.scoreTeam2,
									PropertiesEditionEvent.COMMIT,
									PropertiesEditionEvent.SET, null,
									scoreTeam2.getText()));
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
						propertiesEditionComponent
								.firePropertiesChanged(new PropertiesEditionEvent(
										ForecastPropertiesEditionPartFormCustom.this,
										WorldcupforecastViewsRepository.Forecast.scoreTeam2,
										PropertiesEditionEvent.COMMIT,
										PropertiesEditionEvent.SET, null,
										scoreTeam2.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						WorldcupforecastViewsRepository.Forecast.scoreTeam2,
						WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	
	
	
	@Override
	protected void createMatchGroup(FormToolkit widgetFactory, Composite view) {
		Section matchSection = widgetFactory.createSection(view,
				Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		matchSection
				.setText(WorldcupforecastMessages.ForecastPropertiesEditionPart_MatchGroupLabel);
		GridData matchSectionData = new GridData(GridData.FILL_HORIZONTAL);
		matchSectionData.horizontalSpan = 3;
		matchSection.setLayoutData(matchSectionData);
		Composite matchGroup = widgetFactory.createComposite(matchSection);
		GridLayout matchGroupLayout = new GridLayout();
		matchGroupLayout.numColumns = 3;
		matchGroup.setLayout(matchGroupLayout);
		createMatchFlatComboViewer(matchGroup, widgetFactory);
		createPicsImageViewer(widgetFactory, matchGroup);
		createPics2ImageViewer(widgetFactory, matchGroup);
		matchSection.setClient(matchGroup);
	}
}
