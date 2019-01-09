/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.sct.model.sexec.Return
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Statement
import org.yakindu.sct.model.sexec.TraceStateEntered
import org.yakindu.sct.model.sexec.TraceStateExited
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.model.sgen.GeneratorEntry

class FlowCode extends org.yakindu.sct.generator.c.FlowCode {
	
	@Inject extension CppNaming naming
	@Inject extension CppExpressionsGenerator expressions
	@Inject extension SExecExtensions
	@Inject extension INamingService
	@Inject extension GenmodelEntries
	
	@Inject GeneratorEntry entry
	
	override dispatch CharSequence code(SaveHistory it) '''
		«stepComment»
		«HISTORYVECTOR»[«region.historyVector.offset»] = «STATEVECTOR»[«region.stateVector.offset»];
	'''
	
	override dispatch CharSequence code(HistoryEntry it) '''
		«stepComment»
		if («HISTORYVECTOR»[«region.historyVector.offset»] != «null_state»)
		{
			«historyStep.code»
		} «IF initialStep !== null»else
		{
			«initialStep.code»
		} «ENDIF»
	'''

	override dispatch CharSequence code(StateSwitch it) '''
		«stepComment»
		«IF historyRegion !== null»
			switch(«HISTORYVECTOR»[ «historyRegion.historyVector.offset» ])
			{
		«ELSE»
			switch(«STATEVECTOR»[ «stateConfigurationIdx» ])
			{
		«ENDIF»
			«FOR caseid : cases»
				case «caseid.state.shortName» :
				{
					«caseid.step.code»
					break;
				}
			«ENDFOR»
			default: break;
		}
	'''
	
	override dispatch CharSequence code(TraceStateEntered it) '''
		«IF entry.tracingEnterState»
		«flow.tracingInstance»->«flow.enterStateTracingFctID»(«flow.module»::«it.state.stateName»);
		«ENDIF»
	'''
	
	override dispatch CharSequence code(TraceStateExited it) '''
		«IF entry.tracingExitState»
		«flow.tracingInstance»->«flow.exitStateTracingFctID»(«flow.module»::«it.state.stateName»);
		«ENDIF»
	'''

	override dispatch CharSequence code(ScheduleTimeEvent it) '''
		«stepComment»
		«timerInstance»->«SET_TIMER»(this, (sc_eventid)(&«timeEventsInstance»[«timeEvent.indexOf»]), «timeValue.code», «IF timeEvent.periodic»true«ELSE»false«ENDIF»);
	'''

	override dispatch CharSequence code(UnscheduleTimeEvent it) '''
		«stepComment»
		«timerInstance»->«UNSET_TIMER»(this, (sc_eventid)(&«timeEventsInstance»[«timeEvent.indexOf»]));
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
		'''«IF condition !== null»«condition.code»«ELSE»true«ENDIF»'''
	
	override dispatch CharSequence code(CheckRef it) 
		'''«IF check !== null»«check.shortName»()«ELSE»true«ENDIF»'''
		
    override dispatch CharSequence code(If it) '''
		«stepComment»
		if («check.code»)
		{ 
			«thenStep.code»
		} «IF (elseStep !== null)» else
		{
			«elseStep.code»
		}
		«ENDIF»
	'''
	
	override dispatch CharSequence code(EnterState it) '''
		«STATEVECTOR»[«state.stateVector.offset»] = «state.shortName»;
		«STATEVECTOR_POS» = «state.stateVector.offset»;
	'''

	override dispatch CharSequence code(ExitState it) '''
		«STATEVECTOR»[«state.stateVector.offset»] = «null_state»;
		«STATEVECTOR_POS» = «state.stateVector.offset»;
	'''
	
	override dispatch CharSequence code(Return it) '''
		return«IF value !== null» «value.code»«ENDIF»;
	'''
	
	override dispatch CharSequence code(LocalVariableDefinition it) '''
		«variable.typeSpecifier.targetLanguageName» «variable.name»«IF initialValue !== null» = «initialValue.code»«ENDIF»;
	'''
	
	override dispatch CharSequence code(Statement it) '''
		«expression.code»;
	'''
}