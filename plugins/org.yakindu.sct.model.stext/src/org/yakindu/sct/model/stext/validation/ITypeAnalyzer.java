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

import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;

import com.google.inject.ImplementedBy;

@ImplementedBy(StaticTypeAnalyzer.class)
public interface ITypeAnalyzer {

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

	/** Cached type calculation of the statements type */
	Type getType(Statement expr);

	/**
	 * @return true, iff the actual type is assignable to the expected type.
	 *         (i.e. actual is a subtype of expected)
	 */
	boolean isAssignable(Type expected, Type actual);

	/**
	 * calculates the common supertype of typeOne and typeTwo (Could be one of
	 * them)
	 */
	Type combine(Type typeOne, Type typeTwo);

}
