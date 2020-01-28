package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.types.EnumerationType
import org.yakindu.sct.generator.c.types.CTypeSystemAccess

class CppTypeSystemAccess extends CTypeSystemAccess {
	
	@Inject extension CppNaming
	
	override printStateEnumType(EnumerationType type) {
		type.getOriginStatechart.module + "::" + type.name
	}
}