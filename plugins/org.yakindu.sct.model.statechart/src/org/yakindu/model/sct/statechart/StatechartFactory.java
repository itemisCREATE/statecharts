/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.model.sct.statechart;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.model.sct.statechart.StatechartPackage
 * @generated
 */
public interface StatechartFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatechartFactory eINSTANCE = org.yakindu.model.sct.statechart.impl.StatechartFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Region</em>'.
	 * @generated
	 */
	Region createRegion();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final State</em>'.
	 * @generated
	 */
	FinalState createFinalState();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Real Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Variable Value</em>'.
	 * @generated
	 */
	RealVariableValue createRealVariableValue();

	/**
	 * Returns a new object of class '<em>Real Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Variable</em>'.
	 * @generated
	 */
	RealVariable createRealVariable();

	/**
	 * Returns a new object of class '<em>Shallow History State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shallow History State</em>'.
	 * @generated
	 */
	ShallowHistoryState createShallowHistoryState();

	/**
	 * Returns a new object of class '<em>History State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>History State</em>'.
	 * @generated
	 */
	HistoryState createHistoryState();

	/**
	 * Returns a new object of class '<em>Junction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Junction</em>'.
	 * @generated
	 */
	Junction createJunction();

	/**
	 * Returns a new object of class '<em>Deep History State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deep History State</em>'.
	 * @generated
	 */
	DeepHistoryState createDeepHistoryState();

	/**
	 * Returns a new object of class '<em>Boolean Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Variable</em>'.
	 * @generated
	 */
	BooleanVariable createBooleanVariable();

	/**
	 * Returns a new object of class '<em>Boolean Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Variable Value</em>'.
	 * @generated
	 */
	BooleanVariableValue createBooleanVariableValue();

	/**
	 * Returns a new object of class '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join</em>'.
	 * @generated
	 */
	Join createJoin();

	/**
	 * Returns a new object of class '<em>Integer Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Variable</em>'.
	 * @generated
	 */
	IntegerVariable createIntegerVariable();

	/**
	 * Returns a new object of class '<em>Integer Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Variable Value</em>'.
	 * @generated
	 */
	IntegerVariableValue createIntegerVariableValue();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Statechart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statechart</em>'.
	 * @generated
	 */
	Statechart createStatechart();

	/**
	 * Returns a new object of class '<em>Fork</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork</em>'.
	 * @generated
	 */
	Fork createFork();

	/**
	 * Returns a new object of class '<em>Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial State</em>'.
	 * @generated
	 */
	InitialState createInitialState();

	/**
	 * Returns a new object of class '<em>Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Event</em>'.
	 * @generated
	 */
	TimeEvent createTimeEvent();

	/**
	 * Returns a new object of class '<em>Expression Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Element</em>'.
	 * @generated
	 */
	ExpressionElement createExpressionElement();

	/**
	 * Returns a new object of class '<em>Data Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Element</em>'.
	 * @generated
	 */
	DataElement createDataElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatechartPackage getStatechartPackage();

} //StatechartFactory
