/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.CompoundStatement;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ForeachStatement;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.StateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Statement;
import org.eclipselabs.mscript.language.imperativemodel.Subroutine;
import org.eclipselabs.mscript.language.imperativemodel.SubroutineContext;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage
 * @generated
 */
public class ImperativeModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImperativeModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ImperativeModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImperativeModelPackage.SUBROUTINE: {
				Subroutine subroutine = (Subroutine)theEObject;
				T result = caseSubroutine(subroutine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.SUBROUTINE_CONTEXT: {
				SubroutineContext subroutineContext = (SubroutineContext)theEObject;
				T result = caseSubroutineContext(subroutineContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.CIRCULAR_BUFFER_DECLARATION: {
				CircularBufferDeclaration circularBufferDeclaration = (CircularBufferDeclaration)theEObject;
				T result = caseCircularBufferDeclaration(circularBufferDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.COMPOUND: {
				Compound compound = (Compound)theEObject;
				T result = caseCompound(compound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.COMPUTATION_COMPOUND: {
				ComputationCompound computationCompound = (ComputationCompound)theEObject;
				T result = caseComputationCompound(computationCompound);
				if (result == null) result = caseCompound(computationCompound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION: {
				StatefulVariableDeclaration statefulVariableDeclaration = (StatefulVariableDeclaration)theEObject;
				T result = caseStatefulVariableDeclaration(statefulVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(statefulVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION: {
				InputVariableDeclaration inputVariableDeclaration = (InputVariableDeclaration)theEObject;
				T result = caseInputVariableDeclaration(inputVariableDeclaration);
				if (result == null) result = caseStatefulVariableDeclaration(inputVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(inputVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.OUTPUT_VARIABLE_DECLARATION: {
				OutputVariableDeclaration outputVariableDeclaration = (OutputVariableDeclaration)theEObject;
				T result = caseOutputVariableDeclaration(outputVariableDeclaration);
				if (result == null) result = caseStatefulVariableDeclaration(outputVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(outputVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.TEMPLATE_VARIABLE_DECLARATION: {
				TemplateVariableDeclaration templateVariableDeclaration = (TemplateVariableDeclaration)theEObject;
				T result = caseTemplateVariableDeclaration(templateVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(templateVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.STATE_VARIABLE_DECLARATION: {
				StateVariableDeclaration stateVariableDeclaration = (StateVariableDeclaration)theEObject;
				T result = caseStateVariableDeclaration(stateVariableDeclaration);
				if (result == null) result = caseStatefulVariableDeclaration(stateVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(stateVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.LOCAL_VARIABLE_DECLARATION: {
				LocalVariableDeclaration localVariableDeclaration = (LocalVariableDeclaration)theEObject;
				T result = caseLocalVariableDeclaration(localVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(localVariableDeclaration);
				if (result == null) result = caseStatement(localVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.COMPOUND_STATEMENT: {
				CompoundStatement compoundStatement = (CompoundStatement)theEObject;
				T result = caseCompoundStatement(compoundStatement);
				if (result == null) result = caseCompound(compoundStatement);
				if (result == null) result = caseStatement(compoundStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseStatement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.FOREACH_STATEMENT: {
				ForeachStatement foreachStatement = (ForeachStatement)theEObject;
				T result = caseForeachStatement(foreachStatement);
				if (result == null) result = caseStatement(foreachStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeModelPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null) result = caseExpression(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subroutine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subroutine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubroutine(Subroutine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subroutine Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subroutine Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubroutineContext(SubroutineContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Circular Buffer Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Circular Buffer Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCircularBufferDeclaration(CircularBufferDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundStatement(CompoundStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stateful Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stateful Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatefulVariableDeclaration(StatefulVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputVariableDeclaration(InputVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputVariableDeclaration(OutputVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateVariableDeclaration(TemplateVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateVariableDeclaration(StateVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariableDeclaration(LocalVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompound(Compound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computation Compound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computation Compound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputationCompound(ComputationCompound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Foreach Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Foreach Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForeachStatement(ForeachStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableReference(VariableReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ImperativeModelSwitch
