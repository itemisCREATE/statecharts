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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionDefinition;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class Functor implements IFunctor {

	private ImperativeFunctionDefinition functionDefinition;
	private Map<VariableDeclaration, IVariable> variables = new HashMap<VariableDeclaration, IVariable>();
	
	/**
	 * 
	 */
	private Functor() {
	}
	
	public static IFunctor create(ImperativeFunctionDefinition functionDefinition, List<IValue> templateArguments) {
		if (functionDefinition.getTemplateVariableDeclarations().size() != templateArguments.size()) {
			throw new IllegalArgumentException("Number of template arguments must be equal to number of template parameters of function definition");
		}
		
		Functor functor = new Functor();
		functor.functionDefinition = functionDefinition;
		
		int i = 0;
		for (TemplateVariableDeclaration declaration : functionDefinition.getTemplateVariableDeclarations()) {
			IVariable variable = new Variable(declaration, 1);
			variable.setValue(0, templateArguments.get(i));
			functor.variables.put(declaration, variable);
			++i;
		}
		
		for (InputVariableDeclaration declaration : functionDefinition.getInputVariableDeclarations()) {
			functor.variables.put(declaration, new Variable(declaration, declaration.getCircularBufferSize()));
		}
		
		for (OutputVariableDeclaration declaration : functionDefinition.getOutputVariableDeclarations()) {
			functor.variables.put(declaration, new Variable(declaration, declaration.getCircularBufferSize()));
		}
		
		for (InstanceVariableDeclaration declaration : functionDefinition.getInstanceVariableDeclarations()) {
			functor.variables.put(declaration, new Variable(declaration, declaration.getCircularBufferSize()));
		}
		
		return functor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctor#getFunctionDefinition()
	 */
	public ImperativeFunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctor#getVariable(org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration)
	 */
	public IVariable getVariable(VariableDeclaration declaration) {
		return variables.get(declaration);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctor#incrementStepIndex()
	 */
	public void incrementStepIndex() {
		for (IVariable variable : variables.values()) {
			variable.incrementStepIndex();
		}
	}
	
}
