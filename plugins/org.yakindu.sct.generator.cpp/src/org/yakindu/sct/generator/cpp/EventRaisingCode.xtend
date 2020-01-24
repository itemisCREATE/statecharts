package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Expression
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

class EventRaisingCode {
	
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	
	def raiseEvent(EventRaisingExpression it, CharSequence valueCode) {
		if (event.definition.isExternal) {
			'''«event.context»«event.definition.event.asRaiser»(«IF value !== null»«valueCode»«ENDIF»)'''
		} else {
			'''
			«IF value !== null»
				«event.definition.event.valueAccess» = «valueCode»;
			«ENDIF»
			«event.definition.scope.instance».«event.definition.name.asIdentifier.raised» = true'''
		}
	}
		
	
	def dispatch context(FeatureCall it) '''«owner.code»«owner.callSep»'''
	def dispatch context(Expression it) ''''''
}