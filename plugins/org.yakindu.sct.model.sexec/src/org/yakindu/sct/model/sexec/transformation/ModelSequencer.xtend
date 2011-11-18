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
import apple.awt.CRenderer$Tracer
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

class ModelSequencer {
	
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension FactoryExtension factory
	@Inject extension StatechartExtensions sct


	/* ==========================================================================
	 * TRANSFORMATION ROOT
	 */

	def ExecutionFlow transform(Statechart sc) {
		val ef = sc.create
		
		// during mapping the basic structural elements will be mapped from the source statechart to the execution flow
		sc.mapScopes(ef)
		sc.mapStates(ef)
		sc.mapTimeEvents(ef)
		sc.mapTransitions(ef)
		sc.mapLocalReactions(ef)
		
		// derive all additional information that is necessary for the execution
		ef.defineStateVector(sc)
		ef.defineEnterSequence(sc)
		ef.defineStateCycles(sc)
		
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

		
	def ExecutionFlow mapStates(Statechart statechart, ExecutionFlow r){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(e | e instanceof State)
		r.states.addAll(allStates.map( s | (s as State).mapState));
		return r
	}

	
	def ExecutionState mapState(State state) {
		val _state = state.create
		_state.leaf = state.simple
		_state.entryAction = state.mapEntryAction
		_state.exitAction = state.mapExitAction
		return _state
	}
	 

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
		r.effect = mapToEffect(t)
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
				.filter(lr | (lr.trigger as ReactionTrigger).triggers.empty || ! (lr.trigger as ReactionTrigger).triggers.filter( t | t instanceof RegularEventSpec || t instanceof TimeEventSpec).toList.empty)
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


	def Sequence mapToEffect(Transition t) {
		val sequence = sexecFactory.createSequence 

		t.exitStates().fold(sequence, [seq, state | {
			if (state.create.exitAction != null) seq.steps.add(state.create.exitAction.newCall)
			seq
		}])
		
		if (t.source != null) sequence.steps.add(newExitStateStep(t.source as State))
		if (t.effect != null) sequence.steps.add(t.effect.mapEffect)		
		if (t.target != null && t.target instanceof State) sequence.steps.add(newEnterStateStep(t.target as State))
	

		t.entryStates().reverse.fold(sequence, [seq, state | {
			if (state.create.entryAction != null) seq.steps.add(state.create.entryAction.newCall)
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
		pve.value = tes.value.toString
	
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
		pve.value = divisor.toString
		
		div.operator = MultiplicativeOperator::DIV
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}
	
	def Statement multiply(Expression stmnt, long factor) {
		val NumericalMultiplyDivideExpression div = stextFactory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stextFactory.createPrimitiveValueExpression 
		pve.value = factor.toString
		
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
	
	def defineStateCycles(ExecutionFlow flow, Statechart sc) {
		flow.states.filter(s | s.leaf).forEach(s | defineCycle(s))	
		return flow
	}
	

	def Cycle defineCycle(ExecutionState state) {	
		val cycle = sexecFactory.createCycle
		state.cycle = cycle
		
		val localReactions = state.reactions.filter(r | ! r.transition).toList
		var localSteps = sexecFactory.createSequence
		localSteps.steps.addAll(localReactions.map(lr | {
				var ifStep = sexecFactory.createIf
				ifStep.check = lr.check.newRef		
				ifStep.thenStep = lr.effect.newCall
				ifStep
		}))
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
		flow.stateVector = sexecFactory.createStateVector
		flow.stateVector.offset = 0;
		flow.stateVector.size = sc.maxOrthogonality		
	}


	/************** Calculating execution sequences **************/
	
	
	def defineEnterSequence(ExecutionFlow flow, Statechart sc) {
		val enterSteps = new ArrayList<Step>()
		
		for ( r : sc.regions) {
			val step = r.entry?.target?.newEnterStateStep
			if (step != null) enterSteps.add(step);
		} 
		
		// sc.regions.map(r | r.entry?.target?.newEnterStateStep).filter(e | e != null)
		val enterSequence = sexecFactory.createSequence
		enterSequence.name = "enter"
		enterSteps.forEach(e | enterSequence.steps.add(e));
		flow.enterSequence = enterSequence
		return enterSequence
	}
	
	
	def newEnterStateStep(State s) {
		var ess  = null as EnterState
		if (s != null) {
			ess = sexecFactory.createEnterState
			ess.state = s.create	
		}
		return ess
	}
	
	def newExitStateStep(State s) {
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
	
	
	def target(Entry entry) {
		if ( entry?.outgoingTransitions != null) {
			if (entry.outgoingTransitions.size > 0) entry.outgoingTransitions.get(0).target as State
		}
	}
	 
	def List<LocalReaction> entryReactions(State state) {
		state.localReactions
			.filter(r | ((r as LocalReaction).trigger as ReactionTrigger).triggers.exists( t | t instanceof EntryEvent))
			.map(lr | lr as LocalReaction)
			.toList	
	} 
	
	def List<LocalReaction> exitReactions(State state) {
		state.localReactions
			.filter(r | ((r as LocalReaction).trigger as ReactionTrigger).triggers.exists( t | t instanceof ExitEvent))
			.map(lr | lr as LocalReaction)
			.toList	
	} 
	
}