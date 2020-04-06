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
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.submodules.EventCode
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

/**
 * @author rbeckmann
 * @author axel terfloth
 *
 */
@Singleton // Guice
class EventDrivenEventCode extends EventCode {
	@Inject extension EventNaming
	@Inject protected extension CLiterals
	@Inject protected extension GeneratorPredicate
	
	protected static int valueVarIndex = 0
	
	override CharSequence eventRaisingCode(EventRaisingExpression it, ExpressionsGenerator exp) {
		'''
		«IF eventDefinition.isQueued»
		«toQueue(exp)»
		«ELSE»
		«super.eventRaisingCode(it, exp)»
		«ENDIF»
		'''
	}
	
	override interfaceIncomingEventRaiserBody(ExecutionFlow it, EventDefinition event)  {
		if(event.isQueued) {
			'''
			«IF event.hasValue»
			«event.typeSpecifier.targetLanguageName» event_value = value;
			«flow.addToQueueValueFctID»(&(«scHandle»->«inEventQueue»), «event.eventEnumMemberName», &event_value);
			«ELSE»
			«flow.addToQueueFctID»(&(«scHandle»->«inEventQueue»), «event.eventEnumMemberName»);
			«ENDIF»
			«runCycleFctID»(«scHandle»);
			'''
		} else {
			'''
			«IF event.hasValue»
			«event.valueAccess» = value;
			«ENDIF»
			«event.access» = «TRUE_LITERAL»;
			
			«runCycleFctID»(«scHandle»);
			'''
		}
	}
	
	
	
	def toQueue(EventRaisingExpression it, ExpressionsGenerator exp) {
		val valueVarName = '''value_«valueVarIndex++»'''
		val event = event.definition.event
		val queue = '''&(«scHandle»->«switch(event.direction) {
			case IN: inEventQueue
			case LOCAL: internalQueue
			case OUT: ""
		}»)'''
		'''
		«IF value !== null»
		{
			«event.typeSpecifier.targetLanguageName» «valueVarName» = «exp.code(value)»;
			«flow.addToQueueValueFctID»(«queue», «event.eventEnumMemberName», &«valueVarName»);
		}
		«ELSE»
		«flow.addToQueueFctID»(«queue», «event.eventEnumMemberName»)«ENDIF»
		'''
	}
	
	def eventDefinition(EventRaisingExpression it) {
		val decl = event.definition
		if(decl instanceof EventDefinition) {
			decl
		} else null
	}
}