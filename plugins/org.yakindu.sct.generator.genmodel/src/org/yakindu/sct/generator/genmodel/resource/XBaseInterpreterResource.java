/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.resource;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.resource.XbaseResource;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class XBaseInterpreterResource extends XbaseResource implements
		IExpressionInterpreter {

	@Inject
	private IExpressionInterpreter interpreter;

	public IEvaluationResult evaluate(XExpression expression) {
		return interpreter.evaluate(expression);
	}

	public IEvaluationResult evaluate(XExpression expression,
			IEvaluationContext context, CancelIndicator cancelIndicator) {
		return interpreter.evaluate(expression, context, cancelIndicator);
	}

}
