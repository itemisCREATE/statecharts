package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.base.types.Direction

class EventRaisingCode {
	
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension FeatureCallSeparator
	@Inject protected extension GeneratorPredicate
	
	def CharSequence raiseEvent(EventRaisingExpression it, CharSequence valueCode) {
		if (event.definition.isExternal) {
			'''«event.context»«event.definition.event.asRaiser»(«IF value !== null»«valueCode»«ENDIF»)'''
		} else {
			'''
			«IF value !== null»
				«event.definition.event.valueAccess» = «valueCode»;
			«ENDIF»
			«IF useOutEventObservables && event.definition.event.direction === Direction.OUT»
				«event.definition.event.observableAccess».next(«IF value !== null»«valueCode»«ENDIF»);
			«ENDIF»
			«event.definition.scope.instance».«event.definition.name.asIdentifier.raised» = true'''
		}
	}
}