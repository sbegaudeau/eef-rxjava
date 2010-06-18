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

import org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;



// End of user code	

/**
 * 
 * 
 */
public class FinalScorePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, FinalScorePropertiesEditionPart {

	protected Text scoreTeam1;
	protected Text scoreTeam2;
	protected Text penaltyScoreTeam1;
	protected Text penaltyScoreTeam2;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FinalScorePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(WorldcupforecastMessages.FinalScorePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createScoreTeam1Text(propertiesGroup);
		createScoreTeam2Text(propertiesGroup);
		createPenaltyScoreTeam1Text(propertiesGroup);
		createPenaltyScoreTeam2Text(propertiesGroup);
	}

	
	protected void createScoreTeam1Text(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_ScoreTeam1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.scoreTeam1, WorldcupforecastViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.scoreTeam1, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createScoreTeam2Text(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_ScoreTeam2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.scoreTeam2, WorldcupforecastViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.scoreTeam2, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createPenaltyScoreTeam1Text(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_PenaltyScoreTeam1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, WorldcupforecastViewsRepository.SWT_KIND));
		penaltyScoreTeam1 = new Text(parent, SWT.BORDER);
		GridData penaltyScoreTeam1Data = new GridData(GridData.FILL_HORIZONTAL);
		penaltyScoreTeam1.setLayoutData(penaltyScoreTeam1Data);
		penaltyScoreTeam1.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam1.getText()));
			}

		});
		penaltyScoreTeam1.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam1.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createPenaltyScoreTeam2Text(Composite parent) {
		SWTUtils.createPartLabel(parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_PenaltyScoreTeam2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, WorldcupforecastViewsRepository.SWT_KIND));
		penaltyScoreTeam2 = new Text(parent, SWT.BORDER);
		GridData penaltyScoreTeam2Data = new GridData(GridData.FILL_HORIZONTAL);
		penaltyScoreTeam2.setLayoutData(penaltyScoreTeam2Data);
		penaltyScoreTeam2.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam2.getText()));
			}

		});
		penaltyScoreTeam2.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartImpl.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam2.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, WorldcupforecastViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#getScoreTeam1()
	 * 
	 */
	public String getScoreTeam1() {
		return scoreTeam1.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#setScoreTeam1(String newValue)
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
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#getScoreTeam2()
	 * 
	 */
	public String getScoreTeam2() {
		return scoreTeam2.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#setScoreTeam2(String newValue)
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
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#getPenaltyScoreTeam1()
	 * 
	 */
	public String getPenaltyScoreTeam1() {
		return penaltyScoreTeam1.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#setPenaltyScoreTeam1(String newValue)
	 * 
	 */
	public void setPenaltyScoreTeam1(String newValue) {
		if (newValue != null) {
			penaltyScoreTeam1.setText(newValue);
		} else {
			penaltyScoreTeam1.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#getPenaltyScoreTeam2()
	 * 
	 */
	public String getPenaltyScoreTeam2() {
		return penaltyScoreTeam2.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart#setPenaltyScoreTeam2(String newValue)
	 * 
	 */
	public void setPenaltyScoreTeam2(String newValue) {
		if (newValue != null) {
			penaltyScoreTeam2.setText(newValue);
		} else {
			penaltyScoreTeam2.setText(""); //$NON-NLS-1$
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.FinalScore_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
