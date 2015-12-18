/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.expressions.validation

import java.util.List
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeParameter

class GenericsPrettyPrinter {

	def concatTypeParameter(List<TypeParameter> parameter) {
		return '''<«FOR param : parameter SEPARATOR ', '»«param.name»«IF param.bound != null» extends «(param.bound as Type).name»«ENDIF»«ENDFOR»>'''.toString
	}

	def concatTypeArguments(List<Type> parameter) {
		return '''<«FOR param : parameter SEPARATOR ', '»«param.name»«ENDFOR»>'''.toString
	}
}