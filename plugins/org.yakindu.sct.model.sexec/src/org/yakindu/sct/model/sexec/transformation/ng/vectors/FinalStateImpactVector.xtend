package org.yakindu.sct.model.sexec.transformation.ng.vectors

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart

class FinalStateImpactVector {
	
	@Inject extension StateVector
	@Inject extension StatechartExtensions
	
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
	def List<RegularState>[] finalStateImpactVector(Statechart sc) {

		// we use a vector of list of states to mark which final state has impact on the different slots.
		val List<RegularState>[] vector = newArrayOfSize(sc.stateVector.size)
		
		// process all final states and mark all vector positions with the states 
		sc.eAllContents.filter(FinalState).forEach[ fs |
			// the state vector of the final states region is relevant since the final state has impact on its 
			// own vector position and all other positions covered by the region.
			// > if a final state is active then all other positions must contain the null state.
			var regionVector = fs.superScope.stateVector
			for ( i : regionVector.offset ..< regionVector.offset + regionVector.size) {
				// create a list for the slot if it does not already exist.
				if (vector.get(i) === null) {
					vector.set(i, new ArrayList<RegularState>())
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
	def boolean isCompletelyCovered(List<RegularState>[] finalStateImpactVector) {
		finalStateImpactVector.forall[ l | (l !== null) && (!l.isEmpty) ]
	}
}
