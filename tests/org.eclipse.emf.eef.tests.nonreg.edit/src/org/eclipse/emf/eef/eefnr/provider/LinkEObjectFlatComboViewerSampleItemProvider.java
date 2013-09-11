/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.provider;


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

import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.LinkEObjectFlatComboViewerSample;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.eef.eefnr.LinkEObjectFlatComboViewerSample} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LinkEObjectFlatComboViewerSampleItemProvider
	extends AbstractSampleItemProvider
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
	public LinkEObjectFlatComboViewerSampleItemProvider(AdapterFactory adapterFactory) {
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

			addLinkeobjectflatcomboviewerRequiredPropertyPropertyDescriptor(object);
			addLinkeobjectflatcomboviewerOptionalPropertyPropertyDescriptor(object);
			addLinkeobjectflatcomboviewerROProperyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Linkeobjectflatcomboviewer Required Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinkeobjectflatcomboviewerRequiredPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LinkEObjectFlatComboViewerSample_linkeobjectflatcomboviewerRequiredProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LinkEObjectFlatComboViewerSample_linkeobjectflatcomboviewerRequiredProperty_feature", "_UI_LinkEObjectFlatComboViewerSample_type"),
				 EefnrPackage.Literals.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Linkeobjectflatcomboviewer Optional Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinkeobjectflatcomboviewerOptionalPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LinkEObjectFlatComboViewerSample_linkeobjectflatcomboviewerOptionalProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LinkEObjectFlatComboViewerSample_linkeobjectflatcomboviewerOptionalProperty_feature", "_UI_LinkEObjectFlatComboViewerSample_type"),
				 EefnrPackage.Literals.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Linkeobjectflatcomboviewer RO Propery feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinkeobjectflatcomboviewerROProperyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LinkEObjectFlatComboViewerSample_linkeobjectflatcomboviewerROPropery_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LinkEObjectFlatComboViewerSample_linkeobjectflatcomboviewerROPropery_feature", "_UI_LinkEObjectFlatComboViewerSample_type"),
				 EefnrPackage.Literals.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns LinkEObjectFlatComboViewerSample.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LinkEObjectFlatComboViewerSample"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LinkEObjectFlatComboViewerSample)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LinkEObjectFlatComboViewerSample_type") :
			getString("_UI_LinkEObjectFlatComboViewerSample_type") + " " + label;
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
