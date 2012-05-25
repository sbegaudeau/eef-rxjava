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
package org.eclipse.worldcupforecast.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;
import org.eclipse.worldcupforecast.parts.forms.ForecastPropertiesEditionPartFormCustom;
import org.eclipse.worldcupforecast.parts.forms.TeamPropertiesEditionPartFormCustom;
import org.eclipse.worldcupforecast.parts.forms.WorldCupForecastPlayersRatingPropertiesEditionPartFormCustom;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class WorldcupforecastPropertiesEditionPartProviderCustom extends
		WorldcupforecastPropertiesEditionPartProvider {
	@Override
	public IPropertiesEditionPart getPropertiesEditionPart(Class key, int kind,
			IPropertiesEditionComponent component) {
		
		if (key == WorldcupforecastViewsRepository.Forecast.class) {
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new ForecastPropertiesEditionPartFormCustom(component);
		}
		
		if (key == WorldcupforecastViewsRepository.Team.class) {;
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new TeamPropertiesEditionPartFormCustom(component);
		}
		
		if (key == WorldcupforecastViewsRepository.WorldCupForecastPlayersRating.class) {
			if (kind == WorldcupforecastViewsRepository.FORM_KIND)
				return new WorldCupForecastPlayersRatingPropertiesEditionPartFormCustom(component);
		}
		
		return super.getPropertiesEditionPart(key, kind, component);
	}

}
