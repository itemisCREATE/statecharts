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

import org.yakindu.base.types.Type;

import com.google.inject.ImplementedBy;

/**
 * A Implementation of {@link ITypeSystem} defines all existing types and the
 * type compatibility.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultTypeSystem.class)
public interface ITypeSystem {

	public void declareType(Type type, String name);

	public void declareSuperType(Type baseType, Type superType);

	public Collection<Type> getTypes();

	public Type getType(String name);

	public boolean isSame(Type type1, Type type2);

	public Type getCommonType(Type type1, Type type2);

	public boolean haveCommonType(Type type1, Type type2);

	public Type getSuperType(Type type);

	public boolean isSuperType(Type subtype, Type supertype);
}
