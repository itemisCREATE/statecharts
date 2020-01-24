/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * @author mazesch
 */
class Tracing implements IContentTemplate {

	@Inject extension Naming
	@Inject extension GenmodelEntries
	@Inject extension CLiterals

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «tracingModule.define»_H_
		#define «tracingModule.define»_H_
		
		#ifdef __cplusplus
		extern "C"
		{
		#endif 
		
		#include "sc_types.h"
		
		/*! Enumeration of all trace event types */
		typedef enum
		{
			sc_trace_machine_enter,
			sc_trace_machine_exit,
			sc_trace_machine_run_cycle_start,
			sc_trace_machine_run_cycle_end,
			sc_trace_state_entered,
			sc_trace_state_exited,
			sc_trace_event_raised,
			sc_trace_variable_set,
			sc_trace_time_event_raised,
			sc_trace_time_event_set,
			sc_trace_time_event_unset
		} sc_trace_event;
		
		
		/*! function pointer type for statechart life cycle trace events. */
		typedef void (*sc_trace_fp)(void* handler, void* machine, sc_trace_event event);
		
		/*! function pointer type for feature change events. Features can be events, variables, and properties. */
		typedef void (*sc_trace_feature_fp)(void* handler, void* machine, sc_trace_event event, sc_integer feature_id, const void * payload);
		
		/*! function pointer type for state change events. */
		typedef void (*sc_trace_state_fp)(void* handler, void* machine, sc_trace_event event, sc_integer state_id);
		
		/*! function pointer type for time event processing events. */
		typedef void (*sc_trace_time_event_fp)(void* handler, void* machine, sc_trace_event event, sc_integer tevid);
		
		/*! The trace handler ist a struct that contains pointers to trace functions which handle the different kind of trace events. */
		typedef struct
		{
			sc_trace_fp trace;
			sc_trace_feature_fp traceFeature;
			sc_trace_time_event_fp traceTimeEvent;
			sc_trace_state_fp traceState;
		} sc_trace_handler;
		
		
		#define SC_TRACE(MACHINE, EVENT) \
			if (MACHINE->trace_handler != sc_null && MACHINE->trace_handler->trace != sc_null) {\
				MACHINE->trace_handler->trace(MACHINE->trace_handler, MACHINE, EVENT);\
			}
		
		#define SC_TRACE_FEATURE(MACHINE, TEVENT, FEATURE, PAYLOAD) \
			if (MACHINE->trace_handler != sc_null && MACHINE->trace_handler->traceFeature != sc_null) {\
				MACHINE->trace_handler->traceFeature(MACHINE->trace_handler, MACHINE, TEVENT, FEATURE, PAYLOAD);\
			}
		
		#define SC_TRACE_TIME_EVENT(MACHINE, TEVENT, FEATURE) \
			if (MACHINE->trace_handler != sc_null && MACHINE->trace_handler->traceTimeEvent != sc_null) {\
				MACHINE->trace_handler->traceTimeEvent(MACHINE->trace_handler, MACHINE, TEVENT, FEATURE);\
			}
		
		#define SC_TRACE_STATE(MACHINE, TEVENT, STATE) \
			if (MACHINE->trace_handler != sc_null && MACHINE->trace_handler->traceState != sc_null) {\
				MACHINE->trace_handler->traceState(MACHINE->trace_handler, MACHINE, TEVENT, STATE);\
			}
		
		
		#ifdef __cplusplus
		}
		#endif
		
		#endif /* «tracingModule.define»_H_ */
	'''
}
