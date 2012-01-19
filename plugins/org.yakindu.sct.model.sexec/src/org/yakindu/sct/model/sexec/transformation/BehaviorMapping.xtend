package org.yakindu.sct.model.sexec.transformation

import static extension org.eclipse.xtext.xtend2.lib.EObjectExtensions.*

import org.yakindu.sct.model.sgraph.State
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.TimeUnit
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sexec.Execution
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.LocalReaction
import java.util.List
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.OnCycleEvent
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.sgraph.RegularState
import java.util.ArrayList
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Entry
 

class BehaviorMapping {

	@Inject extension StatechartExtensions sc
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping factory
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension StateVectorBuilder svBuilder
	@Inject extension SequenceBuilder seqBuilder
	@Inject extension TraceExtensions trace


	def ExecutionFlow mapEntryActions(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates.filter(typeof(State))
		allStates.forEach( s | { s.create.entryAction = s.mapEntryAction() null } )
		return r
	}

	/** 
	 * The entry action sequence of a state consist all action that are specified with the 'entry' pseudo trigger within local reactions
	 * and all scheduling actions for time triggers.
	 */
	def Step mapEntryAction(State state) {
		val seq = sexec.factory.createSequence
		seq.name = "entryAction"
		seq.comment = "Entry action for state '" + state.name + "'."
		
		for (tes : state.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val scheduleStep = timeEvent.newScheduleTimeEvent(tes.buildValueExpression)
			seq.steps.add(scheduleStep)
		}	
		
		state.entryReactions
			.map([lr | if (lr.effect != null) { (lr.effect as ReactionEffect).mapEffect } else null])
			.forEach(e | if (e != null) { seq.steps.add(e) })
		
		if (seq.steps.size > 0) seq else null
	}	





	def ExecutionFlow mapExitActions(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates.filter(typeof(State))
		allStates.forEach( s | { s.create.exitAction = s.mapExitAction() null } )
		return r
	}



	/** 
	 * The exit action sequence of a state consist all action that are specified with the 'exit' pseudo trigger within local reactions
	 * and all unscheduling actions for time triggers.
	 */
	def Step mapExitAction(State state) {
		val seq = sexec.factory.createSequence
		seq.name = "exitAction"
		seq.comment = "Exit action for state '" + state.name + "'."
		
		
		for (tes : state.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val unscheduleStep = timeEvent.newUnscheduleTimeEvent()
			seq.steps.add(unscheduleStep)
		}	
		
		state.exitReactions
			.map([lr | if (lr.effect != null) { (lr.effect as ReactionEffect).mapEffect } else null])
			.forEach(e | if (e != null) { seq.steps.add(e) })
		
		if (seq.steps.size > 0) seq else null
	}
	


	def Statement buildValueExpression(TimeEventSpec tes) {
		val PrimitiveValueExpression pve = stext.factory.createPrimitiveValueExpression 
		val IntLiteral intLit = stext.factory.createIntLiteral
		intLit.value = tes.value
		pve.value = intLit
	
		switch (tes.unit) {
			case TimeUnit::MILLISECOND : pve
			case TimeUnit::NANOSECOND  : pve.divide(1000000)
			case TimeUnit::SECOND      : pve.multiply(1000)
			default : pve
		} 
	}
	
	def Statement divide(Expression stmnt, long divisor) {
		val NumericalMultiplyDivideExpression div = stext.factory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stext.factory.createPrimitiveValueExpression 
		val IntLiteral intLit = stext.factory.createIntLiteral
		intLit.value = divisor.intValue
		pve.value = intLit
		
		div.operator = MultiplicativeOperator::DIV
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}
	
	def Statement multiply(Expression stmnt, long factor) {
		val NumericalMultiplyDivideExpression div = stext.factory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stext.factory.createPrimitiveValueExpression 
		val IntLiteral intLit = stext.factory.createIntLiteral
		intLit.value = factor.intValue
		pve.value = intLit
		
		div.operator = MultiplicativeOperator::MUL
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}
	
		
	def dispatch Sequence mapEffect(Effect effect) {}
	
	def dispatch Sequence mapEffect(ReactionEffect effect) {
		if ( ! effect.actions.empty) {
			val sequence = sexec.factory.createSequence
			sequence.name = "reaction_action"
			sequence.steps.addAll( effect.actions.map( stmnt | stmnt.mapToExecution))
			return sequence	
		}	
	}
	
	def Execution mapToExecution(Statement stmnt) {
		val exec = sexec.factory.createExecution
		exec.statement = EcoreUtil::copy(stmnt)
		exec
	}
	
	def ExecutionFlow mapTransitions(Statechart statechart, ExecutionFlow r){
		var content = statechart.allContentsIterable
		val allStates = content.filter(typeof(State))
		allStates.forEach( s | s.mapStateTransition);
		return r
	}


	def ExecutionState mapStateTransition(State state) {
		val _state = state.create
		_state.reactions.addAll( state.outgoingTransitions.map(t | t.mapTransition))
		return _state
	}
	 
	def Reaction mapTransition(Transition t) {
		val r = t.create 
		if (t.trigger != null) r.check = mapToCheck(t.trigger)
		r.effect = mapToEffect(t, r)
		
		return r
	}
	
	def dispatch Check mapToCheck(Trigger tr) { null }
	  
	def dispatch Check mapToCheck(ReactionTrigger tr) {
		val check = tr.createCheck
		check.condition = tr.buildCondition;
		return check
	}
	
	def ExecutionFlow mapLocalReactions(Statechart statechart, ExecutionFlow r){
		var content = statechart.allContentsIterable
		val allStates = content.filter(typeof(State))
		allStates.forEach( s | (s as State).mapStateLocalReactions);
		return r
	}

	def ExecutionState mapStateLocalReactions(State state) {
		val _state = state.create
		
		_state.reactions.addAll( 
			state.localReactions
				.filter( typeof( LocalReaction ))
				// ignore all reaction that are just entry or exit actions
				.filter(lr | 
					(lr.trigger as ReactionTrigger).triggers.empty 
					|| ! (lr.trigger as ReactionTrigger).triggers.filter( t | 
						t instanceof RegularEventSpec 
						|| t instanceof TimeEventSpec 
						|| t instanceof OnCycleEvent 
						|| t instanceof AlwaysEvent
					).toList.empty
				)
				.map(t | t.mapReaction)
		)
		return _state
	}
	 
	 
	def Reaction mapReaction(LocalReaction lr) {
		val r = lr.create 
		if (lr.trigger != null) r.check = mapToCheck(lr.trigger)
		r.effect = mapToEffect(lr)
		return r
	}
	
	def Sequence mapToEffect(LocalReaction lr) {
		if (lr.effect != null) lr.effect.mapEffect	
	}
	
	def Sequence mapToEffect(Transition t, Reaction r) {
		val sequence = sexec.factory.createSequence 

		// define exit behavior of transition
		
		// first process the exit behavior of orthogonal states that hase to be performed before source exit
		val topExitState = t.exitStates.last
		if (topExitState != null) {
			val exitSequence = topExitState.create.exitSequence
			if (exitSequence != null) {
				sequence.steps.add(exitSequence.newCall)
			}
		}

		// map transition actions
		if (t.effect != null) sequence.steps.add(t.effect.mapEffect)	
		if (trace.addTraceSteps) { sequence.steps += r.newTraceReactionFired() }
		

		// define entry behavior of the transition
		
		// first process all composite states on the path to the target state in top-down-order
		t.entryScopes().drop(1).toList.reverse.fold(sequence, [seq, scope | {
			if (scope instanceof ExecutionRegion) { 
				// if we enter a region than we have to process the sibling regions
			
				val siblingRegions = scope.superScope.subScopes
				
				// process higher order sibling regions
				for ( region : siblingRegions.take(siblingRegions.indexOf(scope)) ) {
					if (region.enterSequence != null) {
						seq.steps.add(region.enterSequence.newCall)
					}
				}
			} 
			
			if (scope instanceof ExecutionState) {
				// perform entry on the transition path 			
				if ((scope as ExecutionState).entryAction != null) seq.steps.add((scope as ExecutionState).entryAction.newCall)
				if ( trace.addTraceSteps ) seq.steps.add( (scope as ExecutionState).newTraceStateEntered )
				
			}
			seq
		}])
		
		
		// second process the target state entry behavior
		if (t.target != null ) {

			// perform entry on the transition path 			
			if ( t.target instanceof RegularState) {
				sequence.steps.add((t.target as RegularState).create.enterSequence.newCall )	
			} else if ( t.target instanceof Choice ) {
				sequence.steps.add((t.target as Choice).create.reactSequence.newCall )	
			} else if ( t.target instanceof Entry ) {
				sequence.steps.add((t.target as Entry).create.reactSequence.newCall )	
			}
				
		}
		
		
		// third - process all entry behavior that has to be executed after the target state behavior in bottom-up-order
		
		t.entryScopes().drop(1).fold(sequence, [seq, scope | {
			if (scope instanceof ExecutionRegion) { 
				// if we enter a region than we have to process the sibling regions
			
				val siblingRegions = scope.superScope.subScopes
				
				// process lower order sibling regions 
				for ( region : siblingRegions.drop(siblingRegions.indexOf(scope)+1) ) {
					if (region.enterSequence != null) {
						seq.steps.add(region.enterSequence.newCall)
					}
				}
			} 
			seq
		}])
		
		return sequence
	}
	
	def List<ExecutionScope> entryScopes(Transition t) {
		val l = t.target.containers
		l.removeAll(t.source.containers)
		l.map( c | 
			if ( c instanceof RegularState ) (c as RegularState).create as ExecutionScope
			else if ( c instanceof Region ) (c as Region).create as ExecutionScope
			else if ( c instanceof Statechart ) (c as Statechart).create as ExecutionScope
		).toList
	}
	
	def Iterable<State> exitStates(Transition t) {
		val l = t.source.containers
		l.removeAll(t.target.containers)
		l.filter( typeof(State) )
	}

	def Iterable<State> entryStates(Transition t) {
		val l = t.target.containers
		l.removeAll(t.source.containers)
		l.filter( typeof(State) )
	}
	
	def Iterable<ExecutionScope> exitScopes(Transition t) {
		val source = t.source
		var executionSource = switch (source) {
				RegularState: source.create
			}
		
		val target = t.target
		var executionTarget = switch (source) {
				RegularState: source.create
			}
		
		val l =executionSource.containers
		l.removeAll(executionTarget.containers)
		null
	}
	
	def dispatch Statement buildCondition (Trigger t) { null }
	
	def dispatch Statement buildCondition (ReactionTrigger t) {
		val triggerCheck = if (! t.triggers.empty) t.triggers.reverseView.fold(null as Expression,
			[s,e | {
				val Expression raised = e.raised()
				
				if (raised == null) s
				else if (s==null) raised  
				else raised.or(s)
			}]
		) else null;
		
		val guard = if ( t.guardExpression != null ) EcoreUtil::copy(t.guardExpression) else null;
		
		if ( triggerCheck != null && guard != null ) stext.and(triggerCheck, guard)
		else if ( triggerCheck != null )  triggerCheck
		else guard
	}
	
}