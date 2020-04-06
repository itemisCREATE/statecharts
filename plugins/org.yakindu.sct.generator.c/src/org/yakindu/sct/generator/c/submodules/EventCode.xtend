/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.TraceCode
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

/**
 * @author rbeckmann
 * @author axel terfloth
 *
 */
@Singleton // Guice
class EventCode {
	@Inject protected extension SExecExtensions
	@Inject protected extension Naming
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension CLiterals
	@Inject protected extension	TraceCode 
	@Inject extension ExpressionExtensions
	
	@Inject protected extension GeneratorEntry entry
	@Inject protected extension GenmodelEntries
	
	
	def interfaceIncomingEventRaiser(ExecutionFlow it, EventDefinition event) '''
		«eventRaiserSignature(event)»
		{
			«event.traceCode( if (event.hasValue) "&value" else "sc_null" )»
			«interfaceIncomingEventRaiserBody(event)»
		}

	'''	

	def interfaceIncomingEventRaiserBody(ExecutionFlow it, EventDefinition event) '''
		«IF event.hasValue»
		«event.valueAccess» = value;
		«ENDIF»
		«event.access» = «TRUE_LITERAL»;
	'''
	
	def interfaceOutgoingEventGetter(ExecutionFlow it, EventDefinition event) '''
		«eventGetterSignature(event)»
		{
			return «event.access»;
		}
	'''
	
	def interfaceOutgoingEventValueGetter(ExecutionFlow it, EventDefinition event) '''
		«eventValueGetterSignature(event)»
		{
			return «event.valueAccess»;
		}
	'''
	
	def CharSequence eventRaisingCode(EventRaisingExpression it, ExpressionsGenerator exp) {
		if (event.featureOrReference.eContainer instanceof ComplexType) {
			val fc = event as FeatureCall
			return '''«(fc.feature as EventDefinition).asRaiser»(«fc.owner.getHandle»«IF value !== null», «exp.code(value)»«ENDIF»)'''
		}
		
		val eventMarker = '''«event.definition.event.access» = «TRUE_LITERAL»'''
		val eventValue  = if (it.value !== null) '''«event.definition.event.valueAccess» = «exp.code(value)»''' else null
		val eventTrace  = event.definition.traceCode(if (it.value !== null) '''&«event.definition.event.valueAccess»''' else '''sc_null''')

		return '''
			«eventMarker»«IF eventValue !== null»;
			«eventValue»«ENDIF»«IF eventTrace !== null»;
			«eventTrace»«ENDIF»'''
	}
	
	def eventRaiserSignature(ExecutionFlow it, EventDefinition event) '''void «event.asRaiser»(«scHandleDecl»«event.valueParams»)'''
	
	def eventGetterSignature(ExecutionFlow it, EventDefinition event) '''«CGeneratorConstants.BOOL_TYPE» «event.asRaised»(const «scHandleDecl»)'''
	
	def eventValueGetterSignature(ExecutionFlow it, EventDefinition event) '''«event.typeSpecifier.targetLanguageName» «event.asGetter»(const «scHandleDecl»)'''
}