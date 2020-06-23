package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.concepts.ExecutionGuard
import org.yakindu.sct.model.sexec.extensions.SexecBuilder

class RunCycleMethod {
	
	@Inject extension ExecutionGuard
	@Inject extension EventProcessing
	@Inject extension SuperStep
	
	@Inject extension TypeBuilder
	@Inject extension SexecBuilder
	

	public static val MICRO_STEP = StateMachineConcept.CONCEPT_NAME_PREFIX + "microStep"
	
	def defineFeatures (ExecutionFlow it) {
		defineRunCycle	
	}
			
	def defineRunCycle(ExecutionFlow it) {
		
		it._method("runCycle") => [ m |
			m._public
			m._type(_void)
			m._body(
				_guardExecution( _sequence(
					_traceBeginRunCycle,
					_eventProcessing(
						_superStepLoop(
							_microStep	
						)
					),
					_traceEndRunCycle
				))
			)
		]
	}

	def Step _microStep(ExecutionFlow it) {
		_conceptSequence(MICRO_STEP)
	}
		
	def Method runCycle(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == "runCycle").head
	}
	

	
}