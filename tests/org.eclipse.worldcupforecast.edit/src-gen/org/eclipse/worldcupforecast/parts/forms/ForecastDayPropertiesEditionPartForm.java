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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
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

import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.providers.WorldcupforecastMessages;


// End of user code

/**
 * 
 * 
 */
public class ForecastDayPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ForecastDayPropertiesEditionPart {

	protected Text date;
	protected EMFListEditUtil forecastsEditUtil;
		protected ReferencesTable<? extends EObject> forecasts;
		protected List<ViewerFilter> forecastsBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> forecastsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ForecastDayPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(WorldcupforecastMessages.ForecastDayPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createDateText(widgetFactory, propertiesGroup);
		createForecastsTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createDateText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, WorldcupforecastMessages.ForecastDayPropertiesEditionPart_DateLabel, propertiesEditionComponent.isRequired(WorldcupforecastViewsRepository.ForecastDay.date, WorldcupforecastViewsRepository.FORM_KIND));
		date = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		date.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		date.setLayoutData(dateData);
		date.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastDayPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.ForecastDay.date, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, date.getText()));
			}
		});
		date.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastDayPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.ForecastDay.date, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, date.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.ForecastDay.date, WorldcupforecastViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 * 
	 */
	protected void createForecastsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.forecasts = new ReferencesTable<Forecast>(WorldcupforecastMessages.ForecastDayPropertiesEditionPart_ForecastsLabel, new ReferencesTableListener<Forecast>() {			
			public void handleAdd() { addToForecasts();}
			public void handleEdit(Forecast element) { editForecasts(element); }
			public void handleMove(Forecast element, int oldIndex, int newIndex) { moveForecasts(element, oldIndex, newIndex); }
			public void handleRemove(Forecast element) { removeFromForecasts(element); }
			public void navigateTo(Forecast element) { }
		});
		this.forecasts.setHelpText(propertiesEditionComponent.getHelpContent(WorldcupforecastViewsRepository.ForecastDay.forecasts, WorldcupforecastViewsRepository.FORM_KIND));
		this.forecasts.createControls(parent, widgetFactory);
		GridData forecastsData = new GridData(GridData.FILL_HORIZONTAL);
		forecastsData.horizontalSpan = 3;
		this.forecasts.setLayoutData(forecastsData);
		this.forecasts.setLowerBound(0);
		this.forecasts.setUpperBound(-1);
	}

	/**
	 * 
	 */
	protected void moveForecasts(Forecast element, int oldIndex, int newIndex) {
		EObject editedElement = forecastsEditUtil.foundCorrespondingEObject(element);
		forecastsEditUtil.moveElement(element, oldIndex, newIndex);
		forecasts.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastDayPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.ForecastDay.forecasts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToForecasts() {
		// Start of user code addToForecasts() method body
				Forecast eObject = WorldcupforecastFactory.eINSTANCE.createForecast();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						forecastsEditUtil.addElement(propertiesEditionObject);
						forecasts.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastDayPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.ForecastDay.forecasts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
					}
				}
		
		
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromForecasts(Forecast element) {
		// Start of user code for the removeFromForecasts() method body
				EObject editedElement = forecastsEditUtil.foundCorrespondingEObject(element);
				forecastsEditUtil.removeElement(element);
				forecasts.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastDayPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.ForecastDay.forecasts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
				
		// End of user code

	}

	/**
	 * 
	 */
	protected void editForecasts(Forecast element) {
		// Start of user code editForecasts() method body
				EObject editedElement = forecastsEditUtil.foundCorrespondingEObject(element);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
					if (propertiesEditionObject != null) {
						forecastsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						forecasts.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForecastDayPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.ForecastDay.forecasts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
					}
				}
				
		// End of user code

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
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#getDate()
	 * 
	 */
	public String getDate() {
		return date.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#setDate(String newValue)
	 * 
	 */
	public void setDate(String newValue) {
		if (newValue != null) {
			date.setText(newValue);
		} else {
			date.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#getForecastsToAdd()
	 * 
	 */
	public List getForecastsToAdd() {
		return forecastsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#getForecastsToRemove()
	 * 
	 */
	public List getForecastsToRemove() {
		return forecastsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#getForecastsToEdit()
	 * 
	 */
	public Map getForecastsToEdit() {
		return forecastsEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#getForecastsToMove()
	 * 
	 */
	public List getForecastsToMove() {
		return forecastsEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#getForecastsTable()
	 * 
	 */
	public List getForecastsTable() {
		return forecastsEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#initForecasts(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initForecasts(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			forecastsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			forecastsEditUtil = new EMFListEditUtil(current, feature);
		this.forecasts.setInput(forecastsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#updateForecasts(EObject newValue)
	 * 
	 */
	public void updateForecasts(EObject newValue) {
		if(forecastsEditUtil != null){
			forecastsEditUtil.reinit(newValue);
			forecasts.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#addFilterForecasts(ViewerFilter filter)
	 * 
	 */
	public void addFilterToForecasts(ViewerFilter filter) {
		forecastsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#addBusinessFilterForecasts(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToForecasts(ViewerFilter filter) {
		forecastsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.worldcupforecast.parts.ForecastDayPropertiesEditionPart#isContainedInForecastsTable(EObject element)
	 * 
	 */
	public boolean isContainedInForecastsTable(EObject element) {
		return forecastsEditUtil.contains(element);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return WorldcupforecastMessages.ForecastDay_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
