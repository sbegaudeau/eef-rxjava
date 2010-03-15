/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

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
import org.eclipse.emf.eef.runtime.impl.policies.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.samples.eef.tarot.Bonus;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * 
 * 
 */
public class RoundBonusesPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RoundBonusesPropertiesEditionPart {

	protected EMFListEditUtil bonusesEditUtil;
		protected ReferencesTable<? extends EObject> bonuses;
		protected List<ViewerFilter> bonusesBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> bonusesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RoundBonusesPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		this.messageManager = messageManager;
		createBonusesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createBonusesGroup(FormToolkit widgetFactory, final Composite view) {
		Section bonusesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		bonusesSection.setText(TarotMessages.RoundBonusesPropertiesEditionPart_BonusesGroupLabel);
		GridData bonusesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		bonusesSectionData.horizontalSpan = 3;
		bonusesSection.setLayoutData(bonusesSectionData);
		Composite bonusesGroup = widgetFactory.createComposite(bonusesSection);
		GridLayout bonusesGroupLayout = new GridLayout();
		bonusesGroupLayout.numColumns = 3;
		bonusesGroup.setLayout(bonusesGroupLayout);
		createBonusesTableComposition(widgetFactory, bonusesGroup);
		bonusesSection.setClient(bonusesGroup);
	}

	/**
	 * @param container
	 * 
	 */
	protected void createBonusesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.bonuses = new ReferencesTable<Bonus>(TarotMessages.RoundBonusesPropertiesEditionPart_BonusesLabel, new ReferencesTableListener<Bonus>() {			
			public void handleAdd() { addToBonuses();}
			public void handleEdit(Bonus element) { editBonuses(element); }
			public void handleMove(Bonus element, int oldIndex, int newIndex) { moveBonuses(element, oldIndex, newIndex); }
			public void handleRemove(Bonus element) { removeFromBonuses(element); }
			public void navigateTo(Bonus element) { }
		});
		this.bonuses.setHelpText(propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundBonuses.bonuses, TarotViewsRepository.FORM_KIND));
		this.bonuses.createControls(parent, widgetFactory);
		GridData bonusesData = new GridData(GridData.FILL_HORIZONTAL);
		bonusesData.horizontalSpan = 3;
		this.bonuses.setLayoutData(bonusesData);
		this.bonuses.setLowerBound(0);
		this.bonuses.setUpperBound(-1);
	}

	/**
	 * 
	 */
	protected void moveBonuses(Bonus element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToBonuses() {
		// Start of user code addToBonuses() method body
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(current);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(current);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EReferencePropertiesEditionContext(propertiesEditionComponent, TarotPackage.eINSTANCE.getRound_Bonuses(), resourceSet));
			if (propertiesEditionObject != null) {
				bonusesEditUtil.addElement(propertiesEditionObject);
				bonuses.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundBonusesPropertiesEditionPartForm.this, TarotViewsRepository.RoundBonuses.bonuses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromBonuses(Bonus element) {
		// Start of user code for the removeFromBonuses() method body
		EObject editedElement = bonusesEditUtil.foundCorrespondingEObject(element);
		bonusesEditUtil.removeElement(element);
		bonuses.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundBonusesPropertiesEditionPartForm.this, TarotViewsRepository.RoundBonuses.bonuses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editBonuses(Bonus element) {
		// Start of user code editBonuses() method body
		EObject editedElement = bonusesEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				bonusesEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				bonuses.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundBonusesPropertiesEditionPartForm.this, TarotViewsRepository.RoundBonuses.bonuses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#getBonusesToAdd()
	 * 
	 */
	public List getBonusesToAdd() {
		return bonusesEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#getBonusesToRemove()
	 * 
	 */
	public List getBonusesToRemove() {
		return bonusesEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#getBonusesToEdit()
	 * 
	 */
	public Map getBonusesToEdit() {
		return bonusesEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#getBonusesToMove()
	 * 
	 */
	public List getBonusesToMove() {
		return bonusesEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#getBonusesTable()
	 * 
	 */
	public List getBonusesTable() {
		return bonusesEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#initBonuses(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initBonuses(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			bonusesEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			bonusesEditUtil = new EMFListEditUtil(current, feature);
		this.bonuses.setInput(bonusesEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#updateBonuses(EObject newValue)
	 * 
	 */
	public void updateBonuses(EObject newValue) {
		if(bonusesEditUtil != null){
			bonusesEditUtil.reinit(newValue);
			bonuses.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#addFilterBonuses(ViewerFilter filter)
	 * 
	 */
	public void addFilterToBonuses(ViewerFilter filter) {
		bonusesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#addBusinessFilterBonuses(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToBonuses(ViewerFilter filter) {
		bonusesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart#isContainedInBonusesTable(EObject element)
	 * 
	 */
	public boolean isContainedInBonusesTable(EObject element) {
		return bonusesEditUtil.contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.RoundBonuses_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
