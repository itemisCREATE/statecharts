package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.*;


import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Sequence;
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
	
	
	/**
	 * In the simplest case the a stet without an actions will be entered.
	 */
	@Test public void testSCEnterSequence_SimpleFlatTSC() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		assertNotNull(flow.getEnterSequence());
		assertEquals(1, flow.getEnterSequence().getSteps().size());

		EnterState enterState = (EnterState) flow.getEnterSequence().getSteps().get(0);
		assertEquals(tsc.s1.getName(), enterState.getState().getSimpleName());
	}
	
	
	/**
	 * For each top level region a EnterState step must be performed.
	 */
	@Test public void testSCEnterSequence_OrthogonalFlatTSC() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		assertNotNull(flow.getEnterSequence());
		assertEquals(2, flow.getEnterSequence().getSteps().size());

		EnterState enterState = (EnterState) flow.getEnterSequence().getSteps().get(0);
		assertEquals(tsc.s1.getName(), enterState.getState().getSimpleName());

		enterState = (EnterState) flow.getEnterSequence().getSteps().get(1);
		assertEquals(tsc.s3.getName(), enterState.getState().getSimpleName());
	
	}
	
	
	
	@Test public void testStateCycle_SimpleFlatTSC() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());
		assertNotNull(s1.getCycle());
		
		If _if = (If) s1.getCycle().getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertTrue(_if.getThenStep() instanceof Sequence);
		assertNull(_if.getElseStep());

		Sequence seq = (Sequence) _if.getThenStep();
		assertTrue(seq.getSteps().get(0) instanceof ExitState);
		assertEquals(s1, ((ExitState)seq.getSteps().get(0)).getState());
		assertTrue(seq.getSteps().get(1) instanceof EnterState);
		assertEquals(s2, ((EnterState)seq.getSteps().get(1)).getState());

		
		// test state with two outgoing transitions
		ExecutionState s3 = flow.getStates().get(2);
		assertEquals(tsc.s3.getName(), s3.getSimpleName());
		assertNotNull(s3.getCycle());
		
		_if = (If) s3.getCycle().getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertTrue(_if.getThenStep() instanceof Sequence);
		assertNotNull(_if.getElseStep());
		assertTrue(_if.getElseStep() instanceof If);


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
	public void testTransitionTriggerSequence() {

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

	

	
}
