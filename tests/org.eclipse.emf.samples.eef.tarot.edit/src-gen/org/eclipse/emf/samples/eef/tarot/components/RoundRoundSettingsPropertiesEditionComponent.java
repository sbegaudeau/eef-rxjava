/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.util.EEFConverterUtil;
import org.eclipse.emf.samples.eef.tarot.BID;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.Round;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


// End of user code

/**
 * 
 */
public class RoundRoundSettingsPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String ROUNDSETTINGS_PART = "Round settings"; //$NON-NLS-1$

	private String[] parts = {ROUNDSETTINGS_PART};

	/**
	 * The EObject to edit
	 */
	private Round round;

	/**
	 * The Round settings part
	 */
	protected RoundSettingsPropertiesEditionPart roundSettingsPart;

	/**
	 * Default constructor
	 */
	public RoundRoundSettingsPropertiesEditionComponent(EObject round, String editing_mode) {
		if (round instanceof Round) {
			this.round = (Round)round;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.round.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(final Notification msg) {
				if (roundSettingsPart == null)
					RoundRoundSettingsPropertiesEditionComponent.this.dispose();
				else {
					Runnable updateRunnable = new Runnable() {
						public void run() {
							runUpdateRunnable(msg);
						}
					};
					if (null == Display.getCurrent()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
					} else {
						updateRunnable.run();
					}
				}
			}

		};
	}

	/**
	 * Used to update the views
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (TarotPackage.eINSTANCE.getRound_Bid().equals(msg.getFeature()) && roundSettingsPart != null)
			roundSettingsPart.setBid((Enumerator)msg.getNewValue());

		if (TarotPackage.eINSTANCE.getRound_Taker().equals(msg.getFeature()) && roundSettingsPart != null)
			roundSettingsPart.setTaker((EObject)msg.getNewValue());
		if (TarotPackage.eINSTANCE.getRound_Partner().equals(msg.getFeature()) && roundSettingsPart != null)
			roundSettingsPart.setPartner((EObject)msg.getNewValue());
		if (TarotPackage.eINSTANCE.getRound_Won().equals(msg.getFeature()) && roundSettingsPart != null)
			roundSettingsPart.setWon((Boolean)msg.getNewValue());

		if (TarotPackage.eINSTANCE.getRound_ExtraPoints().equals(msg.getFeature()) && roundSettingsPart != null){
			if (msg.getNewValue() != null) {
				roundSettingsPart.setExtraPoints(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				roundSettingsPart.setExtraPoints("");
			}
		}


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (ROUNDSETTINGS_PART.equals(key))
			return TarotViewsRepository.RoundSettings.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (round != null && ROUNDSETTINGS_PART.equals(key)) {
			if (roundSettingsPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(TarotViewsRepository.class);
				if (provider != null) {
					roundSettingsPart = (RoundSettingsPropertiesEditionPart)provider.getPropertiesEditionPart(TarotViewsRepository.RoundSettings.class, kind, this);
					addListener((IPropertiesEditionListener)roundSettingsPart);
				}
			}
			return (IPropertiesEditionPart)roundSettingsPart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == TarotViewsRepository.RoundSettings.class)
			this.roundSettingsPart = (RoundSettingsPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (roundSettingsPart != null && key == TarotViewsRepository.RoundSettings.class) {
			((IPropertiesEditionPart)roundSettingsPart).setContext(elt, allResource);
			final Round round = (Round)elt;
			// init values
			roundSettingsPart.initBid((EEnum) TarotPackage.eINSTANCE.getRound_Bid().getEType(), round.getBid());
			// init part
			roundSettingsPart.initTaker(allResource, round.getTaker());
			// set the button mode
			roundSettingsPart.setTakerButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			roundSettingsPart.initPartner(allResource, round.getPartner());
			// set the button mode
			roundSettingsPart.setPartnerButtonMode(ButtonsModeEnum.BROWSE);
			roundSettingsPart.setWon(round.isWon());

			roundSettingsPart.setExtraPoints(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), round.getExtraPoints()));

			// init filters

			roundSettingsPart.addFilterToTaker(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Player);
				}

			});
			// Start of user code for additional businessfilters for taker
			
			// End of user code
			roundSettingsPart.addFilterToPartner(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Player); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for partner
			
			// End of user code


		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}









	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((round != null) && (roundSettingsPart != null)) { 
			cc.append(SetCommand.create(editingDomain, round, TarotPackage.eINSTANCE.getRound_Bid(), roundSettingsPart.getBid()));

			if (round.eGet(TarotPackage.eINSTANCE.getRound_Taker()) == null || !round.eGet(TarotPackage.eINSTANCE.getRound_Taker()).equals(roundSettingsPart.getTaker())) {
				cc.append(SetCommand.create(editingDomain, round, TarotPackage.eINSTANCE.getRound_Taker(), roundSettingsPart.getTaker()));
			}
			if (round.eGet(TarotPackage.eINSTANCE.getRound_Partner()) == null || !round.eGet(TarotPackage.eINSTANCE.getRound_Partner()).equals(roundSettingsPart.getPartner())) {
				cc.append(SetCommand.create(editingDomain, round, TarotPackage.eINSTANCE.getRound_Partner(), roundSettingsPart.getPartner()));
			}
			cc.append(SetCommand.create(editingDomain, round, TarotPackage.eINSTANCE.getRound_Won(), roundSettingsPart.getWon()));

			cc.append(SetCommand.create(editingDomain, round, TarotPackage.eINSTANCE.getRound_ExtraPoints(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), roundSettingsPart.getExtraPoints())));


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof Round) {
			Round roundToUpdate = (Round)source;
			roundToUpdate.setBid((BID)roundSettingsPart.getBid());

			roundToUpdate.setTaker((Player)roundSettingsPart.getTaker());
			roundToUpdate.setPartner((Player)roundSettingsPart.getPartner());
			roundToUpdate.setWon(new Boolean(roundSettingsPart.getWon()).booleanValue());

			roundToUpdate.setExtraPoints(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), roundSettingsPart.getExtraPoints()));



			return roundToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (TarotViewsRepository.RoundSettings.bid == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, round, TarotPackage.eINSTANCE.getRound_Bid(), event.getNewValue()));

			if (TarotViewsRepository.RoundSettings.taker == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, round, TarotPackage.eINSTANCE.getRound_Taker(), event.getNewValue()));
			if (TarotViewsRepository.RoundSettings.partner == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, round, TarotPackage.eINSTANCE.getRound_Partner(), event.getNewValue()));
			if (TarotViewsRepository.RoundSettings.won == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, round, TarotPackage.eINSTANCE.getRound_Won(), event.getNewValue()));

			if (TarotViewsRepository.RoundSettings.extraPoints == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, round, TarotPackage.eINSTANCE.getRound_ExtraPoints(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}


				if (!command.isEmpty() && !command.canExecute()) {
					EEFRuntimePlugin.getDefault().logError("Cannot perform model change command.", null);
				} else {
					liveEditingDomain.getCommandStack().execute(command);
				}
			}
			if (valueDiagnostic.getSeverity() != Diagnostic.OK && valueDiagnostic instanceof BasicDiagnostic)
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, valueDiagnostic));
			else {
				Diagnostic validate = validate();
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, validate));
			}
			super.firePropertiesChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == TarotViewsRepository.RoundSettings.bid || key == TarotViewsRepository.RoundSettings.taker || key == TarotViewsRepository.RoundSettings.won || key == TarotViewsRepository.RoundSettings.extraPoints || key == TarotViewsRepository.RoundScore.score;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if (TarotViewsRepository.RoundSettings.bid == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(TarotPackage.eINSTANCE.getRound_Bid().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(TarotPackage.eINSTANCE.getRound_Bid().getEAttributeType(), newValue);
				}
				if (TarotViewsRepository.RoundSettings.won == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(TarotPackage.eINSTANCE.getRound_Won().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(TarotPackage.eINSTANCE.getRound_Won().getEAttributeType(), newValue);
				}
				if (TarotViewsRepository.RoundSettings.extraPoints == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(TarotPackage.eINSTANCE.getRound_ExtraPoints().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(TarotPackage.eINSTANCE.getRound_ExtraPoints().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(round);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(round);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			round.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 */
	public String getTabText(String p_key) {
		return roundSettingsPart.getTitle();
	}
}
