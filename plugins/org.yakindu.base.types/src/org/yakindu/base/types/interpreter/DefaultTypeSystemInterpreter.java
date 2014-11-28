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
package org.yakindu.base.types.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultTypeSystemInterpreter extends AbstractTypeSystemInterpreter {

	@Inject
	private ITypeSystem typeSystem;

	@Override
	public Object interpret(EObject object) {
		throw new IllegalArgumentException("not yet implemented");
	}

	@Override
	public Object defaultValue(Type type) {
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.INTEGER))) {
			return 0;
		}
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.REAL))) {
			return 0.0D;
		}
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.BOOLEAN))) {
			return false;
		}
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.STRING))) {
			return "";
		}
		Type superType = typeSystem.getSuperType(type);
		if (superType != null)
			return defaultValue(superType);
		throw new IllegalArgumentException("Unknown type " + type);
	}

}
