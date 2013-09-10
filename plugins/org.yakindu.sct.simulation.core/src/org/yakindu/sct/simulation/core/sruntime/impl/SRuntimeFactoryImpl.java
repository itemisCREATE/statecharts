/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sruntime.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.sct.simulation.core.sruntime.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class SRuntimeFactoryImpl extends EFactoryImpl implements SRuntimeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static SRuntimeFactory init() {
		try {
			SRuntimeFactory theSRuntimeFactory = (SRuntimeFactory)EPackage.Registry.INSTANCE.getEFactory(SRuntimePackage.eNS_URI);
			if (theSRuntimeFactory != null) {
				return theSRuntimeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SRuntimeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public SRuntimeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SRuntimePackage.EXECUTION_CONTEXT: return createExecutionContext();
			case SRuntimePackage.EXECUTION_EVENT: return createExecutionEvent();
			case SRuntimePackage.EXECUTION_VARIABLE: return createExecutionVariable();
			case SRuntimePackage.COMPOSITE_SLOT: return createCompositeSlot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SRuntimePackage.EVENT_DIRECTION:
				return createEventDirectionFromString(eDataType, initialValue);
			case SRuntimePackage.INFERRED_TYPE:
				return createInferredTypeFromString(eDataType, initialValue);
			case SRuntimePackage.JAVA_OBJECT:
				return createJavaObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SRuntimePackage.EVENT_DIRECTION:
				return convertEventDirectionToString(eDataType, instanceValue);
			case SRuntimePackage.INFERRED_TYPE:
				return convertInferredTypeToString(eDataType, instanceValue);
			case SRuntimePackage.JAVA_OBJECT:
				return convertJavaObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionContext createExecutionContext() {
		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		return executionContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionEvent createExecutionEvent() {
		ExecutionEventImpl executionEvent = new ExecutionEventImpl();
		return executionEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionVariable createExecutionVariable() {
		ExecutionVariableImpl executionVariable = new ExecutionVariableImpl();
		return executionVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSlot createCompositeSlot() {
		CompositeSlotImpl compositeSlot = new CompositeSlotImpl();
		return compositeSlot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventDirection createEventDirectionFromString(EDataType eDataType, String initialValue) {
		EventDirection result = EventDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public InferredType createInferredTypeFromString(EDataType eDataType, String initialValue) {
		PrimitiveType type = TypesFactory.eINSTANCE.createPrimitiveType();
		type.setName(initialValue);
		return new InferredType(type);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInferredTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		int indexOf = initialValue.indexOf(":");
		String className = initialValue.substring(0, indexOf);
		String value = initialValue.substring(indexOf + 1);
		if (Boolean.class.getName().equals(className))
			return Boolean.parseBoolean(value);
		if (String.class.getName().equals(className))
			return value;
		if (Long.class.getName().equals(className))
			return Long.parseLong(value);
		if (Double.class.getName().equals(className))
			return Double.parseDouble(value);
		if (Integer.class.getName().equals(className))
			return Integer.parseInt(value);
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		StringBuilder builder = new StringBuilder();
		builder.append(instanceValue.getClass().getName());
		builder.append(":");
		builder.append(instanceValue);
		return builder.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SRuntimePackage getSRuntimePackage() {
		return (SRuntimePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SRuntimePackage getPackage() {
		return SRuntimePackage.eINSTANCE;
	}

} // SRuntimeFactoryImpl
