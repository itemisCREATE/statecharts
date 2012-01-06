package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.SexecFactory
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
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sexec.Step
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sgraph.SGraphFactory
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
import com.sun.org.apache.xerces.internal.dom.ParentNode$UserDataRecord
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.stext.stext.OnCycleEvent
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import javax.sound.sampled.BooleanControl$Type
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
	@Inject extension FactoryExtension factory
	@Inject extension StatechartExtensions sct
	
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
		
		// derive all additional information that is necessary for the execution
		ef.defineStateVector(sc)
		ef.defineStateEnterSequences(sc)
		ef.defineStateExitSequences(sc)
		ef.defineEnterSequence(sc)
		
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
	 * INTERFACE MAPPING
	 */
	
	/**
	 * maps all required scope defined in the statechart to the execution flow.
	 * This includes creating the scopes and adding all relevant declarations. Empty scopes wont be mapped.
	 */
	def ExecutionFlow mapScopes(Statechart sc, ExecutionFlow flow) {
		flow.scopes.addAll(sc.scopes.map(scope | scope.map))
		flow
	}
	
	
	/**
	 * 
	 */
	def Scope map(Scope scope) {
		val _scope = scope.create
		_scope.declarations.addAll(scope.declarations.map(decl | decl.map).filter(e | e != null))
		return _scope
	}
	
	
	def dispatch Declaration map(Declaration decl) {
	}
	
	def dispatch Declaration map(EventDefinition e) {
		val _e = e.create
		return _e
	}
	
	def dispatch Declaration map(VariableDefinition v) {
		val _v = v.create
		return _v
	}
	
	
	/* ==========================================================================
	 * STRUCTURAL MAPPING
	 */

		
	def ExecutionFlow mapRegularStates(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates
		r.states.addAll(allStates.map( s | s.mapState));
		return r
	}


	def ExecutionFlow mapRegions(Statechart statechart, ExecutionFlow flow){
		val allRegions = statechart.allRegions
		flow.regions.addAll( allRegions.map( r | r.mapRegion));
		return flow		
	}
	
	
	def ExecutionRegion mapRegion(Region region) {
		val _region = region.create
		
		if ( region.composite instanceof Statechart ) _region.superScope = (region.composite as Statechart).create
		else _region.superScope = (region.composite as State).create
		
		_region.subScopes.addAll( region.vertices.filter( typeof(RegularState) ).map( v | v.create as ExecutionScope ) )
		
		return _region
	}
	
	
	
	def ExecutionFlow mapPseudoStates(Statechart statechart, ExecutionFlow r){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allChoices = statechart.allChoices
		r.nodes.addAll( allChoices.map( choice | choice.create ) );
		return r
	}



	
	def dispatch ExecutionState mapState(FinalState state) {
		val _state = state.create
		_state.leaf = true
		_state.entryAction = null
		_state.exitAction = null
		return _state		
	}
	
	def dispatch ExecutionState mapState(State state) {
		val _state = state.create
		_state.leaf = state.simple
		_state.entryAction = state.mapEntryAction
		_state.exitAction = state.mapExitAction
		return _state
	}
	 
	def dispatch ExecutionState mapState(RegularState state) {}
	
	
	

	/** Time trigger will be mapped to execution model time events for each real state. */
	def ExecutionFlow mapTimeEvents(Statechart statechart, ExecutionFlow r) {
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(typeof(State))
		allStates.forEach( s | s.mapTimeEventSpecs)
		return r
	}
	
	
	def mapTimeEventSpecs(State state) {
		
		val timeEventSpecs = state.timeEventSpecs
		
		val result = new ArrayList<TimeEvent>();
		for (tes : timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			timeEvent.name = state.name + "_time_event_" + timeEventSpecs.indexOf(tes);
			state.statechart.create.timeEventScope.declarations.add(timeEvent);
			result.add(timeEvent);
			
		}	
		
		result
	}
	


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
	
	def last(StateVector sv) {
		sv.offset + sv.size -1
	}
	
	def first(StateVector sv) {
		sv.offset
	}
	
	def Sequence mapToEffect(Transition t, Reaction r) {
		val sequence = sexecFactory.createSequence 

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
					if ( _addTraceSteps ) seq.steps += newTraceStateExited(state.create)				
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
//		t.entryStates().reverse.fold(sequence, [seq, state | {
//			if (state != t.target) { // since we call the entry sequence of the target state we have to exclude it here
//			
//				// in the case of orthogonal states we also have to enter sibling states.
//				val siblingRegions = state.parentRegion.composite.regions
//				
//				if (state.parentRegion != t.source.parentRegion) {
//					// process higher order sibling regions
//					for ( region : siblingRegions.take(siblingRegions.indexOf(state.parentRegion)) ) {
//						seq.addEnterRegion(region)
//					} 
//				}
//				
//				// perform entry on the transition path 			
//				if (state.create.entryAction != null) seq.steps.add(state.create.entryAction.newCall)
//				if ( _addTraceSteps ) seq.steps += newTraceStateEntered(state.create)
//				
//			}
//			seq
//		}])
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
				if ( _addTraceSteps ) seq.steps += newTraceStateEntered((scope as ExecutionState))
				
			}
			seq
		}])
		
		
		// second process the target state entry behavior
		if (t.target != null ) {

			// in the case of orthogonal states we also have to enter sibling states.
			val siblingRegions = t.target.parentRegion.composite.regions
			
//			if (t.target.parentRegion != t.source.parentRegion) {
//				// process higher order sibling regions
//				for ( region : siblingRegions.take(siblingRegions.indexOf(t.target.parentRegion)) ) {
//					sequence.addEnterRegion(region)
//				} 	
//			}
			
			// perform entry on the transition path 			
			if ( t.target instanceof RegularState) {
				sequence.steps.add((t.target as RegularState).create.enterSequence.newCall )	
			} else if ( t.target instanceof Choice ) {
				sequence.steps.add((t.target as Choice).create.reactSequence.newCall )	
			}
				
//			if (t.target.parentRegion != t.source.parentRegion) {
//				// process lower order sibling regions 
//				for ( region : siblingRegions.drop(siblingRegions.indexOf(t.target.parentRegion)+1) ) {
//					sequence.addEnterRegion(region)
//				} 	
//			}
		}
		
		
		// third - process all entry behavior that has to be executed after the target state behavior in bottom-up-order
//		t.entryStates().fold(sequence, [seq, state | {
//			if (state != t.target) { // since we call the entry sequence of the target state we have to exclude it here
//			
//				// in the case of orthogonal states we also have to enter sibling states.
//				val siblingRegions = state.parentRegion.composite.regions
//				
//				if (state.parentRegion != t.source.parentRegion) {
//					// process lower order sibling regions 
//					for ( region : siblingRegions.drop(siblingRegions.indexOf(state.parentRegion)+1) ) {
//						seq.addEnterRegion(region)
//					} 				
//				}
//			}
//			seq
//		}])
		
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
	
	
	
	def dispatch addEnterRegion(Sequence seq, Region r) {
		val entryState = r.entry?.target?.create
					
		if (entryState != null && entryState.enterSequence != null) 
				seq.steps.add(entryState.enterSequence.newCall);
	}


	// TODO: refactor - don't access source element...
	def dispatch addEnterRegion(Sequence seq, ExecutionRegion r) {
		val entryState = (r.sourceElement as Region).entry?.target?.create
					
		if (entryState != null && entryState.enterSequence != null) 
				seq.steps.add(entryState.enterSequence.newCall);
	}


	def newTraceReactionFired(Reaction r) {
		val rf = sexecFactory.createReactionFired
		rf.reaction = r
		rf
	}
	
	def newTraceNodeExecuted(ExecutionNode node) {
		val t = sexecFactory.createTraceNodeExecuted
		t.node = node
		t
	}
	
	
	def newTraceStateEntered(ExecutionState state) {
		val t = sexecFactory.createTraceStateEntered
		t.state = state
		t
	}
	
	def newTraceStateExited(ExecutionState state) {
		val t = sexecFactory.createTraceStateExited
		t.state = state
		t
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
	
	
	
	// TODO: rename since this list also includes the start state or change implementation and usages
	def List<RegularState> parentStates(RegularState s) {
		s.containers.filter( typeof(RegularState) ).toList		
	}
	
	
	def List<EObject> containers(EObject obj) {
		val containerList = new ArrayList<EObject>()
		collectContainers(obj, containerList)
		return containerList
	}
	
	def void collectContainers(EObject obj, List<EObject> containerList) {
		containerList += obj
		if (obj?.eContainer != null) collectContainers(obj.eContainer, containerList);
	}
	
	
	
	
	def Sequence mapToEffect(LocalReaction lr) {
		if (lr.effect != null) lr.effect.mapEffect	
	}	

	
	def dispatch Sequence mapEffect(Effect effect) {}
	
	def dispatch Sequence mapEffect(ReactionEffect effect) {
		if ( ! effect.actions.empty) {
			val sequence = sexecFactory.createSequence
			sequence.name = "reaction_action"
			sequence.steps.addAll( effect.actions.map( stmnt | stmnt.mapToExecution))
			return sequence	
		}	
	}
	
	def Execution mapToExecution(Statement stmnt) {
		val exec = sexecFactory.createExecution
		exec.statement = EcoreUtil::copy(stmnt)
		exec	
	}
	
	
	/** 
	 * The entry action sequence of a state consist all action that are specified with the 'entry' pseudo trigger within local reactions
	 * and all scheduling actions for time triggers.
	 */
	def Step mapEntryAction(State state) {
		val seq = sexecFactory.createSequence
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
	
	
	def Statement buildValueExpression(TimeEventSpec tes) {
		val PrimitiveValueExpression pve = stextFactory.createPrimitiveValueExpression 
		val IntLiteral intLit = stextFactory.createIntLiteral
		intLit.value = tes.value
		pve.value = intLit
	
		switch (tes.unit) {
			case TimeUnit::MILLISECOND : pve
			case TimeUnit::NANOSECOND  : pve.divide(1000)
			case TimeUnit::SECOND      : pve.multiply(1000)
			default : pve
		} 
	}
	
	
	def Statement divide(Expression stmnt, long divisor) {
		val NumericalMultiplyDivideExpression div = stextFactory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stextFactory.createPrimitiveValueExpression 
		val IntLiteral intLit = stextFactory.createIntLiteral
		intLit.value = divisor.intValue
		pve.value = intLit
		
		div.operator = MultiplicativeOperator::DIV
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}
	
	def Statement multiply(Expression stmnt, long factor) {
		val NumericalMultiplyDivideExpression div = stextFactory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stextFactory.createPrimitiveValueExpression 
		val IntLiteral intLit = stextFactory.createIntLiteral
		intLit.value = factor.intValue
		pve.value = intLit
		
		div.operator = MultiplicativeOperator::MUL
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}

	/** 
	 * The exit action sequence of a state consist all action that are specified with the 'exit' pseudo trigger within local reactions
	 * and all unscheduling actions for time triggers.
	 */
	def Step mapExitAction(State state) {
		val seq = sexecFactory.createSequence
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
	
	/* ==========================================================================
	 * SEQUENCING
	 */
	
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
		val cycle = sexecFactory.createSequence
				
		val localReactions = state.reactions.filter(r | ! r.transition).toList
		var localSteps = sexecFactory.createSequence
		localSteps.steps.addAll(localReactions.map(lr | {
				var ifStep = sexecFactory.createIf
				ifStep.check = lr.check.newRef		
				ifStep.thenStep = lr.effect.newCall
				ifStep
		}))
		if (localStep != null) localSteps.steps += localStep
		if (localSteps.steps.empty) localSteps = null
				
				
		val transitionReactions = state.reactions.filter(r | r.transition).toList
		val transitionStep = transitionReactions.reverseView.fold(localSteps as Step, [s, reaction | {
				var ifStep = sexecFactory.createIf
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
		val or = stextFactory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	def Expression and(Expression left, Expression right) {
		val or = stextFactory.createLogicalAndExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	 

	def dispatch Expression raised(EventSpec e) {
	}

	def dispatch Expression raised(RegularEventSpec e) {
		val r = stextFactory.createElementReferenceExpression
		r.value = (e.event as EventDefinition).create
		return r
	}
	
	def dispatch Expression raised(TimeEventSpec e) {
		val r = stextFactory.createElementReferenceExpression
		r.value = e.createDerivedEvent
		return r
	}

	def dispatch Expression raised(OnCycleEvent e) {
		val r = stextFactory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stextFactory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}
	
	def dispatch Expression raised(AlwaysEvent e) {
		val r = stextFactory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stextFactory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}

	def dispatch Expression raised(DefaultEvent e) {
		val r = stextFactory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stextFactory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}
	
	
	/* ==========================================================================
	 * HANDLING TIME EVENTS
	 */
	 
	
	
	def TimeEvent create r : sexecFactory.createTimeEvent createDerivedEvent(TimeEventSpec tes) {
		r.periodic = tes.type == TimeEventType::EVERY
	}
		
	//def flow(ExecutionState state) { state.eContainer as ExecutionFlow }
	
	def Scope create r : sgraphFactory.createScope timeEventScope(ExecutionFlow flow) {
		flow.scopes.add(r);
	}
	
	
	/************** Calculating Structure information **************/

	def defineStateVector(ExecutionFlow flow, Statechart sc) {
		var offset = 0
		for ( r : sc.regions ) {
			offset = offset + defineStateVectors(r, offset)	
		}	
		
		
//		flow.stateVector = sexecFactory.createStateVector
//		flow.stateVector.offset = 0;
//		flow.stateVector.size = sc.maxOrthogonality	
		
		flow.stateVector = sexecFactory.createStateVector
		flow.stateVector.offset = 0;
		flow.stateVector.size = offset			
	}


	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart */
	def int defineStateVectors(Statechart sc, int offset) {
		sc.regions.fold(0, [o, r | r.maxOrthogonality + o])
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a region */
	def int defineStateVectors(Region r, int offset) {
		val maxOrthogonality = r.vertices.fold(0, [s, v | {
			val mo = v.defineStateVectors(offset)
			if (mo > s) mo else s }])
			
		val er = r.create
		er.stateVector = sexecFactory.createStateVector
		er.stateVector.offset = offset;
		er.stateVector.size = maxOrthogonality			
	
		return maxOrthogonality
	}

	/** the maximum orthogonality of all  pseudo states is 0 */
	def dispatch int defineStateVectors(Vertex v, int offset) { 0 }
	
		
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(State s, int offset) { 
		var int maxOrthogonality = 0
		if ( s.regions.size > 0 ) {
			for ( r : s.regions ) {
				maxOrthogonality = maxOrthogonality + r.defineStateVectors(offset+maxOrthogonality)
			}
		} else maxOrthogonality = 1
		
		val es = s.create
		es.stateVector = sexecFactory.createStateVector
		es.stateVector.offset = offset;
		es.stateVector.size = maxOrthogonality			
		
		return maxOrthogonality
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(FinalState s, int offset) { 
		
		val es = s.create
		es.stateVector = sexecFactory.createStateVector
		es.stateVector.offset = offset;
		es.stateVector.size = 1			
		
		return 1
	}



	/************** Calculating execution sequences **************/
	
	/**
	 * Defines the enter sequences of all states
	 */
	def void defineStateEnterSequences(ExecutionFlow flow, Statechart sc) {
		
		// iterate over all regions
		for ( r : sc.regions) defineStateEnterSequence(r)
	}
	

	def dispatch void defineStateEnterSequence(Region r) {
		
		// process all vertices of a region
		for ( s : r.vertices) defineStateEnterSequence(s)
	}
	

	def dispatch void defineStateEnterSequence(Vertex v) {
	}	
	
	
	def dispatch void defineStateEnterSequence(FinalState state) {
		val execState = state.create
		val seq = sexecFactory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for state " + state.name
		if (execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateEntered
		
		seq.steps += state.newEnterStateStep
		execState.enterSequence = seq
	}	
	
	
	
	def dispatch void defineStateEnterSequence(State state) {
		
		val execState = state.create
		val seq = sexecFactory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for state " + state.name
		if (execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateEntered
		
		if ( execState.leaf ) {
			
			seq.steps += state.newEnterStateStep
					
		} else {
	
			for ( r : state.regions ) {
				defineStateEnterSequence(r)
				
				seq.addEnterRegion(r)
//				val entryState = r.entry?.target?.create
//				
//				if (entryState != null && entryState.enterSequence != null) 
//					seq.steps.add(entryState.enterSequence.newCall);
			} 
		}

		execState.enterSequence = seq
	}
	
	
	
	/**
	 * Defines the exit sequences of all states
	 */
	def void defineStateExitSequences(ExecutionFlow flow, Statechart sc) {
		
		// iterate over all regions
		for ( r : sc.regions) defineStateExitSequence(r)
	}
		

	def dispatch void defineStateExitSequence(Region r) {
		
		// process all states of a region
		for ( s : r.vertices ) defineStateExitSequence(s)
	}
	
	def dispatch void defineStateExitSequence(Vertex v) {}
	
	def dispatch void defineStateExitSequence(FinalState s) {
		val execState = s.create
		val seq = sexecFactory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for final state."
		seq.steps += s.newExitStateStep
				
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateExited
		
		execState.exitSequence = seq
	}
	
	// TODO : refactor
	def dispatch void defineStateExitSequence(State state) {
		
		val execState = state.create
		val seq = sexecFactory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for state " + state.name

		if ( execState.leaf ) {
			
			seq.steps += state.newExitStateStep
					
		} else {

			// first enforce calculation of all child exit sequences
			state.regions.forEach( r | { r.defineStateExitSequence null })

			// collect leaf states
			val List<RegularState> leafStates = state.collectLeafStates(new ArrayList<RegularState>())
			val sVector = execState.stateVector
	
			for ( i: sVector.offset .. sVector.offset + sVector.size - 1 ) {
						
				// create a state switch for each state configuration vector position
				var StateSwitch sSwitch = state.defineExitSwitch(leafStates, i)
				seq.steps.add(sSwitch);

			}
			
			
		}

		if (execState.exitAction != null) seq.steps.add(execState.exitAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateExited
		
		execState.exitSequence = seq
	}
	
	
	
	def StateSwitch defineExitSwitch(State state, List<RegularState> states, int pos) {

		// create a state switch
		var StateSwitch sSwitch = sexecFactory.createStateSwitch
		sSwitch.stateConfigurationIdx = pos
		sSwitch.comment = "Handle exit of all possible states on position " + sSwitch.stateConfigurationIdx + "..."
						
		val List<RegularState> posStates = states.filter( rs | rs.create.stateVector.size == 1 && rs.create.stateVector.offset == pos).toList					
		
		// create a case for each leaf state				
		for ( s : posStates ) {

			val caseSeq = sexecFactory.createSequence
			caseSeq.steps += s.create.exitSequence.newCall
			val es = s.create


			val exitStates = s.parentStates
			exitStates.removeAll(state.parentStates)
			exitStates.remove(s)
			
			// include exitAction calls up to the direct child level.
			exitStates.fold(caseSeq , [ cs, exitState | {
				if (es.stateVector.last == exitState.create.stateVector.last) {
					if (exitState.create.exitAction != null) cs.steps.add(exitState.create.exitAction.newCall)
					if ( _addTraceSteps ) cs.steps.add(exitState.create.newTraceStateExited)				
				}
				cs
			}]) 
			
			if (s.create.exitSequence != null) sSwitch.cases.add(s.create.newCase(caseSeq))
			
		}
		
		return sSwitch
	}
	
	
	def List<RegularState> collectLeafStates(RegularState state, List<RegularState> leafStates) {
		if ( state.isLeaf ) 
			leafStates += state
		else if ( state instanceof State ) {
			val State s = state as State		
			for ( r : s.regions ) {
				for ( v : r.vertices ) {
					if (v instanceof RegularState) collectLeafStates(v as RegularState, leafStates)
				}
			}
		}
		return leafStates	
	}
	
	
		
	def List<RegularState> collectLeafStates(Region region, List<RegularState> leafStates) {
		for ( v : region.vertices ) {
			if (v instanceof RegularState) collectLeafStates(v as RegularState, leafStates)
		}

		return leafStates	
	}
	
	
	def dispatch isLeaf(RegularState s) { false }
	
	def dispatch isLeaf(FinalState s) {true}
	
	def dispatch isLeaf(State s) { s.simple }
	
	
	def newCase(ExecutionState it, Step step) {
		val sCase = sexecFactory.createStateCase
		sCase.state = it
		sCase.step = step
		return sCase
	}
	
	
	def states(Region it) {
		it.vertices.filter( typeof(State) )
	}
	
	
	def defineEnterSequence(ExecutionFlow flow, Statechart sc) {

		val enterSequence = sexecFactory.createSequence
		enterSequence.name = "enter"
		enterSequence.comment = "Default enter sequence for statechart " + sc.name
		
		for ( r : sc.regions) {
			enterSequence.addEnterRegion(r)
			
//			if ( r.entry?.target != null) {
//				val step = r.entry?.target?.create.enterSequence.newCall
//				if (step != null) enterSequence.steps.add(step);
//			}
		} 
		
		flow.enterSequence = enterSequence
		return enterSequence
	}
	
	
	def newEnterStateStep(RegularState s) {
		var ess  = null as EnterState
		if (s != null) {
			ess = sexecFactory.createEnterState
			ess.state = s.create	
		}
		return ess
	}
	
	def newExitStateStep(RegularState s) {
		var ess  = null as ExitState
		if (s != null) {
			ess = sexecFactory.createExitState
			ess.state = s.create	
		}
		return ess
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
	
	
	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def sgraphFactory() { SGraphFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
	
	
	def entry(Region r) {
		r.vertices.findFirst(v | v instanceof Entry && (v.name == null || "".equals(v.name) || v.name == 'default') ) as Entry
	}
	
	/**
	 * Retrieves the target from an entry.
	 * TODO: validation of preconditions for entry targets e.g every region needs an entry with appropriate target
	 */
	def target(Entry entry) {
		if ( entry?.outgoingTransitions != null) {
			if (entry.outgoingTransitions.size > 0) {
				val target =entry.outgoingTransitions.get(0).target
				if (target instanceof State ) target as State	
			}
		}
	}
	 	
}