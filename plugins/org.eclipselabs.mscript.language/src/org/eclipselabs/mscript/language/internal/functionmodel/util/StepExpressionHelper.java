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

package org.eclipselabs.mscript.language.internal.functionmodel.util;

import java.util.ListIterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.OperationCall;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.util.EObjectDiagnostic;

/**
 * @author Andreas Unger
 *
 */
public class StepExpressionHelper {

	public StepExpressionResult getStepExpression(ListIterator<FeatureCallPart> iterator, DiagnosticChain diagnostics) {
		if (iterator.hasNext()) {
			FeatureCallPart part = iterator.next();
			if (part instanceof OperationCall) {
				OperationCall operationCall = (OperationCall) part;
				if (operationCall.getArguments().size() == 1) {
					return evaluateStepExpression(operationCall.getArguments().get(0), diagnostics);
				}
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid parameter count", operationCall, AstPackage.OPERATION_CALL__ARGUMENTS));
				return null;
			}
			iterator.previous();
		}
		return new StepExpressionResult(0, false);
	}

	private StepExpressionResult evaluateStepExpression(Expression expression, DiagnosticChain diagnostics) {
		Evaluator evaluator = new Evaluator(diagnostics);
		int result = evaluator.doSwitch(expression);
		if (evaluator.isOk()) {
			return new StepExpressionResult(result, evaluator.isAbsolute());
		}
		return null;
	}
	
	private static class Evaluator extends AstSwitch<Integer> {
	
		private DiagnosticChain diagnostics;
		private boolean absolute = true;
		private boolean ok = true;
		
		/**
		 * 
		 */
		public Evaluator(DiagnosticChain diagnostics) {
			this.diagnostics = diagnostics;
		}
		
		public boolean isAbsolute() {
			return absolute;
		}
		
		public boolean isOk() {
			return ok;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public Integer caseAdditiveExpression(AdditiveExpression addSubtractExpression) {
			Integer result = doSwitch(addSubtractExpression.getLeftOperand());
			for (AdditiveExpressionPart part : addSubtractExpression.getRightParts()) {
				result = addSubtract(result, doSwitch(part.getOperand()), part.getOperator());
			}
			return result;
		}
		
		protected Integer addSubtract(Integer operand1, Integer operand2, AdditiveOperator operator) {
			switch (operator) {
			case ADDITION:
				return operand1 + operand2;
			case SUBTRACTION:
				return operand1 - operand2;
			}
			throw new IllegalArgumentException();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Integer caseUnaryExpression(UnaryExpression unaryExpression) {
			Integer result;
			Integer operandValue = doSwitch(unaryExpression.getOperand());
			switch (unaryExpression.getOperator()) {
			case MINUS:
				result = -operandValue;
				break;
			case LOGICAL_NOT:
				result = 0;
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid unary operation", unaryExpression));
				ok = false;
				break;
			default:
				throw new IllegalArgumentException();
			}
			return result;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureCall(org.eclipselabs.mscript.language.ast.FeatureCall)
		 */
		@Override
		public Integer caseFeatureCall(FeatureCall featureCall) {
			if (featureCall.getTarget() instanceof SimpleName) {
				SimpleName simpleName = (SimpleName) featureCall.getTarget();
				if (simpleName.getIdentifier().equals("n")) {
					if (absolute) {
						absolute = false;
						return 0;
					} else {
						diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Duplicate 'n'", simpleName));
					}
				} else {
					diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid symbol", simpleName));
				}
			} else {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid expression", featureCall));
			}
			ok = false;
			return 0;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Integer caseIntegerLiteral(IntegerLiteral integerLiteral) {
			if (integerLiteral.getUnit() != null) {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Integer literal must not specify unit", integerLiteral.getUnit()));
				ok = false;
				return 0;
			}
			return (int) integerLiteral.getValue();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public Integer caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			return doSwitch(parenthesizedExpression.getExpressions().get(0));
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Integer defaultCase(EObject object) {
			diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid expression part", object));
			ok = false;
			return 0;
		}
	
	}

}
