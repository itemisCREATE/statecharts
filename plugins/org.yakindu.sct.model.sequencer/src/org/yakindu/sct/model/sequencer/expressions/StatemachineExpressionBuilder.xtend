/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.expressions

import com.google.inject.Inject
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sequencer.types.StatemachineMethods
import org.yakindu.sct.model.sequencer.types.StatemachineProperties
import org.yakindu.sct.model.sequencer.types.StatemachinePublic
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sequencer.vectors.HistoryVector
import org.yakindu.sct.model.sequencer.vectors.StateVector
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.TimeUnit

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

/**
 * High level expression builder that covers state machine specific high level 
 * operations like enter state, exit state, save history etc..
 * 
 * TODO: move to types plugin
 * 
 * @author axel terfloth
 * @author thomas kutz
 */
class StatemachineExpressionBuilder {
	
	@Inject extension StatemachinePublic 
	@Inject extension StatemachineProperties 
	@Inject extension StatemachineMethods 
	@Inject extension SgraphExtensions
	@Inject extension ExpressionBuilder
	
	@Inject extension StateVector
	@Inject extension HistoryVector
	
	def Expression _saveHistory(Region it) {
		
		// from code generator: historyVector[«region.historyVector.offset»] = stateVector[«region.stateVector.offset»];

		statechart.historyVectorProperty._ref
						._get(historyVector.offset._int)
						._assign(statechart.stateVectorProperty._ref._get(stateVector.offset._int))
	}

	def Expression _enterState(RegularState it) {
		//		«stepComment»
		//		nextStateIndex = «state.stateVector.offset»;
		//		stateVector[«state.stateVector.offset»] = State.«state.stateName.asEscapedIdentifier»;

		_block(
			statechart.nextStateIndex._ref
				._assign(stateVector.offset._int),
				
			stateVectorProperty(statechart)._ref
				._get(stateVector.offset._int)
				._assign(statechart.statesEnumeration._ref._fc(enumerator))
		)

	}
	
	def Expression _exitState(RegularState state) {
		_block(
			state.statechart.nextStateIndex._ref._assign(0._int),
				
			stateVectorProperty(state.statechart)._ref
				._get(state.stateVector.offset._int)
				._assign(state.statechart.statesEnumeration._ref._fc(state.statechart.noState))
		)
	}
	
	
	/** TODO: schedule time events */
	def Expression _scheduleTimeEvent(TimeEventSpec tes) {
		_block	
	}
	
	/** TODO: schedule time events */
	def Expression _unscheduleTimeEvent(TimeEventSpec tes) {
		_block	
	}
	
	/** TODO: move to BehaviorMapping or somewhere else */
	def Expression _entryReaction(LocalReaction it) {
		if (effect !== null) {
			val guard = (trigger as ReactionTrigger).guard
			val lrEffect = effect as ReactionEffect
			
			val action = _block => [
				lrEffect.actions.forEach[ a | expressions += a.copy]
			]
			
			if ((trigger as ReactionTrigger).guard !== null) {
				_if(guard.expression.copy)._then( action )	
			} else {
				return action
			}
						
		} else null
	}
	
	/** TODO: move to BehaviorMapping or somewhere else */
	def Expression _exitReaction(LocalReaction it) {
		if (effect !== null) {
			val guard = (trigger as ReactionTrigger).guard
			val lrEffect = effect as ReactionEffect
			
			val action = _block => [
				lrEffect.actions.forEach[ a | expressions += a.copy]
			]
			
			if ((trigger as ReactionTrigger).guard !== null) {
				_if(guard.expression.copy)._then( action )	
			} else {
				return action
			}
						
		} else null
	}
	
	
	def Expression _timeValue(TimeEventSpec tes) {
		val pve = tes.value.copy

		switch (tes.unit) {
			case TimeUnit::MILLISECOND: pve
			case TimeUnit::MICROSECOND: pve._divide(1000._int)
			case TimeUnit::NANOSECOND: pve._divide(1000000._int)
			case TimeUnit::SECOND: pve._multiply(1000._int)
			default: pve
		}
	}
	
	def Expression _isStateActive(Statechart sc, State state) {
		sc.createIsStateActiveMethod._call(sc.statesEnumeration._ref._fc(state.enumerator))
	}
	 
}
