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

import java.util.Map;

import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.VariableDeclaration;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionConstructor;
import org.eclipselabs.mscript.language.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class FunctorConstructor {

	public IFunctor construct(IInterpreterContext context, FunctionDefinition functionDefinition, Map<String, IValue> templateArguments) {
		Function function = new FunctionConstructor().construct(functionDefinition, context.getDiagnostics());

		Functor functor = new Functor();
		functor.setTemplateArguments(templateArguments);
		functor.setFunction(function);

		context.setFunctor(functor);
		createVariables(context, functor);
		
		functor.setInitialized(true);
		
		return functor;
	}
	
	protected void createVariables(IInterpreterContext context, IFunctor functor) {
		for (ParameterDeclaration parameterDeclaration : functor.getFunction().getDefinition().getInputParameters()) {
			functor.addVariable(new Variable(parameterDeclaration.getName()));
		}
		for (ParameterDeclaration parameterDeclaration : functor.getFunction().getDefinition().getOutputParameters()) {
			functor.addVariable(new Variable(parameterDeclaration.getName()));
		}
		for (VariableDeclaration variableDeclaration : functor.getFunction().getDefinition().getStateVariables()) {
			functor.addVariable(new Variable(variableDeclaration.getName()));
		}
		
		for (Equation equation : functor.getFunction().getEquations()) {
			for (EquationPart equationPart : equation.getLeftHandSide().getParts()) {
				String name = equationPart.getVariableReference().getName();
				IVariable variable = functor.getVariable(name);
				if (variable != null) {
					variable.ensureValueIndex(equationPart.getVariableReference().getStep());
				}
			}
			for (EquationPart equationPart : equation.getRightHandSide().getParts()) {
				String name = equationPart.getVariableReference().getName();
				IVariable variable = functor.getVariable(name);
				if (variable != null) {
					variable.ensureValueIndex(equationPart.getVariableReference().getStep());
				}
			}
		}

		for (Equation equation : functor.getFunction().getEquations()) {
			if (!equation.getLeftHandSide().getParts().isEmpty()) {
				VariableReference variableReference = equation.getLeftHandSide().getParts().get(0).getVariableReference();
				if (variableReference.isInitial()) {
					String name = variableReference.getName();
					IVariable variable = functor.getVariable(name);
					if (variable != null) {
						IValue rhsValue = new ExpressionValueEvaluator(context).doSwitch(equation.getDefinition().getRightHandSide());
						variable.setValue(variableReference.getStep(), rhsValue);
					}
				}
			}
		}

	}
	
}
