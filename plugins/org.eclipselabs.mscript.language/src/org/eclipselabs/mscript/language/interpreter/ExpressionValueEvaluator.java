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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.core.value.ArrayValue;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.INumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.InvalidValue;
import org.eclipselabs.mscript.computation.core.value.StringValue;
import org.eclipselabs.mscript.computation.core.value.UnitValue;
import org.eclipselabs.mscript.computation.core.value.ValueConstructor;
import org.eclipselabs.mscript.computation.core.value.VectorValue;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.ArrayConstructionOperator;
import org.eclipselabs.mscript.language.ast.BooleanKind;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.il.MethodCall;
import org.eclipselabs.mscript.language.il.PropertyReference;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
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
public class ExpressionValueEvaluator extends AbstractExpressionEvaluator<IValue> {
	
	private ValueConstructor valueConstructor = new ValueConstructor();

	private IInterpreterContext context;
	
	private ILExpressionValueEvaluator ilExpressionValueEvaluator = new ILExpressionValueEvaluator();
	
	/**
	 * 
	 */
	public ExpressionValueEvaluator(IInterpreterContext context) {
		this.context = context;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.AbstractExpressionEvaluator#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public IValue caseAdditiveExpression(AdditiveExpression addSubtractExpression) {
		IValue result = super.caseAdditiveExpression(addSubtractExpression);
		if (result instanceof InvalidValue) {
			throw new RuntimeException("Additive operation cannot not be performed on provided operands");
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#add(java.lang.Object, java.lang.Object)
	 */
	public IValue add(IValue addend1, IValue addend2) {
		return addend1.add(addend2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#subtract(java.lang.Object, java.lang.Object)
	 */
	public IValue subtract(IValue minuend, IValue subtrahend) {
		return minuend.subtract(subtrahend);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.AbstractExpressionEvaluator#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public IValue caseMultiplicativeExpression(MultiplicativeExpression multiplyDivideExpression) {
		IValue result = super.caseMultiplicativeExpression(multiplyDivideExpression);
		if (result instanceof InvalidValue) {
			throw new RuntimeException("Multiplicative operation cannot not be performed on provided operands");
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#multiply(java.lang.Object, java.lang.Object)
	 */
	public IValue multiply(IValue factor1, IValue factor2) {
		return factor1.multiply(factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#divide(java.lang.Object, java.lang.Object)
	 */
	public IValue divide(IValue dividend, IValue divisor) {
		return dividend.divide(divisor);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#elementWiseMultiply(java.lang.Object, java.lang.Object)
	 */
	public IValue elementWiseMultiply(IValue factor1, IValue factor2) {
		return factor1.elementWiseMultiply(factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#elementWiseDivide(java.lang.Object, java.lang.Object)
	 */
	public IValue elementWiseDivide(IValue dividend, IValue divisor) {
		return dividend.elementWiseDivide(divisor);
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
				return valueConstructor.createBooleanValue(context.getComputationContext(), true);
			}
			value = doSwitch(impliesExpression.getRightOperand());
			if (value instanceof IBooleanValue) {
				booleanResult = (IBooleanValue) value;
				return valueConstructor.createBooleanValue(context.getComputationContext(), booleanResult.booleanValue());
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
					return valueConstructor.createBooleanValue(context.getComputationContext(), false);
				}
			} else {
				throw new RuntimeException("Logical expression operands must be boolean");
			}
		}
		return valueConstructor.createBooleanValue(context.getComputationContext(), true);
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
					return valueConstructor.createBooleanValue(context.getComputationContext(), true);
				}
			} else {
				throw new RuntimeException("Logical expression operands must be boolean");
			}
		}
		return valueConstructor.createBooleanValue(context.getComputationContext(), false);
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
		DataType dataType = new DataTypeSpecifierEvaluator(context).doSwitch(typeTestExpression.getType());
		return valueConstructor.createBooleanValue(context.getComputationContext(), dataType.isAssignableFrom(value.getDataType()));
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
				result = valueConstructor.createBooleanValue(context.getComputationContext(), !booleanResult.booleanValue());
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

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processMatrix(org.eclipselabs.damos.evaluation.IEvaluationContext, T[][], int, int)
	 */
	public IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
		return InvalidValue.SINGLETON;
	}

	protected DataType getMatrixDataType(DataType[][] matrix, int rowSize, int columnSize) {
		DataType elementType = null;
		
		for (int row = 0; row < rowSize; ++row) {
			for (int column = 0; column < columnSize; ++column) {
				DataType dataType = matrix[row][column];
				
				if (dataType == null || dataType instanceof InvalidDataType) {
					return TypeSystemUtil.INVALID_DATA_TYPE;
				}
				
				if (!EcoreUtil.equals(elementType, dataType)) {
					DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(elementType, dataType);
					if (leftHandDataType == null) {
						return TypeSystemUtil.INVALID_DATA_TYPE;
					}
					dataType = leftHandDataType;
				}
				
				elementType = dataType;
			}
		}
		
		return TypeSystemUtil.createArrayType(elementType, rowSize, columnSize);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
	 */
	@Override
	public IValue caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
		try {
			Unit unit = null;
			if (unitConstructionOperator.getUnit().getNumerator() != null) {
				unit = new UnitExpressionHelper().evaluate(unitConstructionOperator.getUnit());
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
				realType.setUnit(new UnitExpressionHelper().evaluate(realLiteral.getUnit()));
			} else {
				realType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			throw new RuntimeException("Invalid unit", e);
		}
		return valueConstructor.createRealValue(context.getComputationContext(), realType, realLiteral.getValue());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public IValue caseIntegerLiteral(IntegerLiteral integerLiteral) {
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
		return valueConstructor.createIntegerValue(context.getComputationContext(), integerType, integerLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public IValue caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return valueConstructor.createBooleanValue(context.getComputationContext(), booleanLiteral.getValue() == BooleanKind.TRUE);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public IValue caseStringLiteral(StringLiteral stringLiteral) {
		return new StringValue(context.getComputationContext(), stringLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public IValue defaultCase(EObject object) {
		IValue value = ilExpressionValueEvaluator.doSwitch(object);
		if (value != null) {
			return value;
		}
		throw new RuntimeException("Invalid expression");
	}
	
	private class ILExpressionValueEvaluator extends ILSwitch<IValue> {
		
		private BuiltinFeatureDescriptorLookupTable builtinFeatureLookupTable = new BuiltinFeatureDescriptorLookupTable();
		
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
			IFeature behavior = builtinFeatureLookupTable.getFunction(propertyReference.getName());
			if (behavior != null) {
				return behavior.call(context, ExpressionValueEvaluator.this.doSwitch(propertyReference.getTarget()), null);
			}
			return super.casePropertyReference(propertyReference);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseMethodCall(org.eclipselabs.mscript.language.il.MethodCall)
		 */
		@Override
		public IValue caseMethodCall(MethodCall methodCall) {
			IFeature behavior = builtinFeatureLookupTable.getFunction(methodCall.getName());
			if (behavior != null) {
				return behavior.call(context, ExpressionValueEvaluator.this.doSwitch(methodCall.getTarget()), null);
			}
			return super.caseMethodCall(methodCall);
		}
		
	}

}
