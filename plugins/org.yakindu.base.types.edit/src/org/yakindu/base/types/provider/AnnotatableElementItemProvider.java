/**
 */
package org.yakindu.base.types.provider;


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
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.base.types.AnnotatableElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotatableElementItemProvider 
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
	public AnnotatableElementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATIONS);
			childrenFeatures.add(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_AnnotatableElement_type");
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

		switch (notification.getFeatureID(AnnotatableElement.class)) {
			case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS:
			case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO:
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
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATIONS,
				 TypesFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createTypedDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createComplexType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createEnumerator()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createTypeAlias()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createAnnotatableElement()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createAnnotationType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TypesEditPlugin.INSTANCE;
	}

}
