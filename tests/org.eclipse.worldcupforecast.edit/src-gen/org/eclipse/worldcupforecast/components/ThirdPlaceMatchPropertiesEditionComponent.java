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

import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.ThirdPlaceMatch;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.ThirdPlaceMatchPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class ThirdPlaceMatchPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String THIRDPLACEMATCH_PART = "ThirdPlaceMatch"; //$NON-NLS-1$

	
	private String[] parts = {THIRDPLACEMATCH_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private ThirdPlaceMatch thirdPlaceMatch;

	/**
	 * The ThirdPlaceMatch part
	 * 
	 */
	protected ThirdPlaceMatchPropertiesEditionPart thirdPlaceMatchPart;

	/**
	 * Default constructor
	 * 
	 */
	public ThirdPlaceMatchPropertiesEditionComponent(EObject thirdPlaceMatch, String editing_mode) {
		if (thirdPlaceMatch instanceof ThirdPlaceMatch) {
			this.thirdPlaceMatch = (ThirdPlaceMatch)thirdPlaceMatch;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.thirdPlaceMatch.eAdapters().add(semanticAdapter);
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
				if (thirdPlaceMatchPart == null)
					ThirdPlaceMatchPropertiesEditionComponent.this.dispose();
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
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Hours().equals(msg.getFeature()) && thirdPlaceMatchPart != null){
			if (msg.getNewValue() != null) {
				thirdPlaceMatchPart.setHours(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				thirdPlaceMatchPart.setHours("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().equals(msg.getFeature()) && thirdPlaceMatchPart != null){
			if (msg.getNewValue() != null) {
				thirdPlaceMatchPart.setMinutes(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				thirdPlaceMatchPart.setMinutes("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient().equals(msg.getFeature()) && thirdPlaceMatchPart != null){
			if (msg.getNewValue() != null) {
				thirdPlaceMatchPart.setCoefficient(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				thirdPlaceMatchPart.setCoefficient("");
			}
		}
		if (WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team1LooserOfMatch().equals(msg.getFeature()) && thirdPlaceMatchPart != null)
			thirdPlaceMatchPart.setTeam1LooserOfMatch((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team2LooserOfMatch().equals(msg.getFeature()) && thirdPlaceMatchPart != null)
			thirdPlaceMatchPart.setTeam2LooserOfMatch((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Team1().equals(msg.getFeature()) && thirdPlaceMatchPart != null)
			thirdPlaceMatchPart.setTeam1((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getMatch_Team2().equals(msg.getFeature()) && thirdPlaceMatchPart != null)
			thirdPlaceMatchPart.setTeam2((EObject)msg.getNewValue());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (THIRDPLACEMATCH_PART.equals(key))
			return WorldcupforecastViewsRepository.ThirdPlaceMatch.class;
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
		if (thirdPlaceMatch != null && THIRDPLACEMATCH_PART.equals(key)) {
			if (thirdPlaceMatchPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					thirdPlaceMatchPart = (ThirdPlaceMatchPropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.ThirdPlaceMatch.class, kind, this);
					addListener((IPropertiesEditionListener)thirdPlaceMatchPart);
				}
			}
			return (IPropertiesEditionPart)thirdPlaceMatchPart;
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
		if (key == WorldcupforecastViewsRepository.ThirdPlaceMatch.class)
			this.thirdPlaceMatchPart = (ThirdPlaceMatchPropertiesEditionPart) propertiesEditionPart;
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
		if (thirdPlaceMatchPart != null && key == WorldcupforecastViewsRepository.ThirdPlaceMatch.class) {
			((IPropertiesEditionPart)thirdPlaceMatchPart).setContext(elt, allResource);
			final ThirdPlaceMatch thirdPlaceMatch = (ThirdPlaceMatch)elt;
			// init values
			thirdPlaceMatchPart.setHours(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatch.getHours()));

			thirdPlaceMatchPart.setMinutes(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatch.getMinutes()));

			thirdPlaceMatchPart.setCoefficient(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatch.getCoefficient()));

			// init part
			thirdPlaceMatchPart.initTeam1LooserOfMatch(allResource, thirdPlaceMatch.getTeam1LooserOfMatch());
			// set the button mode
			thirdPlaceMatchPart.setTeam1LooserOfMatchButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			thirdPlaceMatchPart.initTeam2LooserOfMatch(allResource, thirdPlaceMatch.getTeam2LooserOfMatch());
			// set the button mode
			thirdPlaceMatchPart.setTeam2LooserOfMatchButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			thirdPlaceMatchPart.initTeam1(allResource, thirdPlaceMatch.getTeam1());
			// set the button mode
			thirdPlaceMatchPart.setTeam1ButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			thirdPlaceMatchPart.initTeam2(allResource, thirdPlaceMatch.getTeam2());
			// set the button mode
			thirdPlaceMatchPart.setTeam2ButtonMode(ButtonsModeEnum.BROWSE);
			// init filters



			thirdPlaceMatchPart.addFilterToTeam1LooserOfMatch(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Match);
				}

			});
			// Start of user code for additional businessfilters for team1LooserOfMatch
			
			// End of user code

			thirdPlaceMatchPart.addFilterToTeam2LooserOfMatch(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Match);
				}

			});
			// Start of user code for additional businessfilters for team2LooserOfMatch
			
			// End of user code

			thirdPlaceMatchPart.addFilterToTeam1(new ViewerFilter() {

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

			thirdPlaceMatchPart.addFilterToTeam2(new ViewerFilter() {

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
		if ((thirdPlaceMatch != null) && (thirdPlaceMatchPart != null)) { 
			cc.append(SetCommand.create(editingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatchPart.getHours())));
			cc.append(SetCommand.create(editingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatchPart.getMinutes())));
			cc.append(SetCommand.create(editingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatchPart.getCoefficient())));
			if (thirdPlaceMatch.eGet(WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team1LooserOfMatch()) == null || !thirdPlaceMatch.eGet(WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team1LooserOfMatch()).equals(thirdPlaceMatchPart.getTeam1LooserOfMatch())) {
				cc.append(SetCommand.create(editingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team1LooserOfMatch(), thirdPlaceMatchPart.getTeam1LooserOfMatch()));
			}
			if (thirdPlaceMatch.eGet(WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team2LooserOfMatch()) == null || !thirdPlaceMatch.eGet(WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team2LooserOfMatch()).equals(thirdPlaceMatchPart.getTeam2LooserOfMatch())) {
				cc.append(SetCommand.create(editingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team2LooserOfMatch(), thirdPlaceMatchPart.getTeam2LooserOfMatch()));
			}
// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in widgetControl.mtl module, with the values : team1, ThirdPlaceMatch, thirdPlaceMatch, thirdPlaceMatch.
// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in widgetControl.mtl module, with the values : team2, ThirdPlaceMatch, thirdPlaceMatch, thirdPlaceMatch.

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
		if (source instanceof ThirdPlaceMatch) {
			ThirdPlaceMatch thirdPlaceMatchToUpdate = (ThirdPlaceMatch)source;
			thirdPlaceMatchToUpdate.setHours(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatchPart.getHours()));

			thirdPlaceMatchToUpdate.setMinutes(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatchPart.getMinutes()));

			thirdPlaceMatchToUpdate.setCoefficient(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), thirdPlaceMatchPart.getCoefficient()));

			thirdPlaceMatchToUpdate.setTeam1LooserOfMatch((Match)thirdPlaceMatchPart.getTeam1LooserOfMatch());
			thirdPlaceMatchToUpdate.setTeam2LooserOfMatch((Match)thirdPlaceMatchPart.getTeam2LooserOfMatch());
// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : team1, ThirdPlaceMatch, thirdPlaceMatch, thirdPlaceMatch.
// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : team2, ThirdPlaceMatch, thirdPlaceMatch, thirdPlaceMatch.

			return thirdPlaceMatchToUpdate;
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
			if (WorldcupforecastViewsRepository.ThirdPlaceMatch.hours == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Hours(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.ThirdPlaceMatch.minutes == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Minutes(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.ThirdPlaceMatch.coefficient == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getMatch_Coefficient(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.ThirdPlaceMatch.team1LooserOfMatch == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team1LooserOfMatch(), event.getNewValue()));
			if (WorldcupforecastViewsRepository.ThirdPlaceMatch.team2LooserOfMatch == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, thirdPlaceMatch, WorldcupforecastPackage.eINSTANCE.getThirdPlaceMatch_Team2LooserOfMatch(), event.getNewValue()));
// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in widgetControl.mtl module, with the values : team1, ThirdPlaceMatch, thirdPlaceMatch.
// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in widgetControl.mtl module, with the values : team2, ThirdPlaceMatch, thirdPlaceMatch.

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
		return key == WorldcupforecastViewsRepository.ThirdPlaceMatch.hours || key == WorldcupforecastViewsRepository.ThirdPlaceMatch.minutes || key == WorldcupforecastViewsRepository.ThirdPlaceMatch.team1LooserOfMatch || key == WorldcupforecastViewsRepository.ThirdPlaceMatch.team2LooserOfMatch || key == WorldcupforecastViewsRepository.ThirdPlaceMatch.team1 || key == WorldcupforecastViewsRepository.ThirdPlaceMatch.team2;
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
				if (WorldcupforecastViewsRepository.ThirdPlaceMatch.hours == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Hours().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.ThirdPlaceMatch.minutes == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getMatch_Minutes().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.ThirdPlaceMatch.coefficient == event.getAffectedEditor()) {
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
			EObject copy = EcoreUtil.copy(thirdPlaceMatch);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(thirdPlaceMatch);
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
			thirdPlaceMatch.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return thirdPlaceMatchPart.getTitle();
	}
}
