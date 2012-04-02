/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext.provider;


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

import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TypedElementReferenceExpressionItemProvider
  extends ExpressionItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedElementReferenceExpressionItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addReferencePropertyDescriptor(object);
      addOperationCallPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Reference feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addReferencePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_TypedElementReferenceExpression_reference_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_TypedElementReferenceExpression_reference_feature", "_UI_TypedElementReferenceExpression_type"),
         StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Operation Call feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addOperationCallPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_TypedElementReferenceExpression_operationCall_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_TypedElementReferenceExpression_operationCall_feature", "_UI_TypedElementReferenceExpression_type"),
         StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL,
         true,
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
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns TypedElementReferenceExpression.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/TypedElementReferenceExpression"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    TypedElementReferenceExpression typedElementReferenceExpression = (TypedElementReferenceExpression)object;
    return getString("_UI_TypedElementReferenceExpression_type") + " " + typedElementReferenceExpression.isOperationCall();
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(TypedElementReferenceExpression.class))
    {
      case StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS:
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
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createEventRaisingExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createAssignmentExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createConditionalExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createLogicalOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createLogicalAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createLogicalNotExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createBitwiseXorExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createBitwiseOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createBitwiseAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createLogicalRelationExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createShiftExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createNumericalAddSubtractExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createNumericalUnaryExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createPrimitiveValueExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createFeatureCall()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createTypedElementReferenceExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createEventValueReferenceExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__ARGS,
         StextFactory.eINSTANCE.createActiveStateReferenceExpression()));
  }

}
