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

		it.statechart.historyStateVector._ref
						._get(it.create.historyVector.offset._int)
						._assign(it.statechart.stateVector._ref._get(it.create.stateVector.offset._int))			
	}
	 
	 
	def Expression _enterState(RegularState state) {
		//		«stepComment»
		//TODO:		nextStateIndex = «state.stateVector.offset»;
		//		stateVector[«state.stateVector.offset»] = State.«state.stateName.asEscapedIdentifier»;

		_block(
			
			stateVector(state.statechart)._ref
							._get(state.create.stateVector.offset._int)
							._assign(state.statechart.statesEnumeration._ref._fc(state.enumerator))					
		)

		
		
	} 
}