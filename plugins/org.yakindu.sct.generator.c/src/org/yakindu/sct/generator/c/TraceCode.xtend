/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.TraceStateEntered
import org.yakindu.sct.model.sexec.TraceStateExited
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author axel terfloth
 */
class TraceCode {
	
 	@Inject extension GenmodelEntries
 	@Inject extension Naming
	@Inject extension SExecExtensions
 
 	@Inject GeneratorEntry entry
 		

	def dispatch CharSequence traceCode(Trace it) '''
		«callTraceHook»
		«IF (entry.tracingGeneric)»«notifyTrace»«ENDIF»
	'''


	def dispatch CharSequence traceCode(Object it) {
		if (entry.tracingGeneric) notifyTrace else ''''''
	}

	def CharSequence traceCode(Object it, Object value) {
		if (entry.tracingGeneric) it.notifyTrace(value) else null
	}

	def CharSequence traceTimeEventRaised(ExecutionFlow it) {
		if (entry.tracingGeneric) '''
			«INT_TYPE» tev_id = time_event_index(«scHandle», evid);
			«it.traceFctID»_TIME_EVENT(«scHandle», «TRACE_MACHINE_TIME_EVENT_RAISED», tev_id);
		'''
	}
	
	def CharSequence traceMachineEnter(ExecutionFlow it) {
		if (entry.tracingGeneric) '''
			«it.traceFctID»(«scHandle», «TRACE_MACHINE_ENTER»);
		'''
	}

	def CharSequence traceMachineExit(ExecutionFlow it) {
		if (entry.tracingGeneric) '''
			«it.traceFctID»(«scHandle», «TRACE_MACHINE_EXIT»);
		'''
	}

	def CharSequence traceCycleStart(ExecutionFlow it) {
		if (entry.tracingGeneric) '''
			«it.traceFctID»(«scHandle», «TRACE_MACHINE_CYCLE_START»);
		'''
	}
	
	def CharSequence traceCycleEnd(ExecutionFlow it) {
		if (entry.tracingGeneric) '''
			«it.traceFctID»(«scHandle», «TRACE_MACHINE_CYCLE_END»);
		'''
	}
		

	def protected dispatch notifyTrace(Object it) ''''''
	
	def protected dispatch notifyTrace(Object it, Object value) ''''''
	
	def protected dispatch notifyTrace(VariableDefinition it, Object value) 
		'''«flow.tracingPrefix»FEATURE(«scHandle», «TRACE_MACHINE_VARIABLE_SET», «flow.featureNamingPrefix»«it.name», «value»)'''

	def protected dispatch notifyTrace(EventDefinition it, Object value) 
		'''«flow.tracingPrefix»FEATURE(«scHandle», «TRACE_MACHINE_EVENT_RAISED», «flow.featureNamingPrefix»«it.name», «value»)'''

	def protected dispatch notifyTrace(TraceStateEntered it) '''
		«TRACE_CALL»_STATE(«scHandle», «TRACE_MACHINE_ENTERED», «state.stateName»);
	'''

	def protected dispatch notifyTrace(TraceStateExited it) '''
		«TRACE_CALL»_STATE(«scHandle», «TRACE_MACHINE_EXITED», «state.stateName»);
	'''

	def protected dispatch notifyTrace(ScheduleTimeEvent it) '''
		«TRACE_CALL»_TIME_EVENT(«scHandle», «TRACE_MACHINE_TIME_EVENT_SET», «flow.timeEvents.indexOf(timeEvent)»);
	'''
	
	def protected dispatch notifyTrace(UnscheduleTimeEvent it) '''
		«TRACE_CALL»_TIME_EVENT(«scHandle», «TRACE_MACHINE_TIME_EVENT_UNSET», «flow.timeEvents.indexOf(timeEvent)»);
	'''


	def protected dispatch callTraceHook(Trace it) '''''' 

	def protected dispatch callTraceHook(TraceStateEntered it) '''
		«IF entry.tracingEnterState»
			«flow.enterStateTracingFctID»(«scHandle», «it.state.stateName»);
		«ENDIF»
	'''

	def protected dispatch callTraceHook(TraceStateExited it) '''
		«IF entry.tracingExitState»
			«flow.exitStateTracingFctID»(«scHandle», «it.state.stateName»);
		«ENDIF»
	'''
	
	
}