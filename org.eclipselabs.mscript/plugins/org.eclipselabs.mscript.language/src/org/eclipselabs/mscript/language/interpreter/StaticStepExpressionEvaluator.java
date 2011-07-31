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

package org.eclipselabs.mscript.language.interpreter;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveStepExpression;
import org.eclipselabs.mscript.language.ast.Equation;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.NegateStepExpression;
import org.eclipselabs.mscript.language.ast.StepLiteral;
import org.eclipselabs.mscript.language.ast.StepN;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class StaticStepExpressionEvaluator {
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IEvaluationContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IStatus evaluate(IStaticEvaluationContext context, FunctionDefinition functionDefinition) {
		Evaluator evaluator = new Evaluator(context);
		for (Equation equation : functionDefinition.getEquations()) {
			for (Iterator<EObject> it = equation.eAllContents(); it.hasNext();) {
				EObject next = it.next();
				if (next instanceof VariableAccess) {
					VariableAccess variableAccess = (VariableAccess) next;
					if (variableAccess.getStepExpression() != null) {
						Integer stepIndex = evaluator.doSwitch(variableAccess.getStepExpression());
						context.setStepIndex(variableAccess, stepIndex);
					}
				}
			}
		}
		return evaluator.getStatus();
	}
	
	private static class Evaluator extends AstSwitch<Integer> {
		
		private MultiStatus status;
		
		/**
		 * 
		 */
		public Evaluator(IStaticEvaluationContext context) {
			status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Step expression evaluation failed", null);
		}
		
		/**
		 * @return the status
		 */
		public IStatus getStatus() {
			return status;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveStepExpression(org.eclipselabs.mscript.language.ast.AdditiveStepExpression)
		 */
		@Override
		public Integer caseAdditiveStepExpression(AdditiveStepExpression additiveStepExpression) {
			Integer leftOperand = doSwitch(additiveStepExpression.getLeftOperand());
			Integer rightOperand = doSwitch(additiveStepExpression.getRightOperand());
			switch (additiveStepExpression.getOperator()) {
			case ADD:
				return leftOperand + rightOperand;
			case SUBTRACT:
				return leftOperand - rightOperand;
			}
			throw new IllegalArgumentException();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Integer caseNegateStepExpression(NegateStepExpression negateStepExpression) {
			return -doSwitch(negateStepExpression.getOperand());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStepLiteral(org.eclipselabs.mscript.language.ast.StepLiteral)
		 */
		@Override
		public Integer caseStepLiteral(StepLiteral stepLiteral) {
			return stepLiteral.getValue();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStepN(org.eclipselabs.mscript.language.ast.StepN)
		 */
		@Override
		public Integer caseStepN(StepN stepN) {
			return 0;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Integer defaultCase(EObject object) {
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid expression", object));
			return 0;
		}
	
	}
	
}
