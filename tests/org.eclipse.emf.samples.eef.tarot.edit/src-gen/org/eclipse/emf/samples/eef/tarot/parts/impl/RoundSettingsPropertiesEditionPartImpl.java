/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 */
public class RoundSettingsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RoundSettingsPropertiesEditionPart {

	protected EObjectFlatComboViewer taker;
	protected EObjectFlatComboViewer partner;
	protected EMFComboViewer bid;
	protected Text extraPoints;
	protected Button won;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public RoundSettingsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
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
	 */
	public void createControls(Composite view) { 
		createPlayersGroup(view);

		createBaseScoreGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPlayersGroup(Composite parent) {
		Group playersGroup = new Group(parent, SWT.NONE);
		playersGroup.setText(TarotMessages.RoundSettingsPropertiesEditionPart_PlayersGroupLabel);
		GridData playersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		playersGroupData.horizontalSpan = 3;
		playersGroup.setLayoutData(playersGroupData);
		GridLayout playersGroupLayout = new GridLayout();
		playersGroupLayout.numColumns = 3;
		playersGroup.setLayout(playersGroupLayout);
		createTakerFlatComboViewer(playersGroup);
		createPartnerFlatComboViewer(playersGroup);
	}

	/**
	 * @param playersGroup
	 */
	protected void createTakerFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.RoundSettingsPropertiesEditionPart_TakerLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.taker, TarotViewsRepository.SWT_KIND));
		taker = new EObjectFlatComboViewer(parent, false);
		taker.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		taker.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartImpl.this, TarotViewsRepository.RoundSettings.taker, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getTaker()));
			}

		});
		GridData takerData = new GridData(GridData.FILL_HORIZONTAL);
		taker.setLayoutData(takerData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.taker, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param playersGroup
	 */
	protected void createPartnerFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.RoundSettingsPropertiesEditionPart_PartnerLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.partner, TarotViewsRepository.SWT_KIND));
		partner = new EObjectFlatComboViewer(parent, true);
		partner.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		partner.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartImpl.this, TarotViewsRepository.RoundSettings.partner, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getPartner()));
			}

		});
		GridData partnerData = new GridData(GridData.FILL_HORIZONTAL);
		partner.setLayoutData(partnerData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.partner, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createBaseScoreGroup(Composite parent) {
		Group baseScoreGroup = new Group(parent, SWT.NONE);
		baseScoreGroup.setText(TarotMessages.RoundSettingsPropertiesEditionPart_BaseScoreGroupLabel);
		GridData baseScoreGroupData = new GridData(GridData.FILL_HORIZONTAL);
		baseScoreGroupData.horizontalSpan = 3;
		baseScoreGroup.setLayoutData(baseScoreGroupData);
		GridLayout baseScoreGroupLayout = new GridLayout();
		baseScoreGroupLayout.numColumns = 3;
		baseScoreGroup.setLayout(baseScoreGroupLayout);
		createBidEMFComboViewer(baseScoreGroup);
		createExtraPointsText(baseScoreGroup);
		createWonCheckbox(baseScoreGroup);
	}

	protected void createBidEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.RoundSettingsPropertiesEditionPart_BidLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.bid, TarotViewsRepository.SWT_KIND));
		bid = new EMFComboViewer(parent);
		bid.setContentProvider(new ArrayContentProvider());
		bid.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData bidData = new GridData(GridData.FILL_HORIZONTAL);
		bid.getCombo().setLayoutData(bidData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.bid, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createExtraPointsText(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.RoundSettingsPropertiesEditionPart_ExtraPointsLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.extraPoints, TarotViewsRepository.SWT_KIND));
		extraPoints = new Text(parent, SWT.BORDER);
		GridData extraPointsData = new GridData(GridData.FILL_HORIZONTAL);
		extraPoints.setLayoutData(extraPointsData);
		extraPoints.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartImpl.this, TarotViewsRepository.RoundSettings.extraPoints, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, extraPoints.getText()));
			}

		});
		extraPoints.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartImpl.this, TarotViewsRepository.RoundSettings.extraPoints, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, extraPoints.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.extraPoints, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createWonCheckbox(Composite parent) {
		won = new Button(parent, SWT.CHECK);
		won.setText(TarotMessages.RoundSettingsPropertiesEditionPart_WonLabel);
		GridData wonData = new GridData(GridData.FILL_HORIZONTAL);
		wonData.horizontalSpan = 2;
		won.setLayoutData(wonData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.won, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getTaker()
	 */
	public EObject getTaker() {
		if (taker.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) taker.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#initTaker(ResourceSet allResources, EObject current)
	 */
	public void initTaker(ResourceSet allResources, EObject current) {
		taker.setInput(allResources);
		if (current != null) {
			taker.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setTaker(EObject newValue)
	 */
	public void setTaker(EObject newValue) {
		if (newValue != null) {
			taker.setSelection(new StructuredSelection(newValue));
		} else {
			taker.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setTakerButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTakerButtonMode(ButtonsModeEnum newValue) {
		taker.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#addFilterTaker(ViewerFilter filter)
	 */
	public void addFilterToTaker(ViewerFilter filter) {
		taker.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#addBusinessFilterTaker(ViewerFilter filter)
	 */
	public void addBusinessFilterToTaker(ViewerFilter filter) {
		taker.addBusinessRuleFilter(filter);
	}

	public void setMessageForTaker(String msg, int msgLevel) {

	}

	public void unsetMessageForTaker() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getPartner()
	 */
	public EObject getPartner() {
		if (partner.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) partner.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#initPartner(ResourceSet allResources, EObject current)
	 */
	public void initPartner(ResourceSet allResources, EObject current) {
		partner.setInput(allResources);
		if (current != null) {
			partner.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setPartner(EObject newValue)
	 */
	public void setPartner(EObject newValue) {
		if (newValue != null) {
			partner.setSelection(new StructuredSelection(newValue));
		} else {
			partner.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setPartnerButtonMode(ButtonsModeEnum newValue)
	 */
	public void setPartnerButtonMode(ButtonsModeEnum newValue) {
		partner.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#addFilterPartner(ViewerFilter filter)
	 */
	public void addFilterToPartner(ViewerFilter filter) {
		partner.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#addBusinessFilterPartner(ViewerFilter filter)
	 */
	public void addBusinessFilterToPartner(ViewerFilter filter) {
		partner.addBusinessRuleFilter(filter);
	}

	public void setMessageForPartner(String msg, int msgLevel) {

	}

	public void unsetMessageForPartner() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getBid()
	 */
	public Enumerator getBid() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) bid.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#initBid(EEnum eenum, Enumerator current)
	 */
	public void initBid(EEnum eenum, Enumerator current) {
		bid.setInput(eenum.getELiterals());
		bid.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setBid(Enumerator newValue)
	 */
	public void setBid(Enumerator newValue) {
		bid.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForBid(String msg, int msgLevel) {

	}

	public void unsetMessageForBid() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getExtraPoints()
	 */
	public String getExtraPoints() {
		return extraPoints.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setExtraPoints(String newValue)
	 */
	public void setExtraPoints(String newValue) {
		if (newValue != null) {
			extraPoints.setText(newValue);
		} else {
			extraPoints.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForExtraPoints(String msg, int msgLevel) {

	}

	public void unsetMessageForExtraPoints() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getWon()
	 */
	public Boolean getWon() {
		return Boolean.valueOf(won.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setWon(Boolean newValue)
	 */
	public void setWon(Boolean newValue) {
		if (newValue != null) {
			won.setSelection(newValue.booleanValue());
		} else {
			won.setSelection(false);
		}
	}

	public void setMessageForWon(String msg, int msgLevel) {

	}

	public void unsetMessageForWon() {

	}








	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return TarotMessages.RoundSettings_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
