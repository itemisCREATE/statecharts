/**
 */
package org.yakindu.sct.model.stext.stext.provider;


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
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.sct.model.sgraph.provider.EffectItemProvider;

import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.stext.stext.ReactionEffect} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReactionEffectItemProvider
  extends EffectItemProvider
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
  public ReactionEffectItemProvider(AdapterFactory adapterFactory)
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
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StextPackage.Literals.REACTION_EFFECT__ACTIONS);
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
	 * This returns ReactionEffect.gif.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object getImage(Object object)
  {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ReactionEffect"));
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
		return getString("_UI_ReactionEffect_type");
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

		switch (notification.getFeatureID(ReactionEffect.class)) {
			case StextPackage.REACTION_EFFECT__ACTIONS:
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
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createActiveStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.REACTION_EFFECT__ACTIONS,
				 StextFactory.eINSTANCE.createParenthesizedExpression()));
	}

  /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public ResourceLocator getResourceLocator()
  {
		return STextEditPlugin.INSTANCE;
	}

}
