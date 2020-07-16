/**
 * Copyright (c) 2018-2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.FlowCode
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.concepts.EnterMethod
import org.yakindu.sct.model.sexec.concepts.EventProcessing
import org.yakindu.sct.model.sexec.concepts.ExecutionGuard
import org.yakindu.sct.model.sexec.concepts.ExitMethod
import org.yakindu.sct.model.sexec.concepts.RunCycleMethod
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.InterfaceScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.base.types.Event

/**
 * @author rbeckmann
 * @author Axel Terfloth - terfloth@itemis.de 
 * 
 */

@Singleton
class APIGenerator {
	@Inject protected extension FlowCode
	@Inject protected extension INamingService
	@Inject protected extension Naming
	@Inject protected extension SExecExtensions
	@Inject protected extension StateVectorExtensions
	@Inject protected extension CLiterals
	@Inject protected extension StatechartAnnotations
	@Inject protected extension GeneratorPredicate
	@Inject protected extension TraceCode
	@Inject protected extension GeneratorEntry genEntry
	@Inject protected extension GenmodelEntries
	@Inject protected extension ShadowEventExtensions
	@Inject protected extension InternalFunctionsGenerator
	@Inject protected extension EventNaming
	
	@Inject protected extension EnterMethod
	@Inject protected extension ExitMethod	
	@Inject protected extension RunCycleMethod
	@Inject protected extension ExecutionGuard
	@Inject protected extension EventProcessing


	
	def tracing(ExecutionFlow it){
		if (timed) 
		'''
		static «INT_TYPE» time_event_index(«scHandleDecl», «EVENT_TYPE» evid);
		
		static «INT_TYPE» time_event_index(«scHandleDecl», «EVENT_TYPE» evid)
		{
			«INT_TYPE» tev_id = ((«INTPTR_TYPE»)evid - («INTPTR_TYPE»)&(«scHandle»->timeEvents)) / sizeof(«BOOL_TYPE»);
			return tev_id;
		}
		'''
		else ''''''
	}

	def initWithTracing(ExecutionFlow it) {
		'''
		void «initTracingFctID»(«scHandleDecl», «TRACE_HANDLER_TYPE» *trace_handler)
		{
			«initFunctionBody(it)»
			«scHandle»->trace_handler = trace_handler;
		}
		'''
	}
	
	def init(ExecutionFlow it) {
		'''
			«initSignature»
			{
				«IF genEntry.tracingGeneric»
				«initTracingFctID»(«scHandle», «CLiterals::NULL_LITERAL_NAME»);
				«ELSE»
				«initFunctionBody(it)»
				«ENDIF»
			}
		'''
	}
	
	protected def CharSequence initFunctionBody(ExecutionFlow it) {
		'''
			«INT_TYPE» i;
			
			for (i = 0; i < «maxOrthogonalStates»; ++i)
			{
				«scHandle»->«STATEVECTOR»[i] = «null_state»;
			}
			
			«IF hasHistory»
				for (i = 0; i < «maxHistoryStates»; ++i)
				{
					«scHandle»->«HISTORYVECTOR»[i] = «null_state»;
				}
			«ENDIF»
			
			«scHandle»->«STATEVECTOR_POS» = 0;
			
			«_clearInEvents.code»
			«_clearInternalEvents.code»
			«_clearOutEvents.code»

			«IF useOutEventObservables»
				«initializeObservables»
			«ENDIF»
			«initializeObserver»

			«initSequence.code»
			
			«_initIsExecuting.code»
		'''
	}
	
	protected def CharSequence initializeObserver(ExecutionFlow it){
		'''
		«FOR e : shadowEvents»
			sc_single_subscription_observer«e.eventType»_init(&(«e.accessObserver»), «scHandle», («e.functionType»)«e.observerCallbackFctID»);
		«ENDFOR»
		'''
	}
	
	def private functionType(Event it) {
		if (hasValue) {
			return '''sc_observer_next«eventType»_fp'''
		}
		return OBSERVER_NEXT_FP_TYPE
	}
	
	
	def initializeObservables(ExecutionFlow it) {
		'''
		«FOR outEvent : scopes.filter(InterfaceScope).map[events].flatten.filter[direction === Direction.OUT]»
			sc_observable«outEvent.eventType»_init(&«outEvent.accessObservable»);
		«ENDFOR»
		'''
	}
	
	def protected CharSequence initSignature(ExecutionFlow it) {
		'''void «initFctID»(«scHandleDecl»)'''
	}

	def declareInit(ExecutionFlow it) {
		'''«initSignature»;'''
	}

	
	def isActive(ExecutionFlow it) {
		'''
			«isActiveSignature»
			{
				«BOOL_TYPE» result = «FALSE_LITERAL»;
				«INT_TYPE» i;
				
				for(i = 0; i < «maxOrthogonalStates»; i++)
				{
					result = result || «scHandle»->«STATEVECTOR»[i] != «null_state»;
				}
				
				return result;
			}
		'''
	}

	def declareIsActive(ExecutionFlow it) {
		'''«isActiveSignature»;'''
	}
	
	def protected CharSequence isActiveSignature(ExecutionFlow it) {
		'''«BOOL_TYPE» «isActiveFctID»(const «scHandleDecl»)'''
	}

	def isStateActive(ExecutionFlow it) {
		'''
			«isStateActiveSignature»
			{
				«BOOL_TYPE» result = «FALSE_LITERAL»;
				switch (state)
				{
					«FOR s : states»
						case «s.stateName» :
							result = («BOOL_TYPE») («IF s.leaf»«scHandle»->«STATEVECTOR»[«s.stateVectorDefine»] == «s.stateName»
							«ELSE»«scHandle»->«STATEVECTOR»[«s.stateVectorDefine»] >= «s.stateName»
								&& «scHandle»->«STATEVECTOR»[«s.stateVectorDefine»] <= «s.subStates.last.stateName»«ENDIF»);
							break;
					«ENDFOR»
					default:
						result = «FALSE_LITERAL»;
						break;
				}
				return result;
			}
			'''
	}

	def declareIsStateActive(ExecutionFlow it) {
		'''«isStateActiveSignature»;'''
	}
	
	def protected CharSequence isStateActiveSignature(ExecutionFlow it) {
		'''«BOOL_TYPE» «stateActiveFctID»(const «scHandleDecl», «statesEnumType» state)'''
	}

	def isFinal(ExecutionFlow it) {
		val fsiv = flow.finalStateImpactVector

		'''
			«IF !fsiv.isCompletelyCovered»
				/* 
				 * Always returns 'false' since this state machine can never become final.
				 */
			«ENDIF»
			«isFinalSignature»
			{
				«IF (fsiv.isCompletelyCovered)»
					return 
					«FOR i : 0 ..<fsiv.size SEPARATOR ' && '»(
						«FOR fs : fsiv.get(i) SEPARATOR ' || '»
							«scHandle»->«STATEVECTOR»[«i»] == «IF fs.stateVector.offset == i»«fs.stateName»«ELSE»«null_state»«ENDIF»
						«ENDFOR»)
					«ENDFOR»;
				«ELSE»
					«unusedParam(scHandle)»
					return «FALSE_LITERAL»;
				«ENDIF»
			}
		''' 
	}

	def declareIsFinal(ExecutionFlow it) {
		'''«isFinalSignature»;'''
	}
	
	def protected CharSequence isFinalSignature(ExecutionFlow it) {
		'''«BOOL_TYPE» «isFinalFctID»(const «scHandleDecl»)'''
	}
	
	def raiseTimeEvent(ExecutionFlow it) {
		'''
			«raiseTimeEventSignature»
			{
				if ( ((«INTPTR_TYPE»)evid) >= ((«INTPTR_TYPE»)&(«scHandle»->timeEvents))
					&&  ((«INTPTR_TYPE»)evid) < ((«INTPTR_TYPE»)&(«scHandle»->timeEvents)) + (unsigned)sizeof(«timeEventScope.type»))
					{
					*(«BOOL_TYPE»*)evid = «TRUE_LITERAL»;
					«traceTimeEventRaised»
				}		
			}
		'''
	}
	
	def declareRaiseTimeEvent(ExecutionFlow it) {
		'''«raiseTimeEventSignature»;'''
	}
	
	def protected CharSequence raiseTimeEventSignature(ExecutionFlow it) {
		'''void «raiseTimeEventFctID»(«scHandleDecl», «EVENT_TYPE» evid)'''
	}
	
	def declareInitWithTracing(ExecutionFlow it) {
		'''«initWithTracingSignature»;'''
	}
	
	def protected CharSequence initWithTracingSignature(ExecutionFlow it) {
		'''void «initTracingFctID»(«scHandleDecl», «scTracingHandleDecl»)'''
	}
	
	def declareSetTraceHandler(ExecutionFlow it) {
		'''«setTraceHandlerSignature»;'''
	}
	
	def protected CharSequence setTraceHandlerSignature(ExecutionFlow it){
		'''void «setTraceHandlerFctID»(«scHandleDecl», «scTracingHandleDecl»)'''
	}
	
}
