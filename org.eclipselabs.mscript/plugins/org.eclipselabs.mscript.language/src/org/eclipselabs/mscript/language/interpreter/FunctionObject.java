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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.computation.core.value.Values;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class FunctionObject implements IFunctionObject {

	private ILFunctionDefinition functionDefinition;
	private Map<VariableDeclaration, IVariable> variables = new HashMap<VariableDeclaration, IVariable>();
	
	/**
	 * 
	 */
	private FunctionObject() {
	}
	
	public static IFunctionObject create(IInterpreterContext context, ILFunctionDefinition functionDefinition) {
		FunctionObject functionObject = new FunctionObject();
		functionObject.functionDefinition = functionDefinition;
		
		for (TemplateVariableDeclaration declaration : functionDefinition.getTemplateVariableDeclarations()) {
			IVariable variable = new Variable(declaration);
			variable.setValue(0, Values.transform(context.getComputationContext(), declaration.getValue()));
			functionObject.variables.put(declaration, variable);
		}
		
		for (InputVariableDeclaration declaration : functionDefinition.getInputVariableDeclarations()) {
			functionObject.variables.put(declaration, new Variable(declaration, declaration.getCircularBufferSize()));
		}
		
		for (OutputVariableDeclaration declaration : functionDefinition.getOutputVariableDeclarations()) {
			functionObject.variables.put(declaration, new Variable(declaration, declaration.getCircularBufferSize()));
		}
		
		for (InstanceVariableDeclaration declaration : functionDefinition.getInstanceVariableDeclarations()) {
			functionObject.variables.put(declaration, new Variable(declaration, declaration.getCircularBufferSize()));
		}
		
		return functionObject;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#getFunctionDefinition()
	 */
	public ILFunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#getVariables()
	 */
	public Collection<IVariable> getVariables() {
		return Collections.unmodifiableCollection(variables.values());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#getVariable(org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration)
	 */
	public IVariable getVariable(VariableDeclaration declaration) {
		return variables.get(declaration);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#incrementStepIndex()
	 */
	public void incrementStepIndex() {
		for (IVariable variable : variables.values()) {
			variable.incrementStepIndex();
		}
	}
	
}
