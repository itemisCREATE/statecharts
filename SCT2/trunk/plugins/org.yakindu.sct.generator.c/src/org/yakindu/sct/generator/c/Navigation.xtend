package org.yakindu.sct.generator.c

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.InternalScope

class Navigation {
	
	def dispatch ExecutionFlow flow(Scope scope) {
		if (scope.eContainer instanceof ExecutionFlow) scope.eContainer as ExecutionFlow
		else null
	}
	
	def dispatch ExecutionFlow flow(Declaration it) {
		scope?.flow
	}
	
	def dispatch ExecutionFlow flow(EObject it) {
		eContainer.flow
	}
	
	def dispatch ExecutionFlow flow(ExecutionFlow it) {
		it
	}
	
	
	def Event event(Declaration it) {
		if ( it instanceof Event ) it as Event else null 	
	} 
	
	def Scope scope(Declaration it) {
		if (eContainer instanceof Scope) eContainer as Scope
		else null
	}
	
	
	def empty (StateVector sv) {
		sv == null || sv.size == 0
	}
	
	def isTimed (ExecutionFlow it) {
		scopes.filter[declarations.filter( typeof(TimeEvent) ).size > 0].size > 0
	}
	
	def hasValue (EventDefinition it) {
		type != null && type.name != 'void'
	}
	
	def operations(ExecutionFlow it) {
		scopes.fold(new ArrayList<OperationDefinition>(), [ l, s | l.addAll(s.declarations.filter( typeof(OperationDefinition))) return l ])
	}
	
	def List<Event> getIncomingEvents(Scope scope) {
		val events = new ArrayList<Event>()
		scope.declarations.filter(typeof(EventDefinition)).forEach(ev | if (ev.direction == Direction::IN) events += ev)
		return events
	}
	
	def boolean hasIncomingEvents(Scope scope) {
		return !scope.incomingEvents.empty
	}
	
	def List<Event> getOutgoingEvents(Scope scope) {
		val events = new ArrayList<Event>()
		scope.declarations.filter(typeof(EventDefinition)).forEach(ev | if (ev.direction == Direction::OUT) events += ev)
		return events
	}
	
	def boolean hasOutgoingEvents(Scope scope) {
		return !scope.outgoingEvents.empty
	}
	
	def InternalScope getLocalScope(ExecutionFlow it) {
		return it.scopes.filter(typeof(InternalScope)).head
	}
	
	def boolean hasLocalScope(ExecutionFlow it) {
		return localScope != null;
	}
	
	def dispatch Reaction reaction(Check it) { eContainer as Reaction }
	def dispatch Reaction reaction(EObject it) { eContainer?.reaction }
	def dispatch Reaction reaction(Reaction it) { it }

	def referencedChecks(ExecutionNode it) {
		reactions.filter( r | r.check != null && r.check.refs.size > 0).map[it.check]
	}

	def referencedEffects(ExecutionNode it) {
		reactions.filter( r | r.effect != null && r.effect.caller.size > 0).map( r | r.effect )
	}

	def isCalled(Step it) { it != null && caller.size > 0 }
	
	
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
	
	
	def dispatch Declaration definition(ElementReferenceExpression it) {
		if (reference instanceof Declaration) reference as Declaration
	}
	def dispatch Declaration definition(FeatureCall it) {
		if (feature instanceof Declaration) feature as Declaration
	}
	def dispatch Declaration definition(Expression it) { null }
	
		
}