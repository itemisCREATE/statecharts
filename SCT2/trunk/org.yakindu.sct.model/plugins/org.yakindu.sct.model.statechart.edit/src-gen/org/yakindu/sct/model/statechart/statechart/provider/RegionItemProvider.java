/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.statechart.statechart.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.StatechartFactory;
import org.yakindu.sct.model.statechart.statechart.StatechartPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.statechart.statechart.Region} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RegionItemProvider
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
	public RegionItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(StatechartPackage.Literals.REGION__VERTICES);
			childrenFeatures.add(StatechartPackage.Literals.REGION__TRANSITIONS);
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
	 * This returns Region.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Region"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Region_type");
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

		switch (notification.getFeatureID(Region.class)) {
			case StatechartPackage.REGION__VERTICES:
			case StatechartPackage.REGION__TRANSITIONS:
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
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createFinalState()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createInitialState()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createDeepHistoryState()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createShallowHistoryState()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createFork()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createJoin()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createJunction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__VERTICES,
				 StatechartFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartPackage.Literals.REGION__TRANSITIONS,
				 StatechartFactory.eINSTANCE.createTransition()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return StatechartEditPlugin.INSTANCE;
	}

}
