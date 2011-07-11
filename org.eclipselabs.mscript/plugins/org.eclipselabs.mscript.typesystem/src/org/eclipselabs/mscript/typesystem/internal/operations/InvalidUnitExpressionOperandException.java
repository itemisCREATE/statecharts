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

package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipselabs.mscript.typesystem.UnitFactor;

/**
 * @author Andreas Unger
 *
 */
public class InvalidUnitExpressionOperandException extends Exception {

	private UnitFactor unitFactor;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidUnitExpressionOperandException(UnitFactor unitFactor) {
		this.unitFactor = unitFactor;
	}
	
	/**
	 * @return the unitExpressionFactor
	 */
	public UnitFactor getUnitExpressionFactor() {
		return unitFactor;
	}
	
}
