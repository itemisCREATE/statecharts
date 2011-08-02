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
package org.yakindu.sct.simulation.runtime.sgraph.builder.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.RTCompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.RTFinalState;
import org.yakindu.sct.simulation.runtime.sgraph.RTNode;
import org.yakindu.sct.simulation.runtime.sgraph.RTPseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.RTRegion;
import org.yakindu.sct.simulation.runtime.sgraph.RTSimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.RTStatechart;
import org.yakindu.sct.simulation.runtime.sgraph.RTTransition;
import org.yakindu.sct.simulation.runtime.sgraph.builder.SGraphBuilder;
import org.yakindu.sct.simulation.runtime.stext.RTTrigger;

/**
 * 
 * @author axel terfloth
 * @author andreas muelder
 * 
 */
public class SGraphBuilderTest {

	private Statechart sourceSC;
	private SGraphFactory graphFactory;
	//TODO: Move to stext
	private StextFactory textFactory;
	private SGraphBuilder builder;

	@BeforeClass
	public static void initContextClassLoader() {
		// set up EMF - the EPackage.Registry requires a context class loader
		if (Thread.currentThread().getContextClassLoader() == null) {
			Thread.currentThread().setContextClassLoader(
					SGraphBuilderTest.class.getClassLoader());
		}
		//SGraphPackage.eINSTANCE.eClass();
		
	}

	@Before
	public void setUp() throws Exception {
		graphFactory = SGraphFactory.eINSTANCE;
		textFactory = StextFactory.eINSTANCE;
		sourceSC = graphFactory.createStatechart();
		sourceSC.setName("SC");
		// sourceSC.setUUID("SC1");
		builder = new SGraphBuilder();
	}

	@After
	public void tearDown() {
		sourceSC = null;
		builder = null;
	}

	@Test
	public void testEmptyStatechart() {
		RTStatechart tSC = builder.build(sourceSC);
		assertNotNull(tSC);
	}
	@Test
	public void testSignalEvents() {
		//TODO: Move to sText
		Scope scope = graphFactory.createScope();
		sourceSC.getScopes().add(scope);
		
		EventDefinition event_a = textFactory.createEventDefinition();
		event_a.setName("a");
		event_a.setType(Type.VOID);
		event_a.setDirection(Direction.IN);
		scope.getEvents().add(event_a);

		Event event_b = textFactory.createEventDefinition();
		event_b.setName("b");
		event_a.setType(Type.VOID);
		event_a.setDirection(Direction.IN);
		scope.getEvents().add(event_b);
		
		RTStatechart tSC = builder.build(sourceSC);
		assertEquals(2, tSC.getSignalEvents().size());
		assertNotNull(tSC.getSignalEvent(event_a.getName()));
		assertNotNull(tSC.getSignalEvent(event_b.getName()));
	}
	
	@Test
	public void testVars() {
		//TODO: Move to sText
		Scope scope = graphFactory.createScope();
		sourceSC.getScopes().add(scope);
		
		VariableDefinition var_a = textFactory.createVariableDefinition();
		var_a.setName("a");
		var_a.setType(Type.INTEGER);
		scope.getVariables().add(var_a);

		VariableDefinition var_b = textFactory.createVariableDefinition();
		var_b.setName("b");
		var_b.setType(Type.BOOLEAN);
		scope.getVariables().add(var_b);
		
		RTStatechart tSC = builder.build(sourceSC);
		assertNotNull(tSC.getVariable(var_a.getName()));
		assertNotNull(tSC.getVariable(var_b.getName()));
		
		assertEquals(0, tSC.getVariable("a").getValue());
		assertEquals(false, tSC.getVariable("b").getValue());
	}
	
	@Test
	public void testTopLevelRegions() throws Exception {
		Region reg_a = graphFactory.createRegion();
		reg_a.setPriority(3);
		sourceSC.getRegions().add(reg_a);

		Region reg_b = graphFactory.createRegion();
		reg_b.setPriority(1);
		sourceSC.getRegions().add(reg_b);

		RTStatechart rtSC = builder.build(sourceSC);
		List<RTRegion> regions = rtSC.getRegions();

		assertEquals(2, regions.size());
		assertEquals(1, regions.get(0).getPriority());
		assertEquals("1", regions.get(0).getId());
		assertEquals(3, regions.get(1).getPriority());
		assertEquals("3", regions.get(1).getId());
	}

	
	/**
	 * public void testSimpleState() {
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
	 */
	
	@Test
	public void testSimpleState() {
		Region region = graphFactory.createRegion();
		region.setPriority(3);
		sourceSC.getRegions().add(region);

		State state = graphFactory.createState();
		state.setName("stateA");
		state.setExpression("entry / raise e1; exit / raise e2;");
		region.getVertices().add(state);

		RTStatechart tSC = builder.build(sourceSC);
		List<RTRegion> regions = tSC.getRegions();

		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		RTNode node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof RTSimpleState);
		RTSimpleState tState = (RTSimpleState) node;
		assertEquals(state.getName(), tState.getName());
		
		fail("complete me");
		//FIXME
//		StatementSequence seq = (StatementSequence) ((ActionStatement) tState
//				.getEntryAction()).getStatement();
//		assertTrue(firstFromSequence(tState.getEntryAction()) instanceof Assign);
//		assertTrue(firstFromSequence(tState.getDoAction()) instanceof Raise);
//		assertTrue(firstFromSequence(tState.getExitAction()) instanceof ProcedureCall);
	}
	

	@Test
	public void testCompboundState() {
		Region region = graphFactory.createRegion();
		region.setPriority(3);
		sourceSC.getRegions().add(region);

		State state = graphFactory.createState();
		state.setName("stateA");
		region.getVertices().add(state);

		Region subRegion = graphFactory.createRegion();
		region.setPriority(0);
		state.getSubRegions().add(subRegion);

		RTStatechart tSC = builder.build(sourceSC);
		List<RTRegion> regions = tSC.getRegions();

		RTNode node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof RTCompoundState);

		RTCompoundState tState = (RTCompoundState) node;
		assertEquals(state.getName(), tState.getName());
		assertEquals(1, tState.getRegions().size());
	}

	@Test
	public void testInitialState() throws Exception {
		testEntryState(EntryKind.INITIAL, PseudostateKind.INITIAL);
	}

	@Test
	public void testDeepHistory() throws Exception {
		testEntryState(EntryKind.DEEP_HISTORY, PseudostateKind.DEEPHISTORY);
	}

	@Test
	public void testShallowHistory() throws Exception {
		testEntryState(EntryKind.SHALLOW_HISTORY,
				PseudostateKind.SHALLOWHISTORY);
	}

	@Test
	public void testChoice() throws Exception {
		Region region = graphFactory.createRegion();
		region.setPriority(3);
		sourceSC.getRegions().add(region);

		Choice entry = graphFactory.createChoice();
		region.getVertices().add(entry);

		RTStatechart tSC = builder.build(sourceSC);
		List<RTRegion> regions = tSC.getRegions();

		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		RTNode node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof RTPseudostate);
		assertEquals(PseudostateKind.CHOICE, ((RTPseudostate) node).getKind());
	}

	@Test
	public void testFinalState() {
		Region region = graphFactory.createRegion();
		region.setPriority(3);
		sourceSC.getRegions().add(region);

		FinalState state = graphFactory.createFinalState();
		region.getVertices().add(state);

		RTStatechart tSC = builder.build(sourceSC);
		List<RTRegion> regions = tSC.getRegions();

		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		RTNode node = regions.get(0).getNodes().iterator().next();
		System.out.println("NODE IS " + node);
		assertTrue(node instanceof RTFinalState);
	}

	/**
	 * Convenience methods...
	 */
	private void testEntryState(EntryKind sourceType, PseudostateKind targetType)
			throws Exception {
		Region region = graphFactory.createRegion();
		region.setPriority(3);
		sourceSC.getRegions().add(region);

		Entry entry = graphFactory.createEntry();
		entry.setKind(sourceType);
		region.getVertices().add(entry);

		RTStatechart tSC = builder.build(sourceSC);
		List<RTRegion> regions = tSC.getRegions();

		assertEquals(1, regions.size());
		assertEquals(1, regions.get(0).getNodes().size());
		RTNode node = regions.get(0).getNodes().iterator().next();
		assertTrue(node instanceof RTPseudostate);
		assertEquals(targetType, ((RTPseudostate) node).getKind());
	}
	@Test
	public void testTransition() {
		//TODO: transition test with events -> move to text
		Scope scope = graphFactory.createScope();
		sourceSC.getScopes().add(scope);
		
		Event e1 = textFactory.createEventDefinition();
		e1.setName("e1");
		scope.getEvents().add(e1);
		
		Event e2 = textFactory.createEventDefinition();
		e2.setName("e2");
		scope.getEvents().add(e2);
		
		Region region = graphFactory.createRegion();
		region.setPriority(3);
		sourceSC.getRegions().add(region);

		State state_a = graphFactory.createState();
		state_a.setName("a");
		region.getVertices().add(state_a);
		
		State state_b = graphFactory.createState();
		state_b.setName("b");
		region.getVertices().add(state_b);
		
		Transition trans = graphFactory.createTransition();
		trans.setSource(state_a);
		trans.setTarget(state_b);
		trans.setPriority(42);
		trans.setExpression("e1,e2,after(200) [a] / a=false;");
		
		state_a.getOutgoingTransitions().add(trans);
		
		RTStatechart tSC = builder.build(sourceSC);
		List<RTRegion> regions = tSC.getRegions();
		
		assertEquals(1, regions.size());
		assertEquals(2, regions.get(0).getNodes().size());
		
		// check if nodes and transition are properly connected...
		RTNode node_a = (RTNode) tSC.getElementByAlias(state_a);
		RTNode node_b = (RTNode) tSC.getElementByAlias(state_b);
		
		assertNotSame(node_a, node_b);
		assertTrue(regions.get(0).getNodes().contains(node_a));
		assertTrue(regions.get(0).getNodes().contains(node_b));
		
		assertEquals(1, node_a.getOutgoingTransitions().size());
		assertEquals(1, node_b.getIncomingTransitions().size());
		
		assertSame(node_a.getOutgoingTransitions().get(0), node_b.getIncomingTransitions().get(0));
		RTTransition tTrans = node_a.getOutgoingTransitions().get(0);
		
		assertSame(node_a, node_a.getOutgoingTransitions().get(0).getSourceNode());
		assertSame(node_b, node_b.getIncomingTransitions().get(0).getTargetNode());
		
		
		// check the properties of the transition
		assertEquals(42, tTrans.getPriority());
		assertEquals("t@1", tTrans.getId());
		
		assertNotNull(tTrans.getTrigger());
		assertTrue(tTrans.getTrigger() instanceof RTTrigger);
		
		RTTrigger rtTrigger = (RTTrigger) tTrans.getTrigger();
		
		assertNotNull(rtTrigger.getGuard());
		fail("complete me");
		//FIXME
//		// Unary expression because new grammar always put a VariableRef inside a positive unary expression
//		assertTrue(((GuardExpression)tTrans.getGuard()).getExpression() instanceof UnaryOperation);
//		assertTrue(((UnaryOperation)((GuardExpression)tTrans.getGuard()).getExpression()).getExpression() instanceof VariableRef);
//		
//		assertNotNull(tTrans.getAction());
//		assertTrue(((ActionStatement)tTrans.getAction()).getStatement() instanceof StatementSequence);

		assertEquals(2, rtTrigger.getSignalTriggers().size());
		assertTrue(rtTrigger.getSignalTriggers().contains(tSC.getSignalEvent("e1")));
		assertTrue(rtTrigger.getSignalTriggers().contains(tSC.getSignalEvent("e2")));

		assertNotNull(tTrans.getTimeTrigger());

	}
	
	

//	private Statement firstFromSequence(Action action) {
//		return ((StatementSequence) ((ActionStatement)action).getStatement()).get(0);
//	}


}
