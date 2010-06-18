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
package org.eclipse.worldcupforecast.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.components.WorldCupForecastPropertiesEditionComponent;
import org.eclipse.worldcupforecast.components.WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent;
import org.eclipse.worldcupforecast.components.WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent;
import org.eclipse.worldcupforecast.components.WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent;
import org.eclipse.worldcupforecast.components.WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent;

/**
 * 
 * 
 */
public class WorldCupForecastPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof WorldCupForecast) && (WorldcupforecastPackage.eINSTANCE.getWorldCupForecast() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof WorldCupForecast) && (WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.WORLDCUPFORECASTGROUP_PART.equals(part) || WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.WORLDCUPFORECASTPLAYER_PART.equals(part) || WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.WORLDCUPFORECASTMATCHDAY_PART.equals(part) || WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.WORLDCUPFORECASTPLAYERSRATING_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof WorldCupForecast) && (refinement == WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.class || refinement == WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.class || refinement == WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.class || refinement == WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof WorldCupForecast) && ((WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.WORLDCUPFORECASTGROUP_PART.equals(part) && refinement == WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.class) || (WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.WORLDCUPFORECASTPLAYER_PART.equals(part) && refinement == WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.class) || (WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.WORLDCUPFORECASTMATCHDAY_PART.equals(part) && refinement == WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.class) || (WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.WORLDCUPFORECASTPLAYERSRATING_PART.equals(part) && refinement == WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof WorldCupForecast) {
			return new WorldCupForecastPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof WorldCupForecast) {
			if (WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.WORLDCUPFORECASTGROUP_PART.equals(part))
				return new WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent(eObject, editing_mode);
			if (WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.WORLDCUPFORECASTPLAYER_PART.equals(part))
				return new WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent(eObject, editing_mode);
			if (WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.WORLDCUPFORECASTMATCHDAY_PART.equals(part))
				return new WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent(eObject, editing_mode);
			if (WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.WORLDCUPFORECASTPLAYERSRATING_PART.equals(part))
				return new WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String, java.lang.Class)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part, java.lang.Class refinement) {
		if (eObject instanceof WorldCupForecast) {
			if (WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.WORLDCUPFORECASTGROUP_PART.equals(part)
				&& refinement == WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.class)
				return new WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent(eObject, editing_mode);
			if (WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.WORLDCUPFORECASTPLAYER_PART.equals(part)
				&& refinement == WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.class)
				return new WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent(eObject, editing_mode);
			if (WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.WORLDCUPFORECASTMATCHDAY_PART.equals(part)
				&& refinement == WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.class)
				return new WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent(eObject, editing_mode);
			if (WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.WORLDCUPFORECASTPLAYERSRATING_PART.equals(part)
				&& refinement == WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.class)
				return new WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
