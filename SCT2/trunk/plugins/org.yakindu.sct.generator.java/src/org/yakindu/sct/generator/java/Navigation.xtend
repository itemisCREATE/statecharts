/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Commiters of Yakindu - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import java.util.List
import java.util.ArrayList
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sgraph.Variable
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.Check
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.Expression

class Navigation {
	
	def isTimed (ExecutionFlow it) {
		scopes.filter[declarations.filter( typeof(TimeEvent) ).size > 0].size > 0
	}
	
	def dispatch List<EventDefinition> getOutgoingEvents(ExecutionFlow flow) {
		val events = new ArrayList<EventDefinition>()
		for (scope: flow.scopes) {
			events.addAll(scope.outgoingEvents)
		}
		return events
	}
	
	def boolean hasHistory(ExecutionFlow it) {
		historyVector != null && historyVector.size > 0;		
	}
	
	def dispatch boolean hasOutgoingEvents(ExecutionFlow it) {
		return !outgoingEvents.empty
	}
	
	def getTimeEvents(ExecutionFlow flow) {
		val timeEvents = new ArrayList<TimeEvent>
		flow.scopes.forEach[timeEvents.addAll(declarations.filter(typeof(TimeEvent)))]
		return timeEvents
	} 
	
	def getInternalScopeEvents(ExecutionFlow flow) {
		val events = new ArrayList<EventDefinition>
		flow.internalScopes.forEach[events.addAll(eventDefinitions)]
		return events
	}
	
	def getInternalScopeVariables(ExecutionFlow flow) {
		val variables = new ArrayList<VariableDefinition>
		flow.internalScopes.forEach[variables.addAll(variableDefinitions)]
		return variables
	}
	
	def InternalScope getInternalScope(ExecutionFlow it) {
		return it.scopes.filter(typeof(InternalScope)).head
	}
	
	def getDefaultScope(ExecutionFlow it) {
		interfaceScopes.filter[name == null || name.empty].head
	}
	
	def Iterable<InternalScope> getInternalScopes(ExecutionFlow it) {
		return scopes.filter(typeof(InternalScope))
	}
	
	def Iterable<InterfaceScope> getInterfaceScopes(ExecutionFlow it) {
		return scopes.filter(typeof(InterfaceScope))
	}
	
	def List<EventDefinition> getIncomingEvents(Scope it) {
		val events = new ArrayList<EventDefinition>()
		declarations.filter(typeof(EventDefinition)).forEach(ev | if (ev.direction == Direction::IN) events += ev)
		return events
	}
	
	def boolean hasIncomingEvents(Scope it) {
		return !incomingEvents.empty
	}
	
	def boolean hasEvents(Scope it) {
		return !eventDefinitions.empty
	}
	
	def dispatch List<EventDefinition> getOutgoingEvents(Scope scope) {
		val events = new ArrayList<EventDefinition>()
		scope.declarations.filter(typeof(EventDefinition)).forEach(ev | if (ev.direction == Direction::OUT) events += ev)
		return events
	}
	
	def dispatch boolean hasOutgoingEvents(Scope it) {
		return !outgoingEvents.empty
	}
	
	def getVariableDefinitions(Scope it) {
		return declarations.filter(typeof(VariableDefinition))
	} 
	
	def getEventDefinitions(Scope scope) {
		scope.declarations.filter(typeof(EventDefinition))
	}
	
	def getOperations(Scope it) {
		declarations.filter(typeof(OperationDefinition));
	}
	
	def hasOperations(Scope it) {
		!operations.isEmpty;
	}
	
	def dispatch List<ExecutionState> subStates(ExecutionState it) {
		subScopes.fold(new ArrayList<ExecutionState>, 
			[a, s | 
				a.addAll(s.subStates)
				a
			]
		)
	} 
	
	def dispatch List<ExecutionState> subStates(ExecutionRegion it) {
		subScopes.fold(new ArrayList<ExecutionState>, 
			[a, s | 
				a.add(s as ExecutionState)
				a.addAll(s.subStates)
				a
			]
		)
	} 
	
	def dispatch List<ExecutionState> subStates(ExecutionScope it) {
		return new ArrayList<ExecutionState>()
	}
	
	def referencedChecks(ExecutionNode it) {
		reactions.filter( r | r.check != null && r.check.refs.size > 0).map[it.check]
	}

	def referencedEffects(ExecutionNode it) {
		reactions.filter( r | r.effect != null && r.effect.caller.size > 0).map( r | r.effect )
	}
	
	def List<Step> checkFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		funcs += referencedChecks
		states.forEach( s | funcs += s.referencedChecks )
		nodes.forEach( n | funcs += n.referencedChecks )
		return funcs
	}
	 
	def List<Step> effectFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		funcs += referencedEffects
		states.forEach( s | funcs += s.referencedEffects )
		nodes.forEach( n | funcs += n.referencedEffects )
		return funcs
	}
	 
	def List<Step> entryActionFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		if (entryAction.called) funcs.add(entryAction) 
		states.forEach( s | if (s.entryAction.called) funcs += s.entryAction )
		return funcs
	}
	
	def List<Step> exitActionFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		if (exitAction.called) funcs.add(exitAction) 
		states.forEach( s | if (s.exitAction.called) funcs += s.exitAction )
		return funcs
	}
	 
	def List<Step> enterSequenceFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		if (enterSequence.called) funcs.add(enterSequence) 
		states.forEach( s | if (s.enterSequence.called) funcs += s.enterSequence )
		regions.forEach( s | {
			if (s.enterSequence.called) funcs += s.enterSequence
			if (s.deepEnterSequence.called) funcs += s.deepEnterSequence
			if (s.shallowEnterSequence.called) funcs += s.shallowEnterSequence
		})
		return funcs
	}
	 
	def List<Step> exitSequenceFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		if (exitSequence.called) funcs.add(exitSequence) 
		states.forEach( s | if (s.exitSequence.called) funcs += s.exitSequence )
		regions.forEach( s | if (s.exitSequence.called) funcs += s.exitSequence )
		return funcs
	}
	 
	def List<Step> reactFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		if (reactSequence.called) funcs.add(reactSequence) 
		states.forEach( s | if (s.reactSequence.called) funcs += s.reactSequence )
		nodes.forEach( s | if (s.reactSequence.called) funcs += s.reactSequence )
		return funcs
	}
	
	def isCalled(Step it) { it != null && caller.size > 0 }
	
	def dispatch Reaction reaction(Check it) { eContainer as Reaction }
	def dispatch Reaction reaction(EObject it) { eContainer?.reaction }
	def dispatch Reaction reaction(Reaction it) { it }
	
	def isEntryAction(Step it) { eContainer.isEntryAction(it) }
	def dispatch isEntryAction(ExecutionFlow it, Step s) { entryAction == s }
	def dispatch isEntryAction(ExecutionState it, Step s) { entryAction == s }
	def dispatch isEntryAction(EObject it, Step s) { false }
	
	def isExitAction(Step it) { eContainer.isExitAction(it) }
	def dispatch isExitAction(ExecutionFlow it, Step s) { exitAction == s }
	def dispatch isExitAction(ExecutionState it, Step s) { exitAction == s }
	def dispatch isExitAction(EObject it, Step s) { false }
	
	def isEffect(Step it) { eContainer.isEffect(it) }
	def dispatch isEffect(Reaction it, Step s) { effect == s }
	def dispatch isEffect(EObject it, Step s) { false }
	
	def isEnterSequence(Step it) { eContainer.isEnterSequence(it) }
	def dispatch isEnterSequence(ExecutionScope it, Step s) { enterSequence == s }
	def dispatch isEnterSequence(EObject it, Step s) { false }
	
	def isDeepEnterSequence(Step it) { eContainer.isDeepEnterSequence(it) }
	def dispatch isDeepEnterSequence(ExecutionRegion it, Step s) { deepEnterSequence == s }
	def dispatch isDeepEnterSequence(EObject it, Step s) { false }
	
	def isShallowEnterSequence(Step it) { eContainer.isShallowEnterSequence(it) }
	def dispatch isShallowEnterSequence(ExecutionRegion it, Step s) { shallowEnterSequence == s }
	def dispatch isShallowEnterSequence(EObject it, Step s) { false }

	def isExitSequence(Step it) { eContainer.isExitSequence(it) }
	def dispatch isExitSequence(ExecutionScope it, Step s) { exitSequence == s }
	def dispatch isExitSequence(EObject it, Step s) { false }
	
	def isReactSequence(Step it) { eContainer.isReactSequence(it) }
	def dispatch isReactSequence(ExecutionNode it, Step s) { reactSequence == s }
	def dispatch isReactSequence(EObject it, Step s) { false }
	
	def isCheckFunction(Step it) { it instanceof Check }
	
	def dispatch scope(Variable it) {
		if (eContainer instanceof InterfaceScope)
			eContainer as InterfaceScope
		else
			null
	}
	
	def dispatch scope(Event it) {
		if (eContainer instanceof InterfaceScope)
			eContainer as InterfaceScope
		else
			null
	}
	
	def dispatch scope(OperationDefinition it) {
		if (eContainer instanceof InterfaceScope)
			eContainer as InterfaceScope
		else
			null
	}
	
	def dispatch Declaration definition(ElementReferenceExpression it) {
		if (reference instanceof Declaration) reference as Declaration
	}
	
	def dispatch Declaration definition(FeatureCall it) {
		if (feature instanceof Declaration) feature as Declaration
	}
	
	def dispatch Declaration definition(Expression it) {
		null
	}
	
	def Event event(Declaration it) {
		if ( it instanceof Event ) it as Event else null 	
	} 
}