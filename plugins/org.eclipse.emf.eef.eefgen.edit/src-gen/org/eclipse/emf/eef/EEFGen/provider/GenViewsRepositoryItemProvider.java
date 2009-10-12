/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: GenViewsRepositoryItemProvider.java,v 1.3 2009/10/12 21:00:19 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenViewsRepository;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.eef.EEFGen.GenViewsRepository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenViewsRepositoryItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenViewsRepositoryItemProvider(AdapterFactory adapterFactory) {
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

			addViewsRepositoryPropertyDescriptor(object);
			addBasePackagePropertyDescriptor(object);
			addSwtViewsPropertyDescriptor(object);
			addFormViewsPropertyDescriptor(object);
			addHelpStrategyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Views Repository feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addViewsRepositoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenViewsRepository_viewsRepository_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenViewsRepository_viewsRepository_feature", "_UI_GenViewsRepository_type"),
				 EEFGenPackage.Literals.GEN_VIEWS_REPOSITORY__VIEWS_REPOSITORY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Base Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBasePackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenViewsRepository_basePackage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenViewsRepository_basePackage_feature", "_UI_GenViewsRepository_type"),
				 EEFGenPackage.Literals.GEN_VIEWS_REPOSITORY__BASE_PACKAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Swt Views feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSwtViewsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenViewsRepository_swtViews_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenViewsRepository_swtViews_feature", "_UI_GenViewsRepository_type"),
				 EEFGenPackage.Literals.GEN_VIEWS_REPOSITORY__SWT_VIEWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Form Views feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFormViewsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenViewsRepository_formViews_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenViewsRepository_formViews_feature", "_UI_GenViewsRepository_type"),
				 EEFGenPackage.Literals.GEN_VIEWS_REPOSITORY__FORM_VIEWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Help Strategy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHelpStrategyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenViewsRepository_helpStrategy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenViewsRepository_helpStrategy_feature", "_UI_GenViewsRepository_type"),
				 EEFGenPackage.Literals.GEN_VIEWS_REPOSITORY__HELP_STRATEGY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns GenViewsRepository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenViewsRepository"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenViewsRepository)object).getBasePackage();
		return label == null || label.length() == 0 ?
			getString("_UI_GenViewsRepository_type") :
			getString("_UI_GenViewsRepository_type") + " " + label;
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

		switch (notification.getFeatureID(GenViewsRepository.class)) {
			case EEFGenPackage.GEN_VIEWS_REPOSITORY__BASE_PACKAGE:
			case EEFGenPackage.GEN_VIEWS_REPOSITORY__SWT_VIEWS:
			case EEFGenPackage.GEN_VIEWS_REPOSITORY__FORM_VIEWS:
			case EEFGenPackage.GEN_VIEWS_REPOSITORY__HELP_STRATEGY:
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EEFGenEditPlugin.INSTANCE;
	}

}
