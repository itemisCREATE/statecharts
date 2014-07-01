/**
 */
package org.yakindu.sct.model.stext.stext.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.base.expressions.expressions.ExpressionsFactory;

import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.stext.stext.RegularEventSpec} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RegularEventSpecItemProvider extends EventSpecItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularEventSpecItemProvider(AdapterFactory adapterFactory)
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
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT);
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
   * This returns RegularEventSpec.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/RegularEventSpec"));
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
    return getString("_UI_RegularEventSpec_type");
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

    switch (notification.getFeatureID(RegularEventSpec.class))
    {
      case StextPackage.REGULAR_EVENT_SPEC__EVENT:
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
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         StextFactory.eINSTANCE.createEventRaisingExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         StextFactory.eINSTANCE.createEventValueReferenceExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         StextFactory.eINSTANCE.createActiveStateReferenceExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createConditionalExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createLogicalOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createLogicalAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createLogicalNotExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createBitwiseXorExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createBitwiseOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createBitwiseAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createLogicalRelationExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createShiftExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createNumericalAddSubtractExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createNumericalUnaryExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createFeatureCall()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createElementReferenceExpression()));

    newChildDescriptors.add
      (createChildParameter
        (StextPackage.Literals.REGULAR_EVENT_SPEC__EVENT,
         ExpressionsFactory.eINSTANCE.createParenthesizedExpression()));
  }

}
