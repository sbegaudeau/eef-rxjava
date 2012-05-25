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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class TeamPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TeamPropertiesEditionPart {

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
	public TeamPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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

		createGroupStageRankGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(WorldcupforecastMessages.TeamPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(widgetFactory, propertiesGroup);
		createPicsImageViewer(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.TeamPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.name, WorldcupforecastViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.name, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createPicsImageViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.TeamPropertiesEditionPart_PicsLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.pics, WorldcupforecastViewsRepository.FORM_KIND));
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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.pics, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPics()));
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.pics, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createGroupStageRankGroup(FormToolkit widgetFactory, final Composite view) {
		Section groupStageRankSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		groupStageRankSection.setText(WorldcupforecastMessages.TeamPropertiesEditionPart_GroupStageRankGroupLabel);
		GridData groupStageRankSectionData = new GridData(GridData.FILL_HORIZONTAL);
		groupStageRankSectionData.horizontalSpan = 3;
		groupStageRankSection.setLayoutData(groupStageRankSectionData);
		Composite groupStageRankGroup = widgetFactory.createComposite(groupStageRankSection);
		GridLayout groupStageRankGroupLayout = new GridLayout();
		groupStageRankGroupLayout.numColumns = 3;
		groupStageRankGroup.setLayout(groupStageRankGroupLayout);
		createPointsText(widgetFactory, groupStageRankGroup);
		createGoalsForText(widgetFactory, groupStageRankGroup);
		createGoalsAgainstText(widgetFactory, groupStageRankGroup);
		createGoalDifferenceText(widgetFactory, groupStageRankGroup);
		groupStageRankSection.setClient(groupStageRankGroup);
	}

	
	protected void createPointsText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.TeamPropertiesEditionPart_PointsLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.points, WorldcupforecastViewsRepository.FORM_KIND));
		points = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		points.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData pointsData = new GridData(GridData.FILL_HORIZONTAL);
		points.setLayoutData(pointsData);
		points.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.points, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, points.getText()));
			}
		});
		points.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.points, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, points.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.points, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGoalsForText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.TeamPropertiesEditionPart_GoalsForLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.goalsFor, WorldcupforecastViewsRepository.FORM_KIND));
		goalsFor = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		goalsFor.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData goalsForData = new GridData(GridData.FILL_HORIZONTAL);
		goalsFor.setLayoutData(goalsForData);
		goalsFor.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.goalsFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsFor.getText()));
			}
		});
		goalsFor.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.goalsFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsFor.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.goalsFor, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGoalsAgainstText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.TeamPropertiesEditionPart_GoalsAgainstLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.goalsAgainst, WorldcupforecastViewsRepository.FORM_KIND));
		goalsAgainst = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		goalsAgainst.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData goalsAgainstData = new GridData(GridData.FILL_HORIZONTAL);
		goalsAgainst.setLayoutData(goalsAgainstData);
		goalsAgainst.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.goalsAgainst, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsAgainst.getText()));
			}
		});
		goalsAgainst.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.goalsAgainst, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalsAgainst.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.goalsAgainst, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createGoalDifferenceText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.TeamPropertiesEditionPart_GoalDifferenceLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.Team.goalDifference, WorldcupforecastViewsRepository.FORM_KIND));
		goalDifference = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		goalDifference.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData goalDifferenceData = new GridData(GridData.FILL_HORIZONTAL);
		goalDifference.setLayoutData(goalDifferenceData);
		goalDifference.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.goalDifference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalDifference.getText()));
			}
		});
		goalDifference.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TeamPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.Team.goalDifference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, goalDifference.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.Team.goalDifference, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
