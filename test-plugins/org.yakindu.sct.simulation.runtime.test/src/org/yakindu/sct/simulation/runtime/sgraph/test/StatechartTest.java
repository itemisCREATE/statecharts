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
package org.yakindu.sct.simulation.runtime.sgraph.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.simulation.runtime.sgraph.RTActionStatement;
import org.yakindu.sct.simulation.runtime.sgraph.GuardExpression;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.RTPseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.RTRegion;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTSimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.RTStatechart;
import org.yakindu.sct.simulation.runtime.sgraph.RTTransition;
import org.yakindu.sct.simulation.runtime.stext.Assign;
import org.yakindu.sct.simulation.runtime.stext.Constant;
import org.yakindu.sct.simulation.runtime.stext.RTVariable;
import org.yakindu.sct.simulation.runtime.stext.VariableRef;

@SuppressWarnings("all")
public class StatechartTest {

	private RTRegion rootRegion;
	protected RTStatechart statechart;
	private RTPseudostate initial;
	private RTSimpleState state1;
	private RTTransition trans;

	/**
	 * The setup creates a basic statechart that consists of a single root
	 * region, an initial state within this region, a simple state, and a
	 * transition from the initial state to the simple state. This statechart
	 * will be extended by the different test cases as appropriate.
	 */
	@Before
	public void setUp() throws Exception {
		statechart = new RTStatechart("SC");
		rootRegion = new RTRegion("r", 1, statechart);
		initial = new RTPseudostate("i", rootRegion, PseudostateKind.INITIAL);
		state1 = new RTSimpleState("s1", "a", rootRegion, null, null, null);
		trans = new RTTransition("t_i_s1", 1, null, null, null, null, initial,
				state1);
	}

	/**
	 * The simple statechart as created by the setup must enter {@link #state1}
	 * when the statechart is initially entered. After a run cycle the current
	 * state must stioll be {@link #state1}.
	 */
	@Test
	public void testSimpleStatechart() {

		assertNull(rootRegion.getCurrentState());

		statechart.enter();
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.runCycle();
		assertEquals(state1, rootRegion.getCurrentState());
	}

	/**
	 * TODO: does not work currently. See bug #
	 */
	@Test
	public void notestTransitionWithoutTrigger() {

		RTSimpleState state2 = new RTSimpleState("s2", "b", rootRegion, null,
				null, null);
		new RTTransition("t_s1_s2", 1, null, null, null, null, state1, state2);

		assertNull(rootRegion.getCurrentState());

		statechart.enter();
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.runCycle();
		assertEquals(state2, rootRegion.getCurrentState());
	}

	/**
	 * A transition with a trigger must only be taken if the event matches the
	 * signal event.
	 */
	@Test
	public void testTransitionTrigger() {

		final RTSignalEvent event = new RTSignalEvent("event");

		RTSimpleState state2 = new RTSimpleState("s2", "b", rootRegion, null,
				null, null);
		new RTTransition("t_s1_s2", 1, null, new HashSet<RTSignalEvent>() {
			{
				add(event);
			}
		}, null, null, state1, state2);

		assertNull(rootRegion.getCurrentState());

		statechart.enter();
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.runCycle();
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.setEvent(event);
		statechart.runCycle();
		assertEquals(state2, rootRegion.getCurrentState());
	}

	/**
	 * Even if a transition trigger matches the transition will only be taken if
	 * an existing guard evaluates to true.
	 */
	@Test
	public void testTransitionWithTriggerAndGuard() {

		final RTSignalEvent event = new RTSignalEvent("event");
		RTVariable var = new RTVariable("v");
		statechart.addVariable(var);

		RTSimpleState state2 = new RTSimpleState("s2", "b", rootRegion, null,
				null, null);
		new RTTransition("t_s1_s2", 1, null, new HashSet<RTSignalEvent>() {
			{
				add(event);
			}
		}, new GuardExpression(new VariableRef("v"), statechart), null, state1,
				state2);

		assertNull(rootRegion.getCurrentState());

		statechart.enter();
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.getVariable("v").setValue(false);
		statechart.setEvent(event);
		statechart.runCycle();
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.getVariable("v").setValue(true);
		statechart.setEvent(event);
		statechart.runCycle();
		assertEquals(state2, rootRegion.getCurrentState());
	}

	/**
	 * When a transition is taken then the transition action must be performed.
	 */
	@Test
	public void testTransitionWithAction() {

		final RTSignalEvent event = new RTSignalEvent("event");
		RTVariable var = new RTVariable("v");
		statechart.addVariable(var);

		RTSimpleState state2 = new RTSimpleState("s2", "b", rootRegion, null,
				null, null);
		new RTTransition("t_s1_s2", 1, null, new HashSet<RTSignalEvent>() {
			{
				add(event);
			}
		}, null, new RTActionStatement(new Assign(new VariableRef("v"),
				new Constant(42)), statechart), state1, state2);

		assertNull(rootRegion.getCurrentState());

		statechart.enter();
		assertEquals(state1, rootRegion.getCurrentState());

		assertNull(statechart.getVariable("v").getValue());

		statechart.setEvent(event);
		statechart.runCycle();
		assertEquals(state2, rootRegion.getCurrentState());
		assertEquals(42, statechart.getValue("v"));
	}
	

}
