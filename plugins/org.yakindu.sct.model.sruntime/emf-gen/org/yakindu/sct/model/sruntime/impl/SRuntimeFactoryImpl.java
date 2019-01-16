/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.model.sruntime.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SRuntimeFactoryImpl extends EFactoryImpl implements SRuntimeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRuntimeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SRuntimePackage.EXECUTION_CONTEXT: return createExecutionContext();
			case SRuntimePackage.EXECUTION_EVENT: return createExecutionEvent();
			case SRuntimePackage.EXECUTION_VARIABLE: return createExecutionVariable();
			case SRuntimePackage.COMPOSITE_SLOT: return createCompositeSlot();
			case SRuntimePackage.REFERENCE_SLOT: return createReferenceSlot();
			case SRuntimePackage.EXECUTION_OPERATION: return createExecutionOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SRuntimePackage.JAVA_OBJECT:
				return createJavaObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SRuntimePackage.JAVA_OBJECT:
				return convertJavaObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionContext createExecutionContext() {
		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		return executionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionEvent createExecutionEvent() {
		ExecutionEventImpl executionEvent = new ExecutionEventImpl();
		return executionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionVariable createExecutionVariable() {
		ExecutionVariableImpl executionVariable = new ExecutionVariableImpl();
		return executionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeSlot createCompositeSlot() {
		CompositeSlotImpl compositeSlot = new CompositeSlotImpl();
		return compositeSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferenceSlot createReferenceSlot() {
		ReferenceSlotImpl referenceSlot = new ReferenceSlotImpl();
		return referenceSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionOperation createExecutionOperation() {
		ExecutionOperationImpl executionOperation = new ExecutionOperationImpl();
		return executionOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createJavaObject(String literal) {
		return super.createFromString(SRuntimePackage.Literals.JAVA_OBJECT, literal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return createJavaObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertJavaObject(Object instanceValue) {
		return super.convertToString(SRuntimePackage.Literals.JAVA_OBJECT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJavaObject((Object)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SRuntimePackage getSRuntimePackage() {
		return (SRuntimePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SRuntimePackage getPackage() {
		return SRuntimePackage.eINSTANCE;
	}

} //SRuntimeFactoryImpl
