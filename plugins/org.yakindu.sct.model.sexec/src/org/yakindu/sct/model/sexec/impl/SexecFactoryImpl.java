/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.model.sexec.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SexecFactoryImpl extends EFactoryImpl implements SexecFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SexecFactory init() {
		try {
			SexecFactory theSexecFactory = (SexecFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.org/sct/sexec/1.0.0"); 
			if (theSexecFactory != null) {
				return theSexecFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SexecFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecFactoryImpl() {
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
			case SexecPackage.EXECUTION_FLOW: return createExecutionFlow();
			case SexecPackage.EXECUTION_STATE: return createExecutionState();
			case SexecPackage.NAMED_ELEMENT: return createNamedElement();
			case SexecPackage.CYCLE: return createCycle();
			case SexecPackage.SEQUENCE: return createSequence();
			case SexecPackage.IF: return createIf();
			case SexecPackage.EXECUTION: return createExecution();
			case SexecPackage.ENTER_STATE: return createEnterState();
			case SexecPackage.EXIT_STATE: return createExitState();
			case SexecPackage.SEQUENCE_EXECUTION: return createSequenceExecution();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlow createExecutionFlow() {
		ExecutionFlowImpl executionFlow = new ExecutionFlowImpl();
		return executionFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionState createExecutionState() {
		ExecutionStateImpl executionState = new ExecutionStateImpl();
		return executionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cycle createCycle() {
		CycleImpl cycle = new CycleImpl();
		return cycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Execution createExecution() {
		ExecutionImpl execution = new ExecutionImpl();
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnterState createEnterState() {
		EnterStateImpl enterState = new EnterStateImpl();
		return enterState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExitState createExitState() {
		ExitStateImpl exitState = new ExitStateImpl();
		return exitState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceExecution createSequenceExecution() {
		SequenceExecutionImpl sequenceExecution = new SequenceExecutionImpl();
		return sequenceExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecPackage getSexecPackage() {
		return (SexecPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SexecPackage getPackage() {
		return SexecPackage.eINSTANCE;
	}

} //SexecFactoryImpl
