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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause;
import org.eclipselabs.mscript.language.ast.ArrayConstructionOperator;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.FunctionCall;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.IfStatement;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.CompoundStatement;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.InvalidExpression;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.BooleanLiteral;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.IntegerLiteral;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.Literal;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.RealLiteral;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.StringLiteral;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemSwitch;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer extends AstSwitch<Expression> implements IExpressionTransformer {

	private ITransformerContext context;

	private IterationCallTransformerLookupTable iterationCallTransformerLookupTable = new IterationCallTransformerLookupTable();
	
	private MultiStatus status;

	/**
	 * 
	 */
	public ExpressionTransformer(ITransformerContext context) {
		this.context = context;
		status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Expression transformation", null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.Switch#doSwitch(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Expression doSwitch(EObject eObject) {
		Expression newExpression = super.doSwitch(eObject);
		IValue value = context.getStaticEvaluationContext().getValue(eObject);
		if (value != null) {
			if (!(eObject instanceof Literal)) {
				newExpression = condenseExpression(value, newExpression);
			}
			context.getStaticEvaluationContext().setValue(newExpression, value);
		}
		return newExpression;
	}

	/**
	 * @param value
	 * @param expression
	 * @return
	 */
	protected Expression condenseExpression(IValue value, Expression expression) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			NumericType dataType = numericValue.getDataType();
			if (dataType instanceof RealType) {
				RealLiteral realLiteral = TypeSystemFactory.eINSTANCE.createRealLiteral();
				realLiteral.setValue(numericValue.doubleValue());
				realLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = realLiteral;
			} else if (dataType instanceof IntegerType) {
				IntegerLiteral integerLiteral = TypeSystemFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setValue(numericValue.longValue());
				integerLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = integerLiteral;
			}
		}
		return expression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformer#transform(org.eclipselabs.mscript.language.ast.Expression, java.util.List)
	 */
	public IStatus transform(Expression expression, List<? extends IExpressionTarget> targets) {
		Expression result = doSwitch(expression);
		IExpressionTarget target = targets.get(0);

		Assignment assignment = ILFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result);
		assignment.setTarget(target.getVariableDeclaration());
		assignment.setStepIndex(target.getStepIndex());
		context.getCompound().getStatements().add(assignment);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public Expression caseLetExpression(LetExpression letExpression) {
		LocalVariableDeclaration localVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		IValue expressionValue = context.getStaticEvaluationContext().getValue(letExpression);
		context.getStaticEvaluationContext().setValue(localVariableDeclaration, expressionValue);
		context.getCompound().getStatements().add(localVariableDeclaration);

		CompoundStatement compoundStatement = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.setCompound(compoundStatement);
		context.addVariableDeclaration(localVariableDeclaration);

		for (LetExpressionVariableDeclaration letExpressionVariableDeclaration : letExpression.getVariableDeclarations()) {
			LocalVariableDeclaration letVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
			LetExpressionVariableDeclarationPart part = letExpressionVariableDeclaration.getParts().get(0);
			IValue partValue = context.getStaticEvaluationContext().getValue(part);
			context.getStaticEvaluationContext().setValue(letVariableDeclaration, partValue);
			letVariableDeclaration.setName(part.getName());
			Expression assignedExpression = doSwitch(letExpressionVariableDeclaration.getAssignedExpression());
			letVariableDeclaration.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(letVariableDeclaration);
			context.addVariableDeclaration(letVariableDeclaration);
		}

		transform(
				letExpression.getTargetExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		
		context.leaveScope();
		
		context.getCompound().getStatements().add(compoundStatement);
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(localVariableDeclaration);
		variableReference.setStepIndex(0);
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public Expression caseIfExpression(IfExpression ifExpression) {
		IValue ifConditionValue = context.getStaticEvaluationContext().getValue(ifExpression.getCondition());
		if (ifConditionValue instanceof IBooleanValue) {
			boolean condition = ((IBooleanValue) ifConditionValue).booleanValue();
			Expression expression = condition ? ifExpression.getThenExpression() : ifExpression.getElseExpression();
			return doSwitch(expression);
		}
		
		LocalVariableDeclaration localVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		IValue ifExpressionValue = context.getStaticEvaluationContext().getValue(ifExpression);
		context.getStaticEvaluationContext().setValue(localVariableDeclaration, ifExpressionValue);
		
		context.getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = AstFactory.eINSTANCE.createIfStatement();
		Expression conditionExpression = doSwitch(ifExpression.getCondition());
		ifStatement.setCondition(conditionExpression);
		
		CompoundStatement thenStatement = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.setCompound(thenStatement);
		context.addVariableDeclaration(localVariableDeclaration);
		transform(
				ifExpression.getThenExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		ifStatement.setThenStatement(thenStatement);
		
		CompoundStatement elseStatement = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.setCompound(elseStatement);
		context.addVariableDeclaration(localVariableDeclaration);
		transform(
				ifExpression.getElseExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		ifStatement.setElseStatement(elseStatement);
		
		context.getCompound().getStatements().add(ifStatement);
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(localVariableDeclaration);
		variableReference.setStepIndex(0);
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	@Override
	public Expression caseVariableAccess(VariableAccess variableAccess) {
		VariableDeclaration variableDeclaration = context.getVariableDeclaration(variableAccess.getFeature().getName());
		if (variableDeclaration != null) {
			VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
			variableReference.setTarget(variableDeclaration);
			variableReference.setStepIndex(context.getStaticEvaluationContext().getStepIndex(variableAccess));
			return variableReference;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFunctionCall(org.eclipselabs.mscript.language.ast.FunctionCall)
	 */
	@Override
	public Expression caseFunctionCall(FunctionCall functionCall) {
		FunctionCall transformedFunctionCall = AstFactory.eINSTANCE.createFunctionCall();
		transformedFunctionCall.setFeature(functionCall.getFeature());
		for (Expression expression : functionCall.getArguments()) {
			Expression transformedExpression = doSwitch(expression);
			if (transformedExpression instanceof InvalidExpression) {
				return transformedExpression;
			}
			transformedFunctionCall.getArguments().add(transformedExpression);
		}
		return transformedFunctionCall;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
	 */
	@Override
	public Expression caseIterationCall(IterationCall iterationCall) {
		IIterationCallTransformer transformer = iterationCallTransformerLookupTable.getTransformer(iterationCall.getIdentifier());
		if (transformer == null) {
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid iteration call", iterationCall));
			return createInvalidExpression();
		}
		
		IIterationCallTransformerResult result = transformer.transform(context, iterationCall, doSwitch(iterationCall.getTarget()));
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(result.getLocalVariableDeclaration());
		variableReference.setStepIndex(0);
		return variableReference;
	}
			
	private InvalidExpression createInvalidExpression() {
		InvalidExpression invalidExpression = ILFactory.eINSTANCE.createInvalidExpression();
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
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);

		return transformedImpliesExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
	 */
	@Override
	public Expression caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = AstFactory.eINSTANCE.createLogicalOrExpression();
		transformedExpression.setLeftOperand(doSwitch(logicalOrExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(logicalOrExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
	 */
	@Override
	public Expression caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = AstFactory.eINSTANCE.createLogicalAndExpression();
		transformedExpression.setLeftOperand(doSwitch(logicalAndExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(logicalAndExpression.getRightOperand()));
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
		
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public Expression caseAdditiveExpression(AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = AstFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setOperator(additiveExpression.getOperator());
		transformedExpression.setLeftOperand(doSwitch(additiveExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(additiveExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public Expression caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setOperator(multiplicativeExpression.getOperator());
		transformedExpression.setLeftOperand(doSwitch(multiplicativeExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(multiplicativeExpression.getRightOperand()));
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
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
	 */
	@Override
	public Expression caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
		ArrayConstructionOperator transformedExpression = AstFactory.eINSTANCE.createArrayConstructionOperator();
		for (Expression expression : arrayConstructionOperator.getExpressions()) {
			transformedExpression.getExpressions().add(doSwitch(expression));
		}
		for (ArrayConstructionIterationClause iterationClause : arrayConstructionOperator.getIterationClauses()) {
			Expression transformedCollectionExpression = doSwitch(iterationClause.getCollectionExpression());
			ArrayConstructionIterationClause transformedIterationClause = AstFactory.eINSTANCE.createArrayConstructionIterationClause();
			transformedIterationClause.setVariableName(iterationClause.getVariableName());
			transformedIterationClause.setCollectionExpression(transformedCollectionExpression);
			transformedExpression.getIterationClauses().add(transformedIterationClause);
		}
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
		return transformedExpression;
	}
	
	private final TypeSystemSwitch<Expression> typeSystemSwitch = new TypeSystemSwitch<Expression>() {
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public Expression caseRealLiteral(RealLiteral realLiteral) {
			RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
			realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
			
			RealLiteral transformedRealLiteral = EcoreUtil.copy(realLiteral);
			return transformedRealLiteral;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Expression caseIntegerLiteral(IntegerLiteral integerLiteral) {
			IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
			integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));
	
			IntegerLiteral transformedIntegerLiteral = EcoreUtil.copy(integerLiteral);
			return transformedIntegerLiteral;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
		 */
		@Override
		public Expression caseBooleanLiteral(BooleanLiteral booleanLiteral) {
			BooleanLiteral transformedBooleanLiteral = EcoreUtil.copy(booleanLiteral);
			return transformedBooleanLiteral;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
		 */
		@Override
		public Expression caseStringLiteral(StringLiteral stringLiteral) {
			StringLiteral transformedStringLiteral = EcoreUtil.copy(stringLiteral);
			return transformedStringLiteral;
		}
	
	};
	
	public Expression defaultCase(EObject object) {
		return typeSystemSwitch.doSwitch(object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
	 */
	@Override
	public Expression caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
		UnitConstructionOperator transformedUnitConstructionOperator = EcoreUtil.copy(unitConstructionOperator);
		return transformedUnitConstructionOperator;
	}
	
}
