package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Inject
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.sgraph.Statechart

class SuperStep {
	
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	@Inject extension StatechartAnnotations
	

	static val String STATE_CHANGED = "stateConfVectorChanged"
	
	
	def void defineFeatures (ExecutionFlow it) {
		if (appliesSuperStep) 
			it.features += _variable(STATE_CHANGED, _boolean)		
	}

	def org.yakindu.base.types.Property hasStateChanged(ExecutionFlow it) {
		features.filter( typeof(Property) ).filter( m | m.name == STATE_CHANGED).head
	}

	
	def Step _superStepLoop(ExecutionFlow it, Step body) {
		
		if (appliesSuperStep)
			_do( _sequence(
				hasStateChanged._assign(_false),
				body
			))._while(hasStateChanged._ref)
		else 
			body
	}
	
	def _stateChanged(ExecutionFlow it) {
		if (stateChangedProperty !== null) 
			stateChangedProperty._assign(_true)
		else
			_empty
	}	
	
	def Property stateChangedProperty(ExecutionFlow it) {
		features.filter( typeof(Property) ).filter( m | m.name == STATE_CHANGED).head
	}
	
	
	def appliesSuperStep(ExecutionFlow it) {
		(it.sourceElement as Statechart).isSuperStep
	}
}