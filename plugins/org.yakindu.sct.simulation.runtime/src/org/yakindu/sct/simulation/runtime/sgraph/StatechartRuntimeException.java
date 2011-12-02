/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.sgraph;

public class StatechartRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StatechartRuntimeException() {
	}

	public StatechartRuntimeException(String message) {
		super(message);
	}

	public StatechartRuntimeException(Throwable cause) {
		super(cause);
	}

	public StatechartRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
