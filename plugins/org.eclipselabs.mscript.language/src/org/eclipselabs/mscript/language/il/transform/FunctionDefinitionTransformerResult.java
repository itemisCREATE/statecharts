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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformerResult implements IFunctionDefinitionTransformerResult {

	private ILFunctionDefinition ilFunctionDefinition;
	private IStatus status;
	
	public FunctionDefinitionTransformerResult(ILFunctionDefinition ilFunctionDefinition) {
		this(ilFunctionDefinition, Status.OK_STATUS);
	}
	
	/**
	 * 
	 */
	public FunctionDefinitionTransformerResult(ILFunctionDefinition ilFunctionDefinition, IStatus status) {
		this.ilFunctionDefinition = ilFunctionDefinition;
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult#getILFunctionDefinition()
	 */
	public ILFunctionDefinition getILFunctionDefinition() {
		return ilFunctionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
}
