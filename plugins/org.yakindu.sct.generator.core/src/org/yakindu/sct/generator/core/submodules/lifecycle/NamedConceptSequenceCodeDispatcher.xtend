/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.submodules.lifecycle

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.concepts.EnterMethod
import org.yakindu.sct.model.sexec.concepts.EventProcessing
import org.yakindu.sct.model.sexec.concepts.ExitMethod
import org.yakindu.sct.model.sexec.concepts.RunCycleMethod
import org.yakindu.sct.model.sexec.concepts.StateMachineBehaviorConcept
import org.yakindu.sct.model.sexec.concepts.InitializedCheck

/**
 * Instances of this class dispatches the generation of named sequences representing state machine concepts 
 * to specific code generator modules.
 * 
 * @author aterfloth 
 */
class NamedConceptSequenceCodeDispatcher implements NamedConceptSequenceCode {
	
	@Inject extension MicroStepCode
	@Inject extension InitializedCheckCode
	@Inject extension EventCode
	@Inject extension TraceCode
	
	@Inject extension StateMachineBehaviorConcept
	 
	override stateMachineConceptCode(ExecutionFlow flow, Sequence s) {
		switch (s.name) {
			case RunCycleMethod.MICRO_STEP :
				return flow.microStepCode
			case EventProcessing.CLEAR_EVENT:
				return flow.eventClearCode(s.expression)
			case EventProcessing.MOVE_EVENT:
				return flow.eventMoveCode(s.expression, s.getExpression(1))
			case EventProcessing.NEXT_EVENT:
				return flow.eventNextCode
			case EnterMethod.TRACE_ENTER:
				return flow.traceEnterCode
			case ExitMethod.TRACE_EXIT:
				return flow.traceExitCode
			case InitializedCheck.INIT_CHECK :
				return flow.initializedCheckCode
			default : 
				return '''// unknown concept sequence : «s.name»'''
		}		
	}
}