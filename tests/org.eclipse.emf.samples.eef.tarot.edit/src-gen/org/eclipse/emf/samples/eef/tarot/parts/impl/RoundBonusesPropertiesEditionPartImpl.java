/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code	

/**
 * 
 * 
 */
public class RoundBonusesPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RoundBonusesPropertiesEditionPart {

	protected EMFListEditUtil bonusesEditUtil;
	protected ReferencesTable<? extends EObject> bonuses;
	protected List<ViewerFilter> bonusesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> bonusesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RoundBonusesPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createBonusesGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createBonusesGroup(Composite parent) {
		Group bonusesGroup = new Group(parent, SWT.NONE);
		bonusesGroup.setText(TarotMessages.RoundBonusesPropertiesEditionPart_BonusesGroupLabel);
		GridData bonusesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		bonusesGroupData.horizontalSpan = 3;
		bonusesGroup.setLayoutData(bonusesGroupData);
		GridLayout bonusesGroupLayout = new GridLayout();
		bonusesGroupLayout.numColumns = 3;
		bonusesGroup.setLayout(bonusesGroupLayout);
		createBonusesAdvancedTableComposition(bonusesGroup);
	}

	/**
	 * @param container
	 * 
	 */
	protected void createBonusesAdvancedTableComposition(Composite parent) {
		this.bonuses = new ReferencesTable<Bonus>(TarotMessages.RoundBonusesPropertiesEditionPart_BonusesLabel, new ReferencesTableListener<Bonus>() {			
			public void handleAdd() { addToBonuses();}
			public void handleEdit(Bonus element) { editBonuses(element); }
			public void handleMove(Bonus element, int oldIndex, int newIndex) { moveBonuses(element, oldIndex, newIndex); }
			public void handleRemove(Bonus element) { removeFromBonuses(element); }
			public void navigateTo(Bonus element) { }
		});
		this.bonuses.setHelpText(propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundBonuses.bonuses, TarotViewsRepository.SWT_KIND));
		this.bonuses.createControls(parent);
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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundBonusesPropertiesEditionPartImpl.this, TarotViewsRepository.RoundBonuses.bonuses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code
	}

	/**
	 *  
	 */
	protected void removeFromBonuses(Bonus element) {
		// Start of user code removeFromBonuses() method body
		EObject editedElement = bonusesEditUtil.foundCorrespondingEObject(element);
		bonusesEditUtil.removeElement(element);
		bonuses.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundBonusesPropertiesEditionPartImpl.this, TarotViewsRepository.RoundBonuses.bonuses, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundBonusesPropertiesEditionPartImpl.this, TarotViewsRepository.RoundBonuses.bonuses, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
