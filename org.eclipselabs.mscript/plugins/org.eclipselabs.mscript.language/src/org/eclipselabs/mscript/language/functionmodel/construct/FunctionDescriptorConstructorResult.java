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

package org.eclipselabs.mscript.language.functionmodel.construct;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDescriptorConstructorResult implements IFunctionDescriptorConstructorResult {

	private FunctionDescriptor functionDescriptor;
	private IStatus status;
	
	/**
	 * 
	 */
	public FunctionDescriptorConstructorResult(FunctionDescriptor functionDescriptor) {
		this(functionDescriptor, Status.OK_STATUS);
	}

	/**
	 * 
	 */
	public FunctionDescriptorConstructorResult(FunctionDescriptor functionDescriptor, IStatus status) {
		this.functionDescriptor = functionDescriptor;
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult#getFunctionDescriptor()
	 */
	public FunctionDescriptor getFunctionDescriptor() {
		return functionDescriptor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
}
