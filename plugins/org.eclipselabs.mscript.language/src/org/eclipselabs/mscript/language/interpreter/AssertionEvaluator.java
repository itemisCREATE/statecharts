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

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.AnyValue;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.Assertion;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.ExpressionTarget;
import org.eclipselabs.mscript.language.il.transform.ExpressionTransformer;
import org.eclipselabs.mscript.language.il.transform.ExpressionTransformerContext;
import org.eclipselabs.mscript.language.il.transform.IExpressionTransformerContext;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.BooleanType;

/**
 * @author Andreas Unger
 *
 */
public class AssertionEvaluator {

	public IStatus evaluate(ILFunctionDefinition functionDefinition, FunctionDescriptor functionDescriptor) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Assertion failed", null);
		
		for (Assertion assertion : functionDescriptor.getDefinition().getAssertions()) {
			if (!assertion.isStatic()) {
				continue;
			}
			LocalVariableDeclaration assertResultVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
			
			Compound compound = ILFactory.eINSTANCE.createCompound();

			IExpressionTransformerContext expressionTransformerContext = new ExpressionTransformerContext();
			initializeContext(expressionTransformerContext, functionDefinition, compound);
			expressionTransformerContext.getScope().add(assertResultVariableDeclaration);
			
			ExpressionTarget target = new ExpressionTarget(assertResultVariableDeclaration, 0);
			
			IStatus transformationStatus = new ExpressionTransformer(expressionTransformerContext).transform(assertion.getCondition(), Collections.singletonList(target));
			
			if (!transformationStatus.isOK()) {
				StatusUtil.merge(status, transformationStatus);
				continue;
			}
			
			if (!(assertResultVariableDeclaration.getType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Assert condition must result to boolean type", assertion.getCondition()));
				continue;
			}
			
			IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());
			
			for (TemplateVariableDeclaration templateVariableDeclaration : functionDefinition.getTemplateVariableDeclarations()) {
				IValue value = templateVariableDeclaration.getValue();
				IVariable variable = new Variable(templateVariableDeclaration);
				variable.setValue(0, value);
				interpreterContext.getScope().add(variable);
			}

			for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
				IValue value = new AnyValue(interpreterContext.getComputationContext(), inputVariableDeclaration.getType());
				IVariable variable = new Variable(inputVariableDeclaration);
				variable.setValue(0, value);
				interpreterContext.getScope().add(variable);
			}
			
			IVariable outputVariable = new Variable(assertResultVariableDeclaration);
			interpreterContext.getScope().add(outputVariable);
			
			new CompoundInterpreter(interpreterContext).doSwitch(compound);
			IBooleanValue outputValue = (IBooleanValue) outputVariable.getValue(0);
			
			if (!outputValue.booleanValue()) {
				Expression message = assertion.getMessage();
				if (message instanceof StringLiteral) {
					StringLiteral stringMessage = (StringLiteral) message;
					status.add(new Status(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, stringMessage.getValue()));
				}
			}
		}
		
		return status.isOK() ? Status.OK_STATUS : status;
	}

	protected void initializeContext(IExpressionTransformerContext context, ILFunctionDefinition ilFunctionDefinition, Compound compound) {
		context.getScope().setCompound(compound);
		for (TemplateVariableDeclaration templateVariableDeclaration : ilFunctionDefinition.getTemplateVariableDeclarations()) {
			context.getScope().add(templateVariableDeclaration);
		}
		for (InputVariableDeclaration inputVariableDeclaration : ilFunctionDefinition.getInputVariableDeclarations()) {
			context.getScope().add(inputVariableDeclaration);
		}
	}

}
