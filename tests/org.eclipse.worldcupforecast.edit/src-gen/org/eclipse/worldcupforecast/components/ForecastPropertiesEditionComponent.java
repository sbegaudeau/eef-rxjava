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
import java.util.Collection;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.parts.ForecastPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
	

// End of user code

/**
 * 
 * 
 */
public class ForecastPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private Forecast forecast;

	/**
	 * The Base part
	 * 
	 */
	protected ForecastPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
	 */
	public ForecastPropertiesEditionComponent(EObject forecast, String editing_mode) {
		if (forecast instanceof Forecast) {
			this.forecast = (Forecast)forecast;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.forecast.eAdapters().add(semanticAdapter);
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
					ForecastPropertiesEditionComponent.this.dispose();
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
		if (WorldcupforecastPackage.eINSTANCE.getForecast_Match().equals(msg.getFeature()) && basePart != null)
			basePart.setMatch((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getForecast_Winner().equals(msg.getFeature()) && basePart != null)
			basePart.setWinner((EObject)msg.getNewValue());
		if (WorldcupforecastPackage.eINSTANCE.getForecast_Score().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setScore(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				basePart.setScore("");
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
			return WorldcupforecastViewsRepository.Forecast.class;
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
		if (forecast != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(WorldcupforecastViewsRepository.class);
				if (provider != null) {
					basePart = (ForecastPropertiesEditionPart)provider.getPropertiesEditionPart(WorldcupforecastViewsRepository.Forecast.class, kind, this);
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
		if (key == WorldcupforecastViewsRepository.Forecast.class)
			this.basePart = (ForecastPropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == WorldcupforecastViewsRepository.Forecast.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Forecast forecast = (Forecast)elt;
			// init values
			basePart.setScoreTeam1(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), forecast.getScoreTeam1()));

			basePart.setScoreTeam2(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), forecast.getScoreTeam2()));

			// init part
			basePart.initMatch(allResource, forecast.getMatch());
			// set the button mode
			basePart.setMatchButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initWinner(allResource, forecast.getWinner());
			// set the button mode
			basePart.setWinnerButtonMode(ButtonsModeEnum.BROWSE);
			basePart.setScore(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), forecast.getScore()));

			// init filters


			basePart.addFilterToMatch(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Match);
				}

			});
			// Start of user code for additional businessfilters for match
			
			// End of user code

			basePart.addFilterToWinner(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Team); //$NON-NLS-1$ 
				}

			});
			basePart.addFilterToWinner(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					Object result = EEFUtils.choiceOfValues(ForecastPropertiesEditionComponent.this.forecast, WorldcupforecastPackage.eINSTANCE.getForecast_Winner());
					if (result instanceof Collection) {
						return ((Collection)result).contains(element);
					} else if (result instanceof ResourceSet && element instanceof EObject) {
						return ((EObject)element).eResource() != null && ((EObject)element).eResource().getResourceSet() != null && ((EObject)element).eResource().getResourceSet().equals(result);
					}
					return element instanceof Resource;
				}
			});
			// Start of user code for additional businessfilters for winner
			
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
		if ((forecast != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam1())));
			cc.append(SetCommand.create(editingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam2())));
			if (forecast.eGet(WorldcupforecastPackage.eINSTANCE.getForecast_Match()) == null || !forecast.eGet(WorldcupforecastPackage.eINSTANCE.getForecast_Match()).equals(basePart.getMatch())) {
				cc.append(SetCommand.create(editingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getForecast_Match(), basePart.getMatch()));
			}
			if (forecast.eGet(WorldcupforecastPackage.eINSTANCE.getForecast_Winner()) == null || !forecast.eGet(WorldcupforecastPackage.eINSTANCE.getForecast_Winner()).equals(basePart.getWinner())) {
				cc.append(SetCommand.create(editingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getForecast_Winner(), basePart.getWinner()));
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
		if (source instanceof Forecast) {
			Forecast forecastToUpdate = (Forecast)source;
			forecastToUpdate.setScoreTeam1(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam1()));

			forecastToUpdate.setScoreTeam2(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), basePart.getScoreTeam2()));

			forecastToUpdate.setMatch((Match)basePart.getMatch());
			forecastToUpdate.setWinner((Team)basePart.getWinner());

			return forecastToUpdate;
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
			if (WorldcupforecastViewsRepository.Forecast.scoreTeam1 == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.Forecast.scoreTeam2 == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}
			if (WorldcupforecastViewsRepository.Forecast.match == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getForecast_Match(), event.getNewValue()));
			if (WorldcupforecastViewsRepository.Forecast.winner == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, forecast, WorldcupforecastPackage.eINSTANCE.getForecast_Winner(), event.getNewValue()));
			// do not generates command for derived attribute score

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
		return key == WorldcupforecastViewsRepository.Forecast.match;
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
				if (WorldcupforecastViewsRepository.Forecast.scoreTeam1 == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam1().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Forecast.scoreTeam2 == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getScore_ScoreTeam2().getEAttributeType(), newValue);
				}
				if (WorldcupforecastViewsRepository.Forecast.score == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(WorldcupforecastPackage.eINSTANCE.getForecast_Score().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(WorldcupforecastPackage.eINSTANCE.getForecast_Score().getEAttributeType(), newValue);
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
			EObject copy = EcoreUtil.copy(forecast);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(forecast);
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
			forecast.eAdapters().remove(semanticAdapter);
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
