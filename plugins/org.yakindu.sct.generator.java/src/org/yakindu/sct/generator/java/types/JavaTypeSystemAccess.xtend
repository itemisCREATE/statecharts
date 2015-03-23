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
package org.yakindu.sct.generator.java.types

import com.google.inject.Inject
import org.yakindu.base.types.Type
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.ITypeSystem.*

/**
 * @author andreas muelder
 */
class JavaTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject
	private extension ITypeSystem ts

	override String getTargetLanguageName(Type type) {
		switch (type) {
			case type == null || ts.isSame(type, getType(VOID)) : 'void'
			case ts.isSame(type, getType(REAL)): "double"
			case ts.isSame(type, getType(INTEGER)): "long"
			case ts.isSame(type, getType(BOOLEAN)): "boolean"
			case ts.isSame(type, getType(STRING)): "String"
			default: "//" + this
		};
	}
}
