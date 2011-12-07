/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.validation;

/**
 * checked Exception thrown by the {@link StaticTypeAnalyzer} if a type
 * conformance check fails.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TypeCheckException extends Exception {

	private static final long serialVersionUID = 1L;

	public TypeCheckException(String cause) {
		super(cause);
	}
}
