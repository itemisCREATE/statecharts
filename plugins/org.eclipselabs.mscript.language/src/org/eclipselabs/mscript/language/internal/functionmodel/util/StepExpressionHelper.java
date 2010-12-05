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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.OperationArgumentList;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class StepExpressionHelper {

	public StepExpressionResult getStepExpression(ListIterator<FeatureCallPart> iterator) throws CoreException {
		if (iterator.hasNext()) {
			FeatureCallPart part = iterator.next();
			if (part instanceof OperationArgumentList) {
				OperationArgumentList operationArgumentList = (OperationArgumentList) part;
				if (operationArgumentList.getArguments().size() == 1) {
					return evaluateStepExpression(operationArgumentList.getArguments().get(0));
				}
				throw new CoreException(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid parameter count", operationArgumentList));
			}
			iterator.previous();
		}
		return new StepExpressionResult(0, false);
	}

	private StepExpressionResult evaluateStepExpression(Expression expression) throws CoreException {
		Evaluator evaluator = new Evaluator();
		int result = evaluator.doSwitch(expression);
		IStatus status = evaluator.getStatus();
		if (status.isOK()) {
			return new StepExpressionResult(result, evaluator.isAbsolute());
		}
		throw new CoreException(status);
	}
	
	private static class Evaluator extends AstSwitch<Integer> {
	
		private MultiStatus status;
		
		private boolean absolute = true;
		
		/**
		 * 
		 */
		public Evaluator() {
			status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Step expression evaluation failed", null);
		}
		
		/**
		 * @return the status
		 */
		public IStatus getStatus() {
			return status;
		}
		
		public boolean isAbsolute() {
			return absolute;
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
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid unary operation", unaryExpression));
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
						status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Duplicate 'n'", simpleName));
					}
				} else {
					status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid symbol", simpleName));
				}
			} else {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid expression", featureCall));
			}
			return 0;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Integer caseIntegerLiteral(IntegerLiteral integerLiteral) {
			if (integerLiteral.getUnit() != null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Integer literal must not specify unit", integerLiteral.getUnit()));
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
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid expression part", object));
			return 0;
		}
	
	}

}
