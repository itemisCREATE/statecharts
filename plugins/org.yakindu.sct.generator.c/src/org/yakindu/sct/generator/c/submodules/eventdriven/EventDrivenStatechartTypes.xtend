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
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.submodules.StatechartTypes
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.BOOL_TYPE
import static org.yakindu.sct.generator.c.CGeneratorConstants.INT_TYPE
import org.yakindu.sct.generator.c.extensions.Naming

/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class EventDrivenStatechartTypes extends StatechartTypes {
	@Inject protected extension EventNaming
	@Inject protected extension GeneratorPredicate
	@Inject protected extension Naming
	
	override statemachineStructContent(ExecutionFlow it) {
		'''
		«super.statemachineStructContent(it)»
		«IF needsInternalEventQueue»
		«eventQueueTypeName» «internalQueue»;
		«IF !userAllocatesInternalQueue»
		«internalEventStructTypeName» internal_buffer[«internalBufferSize»];
		«ENDIF»
		«ENDIF»
		«IF needsInEventQueue»
		«eventQueueTypeName» «inEventQueue»;
		«IF !userAllocatesInternalQueue»
		«internalEventStructTypeName» in_buffer[«inBufferSize»];
		«ENDIF»
		«ENDIF»
		«IF needsRunCycleGuard»
		«BOOL_TYPE» «runCycleGuard»;
		«ENDIF»
		'''
	}
	
	def generateEventsEnum(ExecutionFlow it) {
		if(!needsQueues) return ''''''
		'''
		/*
		 * Enum of event names in the statechart.
		 */
		typedef enum  {
			«invalidEventEnumName(it)» = «invalidEvent»,
			«FOR e : queuedEvents SEPARATOR ","»
				«eventEnumMemberName(e)»
			«ENDFOR»
		} «eventEnumName»;
		'''
	}
	
	def generateEventValueUnion(ExecutionFlow it) {
		if(!needsValueUnion) return ''''''
		'''
		/*
		 * Union of all possible event value types.
		 */
		typedef union {
			«FOR e : queuedEventsWithValue»
			«e.typeSpecifier.targetLanguageName» «eventValueUnionMemberName(e)»;
			«ENDFOR»
		} «eventValueUnionName»;
		'''
	}
	
	def generateEventStruct(ExecutionFlow it) {
		'''
		/*
		 * Struct that represents a single event.
		 */
		typedef struct {
			«eventEnumName» name;
			«IF needsValueUnion»
			«BOOL_TYPE» has_value;
			«eventValueUnionName» value;
			«ENDIF»
		} «internalEventStructTypeName»;
		'''
	}

	def generateEventQueue(ExecutionFlow it) {
		'''
		/*
		 * Queue that holds the raised events.
		 */
		typedef struct «eventQueueTypeName»_s {
			«internalEventStructTypeName» *events;
			«INT_TYPE» capacity;
			«INT_TYPE» pop_index;
			«INT_TYPE» push_index;
			«INT_TYPE» size;
		} «eventQueueTypeName»;
		'''
	}
}