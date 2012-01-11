package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.EnterState
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.OnCycleEvent
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.TimeEventSpec

class SexecExtensions {
	
	def factory() { SexecFactory::eINSTANCE }
	
	
	
	def newEnterStateStep(ExecutionState s) {
		var EnterState ess
		if (s != null) {
			ess = factory.createEnterState
			ess.state = s	
		}
		return ess
	}
	
	
	def newExitStateStep(ExecutionState s) {
		var ExitState ess  
		if (s != null) {
			ess = factory.createExitState
			ess.state = s	
		}
		return ess
	}
	
	
	def newCase(ExecutionState it, Step step) {
		val sCase = factory.createStateCase
		sCase.state = it
		sCase.step = step
		return sCase
	}
	 
	
	
	def last(StateVector sv) {
		sv.offset + sv.size -1
	}
	
	def first(StateVector sv) {
		sv.offset
	}
}