/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.CompoundStatement;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.ILPackage;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.InvalidExpression;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ILFactoryImpl extends EFactoryImpl implements ILFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ILFactory init() {
		try {
			ILFactory theILFactory = (ILFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/mscript/IL/1.0.0"); 
			if (theILFactory != null) {
				return theILFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ILFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILFactoryImpl() {
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
			case ILPackage.IL_FUNCTION_DEFINITION: return createILFunctionDefinition();
			case ILPackage.COMPOUND: return createCompound();
			case ILPackage.COMPUTATION_COMPOUND: return createComputationCompound();
			case ILPackage.TEMPLATE_VARIABLE_DECLARATION: return createTemplateVariableDeclaration();
			case ILPackage.INPUT_VARIABLE_DECLARATION: return createInputVariableDeclaration();
			case ILPackage.OUTPUT_VARIABLE_DECLARATION: return createOutputVariableDeclaration();
			case ILPackage.INSTANCE_VARIABLE_DECLARATION: return createInstanceVariableDeclaration();
			case ILPackage.LOCAL_VARIABLE_DECLARATION: return createLocalVariableDeclaration();
			case ILPackage.COMPOUND_STATEMENT: return createCompoundStatement();
			case ILPackage.ASSIGNMENT: return createAssignment();
			case ILPackage.IF_STATEMENT: return createIfStatement();
			case ILPackage.FOREACH_STATEMENT: return createForeachStatement();
			case ILPackage.VARIABLE_REFERENCE: return createVariableReference();
			case ILPackage.INVALID_EXPRESSION: return createInvalidExpression();
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
			case ILPackage.IVALUE:
				return createIValueFromString(eDataType, initialValue);
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
			case ILPackage.IVALUE:
				return convertIValueToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILFunctionDefinition createILFunctionDefinition() {
		ILFunctionDefinitionImpl ilFunctionDefinition = new ILFunctionDefinitionImpl();
		return ilFunctionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound createCompound() {
		CompoundImpl compound = new CompoundImpl();
		return compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationCompound createComputationCompound() {
		ComputationCompoundImpl computationCompound = new ComputationCompoundImpl();
		return computationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateVariableDeclaration createTemplateVariableDeclaration() {
		TemplateVariableDeclarationImpl templateVariableDeclaration = new TemplateVariableDeclarationImpl();
		return templateVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariableDeclaration createInputVariableDeclaration() {
		InputVariableDeclarationImpl inputVariableDeclaration = new InputVariableDeclarationImpl();
		return inputVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVariableDeclaration createOutputVariableDeclaration() {
		OutputVariableDeclarationImpl outputVariableDeclaration = new OutputVariableDeclarationImpl();
		return outputVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceVariableDeclaration createInstanceVariableDeclaration() {
		InstanceVariableDeclarationImpl instanceVariableDeclaration = new InstanceVariableDeclarationImpl();
		return instanceVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableDeclaration createLocalVariableDeclaration() {
		LocalVariableDeclarationImpl localVariableDeclaration = new LocalVariableDeclarationImpl();
		return localVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundStatement createCompoundStatement() {
		CompoundStatementImpl compoundStatement = new CompoundStatementImpl();
		return compoundStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeachStatement createForeachStatement() {
		ForeachStatementImpl foreachStatement = new ForeachStatementImpl();
		return foreachStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidExpression createInvalidExpression() {
		InvalidExpressionImpl invalidExpression = new InvalidExpressionImpl();
		return invalidExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IValue createIValueFromString(EDataType eDataType, String initialValue) {
		return (IValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIValueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILPackage getILPackage() {
		return (ILPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ILPackage getPackage() {
		return ILPackage.eINSTANCE;
	}

} //ILFactoryImpl
