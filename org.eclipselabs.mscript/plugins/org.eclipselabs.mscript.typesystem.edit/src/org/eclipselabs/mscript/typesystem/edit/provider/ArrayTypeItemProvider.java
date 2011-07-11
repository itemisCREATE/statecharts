/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;

/**
 * This is the item provider adapter for a {@link org.eclipselabs.mscript.typesystem.ArrayType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArrayTypeItemProvider
	extends DataTypeItemProvider
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
	public ArrayTypeItemProvider(AdapterFactory adapterFactory) {
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

			addElementTypePropertyDescriptor(object);
			addDimensionalityPropertyDescriptor(object);
			addDimensionalPropertyDescriptor(object);
			addMultidimensionalPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Element Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArrayType_elementType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ArrayType_elementType_feature", "_UI_ArrayType_type"),
				 TypeSystemPackage.Literals.ARRAY_TYPE__ELEMENT_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dimensionality feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDimensionalityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArrayType_dimensionality_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ArrayType_dimensionality_feature", "_UI_ArrayType_type"),
				 TypeSystemPackage.Literals.ARRAY_TYPE__DIMENSIONALITY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dimensional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDimensionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArrayType_dimensional_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ArrayType_dimensional_feature", "_UI_ArrayType_type"),
				 TypeSystemPackage.Literals.ARRAY_TYPE__DIMENSIONAL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Multidimensional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMultidimensionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArrayType_multidimensional_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ArrayType_multidimensional_feature", "_UI_ArrayType_type"),
				 TypeSystemPackage.Literals.ARRAY_TYPE__MULTIDIMENSIONAL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE);
			childrenFeatures.add(TypeSystemPackage.Literals.ARRAY_TYPE__DIMENSIONS);
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
	 * This returns ArrayType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ArrayType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		ArrayType arrayType = (ArrayType)object;
		return getString("_UI_ArrayType_type") + " " + arrayType.getDimensionality();
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

		switch (notification.getFeatureID(ArrayType.class)) {
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONALITY:
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONAL:
			case TypeSystemPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE:
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONS:
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
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createInvalidDataType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createAnyDataType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createUnitType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createNumericType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createRealType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createIntegerType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createComplexType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createGaussianType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createBooleanType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createArrayType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DEFINED_ELEMENT_TYPE,
				 TypeSystemFactory.eINSTANCE.createTensorType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.ARRAY_TYPE__DIMENSIONS,
				 TypeSystemFactory.eINSTANCE.createArrayDimension()));
	}

}
