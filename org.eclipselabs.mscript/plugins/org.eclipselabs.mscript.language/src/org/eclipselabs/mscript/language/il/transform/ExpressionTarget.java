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

import org.eclipselabs.mscript.language.il.VariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTarget implements IExpressionTarget {

	private VariableDeclaration variableDeclaration;
	private int stepIndex;
	
	/**
	 * 
	 */
	public ExpressionTarget(VariableDeclaration variableDeclaration, int stepIndex) {
		this.variableDeclaration = variableDeclaration;
		this.stepIndex = stepIndex;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTarget#getVariableDeclaration()
	 */
	public VariableDeclaration getVariableDeclaration() {
		return variableDeclaration;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTarget#getStepIndex()
	 */
	public int getStepIndex() {
		return stepIndex;
	}
	
}
