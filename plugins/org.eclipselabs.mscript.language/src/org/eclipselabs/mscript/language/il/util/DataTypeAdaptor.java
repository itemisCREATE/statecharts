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

package org.eclipselabs.mscript.language.il.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.MethodCall;
import org.eclipselabs.mscript.language.il.PropertyReference;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.typesystem.ArrayType;
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
public class DataTypeAdaptor extends ILSwitch<Boolean> {
	
	private ExpressionAdaptor expressionAdaptor = new ExpressionAdaptor();
	
	private MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Data type adaptor errors", null);
	
	public IStatus adapt(ILFunctionDefinition functionDefinition) {
		boolean finished;
		
		do {
			finished = doSwitch(functionDefinition.getInitializationCompound());
			if (finished) {
				for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
					finished = doSwitch(compound);
					if (!finished) {
						break;
					}
				}
			}
		} while (!finished && status.isOK());
		
		return status;
	}

	public IStatus adapt(Compound compound) {
		boolean finished;
		
		do {
			finished = doSwitch(compound);
		} while (!finished && status.isOK());
		
		return status;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.il.Compound)
	 */
	@Override
	public Boolean caseCompound(Compound compound) {
		for (Statement statement : compound.getStatements()) {
			if (!doSwitch(statement)) {
				return false;
			}
		}
		return true;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
	 */
	@Override
	public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		if (localVariableDeclaration.getInitializer() != null) {
			DataType dataType = expressionAdaptor.doSwitch(localVariableDeclaration.getInitializer());
			return updateDataType(localVariableDeclaration, dataType);
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseAssignment(org.eclipselabs.mscript.language.il.Assignment)
	 */
	@Override
	public Boolean caseAssignment(Assignment assignment) {
		DataType dataType = expressionAdaptor.doSwitch(assignment.getAssignedExpression());
		return updateDataType(assignment.getTarget(), dataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseIfStatement(org.eclipselabs.mscript.language.il.IfStatement)
	 */
	@Override
	public Boolean caseIfStatement(IfStatement ifStatement) {
		expressionAdaptor.doSwitch(ifStatement.getCondition());
		return status.isOK() && doSwitch(ifStatement.getThenStatement()) && doSwitch(ifStatement.getElseStatement());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseForeachStatement(org.eclipselabs.mscript.language.il.ForeachStatement)
	 */
	@Override
	public Boolean caseForeachStatement(ForeachStatement foreachStatement) {
		DataType collectionType = expressionAdaptor.doSwitch(foreachStatement.getCollectionExpression());
		if (!status.isOK()) {
			return false;
		}
		
		if (!(collectionType instanceof ArrayType)) {
			status.add(new Status(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, "Collection type must be array type"));
			return false;
		}
		
		ArrayType arrayType = (ArrayType) collectionType;
		
		return updateDataType(foreachStatement.getIterationVariableDeclaration(), arrayType.getElementType()) && doSwitch(foreachStatement.getBody());
	}
		
	private boolean updateDataType(VariableDeclaration variableDeclaration, DataType dataType) {
		if (variableDeclaration.getType() == null) {
			variableDeclaration.setType(dataType);
			return true;
		}
		
		if (variableDeclaration.getType() == dataType) {
			return true;
		}

		DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(variableDeclaration.getType(), dataType);
		if (leftHandDataType == null) {
			status.add(new Status(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, "Incompatible data types"));
			return false;
		}
		
		if (leftHandDataType == dataType) {
			variableDeclaration.setType(leftHandDataType);
			return false;
		}
		
		return true;
	}
	
	private class ExpressionAdaptor extends AstSwitch<DataType> {
		
		private ILExpressionAdaptor ilExpressionAdaptor = new ILExpressionAdaptor();
		
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
					operatorKind = OperatorKind.ADDITION;
					break;
				case SUBTRACTION:
					operatorKind = OperatorKind.SUBTRACTION;
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
			DataType dataType = doSwitch(unaryExpression).evaluate(OperatorKind.UNARY_MINUS, null);
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
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public DataType caseRealLiteral(RealLiteral realLiteral) {
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
			ILUtil.setDataType(realLiteral, realType);
			return realType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public DataType caseIntegerLiteral(IntegerLiteral integerLiteral) {
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
				DataType dataType = variableReference.getTarget().getType();
				if (dataType == null) {
					throw new RuntimeException("Data type not set");
				}
				ILUtil.setDataType(variableReference, dataType);
				return dataType;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseMethodCall(org.eclipselabs.mscript.language.il.MethodCall)
			 */
			@Override
			public DataType caseMethodCall(MethodCall methodCall) {
				DataType targetDataType = ExpressionAdaptor.this.doSwitch(methodCall.getTarget());
				DataType dataType = getBuiltinFeatureDataType(methodCall.getName(), targetDataType, Collections.<DataType>emptyList());
				ILUtil.setDataType(methodCall, dataType);
				return dataType;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#casePropertyReference(org.eclipselabs.mscript.language.il.PropertyReference)
			 */
			@Override
			public DataType casePropertyReference(PropertyReference propertyReference) {
				DataType targetDataType = ExpressionAdaptor.this.doSwitch(propertyReference.getTarget());
				DataType dataType = getBuiltinFeatureDataType(propertyReference.getName(), targetDataType, null);
				ILUtil.setDataType(propertyReference, dataType);
				return dataType;
			}
			
			private DataType getBuiltinFeatureDataType(String name, DataType targetDataType, List<DataType> inputParameterDataTypes) {
				BuiltinFeatureDescriptor descriptor = BuiltinFeatureDescriptor.get(name, targetDataType, inputParameterDataTypes);
				if (descriptor == null) {
					return TypeSystemFactory.eINSTANCE.createInvalidDataType();
				}
				return descriptor.getSignature().evaluateOutputParameterDataTypes(targetDataType, inputParameterDataTypes).get(0);
			}
			
		}

	}
			
}
