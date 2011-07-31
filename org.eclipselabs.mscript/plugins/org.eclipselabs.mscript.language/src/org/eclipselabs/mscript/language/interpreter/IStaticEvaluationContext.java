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

import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public interface IStaticEvaluationContext {

	IComputationContext getComputationContext();
	
	IValue getValue(Object key);
	void setValue(Object key, IValue value);
	
	int getStepIndex(VariableAccess variableAccess);
	void setStepIndex(VariableAccess variableAccess, int stepIndex);
	
	FunctionDescriptor getFunctionDescriptor(FunctionDefinition functionDefinition);
	void setFunctionDescriptor(FunctionDefinition functionDefinition, FunctionDescriptor functionDescriptor);

}
