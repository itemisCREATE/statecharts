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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableKind;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ConstantDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.internal.util.EquationCompoundHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeFunctionConstructor {
	
	public ImperativeFunction construct(Function function) {
		ImperativeFunction imperativeFunction = ImperativeModelFactory.eINSTANCE.createImperativeFunction();

		Map<VariableDescriptor, VariableDeclaration> variableDeclarations = new HashMap<VariableDescriptor, VariableDeclaration>();
		
		initializeVariableDeclarations(imperativeFunction, function, variableDeclarations);

		Collection<List<EquationDescriptor>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(function);

		constructInitializationCompound(imperativeFunction, equationCompounds, variableDeclarations);
		constructComputationCompounds(imperativeFunction, equationCompounds, variableDeclarations);
		
		return imperativeFunction;
	}
	
	private void initializeVariableDeclarations(ImperativeFunction imperativeFunction, Function function, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		for (VariableDescriptor variableDescriptor : function.getVariableDescriptors()) {
			switch (variableDescriptor.getKind()) {
			case TEMPLATE_PARAMETER:
				initializeConstantDeclaration(imperativeFunction, variableDescriptor, variableDeclarations);
				break;
			case INPUT_PARAMETER:
				initializeInputVariableDeclaration(imperativeFunction, variableDescriptor, variableDeclarations);
				break;
			case OUTPUT_PARAMETER:
				initializeOutputVariableDeclaration(imperativeFunction, variableDescriptor, variableDeclarations);
				break;
			case STATE_VARIABLE:
				initializeInstanceVariableDeclaration(imperativeFunction, variableDescriptor, variableDeclarations);
				break;
			}
		}
	}
	
	private void initializeConstantDeclaration(ImperativeFunction imperativeFunction, VariableDescriptor variableDescriptor, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		ConstantDeclaration constantDeclaration = ImperativeModelFactory.eINSTANCE.createConstantDeclaration();
		constantDeclaration.setName(variableDescriptor.getName());
		imperativeFunction.getConstantDeclarations().add(constantDeclaration);
		variableDeclarations.put(variableDescriptor, constantDeclaration);
	}
	
	private void initializeInputVariableDeclaration(ImperativeFunction imperativeFunction, VariableDescriptor variableDescriptor, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		InputVariableDeclaration inputVariableDeclaration = ImperativeModelFactory.eINSTANCE.createInputVariableDeclaration();
		inputVariableDeclaration.setName(variableDescriptor.getName());
		inputVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
		variableDeclarations.put(variableDescriptor, inputVariableDeclaration);
	}
	
	private void initializeOutputVariableDeclaration(ImperativeFunction imperativeFunction, VariableDescriptor variableDescriptor, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		OutputVariableDeclaration outputVariableDeclaration = ImperativeModelFactory.eINSTANCE.createOutputVariableDeclaration();
		outputVariableDeclaration.setName(variableDescriptor.getName());
		outputVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
		variableDeclarations.put(variableDescriptor, outputVariableDeclaration);
	}

	private void initializeInstanceVariableDeclaration(ImperativeFunction imperativeFunction, VariableDescriptor variableDescriptor, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		InstanceVariableDeclaration instanceVariableDeclaration = ImperativeModelFactory.eINSTANCE.createInstanceVariableDeclaration();
		instanceVariableDeclaration.setName(variableDescriptor.getName());
		instanceVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
		variableDeclarations.put(variableDescriptor, instanceVariableDeclaration);
	}

	private void constructInitializationCompound(ImperativeFunction imperativeFunction, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		Compound compound = ImperativeModelFactory.eINSTANCE.createCompound();
		for (Iterator<List<EquationDescriptor>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescriptor> equationDescriptors = it.next();
			boolean processed = false;
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					Assignment assignment = ImperativeModelFactory.eINSTANCE.createAssignment();
					assignment.setTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()));
					assignment.setStepIndex(lhsVariableStep.getIndex());
					assignment.setAssignedExpression(equationDescriptor.getRightHandSide().getExpression());
					compound.getStatements().add(assignment);
					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		imperativeFunction.setInitializationCompound(compound);
	}
	
	private void constructComputationCompounds(ImperativeFunction imperativeFunction, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			ComputationCompound compound = ImperativeModelFactory.eINSTANCE.createComputationCompound();
			Set<InputVariableDeclaration> inputs = new HashSet<InputVariableDeclaration>();
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null) {
					Assignment assignment = ImperativeModelFactory.eINSTANCE.createAssignment();
					assignment.setTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()));
					assignment.setStepIndex(lhsVariableStep.getIndex());
					assignment.setAssignedExpression(equationDescriptor.getRightHandSide().getExpression());
					compound.getStatements().add(assignment);

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
			imperativeFunction.getComputationCompounds().add(compound);
		}
	}
	
}
