/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.extensions

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
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class SExecExtensions {
	
	def isDefaultInterface(StatechartScope scope) {
		switch scope {
			InterfaceScope: scope.name == null || scope.name.empty
			default: false
		}
	}
	
	def ExecutionFlow flow(EObject element){
		var ExecutionFlow ret = null;
		if (element != null) {
			if (element instanceof ExecutionFlow) {
				return element as ExecutionFlow
			}
			else {
				ret = flow(element.eContainer)
			}
		}
		return ret;
	}
	
	def isTimed (ExecutionFlow it) {
		scopes.filter[declarations.filter( typeof(TimeEvent) ).size > 0].size > 0
	}
	
	def getTimeEvents(ExecutionFlow it) {
		scopes.fold(new ArrayList<TimeEvent>, [l, s | l += s.declarations.filter(typeof(TimeEvent)) l])
	}
	
	def hasHistory(ExecutionFlow it) {
		historyVector != null && historyVector.size > 0;		
	}
	
	def hasOutgoingEvents(Scope it) {
		!outgoingEvents.empty
	}
	
	def getOutgoingEvents(Scope it) {
		declarations.filter(typeof(EventDefinition)).filter[direction == Direction::OUT].fold(new ArrayList<EventDefinition>, [l, ev | l += ev l])
	}
	
	def hasIncomingEvents(Scope it) {
		!incomingEvents.empty
	}
		
	def List<EventDefinition> getIncomingEvents(Scope it) {
		declarations.filter(typeof(EventDefinition)).filter[direction == Direction::IN].fold(new ArrayList<EventDefinition>, [l, ev | l += ev l])
	}
	
	def List<EventDefinition> getLocalEvents(Scope it) {
		declarations.filter(typeof(EventDefinition)).filter[direction == Direction::LOCAL].fold(new ArrayList<EventDefinition>, [l, ev | l += ev l])
	}
	
	def getInterfaceScopes(ExecutionFlow it) {
		scopes.filter(typeof(InterfaceScope))
	}
	
	def getVariableDefinitions(Scope it) {
		declarations.filter(typeof(VariableDefinition))
	} 
	def getInternalScope(ExecutionFlow it) {
		it.scopes.filter(typeof(InternalScope)).head
	}
	
	def dispatch definition(ElementReferenceExpression it) {
		if (reference instanceof Declaration) reference as Declaration
	}
	def dispatch definition(FeatureCall it) {
		if (feature instanceof Declaration) feature as Declaration
	}
	def dispatch definition(Expression it) {
		null
	}
	
	def Event event(Declaration it) {
		if ( it instanceof Event ) it as Event else null 	
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
		funcs
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

	/**
	 * Checks if a step is called or not.
	 */
	def isCalled(Step it) { it != null && caller.size > 0 }
	
	
	/**
	 * Returns a list of all steps that are called. 
	 */
	def List<Sequence> called(List<Sequence> it) {
		filter( s | s.called ).toList
	}
	
	 
	def List<Step> enterSequenceFunctions(ExecutionFlow it) {
		val funcs = new ArrayList<Step>()
		funcs.addAll(enterSequences.called) 
		states.forEach( s | funcs += s.enterSequences.called )
		regions.forEach( s | {
			funcs += s.enterSequences.called
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
	def dispatch isEnterSequence(ExecutionScope it, Step s) { enterSequences.contains(s) }
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
	
	
	
	/**
	 * Returns a step that mathes the given name.
	 */
	def Sequence byName(List<Sequence>steps, String name) {
		steps.filter(s | name.trim == s.name.trim ).head
	}

	/**
	 * Returns the default step that is the step without name or the name 'default'.
	 */
	def Sequence defaultSequence(List<Sequence>steps) {
		steps.filter(s | s.name == null || s.name.trim == "" ||  s.name.trim == "default" ).head
	}
	
}