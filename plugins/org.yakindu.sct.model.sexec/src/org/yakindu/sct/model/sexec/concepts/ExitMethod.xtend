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

class ExitMethod {

	public static val TRACE_EXIT = StateMachineConcept.CONCEPT_NAME_PREFIX + "traceExit"
	public static val EXIT = "exit"

	@Inject protected extension ExecutionGuard
	@Inject protected extension EventProcessing

	@Inject protected extension SExecExtensions
	@Inject protected extension TypeBuilder
	@Inject protected extension SexecBuilder
	
	def defineFeatures (ExecutionFlow it) {
		defineExit	
	}
	
	def defineExit(ExecutionFlow it) {
		
		it._method(EXIT) => [ m |
			m._public
			m._type(_void)
			m._body(
				_guardExecution( _sequence(
					_traceExit,
					exitSequence
				))
			)
		]
	}

	def Step _traceExit(ExecutionFlow it) {
		_conceptSequence(TRACE_EXIT)	
	}
	
	def Method exit(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == EXIT).head
	}
	
	
}