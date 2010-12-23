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

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.codegen.c.util.GeneratorUtil;
import org.eclipselabs.mscript.computation.core.value.IIntegerValue;
import org.eclipselabs.mscript.computation.core.value.IRealValue;
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
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
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
			writer.print(GeneratorUtil.toString(localVariableDeclaration.getType()));
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
		doSwitch(assignment.getAssignedExpression());
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
		writer.print("{\n");
		writer.print("int i;\n");
		writer.print("for (i = 0; i < ");
		writer.print(collectionArrayType.getDimensions().get(0).getSize());
		writer.print("; ++i) {\n");
		writer.print(GeneratorUtil.toString(iterationVariableDeclaration.getType()));
		writer.print(" ");
		writer.print(iterationVariableDeclaration.getName());
		writer.print(" = (");
		doSwitch(foreachStatement.getCollectionExpression());
		writer.print(")[i];\n");
		doSwitch(foreachStatement.getBody());
		writer.print("}\n");
		writer.print("}\n");
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
			doSwitch(equalityExpression.getLeftOperand());
			writer.print(" ");
			writer.print(equalityExpression.getOperator().getLiteral());
			writer.print(" ");
			doSwitch(equalityExpression.getRightOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public Boolean caseRelationalExpression(RelationalExpression relationalExpression) {
			doSwitch(relationalExpression.getLeftOperand());
			writer.print(" ");
			writer.print(relationalExpression.getOperator().getLiteral());
			writer.print(" ");
			doSwitch(relationalExpression.getRightOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public Boolean caseAdditiveExpression(AdditiveExpression additiveExpression) {
			doSwitch(additiveExpression.getLeftOperand());
			for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
				writer.print(" ");
				writer.print(rightPart.getOperator().getLiteral());
				writer.print(" ");
				doSwitch(rightPart.getOperand());
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public Boolean caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			doSwitch(multiplicativeExpression.getLeftOperand());
			for (MultiplicativeExpressionPart rightPart : multiplicativeExpression.getRightParts()) {
				writer.print(" ");
				writer.print(rightPart.getOperator().getLiteral());
				if (rightPart.getOperator() == MultiplicativeOperator.DIVISION) {
					writer.print(" (double) (");
				} else {
					writer.print(" ");
				}
				doSwitch(rightPart.getOperand());
				if (rightPart.getOperator() == MultiplicativeOperator.DIVISION) {
					writer.print(")");
				}
			}
			return true;
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
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
			writer.print(Long.toString(integerLiteral.getValue()));
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public Boolean caseRealLiteral(RealLiteral realLiteral) {
			writer.print(Double.toString(realLiteral.getValue()));
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
			if (templateArgument instanceof IIntegerValue) {
				IIntegerValue value = (IIntegerValue) templateArgument;
				writer.print(Long.toString(value.longValue()));
			} else if (templateArgument instanceof IRealValue) {
				IRealValue value = (IRealValue) templateArgument;
				writer.print(Double.toString(value.doubleValue()));
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
			writer.printf("context->%s[(context->%s_index + (%d)) %% %d]", name, name, variableAccess.getStepIndex(),
					circularBufferSize);
		}
		
	}

}
