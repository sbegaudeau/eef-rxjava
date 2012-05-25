/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
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

import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.TeamPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class TeamPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private Team team;

	/**
	 * The Base part
	 * 
	 */
	protected TeamPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
	 */
	public TeamPropertiesEditionComponent(EObject team, String editing_mode) {
		if (team instanceof Team) {
			this.team = (Team)team;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.team.eAdapters().add(semanticAdapter);
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
					TeamPropertiesEditionComponent.this.dispose();
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
		if (WorldcupforecastPackage.eINSTANCE.getTeam_Name().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setName("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getTeam_Pics().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null)
				basePart.setPics((String)msg.getNewValue());
			else
				basePart.setPics("");
		}
		if (WorldcupforecastPackage.eINSTANCE.getTeam_Points().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setPoints(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setPoints("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getTeam_GoalsFor().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setGoalsFor(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setGoalsFor("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getTeam_GoalsAgainst().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setGoalsAgainst(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setGoalsAgainst("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getTeam_GoalDifference().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setGoalDifference(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setGoalDifference("");
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
			return WorldcupforecastViewsRepository.Team.class;
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
		if (team != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					basePart = (TeamPropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.Team.class, kind, this);
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
		if (key == WorldcupforecastViewsRepository.Team.class)
			this.basePart = (TeamPropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == WorldcupforecastViewsRepository.Team.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Team team = (Team)elt;
			// init values
			if (team.getName() != null)
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), team.getName()));

			if (team.getPics() != null)
				basePart.initPics(EcoreUtil.getIdentification(team), team.getPics());

			basePart.setPoints(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), team.getPoints()));

			basePart.setGoalsFor(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), team.getGoalsFor()));

			basePart.setGoalsAgainst(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), team.getGoalsAgainst()));

			basePart.setGoalDifference(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), team.getGoalDifference()));

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
		if ((team != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, team, WorldcupforecastPackage.eINSTANCE.getTeam_Name(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getName())));
			cc.append(SetCommand.create(editingDomain, team, WorldcupforecastPackage.eINSTANCE.getTeam_Pics(), basePart.getPics()));

			// do not generates command for derived attribute points
			// do not generates command for derived attribute goalsFor
			// do not generates command for derived attribute goalsAgainst
			// do not generates command for derived attribute goalDifference

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
		if (source instanceof Team) {
			Team teamToUpdate = (Team)source;
			teamToUpdate.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getName()));

			teamToUpdate.setPics(basePart.getPics());

			// do not update derived attribute points
			// do not update derived attribute goalsFor
			// do not update derived attribute goalsAgainst
			// do not update derived attribute goalDifference

			return teamToUpdate;
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
			if (WorldcupforecastViewsRepository.Team.name == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, team, WorldcupforecastPackage.eINSTANCE.getTeam_Name(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.Team.pics == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, team, WorldcupforecastPackage.eINSTANCE.getTeam_Pics(), event.getNewValue()));

			// do not generates command for derived attribute points
			// do not generates command for derived attribute goalsFor
			// do not generates command for derived attribute goalsAgainst
			// do not generates command for derived attribute goalDifference

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
		return key == WorldcupforecastViewsRepository.Team.name;
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
				if (WorldcupforecastViewsRepository.Team.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getTeam_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getTeam_Name().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Team.pics == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getTeam_Pics().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getTeam_Pics().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Team.points == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getTeam_Points().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getTeam_Points().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Team.goalsFor == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getTeam_GoalsFor().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getTeam_GoalsFor().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Team.goalsAgainst == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getTeam_GoalsAgainst().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getTeam_GoalsAgainst().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Team.goalDifference == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getTeam_GoalDifference().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getTeam_GoalDifference().getEAttributeType(), newValue);
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
			EObject copy = EcoreUtil.copy(team);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(team);
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
			team.eAdapters().remove(semanticAdapter);
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
