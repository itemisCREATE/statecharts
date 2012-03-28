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

	boolean isBoolean(Type type);

	boolean isInteger(Type type);

	boolean isReal(Type type);

	boolean isString(Type type);

	Type inferType(Statement expr);

	boolean isAssignable(Type expected, Type actual);

	Type combine(Type typeOne, Type typeTwo);

}
