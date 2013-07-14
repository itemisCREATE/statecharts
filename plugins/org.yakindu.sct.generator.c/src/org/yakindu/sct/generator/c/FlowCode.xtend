/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
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

class FlowCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ExpressionCode
	
	
 
	def stepComment(Step it) '''
		«IF comment != null && ! comment.empty»
			/* «comment» */
		«ENDIF»
	'''
	
	def dispatch CharSequence code(Step it) '''
		#error ActionCode for Step '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(SaveHistory it) '''
		«stepComment»
		«scHandle»->historyVector[«region.historyVector.offset»] = «scHandle»->stateConfVector[«region.stateVector.offset»];
	'''
	
	def dispatch CharSequence code(HistoryEntry it) '''
		«stepComment»
		if («scHandle»->historyVector[«region.historyVector.offset»] != «last_state») {
			«historyStep.code»
		} «IF initialStep != null»else {
			«initialStep.code»
		} «ENDIF»
	'''

	def dispatch CharSequence code(StateSwitch it) '''
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

	def dispatch CharSequence code(ScheduleTimeEvent it) '''
		«stepComment»
		«flow.type.toFirstLower»_setTimer( (sc_eventid) &(«scHandle»->timeEvents.«timeEvent.name.asIdentifier»_raised) , «timeValue.code», «IF timeEvent.periodic»bool_true«ELSE»bool_false«ENDIF»);
	'''

	def dispatch CharSequence code(UnscheduleTimeEvent it) '''
		«stepComment»
		«flow.type.toFirstLower»_unsetTimer( (sc_eventid) &(«scHandle»->timeEvents.«timeEvent.name.asIdentifier»_raised) );		
	'''

	def dispatch CharSequence code(Execution it) 
		'''«statement.code»;'''
	
	def dispatch CharSequence code(Call it) 
		'''«step.functionName»(«scHandle»);'''

	def dispatch CharSequence code(Sequence it) '''
		«IF comment != null»
			{
				«stepComment»
				«FOR s : steps»
					«s.code»
				«ENDFOR»
			}
		«ELSE»
			«FOR s : steps»
				«s.code»
			«ENDFOR»
		«ENDIF»
	'''	

	def dispatch CharSequence code(Check it) 
		'''«IF condition != null»«condition.code»«ELSE»bool_true«ENDIF»'''
	
	def dispatch CharSequence code(CheckRef it) 
		'''«IF check != null»«check.functionName»(«scHandle»)«ELSE»bool_true«ENDIF»'''

	def dispatch CharSequence code(If it) '''
		«stepComment»
		if («check.code») { 
			«thenStep.code»
		} «IF (elseStep != null)» else {
			«elseStep.code»
		}
		«ENDIF»
	'''
	
	def dispatch CharSequence code(EnterState it) '''
		«scHandle»->stateConfVector[«state.stateVector.offset»] = «state.name.asEscapedIdentifier»;
		«scHandle»->stateConfVectorPosition = «state.stateVector.offset»;
	'''

	def dispatch CharSequence code(ExitState it) '''
		«scHandle»->stateConfVector[«state.stateVector.offset»] = «last_state»;
		«scHandle»->stateConfVectorPosition = «state.stateVector.offset»;
	'''
}
