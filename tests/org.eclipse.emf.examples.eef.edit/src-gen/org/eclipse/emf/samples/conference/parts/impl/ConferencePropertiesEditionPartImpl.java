/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.samples.conference.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class ConferencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConferencePropertiesEditionPart {

	protected Text name;
	protected Text overview;
	protected Text place;
protected ReferencesTable sites;
protected List<ViewerFilter> sitesBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> sitesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConferencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conference_Step = new CompositionSequence();
		CompositionStep propertiesStep = conference_Step.addStep(ConferenceViewsRepository.Conference_.Properties.class);
		propertiesStep.addStep(ConferenceViewsRepository.Conference_.Properties.name);
		propertiesStep.addStep(ConferenceViewsRepository.Conference_.Properties.overview);
		
		CompositionStep localisationStep = conference_Step.addStep(ConferenceViewsRepository.Conference_.Localisation.class);
		localisationStep.addStep(ConferenceViewsRepository.Conference_.Localisation.place);
		localisationStep.addStep(ConferenceViewsRepository.Conference_.Localisation.sites);
		
		
		composer = new PartComposer(conference_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ConferenceViewsRepository.Conference_.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ConferenceViewsRepository.Conference_.Properties.name) {
					return createNameText(parent);
				}
				if (key == ConferenceViewsRepository.Conference_.Properties.overview) {
					return createOverviewText(parent);
				}
				if (key == ConferenceViewsRepository.Conference_.Localisation.class) {
					return createLocalisationGroup(parent);
				}
				if (key == ConferenceViewsRepository.Conference_.Localisation.place) {
					return createPlaceText(parent);
				}
				if (key == ConferenceViewsRepository.Conference_.Localisation.sites) {
					return createSitesAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ConferenceMessages.ConferencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.ConferencePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Conference_.Properties.name, ConferenceViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, ConferenceViewsRepository.Conference_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Conference_.Properties.name, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOverviewText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.ConferencePropertiesEditionPart_OverviewLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Conference_.Properties.overview, ConferenceViewsRepository.SWT_KIND));
		overview = new Text(parent, SWT.BORDER);
		GridData overviewData = new GridData(GridData.FILL_HORIZONTAL);
		overview.setLayoutData(overviewData);
		overview.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Properties.overview, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, overview.getText()));
			}

		});
		overview.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Properties.overview, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, overview.getText()));
				}
			}

		});
		EditingUtils.setID(overview, ConferenceViewsRepository.Conference_.Properties.overview);
		EditingUtils.setEEFtype(overview, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Conference_.Properties.overview, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createLocalisationGroup(Composite parent) {
		Group localisationGroup = new Group(parent, SWT.NONE);
		localisationGroup.setText(ConferenceMessages.ConferencePropertiesEditionPart_LocalisationGroupLabel);
		GridData localisationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		localisationGroupData.horizontalSpan = 3;
		localisationGroup.setLayoutData(localisationGroupData);
		GridLayout localisationGroupLayout = new GridLayout();
		localisationGroupLayout.numColumns = 3;
		localisationGroup.setLayout(localisationGroupLayout);
		return localisationGroup;
	}

	
	protected Composite createPlaceText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.ConferencePropertiesEditionPart_PlaceLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Conference_.Localisation.place, ConferenceViewsRepository.SWT_KIND));
		place = new Text(parent, SWT.BORDER);
		GridData placeData = new GridData(GridData.FILL_HORIZONTAL);
		place.setLayoutData(placeData);
		place.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.place, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, place.getText()));
			}

		});
		place.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.place, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, place.getText()));
				}
			}

		});
		EditingUtils.setID(place, ConferenceViewsRepository.Conference_.Localisation.place);
		EditingUtils.setEEFtype(place, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Conference_.Localisation.place, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSitesAdvancedTableComposition(Composite parent) {
		this.sites = new ReferencesTable(ConferenceMessages.ConferencePropertiesEditionPart_SitesLabel, new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				sites.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				sites.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				sites.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				sites.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		this.sites.setHelpText(propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Conference_.Localisation.sites, ConferenceViewsRepository.SWT_KIND));
		this.sites.createControls(parent);
		this.sites.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Conference_.Localisation.sites, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData sitesData = new GridData(GridData.FILL_HORIZONTAL);
		sitesData.horizontalSpan = 3;
		this.sites.setLayoutData(sitesData);
		this.sites.setLowerBound(0);
		this.sites.setUpperBound(-1);
		sites.setID(ConferenceViewsRepository.Conference_.Localisation.sites);
		sites.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
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
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getOverview()
	 * 
	 */
	public String getOverview() {
		return overview.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#setOverview(String newValue)
	 * 
	 */
	public void setOverview(String newValue) {
		if (newValue != null) {
			overview.setText(newValue);
		} else {
			overview.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getPlace()
	 * 
	 */
	public String getPlace() {
		return place.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#setPlace(String newValue)
	 * 
	 */
	public void setPlace(String newValue) {
		if (newValue != null) {
			place.setText(newValue);
		} else {
			place.setText(""); //$NON-NLS-1$
		}
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#initSites(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSites(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		sites.setContentProvider(contentProvider);
		sites.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#updateSites()
	 * 
	 */
	public void updateSites() {
	sites.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#addFilterSites(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSites(ViewerFilter filter) {
		sitesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#addBusinessFilterSites(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSites(ViewerFilter filter) {
		sitesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#isContainedInSitesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSitesTable(EObject element) {
		return ((ReferencesTableSettings)sites.getInput()).contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ConferenceMessages.Conference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
