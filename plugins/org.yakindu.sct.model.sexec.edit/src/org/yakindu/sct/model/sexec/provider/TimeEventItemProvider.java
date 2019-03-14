/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.provider.EventItemProvider;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sgraph.SGraphFactory;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.sexec.TimeEvent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TimeEventItemProvider
	extends EventItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEventItemProvider(AdapterFactory adapterFactory) {
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

			addPeriodicPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Periodic feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPeriodicPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TimeEvent_periodic_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TimeEvent_periodic_feature", "_UI_TimeEvent_type"),
				 SexecPackage.Literals.TIME_EVENT__PERIODIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns TimeEvent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TimeEvent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TimeEvent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TimeEvent_type") :
			getString("_UI_TimeEvent_type") + " " + label;
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

		switch (notification.getFeatureID(TimeEvent.class)) {
			case SexecPackage.TIME_EVENT__PERIODIC:
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

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionFlow()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionNode()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionState()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionScope()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionRegion()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionEntry()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionExit()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionChoice()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createExecutionSynchronization()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SexecFactory.eINSTANCE.createTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SGraphFactory.eINSTANCE.createStatechart()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 SGraphFactory.eINSTANCE.createImportDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionFlow()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionNode()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionState()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionScope()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionRegion()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionEntry()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionExit()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionChoice()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createExecutionSynchronization()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SexecFactory.eINSTANCE.createTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SGraphFactory.eINSTANCE.createImportDeclaration()));
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
			childFeature == TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO ||
			childFeature == TypesPackage.Literals.META_COMPOSITE__META_FEATURES;

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
		return SexecEditPlugin.INSTANCE;
	}

}
