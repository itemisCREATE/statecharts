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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class StaticEvaluationContext implements IStaticEvaluationContext {

	private final IComputationContext computationContext = new ComputationContext();
	
	private Map<Object, IValue> values = new HashMap<Object, IValue>();
	
	private Map<VariableAccess, Integer> stepIndices = new HashMap<VariableAccess, Integer>();
	
	private Map<FunctionDefinition, FunctionDescriptor> functionDescriptors = new HashMap<FunctionDefinition, FunctionDescriptor>();

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IEvaluationContext#getComputationContext()
	 */
	public IComputationContext getComputationContext() {
		return computationContext;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IEvaluationContext#getValue(java.lang.Object)
	 */
	public IValue getValue(Object key) {
		return values.get(key);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IEvaluationContext#setValue(java.lang.Object, org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	public void setValue(Object key, IValue value) {
		values.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#getStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	public int getStepIndex(VariableAccess variableAccess) {
		Integer stepIndex = stepIndices.get(variableAccess);
		if (stepIndex == null) {
			return 0;
		}
		return stepIndex;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#setStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess, int)
	 */
	public void setStepIndex(VariableAccess variableAccess, int stepIndex) {
		stepIndices.put(variableAccess, stepIndex);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#getFunctionDescriptor(org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	public FunctionDescriptor getFunctionDescriptor(FunctionDefinition functionDefinition) {
		return functionDescriptors.get(functionDefinition);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#setFunctionDescriptor(org.eclipselabs.mscript.language.ast.FunctionDefinition, org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor)
	 */
	public void setFunctionDescriptor(FunctionDefinition functionDefinition, FunctionDescriptor functionDescriptor) {
		functionDescriptors.put(functionDefinition, functionDescriptor);
	}
	
}
