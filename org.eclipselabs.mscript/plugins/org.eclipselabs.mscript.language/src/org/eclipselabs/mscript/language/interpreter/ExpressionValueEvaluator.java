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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.core.value.ArrayValue;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.INumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.IValueConstructor;
import org.eclipselabs.mscript.computation.core.value.InvalidValue;
import org.eclipselabs.mscript.computation.core.value.StringValue;
import org.eclipselabs.mscript.computation.core.value.UnitValue;
import org.eclipselabs.mscript.computation.core.value.ValueConstructor;
import org.eclipselabs.mscript.computation.core.value.VectorValue;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator;
import org.eclipselabs.mscript.language.ast.ArrayConstructionOperator;
import org.eclipselabs.mscript.language.ast.BooleanKind;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.FunctionCall;
import org.eclipselabs.mscript.language.il.Name;
import org.eclipselabs.mscript.language.il.PropertyReference;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.language.interpreter.builtin.BuiltinFunctionLookupTable;
import org.eclipselabs.mscript.language.interpreter.builtin.IBuiltinFunctionLookupTable;
import org.eclipselabs.mscript.language.interpreter.builtin.IFunction;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionValueEvaluator implements IExpressionValueEvaluator {
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IValue evaluate(IInterpreterContext context, Expression expression) {
		return new ExpressionValueEvaluatorSwitch(context).doSwitch(expression);
	}
	
	private static class ExpressionValueEvaluatorSwitch extends AstSwitch<IValue> {
		
		private IInterpreterContext context;

		private IValueConstructor valueConstructor = new ValueConstructor();

		private ILExpressionValueEvaluatorSwitch ilExpressionValueEvaluatorSwitch = new ILExpressionValueEvaluatorSwitch();
		
		private IDataTypeSpecifierEvaluator dataTypeSpecifierEvaluator = new DataTypeSpecifierEvaluator();
		
		private UnitExpressionHelper unitExpressionHelper = new UnitExpressionHelper();
		
		/**
		 * 
		 */
		public ExpressionValueEvaluatorSwitch(IInterpreterContext context) {
			this.context = context;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public IValue caseAdditiveExpression(AdditiveExpression addSubtractExpression) {
			IValue result = doSwitch(addSubtractExpression.getLeftOperand());
			for (AdditiveExpressionPart part : addSubtractExpression.getRightParts()) {
				result = addSubtract(result, doSwitch(part.getOperand()), part.getOperator());
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Additive operation cannot not be performed on provided operands");
			}
			return result;
		}

		private IValue addSubtract(IValue operand1, IValue operand2, AdditiveOperator operator) {
			switch (operator) {
			case ADDITION:
				return operand1.add(operand2);
			case SUBTRACTION:
				return operand1.subtract(operand2);
			}
			throw new IllegalArgumentException();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public IValue caseMultiplicativeExpression(MultiplicativeExpression multiplyDivideExpression) {
			IValue result = doSwitch(multiplyDivideExpression.getLeftOperand());
			for (MultiplicativeExpressionPart part : multiplyDivideExpression.getRightParts()) {
				result = multiplyDivide(result, doSwitch(part.getOperand()), part.getOperator());
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Multiplicative operation cannot not be performed on provided operands");
			}
			return result;
		}
		
		private IValue multiplyDivide(IValue operand1, IValue operand2, MultiplicativeOperator operator) {
			switch (operator) {
			case MULTIPLICATION:
				return operand1.multiply(operand2);
			case DIVISION:
				return operand1.divide(operand2);
			case ELEMENT_WISE_MULTIPLICATION:
				return operand1.elementWiseMultiply(operand2);
			case ELEMENT_WISE_DIVISION:
				return operand1.elementWiseDivide(operand2);
			}
			throw new IllegalArgumentException();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public IValue caseImpliesExpression(ImpliesExpression impliesExpression) {
			Expression operand = impliesExpression.getLeftOperand();
			IValue value = doSwitch(operand);
			if (value instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) value;
				if (!booleanResult.booleanValue()) {
					return valueConstructor.construct(context.getComputationContext(), true);
				}
				value = doSwitch(impliesExpression.getRightOperand());
				if (value instanceof IBooleanValue) {
					booleanResult = (IBooleanValue) value;
					return valueConstructor.construct(context.getComputationContext(), booleanResult.booleanValue());
				}
			}
			throw new RuntimeException("Implies expression operands must be boolean");
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public IValue caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			for (Expression operand : logicalAndExpression.getOperands()) {
				IValue operandValue = doSwitch(operand);
				if (operandValue instanceof IBooleanValue) {
					IBooleanValue booleanResult = (IBooleanValue) operandValue;
					if (!booleanResult.booleanValue()) {
						return valueConstructor.construct(context.getComputationContext(), false);
					}
				} else {
					throw new RuntimeException("Logical expression operands must be boolean");
				}
			}
			return valueConstructor.construct(context.getComputationContext(), true);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public IValue caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			for (Expression operand : logicalOrExpression.getOperands()) {
				IValue operandValue = doSwitch(operand);
				if (operandValue instanceof IBooleanValue) {
					IBooleanValue booleanResult = (IBooleanValue) operandValue;
					if (booleanResult.booleanValue()) {
						return valueConstructor.construct(context.getComputationContext(), true);
					}
				} else {
					throw new RuntimeException("Logical expression operands must be boolean");
				}
			}
			return valueConstructor.construct(context.getComputationContext(), false);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public IValue caseEqualityExpression(EqualityExpression equalityExpression) {
			IValue result = null;
			switch (equalityExpression.getOperator()) {
			case EQUAL_TO:
				result = doSwitch(equalityExpression.getLeftOperand()).equalTo(doSwitch(equalityExpression.getRightOperand()));
				break;
			case NOT_EQUAL_TO:
				result = doSwitch(equalityExpression.getLeftOperand()).notEqualTo(doSwitch(equalityExpression.getRightOperand()));
				break;
			default:
				throw new IllegalArgumentException();
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Invalid equality operation operands");
			}
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public IValue caseRelationalExpression(RelationalExpression relationalExpression) {
			IValue result = null;
			switch (relationalExpression.getOperator()) {
			case LESS_THAN:
				result = doSwitch(relationalExpression.getLeftOperand()).lessThan(doSwitch(relationalExpression.getRightOperand()));
				break;
			case LESS_THAN_OR_EQUAL_TO:
				result = doSwitch(relationalExpression.getLeftOperand()).lessThanOrEqualTo(doSwitch(relationalExpression.getRightOperand()));
				break;
			case GREATER_THAN:
				result = doSwitch(relationalExpression.getLeftOperand()).greaterThan(doSwitch(relationalExpression.getRightOperand()));
				break;
			case GREATER_THAN_OR_EQUAL_TO:
				result = doSwitch(relationalExpression.getLeftOperand()).greaterThanOrEqualTo(doSwitch(relationalExpression.getRightOperand()));
				break;
			default:
				throw new IllegalArgumentException();
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Invalid relational operation operands");
			}
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
		 */
		@Override
		public IValue caseTypeTestExpression(TypeTestExpression typeTestExpression) {
			IValue value = doSwitch(typeTestExpression.getExpression());
			DataType dataType = dataTypeSpecifierEvaluator.evaluate(context, typeTestExpression.getType());
			return valueConstructor.construct(context.getComputationContext(), dataType.isAssignableFrom(value.getDataType()));
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public IValue caseUnaryExpression(UnaryExpression unaryExpression) {
			IValue result;
			IValue operandValue = doSwitch(unaryExpression.getOperand());
			switch (unaryExpression.getOperator()) {
			case MINUS:
				result = operandValue.unaryMinus();
				break;
			case LOGICAL_NOT:
				if (operandValue instanceof IBooleanValue) {
					IBooleanValue booleanResult = (IBooleanValue) operandValue;
					result = valueConstructor.construct(context.getComputationContext(), !booleanResult.booleanValue());
				} else {
					result = InvalidValue.SINGLETON;
				}
				break;
			default:
				throw new IllegalArgumentException();
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Invalid unary operation operand");
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
				IValue value = doSwitch(expression);
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
					return InvalidValue.SINGLETON;
				}
				elements[i] = value;
				++i;
			}
			
			ArrayType arrayType = createArrayType(elements);
			
			if (arrayType == null) {
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
				
				if (elementType != null && !EcoreUtil.equals(elementType, dataType)) {
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
					matrix[row][column] = doSwitch(expression);
					++column;
				}
				++row;
			}
			
			return processMatrix(matrix, rowSize, columnSize);
		}
	
		public IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
			return InvalidValue.SINGLETON;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
		 */
		@Override
		public IValue caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
			try {
				Unit unit = null;
				if (unitConstructionOperator.getUnit().getNumerator() != null) {
					unit = unitExpressionHelper.evaluate(unitConstructionOperator.getUnit());
				}
				return new UnitValue(context.getComputationContext(), unit);
			} catch (InvalidUnitExpressionOperandException e) {
				throw new RuntimeException("Invalid unit", e);
			}
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public IValue caseRealLiteral(RealLiteral realLiteral) {
			RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
			try {
				if (realLiteral.getUnit() != null) {
					realType.setUnit(unitExpressionHelper.evaluate(realLiteral.getUnit()));
				} else {
					realType.setUnit(TypeSystemUtil.createUnit());
				}
			} catch (InvalidUnitExpressionOperandException e) {
				throw new RuntimeException("Invalid unit", e);
			}
			return valueConstructor.construct(context.getComputationContext(), realType, realLiteral.getValue());
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public IValue caseIntegerLiteral(IntegerLiteral integerLiteral) {
			IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
			try {
				if (integerLiteral.getUnit() != null) {
					integerType.setUnit(unitExpressionHelper.evaluate(integerLiteral.getUnit()));
				} else {
					integerType.setUnit(TypeSystemUtil.createUnit());
				}
			} catch (InvalidUnitExpressionOperandException e) {
				throw new RuntimeException("Invalid unit", e);
			}
			return valueConstructor.construct(context.getComputationContext(), integerType, integerLiteral.getValue());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
		 */
		@Override
		public IValue caseBooleanLiteral(BooleanLiteral booleanLiteral) {
			return valueConstructor.construct(context.getComputationContext(), booleanLiteral.getValue() == BooleanKind.TRUE);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
		 */
		@Override
		public IValue caseStringLiteral(StringLiteral stringLiteral) {
			return new StringValue(context.getComputationContext(), stringLiteral.getValue());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public IValue caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			return doSwitch(parenthesizedExpression.getExpressions().get(0));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public IValue defaultCase(EObject object) {
			IValue value = ilExpressionValueEvaluatorSwitch.doSwitch(object);
			if (value != null) {
				return value;
			}
			throw new RuntimeException("Invalid expression");
		}
	
		private class ILExpressionValueEvaluatorSwitch extends ILSwitch<IValue> {
			
			private IBuiltinFunctionLookupTable builtinFunctionLookupTable = new BuiltinFunctionLookupTable();
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseVariableReference(org.eclipselabs.mscript.language.imperativemodel.VariableReference)
			 */
			@Override
			public IValue caseVariableReference(VariableReference variableReference) {
				IVariable variable = context.getVariable(variableReference.getTarget());
				return variable.getValue(variableReference.getStepIndex());
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#casePropertyReference(org.eclipselabs.mscript.language.il.PropertyReference)
			 */
			@Override
			public IValue casePropertyReference(PropertyReference propertyReference) {
				return InvalidValue.SINGLETON;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
			 */
			@Override
			public IValue caseFunctionCall(FunctionCall functionCall) {
				Name name = functionCall.getName();
				
				List<IValue> argumentValues = new ArrayList<IValue>();
				for (Expression argument : functionCall.getArguments()) {
					argumentValues.add(ExpressionValueEvaluatorSwitch.this.doSwitch(argument));
				}

				if (name.getSegments().size() == 1) {
					List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
					for (IValue argumentValue : argumentValues) {
						inputParameterDataTypes.add(argumentValue.getDataType());
					}
					BuiltinFunctionDescriptor descriptor = BuiltinFunctionDescriptor.get(name.getLastSegment(), inputParameterDataTypes);
					if (descriptor != null) {
						IFunction behavior = builtinFunctionLookupTable.getFunction(descriptor);
						if (behavior != null) {
							return behavior.call(context, argumentValues).get(0);
						}
					}
				}
				
				return super.caseFunctionCall(functionCall);
			}
			
		}

	}
	
}
