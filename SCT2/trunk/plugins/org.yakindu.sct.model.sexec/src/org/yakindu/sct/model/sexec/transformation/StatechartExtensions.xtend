package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.sgraph.Reaction
import org.yakindu.sct.model.sgraph.Transition

class StatechartExtensions {
	
	
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart */
	def int maxOrthogonality(Statechart sc) {
		sc.regions.fold(0, [o, r | r.maxOrthogonality + o])
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a region */
	def int maxOrthogonality(Region r) {
		r.vertices.fold(0, [s, v | {
			val mo = v.maxOrthogonality
			if (mo > s) mo else s }])
	}

	/** the maximum orthogonality of all  pseudo states is 0 */
	def dispatch int maxOrthogonality(Vertex v) { 0 }
	
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int maxOrthogonality(State s) { 
		if ( s.subRegions.size > 0 ) {
			s.subRegions.fold(0, [o, r | r.maxOrthogonality + o])		
		} else 1
	}


	//=================================================================
	// navigation util extensions
	//
		
	def reaction(Trigger tr) { tr.eContainer as Reaction }


	//=================================================================
	// naming util extensions
	//

	def dispatch String id(Object obj) { null }
		
		
	/**
	 * The id of a transition is unique within the context of its source vertex.
	 */	
	def dispatch String id(Transition t) {
		"tr" + if (t.source != null) t.source.outgoingTransitions.indexOf(t) else ""
	}
	
	
	
}
