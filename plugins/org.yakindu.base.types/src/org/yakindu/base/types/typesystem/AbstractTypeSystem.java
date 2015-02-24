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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;

/**
 * Abstract base implementation if {@link ITypeSystem}. Provides convenience
 * methods to determine type compatibility.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystem implements ITypeSystem {

	protected Map<String, Type> typeRegistry = new HashMap<String, Type>();
	protected Map<Type, Type> extendsRegistry = new HashMap<Type, Type>();
	protected Map<Type, Type> conversionRegistry = new HashMap<Type, Type>();

	protected abstract void initBuiltInTypes();

	protected Resource resource;

	public AbstractTypeSystem() {
		resource = new ResourceImpl(URI.createURI("types"));
		initBuiltInTypes();
	}

	protected void reset() {
		typeRegistry.clear();
		extendsRegistry.clear();
		conversionRegistry.clear();
	}

	public Type getType(String type) {
		return typeRegistry.get(type);
	}

	public Type getSuperType(Type type) {
		Set<Entry<Type, Type>> entrySet = extendsRegistry.entrySet();
		for (Entry<Type, Type> entry : entrySet) {
			if (isSame(type, entry.getKey())) {
				return entry.getValue();
			}
		}
		return null;
	}

	public boolean isSuperType(Type subtype, Type supertype) {
		List<Type> typehierachy = new ArrayList<Type>();
		typehierachy.add(subtype);
		collectSupertypes(subtype, typehierachy);
		for (Type eObject : typehierachy) {
			if (isSame(eObject, supertype))
				return true;
		}
		return false;
	}

	private void collectSupertypes(Type subtypeClass, List<Type> typehierachy) {
		if (subtypeClass == null)
			return;
		Type superType = getSuperType(subtypeClass);
		if (superType != null) {
			typehierachy.add(superType);
			collectSupertypes(superType, typehierachy);
		}

	}

	public Collection<Type> getTypes(EObject context) {
		return Collections.unmodifiableCollection(typeRegistry.values());
	}

	protected Type declarePrimitive(String name) {
		PrimitiveType primitive = TypesFactory.eINSTANCE.createPrimitiveType();
		primitive.setName(name);
		declareType(primitive, name);
		resource.getContents().add(primitive);
		return primitive;
	}

	public void declareType(Type type, String name) {
		typeRegistry.put(name, type);
	}

	public void removeType(String name) {
		Type type = typeRegistry.get(name);
		if (type != null) {
			extendsRegistry.remove(type);
			resource.getContents().remove(type);
			typeRegistry.remove(type);
		}
	}

	public void declareSuperType(Type superType, Type subType) {
		extendsRegistry.put(subType, superType);
	}

	public void declareConversion(Type baseType, Type targetType) {
		conversionRegistry.put(baseType, targetType);
	}

	public boolean haveCommonType(Type type1, Type type2) {
		return getCommonType(type1, type2) != null;
	}

	public boolean isSame(Type type1, Type type2) {
		return EcoreUtil.equals(type1, type2);
	}

	public Type getCommonType(Type type1, Type type2) {
		Type result = getCommonTypeInternal(type1, type2);
		if (result != null)
			return result;

		Type conversionType1 = getConversionType(type1);
		if (conversionType1 != null) {
			result = getCommonTypeInternal(conversionType1, type2);
			if (result != null)
				return result;
		}

		Type conversionType2 = getConversionType(type2);
		if (conversionType2 != null)
			return getCommonTypeInternal(type1, conversionType2);

		return null;
	}

	private Type getCommonTypeInternal(Type type1, Type type2) {

		if (isSame(type1, type2))
			return type1;
		if (isSuperType(type1, type2)) {
			return type2;
		}
		if (isSuperType(type2, type1))
			return type1;

		List<Type> typehierachy1 = new ArrayList<Type>();
		collectSupertypes(type1, typehierachy1);
		List<Type> typehierachy2 = new ArrayList<Type>();
		collectSupertypes(type2, typehierachy2);

		for (Type type : typehierachy1) {
			if (typehierachy2.contains(type)) {
				return type;
			}
		}
		for (Type type : typehierachy2) {
			if (typehierachy1.contains(type)) {
				return type;
			}
		}

		return null;
	}

	protected Type getConversionType(Type sourceType) {
		return conversionRegistry.get(sourceType);
	}
}
