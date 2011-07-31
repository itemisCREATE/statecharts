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

package org.eclipselabs.mscript.language.il.transform;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformerContext extends TransformerContext implements IFunctionDefinitionTransformerContext {

	private ILFunctionDefinition functionDefinition;
	
	private Map<String, VariableDeclaration> cachedVariableDeclarations;
	
	/**
	 * 
	 */
	public FunctionDefinitionTransformerContext(IStaticEvaluationContext staticEvaluationContext, ILFunctionDefinition functionDefinition) {
		super(staticEvaluationContext);
		this.functionDefinition = functionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerContext#getFunctionDefinition()
	 */
	public ILFunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.TransformerContext#getVariableDeclaration(java.lang.String)
	 */
	@Override
	public VariableDeclaration getVariableDeclaration(String name) {
		VariableDeclaration variableDeclaration = super.getVariableDeclaration(name);
		if (variableDeclaration == null) {
			variableDeclaration = getFunctionDefinitionVariableDeclaration(name);
		}
		return variableDeclaration;
	}
	
	protected VariableDeclaration getFunctionDefinitionVariableDeclaration(String name) {
		if (cachedVariableDeclarations == null) {
			cachedVariableDeclarations = new HashMap<String, VariableDeclaration>();
			for (TemplateVariableDeclaration templateVariableDeclaration : functionDefinition.getTemplateVariableDeclarations()) {
				cachedVariableDeclarations.put(templateVariableDeclaration.getName(), templateVariableDeclaration);
			}
			for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
				cachedVariableDeclarations.put(inputVariableDeclaration.getName(), inputVariableDeclaration);
			}
			for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
				cachedVariableDeclarations.put(outputVariableDeclaration.getName(), outputVariableDeclaration);
			}
			for (InstanceVariableDeclaration instanceVariableDeclaration : functionDefinition.getInstanceVariableDeclarations()) {
				cachedVariableDeclarations.put(instanceVariableDeclaration.getName(), instanceVariableDeclaration);
			}
		}
		return cachedVariableDeclarations.get(name);
	}
	
}
