/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.extensions

import java.util.List
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.FinalState
import java.util.ArrayList

/**
 * 
 * @author Axel Terfloth
 */
class StateVectorExtensions {
	
	/**
	 * This function calculates the final state impact vector.
	 * This vector is an array of the size of the state machines state vector. 
	 * Each array slot holds a List of ExecutionState instances that map to FinalState elements
	 * in the orginal model. The assignment of a final state to a slot means that if this state is 
	 * active it has impact on the vector slot. Here two cases have to be distinguished:
	 * 
	 * 1. The final state is directly assigned to the slot (the states vector offset). If the state is active
	 *    then the slot will contain a reference to this state
	 * 2. If the parent region contains orthogonal states then all other vector positions covered by the region
	 *    are empty (refer to no state) if the state is active so there is an indirect impact on the vector. 
	 */
	def List<ExecutionState>[] finalStateImpactVector(ExecutionFlow flow) {

		// we use a vector of list of states to mark which final state has impact on the different slots.
		val List<ExecutionState>[] vector = newArrayOfSize(flow.stateVector.size)
		
		// process all final states and mark all vector positions with the states 
		flow.states.filter[s | s.sourceElement instanceof FinalState].forEach[ fs |
			// the state vector of the final states region is relevant since the final state has impact on its 
			// own vector position and all other positions covered by the region.
			// > if a final state is active then all other positions must contain the null state.
			var regionVector = fs.superScope.stateVector
			for ( i : regionVector.offset ..< regionVector.offset + regionVector.size) {
				// create a list for the slot if it does not already exist.
				if (vector.get(i) == null) {
					vector.set(i, new ArrayList<ExecutionState>())
				}
				// and add the final state to it.
				vector.get(i).add(fs);  
				// so all vector positions are marked with all those final states that have impact on the slot.
			}
		]			
				
		return vector
	}
	
	
	/** 
	 * Checks if all state vector positions are covered by states. 
	 */
	def boolean isCompletelyCovered(List<ExecutionState>[] finalStateImpactVector) {
		finalStateImpactVector.forall[ l | (l != null) && (!l.isEmpty) ]
	}
	
	
	
}