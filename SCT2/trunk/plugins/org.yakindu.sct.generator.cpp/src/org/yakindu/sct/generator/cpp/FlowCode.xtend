package org.yakindu.sct.generator.cpp

import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.Call
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.naming.INamingService

class FlowCode extends org.yakindu.sct.generator.c.FlowCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ExpressionCode
	@Inject extension INamingService
	
	override dispatch CharSequence code(SaveHistory it) '''
		«stepComment»
		historyVector[«region.historyVector.offset»] = stateConfVector[«region.stateVector.offset»];
	'''
	
	override dispatch CharSequence code(HistoryEntry it) '''
		«stepComment»
		if (historyVector[«region.historyVector.offset»] != «last_state») {
			«historyStep.code»
		} «IF initialStep != null»else {
			«initialStep.code»
		} «ENDIF»
	'''

	override dispatch CharSequence code(StateSwitch it) '''
		«stepComment»
		«IF historyRegion != null»
			switch(historyVector[ «historyRegion.historyVector.offset» ]) {
		«ELSE»
			switch(stateConfVector[ «stateConfigurationIdx» ]) {
		«ENDIF»
			«FOR caseid : cases»
				case «caseid.state.shortName» : {
					«caseid.step.code»
					break;
				}
			«ENDFOR»
			default: break;
		}
	'''

	override dispatch CharSequence code(ScheduleTimeEvent it) '''
		«stepComment»
		«timerInstance»->setTimer(this, &«timeEventsInstance»[«timeEvent.indexOf»], «timeValue.code», «IF timeEvent.periodic»true«ELSE»false«ENDIF»);
	'''

	override dispatch CharSequence code(UnscheduleTimeEvent it) '''
		«stepComment»
		«timerInstance»->unsetTimer(this, &«timeEventsInstance»[«timeEvent.indexOf»]);
	'''
	
	override dispatch CharSequence code(Execution it) 
		'''«statement.code»;'''
	
	override dispatch CharSequence code(Call it) 
		'''«step.shortName»();'''
	
	override dispatch CharSequence code(Sequence it) '''
		«IF !steps.nullOrEmpty»«stepComment»«ENDIF»
		«FOR s : steps»
			«s.code»
		«ENDFOR»
	'''	
	
	override dispatch CharSequence code(Check it) 
		'''«IF condition != null»«condition.code»«ELSE»true«ENDIF»'''
	
	override dispatch CharSequence code(CheckRef it) 
		'''«IF check != null»«check.shortName»()«ELSE»true«ENDIF»'''
	
	override dispatch CharSequence code(EnterState it) '''
		stateConfVector[«state.stateVector.offset»] = «state.shortName»;
		stateConfVectorPosition = «state.stateVector.offset»;
	'''

	override dispatch CharSequence code(ExitState it) '''
		stateConfVector[«state.stateVector.offset»] = «last_state»;
		stateConfVectorPosition = «state.stateVector.offset»;
	'''
}