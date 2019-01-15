/**
 * Copyright (c) 2019 committers of YAKINDU and others.
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
import org.yakindu.sct.generator.core.extensions.AnnotationExtensions
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenPredicate {
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	
	@Inject protected GeneratorEntry entry
	@Inject protected extension AnnotationExtensions
	
	def boolean isEventDriven() {
		entry.isEventDriven
	}
	
	def boolean needsQueues(ExecutionFlow it) {
		needsInternalEventQueue || needsInEventQueue
	}
	
	def boolean needsDispatchEventFunction(ExecutionFlow it) {
		needsQueues
	}
	
	def boolean needsNextEventFunction(ExecutionFlow it) {
		needsQueues
	}
	
	def boolean needsInternalEventQueue(ExecutionFlow it) {
		isEventDriven && flow.hasLocalEvents
	}
	
	def boolean needsInEventQueue(ExecutionFlow it) {
		isEventDriven && entry.inEventQueue
	}
	
	def boolean needsRunCycleGuard(ExecutionFlow it) {
		needsInEventQueue
	}
	
	def boolean isQueued(EventDefinition it) {
		isEventDriven && (isLocalEvent || (isInEvent && entry.inEventQueue))
	}
	
	def boolean needsEventNamespace(ExecutionFlow it) {
		needsEventClasses
	}
	
	def boolean needsEventClasses(ExecutionFlow it) {
		isEventDriven && (flow.hasLocalEvents || (flow.hasInEvents && entry.inEventQueue))
	}
}