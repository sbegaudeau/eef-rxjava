/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *       Obeo - initial API and implementation
 *
 * $Id: ForecastItemProvider.java,v 1.1 2010/06/18 12:13:17 glefur Exp $
 */
package org.eclipse.worldcupforecast.provider;


import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;

/**
 * This is the item provider adapter for a {@link org.eclipse.worldcupforecast.Forecast} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForecastItemProvider
	extends ScoreItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForecastItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMatchPropertyDescriptor(object);
			addWinnerPropertyDescriptor(object);
			addScorePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Forecast_match_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Forecast_match_feature", "_UI_Forecast_type"),
				 WorldcupforecastPackage.Literals.FORECAST__MATCH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Winner feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWinnerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Forecast_winner_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Forecast_winner_feature", "_UI_Forecast_type"),
				 WorldcupforecastPackage.Literals.FORECAST__WINNER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null) {

					@Override
					protected Collection<?> getComboBoxObjects(Object object) {
						Forecast forecast = (Forecast) object;
						Match game = forecast.getMatch();
						ArrayList<Object> result = new ArrayList<Object>();
						Collection<?> resultTemp = super.getComboBoxObjects(forecast);
						for(Object o : resultTemp) {
							if(o != null && o instanceof Team) {
								if(((Team) o).equals(game.getTeam1()) || ((Team) o).equals(game.getTeam2())) {
									result.add(o);
								}
							}
						}
						
						return result;
					}
				
			});
	}

	/**
	 * This adds a property descriptor for the Score feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Forecast_score_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Forecast_score_feature", "_UI_Forecast_type"),
				 WorldcupforecastPackage.Literals.FORECAST__SCORE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Forecast.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Forecast"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Forecast forecast = (Forecast)object;
		Match game = forecast.getMatch();
		if(game != null) {
			String finalScoreString = "";
			FinalScore finalScore = game.getScore();
			if(finalScore != null) {
				finalScoreString = " | Final Score : " + finalScore.getScoreTeam1() + " - " + finalScore.getScoreTeam2();
			}
			String label = "";
			Match match = forecast.getMatch();
			if(match != null) {
				if(match.getTeam1() != null) {
					label += match.getTeam1().getName();
				}
				label += " " + forecast.getScoreTeam1() + " - " + forecast.getScoreTeam2();
				if(match.getTeam2() != null) {
					label += " " + match.getTeam2().getName();
				}
			}
			
			else {
				label += forecast.getScoreTeam1() + " - " + forecast.getScoreTeam2();
			}
			label += finalScoreString;
			return label;
		}
		return getString("_UI_Forecast_type") + " " + forecast.getScoreTeam1();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Forecast.class)) {
			case WorldcupforecastPackage.FORECAST__SCORE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
