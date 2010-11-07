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
import java.util.List;

import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public class Interpreter {

	public List<IValue> execute(IInterpreterContext context, IFunctor functor, List<IValue> inputValues) {
		assignInputValues(context, functor, inputValues);
		
		for (Equation equation : functor.getFunction().getEquations()) {
			if (equation.getLeftHandSide().getParts().size() == 1) {
				VariableStep variableStep = equation.getLeftHandSide().getParts().get(0).getVariableStep();
				if (!variableStep.isInitial()) {
					IValue rhsValue = new ExpressionValueEvaluator(context).doSwitch(equation.getDefinition().getRightHandSide());
					if (!(rhsValue instanceof InvalidValue)) {
						IVariable variable = functor.getVariable(variableStep.getReference().getName());
						if (variable != null) {
							variable.setValue(variableStep.getIndex(), rhsValue);
						}
					}
				}
			}
		}
		
		List<IValue> outputValues = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functor.getFunction().getDefinition().getOutputParameters()) {
			IVariable variable = functor.getVariable(parameterDeclaration.getName());
			outputValues.add(variable.getValue(0));
		}
		
		incrementVariableIndices(context, functor);
		
		return outputValues;
	}
	
	public void assignInputValues(IInterpreterContext context, IFunctor functor, List<IValue> inputValues) {
		int i = 0;
		for (ParameterDeclaration parameterDeclaration : functor.getFunction().getDefinition().getInputParameters()) {
			IVariable variable = functor.getVariable(parameterDeclaration.getName());
			variable.setValue(0, inputValues.get(i));
			++i;
		}
	}

	public void evaluateEquations(IInterpreterContext context, IFunctor functor, boolean validInput) {
	}

	public void incrementVariableIndices(IInterpreterContext context, IFunctor functor) {
		for (IVariable variable : functor.getVariables()) {
			variable.incrementStepIndex();
		}	
	}	
	
}
