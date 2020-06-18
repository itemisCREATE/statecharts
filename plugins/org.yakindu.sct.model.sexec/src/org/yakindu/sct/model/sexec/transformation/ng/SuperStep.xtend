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
	

	static val String HAS_STATE_CHANGED = "hasStataChanged"
	
	
	def void defineStructuralFeatures (ExecutionFlow it) {
		if (appliesSuperStep) 
			it.features += _variable(HAS_STATE_CHANGED, _boolean)		
	}

	def org.yakindu.base.types.Property hasStateChanged(ExecutionFlow it) {
		features.filter( typeof(Property) ).filter( m | m.name == HAS_STATE_CHANGED).head
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
	
	
	
	def appliesSuperStep(ExecutionFlow it) {
		(it.sourceElement as Statechart).isSuperStep
	}
}