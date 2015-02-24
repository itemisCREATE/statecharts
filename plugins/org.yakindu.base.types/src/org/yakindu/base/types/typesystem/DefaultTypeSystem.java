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

import org.yakindu.base.types.Type;

import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class DefaultTypeSystem extends AbstractTypeSystem {

	public static final String NULL = "null";
	public static final String STRING = "string";
	public static final String REAL = "real";
	public static final String INTEGER = "integer";
	public static final String BOOLEAN = "boolean";
	public static final String VOID = "void";

	@Override
	protected void initStaticTypes() {
		declarePrimitive(STRING);
		declarePrimitive(REAL);
		declarePrimitive(INTEGER);
		declarePrimitive(BOOLEAN);
		declarePrimitive(VOID);
		declarePrimitive(NULL);

		declareSuperType(getType(REAL), getType(INTEGER));
	}

	@Override
	public Object defaultValue(Type type) {
		if (isSame(type, getType(INTEGER))) {
			return 0;
		}
		if (isSame(type, getType(REAL))) {
			return 0.0D;
		}
		if (isSame(type, getType(BOOLEAN))) {
			return false;
		}
		if (isSame(type, getType(STRING))) {
			return "";
		}
		Type superType = getSuperType(type);
		if (superType != null)
			return defaultValue(superType);
		throw new IllegalArgumentException("Unknown type " + type);
	}

}
