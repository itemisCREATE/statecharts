package org.yakindu.sct.model.sexec.transformation

import com.google.common.collect.Iterables
import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.EntryKind
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sgraph.Exit
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.DefaultTrigger


class ReactionBuilder {
	@Inject extension SexecElementMapping mapping
	@Inject extension SexecExtensions sexec
	@Inject extension SgraphExtensions sgraph
	@Inject extension StatechartExtensions sct
	@Inject extension TraceExtensions trace
	@Inject extension BehaviorMapping behaviorMapping
	
	def defineStatechartReaction(ExecutionFlow flow, Statechart sc) {
		val sequence = sexec.factory.createSequence
		sequence.name = "react"
		sequence.comment = 'The reactions of statechart '+sc.name
		
		val leafStates = sc.allRegularStates.filter(s|s.leaf)
		val sSwitch = sexec.factory.createStateSwitch
		sequence.steps += sSwitch
		for (leaf : leafStates.map(s|s.create)) {
			val sCase = sexec.factory.createStateCase
			sCase.state = leaf
			sCase.step = leaf.reactSequence.newCall
			sSwitch.cases += sCase
		}
		
		flow.reactSequence = sequence
		return flow
	}

	def defineRegularStateReactions(ExecutionFlow flow, Statechart sc) {
		
		val states = sc.allRegularStates
		
		states.filter(typeof(State)).filter(s | s.simple).forEach(s | defineCycle(s))
		states.filter(typeof(FinalState)).forEach(s | defineCycle(s))
		
		return flow
	}
	

	def definePseudoStateReactions(ExecutionFlow flow, Statechart sc) {
		
		sc.allChoices().forEach( choice | choice.defineReaction() )
		sc.allSynchronizations().forEach( sync | sync.defineReaction() )
		sc.allExits().forEach( sync | sync.defineReaction() )
	}
	

	def Sequence defineReaction(Choice choice) {
	
		val execChoice = choice.create
		
		// move the default transition to the end of the reaction list
		val defaultTransition = choice.outgoingTransitions.filter( t | t.trigger == null || t.trigger instanceof DefaultTrigger ).head
		if ( defaultTransition != null ) {
			val defaultReaction = defaultTransition.create		
			execChoice.reactions.move(execChoice.reactions.size -1, defaultReaction)
		}
		// TODO: raise an error if no default exists 
		
		val stateReaction = execChoice.createReactionSequence(null)
		execChoice.reactSequence.steps.addAll(stateReaction.steps)

		execChoice.reactSequence.name = 'react'
		execChoice.reactSequence.comment = 'The reactions of state ' + choice.name + '.'
		
		if ( trace.addTraceSteps ) execChoice.reactSequence.steps.add(0,choice.create.newTraceNodeExecuted)
		
		return execChoice.reactSequence
	}	
	

	def Sequence defineReaction(Synchronization sync) {
	
		val execSync = sync.create
		
		// move the default transition to the end of the reaction list
		val _default_ = execSync.reactions.head
		
		execSync.reactSequence.steps.addAll(_default_.effect)

		execSync.reactSequence.name = 'react'
		execSync.reactSequence.comment = 'The reactions of state ' + sync.name + '.'
		
		if ( trace.addTraceSteps ) execSync.reactSequence.steps.add(0,sync.create.newTraceNodeExecuted)
		
		return execSync.reactSequence
	}	
	

	def Sequence defineReaction(Exit it) {
	
		val execExit = it.create
		val realName = if (name.empty) 'default' else name 
				
		execExit.reactSequence.name = 'react'
		execExit.reactSequence.comment = 'The reactions of exit ' + realName + '.'
		
		// find the transition that relates to the matching exit point
		val outTransitions = (it.parentRegion.composite as Vertex).outgoingTransitions
		var exitTrans = outTransitions.filter( t | t.trigger == null && t.exitPointName.equals(realName)).head
		if (exitTrans == null) exitTrans = outTransitions.filter( t | t.trigger == null && t.exitPointName.equals('default')).head
		
		if (exitTrans != null) {
			val exitReaction = exitTrans.create
			execExit.reactSequence.steps.add(exitReaction.effect.newCall)
		}
		
		if ( trace.addTraceSteps ) execExit.reactSequence.steps.add(0,it.create.newTraceNodeExecuted)
		
		return execExit.reactSequence
	}	

	def alwaysTrue(Check check) {
		if (check != null && check.condition instanceof PrimitiveValueExpression) {
			val pve = (check.condition as PrimitiveValueExpression)
			return ( pve.value instanceof BoolLiteral && ( pve.value as BoolLiteral ).value )
		} 
		
		return false
	}
	
	
	def unchecked(Reaction it) {
		return (check == null || check.condition == null )
	}


	def Sequence defineCycle(RegularState state) {
	
		val execState = state.create
		val parents = state.parentStates.map(p|p.create as ExecutionState).filter(p|p.stateVector.offset == execState.stateVector.offset)
		val parentNodes = if ((EcoreUtil2::getRootContainer(execState) as ExecutionFlow).stateVector.offset == execState.stateVector.offset)
			Iterables::concat(parents.map(p|p as ExecutionNode),newHashSet(EcoreUtil2::getRootContainer(execState) as ExecutionNode))
			else parents.map(p|p as ExecutionNode)
		execState.reactSequence = parentNodes.fold(null, [r, s | {
			s.createReactionSequence(r)
		}])
		
		execState.reactSequence.name = 'react'
		execState.reactSequence.comment = 'The reactions of state ' + state.name + '.'
		
		return execState.reactSequence
	}	

	def Sequence createReactionSequence(ExecutionNode state, Step localStep) {	
		val cycle = sexec.factory.createSequence
		cycle.name = "react"
		
		val localReactions = state.reactions.filter(r | ! r.transition ).toList
		var localSteps = sexec.factory.createSequence
		localSteps.steps.addAll(localReactions.map(lr | {
				var ifStep = sexec.factory.createIf
				ifStep.check = lr.check.newRef		
				ifStep.thenStep = lr.effect.newCall
				ifStep
		}))
		if (localStep != null) localSteps.steps += localStep
		if (localSteps.steps.empty) localSteps = null
				
				
		val transitionReactions = state.reactions.filter(r | r.transition && ! r.unchecked ).toList
		val transitionStep = transitionReactions.reverseView.fold(localSteps as Step, [s, reaction | {
				var ifStep = sexec.factory.createIf
				ifStep.check = reaction.check.newRef		
				ifStep.thenStep = reaction.effect.newCall
				ifStep.elseStep = s
				ifStep as Step
			}])

	
		if (transitionStep != null) cycle.steps.add(transitionStep)		
		else if (localSteps != null) cycle.steps.add(localSteps)
		
		return cycle
	}
	
	def ExecutionFlow defineEntryReactions(Statechart statechart, ExecutionFlow r) {
		statechart.allEntries.forEach(e|e.defineReaction)
		return r
	}
	
	def defineReaction(Entry e) {
		val execEntry = e.create
		//Reuse already created react sequence from defineStateEnterSequence(Entry) 
		val seq = execEntry.reactSequence
		val target = e.target.create
		val targetEnterSequence = if (target != null && e.outgoingTransitions.size > 0) { e.outgoingTransitions.mapToStateConfigurationEnterSequence } else null
			
		
		if ( trace.addTraceSteps ) seq.steps.add(0,execEntry.newTraceNodeExecuted)
		
		if (e.kind == EntryKind::INITIAL) {
			if (targetEnterSequence != null) {
				seq.steps += targetEnterSequence
			}
			
		} else if (e.kind == EntryKind::SHALLOW_HISTORY) {
			val entryStep = sexec.factory.createHistoryEntry
			entryStep.name = "HistoryEntry"
			entryStep.comment = "Enter the region with shallow history"
			entryStep.deep = false
			entryStep.region = (e.eContainer as Region).create
			
			//Initial step, if no history is known
			if (targetEnterSequence != null) {
				entryStep.initialStep = targetEnterSequence
			}
			
			entryStep.historyStep = (e.eContainer as Region).create.shallowEnterSequence.newCall
			
			seq.steps += entryStep
		} else if (e.kind == EntryKind::DEEP_HISTORY) {
			val entryStep = sexec.factory.createHistoryEntry
			entryStep.name = "HistoryEntry"
			entryStep.comment = "Enter the region with deep history"
			entryStep.region = (e.eContainer as Region).create
			entryStep.deep = true
			
			//Initial step, if no history is known
			if (targetEnterSequence != null) {
				entryStep.initialStep = targetEnterSequence
			}
			
			entryStep.historyStep =  (e.eContainer as Region).create.deepEnterSequence.newCall

			seq.steps += entryStep
		}
	}
}