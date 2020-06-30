/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.base.types.Expression
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.model.sexec.concepts.EventProcessing
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

/**
 * @author René Beckmann
 */
class EventCode implements org.yakindu.sct.generator.core.submodules.lifecycle.EventCode {
	@Inject protected extension org.yakindu.sct.generator.cpp.CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GeneratorPredicate
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension EventProcessing
	@Inject protected extension ExpressionBuilder
	
	def generateEvents(ExecutionFlow it, StatechartScope scope)
		'''
		«FOR event : scope.incomingEvents»
			«generateEventComment(event, scope)»
			«generateInterfaceEventRaiser(it, event, scope)»
			«IF scope.defaultInterface»
				«generateDefaultInterfaceEventRaiser(it, event, scope)»
			«ENDIF»
		«ENDFOR»
		«FOR event : scope.outgoingEvents»
			«generateEventComment(event, scope)»
			«generateInterfaceEventRaised(it, event, scope)»
			«IF scope.defaultInterface»
				«generateDefaultInterfaceEventRaised(it, event, scope)»
			«ENDIF»
			«IF event.hasValue»
				«generateEventValueGetter(it, event, scope)»
				«IF scope.defaultInterface»
					«generateEventGetter(it, event, scope)»
				«ENDIF»
			«ENDIF»
			«IF useOutEventObservables»
				«generateObservableGetter(it, event, scope)»
				«IF scope.defaultInterface»
					«generateDefaultInterfaceObservableGetter(it, event, scope)»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		«FOR event : scope.localEvents»
			«generateEventComment(event, scope)»
			«generateInterfaceEventRaiser(it, event, scope)»
			«generateInterfaceEventRaised(it, event, scope)»
			«IF event.hasValue» 
				«generateEventValueGetter(it, event, scope)»
			«ENDIF»
		«ENDFOR»
	'''
		
	def protected generateObservableGetter(ExecutionFlow it, EventDefinition event, StatechartScope scope) {
		'''
			sc::rx::Observable<«event.typeSpecifier.targetLanguageName»>* «module»::«scope.interfaceName»::«event.asObservableGetter»()
			{
				return &(this->«event.observable»);
			}
		'''
	}
	
	def protected generateDefaultInterfaceObservableGetter(ExecutionFlow it, EventDefinition event, StatechartScope scope) {
		'''
			sc::rx::Observable<«event.typeSpecifier.targetLanguageName»>* «module»::«event.asObservableGetter»()
			{
				return «scope.instance».«event.asObservableGetter»();
			}
		'''		
	}
		
	protected def CharSequence generateEventGetter(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		«event.typeSpecifier.targetLanguageName» «module»::«event.asGetter»() const
		{
			return «scope.instance».«event.asGetter»();
		}
	'''
	
	
	protected def CharSequence generateEventValueGetter(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		«event.typeSpecifier.targetLanguageName» «module»::«scope.interfaceName»::«event.asGetter»() const
		{
			return «event.localValueAccess»;
		}
	'''
	
	
	protected def CharSequence generateDefaultInterfaceEventRaised(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		«BOOL_TYPE» «module»::«event.asRaised»() const
		{
			return «scope.instance».«event.asRaised»();
		}
	'''
	
	
	protected def CharSequence generateInterfaceEventRaised(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		«BOOL_TYPE» «module»::«scope.interfaceName»::«event.asRaised»() const
		{
			return «event.localAccess»;
		}
	'''
		
	
	protected def CharSequence generateDefaultInterfaceEventRaiser(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		void «module»::«event.asRaiser»(«event.valueParams»)
		{
			«scope.instance».«event.asRaiser»(«IF event.hasValue»value«ENDIF»);
		}
	'''
	
	
	protected def CharSequence generateInterfaceEventRaiser(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		void «module»::«scope.interfaceName»::«event.asRaiser»(«event.valueParams»)
		{
			«IF event.hasValue»
				«event.localValueAccess» = value;
			«ENDIF»
			«event.localAccess» = true;
		}
	'''
	
	protected def CharSequence generateEventComment(EventDefinition it, StatechartScope scope)
		'''/* Functions for event «name» in interface «scope.interfaceName» */'''
		
	def needsRaiser(EventDefinition it) { it.isInEvent || it.isLocalEvent }
	def needsRaised(EventDefinition it) { it.isLocalEvent || it.isOutEvent } // && getter feature?
	
	override eventClearCode(ExecutionFlow flow, Expression event) '''
	«event.code» = false;
	'''
	
	override eventMoveCode(ExecutionFlow flow, Expression source, Expression target) '''
		«target.code» = «source.code»;
		«IF source.event.hasValue»«target._meta(target.event.valueFeature).code» = «source._meta(source.event.valueFeature).code»;«ENDIF»
		«source.code» = false;
	'''
	
	override eventNextCode(ExecutionFlow flow) {
		throw new UnsupportedOperationException("Something went wrong - generating 'eventNext' not supported for cycle based statecharts.")
	}
}
