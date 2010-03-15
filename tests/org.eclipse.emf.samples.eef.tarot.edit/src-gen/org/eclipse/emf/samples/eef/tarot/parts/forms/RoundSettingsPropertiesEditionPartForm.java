/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

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
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * 
 * 
 */
public class RoundSettingsPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RoundSettingsPropertiesEditionPart {

	protected EObjectFlatComboViewer taker;
	protected EObjectFlatComboViewer partner;
	protected EMFComboViewer bid;
	protected Text extraPoints;
	protected Button won;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RoundSettingsPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPlayersGroup(widgetFactory, view);

		createBaseScoreGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPlayersGroup(FormToolkit widgetFactory, final Composite view) {
		Section playersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		playersSection.setText(TarotMessages.RoundSettingsPropertiesEditionPart_PlayersGroupLabel);
		GridData playersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		playersSectionData.horizontalSpan = 3;
		playersSection.setLayoutData(playersSectionData);
		Composite playersGroup = widgetFactory.createComposite(playersSection);
		GridLayout playersGroupLayout = new GridLayout();
		playersGroupLayout.numColumns = 3;
		playersGroup.setLayout(playersGroupLayout);
		createTakerFlatComboViewer(playersGroup, widgetFactory);
		createPartnerFlatComboViewer(playersGroup, widgetFactory);
		playersSection.setClient(playersGroup);
	}

	/**
	 * @param playersGroup
	 * 
	 */
	protected void createTakerFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, TarotMessages.RoundSettingsPropertiesEditionPart_TakerLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.taker, TarotViewsRepository.FORM_KIND));
		taker = new EObjectFlatComboViewer(parent, false);
		taker.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData takerData = new GridData(GridData.FILL_HORIZONTAL);
		taker.setLayoutData(takerData);
		taker.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartForm.this, TarotViewsRepository.RoundSettings.taker, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTaker()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.taker, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param playersGroup
	 * 
	 */
	protected void createPartnerFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, TarotMessages.RoundSettingsPropertiesEditionPart_PartnerLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.partner, TarotViewsRepository.FORM_KIND));
		partner = new EObjectFlatComboViewer(parent, true);
		partner.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData partnerData = new GridData(GridData.FILL_HORIZONTAL);
		partner.setLayoutData(partnerData);
		partner.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartForm.this, TarotViewsRepository.RoundSettings.partner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPartner()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.partner, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createBaseScoreGroup(FormToolkit widgetFactory, final Composite view) {
		Section baseScoreSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		baseScoreSection.setText(TarotMessages.RoundSettingsPropertiesEditionPart_BaseScoreGroupLabel);
		GridData baseScoreSectionData = new GridData(GridData.FILL_HORIZONTAL);
		baseScoreSectionData.horizontalSpan = 3;
		baseScoreSection.setLayoutData(baseScoreSectionData);
		Composite baseScoreGroup = widgetFactory.createComposite(baseScoreSection);
		GridLayout baseScoreGroupLayout = new GridLayout();
		baseScoreGroupLayout.numColumns = 3;
		baseScoreGroup.setLayout(baseScoreGroupLayout);
		createBidEMFComboViewer(widgetFactory, baseScoreGroup);
		createExtraPointsText(widgetFactory, baseScoreGroup);
		createWonCheckbox(widgetFactory, baseScoreGroup);
		baseScoreSection.setClient(baseScoreGroup);
	}

	
	protected void createBidEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, TarotMessages.RoundSettingsPropertiesEditionPart_BidLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.bid, TarotViewsRepository.FORM_KIND));
		bid = new EMFComboViewer(parent);
		bid.setContentProvider(new ArrayContentProvider());
		bid.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData bidData = new GridData(GridData.FILL_HORIZONTAL);
		bid.getCombo().setLayoutData(bidData);
		bid.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartForm.this, TarotViewsRepository.RoundSettings.bid, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getBid()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.bid, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createExtraPointsText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, TarotMessages.RoundSettingsPropertiesEditionPart_ExtraPointsLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundSettings.extraPoints, TarotViewsRepository.FORM_KIND));
		extraPoints = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		extraPoints.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData extraPointsData = new GridData(GridData.FILL_HORIZONTAL);
		extraPoints.setLayoutData(extraPointsData);
		extraPoints.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartForm.this, TarotViewsRepository.RoundSettings.extraPoints, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, extraPoints.getText()));
			}
		});
		extraPoints.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartForm.this, TarotViewsRepository.RoundSettings.extraPoints, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, extraPoints.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.extraPoints, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createWonCheckbox(FormToolkit widgetFactory, Composite parent) {
		won = widgetFactory.createButton(parent, TarotMessages.RoundSettingsPropertiesEditionPart_WonLabel, SWT.CHECK);
		won.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundSettingsPropertiesEditionPartForm.this, TarotViewsRepository.RoundSettings.won, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(won.getSelection())));
			}

		});
		GridData wonData = new GridData(GridData.FILL_HORIZONTAL);
		wonData.horizontalSpan = 2;
		won.setLayoutData(wonData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundSettings.won, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getTaker()
	 * 
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
	 * 
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
	 * 
	 */
	public void addFilterToTaker(ViewerFilter filter) {
		taker.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#addBusinessFilterTaker(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTaker(ViewerFilter filter) {
		taker.addBusinessRuleFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getPartner()
	 * 
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
	 * 
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
	 * 
	 */
	public void addFilterToPartner(ViewerFilter filter) {
		partner.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#addBusinessFilterPartner(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPartner(ViewerFilter filter) {
		partner.addBusinessRuleFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getBid()
	 * 
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
	 * 
	 */
	public void setBid(Enumerator newValue) {
		bid.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getExtraPoints()
	 * 
	 */
	public String getExtraPoints() {
		return extraPoints.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setExtraPoints(String newValue)
	 * 
	 */
	public void setExtraPoints(String newValue) {
		if (newValue != null) {
			extraPoints.setText(newValue);
		} else {
			extraPoints.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForExtraPoints(String msg, int msgLevel) {
		messageManager.addMessage("ExtraPoints_key", msg, null, msgLevel, extraPoints);
	}

	public void unsetMessageForExtraPoints() {
		messageManager.removeMessage("ExtraPoints_key", extraPoints);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#getWon()
	 * 
	 */
	public Boolean getWon() {
		return Boolean.valueOf(won.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart#setWon(Boolean newValue)
	 * 
	 */
	public void setWon(Boolean newValue) {
		if (newValue != null) {
			won.setSelection(newValue.booleanValue());
		} else {
			won.setSelection(false);
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.RoundSettings_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
