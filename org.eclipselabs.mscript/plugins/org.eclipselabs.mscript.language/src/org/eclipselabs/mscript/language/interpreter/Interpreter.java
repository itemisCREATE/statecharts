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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class Interpreter implements IInterpreter {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreter#initialize(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.interpreter.IFunctionObject)
	 */
	public void initialize(IInterpreterContext context, IFunctionObject functionObject) {
		Compound initializationCompound = functionObject.getFunctionDefinition().getInitializationCompound();
		if (initializationCompound != null) {
			new CompoundInterpreter().execute(context, initializationCompound);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreter#execute(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.interpreter.IFunctionObject, java.util.List)
	 */
	public List<IValue> execute(IInterpreterContext context, IFunctionObject functionObject, List<IValue> inputValues) {
		Iterator<IValue> inputValueIterator = inputValues.iterator();
		for (InputVariableDeclaration inputVariableDeclaration : functionObject.getFunctionDefinition().getInputVariableDeclarations()) {
			IVariable variable = functionObject.getVariable(inputVariableDeclaration);
			variable.setValue(0, inputValueIterator.next());
		}
		
		ICompoundInterpreter compoundInterpreter = new CompoundInterpreter();
		
		for (ComputationCompound compound : functionObject.getFunctionDefinition().getComputationCompounds()) {
			compoundInterpreter.execute(context, compound);
		}
		
		List<IValue> outputValues = new ArrayList<IValue>();
		for (OutputVariableDeclaration outputVariableDeclaration : functionObject.getFunctionDefinition().getOutputVariableDeclarations()) {
			outputValues.add(functionObject.getVariable(outputVariableDeclaration).getValue(0));
		}
		
		return outputValues;
	}
		
}
