package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex

class StateVector {
	
	@Inject extension SexecExtensions sexec
	@Inject extension StatechartExtensions sc
	
	def dispatch create sexec.factory.createStateVector stateVector(Statechart sc) {
		var offset = 0
		for ( r : sc.regions ) {
			offset = offset + defineStateVectors(r, offset)	
		}
		it.offset = 0
		it.size = offset
	}
	
	def dispatch create sexec.factory.createStateVector stateVector(Region r) {}
	
	def dispatch create sexec.factory.createStateVector stateVector(State r) {}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart */
	def dispatch int defineStateVectors(Statechart sc, int offset) {
		sc.regions.fold(0, [o, r | r.maxOrthogonality + o])
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a region */
	def dispatch int defineStateVectors(Region r, int offset) {
		val maxOrthogonality = r.vertices.fold(0, [s, v | {
			val mo = v.defineStateVectors(offset)
			if (mo > s) mo else s }])
			
		r.stateVector.offset = offset
		r.stateVector.size = maxOrthogonality
	
		return maxOrthogonality
	}

	/** the maximum orthogonality of all  pseudo states is 0 */
	def dispatch int defineStateVectors(Vertex v, int offset) { 0 }
	
		
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(State s, int offset) { 
		var int maxOrthogonality = 0
		if ( s.regions.containsStates) {
			for ( r : s.regions ) {
				maxOrthogonality = maxOrthogonality + r.defineStateVectors(offset+maxOrthogonality)
			}
		} else maxOrthogonality = 1
		
		s.stateVector.offset = offset
		s.stateVector.size = maxOrthogonality
		
		return maxOrthogonality
	}
	
	def boolean containsStates (List<Region> regions){
		regions.filter(r | r.vertices.filter(typeof(RegularState)).size > 0).size > 0
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(FinalState s, int offset) {
		s.stateVector.offset = offset
		s.stateVector.size = 1
		return 1
	}

}