/** 
 * Copyright (c) 2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Operation

/**
 * React method is an artifact concepts that is created for each state machine state and the statechart
 * itself. It defines the react behavior for each reactive element of the state machine. 
 * 
 * @author Axel Terfloth - terfloth@itemis.de
 *  
 */
class ReactMethod {
	
	@Inject extension SexecElementMapping mapping
	@Inject extension SexecExtensions sexec
	@Inject extension SgraphExtensions sgraph
	@Inject extension StatechartAnnotations
	
	@Inject extension TypeBuilder typeBuilder
	@Inject extension ExpressionBuilder exprBuilder
	@Inject extension SexecBuilder sexecBuilder
	
	
	/**
	 * Declares the react methods for all ExecutionNode objects. This are the ExecutionStates and the ExecutionFlow itself.
	 */	
	def declareReactMethods(ExecutionFlow it) {

		flow.declareReactMethod		
		states.forEach[s | s.declareReactMethod ]
	}
	
	/**
	 * Define the react methods for all ExecutionNode objects. This are the ExecutionStates and the ExecutionFlow itself.
	 */	
	def defineReactMethods(ExecutionFlow it) {

		if (flow.reactMethod !== null) flow.defineReactMethod
		states.forEach[s | s.defineReactMethod ]
		
	}
	
	def dispatch ExecutionNode declareReactMethod(RegularState state) {
		state.create.declareReactMethod
	}	
	

	def dispatch ExecutionNode declareReactMethod(Statechart statechart) {	
		statechart.flow.declareReactMethod 
	}	

	def dispatch ExecutionNode declareReactMethod(ExecutionNode node) {
		node => [
			features.add( sexecFactory.createMethod => [ m |
				m.name = "react"
				m._type(_boolean)
				m._param("try_transition", _boolean)
			])
		]
	}

	def dispatch ExecutionNode declareReactMethod(ExecutionFlow node) {
		node => [
			features.add( sexecFactory.createMethod => [ m |
				m.name = "react"
				m._type(_boolean)
			])
		]
	}

	
	def defineReactMethod(ExecutionFlow it) {
		reactMethod => [ body = 
			_sequence(
				flow.createLocalReactionSequence,
				_return(_false)	
			) => [ comment = "State machine reactions."]	
		]		
	}
	
	
	
	def defineReactMethod(ExecutionState execState) {
		
		val state = execState.sourceElement as RegularState
		val reactMethod = execState.reactMethod
		val childFirst = state.statechart.isChildFirstExecution
				
		val parentNode = if (state.parentState !== null) state.parentState.create else execState.flow
		val processParent = 	   parentNode !== null
							&& (	    ( childFirst && parentNode.impactVector.last == execState.impactVector.last)
							     || (!childFirst && parentNode.stateVector.offset == execState.stateVector.offset)
							   )
				 				
		if (state.statechart.interleaveLocalReactions) {
			
			val tryTransitionParam = reactMethod.param('try_transition')
			val didTransitionVariable = _variable("did_transition", _boolean)
			
				
			val stateReactions = 
				_sequence(
					_declare(didTransitionVariable)._with(_ref(tryTransitionParam)),
					
					_if(tryTransitionParam._ref)
						._then (
							if (processParent && !childFirst) 
								_if(parentNode.callReact(_ref(tryTransitionParam))._equals(_false))
									._then ( 
										execState.createReactionSequence(
											didTransitionVariable._assign(_false)) 
									)	
							else
								execState.createReactionSequence(
									didTransitionVariable._assign(_false))
						),
								
					if ( execState.localReactions.size > 0 || (processParent && childFirst ))
						_if(didTransitionVariable._ref._equals(_false))
							._then(
								_sequence(
									execState.createLocalReactionSequence => [
										if (processParent && childFirst) 
											_step(didTransitionVariable._assign(parentNode.callReact(_ref(tryTransitionParam))))	
									])		
							)
					else _sequence(), // empty sequence ...
						
					_return(didTransitionVariable._ref)
				)
								
			reactMethod.body = stateReactions
			
		} else {
			
			throw new RuntimeException("Non interleaved local reactions not supported");
		}
				
		reactMethod.body.comment = 'The reactions of state ' + state.name + '.'
		
		return reactMethod
	} 
	


	def dispatch callReact(ExecutionState state, Expression p)  { _call(state.reactMethod)._with(p) }

	def dispatch callReact(ExecutionFlow flow, Expression p)  { _call(flow.reactMethod) }
	

	
	def Method reactMethod(ExecutionNode it) {
		features.filter( typeof(Method) ).filter( m | m.name == "react").head
	}
	
	def Parameter param(Operation it, String name) {
		parameters.filter[ p | p.name == name].head
	}
	
	
	
	 
	 		
	def Sequence createLocalReactionSequence(ExecutionNode state) {	

		 _sequence(
			state.reactions.filter(r | ! r.transition ).map[ lr | 
				_if(lr.check.newRef)
					._then(lr.effect.newCall)
			]	
		)				
	}


	def Sequence createReactionSequence(ExecutionNode state, Step localStep) {	
		val cycle = sexec.factory.createSequence
		cycle.name = "react"
		
		var localSteps = sexec.factory.createSequence		
		if (localStep !== null) localSteps.steps += localStep
		if (localSteps.steps.empty) localSteps = null
				
		val transitionReactions = state.reactions.filter(r | r.transition && ! r.unchecked ).toList
		val transitionStep = transitionReactions.reverseView.fold(localSteps as Step, [s, reaction | {
				var ifStep = sexec.factory.createIf
				ifStep.check = reaction.check.newRef		
				ifStep.thenStep = reaction.effect.newCall
				ifStep.elseStep = s
				ifStep as Step
			}])

		if (transitionStep !== null) cycle.steps.add(transitionStep)		
		else if (localSteps!== null) cycle.steps.add(localSteps)
		
		return cycle
	}
	
	
	def localReactions(ExecutionNode it) {
		reactions.filter[ r | ! r.transition ].toList	
	}
	
}