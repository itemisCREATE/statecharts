package org.yakindu.sct.generator.csharp

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
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import java.util.List
import org.yakindu.sct.model.sexec.TimeEvent

class FlowCode {
	
	@Inject extension Naming
	@Inject extension ExpressionCode
	@Inject extension SExecExtensions
	
	private var List<TimeEvent> timeEvents;
	
	def stepComment(Step it) '''
		«IF comment != null && ! comment.empty»
			/* «comment» */
		«ENDIF»
	'''
	
	def dispatch code(Step it) '''
		//ERROR: FlowCode for Step '«getClass().name»' not defined
	'''
	
	def dispatch CharSequence code(StateSwitch it) '''
		«IF historyRegion != null»
			switch(historyVector[«historyRegion.historyVector.offset»]) {
		«ELSE»
			switch(stateVector[«stateConfigurationIdx»]) {
		«ENDIF»
			«FOR stateCase : cases»
				case State.«stateCase.state.stateName.asEscapedIdentifier» : 
					«stateCase.step.code»
					break;
				
			«ENDFOR»
			default: 
				break;
		}
	'''
	
	def dispatch CharSequence code(ScheduleTimeEvent it) '''
		«stepComment»
		
		timer.setTimer(this, «getTimeEvents.indexOf(timeEvent)», «timeValue.code», «IF timeEvent.periodic»true«ELSE»false«ENDIF»);
	'''
	
	def dispatch CharSequence code(UnscheduleTimeEvent it) '''
		«stepComment»
		timer.unsetTimer(this, «getTimeEvents.indexOf(timeEvent)»);
	'''
	
	def dispatch CharSequence code(Execution it) {
		'''
		«statement.code»;
		'''
	}
	
	def dispatch CharSequence code(Call it) '''
		«step.functionName()»();
	'''
	
	def dispatch CharSequence code(Sequence it) {
		steps.map[code].join('\n')
	}
	
	def dispatch CharSequence code(Check it) '''
		«IF this != null»
			«condition.code()»
		«ELSE»
			true
 		«ENDIF»
	'''
	
	def dispatch CharSequence code(CheckRef it) '''
		«IF check != null»
			«comment»
			«check.functionName()»()
		«ELSE»
			true
		«ENDIF»
	'''
	
	def dispatch CharSequence code(Reaction it) {
		effect.code
	}
	
	def dispatch CharSequence code(If it) '''
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
	
	def dispatch CharSequence code(EnterState it) '''
		«stepComment»
		nextStateIndex = «state.stateVector.offset»;
		stateVector[«state.stateVector.offset»] = State.«state.stateName.asEscapedIdentifier»;
	'''
	
	def dispatch CharSequence code(ExitState it) '''
		«stepComment»
		nextStateIndex = «state.stateVector.offset»;
		stateVector[«state.stateVector.offset»] = State.«getNullStateName()»;
	'''
	
	def dispatch CharSequence code(HistoryEntry it) '''
		«stepComment»
		if (historyVector[«region.historyVector.offset»] != State.$NullState$) {
			«historyStep.code»
		} «IF initialStep != null»else {
			«initialStep.code»
		} «ENDIF»
	'''
	
	def dispatch CharSequence code(SaveHistory it) '''
		«stepComment»
		historyVector[«region.historyVector.offset»] = stateVector[«region.stateVector.offset»];
	'''
	
	def private getTimeEvents(Step it) {
		if (timeEvents==null) {
			timeEvents = flow.timeEvents
		}
		return timeEvents
	}
}