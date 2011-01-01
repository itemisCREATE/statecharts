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

package org.eclipselabs.mscript.codegen.c;

import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.codegen.c.util.GeneratorUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
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
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class CompoundGenerator extends ILSwitch<Boolean> {

	private IGeneratorContext context;

	private PrintWriter writer;
	
	/**
	 * 
	 */
	public CompoundGenerator(IGeneratorContext context) {
		this.context = context;
		this.writer = new PrintWriter(context.getWriter());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.imperativemodel.Compound)
	 */
	@Override
	public Boolean caseCompound(Compound compound) {
		boolean block = compound instanceof Statement;
		if (block) {
			writer.print("{\n");
		}
		for (LocalVariableDeclaration localVariableDeclaration : compound.getLocalVariableDeclarations()) {
			writer.print(GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(localVariableDeclaration.getType())));
			writer.print(" ");
			writer.print(localVariableDeclaration.getName());
			writer.print(";\n");
		}
		for (Statement statement : compound.getStatements()) {
			doSwitch(statement);
		}
		if (block) {
			writer.print("}\n");
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration)
	 */
	@Override
	public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		if (localVariableDeclaration.getInitializer() != null) {
			writer.print(localVariableDeclaration.getName());
			if (localVariableDeclaration.getInitializer() != null) {
				writer.print(" = ");
				doSwitch(localVariableDeclaration.getInitializer());
			}
			writer.print(";\n");
			return true;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseAssignment(org.eclipselabs.mscript.language.imperativemodel.Assignment)
	 */
	@Override
	public Boolean caseAssignment(Assignment assignment) {
		new VariableAccessGenerator(assignment).generate();
		writer.print(" = ");
		cast(assignment.getAssignedExpression(), context.getComputationModel().getNumberFormat(assignment.getTarget().getType()));
		writer.print(";\n");
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseIfStatement(org.eclipselabs.mscript.language.imperativemodel.IfStatement)
	 */
	@Override
	public Boolean caseIfStatement(IfStatement ifStatement) {
		writer.print("if (");
		doSwitch(ifStatement.getCondition());
		writer.print(")\n");
		doSwitch(ifStatement.getThenStatement());
		writer.print("else\n");
		doSwitch(ifStatement.getElseStatement());
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseForeachStatement(org.eclipselabs.mscript.language.imperativemodel.ForeachStatement)
	 */
	@Override
	public Boolean caseForeachStatement(ForeachStatement foreachStatement) {
		VariableDeclaration iterationVariableDeclaration = foreachStatement.getIterationVariableDeclaration();
		DataType collectionDataType = ILUtil.getDataType(foreachStatement.getCollectionExpression());
		if (!(collectionDataType instanceof ArrayType)) {
			throw new RuntimeException("Collection type must be array type");
		}
		ArrayType collectionArrayType = (ArrayType) collectionDataType;
		if (collectionArrayType.getDimensionality() != 1) {
			throw new RuntimeException("Array dimensionality must be 1");
		}
		
		String itVarName = iterationVariableDeclaration.getName();
		String itVarType = GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(iterationVariableDeclaration.getType()));
		int size = collectionArrayType.getDimensions().get(0).getSize();
		
		writer.println("{");
		writer.printf("int %s_i;\n", itVarName);
		writer.printf("for (%s_i = 0; %s_i < %d; ++%s_i) {\n", itVarName, itVarName, size, itVarName);
		writer.printf("%s %s = (", itVarType, itVarName);
		doSwitch(foreachStatement.getCollectionExpression());
		writer.printf(")[%s_i];\n", itVarName);
		doSwitch(foreachStatement.getBody());
		writer.println("}");
		writer.println("}");
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Boolean defaultCase(EObject object) {
		if (object instanceof Expression) {
			new ExpressionGenerator().doSwitch(object);
			return true;
		}
		return super.defaultCase(object);
	}
	
	private void cast(Expression expression, NumberFormat numberFormat) {
		if (numberFormat instanceof FloatingPointFormat) {
			new CastToFloatingPointHelper(expression, (FloatingPointFormat) numberFormat).cast();
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			new CastToFixedPointHelper(expression, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()).cast();
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private class CastToFloatingPointHelper extends ComputationModelSwitch<Boolean> {
		
		private Expression expression;
		private FloatingPointFormat targetFloatingPointFormat;
		
		/**
		 * 
		 */
		public CastToFloatingPointHelper(Expression expression, FloatingPointFormat targetFloatingPointFormat) {
			this.expression = expression;
			this.targetFloatingPointFormat = targetFloatingPointFormat;
		}
		
		public void cast() {
			DataType dataType = ILUtil.getDataType(expression);
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
			doSwitch(numberFormat);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFloatingPointFormat(org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat)
		 */
		@Override
		public Boolean caseFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
			if (floatingPointFormat.getKind() == targetFloatingPointFormat.getKind()) {
				new ExpressionGenerator().doSwitch(expression);
			} else {
				writer.printf("((%s) (", getCDataType());
				new ExpressionGenerator().doSwitch(expression);
				writer.print("))");
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFixedPointFormat(org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat)
		 */
		@Override
		public Boolean caseFixedPointFormat(FixedPointFormat fixedPointFormat) {
			if (fixedPointFormat.getFractionLength() > 0) {
				writer.printf("((%s) ((", getCDataType());
				new ExpressionGenerator().doSwitch(expression);
				writer.printf(") * pow(2, -%d)))", fixedPointFormat.getFractionLength());
			} else {
				writer.printf("((%s) (", getCDataType());
				new ExpressionGenerator().doSwitch(expression);
				writer.print("))");
			}
			return true;
		}
		
		private String getCDataType() {
			switch (targetFloatingPointFormat.getKind()) {
			case BINARY32:
				return "float";
			case BINARY64:
				return "double";
			default:
				throw new IllegalArgumentException();
			}
		}
		
	}
		
	private class CastToFixedPointHelper extends ComputationModelSwitch<Boolean> {
		
		private Expression expression;
		private int wordSize;
		private int fractionLength;
		
		/**
		 * 
		 */
		public CastToFixedPointHelper(Expression expression, int wordSize, int fractionLength) {
			this.expression = expression;
			this.wordSize = wordSize;
			this.fractionLength = fractionLength;
		}
		
		public void cast() {
			DataType dataType = ILUtil.getDataType(expression);
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
			doSwitch(numberFormat);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFloatingPointFormat(org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat)
		 */
		@Override
		public Boolean caseFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
			if (fractionLength > 0) {
				writer.printf("((%s) floor((", getCDataType());
				new ExpressionGenerator().doSwitch(expression);
				writer.printf(") * pow(2, %d) + 0.5))", fractionLength);
			} else {
				writer.printf("((%s) (", getCDataType());
				new ExpressionGenerator().doSwitch(expression);
				writer.print("))");
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFixedPointFormat(org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat)
		 */
		@Override
		public Boolean caseFixedPointFormat(FixedPointFormat fixedPointFormat) {
			if (wordSize != fixedPointFormat.getWordSize()) {
				writer.printf("((%s) (", getCDataType());
			}
			if (fractionLength != fixedPointFormat.getFractionLength()) {
				if (wordSize == fixedPointFormat.getWordSize()) {
					writer.print("((");
				}
				new ExpressionGenerator().doSwitch(expression);
				if (fractionLength > fixedPointFormat.getFractionLength()) {
					writer.printf(") << %d)", fractionLength - fixedPointFormat.getFractionLength());
				} else {
					writer.printf(") >> %d)", fixedPointFormat.getFractionLength() - fractionLength);
				}
			} else {
				new ExpressionGenerator().doSwitch(expression);
				if (wordSize != fixedPointFormat.getWordSize()) {
					writer.print("))");
				}
			}
			return true;
		}
		
		private String getCDataType() {
			return String.format("int%d_t", wordSize);
		}
		
	}
	
	private void writeLiteral(DataType dataType, double value) {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
		writer.printf("(%s) ", GeneratorUtil.getCDataType(numberFormat));
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			writer.print(Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		} else {
			writer.print(value);
		}
	}

	private void writeLiteral(DataType dataType, long value) {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
		writer.printf("(%s) ", GeneratorUtil.getCDataType(numberFormat));
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
		}
		writer.print(value);
	}
	
	private class ExpressionGenerator extends AstSwitch<Boolean> {
		
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
			
			DataType dataType1 = TypeSystemUtil.getLeftHandDataType(leftDataType, rightDataType);
			DataType dataType2 = TypeSystemUtil.getLeftHandDataType(rightDataType, leftDataType);
			
			NumberFormat numberFormat1 = context.getComputationModel().getNumberFormat(dataType1);
			NumberFormat numberFormat2 = context.getComputationModel().getNumberFormat(dataType2);
			
			NumberFormat widestNumberFormat = ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);

			cast(leftOperand, widestNumberFormat);
			writer.print(" ");
			writer.print(operator);
			writer.print(" ");
			cast(rightOperand, widestNumberFormat);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public Boolean caseAdditiveExpression(AdditiveExpression additiveExpression) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(ILUtil.getDataType(additiveExpression));
			
			cast(additiveExpression.getLeftOperand(), numberFormat);
			for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
				writer.print(" ");
				writer.print(rightPart.getOperator().getLiteral());
				writer.print(" ");
				cast(rightPart.getOperand(), numberFormat);
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
				new CastToFloatingPointHelper(leftOperand, floatingPointFormat).cast();
			}
			writer.print(" ");
			writer.print(part.getOperator().getLiteral());
			writer.print(" ");
			new CastToFloatingPointHelper(part.getOperand(), floatingPointFormat).cast();
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
				new CastToFixedPointHelper(leftOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
			}
			
			if (castExplicitly) {
				writer.print(")");
			}
			
			writer.print(" * ");
			
			if (fixedPointFormat.getFractionLength() > 0) {
				writer.print("(");
			}

			new CastToFixedPointHelper(part.getOperand(), operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
			
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
				new CastToFixedPointHelper(leftOperand, operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
			}
			
			if (castExplicitly || fixedPointFormat.getFractionLength() > 0) {
				writer.print(")");
			}
			
			if (fixedPointFormat.getFractionLength() > 0) {
				writer.printf(" << %d)", fixedPointFormat.getFractionLength());
			}

			writer.print(" / ");
			
			new CastToFixedPointHelper(part.getOperand(), operation.getIntermediateWordSize(), fixedPointFormat.getFractionLength()).cast();
			
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
			writeLiteral(dataType, realLiteral.getValue());
			return true;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
			DataType dataType = ILUtil.getDataType(integerLiteral);
			writeLiteral(dataType, integerLiteral.getValue());
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
		
		public Boolean caseVariableReference(VariableReference variableReference) {
			new VariableAccessGenerator(variableReference).generate();
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseExpression(org.eclipselabs.mscript.language.ast.Expression)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			if (object instanceof VariableReference) {
				return caseVariableReference((VariableReference) object);
			}
			return super.defaultCase(object);
		}

	}
	
	private class VariableAccessGenerator extends ILSwitch<Boolean> {

		private VariableAccess variableAccess;
		
		/**
		 * 
		 */
		public VariableAccessGenerator(VariableAccess variableAccess) {
			this.variableAccess = variableAccess;
		}
		
		public void generate() {
			doSwitch(variableAccess.getTarget());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseTemplateVariableDeclaration(org.eclipselabs.mscript.language.il.TemplateVariableDeclaration)
		 */
		@Override
		public Boolean caseTemplateVariableDeclaration(TemplateVariableDeclaration templateVariableDeclaration) {
			IValue templateArgument = templateVariableDeclaration.getValue();
			if (templateArgument instanceof ISimpleNumericValue) {
				ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) templateArgument;
				if (templateArgument.getDataType() instanceof RealType) {
					writeLiteral(numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue());
				} else if (templateArgument.getDataType() instanceof IntegerType) {
					writeLiteral(numericTemplateArgument.getDataType(), numericTemplateArgument.longValue());
				}
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInputVariableDeclaration(org.eclipselabs.mscript.language.il.InputVariableDeclaration)
		 */
		@Override
		public Boolean caseInputVariableDeclaration(InputVariableDeclaration inputVariableDeclaration) {
			if (variableAccess.getStepIndex() == 0) {
				writer.print(inputVariableDeclaration.getName());
			} else {
				writeContextAccess();
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseOutputVariableDeclaration(org.eclipselabs.mscript.language.il.OutputVariableDeclaration)
		 */
		@Override
		public Boolean caseOutputVariableDeclaration(OutputVariableDeclaration outputVariableDeclaration) {
			if (variableAccess.getStepIndex() == 0) {
				writer.printf("*%s", outputVariableDeclaration.getName());
			} else {
				writeContextAccess();
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInstanceVariableDeclaration(org.eclipselabs.mscript.language.il.InstanceVariableDeclaration)
		 */
		@Override
		public Boolean caseInstanceVariableDeclaration(InstanceVariableDeclaration instanceVariableDeclaration) {
			writeContextAccess();
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
		 */
		@Override
		public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
			writer.print(localVariableDeclaration.getName());
			return true;
		}
		
		private void writeContextAccess() {
			String name = variableAccess.getTarget().getName();
			int circularBufferSize = ((StatefulVariableDeclaration) variableAccess.getTarget()).getCircularBufferSize();
			if (circularBufferSize > 1) {
				int stepIndex = variableAccess.getStepIndex();
				if (stepIndex == 0) {
					writer.printf("context->%s[context->%s_index]", name, name, stepIndex,
							circularBufferSize);
				} else if (stepIndex < 0) {
					writer.printf("context->%s[(context->%s_index - %d) %% %d]", name, name, -stepIndex,
							circularBufferSize);
				} else {
					writer.printf("context->%s[(context->%s_index + %d) %% %d]", name, name, stepIndex,
							circularBufferSize);
				}
			} else {
				writer.printf("context->%s", name);
			}
		}
		
	}

}
