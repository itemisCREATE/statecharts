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

class SexecExtensions {
	
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
}