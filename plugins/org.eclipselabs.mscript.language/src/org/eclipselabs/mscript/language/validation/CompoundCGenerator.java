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

package org.eclipselabs.mscript.language.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.BooleanKind;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Statement;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch;

/**
 * Note: This class is for testing purposes only.
 * 
 * @author Andreas Unger
 *
 */
class CompoundCGenerator extends ImperativeModelSwitch<String> {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseCompound(org.eclipselabs.mscript.language.imperativemodel.Compound)
	 */
	@Override
	public String caseCompound(Compound compound) {
		boolean block = compound instanceof Statement;
		StringBuilder sb = new StringBuilder();
		if (block) {
			sb.append("{\n");
		}
		for (Statement statement : compound.getStatements()) {
			sb.append(doSwitch(statement));
		}
		if (block) {
			sb.append("}\n");
		}
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration)
	 */
	@Override
	public String caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		StringBuilder sb = new StringBuilder();
		sb.append("var ");
		sb.append(localVariableDeclaration.getName());
		if (localVariableDeclaration.getInitializer() != null) {
			sb.append(" = ");
			sb.append(doSwitch(localVariableDeclaration.getInitializer()));
		}
		sb.append(";\n");
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseAssignment(org.eclipselabs.mscript.language.imperativemodel.Assignment)
	 */
	@Override
	public String caseAssignment(Assignment assignment) {
		StringBuilder sb = new StringBuilder();
		VariableDeclaration target = assignment.getTarget();
		sb.append(target.getName());
		if (target instanceof StatefulVariableDeclaration) {
			StatefulVariableDeclaration statefulVariableDeclaration = (StatefulVariableDeclaration) target;
			appendStateArraySubscript(sb, statefulVariableDeclaration, assignment.getStepIndex());
		}
		sb.append(" = ");
		sb.append(doSwitch(assignment.getAssignedExpression()));
		sb.append(";\n");
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseIfStatement(org.eclipselabs.mscript.language.imperativemodel.IfStatement)
	 */
	@Override
	public String caseIfStatement(IfStatement ifStatement) {
		StringBuilder sb = new StringBuilder();
		sb.append("if (");
		sb.append(doSwitch(ifStatement.getCondition()));
		sb.append(")\n");
		sb.append(doSwitch(ifStatement.getThenStatement()));
		sb.append("else\n");
		sb.append(doSwitch(ifStatement.getElseStatement()));
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public String defaultCase(EObject object) {
		if (object instanceof Expression) {
			return new ExpressionCGenerator().doSwitch(object);
		}
		return super.defaultCase(object);
	}
	
	private void appendStateArraySubscript(StringBuilder sb, StatefulVariableDeclaration statefulVariableDeclaration, int stepIndex) {
		if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
			sb.append("[(");
			sb.append(statefulVariableDeclaration.getName());
			sb.append("_index + (");
			sb.append(stepIndex);
			sb.append(")) % ");
			sb.append(statefulVariableDeclaration.getCircularBufferSize());
			sb.append("]");
		}
	}
	
	private class ExpressionCGenerator extends AstSwitch<String> {
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public String caseAdditiveExpression(AdditiveExpression additiveExpression) {
			StringBuilder sb = new StringBuilder();
			sb.append(doSwitch(additiveExpression.getLeftOperand()));
			for (AdditiveExpressionPart rightPart : additiveExpression.getRightParts()) {
				sb.append(" ");
				sb.append(rightPart.getOperator().getLiteral());
				sb.append(" ");
				sb.append(doSwitch(rightPart.getOperand()));
			}
			return sb.toString();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public String caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			StringBuilder sb = new StringBuilder();
			sb.append(doSwitch(multiplicativeExpression.getLeftOperand()));
			for (MultiplicativeExpressionPart rightPart : multiplicativeExpression.getRightParts()) {
				sb.append(" ");
				sb.append(rightPart.getOperator().getLiteral());
				sb.append(" ");
				sb.append(doSwitch(rightPart.getOperand()));
			}
			return sb.toString();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public String caseRelationalExpression(RelationalExpression relationalExpression) {
			StringBuilder sb = new StringBuilder();
			sb.append(doSwitch(relationalExpression.getLeftOperand()));
			sb.append(" ");
			sb.append(relationalExpression.getOperator().getLiteral());
			sb.append(" ");
			sb.append(doSwitch(relationalExpression.getRightOperand()));
			return sb.toString();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public String caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(doSwitch(parenthesizedExpression.getExpressions().get(0)));
			sb.append(")");
			return sb.toString();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public String caseUnaryExpression(UnaryExpression unaryExpression) {
			return unaryExpression.getOperator().getLiteral() + doSwitch(unaryExpression.getOperand());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public String caseIntegerLiteral(IntegerLiteral integerLiteral) {
			return Long.toString(integerLiteral.getValue());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public String caseRealLiteral(RealLiteral realLiteral) {
			return Double.toString(realLiteral.getValue());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
		 */
		@Override
		public String caseBooleanLiteral(BooleanLiteral booleanLiteral) {
			return booleanLiteral.getValue() == BooleanKind.TRUE ? "1" : "0";
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
		 */
		@Override
		public String caseStringLiteral(StringLiteral stringLiteral) {
			return "\"" + stringLiteral.getValue() + "\"";
		}
		
		public String caseVariableReference(VariableReference variableReference) {
			StringBuilder sb = new StringBuilder();
			VariableDeclaration variableDeclaration = variableReference.getDeclaration();
			sb.append(variableDeclaration.getName());
			if (variableDeclaration instanceof StatefulVariableDeclaration) {
				StatefulVariableDeclaration statefulVariableDeclaration = (StatefulVariableDeclaration) variableDeclaration;
				appendStateArraySubscript(sb, statefulVariableDeclaration, variableReference.getStepIndex());
			}
			return sb.toString();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseExpression(org.eclipselabs.mscript.language.ast.Expression)
		 */
		@Override
		public String caseExpression(Expression expression) {
			if (expression instanceof VariableReference) {
				return caseVariableReference((VariableReference) expression);
			}
			return super.caseExpression(expression);
		}

	}
	
}
