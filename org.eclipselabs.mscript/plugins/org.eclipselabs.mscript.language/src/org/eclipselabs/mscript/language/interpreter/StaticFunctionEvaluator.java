/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.mscript.computation.core.value.AnyValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.InvalidValue;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class StaticFunctionEvaluator {

	public IStatus evaluate(IStaticEvaluationContext context, FunctionDescriptor functionDescriptor) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Evaluation result", null);
		StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
		for (EquationDescriptor equationDescriptor : functionDescriptor.getEquationDescriptors()) {
			StatusUtil.merge(status, staticExpressionEvaluator.evaluate(context, equationDescriptor.getRightHandSide().getExpression()));
			VariableAccess variableAccess = (VariableAccess) equationDescriptor.getLeftHandSide().getExpression();
			IValue leftHandSideValue = context.getValue(variableAccess.getFeature());
			IValue rightHandSideValue = context.getValue(equationDescriptor.getRightHandSide().getExpression());
			if (!(leftHandSideValue instanceof InvalidValue) && !(rightHandSideValue instanceof InvalidValue)) {
				DataType dataType;
				if (leftHandSideValue != null) {
					dataType = TypeSystemUtil.getLeftHandDataType(leftHandSideValue.getDataType(), rightHandSideValue.getDataType());
				} else {
					dataType = rightHandSideValue.getDataType();
				}
				if (dataType != null) {
					AnyValue value = new AnyValue(context.getComputationContext(), dataType);
					context.setValue(variableAccess, value);
					context.setValue(variableAccess.getFeature(), value);
				} else {
					status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0,
							"The data type of the variable " + variableAccess.getFeature().getName()
									+ " could not be determined",
							variableAccess.getFeature()));
				}
			}
		}
		return status;
	}
	
}
