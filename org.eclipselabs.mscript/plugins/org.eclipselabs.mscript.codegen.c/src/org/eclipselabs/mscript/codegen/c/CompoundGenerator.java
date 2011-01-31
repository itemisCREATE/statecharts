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
import org.eclipselabs.mscript.codegen.c.internal.VariableAccessGenerator;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class CompoundGenerator implements ICompoundGenerator {
	
	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.ICompoundGenerator#generate(org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext, org.eclipselabs.mscript.language.il.Compound, org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy)
	 */
	public void generate(IMscriptGeneratorContext context, IVariableAccessStrategy variableAccessStrategy, Compound compound) {
		new CompoundGeneratorSwitch(context, variableAccessStrategy).doSwitch(compound);
	}
	
	private class CompoundGeneratorSwitch extends ILSwitch<Boolean> {

		private IMscriptGeneratorContext context;
		private IVariableAccessStrategy variableAccessStrategy;

		private PrintWriter writer;

		/**
		 * 
		 */
		public CompoundGeneratorSwitch(IMscriptGeneratorContext context, IVariableAccessStrategy variableAccessStrategy) {
			this.context = context;
			this.variableAccessStrategy = variableAccessStrategy;
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
				writer.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), localVariableDeclaration.getType(), localVariableDeclaration.getName(), false));
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
				writeAssignment(localVariableDeclaration.getType(), localVariableDeclaration.getName(), localVariableDeclaration.getInitializer());
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseAssignment(org.eclipselabs.mscript.language.imperativemodel.Assignment)
		 */
		@Override
		public Boolean caseAssignment(Assignment assignment) {
			writeAssignment(assignment.getTarget().getType(), new VariableAccessGenerator(context.getComputationModel(), variableAccessStrategy, assignment).generate(), assignment.getAssignedExpression());
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
			String itVarDecl = MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), iterationVariableDeclaration.getType(), itVarName, false);
			int size = collectionArrayType.getSize();
			
			writer.println("{");
			writer.printf("int %s_i;\n", itVarName);
			writer.printf("for (%s_i = 0; %s_i < %d; ++%s_i) {\n", itVarName, itVarName, size, itVarName);
			writer.printf("%s = (", itVarDecl);
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
				expressionGenerator.generate(context, variableAccessStrategy, (Expression) object);
				return true;
			}
			return super.defaultCase(object);
		}
		
		private void writeAssignment(DataType targetDataType, String target, Expression assignedExpression) {
			ArrayType arrayType = null;
			if (targetDataType instanceof ArrayType) {
				arrayType = (ArrayType) targetDataType;
			}
			if (arrayType != null) {
				writer.print("memcpy(");
			}
			writer.print(target);
			if (arrayType != null) {
				writer.print(", ");
			} else {
				writer.print(" = ");
			}
			cast(targetDataType, assignedExpression);
			if (arrayType != null) {
				writer.printf(", sizeof (%s)", MscriptGeneratorUtil.getCDataType(context.getComputationModel(), arrayType.getElementType()));
				for (ArrayDimension arrayDimension : arrayType.getDimensions()) {
					writer.printf(" * %d", arrayDimension.getSize());
				}
				writer.print(")");
			}
			writer.print(";\n");
		}
		
		private void cast(DataType targetDataType, Expression expression) {
			MscriptGeneratorUtil.cast(context, variableAccessStrategy, expression, targetDataType);
		}
	
	}
	
}
