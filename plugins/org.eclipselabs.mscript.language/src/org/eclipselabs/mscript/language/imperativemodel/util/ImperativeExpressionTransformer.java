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
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.CompoundStatement;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
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
public class ImperativeExpressionTransformer extends AstSwitch<ExpressionDescriptor> {
	
	private Scope scope;

	/**
	 * 
	 */
	public ImperativeExpressionTransformer(Scope scope) {
		this.scope = scope;
	}
	
	public void transform(Expression expression, List<ImperativeExpressionTarget> targets) {
		ExpressionDescriptor result = doSwitch(expression);

		if (result.getDataType() instanceof InvalidDataType) {
			throw new RuntimeException("Invalid data type");
		}

		ImperativeExpressionTarget target = targets.get(0);
		if (target.getVariableDeclaration().getType() == null) {
			target.getVariableDeclaration().setType(result.getDataType());
		} else {
			DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(target.getVariableDeclaration().getType(), result.getDataType());
			if (leftHandDataType == null) {
				throw new RuntimeException("Incompatible data types in assignment");
			}
			target.getVariableDeclaration().setType(leftHandDataType);
		}

		Assignment assignment = ImperativeModelFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result.getExpression());
		assignment.setTarget(target.getVariableDeclaration());
		assignment.setStepIndex(target.getStepIndex());
		scope.getCompound().getStatements().add(assignment);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public ExpressionDescriptor caseLetExpression(LetExpression letExpression) {
		LocalVariableDeclaration localVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(createLocalVariableName("letResult"));
		scope.getCompound().getStatements().add(localVariableDeclaration);

		CompoundStatement compoundStatement = ImperativeModelFactory.eINSTANCE.createCompoundStatement();
		scope = new Scope(scope, compoundStatement);
		scope.addVariableDeclaration(localVariableDeclaration);

		for (LetExpressionVariableDeclaration letExpressionVariableDeclaration : letExpression.getVariableDeclarations()) {
			LocalVariableDeclaration letVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
			letVariableDeclaration.setName(createLocalVariableName(letExpressionVariableDeclaration.getNames().get(0)));
			ExpressionDescriptor assignedExpressionDescriptor = doSwitch(letExpressionVariableDeclaration.getAssignedExpression());
			letVariableDeclaration.setType(assignedExpressionDescriptor.getDataType());
			letVariableDeclaration.setInitializer(assignedExpressionDescriptor.getExpression());
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
		return new ExpressionDescriptor(variableReference, localVariableDeclaration.getType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public ExpressionDescriptor caseIfExpression(IfExpression ifExpression) {
		LocalVariableDeclaration localVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(createLocalVariableName("ifResult"));
		scope.getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = ImperativeModelFactory.eINSTANCE.createIfStatement();
		ExpressionDescriptor conditionExpressionDescriptor = doSwitch(ifExpression.getCondition());
		ifStatement.setCondition(conditionExpressionDescriptor.getExpression());
		
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
		return new ExpressionDescriptor(variableReference, localVariableDeclaration.getType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureCall(org.eclipselabs.mscript.language.ast.FeatureCall)
	 */
	@Override
	public ExpressionDescriptor caseFeatureCall(FeatureCall featureCall) {
		if (featureCall.getTarget() instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) featureCall.getTarget();
			VariableDeclaration variableDeclaration = scope.getVariableDeclaration(simpleName.getIdentifier());
			if (variableDeclaration != null) {
				ListIterator<FeatureCallPart> partIterator = featureCall.getParts().listIterator();
				StepExpressionResult stepExpressionResult = new StepExpressionHelper().getStepExpression(partIterator, null);
				if (stepExpressionResult != null) {
					VariableReference variableReference = ImperativeModelFactory.eINSTANCE.createVariableReference();
					variableReference.setDeclaration(variableDeclaration);
					variableReference.setStepIndex(stepExpressionResult.getIndex());
					if (variableDeclaration.getType() == null) {
						throw new RuntimeException("Data type of variable declaration not set");
					}
					return new ExpressionDescriptor(variableReference, variableDeclaration.getType());
				}
			}
		}
		return super.caseFeatureCall(featureCall);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public ExpressionDescriptor caseAdditiveExpression(AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = AstFactory.eINSTANCE.createAdditiveExpression();
		ExpressionDescriptor expressionDescriptor = doSwitch(additiveExpression.getLeftOperand());
		transformedExpression.setLeftOperand(expressionDescriptor.getExpression());
		DataType dataType = expressionDescriptor.getDataType();
		for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
			AdditiveExpressionPart transformedRightPart = AstFactory.eINSTANCE.createAdditiveExpressionPart();
			transformedRightPart.setOperator(rightPart.getOperator());
			expressionDescriptor = doSwitch(rightPart.getOperand());
			transformedRightPart.setOperand(expressionDescriptor.getExpression());
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
			dataType = dataType.evaluate(operatorKind, expressionDescriptor.getDataType());
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		return new ExpressionDescriptor(transformedExpression, dataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public ExpressionDescriptor caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
		ExpressionDescriptor expressionDescriptor = doSwitch(multiplicativeExpression.getLeftOperand());
		transformedExpression.setLeftOperand(expressionDescriptor.getExpression());
		DataType dataType = expressionDescriptor.getDataType();
		for (MultiplicativeExpressionPart rightPart : multiplicativeExpression.getRightParts()) {
			MultiplicativeExpressionPart transformedRightPart = AstFactory.eINSTANCE.createMultiplicativeExpressionPart();
			transformedRightPart.setOperator(rightPart.getOperator());
			expressionDescriptor = doSwitch(rightPart.getOperand());
			transformedRightPart.setOperand(expressionDescriptor.getExpression());
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
			dataType = dataType.evaluate(operatorKind, expressionDescriptor.getDataType());
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		return new ExpressionDescriptor(transformedExpression, dataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
	 */
	@Override
	public ExpressionDescriptor caseRelationalExpression(RelationalExpression relationalExpression) {
		if (relationalExpression.isTypeTest()) {
			// TODO: to be implemented
			throw new IllegalArgumentException();
		}
		RelationalExpression transformedExpression = AstFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setTypeTest(false);
		transformedExpression.setOperator(relationalExpression.getOperator());
		ExpressionDescriptor leftExpressionDescriptor = doSwitch(relationalExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpressionDescriptor.getExpression());
		ExpressionDescriptor rightExpressionDescriptor = doSwitch(relationalExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpressionDescriptor.getExpression());
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
		return new ExpressionDescriptor(transformedExpression, leftExpressionDescriptor.getDataType().evaluate(operatorKind, rightExpressionDescriptor.getDataType()));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public ExpressionDescriptor caseUnaryExpression(UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = AstFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		ExpressionDescriptor expressionDescriptor = doSwitch(unaryExpression.getOperand());
		transformedExpression.setOperand(expressionDescriptor.getExpression());
		return new ExpressionDescriptor(transformedExpression, expressionDescriptor.getDataType().evaluate(OperatorKind.UNARY_MINUS, null));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public ExpressionDescriptor caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = AstFactory.eINSTANCE.createParenthesizedExpression();
		Expression expression = parenthesizedExpression.getExpressions().get(0);
		ExpressionDescriptor expressionDescriptor = doSwitch(expression);
		transformedExpression.getExpressions().add(expressionDescriptor.getExpression());
		return new ExpressionDescriptor(transformedExpression, expressionDescriptor.getDataType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public ExpressionDescriptor caseIntegerLiteral(IntegerLiteral integerLiteral) {
		IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(TypeSystemUtil.createUnit());
		return new ExpressionDescriptor(EcoreUtil.copy(integerLiteral), integerType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public ExpressionDescriptor caseRealLiteral(RealLiteral realLiteral) {
		RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
		realType.setUnit(TypeSystemUtil.createUnit());
		return new ExpressionDescriptor(EcoreUtil.copy(realLiteral), realType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public ExpressionDescriptor caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return new ExpressionDescriptor(EcoreUtil.copy(booleanLiteral), TypeSystemFactory.eINSTANCE.createBooleanType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public ExpressionDescriptor caseStringLiteral(StringLiteral stringLiteral) {
		return new ExpressionDescriptor(EcoreUtil.copy(stringLiteral), TypeSystemFactory.eINSTANCE.createStringType());
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
