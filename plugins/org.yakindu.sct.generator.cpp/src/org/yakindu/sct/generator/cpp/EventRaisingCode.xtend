package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

class EventRaisingCode {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension INamingService
	
	def raiseEvent(EventRaisingExpression it, CharSequence valueCode) '''
		«IF value !== null»
			«event.definition.event.valueAccess» = «valueCode»;
		«ENDIF»
		«event.definition.event.access» = true'''
}