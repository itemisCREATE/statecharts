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
package org.yakindu.sct.generator.core.extensions

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.EventDefinition

abstract class GeneratorPredicate {

	@Inject protected extension SExecExtensions
	@Inject protected extension StatechartAnnotations;
	@Inject protected GeneratorEntry entry
	@Inject protected extension ICoreLibraryHelper

	def boolean isEventDriven() {
		entry.statechart.eventDriven
	}

	def useOutEventObservables() {
		getOutEventObservablesUsed(entry)
	}

	def useOutEventGetters() {
		getOutEventGettersUsed(entry)
	}

	def needsObservable(Event it) {
		useOutEventObservables && direction === Direction.OUT
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
		getStatechart.isInternalEventBuffer && hasLocalEvents
	}

	def boolean needsInEventQueue(ExecutionFlow it) {

		isEventDriven && useInEventQueue
	}

	def boolean needsRunCycleGuard(ExecutionFlow it) {
		needsInEventQueue
	}

	def boolean isQueued(EventDefinition it) {
		isEventDriven && (isLocalEvent || (isInEvent && useInEventQueue))
	}

	def boolean needsEventNamespace(ExecutionFlow it) {
		needsEventClasses
	}

	def boolean needsEventClasses(ExecutionFlow it) {
		isEventDriven && (flow.hasLocalEvents || (flow.hasInEvents && useInEventQueue))
	}

	def boolean useInEventQueue() {
		entry.statechart.isInEventBuffer
	}

	/**
	 * Can be overridden to check for deprecated inEventQueue feature. Defaults to false. Can be removed if not used anymore.
	 */
	def boolean useInEventQueueDeprecated() {
		false
	}

	def getQueuedEvents(ExecutionFlow it) {
		it.allEvents.filter[isQueued]
	}

	def boolean hasQueuedEvents(ExecutionFlow it) {
		!queuedEvents.empty
	}

	def hasQueuedEventsWithValue(ExecutionFlow it) {
		!queuedEventsWithValue.empty
	}

	def getQueuedEventsWithValue(ExecutionFlow it) {
		queuedEvents.filter[hasValue]
	}

	def dispatch Statechart getStatechart(ExecutionFlow it) {
		it.sourceElement as Statechart
	}

	def dispatch Statechart getStatechart(GeneratorEntry it) {
		it.elementRef as Statechart
	}
}
