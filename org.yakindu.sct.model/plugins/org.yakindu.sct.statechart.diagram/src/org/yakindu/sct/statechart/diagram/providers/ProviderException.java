/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.providers;

/**
 * {@link RuntimeException}, thrown by the different Provider Implementations.
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class ProviderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProviderException() {
	}

	public ProviderException(String cause) {
		super(cause);
	}

	public ProviderException(Throwable t) {
		super(t);
	}
}
