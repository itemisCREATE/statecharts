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

package org.eclipselabs.mscript.language.internal.il.transform;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.IBooleanValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.language.ast.Assertion;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformerContext;
import org.eclipselabs.mscript.language.il.transform.ITransformerContext;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.StaticInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.util.ExpressionInterpreterHelper;
import org.eclipselabs.mscript.language.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class AssertionEvaluator {

	public IStatus evaluate(ILFunctionDefinition functionDefinition, FunctionDescriptor functionDescriptor) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Assertion failed", null);
		
		for (Assertion assertion : functionDescriptor.getDefinition().getAssertions()) {
			if (!assertion.isStatic()) {
				continue;
			}
			
			ITransformerContext transformerContext = new FunctionDefinitionTransformerContext(functionDefinition);
			IInterpreterContext interpreterContext = new StaticInterpreterContext(new ComputationContext(), functionDefinition);
			ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext, interpreterContext, assertion.getCondition());

			try {
				IValue outputValue = expressionInterpreterHelper.evaluateSingle();
				
				if (!(outputValue instanceof IBooleanValue)) {
					status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Assert condition must result to boolean value", assertion.getCondition()));
					continue;
				}
	
				IBooleanValue booleanOutputValue = (IBooleanValue) outputValue;
				
				if (!booleanOutputValue.booleanValue()) {
					Expression message = assertion.getMessage();
					if (message instanceof StringLiteral) {
						StringLiteral stringMessage = (StringLiteral) message;
						status.add(new Status(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, stringMessage.getValue()));
					}
				}
			} catch (CoreException e) {
				StatusUtil.merge(status, e.getStatus());
			}
		}
		
		return status.isOK() ? Status.OK_STATUS : status;
	}

}
