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
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.ITypeSystem.*

/**
 * @author andreas muelder
 */
class JavaTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject
	extension ITypeSystem ts

	override String getTargetLanguageName(Type type) {
		val originalType = type?.originType
		switch (originalType) {
			case originalType === null || ts.isSame(originalType, getType(VOID)) : 'void'
			case ts.isSame(originalType, getType(REAL)): "double"
			case ts.isSame(originalType, getType(INTEGER)): "long"
			case ts.isSame(originalType, getType(BOOLEAN)): "boolean"
			case ts.isSame(originalType, getType(STRING)): "String"
			default: "//" + this
		};
	}
	
	override getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}
}
