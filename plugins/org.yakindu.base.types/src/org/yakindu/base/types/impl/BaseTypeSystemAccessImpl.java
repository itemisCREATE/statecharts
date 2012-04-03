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
package org.yakindu.base.types.impl;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BaseTypeSystemAccessImpl implements ITypeSystemAccess {

	@Override
	public boolean isBoolean(Type type) {
		return type != null && (type.getName().equalsIgnoreCase("boolean")
				|| type.getName().equalsIgnoreCase("bool"));
	}

	@Override
	public boolean isInteger(Type type) {
		return type != null && (type.getName().equalsIgnoreCase("integer")
				|| type.getName().equalsIgnoreCase("int"));
	}

	@Override
	public boolean isReal(Type type) {
		return type != null && type.getName().equalsIgnoreCase("real");
	}

	@Override
	public boolean isVoid(Type type) {
		return type == null || type.getName().equalsIgnoreCase("void");
	}

	@Override
	public boolean isString(Type type) {
		return type != null && type.getName().equalsIgnoreCase("string");
	}

	public boolean isAssignable(Type expected, Type actual) {
		if (expected.getName().equals(combine(expected, actual).getName())) {
			return true;
		}
		if ((isInteger(expected) || isReal(expected))
				&& (isInteger(actual) || isReal(actual))) {
			return true;
		}
		return false;
	}
	
	@Override
	public Type getBoolean() {
		Type type = TypesFactory.eINSTANCE.createType();
		type.setName("boolean");
		return type;
	}

	@Override
	public Type  getInteger() {
		Type type = TypesFactory.eINSTANCE.createType();
		type.setName("integer");
		return type;
	} 
	
	@Override
	public Type getReal() {
		Type type = TypesFactory.eINSTANCE.createType();
		type.setName("real");
		return type;
	}
	@Override
	public Type getString() {
		Type type = TypesFactory.eINSTANCE.createType();
		type.setName("string");
		return type;
	}

	public Type combine(Type typeOne, Type typeTwo) {
		if (typeOne == null || typeTwo == null) {
			return null;
		}
		if (typeOne.equals(typeTwo)
				|| typeOne.getName().equals(typeTwo.getName())) {
			return typeOne;
		}
		if (isInteger(typeOne) && isReal(typeTwo)) {
			return typeTwo;
		}
		if (isReal(typeOne) && isInteger(typeTwo)) {
			return typeOne;
		}
		// TODO
		// List<Type> typesOne = allSuperTypes(typeOne);
		// List<Type> typesTwo = allSuperTypes(typeTwo);
		// List<Type> superType = typesOne.findFirst(t | typesTwo.contains(t));
		// if (superType != null) {
		// return superType;
		// }

		return null;
	}

	public List<Type> allSuperTypes(Type type) {
		List<Type> types = new ArrayList<Type>();
		types.add(type);
		List<Type> newSuperTypes = new ArrayList<Type>();
		newSuperTypes.addAll(type.getSuperTypes());
		while (!newSuperTypes.isEmpty()) {
			List<Type> oldSuperTypes = newSuperTypes;
			newSuperTypes = new ArrayList<Type>();
			for (Type superType : oldSuperTypes) {
				if (!types.contains(superType)) {
					types.add(superType);
					newSuperTypes.addAll(superType.getSuperTypes());
				}
			}
		}
		return types;
	}
}
