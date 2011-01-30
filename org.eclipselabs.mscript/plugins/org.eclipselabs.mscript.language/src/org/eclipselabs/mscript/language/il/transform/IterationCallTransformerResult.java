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
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class IterationCallTransformerResult implements IIterationCallTransformerResult {

	private LocalVariableDeclaration localVariableDeclaration;
	private IStatus status;
	
	public IterationCallTransformerResult(LocalVariableDeclaration localVariableDeclaration) {
		this(localVariableDeclaration, Status.OK_STATUS);
	}
	
	/**
	 * 
	 */
	public IterationCallTransformerResult(LocalVariableDeclaration localVariableDeclaration, IStatus status) {
		this.localVariableDeclaration = localVariableDeclaration;
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IIterationCallTransformerResult#getLocalVariableDeclaration()
	 */
	public LocalVariableDeclaration getLocalVariableDeclaration() {
		return localVariableDeclaration;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IIterationCallTransformerResult#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
}
