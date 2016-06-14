/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
/**
 * 
 * @author schwertfeger
 *
 */
public class StateImplTest extends TestCase {
	protected SGraphFactory factory;

	protected Statechart statechart;
	protected Region region;
	private State state;

	@Before
	public void setUp() throws Exception {
		factory = SGraphFactory.eINSTANCE;
		statechart = factory.createStatechart();
		statechart.setName("SC");

		region = factory.createRegion();
		statechart.getRegions().add(region);
		state = factory.createState();
		state.setName(getClass().getSimpleName());
		region.getVertices().add(state);
	}

	@Test
	public void testIsSimple() {
		assertTrue(state.isSimple());

		Region region2 = factory.createRegion();
		state.getRegions().add(region2);
		assertTrue(state.isSimple());

		region2.getVertices().add(factory.createState());
		assertFalse(state.isSimple());

		state.getRegions().add(factory.createRegion());
		assertFalse(state.isSimple());

		region2.getVertices().clear();
		assertTrue(state.isSimple());
	}
}
