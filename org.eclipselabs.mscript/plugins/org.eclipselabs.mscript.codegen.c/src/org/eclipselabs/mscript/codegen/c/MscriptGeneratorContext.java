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

import java.io.Writer;

import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorContext implements IMscriptGeneratorContext {

	private IStaticEvaluationContext staticEvaluationContext;
	private ComputationModel computationModel;
	private Writer writer;
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IStaticEvaluationContext staticEvaluationContext, ComputationModel computationModel, Writer writer) {
		this.staticEvaluationContext = staticEvaluationContext;
		this.computationModel = computationModel;
		this.writer = writer;
	}
	
	/**
	 * @return the staticEvaluationContext
	 */
	public IStaticEvaluationContext getStaticEvaluationContext() {
		return staticEvaluationContext;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IGeneratorContext#getComputationModel()
	 */
	public ComputationModel getComputationModel() {
		return computationModel;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IGeneratorContext#getWriter()
	 */
	public Writer getWriter() {
		return writer;
	}

}
