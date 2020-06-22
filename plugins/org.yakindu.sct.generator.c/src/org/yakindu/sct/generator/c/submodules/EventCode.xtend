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
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Expression
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.TraceCode
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.ng.EventProcessing
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

/**
 * @author rbeckmann
 * @author axel terfloth
 *
 */
@Singleton // Guice
class EventCode implements org.yakindu.sct.generator.core.submodules.lifecycle.EventCode {

	@Inject protected extension SExecExtensions
	@Inject protected extension Naming
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension CLiterals
	@Inject protected extension	TraceCode 
	@Inject extension ExpressionExtensions
	@Inject extension GeneratorPredicate
	
	@Inject protected extension GeneratorEntry entry
	@Inject protected extension GenmodelEntries
	
	@Inject protected extension CExpressionsGenerator
	
	@Inject protected extension EventProcessing
	@Inject protected extension ExpressionBuilder
	
	
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
	
	def interfaceOutgoingEventObservableGetter(ExecutionFlow it, EventDefinition event) '''
		«eventObservableSignature(event)»
		{
			return &«event.accessObservable»;
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
		val eventDefintion = event.definition.event
		'''
			«IF useOutEventObservables && event.definition.event.direction === Direction.OUT»
				«IF value !== null»
					{
						«event.definition.event.valueDeclaration» = «exp.code(value)»;
						sc_observable_next(&«eventDefintion.accessObservable», &«eventDefintion.valueName»);
					}
				«ELSE»
					sc_observable_next(&«eventDefintion.accessObservable», sc_null)«IF useOutEventGetters»;«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF (useOutEventGetters && eventDefintion.direction == Direction.OUT) || eventDefintion.direction == Direction.IN || eventDefintion.direction == Direction.LOCAL»
				«eventMarker»«IF eventValue(exp) !== null»;
				«eventValue(exp)»«ENDIF»«IF eventTrace !== null»;
				«eventTrace»«ENDIF»
			«ENDIF»
		'''
	}
	
	protected def CharSequence eventTrace(EventRaisingExpression it) {
		event.definition.traceCode(if (it.value !== null) '''&«event.definition.event.valueAccess»''' else '''sc_null''')
	}
	
	protected def String eventValue(EventRaisingExpression it, ExpressionsGenerator exp) {
		if (it.value !== null) '''«event.definition.event.valueAccess» = «exp.code(value)»''' else null
	}
	
	protected def CharSequence eventMarker(EventRaisingExpression it)
		'''«event.definition.event.access» = «TRUE_LITERAL»'''
	
	
	def eventRaiserSignature(ExecutionFlow it, EventDefinition event) '''void «event.asRaiser»(«scHandleDecl»«event.valueParams»)'''
	
	def eventGetterSignature(ExecutionFlow it, EventDefinition event) '''«CGeneratorConstants.BOOL_TYPE» «event.asRaised»(const «scHandleDecl»)'''
	
	def eventValueGetterSignature(ExecutionFlow it, EventDefinition event) '''«event.typeSpecifier.targetLanguageName» «event.asGetter»(const «scHandleDecl»)'''
	
	def eventObservableSignature(ExecutionFlow it, EventDefinition event) '''«CGeneratorConstants.OBSERVABLE_TYPE»* «event.asObservableGetter»(«scHandleDecl»)'''
	
	def eventObserverNextSignature(ExecutionFlow it, EventDefinition event) '''«CGeneratorConstants.OBSERVABLE_TYPE»* «event.asObservableGetter»(«scHandleDecl»)'''
	
	
	override eventClearCode(ExecutionFlow flow, Expression event) '''
		«event.code» = «FALSE_LITERAL»;
	'''
	
	override eventMoveCode(ExecutionFlow flow, Expression source, Expression target) '''
		«target.code» = «source.code»;
		«IF source.event.hasValue»«target._meta(target.event.valueFeature).code» = «source._meta(source.event.valueFeature).code»;«ENDIF»
		«source.code» = «FALSE_LITERAL»;
	'''
	
}