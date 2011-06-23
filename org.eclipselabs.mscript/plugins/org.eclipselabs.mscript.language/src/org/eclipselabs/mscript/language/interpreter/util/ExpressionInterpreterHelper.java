/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.interpreter.util;

import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.ExpressionTarget;
import org.eclipselabs.mscript.language.il.transform.ExpressionTransformer;
import org.eclipselabs.mscript.language.il.transform.ITransformerContext;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;
import org.eclipselabs.mscript.language.interpreter.CompoundInterpreter;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.IVariable;
import org.eclipselabs.mscript.language.interpreter.Variable;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionInterpreterHelper {
	
	private Compound compound;
	
	private ITransformerContext transformerContext;

	private IInterpreterContext interpreterContext;
	
	private Expression expression;
	
	/**
	 * 
	 */
	public ExpressionInterpreterHelper(ITransformerContext transformerContext, IInterpreterContext interpreterContext, Expression expression) {
		this.transformerContext = transformerContext;
		this.interpreterContext = interpreterContext;
		this.expression = expression;
	}

	public IValue evaluateSingle() throws CoreException {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Evaluating expression failed", null);
		
		LocalVariableDeclaration resultVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		
		compound = ILFactory.eINSTANCE.createCompound();

		transformerContext.enterScope();
		transformerContext.setCompound(compound);
		transformerContext.addVariableDeclaration(resultVariableDeclaration);
		
		try {
			ExpressionTarget target = new ExpressionTarget(resultVariableDeclaration, 0);
			
			IStatus transformationStatus = new ExpressionTransformer(transformerContext).transform(expression, Collections.singletonList(target));

			if (!transformationStatus.isOK()) {
				StatusUtil.merge(status, transformationStatus);
				throw new CoreException(status);
			}
			
			preprocessCompound(compound);

			IVariable outputVariable = new Variable(resultVariableDeclaration);
			interpreterContext.addVariable(outputVariable);
			
			new CompoundInterpreter().execute(interpreterContext, compound);

			return outputVariable.getValue(0);
		} finally {
			transformerContext.leaveScope();
		}
	}
	
	protected void preprocessCompound(Compound compound) throws CoreException {
	}

}
