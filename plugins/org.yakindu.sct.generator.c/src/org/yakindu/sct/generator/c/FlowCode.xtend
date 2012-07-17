package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sgraph.Statement

class FlowCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	
	def expCode (Statement it) '''
		#warning TODO: generate code for «getClass().name»
	'''
 
	def stepComment(Step it) '''
		«IF comment != null && ! comment.empty»
			/* «comment» */
		«ENDIF»
	'''
	
	def dispatch code(Step it) '''
		#warning ActionCode for Step '«getClass().name»' not defined
	'''

	def dispatch code(SaveHistory it) '''
		«stepComment»
		«scHandle»->historyVector[«region.historyVector.offset»] = «scHandle»->stateConfVector[«region.stateVector.offset»];
	'''
	
	def dispatch code(HistoryEntry it) '''
		«stepComment»
		if («scHandle»->historyVector[«region.historyVector.offset»] != last_state) {
			«historyStep.code»
		} else {
			«initialStep.code»
		}
	'''

	def dispatch code(StateSwitch it) '''
		«stepComment»
		«IF historyRegion != null»
			switch(«scHandle»->historyVector[ «historyRegion.historyVector.offset» ]) {
		«ELSE»
			switch(«scHandle»->stateConfVector[ «stateConfigurationIdx» ]) {
		«ENDIF»
			«FOR caseid : cases»
				case «caseid.state.name.asIdentifier» : {
					«caseid.step.code»
					break;
				}
			«ENDFOR»
			default: break;
		}
	'''

	def dispatch code(ScheduleTimeEvent it) '''
		«stepComment»
		// TODO: schedule time event id:
		«flow.type.toFirstLower»_setTimer( EVID , «timeValue.expCode», «IF timeEvent.periodic»true«ELSE»false«ENDIF»);
	'''

	def dispatch code(UnscheduleTimeEvent it) '''
		«stepComment»
		// TODO: unschedule time event id:
		«flow.type.toFirstLower»_unsetTimer( EVID );		
	'''

	def dispatch code(Execution it) '''
		«statement.expCode»
	'''
	
	def dispatch code(Call it) '''
		#warning TODO: call function(handle)
	'''

	def dispatch code(Sequence it) '''
		«stepComment»
		«FOR s : steps»«s.code»«ENDFOR»
	'''	

	def dispatch code(Check it) '''
		«IF condition != null»«condition.expCode»«ELSE»true«ENDIF»
	'''
	
	def dispatch code(CheckRef it) '''
		«IF check != null»callcheckfunc(handle)«ELSE»true«ENDIF»
	'''

	def dispatch code(If it) '''
		«stepComment»
		if («check.code») { 
			«thenStep.code»
		} «IF (elseStep != null)» else {
			«elseStep.code»
		}
		«ENDIF»
	'''
	
	def dispatch code(EnterState it) '''
		«scHandle»->stateConfVector[«state.stateVector.offset»] = «state.name.asIdentifier»;
		«scHandle»->stateConfVectorPosition = «state.stateVector.offset»;
	'''

	def dispatch code(ExitState it) '''
		«scHandle»->stateConfVector[«state.stateVector.offset»] = last_state;
		«scHandle»->stateConfVectorPosition = «state.stateVector.offset»;
	'''
}
