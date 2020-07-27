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

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex

class StateVectorBuilder {
	
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sc
	@Inject extension SgraphExtensions sgraph
	
	def defineHistoryVector(ExecutionFlow flow, Statechart sc) {
		var offset = -1
		for ( r : sc.eAllContents.filter(typeof(Region)).toIterable) {
			if (r.requireHistory) {
				offset = offset+1
				val er = r.create
				er.historyVector = sexec.factory.createStateVector
				er.historyVector.offset = offset;
				er.historyVector.size = 1
			}
		}
		if (offset != -1) {			
			flow.historyVector = sexec.factory.createStateVector
			flow.historyVector.offset = 0;
			flow.historyVector.size = offset+1
		}
	}

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
	def dispatch int defineStateVectors(Statechart sc, int offset) {
		sc.regions.fold(0, [o, r | r.maxOrthogonality + o])
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a region */
	def dispatch int defineStateVectors(Region r, int offset) {
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
		if ( s.regions.containsStates) {
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
	
	def boolean containsStates (List<Region> regions){
		regions.filter(r | r.vertices.filter(typeof(RegularState)).size > 0).size > 0
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int defineStateVectors(FinalState s, int offset) { 
		
		val es = s.create
		es.stateVector = sexec.factory.createStateVector
		es.stateVector.offset = offset;
		es.stateVector.size = 1			
		
		return 1
	}

	
}