/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - minimized changes on execution context
 * 
 */
@Singleton
class DefaultExecutionFlowInterpreter implements IExecutionFlowInterpreter {

	@Inject
	protected IStatementInterpreter statementInterpreter
	@Inject
	ITimingService timingService
	@Inject extension SexecExtensions
	@Inject(optional=true)
	ITraceStepInterpreter traceInterpreter
	@Inject protected extension ExecutionContextExtensions

	protected ExecutionFlow flow
	protected ExecutionContext executionContext
	protected ExecutionState[] activeStateConfiguration
	protected Map<Integer, ExecutionState> historyStateConfiguration
	protected List<Step> executionStack
	protected int activeStateIndex

	boolean suspended = false

	override initialize(ExecutionFlow flow, ExecutionContext context) {
		this.flow = flow
		executionContext = context
		executionStack = newLinkedList()
		activeStateConfiguration = newArrayOfSize(flow.stateVector.size)
		activeStateIndex = 0
		historyStateConfiguration = newHashMap()
		if (!executionContext.snapshot)
			flow.initSequence.scheduleAndRun
	}

	override enter() {
		if (!executionContext.snapshot)
			flow.enterSequences?.defaultSequence?.scheduleAndRun
		else {
			executionContext.activeStates.forEach[state|
				activeStateConfiguration.set(state.toExecutionState.stateVector.offset, state.toExecutionState)]
		}
	}

	def ExecutionState toExecutionState(RegularState state) {
		return flow.eAllContents.filter[
			it instanceof ExecutionState && EcoreUtil::equals((it as ExecutionState).sourceElement, state)].head as ExecutionState
	}

	override runCycle() {
		executionContext.raiseScheduledEvents
		activeStateIndex = 0
		if(executionContext.executedElements.size > 0) executionContext.executedElements.clear
		executionContext.clearOutEvents
		while (activeStateIndex < activeStateConfiguration.size) {
			var state = activeStateConfiguration.get(activeStateIndex)
			state?.reactSequence?.scheduleAndRun
			activeStateIndex = activeStateIndex + 1
		}
		executionContext.clearLocalAndInEvents
	}

	override resume() {
		executionContext.suspendedElements.clear
		suspended = false
		run
	}

	override suspend() {
		suspended = true
	}

	override exit() {
		flow.exitSequence.scheduleAndRun
	}

	override tearDown() {
		timingService.stop
	}

	def scheduleAndRun(Step step) {
		schedule(step)
		run
	}

	def run() {
		while (!executionStack.empty && !suspended) {
			var head = executionStack.head
			executionStack.remove(head)
			head.execute
		}
	}

	def schedule(Step step) {
		executionStack.add(0, step)
	}

	def dispatch Object execute(Call call) {
		call.step.schedule
		null
	}

	def dispatch Object execute(Step step) {
	}

	def dispatch Object execute(Trace trace) {
		traceInterpreter?.evaluate(trace, executionContext)
		null
	}

	def dispatch Object execute(Check check) {
		if (check.condition == null)
			return true
		return statementInterpreter.evaluateStatement(check.condition, executionContext)

	}

	def dispatch Object execute(EnterState enterState) {
		activeStateConfiguration.set(enterState.state.stateVector.offset, enterState.state)
		executionContext.activeStates += enterState.state.sourceElement as RegularState
		activeStateIndex = enterState.state.stateVector.offset // mark all state vector elements up to this as processed ...		
		null
	}

	def dispatch Object execute(Execution execution) {
		statementInterpreter.evaluateStatement(execution.statement, executionContext)
	}

	def dispatch Object execute(ExitState exitState) {
		activeStateConfiguration.set(exitState.state.stateVector.offset, null)
		var activeStates = executionContext.activeStates.filter[EcoreUtil::equals(it, exitState.state.sourceElement)]
		executionContext.activeStates.removeAll(activeStates)
		null
	}

	def dispatch Object execute(If ifStep) {
		var check = execute(ifStep.check)
		if (check as Boolean) {
			ifStep.thenStep.schedule
		} else if (ifStep.elseStep != null) {
			ifStep.elseStep.schedule
		}
		null
	}

	def dispatch Object execute(Sequence sequence) {
		sequence.steps.reverseView.forEach[schedule]
		null
	}

	def dispatch Object execute(SaveHistory action) {
		var region = action.region
		historyStateConfiguration.put(region.historyVector.offset,
			activeStateConfiguration.get(region.stateVector.offset))
	}

	def dispatch Object execute(HistoryEntry entry) {
		if (historyStateConfiguration.get(entry.region.historyVector.offset) != null) {
			entry.historyStep?.execute
		} else {
			entry.initialStep?.execute
		}
		null
	}

	def dispatch Object execute(StateSwitch stateSwitch) {
		val historyRegion = stateSwitch.historyRegion
		if (historyRegion != null) {
			val historyState = historyStateConfiguration.get(historyRegion.historyVector.offset)
			stateSwitch.cases.filter[it.state == historyState].forEach[step.schedule]
		} else {
			stateSwitch.cases.filter[activeStateConfiguration.contains(state)].forEach[step.schedule]
		}
		null
	}

	def dispatch Object execute(ScheduleTimeEvent scheduleTimeEvent) {
		var timeEvent = scheduleTimeEvent.timeEvent
		var duration = statementInterpreter.evaluateStatement(scheduleTimeEvent.timeValue, executionContext)
		timingService.scheduleTimeEvent(executionContext, timeEvent.name, timeEvent.periodic, duration as Integer)
		null
	}

	def dispatch Object execute(UnscheduleTimeEvent timeEvent) {
		timingService.unscheduleTimeEvent(timeEvent.timeEvent.name)
		null
	}

}
