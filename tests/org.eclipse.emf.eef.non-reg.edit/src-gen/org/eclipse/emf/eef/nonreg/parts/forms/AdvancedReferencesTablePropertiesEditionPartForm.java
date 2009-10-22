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
import org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
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

// End of user code

/**
 * 
 */
public class AdvancedReferencesTablePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, AdvancedReferencesTablePropertiesEditionPart {

	private EMFListEditUtil advancedreferencestableEditUtil;
	protected ReferencesTable<? extends EObject> advancedreferencestable;
	protected List<ViewerFilter> advancedreferencestableBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedreferencestableFilters = new ArrayList<ViewerFilter>();
	private EMFListEditUtil advancedreferencestableROEditUtil;
	protected ReferencesTable<? extends EObject> advancedreferencestableRO;
	protected List<ViewerFilter> advancedreferencestableROBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedreferencestableROFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public AdvancedReferencesTablePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
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
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createAdvancedreferencestableReferencesTable(widgetFactory, view);
		createAdvancedreferencestableROReferencesTable(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createAdvancedreferencestableReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.advancedreferencestable = new ReferencesTable<Talk>(NonregMessages.AdvancedReferencesTablePropertiesEditionPart_AdvancedreferencestableLabel, new ReferencesTableListener<Talk>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Talk> dialog = new TabElementTreeSelectionDialog<Talk>(resourceSet, advancedreferencestableFilters, advancedreferencestableBusinessFilters,
				"Talk", NonregPackage.eINSTANCE.getTalk(), current.eResource()) {
					@Override
					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!advancedreferencestableEditUtil.getVirtualList().contains(elem))
								advancedreferencestableEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestable,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						advancedreferencestable.refresh();
					}
				};
				dialog.open();
			}
			public void handleEdit(Talk element) { editAdvancedreferencestable(element); }
			public void handleMove(Talk element, int oldIndex, int newIndex) { moveAdvancedreferencestable(element, oldIndex, newIndex); }
			public void handleRemove(Talk element) { removeFromAdvancedreferencestable(element); }
			public void navigateTo(Talk element) { }
		});
		this.advancedreferencestable.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedReferencesTable.advancedreferencestable, NonregViewsRepository.FORM_KIND));
		this.advancedreferencestable.createControls(parent, widgetFactory);
		GridData advancedreferencestableData = new GridData(GridData.FILL_HORIZONTAL);
		advancedreferencestableData.horizontalSpan = 3;
		this.advancedreferencestable.setLayoutData(advancedreferencestableData);
		this.advancedreferencestable.disableMove();
	}

	/**
	 * 
	 */
	protected void moveAdvancedreferencestable(Talk element, int oldIndex, int newIndex) {
		EObject editedElement = advancedreferencestableEditUtil.foundCorrespondingEObject(element);
		advancedreferencestableEditUtil.moveElement(element, oldIndex, newIndex);
		advancedreferencestable.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedreferencestable(Talk element) {
		// Start of user code for the removeFromAdvancedreferencestable() method body
		EObject editedElement = advancedreferencestableEditUtil.foundCorrespondingEObject(element);
		advancedreferencestableEditUtil.removeElement(element);
		advancedreferencestable.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editAdvancedreferencestable(Talk element) {
		// Start of user code editAdvancedreferencestable() method body
		
		EObject editedElement = advancedreferencestableEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				advancedreferencestableEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				advancedreferencestable.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createAdvancedreferencestableROReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.advancedreferencestableRO = new ReferencesTable<Talk>(NonregMessages.AdvancedReferencesTablePropertiesEditionPart_AdvancedreferencestableROLabel, new ReferencesTableListener<Talk>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Talk> dialog = new TabElementTreeSelectionDialog<Talk>(resourceSet, advancedreferencestableROFilters, advancedreferencestableROBusinessFilters,
				"Talk", NonregPackage.eINSTANCE.getTalk(), current.eResource()) {
					@Override
					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!advancedreferencestableROEditUtil.getVirtualList().contains(elem))
								advancedreferencestableROEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestableRO,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						advancedreferencestableRO.refresh();
					}
				};
				dialog.open();
			}
			public void handleEdit(Talk element) { editAdvancedreferencestableRO(element); }
			public void handleMove(Talk element, int oldIndex, int newIndex) { moveAdvancedreferencestableRO(element, oldIndex, newIndex); }
			public void handleRemove(Talk element) { removeFromAdvancedreferencestableRO(element); }
			public void navigateTo(Talk element) { }
		});
		this.advancedreferencestableRO.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedReferencesTable.advancedreferencestableRO, NonregViewsRepository.FORM_KIND));
		this.advancedreferencestableRO.createControls(parent, widgetFactory);
		advancedreferencestableRO.setEnabled(false);
		advancedreferencestableRO.setToolTipText(NonregMessages.AdvancedReferencesTable_ReadOnly);
		GridData advancedreferencestableROData = new GridData(GridData.FILL_HORIZONTAL);
		advancedreferencestableROData.horizontalSpan = 3;
		this.advancedreferencestableRO.setLayoutData(advancedreferencestableROData);
		this.advancedreferencestableRO.disableMove();
	}

	/**
	 * 
	 */
	protected void moveAdvancedreferencestableRO(Talk element, int oldIndex, int newIndex) {
		EObject editedElement = advancedreferencestableROEditUtil.foundCorrespondingEObject(element);
		advancedreferencestableROEditUtil.moveElement(element, oldIndex, newIndex);
		advancedreferencestableRO.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestableRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedreferencestableRO(Talk element) {
		// Start of user code for the removeFromAdvancedreferencestableRO() method body
		EObject editedElement = advancedreferencestableROEditUtil.foundCorrespondingEObject(element);
		advancedreferencestableROEditUtil.removeElement(element);
		advancedreferencestableRO.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestableRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editAdvancedreferencestableRO(Talk element) {
		// Start of user code editAdvancedreferencestableRO() method body
		
		EObject editedElement = advancedreferencestableROEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				advancedreferencestableROEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				advancedreferencestableRO.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.AdvancedReferencesTable.advancedreferencestableRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#getAdvancedreferencestableToAdd()
	 */
	public List getAdvancedreferencestableToAdd() {
		return advancedreferencestableEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#getAdvancedreferencestableToRemove()
	 */
	public List getAdvancedreferencestableToRemove() {
		return advancedreferencestableEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#getAdvancedreferencestableTable()
	 */
	public List getAdvancedreferencestableTable() {
		return advancedreferencestableEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#initAdvancedreferencestable(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedreferencestable(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			advancedreferencestableEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			advancedreferencestableEditUtil = new EMFListEditUtil(current, feature);
		this.advancedreferencestable.setInput(advancedreferencestableEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#updateAdvancedreferencestable(EObject newValue)
	 */
	public void updateAdvancedreferencestable(EObject newValue) {
		if(advancedreferencestableEditUtil != null){
			advancedreferencestableEditUtil.reinit(newValue);
			advancedreferencestable.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#addFilterAdvancedreferencestable(ViewerFilter filter)
	 */
	public void addFilterToAdvancedreferencestable(ViewerFilter filter) {
		advancedreferencestableFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#addBusinessFilterAdvancedreferencestable(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedreferencestable(ViewerFilter filter) {
		advancedreferencestableBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#isContainedInAdvancedreferencestableTable(EObject element)
	 */
	public boolean isContainedInAdvancedreferencestableTable(EObject element) {
		return advancedreferencestableEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#getAdvancedreferencestableROToAdd()
	 */
	public List getAdvancedreferencestableROToAdd() {
		return advancedreferencestableROEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#getAdvancedreferencestableROToRemove()
	 */
	public List getAdvancedreferencestableROToRemove() {
		return advancedreferencestableROEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#getAdvancedreferencestableROTable()
	 */
	public List getAdvancedreferencestableROTable() {
		return advancedreferencestableROEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#initAdvancedreferencestableRO(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedreferencestableRO(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			advancedreferencestableROEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			advancedreferencestableROEditUtil = new EMFListEditUtil(current, feature);
		this.advancedreferencestableRO.setInput(advancedreferencestableROEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#updateAdvancedreferencestableRO(EObject newValue)
	 */
	public void updateAdvancedreferencestableRO(EObject newValue) {
		if(advancedreferencestableROEditUtil != null){
			advancedreferencestableROEditUtil.reinit(newValue);
			advancedreferencestableRO.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#addFilterAdvancedreferencestableRO(ViewerFilter filter)
	 */
	public void addFilterToAdvancedreferencestableRO(ViewerFilter filter) {
		advancedreferencestableROFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#addBusinessFilterAdvancedreferencestableRO(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedreferencestableRO(ViewerFilter filter) {
		advancedreferencestableROBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart#isContainedInAdvancedreferencestableROTable(EObject element)
	 */
	public boolean isContainedInAdvancedreferencestableROTable(EObject element) {
		return advancedreferencestableROEditUtil.contains(element);
	}










	// Start of user code additional methods
	
	// End of user code

}
