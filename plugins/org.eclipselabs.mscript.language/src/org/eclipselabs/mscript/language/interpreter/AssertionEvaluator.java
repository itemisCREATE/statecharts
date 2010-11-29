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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipselabs.mscript.language.ast.Assertion;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeExpressionTarget;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeExpressionTransformer;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeExpressionTransformer.Scope;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.util.EObjectDiagnostic;
import org.eclipselabs.mscript.language.interpreter.value.AnyValue;
import org.eclipselabs.mscript.language.interpreter.value.IBooleanValue;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.ValueFactory;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class AssertionEvaluator {

	public void evaluate(ImperativeFunction imperativeFunction, FunctionDescriptor functionDescriptor, List<DataType> templateParameterDataTypes, List<DataType> inputParameterDataTypes, DiagnosticChain diagnostics) {
		for (Assertion assertion : functionDescriptor.getDefinition().getAssertions()) {
			if (!assertion.isStatic()) {
				continue;
			}
			LocalVariableDeclaration assertResultVariableDeclaration = ImperativeModelFactory.eINSTANCE.createLocalVariableDeclaration();
			
			Compound compound = ImperativeModelFactory.eINSTANCE.createCompound();
			Scope scope = createScope(imperativeFunction, compound);
			scope.addVariableDeclaration(assertResultVariableDeclaration);
			ImperativeExpressionTarget target = new ImperativeExpressionTarget(assertResultVariableDeclaration, 0);
			new ImperativeExpressionTransformer(scope).transform(assertion.getCondition(), Collections.singletonList(target));
			if (!(assertResultVariableDeclaration.getType() instanceof BooleanType)) {
				diagnostics.add(new EObjectDiagnostic(Diagnostic.ERROR, "Assert condition must result to boolean type", assertion.getCondition()));
				continue;
			}
			
			IInterpreterContext context = new InterpreterContext(diagnostics, new ValueFactory());
			
			Iterator<DataType> dataTypeIterator = templateParameterDataTypes.iterator();
			for (TemplateVariableDeclaration templateVariableDeclaration : imperativeFunction.getTemplateVariableDeclarations()) {
				IValue value = new AnyValue(dataTypeIterator.next());
				IVariable variable = new Variable(templateVariableDeclaration);
				variable.setValue(0, value);
				context.addVariable(variable);
			}

			dataTypeIterator = inputParameterDataTypes.iterator();
			for (InputVariableDeclaration inputVariableDeclaration : imperativeFunction.getInputVariableDeclarations()) {
				IValue value = new AnyValue(dataTypeIterator.next());
				IVariable variable = new Variable(inputVariableDeclaration);
				variable.setValue(0, value);
				context.addVariable(variable);
			}
			
			IVariable outputVariable = new Variable(assertResultVariableDeclaration);
			context.addVariable(outputVariable);
			
			new CompoundInterpreter(context).doSwitch(compound);
			IBooleanValue outputValue = (IBooleanValue) outputVariable.getValue(0);
			
			if (!outputValue.booleanValue()) {
				Expression message = assertion.getMessage();
				if (message instanceof StringLiteral) {
					StringLiteral stringMessage = (StringLiteral) message;
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, LanguagePlugin.PLUGIN_ID, 0, stringMessage.getValue(), new Object[] {}));
				}
			}
		}
	}

	protected Scope createScope(ImperativeFunction imperativeFunction, Compound compound) {
		Scope scope = new Scope(null, compound);
		for (TemplateVariableDeclaration templateVariableDeclaration : imperativeFunction.getTemplateVariableDeclarations()) {
			scope.addVariableDeclaration(templateVariableDeclaration);
		}
		for (InputVariableDeclaration inputVariableDeclaration : imperativeFunction.getInputVariableDeclarations()) {
			scope.addVariableDeclaration(inputVariableDeclaration);
		}
		return scope;
	}

}
