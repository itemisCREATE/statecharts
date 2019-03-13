/**
 */
package org.yakindu.base.expressions.expressions.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.expressions.expressions.ForVarDecl;

import org.yakindu.base.types.TypesPackage;

import org.yakindu.base.types.provider.PropertyItemProvider;

/**
 * This is the item provider adapter for a {@link org.yakindu.base.expressions.expressions.ForVarDecl} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForVarDeclItemProvider extends PropertyItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForVarDeclItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns ForVarDecl.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForVarDecl"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ForVarDecl)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ForVarDecl_type") :
			getString("_UI_ForVarDecl_type") + " " + label;
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
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createConditionalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createLogicalOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createLogicalAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createLogicalNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createBitwiseXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createBitwiseOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createBitwiseAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createLogicalRelationExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createShiftExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createNumericalAddSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createNumericalMultiplyDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createNumericalUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createPostFixUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createMetaCall()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createElementReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createParenthesizedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createIfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createBlockExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createReturnExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createSwitchExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createEventRaisingExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createEventValueReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createForExpression()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PROPERTY__INITIAL_VALUE,
				 ExpressionsFactory.eINSTANCE.createThrowExpression()));
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
			childFeature == TypesPackage.Literals.PROPERTY__INITIAL_VALUE;

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
