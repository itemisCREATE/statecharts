package org.yakindu.sct.generator.cpp.providers.eventdriven

import org.yakindu.sct.generator.cpp.providers.ConstructorProvider
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class EventDrivenConstructorProvider extends ConstructorProvider {
	override protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_STRING»),«ENDIF»
			«IF entry.tracingUsed»«tracingInstance»(0),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»(this)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_STRING»)«ENDIF»«ENDFOR»
		'''
	}
}