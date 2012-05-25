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
package org.eclipse.worldcupforecast.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.parts.forms.FinalScorePropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.ForecastDayPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.ForecastPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.GroupeStageMatchPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.MatchDayPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.OtherKnockoutStageGamePropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.PlayerPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.RoundOfSixteenMatchPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.TeamPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.ThirdPlaceMatchPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.WorldCupForecastGroupPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.WorldCupForecastMatchDayPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.WorldCupForecastPLayerPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.WorldCupForecastPlayersRatingPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.forms.WorldCupGroupPropertiesEditionPartForm;
import org.eclipse.worldcupforecast.parts.impl.FinalScorePropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.ForecastDayPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.ForecastPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.GroupeStageMatchPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.MatchDayPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.OtherKnockoutStageGamePropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.PlayerPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.RoundOfSixteenMatchPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.TeamPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.ThirdPlaceMatchPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.WorldCupForecastGroupPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.WorldCupForecastMatchDayPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.WorldCupForecastPLayerPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.WorldCupForecastPlayersRatingPropertiesEditionPartImpl;
import org.eclipse.worldcupforecast.parts.impl.WorldCupGroupPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class WorldcupforecastPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 * 
	 */
	public boolean provides(java.lang.Class key) {
		return key == WorldcupforecastViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == WorldcupforecastViewsRepository.Forecast.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new ForecastPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new ForecastPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.Team.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new TeamPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new TeamPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.FinalScore.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new FinalScorePropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new FinalScorePropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.MatchDay.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new MatchDayPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new MatchDayPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.ForecastDay.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new ForecastDayPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new ForecastDayPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupGroup.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new WorldCupGroupPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new WorldCupGroupPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastGroup.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new WorldCupForecastGroupPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new WorldCupForecastGroupPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastPLayer.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new WorldCupForecastPLayerPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new WorldCupForecastPLayerPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastMatchDay.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new WorldCupForecastMatchDayPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new WorldCupForecastMatchDayPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.Player.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new PlayerPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new PlayerPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.GroupeStageMatch.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new GroupeStageMatchPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new GroupeStageMatchPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.OtherKnockoutStageGame.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new OtherKnockoutStageGamePropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new OtherKnockoutStageGamePropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new WorldCupForecastPlayersRatingPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new WorldCupForecastPlayersRatingPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.RoundOfSixteenMatch.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new RoundOfSixteenMatchPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new RoundOfSixteenMatchPropertiesEditionPartForm(component);
		}
		if (key == WorldcupforecastViewsRepository.ThirdPlaceMatch.class) {
			if (kind == WorldcupforecastViewsRepository.SWT_KIND)
				return new ThirdPlaceMatchPropertiesEditionPartImpl(component);
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new ThirdPlaceMatchPropertiesEditionPartForm(component);
		}
		return null;
	}

}
