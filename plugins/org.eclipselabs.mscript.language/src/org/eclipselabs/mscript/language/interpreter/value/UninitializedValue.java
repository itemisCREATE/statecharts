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

package org.eclipselabs.mscript.language.interpreter.value;

import org.eclipselabs.mscript.typesystem.DataType;


/**
 * @author Andreas Unger
 *
 */
public class UninitializedValue extends AbstractValue {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#getDataType()
	 */
	public DataType getDataType() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return this;
	}
	
}
