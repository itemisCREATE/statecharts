package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.FinalState
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Choice

class StateVectorBuilder {
	
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sc
	
	def defineStateVector(ExecutionFlow flow, Statechart sc) {
		var offset = 0
		for ( r : sc.regions ) {
			offset = offset + defineStateVectors(r, offset)	
		}	
		
		
		flow.stateVector = sexec.factory.createStateVector
		flow.stateVector.offset = 0;
		flow.stateVector.size = offset			
	}
 

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart */
	def int defineStateVectors(Statechart sc, int offset) {
		sc.regions.fold(0, [o, r | r.maxOrthogonality + o])
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a region */
	def int defineStateVectors(Region r, int offset) {
		val maxOrthogonality = r.vertices.fold(0, [s, v | {
			val mo = v.defineStateVectors(offset)
			if (mo > s) mo else s }])
			
		val er = r.create
		er.stateVector = sexec.factory.createStateVector
		er.stateVector.offset = offset;
		er.stateVector.size = maxOrthogonality			
	
		return maxOrthogonality
	}

	/** the maximum orthogonality of all  pseudo states is 0 */
	def dispatch int defineStateVectors(Vertex v, int offset) { 0 }
	
		
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(State s, int offset) { 
		var int maxOrthogonality = 0
		if ( s.regions.size > 0 ) {
			for ( r : s.regions ) {
				maxOrthogonality = maxOrthogonality + r.defineStateVectors(offset+maxOrthogonality)
			}
		} else maxOrthogonality = 1
		
		val es = s.create
		es.stateVector = sexec.factory.createStateVector
		es.stateVector.offset = offset;
		es.stateVector.size = maxOrthogonality			
		
		return maxOrthogonality
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(FinalState s, int offset) { 
		
		val es = s.create
		es.stateVector = sexec.factory.createStateVector
		es.stateVector.offset = offset;
		es.stateVector.size = 1			
		
		return 1
	}

	def dispatch StateVector stateVector(Vertex v) {
		null	
	}
	
	def dispatch StateVector stateVector(RegularState s) {
		s.create.stateVector	
	}
	
	def dispatch StateVector stateVector(Choice choice) {
		choice.parentRegion.create.stateVector	
	}
	
}