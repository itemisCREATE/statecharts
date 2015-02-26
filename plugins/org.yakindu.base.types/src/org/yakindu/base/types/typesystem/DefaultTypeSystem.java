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
	protected void initBuiltInTypes() {
		declarePrimitive(STRING);
		declarePrimitive(REAL);
		declarePrimitive(INTEGER);
		declarePrimitive(BOOLEAN);
		declarePrimitive(VOID);
		declarePrimitive(NULL);

		declareSuperType(getType(REAL), getType(INTEGER));
	}

}
