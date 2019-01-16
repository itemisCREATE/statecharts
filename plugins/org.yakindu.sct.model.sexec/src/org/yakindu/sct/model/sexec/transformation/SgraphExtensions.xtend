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

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.Annotation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.EntryKind
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.stext.stext.EntryPointSpec
import org.yakindu.sct.model.stext.stext.ExitPointSpec

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


	def parentState (EObject obj) {
		EcoreUtil2.getAllContainers(obj).filter(typeof (RegularState)).head
	} 

	
	def List<EObject> containers(EObject obj) {
		val containerList = new ArrayList<EObject>()
		collectContainers(obj, containerList)
		return containerList
	}
	
	def void collectContainers(EObject obj, List<EObject> containerList) {
		containerList += obj
		if (obj?.eContainer !== null) collectContainers(obj.eContainer, containerList);
	}

	def collectEntries(Region r) {
		r.vertices.filter(typeof(Entry))
	}

	def entry(Region r) {
		r.vertices.findFirst(v | v instanceof Entry && (v.name === null || "".equals(v.name) || v.name == 'default') ) as Entry
	}
	
	
	/**
	 * Returns the name of the specified entry point or 'default' if it does not exist
	 */
	def String entryPointName(Transition t) {
		val eps = t.properties.filter(typeof(EntryPointSpec)).head
		
		if (eps === null) 'default' else eps.entrypoint	
	}

	/**
	 * Returns the name of the specified entry point or 'default' if it does not exist
	 */
	def String exitPointName(Transition t) {
		val eps = t.properties.filter(typeof(ExitPointSpec)).head
		
		if (eps === null) 'default' else eps.exitpoint	
	}
	

	
	/**
	 * Retrieves the target from an entry.
	 * TODO: validation of preconditions for entry targets e.g every region needs an entry with appropriate target
	 */
	def State target(Entry entry) {
		val obj = entry.transition?.target
		if (obj instanceof State ) return obj		
		
		return null
	}
	
	def Transition transition(Entry entry) {
		if ( entry?.outgoingTransitions !== null) {
			if (entry.outgoingTransitions.size > 0) {
				return entry.outgoingTransitions.get(0)
			}
		}	
		
		return null	
	}
	
	
	def List<RegularState> collectLeafStates(RegularState state, List<RegularState> leafStates) {
		if ( state.isLeaf ) 
			leafStates += state
		else if ( state instanceof State ) {
			val State s = state		
			for ( r : s.regions ) {
				for ( v : r.vertices ) {
					if (v instanceof RegularState) collectLeafStates(v, leafStates)
				}
			}
		}
		return leafStates	
	}
	
	 
		
	def List<RegularState> collectLeafStates(Region region, List<RegularState> leafStates) {
		for ( v : region.vertices ) {
			if (v instanceof RegularState) collectLeafStates(v, leafStates)
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
		if(element === null) {
			return null
		}
		if(element instanceof ExecutionFlow) {
			if(element.sourceElement instanceof Statechart) {
				return (element.sourceElement as Statechart)
			}
		}
		EcoreUtil2.getContainerOfType(element, typeof(Statechart))
	}
	
	/** 
	 * Returns wether a child first execution order is defined for the statechart.
	 * 
	 * This feature can be configured by using the ChildFirstExecution annotation.
	 * 
	 * @return true if child first execution is declared.
	 */
	def boolean isChildFirstExecution(Statechart it) {
		findAnnotation("ChildFirstExecution") !== null
	}
	
	/** 
	 * Returns wether interleaved or non interleaved execution order for local reactions is required.
	 * 
	 * Local reactions are interleaved when they are processed directly after a states transition checks. 
	 * They are not interleaved if they are processed after all transitions along the state hierarchy are checked.
	 * 
	 * Currently just interleaved execution order is supportede for all kinds of statecharts. Especially orthogogal 
	 * statecharts are not supported with non interleaved execution order. Thats why just true is returned. In future
	 * an annotation should be introduced.
	 * 
	 * @return true if interleaved local reaction execution is required.
	 */
	def boolean interleaveLocalReactions(Statechart it) {
		return true	
	}
	
	
	def Annotation findAnnotation(AnnotatableElement it, String name) {
		annotations.filter[a | name.equals(a.type.name)].head
	}	
	 
}