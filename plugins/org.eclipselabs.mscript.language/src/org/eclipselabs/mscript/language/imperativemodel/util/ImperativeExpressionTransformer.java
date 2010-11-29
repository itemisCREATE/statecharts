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

package org.eclipselabs.mscript.language.imperativemodel.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
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
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.CompoundStatement;
import org.eclipselabs.mscript.language.imperativemodel.ForeachStatement;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeExpressionTransformer extends AstSwitch<Expression> {
	
	private Scope scope;

	/**
	 * 
	 */
	public ImperativeExpressionTransformer(Scope scope) {
		this.scope = scope;
	}
	
	public void transform(Expression expression, List<ImperativeExpressionTarget> targets) {
		Expression result = doSwitch(expression);
		DataType dataType = ImperativeModelUtil.getDataType(result);
		
		if (dataType == null) {
			throw new RuntimeException("Data type not set");
		}

		if (dataType instanceof InvalidDataType) {
			throw new RuntimeException("Invalid data type");
		}

		ImperativeExpressionTarget target = targets.get(0);
		if (target.getVariableDeclaration().getType() == null) {
			target.getVariableDeclaration().setType(EcoreUtil.copy(dataType));
		} else {
			DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(target.getVariableDeclaration().getType(), dataType);
			if (leftHandDataType == null) {
				throw new RuntimeException("Incompatible data types in assignment");
			}
			target.getVariableDeclaration().setType(EcoreUtil.copy(leftHandDataType));
		}

		Assignment assignment = ImperativeModelFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result);
		assignment.setTarget(target.getVariableDeclaration());
		assignment.setStepIndex(target.getStepIndex());
		scope.getCompound().getStatements().add(assignment);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public Expression caseLetExpression(LetExpression letExpression) {
		LocalVariableDeclaration localVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(createLocalVariableName("letResult"));
		scope.getCompound().getStatements().add(localVariableDeclaration);

		CompoundStatement compoundStatement = ImperativeModelFactory.eINSTANCE.createCompoundStatement();
		scope = new Scope(scope, compoundStatement);
		scope.addVariableDeclaration(localVariableDeclaration);

		for (LetExpressionVariableDeclaration letExpressionVariableDeclaration : letExpression.getVariableDeclarations()) {
			LocalVariableDeclaration letVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
			letVariableDeclaration.setName(createLocalVariableName(letExpressionVariableDeclaration.getNames().get(0)));
			Expression assignedExpression = doSwitch(letExpressionVariableDeclaration.getAssignedExpression());
			letVariableDeclaration.setType(EcoreUtil.copy(ImperativeModelUtil.getDataType(assignedExpression)));
			letVariableDeclaration.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(letVariableDeclaration);
			scope.addVariableDeclaration(letVariableDeclaration);
		}

		transform(
				letExpression.getTargetExpression(),
				Collections.singletonList(new ImperativeExpressionTarget(localVariableDeclaration, 0)));
		
		scope = scope.getOuterScope();
		
		scope.getCompound().getStatements().add(compoundStatement);
		
		VariableReference variableReference = ImperativeModelFactory.eINSTANCE.createVariableReference();
		variableReference.setDeclaration(localVariableDeclaration);
		variableReference.setStepIndex(0);
		ImperativeModelUtil.adaptDataType(variableReference, localVariableDeclaration.getType());
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public Expression caseIfExpression(IfExpression ifExpression) {
		LocalVariableDeclaration localVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(createLocalVariableName("ifResult"));
		scope.getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = ImperativeModelFactory.eINSTANCE.createIfStatement();
		Expression conditionExpression = doSwitch(ifExpression.getCondition());
		ifStatement.setCondition(conditionExpression);
		
		CompoundStatement thenStatement = ImperativeModelFactory.eINSTANCE.createCompoundStatement();
		scope = new Scope(scope, thenStatement);
		scope.addVariableDeclaration(localVariableDeclaration);
		transform(
				ifExpression.getThenExpression(),
				Collections.singletonList(new ImperativeExpressionTarget(localVariableDeclaration, 0)));
		scope = scope.getOuterScope();
		ifStatement.setThenStatement(thenStatement);
		
		CompoundStatement elseStatement = ImperativeModelFactory.eINSTANCE.createCompoundStatement();
		scope = new Scope(scope, elseStatement);
		scope.addVariableDeclaration(localVariableDeclaration);
		transform(
				ifExpression.getElseExpression(),
				Collections.singletonList(new ImperativeExpressionTarget(localVariableDeclaration, 0)));
		scope = scope.getOuterScope();
		ifStatement.setElseStatement(elseStatement);
		
		scope.getCompound().getStatements().add(ifStatement);
		
		VariableReference variableReference = ImperativeModelFactory.eINSTANCE.createVariableReference();
		variableReference.setDeclaration(localVariableDeclaration);
		variableReference.setStepIndex(0);
		ImperativeModelUtil.adaptDataType(variableReference, localVariableDeclaration.getType());
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
			targetExpression = resolveSimpleName(simpleName, featureCallPartIterator);
			if (targetExpression == null) {
				// TODO: Is it a function call? Maybe full qualified?
				throw new RuntimeException("Not yet implemented");
			}
		} else {
			targetExpression = doSwitch(featureCall.getTarget());
		}
		while (featureCallPartIterator.hasNext()) {
			targetExpression = transformNextFeatureCallPart(featureCallPartIterator, targetExpression);
		}
		return targetExpression;
	}
	
	private Expression resolveSimpleName(SimpleName simpleName, ListIterator<FeatureCallPart> featureCallPartIterator) {
		VariableDeclaration variableDeclaration = scope.getVariableDeclaration(simpleName.getIdentifier());
		if (variableDeclaration != null) {
			StepExpressionResult stepExpressionResult = new StepExpressionHelper().getStepExpression(featureCallPartIterator, null);
			if (stepExpressionResult != null) {
				VariableReference variableReference = ImperativeModelFactory.eINSTANCE.createVariableReference();
				variableReference.setDeclaration(variableDeclaration);
				variableReference.setStepIndex(stepExpressionResult.getIndex());
				if (variableDeclaration.getType() == null) {
					throw new RuntimeException("Data type of variable declaration not set");
				}
				ImperativeModelUtil.adaptDataType(variableReference, variableDeclaration.getType());
				return variableReference;
			}
		}
		return null;
	}
	
	private Expression transformNextFeatureCallPart(ListIterator<FeatureCallPart> featureCallPartIterator, Expression collectionExpression) {
		// Check for iterators
		FeatureCallPart featureCallPart = featureCallPartIterator.next();
		if (!(featureCallPart instanceof IterationCall)) {
			throw new RuntimeException("No idea what to do here");
		}
		IterationCall iterationCall = (IterationCall) featureCallPart;
		
		LocalVariableDeclaration accumulatorDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
		accumulatorDeclaration.setName(createLocalVariableName(iterationCall.getAccumulator().getName()));
		scope.getCompound().getStatements().add(accumulatorDeclaration);
		ForeachStatement foreachStatement = ImperativeModelFactory.eINSTANCE.createForeachStatement();
		
		LocalVariableDeclaration iterationVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
		iterationVariableDeclaration.setName(createLocalVariableName(iterationCall.getVariables().get(0).getName()));

		DataType collectionDataType = ImperativeModelUtil.getDataType(collectionExpression);
		if (!(collectionDataType instanceof ArrayType)) {
			throw new RuntimeException("Collection type must be array type");
		}
		ArrayType arrayType = (ArrayType) collectionDataType;
		iterationVariableDeclaration.setType(EcoreUtil.copy(arrayType.getElementType()));

		Expression initializerExpression = doSwitch(iterationCall.getAccumulator().getInitializer());
		accumulatorDeclaration.setInitializer(initializerExpression);
		accumulatorDeclaration.setType(EcoreUtil.copy(ImperativeModelUtil.getDataType(initializerExpression)));

		foreachStatement.setIterationVariableDeclaration(iterationVariableDeclaration);
		foreachStatement.setCollectionExpression(collectionExpression);

		CompoundStatement body = ImperativeModelFactory.eINSTANCE.createCompoundStatement();
		scope = new Scope(scope, body);
		scope.addVariableDeclaration(accumulatorDeclaration);
		scope.addVariableDeclaration(iterationVariableDeclaration);
		transform(
				iterationCall.getExpression(),
				Collections.singletonList(new ImperativeExpressionTarget(accumulatorDeclaration, 0)));
		scope = scope.getOuterScope();
		foreachStatement.setBody(body);

		scope.getCompound().getStatements().add(foreachStatement);
		
		VariableReference variableReference = ImperativeModelFactory.eINSTANCE.createVariableReference();
		variableReference.setDeclaration(accumulatorDeclaration);
		variableReference.setStepIndex(0);
		ImperativeModelUtil.adaptDataType(variableReference, accumulatorDeclaration.getType());
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
	 */
	@Override
	public Expression caseImpliesExpression(ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = AstFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = doSwitch(impliesExpression.getLeftOperand());
		Expression rightTransformedExpression = doSwitch(impliesExpression.getRightOperand());
		
		DataType leftDataType = ImperativeModelUtil.getDataType(leftTransformedExpression);
		DataType rightDataType = ImperativeModelUtil.getDataType(rightTransformedExpression);
		
		DataType dataType = leftDataType.evaluate(OperatorKind.IMPLIES, rightDataType);
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);

		ImperativeModelUtil.adaptDataType(transformedImpliesExpression, dataType);
		
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
			DataType operandDataType = ImperativeModelUtil.getDataType(transformedOperand);
			if (dataType == null) {
				dataType = operandDataType;
			} else {
				dataType = dataType.evaluate(OperatorKind.LOGICAL_OR, operandDataType);
			}
			transformedExpression.getOperands().add(transformedOperand);
		}
		
		ImperativeModelUtil.adaptDataType(transformedExpression, dataType);
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
			DataType operandDataType = ImperativeModelUtil.getDataType(transformedOperand);
			if (dataType == null) {
				dataType = operandDataType;
			} else {
				dataType = dataType.evaluate(OperatorKind.LOGICAL_AND, operandDataType);
			}
			transformedExpression.getOperands().add(transformedOperand);
		}
		
		ImperativeModelUtil.adaptDataType(transformedExpression, dataType);
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
		
		DataType leftDataType = ImperativeModelUtil.getDataType(leftExpression);
		DataType rightDataType = ImperativeModelUtil.getDataType(rightExpression);
		DataType transformedDataType = leftDataType.evaluate(operatorKind, rightDataType);
		ImperativeModelUtil.adaptDataType(transformedExpression, transformedDataType);
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
		DataType leftDataType = ImperativeModelUtil.getDataType(leftExpression);
		DataType rightDataType = ImperativeModelUtil.getDataType(rightExpression);
		DataType transformedDataType = leftDataType.evaluate(operatorKind, rightDataType);
		ImperativeModelUtil.adaptDataType(transformedExpression, transformedDataType);
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
		DataType dataType = ImperativeModelUtil.getDataType(expression);
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
			dataType = dataType.evaluate(operatorKind, ImperativeModelUtil.getDataType(expression));
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		ImperativeModelUtil.adaptDataType(transformedExpression, dataType);
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
		DataType dataType = ImperativeModelUtil.getDataType(expression);
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
			dataType = dataType.evaluate(operatorKind, ImperativeModelUtil.getDataType(expression));
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		ImperativeModelUtil.adaptDataType(transformedExpression, dataType);
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
		ImperativeModelUtil.adaptDataType(transformedTypeTestExpression, TypeSystemFactory.eINSTANCE.createBooleanType());
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
		DataType dataType = ImperativeModelUtil.getDataType(expression);
		DataType transformedDataType = dataType.evaluate(OperatorKind.UNARY_MINUS, null);
		ImperativeModelUtil.adaptDataType(transformedExpression, transformedDataType);
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
		DataType dataType = ImperativeModelUtil.getDataType(transformedFirstParenthesizedExpression);
		ImperativeModelUtil.adaptDataType(transformedExpression, dataType);
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
		ImperativeModelUtil.adaptDataType(transformedRealLiteral, realType);
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
		ImperativeModelUtil.adaptDataType(transformedIntegerLiteral, integerType);
		return transformedIntegerLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public Expression caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		BooleanLiteral transformedBooleanLiteral = EcoreUtil.copy(booleanLiteral);
		ImperativeModelUtil.adaptDataType(transformedBooleanLiteral, TypeSystemFactory.eINSTANCE.createBooleanType());
		return transformedBooleanLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public Expression caseStringLiteral(StringLiteral stringLiteral) {
		StringLiteral transformedStringLiteral = EcoreUtil.copy(stringLiteral);
		ImperativeModelUtil.adaptDataType(transformedStringLiteral, TypeSystemFactory.eINSTANCE.createStringType());
		return transformedStringLiteral;
	}
	
	private String createLocalVariableName(String preferredName) {
		String name = preferredName;
		int n = 1;
		while (scope.getVariableDeclaration(name) != null) {
			name = preferredName + ++n;
		}
		return name;
	}
	
	public static class Scope {

		private Scope outerScope;
		private Compound compound;
		private Map<String, VariableDeclaration> variableDeclarations = new HashMap<String, VariableDeclaration>();
		
		/**
		 * 
		 */
		public Scope(Scope outerScope, Compound compound) {
			this.outerScope = outerScope;
			this.compound = compound;
		}
		
		/**
		 * @return the outerScope
		 */
		public Scope getOuterScope() {
			return outerScope;
		}
		
		/**
		 * @return the compound
		 */
		public Compound getCompound() {
			return compound;
		}
		
		public void addVariableDeclaration(VariableDeclaration variableDeclaration) {
			variableDeclarations.put(variableDeclaration.getName(), variableDeclaration);
		}
		
		public VariableDeclaration getVariableDeclaration(String name) {
			VariableDeclaration variableDeclaration;
			Scope scope = this;
			do {
				variableDeclaration = scope.variableDeclarations.get(name);
			} while (variableDeclaration == null && (scope = scope.outerScope) != null);
			return variableDeclaration;
		}
		
	}

}
