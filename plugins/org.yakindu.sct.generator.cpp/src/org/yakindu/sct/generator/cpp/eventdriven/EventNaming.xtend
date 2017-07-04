package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.Naming
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry

class EventNaming {
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension INamingService
	
	def eventEnumMemberName(Event it) {
		'''«scope.interfaceName»_«name.asIdentifier»'''
	}
	
	def eventEnumName(ExecutionFlow it) {
		'''«module»EventName'''
	}
	
	def eventClassName(Event it) {
		'''SctEvent_«flow.name.toFirstUpper»_«scope.interfaceName»_«it.name.asIdentifier»'''
	}
	
	def eventNamespaceName(ExecutionFlow it) {
		'''«name.toLowerCase»_events'''
	}
}