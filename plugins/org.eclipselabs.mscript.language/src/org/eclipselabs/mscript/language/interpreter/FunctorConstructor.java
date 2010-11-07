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

import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.VariableDeclaration;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionConstructor;
import org.eclipselabs.mscript.language.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class FunctorConstructor {

	public IFunctor construct(IInterpreterContext context, FunctionDefinition functionDefinition, List<IValue> templateArguments) {
		if (functionDefinition.getTemplateParameters().size() != templateArguments.size()) {
			throw new IllegalArgumentException("Number of template arguments must be equal to number of template parameters of function definition");
		}
		
		Map<String, IValue> templateArgumentMap = new HashMap<String, IValue>();
		int i = 0;
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameters()) {
			templateArgumentMap.put(parameterDeclaration.getName(), templateArguments.get(i));
			++i;
		}
		
		Function function = new FunctionConstructor().construct(functionDefinition, context.getDiagnostics());

		Functor functor = new Functor();
		functor.setTemplateArguments(templateArgumentMap);
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
				String name = equationPart.getVariableStep().getReference().getName();
				IVariable variable = functor.getVariable(name);
				if (variable != null) {
					variable.ensureStep(equationPart.getVariableStep().getIndex());
				}
			}
			for (EquationPart equationPart : equation.getRightHandSide().getParts()) {
				String name = equationPart.getVariableStep().getReference().getName();
				IVariable variable = functor.getVariable(name);
				if (variable != null) {
					variable.ensureStep(equationPart.getVariableStep().getIndex());
				}
			}
		}

		for (Equation equation : functor.getFunction().getEquations()) {
			if (!equation.getLeftHandSide().getParts().isEmpty()) {
				VariableStep variableStep = equation.getLeftHandSide().getParts().get(0).getVariableStep();
				if (variableStep.isInitial()) {
					String name = variableStep.getReference().getName();
					IVariable variable = functor.getVariable(name);
					if (variable != null) {
						IValue rhsValue = new ExpressionValueEvaluator(context).doSwitch(equation.getDefinition().getRightHandSide());
						variable.setValue(variableStep.getIndex(), rhsValue);
					}
				}
			}
		}

	}
	
}
