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