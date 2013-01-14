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

import org.yakindu.base.types.impl.BaseTypeSystemAccessImpl
import org.yakindu.base.types.Type

/**
 * @author andreas muelder
 */
class CTypeSystemAccess extends BaseTypeSystemAccessImpl {
	
	override getTargetLanguageTypeName(Type it) {
		switch (if (it == null) 'void' else name ) {
			case 'void' 	: 'void'
			case 'integer'	: 'sc_integer'
			case 'real'		: 'sc_real'
			case 'boolean'	: 'sc_boolean'
			case 'string'	: 'sc_string'
		}
	}
	
}
