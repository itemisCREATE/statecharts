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
package org.yakindu.base.types;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemRegistry implements ITypeSystemRegistry {

	private Multimap<String, ITypeSystem> typeSystemRegistry = ArrayListMultimap.create();

	public Iterable<ITypeSystem> getTypeSystems(String typesystemID) {
		return typeSystemRegistry.get(typesystemID);
	}

	protected void addTypeSystem(String uriScheme, ITypeSystem system) {
		typeSystemRegistry.put(uriScheme, system);
	}

	@Override
	public Iterable<ITypeSystem> getAllTypeSystems() {
		return typeSystemRegistry.values();
	}

	@Override
	public Collection<Type> getTypes(EObject context) {
		List<Type> allTypes = Lists.newArrayList();
		Iterable<ITypeSystem> allTypeSystems = getAllTypeSystems();
		for (ITypeSystem iTypeSystem : allTypeSystems) {
			allTypes.addAll(iTypeSystem.getTypes(context));
		}
		return allTypes;
	}

	@Override
	public Type getType(String name) {
		Iterable<ITypeSystem> allTypeSystems = getAllTypeSystems();
		for (ITypeSystem iTypeSystem : allTypeSystems) {
			if (iTypeSystem.getType(name) != null) {
				return iTypeSystem.getType(name);
			}
		}
		throw new IllegalArgumentException(String.format("Type %s not found ", name));
	}

	protected ITypeSystem getDelegate(Type type) {
		Iterable<ITypeSystem> allTypeSystems = getAllTypeSystems();
		for (ITypeSystem iTypeSystem : allTypeSystems) {
			if (iTypeSystem.isTypeSystemFor(type))
				return iTypeSystem;
		}
		throw new IllegalStateException(String.format("No Type System for type %s found!", type));
	}

	@Override
	public boolean isSame(Type type1, Type type2) {
		return getDelegate(type1).isSame(type1, type2);
	}

	@Override
	public Type getCommonType(Type type1, Type type2) {
		return getDelegate(type1).getCommonType(type1, type2);
	}

	@Override
	public boolean haveCommonType(Type type1, Type type2) {
		return getDelegate(type1).haveCommonType(type1, type2);
	}

	@Override
	public Type getSuperType(Type type) {
		return getDelegate(type).getSuperType(type);
	}

	@Override
	public boolean isSuperType(Type subtype, Type supertype) {
		return getDelegate(subtype).isSuperType(subtype, supertype);
	}

	@Override
	public boolean isTypeSystemFor(Type type) {
		return getDelegate(type) != null;
	}

	@Override
	public Object defaultValue(Type type) {
		return getDelegate(type).defaultValue(type);
	}

}
