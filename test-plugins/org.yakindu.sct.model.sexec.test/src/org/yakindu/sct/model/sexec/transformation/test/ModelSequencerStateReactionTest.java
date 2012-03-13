package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEventDefinition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createInterfaceScope;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createLocalReaction;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createOncycleEventSpec;
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

import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class ModelSequencerStateReactionTest extends ModelSequencerTest {

	/**
	 * Single trigger events of a Reaction Trigger will be converted into a
	 * single condition that consists of a ElementReferenceExpression to the
	 * corresponding event definition.
	 */
	@Test
	public void testSingleRegularEventTriggerCondition() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);

		Statement s = behaviorMapping.buildCondition(tr1);

		assertClass(TypedElementReferenceExpression.class, s);
	}

	/**
	 * Multiple trigger events of a ReactionTrigger will be converted to a
	 * condition that consists of a ElementReferenceExpressions connected by
	 * LogicalOrExpressions.
	 * 
	 * e1, e1 -> e1 || e2
	 * 
	 */
	@Test
	public void testMultipleRegularEventTriggerCondition() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		Statement s = behaviorMapping.buildCondition(tr1);

		assertTrue(s instanceof LogicalOrExpression);
		assertClass(TypedElementReferenceExpression.class,
				((LogicalOrExpression) s).getLeftOperand());
		assertClass(TypedElementReferenceExpression.class,
				((LogicalOrExpression) s).getRightOperand());
	}

	/**
	 * The 'onclycle' trigger event will be converted to a simple 'true'
	 * condition.
	 */
	@Test
	public void testOnCycleTriggerCondition() {

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createOncycleEventSpec(tr1);

		Statement s = behaviorMapping.buildCondition(tr1);

		assertNotNull(s);
		assertTrue(s instanceof PrimitiveValueExpression);
		assertBoolLiteral(true, ((PrimitiveValueExpression) s).getValue());
	}

	public static void assertBoolLiteral(boolean value, Literal lit) {
		assertTrue("Literal is no BoolLiteral", lit instanceof BoolLiteral);
		assertEquals(value, ((BoolLiteral) lit).isValue());
	}

	public static void assertIntLiteral(int value, Literal lit) {
		assertTrue("Literal is no IntLiteral", lit instanceof IntLiteral);
		assertEquals(value, ((IntLiteral) lit).getValue());
	}

	/**
	 * The 'always' trigger event will be converted to a simple 'true'
	 * condition.
	 */
	@Test
	public void testAlwaysTriggerCondition() {

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createOncycleEventSpec(tr1);

		Statement s = behaviorMapping.buildCondition(tr1);

		assertNotNull(s);
		assertTrue(s instanceof PrimitiveValueExpression);
		assertBoolLiteral(true, ((PrimitiveValueExpression) s).getValue());
	}

	@Test
	public void testTransitionCheckSequenceWithoutGuard() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Reaction reaction = behaviorMapping.mapTransition(t);

		assertTrue(reaction.getCheck().getCondition() instanceof LogicalOrExpression);
		assertClass(TypedElementReferenceExpression.class,
				((LogicalOrExpression) reaction.getCheck().getCondition())
						.getLeftOperand());
		assertClass(TypedElementReferenceExpression.class,
				((LogicalOrExpression) reaction.getCheck().getCondition())
						.getRightOperand());

		assertEquals(
				e1.getName(),
				((TypedElementReferenceExpression) ((LogicalOrExpression) reaction
						.getCheck().getCondition()).getLeftOperand())
						.getReference().getName());
		assertEquals(
				e2.getName(),
				((TypedElementReferenceExpression) ((LogicalOrExpression) reaction
						.getCheck().getCondition()).getRightOperand())
						.getReference().getName());
	}

	@Test
	public void testTransitionCheckSequenceWithGuard() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		PrimitiveValueExpression exp = _createValue(false);
		tr1.setGuardExpression(exp);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Reaction reaction = behaviorMapping.mapTransition(t);

		// now check the expression structure ...

		// the root is an and condition with the trigger check as the first
		// (left) part and the guard as the right (second) part.
		LogicalAndExpression and = (LogicalAndExpression) reaction.getCheck()
				.getCondition();
		LogicalOrExpression triggerCheck = (LogicalOrExpression) and
				.getLeftOperand();
		PrimitiveValueExpression guardCheck = (PrimitiveValueExpression) and
				.getRightOperand();

		assertClass(TypedElementReferenceExpression.class,
				triggerCheck.getLeftOperand());
		assertClass(TypedElementReferenceExpression.class,
				triggerCheck.getRightOperand());
		assertEquals(e1.getName(),
				((TypedElementReferenceExpression) triggerCheck
						.getLeftOperand()).getReference().getName());
		assertEquals(e2.getName(),
				((TypedElementReferenceExpression) triggerCheck
						.getRightOperand()).getReference().getName());

		assertBoolLiteral(false, guardCheck.getValue());
	}

	@Test
	public void testTransitionCheckSequenceWithoutTrigger() {

		ReactionTrigger tr1 = _createReactionTrigger(null);
		PrimitiveValueExpression exp = _createValue(false);
		tr1.setGuardExpression(exp);

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Reaction reaction = behaviorMapping.mapTransition(t);

		// now check the expression structure ...

		// the root is an and condition with the trigger check as the first
		// (left) part and the guard as the right (second) part.
		PrimitiveValueExpression guard = (PrimitiveValueExpression) reaction
				.getCheck().getCondition();
		assertBoolLiteral(false, guard.getValue());
	}

	/**
	 * If a time trigger is defined for a transition then an event must be
	 * introduced into the execution flow.
	 */
	@Test
	public void testSingleTransitionTimeTrigger() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER,
				scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		Transition t = _createTransition(s, s);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createTimeEventSpec(TimeEventType.AFTER, 1, TimeUnit.SECOND, tr1);

		AssignmentExpression assign = _createVariableAssignment(v1,
				AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) t.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		// assert definition of time event
		Scope timerScope = flow.getScopes().get(1);
		assertTrue(timerScope.getDeclarations().get(0) instanceof TimeEvent);

		TimeEvent te = (TimeEvent) timerScope.getDeclarations().get(0);

		// assert that the reaction check checks the time event
		assertEquals(1, flow.getStates().size());
		ExecutionState _s = flow.getStates().get(0);
		assertEquals(s.getName(), _s.getSimpleName());
		If _if = (If) SCTTestUtil.flattenSequenceStepsAsList(
				flow.getStates().get(0).getReactSequence()).get(0);

		TypedElementReferenceExpression _ere = (TypedElementReferenceExpression) _if
				.getCheck().getCondition();
		assertSame(te, _ere.getReference());

		// assert the scheduling of the time event during state entry
		assertNotNull(_s.getEntryAction());
		Sequence entryAction = (Sequence) _s.getEntryAction();
		ScheduleTimeEvent ste = (ScheduleTimeEvent) entryAction.getSteps().get(
				0);
		assertSame(te, ste.getTimeEvent());
		NumericalMultiplyDivideExpression multiply = (NumericalMultiplyDivideExpression) ste
				.getTimeValue();
		assertIntLiteral(1,
				((PrimitiveValueExpression) multiply.getLeftOperand())
						.getValue());
		assertIntLiteral(1000,
				((PrimitiveValueExpression) multiply.getRightOperand())
						.getValue());
		assertEquals(MultiplicativeOperator.MUL, multiply.getOperator());

		// assert the unscheduling of the time events during state exit
		assertNotNull(_s.getExitAction());
		Sequence exitAction = (Sequence) _s.getExitAction();
		UnscheduleTimeEvent ute = (UnscheduleTimeEvent) exitAction.getSteps()
				.get(0);
		assertSame(te, ute.getTimeEvent());
	}

	/**
	 * 
	 */
	@Test
	public void testSingleLocalTimeTrigger() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER,
				scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		LocalReaction timeTriggeredReaction = _createTimeTriggeredReaction(s,
				TimeEventType.AFTER, 2, TimeUnit.MILLISECOND);
		AssignmentExpression assign = _createVariableAssignment(v1,
				AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) timeTriggeredReaction.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		Scope timerScope = flow.getScopes().get(1);
		assertTrue(timerScope.getDeclarations().get(0) instanceof TimeEvent);

		TimeEvent te = (TimeEvent) timerScope.getDeclarations().get(0);

		// assert that the reaction check checks the time event
		ExecutionState _s = flow.getStates().get(0);

		// assert the scheduling of the time event during state entry
		assertNotNull(_s.getEntryAction());
		Sequence entryAction = (Sequence) _s.getEntryAction();
		ScheduleTimeEvent ste = (ScheduleTimeEvent) entryAction.getSteps().get(
				0);
		assertSame(te, ste.getTimeEvent());
		PrimitiveValueExpression value = (PrimitiveValueExpression) ste
				.getTimeValue();
		assertIntLiteral(2, value.getValue());
		assertNotNull(_s.getExitAction());
		Sequence exitAction = (Sequence) _s.getExitAction();
		UnscheduleTimeEvent ute = (UnscheduleTimeEvent) exitAction.getSteps()
				.get(0);
		assertSame(te, ute.getTimeEvent());

	}

	/**
	 * Local reactions must be created for behavior with 'oncycle' trigger
	 */
	@Test
	public void testOncycleLocalReaction() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER,
				scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		LocalReaction timeTriggeredReaction = _createLocalReaction(s,
				StextFactory.eINSTANCE.createOnCycleEvent());
		AssignmentExpression assign = _createVariableAssignment(v1,
				AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) timeTriggeredReaction.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = flow.getStates().get(0);

		// assert that a local reaction is created
		Reaction reaction = _s.getReactions().get(0);
		PrimitiveValueExpression pve = (PrimitiveValueExpression) reaction
				.getCheck().getCondition();
		assertBoolLiteral(true, pve.getValue());

	}

	/**
	 * Local reactions must be created for behavior with 'always' trigger
	 */
	@Test
	public void testAlwaysLocalReaction() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER,
				scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		LocalReaction timeTriggeredReaction = _createLocalReaction(s,
				StextFactory.eINSTANCE.createAlwaysEvent());
		AssignmentExpression assign = _createVariableAssignment(v1,
				AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) timeTriggeredReaction.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = flow.getStates().get(0);

		// assert that a local reaction is created
		Reaction reaction = _s.getReactions().get(0);
		PrimitiveValueExpression pve = (PrimitiveValueExpression) reaction
				.getCheck().getCondition();
		assertBoolLiteral(true, pve.getValue());

	}

}
