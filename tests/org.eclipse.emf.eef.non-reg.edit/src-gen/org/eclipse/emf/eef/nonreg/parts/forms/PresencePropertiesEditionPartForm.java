/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Talk;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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

	private EMFListEditUtil assistsEditUtil;
	private ReferencesTable<?> assists;
	protected List<ViewerFilter> assistsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> assistsFilters = new ArrayList<ViewerFilter>();




	
	public PresencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
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
	
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createPresenceGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createPresenceGroup(FormToolkit widgetFactory, final Composite view) {
		Section presenceSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		presenceSection.setText(NonregMessages.PresencePropertiesEditionPart_PresenceGroupLabel);
		GridData presenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		presenceSectionData.horizontalSpan = 3;
		presenceSection.setLayoutData(presenceSectionData);
		Composite presenceGroup = widgetFactory.createComposite(presenceSection);
		GridLayout presenceGroupLayout = new GridLayout();
		presenceGroupLayout.numColumns = 3;
		presenceGroup.setLayout(presenceGroupLayout);
		createAssistsReferencesTable(widgetFactory, presenceGroup);
		presenceSection.setClient(presenceGroup);
	}
	protected void createAssistsReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.assists = new ReferencesTable<Talk>(NonregMessages.PresencePropertiesEditionPart_AssistsLabel, new ReferencesTableListener<Talk>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Talk> dialog = new TabElementTreeSelectionDialog<Talk>(resourceSet, assistsFilters, assistsBusinessFilters,
				"Talk", NonregPackage.eINSTANCE.getTalk()) {
					@Override
					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!assistsEditUtil.getVirtualList().contains(elem))
								assistsEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, NonregViewsRepository.Presence.assists,
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
		this.assists.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.Presence.assists, NonregViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, NonregViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}
	
	/**
	 * 
	 */
	protected void removeFromAssists(Talk element) {

		// Start of user code for the removeFromAssists() method body

		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		assistsEditUtil.removeElement(element);
		assists.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, NonregViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartForm.this, NonregViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#getAssistsToAdd()
	 */
	public List getAssistsToAdd() {
		return assistsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#getAssistsToRemove()
	 */
	public List getAssistsToRemove() {
		return assistsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#getAssistsTable()
	 */
	public List getAssistsTable() {
		return assistsEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#initAssists(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#updateAssists(EObject newValue)
	 */
	public void updateAssists(EObject newValue) {
		if(assistsEditUtil!=null){
			assistsEditUtil.reinit(newValue);
			assists.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#addFilterAssists(ViewerFilter filter)
	 */
	public void addFilterToAssists(ViewerFilter filter) {
		assistsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#addBusinessFilterAssists(ViewerFilter filter)
	 */
	public void addBusinessFilterToAssists(ViewerFilter filter) {
		assistsBusinessFilters.add(filter);
	}











	
	// Start of user code additional methods
 	
	// End of user code
}	
