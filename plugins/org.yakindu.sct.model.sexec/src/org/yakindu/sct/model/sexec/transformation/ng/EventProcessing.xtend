package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.eclipse.emf.ecore.EObject

class EventProcessing {


	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	
	@Inject extension StatechartAnnotations
	@Inject extension SExecExtensions
	@Inject extension StateMachineConcept
	@Inject protected extension EventBuffer
	

	public static val CLEAR_EVENT = StateMachineConcept.CONCEPT_NAME_PREFIX + "clearEvent"
	public static val CLEAR_OUT_EVENTS = "clearOutEvents"
	public static val CLEAR_IN_EVENTS = "clearInEvents"
	public static val CLEAR_INTERNAL_EVENTS = "clearInternalEvents"
	public static val TAKE_INTERNAL_EVENTS = "takeInternalEvents"


	def defineFeatures (ExecutionFlow it) {
		if (hasOutgoingEvents) defineClearOutEvents
		if (needsClearInEvents) defineClearInEvents
		if (hasLocalEvents) {
			defineClearInternalEvents
			defineTakeInternalEvents	
		}
	}


	def defineClearOutEvents(ExecutionFlow it) {
		it._method(CLEAR_OUT_EVENTS) => [ m | 
			m._type(_void)
			m._body(
				outgoingEvents.map[ o |
					o._clear
				]
			)
		]
	}
	
	def defineClearInEvents(ExecutionFlow it) {
		it._method(CLEAR_IN_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				#[flow.incomingEvents, flow.timeEvents].flatten.map[ i |
					i._clear
				]
			)
		]
	}
	
	def defineClearInternalEvents(ExecutionFlow it) {
		it._method(CLEAR_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				localEvents.map[ i |
					i._clear
				]
			)
		]
	}

	def defineTakeInternalEvents(ExecutionFlow it) {
		it._method(TAKE_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				it.eventBuffer.bufferEvents.asExpressions.map[ i |
					i._clear
				]
			)
		]
	}
	
	def Step _eventProcessing(ExecutionFlow it, Step body) {
		_sequence(
			_clearOutEvents,
			_eventLoop(_sequence(
				body,
				_clearInEvents	
			))
		)
	}


	def Step _eventLoop(ExecutionFlow it, Step body) {
		if (hasLocalEvents) 
			_do(_sequence(
				body,
				_takeInternalEvents
			))._while(
				localEvents.map[ e | e._ref as Expression].reduce[r1, r2| r1._or(r2)]
			)
		else 
			body	
	}

	def Step _clearOutEvents(ExecutionFlow it) {
		if ( hasOutgoingEvents ) clearOutEvents._call._statement else _empty	
	}


	def Step _clearInEvents(ExecutionFlow it) {
		if ( needsClearInEvents  ) clearInEvents._call._statement else _empty	
	}

	def Step _takeInternalEvents(ExecutionFlow it) {
		 takeInternalEvents._call._statement
	}



	def Step _clear(EObject it){
		_conceptSequence(CLEAR_EVENT, it)	
	}
	
	def Event event(Sequence it){
		it.getParameter as Event
	}
	

	def Method clearOutEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_OUT_EVENTS).head
	}
	
	def Method clearInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_IN_EVENTS).head
	}
	
	def Method takeInternalEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == TAKE_INTERNAL_EVENTS).head
	}
	

	def needsClearInEvents(ExecutionFlow it) {
		hasInEvents || timeEvents.size > 0 
	}

	
	
}