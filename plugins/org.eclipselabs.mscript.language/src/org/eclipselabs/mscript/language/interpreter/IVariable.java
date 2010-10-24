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

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IVariable {

	String getName();
	void setName(String name);
	
	void ensureValueIndex(int step);

	IValue getValue(int step);
	void setValue(int step, IValue value);
	
	void incrementStep();
	
}
