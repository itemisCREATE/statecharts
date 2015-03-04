/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.typesystem;

import static org.yakindu.base.types.typesystem.ITypeSystem.BOOLEAN;
import static org.yakindu.base.types.typesystem.ITypeSystem.INTEGER;
import static org.yakindu.base.types.typesystem.ITypeSystem.REAL;
import static org.yakindu.base.types.typesystem.ITypeSystem.STRING;

import org.yakindu.base.types.Type;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultTypeValueProvider implements ITypeValueProvider {

	@Inject
	private ITypeSystem typeSystem;

	@Override
	public Object defaultValue(Type type) {
		type = type.getOriginType();
		
		if (is(type, INTEGER)) {
			return new Integer(0);
		}
		if (is(type, REAL)) {
			return new Double(0.0);
		}
		if (is(type, BOOLEAN)) {
			return Boolean.FALSE;
		}
		if (is(type, STRING)) {
			return new String("");
		}
		Type superType = typeSystem.getSuperType(type);
		if (superType != null)
			return defaultValue(superType);
		throw new IllegalArgumentException("Unknown type " + type);
	}

	protected boolean is(Type type, String typeName) {
		return typeSystem.isSame(type, typeSystem.getType(typeName));
	}

}
