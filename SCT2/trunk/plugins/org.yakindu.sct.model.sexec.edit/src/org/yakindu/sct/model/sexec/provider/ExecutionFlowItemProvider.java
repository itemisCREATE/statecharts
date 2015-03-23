/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sgraph.provider.ScopedElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.sexec.ExecutionFlow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionFlowItemProvider
	extends ScopedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlowItemProvider(AdapterFactory adapterFactory) {
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

			addSourceElementPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addSubScopesPropertyDescriptor(object);
			addSuperScopePropertyDescriptor(object);
			addSimpleNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
				 BasePackage.Literals.NAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappedElement_sourceElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappedElement_sourceElement_feature", "_UI_MappedElement_type"),
				 SexecPackage.Literals.MAPPED_ELEMENT__SOURCE_ELEMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sub Scopes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubScopesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExecutionScope_subScopes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExecutionScope_subScopes_feature", "_UI_ExecutionScope_type"),
				 SexecPackage.Literals.EXECUTION_SCOPE__SUB_SCOPES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExecutionScope_superScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExecutionScope_superScope_feature", "_UI_ExecutionScope_type"),
				 SexecPackage.Literals.EXECUTION_SCOPE__SUPER_SCOPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSimpleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExecutionNode_simpleName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExecutionNode_simpleName_feature", "_UI_ExecutionNode_type"),
				 SexecPackage.Literals.EXECUTION_NODE__SIMPLE_NAME,
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__STATE_VECTOR);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__ENTER_SEQUENCES);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__EXIT_SEQUENCE);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__INIT_SEQUENCE);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_NODE__REACTIONS);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_NODE__REACT_SEQUENCE);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__STATES);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__NODES);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__REGIONS);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__HISTORY_VECTOR);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_FLOW__STATIC_INIT_SEQUENCE);
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
	 * This returns ExecutionFlow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExecutionFlow"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ExecutionFlow)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExecutionFlow_type") :
			getString("_UI_ExecutionFlow_type") + " " + label;
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

		switch (notification.getFeatureID(ExecutionFlow.class)) {
			case SexecPackage.EXECUTION_FLOW__NAME:
			case SexecPackage.EXECUTION_FLOW__SIMPLE_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES:
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
			case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE:
			case SexecPackage.EXECUTION_FLOW__REACTIONS:
			case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE:
			case SexecPackage.EXECUTION_FLOW__STATES:
			case SexecPackage.EXECUTION_FLOW__NODES:
			case SexecPackage.EXECUTION_FLOW__REGIONS:
			case SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR:
			case SexecPackage.EXECUTION_FLOW__ENTRY_ACTION:
			case SexecPackage.EXECUTION_FLOW__EXIT_ACTION:
			case SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE:
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
				(SexecPackage.Literals.EXECUTION_SCOPE__STATE_VECTOR,
				 SexecFactory.eINSTANCE.createStateVector()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_SCOPE__ENTER_SEQUENCES,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_SCOPE__EXIT_SEQUENCE,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_SCOPE__INIT_SEQUENCE,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_NODE__REACTIONS,
				 SexecFactory.eINSTANCE.createReaction()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_NODE__REACT_SEQUENCE,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__STATES,
				 SexecFactory.eINSTANCE.createExecutionState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionFlow()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionNode()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionEntry()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionExit()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionChoice()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__NODES,
				 SexecFactory.eINSTANCE.createExecutionSynchronization()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__REGIONS,
				 SexecFactory.eINSTANCE.createExecutionRegion()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__HISTORY_VECTOR,
				 SexecFactory.eINSTANCE.createStateVector()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createCheck()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createCheckRef()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createExecution()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createEnterState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createExitState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createCall()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createScheduleTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createUnscheduleTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createStateSwitch()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createSaveHistory()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createHistoryEntry()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createTraceNodeExecuted()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createReactionFired()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createTraceReactionWillFire()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createTraceStateEntered()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createTraceStateExited()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createTraceBeginRunCycle()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION,
				 SexecFactory.eINSTANCE.createTraceEndRunCycle()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createCheck()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createCheckRef()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createExecution()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createEnterState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createExitState()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createCall()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createScheduleTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createUnscheduleTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createStateSwitch()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createSaveHistory()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createHistoryEntry()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createTraceNodeExecuted()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createReactionFired()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createTraceReactionWillFire()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createTraceStateEntered()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createTraceStateExited()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createTraceBeginRunCycle()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION,
				 SexecFactory.eINSTANCE.createTraceEndRunCycle()));

		newChildDescriptors.add
			(createChildParameter
				(SexecPackage.Literals.EXECUTION_FLOW__STATIC_INIT_SEQUENCE,
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
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__STATE_VECTOR ||
			childFeature == SexecPackage.Literals.EXECUTION_FLOW__HISTORY_VECTOR ||
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__ENTER_SEQUENCES ||
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__EXIT_SEQUENCE ||
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__INIT_SEQUENCE ||
			childFeature == SexecPackage.Literals.EXECUTION_NODE__REACT_SEQUENCE ||
			childFeature == SexecPackage.Literals.EXECUTION_FLOW__ENTRY_ACTION ||
			childFeature == SexecPackage.Literals.EXECUTION_FLOW__EXIT_ACTION ||
			childFeature == SexecPackage.Literals.EXECUTION_FLOW__STATIC_INIT_SEQUENCE ||
			childFeature == SexecPackage.Literals.EXECUTION_FLOW__STATES ||
			childFeature == SexecPackage.Literals.EXECUTION_FLOW__NODES;

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
