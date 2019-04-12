package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sgraph.Pseudostate
import org.yakindu.sct.model.sgraph.Reaction
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.EventSpec

/**
 * Most things are copied from BehaviorMapping and rewritten to work on sgraph and expressions instead of sexec
 */
class TransitionMapping {
	
	@Inject protected extension BehaviorMapping
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ExitSequence
	@Inject protected extension EnterSequence
	@Inject protected extension StateType
	@Inject protected extension RegionType
	@Inject protected extension SgraphExtensions
	@Inject protected extension StatechartExtensions
	@Inject protected extension StateOperations
	@Inject protected extension HistoryVector
	@Inject protected extension ReactOperation
	@Inject protected extension ImpactVector
	
	@Inject protected extension StatemachineExpressionBuilder
	@Inject protected extension StextToExpressionMapper
	@Inject protected extension ExpressionExtensions
	
	def mapCheck(Reaction it) {
		it.trigger.toCheckExpression ?: _true
	}
	
	def dispatch mapEffect(LocalReaction it) {
		it.effect.toExpression
	}
	
	def dispatch mapEffect(Transition it) {
		toEffectExpression(#[it])
	}
	
	def dispatch List<Expression> toExpression(Void effect) { null }
	
	def dispatch List<Expression> toExpression(Effect effect) { null }
	
	def dispatch List<Expression> toExpression(ReactionEffect effect) {
		EcoreUtil.copyAll(effect.actions).map[replaceStextExpressions(effect.statechart)].toList
	}
	
	def dispatch Expression toCheckExpression (Void t) { _true }
	
	def dispatch Expression toCheckExpression (Trigger t) { _true }
	
	def dispatch Expression toCheckExpression (ReactionTrigger t) {
		
		val hasTriggers = ! t.triggers.empty
		val triggersAreAlwaysTrue = t.triggers.filter(AlwaysEvent).size > 0 
		val triggerCheck = if (hasTriggers && !triggersAreAlwaysTrue) t.toTriggerCheck else null;
		
		val guard = t.buildGuard
		
		if ( triggerCheck !== null && guard !== null ) _parenthesized(triggerCheck)._and(_parenthesized(guard))
		else if ( triggerCheck !== null ) triggerCheck
		else if ( guard !== null ) guard
		else if ( triggersAreAlwaysTrue ) _true
	}
	
	
	def toTriggerCheck(ReactionTrigger t) {
		t.triggers.reverseView.fold(null as Expression,
			[s,e | {
				val Expression raised = e.isRaised
				
				if (raised === null) s
				else if (s===null) raised  
				else raised._or(s)
			}])		
	}
	
	
	protected def dispatch Expression buildGuard( Trigger t) {null}
	
	protected def dispatch Expression buildGuard( ReactionTrigger t) {
		if ( t.guard !== null ) EcoreUtil::copy(t.guard.expression).replaceStextExpressions(t.statechart) else null
	}
	
	protected def dispatch isRaised(RegularEventSpec e) {
		e.event
	}
	
	protected def dispatch isRaised(TimeEventSpec e) {
		null // TODO: transform time events into properties
	}
	
	protected def dispatch isRaised(EventSpec e) {
		null
	}
	
	
	/**
	 * Creates a compound effect that can consist of multiple transitions.
	 */
	def List<Expression> toEffectExpression(List<Transition> transitions) {
		val sequence = <Expression>newArrayList

		// define exit behavior of transition
		
		// first process the exit behavior of orthogonal states that has to be performed before source exit
		val topExitState = transitions.topExitState 
		
//		if (trace.addTraceSteps) {
//			for (t : transitions) {
//				sequence.steps.add(t.create.newTraceReactionWillFire)	
//			}
//		}
		
		if (topExitState !== null) {
			val exitOperation = topExitState.type.resolveExitSequence
			if (exitOperation !== null) {
				sequence += exitOperation._call
			}
		}

		// map transition actions
		for ( t : transitions ) {
			if (t.effect !== null) {
				sequence += t.effect.toExpression
			}
//			if (trace.addTraceSteps) { 
//				sequence.steps += t.create.newTraceReactionFired
//			}
		}
	
		// define entry behavior of the transition	
		sequence += mapToStateConfigurationEnterSequence(transitions)
		
		
		// handle local reactions that are out of transition scope
		val topEntryState = transitions.topEntryState
		val commonAncestors = commonAncestors(topExitState, topEntryState)
		val lcaRegion = commonAncestors.firstRegion
		
		val localReactionSequence = lcaRegion.lcaDoSequence
		if (localReactionSequence !== null) sequence += localReactionSequence
		
		return sequence
	}
	
	/**
	 * Calcuates a sequence to enter one or more states. Entering multiple states is required for fork, where parts of a state 
	 * configuration is specified.
	 */
	def List<Expression> mapToStateConfigurationEnterSequence(List<Transition> transitions) {
	
		// precondition : common source vertex
		// ? precondition : targets are Regular States ?
		
		val List<Expression> sequence = newArrayList 

		// determine start entry scope
		val entryScopes = transitions.get(0).entryScopes.drop(1).toList.reverse
		for ( t: transitions ) {
			entryScopes.retainAll(t.entryScopes)
		}
		val entryScope = entryScopes.head
		
		// determine all target vertices
		val List<TargetEntrySpec> targets = transitions
												.map( t | new TargetEntrySpec(t.target, t.entryPointName) )
												.fold(new ArrayList<TargetEntrySpec>, [ s, e | { 
														if (!s.exists(tes | e.target == tes.target)) {s.add(e)} 
														s
													}])
															
		// recursively extend the sequence by entering the scope for the specified targets		
		if (entryScope !== null) (entryScope.sourceElement as NamedElement).addEnterExpForTargetsToSequence(targets, sequence)	
		else {
			for ( t : targets ) t.target.addEnterExpForTargetsToSequence(targets, sequence)
 		}	
	
		return sequence
	}
	
	def dispatch void addEnterExpForTargetsToSequence(Pseudostate it, List<TargetEntrySpec> targets, List<Expression> seq) {
//		seq += reactSequence.newCall	TODO
	}
	
	def dispatch void addEnterExpForTargetsToSequence(Region it, List<TargetEntrySpec> targets, List<Expression> seq) {
		
		// if a target is a direct node
		val target = targets.filter( t | it.vertices.contains(t.target)).head 

		if (target !== null) {
			target.target.addEnterExpForTargetsToSequence(targets, seq)
			return
		}
		
		// if the execution region contains targets 
		val List<Vertex> targetNodes = targets.map(t | t.target)
		if ( allSubScopes.exists( n | targetNodes.contains(n) ) ) {
			for (s : subScopes) {
				if (s.allSubScopes.exists(n|targetNodes.contains(n)))
					s.addEnterExpForTargetsToSequence(targets, seq)
			}
		} else {
			// in the case only sibling regions contain targets the region must be entered 
			// using the default enter sequence, if this exists
			if (it.type.defaultEnterSequence !== null) {
				seq += it.type.defaultEnterSequence._call
			}
		}
	}
	
	def dispatch void addEnterExpForTargetsToSequence(RegularState it, List<TargetEntrySpec> targets, List<Expression> seq) {
		
		val target = targets.findFirst( t | t.target == it)
		
		if ( target !== null ) {
			if (target.resolveEnterSequence !== null) seq += target.resolveEnterSequence._call
		}
		else {
			if ( it.entryAction !== null ) seq += it.entryAction._call
//			if ( trace.addTraceSteps ) seq.steps.add(it.newTraceStateEntered)
			
			for (subScope : it.subScopes ) {
				subScope.addEnterExpForTargetsToSequence(targets, seq)
			}
			
			/* save state to shallow history if parent region contains one */ 
			val parentRegion = it.superScope as Region
			if(parentRegion.requireHistory) {
				seq += parentRegion._saveHistory
			}	
		}

	}
	
	protected def Expression lcaDoSequence(Region region) {
		
		if (region === null) return null
		
		val shouldExecuteParent = 
			if (! region.statechart.childFirstExecution) 
				[NamedElement parentScope, NamedElement execScope | false ]
			else
				[NamedElement parentScope, NamedElement execScope | 
					parentScope === execScope || parentScope.impactVector.last == execScope.impactVector.last
				]
		
		val parent = region.parentStates.head ?: region.statechart

		if (shouldExecuteParent.apply(parent, region)) {
			parent.callReact(_false)
		}
	}
	
}