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
package org.eclipse.emf.samples.conference.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
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
import org.eclipse.emf.samples.conference.ConferenceFactory;
import org.eclipse.emf.samples.conference.Site;
import org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class ConferencePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ConferencePropertiesEditionPart {

	protected Text place;
	protected EMFListEditUtil sitesEditUtil;
	protected ReferencesTable<? extends EObject> sites;
	protected List<ViewerFilter> sitesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> sitesFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil sitesTCEditUtil;
	protected TableViewer sitesTC;
	protected List<ViewerFilter> sitesTCBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> sitesTCFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ConferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
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
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createLocalisationGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createLocalisationGroup(FormToolkit widgetFactory, final Composite view) {
		Section localisationSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		localisationSection.setText(ConferenceMessages.ConferencePropertiesEditionPart_LocalisationGroupLabel);
		GridData localisationSectionData = new GridData(GridData.FILL_HORIZONTAL);
		localisationSectionData.horizontalSpan = 3;
		localisationSection.setLayoutData(localisationSectionData);
		Composite localisationGroup = widgetFactory.createComposite(localisationSection);
		GridLayout localisationGroupLayout = new GridLayout();
		localisationGroupLayout.numColumns = 3;
		localisationGroup.setLayout(localisationGroupLayout);
		createPlaceText(widgetFactory, localisationGroup);
		createSitesTableComposition(widgetFactory, localisationGroup);
		createSitesTCTableComposition(widgetFactory, localisationGroup);
		localisationSection.setClient(localisationGroup);
	}

	protected void createPlaceText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ConferenceMessages.ConferencePropertiesEditionPart_PlaceLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Conference.place, ConferenceViewsRepository.FORM_KIND));
		place = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		place.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData placeData = new GridData(GridData.FILL_HORIZONTAL);
		place.setLayoutData(placeData);
		place.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.place, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, place.getText()));
			}

		});
		place.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.place, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, place.getText()));
			}

		});
		place.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.place, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, place.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Conference.place, ConferenceViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createSitesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.sites = new ReferencesTable<Site>(ConferenceMessages.ConferencePropertiesEditionPart_SitesLabel, new ReferencesTableListener<Site>() {			
			public void handleAdd() { addToSites();}
			public void handleEdit(Site element) { editSites(element); }
			public void handleMove(Site element, int oldIndex, int newIndex) { moveSites(element, oldIndex, newIndex); }
			public void handleRemove(Site element) { removeFromSites(element); }
			public void navigateTo(Site element) { }
		});
		this.sites.setHelpText(propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Conference.sites, ConferenceViewsRepository.FORM_KIND));
		this.sites.createControls(parent, widgetFactory);
		GridData sitesData = new GridData(GridData.FILL_HORIZONTAL);
		sitesData.horizontalSpan = 3;
		this.sites.setLayoutData(sitesData);
		this.sites.setLowerBound(0);
		this.sites.setUpperBound(-1);
	}

	/**
	 * 
	 */
	protected void moveSites(Site element, int oldIndex, int newIndex) {
		EObject editedElement = sitesEditUtil.foundCorrespondingEObject(element);
		sitesEditUtil.moveElement(element, oldIndex, newIndex);
		sites.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToSites() {
		// Start of user code addToSites() method body
		Site eObject = ConferenceFactory.eINSTANCE.createSite();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				sitesEditUtil.addElement(propertiesEditionObject);
				sites.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSites(Site element) {
		// Start of user code for the removeFromSites() method body
		EObject editedElement = sitesEditUtil.foundCorrespondingEObject(element);
		sitesEditUtil.removeElement(element);
		sites.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSites(Site element) {
		// Start of user code editSites() method body
		EObject editedElement = sitesEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				sitesEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				sites.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createSitesTCTableComposition(FormToolkit widgetFactory, Composite container) {
		Composite tableContainer = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableSitesTC = widgetFactory.createTable(tableContainer, SWT.FULL_SELECTION | SWT.BORDER);
		tableSitesTC.setHeaderVisible(true);
		GridData gdSitesTC = new GridData();
		gdSitesTC.grabExcessHorizontalSpace = true;
		gdSitesTC.horizontalAlignment = GridData.FILL;
		gdSitesTC.grabExcessVerticalSpace = true;
		gdSitesTC.verticalAlignment = GridData.FILL;
		tableSitesTC.setLayoutData(gdSitesTC);
		tableSitesTC.setLinesVisible(true);

		// Start of user code for columns definition for SitesTC

		TableColumn name = new TableColumn(tableSitesTC, SWT.NONE);
		name.setWidth(80);
		name.setText("Label"); //$NON-NLS-1$

		// End of user code

		sitesTC = new TableViewer(tableSitesTC);
		sitesTC.setContentProvider(new AdapterFactoryContentProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
			 */
			@Override
			public Object[] getElements(Object object) {
				if (object instanceof Collection)
					return ((Collection) object).toArray();
				else
					return super.getElements(object);
			}
			
		});
		sitesTC.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {

			//Start of user code for label provider definition for SitesTC
			public String getColumnText(Object object, int columnIndex) {
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				if (object instanceof EObject) {
					switch (columnIndex) {
					case 0:
						return labelProvider.getText(object);
					}
				}
				return ""; //$NON-NLS-1$
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
			//End of user code

		});
		sitesTC.getTable().addListener(SWT.MouseDoubleClick, new Listener(){

			public void handleEvent(Event event) {
				editSitesTC();
			}
	
		});

		GridData sitesTCData = new GridData(GridData.FILL_HORIZONTAL);
		sitesTCData.minimumHeight = 120;
		sitesTCData.heightHint = 120;
		sitesTC.getTable().setLayoutData(sitesTCData);
		createSitesTCPanel(widgetFactory, tableContainer);
	}

	/**
	 * @param container
	 */
	protected Composite createSitesTCPanel(FormToolkit widgetFactory, Composite container) {
		Composite sitesTCPanel = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout sitesTCPanelLayout = new GridLayout();
		sitesTCPanelLayout.numColumns = 1;
		sitesTCPanel.setLayout(sitesTCPanelLayout);
		Button addSitesTC = widgetFactory.createButton(sitesTCPanel, ConferenceMessages.PropertiesEditionPart_AddTableViewerLabel, SWT.NONE);
		GridData addSitesTCData = new GridData(GridData.FILL_HORIZONTAL);
		addSitesTC.setLayoutData(addSitesTCData);
		addSitesTC.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addToSitesTC();
			}
		});
		Button removeSitesTC = widgetFactory.createButton(sitesTCPanel, ConferenceMessages.PropertiesEditionPart_RemoveTableViewerLabel, SWT.NONE);
		GridData removeSitesTCData = new GridData(GridData.FILL_HORIZONTAL);
		removeSitesTC.setLayoutData(removeSitesTCData);
		removeSitesTC.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				removeFromSitesTC();
			}

		});
		Button editSitesTC = widgetFactory.createButton(sitesTCPanel, ConferenceMessages.PropertiesEditionPart_EditTableViewerLabel, SWT.NONE);
		GridData editSitesTCData = new GridData(GridData.FILL_HORIZONTAL);
		editSitesTC.setLayoutData(editSitesTCData);
		editSitesTC.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				editSitesTC();
			}

		});
		return sitesTCPanel;
	}

	/**
	 * 
	 */
	protected void addToSitesTC() {
		// Start of user code addToSitesTC() method body

		Site eObject = ConferenceFactory.eINSTANCE.createSite();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				sitesTCEditUtil.addElement(propertiesEditionObject);
				sitesTC.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sitesTC, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSitesTC() {
		// Start of user code for the removeFromSitesTC() method body
		if (sitesTC.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) sitesTC.getSelection();
			EObject editedElement = null;
			if (selection.getFirstElement() instanceof EObject) {
				EObject selectedElement = (EObject) selection.getFirstElement();
				editedElement = sitesTCEditUtil.foundCorrespondingEObject(selectedElement);
				sitesTCEditUtil.removeElement(selectedElement);
			}
			sitesTC.refresh();
			propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sitesTC, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSitesTC() {
		// Start of user code editSitesTC() method body
		if (sitesTC.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) sitesTC.getSelection();
			if (selection.getFirstElement() instanceof EObject) {
				EObject selectedElement = (EObject) selection.getFirstElement();
				EObject editedElement = sitesTCEditUtil.foundCorrespondingEObject(selectedElement);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(selectedElement);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
					if (propertiesEditionObject != null) {
						sitesTCEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						sitesTC.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConferencePropertiesEditionPartForm.this, ConferenceViewsRepository.Conference.sitesTC, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
					}
				}
			}
		}
		// End of user code

	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getPlace()
	 */
	public String getPlace() {
		return place.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#setPlace(String newValue)
	 */
	public void setPlace(String newValue) {
		if (newValue != null) {
			place.setText(newValue);
		} else {
			place.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForPlace(String msg, int msgLevel) {
		messageManager.addMessage("Place_key", msg, null, msgLevel, place);
	}

	public void unsetMessageForPlace() {
		messageManager.removeMessage("Place_key", place);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesToAdd()
	 */
	public List getSitesToAdd() {
		return sitesEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesToRemove()
	 */
	public List getSitesToRemove() {
		return sitesEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesToEdit()
	 */
	public Map getSitesToEdit() {
		return sitesEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesToMove()
	 */
	public List getSitesToMove() {
		return sitesEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesTable()
	 */
	public List getSitesTable() {
		return sitesEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#initSites(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSites(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			sitesEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			sitesEditUtil = new EMFListEditUtil(current, feature);
		this.sites.setInput(sitesEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#updateSites(EObject newValue)
	 */
	public void updateSites(EObject newValue) {
		if(sitesEditUtil != null){
			sitesEditUtil.reinit(newValue);
			sites.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#addFilterSites(ViewerFilter filter)
	 */
	public void addFilterToSites(ViewerFilter filter) {
		sitesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#addBusinessFilterSites(ViewerFilter filter)
	 */
	public void addBusinessFilterToSites(ViewerFilter filter) {
		sitesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#isContainedInSitesTable(EObject element)
	 */
	public boolean isContainedInSitesTable(EObject element) {
		return sitesEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesTCToAdd()
	 */
	public List getSitesTCToAdd() {
		return sitesTCEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesTCToRemove()
	 */
	public List getSitesTCToRemove() {
		return sitesTCEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesTCToEdit()
	 */
	public Map getSitesTCToEdit() {
		return sitesTCEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesTCToMove()
	 */
	public List getSitesTCToMove() {
		return sitesTCEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#getSitesTCTable()
	 */
	public List getSitesTCTable() {
		return sitesTCEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#initSitesTC(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSitesTC(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			sitesTCEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			sitesTCEditUtil = new EMFListEditUtil(current, feature);
		this.sitesTC.setInput(sitesTCEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#updateSitesTC(EObject newValue)
	 */
	public void updateSitesTC(EObject newValue) {
		if(sitesTCEditUtil != null){
			sitesTCEditUtil.reinit(newValue);
			sitesTC.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#addFilterSitesTC(ViewerFilter filter)
	 */
	public void addFilterToSitesTC(ViewerFilter filter) {
		sitesTCFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#addBusinessFilterSitesTC(ViewerFilter filter)
	 */
	public void addBusinessFilterToSitesTC(ViewerFilter filter) {
		sitesTCBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart#isContainedInSitesTCTable(EObject element)
	 */
	public boolean isContainedInSitesTCTable(EObject element) {
		return sitesTCEditUtil.contains(element);
	}










	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return ConferenceMessages.Conference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
