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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.worldcupforecast.RoundOfSixteenMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldCupGroup;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.RoundOfSixteenMatchPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class RoundOfSixteenMatchPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private RoundOfSixteenMatch roundOfSixteenMatch;

	/**
	 * The Base part
	 * 
	 */
	protected RoundOfSixteenMatchPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
	 */
	public RoundOfSixteenMatchPropertiesEditionComponent(EObject roundOfSixteenMatch, String editing_mode) {
		if (roundOfSixteenMatch instanceof RoundOfSixteenMatch) {
			this.roundOfSixteenMatch = (RoundOfSixteenMatch)roundOfSixteenMatch;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.roundOfSixteenMatch.eAdapters().add(semanticAdapter);
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
					RoundOfSixteenMatchPropertiesEditionComponent.this.dispose();
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
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Hours().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setHours(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setHours("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setMinutes(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setMinutes("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setCoefficient(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setCoefficient("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team1WinnerOfGroup().equals(msg.getFeature()) && basePart != null)
			basePart.setTeam1WinnerOfGroup((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team2RunnerUpOfGroup().equals(msg.getFeature()) && basePart != null)
			basePart.setTeam2RunnerupOfGroup((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Team1().equals(msg.getFeature()) && basePart != null)
			basePart.setTeam1((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Team2().equals(msg.getFeature()) && basePart != null)
			basePart.setTeam2((EObject)msg.getNewValue());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return WorldcupforecastViewsRepository.RoundOfSixteenMatch.class;
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
		if (roundOfSixteenMatch != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					basePart = (RoundOfSixteenMatchPropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.RoundOfSixteenMatch.class, kind, this);
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
		if (key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.class)
			this.basePart = (RoundOfSixteenMatchPropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final RoundOfSixteenMatch roundOfSixteenMatch = (RoundOfSixteenMatch)elt;
			// init values
			basePart.setHours(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), roundOfSixteenMatch.getHours()));

			basePart.setMinutes(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), roundOfSixteenMatch.getMinutes()));

			basePart.setCoefficient(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), roundOfSixteenMatch.getCoefficient()));

			// init part
			basePart.initTeam1WinnerOfGroup(allResource, roundOfSixteenMatch.getTeam1WinnerOfGroup());
			// set the button mode
			basePart.setTeam1WinnerOfGroupButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initTeam2RunnerupOfGroup(allResource, roundOfSixteenMatch.getTeam2RunnerUpOfGroup());
			// set the button mode
			basePart.setTeam2RunnerupOfGroupButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initTeam1(allResource, roundOfSixteenMatch.getTeam1());
			// set the button mode
			basePart.setTeam1ButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initTeam2(allResource, roundOfSixteenMatch.getTeam2());
			// set the button mode
			basePart.setTeam2ButtonMode(ButtonsModeEnum.BROWSE);
			// init filters



			basePart.addFilterToTeam1WinnerOfGroup(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof WorldCupGroup);
				}

			});
			// Start of user code for additional businessfilters for team1WinnerOfGroup
			
			// End of user code

			basePart.addFilterToTeam2RunnerupOfGroup(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof WorldCupGroup);
				}

			});
			// Start of user code for additional businessfilters for team2RunnerUpOfGroup
			
			// End of user code

			basePart.addFilterToTeam1(new ViewerFilter() {

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

			basePart.addFilterToTeam2(new ViewerFilter() {

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
		if ((roundOfSixteenMatch != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getHours())));
			cc.append(SetCommand.create(editingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getMinutes())));
			cc.append(SetCommand.create(editingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getCoefficient())));
			if (roundOfSixteenMatch.eGet(WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team1WinnerOfGroup()) == null || !roundOfSixteenMatch.eGet(WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team1WinnerOfGroup()).equals(basePart.getTeam1WinnerOfGroup())) {
				cc.append(SetCommand.create(editingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team1WinnerOfGroup(), basePart.getTeam1WinnerOfGroup()));
			}
			if (roundOfSixteenMatch.eGet(WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team2RunnerUpOfGroup()) == null || !roundOfSixteenMatch.eGet(WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team2RunnerUpOfGroup()).equals(basePart.getTeam2RunnerupOfGroup())) {
				cc.append(SetCommand.create(editingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team2RunnerUpOfGroup(), basePart.getTeam2RunnerupOfGroup()));
			}
// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in widgetControl.mtl module, with the values : team1, RoundOfSixteenMatch, RoundOfSixteenMatch, roundOfSixteenMatch.
// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in widgetControl.mtl module, with the values : team2, RoundOfSixteenMatch, RoundOfSixteenMatch, roundOfSixteenMatch.

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
		if (source instanceof RoundOfSixteenMatch) {
			RoundOfSixteenMatch roundOfSixteenMatchToUpdate = (RoundOfSixteenMatch)source;
			roundOfSixteenMatchToUpdate.setHours(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getHours()));

			roundOfSixteenMatchToUpdate.setMinutes(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getMinutes()));

			roundOfSixteenMatchToUpdate.setCoefficient(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getCoefficient()));

			roundOfSixteenMatchToUpdate.setTeam1WinnerOfGroup((WorldCupGroup)basePart.getTeam1WinnerOfGroup());
			roundOfSixteenMatchToUpdate.setTeam2RunnerUpOfGroup((WorldCupGroup)basePart.getTeam2RunnerupOfGroup());
// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : team1, RoundOfSixteenMatch, RoundOfSixteenMatch, roundOfSixteenMatch.
// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : team2, RoundOfSixteenMatch, RoundOfSixteenMatch, roundOfSixteenMatch.

			return roundOfSixteenMatchToUpdate;
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
			if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.coefficient == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1WinnerOfGroup == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team1WinnerOfGroup(), event.getNewValue()));
			if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2RunnerupOfGroup == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, roundOfSixteenMatch, WorldcupforecastPackage.eINSTANCE.getRoundOfSixteenMatch_Team2RunnerUpOfGroup(), event.getNewValue()));
// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in widgetControl.mtl module, with the values : team1, RoundOfSixteenMatch, roundOfSixteenMatch.
// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in widgetControl.mtl module, with the values : team2, RoundOfSixteenMatch, roundOfSixteenMatch.

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
		return key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours || key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes || key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1WinnerOfGroup || key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2RunnerupOfGroup || key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.team1 || key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.team2;
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
				if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.hours == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.minutes == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.RoundOfSixteenMatch.coefficient == event.getAffectedEditor()) {
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
			EObject copy = EcoreUtil.copy(roundOfSixteenMatch);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(roundOfSixteenMatch);
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
			roundOfSixteenMatch.eAdapters().remove(semanticAdapter);
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
