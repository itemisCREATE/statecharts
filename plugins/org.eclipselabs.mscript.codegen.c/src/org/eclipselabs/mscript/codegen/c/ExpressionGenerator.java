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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.codegen.c.util.CastToFixedPointHelper;
import org.eclipselabs.mscript.codegen.c.util.CastToFloatingPointHelper;
import org.eclipselabs.mscript.codegen.c.util.GeneratorUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.BooleanKind;
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
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.MethodCall;
import org.eclipselabs.mscript.language.il.PropertyReference;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class ExpressionGenerator extends AstSwitch<Boolean> {
	
	private IGeneratorContext context;
	
	private PrintWriter writer;

	/**
	 * @param compoundGenerator
	 */
	public ExpressionGenerator(IGeneratorContext context) {
		this.context = context;
		writer = new PrintWriter(context.getWriter());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
	 */
	@Override
	public Boolean caseImpliesExpression(ImpliesExpression impliesExpression) {
		writer.print("(!(");
		doSwitch(impliesExpression.getLeftOperand());
		writer.print(") || ");
		doSwitch(impliesExpression.getRightOperand());
		writer.print(")");
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
	 */
	@Override
	public Boolean caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
		boolean first = true;
		for (Expression operand : logicalOrExpression.getOperands()) {
			if (first) {
				first = false;
			} else {
				writer.print(" || ");
			}
			doSwitch(operand);
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
	 */
	@Override
	public Boolean caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
		boolean first = true;
		for (Expression operand : logicalAndExpression.getOperands()) {
			if (first) {
				first = false;
			} else {
				writer.print(" && ");
			}
			doSwitch(operand);
		}
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
		DataType leftDataType = ILUtil.getDataType(leftOperand);
		DataType rightDataType = ILUtil.getDataType(rightOperand);
		
		if (leftDataType instanceof NumericType && rightDataType instanceof NumericType) {
			DataType dataType1 = TypeSystemUtil.getLeftHandDataType(leftDataType, rightDataType);
			DataType dataType2 = TypeSystemUtil.getLeftHandDataType(rightDataType, leftDataType);
			
			NumberFormat numberFormat1 = context.getComputationModel().getNumberFormat(dataType1);
			NumberFormat numberFormat2 = context.getComputationModel().getNumberFormat(dataType2);
			
			NumberFormat widestNumberFormat = ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);

			GeneratorUtil.castNumericType(context, widestNumberFormat, leftOperand);
			writer.print(" ");
			writer.print(operator);
			writer.print(" ");
			GeneratorUtil.castNumericType(context, widestNumberFormat, rightOperand);
		} else {
			doSwitch(leftOperand);
			writer.print(" ");
			writer.print(operator);
			writer.print(" ");
			doSwitch(rightOperand);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public Boolean caseAdditiveExpression(AdditiveExpression additiveExpression) {
		DataType dataType = ILUtil.getDataType(additiveExpression);
		
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);

		GeneratorUtil.castNumericType(context, numberFormat, additiveExpression.getLeftOperand());
		for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
			writer.print(" ");
			writer.print(rightPart.getOperator().getLiteral());
			writer.print(" ");
			GeneratorUtil.castNumericType(context, numberFormat, rightPart.getOperand());
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public Boolean caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		List<MultiplicativeExpressionPart> rightParts = multiplicativeExpression.getRightParts();

		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(ILUtil.getDataType(multiplicativeExpression));
		if (numberFormat instanceof FloatingPointFormat) {
			writeFloatingPointMultiplicativeExpression(multiplicativeExpression.getLeftOperand(), rightParts.listIterator(rightParts.size()), (FloatingPointFormat) numberFormat);
		} else if (numberFormat instanceof FixedPointFormat) {
			writeFixedPointMultiplicativeExpression(multiplicativeExpression.getLeftOperand(), rightParts.listIterator(rightParts.size()), (FixedPointFormat) numberFormat);
		} else {
			throw new IllegalArgumentException();
		}
		
		return true;
	}
	
	private void writeFloatingPointMultiplicativeExpression(Expression leftOperand, ListIterator<MultiplicativeExpressionPart> rightParts, FloatingPointFormat floatingPointFormat) {
		MultiplicativeExpressionPart part = rightParts.previous();
		if (rightParts.hasPrevious()) {
			writeFloatingPointMultiplicativeExpression(leftOperand, rightParts, floatingPointFormat);
		} else {
			new CastToFloatingPointHelper(context, leftOperand, floatingPointFormat).cast();
		}
		writer.print(" ");
		writer.print(part.getOperator().getLiteral());
		writer.print(" ");
		new CastToFloatingPointHelper(context, part.getOperand(), floatingPointFormat).cast();
	}
	
	private void writeFixedPointMultiplicativeExpression(Expression leftOperand, ListIterator<MultiplicativeExpressionPart> rightParts, FixedPointFormat fixedPointFormat) {
		MultiplicativeExpressionPart part = rightParts.previous();
		rightParts.next();
		switch (part.getOperator()) {
		case MULTIPLICATION:
			writeFixedPointMultiplicationExpression(leftOperand, rightParts, fixedPointFormat);
			break;
		case DIVISION:
			writeFixedPointDivisionExpression(leftOperand, rightParts, fixedPointFormat);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void writeFixedPointMultiplicationExpression(Expression leftOperand, ListIterator<MultiplicativeExpressionPart> rightParts, FixedPointFormat fixedPointFormat) {
		MultiplicativeExpressionPart part = rightParts.previous();
		FixedPointOperation operation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat, FixedPointOperationKind.MULTIPLY);
		
		boolean hasIntermediateWordSize = operation.getIntermediateWordSize() != fixedPointFormat.getWordSize();
	
		if (hasIntermediateWordSize) {
			writer.printf("(int%d_t) ", fixedPointFormat.getWordSize());
		}
		
		if (hasIntermediateWordSize || fixedPointFormat.getFractionLength() > 0) {
			writer.print("(");
		}
		
		boolean castExplicitly = rightParts.hasPrevious() && hasIntermediateWordSize;
		
		if (castExplicitly) {
			writer.printf("(int%d_t) (", operation.getIntermediateWordSize());
		}

		if (rightParts.hasPrevious()) {
			writeFixedPointMultiplicativeExpression(leftOperand, rightParts, fixedPointFormat);
		} else {
			new CastToFixedPointHelper(context, leftOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
		}
		
		if (castExplicitly) {
			writer.print(")");
		}
		
		writer.print(" * ");
		
		if (fixedPointFormat.getFractionLength() > 0) {
			writer.print("(");
		}

		new CastToFixedPointHelper(context, part.getOperand(), operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
		
		if (fixedPointFormat.getFractionLength() > 0) {
			writer.printf(") >> %d", fixedPointFormat.getFractionLength());
		}

		if (hasIntermediateWordSize || fixedPointFormat.getFractionLength() > 0) {
			writer.print(")");
		}
	}

	private void writeFixedPointDivisionExpression(Expression leftOperand, ListIterator<MultiplicativeExpressionPart> rightParts, FixedPointFormat fixedPointFormat) {
		MultiplicativeExpressionPart part = rightParts.previous();
		FixedPointOperation operation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat, FixedPointOperationKind.DIVIDE);
		
		boolean hasIntermediateWordSize = operation.getIntermediateWordSize() != fixedPointFormat.getWordSize();
	
		if (hasIntermediateWordSize) {
			writer.printf("(int%d_t) (", fixedPointFormat.getWordSize());
		}
		
		if (fixedPointFormat.getFractionLength() > 0) {
			writer.print("(");
		}

		boolean castExplicitly = rightParts.hasPrevious() && hasIntermediateWordSize;
		
		if (castExplicitly) {
			writer.printf("(int%d_t) ", operation.getIntermediateWordSize());
		}
		
		if (castExplicitly || fixedPointFormat.getFractionLength() > 0) {
			writer.print("(");
		}

		if (rightParts.hasPrevious()) {
			writeFixedPointMultiplicativeExpression(leftOperand, rightParts, fixedPointFormat);
		} else {
			new CastToFixedPointHelper(context, leftOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
		}
		
		if (castExplicitly || fixedPointFormat.getFractionLength() > 0) {
			writer.print(")");
		}
		
		if (fixedPointFormat.getFractionLength() > 0) {
			writer.printf(" << %d)", fixedPointFormat.getFractionLength());
		}

		writer.print(" / ");
		
		new CastToFixedPointHelper(context, part.getOperand(), operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
		
		if (hasIntermediateWordSize) {
			writer.print(")");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public Boolean caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		writer.print("(");
		doSwitch(parenthesizedExpression.getExpressions().get(0));
		writer.print(")");
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public Boolean caseUnaryExpression(UnaryExpression unaryExpression) {
		writer.print(unaryExpression.getOperator().getLiteral() + doSwitch(unaryExpression.getOperand()));
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public Boolean caseRealLiteral(RealLiteral realLiteral) {
		DataType dataType = ILUtil.getDataType(realLiteral);
		GeneratorUtil.writeLiteral(context, dataType, realLiteral.getValue());
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
		DataType dataType = ILUtil.getDataType(integerLiteral);
		GeneratorUtil.writeLiteral(context, dataType, integerLiteral.getValue());
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public Boolean caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		writer.print(booleanLiteral.getValue() == BooleanKind.TRUE ? "1" : "0");
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public Boolean caseStringLiteral(StringLiteral stringLiteral) {
		writer.print("\"" + stringLiteral.getValue() + "\"");
		return true;
	}
			
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseExpression(org.eclipselabs.mscript.language.ast.Expression)
	 */
	@Override
	public Boolean defaultCase(EObject object) {
		if (object instanceof Expression) {
			return new ILExpressionGenerator().doSwitch(object);
		}
		return super.defaultCase(object);
	}

	private class ILExpressionGenerator extends ILSwitch<Boolean> {
		
		private BuiltinFunctionGeneratorLookupTable builtinFunctionGeneratorLookupTable = new BuiltinFunctionGeneratorLookupTable();
		
		public Boolean caseVariableReference(VariableReference variableReference) {
			new VariableAccessGenerator(context, variableReference).generate();
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#casePropertyReference(org.eclipselabs.mscript.language.il.PropertyReference)
		 */
		@Override
		public Boolean casePropertyReference(PropertyReference propertyReference) {
			// TODO Auto-generated method stub
			return super.casePropertyReference(propertyReference);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseMethodCall(org.eclipselabs.mscript.language.il.MethodCall)
		 */
		@Override
		public Boolean caseMethodCall(MethodCall methodCall) {
			List<Expression> arguments = methodCall.getArguments();
			List<Expression> expressions = new ArrayList<Expression>(arguments.size() + 1);
			expressions.add(methodCall.getTarget());
			expressions.addAll(arguments);
			IFunctionGenerator generator = builtinFunctionGeneratorLookupTable.getFunctionGenerator(methodCall.getName());
			if (generator != null) {
				generator.generate(context, expressions);
			}
			return true;
		}

	}

}