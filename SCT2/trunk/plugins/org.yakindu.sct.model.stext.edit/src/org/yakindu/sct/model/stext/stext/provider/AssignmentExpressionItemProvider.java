/**
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

import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.stext.stext.AssignmentExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssignmentExpressionItemProvider
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
  public AssignmentExpressionItemProvider(AdapterFactory adapterFactory)
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

			addOperatorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

  /**
	 * This adds a property descriptor for the Operator feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addOperatorPropertyDescriptor(Object object)
  {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AssignmentExpression_operator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AssignmentExpression_operator_feature", "_UI_AssignmentExpression_type"),
				 StextPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
			childrenFeatures.add(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION);
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
	 * This returns AssignmentExpression.gif.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object getImage(Object object)
  {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AssignmentExpression"));
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
		AssignmentOperator labelValue = ((AssignmentExpression)object).getOperator();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_AssignmentExpression_type") :
			getString("_UI_AssignmentExpression_type") + " " + label;
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

		switch (notification.getFeatureID(AssignmentExpression.class)) {
			case StextPackage.ASSIGNMENT_EXPRESSION__OPERATOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF:
			case StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION:
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
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createActiveStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				 StextFactory.eINSTANCE.createParenthesizedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createActiveStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION,
				 StextFactory.eINSTANCE.createParenthesizedExpression()));
	}

  /**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
  {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF ||
			childFeature == StextPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
