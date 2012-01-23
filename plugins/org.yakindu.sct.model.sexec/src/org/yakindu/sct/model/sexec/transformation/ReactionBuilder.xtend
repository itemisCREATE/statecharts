package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Entry
import com.google.inject.Inject
import org.yakindu.sct.model.sgraph.EntryKind
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.FinalState

class ReactionBuilder {
	@Inject extension SexecElementMapping mapping
	@Inject extension SexecExtensions sexec
	@Inject extension SgraphExtensions sgraph
	@Inject extension StatechartExtensions sct
	@Inject extension TraceExtensions trace
	
	def defineRegularStateReactions(ExecutionFlow flow, Statechart sc) {
		
		val states = sc.allRegularStates
		
		states.filter(typeof(State)).filter(s | s.simple).forEach(s | defineCycle(s))
		states.filter(typeof(FinalState)).forEach(s | defineCycle(s))
		
		return flow
	}
	

	def definePseudoStateReactions(ExecutionFlow flow, Statechart sc) {
		
		sc.allChoices().forEach( choice | choice.defineReaction() )
	}
	

	def Sequence defineReaction(Choice choice) {
	
		val execChoice = choice.create
		
		// move the default transition to the end of the reaction list
		val _default_ = execChoice.reactions.filter([ r | r.check.alwaysTrue ]).toList.head
		if ( _default_ != null ) execChoice.reactions.move(execChoice.reactions.size -1, _default_)
		// TODO: raise an error if no default exists 
		
		val stateReaction = execChoice.createReactionSequence(null)
		execChoice.reactSequence.steps.addAll(stateReaction.steps)

		execChoice.reactSequence.name = 'react'
		execChoice.reactSequence.comment = 'The reactions of state ' + choice.name + '.'
		
		if ( trace.addTraceSteps ) execChoice.reactSequence.steps.add(0,choice.create.newTraceNodeExecuted)
		
		return execChoice.reactSequence
	}	
	

	def alwaysTrue(Check check) {
		if (check != null && check.condition instanceof PrimitiveValueExpression) {
			val pve = (check.condition as PrimitiveValueExpression)
			return ( pve.value instanceof BoolLiteral && ( pve.value as BoolLiteral ).value )
		} 
		
		return false
	}



	def Sequence defineCycle(RegularState state) {
	
		val execState = state.create
		val stateReaction = execState.createReactionSequence(null)
		val parents = state.parentStates		
		execState.reactSequence = parents.fold(null, [r, s | {
			s.create.createReactionSequence(r)
		}])
		
		execState.reactSequence.name = 'react'
		execState.reactSequence.comment = 'The reactions of state ' + state.name + '.'
		
		return execState.reactSequence
	}	

	def Sequence createReactionSequence(ExecutionNode state, Step localStep) {	
		val cycle = sexec.factory.createSequence
				
		val localReactions = state.reactions.filter(r | ! r.transition).toList
		var localSteps = sexec.factory.createSequence
		localSteps.steps.addAll(localReactions.map(lr | {
				var ifStep = sexec.factory.createIf
				ifStep.check = lr.check.newRef		
				ifStep.thenStep = lr.effect.newCall
				ifStep
		}))
		if (localStep != null) localSteps.steps += localStep
		if (localSteps.steps.empty) localSteps = null
				
				
		val transitionReactions = state.reactions.filter(r | r.transition).toList
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
		
		if ( trace.addTraceSteps ) seq.steps.add(0,execEntry.newTraceNodeExecuted)
		
		if (e.kind == EntryKind::INITIAL) {
			if (target != null && target.enterSequence != null) {
				if (trace.addTraceSteps) seq.steps += e.outgoingTransitions.get(0).create.newTraceReactionFired
				seq.steps += target.enterSequence.newCall
			}
		} else if (e.kind == EntryKind::SHALLOW_HISTORY) {
			val entryStep = sexec.factory.createHistoryEntry
			entryStep.name = "HistoryEntry"
			entryStep.comment = "Enter the region with shallow history"
			entryStep.deep = false
			entryStep.region = (e.eContainer as Region).create
			
			//Initial step, if no history is known
			if (target != null && target.enterSequence != null) {
				if (trace.addTraceSteps) seq.steps += e.outgoingTransitions.get(0).create.newTraceReactionFired
				entryStep.initialStep = target.enterSequence.newCall
			}
			val sSwitch = (e.eContainer as Region).defineShallowHistorySwitch()
			entryStep.historyStep = sSwitch
			
			seq.steps += entryStep
		} else if (e.kind == EntryKind::DEEP_HISTORY) {
			val entryStep = sexec.factory.createHistoryEntry
			entryStep.name = "HistoryEntry"
			entryStep.comment = "Enter the region with deep history"
			entryStep.region = (e.eContainer as Region).create
			entryStep.deep = true
			
			//Initial step, if no history is known
			if (target != null && target.enterSequence != null) {
				if (trace.addTraceSteps) seq.steps += e.outgoingTransitions.get(0).create.newTraceReactionFired
				entryStep.initialStep = target.enterSequence.newCall
			}
			val sSwitch = (e.eContainer as Region).defineDeepHistorySwitch()
			entryStep.historyStep = sSwitch

			seq.steps += entryStep
		}
	}
	
	/**
	 * Enter switch for a region with a deep history, which must be save before
	 */
	def StateSwitch defineDeepHistorySwitch(Region r) {
		r.defineDeepHistorySwitch(r.create)
	}
	
	def StateSwitch defineDeepHistorySwitch(Region r, ExecutionRegion historyRegion) {
		val execRegion = r.create
		
		val StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = execRegion.stateVector.offset
		sSwitch.comment = "Handle shallow history entry of " +r.name
		sSwitch.historyRegion = historyRegion
		
		for (child : r.vertices.filter(typeof(State))) {
			for (childLeaf : child.collectLeafStates(newArrayList).filter(c|c.create.stateVector.offset == sSwitch.stateConfigurationIdx)) {
				val execChild = child.create
				val seq = sexec.factory.createSequence
				seq.name = "enterSequence"
				seq.comment = "enterSequence with history in child " + child.name+" for leaf "+childLeaf.name
				if ( execChild.leaf ) {
					seq.steps += execChild.enterSequence.newCall
				} else {
					if (execChild.entryAction != null ) seq.steps += execChild.entryAction.newCall
					if ( trace.addTraceSteps ) seq.steps += execChild.newTraceStateEntered
					for (childRegion : child.regions) {
						seq.steps += childRegion.defineDeepHistorySwitch(historyRegion)
					}
				}
				sSwitch.cases += childLeaf.create.newCase(seq)
			}
		}
		
		return sSwitch
	}

	/**
	 * Enter switch for a region with a shallow history, which must be save before
	 */
	def StateSwitch defineShallowHistorySwitch(Region r) {
		val execRegion = r.create
		
		val StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = execRegion.stateVector.offset
		sSwitch.comment = "Handle shallow history entry of " +r.name
		sSwitch.historyRegion = r.create
		
		for (child : r.vertices.filter(typeof(State))) {
			val execChild = child.create
			for (childLeaf : child.collectLeafStates(newArrayList).filter(c|c.create.stateVector.offset == sSwitch.stateConfigurationIdx)) {
				sSwitch.cases += childLeaf.create.newCase(execChild.enterSequence.newCall)
			}
		}
		
		return sSwitch
	}
}