/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.imperativemodel.*;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.CompoundStatement;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ForeachStatement;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionDefinition;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Statement;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage
 * @generated
 */
public class ImperativeModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImperativeModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ImperativeModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeModelSwitch<Adapter> modelSwitch =
		new ImperativeModelSwitch<Adapter>() {
			@Override
			public Adapter caseImperativeFunctionDefinition(ImperativeFunctionDefinition object) {
				return createImperativeFunctionDefinitionAdapter();
			}
			@Override
			public Adapter caseCompound(Compound object) {
				return createCompoundAdapter();
			}
			@Override
			public Adapter caseComputationCompound(ComputationCompound object) {
				return createComputationCompoundAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseStatefulVariableDeclaration(StatefulVariableDeclaration object) {
				return createStatefulVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseTemplateVariableDeclaration(TemplateVariableDeclaration object) {
				return createTemplateVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseInputVariableDeclaration(InputVariableDeclaration object) {
				return createInputVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseOutputVariableDeclaration(OutputVariableDeclaration object) {
				return createOutputVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseInstanceVariableDeclaration(InstanceVariableDeclaration object) {
				return createInstanceVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseLocalVariableDeclaration(LocalVariableDeclaration object) {
				return createLocalVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseCompoundStatement(CompoundStatement object) {
				return createCompoundStatementAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object) {
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseIfStatement(IfStatement object) {
				return createIfStatementAdapter();
			}
			@Override
			public Adapter caseForeachStatement(ForeachStatement object) {
				return createForeachStatementAdapter();
			}
			@Override
			public Adapter caseVariableReference(VariableReference object) {
				return createVariableReferenceAdapter();
			}
			@Override
			public Adapter caseOperationCall(OperationCall object) {
				return createOperationCallAdapter();
			}
			@Override
			public Adapter caseBuiltinFunctionCall(BuiltinFunctionCall object) {
				return createBuiltinFunctionCallAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionDefinition <em>Imperative Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionDefinition
	 * @generated
	 */
	public Adapter createImperativeFunctionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.CompoundStatement <em>Compound Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.CompoundStatement
	 * @generated
	 */
	public Adapter createCompoundStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration <em>Stateful Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration
	 * @generated
	 */
	public Adapter createStatefulVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration <em>Template Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration
	 * @generated
	 */
	public Adapter createTemplateVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration <em>Input Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration
	 * @generated
	 */
	public Adapter createInputVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration <em>Output Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration
	 * @generated
	 */
	public Adapter createOutputVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration <em>Instance Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration
	 * @generated
	 */
	public Adapter createInstanceVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration <em>Local Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration
	 * @generated
	 */
	public Adapter createLocalVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Compound
	 * @generated
	 */
	public Adapter createCompoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ComputationCompound
	 * @generated
	 */
	public Adapter createComputationCompoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.IfStatement
	 * @generated
	 */
	public Adapter createIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.ForeachStatement <em>Foreach Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ForeachStatement
	 * @generated
	 */
	public Adapter createForeachStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableReference
	 * @generated
	 */
	public Adapter createVariableReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.OperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.OperationCall
	 * @generated
	 */
	public Adapter createOperationCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.imperativemodel.BuiltinFunctionCall <em>Builtin Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.imperativemodel.BuiltinFunctionCall
	 * @generated
	 */
	public Adapter createBuiltinFunctionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.ast.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ImperativeModelAdapterFactory
