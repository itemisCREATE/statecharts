package org.yakindu.sct.model.sexec.transformation.ng.expressions

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sexec.transformation.ng.BehaviorMapping
import org.yakindu.sct.model.sexec.transformation.ng.RegionType
import org.yakindu.sct.model.sexec.transformation.ng.StateType
import org.yakindu.sct.model.sexec.transformation.ng.operations.EnterOperation
import org.yakindu.sct.model.sexec.transformation.ng.operations.EntryActionOperation
import org.yakindu.sct.model.sexec.transformation.ng.operations.EntryReactOperation
import org.yakindu.sct.model.sexec.transformation.ng.operations.ExitOperation
import org.yakindu.sct.model.sexec.transformation.ng.operations.ExitReactOperation
import org.yakindu.sct.model.sexec.transformation.ng.operations.ReactOperation
import org.yakindu.sct.model.sexec.transformation.ng.vectors.ImpactVector
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.Exit
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.ReactionEffect

class EffectToExpression {
	
	@Inject extension BehaviorMapping // TODO: remove dependency
	
	@Inject extension ExpressionBuilder
	@Inject extension StextToExpressionMapper
	@Inject extension SgraphExtensions
	@Inject extension ExitOperation
	@Inject extension EnterOperation
	@Inject extension StateType
	@Inject extension RegionType
	@Inject extension StatechartExtensions
	@Inject extension EntryActionOperation
	@Inject extension ReactOperation
	@Inject extension EntryReactOperation
	@Inject extension ExitReactOperation
	@Inject extension ImpactVector
	@Inject extension StatemachineExpressionBuilder
	
	def dispatch List<Expression> toEffectExpressions(Void effect) { #[] }
	
	def dispatch List<Expression> toEffectExpressions(Effect effect) { #[] }
	
	def dispatch List<Expression> toEffectExpressions(ReactionEffect effect) {
		EcoreUtil.copyAll(effect.actions).map[replaceStextExpressions(effect.statechart)].toList
	}
	
	/**
	 * Creates a compound effect that can consist of multiple transitions.
	 */
	def dispatch List<Expression> toEffectExpressions(List<Transition> transitions) {
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
			val exitOperation = topExitState.type.resolveExitOperation
			if (exitOperation !== null) {
				sequence += exitOperation._call
			}
		}

		// map transition actions
		for ( t : transitions ) {
			if (t.effect !== null) {
				sequence += t.effect.toEffectExpressions
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
	
	def protected dispatch void addEnterExpForTargetsToSequence(Exit it, List<TargetEntrySpec> targets, List<Expression> seq) {
		seq += it.exitReactOperation._call
	}
	
	def protected dispatch void addEnterExpForTargetsToSequence(Entry it, List<TargetEntrySpec> targets, List<Expression> seq) {
		seq += it.entryReactOperation._call
	}
	
	def protected dispatch void addEnterExpForTargetsToSequence(Choice it, List<TargetEntrySpec> targets, List<Expression> seq) {
		seq += it.type.reactMethod._call
	}
	
	def protected dispatch void addEnterExpForTargetsToSequence(Synchronization it, List<TargetEntrySpec> targets, List<Expression> seq) {
		seq += it.type.reactMethod._call
	}
	
	def protected dispatch void addEnterExpForTargetsToSequence(Region it, List<TargetEntrySpec> targets, List<Expression> seq) {
		
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
	
	def protected dispatch void addEnterExpForTargetsToSequence(RegularState it, List<TargetEntrySpec> targets, List<Expression> seq) {
		
		val target = targets.findFirst( t | t.target == it)
		
		if ( target !== null ) {
			if (target.resolveEnterSequence !== null) seq += target.resolveEnterSequence._call
		}
		else {
			if ( it.entryActionOperation !== null ) seq += it.entryActionOperation._call
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
	
	def protected Expression lcaDoSequence(Region region) {
		
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
