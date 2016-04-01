/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Axel Terfloth - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * Provides a collection of static functions that perform set operations and calculate derived properties based on the sgraph structure.
 *  
 * @author terfloth
 */
public class SGgraphUtil {

	
	/**
	 * Calculates the common ancestor of to EObjects
	 *  
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static EObject commonAncestor(EObject o1, EObject o2) {
		
		List<EObject> o1Anchestors = collectAncestors(o1, new ArrayList<EObject>());
		List<EObject> o2Anchestors = collectAncestors(o2, new ArrayList<EObject>());
		
		return findCommonAncestor(o1Anchestors, o2Anchestors);
	}

	
	/**
	 * Calculates the common ancestor of to EObjects based on two ancestor list.  The lists are compareredstarting from the root. 
	 * The last same element is the common ancestor.
	 *  
	 * @param o1Anchestors
	 * @param o2Anchestors
	 * @return
	 */
	public static EObject findCommonAncestor(List<EObject> o1Anchestors, List<EObject> o2Anchestors) {
		int max = Math.min(o1Anchestors.size(), o2Anchestors.size());
		EObject commonAncestor = null;
		
		for (int i=0; i<max; i++) {
			if (o1Anchestors.get(i) == o2Anchestors.get(i)) {
				commonAncestor = o1Anchestors.get(i);
			} else {
				break; // do not continue if we came across different amcestors.
			}
		}
		
		return commonAncestor;
	}
	

	/**
	 * Adds all ancestors of an EObject to the provided list. Ancestors are all eContainers starting from the specified element. The ancestors are added starting with the root.
	 *  
	 * @param o1 The EObject instance for which we want to get the ancestors.
	 * @param al A list where the ancestors are added.
	 * @return The list with ancestors (same as @param al) 
	 */
	public static List<EObject> collectAncestors(EObject o1, List<EObject> al) {

		if ( o1 != null ) {
		
			if ( o1.eContainer() != null ) {
				collectAncestors(o1.eContainer(), al);
				al.add(o1.eContainer());
			}
		
		}		
		return al;
	}
	

	/**
	 * Checks if all provided vertices are orthogonal to each other.
	 * 
	 * @param vertices
	 * @return true if the vertices are orthogonal to each other.
	 */
	public static boolean areOrthogonal(List<Vertex> vertices) {
		
		if (vertices == null || vertices.isEmpty()) return true;
		
		List<List<EObject>> ancestorLists = new ArrayList<List<EObject>>();
		
		for (Vertex vertex : vertices) {
			ancestorLists.add(collectAncestors(vertex, new ArrayList<EObject>()));
		}
		
		// check all pairs of verices for orthogonality ...
		for ( int i=0; i<vertices.size()-1; i++) {
			for ( int j=i+1; j<vertices.size(); j++) {
				// ... by checking their common ancestor. f it is a region then the pair of vertices are not orthogonal.
				EObject commonAncestor = findCommonAncestor(ancestorLists.get(i), ancestorLists.get(j));
				if ( commonAncestor instanceof Region ) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	/**
	 * Provides a list of Vertex objects that are source of the provided transitions.
	 * 
	 * @param transitions
	 * @return
	 */
	public static List<Vertex> sources(List<Transition> transitions) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		
		for (Transition transition : transitions) {
			vertices.add(transition.getSource());
		}
		
		return vertices;
	}
	
	
	/**
	 * Provides a list of Vertex objects that are target of the provided transitions.
	 * 
	 * @param transitions
	 * @return
	 */
	public static List<Vertex> targets(List<Transition> transitions) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		
		for (Transition transition : transitions) {
			vertices.add(transition.getTarget());
		}
		
		return vertices;
	}
	
	
	/**
	 * Returns the first NamedElement from the specified collection that matches the specified name.
	 * 
	 * @param coll
	 * @param name
	 * @return
	 */
	public static <T extends NamedElement> T firstNamed(Collection<T> coll, String name) {
		
		for (T t : coll) {
			if (name.equals(t.getName())) return t;
		}
		return null;
	}

}
