/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.sexec.Step

class SexecExtensions {
	
	
	static String DEFAULT_SEQUENCE_NAME = "default" 
	
	def factory() { SexecFactory::eINSTANCE }
	
	
	
	def newEnterStateStep(ExecutionState s) {
		var EnterState ess
		if (s !== null) {
			ess = factory.createEnterState
			ess.state = s	
		}
		return ess
	}
	
	
	def newExitStateStep(ExecutionState s) {
		var ExitState ess  
		if (s !== null) {
			ess = factory.createExitState
			ess.state = s	
		}
		return ess
	}
	
	
	def newCase(ExecutionState it, Step step) {
		val sCase = factory.createStateCase
		sCase.state = it
		sCase.step = step
		return sCase
	}

	def newSaveHistory(ExecutionRegion r) {
		val save = factory.createSaveHistory
		save.region = r
		return save
	}

	def dispatch List<ExecutionState> collectLeafStates(ExecutionState state, List<ExecutionState> leafStates) {
		if ( state.isLeaf ) 
			leafStates += state
		else {
			for ( r : state.subScopes ) {
				r.collectLeafStates(leafStates)
			}
		}
		return leafStates	
	}
	
	 
		
	def dispatch List<ExecutionState> collectLeafStates(ExecutionRegion region, List<ExecutionState> leafStates) {
		for ( r : region.subScopes ) {
			r.collectLeafStates(leafStates)
		}
		
		return leafStates	
	}
	
	def last(StateVector sv) {
		sv.offset + sv.size -1
	}
	
	def first(StateVector sv) {
		sv.offset
	}
	
	/**
	 * Returns a states impact state vector. 
	 * 
	 * A regular states state vector defines the range of the state configuration vector where the state or its's sub states are stored if they are active.
	 * Nevertheless a state may have a larger impact on a state configuration vector if sibling states in the same region cover a larger range. 
	 * In these cases these additional positions are 'nulled' if the state is active. So a states impact vector is its regions state vector. 
	 * This impact vector is also used to determine when parent behavior must be executed.
	 */
	def dispatch StateVector impactVector(ExecutionState it) { superScope.impactVector}


	/** 
	 * The impact vector of any other execution scope is the native stateVector of that scope.
	 */
	def dispatch StateVector  impactVector(ExecutionRegion it) { 
		if ((it.superScope.subScopes.last === it) && (it.superScope.impactVector.last > it.stateVector.last))
			return factory.createStateVector => [ sv | 
				sv.offset = it.stateVector.offset
				sv.size = it.superScope.impactVector.last - sv.offset + 1
			] 
		else 
			return stateVector
	}


	/** 
	 * The impact vector of any other execution scope is the native stateVector of that scope.
	 */
	def dispatch StateVector impactVector(ExecutionScope it) { stateVector }



	
	
	def parentScopes(ExecutionScope scope) {
		val parents = <ExecutionScope>newArrayList
		var s = scope
		while(s !== null) {
			parents.add(s)
			s=s.superScope
		}
		return parents
	}
	
	
	def unchecked(Reaction it) {
		return (check === null || check.condition === null )
	}
	
	/**
	 * Collect all scopes beneath this scope which does not contain subscopes and are instances of ExecutionState.
	 */
	def List<ExecutionState> collectLeafScopes(ExecutionScope scope, List<ExecutionState> leafs) {
		if (scope.subScopes.empty) {
			if (scope instanceof ExecutionState) {
				leafs.add(scope as ExecutionState)
			}
		} else {
			for (s:scope.subScopes) {
				s.collectLeafScopes(leafs)
			}
		}
		return leafs
	}
	
	
	
		
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
		steps.findFirst(s | s.name === null || s.name.trim == "" ||  s.name.trim == DEFAULT_SEQUENCE_NAME )
	}
	
	def ExecutionFlow getFlow(EObject it) {
		val root = EcoreUtil2::getRootContainer(it)
		
		return if ( root instanceof ExecutionFlow) root as ExecutionFlow else null
	}
	
	 
}