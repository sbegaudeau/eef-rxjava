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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.GroupeStageMatchPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class GroupStageMatchPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String GROUPESTAGEMATCH_PART = "GroupeStageMatch"; //$NON-NLS-1$

	
	private String[] parts = {GROUPESTAGEMATCH_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private GroupStageMatch groupStageMatch;

	/**
	 * The GroupeStageMatch part
	 * 
	 */
	protected GroupeStageMatchPropertiesEditionPart groupeStageMatchPart;

	/**
	 * Default constructor
	 * 
	 */
	public GroupStageMatchPropertiesEditionComponent(EObject groupStageMatch, String editing_mode) {
		if (groupStageMatch instanceof GroupStageMatch) {
			this.groupStageMatch = (GroupStageMatch)groupStageMatch;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.groupStageMatch.eAdapters().add(semanticAdapter);
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
				if (groupeStageMatchPart == null)
					GroupStageMatchPropertiesEditionComponent.this.dispose();
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
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Hours().equals(msg.getFeature()) && groupeStageMatchPart != null){
			if (msg.getNewValue() != null) {
				groupeStageMatchPart.setHours(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				groupeStageMatchPart.setHours("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().equals(msg.getFeature()) && groupeStageMatchPart != null){
			if (msg.getNewValue() != null) {
				groupeStageMatchPart.setMinutes(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				groupeStageMatchPart.setMinutes("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().equals(msg.getFeature()) && groupeStageMatchPart != null){
			if (msg.getNewValue() != null) {
				groupeStageMatchPart.setCoefficient(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				groupeStageMatchPart.setCoefficient("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam1().equals(msg.getFeature()) && groupeStageMatchPart != null)
			groupeStageMatchPart.setTeam1((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam2().equals(msg.getFeature()) && groupeStageMatchPart != null)
			groupeStageMatchPart.setTeam2((EObject)msg.getNewValue());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (GROUPESTAGEMATCH_PART.equals(key))
			return WorldcupforecastViewsRepository.GroupeStageMatch.class;
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
		if (groupStageMatch != null && GROUPESTAGEMATCH_PART.equals(key)) {
			if (groupeStageMatchPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					groupeStageMatchPart = (GroupeStageMatchPropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.GroupeStageMatch.class, kind, this);
					addListener((IPropertiesEditionListener)groupeStageMatchPart);
				}
			}
			return (IPropertiesEditionPart)groupeStageMatchPart;
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
		if (key == WorldcupforecastViewsRepository.GroupeStageMatch.class)
			this.groupeStageMatchPart = (GroupeStageMatchPropertiesEditionPart) propertiesEditionPart;
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
		if (groupeStageMatchPart != null && key == WorldcupforecastViewsRepository.GroupeStageMatch.class) {
			((IPropertiesEditionPart)groupeStageMatchPart).setContext(elt, allResource);
			final GroupStageMatch groupStageMatch = (GroupStageMatch)elt;
			// init values
			groupeStageMatchPart.setHours(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), groupStageMatch.getHours()));

			groupeStageMatchPart.setMinutes(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), groupStageMatch.getMinutes()));

			groupeStageMatchPart.setCoefficient(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), groupStageMatch.getCoefficient()));

			// init part
			groupeStageMatchPart.initTeam1(allResource, groupStageMatch.getManualTeam1());
			// set the button mode
			groupeStageMatchPart.setTeam1ButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			groupeStageMatchPart.initTeam2(allResource, groupStageMatch.getManualTeam2());
			// set the button mode
			groupeStageMatchPart.setTeam2ButtonMode(ButtonsModeEnum.BROWSE);
			// init filters



			groupeStageMatchPart.addFilterToTeam1(new ViewerFilter() {

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

			groupeStageMatchPart.addFilterToTeam2(new ViewerFilter() {

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
		if ((groupStageMatch != null) && (groupeStageMatchPart != null)) { 
			cc.append(SetCommand.create(editingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), groupeStageMatchPart.getHours())));
			cc.append(SetCommand.create(editingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), groupeStageMatchPart.getMinutes())));
			cc.append(SetCommand.create(editingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), groupeStageMatchPart.getCoefficient())));
			if (groupStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam1()) == null || !groupStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam1()).equals(groupeStageMatchPart.getTeam1())) {
				cc.append(SetCommand.create(editingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam1(), groupeStageMatchPart.getTeam1()));
			}
			if (groupStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam2()) == null || !groupStageMatch.eGet(WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam2()).equals(groupeStageMatchPart.getTeam2())) {
				cc.append(SetCommand.create(editingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam2(), groupeStageMatchPart.getTeam2()));
			}

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
		if (source instanceof GroupStageMatch) {
			GroupStageMatch groupStageMatchToUpdate = (GroupStageMatch)source;
			groupStageMatchToUpdate.setHours(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), groupeStageMatchPart.getHours()));

			groupStageMatchToUpdate.setMinutes(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), groupeStageMatchPart.getMinutes()));

			groupStageMatchToUpdate.setCoefficient(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), groupeStageMatchPart.getCoefficient()));

			groupStageMatchToUpdate.setManualTeam1((Team)groupeStageMatchPart.getTeam1());
			groupStageMatchToUpdate.setManualTeam2((Team)groupeStageMatchPart.getTeam2());

			return groupStageMatchToUpdate;
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
			if (WorldcupforecastViewsRepository.GroupeStageMatch.hours == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.GroupeStageMatch.minutes == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.GroupeStageMatch.coefficient == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.GroupeStageMatch.team1 == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam1(), event.getNewValue()));
			if (WorldcupforecastViewsRepository.GroupeStageMatch.team2 == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, groupStageMatch, WorldcupforecastPackage.eINSTANCE.getGroupStageMatch_ManualTeam2(), event.getNewValue()));

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
		return key == WorldcupforecastViewsRepository.GroupeStageMatch.hours || key == WorldcupforecastViewsRepository.GroupeStageMatch.minutes || key == WorldcupforecastViewsRepository.GroupeStageMatch.team1 || key == WorldcupforecastViewsRepository.GroupeStageMatch.team2;
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
				if (WorldcupforecastViewsRepository.GroupeStageMatch.hours == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.GroupeStageMatch.minutes == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.GroupeStageMatch.coefficient == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().getEAttributeType(), newValue);
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
			EObject copy = EcoreUtil.copy(groupStageMatch);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(groupStageMatch);
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
			groupStageMatch.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return groupeStageMatchPart.getTitle();
	}
}
