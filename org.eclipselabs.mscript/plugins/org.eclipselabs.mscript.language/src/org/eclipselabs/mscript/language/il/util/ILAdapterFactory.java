/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.CompoundStatement;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.ILPackage;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.InvalidExpression;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.il.ILPackage
 * @generated
 */
public class ILAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ILPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ILPackage.eINSTANCE;
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
	protected ILSwitch<Adapter> modelSwitch =
		new ILSwitch<Adapter>() {
			@Override
			public Adapter caseILFunctionDefinition(ILFunctionDefinition object) {
				return createILFunctionDefinitionAdapter();
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
			public Adapter caseVariableAccess(VariableAccess object) {
				return createVariableAccessAdapter();
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
			public Adapter caseInvalidExpression(InvalidExpression object) {
				return createInvalidExpressionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition
	 * @generated
	 */
	public Adapter createILFunctionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.CompoundStatement <em>Compound Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.CompoundStatement
	 * @generated
	 */
	public Adapter createCompoundStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.VariableAccess
	 * @generated
	 */
	public Adapter createVariableAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.StatefulVariableDeclaration <em>Stateful Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.StatefulVariableDeclaration
	 * @generated
	 */
	public Adapter createStatefulVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.TemplateVariableDeclaration <em>Template Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.TemplateVariableDeclaration
	 * @generated
	 */
	public Adapter createTemplateVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.InputVariableDeclaration <em>Input Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.InputVariableDeclaration
	 * @generated
	 */
	public Adapter createInputVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.OutputVariableDeclaration <em>Output Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.OutputVariableDeclaration
	 * @generated
	 */
	public Adapter createOutputVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.InstanceVariableDeclaration <em>Instance Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.InstanceVariableDeclaration
	 * @generated
	 */
	public Adapter createInstanceVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.LocalVariableDeclaration <em>Local Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.LocalVariableDeclaration
	 * @generated
	 */
	public Adapter createLocalVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.Compound
	 * @generated
	 */
	public Adapter createCompoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.ComputationCompound
	 * @generated
	 */
	public Adapter createComputationCompoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.IfStatement
	 * @generated
	 */
	public Adapter createIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.ForeachStatement <em>Foreach Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.ForeachStatement
	 * @generated
	 */
	public Adapter createForeachStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.VariableReference
	 * @generated
	 */
	public Adapter createVariableReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.il.InvalidExpression <em>Invalid Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.il.InvalidExpression
	 * @generated
	 */
	public Adapter createInvalidExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.typesystem.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.typesystem.Expression
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

} //ILAdapterFactory
