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
package org.yakindu.sct.model.sexec.transformation.ng.operations

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ng.StateType
import org.yakindu.sct.model.sexec.transformation.ng.StatemachinePublic
import org.yakindu.sct.model.sexec.transformation.ng.expressions.ReactionToExpression
import org.yakindu.sct.model.sexec.transformation.ng.vectors.ImpactVector
import org.yakindu.sct.model.sexec.transformation.ng.vectors.StateVector
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Pseudostate
import org.yakindu.sct.model.sgraph.ReactiveElement
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.DefaultTrigger
import org.yakindu.sct.model.stext.stext.EntryEvent
import org.yakindu.sct.model.stext.stext.ExitEvent
import org.yakindu.sct.model.stext.stext.ReactionTrigger

/**
 * React method is an artifact concepts that is created for each state machine state and the statechart
 * itself. It defines the react behavior for each reactive element of the state machine. 
 * 
 * @author Axel Terfloth - terfloth@itemis.de
 *  
 */
class ReactOperation {
	
	@Inject extension SgraphExtensions
	@Inject extension ExpressionBuilder
	@Inject extension TypeBuilder
	@Inject extension StatemachinePublic
	@Inject extension StateType
	@Inject extension StatechartExtensions sct
	
	@Inject extension ImpactVector
	@Inject extension StateVector
	
	@Inject extension ReactionToExpression
	
	/**
	 * Declares the react methods for all ExecutionNode objects.
	 */	
	def declareReactMethods(Statechart sc) {

		sc.declareReactMethod
		
		sc.allRegularStates.forEach[s|s.declareReactMethod]
		sc.allChoices.forEach[s|s.declareReactMethod]
		sc.allSynchronizations.forEach[s|s.declareReactMethod]
	}
	
	/**
	 * Define the react methods for all ExecutionNode objects.
	 */	
	def defineReactMethods(Statechart sc) {

		if(sc.reactMethod !== null) sc.defineReactMethod

		sc.allRegularStates.forEach[s|s.defineReactMethod]
		sc.allChoices.forEach[s|s.defineReactMethod]
		sc.allSynchronizations.forEach[s|s.defineReactMethod]
	}

	def dispatch declareReactMethod(RegularState state) {
		state.type.features.add( _op => [ m |
			m.name = "react"
			m._type(ITypeSystem.BOOLEAN)
			m._param("try_transition", ITypeSystem.BOOLEAN)
		])
		state
	}
	
	def dispatch declareReactMethod(Pseudostate state) {
		state.type.features.add( _op("react", ITypeSystem.VOID))
		state
	}

	def dispatch declareReactMethod(Statechart sc) {
		sc.statemachineType.features.add( _op("react", ITypeSystem.BOOLEAN))
		sc
	}
	
	def dispatch defineReactMethod(Statechart sc) {
		sc.reactMethod => [ 
			body = _block(
				sc.createLocalReactionSequence,
				_return(_false)	
			)
			_comment("State machine reactions.")
		]		
	}
	
	def dispatch defineReactMethod(Pseudostate state) {
		state.reactMethod => [ 
			body = _block(
				state.createReactionSequence
			)
			_comment("Pseudo state reactions.")	
		]		
	}
	
	def dispatch defineReactMethod(RegularState state) {
		
		val reactMethod = state.reactMethod
		val childFirst = sct.statechart(state).isChildFirstExecution
				
		val parentNode = if (state.parentState !== null) state.parentState else sct.statechart(state)
		
		val processParent = parentNode !== null
							&& (( childFirst && parentNode.impactVector.last == state.impactVector.last)
							     || (!childFirst && parentNode.stateVector.offset == state.stateVector.offset)
							   )
				 				
		if (sct.statechart(state).interleaveLocalReactions) {
			
			val tryTransitionParam = reactMethod.parameters.findFirst[name == 'try_transition']
			val didTransitionVariable = _variable("did_transition", ITypeSystem.BOOLEAN, tryTransitionParam._ref)
			
				
			val stateReactions = 
				_block(
					didTransitionVariable,
					
					_if(tryTransitionParam._ref)
						._then (
							if (processParent && !childFirst) {
								_block(
									_if(parentNode.callReact(_ref(tryTransitionParam))._equals(_false))
										._then ( 
											state.createReactionSequence(didTransitionVariable._ref._assign(_false))
										)	
								)
							} else {
								state.createReactionSequence(didTransitionVariable._ref._assign(_false))
							}
						),

					if (state instanceof State) {
						if (state.localReactions.filter[!trigger.isEntry && !trigger.isExit].size > 0 || (processParent && childFirst )) {
							_if(didTransitionVariable._ref._equals(_false))
								._then(
									state.createLocalReactionSequence => [
										if (processParent && childFirst) 
											expressions += didTransitionVariable._ref._assign(parentNode.callReact(_ref(tryTransitionParam)))	
									]
								)
						}
					} else { _block }, // empty block ...
						
					_return(didTransitionVariable._ref)
				)
								
			reactMethod.body = stateReactions
			
		} else {
			throw new RuntimeException("Non interleaved local reactions not supported");
		}
				
		reactMethod._comment = 'The reactions of state ' + state.name + '.'
		
		return reactMethod
	}
	
	def dispatch callReact(State state, Expression p)  { _call(state.reactMethod)._with(p) }
	def dispatch callReact(Statechart sc, Expression p)  { _call(sc.reactMethod) }
	
	def dispatch Operation reactMethod(Statechart sc) { sc.statemachineType.reactMethod }
	def dispatch Operation reactMethod(Vertex state) { state.type.reactMethod }
	def dispatch Operation reactMethod(ComplexType it) { features.filter(Operation).findFirst[name == "react"] }
	
	def protected dispatch isEntry(Trigger t) { false }
	def protected dispatch isEntry(ReactionTrigger t) {
		!t.triggers.empty && t.triggers.forall[tr | tr instanceof EntryEvent]
	}
	
	def protected dispatch isExit(Trigger t) { false }
	def protected dispatch isExit(ReactionTrigger t) {
		!t.triggers.empty && t.triggers.forall[tr | tr instanceof ExitEvent]
	}

	def protected BlockExpression createLocalReactionSequence(ReactiveElement state) {
		_block(
			state.localReactions.filter[!trigger.isEntry && !trigger.isExit].map[mapLocalReaction]
		)
	}
	
	def protected dispatch BlockExpression createReactionSequence(Pseudostate it) {
		_block
	}
	
	def protected dispatch BlockExpression createReactionSequence(Synchronization sync) {
		val cycle = _block
		
		val reaction = sync.outgoingTransitions.head
		cycle.expressions += reaction.mapTransition
		cycle._comment('The reactions of state ' + sync.name + '.')
		
//		if ( trace.addTraceSteps ) execSync.reactSequence.steps.add(0,sync.create.newTraceNodeExecuted)
		
		return cycle
	}
	
	def protected dispatch BlockExpression createReactionSequence(Choice choice) {
		val cycle = _block

		val reactions = choice.outgoingTransitions.toList
		
		// move the default transition to the end of the reaction list
		val defaultTransition = choice.outgoingTransitions.filter( t | t.trigger === null || t.trigger instanceof DefaultTrigger ).head
		if (defaultTransition !== null) {
			reactions.remove(defaultTransition)
			reactions.add(defaultTransition)
		}
		// TODO: raise an error if no default exists 
		
		val transitionStep = reactions.reverseView.fold(null, [s, reaction | {
				val ifExp = mapTransition(reaction)
				if (s !== null) ifExp._else(_block(s))
				ifExp
			}])

		if (transitionStep !== null) cycle.expressions.add(transitionStep)

		cycle._comment('The reactions of state ' + choice.name + '.')
		
//		if ( trace.addTraceSteps ) execChoice.reactSequence.steps.add(0,choice.create.newTraceNodeExecuted)
		return cycle
	}
	
	def protected BlockExpression createReactionSequence(RegularState state, Expression localStep) {	
		val cycle = _block

		val transitionReactions = state.outgoingTransitions.filter[tr | tr.trigger !== null].toList
		
		val transitionStep = transitionReactions.reverseView.fold(localStep, [s, r | {
				mapTransition(r)._else(_block(s))
			}])

		if (transitionStep !== null) cycle.expressions.add(transitionStep)
		else if (localStep !== null) cycle.expressions.add(localStep)
		
		return cycle
	}
	
}
