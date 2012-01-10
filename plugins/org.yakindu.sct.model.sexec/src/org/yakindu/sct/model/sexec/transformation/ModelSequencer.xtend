package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.xtend2.lib.EObjectExtensions
import org.eclipse.xtext.xbase.lib.CollectionExtensions
import org.eclipse.emf.common.util.TreeIterator
import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.sct.model.sexec.Cycle
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sexec.Step
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.SGraphPackage
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.StextPackage
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.stext.stext.Assignment
import org.yakindu.sct.model.sgraph.Variable
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.EntryEvent
import org.yakindu.sct.model.stext.stext.ExitEvent
import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters
import org.eclipse.emf.ecore.util.EcoreUtil$AbstractFilteredSettingsIterator
import java.util.ArrayList
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.TimeEventType
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.TimeUnit
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.stext.stext.OnCycleEvent
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.stext.stext.DefaultEvent
import org.yakindu.sct.model.sexec.ExecutionNode
import com.google.inject.name.Named
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.StateVector

class ModelSequencer {
	 
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sct
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension StructureMapping structureMapping
	@Inject extension BehaviorMapping behaviorMapping
	@Inject extension SequenceBuilder seqBuilder
	@Inject extension StateVectorBuilder svBuilder
	@Inject extension TraceExtensions trace
	
	@Inject
	@Named("ADD_TRACES") 
	boolean _addTraceSteps 
	
	
	/* ==========================================================================
	 * TRANSFORMATION ROOT
	 */ 

	def ExecutionFlow transform(Statechart sc) {
		val ef = sc.create
		
		// during mapping the basic structural elements will be mapped from the source statechart to the execution flow
		sc.mapScopes(ef)
		sc.mapRegularStates(ef)
		sc.mapRegions(ef)
		sc.mapPseudoStates(ef)
		sc.mapTimeEvents(ef)

		// calculate state vectors
		ef.defineStateVector(sc)
		
		// derive all additional information that is necessary for the execution
		sc.mapEntryActions(ef)
		sc.mapExitActions(ef)
		
		ef.defineStateEnterSequences(sc)
		ef.defineStateExitSequences(sc)
		ef.defineStatechartEnterSequence(sc)
		// TODO: ef.defineStatechartExitSequence(sc)
		
		sc.mapTransitions(ef)
		sc.mapLocalReactions(ef)
		sc.mapChoiceTransitions(ef)
		
		ef.defineRegularStateReactions(sc)
		ef.definePseudoStateReactions(sc)
		
		// retarget declaration refs
		ef.retargetDeclRefs
		
		return ef
	}
	
	
	
	
	/* ==========================================================================
	 * STRUCTURAL MAPPING
	 */

	
	

	def ExecutionFlow mapChoiceTransitions(Statechart statechart, ExecutionFlow r) {
		statechart.allChoices.forEach( choice | choice.mapChoiceTransition);		
		return r
	}


	def ExecutionChoice mapChoiceTransition(Choice choice) {
		val _choice = choice.create
		_choice.reactions.addAll( choice.outgoingTransitions.map(t | t.mapTransition) )
		return _choice
	}



	def ExecutionFlow mapTransitions(Statechart statechart, ExecutionFlow r){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(e | e instanceof State)
		allStates.forEach( s | (s as State).mapStateTransition);
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


	def ExecutionFlow mapLocalReactions(Statechart statechart, ExecutionFlow r){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(e | e instanceof State)
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


	def dispatch StateVector stateVector(Vertex v) {
		null	
	}
	
	def dispatch StateVector stateVector(RegularState s) {
		s.create.stateVector	
	}
	
	def dispatch StateVector stateVector(Choice choice) {
		choice.parentRegion.create.stateVector	
	}
	
	
	def Sequence mapToEffect(Transition t, Reaction r) {
		val sequence = sexec.factory.createSequence 

		// define exit behavior of transition
		
		// first process the exit behavior of orthogonal states that hase to be performed before source exit
		val topExitState = t.exitStates.last
		if ( topExitState != null ) {
			val List<RegularState> leafStates = topExitState.collectLeafStates(new ArrayList<RegularState>())
			val topVector = topExitState.stateVector
			val sourceVector = t.source.stateVector
		
			val prepositions = (topVector.offset .. sourceVector.offset).take(sourceVector.offset - topVector.offset)
			
			for ( i: prepositions ) {
						
				// create a state switch for each state configuration vector position
				var StateSwitch sSwitch = topExitState.defineExitSwitch(leafStates, i)
				sequence.steps.add(sSwitch);
			}
		}
		
		// second process the exit path behavior from the the source state
		if (t.source != null && t.source instanceof RegularState) {
			sequence.steps.add((t.source as RegularState).create.exitSequence.newCall)	
		}
 
		t.exitStates().fold(sequence, [seq, state | {
			if (state != t.source && state != topExitState) { // since we call the exit sequence of the source state we have to exclude it's exit action here
				if (t.source.stateVector.last == state.create.stateVector.last) {
					if ( state.create.exitAction != null) seq.steps.add(state.create.exitAction.newCall)
					if ( _addTraceSteps ) seq.steps.add(state.create.newTraceStateExited())			
				}
			}
			
			seq
		}])


		// third process the exit behavior of orthogonal states that hase to be performed after source exit
		if ( topExitState != null ) {
			val List<RegularState> leafStates = topExitState.collectLeafStates(new ArrayList<RegularState>())
			val topVector = topExitState.stateVector
			val sourceVector = t.source.stateVector
		
			val postpositions = (sourceVector.last .. topVector.last).drop(1)
			
			for ( i: postpositions ) {
						
				// create a state switch for each state configuration vector position
				var StateSwitch sSwitch = topExitState.defineExitSwitch(leafStates, i)
				sequence.steps.add(sSwitch);
			}
		}
		
		// forth exit the top exit state
		// TODO refactor: the algorithm shoud not depend on these special cases...
		if ( topExitState != t.source ) {
			if (topExitState.create.exitAction != null) sequence.steps.add(topExitState.create.exitAction.newCall)
			if ( _addTraceSteps ) sequence.steps += topExitState.create.newTraceStateExited
		}
		
		
		// map transition actions
		if (t.effect != null) sequence.steps.add(t.effect.mapEffect)	
		if (_addTraceSteps) { sequence.steps += r.newTraceReactionFired() }
		

		// define entry behavior of the transition
		
		// first process all composite states on the path to the target state in top-down-order
		t.entryScopes().drop(1).toList.reverse.fold(sequence, [seq, scope | {
			if (scope instanceof ExecutionRegion) { 
				// if we enter a region than we have to process the sibling regions
			
				val siblingRegions = scope.superScope.subScopes
				
				// process higher order sibling regions
				for ( region : siblingRegions.take(siblingRegions.indexOf(scope)) ) {
					seq.addEnterRegion(region)
				}
			} 
			
			if (scope instanceof ExecutionState) {
				// perform entry on the transition path 			
				if ((scope as ExecutionState).entryAction != null) seq.steps.add((scope as ExecutionState).entryAction.newCall)
				if ( _addTraceSteps ) seq.steps.add( (scope as ExecutionState).newTraceStateEntered )
				
			}
			seq
		}])
		
		
		// second process the target state entry behavior
		if (t.target != null ) {

			// in the case of orthogonal states we also have to enter sibling states.
			val siblingRegions = t.target.parentRegion.composite.regions
			
			
			// perform entry on the transition path 			
			if ( t.target instanceof RegularState) {
				sequence.steps.add((t.target as RegularState).create.enterSequence.newCall )	
			} else if ( t.target instanceof Choice ) {
				sequence.steps.add((t.target as Choice).create.reactSequence.newCall )	
			}
				
		}
		
		
		// third - process all entry behavior that has to be executed after the target state behavior in bottom-up-order
		
		t.entryScopes().drop(1).fold(sequence, [seq, scope | {
			if (scope instanceof ExecutionRegion) { 
				// if we enter a region than we have to process the sibling regions
			
				val siblingRegions = scope.superScope.subScopes
				
				// process lower order sibling regions 
				for ( region : siblingRegions.drop(siblingRegions.indexOf(scope)+1) ) {
					seq.addEnterRegion(region)
				} 				
			} 
			seq
		}])
			
		return sequence
	}	
	
	
		
	
	def List<State> exitStates(Transition t) {
		val l = t.source.containers
		l.removeAll(t.target.containers)
		l.filter( typeof(State) ).toList
	}
	
	def List<State> entryStates(Transition t) {
		val l = t.target.containers
		l.removeAll(t.source.containers)
		l.filter( typeof(State) ).toList
	}
	
	def List<ExecutionScope> exitScopes(Transition t) {
//		val l = t.source.containers
//		l.removeAll(t.target.containers)
//		l.filter( typeof(State) ).toList
		null
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
	
	
		
	def Sequence mapToEffect(LocalReaction lr) {
		if (lr.effect != null) lr.effect.mapEffect	
	}	

	

	
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
		
		if ( _addTraceSteps ) execChoice.reactSequence.steps.add(0,choice.create.newTraceNodeExecuted)
		
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

	
	def dispatch Check mapToCheck(Trigger tr) { null }
	  
	def dispatch Check mapToCheck(ReactionTrigger tr) {
		val check = tr.createCheck
		check.condition = tr.buildCondition;
		return check
	}
	
	
	def dispatch Statement buildCondition (Trigger t) { null }
	
	def dispatch Statement buildCondition (ReactionTrigger t) {
		val triggerCheck = if (! t.triggers.empty) t.triggers.reverseView.fold(null as Expression,
			[s,e | {
				val Expression raised = raised(e)
				
				if (raised == null) s
				else if (s==null) raised  
				else raised.or(s)
			}]
		) else null;
		
		val guard = if ( t.guardExpression != null ) EcoreUtil::copy(t.guardExpression) else null;
		
		if ( triggerCheck != null && guard != null ) and(triggerCheck, guard)
		else if ( triggerCheck != null )  triggerCheck
		else guard
	}
	
	

	def Expression or(Expression left, Expression right) {
		val or = stext.factory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	def Expression and(Expression left, Expression right) {
		val or = stext.factory.createLogicalAndExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	 

	def dispatch Expression raised(EventSpec e) {
	}

	def dispatch Expression raised(RegularEventSpec e) {
		val r = stext.factory.createElementReferenceExpression
		r.value = (e.event as EventDefinition).create
		return r
	} 
	
	def dispatch Expression raised(TimeEventSpec e) {
		val r = stext.factory.createElementReferenceExpression
		r.value = e.createDerivedEvent
		return r
	}

	def dispatch Expression raised(OnCycleEvent e) {
		val r = stext.factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stext.factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}
	
	def dispatch Expression raised(AlwaysEvent e) {
		val r = stext.factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stext.factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}

	def dispatch Expression raised(DefaultEvent e) {
		val r = stext.factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stext.factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}
	
	


	
	/************** retarget declaration refs **************/
	
	def retargetDeclRefs(ExecutionFlow flow) {
		val allContent = EcoreUtil2::eAllContentsAsList(flow)
		val declared = allContent.filter(e | e instanceof EventDefinition || e instanceof VariableDefinition).toList
		
		allContent.filter(e | e instanceof ElementReferenceExpression).map(s | s as ElementReferenceExpression).forEach( ere | ere.retarget(declared) )
		allContent.filter(e | e instanceof Assignment).map(s | s as Assignment).forEach( ere | ere.retarget(declared) )
	}
	
	
	def retarget(ElementReferenceExpression ere, List<EObject> declared) {
		if (! declared.contains(ere.value) ) ere.value = ere.value.replaced
	}
	
	def retarget(Assignment assign, List<EObject> declared) {
		if (! declared.contains(assign.varRef) ) assign.varRef = ((assign.varRef as VariableDefinition).replaced) as Variable
	}
	
	def dispatch replaced(VariableDefinition vd) {
		vd.create	
	}
	
	def dispatch replaced(EventDefinition ed) {
		ed.create	
	}
	
	def dispatch replaced(TimeEvent ed) {
		ed	
	}
	
		 	
}