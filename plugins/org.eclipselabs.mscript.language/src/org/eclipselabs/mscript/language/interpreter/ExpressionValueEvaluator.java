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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.BooleanKind;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.language.internal.util.EObjectDiagnostic;
import org.eclipselabs.mscript.language.interpreter.value.IBooleanValue;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.InvalidValue;
import org.eclipselabs.mscript.language.interpreter.value.StringValue;
import org.eclipselabs.mscript.language.interpreter.value.UnitValue;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionValueEvaluator extends AbstractExpressionEvaluator<IValue> {

	private static final Scope MOST_OUTER_SCOPE = new Scope(null);
	
	private IInterpreterContext context;
	
	private Scope scope = MOST_OUTER_SCOPE;
	
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
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Additive operation cannot not be performed on provided operands", addSubtractExpression));
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
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Multiplicative operation cannot not be performed on provided operands", multiplyDivideExpression));
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
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
	 */
	@Override
	public IValue caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
		for (Expression operand : logicalAndExpression.getOperands()) {
			IValue operandValue = doSwitch(operand);
			if (operandValue instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) operandValue;
				if (!booleanResult.booleanValue()) {
					return context.getValueFactory().createBooleanValue(false);
				}
			} else {
				context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Logical expression operands must be boolean", operand));
				return InvalidValue.SINGLETON;
			}
		}
		return context.getValueFactory().createBooleanValue(true);
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
					return context.getValueFactory().createBooleanValue(true);
				}
			} else {
				context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Logical expression operands must be boolean", operand));
				return InvalidValue.SINGLETON;
			}
		}
		return context.getValueFactory().createBooleanValue(false);
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
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid equality operation operands", equalityExpression));
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
	 */
	@Override
	public IValue caseRelationalExpression(RelationalExpression relationalExpression) {
		IValue result = null;
		if (relationalExpression.getType() != null) {
			IValue value = doSwitch(relationalExpression.getLeftOperand());
			DataType dataType = new DataTypeSpecifierEvaluator(context).doSwitch(relationalExpression.getType());
			result = context.getValueFactory().createBooleanValue(dataType.isAssignableFrom(value.getDataType()));
		} else {
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
		}
		if (result instanceof InvalidValue) {
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid relational operation operands", relationalExpression));
		}
		return result;
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
				result = context.getValueFactory().createBooleanValue(!booleanResult.booleanValue());
			} else {
				result = InvalidValue.SINGLETON;
			}
			break;
		default:
			throw new IllegalArgumentException();
		}
		if (result instanceof InvalidValue) {
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid unary operation operand", unaryExpression));
		}
		return result;
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
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public IValue caseLetExpression(LetExpression letExpression) {
		Scope newScope = new Scope(scope);
		for (LetExpressionVariableDeclaration variableDeclaration : letExpression.getVariableDeclarations()) {
			IValue value = doSwitch(variableDeclaration.getAssignedExpression());
			if (value instanceof InvalidValue) {
				return value;
			}
			newScope.addVariable(variableDeclaration.getNames().get(0), value);
		}
		
		scope = newScope;
		IValue result = doSwitch(letExpression.getTargetExpression());
		scope = scope.getOuterScope();
		
		return result;
	}
	
	public IValue caseIfExpression(IfExpression ifExpression) {
		IValue conditionValue = doSwitch(ifExpression.getCondition());
		if (conditionValue instanceof IBooleanValue) {
			IBooleanValue booleanConditionValue = (IBooleanValue) conditionValue;
			if (booleanConditionValue.booleanValue()) {
				return doSwitch(ifExpression.getThenExpression());
			}
		} else {
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Condition expression must be boolean", ifExpression.getCondition()));
			return InvalidValue.SINGLETON;
		}
		return doSwitch(ifExpression.getElseExpression());
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
			return new UnitValue(unit);
		} catch (InvalidUnitExpressionOperandException e) {
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid unit", unitConstructionOperator.getUnit()));
		}
		return InvalidValue.SINGLETON;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureCall(org.eclipselabs.mscript.language.ast.FeatureCall)
	 */
	@Override
	public IValue caseFeatureCall(FeatureCall featureCall) {
		IValue value = null;
		if (featureCall.getTarget() instanceof SimpleName && featureCall.getParts().isEmpty()) {
			value = scope.getVariableValue(((SimpleName) featureCall.getTarget()).getIdentifier());
		}
		if (value == null) {
			value = context.getFeatureValue(featureCall);
			if (value == null) {
				context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Feature not found", featureCall));
				return InvalidValue.SINGLETON;
			}
		}
		return value;
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
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid unit", realLiteral.getUnit()));
			return InvalidValue.SINGLETON;
		}
		return context.getValueFactory().createRealValue(realType, realLiteral.getValue());
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
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid unit", integerLiteral.getUnit()));
			return InvalidValue.SINGLETON;
		}
		return context.getValueFactory().createIntegerValue(integerType, integerLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public IValue caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return context.getValueFactory().createBooleanValue(booleanLiteral.getValue() == BooleanKind.TRUE);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public IValue caseStringLiteral(StringLiteral stringLiteral) {
		return new StringValue(stringLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public IValue defaultCase(EObject object) {
		context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid expression", object));
		return InvalidValue.SINGLETON;
	}
	
	private static class Scope {

		private Scope outerScope;
		private Map<String, IValue> variables = new HashMap<String, IValue>();
		
		/**
		 * 
		 */
		public Scope(Scope outerScope) {
			this.outerScope = outerScope;
		}
		
		/**
		 * @return the outerScope
		 */
		public Scope getOuterScope() {
			return outerScope;
		}
		
		public void addVariable(String name, IValue value) {
			variables.put(name, value);
		}
		
		public IValue getVariableValue(String name) {
			IValue value;
			Scope scope = this;
			do {
				value = scope.variables.get(name);
			} while (value == null && (scope = scope.outerScope) != null);
			return value;
		}
		
	}

}
