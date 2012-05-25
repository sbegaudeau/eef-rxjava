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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;

import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.parts.WorldCupForecastGroupPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldCupForecastMatchDayPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldCupForecastPLayerPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldCupForecastPlayersRatingPropertiesEditionPart;
import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class WorldCupForecastPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The WorldCupForecastGroup part
	 * 
	 */
	private WorldCupForecastGroupPropertiesEditionPart worldCupForecastGroupPart;

	/**
	 * The WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent sub component
	 * 
	 */
	protected WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent worldCupForecastWorldCupForecastGroupPropertiesEditionComponent;

	/**
	 * The WorldCupForecastPLayer part
	 * 
	 */
	private WorldCupForecastPLayerPropertiesEditionPart worldCupForecastPLayerPart;

	/**
	 * The WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent sub component
	 * 
	 */
	protected WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent worldCupForecastWorldCupForecastPLayerPropertiesEditionComponent;

	/**
	 * The WorldCupForecastMatchDay part
	 * 
	 */
	private WorldCupForecastMatchDayPropertiesEditionPart worldCupForecastMatchDayPart;

	/**
	 * The WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent sub component
	 * 
	 */
	protected WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent worldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent;

	/**
	 * The WorldCupForecastPlayersRating part
	 * 
	 */
	private WorldCupForecastPlayersRatingPropertiesEditionPart worldCupForecastPlayersRatingPart;

	/**
	 * The WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent sub component
	 * 
	 */
	protected WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent worldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param worldCupForecast the EObject to edit
	 * 
	 */
	public WorldCupForecastPropertiesEditionComponent(EObject worldCupForecast, String editing_mode) {
		super(editing_mode);
		if (worldCupForecast instanceof WorldCupForecast) {
			IPropertiesEditionProvider provider = null;
			provider = PropertiesEditionComponentService.getInstance().getProvider(worldCupForecast, WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.class);
			worldCupForecastWorldCupForecastGroupPropertiesEditionComponent = (WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent)provider.getPropertiesEditionComponent(worldCupForecast, editing_mode, WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.WORLDCUPFORECASTGROUP_PART, WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.class);
			addSubComponent(worldCupForecastWorldCupForecastGroupPropertiesEditionComponent);
			provider = PropertiesEditionComponentService.getInstance().getProvider(worldCupForecast, WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.class);
			worldCupForecastWorldCupForecastPLayerPropertiesEditionComponent = (WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent)provider.getPropertiesEditionComponent(worldCupForecast, editing_mode, WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.WORLDCUPFORECASTPLAYER_PART, WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.class);
			addSubComponent(worldCupForecastWorldCupForecastPLayerPropertiesEditionComponent);
			provider = PropertiesEditionComponentService.getInstance().getProvider(worldCupForecast, WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.class);
			worldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent = (WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent)provider.getPropertiesEditionComponent(worldCupForecast, editing_mode, WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.WORLDCUPFORECASTMATCHDAY_PART, WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.class);
			addSubComponent(worldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent);
			provider = PropertiesEditionComponentService.getInstance().getProvider(worldCupForecast, WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.class);
			worldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent = (WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent)provider.getPropertiesEditionComponent(worldCupForecast, editing_mode, WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.WORLDCUPFORECASTPLAYERSRATING_PART, WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.class);
			addSubComponent(worldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (WorldCupForecastWorldCupForecastGroupPropertiesEditionComponent.WORLDCUPFORECASTGROUP_PART.equals(key)) {
			worldCupForecastGroupPart = (WorldCupForecastGroupPropertiesEditionPart)worldCupForecastWorldCupForecastGroupPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)worldCupForecastGroupPart;
		}
		if (WorldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.WORLDCUPFORECASTPLAYER_PART.equals(key)) {
			worldCupForecastPLayerPart = (WorldCupForecastPLayerPropertiesEditionPart)worldCupForecastWorldCupForecastPLayerPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)worldCupForecastPLayerPart;
		}
		if (WorldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.WORLDCUPFORECASTMATCHDAY_PART.equals(key)) {
			worldCupForecastMatchDayPart = (WorldCupForecastMatchDayPropertiesEditionPart)worldCupForecastWorldCupForecastMatchDayPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)worldCupForecastMatchDayPart;
		}
		if (WorldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.WORLDCUPFORECASTPLAYERSRATING_PART.equals(key)) {
			worldCupForecastPlayersRatingPart = (WorldCupForecastPlayersRatingPropertiesEditionPart)worldCupForecastWorldCupForecastPlayersRatingPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)worldCupForecastPlayersRatingPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (WorldcupforecastViewsRepository.WorldCupForecastGroup.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			worldCupForecastGroupPart = (WorldCupForecastGroupPropertiesEditionPart)propertiesEditionPart;
		}
		if (WorldcupforecastViewsRepository.WorldCupForecastPLayer.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			worldCupForecastPLayerPart = (WorldCupForecastPLayerPropertiesEditionPart)propertiesEditionPart;
		}
		if (WorldcupforecastViewsRepository.WorldCupForecastMatchDay.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			worldCupForecastMatchDayPart = (WorldCupForecastMatchDayPropertiesEditionPart)propertiesEditionPart;
		}
		if (WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			worldCupForecastPlayersRatingPart = (WorldCupForecastPlayersRatingPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == WorldcupforecastViewsRepository.WorldCupForecastGroup.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastPLayer.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastMatchDay.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
