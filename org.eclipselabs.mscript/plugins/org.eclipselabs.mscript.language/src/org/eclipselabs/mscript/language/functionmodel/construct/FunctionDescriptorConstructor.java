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

package org.eclipselabs.mscript.language.functionmodel.construct;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.Equation;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelFactory;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableKind;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDescriptorConstructor implements IFunctionDescriptorConstructor {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.functionmodel.construct.IFunctionDescriptorConstructor#construct(org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	public IFunctionDescriptorConstructorResult construct(FunctionDefinition functionDefinition) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Function descriptor construction errors", null);

		FunctionDescriptor functionDescriptor = FunctionModelFactory.eINSTANCE.createFunctionDescriptor();
		functionDescriptor.setDefinition(functionDefinition);

		for (Equation equation : functionDefinition.getEquations()) {
			EquationDescriptor equationDescriptor = FunctionModelFactory.eINSTANCE.createEquationDescriptor();
			equationDescriptor.setFunctionDescriptor(functionDescriptor);
			equationDescriptor.setEquation(equation);
			
			Expression lhsExpression = equation.getLeftHandSide();
			EquationSide lhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			lhs.setDescriptor(equationDescriptor);
			lhs.setExpression(lhsExpression);
			StatusUtil.merge(status, new EquationSideInitializer(lhs).initialize());
			
			Expression rhsExpression = equation.getRightHandSide();
			EquationSide rhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			rhs.setDescriptor(equationDescriptor);
			rhs.setExpression(rhsExpression);
			StatusUtil.merge(status, new EquationSideInitializer(rhs).initialize());
		}
		
		if (!status.isOK()) {
			return new FunctionDescriptorConstructorResult(functionDescriptor, status);
		}
		
		return new FunctionDescriptorConstructorResult(functionDescriptor);
	}
			
	private static class EquationSideInitializer extends AstSwitch<Boolean> {

		private EquationSide equationSide;
		private MultiStatus status;
		
		/**
		 * 
		 */
		public EquationSideInitializer(EquationSide equationSide) {
			this.equationSide = equationSide;
		}
		
		public IStatus initialize() {
			status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "", null);
			doSwitch(equationSide.getExpression());
			return status;
		}

		@Override
		public Boolean caseVariableAccess(VariableAccess variableAccess) {
			String name = variableAccess.getVariable().getName();
			
			FunctionDescriptor functionDescriptor = equationSide.getDescriptor().getFunctionDescriptor();
			VariableKind variableKind = getVariableKind(
					functionDescriptor.getDefinition(),
					name);
			
			checkFeatureCall(variableAccess, variableKind);
			
			if (variableKind != VariableKind.UNKNOWN) {
				int stepIndex = 0;
				boolean initial = false;
				
				if (variableKind == VariableKind.INPUT_PARAMETER
						|| variableKind == VariableKind.OUTPUT_PARAMETER
						|| variableKind == VariableKind.STATE_VARIABLE) {
					try {
						StepExpressionResult stepExpressionResult = new StepExpressionHelper().getStepExpression(variableAccess);
						stepIndex = stepExpressionResult.getIndex();
						initial = stepExpressionResult.isInitial();
					} catch (CoreException e) {
						StatusUtil.merge(status, e.getStatus());
					}
				}

				EquationPart part = FunctionModelFactory.eINSTANCE.createEquationPart();
				part.setSide(equationSide);
				part.setVariableAccess(variableAccess);
				VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(name);
				if (variableDescriptor == null) {
					variableDescriptor = FunctionModelFactory.eINSTANCE.createVariableDescriptor();
					variableDescriptor.setFunctionDescriptor(functionDescriptor);
					variableDescriptor.setName(name);
					variableDescriptor.setKind(variableKind);
				}
				
				VariableStep variableStep = variableDescriptor.getStep(stepIndex, initial);
				if (variableStep == null) {
					variableStep = FunctionModelFactory.eINSTANCE.createVariableStep();
					variableStep.setDescriptor(variableDescriptor);
					variableStep.setIndex(stepIndex);
					variableStep.setInitial(initial);
				}
				part.setVariableStep(variableStep);
			}
			return true;
		}
		
		/**
		 * @param featureCall
		 * @param variableKind
		 */
		private void checkFeatureCall(VariableAccess variableAccess, VariableKind variableKind) {
			String message = null;
			switch (variableKind) {
			case INPUT_PARAMETER:
			case OUTPUT_PARAMETER:
			case STATE_VARIABLE:
				if (variableAccess.getStepExpression() != null
						&& !equationSide.getDescriptor().getFunctionDescriptor().getDefinition().isStateful()) {
					message = "Variable references of stateless functions must not specify step expressions";
				}
				break;
			}
			
			if (message != null) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, message, variableAccess));
			}
		}

		private VariableKind getVariableKind(FunctionDefinition functionDefinition, String name) {
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableKind.TEMPLATE_PARAMETER;
				}
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableKind.INPUT_PARAMETER;
				}
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getOutputParameterDeclarations()) {
				if (name.equals(parameterDeclaration.getName())) {
					return VariableKind.OUTPUT_PARAMETER;
				}
			}
			for (StateVariableDeclaration stateVariableDeclaration : functionDefinition.getStateVariableDeclarations()) {
				if (name.equals(stateVariableDeclaration.getName())) {
					return VariableKind.STATE_VARIABLE;
				}
			}
			return VariableKind.UNKNOWN;
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

	}

}
