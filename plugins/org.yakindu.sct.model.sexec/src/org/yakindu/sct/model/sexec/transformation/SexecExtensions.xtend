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
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

class SexecExtensions {
	
	
	static String DEFAULT_SEQUENCE_NAME = "default" 
	
	def factory() { SexecFactory::eINSTANCE }
	
	
	
	def newEnterStateStep(ExecutionState s) {
		var EnterState ess
		if (s != null) {
			ess = factory.createEnterState
			ess.state = s	
		}
		return ess
	}
	
	
	def newExitStateStep(ExecutionState s) {
		var ExitState ess  
		if (s != null) {
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
	
	def parentScopes(ExecutionScope scope) {
		val parents = <ExecutionScope>newArrayList
		var s = scope
		while(s != null) {
			parents.add(s)
			s=s.superScope
		}
		return parents
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
		steps.findFirst(s | s.name == null || s.name.trim == "" ||  s.name.trim == DEFAULT_SEQUENCE_NAME )
	}
	
	def ExecutionFlow getFlow(EObject it) {
		(EcoreUtil2::getRootContainer(it) as ExecutionFlow)
	}
	
	 
}