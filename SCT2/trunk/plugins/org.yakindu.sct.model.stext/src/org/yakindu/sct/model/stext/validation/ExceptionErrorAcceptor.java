/**
 * Copyright (c) 2012 itemis AG and others.
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
 * Converts the reported type check error to a unchecked exception
 * 
 * @author muelder
 * 
 */
public class ExceptionErrorAcceptor implements ITypeCheckErrorAcceptor {

	public void acceptError(String msg) {
		throw new TypeCheckException(msg);
	}

}
