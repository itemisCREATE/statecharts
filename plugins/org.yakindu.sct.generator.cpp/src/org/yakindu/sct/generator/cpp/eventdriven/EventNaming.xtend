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
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

/**
 * @author René Beckmann - Initial contribution and API
 */
class EventNaming extends org.yakindu.sct.generator.c.extensions.EventNaming {
	@Inject extension CppNaming
	@Inject extension SExecExtensions
	@Inject extension INamingService
	
	override invalidEventEnumName(ExecutionFlow it) {
		'''«module»_invalid_event'''.toString.toLowerCase
	}
	
	override eventEnumMemberName(Event it) {
		'''«scope.interfaceName»_«name.asIdentifier»'''
	}
	
	override eventEnumName(ExecutionFlow it) {
		'''«module»EventName'''
	}
	
	def timeEventEnumName() {
		'''TimeEvent'''
	}
	
	def eventClassName(Event it) {
		'''«SCT_EVENT»_«scope.interfaceName»_«it.name.asIdentifier»'''
	}
	
	def eventNamespaceName(ExecutionFlow it) {
		'''«name.toLowerCase»_events'''
	}
	
	override internalQueue() {
		"internalEventQueue"
	}
	
	override nextEventFctID(ExecutionFlow it) {
		NEXT_EVENT
	}
	
	override dispatchEventFctID(ExecutionFlow it) {
		"dispatch_event"
	}
	
	override addToQueueFctID(ExecutionFlow it) {
		super.addToQueueFctID(it)
	}
	
	override addToQueueValueFctID(ExecutionFlow it) {
		super.addToQueueValueFctID(it)
	}
}