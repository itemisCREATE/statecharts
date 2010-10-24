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

package org.eclipselabs.mscript.language.internal.functionmodel.util;

/**
 * @author Andreas Unger
 *
 */
public class StepExpressionResult {

	private int step;
	private boolean absolute;
	
	/**
	 * 
	 */
	public StepExpressionResult(int step, boolean absolute) {
		this.step = step;
		this.absolute = absolute;
	}
	
	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}
	
	/**
	 * @return the absolute
	 */
	public boolean isAbsolute() {
		return absolute;
	}
	
}
