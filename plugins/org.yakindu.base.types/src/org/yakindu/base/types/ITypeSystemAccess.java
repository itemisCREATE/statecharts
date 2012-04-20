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
package org.yakindu.base.types;

import com.google.inject.ImplementedBy;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(org.yakindu.base.types.impl.BaseTypeSystemAccessImpl.class)
public interface ITypeSystemAccess {

	/** true, if this type represents a boolean */
	boolean isBoolean(Type type);

	/** true, if this type represents an integer */
	boolean isInteger(Type type);

	/** true, if this type represents a real */
	boolean isReal(Type type);

	/** true, if this type represents a string */
	boolean isString(Type type);

	/** true, if this type represents void */
	boolean isVoid(Type type);

	boolean isAssignable(Type expected, Type actual);

	Type combine(Type typeOne, Type typeTwo);

	public Type getString();

	public Type getReal();

	public Type getInteger();

	public Type getBoolean();

}
