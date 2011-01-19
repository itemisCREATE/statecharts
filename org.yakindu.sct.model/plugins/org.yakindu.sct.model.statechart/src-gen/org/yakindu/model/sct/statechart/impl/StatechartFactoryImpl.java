/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.model.sct.statechart.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.yakindu.model.sct.statechart.BooleanVariable;
import org.yakindu.model.sct.statechart.BooleanVariableValue;
import org.yakindu.model.sct.statechart.Choice;
import org.yakindu.model.sct.statechart.DeepHistoryState;
import org.yakindu.model.sct.statechart.Event;
import org.yakindu.model.sct.statechart.FinalState;
import org.yakindu.model.sct.statechart.Fork;
import org.yakindu.model.sct.statechart.HistoryState;
import org.yakindu.model.sct.statechart.InitialState;
import org.yakindu.model.sct.statechart.IntegerVariable;
import org.yakindu.model.sct.statechart.IntegerVariableValue;
import org.yakindu.model.sct.statechart.Join;
import org.yakindu.model.sct.statechart.Junction;
import org.yakindu.model.sct.statechart.RealVariable;
import org.yakindu.model.sct.statechart.RealVariableValue;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.ShallowHistoryState;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatechartFactoryImpl extends EFactoryImpl implements StatechartFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatechartFactory init() {
		try {
			StatechartFactory theStatechartFactory = (StatechartFactory)EPackage.Registry.INSTANCE.getEFactory("http:///statechart.ecore"); 
			if (theStatechartFactory != null) {
				return theStatechartFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StatechartFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartFactoryImpl() {
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
			case StatechartPackage.REGION: return createRegion();
			case StatechartPackage.TRANSITION: return createTransition();
			case StatechartPackage.FINAL_STATE: return createFinalState();
			case StatechartPackage.STATE: return createState();
			case StatechartPackage.EVENT: return createEvent();
			case StatechartPackage.REAL_VARIABLE_VALUE: return createRealVariableValue();
			case StatechartPackage.REAL_VARIABLE: return createRealVariable();
			case StatechartPackage.SHALLOW_HISTORY_STATE: return createShallowHistoryState();
			case StatechartPackage.HISTORY_STATE: return createHistoryState();
			case StatechartPackage.JUNCTION: return createJunction();
			case StatechartPackage.DEEP_HISTORY_STATE: return createDeepHistoryState();
			case StatechartPackage.BOOLEAN_VARIABLE: return createBooleanVariable();
			case StatechartPackage.BOOLEAN_VARIABLE_VALUE: return createBooleanVariableValue();
			case StatechartPackage.JOIN: return createJoin();
			case StatechartPackage.INTEGER_VARIABLE: return createIntegerVariable();
			case StatechartPackage.INTEGER_VARIABLE_VALUE: return createIntegerVariableValue();
			case StatechartPackage.CHOICE: return createChoice();
			case StatechartPackage.STATECHART: return createStatechart();
			case StatechartPackage.FORK: return createFork();
			case StatechartPackage.INITIAL_STATE: return createInitialState();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region createRegion() {
		RegionImpl region = new RegionImpl();
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart createStatechart() {
		StatechartImpl statechart = new StatechartImpl();
		return statechart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState createFinalState() {
		FinalStateImpl finalState = new FinalStateImpl();
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealVariableValue createRealVariableValue() {
		RealVariableValueImpl realVariableValue = new RealVariableValueImpl();
		return realVariableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealVariable createRealVariable() {
		RealVariableImpl realVariable = new RealVariableImpl();
		return realVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShallowHistoryState createShallowHistoryState() {
		ShallowHistoryStateImpl shallowHistoryState = new ShallowHistoryStateImpl();
		return shallowHistoryState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryState createHistoryState() {
		HistoryStateImpl historyState = new HistoryStateImpl();
		return historyState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Junction createJunction() {
		JunctionImpl junction = new JunctionImpl();
		return junction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeepHistoryState createDeepHistoryState() {
		DeepHistoryStateImpl deepHistoryState = new DeepHistoryStateImpl();
		return deepHistoryState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVariable createBooleanVariable() {
		BooleanVariableImpl booleanVariable = new BooleanVariableImpl();
		return booleanVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVariableValue createBooleanVariableValue() {
		BooleanVariableValueImpl booleanVariableValue = new BooleanVariableValueImpl();
		return booleanVariableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Join createJoin() {
		JoinImpl join = new JoinImpl();
		return join;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVariable createIntegerVariable() {
		IntegerVariableImpl integerVariable = new IntegerVariableImpl();
		return integerVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVariableValue createIntegerVariableValue() {
		IntegerVariableValueImpl integerVariableValue = new IntegerVariableValueImpl();
		return integerVariableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fork createFork() {
		ForkImpl fork = new ForkImpl();
		return fork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialState createInitialState() {
		InitialStateImpl initialState = new InitialStateImpl();
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartPackage getStatechartPackage() {
		return (StatechartPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StatechartPackage getPackage() {
		return StatechartPackage.eINSTANCE;
	}

} //StatechartFactoryImpl
