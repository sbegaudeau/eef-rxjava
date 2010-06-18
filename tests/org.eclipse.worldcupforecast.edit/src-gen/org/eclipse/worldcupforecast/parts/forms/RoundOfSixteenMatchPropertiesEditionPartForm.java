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

import org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class RoundOfSixteenMatchPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RoundOfSixteenMatchPropertiesEditionPart {

	protected Text hours;
	protected Text minutes;
	protected Text coefficient;
	protected EObjectFlatComboViewer team1WinnerOfGroup;
	protected EObjectFlatComboViewer team2RunnerupOfGroup;
	protected EObjectFlatComboViewer team1;
	protected EObjectFlatComboViewer team2;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RoundOfSixteenMatchPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createHoursText(widgetFactory, propertiesGroup);
		createMinutesText(widgetFactory, propertiesGroup);
		createCoefficientText(widgetFactory, propertiesGroup);
		createTeam1WinnerOfGroupFlatComboViewer(propertiesGroup, widgetFactory);
		createTeam2RunnerupOfGroupFlatComboViewer(propertiesGroup, widgetFactory);
		createTeam1FlatComboViewer(propertiesGroup, widgetFactory);
		createTeam2FlatComboViewer(propertiesGroup, widgetFactory);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createHoursText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_HoursLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours, WorldcupforecastViewsRepository.FORM_KIND));
		hours = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		hours.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData hoursData = new GridData(GridData.FILL_HORIZONTAL);
		hours.setLayoutData(hoursData);
		hours.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hours.getText()));
			}
		});
		hours.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hours.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createMinutesText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_MinutesLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes, WorldcupforecastViewsRepository.FORM_KIND));
		minutes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		minutes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData minutesData = new GridData(GridData.FILL_HORIZONTAL);
		minutes.setLayoutData(minutesData);
		minutes.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minutes.getText()));
			}
		});
		minutes.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minutes.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createCoefficientText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_CoefficientLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.coefficient, WorldcupforecastViewsRepository.FORM_KIND));
		coefficient = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		coefficient.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData coefficientData = new GridData(GridData.FILL_HORIZONTAL);
		coefficient.setLayoutData(coefficientData);
		coefficient.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.coefficient, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, coefficient.getText()));
			}
		});
		coefficient.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.coefficient, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, coefficient.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.coefficient, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 * 
	 */
	protected void createTeam1WinnerOfGroupFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_Team1WinnerOfGroupLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1WinnerOfGroup, WorldcupforecastViewsRepository.FORM_KIND));
		team1WinnerOfGroup = new EObjectFlatComboViewer(parent, false);
		team1WinnerOfGroup.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData team1WinnerOfGroupData = new GridData(GridData.FILL_HORIZONTAL);
		team1WinnerOfGroup.setLayoutData(team1WinnerOfGroupData);
		team1WinnerOfGroup.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1WinnerOfGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTeam1WinnerOfGroup()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1WinnerOfGroup, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 * 
	 */
	protected void createTeam2RunnerupOfGroupFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_Team2RunnerupOfGroupLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2RunnerupOfGroup, WorldcupforecastViewsRepository.FORM_KIND));
		team2RunnerupOfGroup = new EObjectFlatComboViewer(parent, false);
		team2RunnerupOfGroup.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData team2RunnerupOfGroupData = new GridData(GridData.FILL_HORIZONTAL);
		team2RunnerupOfGroup.setLayoutData(team2RunnerupOfGroupData);
		team2RunnerupOfGroup.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2RunnerupOfGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTeam2RunnerupOfGroup()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2RunnerupOfGroup, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 * 
	 */
	protected void createTeam1FlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_Team1Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1, WorldcupforecastViewsRepository.FORM_KIND));
		team1 = new EObjectFlatComboViewer(parent, false);
		team1.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		team1.setEnabled(false);
		team1.setToolTipText(WorldcupforecastMessages.RoundOfSixteenMatch_ReadOnly);
		GridData team1Data = new GridData(GridData.FILL_HORIZONTAL);
		team1.setLayoutData(team1Data);
		team1.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTeam1()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 * 
	 */
	protected void createTeam2FlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.RoundOfSixteenMatchPropertiesEditionPart_Team2Label, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2, WorldcupforecastViewsRepository.FORM_KIND));
		team2 = new EObjectFlatComboViewer(parent, false);
		team2.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		team2.setEnabled(false);
		team2.setToolTipText(WorldcupforecastMessages.RoundOfSixteenMatch_ReadOnly);
		GridData team2Data = new GridData(GridData.FILL_HORIZONTAL);
		team2.setLayoutData(team2Data);
		team2.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundOfSixteenMatchPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTeam2()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getHours()
	 * 
	 */
	public String getHours() {
		return hours.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setHours(String newValue)
	 * 
	 */
	public void setHours(String newValue) {
		if (newValue != null) {
			hours.setText(newValue);
		} else {
			hours.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getMinutes()
	 * 
	 */
	public String getMinutes() {
		return minutes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setMinutes(String newValue)
	 * 
	 */
	public void setMinutes(String newValue) {
		if (newValue != null) {
			minutes.setText(newValue);
		} else {
			minutes.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getCoefficient()
	 * 
	 */
	public String getCoefficient() {
		return coefficient.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setCoefficient(String newValue)
	 * 
	 */
	public void setCoefficient(String newValue) {
		if (newValue != null) {
			coefficient.setText(newValue);
		} else {
			coefficient.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getTeam1WinnerOfGroup()
	 * 
	 */
	public EObject getTeam1WinnerOfGroup() {
		if (team1WinnerOfGroup.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) team1WinnerOfGroup.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#initTeam1WinnerOfGroup(ResourceSet allResources, EObject current)
	 */
	public void initTeam1WinnerOfGroup(ResourceSet allResources, EObject current) {
		team1WinnerOfGroup.setInput(allResources);
		if (current != null) {
			team1WinnerOfGroup.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam1WinnerOfGroup(EObject newValue)
	 * 
	 */
	public void setTeam1WinnerOfGroup(EObject newValue) {
		if (newValue != null) {
			team1WinnerOfGroup.setSelection(new StructuredSelection(newValue));
		} else {
			team1WinnerOfGroup.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam1WinnerOfGroupButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTeam1WinnerOfGroupButtonMode(ButtonsModeEnum newValue) {
		team1WinnerOfGroup.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addFilterTeam1WinnerOfGroup(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTeam1WinnerOfGroup(ViewerFilter filter) {
		team1WinnerOfGroup.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addBusinessFilterTeam1WinnerOfGroup(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTeam1WinnerOfGroup(ViewerFilter filter) {
		team1WinnerOfGroup.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getTeam2RunnerupOfGroup()
	 * 
	 */
	public EObject getTeam2RunnerupOfGroup() {
		if (team2RunnerupOfGroup.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) team2RunnerupOfGroup.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#initTeam2RunnerupOfGroup(ResourceSet allResources, EObject current)
	 */
	public void initTeam2RunnerupOfGroup(ResourceSet allResources, EObject current) {
		team2RunnerupOfGroup.setInput(allResources);
		if (current != null) {
			team2RunnerupOfGroup.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam2RunnerupOfGroup(EObject newValue)
	 * 
	 */
	public void setTeam2RunnerupOfGroup(EObject newValue) {
		if (newValue != null) {
			team2RunnerupOfGroup.setSelection(new StructuredSelection(newValue));
		} else {
			team2RunnerupOfGroup.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam2RunnerupOfGroupButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTeam2RunnerupOfGroupButtonMode(ButtonsModeEnum newValue) {
		team2RunnerupOfGroup.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addFilterTeam2RunnerupOfGroup(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTeam2RunnerupOfGroup(ViewerFilter filter) {
		team2RunnerupOfGroup.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addBusinessFilterTeam2RunnerupOfGroup(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTeam2RunnerupOfGroup(ViewerFilter filter) {
		team2RunnerupOfGroup.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getTeam1()
	 * 
	 */
	public EObject getTeam1() {
		if (team1.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) team1.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#initTeam1(ResourceSet allResources, EObject current)
	 */
	public void initTeam1(ResourceSet allResources, EObject current) {
		team1.setInput(allResources);
		if (current != null) {
			team1.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam1(EObject newValue)
	 * 
	 */
	public void setTeam1(EObject newValue) {
		if (newValue != null) {
			team1.setSelection(new StructuredSelection(newValue));
		} else {
			team1.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam1ButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTeam1ButtonMode(ButtonsModeEnum newValue) {
		team1.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addFilterTeam1(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTeam1(ViewerFilter filter) {
		team1.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addBusinessFilterTeam1(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTeam1(ViewerFilter filter) {
		team1.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#getTeam2()
	 * 
	 */
	public EObject getTeam2() {
		if (team2.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) team2.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#initTeam2(ResourceSet allResources, EObject current)
	 */
	public void initTeam2(ResourceSet allResources, EObject current) {
		team2.setInput(allResources);
		if (current != null) {
			team2.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam2(EObject newValue)
	 * 
	 */
	public void setTeam2(EObject newValue) {
		if (newValue != null) {
			team2.setSelection(new StructuredSelection(newValue));
		} else {
			team2.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#setTeam2ButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTeam2ButtonMode(ButtonsModeEnum newValue) {
		team2.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addFilterTeam2(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTeam2(ViewerFilter filter) {
		team2.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart#addBusinessFilterTeam2(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTeam2(ViewerFilter filter) {
		team2.addBusinessRuleFilter(filter);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.RoundOfSixteenMatch_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
