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

package org.eclipselabs.damos.mscript.ide.core.launch;

import java.util.EventObject;

import org.eclipse.core.runtime.IStatus;

/**
 * @author Andreas Unger
 *
 */
public class MscriptExecutionEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IStatus status;

	/**
	 * @param source
	 */
	public MscriptExecutionEvent(Object source, IStatus status) {
		super(source);
		this.status = status;
	}
	
	/**
	 * @return the status
	 */
	public IStatus getStatus() {
		return status;
	}

}
