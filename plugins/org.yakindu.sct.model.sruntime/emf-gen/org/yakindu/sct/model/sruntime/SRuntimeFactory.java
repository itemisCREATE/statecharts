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
package org.yakindu.sct.model.sruntime;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.sruntime.SRuntimePackage
 * @generated
 */
public interface SRuntimeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SRuntimeFactory eINSTANCE = org.yakindu.sct.model.sruntime.impl.SRuntimeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Execution Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Context</em>'.
	 * @generated
	 */
	ExecutionContext createExecutionContext();

	/**
	 * Returns a new object of class '<em>Execution Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Event</em>'.
	 * @generated
	 */
	ExecutionEvent createExecutionEvent();

	/**
	 * Returns a new object of class '<em>Execution Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Variable</em>'.
	 * @generated
	 */
	ExecutionVariable createExecutionVariable();

	/**
	 * Returns a new object of class '<em>Composite Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Slot</em>'.
	 * @generated
	 */
	CompositeSlot createCompositeSlot();

	/**
	 * Returns a new object of class '<em>Reference Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Slot</em>'.
	 * @generated
	 */
	ReferenceSlot createReferenceSlot();

	/**
	 * Returns a new object of class '<em>Execution Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Operation</em>'.
	 * @generated
	 */
	ExecutionOperation createExecutionOperation();

	/**
	 * Returns an instance of data type '<em>Java Object</em>' corresponding the given literal.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal a literal of the data type.
	 * @return a new instance value of the data type.
	 * @generated
	 */
	Object createJavaObject(String literal);

	/**
	 * Returns a literal representation of an instance of data type '<em>Java Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param instanceValue an instance value of the data type.
	 * @return a literal representation of the instance value.
	 * @generated
	 */
	String convertJavaObject(Object instanceValue);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SRuntimePackage getSRuntimePackage();

} //SRuntimeFactory
