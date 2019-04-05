package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.State

class ImpactVector {
	
	@Inject protected extension StateVector
	@Inject protected extension StatechartExtensions
	
	def last(org.yakindu.sct.model.sexec.StateVector sv) {
		sv.offset + sv.size -1
	}
	
	def first(org.yakindu.sct.model.sexec.StateVector sv) {
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
	def dispatch org.yakindu.sct.model.sexec.StateVector impactVector(State it) { superScope.impactVector}


	/** 
	 * The impact vector of any other execution scope is the native stateVector of that scope.
	 */
	def dispatch org.yakindu.sct.model.sexec.StateVector impactVector(Region it) { 
		if ((it.superScope.subScopes.last === it) && (it.superScope.impactVector.last > it.stateVector.last))
		
			return SexecFactory.eINSTANCE.createStateVector => [ sv | 
				sv.offset = it.stateVector.offset
				sv.size = it.superScope.impactVector.last - sv.offset + 1
			] 
		else 
			return stateVector
	}


	/** 
	 * The impact vector of any other execution scope is the native stateVector of that scope.
	 */
	def dispatch org.yakindu.sct.model.sexec.StateVector impactVector(NamedElement it) { stateVector }
	

}