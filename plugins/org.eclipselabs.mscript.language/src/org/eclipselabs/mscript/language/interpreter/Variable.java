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

import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.UninitializedValue;

/**
 * @author Andreas Unger
 *
 */
public class Variable implements IVariable {

	private String name;
	private IValue value = new UninitializedValue();
	
	/**
	 * 
	 */
	public Variable() {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#getValue()
	 */
	public IValue getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#setValue(org.eclipselabs.mscript.execution.value.IValue)
	 */
	public void setValue(IValue value) {
		this.value = value;
	}

}
