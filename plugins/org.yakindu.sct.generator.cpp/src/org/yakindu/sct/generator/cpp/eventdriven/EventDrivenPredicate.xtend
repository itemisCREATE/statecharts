/**
 * Copyright (c) 2018 committers of YAKINDU and others.
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
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.extensions.AnnotationExtensions
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenPredicate {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	@Inject protected GeneratorEntry entry
	@Inject protected extension AnnotationExtensions
	
	def boolean isEventDriven() {
		entry.isEventDriven
	}
	
	def boolean needsQueues(ExecutionFlow it) {
		needsInternalEventQueue
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
	
	def boolean isQueued(EventDefinition it) {
		isEventDriven && isLocalEvent
	}
	
	def boolean needsEventNamespace(ExecutionFlow it) {
		isEventDriven && flow.hasLocalEvents
	}
}