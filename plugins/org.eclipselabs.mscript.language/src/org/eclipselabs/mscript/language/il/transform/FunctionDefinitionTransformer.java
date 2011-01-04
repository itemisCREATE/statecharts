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

package org.eclipselabs.mscript.language.il.transform;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableKind;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.internal.util.EquationCompoundHelper;
import org.eclipselabs.mscript.language.il.util.DataTypeAdaptor;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;
import org.eclipselabs.mscript.language.interpreter.AssertionEvaluator;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformer {
	
	public IFunctionDefinitionTransformerResult transform(FunctionDescriptor functionDescriptor, String functionName, List<IValue> templateArguments, List<DataType> inputParameterDataTypes) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Function definition transformation errors", null);

		ILFunctionDefinition ilFunctionDefinition = ILFactory.eINSTANCE.createILFunctionDefinition();
		ilFunctionDefinition.setStateful(functionDescriptor.getDefinition().isStateful());
		ilFunctionDefinition.setName(functionName != null ? functionName : functionDescriptor.getDefinition().getName());
		
		Map<VariableDescriptor, VariableDeclaration> variableDeclarations = new HashMap<VariableDescriptor, VariableDeclaration>();
		
		initializeVariableDeclarations(ilFunctionDefinition, functionDescriptor, templateArguments, inputParameterDataTypes, variableDeclarations);
		StatusUtil.merge(status, new AssertionEvaluator().evaluate(ilFunctionDefinition, functionDescriptor));

		Collection<List<EquationDescriptor>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(functionDescriptor);
		
		FunctionDefinitionTransformerContext context = new FunctionDefinitionTransformerContext(ilFunctionDefinition);
		StatusUtil.merge(status, constructInitializationCompound(context, equationCompounds, variableDeclarations));
		StatusUtil.merge(status, constructComputationCompounds(context, equationCompounds, variableDeclarations));
		
		if (!status.isOK()) {
			return new FunctionDefinitionTransformerResult(ilFunctionDefinition, status);
		}
		
		StatusUtil.merge(status, new DataTypeAdaptor().adapt(ilFunctionDefinition));
		
		if (!status.isOK()) {
			return new FunctionDefinitionTransformerResult(ilFunctionDefinition, status);
		}

		return new FunctionDefinitionTransformerResult(ilFunctionDefinition);
	}
	
	private void initializeVariableDeclarations(ILFunctionDefinition ilFunctionDefinition, FunctionDescriptor functionDescriptor, List<IValue> templateArguments, List<DataType> inputParameterDataTypes, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		Iterator<IValue> templateArgumentIterator = templateArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getTemplateParameterDeclarations()) {
			TemplateVariableDeclaration templateVariableDeclaration = ILFactory.eINSTANCE.createTemplateVariableDeclaration();
			templateVariableDeclaration.setName(parameterDeclaration.getName());
			if (templateArgumentIterator.hasNext()) {
				IValue value = templateArgumentIterator.next();
				templateVariableDeclaration.setType(EcoreUtil.copy(value.getDataType()));
				templateVariableDeclaration.setValue(value);
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				variableDeclarations.put(variableDescriptor, templateVariableDeclaration);
			}
			ilFunctionDefinition.getTemplateVariableDeclarations().add(templateVariableDeclaration);
		}

		Iterator<DataType> inputParameterDataTypesIterator = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getInputParameterDeclarations()) {
			InputVariableDeclaration inputVariableDeclaration = ILFactory.eINSTANCE.createInputVariableDeclaration();
			inputVariableDeclaration.setName(parameterDeclaration.getName());
			if (inputParameterDataTypesIterator.hasNext()) {
				inputVariableDeclaration.setType(EcoreUtil.copy(inputParameterDataTypesIterator.next()));
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				inputVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				variableDeclarations.put(variableDescriptor, inputVariableDeclaration);
			}
			ilFunctionDefinition.getInputVariableDeclarations().add(inputVariableDeclaration);
		}
		
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getOutputParameterDeclarations()) {
			OutputVariableDeclaration outputVariableDeclaration = ILFactory.eINSTANCE.createOutputVariableDeclaration();
			outputVariableDeclaration.setName(parameterDeclaration.getName());
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				outputVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				variableDeclarations.put(variableDescriptor, outputVariableDeclaration);
			}
			ilFunctionDefinition.getOutputVariableDeclarations().add(outputVariableDeclaration);
		}

		for (StateVariableDeclaration stateVariableDeclaration : functionDescriptor.getDefinition().getStateVariableDeclarations()) {
			InstanceVariableDeclaration instanceVariableDeclaration = ILFactory.eINSTANCE.createInstanceVariableDeclaration();
			instanceVariableDeclaration.setName(stateVariableDeclaration.getName());
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(stateVariableDeclaration.getName());
			if (variableDescriptor != null) {
				instanceVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				variableDeclarations.put(variableDescriptor, instanceVariableDeclaration);
			}
			ilFunctionDefinition.getInstanceVariableDeclarations().add(instanceVariableDeclaration);
		}
	}
	
	private IStatus constructInitializationCompound(FunctionDefinitionTransformerContext context, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Initialization compound construction errors", null);
		
		Compound compound = ILFactory.eINSTANCE.createCompound();
		for (Iterator<List<EquationDescriptor>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescriptor> equationDescriptors = it.next();
			boolean processed = false;
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					context.enterScope();
					context.setCompound(compound);

					ExpressionTransformer transformer = new ExpressionTransformer(context);
					ExpressionTarget target = new ExpressionTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target)));
					
					context.leaveScope();

					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		context.getFunctionDefinition().setInitializationCompound(compound);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	private IStatus constructComputationCompounds(FunctionDefinitionTransformerContext context, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Computation compound construction errors", null);

		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			ComputationCompound compound = ILFactory.eINSTANCE.createComputationCompound();
			Set<InputVariableDeclaration> inputs = new HashSet<InputVariableDeclaration>();
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null) {
					context.enterScope();
					context.setCompound(compound);
					
					ExpressionTransformer transformer = new ExpressionTransformer(context);
					ExpressionTarget target = new ExpressionTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target)));

					context.leaveScope();

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
			context.getFunctionDefinition().getComputationCompounds().add(compound);
		}

		return status.isOK() ? Status.OK_STATUS : status;
	}
	
}
