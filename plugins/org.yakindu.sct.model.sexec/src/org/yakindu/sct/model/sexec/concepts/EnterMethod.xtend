package org.yakindu.sct.model.sexec.concepts

import com.google.inject.Inject
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ng.EventProcessing
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.ng.StateMachineConcept
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Method

class EnterMethod {

	public static val TRACE_ENTER = StateMachineConcept.CONCEPT_NAME_PREFIX + "traceEnter"
	public static val ENTER = "enter"

	@Inject protected extension ExecutionGuard
	@Inject protected extension EventProcessing

	@Inject protected extension SExecExtensions
	@Inject protected extension TypeBuilder
	@Inject protected extension SexecBuilder
	
	def defineFeatures (ExecutionFlow it) {
		defineEnter	
	}
	
	def defineEnter(ExecutionFlow it) {
		
		it._method(ENTER) => [ m |
			m._public
			m._type(_void)
			m._body(
				_guardExecution( _sequence(
					_traceEnter,
					enterSequences.defaultSequence
				))
			)
		]
	}

	def Step _traceEnter(ExecutionFlow it) {
		_conceptSequence(TRACE_ENTER)	
	}
	
	
	def Method enter(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == ENTER).head
	}
	
}
