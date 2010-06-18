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
package org.eclipse.worldcupforecast.utils;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.WorldCupForecast;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class WorldCupForecastHelper {

	/**
	 * provide the first worldcupforecast instance from model (and probably the only one)
	 * @param rset the resource set
	 * @return the worldcupforecast instance
	 */
	public static WorldCupForecast findFirstWorldCupForecastInstance(ResourceSet rset) {
		TreeIterator<Notifier> allContents = rset.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof WorldCupForecast)
				return (WorldCupForecast)next;
		}
		return null;
	}
	
	/**
	 * provide the first met forecastday instance from resourceSet
	 * @param rset the resource set
	 * @return the first forecastday instance from resourceSet 
	 */
	public static ForecastDay findFirstForecastDayInstance(ResourceSet rset) {
		TreeIterator<Notifier> allContents = rset.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof ForecastDay)
				return (ForecastDay)next;
		}
		return null;
	}
	
	/**
	 * 
	 * @param resourceSet
	 * @return
	 */
	public static Player findFirstPlayerInstance(ResourceSet resourceSet) {
		TreeIterator<Notifier> allContents = resourceSet.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof Player)
				return (Player)next;
		}
		return null;
		
	}
	
	/**
	 * 
	 * @param resourceSet
	 * @return
	 */
	public static Player findFirstPlayerInstance(Resource resource) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof Player)
				return (Player)next;
		}
		return null;
		
	}
}
