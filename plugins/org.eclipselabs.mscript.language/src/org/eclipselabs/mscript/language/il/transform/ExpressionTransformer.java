/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.il.transform;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.FeatureReference;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.OperationArgumentList;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.BuiltinFunctionCall;
import org.eclipselabs.mscript.language.il.CompoundStatement;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.InvalidExpression;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.BuiltinFunctionDescriptor;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer extends AstSwitch<Expression> {

	private IExpressionTransformerContext context;

	private IterationCallTransformerLookupTable iterationCallTransformerLookupTable = new IterationCallTransformerLookupTable();
	
	private MultiStatus status;

	/**
	 * 
	 */
	public ExpressionTransformer(IExpressionTransformerContext context) {
		this.context = context;
		status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Expression transformer errors", null);
	}
	
	public IStatus transform(Expression expression, List<ExpressionTarget> targets) {
		Expression result = doSwitch(expression);
		DataType dataType = ILUtil.getDataType(result);
		
		if (dataType == null) {
			throw new RuntimeException("Data type not set");
		}

		ExpressionTarget target = targets.get(0);
		if (target.getVariableDeclaration().getType() == null) {
			target.getVariableDeclaration().setType(EcoreUtil.copy(dataType));
		} else {
			DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(target.getVariableDeclaration().getType(), dataType);
			if (leftHandDataType == null) {
				throw new RuntimeException("Incompatible data types in assignment");
			}
			target.getVariableDeclaration().setType(EcoreUtil.copy(leftHandDataType));
		}

		Assignment assignment = ILFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result);
		assignment.setTarget(target.getVariableDeclaration());
		assignment.setStepIndex(target.getStepIndex());
		context.getScope().getCompound().getStatements().add(assignment);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public Expression caseLetExpression(LetExpression letExpression) {
		LocalVariableDeclaration localVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		context.getScope().getCompound().getStatements().add(localVariableDeclaration);

		CompoundStatement compoundStatement = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.getScope().setCompound(compoundStatement);
		context.getScope().add(localVariableDeclaration);

		for (LetExpressionVariableDeclaration letExpressionVariableDeclaration : letExpression.getVariableDeclarations()) {
			LocalVariableDeclaration letVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
			letVariableDeclaration.setName(letExpressionVariableDeclaration.getNames().get(0));
			Expression assignedExpression = doSwitch(letExpressionVariableDeclaration.getAssignedExpression());
			letVariableDeclaration.setType(EcoreUtil.copy(ILUtil.getDataType(assignedExpression)));
			letVariableDeclaration.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(letVariableDeclaration);
			context.getScope().add(letVariableDeclaration);
		}

		transform(
				letExpression.getTargetExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		
		context.leaveScope();
		
		context.getScope().getCompound().getStatements().add(compoundStatement);
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(localVariableDeclaration);
		variableReference.setStepIndex(0);
		ILUtil.adaptDataType(variableReference, localVariableDeclaration.getType());
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public Expression caseIfExpression(IfExpression ifExpression) {
		LocalVariableDeclaration localVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		context.getScope().getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = ILFactory.eINSTANCE.createIfStatement();
		Expression conditionExpression = doSwitch(ifExpression.getCondition());
		ifStatement.setCondition(conditionExpression);
		
		CompoundStatement thenStatement = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.getScope().setCompound(thenStatement);
		context.getScope().add(localVariableDeclaration);
		transform(
				ifExpression.getThenExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		ifStatement.setThenStatement(thenStatement);
		
		CompoundStatement elseStatement = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.getScope().setCompound(elseStatement);
		context.getScope().add(localVariableDeclaration);
		transform(
				ifExpression.getElseExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		ifStatement.setElseStatement(elseStatement);
		
		context.getScope().getCompound().getStatements().add(ifStatement);
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(localVariableDeclaration);
		variableReference.setStepIndex(0);
		ILUtil.adaptDataType(variableReference, localVariableDeclaration.getType());
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureCall(org.eclipselabs.mscript.language.ast.FeatureCall)
	 */
	@Override
	public Expression caseFeatureCall(FeatureCall featureCall) {
		Expression targetExpression;
		ListIterator<FeatureCallPart> featureCallPartIterator = featureCall.getParts().listIterator();
		
		if (featureCall.getTarget() instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) featureCall.getTarget();
			targetExpression = resolveVariableReference(simpleName.getIdentifier(), featureCallPartIterator);
			if (targetExpression == null) {
				String message;
				if (featureCallPartIterator.hasNext() && featureCallPartIterator.next() instanceof OperationArgumentList) {
					message = "The method " + simpleName.getIdentifier() + "(...) is undefined";
				} else {
					message = simpleName.getIdentifier() + " cannot be resolved to a variable";
				}
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, message, simpleName));
				return createInvalidExpression();
			}
		} else {
			targetExpression = doSwitch(featureCall.getTarget());
		}
		
		FeatureCallPartTransformer featureCallPartTransformer = new FeatureCallPartTransformer();
		while (featureCallPartIterator.hasNext()) {
			featureCallPartTransformer.setTargetExpression(targetExpression);
			targetExpression = featureCallPartTransformer.doSwitch(featureCallPartIterator.next());
			if (targetExpression instanceof InvalidExpression) {
				return targetExpression;
			}
		}
		
		return targetExpression;
	}
	
	private Expression resolveVariableReference(String variableName, ListIterator<FeatureCallPart> featureCallPartIterator) {
		VariableDeclaration variableDeclaration = context.getScope().findInEnclosingScopes(variableName);
		if (variableDeclaration != null) {
			try {
				StepExpressionResult stepExpressionResult = new StepExpressionHelper().getStepExpression(featureCallPartIterator);
				VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
				variableReference.setTarget(variableDeclaration);
				variableReference.setStepIndex(stepExpressionResult.getIndex());
				if (variableDeclaration.getType() == null) {
					throw new RuntimeException("Data type of variable declaration not set");
				}
				ILUtil.adaptDataType(variableReference, variableDeclaration.getType());
				return variableReference;
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	private class FeatureCallPartTransformer extends AstSwitch<Expression> {

		private Expression targetExpression;
	
		/**
		 * @param targetExpression the targetExpression to set
		 */
		public void setTargetExpression(Expression targetExpression) {
			this.targetExpression = targetExpression;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureReference(org.eclipselabs.mscript.language.ast.FeatureReference)
		 */
		@Override
		public Expression caseFeatureReference(FeatureReference featureReference) {
			BuiltinFunctionDescriptor builtinFunctionDescriptor = BuiltinFunctionDescriptor.valueOf(featureReference.getName(), BuiltinFunctionDescriptor.PROPERTY);
			if (builtinFunctionDescriptor != null) {
				BuiltinFunctionCall builtinFunctionCall = ILFactory.eINSTANCE.createBuiltinFunctionCall();
				builtinFunctionCall.setName(featureReference.getName());
				builtinFunctionCall.getArguments().add(targetExpression);
				ILUtil.adaptDataType(builtinFunctionCall, TypeSystemFactory.eINSTANCE.createUnitType());
				return builtinFunctionCall;
			}
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid feature call", featureReference, AstPackage.FEATURE_REFERENCE__NAME));
			return createInvalidExpression();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayElementAccess(org.eclipselabs.mscript.language.ast.ArrayElementAccess)
		 */
		@Override
		public Expression caseArrayElementAccess(ArrayElementAccess arrayElementAccess) {
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Array element access not supported yet", arrayElementAccess));
			return createInvalidExpression();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
		 */
		@Override
		public Expression caseIterationCall(IterationCall iterationCall) {
			IIterationCallTransformer transformer = iterationCallTransformerLookupTable.getTransformer(iterationCall.getName());
			if (transformer == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid iteration call", iterationCall));
				return createInvalidExpression();
			}
			
			IIterationCallTransformerResult result = transformer.transform(context, iterationCall, targetExpression);
			
			VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
			variableReference.setTarget(result.getLocalVariableDeclaration());
			variableReference.setStepIndex(0);
			ILUtil.adaptDataType(variableReference, result.getLocalVariableDeclaration().getType());
			return variableReference;
		}
		
	}
		
	private InvalidExpression createInvalidExpression() {
		InvalidExpression invalidExpression = ILFactory.eINSTANCE.createInvalidExpression();
		DataType invalidDataType = TypeSystemFactory.eINSTANCE.createInvalidDataType();
		ILUtil.adaptDataType(invalidExpression, invalidDataType);
		return invalidExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
	 */
	@Override
	public Expression caseImpliesExpression(ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = AstFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = doSwitch(impliesExpression.getLeftOperand());
		Expression rightTransformedExpression = doSwitch(impliesExpression.getRightOperand());
		
		DataType leftDataType = ILUtil.getDataType(leftTransformedExpression);
		DataType rightDataType = ILUtil.getDataType(rightTransformedExpression);
		
		DataType dataType = leftDataType.evaluate(OperatorKind.IMPLIES, rightDataType);
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);

		ILUtil.adaptDataType(transformedImpliesExpression, dataType);
		
		return transformedImpliesExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
	 */
	@Override
	public Expression caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = AstFactory.eINSTANCE.createLogicalOrExpression();
		DataType dataType = null;
		
		for (Expression operand : logicalOrExpression.getOperands()) {
			Expression transformedOperand = doSwitch(operand);
			DataType operandDataType = ILUtil.getDataType(transformedOperand);
			if (dataType == null) {
				dataType = operandDataType;
			} else {
				dataType = dataType.evaluate(OperatorKind.LOGICAL_OR, operandDataType);
			}
			transformedExpression.getOperands().add(transformedOperand);
		}
		
		ILUtil.adaptDataType(transformedExpression, dataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
	 */
	@Override
	public Expression caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = AstFactory.eINSTANCE.createLogicalAndExpression();
		DataType dataType = null;
		
		for (Expression operand : logicalAndExpression.getOperands()) {
			Expression transformedOperand = doSwitch(operand);
			DataType operandDataType = ILUtil.getDataType(transformedOperand);
			if (dataType == null) {
				dataType = operandDataType;
			} else {
				dataType = dataType.evaluate(OperatorKind.LOGICAL_AND, operandDataType);
			}
			transformedExpression.getOperands().add(transformedOperand);
		}
		
		ILUtil.adaptDataType(transformedExpression, dataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
	 */
	@Override
	public Expression caseEqualityExpression(EqualityExpression equalityExpression) {
		EqualityExpression transformedExpression = AstFactory.eINSTANCE.createEqualityExpression();
		transformedExpression.setOperator(equalityExpression.getOperator());
		
		Expression leftExpression = doSwitch(equalityExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = doSwitch(equalityExpression.getRightOperand());		
		transformedExpression.setRightOperand(rightExpression);
		
		OperatorKind operatorKind;
		switch (equalityExpression.getOperator()) {
		case EQUAL_TO:
			operatorKind = OperatorKind.EQUAL_TO;
			break;
		case NOT_EQUAL_TO:
			operatorKind = OperatorKind.NOT_EQUAL_TO;
			break;
		default:
			throw new IllegalArgumentException();
		}
		
		DataType leftDataType = ILUtil.getDataType(leftExpression);
		DataType rightDataType = ILUtil.getDataType(rightExpression);
		DataType transformedDataType = leftDataType.evaluate(operatorKind, rightDataType);
		ILUtil.adaptDataType(transformedExpression, transformedDataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
	 */
	@Override
	public Expression caseRelationalExpression(RelationalExpression relationalExpression) {
		RelationalExpression transformedExpression = AstFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setOperator(relationalExpression.getOperator());
		
		Expression leftExpression = doSwitch(relationalExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = doSwitch(relationalExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpression);
		
		OperatorKind operatorKind;
		switch (relationalExpression.getOperator()) {
		case GREATER_THAN:
			operatorKind = OperatorKind.GREATER_THAN;
			break;
		case GREATER_THAN_OR_EQUAL_TO:
			operatorKind = OperatorKind.GREATER_THAN_OR_EQUAL_TO;
			break;
		case LESS_THAN:
			operatorKind = OperatorKind.LESS_THAN;
			break;
		case LESS_THAN_OR_EQUAL_TO:
			operatorKind = OperatorKind.LESS_THAN_OR_EQUAL_TO;
			break;
		default:
			throw new IllegalArgumentException();
		}
		DataType leftDataType = ILUtil.getDataType(leftExpression);
		DataType rightDataType = ILUtil.getDataType(rightExpression);
		DataType transformedDataType = leftDataType.evaluate(operatorKind, rightDataType);
		ILUtil.adaptDataType(transformedExpression, transformedDataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public Expression caseAdditiveExpression(AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = AstFactory.eINSTANCE.createAdditiveExpression();
		Expression expression = doSwitch(additiveExpression.getLeftOperand());
		transformedExpression.setLeftOperand(expression);
		DataType dataType = ILUtil.getDataType(expression);
		for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
			AdditiveExpressionPart transformedRightPart = AstFactory.eINSTANCE.createAdditiveExpressionPart();
			transformedRightPart.setOperator(rightPart.getOperator());
			expression = doSwitch(rightPart.getOperand());
			transformedRightPart.setOperand(expression);
			OperatorKind operatorKind;
			switch (rightPart.getOperator()) {
			case ADDITION:
				operatorKind = OperatorKind.ADDITION;
				break;
			case SUBTRACTION:
				operatorKind = OperatorKind.SUBTRACTION;
				break;
			default:
				throw new IllegalArgumentException();
			}
			dataType = dataType.evaluate(operatorKind, ILUtil.getDataType(expression));
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		ILUtil.adaptDataType(transformedExpression, dataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public Expression caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
		Expression expression = doSwitch(multiplicativeExpression.getLeftOperand());
		transformedExpression.setLeftOperand(expression);
		DataType dataType = ILUtil.getDataType(expression);
		for (MultiplicativeExpressionPart rightPart : multiplicativeExpression.getRightParts()) {
			MultiplicativeExpressionPart transformedRightPart = AstFactory.eINSTANCE.createMultiplicativeExpressionPart();
			transformedRightPart.setOperator(rightPart.getOperator());
			expression = doSwitch(rightPart.getOperand());
			transformedRightPart.setOperand(expression);
			OperatorKind operatorKind;
			switch (rightPart.getOperator()) {
			case MULTIPLICATION:
				operatorKind = OperatorKind.MULTIPLICATION;
				break;
			case DIVISION:
				operatorKind = OperatorKind.DIVISION;
				break;
			case ELEMENT_WISE_MULTIPLICATION:
				operatorKind = OperatorKind.ELEMENT_WISE_MULTIPLICATION;
				break;
			case ELEMENT_WISE_DIVISION:
				operatorKind = OperatorKind.ELEMENT_WISE_DIVISION;
				break;
			default:
				throw new IllegalArgumentException();
			}
			dataType = dataType.evaluate(operatorKind, ILUtil.getDataType(expression));
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		ILUtil.adaptDataType(transformedExpression, dataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
	 */
	@Override
	public Expression caseTypeTestExpression(TypeTestExpression typeTestExpression) {
		TypeTestExpression transformedTypeTestExpression = AstFactory.eINSTANCE.createTypeTestExpression();
		Expression expression = doSwitch(typeTestExpression.getExpression());
		transformedTypeTestExpression.setExpression(expression);
		transformedTypeTestExpression.setType(EcoreUtil.copy(typeTestExpression.getType()));
		ILUtil.adaptDataType(transformedTypeTestExpression, TypeSystemFactory.eINSTANCE.createBooleanType());
		return transformedTypeTestExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public Expression caseUnaryExpression(UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = AstFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		Expression expression = doSwitch(unaryExpression.getOperand());
		transformedExpression.setOperand(expression);
		DataType dataType = ILUtil.getDataType(expression);
		DataType transformedDataType = dataType.evaluate(OperatorKind.UNARY_MINUS, null);
		ILUtil.adaptDataType(transformedExpression, transformedDataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public Expression caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = AstFactory.eINSTANCE.createParenthesizedExpression();
		Expression firstParenthesizedExpression = parenthesizedExpression.getExpressions().get(0);
		Expression transformedFirstParenthesizedExpression = doSwitch(firstParenthesizedExpression);
		transformedExpression.getExpressions().add(transformedFirstParenthesizedExpression);
		DataType dataType = ILUtil.getDataType(transformedFirstParenthesizedExpression);
		ILUtil.adaptDataType(transformedExpression, dataType);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public Expression caseRealLiteral(RealLiteral realLiteral) {
		RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
		try {
			if (realLiteral.getUnit() != null) {
				realType.setUnit(new UnitExpressionHelper().evaluate(realLiteral.getUnit()));
			} else {
				realType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			throw new RuntimeException("Invalid unit", e);
		}
		
		RealLiteral transformedRealLiteral = EcoreUtil.copy(realLiteral);
		ILUtil.adaptDataType(transformedRealLiteral, realType);
		return transformedRealLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public Expression caseIntegerLiteral(IntegerLiteral integerLiteral) {
		IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
		try {
			if (integerLiteral.getUnit() != null) {
				integerType.setUnit(new UnitExpressionHelper().evaluate(integerLiteral.getUnit()));
			} else {
				integerType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			throw new RuntimeException("Invalid unit", e);
		}

		IntegerLiteral transformedIntegerLiteral = EcoreUtil.copy(integerLiteral);
		ILUtil.adaptDataType(transformedIntegerLiteral, integerType);
		return transformedIntegerLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public Expression caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		BooleanLiteral transformedBooleanLiteral = EcoreUtil.copy(booleanLiteral);
		ILUtil.adaptDataType(transformedBooleanLiteral, TypeSystemFactory.eINSTANCE.createBooleanType());
		return transformedBooleanLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public Expression caseStringLiteral(StringLiteral stringLiteral) {
		StringLiteral transformedStringLiteral = EcoreUtil.copy(stringLiteral);
		ILUtil.adaptDataType(transformedStringLiteral, TypeSystemFactory.eINSTANCE.createStringType());
		return transformedStringLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
	 */
	@Override
	public Expression caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
		UnitConstructionOperator transformedUnitConstructionOperator = EcoreUtil.copy(unitConstructionOperator);
		ILUtil.adaptDataType(transformedUnitConstructionOperator, TypeSystemFactory.eINSTANCE.createUnitType());
		return transformedUnitConstructionOperator;
	}
	
}
