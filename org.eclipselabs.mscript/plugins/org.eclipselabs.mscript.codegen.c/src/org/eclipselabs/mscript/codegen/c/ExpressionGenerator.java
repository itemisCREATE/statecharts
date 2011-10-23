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

package org.eclipselabs.mscript.codegen.c;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration;
import org.eclipselabs.damos.mscript.il.VariableReference;
import org.eclipselabs.damos.mscript.il.builtin.BuiltinFunctionDescriptor;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.mscript.codegen.c.internal.VariableAccessGenerator;
import org.eclipselabs.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.mscript.codegen.c.internal.util.CastToFloatingPointHelper;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.common.util.PrintAppendable;

public class ExpressionGenerator implements IExpressionGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IExpressionGenerator#generate(org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext, org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public void generate(IMscriptGeneratorContext context, Expression expression) {
		new ExpressionGeneratorSwitch(context).doSwitch(expression);
	}
	
	private static class ExpressionGeneratorSwitch extends MscriptSwitch<Boolean> {

		private IMscriptGeneratorContext context;
		private IBuiltinFunctionGeneratorLookupTable builtinFunctionGeneratorLookupTable = new BuiltinFunctionGeneratorLookupTable();
		
		private PrintAppendable out;

		public ExpressionGeneratorSwitch(IMscriptGeneratorContext context) {
			this.context = context;
			out = new PrintAppendable(context.getAppendable());
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public Boolean caseImpliesExpression(ImpliesExpression impliesExpression) {
			out.print("(!(");
			doSwitch(impliesExpression.getLeftOperand());
			out.print(") || ");
			doSwitch(impliesExpression.getRightOperand());
			out.print(")");
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public Boolean caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			doSwitch(logicalOrExpression.getLeftOperand());
			out.print(" || ");
			doSwitch(logicalOrExpression.getRightOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public Boolean caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			doSwitch(logicalAndExpression.getLeftOperand());
			out.print(" && ");
			doSwitch(logicalAndExpression.getRightOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public Boolean caseEqualityExpression(EqualityExpression equalityExpression) {
			writeCompareExpression(equalityExpression.getLeftOperand(), equalityExpression.getRightOperand(), equalityExpression.getOperator().getLiteral());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public Boolean caseRelationalExpression(RelationalExpression relationalExpression) {
			writeCompareExpression(relationalExpression.getLeftOperand(), relationalExpression.getRightOperand(), relationalExpression.getOperator().getLiteral());
			return true;
		}
		
		private void writeCompareExpression(Expression leftOperand, Expression rightOperand, String operator) {
			DataType leftDataType = getDataType(leftOperand);
			DataType rightDataType = getDataType(rightOperand);
			
			if (leftDataType instanceof NumericType && rightDataType instanceof NumericType) {
				DataType dataType1 = TypeUtil.getLeftHandDataType(leftDataType, rightDataType);
				DataType dataType2 = TypeUtil.getLeftHandDataType(rightDataType, leftDataType);
				
				NumberFormat numberFormat1 = context.getComputationModel().getNumberFormat(dataType1);
				NumberFormat numberFormat2 = context.getComputationModel().getNumberFormat(dataType2);
				
				NumberFormat widestNumberFormat = ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);
	
				MscriptGeneratorUtil.castNumericType(context, widestNumberFormat, leftOperand);
				out.print(" ");
				out.print(operator);
				out.print(" ");
				MscriptGeneratorUtil.castNumericType(context, widestNumberFormat, rightOperand);
			} else {
				doSwitch(leftOperand);
				out.print(" ");
				out.print(operator);
				out.print(" ");
				doSwitch(rightOperand);
			}
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public Boolean caseAdditiveExpression(AdditiveExpression additiveExpression) {
			DataType dataType = getDataType(additiveExpression);
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
	
			MscriptGeneratorUtil.castNumericType(context, numberFormat, additiveExpression.getLeftOperand());
			out.print(" ");
			out.print(additiveExpression.getOperator().getLiteral());
			out.print(" ");
			MscriptGeneratorUtil.castNumericType(context, numberFormat, additiveExpression.getRightOperand());
			
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public Boolean caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(getDataType(multiplicativeExpression));
			if (numberFormat instanceof FloatingPointFormat) {
				writeFloatingPointMultiplicativeExpression(multiplicativeExpression.getOperator(), multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand(), (FloatingPointFormat) numberFormat);
			} else if (numberFormat instanceof FixedPointFormat) {
				writeFixedPointMultiplicativeExpression(multiplicativeExpression.getOperator(), multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand(), (FixedPointFormat) numberFormat);
			} else {
				throw new IllegalArgumentException();
			}
			
			return true;
		}
		
		private void writeFloatingPointMultiplicativeExpression(MultiplicativeOperator operator, Expression leftOperand, Expression rightOperand, FloatingPointFormat floatingPointFormat) {
			castToFloatingPoint(leftOperand, floatingPointFormat);
			out.print(" ");
			out.print(operator.getLiteral());
			out.print(" ");
			castToFloatingPoint(rightOperand, floatingPointFormat);
		}
		
		private void writeFixedPointMultiplicativeExpression(MultiplicativeOperator operator, Expression leftOperand, Expression rightOperand, FixedPointFormat fixedPointFormat) {
			switch (operator) {
			case MULTIPLY:
				writeFixedPointMultiplicationExpression(leftOperand, rightOperand, fixedPointFormat);
				break;
			case DIVIDE:
				writeFixedPointDivisionExpression(leftOperand, rightOperand, fixedPointFormat);
				break;
			default:
				throw new IllegalArgumentException();
			}
		}
		
		private void writeFixedPointMultiplicationExpression(Expression leftOperand, Expression rightOperand, FixedPointFormat fixedPointFormat) {
			FixedPointOperation operation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat, FixedPointOperationKind.MULTIPLY);
			
			boolean hasIntermediateWordSize = operation.getIntermediateWordSize() != fixedPointFormat.getWordSize();
		
			if (hasIntermediateWordSize) {
				out.printf("(int%d_t) ", fixedPointFormat.getWordSize());
			}
			
			if (hasIntermediateWordSize || fixedPointFormat.getFractionLength() > 0) {
				out.print("(");
			}
			
			castToFixedPoint(leftOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength());
			
			out.print(" * ");
			
			if (fixedPointFormat.getFractionLength() > 0) {
				out.print("(");
			}
	
			castToFixedPoint(rightOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength());
			
			if (fixedPointFormat.getFractionLength() > 0) {
				out.printf(") >> %d", fixedPointFormat.getFractionLength());
			}
	
			if (hasIntermediateWordSize || fixedPointFormat.getFractionLength() > 0) {
				out.print(")");
			}
		}
	
		private void writeFixedPointDivisionExpression(Expression leftOperand, Expression rightOperand, FixedPointFormat fixedPointFormat) {
			FixedPointOperation operation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat, FixedPointOperationKind.DIVIDE);
			
			boolean hasIntermediateWordSize = operation.getIntermediateWordSize() != fixedPointFormat.getWordSize();
		
			if (hasIntermediateWordSize) {
				out.printf("(int%d_t) (", fixedPointFormat.getWordSize());
			}
			
			if (fixedPointFormat.getFractionLength() > 0) {
				out.print("((");
			}
	
			castToFixedPoint(leftOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength());
			
			if (fixedPointFormat.getFractionLength() > 0) {
				out.printf(") << %d)", fixedPointFormat.getFractionLength());
			}
	
			out.print(" / ");
			
			castToFixedPoint(rightOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength());
			
			if (hasIntermediateWordSize) {
				out.print(")");
			}
		}
		
		private void castToFloatingPoint(final Expression expression, FloatingPointFormat floatingPointFormat) {
			new CastToFloatingPointHelper(context.getComputationModel(), context.getAppendable(), getDataType(expression), floatingPointFormat) {
				
				@Override
				protected void writeExpression() {
					ExpressionGeneratorSwitch.this.doSwitch(expression);
				}
				
			}.cast();
		}
	
		private void castToFixedPoint(final Expression expression, int wordSize, int fractionLength) {
			new CastToFixedPointHelper(context.getComputationModel(), context.getAppendable(), getDataType(expression), wordSize, fractionLength) {
				
				@Override
				protected void writeExpression() {
					ExpressionGeneratorSwitch.this.doSwitch(expression);
				}
				
			}.cast();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public Boolean caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			out.print("(");
			doSwitch(parenthesizedExpression.getExpressions().get(0));
			out.print(")");
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Boolean caseUnaryExpression(UnaryExpression unaryExpression) {
			out.print(unaryExpression.getOperator().getLiteral());
			doSwitch(unaryExpression.getOperand());
			return true;
		}
		
		private MscriptSwitch<Boolean> typeSystemSwitch = new MscriptSwitch<Boolean>() {
		
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
			 */
			@Override
			public Boolean caseRealLiteral(RealLiteral realLiteral) {
				DataType dataType = getDataType(realLiteral);
				out.print(MscriptGeneratorUtil.getLiteralString(context.getComputationModel(), dataType, realLiteral.getValue()));
				return true;
			}
		
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
			 */
			@Override
			public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
				DataType dataType = getDataType(integerLiteral);
				out.print(MscriptGeneratorUtil.getLiteralString(context.getComputationModel(), dataType, integerLiteral.getValue()));
				return true;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
			 */
			@Override
			public Boolean caseBooleanLiteral(BooleanLiteral booleanLiteral) {
				out.print(booleanLiteral.isTrue() ? "1" : "0");
				return true;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
			 */
			@Override
			public Boolean caseStringLiteral(StringLiteral stringLiteral) {
				out.print("\"" + stringLiteral.getValue() + "\"");
				return true;
			}
		
		};
				
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public Boolean caseFunctionCall(FunctionCall functionCall) {
			String name = functionCall.getFeature().getName();

			List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
			for (Expression argument : functionCall.getArguments()) {
				inputParameterDataTypes.add(getDataType(argument));
			}
			BuiltinFunctionDescriptor descriptor = BuiltinFunctionDescriptor.get(name, inputParameterDataTypes);
			if (descriptor != null) {
				IFunctionGenerator generator = builtinFunctionGeneratorLookupTable.getFunctionGenerator(descriptor);
				if (generator != null) {
					generator.generate(context, functionCall.getArguments());
				}
			}

			return true;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseExpression(org.eclipselabs.mscript.language.ast.Expression)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			Boolean result = typeSystemSwitch.doSwitch(object);
			if (result != null) {
				return result;
			}
			if (object instanceof Expression) {
				return new ILExpressionGenerator().doSwitch(object);
			}
			return super.defaultCase(object);
		}
		
		private DataType getDataType(Expression expression) {
			return context.getStaticEvaluationContext().getValue(expression).getDataType();
		}
	
		private class ILExpressionGenerator extends ILSwitch<Boolean> {
			
			public Boolean caseVariableReference(VariableReference variableReference) {
				// TODO: redesign is needed here
				String variableAccessString = new VariableAccessGenerator(context, variableReference).generate();
				out.print(variableAccessString);
				if (!(variableReference.getTarget() instanceof TemplateVariableDeclaration)) {
					for (Expression expression : variableReference.getArrayIndices()) {
						out.print("[");
						ExpressionGeneratorSwitch.this.doSwitch(expression);
						out.print("]");
					}
				}
				return true;
			}
			
		}

	}
	
}