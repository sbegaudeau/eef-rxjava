/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.eclipse.worldcupforecast.components;

// Start of user code for imports
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
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
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.FinalScorePropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class FinalScorePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private FinalScore finalScore;

	/**
	 * The Base part
	 * 
	 */
	protected FinalScorePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
	 */
	public FinalScorePropertiesEditionComponent(EObject finalScore, String editing_mode) {
		if (finalScore instanceof FinalScore) {
			this.finalScore = (FinalScore)finalScore;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.finalScore.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 * 
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 */
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					FinalScorePropertiesEditionComponent.this.dispose();
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
	 * 
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setScoreTeam1(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setScoreTeam1("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setScoreTeam2(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setScoreTeam2("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam1().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setPenaltyScoreTeam1(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setPenaltyScoreTeam1("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam2().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setPenaltyScoreTeam2(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setPenaltyScoreTeam2("");
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return WorldcupforecastViewsRepository.FinalScore.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 * 
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (finalScore != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					basePart = (FinalScorePropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.FinalScore.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == WorldcupforecastViewsRepository.FinalScore.class)
			this.basePart = (FinalScorePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (basePart != null && key == WorldcupforecastViewsRepository.FinalScore.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final FinalScore finalScore = (FinalScore)elt;
			// init values
			basePart.setScoreTeam1(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), finalScore.getScoreTeam1()));

			basePart.setScoreTeam2(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), finalScore.getScoreTeam2()));

			basePart.setPenaltyScoreTeam1(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), finalScore.getPenaltyScoreTeam1()));

			basePart.setPenaltyScoreTeam2(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), finalScore.getPenaltyScoreTeam2()));

			// init filters




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
	 * 
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((finalScore != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam1())));
			cc.append(SetCommand.create(editingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam2())));
			cc.append(SetCommand.create(editingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam1(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getPenaltyScoreTeam1())));
			cc.append(SetCommand.create(editingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam2(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getPenaltyScoreTeam2())));

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
	 * 
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof FinalScore) {
			FinalScore finalScoreToUpdate = (FinalScore)source;
			finalScoreToUpdate.setScoreTeam1(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam1()));

			finalScoreToUpdate.setScoreTeam2(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam2()));

			finalScoreToUpdate.setPenaltyScoreTeam1(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getPenaltyScoreTeam1()));

			finalScoreToUpdate.setPenaltyScoreTeam2(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getPenaltyScoreTeam2()));


			return finalScoreToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (WorldcupforecastViewsRepository.FinalScore.scoreTeam1 == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.FinalScore.scoreTeam2 == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1 == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam1(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2 == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, finalScore, WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam2(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
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
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if (WorldcupforecastViewsRepository.FinalScore.scoreTeam1 == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.FinalScore.scoreTeam2 == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam1 == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam1().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam1().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.FinalScore.penaltyScoreTeam2 == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam2().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getFinalScore_PenaltyScoreTeam2().getEAttributeType(), newValue);
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
	 * 
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(finalScore);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(finalScore);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 * 
	 */
	public void dispose() {
		if (semanticAdapter != null)
			finalScore.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
