/**
 * Copyright (c) 2018-2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
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
	
	@Inject extension SexecElementMapping mapping
	@Inject extension StatemachinePublic smPublic 
	@Inject extension StatemachineProperties smPropos 
	@Inject extension SgraphExtensions sgraph
	@Inject extension ExpressionBuilder eBuilder
	
	
	def Expression _saveHistory(Region it) {
		
		// from code henerator: historyVector[«region.historyVector.offset»] = stateVector[«region.stateVector.offset»];

		it.statechart.historyVector._ref
						._get(it.create.historyVector.offset._int)
						._assign(it.statechart.stateVector._ref._get(it.create.stateVector.offset._int))			
	}
	 
	 
	def Expression _enterState(RegularState state) {
		//		«stepComment»
		//		nextStateIndex = «state.stateVector.offset»;
		//		stateVector[«state.stateVector.offset»] = State.«state.stateName.asEscapedIdentifier»;

		_block(
			state.statechart.nextStateIndex._ref
				._assign(state.create.stateVector.offset._int),
				
			stateVector(state.statechart)._ref
				._get(state.create.stateVector.offset._int)
				._assign(state.statechart.statesEnumeration._ref._fc(state.enumerator))
		)

	}
	
	def Expression _exitState(RegularState state) {
		_block(
			state.statechart.nextStateIndex._ref._assign(0._int),
				
			stateVector(state.statechart)._ref
				._get(state.create.stateVector.offset._int)
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
	 
}