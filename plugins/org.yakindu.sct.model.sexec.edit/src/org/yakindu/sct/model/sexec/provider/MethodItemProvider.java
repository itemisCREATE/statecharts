/**
 */
package org.yakindu.sct.model.sexec.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.provider.OperationItemProvider;

import org.yakindu.sct.model.sexec.Method;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sgraph.SGraphFactory;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.sexec.Method} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MethodItemProvider extends OperationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(SexecPackage.Literals.METHOD__BODY_SEQUENCE);
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
	 * This returns Method.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Method"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Method)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Method_type") :
			getString("_UI_Method_type") + " " + label;
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

		switch (notification.getFeatureID(Method.class)) {
			case SexecPackage.METHOD__BODY_SEQUENCE:
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

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createPostFixUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createMetaCall()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createParenthesizedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createIfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createBlockExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createReturnExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createSwitchExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createForExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.OPERATION__BODY,
				 ExpressionsFactory.eINSTANCE.createThrowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.METHOD__BODY_SEQUENCE,
				 SexecFactory.eINSTANCE.createSequence()));
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
			childFeature == TypesPackage.Literals.META_COMPOSITE__META_FEATURES ||
			childFeature == TypesPackage.Literals.OPERATION__BODY ||
			childFeature == TypesPackage.Literals.OPERATION__PARAMETERS ||
			childFeature == TypesPackage.Literals.GENERIC_ELEMENT__TYPE_PARAMETERS;

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
