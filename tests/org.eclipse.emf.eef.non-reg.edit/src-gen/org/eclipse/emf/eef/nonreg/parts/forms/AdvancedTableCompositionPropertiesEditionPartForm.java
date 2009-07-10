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
import org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart;
import java.util.Map;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.Site;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class AdvancedTableCompositionPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, AdvancedTableCompositionPropertiesEditionPart {

	protected EMFListEditUtil advancedtablecompositionEditUtil;
	protected ReferencesTable<? extends EObject> advancedtablecomposition;
	protected List<ViewerFilter> advancedtablecompositionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedtablecompositionFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil advancedtablecompositionROEditUtil;
	protected ReferencesTable<? extends EObject> advancedtablecompositionRO;
	protected List<ViewerFilter> advancedtablecompositionROBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedtablecompositionROFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public AdvancedTableCompositionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createAdvancedtablecompositionTableComposition(widgetFactory, view);
		createAdvancedtablecompositionROTableComposition(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	/**
	 * @param container
	 */
	protected void createAdvancedtablecompositionTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.advancedtablecomposition = new ReferencesTable<Site>(NonregMessages.AdvancedTableCompositionPropertiesEditionPart_AdvancedtablecompositionLabel, new ReferencesTableListener<Site>() {			
			public void handleAdd() { addToAdvancedtablecomposition();}
			public void handleEdit(Site element) { editAdvancedtablecomposition(element); }
			public void handleMove(Site element, int oldIndex, int newIndex) { moveAdvancedtablecomposition(element, oldIndex, newIndex); }
			public void handleRemove(Site element) { removeFromAdvancedtablecomposition(element); }
			public void navigateTo(Site element) { }
		});
		this.advancedtablecomposition.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedTableComposition.advancedtablecomposition, NonregViewsRepository.FORM_KIND));
		this.advancedtablecomposition.createControls(parent, widgetFactory);
		GridData advancedtablecompositionData = new GridData(GridData.FILL_HORIZONTAL);
		advancedtablecompositionData.horizontalSpan = 3;
		this.advancedtablecomposition.setLayoutData(advancedtablecompositionData);
	}

	/**
	 * 
	 */
	protected void moveAdvancedtablecomposition(Site element, int oldIndex, int newIndex) {
		EObject editedElement = advancedtablecompositionEditUtil.foundCorrespondingEObject(element);
		advancedtablecompositionEditUtil.moveElement(element, oldIndex, newIndex);
		advancedtablecomposition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecomposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToAdvancedtablecomposition() {
		// Start of user code addToAdvancedtablecomposition() method body
		Site eObject = NonregFactory.eINSTANCE.createSite();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				advancedtablecompositionEditUtil.addElement(propertiesEditionObject);
				advancedtablecomposition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecomposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedtablecomposition(Site element) {
		// Start of user code for the removeFromAdvancedtablecomposition() method body
		EObject editedElement = advancedtablecompositionEditUtil.foundCorrespondingEObject(element);
		advancedtablecompositionEditUtil.removeElement(element);
		advancedtablecomposition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecomposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code
	}

	/**
	 * 
	 */
	protected void editAdvancedtablecomposition(Site element) {
		// Start of user code editAdvancedtablecomposition() method body
		EObject editedElement = advancedtablecompositionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				advancedtablecompositionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				advancedtablecomposition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecomposition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createAdvancedtablecompositionROTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.advancedtablecompositionRO = new ReferencesTable<Site>(NonregMessages.AdvancedTableCompositionPropertiesEditionPart_AdvancedtablecompositionROLabel, new ReferencesTableListener<Site>() {			
			public void handleAdd() { addToAdvancedtablecompositionRO();}
			public void handleEdit(Site element) { editAdvancedtablecompositionRO(element); }
			public void handleMove(Site element, int oldIndex, int newIndex) { moveAdvancedtablecompositionRO(element, oldIndex, newIndex); }
			public void handleRemove(Site element) { removeFromAdvancedtablecompositionRO(element); }
			public void navigateTo(Site element) { }
		});
		this.advancedtablecompositionRO.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedTableComposition.advancedtablecompositionRO, NonregViewsRepository.FORM_KIND));
		this.advancedtablecompositionRO.createControls(parent, widgetFactory);
		advancedtablecompositionRO.setEnabled(false);
		advancedtablecompositionRO.setToolTipText(NonregMessages.AdvancedTableComposition_ReadOnly);
		GridData advancedtablecompositionROData = new GridData(GridData.FILL_HORIZONTAL);
		advancedtablecompositionROData.horizontalSpan = 3;
		this.advancedtablecompositionRO.setLayoutData(advancedtablecompositionROData);
	}

	/**
	 * 
	 */
	protected void moveAdvancedtablecompositionRO(Site element, int oldIndex, int newIndex) {
		EObject editedElement = advancedtablecompositionROEditUtil.foundCorrespondingEObject(element);
		advancedtablecompositionROEditUtil.moveElement(element, oldIndex, newIndex);
		advancedtablecompositionRO.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecompositionRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToAdvancedtablecompositionRO() {
		// Start of user code addToAdvancedtablecompositionRO() method body
		Site eObject = NonregFactory.eINSTANCE.createSite();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				advancedtablecompositionROEditUtil.addElement(propertiesEditionObject);
				advancedtablecompositionRO.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecompositionRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedtablecompositionRO(Site element) {
		// Start of user code for the removeFromAdvancedtablecompositionRO() method body
		EObject editedElement = advancedtablecompositionROEditUtil.foundCorrespondingEObject(element);
		advancedtablecompositionROEditUtil.removeElement(element);
		advancedtablecompositionRO.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecompositionRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code
	}

	/**
	 * 
	 */
	protected void editAdvancedtablecompositionRO(Site element) {
		// Start of user code editAdvancedtablecompositionRO() method body
		EObject editedElement = advancedtablecompositionROEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				advancedtablecompositionROEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				advancedtablecompositionRO.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedTableComposition.advancedtablecompositionRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionToAdd()
	 */
	public List getAdvancedtablecompositionToAdd() {
		return advancedtablecompositionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionToRemove()
	 */
	public List getAdvancedtablecompositionToRemove() {
		return advancedtablecompositionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionToEdit()
	 */
	public Map getAdvancedtablecompositionToEdit() {
		return advancedtablecompositionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionToMove()
	 */
	public List getAdvancedtablecompositionToMove() {
		return advancedtablecompositionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionTable()
	 */
	public List getAdvancedtablecompositionTable() {
		return advancedtablecompositionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#initAdvancedtablecomposition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedtablecomposition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			advancedtablecompositionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			advancedtablecompositionEditUtil = new EMFListEditUtil(current, feature);
		this.advancedtablecomposition.setInput(advancedtablecompositionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#updateAdvancedtablecomposition(EObject newValue)
	 */
	public void updateAdvancedtablecomposition(EObject newValue) {
		if(advancedtablecompositionEditUtil != null){
			advancedtablecompositionEditUtil.reinit(newValue);
			advancedtablecomposition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#addFilterAdvancedtablecomposition(ViewerFilter filter)
	 */
	public void addFilterToAdvancedtablecomposition(ViewerFilter filter) {
		advancedtablecompositionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#addBusinessFilterAdvancedtablecomposition(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedtablecomposition(ViewerFilter filter) {
		advancedtablecompositionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#isContainedInAdvancedtablecompositionTable(EObject element)
	 */
	public boolean isContainedInAdvancedtablecompositionTable(EObject element) {
		return advancedtablecompositionEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionROToAdd()
	 */
	public List getAdvancedtablecompositionROToAdd() {
		return advancedtablecompositionROEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionROToRemove()
	 */
	public List getAdvancedtablecompositionROToRemove() {
		return advancedtablecompositionROEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionROToEdit()
	 */
	public Map getAdvancedtablecompositionROToEdit() {
		return advancedtablecompositionROEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionROToMove()
	 */
	public List getAdvancedtablecompositionROToMove() {
		return advancedtablecompositionROEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#getAdvancedtablecompositionROTable()
	 */
	public List getAdvancedtablecompositionROTable() {
		return advancedtablecompositionROEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#initAdvancedtablecompositionRO(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedtablecompositionRO(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			advancedtablecompositionROEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			advancedtablecompositionROEditUtil = new EMFListEditUtil(current, feature);
		this.advancedtablecompositionRO.setInput(advancedtablecompositionROEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#updateAdvancedtablecompositionRO(EObject newValue)
	 */
	public void updateAdvancedtablecompositionRO(EObject newValue) {
		if(advancedtablecompositionROEditUtil != null){
			advancedtablecompositionROEditUtil.reinit(newValue);
			advancedtablecompositionRO.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#addFilterAdvancedtablecompositionRO(ViewerFilter filter)
	 */
	public void addFilterToAdvancedtablecompositionRO(ViewerFilter filter) {
		advancedtablecompositionROFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#addBusinessFilterAdvancedtablecompositionRO(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedtablecompositionRO(ViewerFilter filter) {
		advancedtablecompositionROBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedTableCompositionPropertiesEditionPart#isContainedInAdvancedtablecompositionROTable(EObject element)
	 */
	public boolean isContainedInAdvancedtablecompositionROTable(EObject element) {
		return advancedtablecompositionROEditUtil.contains(element);
	}











	
	// Start of user code additional methods
	
	// End of user code
}	
