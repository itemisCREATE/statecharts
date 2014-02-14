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
import org.yakindu.base.types.ITypeSystem
import org.yakindu.base.types.Type
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

/**
 * @author andreas muelder
 * @author Alexander Nyßen - Adopted to type system changes
 */
class OldJavaTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject
	private extension ITypeSystem ts

	override String getTargetLanguageName(Type type) {
		switch (type) {
			case type == null || isVoidType(type): "void"
			case isRealType(type): "double"
			case isIntegerType(type): "int"
			case isBooleanType(type): "boolean"
			case isStringType(type): "String"
			default: "//" + this
		};
	}
}
