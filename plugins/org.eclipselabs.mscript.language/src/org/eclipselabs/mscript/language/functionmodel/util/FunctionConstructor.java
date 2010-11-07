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

package org.eclipselabs.mscript.language.functionmodel.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.EquationDefinition;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariable;
import org.eclipselabs.mscript.language.ast.OperationCall;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.ast.VariableDeclaration;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelFactory;
import org.eclipselabs.mscript.language.functionmodel.VariableKind;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
import org.eclipselabs.mscript.language.internal.util.EObjectDiagnostic;
import org.eclipselabs.mscript.language.internal.util.TreeIterator;

/**
 * @author Andreas Unger
 *
 */
public class FunctionConstructor {

	public Function construct(FunctionDefinition functionDefinition, DiagnosticChain diagnostics) {
		validate(functionDefinition, diagnostics);
		
		Function function = FunctionModelFactory.eINSTANCE.createFunction();
		function.setDefinition(functionDefinition);

		for (EquationDefinition equationDefinition : functionDefinition.getEquations()) {
			Equation equation = FunctionModelFactory.eINSTANCE.createEquation();
			equation.setFunction(function);
			equation.setDefinition(equationDefinition);
			
			Expression lhsExpression = equationDefinition.getLeftHandSide();
			EquationSide lhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			lhs.setEquation(equation);
			lhs.setExpression(lhsExpression);
			new EquationSideInitializer(lhs, diagnostics).initialize();
			
			Expression rhsExpression = equationDefinition.getRightHandSide();
			EquationSide rhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			rhs.setEquation(equation);
			rhs.setExpression(rhsExpression);
			new EquationSideInitializer(rhs, diagnostics).initialize();
		}
		
		for (TreeIterator it = new TreeIterator(function, true); it.hasNext();) {
			FunctionModelValidator.INSTANCE.validate(it.next(), diagnostics, new HashMap<Object, Object>());
		}
		
		return function;
	}
	
	protected boolean validate(FunctionDefinition functionDefinition, DiagnosticChain diagnostics) {
		boolean result = true;
		
		if (!functionDefinition.isStateful()) {
			if (!functionDefinition.getTemplateParameters().isEmpty()) {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Stateless functions must not declare template parameters", functionDefinition, AstPackage.FUNCTION_DEFINITION__NAME));
				result = false;
			}
			if (!functionDefinition.getStateVariables().isEmpty()) {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Stateless functions must not declare state variables", functionDefinition, AstPackage.FUNCTION_DEFINITION__NAME));
				result = false;
			}
			if (!functionDefinition.getFunctors().isEmpty()) {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Stateless functions must not declare functors", functionDefinition, AstPackage.FUNCTION_DEFINITION__NAME));
				result = false;
			}
		}
		
		return result;
	}
		
	private static class EquationSideInitializer extends AstSwitch<Boolean> {

		private static final Scope MOST_OUTER_SCOPE = new Scope(null);
		private Scope scope = MOST_OUTER_SCOPE;

		private EquationSide equationSide;
		private DiagnosticChain diagnostics;
		
		/**
		 * 
		 */
		public EquationSideInitializer(EquationSide equationSide, DiagnosticChain diagnostics) {
			this.equationSide = equationSide;
			this.diagnostics = diagnostics;
		}
		
		public void initialize() {
			doSwitch(equationSide.getExpression());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
		 */
		@Override
		public Boolean caseLetExpression(LetExpression letExpression) {
			Scope newScope = new Scope(scope);
			for (LetExpressionVariable variable : letExpression.getVariables()) {
				doSwitch(variable.getAssignedExpression());
				newScope.addVariable(variable.getName());
			}
			
			scope = newScope;
			doSwitch(letExpression.getTargetExpression());
			scope = scope.getOuterScope();
			
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFeatureCall(org.eclipselabs.mscript.language.ast.FeatureCall)
		 */
		@Override
		public Boolean caseFeatureCall(FeatureCall featureCall) {
			if (featureCall.getTarget() instanceof SimpleName) {
				SimpleName simpleName = (SimpleName) featureCall.getTarget();
				if (scope.containsVariable(simpleName.getIdentifier())) {
					if (!featureCall.getParts().isEmpty()) {
						diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Let variable '" + simpleName.getIdentifier() + "' cannot be called", featureCall));
					}
					return true;
				}
				
				Function function = equationSide.getEquation().getFunction();
				VariableKind variableKind = getVariableKind(
						function.getDefinition(),
						simpleName.getIdentifier());
				
				switch (variableKind) {
				case TEMPLATE_PARAMETER:
					if (!featureCall.getParts().isEmpty() && featureCall.getParts().get(0) instanceof OperationCall) {
						diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Template parameters cannot be called", featureCall));
					}
					break;
				case INPUT_PARAMETER:
				case OUTPUT_PARAMETER:
				case STATE_VARIABLE:
					if (!function.getDefinition().isStateful() && !featureCall.getParts().isEmpty() && featureCall.getParts().get(0) instanceof OperationCall) {
						diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Variable references of stateless functions must not specify step expressions", featureCall));
					}
					break;
				case CONSTANT:
					if (!featureCall.getParts().isEmpty() && featureCall.getParts().get(0) instanceof OperationCall) {
						diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Constants cannot be called", featureCall));
					}
					break;
				case FUNCTOR:
					diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Functors not supported yet", featureCall));
					break;
				}
				
				if (variableKind != VariableKind.UNKNOWN) {
					int stepIndex = 0;
					boolean initial = false;
					
					if (variableKind == VariableKind.INPUT_PARAMETER
							|| variableKind == VariableKind.OUTPUT_PARAMETER
							|| variableKind == VariableKind.STATE_VARIABLE) {
						StepExpressionResult stepExpressionResult = evaluateStepExpression(featureCall, diagnostics);
						if (stepExpressionResult != null) {
							stepIndex = stepExpressionResult.getIndex();
							initial = stepExpressionResult.isInitial();
						}
					}

					EquationPart part = FunctionModelFactory.eINSTANCE.createEquationPart();
					part.setSide(equationSide);
					part.setFeatureCall(featureCall);
					VariableReference variableReference = function.getVariableReference(simpleName.getIdentifier());
					if (variableReference == null) {
						variableReference = FunctionModelFactory.eINSTANCE.createVariableReference();
						variableReference.setFunction(function);
						variableReference.setName(simpleName.getIdentifier());
						variableReference.setKind(variableKind);
					}
					
					VariableStep variableStep = variableReference.getStep(stepIndex, initial);
					if (variableStep == null) {
						variableStep = FunctionModelFactory.eINSTANCE.createVariableStep();
						variableStep.setReference(variableReference);
						variableStep.setIndex(stepIndex);
						variableStep.setInitial(initial);
					}
					part.setVariableStep(variableStep);
				} else {
					diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "'" + simpleName.getIdentifier() + "' cannot be resolved to a variable", simpleName));
				}
			} else {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid expression", featureCall.getTarget()));
			}
			return true;
		}
		
		private VariableKind getVariableKind(FunctionDefinition functionDefinition, String name) {
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameters()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableKind.TEMPLATE_PARAMETER;
				}
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameters()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableKind.INPUT_PARAMETER;
				}
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getOutputParameters()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableKind.OUTPUT_PARAMETER;
				}
			}
			for (VariableDeclaration stateVariableDeclaration : functionDefinition.getStateVariables()) {
				if (name.equals(stateVariableDeclaration.getName())) {
					return VariableKind.STATE_VARIABLE;
				}
			}
			return VariableKind.UNKNOWN;
		}

		private StepExpressionResult evaluateStepExpression(FeatureCall featureCall, DiagnosticChain diagnostics) {
			if (featureCall.getParts().isEmpty()) {
				return new StepExpressionResult(0, false);
			}
			Expression stepExpression = getStepExpression(featureCall, diagnostics);
			return new StepExpressionHelper().evaluate(stepExpression, diagnostics);
		}

		private Expression getStepExpression(FeatureCall featureCall, DiagnosticChain diagnostics) {
			FeatureCallPart part = featureCall.getParts().get(0);
			if (part instanceof OperationCall) {
				OperationCall operationCall = (OperationCall) part;
				if (operationCall.getArguments().size() != 1) {
					diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid parameter count", operationCall, AstPackage.OPERATION_CALL__ARGUMENTS));
				} else {
					return operationCall.getArguments().get(0);
				}
			}
			return null;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			for (EObject content : object.eContents()) {
				doSwitch(content);
			}
			return true;
		}

		private static class Scope {

			private Scope outerScope;
			private Set<String> variables = new HashSet<String>();
			
			/**
			 * 
			 */
			public Scope(Scope outerScope) {
				this.outerScope = outerScope;
			}
			
			/**
			 * @return the outerScope
			 */
			public Scope getOuterScope() {
				return outerScope;
			}
			
			public void addVariable(String name) {
				variables.add(name);
			}
			
			public boolean containsVariable(String name) {
				return variables.contains(name);
			}
			
		}

	}

}
