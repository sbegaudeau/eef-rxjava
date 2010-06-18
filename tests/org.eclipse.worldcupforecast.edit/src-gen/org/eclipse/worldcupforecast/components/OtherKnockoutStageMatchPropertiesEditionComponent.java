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
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchType;
import org.eclipse.worldcupforecast.OtherKnockoutStageMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.OtherKnockoutStageGamePropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class OtherKnockoutStageMatchPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String OTHERKNOCKOUTSTAGEGAME_PART = "OtherKnockoutStageGame"; //$NON-NLS-1$

	
	private String[] parts = {OTHERKNOCKOUTSTAGEGAME_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private OtherKnockoutStageMatch otherKnockoutStageMatch;

	/**
	 * The OtherKnockoutStageGame part
	 * 
	 */
	protected OtherKnockoutStageGamePropertiesEditionPart otherKnockoutStageGamePart;

	/**
	 * Default constructor
	 * 
	 */
	public OtherKnockoutStageMatchPropertiesEditionComponent(EObject otherKnockoutStageMatch, String editing_mode) {
		if (otherKnockoutStageMatch instanceof OtherKnockoutStageMatch) {
			this.otherKnockoutStageMatch = (OtherKnockoutStageMatch)otherKnockoutStageMatch;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.otherKnockoutStageMatch.eAdapters().add(semanticAdapter);
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
				if (otherKnockoutStageGamePart == null)
					OtherKnockoutStageMatchPropertiesEditionComponent.this.dispose();
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
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Hours().equals(msg.getFeature()) && otherKnockoutStageGamePart != null){
			if (msg.getNewValue() != null) {
				otherKnockoutStageGamePart.setHours(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				otherKnockoutStageGamePart.setHours("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().equals(msg.getFeature()) && otherKnockoutStageGamePart != null){
			if (msg.getNewValue() != null) {
				otherKnockoutStageGamePart.setMinutes(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				otherKnockoutStageGamePart.setMinutes("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().equals(msg.getFeature()) && otherKnockoutStageGamePart != null){
			if (msg.getNewValue() != null) {
				otherKnockoutStageGamePart.setCoefficient(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				otherKnockoutStageGamePart.setCoefficient("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team1WinnerOfMatch().equals(msg.getFeature()) && otherKnockoutStageGamePart != null)
			otherKnockoutStageGamePart.setTeam1WinnerOfMatch((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team2WinnerOfMatch().equals(msg.getFeature()) && otherKnockoutStageGamePart != null)
			otherKnockoutStageGamePart.setTeam2WinnerOfMatch((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Team1().equals(msg.getFeature()) && otherKnockoutStageGamePart != null)
			otherKnockoutStageGamePart.setTeam1((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Team2().equals(msg.getFeature()) && otherKnockoutStageGamePart != null)
			otherKnockoutStageGamePart.setTeam2((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Type().equals(msg.getFeature()) && otherKnockoutStageGamePart != null)
			otherKnockoutStageGamePart.setType((Enumerator)msg.getNewValue());


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (OTHERKNOCKOUTSTAGEGAME_PART.equals(key))
			return WorldcupforecastViewsRepository.OtherKnockoutStageGame.class;
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
		if (otherKnockoutStageMatch != null && OTHERKNOCKOUTSTAGEGAME_PART.equals(key)) {
			if (otherKnockoutStageGamePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					otherKnockoutStageGamePart = (OtherKnockoutStageGamePropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.OtherKnockoutStageGame.class, kind, this);
					addListener((IPropertiesEditionListener)otherKnockoutStageGamePart);
				}
			}
			return (IPropertiesEditionPart)otherKnockoutStageGamePart;
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
		if (key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.class)
			this.otherKnockoutStageGamePart = (OtherKnockoutStageGamePropertiesEditionPart) propertiesEditionPart;
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
		if (otherKnockoutStageGamePart != null && key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.class) {
			((IPropertiesEditionPart)otherKnockoutStageGamePart).setContext(elt, allResource);
			final OtherKnockoutStageMatch otherKnockoutStageMatch = (OtherKnockoutStageMatch)elt;
			// init values
			otherKnockoutStageGamePart.setHours(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageMatch.getHours()));

			otherKnockoutStageGamePart.setMinutes(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageMatch.getMinutes()));

			otherKnockoutStageGamePart.setCoefficient(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageMatch.getCoefficient()));

			// init part
			otherKnockoutStageGamePart.initTeam1WinnerOfMatch(allResource, otherKnockoutStageMatch.getTeam1WinnerOfMatch());
			// set the button mode
			otherKnockoutStageGamePart.setTeam1WinnerOfMatchButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			otherKnockoutStageGamePart.initTeam2WinnerOfMatch(allResource, otherKnockoutStageMatch.getTeam2WinnerOfMatch());
			// set the button mode
			otherKnockoutStageGamePart.setTeam2WinnerOfMatchButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			otherKnockoutStageGamePart.initTeam1(allResource, otherKnockoutStageMatch.getTeam1());
			// set the button mode
			otherKnockoutStageGamePart.setTeam1ButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			otherKnockoutStageGamePart.initTeam2(allResource, otherKnockoutStageMatch.getTeam2());
			// set the button mode
			otherKnockoutStageGamePart.setTeam2ButtonMode(ButtonsModeEnum.BROWSE);
			otherKnockoutStageGamePart.initType((EEnum) WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Type().getEType(), otherKnockoutStageMatch.getType());
			// init filters



			otherKnockoutStageGamePart.addFilterToTeam1WinnerOfMatch(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Match);
				}

			});
			// Start of user code for additional businessfilters for team1winnerofmatch
			
			// End of user code

			otherKnockoutStageGamePart.addFilterToTeam2WinnerOfMatch(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Match);
				}

			});
			// Start of user code for additional businessfilters for team2winnerofmatch
			
			// End of user code

			otherKnockoutStageGamePart.addFilterToTeam1(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Team);
				}

			});
			// Start of user code for additional businessfilters for team1
			
			// End of user code

			otherKnockoutStageGamePart.addFilterToTeam2(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Team);
				}

			});
			// Start of user code for additional businessfilters for team2
			
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
	 * 
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((otherKnockoutStageMatch != null) && (otherKnockoutStageGamePart != null)) { 
			cc.append(SetCommand.create(editingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageGamePart.getHours())));
			cc.append(SetCommand.create(editingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageGamePart.getMinutes())));
			cc.append(SetCommand.create(editingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageGamePart.getCoefficient())));
			if (otherKnockoutStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team1WinnerOfMatch()) == null || !otherKnockoutStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team1WinnerOfMatch()).equals(otherKnockoutStageGamePart.getTeam1WinnerOfMatch())) {
				cc.append(SetCommand.create(editingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team1WinnerOfMatch(), otherKnockoutStageGamePart.getTeam1WinnerOfMatch()));
			}
			if (otherKnockoutStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team2WinnerOfMatch()) == null || !otherKnockoutStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team2WinnerOfMatch()).equals(otherKnockoutStageGamePart.getTeam2WinnerOfMatch())) {
				cc.append(SetCommand.create(editingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team2WinnerOfMatch(), otherKnockoutStageGamePart.getTeam2WinnerOfMatch()));
			}
// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in widgetControl.mtl module, with the values : team1, OtherKnockoutStageGame, OtherKnockoutStageMatch, otherKnockoutStageMatch.
// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in widgetControl.mtl module, with the values : team2, OtherKnockoutStageGame, OtherKnockoutStageMatch, otherKnockoutStageMatch.
			cc.append(SetCommand.create(editingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Type(), otherKnockoutStageGamePart.getType()));


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
		if (source instanceof OtherKnockoutStageMatch) {
			OtherKnockoutStageMatch otherKnockoutStageMatchToUpdate = (OtherKnockoutStageMatch)source;
			otherKnockoutStageMatchToUpdate.setHours(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageGamePart.getHours()));

			otherKnockoutStageMatchToUpdate.setMinutes(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageGamePart.getMinutes()));

			otherKnockoutStageMatchToUpdate.setCoefficient(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), otherKnockoutStageGamePart.getCoefficient()));

			otherKnockoutStageMatchToUpdate.setTeam1WinnerOfMatch((Match)otherKnockoutStageGamePart.getTeam1WinnerOfMatch());
			otherKnockoutStageMatchToUpdate.setTeam2WinnerOfMatch((Match)otherKnockoutStageGamePart.getTeam2WinnerOfMatch());
// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : team1, OtherKnockoutStageGame, OtherKnockoutStageMatch, otherKnockoutStageMatch.
// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : team2, OtherKnockoutStageGame, OtherKnockoutStageMatch, otherKnockoutStageMatch.
			otherKnockoutStageMatchToUpdate.setType((MatchType)otherKnockoutStageGamePart.getType());


			return otherKnockoutStageMatchToUpdate;
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
			if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.hours == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.minutes == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.coefficient == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.team1WinnerOfMatch == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team1WinnerOfMatch(), event.getNewValue()));
			if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.team2WinnerOfMatch == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Team2WinnerOfMatch(), event.getNewValue()));
// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in widgetControl.mtl module, with the values : team1, OtherKnockoutStageGame, otherKnockoutStageMatch.
// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in widgetControl.mtl module, with the values : team2, OtherKnockoutStageGame, otherKnockoutStageMatch.
			if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.type == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, otherKnockoutStageMatch, WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Type(), event.getNewValue()));


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
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.hours || key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.minutes || key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.team1WinnerOfMatch || key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.team2WinnerOfMatch || key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.team1 || key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.team2 || key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.type;
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
				if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.hours == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.minutes == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.coefficient == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.OtherKnockoutStageGame.type == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Type().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getOtherKnockoutStageMatch_Type().getEAttributeType(), newValue);
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
			EObject copy = EcoreUtil.copy(otherKnockoutStageMatch);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(otherKnockoutStageMatch);
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
			otherKnockoutStageMatch.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return otherKnockoutStageGamePart.getTitle();
	}
}
