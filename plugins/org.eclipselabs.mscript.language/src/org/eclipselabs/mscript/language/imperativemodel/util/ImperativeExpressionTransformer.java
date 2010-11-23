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
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
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
import org.eclipselabs.mscript.language.ast.OperationCall;
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

		ImperativeExpressionTarget target = targets.get(0);
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
			letVariableDeclaration.setInitializer(doSwitch(letExpressionVariableDeclaration.getAssignedExpression()));
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
		ifStatement.setCondition(doSwitch(ifExpression.getCondition()));
		
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
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureCall(org.eclipselabs.mscript.language.ast.FeatureCall)
	 */
	@Override
	public Expression caseFeatureCall(FeatureCall featureCall) {
		if (featureCall.getTarget() instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) featureCall.getTarget();
			VariableDeclaration variableDeclaration = scope.getVariableDeclaration(simpleName.getIdentifier());
			if (variableDeclaration != null) {
				int stepIndex = 0;
				List<FeatureCallPart> parts = featureCall.getParts();
				if (!parts.isEmpty() && parts.get(0) instanceof OperationCall) {
					OperationCall operationCall = (OperationCall) parts.get(0);
					if (!operationCall.getArguments().isEmpty()) {
						StepExpressionResult stepExpressionResult = new StepExpressionHelper().evaluate(operationCall.getArguments().get(0), new BasicDiagnostic());
						stepIndex = stepExpressionResult.getIndex();
					}
				}
				VariableReference variableReference = ImperativeModelFactory.eINSTANCE.createVariableReference();
				variableReference.setDeclaration(variableDeclaration);
				variableReference.setStepIndex(stepIndex);
				return variableReference;
			}
		}
		return super.caseFeatureCall(featureCall);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public Expression caseAdditiveExpression(AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = AstFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setLeftOperand(doSwitch(additiveExpression.getLeftOperand()));
		for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
			AdditiveExpressionPart transformedRightPart = AstFactory.eINSTANCE.createAdditiveExpressionPart();
			transformedRightPart.setOperator(rightPart.getOperator());
			transformedRightPart.setOperand(doSwitch(rightPart.getOperand()));
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public Expression caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setLeftOperand(doSwitch(multiplicativeExpression.getLeftOperand()));
		for (MultiplicativeExpressionPart rightPart : multiplicativeExpression.getRightParts()) {
			MultiplicativeExpressionPart transformedRightPart = AstFactory.eINSTANCE.createMultiplicativeExpressionPart();
			transformedRightPart.setOperator(rightPart.getOperator());
			transformedRightPart.setOperand(doSwitch(rightPart.getOperand()));
			transformedExpression.getRightParts().add(transformedRightPart);
		}
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
	 */
	@Override
	public Expression caseRelationalExpression(RelationalExpression relationalExpression) {
		if (relationalExpression.isTypeTest()) {
			// TODO: to be implemented
			throw new IllegalArgumentException();
		}
		RelationalExpression transformedExpression = AstFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setTypeTest(false);
		transformedExpression.setOperator(relationalExpression.getOperator());
		transformedExpression.setLeftOperand(doSwitch(relationalExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(relationalExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public Expression caseUnaryExpression(UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = AstFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		transformedExpression.setOperand(doSwitch(unaryExpression.getOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public Expression caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = AstFactory.eINSTANCE.createParenthesizedExpression();
		for (Expression expression : parenthesizedExpression.getExpressions()) {
			transformedExpression.getExpressions().add(doSwitch(expression));
		}
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public Expression caseIntegerLiteral(IntegerLiteral integerLiteral) {
		return EcoreUtil.copy(integerLiteral);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public Expression caseRealLiteral(RealLiteral realLiteral) {
		return EcoreUtil.copy(realLiteral);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public Expression caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return EcoreUtil.copy(booleanLiteral);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public Expression caseStringLiteral(StringLiteral stringLiteral) {
		return EcoreUtil.copy(stringLiteral);
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
