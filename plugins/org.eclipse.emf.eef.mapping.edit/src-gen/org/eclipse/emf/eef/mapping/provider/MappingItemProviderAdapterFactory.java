/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.mapping.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.util.MappingAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingItemProviderAdapterFactory extends MappingAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable,
		IChildCreationExtender {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(
			MappingEditPlugin.INSTANCE, MappingPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.Databinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabindingItemProvider databindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.Databinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDatabindingAdapter() {
		if (databindingItemProvider == null) {
			databindingItemProvider = new DatabindingItemProvider(this);
		}

		return databindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.EMFElementBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMFElementBindingItemProvider emfElementBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.EMFElementBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMFElementBindingAdapter() {
		if (emfElementBindingItemProvider == null) {
			emfElementBindingItemProvider = new EMFElementBindingItemProvider(
					this);
		}

		return emfElementBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.EMFPropertyBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMFPropertyBindingItemProvider emfPropertyBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.EMFPropertyBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMFPropertyBindingAdapter() {
		if (emfPropertyBindingItemProvider == null) {
			emfPropertyBindingItemProvider = new EMFPropertyBindingItemProvider(
					this);
		}

		return emfPropertyBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.StandardElementBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardElementBindingItemProvider standardElementBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.StandardElementBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStandardElementBindingAdapter() {
		if (standardElementBindingItemProvider == null) {
			standardElementBindingItemProvider = new StandardElementBindingItemProvider(
					this);
		}

		return standardElementBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.StandardPropertyBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardPropertyBindingItemProvider standardPropertyBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.StandardPropertyBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStandardPropertyBindingAdapter() {
		if (standardPropertyBindingItemProvider == null) {
			standardPropertyBindingItemProvider = new StandardPropertyBindingItemProvider(
					this);
		}

		return standardPropertyBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.Category} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryItemProvider categoryItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.Category}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCategoryAdapter() {
		if (categoryItemProvider == null) {
			categoryItemProvider = new CategoryItemProvider(this);
		}

		return categoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.ElementBindingReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementBindingReferenceItemProvider elementBindingReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.ElementBindingReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createElementBindingReferenceAdapter() {
		if (elementBindingReferenceItemProvider == null) {
			elementBindingReferenceItemProvider = new ElementBindingReferenceItemProvider(
					this);
		}

		return elementBindingReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMFMultiPropertiesBindingItemProvider emfMultiPropertiesBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMFMultiPropertiesBindingAdapter() {
		if (emfMultiPropertiesBindingItemProvider == null) {
			emfMultiPropertiesBindingItemProvider = new EMFMultiPropertiesBindingItemProvider(
					this);
		}

		return emfMultiPropertiesBindingItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(
			ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>)
					|| (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders() {
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {
		return childCreationExtenderManager.getNewChildDescriptors(object,
				editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (databindingItemProvider != null)
			databindingItemProvider.dispose();
		if (emfElementBindingItemProvider != null)
			emfElementBindingItemProvider.dispose();
		if (emfPropertyBindingItemProvider != null)
			emfPropertyBindingItemProvider.dispose();
		if (standardElementBindingItemProvider != null)
			standardElementBindingItemProvider.dispose();
		if (standardPropertyBindingItemProvider != null)
			standardPropertyBindingItemProvider.dispose();
		if (categoryItemProvider != null)
			categoryItemProvider.dispose();
		if (elementBindingReferenceItemProvider != null)
			elementBindingReferenceItemProvider.dispose();
		if (emfMultiPropertiesBindingItemProvider != null)
			emfMultiPropertiesBindingItemProvider.dispose();
	}

}
