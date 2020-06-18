package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.base.types.Event
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Sequence

class EventProcessing {


	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	
	@Inject extension StatechartAnnotations
	@Inject extension SExecExtensions
	@Inject extension StateMachineConcept
	

	public static val CLEAR_EVENT = StateMachineConcept.CONCEPT_NAME_PREFIX + "clearEvent"
	public static val CLEAR_OUT_EVENTS = "clearOutEvents"
	public static val CLEAR_IN_EVENTS = "clearInEvents"


	def defineFeatures (ExecutionFlow it) {
		if (hasOutgoingEvents) defineClearOutEvents
		if (hasInEvents) it._method("clearInEvents") => [ _type(_void) ]
		
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
	
	def Step _clear(Event it){
		_conceptSequence(CLEAR_EVENT, it)	
	}
	
	def Event event(Sequence it){
		it.getParameter as Event
	}
	
	def Step _eventProcessing(ExecutionFlow it, Step body) {
		_sequence(
			_clearOutEvents,
			body,
			_clearInEvents
		)
	}


	def Step _clearOutEvents(ExecutionFlow it) {
			if ( hasOutgoingEvents ) clearOutEvents._call._statement else _empty	
	}


	def Step _clearInEvents(ExecutionFlow it) {
			if ( hasOutgoingEvents ) clearInEvents._call._statement else _empty	
	}


	def Method clearOutEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_OUT_EVENTS).head
	}
	
	def Method clearInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_IN_EVENTS).head
	}
	


	
	
}