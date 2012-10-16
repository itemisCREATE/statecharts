package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.stext.stext.VariableDefinition

class FlowCode {
	
	@Inject extension Naming
	@Inject extension ExpressionCode
	
	def stepComment(Step it) '''
		«IF comment != null && ! comment.empty»
			/* «comment» */
		«ENDIF»
	'''
	
	def dispatch code(Step it) '''
		//ERROR: FlowCode for Step '«getClass().name»' not defined
	'''
	
	def dispatch code(StateSwitch it) '''
		«IF historyRegion != null»
			switch(historyVector[«historyRegion.historyVector.offset»]) {
		«ELSE»
			switch(stateVector[«stateConfigurationIdx»]) {
		«ENDIF»
			«FOR stateCase : cases»
				case «stateCase.state.stateName.asEscapedIdentifier» : 
					«stateCase.step.code»
					break;
				
			«ENDFOR»
			default: 
				break;
		}
	'''
	
	def dispatch code(ScheduleTimeEvent it) '''
		«stepComment»
		getTimerService().setTimer(«timeEvent.name.asEscapedIdentifier», «timeValue.code», cycleStartTime);
	'''
	
	def dispatch code(UnscheduleTimeEvent it) '''
		«stepComment»
		getTimerService().resetTimer(«timeEvent.name.asEscapedIdentifier»);
	'''
	
	def dispatch code(Execution it) {
		'''
		«statement.code»;
		'''
	}
	
	def dispatch code(Call it) '''
		«step.functionName()»();
	'''
	
	def dispatch code(Sequence it) {
		steps.map[code].join('\n')
	}
	
	def dispatch code(Check it) '''
		«IF this != null»
			«condition.code()»
		«ELSE»
			true
 		«ENDIF»
	'''
	
	def dispatch code(CheckRef it) '''
		«IF check != null»
			«comment»
			«check.functionName()»()
		«ELSE»
			true
		«ENDIF»
	'''
	
	def dispatch code(Reaction it) {
		effect.code
	}
	
	def dispatch code(If it) '''
		«stepComment»
		if («check.code») { 
			«thenStep.code»
		}
		«IF elseStep != null»
		else {
			«elseStep.code»
		}
		«ENDIF»
	'''
	
	def dispatch code(EnterState it) '''
		«stepComment»
		nextStateIndex = «state.stateVector.offset»;
		stateVector[«state.stateVector.offset»] = State.«state.stateName.asEscapedIdentifier»;
	'''
	
	def dispatch code(ExitState it) '''
		«stepComment»
		nextStateIndex = «state.stateVector.offset»;
		stateVector[«state.stateVector.offset»] = State.«getNullStateName()»;
	'''
	
	def dispatch code(HistoryEntry it) '''
		«stepComment»
		if (historyVector[«region.historyVector.offset»] != State.$NullState$) {
			«historyStep.code»
		} else {
			«initialStep.code»
		}
	'''
	
	def dispatch code(SaveHistory it) '''
		«stepComment»
		historyVector[«region.historyVector.offset»] = stateVector[«region.stateVector.offset»];
	'''
	
	def String getInitialValueAssignment(VariableDefinition it) {
		if (initialValue != null) {
			return " = " + initialValue.code
		}
		else {
			return ""
		}
	}
}