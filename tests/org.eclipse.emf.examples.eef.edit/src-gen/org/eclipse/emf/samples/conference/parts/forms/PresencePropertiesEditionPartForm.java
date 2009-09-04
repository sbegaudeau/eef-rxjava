/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
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
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.Talk;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * 
 */
public class PresencePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, PresencePropertiesEditionPart {

	protected Button isRegistered;
	private EMFListEditUtil assistsEditUtil;
	protected ReferencesTable<? extends EObject> assists;
	protected List<ViewerFilter> assistsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> assistsFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PresencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createTalksGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	protected void createTalksGroup(FormToolkit widgetFactory, final Composite view) {
		Section talksSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		talksSection.setText(ConferenceMessages.PresencePropertiesEditionPart_TalksGroupLabel);
		GridData talksSectionData = new GridData(GridData.FILL_HORIZONTAL);
		talksSectionData.horizontalSpan = 3;
		talksSection.setLayoutData(talksSectionData);
		Composite talksGroup = widgetFactory.createComposite(talksSection);
		GridLayout talksGroupLayout = new GridLayout();
		talksGroupLayout.numColumns = 3;
		talksGroup.setLayout(talksGroupLayout);
		createIsRegisteredCheckbox(widgetFactory, talksGroup);
		createAssistsReferencesTable(widgetFactory, talksGroup);
		talksSection.setClient(talksGroup);
	}
	protected void createIsRegisteredCheckbox(FormToolkit widgetFactory, Composite parent) {
		isRegistered = widgetFactory.createButton(parent, ConferenceMessages.PresencePropertiesEditionPart_IsRegisteredLabel, SWT.CHECK);
		isRegistered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, ConferenceViewsRepository.Presence.isRegistered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isRegistered.getSelection())));
			}

		});
		GridData isRegisteredData = new GridData(GridData.FILL_HORIZONTAL);
		isRegisteredData.horizontalSpan = 2;
		isRegistered.setLayoutData(isRegisteredData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Presence.isRegistered, ConferenceViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createAssistsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.assists = new ReferencesTable<Talk>(ConferenceMessages.PresencePropertiesEditionPart_AssistsLabel, new ReferencesTableListener<Talk>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Talk> dialog = new TabElementTreeSelectionDialog<Talk>(resourceSet, assistsFilters, assistsBusinessFilters,
				"Talk", ConferencePackage.eINSTANCE.getTalk(), current.eResource()) {
					@Override
					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!assistsEditUtil.getVirtualList().contains(elem))
								assistsEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, ConferenceViewsRepository.Presence.assists,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						assists.refresh();
					}
				};
				dialog.open();
			}
			public void handleEdit(Talk element) { editAssists(element); }
			public void handleMove(Talk element, int oldIndex, int newIndex) { moveAssists(element, oldIndex, newIndex); }
			public void handleRemove(Talk element) { removeFromAssists(element); }
			public void navigateTo(Talk element) { }
		});
		this.assists.setHelpText(propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Presence.assists, ConferenceViewsRepository.FORM_KIND));
		this.assists.createControls(parent, widgetFactory);
		GridData assistsData = new GridData(GridData.FILL_HORIZONTAL);
		assistsData.horizontalSpan = 3;
		this.assists.setLayoutData(assistsData);
		this.assists.disableMove();
	}

	/**
	 * 
	 */
	protected void moveAssists(Talk element, int oldIndex, int newIndex) {
		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		assistsEditUtil.moveElement(element, oldIndex, newIndex);
		assists.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, ConferenceViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromAssists(Talk element) {
		// Start of user code for the removeFromAssists() method body
		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		assistsEditUtil.removeElement(element);
		assists.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, ConferenceViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editAssists(Talk element) {
		// Start of user code editAssists() method body
		
		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				assistsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				assists.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, ConferenceViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#getIsRegistered()
	 */
	public Boolean getIsRegistered() {
		return Boolean.valueOf(isRegistered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#setIsRegistered(Boolean newValue)
	 */
	public void setIsRegistered(Boolean newValue) {
		if (newValue != null) {
			isRegistered.setSelection(newValue.booleanValue());
		} else {
			isRegistered.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#getAssistsToAdd()
	 */
	public List getAssistsToAdd() {
		return assistsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#getAssistsToRemove()
	 */
	public List getAssistsToRemove() {
		return assistsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#getAssistsTable()
	 */
	public List getAssistsTable() {
		return assistsEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#initAssists(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAssists(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			assistsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			assistsEditUtil = new EMFListEditUtil(current, feature);
		this.assists.setInput(assistsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#updateAssists(EObject newValue)
	 */
	public void updateAssists(EObject newValue) {
		if(assistsEditUtil != null){
			assistsEditUtil.reinit(newValue);
			assists.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#addFilterAssists(ViewerFilter filter)
	 */
	public void addFilterToAssists(ViewerFilter filter) {
		assistsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#addBusinessFilterAssists(ViewerFilter filter)
	 */
	public void addBusinessFilterToAssists(ViewerFilter filter) {
		assistsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#isContainedInAssistsTable(EObject element)
	 */
	public boolean isContainedInAssistsTable(EObject element) {
		return assistsEditUtil.contains(element);
	}











	
	// Start of user code additional methods
	
	// End of user code

}	