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
package org.yakindu.sct.simulation.runtime.sgraph.builder.test;

import java.util.List;

import junit.framework.TestCase;

import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.simulation.runtime.stext.Assign;
import org.yakindu.sct.simulation.runtime.stext.ProcedureCall;
import org.yakindu.sct.simulation.runtime.stext.Raise;
import org.yakindu.sct.simulation.runtime.stext.Statement;
import org.yakindu.sct.simulation.runtime.stext.StatementSequence;
import org.yakindu.sct.simulation.runtime.stext.UnaryOperation;
import org.yakindu.sct.simulation.runtime.stext.VariableRef;
import org.yakindu.sct.simulation.runtime.sgraph.Action;
import org.yakindu.sct.simulation.runtime.sgraph.ActionStatement;
import org.yakindu.sct.simulation.runtime.sgraph.CompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.FinalState;
import org.yakindu.sct.simulation.runtime.sgraph.GuardExpression;
import org.yakindu.sct.simulation.runtime.sgraph.Node;
import org.yakindu.sct.simulation.runtime.sgraph.Pseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.Region;
import org.yakindu.sct.simulation.runtime.sgraph.SimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.Statechart;
import org.yakindu.sct.simulation.runtime.sgraph.Transition;
import org.yakindu.sct.simulation.runtime.sgraph.builder.StatechartBuilder;

public class StatechartBuilderTest extends TestCase {
	

	static {
		// set up EMF - the EPackage.Registry requires a context class loader ...
		if (Thread.currentThread().getContextClassLoader() == null) {
			Thread.currentThread().setContextClassLoader(StatechartBuilderTest.class.getClassLoader());	
		}
		SGraphPackage.eINSTANCE.eClass();
	}
	
	protected org.yakindu.sct.model.sgraph.Statechart sourceSC;
	protected SGraphFactory factory;
	StatechartBuilder builder;
	
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = SGraphFactory.eINSTANCE;
		sourceSC = factory.createStatechart();
		sourceSC.setName("SC");
		sourceSC.setUUID("SC1");
		builder = new StatechartBuilder();
	}

	

	public void testEmptyStatechart() {
		
		Statechart tSC = builder.build(sourceSC);
		assertNotNull(tSC);
		//assertEquals(sSC.getName(), tSC.)
	}
	
	
	public void testVars() {
		statemachine.Variable var_a = factory.createVariable();
		var_a.setName("a");
		var_a.setDataType(statemachine.DataTypes.INT);
		sourceSC.getDataElement().add(var_a);

		statemachine.Variable var_b = factory.createVariable();
		var_b.setName("b");
		var_b.setDataType(statemachine.DataTypes.BOOLEAN);
		sourceSC.getDataElement().add(var_b);
		
		Statechart tSC = builder.build(sourceSC);
		assertNotNull(tSC.getVariable(var_a.getName()));
		assertNotNull(tSC.getVariable(var_b.getName()));
		
		assertEquals(0, tSC.getVariable("a").getValue());
		assertEquals(false, tSC.getVariable("b").getValue());
	}

	
	
	public void testSignalEvents() {
		statemachine.Event event_a = factory.createEvent();
		event_a.setName("a");
		sourceSC.getDataElement().add(event_a);

		statemachine.Event event_b = factory.createEvent();
		event_b.setName("b");
		sourceSC.getDataElement().add(event_b);
		
		Statechart tSC = builder.build(sourceSC);
		assertEquals(2, tSC.getSignalEvents().size());
		assertNotNull(tSC.getSignalEvent(event_a.getName()));
		assertNotNull(tSC.getSignalEvent(event_b.getName()));
	}

	
	
	public void testTopLevelRegions() throws Exception {
		statemachine.Region reg_a = factory.createRegion();
		reg_a.setPriority(3);
		sourceSC.getRegion().add(reg_a);

		statemachine.Region reg_b = factory.createRegion();
		reg_b.setPriority(1);
		sourceSC.getRegion().add(reg_b);

		Statechart tSC = builder.build(sourceSC);
		List<Region> regions = tSC.getRegions();
		
		assertEquals(2, regions.size());
		assertEquals(1, regions.get(0).getPriority());
		assertEquals("1", regions.get(0).getId());
		assertEquals(3, regions.get(1).getPriority());
		assertEquals("3", regions.get(1).getId());
	}

	

	
	public void testChoice() throws Exception {
		testPseudoState(statemachine.PseudoTypes.CHOICE, PseudostateKind.CHOICE);
	}

	public void testJunction() throws Exception {
		testPseudoState(statemachine.PseudoTypes.JUNCTION, PseudostateKind.JUNCTION);
	}

	public void testInitialState() throws Exception {
		testPseudoState(statemachine.PseudoTypes.INITIAL, PseudostateKind.INITIAL);
	}

	public void testDeepHistory() throws Exception {
		testPseudoState(statemachine.PseudoTypes.DEEP_HISTORY, PseudostateKind.DEEPHISTORY);
	}
	
	public void testShallowHistory() throws Exception {
		testPseudoState(statemachine.PseudoTypes.SHALLOW_HISTORY, PseudostateKind.SHALLOWHISTORY);
	}

	
	public void testPseudoState(statemachine.PseudoTypes sourceType, PseudostateKind targetType) throws Exception {
		statemachine.Region region = factory.createRegion();
		region.setPriority(3);
		sourceSC.getRegion().add(region);

		statemachine.Pseudostate initial = factory.createPseudostate();
		initial.setPseudoType(sourceType);
		initial.setId(1);
		region.getState().add(initial);
		
		Statechart tSC = builder.build(sourceSC);
		List<Region> regions = tSC.getRegions();
		
		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		Node node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof Pseudostate);
		assertEquals(targetType, ((Pseudostate)node).getKind());
	}
	
	
	public void testSimpleState() {
		statemachine.Region region = factory.createRegion();
		region.setPriority(3);
		sourceSC.getRegion().add(region);

		statemachine.State state = factory.createState();
		state.setName("stateA");
		state.setId(1);
		state.setEntry("a=1;");
		state.setDo("raise(abc);");
		state.setExit("call();");
		region.getState().add(state);
		
		Statechart tSC = builder.build(sourceSC);
		List<Region> regions = tSC.getRegions();
		
		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		Node node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof SimpleState);

		SimpleState tState = (SimpleState)node;
		assertEquals(state.getName(), tState.getName());
		
		StatementSequence seq = (StatementSequence) ((ActionStatement)tState.getEntryAction()).getStatement();
		assertTrue(firstFromSequence(tState.getEntryAction()) instanceof Assign);
		assertTrue(firstFromSequence(tState.getDoAction()) instanceof Raise);
		assertTrue(firstFromSequence(tState.getExitAction()) instanceof ProcedureCall);
	}
	
	
	public void testFinalState() {
		statemachine.Region region = factory.createRegion();
		region.setPriority(3);
		sourceSC.getRegion().add(region);

		statemachine.FinalState state = factory.createFinalState();
		state.setId(1);
		region.getState().add(state);
		
		Statechart tSC = builder.build(sourceSC);
		List<Region> regions = tSC.getRegions();
		
		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		Node node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof FinalState);
	}
	

	
	/**
	 * TODO: CompoundStates do not support do-Actions 
	 */
	public void testCompboundState() {
		statemachine.Region region = factory.createRegion();
		region.setPriority(3);
		sourceSC.getRegion().add(region);

		statemachine.State state = factory.createState();
		state.setName("stateA");
		state.setId(1);
		state.setEntry("a=1;");
		state.setDo("raise(abc);");
		state.setExit("call();");
		region.getState().add(state);

		statemachine.Region subRegion = factory.createRegion();
		region.setPriority(0);
		state.getRegion().add(subRegion);

		
		Statechart tSC = builder.build(sourceSC);
		List<Region> regions = tSC.getRegions();
		

		Node node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof CompoundState);

		CompoundState tState = (CompoundState)node;
		assertEquals(state.getName(), tState.getName());
		
		StatementSequence seq = (StatementSequence) ((ActionStatement)tState.getEntryAction()).getStatement();
		assertTrue(firstFromSequence(tState.getEntryAction()) instanceof Assign);
		// assertTrue(firstFromSequence(tState.getDoAction()) instanceof Raise);
		assertTrue(firstFromSequence(tState.getExitAction()) instanceof ProcedureCall);
		
		assertEquals(1, tState.getRegions().size());
	}
	
	
	
	public void testTransition() {
		statemachine.Event e1 = factory.createEvent();
		e1.setName("e1");
		sourceSC.getDataElement().add(e1);
		
		statemachine.Event e2 = factory.createEvent();
		e2.setName("e2");
		sourceSC.getDataElement().add(e2);
		
		statemachine.Region region = factory.createRegion();
		region.setPriority(3);
		sourceSC.getRegion().add(region);

		statemachine.State state_a = factory.createState();
		state_a.setId(1);
		state_a.setName("a");
		region.getState().add(state_a);
		
		statemachine.State state_b = factory.createState();
		state_b.setId(2);
		state_b.setName("b");
		region.getState().add(state_b);
		
		statemachine.Transition trans = factory.createTransition();
		trans.setSourceNode(state_a);
		trans.setTargetNode(state_b);
		trans.setId(1);
		trans.setPriority(42);
		trans.setExpression("e1,e2,after(200) [a] / a=false;");
		
		sourceSC.getTransition().add(trans);
		
		Statechart tSC = builder.build(sourceSC);
		List<Region> regions = tSC.getRegions();
		
		assertEquals(1, regions.size());
		assertEquals(2, regions.get(0).getNodes().size());
		
		// check if nodes and transition are properly connected...
		Node node_a = (Node) tSC.getElementByAlias(state_a);
		Node node_b = (Node) tSC.getElementByAlias(state_b);
		
		assertNotSame(node_a, node_b);
		assertTrue(regions.get(0).getNodes().contains(node_a));
		assertTrue(regions.get(0).getNodes().contains(node_b));
		
		assertEquals(1, node_a.getOutgoingTransitions().size());
		assertEquals(1, node_b.getIncomingTransitions().size());
		
		assertSame(node_a.getOutgoingTransitions().get(0), node_b.getIncomingTransitions().get(0));
		Transition tTrans = node_a.getOutgoingTransitions().get(0);
		
		assertSame(node_a, node_a.getOutgoingTransitions().get(0).getSourceNode());
		assertSame(node_b, node_b.getIncomingTransitions().get(0).getTargetNode());
		
		
		// check the properties of the transition
		assertEquals(42, tTrans.getPriority());
		assertEquals("t@1", tTrans.getId());
		
		assertNotNull(tTrans.getGuard());
		// Unary expression because new grammar always put a VariableRef inside a positive unary expression
		assertTrue(((GuardExpression)tTrans.getGuard()).getExpression() instanceof UnaryOperation);
		assertTrue(((UnaryOperation)((GuardExpression)tTrans.getGuard()).getExpression()).getExpression() instanceof VariableRef);
		
		assertNotNull(tTrans.getAction());
		assertTrue(((ActionStatement)tTrans.getAction()).getStatement() instanceof StatementSequence);

		assertEquals(2, tTrans.getSignalTriggers().size());
		assertTrue(tTrans.getSignalTriggers().contains(tSC.getSignalEvent("e1")));
		assertTrue(tTrans.getSignalTriggers().contains(tSC.getSignalEvent("e2")));

		assertNotNull(tTrans.getTimeTrigger());

	}
	
	

	private Statement firstFromSequence(Action action) {
		return ((StatementSequence) ((ActionStatement)action).getStatement()).get(0);
	}
	
	

}
