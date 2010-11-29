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

package org.eclipselabs.mscript.language.imperativemodel.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableKind;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionDefinition;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.internal.util.EquationCompoundHelper;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeExpressionTransformer.Scope;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil;
import org.eclipselabs.mscript.language.interpreter.AssertionEvaluator;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeFunctionTransformer {
	
	public ImperativeFunctionDefinition transform(FunctionDescriptor functionDescriptor, List<DataType> templateParameterDataTypes, List<DataType> inputParameterDataTypes, DiagnosticChain diagnostics) {
		ImperativeFunctionDefinition imperativeFunctionDefinition = ImperativeModelFactory.eINSTANCE.createImperativeFunctionDefinition();
		
		Map<VariableDescriptor, VariableDeclaration> variableDeclarations = new HashMap<VariableDescriptor, VariableDeclaration>();
		
		initializeVariableDeclarations(imperativeFunctionDefinition, functionDescriptor, templateParameterDataTypes, inputParameterDataTypes, variableDeclarations);
		new AssertionEvaluator().evaluate(imperativeFunctionDefinition, functionDescriptor, templateParameterDataTypes, inputParameterDataTypes, diagnostics);

		Collection<List<EquationDescriptor>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(functionDescriptor);
		constructInitializationCompound(imperativeFunctionDefinition, equationCompounds, variableDeclarations);
		constructComputationCompounds(imperativeFunctionDefinition, equationCompounds, variableDeclarations);
		
		return imperativeFunctionDefinition;
	}
	
	private void initializeVariableDeclarations(ImperativeFunctionDefinition imperativeFunctionDefinition, FunctionDescriptor functionDescriptor, List<DataType> templateParameterDataTypes, List<DataType> inputParameterDataTypes, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		Iterator<DataType> dataTypeIterator = templateParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getTemplateParameterDeclarations()) {
			TemplateVariableDeclaration templateVariableDeclaration = ImperativeModelFactory.eINSTANCE.createTemplateVariableDeclaration();
			templateVariableDeclaration.setName(parameterDeclaration.getName());
			if (dataTypeIterator.hasNext()) {
				templateVariableDeclaration.setType(EcoreUtil.copy(dataTypeIterator.next()));
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				variableDeclarations.put(variableDescriptor, templateVariableDeclaration);
			}
			imperativeFunctionDefinition.getTemplateVariableDeclarations().add(templateVariableDeclaration);
		}

		dataTypeIterator = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getInputParameterDeclarations()) {
			InputVariableDeclaration inputVariableDeclaration = ImperativeModelFactory.eINSTANCE.createInputVariableDeclaration();
			inputVariableDeclaration.setName(parameterDeclaration.getName());
			if (dataTypeIterator.hasNext()) {
				inputVariableDeclaration.setType(EcoreUtil.copy(dataTypeIterator.next()));
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				inputVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				variableDeclarations.put(variableDescriptor, inputVariableDeclaration);
			}
			imperativeFunctionDefinition.getInputVariableDeclarations().add(inputVariableDeclaration);
		}
		
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getOutputParameterDeclarations()) {
			OutputVariableDeclaration outputVariableDeclaration = ImperativeModelFactory.eINSTANCE.createOutputVariableDeclaration();
			outputVariableDeclaration.setName(parameterDeclaration.getName());
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				outputVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				variableDeclarations.put(variableDescriptor, outputVariableDeclaration);
			}
			imperativeFunctionDefinition.getOutputVariableDeclarations().add(outputVariableDeclaration);
		}

		for (StateVariableDeclaration stateVariableDeclaration : functionDescriptor.getDefinition().getStateVariableDeclarations()) {
			InstanceVariableDeclaration instanceVariableDeclaration = ImperativeModelFactory.eINSTANCE.createInstanceVariableDeclaration();
			instanceVariableDeclaration.setName(stateVariableDeclaration.getName());
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(stateVariableDeclaration.getName());
			if (variableDescriptor != null) {
				instanceVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				variableDeclarations.put(variableDescriptor, instanceVariableDeclaration);
			}
			imperativeFunctionDefinition.getInstanceVariableDeclarations().add(instanceVariableDeclaration);
		}
	}
	
	private void constructInitializationCompound(ImperativeFunctionDefinition imperativeFunctionDefinition, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		Compound compound = ImperativeModelFactory.eINSTANCE.createCompound();
		for (Iterator<List<EquationDescriptor>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescriptor> equationDescriptors = it.next();
			boolean processed = false;
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					ImperativeExpressionTarget target = new ImperativeExpressionTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					Scope scope = createScope(imperativeFunctionDefinition, compound);
					ImperativeExpressionTransformer transformer = new ImperativeExpressionTransformer(scope);
					transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target));
					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		imperativeFunctionDefinition.setInitializationCompound(compound);
	}
	
	private void constructComputationCompounds(ImperativeFunctionDefinition imperativeFunctionDefinition, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			ComputationCompound compound = ImperativeModelFactory.eINSTANCE.createComputationCompound();
			Set<InputVariableDeclaration> inputs = new HashSet<InputVariableDeclaration>();
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null) {
					ImperativeExpressionTarget target = new ImperativeExpressionTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					Scope scope = createScope(imperativeFunctionDefinition, compound);
					ImperativeExpressionTransformer transformer = new ImperativeExpressionTransformer(scope);
					transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target));

					for (EquationPart equationPart : equationDescriptor.getRightHandSide().getParts()) {
						VariableStep rhsVariableStep = equationPart.getVariableStep();
						if (rhsVariableStep.getDescriptor().getKind() == VariableKind.INPUT_PARAMETER
								&& rhsVariableStep.getIndex() == 0) {
							inputs.add((InputVariableDeclaration) variableDeclarations.get(rhsVariableStep.getDescriptor()));
						}
					}

					if (lhsVariableStep.getDescriptor().getKind() == VariableKind.OUTPUT_PARAMETER
							&& lhsVariableStep.getIndex() == 0) {
						compound.getOutputs().add((OutputVariableDeclaration) variableDeclarations.get(lhsVariableStep.getDescriptor()));
					}
				}
			}
			for (InputVariableDeclaration input : inputs) {
				compound.getInputs().add(input);
			}
			imperativeFunctionDefinition.getComputationCompounds().add(compound);
		}
	}
	
	protected Scope createScope(ImperativeFunctionDefinition imperativeFunctionDefinition, Compound compound) {
		Scope scope = new Scope(null, compound);
		for (TemplateVariableDeclaration templateVariableDeclaration : imperativeFunctionDefinition.getTemplateVariableDeclarations()) {
			scope.addVariableDeclaration(templateVariableDeclaration);
		}
		for (InputVariableDeclaration inputVariableDeclaration : imperativeFunctionDefinition.getInputVariableDeclarations()) {
			scope.addVariableDeclaration(inputVariableDeclaration);
		}
		for (OutputVariableDeclaration outputVariableDeclaration : imperativeFunctionDefinition.getOutputVariableDeclarations()) {
			scope.addVariableDeclaration(outputVariableDeclaration);
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration : imperativeFunctionDefinition.getInstanceVariableDeclarations()) {
			scope.addVariableDeclaration(instanceVariableDeclaration);
		}
		return scope;
	}
	
}
