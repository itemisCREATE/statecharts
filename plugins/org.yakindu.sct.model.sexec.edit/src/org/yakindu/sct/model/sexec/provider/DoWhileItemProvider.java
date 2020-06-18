/**
 */
package org.yakindu.sct.model.sexec.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.sct.model.sexec.DoWhile;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.sexec.DoWhile} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DoWhileItemProvider extends StepItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoWhileItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(SexecPackage.Literals.DO_WHILE__CHECK);
			childrenFeatures.add(SexecPackage.Literals.DO_WHILE__BODY);
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
	 * This returns DoWhile.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DoWhile"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DoWhile)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DoWhile_type") :
			getString("_UI_DoWhile_type") + " " + label;
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

		switch (notification.getFeatureID(DoWhile.class)) {
			case SexecPackage.DO_WHILE__CHECK:
			case SexecPackage.DO_WHILE__BODY:
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
				(SexecPackage.Literals.DO_WHILE__CHECK,
				 SexecFactory.eINSTANCE.createCheck()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__CHECK,
				 SexecFactory.eINSTANCE.createCheckRef()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createCheck()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createCheckRef()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createDoWhile()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createExecution()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createEnterState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createExitState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createCall()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createScheduleTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createUnscheduleTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createStateSwitch()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createSaveHistory()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createHistoryEntry()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createLocalVariableDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createTraceNodeExecuted()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createReactionFired()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createTraceReactionWillFire()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createTraceStateEntered()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createTraceStateExited()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createTraceBeginRunCycle()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.DO_WHILE__BODY,
				 SexecFactory.eINSTANCE.createTraceEndRunCycle()));
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
			childFeature == SexecPackage.Literals.DO_WHILE__CHECK ||
			childFeature == SexecPackage.Literals.DO_WHILE__BODY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
