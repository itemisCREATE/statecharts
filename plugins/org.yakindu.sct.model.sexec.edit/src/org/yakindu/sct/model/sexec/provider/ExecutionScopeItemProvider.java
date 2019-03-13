/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sgraph.SGraphFactory;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.sexec.ExecutionScope} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionScopeItemProvider
	extends MappedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionScopeItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addStaticPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
			addVisiblePropertyDescriptor(object);
			addSubScopesPropertyDescriptor(object);
			addSuperScopePropertyDescriptor(object);
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
	 * This adds a property descriptor for the Static feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Declaration_static_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Declaration_static_feature", "_UI_Declaration_type"),
				 TypesPackage.Literals.DECLARATION__STATIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Declaration_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Declaration_id_feature", "_UI_Declaration_type"),
				 TypesPackage.Literals.DECLARATION__ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Type_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Type_abstract_feature", "_UI_Type_type"),
				 TypesPackage.Literals.TYPE__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Visible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Type_visible_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Type_visible_feature", "_UI_Type_type"),
				 TypesPackage.Literals.TYPE__VISIBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(TypesPackage.Literals.META_COMPOSITE__META_FEATURES);
			childrenFeatures.add(TypesPackage.Literals.TYPE__SUPER_TYPES);
			childrenFeatures.add(TypesPackage.Literals.GENERIC_ELEMENT__TYPE_PARAMETERS);
			childrenFeatures.add(TypesPackage.Literals.COMPLEX_TYPE__FEATURES);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__STATE_VECTOR);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__ENTER_SEQUENCES);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__EXIT_SEQUENCE);
			childrenFeatures.add(SexecPackage.Literals.EXECUTION_SCOPE__INIT_SEQUENCE);
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
	 * This returns ExecutionScope.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExecutionScope"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ExecutionScope)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExecutionScope_type") :
			getString("_UI_ExecutionScope_type") + " " + label;
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

		switch (notification.getFeatureID(ExecutionScope.class)) {
			case SexecPackage.EXECUTION_SCOPE__NAME:
			case SexecPackage.EXECUTION_SCOPE__ANNOTATION_INFO:
			case SexecPackage.EXECUTION_SCOPE__STATIC:
			case SexecPackage.EXECUTION_SCOPE__ID:
			case SexecPackage.EXECUTION_SCOPE__ABSTRACT:
			case SexecPackage.EXECUTION_SCOPE__VISIBLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SexecPackage.EXECUTION_SCOPE__ANNOTATIONS:
			case SexecPackage.EXECUTION_SCOPE__META_FEATURES:
			case SexecPackage.EXECUTION_SCOPE__SUPER_TYPES:
			case SexecPackage.EXECUTION_SCOPE__TYPE_PARAMETERS:
			case SexecPackage.EXECUTION_SCOPE__FEATURES:
			case SexecPackage.EXECUTION_SCOPE__STATE_VECTOR:
			case SexecPackage.EXECUTION_SCOPE__ENTER_SEQUENCES:
			case SexecPackage.EXECUTION_SCOPE__EXIT_SEQUENCE:
			case SexecPackage.EXECUTION_SCOPE__INIT_SEQUENCE:
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
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

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
				(TypesPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_INFO,
				 TypesFactory.eINSTANCE.createDeclaration()));

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
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SGraphFactory.eINSTANCE.createImportDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createTypedDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createComplexType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createEnumerator()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createTypeAlias()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createAnnotationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.TYPE__SUPER_TYPES,
				 TypesFactory.eINSTANCE.createTypeSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.TYPE__SUPER_TYPES,
				 TypesFactory.eINSTANCE.createArrayTypeSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.GENERIC_ELEMENT__TYPE_PARAMETERS,
				 TypesFactory.eINSTANCE.createTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionFlow()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionNode()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionState()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionScope()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionRegion()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionEntry()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionExit()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionChoice()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createExecutionSynchronization()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SexecFactory.eINSTANCE.createTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 ExpressionsFactory.eINSTANCE.createForVarDecl()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 SGraphFactory.eINSTANCE.createImportDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createTypedDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createComplexType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createEnumerator()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createTypeAlias()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.COMPLEX_TYPE__FEATURES,
				 TypesFactory.eINSTANCE.createAnnotationType()));

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
			childFeature == TypesPackage.Literals.COMPLEX_TYPE__FEATURES ||
			childFeature == TypesPackage.Literals.GENERIC_ELEMENT__TYPE_PARAMETERS ||
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__ENTER_SEQUENCES ||
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__EXIT_SEQUENCE ||
			childFeature == SexecPackage.Literals.EXECUTION_SCOPE__INIT_SEQUENCE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
