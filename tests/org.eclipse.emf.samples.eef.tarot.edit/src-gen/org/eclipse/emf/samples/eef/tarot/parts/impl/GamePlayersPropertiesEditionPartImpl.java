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
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.TarotFactory;
import org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

// End of user code	

/**
 * 
 * 
 */
public class GamePlayersPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GamePlayersPropertiesEditionPart {

	protected EMFListEditUtil playersEditUtil;
	protected ReferencesTable<? extends EObject> players;
	protected List<ViewerFilter> playersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> playersFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public GamePlayersPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createPlayersAdvancedTableComposition(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * @param container
	 * 
	 */
	protected void createPlayersAdvancedTableComposition(Composite parent) {
		this.players = new ReferencesTable<Player>(TarotMessages.GamePlayersPropertiesEditionPart_PlayersLabel, new ReferencesTableListener<Player>() {			
			public void handleAdd() { addToPlayers();}
			public void handleEdit(Player element) { editPlayers(element); }
			public void handleMove(Player element, int oldIndex, int newIndex) { movePlayers(element, oldIndex, newIndex); }
			public void handleRemove(Player element) { removeFromPlayers(element); }
			public void navigateTo(Player element) { }
		});
		this.players.setHelpText(propertiesEditionComponent.getHelpContent(TarotViewsRepository.GamePlayers.players, TarotViewsRepository.SWT_KIND));
		this.players.createControls(parent);
		GridData playersData = new GridData(GridData.FILL_HORIZONTAL);
		playersData.horizontalSpan = 3;
		this.players.setLayoutData(playersData);
		this.players.setLowerBound(3);
		this.players.setUpperBound(5);
	}

	/**
	 *  
	 */
	protected void movePlayers(Player element, int oldIndex, int newIndex) {
		EObject editedElement = playersEditUtil.foundCorrespondingEObject(element);
		playersEditUtil.moveElement(element, oldIndex, newIndex);
		players.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GamePlayersPropertiesEditionPartImpl.this, TarotViewsRepository.GamePlayers.players, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 *  
	 */
	protected void addToPlayers() {
		// Start of user code addToPlayers() method body
		Player eObject = TarotFactory.eINSTANCE.createPlayer();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				playersEditUtil.addElement(propertiesEditionObject);
				players.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GamePlayersPropertiesEditionPartImpl.this, TarotViewsRepository.GamePlayers.players, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 *  
	 */
	protected void removeFromPlayers(Player element) {
		// Start of user code removeFromPlayers() method body
		EObject editedElement = playersEditUtil.foundCorrespondingEObject(element);
		playersEditUtil.removeElement(element);
		players.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GamePlayersPropertiesEditionPartImpl.this, TarotViewsRepository.GamePlayers.players, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 *  
	 */
	protected void editPlayers(Player element) {
		// Start of user code editPlayers() method body
		EObject editedElement = playersEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				playersEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				players.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GamePlayersPropertiesEditionPartImpl.this, TarotViewsRepository.GamePlayers.players, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#getPlayersToAdd()
	 * 
	 */
	public List getPlayersToAdd() {
		return playersEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#getPlayersToRemove()
	 * 
	 */
	public List getPlayersToRemove() {
		return playersEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#getPlayersToEdit()
	 * 
	 */
	public Map getPlayersToEdit() {
		return playersEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#getPlayersToMove()
	 * 
	 */
	public List getPlayersToMove() {
		return playersEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#getPlayersTable()
	 * 
	 */
	public List getPlayersTable() {
		return playersEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#initPlayers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPlayers(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			playersEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			playersEditUtil = new EMFListEditUtil(current, feature);
		this.players.setInput(playersEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#updatePlayers(EObject newValue)
	 * 
	 */
	public void updatePlayers(EObject newValue) {
		if(playersEditUtil != null){
			playersEditUtil.reinit(newValue);
			players.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#addFilterPlayers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPlayers(ViewerFilter filter) {
		playersFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#addBusinessFilterPlayers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPlayers(ViewerFilter filter) {
		playersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart#isContainedInPlayersTable(EObject element)
	 * 
	 */
	public boolean isContainedInPlayersTable(EObject element) {
		return playersEditUtil.contains(element);
	}

	public void setMessageForPlayers(String msg, int msgLevel) {

	}

	public void unsetMessageForPlayers() {

	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.GamePlayers_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
