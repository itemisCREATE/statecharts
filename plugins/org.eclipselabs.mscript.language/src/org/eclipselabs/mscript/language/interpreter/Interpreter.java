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

import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class Interpreter {

	public void initialize(IInterpreterContext context, IFunctor functor) {
		Compound initializationCompound = functor.getFunctionDefinition().getInitializationCompound();
		if (initializationCompound != null) {
			new CompoundInterpreter(context).doSwitch(initializationCompound);
		}
	}
	
	public List<IValue> execute(IInterpreterContext context, IFunctor functor, List<IValue> inputValues) {
		Iterator<IValue> inputValueIterator = inputValues.iterator();
		for (InputVariableDeclaration inputVariableDeclaration : functor.getFunctionDefinition().getInputVariableDeclarations()) {
			IVariable variable = functor.getVariable(inputVariableDeclaration);
			variable.setValue(0, inputValueIterator.next());
		}
		
		CompoundInterpreter compoundInterpreter = new CompoundInterpreter(context);
		
		for (ComputationCompound compound : functor.getFunctionDefinition().getComputationCompounds()) {
			compoundInterpreter.doSwitch(compound);
		}
		
		List<IValue> outputValues = new ArrayList<IValue>();
		for (OutputVariableDeclaration outputVariableDeclaration : functor.getFunctionDefinition().getOutputVariableDeclarations()) {
			outputValues.add(functor.getVariable(outputVariableDeclaration).getValue(0));
		}
		
		return outputValues;
	}
		
}
