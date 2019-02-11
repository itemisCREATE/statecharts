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
package org.yakindu.sct.generator.c.extensions

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.Event
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

/**
 * @author René Beckmann
 */
@Singleton // Guice
class EventNaming {
	@Inject extension Naming
	@Inject extension SExecExtensions
	@Inject extension INamingService

	def eventEnumMemberName(Event it) {
		'''«scope.functionPrefix(it)»_«name.asIdentifier»'''
	}

	def invalidEventEnumName(ExecutionFlow it) {
		'''«module»_invalid_event'''.toString.toLowerCase
	}

	def eventEnumName(ExecutionFlow it) {
		'''«module»_event_name'''.toString.toLowerCase
	}

	def eventValueUnionName(ExecutionFlow it) {
		'''«module»_event_value'''.toString.toLowerCase
	}
	
	def eventValueUnionMemberName(Event it) {
		'''«eventEnumMemberName»_value'''
	}

	def internalEventStructTypeName(ExecutionFlow it) {
		'''«name»_internal_event'''.toString.toLowerCase
	}

	def eventQueueTypeName(ExecutionFlow it) {
		'''«name»_eventqueue'''.toString.toLowerCase
	}

	def eventInitFunction(ExecutionFlow it) {
		'''«internalEventStructTypeName»_init'''
	}

	def valueEventInitFunction(ExecutionFlow it) {
		'''«internalEventStructTypeName»_value_init'''
	}

	def eventQueueInitFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_init'''
	}

	def eventQueueSizeFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_size'''
	}

	def eventQueuePopFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_pop'''
	}

	def eventQueuePushFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_push'''
	}
	
	def nextEventFctID(ExecutionFlow it) {
		eventQueuePopFunction
	}

	def bufferSize(ExecutionFlow it) {
		'''«name»_eventqueue_buffersize'''.toString.toUpperCase
	}
	
	def invalidEvent() {
		"SC_INVALID_EVENT_VALUE"
	}
	
	def internalQueue() {
		"internal_event_queue"
	}
	
	def inEventQueue() {
		"in_event_queue"
	}
	
	def dispatchEventFctID(ExecutionFlow it) {
		'''«functionPrefix»dispatch_event'''
	}
	
	def addToQueueFctID(ExecutionFlow it) {
		'''«functionPrefix»add_event_to_queue'''
	}
	
	def addToQueueValueFctID(ExecutionFlow it) {
		'''«functionPrefix»add_value_event_to_queue'''
	}
}
