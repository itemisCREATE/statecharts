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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class Functor implements IFunctor {

	private FunctionDescriptor functionDescriptor;
	private Map<String, IValue> templateArguments = new HashMap<String, IValue>();
	private Map<String, IVariable> variables = new HashMap<String, IVariable>();
	
	private boolean initialized;

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctor#getFunctionDefinition()
	 */
	public FunctionDescriptor getDescriptorFunction() {
		return functionDescriptor;
	}
	
	/**
	 * @param function the function to set
	 */
	public void setFunction(FunctionDescriptor functionDescriptor) {
		this.functionDescriptor = functionDescriptor;
	}
	
	public IValue getTemplateArgument(String name) {
		return templateArguments.get(name);
	}
	
	/**
	 * @param templateArguments the templateArguments to set
	 */
	public void setTemplateArguments(Map<String, IValue> templateArguments) {
		this.templateArguments = templateArguments;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctor#getVariables()
	 */
	public Collection<IVariable> getVariables() {
		return Collections.unmodifiableCollection(variables.values());
	}
	
	/**
	 * @return the variables
	 */
	public IVariable getVariable(String name) {
		return variables.get(name);
	}
	
	public void addVariable(IVariable variable) {
		variables.put(variable.getName(), variable);
	}
	
	/**
	 * @return the initialized
	 */
	public boolean isInitialized() {
		return initialized;
	}
	
	/**
	 * @param initialized the initialized to set
	 */
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	
}
