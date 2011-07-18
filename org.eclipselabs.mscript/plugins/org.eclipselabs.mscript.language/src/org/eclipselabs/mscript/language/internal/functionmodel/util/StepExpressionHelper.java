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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveStepExpression;
import org.eclipselabs.mscript.language.ast.NegateStepExpression;
import org.eclipselabs.mscript.language.ast.StepExpression;
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
public class StepExpressionHelper {

	public StepExpressionResult getStepExpression(VariableAccess variableAccess) throws CoreException {
		if (variableAccess.getStepExpression() != null) {
			return evaluateStepExpression(variableAccess.getStepExpression());
		}
		return new StepExpressionResult(0, false);
	}

	private StepExpressionResult evaluateStepExpression(StepExpression stepExpression) throws CoreException {
		Evaluator evaluator = new Evaluator();
		int result = evaluator.doSwitch(stepExpression);
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
			if (absolute) {
				absolute = false;
			} else {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Duplicate 'n'", stepN));
			}
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
