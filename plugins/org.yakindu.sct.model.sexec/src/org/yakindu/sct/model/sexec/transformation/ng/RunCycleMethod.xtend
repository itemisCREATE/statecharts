package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Inject
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Method

class RunCycleMethod {
	
	
	@Inject extension SuperStep
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	

	public static val MICRO_STEP = StateMachineConcept.CONCEPT_NAME_PREFIX + "microStep"
	
	def defineStructuralFeatures (ExecutionFlow it) {
		it.features += _variable("isReacting", _boolean)		
	}
			
	def defineRunCycle(ExecutionFlow it) {
		it._method("clearOutEvents") => [ _type(_void) ]
		it._method("clearInEvents") => [ _type(_void) ]
		it._method("microStep") => [ _type(_void) ]
		
		it._method("runCycle") => [ m |
			m._type(_void)
			m._body(
				_guardExecution( _sequence(
					_traceBeginRunCycle,
					clearOutEvents._call._statement,
					_eventLoop(
						_superStepLoop(
							_microStep	
						)
					),
					clearInEvents._call._statement,
					_traceEndRunCycle
				))
			)
		]
	}


	def Step _guardExecution(ExecutionFlow it, Step body){
		_sequence(
			_if(isReactingProperty._ref)._then(_return(null)),
			isReactingProperty._assign(_true),
				
			body,
			
			isReactingProperty._assign(_false)	
		)
	}


	def Step _eventLoop(ExecutionFlow flow, Step body) {
		body
	}

	
	def Step _microStep(ExecutionFlow it) {
		//flow.microStep._call._statement
		_sequence => [ name = MICRO_STEP ]
	}
		

	def Property isReactingProperty(ExecutionFlow it) {
		features.filter( typeof(Property) ).filter( m | m.name == "isReacting").head
	}
	
	def Method clearOutEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == "clearOutEvents").head
	}
	
	def Method clearInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == "clearInEvents").head
	}
	
	def Method microStep(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == "microStep").head
	}

	
}