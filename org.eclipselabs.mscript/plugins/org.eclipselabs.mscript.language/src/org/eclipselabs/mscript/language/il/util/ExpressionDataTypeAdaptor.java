/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.il.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.FunctionCall;
import org.eclipselabs.mscript.language.il.Name;
import org.eclipselabs.mscript.language.il.PropertyReference;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor;
import org.eclipselabs.mscript.typesystem.BooleanLiteral;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.IntegerLiteral;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.RealLiteral;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.StringLiteral;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemSwitch;

public class ExpressionDataTypeAdaptor implements IExpressionDataTypeAdaptor {
	
	private final ExpressionAdaptorSwitch expressionAdaptorSwitch = new ExpressionAdaptorSwitch();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.IExpressionDataTypeAdaptor#adapt(org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IStatus adapt(Expression expression) {
		expressionAdaptorSwitch.doSwitch(expression);
		return Status.OK_STATUS;
	}
	
	private static class ExpressionAdaptorSwitch extends AstSwitch<DataType> {

		private final ILExpressionAdaptor ilExpressionAdaptor = new ILExpressionAdaptor();

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public DataType caseImpliesExpression(ImpliesExpression impliesExpression) {
			DataType leftDataType = doSwitch(impliesExpression.getLeftOperand());
			DataType rightDataType = doSwitch(impliesExpression.getRightOperand());
			
			DataType dataType = leftDataType.evaluate(OperatorKind.IMPLIES, rightDataType);
			
			ILUtil.setDataType(impliesExpression, dataType);
			
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public DataType caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			DataType dataType = null;
			
			for (Expression operand : logicalOrExpression.getOperands()) {
				DataType operandDataType = doSwitch(operand);
				if (dataType == null) {
					dataType = operandDataType;
				} else {
					dataType = dataType.evaluate(OperatorKind.LOGICAL_OR, operandDataType);
				}
			}
			
			ILUtil.setDataType(logicalOrExpression, dataType);
	
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public DataType caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			DataType dataType = null;
			
			for (Expression operand : logicalAndExpression.getOperands()) {
				DataType operandDataType = doSwitch(operand);
				if (dataType == null) {
					dataType = operandDataType;
				} else {
					dataType = dataType.evaluate(OperatorKind.LOGICAL_AND, operandDataType);
				}
			}
			
			ILUtil.setDataType(logicalAndExpression, dataType);
	
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public DataType caseEqualityExpression(EqualityExpression equalityExpression) {
			DataType leftDataType = doSwitch(equalityExpression.getLeftOperand());
			DataType rightDataType = doSwitch(equalityExpression.getRightOperand());
			
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
			DataType dataType = leftDataType.evaluate(operatorKind, rightDataType);
			
			ILUtil.setDataType(equalityExpression, dataType);
			
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public DataType caseRelationalExpression(RelationalExpression relationalExpression) {
			DataType leftDataType = doSwitch(relationalExpression.getLeftOperand());
			DataType rightDataType = doSwitch(relationalExpression.getRightOperand());
			
			OperatorKind operatorKind;
			switch (relationalExpression.getOperator()) {
			case LESS_THAN:
				operatorKind = OperatorKind.LESS_THAN;
				break;
			case LESS_THAN_OR_EQUAL_TO:
				operatorKind = OperatorKind.LESS_THAN_OR_EQUAL_TO;
				break;
			case GREATER_THAN:
				operatorKind = OperatorKind.GREATER_THAN;
				break;
			case GREATER_THAN_OR_EQUAL_TO:
				operatorKind = OperatorKind.GREATER_THAN_OR_EQUAL_TO;
				break;
			default:
				throw new IllegalArgumentException();
			}
			DataType dataType = leftDataType.evaluate(operatorKind, rightDataType);
			
			ILUtil.setDataType(relationalExpression, dataType);
			
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public DataType caseAdditiveExpression(AdditiveExpression additiveExpression) {
			DataType dataType = doSwitch(additiveExpression.getLeftOperand());
			
			for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
				OperatorKind operatorKind;
				switch (rightPart.getOperator()) {
				case ADDITION:
					operatorKind = OperatorKind.ADD;
					break;
				case SUBTRACTION:
					operatorKind = OperatorKind.SUBTRACT;
					break;
				default:
					throw new IllegalArgumentException();
				}
				dataType = dataType.evaluate(operatorKind, doSwitch(rightPart.getOperand()));
			}
			
			ILUtil.setDataType(additiveExpression, dataType);
			
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public DataType caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			DataType dataType = doSwitch(multiplicativeExpression.getLeftOperand());
			
			for (MultiplicativeExpressionPart rightPart : multiplicativeExpression.getRightParts()) {
				OperatorKind operatorKind;
				switch (rightPart.getOperator()) {
				case MULTIPLICATION:
					operatorKind = OperatorKind.MULTIPLY;
					break;
				case DIVISION:
					operatorKind = OperatorKind.DIVIDE;
					break;
				case ELEMENT_WISE_MULTIPLICATION:
					operatorKind = OperatorKind.ELEMENT_WISE_MULTIPLY;
					break;
				case ELEMENT_WISE_DIVISION:
					operatorKind = OperatorKind.ELEMENT_WISE_DIVIDE;
					break;
				default:
					throw new IllegalArgumentException();
				}
				dataType = dataType.evaluate(operatorKind, doSwitch(rightPart.getOperand()));
			}
			
			ILUtil.setDataType(multiplicativeExpression, dataType);
			
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
		 */
		@Override
		public DataType caseTypeTestExpression(TypeTestExpression typeTestExpression) {
			doSwitch(typeTestExpression.getExpression());
			DataType dataType = TypeSystemFactory.eINSTANCE.createBooleanType();
			ILUtil.setDataType(typeTestExpression, dataType);
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public DataType caseUnaryExpression(UnaryExpression unaryExpression) {
			OperatorKind operatorKind;
			switch (unaryExpression.getOperator()) {
			case MINUS:
				operatorKind = OperatorKind.NEGATE;
				break;
			case LOGICAL_NOT:
				operatorKind = OperatorKind.LOGICAL_NOT;
				break;
			default:
				throw new IllegalArgumentException();
			}
			DataType dataType = doSwitch(unaryExpression.getOperand()).evaluate(operatorKind, null);
			ILUtil.setDataType(unaryExpression, dataType);
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public DataType caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			DataType dataType = doSwitch(parenthesizedExpression.getExpressions().get(0));
			ILUtil.setDataType(parenthesizedExpression, dataType);
			return dataType;
		}
		
		private TypeSystemSwitch<DataType> typeSystemSwitch = new TypeSystemSwitch<DataType>() { 
		
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
			 */
			@Override
			public DataType caseRealLiteral(RealLiteral realLiteral) {
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
				ILUtil.setDataType(realLiteral, realType);
				return realType;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
			 */
			@Override
			public DataType caseIntegerLiteral(IntegerLiteral integerLiteral) {
				IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));
				ILUtil.setDataType(integerLiteral, integerType);
				return integerType;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
			 */
			@Override
			public DataType caseBooleanLiteral(BooleanLiteral booleanLiteral) {
				DataType dataType = TypeSystemFactory.eINSTANCE.createBooleanType();
				ILUtil.setDataType(booleanLiteral, dataType);
				return dataType;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
			 */
			@Override
			public DataType caseStringLiteral(StringLiteral stringLiteral) {
				DataType dataType = TypeSystemFactory.eINSTANCE.createStringType();
				ILUtil.setDataType(stringLiteral, dataType);
				return dataType;
			}
		
		};
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
		 */
		@Override
		public DataType caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
			DataType dataType = TypeSystemFactory.eINSTANCE.createUnitType();
			ILUtil.setDataType(unitConstructionOperator, dataType);
			return dataType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public DataType defaultCase(EObject object) {
			DataType dataType = typeSystemSwitch.doSwitch(object);
			if (dataType != null) {
				return dataType;
			}
			if (object instanceof Expression) {
				return ilExpressionAdaptor.doSwitch(object);
			}
			return super.defaultCase(object);
		}
		
		private class ILExpressionAdaptor extends ILSwitch<DataType> {
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseVariableReference(org.eclipselabs.mscript.language.il.VariableReference)
			 */
			@Override
			public DataType caseVariableReference(VariableReference variableReference) {
				DataType dataType = variableReference.getTarget().getDataType();
				if (dataType == null) {
					throw new RuntimeException("Data type not set");
				}
				ILUtil.setDataType(variableReference, dataType);
				return dataType;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
			 */
			@Override
			public DataType caseFunctionCall(FunctionCall functionCall) {
				Name name = functionCall.getName();
				if (name.getSegments().size() == 1) {
					List<DataType> argumentDataTypes = new ArrayList<DataType>();
					for (Expression argument : functionCall.getArguments()) {
						argumentDataTypes.add(doSwitch(argument));
					}
					BuiltinFunctionDescriptor descriptor = BuiltinFunctionDescriptor.get(name.getLastSegment(), argumentDataTypes);
					if (descriptor != null) {
						DataType dataType = descriptor.getSignature().evaluateOutputParameterDataTypes(argumentDataTypes).get(0);
						ILUtil.setDataType(functionCall, dataType);
						return dataType;
					}
				}
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#casePropertyReference(org.eclipselabs.mscript.language.il.PropertyReference)
			 */
			@Override
			public DataType casePropertyReference(PropertyReference propertyReference) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			
		}
	
	}
	
}