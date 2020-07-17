/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.interpreter.base;

/**
 * 
 * @author axel terfloth
 */
public class InterpreterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9074079205558144459L;

	public InterpreterException() {
		super();
	}

	public InterpreterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InterpreterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InterpreterException(String message) {
		super(message);
	}

	public InterpreterException(Throwable cause) {
		super(cause);
	}

	
}
