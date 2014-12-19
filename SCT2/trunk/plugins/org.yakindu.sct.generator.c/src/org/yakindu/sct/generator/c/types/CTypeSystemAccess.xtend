/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.types

import com.google.inject.Inject
import org.yakindu.base.types.ITypeSystemRegistry
import org.yakindu.base.types.Type
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.DefaultTypeSystem.*

/**
 * @author andreas muelder
 */
class CTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject
	extension ITypeSystemRegistry ts

	override getTargetLanguageName(Type type) {
		switch (type) {
			case type == null || ts.isSame(type, getType(VOID)) : 'void'
			case ts.isSame(type, getType(INTEGER)): 'sc_integer'
			case ts.isSame(type, getType(REAL)): 'sc_real'
			case ts.isSame(type, getType(BOOLEAN)): 'sc_boolean'
			case ts.isSame(type, getType(STRING)): 'sc_string'
			default: "TargetLanguageName not found"
		}
	}

}
