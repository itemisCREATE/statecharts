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
public class GenericTypeSystem extends AbstractTypeSystem {
	
	private static final GenericTypeSystem INSTANCE = new GenericTypeSystem();
	
	protected GenericTypeSystem() {}
	
	public static GenericTypeSystem getInstance() {
		return INSTANCE;
	}

	@Override
	protected void initRegistries() {
		declarePrimitive(STRING);
		declarePrimitive(REAL);
		declarePrimitive(INTEGER);
		declarePrimitive(BOOLEAN);
		declarePrimitive(VOID);

		declarePrimitive(NULL);
		getType(NULL).setAbstract(true);

		declarePrimitive(ANY);
		getType(ANY).setAbstract(true);
		
		declareSuperType(getType(ANY), getType(STRING));
		declareSuperType(getType(ANY), getType(BOOLEAN));
		declareSuperType(getType(ANY), getType(INTEGER));
		declareSuperType(getType(INTEGER), getType(REAL));

	}
}
