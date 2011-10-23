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

package org.eclipselabs.mscript.codegen.c;

import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.mscript.codegen.c.internal.DefaultVariableAccessStrategy;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorContext implements IMscriptGeneratorContext {

	private Appendable appendable;
	private ComputationModel computationModel;
	private IStaticEvaluationContext staticEvaluationContext;
	private IVariableAccessStrategy variableAccessStrategy;
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(Appendable appendable, ComputationModel computationModel, IStaticEvaluationContext staticEvaluationContext) {
		this(appendable, computationModel, staticEvaluationContext, new DefaultVariableAccessStrategy());
	}
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(Appendable appendable, ComputationModel computationModel, IStaticEvaluationContext staticEvaluationContext, IVariableAccessStrategy variableAccessStrategy) {
		this.appendable = appendable;
		this.computationModel = computationModel;
		this.staticEvaluationContext = staticEvaluationContext;
		this.variableAccessStrategy = variableAccessStrategy;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IGeneratorContext#getWriter()
	 */
	public Appendable getAppendable() {
		return appendable;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IGeneratorContext#getComputationModel()
	 */
	public ComputationModel getComputationModel() {
		return computationModel;
	}

	/**
	 * @return the staticEvaluationContext
	 */
	public IStaticEvaluationContext getStaticEvaluationContext() {
		return staticEvaluationContext;
	}

	/**
	 * @return the variableAccessStrategy
	 */
	public IVariableAccessStrategy getVariableAccessStrategy() {
		return variableAccessStrategy;
	}

}
