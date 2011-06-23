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

package org.eclipselabs.mscript.computation.core.value;

/**
 * @author Andreas Unger
 *
 */
public interface IArrayValue {

	IValue get(int index);
	
	IValue get(int rowIndex, int columnIndex);

	IValue get(int... indices);
	
	void set(int index, IValue value);

	void set(int rowIndex, int columnIndex, IValue value);
	
	void set(int[] indices, IValue value);

}
