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
 * $Id: ThirdPlaceMatchItemProvider.java,v 1.1 2010/06/18 12:13:17 glefur Exp $
 */
package org.eclipse.worldcupforecast.provider;


import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.ThirdPlaceMatch;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

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
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.worldcupforecast.ThirdPlaceMatch} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ThirdPlaceMatchItemProvider
	extends KnockoutStageMatchItemProvider
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
	public ThirdPlaceMatchItemProvider(AdapterFactory adapterFactory) {
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

			addTeam1LooserOfMatchPropertyDescriptor(object);
			addTeam2LooserOfMatchPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Team1 Looser Of Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTeam1LooserOfMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThirdPlaceMatch_team1LooserOfMatch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThirdPlaceMatch_team1LooserOfMatch_feature", "_UI_ThirdPlaceMatch_type"),
				 WorldcupforecastPackage.Literals.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Team2 Looser Of Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTeam2LooserOfMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThirdPlaceMatch_team2LooserOfMatch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThirdPlaceMatch_team2LooserOfMatch_feature", "_UI_ThirdPlaceMatch_type"),
				 WorldcupforecastPackage.Literals.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns ThirdPlaceMatch.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ThirdPlaceMatch"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ThirdPlaceMatch match = (ThirdPlaceMatch)object;
		String label = match.getName();
		if(label == null || label.length() == 0) {
			label = "";
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
			Match match1 = match.getTeam1LooserOfMatch();
			Match match2 = match.getTeam2LooserOfMatch();
			
			if(match1 != null) {
				label += labelProvider.getText(match1);
			}
			if(match2 != null)
				label += labelProvider.getText(match2);
		}
		return label == null || label.length() == 0 ?
				"Third place" :
					"Third place " + label;
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
