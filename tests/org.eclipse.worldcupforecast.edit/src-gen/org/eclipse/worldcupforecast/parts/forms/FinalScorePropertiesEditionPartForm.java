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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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

import org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class FinalScorePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, FinalScorePropertiesEditionPart {

	protected Text scoreTeam1;
	protected Text scoreTeam2;
	protected Text penaltyScoreTeam1;
	protected Text penaltyScoreTeam2;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FinalScorePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(WorldcupforecastMessages.FinalScorePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createScoreTeam1Text(widgetFactory, propertiesGroup);
		createScoreTeam2Text(widgetFactory, propertiesGroup);
		createPenaltyScoreTeam1Text(widgetFactory, propertiesGroup);
		createPenaltyScoreTeam2Text(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createScoreTeam1Text(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_ScoreTeam1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.scoreTeam1, WorldcupforecastViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam1.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.scoreTeam1, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createScoreTeam2Text(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_ScoreTeam2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.scoreTeam2, WorldcupforecastViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.scoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scoreTeam2.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.scoreTeam2, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createPenaltyScoreTeam1Text(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_PenaltyScoreTeam1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, WorldcupforecastViewsRepository.FORM_KIND));
		penaltyScoreTeam1 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		penaltyScoreTeam1.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData penaltyScoreTeam1Data = new GridData(GridData.FILL_HORIZONTAL);
		penaltyScoreTeam1.setLayoutData(penaltyScoreTeam1Data);
		penaltyScoreTeam1.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam1.getText()));
			}
		});
		penaltyScoreTeam1.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam1.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createPenaltyScoreTeam2Text(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.FinalScorePropertiesEditionPart_PenaltyScoreTeam2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, WorldcupforecastViewsRepository.FORM_KIND));
		penaltyScoreTeam2 = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		penaltyScoreTeam2.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData penaltyScoreTeam2Data = new GridData(GridData.FILL_HORIZONTAL);
		penaltyScoreTeam2.setLayoutData(penaltyScoreTeam2Data);
		penaltyScoreTeam2.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam2.getText()));
			}
		});
		penaltyScoreTeam2.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinalScorePropertiesEditionPartForm.this, WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, penaltyScoreTeam2.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
