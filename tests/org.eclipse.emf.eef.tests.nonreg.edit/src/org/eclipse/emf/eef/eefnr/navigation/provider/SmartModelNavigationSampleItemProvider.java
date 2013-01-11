/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.navigation.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.eef.eefnr.navigation.NavigationFactory;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;

import org.eclipse.emf.eef.eefnr.provider.EefnrEditPlugin;
import org.eclipse.emf.eef.eefnr.provider.NamedElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SmartModelNavigationSampleItemProvider
	extends NamedElementItemProvider
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
	public SmartModelNavigationSampleItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION);
			childrenFeatures.add(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION);
			childrenFeatures.add(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2);
			childrenFeatures.add(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SmartModelNavigationSample.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SmartModelNavigationSample"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SmartModelNavigationSample)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SmartModelNavigationSample_type") :
			getString("_UI_SmartModelNavigationSample_type") + " " + label;
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

		switch (notification.getFeatureID(SmartModelNavigationSample.class)) {
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION:
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION:
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2:
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION,
				 NavigationFactory.eINSTANCE.createFirstModelNavigation()));

		newChildDescriptors.add
			(createChildParameter
				(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION,
				 NavigationFactory.eINSTANCE.createFirstModelNavigation()));

		newChildDescriptors.add
			(createChildParameter
				(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2,
				 NavigationFactory.eINSTANCE.createFirstModelNavigation()));

		newChildDescriptors.add
			(createChildParameter
				(NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2,
				 NavigationFactory.eINSTANCE.createFirstModelNavigation()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION ||
			childFeature == NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION ||
			childFeature == NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2 ||
			childFeature == NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EefnrEditPlugin.INSTANCE;
	}

}
