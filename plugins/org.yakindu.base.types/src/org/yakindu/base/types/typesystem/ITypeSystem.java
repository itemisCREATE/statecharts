/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.typesystem;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;

import com.google.inject.ImplementedBy;

/**
 * A Implementation of {@link ITypeSystem} defines all existing types and the
 * type compatibility.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(GenericTypeSystem.class)
public interface ITypeSystem {
	
	public static final String STRING = "string";
	public static final String REAL = "real";
	public static final String INTEGER = "integer";
	public static final String BOOLEAN = "boolean";
	public static final String VOID = "void";
	public static final String NULL = "null";

	public Collection<Type> getTypes(EObject context);
	
	public Collection<Type> getConcreteTypes(EObject context);

	public Type getType(String name);
	
	public boolean isSame(Type type1, Type type2);

	public boolean haveCommonType(Type type1, Type type2);

	public Type getCommonType(Type type1, Type type2);

	public boolean haveCommonTypeWithConversion(Type type1, Type type2);

	public Type getCommonTypeWithConversion(Type type1, Type type2);
	
	public Type getSuperType(Type type);

	public boolean isSuperType(Type subtype, Type supertype);

	public void declareType(Type type, String name);


}
