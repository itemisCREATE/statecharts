/**
 */
package org.yakindu.base.expressions.expressions.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.IfExpression;

import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.provider.ExpressionItemProvider;

/**
 * This is the item provider adapter for a {@link org.yakindu.base.expressions.expressions.IfExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IfExpressionItemProvider extends ExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpressionItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION);
			childrenFeatures.add(ExpressionsPackage.Literals.IF_EXPRESSION__THEN);
			childrenFeatures.add(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE);
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
	 * This returns IfExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IfExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_IfExpression_type");
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

		switch (notification.getFeatureID(IfExpression.class)) {
			case ExpressionsPackage.IF_EXPRESSION__CONDITION:
			case ExpressionsPackage.IF_EXPRESSION__THEN:
			case ExpressionsPackage.IF_EXPRESSION__ELSE:
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
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createPostFixUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createMetaCall()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createParenthesizedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createIfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createBlockExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createReturnExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createSwitchExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createForExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 ExpressionsFactory.eINSTANCE.createThrowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION,
				 TypesFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createPostFixUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createMetaCall()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createParenthesizedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createIfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createBlockExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createReturnExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createSwitchExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createForExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 ExpressionsFactory.eINSTANCE.createThrowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__THEN,
				 TypesFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createPostFixUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createMetaCall()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createParenthesizedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createIfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createBlockExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createReturnExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createSwitchExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createForExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 ExpressionsFactory.eINSTANCE.createThrowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IF_EXPRESSION__ELSE,
				 TypesFactory.eINSTANCE.createProperty()));
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
			childFeature == ExpressionsPackage.Literals.IF_EXPRESSION__CONDITION ||
			childFeature == ExpressionsPackage.Literals.IF_EXPRESSION__THEN ||
			childFeature == ExpressionsPackage.Literals.IF_EXPRESSION__ELSE;

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
		return ExpressionsEditPlugin.INSTANCE;
	}

}
