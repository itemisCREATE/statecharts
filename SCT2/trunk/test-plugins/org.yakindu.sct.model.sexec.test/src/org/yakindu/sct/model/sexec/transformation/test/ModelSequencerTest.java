package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.*;


import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author axel terfloth
 * 
 */
public class ModelSequencerTest {

	@Inject
	private ModelSequencer sequencer;

	@Before
	public void setup() {
		Injector injector = Guice.createInjector(new SequencerModule());
		injector.injectMembers(this);
	}

	
	
	/**
	 * The name of the execution flow must be equal to the statechart name.
	 */
	@Test public void testFlowName() {
		Statechart sc = _createStatechart("Test");
		assertEquals(sc.getName(), sequencer.transform(sc).getName());
	}
	
	/**
	 * The event refs used in the trigger condition must refer to the event declarations in the flow model 
	 * and not the sc source model.
	 */
	@Test public void testTriggerEventDeclarationIntegrity() {

		Statechart sc = _createStatechart("test");
		InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		EventDefinition e1 = _createEventDefinition("e1", s_scope);
		Region r = _createRegion("main", sc);
		State s1 = _createState("S1", r);
		State s2 = _createState("S2", r);
		Transition t = _createTransition(s1, s2);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createRegularEventSpec(e1, tr1);

		ExecutionFlow flow = sequencer.transform(sc);

		EventDefinition _e1 = (EventDefinition) flow.getScopes().get(0).getDeclarations().get(0); 
		assertNotSame(e1, _e1);
		assertEquals(e1.getName(), _e1.getName());
		
		assertEquals(2, flow.getStates().size());
		assertEquals(s1.getName(), flow.getStates().get(0).getSimpleName());
		If _if = (If) flow.getStates().get(0).getCycle().getSteps().get(0);

		ElementReferenceExpression _ere = (ElementReferenceExpression) _if.getCondition();
		assertSame(_e1, _ere.getValue());
	}


	/**
	 * Single trigger events of a Reaction Trigger will be converted into a single condition 
	 * that consists of a ElementReferenceExpression to the corresponding event definition.
	 */
	@Test public void testSingleRegularEventTriggerCondition() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);

		Statement s = sequencer.buildCondition(tr1);

		assertTrue(s instanceof ElementReferenceExpression);
	}


	/**
	 * Multiple trigger events of a ReactionTrigger will be converted to a condition 
	 * that consists of a ElementReferenceExpressions connected by LogicalOrExpressions.
	 * 
	 * e1, e1 -> e1 || e2
	 * 
	 */
	@Test public void testMultipleRegularEventTriggerCondition() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		Statement s = sequencer.buildCondition(tr1);

		assertTrue(s instanceof LogicalOrExpression);
		assertTrue(((LogicalOrExpression) s).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(((LogicalOrExpression) s).getRightOperand() instanceof ElementReferenceExpression);
	}

	
	@Test
	public void testTransitionSequence() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		If s = sequencer.buildTransitionSequence(t);

		assertTrue(s.getCondition() instanceof LogicalOrExpression);
		assertTrue(((LogicalOrExpression) s.getCondition()).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(((LogicalOrExpression) s.getCondition()).getRightOperand() instanceof ElementReferenceExpression);

		assertEquals(e1.getName(),
				((ElementReferenceExpression)((LogicalOrExpression) s.getCondition()).getLeftOperand()).getValue().getName());
		assertEquals(e2.getName(),
				((ElementReferenceExpression)((LogicalOrExpression) s.getCondition()).getRightOperand()).getValue().getName());
	}

	
	/** 
	 * the scope name must be mapped.
	 */
	@Test public void testScopeName() {
		InterfaceScope scope = _createInterfaceScope("abc", null);
		assertEquals(scope.getName(), ((InterfaceScope) sequencer.map(scope)).getName());
	}
	
	/** 
	 * An InternalScope must be mapped to an InternalScope.
	 */
	@Test public void testMapEmptyInternalScope() {
		InternalScope scope = _createInternalScope(null);
		Scope _scope = sequencer.map(scope);
		
		assertTrue(_scope instanceof InternalScope);
	}
	
	
	@Test
	public void testMapScope() {

		InterfaceScope scope = _createInterfaceScope(null, null);
		EventDefinition e1 = _createEventDefinition("e1", scope);
		EventDefinition e2 = _createEventDefinition("e2", scope);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		
		Scope _scope = sequencer.map(scope);

		assertTrue(_scope instanceof InterfaceScope);
		assertEquals(3, _scope.getDeclarations().size());
		
		
		for ( int i =0; i<_scope.getDeclarations().size(); i++) {			
			Declaration s_decl = scope.getDeclarations().get(i);
			Declaration r_decl = _scope.getDeclarations().get(i);
			
			assertNotSame(s_decl, r_decl);	
			assertEquals(s_decl.getName(), r_decl.getName());	
			assertEquals(s_decl.getClass(), r_decl.getClass());	
		}
	}
	
	
}
