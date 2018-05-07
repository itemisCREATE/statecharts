/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.util.DFS;

/**
 * 
 * All validation constraints for the meta model element {@link Vertex}
 * 
 * @author terfloth
 * 
 */
public class VertexValidator extends AbstractSGraphValidator {

	private static final String VERTEX_MUST_BE_REACHABLE_MSG = "Node is not reachable.";
	public static final String VERTEX_MUST_BE_REACHABLE_CODE = "vertex.MustBeReachable";

	@Check(CheckType.FAST)
	public void checkVertexMustBeReachable(final Vertex vertex) {
		if (!(vertex instanceof Entry)) {
			final Set<Object> stateScopeSet = new HashSet<>();
			for (EObject obj : EcoreUtil2.eAllContents(vertex)) {
				stateScopeSet.add(obj);
			}
			stateScopeSet.add(vertex);
			final List<Object> externalPredecessors = new ArrayList<>();
			
			DFS dfs = new DFS() {

				@Override
				public Iterator<Object> getElementLinks(Object element) {
					List<Object> elements = new ArrayList<>();

					if (element instanceof org.yakindu.sct.model.sgraph.State) {
						if (!stateScopeSet.contains(element)) {
							externalPredecessors.add(element);
						} else {
							elements.addAll(((org.yakindu.sct.model.sgraph.State) element).getRegions());
							elements.addAll(((org.yakindu.sct.model.sgraph.State) element).getIncomingTransitions());
						}

					} else if (element instanceof Region) {
						elements.addAll(((Region) element).getVertices());
					} else if (element instanceof Entry) {
						if (!stateScopeSet.contains(element)) {
							externalPredecessors.add(element);
						} else {
							elements.addAll(((Entry) element).getIncomingTransitions());
						}

					} else if (element instanceof Vertex) {
						elements.addAll(((Vertex) element).getIncomingTransitions());

					} else if (element instanceof Transition) {
						elements.add(((Transition) element).getSource());

					}

					return elements.iterator();
				}
			};

			dfs.perform(vertex);

			if (externalPredecessors.size() == 0) {
				error(VERTEX_MUST_BE_REACHABLE_MSG, vertex, null, -1, VERTEX_MUST_BE_REACHABLE_CODE);
			}
		}
	}

}
