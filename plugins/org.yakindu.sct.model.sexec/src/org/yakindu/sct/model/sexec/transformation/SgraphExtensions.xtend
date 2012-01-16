package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Entry
import java.util.List
import org.eclipse.emf.ecore.EObject
import java.util.ArrayList

class SgraphExtensions {
	
	def factory() { SGraphFactory::eINSTANCE }
	
	def dispatch isLeaf(RegularState s) { false }
	
	def dispatch isLeaf(FinalState s) {true}
	
	def dispatch isLeaf(State s) { s.simple }
	

	// TODO: rename since this list also includes the start state or change implementation and usages
	def List<RegularState> parentStates(RegularState s) {
		s.containers.filter( typeof(RegularState) ).toList		
	}

	def List<RegularState> parentStates(Region s) {
		s.containers.filter( typeof(RegularState) ).toList		
	}


	def List<EObject> containers(EObject obj) {
		val containerList = new ArrayList<EObject>()
		collectContainers(obj, containerList)
		return containerList
	}
	
	def void collectContainers(EObject obj, List<EObject> containerList) {
		containerList += obj
		if (obj?.eContainer != null) collectContainers(obj.eContainer, containerList);
	}


	def entry(Region r) {
		r.vertices.findFirst(v | v instanceof Entry && (v.name == null || "".equals(v.name) || v.name == 'default') ) as Entry
	}
	
	/**
	 * Retrieves the target from an entry.
	 * TODO: validation of preconditions for entry targets e.g every region needs an entry with appropriate target
	 */
	def target(Entry entry) {
		if ( entry?.outgoingTransitions != null) {
			if (entry.outgoingTransitions.size > 0) {
				val target =entry.outgoingTransitions.get(0).target
				if (target instanceof State ) target as State	
			}
		}
	}
	
	
	def List<RegularState> collectLeafStates(RegularState state, List<RegularState> leafStates) {
		if ( state.isLeaf ) 
			leafStates += state
		else if ( state instanceof State ) {
			val State s = state as State		
			for ( r : s.regions ) {
				for ( v : r.vertices ) {
					if (v instanceof RegularState) collectLeafStates(v as RegularState, leafStates)
				}
			}
		}
		return leafStates	
	}
	
	 
		
	def List<RegularState> collectLeafStates(Region region, List<RegularState> leafStates) {
		for ( v : region.vertices ) {
			if (v instanceof RegularState) collectLeafStates(v as RegularState, leafStates)
		}

		return leafStates	
	}
	
	
	
}