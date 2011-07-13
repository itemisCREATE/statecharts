/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.sgraph.test;

import java.util.HashSet;

import org.yakindu.sct.simulation.runtime.stext.Assign;
import org.yakindu.sct.simulation.runtime.stext.Constant;
import org.yakindu.sct.simulation.runtime.stext.Variable;
import org.yakindu.sct.simulation.runtime.stext.VariableRef;
import org.yakindu.sct.simulation.runtime.sgraph.ActionStatement;
import org.yakindu.sct.simulation.runtime.sgraph.GuardExpression;
import org.yakindu.sct.simulation.runtime.sgraph.Pseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.Region;
import org.yakindu.sct.simulation.runtime.sgraph.SignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.SimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.Statechart;
import org.yakindu.sct.simulation.runtime.sgraph.Transition;

import junit.framework.TestCase;

public class StatechartTest extends TestCase {

	
	
	private Region rootRegion;
	protected Statechart statechart;
	private Pseudostate initial;
	private SimpleState state1;
	private Transition trans;


	/**
	 * The setup creates a basic statechart that consists of a single root region, an initial state within this region, 
	 * a simple state, and a transition from the initial state to the simple state. This statechart will be extended 
	 * by the different test cases as appropriate.
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		statechart = new Statechart("SC");
		rootRegion = new Region("r", 1, statechart);
		initial = new Pseudostate("i", rootRegion, PseudostateKind.INITIAL);
		state1 = new SimpleState("s1", "a", rootRegion, null, null, null);
		trans = new Transition("t_i_s1", 1, null, null, null, null, initial, state1);
	}


	/**
	 * The simple statechart as created by the setup must enter  {@link #state1}when the statechart is initially entered.
	 * After a run cycle the current state must stioll be {@link #state1}. 
	 */
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
	public void notestTransitionWithoutTrigger() {
		
		SimpleState state2 = new SimpleState("s2", "b", rootRegion, null, null, null);
		new Transition("t_s1_s2", 1, null, null, null, null, state1, state2);
		
		assertNull(rootRegion.getCurrentState());
		
		statechart.enter();		
		assertEquals(state1, rootRegion.getCurrentState());

		statechart.runCycle();
		assertEquals(state2, rootRegion.getCurrentState());		
	}


	/**
	 * A transition with a trigger must only be taken if the event matches the signal event.
	 */
	public void testTransitionTrigger() {
		
		final SignalEvent event = new SignalEvent("event");
		
		SimpleState state2 = new SimpleState("s2", "b", rootRegion, null, null, null);
		new Transition("t_s1_s2", 1, null, 
				new HashSet<SignalEvent>(){{add(event);}}, 
				null, null, state1, state2);
		
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
	 * Even if a transition trigger matches the transition will only be taken if an existing guard evaluates to true. 
	 */
	public void testTransitionWithTriggerAndGuard() {
		
		final SignalEvent event = new SignalEvent("event");
		Variable var = new Variable("v");
		statechart.addVariable(var);
		
		SimpleState state2 = new SimpleState("s2", "b", rootRegion, null, null, null);
		new Transition("t_s1_s2", 1, null, 
				new HashSet<SignalEvent>(){{add(event);}}, 
				new GuardExpression(new VariableRef("v"), statechart), 
				null, state1, state2);
		
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
	public void testTransitionWithAction() {
		
		final SignalEvent event = new SignalEvent("event");
		Variable var = new Variable("v");
		statechart.addVariable(var);
		
		SimpleState state2 = new SimpleState("s2", "b", rootRegion, null, null, null);
		new Transition("t_s1_s2", 1, null, 
				new HashSet<SignalEvent>(){{add(event);}}, 
				null, 
				new ActionStatement(new Assign(new VariableRef("v"), new Constant(42)), statechart), 
				state1, state2);
		
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
