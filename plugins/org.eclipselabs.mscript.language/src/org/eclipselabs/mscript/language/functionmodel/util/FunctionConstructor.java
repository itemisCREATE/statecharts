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
import java.util.Map;
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
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
import org.eclipselabs.mscript.language.internal.util.EObjectDiagnostic;
import org.eclipselabs.mscript.language.internal.util.TreeIterator;
import org.eclipselabs.mscript.language.internal.util.VariableReferenceDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class FunctionConstructor {

	public Function construct(FunctionDefinition functionDefinition, DiagnosticChain diagnostics) {
		VariableReferenceMap variableReferences = new VariableReferenceMap();
				
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
			new EquationSideInitializer(lhs, variableReferences, diagnostics).initialize();
			
			Expression rhsExpression = equationDefinition.getRightHandSide();
			EquationSide rhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			rhs.setEquation(equation);
			rhs.setExpression(rhsExpression);
			new EquationSideInitializer(rhs, variableReferences, diagnostics).initialize();
		}
		
		for (TreeIterator it = new TreeIterator(function, true); it.hasNext();) {
			FunctionModelValidator.INSTANCE.validate(it.next(), diagnostics, new HashMap<Object, Object>());
		}
		
		return function;
	}
		
	protected VariableReference getVariableReference(String name, VariableReferenceKind kind, int step, boolean initial, Function function, Map<VariableReferenceDescriptor, VariableReference> variableReferences) {
		VariableReferenceDescriptor descriptor = new VariableReferenceDescriptor(name, step, initial);
		VariableReference variableReference = variableReferences.get(descriptor);
		if (variableReference == null) {
			variableReference = FunctionModelFactory.eINSTANCE.createVariableReference();
			variableReference.setName(name);
			variableReference.setKind(kind);
			variableReference.setStep(step);
			variableReference.setInitial(initial);
			variableReference.setFunction(function);
			variableReferences.put(descriptor, variableReference);
		}
		return variableReference;
	}

	private static class VariableReferenceMap extends HashMap<VariableReferenceDescriptor, VariableReference> {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public VariableReference get(String name, VariableReferenceKind kind, int step, boolean initial, Function function) {
			VariableReferenceDescriptor descriptor = new VariableReferenceDescriptor(name, step, initial);
			VariableReference variableReference = get(descriptor);
			if (variableReference == null) {
				variableReference = FunctionModelFactory.eINSTANCE.createVariableReference();
				variableReference.setName(name);
				variableReference.setKind(kind);
				variableReference.setStep(step);
				variableReference.setInitial(initial);
				variableReference.setFunction(function);
				put(descriptor, variableReference);
			}
			return variableReference;
		}

	}
	
	private static class EquationSideInitializer extends AstSwitch<Boolean> {

		private static final Scope MOST_OUTER_SCOPE = new Scope(null);
		private Scope scope = MOST_OUTER_SCOPE;

		private EquationSide equationSide;
		private VariableReferenceMap variableReferences;
		private DiagnosticChain diagnostics;
		
		/**
		 * 
		 */
		public EquationSideInitializer(EquationSide equationSide, VariableReferenceMap variableReferences, DiagnosticChain diagnostics) {
			this.equationSide = equationSide;
			this.variableReferences = variableReferences;
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
						diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Let variable " + simpleName.getIdentifier() + " cannot be called", simpleName));
					}
					return true;
				}
				VariableReferenceKind variableReferenceKind = getVariableReferenceKind(
						equationSide.getEquation().getFunction().getDefinition(),
						simpleName.getIdentifier());
				if (variableReferenceKind != VariableReferenceKind.UNKNOWN) {
					StepExpressionResult stepExpressionResult = evaluateStepExpression(featureCall, diagnostics);
					if (stepExpressionResult != null) {
						EquationPart part = FunctionModelFactory.eINSTANCE.createEquationPart();
						part.setSide(equationSide);
						part.setFeatureCall(featureCall);
						VariableReference variableReference = variableReferences.get(
								simpleName.getIdentifier(),
								variableReferenceKind,
								stepExpressionResult.getStep(),
								stepExpressionResult.isAbsolute(),
								equationSide.getEquation().getFunction());
						part.setVariableReference(variableReference);
					}
				} else {
					diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, simpleName.getIdentifier() + " cannot be resolved to a variable", simpleName));
				}
			} else {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Invalid expression", featureCall.getTarget()));
			}
			return true;
		}
		
		private VariableReferenceKind getVariableReferenceKind(FunctionDefinition functionDefinition, String name) {
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameters()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableReferenceKind.TEMPLATE_PARAMETER;
				}
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameters()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableReferenceKind.INPUT_PARAMETER;
				}
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getOutputParameters()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableReferenceKind.OUTPUT_PARAMETER;
				}
			}
			for (VariableDeclaration stateVariableDeclaration : functionDefinition.getStateVariables()) {
				if (name.equals(stateVariableDeclaration.getName())) {
					return VariableReferenceKind.STATE_VARIABLE;
				}
			}
			return VariableReferenceKind.UNKNOWN;
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
