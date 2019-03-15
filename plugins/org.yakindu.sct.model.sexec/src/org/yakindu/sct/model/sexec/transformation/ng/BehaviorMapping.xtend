/**
 * Copyright (c) 2018 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.stext.stext.ReactionEffect

/**
 * Implements the lcaDoSequence for ReactMethods.
 *  
 * @author axel terfloth
 * 
 */
class BehaviorMapping extends org.yakindu.sct.model.sexec.transformation.BehaviorMapping {

	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sc
	@Inject extension SgraphExtensions sgraph
	@Inject extension SexecExtensions sexec
	@Inject extension ReactMethod rm
	
	@Inject extension ExpressionBuilder exprBuilder
	@Inject extension StatemachineExpressionBuilder smeBuilder
	@Inject extension StateOperations stateOps
	

	protected override Step lcaDoSequence(Region region, ExecutionFlow flow) {
		
		if ( region === null ) return null

		val execRegion = region.create
		
		val shouldExecuteParent = 
			if (! region.statechart.childFirstExecution) 
				[ExecutionScope parentScope, ExecutionScope execScope | false ]
			else
				[ExecutionScope parentScope, ExecutionScope execScope | 
					parentScope === execScope || parentScope.impactVector.last == execScope.impactVector.last
				]
		
		val parent = if (region.parentStates.head !== null) {
						region.parentStates.head.create
					} else {
						flow
					}


		if (shouldExecuteParent.apply(parent, execRegion)) {
			parent.callReact(_false)._statement
		}
	}
	
	
	/** 
	 * Overrides the base implementation to additionally create a entryAction operation.
	 * TODO: remove on cleanup
	 */
	override Step mapEntryAction(State state) {
		
		val eaSeq = super.mapEntryAction(state)
		
		state.defineEntryAction
		
		eaSeq
	}	


	/** Defines a states entry action.  */	
	def void defineEntryAction(State state) {

		state.entryAction.body = _block => [

			for (tes : state.timeEventSpecs ) {
				expressions += _scheduleTimeEvent(tes)
			}	
						
			state.entryReactions.forEach[ lr | expressions += lr._entryReaction]
		]
		
	}
	
}