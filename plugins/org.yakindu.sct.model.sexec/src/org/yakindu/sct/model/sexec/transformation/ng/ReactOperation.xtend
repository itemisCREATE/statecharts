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
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

/**
 * React method is an artifact concepts that is created for each state machine state and the statechart
 * itself. It defines the react behavior for each reactive element of the state machine. 
 * 
 * @author Axel Terfloth - terfloth@itemis.de
 *  
 */
class ReactOperation {
	
	@Inject extension SexecElementMapping mapping
	@Inject extension SexecExtensions sexec
	@Inject extension SgraphExtensions sgraph
	@Inject extension ExpressionBuilder exprBuilder
	@Inject extension TypeBuilder tBuilder
	@Inject extension StatemachinePublic smPublic
	@Inject extension StateType stateType
	
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
		node	
	}

	def dispatch ExecutionNode declareReactMethod(ExecutionState node) {
		node => [
			(node.sourceElement as RegularState).type.features.add( _op => [ m |
				m.name = "react"
				m._type(_bool)
				m._param("try_transition", _bool)
			])
		]
	}

	def dispatch ExecutionNode declareReactMethod(ExecutionFlow node) {
		node => [
			node.statechart.statemachineType.features.add( _op => [ m |
				m.name = "react"
				m._type(_bool)
			])
		]
	}
	
	def defineReactMethod(ExecutionFlow ef) {
		ef.reactMethod => [ body = 
			_block(
				ef.createLocalReactionSequence,
				_return(_false)	
			) => [ _comment = "State machine reactions."]	
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
			val didTransitionVariable = _variable("did_transition", _bool, tryTransitionParam._ref)
			
				
			val stateReactions = 
				_block(
					didTransitionVariable,
					
					_if(tryTransitionParam._ref)
						._then (
							if (processParent && !childFirst) {
								_block(
									_if(parentNode.callReact(_ref(tryTransitionParam))._equals(_false))
										._then ( 
											execState.createReactionSequence(didTransitionVariable._ref._assign(_false))
										)	
								)
							} else {
								execState.createReactionSequence(didTransitionVariable._ref._assign(_false))
							}
						),
					if ( execState.localReactions.size > 0 || (processParent && childFirst ))
						_if(didTransitionVariable._ref._equals(_false))
							._then(
								execState.createLocalReactionSequence => [
									if (processParent && childFirst) 
										didTransitionVariable._ref._assign(parentNode.callReact(_ref(tryTransitionParam)))	
								]
							)
					else _block, // empty block ...
						
					_return(didTransitionVariable._ref)
				)
								
			reactMethod.body = stateReactions
			
		} else {
			
			throw new RuntimeException("Non interleaved local reactions not supported");
		}
				
		reactMethod._comment = 'The reactions of state ' + state.name + '.'
		
		return reactMethod
	} 

	def dispatch callReact(ExecutionState state, Expression p)  { _call(state.reactMethod)._with(p) }

	def dispatch callReact(ExecutionFlow flow, Expression p)  { _call(flow.reactMethod) }
	
	def _statement(Expression value) {
		sexecFactory.createStatement => [
			expression = value
		]	
	}
	
	def Parameter param(Operation it, String name) {
		parameters.filter[ p | p.name == name].head
	}
	
	def dispatch Operation reactMethod(ExecutionFlow it) {
		it.statechart.statemachineType.reactMethod
	}
	
	def dispatch Operation reactMethod(ExecutionState it) {
		(it.sourceElement as RegularState).type.reactMethod
	}
	
	def dispatch Operation reactMethod(ComplexType it) {
		features.filter( typeof(Operation) ).filter( m | m.name == "react").head
	}
	
	
	def _bool() {
		return ITypeSystem::BOOLEAN
	}
	
	def BlockExpression createLocalReactionSequence(ExecutionNode state) {	
		_block(
			state.reactions.filter(r | ! r.transition ).map[ lr | 
				_if(lr.checkOperation._call)._then(_block(lr.effectOperation._call))
			]	
		)				
	}
	
	def create op : _op checkOperation(Reaction it) {
		op.name = ("check" + "_" + it.name)
		op._type(_bool)
		val parentState = (it.eContainer as ExecutionNode).sourceElement as State
		parentState.type.features += op
		
		val condition = it.check?.condition
		op.body = if (condition !== null) {
			_block(_return(condition))
		} else {
			_block
		}
	}
	
	def create op : _op effectOperation(Reaction it) {
		op.name = ("effect" + "_" + it.name)
		val parentState = (it.eContainer as ExecutionNode).sourceElement as State
		parentState.type.features += op
		
		// TODO: effect steps need to be expressions
		op.body = _block
//		val actions = (it.effect as Execution).statement
//		op.body = if (actions !== null) {
//			_block(actions)
//		} else {
//			_block
//		}
	}

	def BlockExpression createReactionSequence(ExecutionNode state, Expression localStep) {	
		val cycle = _block

		val transitionReactions = state.reactions.filter(r | r.transition && ! r.unchecked ).toList
		
		val transitionStep = transitionReactions.reverseView.fold(localStep, [s, reaction | {
				_if(reaction.checkOperation._call)
				._then(_block(reaction.effectOperation._call))
				._else(_block(s))
			}])

		if (transitionStep !== null) cycle.expressions.add(transitionStep)
		else if (localStep !== null) cycle.expressions.add(localStep)
		
		return cycle
	}
	
	def localReactions(ExecutionNode it) {
		reactions.filter[ r | ! r.transition ].toList	
	}
	
}