package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEntry;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEntryAction;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEventDefinition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createExitAction;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createInterfaceScope;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createInternalScope;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createReactionEffect;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createReactionTrigger;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createRegion;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createRegularEventSpec;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createStatechart;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createTimeEventSpec;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createTimeTriggeredReaction;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createTransition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createValue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createVariableAssignment;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createVariableDefinition;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
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
@SuppressWarnings("unused")
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

		ElementReferenceExpression _ere = (ElementReferenceExpression) _if.getCheck().getCondition();
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
	 * In the simplest case the a state without an actions will be entered.
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
	
	
	/**
	 * if a state defines a entry action then the execution state must have a entryAction.
	 */
	@Test public void testStateEntryAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		Transition e_t = _createTransition(e, s1);
		Transition s1_t = _createTransition(s1, s2);
		LocalReaction entryAction = _createEntryAction(s2);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());
		
		assertNotNull(_s2.getEntryAction());
		assertNull(_s1.getEntryAction());
	}

	
	/**
	 * entry actions of a substate must not be included in a states entry action list
	 */
	@Test public void testSubStateEntryAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
//		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s2 = _createState("s2", r);
		
		Region s2_r = _createRegion("sub", s2);
		State s2_1 = _createState("s2_1", s2_r);
		LocalReaction entryAction = _createEntryAction(s2_1);
		Assignment assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		LocalReaction exitAction = _createExitAction(s2_1);
		Assignment assign2 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("43"), (ReactionEffect) exitAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(0);
		ExecutionState _s2_1 = flow.getStates().get(1);
		assertEquals(s2.getName(), _s2.getSimpleName());
		assertEquals(s2_1.getName(), _s2_1.getSimpleName());
		
		assertNull(_s2.getEntryAction());
		assertNotNull(_s2_1.getEntryAction());

		assertNull(_s2.getExitAction());
		assertNotNull(_s2_1.getExitAction());
}
	
	
	/**
	 * if a state defines a exit action then the execution state must have a exitAction.
	 */
	@Test public void testStateExitAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		Transition e_t = _createTransition(e, s1);
		Transition s1_t = _createTransition(s1, s2);
		LocalReaction exitAction = _createExitAction(s1);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) exitAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());
		
		assertNotNull(_s1.getExitAction());
		assertNull(_s2.getExitAction());
	}
	
	
	@Test public void testStateReaction_SimpleFlatTSC() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());

		assertEquals(1, s1.getReactions().size());
		Reaction reaction = s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();
		assertTrue(seq.getSteps().get(0) instanceof ExitState);
		assertEquals(s1, ((ExitState)seq.getSteps().get(0)).getState());
		assertTrue(seq.getSteps().get(1) instanceof EnterState);
		assertEquals(s2, ((EnterState)seq.getSteps().get(1)).getState());
		
	}
	
	/**
	 * The transition action must be part of the reaction effect sequence
	 */
	@Test public void testStateReaction_WithTransitionAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);
		ReactionEffect effect = _createReactionEffect(tsc.t1);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), effect); 
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());

		assertEquals(1, s1.getReactions().size());
		Reaction reaction = s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();
		
		assertTrue(seq.getSteps().get(0) instanceof ExitState);
		assertEquals(s1, ((ExitState)seq.getSteps().get(0)).getState());
		assertTrue(seq.getSteps().get(1) instanceof Sequence);		
		Execution _exec = (Execution) ((Sequence)seq.getSteps().get(1)).getSteps().get(0);
		Assignment _assign = (Assignment) _exec.getStatement();
		assertNotSame(_assign, assign);
		assertNotSame(_assign.getVarRef(), assign.getVarRef());
		assertNotSame(_assign.getVarRef(), v1);
		
		assertTrue(seq.getSteps().get(2) instanceof EnterState);
		assertEquals(s2, ((EnterState)seq.getSteps().get(2)).getState());
	}

		
	
	/**
	 * The exit action must be part of the reaction effect sequence
	 */
	@Test public void testStateReaction_WithExitAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);
		LocalReaction exitAction = _createExitAction(tsc.s1);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) exitAction.getEffect());

		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		
		// test state with one outgoing transition
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), _s1.getSimpleName());
		assertEquals(tsc.s2.getName(), _s2.getSimpleName());

		assertEquals(1, _s1.getReactions().size());
		Reaction reaction = _s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();

		Call _exitActionCall = (Call) seq.getSteps().get(0);
		assertSame( _s1.getExitAction(), _exitActionCall.getStep());	

		assertTrue(seq.getSteps().get(1) instanceof ExitState);
		assertEquals(_s1, ((ExitState)seq.getSteps().get(1)).getState());
		
	}
	
	/**
	 * The exit action must be part of the reaction effect sequence
	 */
	@Test public void testStateReaction_WithEntryAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);
		LocalReaction entryAction = _createEntryAction(tsc.s2);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) entryAction.getEffect());

		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		
		// test state with one outgoing transition
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), _s1.getSimpleName());
		assertEquals(tsc.s2.getName(), _s2.getSimpleName());

		assertEquals(1, _s1.getReactions().size());
		Reaction reaction = _s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();

		assertTrue(seq.getSteps().get(0) instanceof ExitState);
		assertEquals(_s1, ((ExitState)seq.getSteps().get(0)).getState());

		assertTrue(seq.getSteps().get(1) instanceof EnterState);
		assertEquals(_s2, ((EnterState)seq.getSteps().get(1)).getState());

		Call _entryActionCall = (Call) seq.getSteps().get(2);
		assertSame( _s2.getEntryAction(), _entryActionCall.getStep());	
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
		assertTrue(_if.getThenStep() instanceof Call);
		assertNull(_if.getElseStep());

		Call seq = (Call) _if.getThenStep();
		assertEquals(s1.getReactions().get(0).getEffect(), seq.getStep());
		
//		assertTrue(seq.getSteps().get(0) instanceof ExitState);
//		assertEquals(s1, ((ExitState)seq.getSteps().get(0)).getState());
//		assertTrue(seq.getSteps().get(1) instanceof EnterState);
//		assertEquals(s2, ((EnterState)seq.getSteps().get(1)).getState());
//
		
		// test state with two outgoing transitions
		ExecutionState s3 = flow.getStates().get(2);
		assertEquals(tsc.s3.getName(), s3.getSimpleName());
		assertNotNull(s3.getCycle());
		
		_if = (If) s3.getCycle().getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertTrue(_if.getThenStep() instanceof Call);
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

	
	@Test public void testTransitionCheckSequenceWithoutGuard() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Reaction reaction = sequencer.mapTransition(t);

		assertTrue(reaction.getCheck().getCondition() instanceof LogicalOrExpression);
		assertTrue(((LogicalOrExpression) reaction.getCheck().getCondition()).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(((LogicalOrExpression) reaction.getCheck().getCondition()).getRightOperand() instanceof ElementReferenceExpression);

		assertEquals(e1.getName(),
				((ElementReferenceExpression)((LogicalOrExpression) reaction.getCheck().getCondition()).getLeftOperand()).getValue().getName());
		assertEquals(e2.getName(),
				((ElementReferenceExpression)((LogicalOrExpression) reaction.getCheck().getCondition()).getRightOperand()).getValue().getName());
	}

	
	@Test public void testTransitionCheckSequenceWithGuard() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		PrimitiveValueExpression exp = _createValue("false");
		tr1.setGuardExpression(exp);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Reaction reaction = sequencer.mapTransition(t);

		// now check the expression structure ...
		
		// the root is an and condition with the trigger check as the first (left) part and the guard as the right (second) part.
		LogicalAndExpression and = (LogicalAndExpression) reaction.getCheck().getCondition();
		LogicalOrExpression triggerCheck = (LogicalOrExpression) and.getLeftOperand();
		PrimitiveValueExpression guardCheck = (PrimitiveValueExpression) and.getRightOperand();
		
		assertTrue(triggerCheck.getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(triggerCheck.getRightOperand() instanceof ElementReferenceExpression);
		assertEquals(e1.getName(),
				((ElementReferenceExpression) triggerCheck.getLeftOperand()).getValue().getName());
		assertEquals(e2.getName(),
				((ElementReferenceExpression) triggerCheck.getRightOperand()).getValue().getName());
		
		assertEquals(exp.getValue(), guardCheck.getValue());
	}

	
	@Test public void testTransitionCheckSequenceWithoutTrigger() {

		ReactionTrigger tr1 = _createReactionTrigger(null);
		PrimitiveValueExpression exp = _createValue("false");
		tr1.setGuardExpression(exp);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Reaction reaction = sequencer.mapTransition(t);

		// now check the expression structure ...
		
		// the root is an and condition with the trigger check as the first (left) part and the guard as the right (second) part.
		PrimitiveValueExpression guard = (PrimitiveValueExpression) reaction.getCheck().getCondition();
		assertEquals(exp.getValue(), guard.getValue());
	}

	

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorFlatNonOrthopgonal() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(1, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorFlatOrthopgonal() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(2, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	
	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorDeepNonOrthopgonal() {
		Statechart sc = _createStatechart("test");
		Region r = _createRegion("sc_r", sc);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		Region s2_r = _createRegion("s2_r", s2);
		State s2_1 = _createState("s2_1", s2_r);
		State s2_2 = _createState("s2_2", s2_r);
		Region s2_1_r = _createRegion("s2_1_r", s2_1);
		State s2_1_1 = _createState("s2_1_1", s2_1_r);
		State s2_1_2 = _createState("s2_1_2", s2_1_r);

		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(1, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	
	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorDeepOrthopgonal() {
		Statechart sc = _createStatechart("test");
		
		{  // first top region 
			Region r = _createRegion("sc_r1", sc);
			State s1 = _createState("s1", r);
			State s2 = _createState("s2", r);
			{ // first sub region 
				Region s2_r = _createRegion("s2_r", s2);
				State s2_1 = _createState("s2_1", s2_r);
				State s2_2 = _createState("s2_2", s2_r);
				{ // first sub sub region
					Region s2_1_r = _createRegion("s2_1_r", s2_1);
					State s2_1_1 = _createState("s2_1_1", s2_1_r);
					State s2_1_2 = _createState("s2_1_2", s2_1_r);
				}
				{ // second sub sub region
					Region s2_2_r = _createRegion("s2_1_r2", s2_1);
					State s2_1_3 = _createState("s2_1_3", s2_2_r);
					State s2_1_4 = _createState("s2_2_4", s2_2_r);
				}
			}
		}
		{  // second top region 
			Region r = _createRegion("sc_r2", sc);
			State s1 = _createState("r2_s1", r);
			State s2 = _createState("r2_s2", r);
		}


		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(3, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	
	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorEmptyRegion() {
		Statechart sc = _createStatechart("test");
		
		{  // first top region 
			Region r = _createRegion("sc_r1", sc);
		}
	
		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(0, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorPseudoStates() {
		Statechart sc = _createStatechart("test");
		
		{  // first top region 
			Region r = _createRegion("sc_r1", sc);
			Entry e = _createEntry(EntryKind.INITIAL, null, r);
			Entry s = _createEntry(null, "s", r);
			_createTransition(e, s);
		}
	
		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(0, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}
	
	
	/**
	 * If a time trigger is defined for a transition then an event must be introduced into the execution flow.
	 */
	@Test public void testSingleTransitionTimeTrigger() {
		
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		State s= _createState("s", r);

		Transition t = _createTransition(s, s);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createTimeEventSpec(TimeEventType.AFTER, 1, TimeUnit.SECOND, tr1);

		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) t.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		// assert definition of time event
		Scope timerScope = flow.getScopes().get(1);
		assertTrue(timerScope.getDeclarations().get(0) instanceof TimeEvent);
		
		TimeEvent te = (TimeEvent) timerScope.getDeclarations().get(0);
		
		// assert that the reaction check checks the time event
		assertEquals(1, flow.getStates().size());
		ExecutionState _s = flow.getStates().get(0);
		assertEquals(s.getName(), _s.getSimpleName());
		If _if = (If) flow.getStates().get(0).getCycle().getSteps().get(0);

		ElementReferenceExpression _ere = (ElementReferenceExpression) _if.getCheck().getCondition();
		assertSame(te, _ere.getValue());
		
		// assert the scheduling of the time event during state entry
		assertNotNull(_s.getEntryAction());
		Sequence entryAction = (Sequence) _s.getEntryAction();
		ScheduleTimeEvent ste = (ScheduleTimeEvent) entryAction.getSteps().get(0);
		assertSame(te, ste.getTimeEvent());
		NumericalMultiplyDivideExpression multiply = (NumericalMultiplyDivideExpression) ste.getTimeValue();
		assertEquals("1", ((PrimitiveValueExpression)multiply.getLeftOperand()).getValue());
		assertEquals("1000", ((PrimitiveValueExpression)multiply.getRightOperand()).getValue());
		assertEquals(MultiplicativeOperator.MUL, multiply.getOperator());
						
		// assert the unscheduling of the time events during state exit
		assertNotNull(_s.getExitAction());
		Sequence exitAction = (Sequence) _s.getExitAction();
		UnscheduleTimeEvent ute = (UnscheduleTimeEvent) exitAction.getSteps().get(0);
		assertSame(te, ute.getTimeEvent());
	}

	/**
	 * 
	 */
	@Test public void testSingleLocalTimeTrigger() {
		
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		State s= _createState("s", r);

		LocalReaction timeTriggeredReaction = _createTimeTriggeredReaction(s, TimeEventType.AFTER, 2, TimeUnit.MILLISECOND);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) timeTriggeredReaction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		Scope timerScope = flow.getScopes().get(1);
		assertTrue(timerScope.getDeclarations().get(0) instanceof TimeEvent);
		
		TimeEvent te = (TimeEvent) timerScope.getDeclarations().get(0);
		
		// assert that the reaction check checks the time event
		ExecutionState _s = flow.getStates().get(0);

		// assert the scheduling of the time event during state entry
		assertNotNull(_s.getEntryAction());
		Sequence entryAction = (Sequence) _s.getEntryAction();
		ScheduleTimeEvent ste = (ScheduleTimeEvent) entryAction.getSteps().get(0);
		assertSame(te, ste.getTimeEvent());
		PrimitiveValueExpression value = (PrimitiveValueExpression) ste.getTimeValue();
		assertEquals("2", value.getValue());
		assertNotNull(_s.getExitAction());
		Sequence exitAction = (Sequence) _s.getExitAction();
		UnscheduleTimeEvent ute = (UnscheduleTimeEvent) exitAction.getSteps().get(0);
		assertSame(te, ute.getTimeEvent());

	}

}
