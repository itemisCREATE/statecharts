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

package org.eclipselabs.mscript.language.imperativemodel.util;

import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeExpressionTarget {

	private VariableDeclaration variableDeclaration;
	private int stepIndex;
	
	/**
	 * 
	 */
	public ImperativeExpressionTarget(VariableDeclaration variableDeclaration, int stepIndex) {
		this.variableDeclaration = variableDeclaration;
		this.stepIndex = stepIndex;
	}
	
	/**
	 * @return the variableDeclaration
	 */
	public VariableDeclaration getVariableDeclaration() {
		return variableDeclaration;
	}
	
	/**
	 * @return the stepIndex
	 */
	public int getStepIndex() {
		return stepIndex;
	}
	
}
