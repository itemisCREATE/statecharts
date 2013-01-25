/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.util;

import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class TestHelper {

	public State getStateByName(Statechart statechart, String name) {
		EList<Region> regions = statechart.getRegions();
		for (Region region : regions) {
			EList<Vertex> vertices = region.getVertices();
			for (Vertex vertex : vertices) {
				if ((vertex instanceof State) && vertex.getName().equals(name)) {
					return (State) vertex;
				}
			}
		}
		return null;
	}
}
