package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.ScopedElement
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

class ImpactVector {
	
	@Inject protected extension StateVector
	
	@Inject extension SexecExtensions sexec
	
	
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
		
			return sexec.factory.createStateVector => [ sv | 
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
	
	def dispatch protected superScope(State state) {
		state.parentRegion
	}
	
	def dispatch protected superScope(Region region) {
		region.composite as NamedElement
	}
	
	def dispatch protected subScopes(Statechart sc) {
		sc.scopes
	}

	def dispatch protected subScopes(State state) {
		state.scopes
	}
	
	def dispatch protected subScopes(Region region) {
		region.vertices.filter(ScopedElement)
	}
}