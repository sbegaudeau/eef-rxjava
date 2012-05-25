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
package org.eclipse.worldcupforecast.provider;


import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.OtherKnockoutStageMatch;
import org.eclipse.worldcupforecast.RoundOfSixteenMatch;
import org.eclipse.worldcupforecast.WorldCupGroup;
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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OtherKnockoutStageMatchItemProvider
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
	public OtherKnockoutStageMatchItemProvider(AdapterFactory adapterFactory) {
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

			addTeam1WinnerOfMatchPropertyDescriptor(object);
			addTeam2WinnerOfMatchPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Team1 Winner Of Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTeam1WinnerOfMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OtherKnockoutStageMatch_team1WinnerOfMatch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OtherKnockoutStageMatch_team1WinnerOfMatch_feature", "_UI_OtherKnockoutStageMatch_type"),
				 WorldcupforecastPackage.Literals.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Team2 Winner Of Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTeam2WinnerOfMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OtherKnockoutStageMatch_team2WinnerOfMatch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OtherKnockoutStageMatch_team2WinnerOfMatch_feature", "_UI_OtherKnockoutStageMatch_type"),
				 WorldcupforecastPackage.Literals.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OtherKnockoutStageMatch_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OtherKnockoutStageMatch_type_feature", "_UI_OtherKnockoutStageMatch_type"),
				 WorldcupforecastPackage.Literals.OTHER_KNOCKOUT_STAGE_MATCH__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns OtherKnockoutStageMatch.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OtherKnockoutStageMatch"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		OtherKnockoutStageMatch match = (OtherKnockoutStageMatch)object;
		String label = match.getName();
		if(label == null || label.length() == 0) {
			label = "";
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
			Match match1 = match.getTeam1WinnerOfMatch();
			Match match2 = match.getTeam2WinnerOfMatch();
			
			if(match1 != null) {
				if(match1 instanceof RoundOfSixteenMatch) {
					WorldCupGroup group1 = ((RoundOfSixteenMatch)match1).getTeam1WinnerOfGroup();
					WorldCupGroup group2 = ((RoundOfSixteenMatch)match1).getTeam2RunnerUpOfGroup();
					if(group1 != null) {
						label += "(1" + group1.getName() + "-";
					}
					if(group2 != null) {
						label += "2" + group2.getName() + ") ";
					}
				}
				else {
					label += labelProvider.getText(match1);
				}
			}
			if(match2 != null)
				if(match2 instanceof RoundOfSixteenMatch) {
					WorldCupGroup group1 = ((RoundOfSixteenMatch)match2).getTeam1WinnerOfGroup();
					WorldCupGroup group2 = ((RoundOfSixteenMatch)match2).getTeam2RunnerUpOfGroup();
					if(group1 != null) {
						label += "(1" + group1.getName() + "-";
					}
					if(group2 != null) {
						label += "2" + group2.getName() + ") ";
					}
				}
				else {
					label += labelProvider.getText(match2);
				}
		}
		return label == null || label.length() == 0 ?
				((OtherKnockoutStageMatch)object).getType().getLiteral() :
			((OtherKnockoutStageMatch)object).getType().getLiteral()+ " " + label;
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

		switch (notification.getFeatureID(OtherKnockoutStageMatch.class)) {
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TYPE:
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
