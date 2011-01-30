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

package org.eclipselabs.mscript.language.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.computation.engine.value.AnyValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class StaticInterpreterContext extends InterpreterContext {

	private ILFunctionDefinition functionDefinition;
	
	private Map<VariableDeclaration, IVariable> variables;
	
	/**
	 * @param computationContext
	 */
	public StaticInterpreterContext(IComputationContext computationContext, ILFunctionDefinition functionDefinition) {
		super(computationContext);
		this.functionDefinition = functionDefinition;
	}
	
	/**
	 * @return the functionDefinition
	 */
	public ILFunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.InterpreterContext#getVariable(org.eclipselabs.mscript.language.il.VariableDeclaration)
	 */
	@Override
	public IVariable getVariable(VariableDeclaration variableDeclaration) {
		IVariable variable = super.getVariable(variableDeclaration);
		if (variable == null) {
			variable = getFunctionDefinitionVariable(variableDeclaration);
		}
		return variable;
	}
	
	protected IVariable getFunctionDefinitionVariable(VariableDeclaration variableDeclaration) {
		if (variables == null) {
			variables = new HashMap<VariableDeclaration, IVariable>();
			for (TemplateVariableDeclaration templateVariableDeclaration : functionDefinition.getTemplateVariableDeclarations()) {
				IValue value = templateVariableDeclaration.getValue();
				IVariable variable = new Variable(templateVariableDeclaration);
				variable.setValue(0, value);
				variables.put(variable.getDeclaration(), variable);
			}

			for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
				IValue value = new AnyValue(getComputationContext(), inputVariableDeclaration.getType());
				IVariable variable = new Variable(inputVariableDeclaration);
				variable.setValue(0, value);
				variables.put(variable.getDeclaration(), variable);
			}
		}
		return variables.get(variableDeclaration);
	}

}
