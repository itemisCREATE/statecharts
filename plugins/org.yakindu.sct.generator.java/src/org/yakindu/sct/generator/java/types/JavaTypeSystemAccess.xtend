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

import org.yakindu.base.types.impl.BaseTypeSystemAccessImpl
import org.yakindu.base.types.Type

/**
 * @author andreas muelder
 */
class JavaTypeSystemAccess extends BaseTypeSystemAccessImpl {
	
	override getTargetLanguageTypeName(Type type) {
		switch (type.name) {
			case "real" : "double"
			case "integer" : "int"
			case "boolean" : "boolean"
			case "string" : "String"
			case "void" : "void"
			default : "//"+this
		};
	}
	
}
