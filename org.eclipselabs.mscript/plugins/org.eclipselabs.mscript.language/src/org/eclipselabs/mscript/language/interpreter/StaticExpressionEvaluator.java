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

package org.eclipselabs.mscript.language.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.core.value.AnyValue;
import org.eclipselabs.mscript.computation.core.value.ArrayValue;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.INumericValue;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.InvalidValue;
import org.eclipselabs.mscript.computation.core.value.StringValue;
import org.eclipselabs.mscript.computation.core.value.UnitValue;
import org.eclipselabs.mscript.computation.core.value.Values;
import org.eclipselabs.mscript.computation.core.value.VectorValue;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator;
import org.eclipselabs.mscript.language.ast.ArrayConstructionOperator;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.FunctionCall;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
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
import org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.interpreter.builtin.BuiltinFunctionLookupTable;
import org.eclipselabs.mscript.language.interpreter.builtin.IBuiltinFunctionLookupTable;
import org.eclipselabs.mscript.language.interpreter.builtin.IFunction;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.BooleanLiteral;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.IntegerLiteral;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.RealLiteral;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.StringLiteral;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.util.TypeSystemSwitch;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class StaticExpressionEvaluator {

	public IStatus evaluate(IStaticEvaluationContext context, Expression expression) {
		return evaluate(context, expression, false);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IEvaluationContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IStatus evaluate(IStaticEvaluationContext context, Expression expression, boolean staticScope) {
		ExpressionValueEvaluatorSwitch expressionValueEvaluatorSwitch = new ExpressionValueEvaluatorSwitch(context, staticScope);
		expressionValueEvaluatorSwitch.evaluate(expression);
		return expressionValueEvaluatorSwitch.getStatus();
	}
	
	private static class ExpressionValueEvaluatorSwitch extends AstSwitch<IValue> {
		
		private boolean staticScope;
		
		private MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Expression evaluation", null);

		private IStaticEvaluationContext context;
		
		private IBuiltinFunctionLookupTable builtinFunctionLookupTable = new BuiltinFunctionLookupTable();

		private ExpressionTypeSystemSwitch typeSystemSwitch = new ExpressionTypeSystemSwitch();

		/**
		 * 
		 */
		public ExpressionValueEvaluatorSwitch(IStaticEvaluationContext context, boolean staticScope) {
			this.context = context;
			this.staticScope = staticScope;
		}
		
		/**
		 * @return the status
		 */
		public MultiStatus getStatus() {
			return status;
		}
		
		public IValue evaluate(EObject eObject) {
			IValue value = doSwitch(eObject);
			context.setValue(eObject, value);
			return value;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
		 */
		@Override
		public IValue caseLetExpression(LetExpression letExpression) {
			for (LetExpressionVariableDeclaration declaration : letExpression.getVariableDeclarations()) {
				IValue value = evaluate(declaration.getAssignedExpression());
				context.setValue(declaration.getParts().get(0), value);
			}
			return evaluate(letExpression.getTargetExpression());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
		 */
		@Override
		public IValue caseIfExpression(IfExpression ifExpression) {
			staticScope = ifExpression.isStatic();
			IValue conditionValue = evaluate(ifExpression.getCondition());
			staticScope = false;

			if (conditionValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (ifExpression.isStatic()) {
				if (conditionValue instanceof IBooleanValue) {
					boolean booleanValue = ((IBooleanValue) conditionValue).booleanValue();
					if (booleanValue) {
						return evaluate(ifExpression.getThenExpression());
					}
					return evaluate(ifExpression.getElseExpression());
				}
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Static if expression condition cannot be evaluated", ifExpression));
				return InvalidValue.SINGLETON;
			}

			IValue thenValue = evaluate(ifExpression.getThenExpression());
			IValue elseValue = evaluate(ifExpression.getElseExpression());
			
			if (thenValue instanceof InvalidValue || elseValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			DataType dataType = TypeSystemUtil.getLeftHandDataType(thenValue.getDataType(), elseValue.getDataType());
			if (dataType == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with else expression data type", ifExpression.getThenExpression()));
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with then expression data type", ifExpression.getElseExpression()));
				return InvalidValue.SINGLETON;
			}
			
			return new AnyValue(context.getComputationContext(), dataType);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public IValue caseImpliesExpression(ImpliesExpression impliesExpression) {
			IValue leftValue = evaluate(impliesExpression.getLeftOperand());
			
			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (staticScope && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
				return Values.valueOf(context.getComputationContext(), true);
			}
			
			IValue rightValue = evaluate(impliesExpression.getRightOperand());
			
			if (rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (leftValue instanceof IBooleanValue) {
				IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
				if (!leftBooleanValue.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), true);
				}
				if (rightValue instanceof IBooleanValue) {
					IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
					return Values.valueOf(context.getComputationContext(), rightBooleanValue.booleanValue());
				}
			}

			if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
					&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
				return leftValue;
			}
			
			if (!(leftValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Implies expression left operand must result to boolean type", impliesExpression.getLeftOperand()));
			}
			
			if (!(rightValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Implies expression right operand must result to boolean type", impliesExpression.getRightOperand()));
			}

			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public IValue caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			IValue leftValue = evaluate(logicalOrExpression.getLeftOperand());

			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (staticScope && leftValue instanceof IBooleanValue && ((IBooleanValue) leftValue).booleanValue()) {
				return Values.valueOf(context.getComputationContext(), true);
			}

			IValue rightValue = evaluate(logicalOrExpression.getRightOperand());
			
			if (rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (leftValue instanceof IBooleanValue) {
				IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
				if (leftBooleanValue.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), true);
				}
				if (rightValue instanceof IBooleanValue) {
					IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
					return Values.valueOf(context.getComputationContext(), rightBooleanValue.booleanValue());
				}
			}
			
			if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
					&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
				return leftValue;
			}
			
			if (!(leftValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Logical OR expression left operand must result to boolean type", logicalOrExpression.getLeftOperand()));
			}
			
			if (!(rightValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Logical OR expression right operand must result to boolean type", logicalOrExpression.getRightOperand()));
			}

			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public IValue caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			IValue leftValue = evaluate(logicalAndExpression.getLeftOperand());
			
			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (staticScope && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
				return Values.valueOf(context.getComputationContext(), false);
			}

			IValue rightValue = evaluate(logicalAndExpression.getRightOperand());
			
			if (rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (leftValue instanceof IBooleanValue) {
				IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
				if (!leftBooleanValue.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), false);
				}
				if (rightValue instanceof IBooleanValue) {
					IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
					return Values.valueOf(context.getComputationContext(), rightBooleanValue.booleanValue());
				}
			}
			
			if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
					&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
				return leftValue;
			}
			
			if (!(leftValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Logical AND expression left operand must result to boolean type", logicalAndExpression.getLeftOperand()));
			}
			
			if (!(rightValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Logical AND expression right operand must result to boolean type", logicalAndExpression.getRightOperand()));
			}

			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public IValue caseEqualityExpression(EqualityExpression equalityExpression) {
			IValue leftValue = evaluate(equalityExpression.getLeftOperand());
			IValue rightValue = evaluate(equalityExpression.getRightOperand());
			
			if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			IValue result;
			switch (equalityExpression.getOperator()) {
			case EQUAL_TO:
				result = leftValue.equalTo(rightValue);
				break;
			case NOT_EQUAL_TO:
				result = leftValue.notEqualTo(rightValue);
				break;
			default:
				throw new IllegalArgumentException();
			}
			
			if (result instanceof InvalidValue) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid equality operation operands", equalityExpression));
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public IValue caseRelationalExpression(RelationalExpression relationalExpression) {
			IValue leftValue = evaluate(relationalExpression.getLeftOperand());
			IValue rightValue = evaluate(relationalExpression.getRightOperand());
			
			if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			IValue result;
			switch (relationalExpression.getOperator()) {
			case LESS_THAN:
				result = leftValue.lessThan(rightValue);
				break;
			case LESS_THAN_OR_EQUAL_TO:
				result = leftValue.lessThanOrEqualTo(rightValue);
				break;
			case GREATER_THAN:
				result = leftValue.greaterThan(rightValue);
				break;
			case GREATER_THAN_OR_EQUAL_TO:
				result = leftValue.greaterThanOrEqualTo(rightValue);
				break;
			default:
				throw new IllegalArgumentException();
			}
			
			if (result instanceof InvalidValue) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid relational operation operands", relationalExpression));
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
		 */
		@Override
		public IValue caseTypeTestExpression(TypeTestExpression typeTestExpression) {
			IValue value = evaluate(typeTestExpression.getExpression());
			if (value instanceof InvalidValue) {
				return value;
			}
			DataType dataType = EcoreUtil.copy(typeTestExpression.getType().getType());
			return Values.valueOf(context.getComputationContext(), dataType.isAssignableFrom(value.getDataType()));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public IValue caseAdditiveExpression(AdditiveExpression additiveExpression) {
			IValue leftValue = evaluate(additiveExpression.getLeftOperand());
			IValue rightValue = evaluate(additiveExpression.getRightOperand());
			
			if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			IValue result;

			switch (additiveExpression.getOperator()) {
			case ADD:
				result = leftValue.add(rightValue);
				break;
			case SUBTRACT:
				result = leftValue.subtract(rightValue);
				break;
			default:
				throw new IllegalArgumentException();
			}
			
			if (result instanceof InvalidValue) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Additive operation cannot not be performed on provided operands", additiveExpression));
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public IValue caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			IValue leftValue = evaluate(multiplicativeExpression.getLeftOperand());
			IValue rightValue = evaluate(multiplicativeExpression.getRightOperand());
			
			if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			IValue result;

			switch (multiplicativeExpression.getOperator()) {
			case MULTIPLY:
				result = leftValue.multiply(rightValue);
				break;
			case DIVIDE:
				result = leftValue.divide(rightValue);
				break;
			default:
				throw new IllegalArgumentException();
			}

			if (result instanceof InvalidValue) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Multiplicative operation cannot not be performed on provided operands", multiplicativeExpression));
			}
			
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public IValue caseUnaryExpression(UnaryExpression unaryExpression) {
			IValue operandValue = evaluate(unaryExpression.getOperand());
			if (operandValue instanceof InvalidValue) {
				return operandValue;
			}

			IValue result;

			switch (unaryExpression.getOperator()) {
			case NEGATE:
				result = operandValue.negate();
				break;
			case LOGICAL_NOT:
				if (operandValue instanceof IBooleanValue) {
					IBooleanValue booleanResult = (IBooleanValue) operandValue;
					result = Values.valueOf(context.getComputationContext(), !booleanResult.booleanValue());
				} else if (operandValue instanceof AnyValue && operandValue.getDataType() instanceof BooleanType) {
					result = operandValue;
				} else {
					result = InvalidValue.SINGLETON;
				}
				break;
			default:
				throw new IllegalArgumentException();
			}
			
			if (result instanceof InvalidValue) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid unary operation operand", unaryExpression));
			}
			
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
		 */
		@Override
		public IValue caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
			int size = arrayConstructionOperator.getExpressions().size();
			
			IValue[] elements = null;
			
			int i = 0;
			for (Expression expression : arrayConstructionOperator.getExpressions()) {
				IValue value = evaluate(expression);
				if (value instanceof InvalidValue) {
					return value;
				}
				if (elements == null) {
					if (value instanceof INumericValue) {
						elements = new INumericValue[size];
					} else {
						elements = new IValue[size];
					}
				} else if (elements instanceof INumericValue[] && !(value instanceof INumericValue)) {
					status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid array construction elements", arrayConstructionOperator));
					return InvalidValue.SINGLETON;
				}
				elements[i] = value;
				++i;
			}
			
			ArrayType arrayType = createArrayType(elements);
			
			if (arrayType == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid array construction elements", arrayConstructionOperator));
				return InvalidValue.SINGLETON;
			}
			
			if (arrayType instanceof TensorType) {
				return new VectorValue(context.getComputationContext(), (TensorType) arrayType, (INumericValue[]) elements);
			}
			
			return new ArrayValue(context.getComputationContext(), arrayType, elements);
		}
		
		private ArrayType createArrayType(IValue[] elements) {
			DataType elementType = null;
			
			for (IValue elementValue : elements) {
				DataType dataType = elementValue.getDataType();
				
				if (dataType == null || dataType instanceof InvalidDataType) {
					return null;
				}
				
				if (elementType != null && !elementType.isEquivalentTo(dataType)) {
					DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(elementType, dataType);
					if (leftHandDataType == null) {
						return null;
					}
					dataType = leftHandDataType;
				}
				
				elementType = dataType;
			}
			
			return TypeSystemUtil.createArrayType(elementType, elements.length);
		}
		
		public IValue caseArrayConcatenationOperator(ArrayConcatenationOperator arrayConcatenationOperator) {
			int rowSize = arrayConcatenationOperator.getRows().size();
			int columnSize = -1;
			
			for (ExpressionList expressionList : arrayConcatenationOperator.getRows()) {
				if (columnSize == -1) {
					columnSize = expressionList.getExpressions().size();
				} else if (columnSize < expressionList.getExpressions().size()) {
					columnSize = expressionList.getExpressions().size();
				}
			}
			
			IValue[][] matrix = new IValue[rowSize][columnSize];

			int row = 0;
			for (ExpressionList expressionList : arrayConcatenationOperator.getRows()) {
				int column = 0;
				for (Expression expression : expressionList.getExpressions()) {
					matrix[row][column] = evaluate(expression);
					++column;
				}
				++row;
			}
			
			IValue result = processMatrix(matrix, rowSize, columnSize);
			if (result instanceof InvalidValue) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid matrix operation", arrayConcatenationOperator));
			}
			return result;
		}
	
		public IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
			return InvalidValue.SINGLETON;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
		 */
		@Override
		public IValue caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
			Unit unit = null;
			if (unitConstructionOperator.getUnit().getNumerator() != null) {
				unit = EcoreUtil.copy(unitConstructionOperator.getUnit());
			}
			return new UnitValue(context.getComputationContext(), unit);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public IValue caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			return evaluate(parenthesizedExpression.getExpressions().get(0));
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
		 */
		@Override
		public IValue caseVariableAccess(VariableAccess variableAccess) {
			IValue value = context.getValue(variableAccess.getFeature());
			if (value == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "No value set for " + variableAccess.getFeature().getName(), variableAccess));
				value = InvalidValue.SINGLETON;
			}
			return value;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public IValue caseFunctionCall(FunctionCall functionCall) {
			String name = functionCall.getFeature().getName();
			
			List<IValue> argumentValues = new ArrayList<IValue>();
			for (Expression argument : functionCall.getArguments()) {
				argumentValues.add(ExpressionValueEvaluatorSwitch.this.evaluate(argument));
			}

			List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
			for (IValue argumentValue : argumentValues) {
				inputParameterDataTypes.add(argumentValue.getDataType());
			}
			BuiltinFunctionDescriptor descriptor = BuiltinFunctionDescriptor.get(name, inputParameterDataTypes);
			if (descriptor != null) {
				IFunction behavior = builtinFunctionLookupTable.getFunction(descriptor);
				if (behavior != null) {
					return behavior.call(context.getComputationContext(), argumentValues).get(0);
				}
			}
			
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "The Function " + functionCall.getFeature().getName() + " is not supported", functionCall));
			return InvalidValue.SINGLETON;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
		 */
		@Override
		public IValue caseIterationCall(IterationCall iterationCall) {
			if (!"iterate".equals(iterationCall.getIdentifier())) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid iteration call " + iterationCall.getIdentifier(), iterationCall));
				return InvalidValue.SINGLETON;
			}

			IValue targetValue = evaluate(iterationCall.getTarget());
			if (targetValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (!(targetValue.getDataType() instanceof ArrayType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Iteration call target must be array type", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			ArrayType arrayType = (ArrayType) targetValue.getDataType();
			
			if (arrayType.getDimensionality() != 1) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Iteration call target array type must have dimensionality of 1", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			// TODO: Evaluate all array sizes ahead of time
			Expression sizeExpression = arrayType.getDimensions().get(0).getSize();
			IValue sizeValue = evaluate(sizeExpression);
			if (!(sizeValue instanceof ISimpleNumericValue) || !(sizeValue.getDataType() instanceof IntegerType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Array size expression must be integer", sizeExpression));
				return InvalidValue.SINGLETON;
			}

			IValue accumulatorValue = evaluate(iterationCall.getAccumulator().getInitializer());
			if (accumulatorValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			context.setValue(iterationCall.getAccumulator(), accumulatorValue);
			
			if (iterationCall.getVariables().size() != 1) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Iteration call must have exactly one iteration variable", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			context.setValue(iterationCall.getVariables().get(0), new AnyValue(context.getComputationContext(), arrayType.getElementType()));

			IValue expressionValue = evaluate(iterationCall.getExpression());
			if (expressionValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			DataType resultingDataType = TypeSystemUtil.getLeftHandDataType(accumulatorValue.getDataType(), expressionValue.getDataType());
			if (resultingDataType == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Iteration call accumulator type is incompatabile with expression type", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			return new AnyValue(context.getComputationContext(), resultingDataType);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public IValue defaultCase(EObject object) {
			IValue value = typeSystemSwitch.evaluate(object);
			if (value != null) {
				return value;
			}
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid expression", object));
			return InvalidValue.SINGLETON;
		}
		
		private class ExpressionTypeSystemSwitch extends TypeSystemSwitch<IValue> {
			
			public IValue evaluate(EObject eObject) {
				IValue value = doSwitch(eObject);
				context.setValue(eObject, value);
				return value;
			}

			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
			 */
			@Override
			public IValue caseRealLiteral(RealLiteral realLiteral) {
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
				return Values.valueOf(context.getComputationContext(), realType, realLiteral.getValue());
			}
		
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
			 */
			@Override
			public IValue caseIntegerLiteral(IntegerLiteral integerLiteral) {
				IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));
				return Values.valueOf(context.getComputationContext(), integerType, integerLiteral.getValue());
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
			 */
			@Override
			public IValue caseBooleanLiteral(BooleanLiteral booleanLiteral) {
				return Values.valueOf(context.getComputationContext(), booleanLiteral.isTrue());
			}
		
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
			 */
			@Override
			public IValue caseStringLiteral(StringLiteral stringLiteral) {
				return new StringValue(context.getComputationContext(), stringLiteral.getValue());
			}
		
		};
		
	}
	
}
