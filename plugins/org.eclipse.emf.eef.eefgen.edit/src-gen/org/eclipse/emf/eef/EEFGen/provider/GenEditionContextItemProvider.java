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
 * $Id: GenEditionContextItemProvider.java,v 1.1 2009/04/30 17:12:37 glefur Exp $
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
import org.eclipse.emf.eef.EEFGen.GenEditionContext;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.eef.EEFGen.GenEditionContext} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenEditionContextItemProvider
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
	public GenEditionContextItemProvider(AdapterFactory adapterFactory) {
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

			addPropertiesEditionContextPropertyDescriptor(object);
			addBasePackagePropertyDescriptor(object);
			addGenDirectoryPropertyDescriptor(object);
			addSwtViewsPropertyDescriptor(object);
			addFormViewsPropertyDescriptor(object);
			addDescriptorsGenericPropertiesViewsPropertyDescriptor(object);
			addGmfPropertiesViewsPropertyDescriptor(object);
			addHelpStrategyPropertyDescriptor(object);
			addDescriptorsContributorIDPropertyDescriptor(object);
			addAuthorPropertyDescriptor(object);
			addLicensePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Properties Edition Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertiesEditionContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_PropertiesEditionContext_feature"),
				 getString("_UI_GenEditionContext_PropertiesEditionContext_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__PROPERTIES_EDITION_CONTEXT,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_ReferencesPropertyCategory"),
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
				 getString("_UI_GenEditionContext_basePackage_feature"),
				 getString("_UI_GenEditionContext_basePackage_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__BASE_PACKAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Gen Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_genDirectory_feature"),
				 getString("_UI_GenEditionContext_genDirectory_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__GEN_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ParametersPropertyCategory"),
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
				 getString("_UI_GenEditionContext_swtViews_feature"),
				 getString("_UI_GenEditionContext_swtViews_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__SWT_VIEWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ActivationPropertyCategory"),
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
				 getString("_UI_GenEditionContext_formViews_feature"),
				 getString("_UI_GenEditionContext_formViews_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__FORM_VIEWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ActivationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Descriptors Generic Properties Views feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptorsGenericPropertiesViewsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_descriptorsGenericPropertiesViews_feature"),
				 getString("_UI_GenEditionContext_descriptorsGenericPropertiesViews_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ActivationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Gmf Properties Views feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGmfPropertiesViewsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_gmfPropertiesViews_feature"),
				 getString("_UI_GenEditionContext_gmfPropertiesViews_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ActivationPropertyCategory"),
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
				 getString("_UI_GenEditionContext_helpStrategy_feature"),
				 getString("_UI_GenEditionContext_helpStrategy_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__HELP_STRATEGY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Descriptors Contributor ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptorsContributorIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_descriptorsContributorID_feature"),
				 getString("_UI_GenEditionContext_descriptorsContributorID_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Author feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuthorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_author_feature"),
				 getString("_UI_GenEditionContext_author_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__AUTHOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the License feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLicensePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenEditionContext_license_feature"),
				 getString("_UI_GenEditionContext_license_description"),
				 EEFGenPackage.Literals.GEN_EDITION_CONTEXT__LICENSE,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ParametersPropertyCategory"),
				 null));
	}

	/**
	 * This returns GenEditionContext.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenEditionContext"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenEditionContext)object).getBasePackage();
		return label == null || label.length() == 0 ?
			getString("_UI_GenEditionContext_type") :
			getString("_UI_GenEditionContext_type") + " " + label;
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

		switch (notification.getFeatureID(GenEditionContext.class)) {
			case EEFGenPackage.GEN_EDITION_CONTEXT__BASE_PACKAGE:
			case EEFGenPackage.GEN_EDITION_CONTEXT__GEN_DIRECTORY:
			case EEFGenPackage.GEN_EDITION_CONTEXT__SWT_VIEWS:
			case EEFGenPackage.GEN_EDITION_CONTEXT__FORM_VIEWS:
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_GENERIC_PROPERTIES_VIEWS:
			case EEFGenPackage.GEN_EDITION_CONTEXT__GMF_PROPERTIES_VIEWS:
			case EEFGenPackage.GEN_EDITION_CONTEXT__HELP_STRATEGY:
			case EEFGenPackage.GEN_EDITION_CONTEXT__DESCRIPTORS_CONTRIBUTOR_ID:
			case EEFGenPackage.GEN_EDITION_CONTEXT__AUTHOR:
			case EEFGenPackage.GEN_EDITION_CONTEXT__LICENSE:
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
