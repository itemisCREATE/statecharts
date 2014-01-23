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
import org.yakindu.sct.model.sgraph.EntryKind
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.stext.stext.EntryPointSpec
import org.yakindu.sct.model.stext.stext.ExitPointSpec
import org.yakindu.sct.model.sgraph.Statechart

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

	def collectEntries(Region r) {
		r.vertices.filter(typeof(Entry))
	}

	def entry(Region r) {
		r.vertices.findFirst(v | v instanceof Entry && (v.name == null || "".equals(v.name) || v.name == 'default') ) as Entry
	}
	
	
	/**
	 * Returns the name of the specified entry point or 'default' if it does not exist
	 */
	def String entryPointName(Transition t) {
		val eps = t.properties.filter(typeof(EntryPointSpec)).head
		
		if (eps == null) 'default' else eps.entrypoint	
	}

	/**
	 * Returns the name of the specified entry point or 'default' if it does not exist
	 */
	def String exitPointName(Transition t) {
		val eps = t.properties.filter(typeof(ExitPointSpec)).head
		
		if (eps == null) 'default' else eps.exitpoint	
	}
	

	
	/**
	 * Retrieves the target from an entry.
	 * TODO: validation of preconditions for entry targets e.g every region needs an entry with appropriate target
	 */
	def target(Entry entry) {
		var State target = null
		if ( entry?.outgoingTransitions != null) {
			if (entry.outgoingTransitions.size > 0) {
				val obj =entry.outgoingTransitions.get(0).target
				if (obj instanceof State ) target = obj as State	
			}
		}
		return target
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
	
	def requireDeepHistory(Region r) {
		 r.containers.filter(typeof(Region)).exists(p|p.vertices.filter(typeof(Entry)).exists(v|v.kind == EntryKind::DEEP_HISTORY))
	}
	def requireShallowHistory(Region r) {
		r.vertices.filter(typeof(Entry)).exists(v|v.kind == EntryKind::SHALLOW_HISTORY)		
	}
	def requireHistory(Region r) {
		r.requireDeepHistory || r.requireShallowHistory
	}
	
	/**
	 * Tries to find the parent {@link Statechart} Object of the element.
	 * 
	 * @param element
	 * @return
	 * 		The parent statechart or null.
	 */
	def Statechart getStatechart(EObject element){
		var Statechart ret = null
		if (element != null) {
			if (element instanceof Statechart) {
				return element as Statechart
			}
			else {
				ret = getStatechart(element.eContainer)
			}
		}
		return ret
	}
}