/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart;
import java.util.Map;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.eef.nonreg.Site;



import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class EclipseSummitPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EclipseSummitPropertiesEditionPart {

	protected Text place;
	protected EMFListEditUtil sitesEditUtil;
	protected ReferencesTable<?> sites;
	protected List<ViewerFilter> sitesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> sitesFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EclipseSummitPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createPropertiesGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(NonregMessages.EclipseSummitPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createPlaceText(widgetFactory, propertiesGroup);
		createSitesTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}
	protected void createPlaceText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.EclipseSummitPropertiesEditionPart_PlaceLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.EclipseSummit.place, NonregViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.place, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, place.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.place, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, place.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.place, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, place.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.EclipseSummit.place, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	/**
	 * @param container
	 */
	protected void createSitesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.sites = new ReferencesTable<Site>(NonregMessages.EclipseSummitPropertiesEditionPart_SitesLabel, new ReferencesTableListener<Site>() {			
			public void handleAdd() { addToSites();}
			public void handleEdit(Site element) { editSites(element); }
			public void handleMove(Site element, int oldIndex, int newIndex) { moveSites(element, oldIndex, newIndex); }
			public void handleRemove(Site element) { removeFromSites(element); }
			public void navigateTo(Site element) { }
		});
		this.sites.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.EclipseSummit.sites, NonregViewsRepository.FORM_KIND));
		this.sites.createControls(parent, widgetFactory);
		GridData sitesData = new GridData(GridData.FILL_HORIZONTAL);
		sitesData.horizontalSpan = 3;
		this.sites.setLayoutData(sitesData);
	}
	
	/**
	 * 
	 */
	protected void moveSites(Site element, int oldIndex, int newIndex) {
		EObject editedElement = sitesEditUtil.foundCorrespondingEObject(element);
		sitesEditUtil.moveElement(element, oldIndex, newIndex);
		sites.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToSites() {
	
		// Start of user code addToSites() method body
		
		
		Site eObject = NonregFactory.eINSTANCE.createSite();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				sitesEditUtil.addElement(propertiesEditionObject);
				sites.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EclipseSummitPropertiesEditionPartForm.this, NonregViewsRepository.EclipseSummit.sites, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#getPlace()
	 */
	public String getPlace() {
		return place.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#setPlace(String newValue)
	 */
	public void setPlace(String newValue) {
		if (newValue != null) {
			place.setText(newValue);
		} else {
			place.setText("");  //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#getSitesToAdd()
	 */
	public List getSitesToAdd() {
		return sitesEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#getSitesToRemove()
	 */
	public List getSitesToRemove() {
		return sitesEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#getSitesToEdit()
	 */
	public Map getSitesToEdit() {
		return sitesEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#getSitesToMove()
	 */
	public List getSitesToMove() {
		return sitesEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#getSitesTable()
	 */
	public List getSitesTable() {
		return sitesEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#initSites(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#updateSites(EObject newValue)
	 */
	public void updateSites(EObject newValue) {
		if(sitesEditUtil!=null){
			sitesEditUtil.reinit(newValue);
			sites.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#addFilterSites(ViewerFilter filter)
	 */
	public void addFilterToSites(ViewerFilter filter) {
		sitesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#addBusinessFilterSites(ViewerFilter filter)
	 */
	public void addBusinessFilterToSites(ViewerFilter filter) {
		sitesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart#isContainedInSitesTable(EObject element)
	 */
	public boolean isContainedInSitesTable(EObject element) {
		return sitesEditUtil.contains(element);
	}











	
	// Start of user code additional methods
	
	// End of user code
}	
