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

package org.eclipselabs.mscript.language.internal.interpreter;

import org.eclipselabs.mscript.language.ast.UnitExpressionFactor;

/**
 * @author Andreas Unger
 *
 */
public class InvalidUnitExpressionOperandException extends Exception {

	private UnitExpressionFactor unitExpressionFactor;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidUnitExpressionOperandException(UnitExpressionFactor unitExpressionFactor) {
		this.unitExpressionFactor = unitExpressionFactor;
	}
	
	/**
	 * @return the unitExpressionFactor
	 */
	public UnitExpressionFactor getUnitExpressionFactor() {
		return unitExpressionFactor;
	}
	
}
