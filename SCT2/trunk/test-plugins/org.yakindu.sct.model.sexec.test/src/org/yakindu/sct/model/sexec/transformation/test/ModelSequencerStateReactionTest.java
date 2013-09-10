package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createAlwaysEventSpec;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEventDefinition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createExitAction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createLocalReaction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionTrigger;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createRegularEventSpec;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createTimeEventSpec;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createTimeTriggeredReaction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createValue;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.*;

import org.junit.Test;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
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
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
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

		assertClass(ElementReferenceExpression.class, s);
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
		assertClass(ElementReferenceExpression.class, ((LogicalOrExpression) s).getLeftOperand());
		assertClass(ElementReferenceExpression.class, ((LogicalOrExpression) s).getRightOperand());
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
		_createAlwaysEventSpec(tr1);

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

		Statechart sc = _createStatechart("test");
		Region region = _createRegion("r1", sc);
		t.setSource(_createState("A", region));
		t.setTarget(_createState("B", region));

		Reaction reaction = behaviorMapping.mapTransition(t);

		assertTrue(reaction.getCheck().getCondition() instanceof LogicalOrExpression);
		assertClass(ElementReferenceExpression.class,
				((LogicalOrExpression) reaction.getCheck().getCondition()).getLeftOperand());
		assertClass(ElementReferenceExpression.class,
				((LogicalOrExpression) reaction.getCheck().getCondition()).getRightOperand());

		assertEquals(e1.getName(), ((NamedElement) ((ElementReferenceExpression) ((LogicalOrExpression) reaction
				.getCheck().getCondition()).getLeftOperand()).getReference()).getName());
		assertEquals(e2.getName(), ((NamedElement) ((ElementReferenceExpression) ((LogicalOrExpression) reaction
				.getCheck().getCondition()).getRightOperand()).getReference()).getName());
	}

	@Test
	public void testTransitionCheckSequenceWithGuard() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		PrimitiveValueExpression exp = _createValue(false);
		tr1.setGuard(createGuardExpression(exp));

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Statechart sc = _createStatechart("test");
		Region region = _createRegion("r1", sc);
		t.setSource(_createState("A", region));
		t.setTarget(_createState("B", region));

		Reaction reaction = behaviorMapping.mapTransition(t);

		// now check the expression structure ...

		// the root is an and condition with the trigger check as the first
		// (left) part and the guard as the right (second) part.
		LogicalAndExpression and = (LogicalAndExpression) reaction.getCheck().getCondition();
		LogicalOrExpression triggerCheck = (LogicalOrExpression) and.getLeftOperand();
		PrimitiveValueExpression guardCheck = (PrimitiveValueExpression) and.getRightOperand();

		assertClass(ElementReferenceExpression.class, triggerCheck.getLeftOperand());
		assertClass(ElementReferenceExpression.class, triggerCheck.getRightOperand());
		assertEquals(e1.getName(),
				((NamedElement) ((ElementReferenceExpression) triggerCheck.getLeftOperand()).getReference()).getName());
		assertEquals(e2.getName(),
				((NamedElement) ((ElementReferenceExpression) triggerCheck.getRightOperand()).getReference()).getName());

		assertBoolLiteral(false, guardCheck.getValue());
	}

	@Test
	public void testTransitionCheckSequenceWithoutTrigger() {

		ReactionTrigger tr1 = _createReactionTrigger(null);
		PrimitiveValueExpression exp = _createValue(false);
		tr1.setGuard(createGuardExpression(exp));

		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);

		Statechart sc = _createStatechart("test");
		Region region = _createRegion("r1", sc);
		t.setSource(_createState("A", region));
		t.setTarget(_createState("B", region));

		Reaction reaction = behaviorMapping.mapTransition(t);

		// now check the expression structure ...

		// the root is an and condition with the trigger check as the first
		// (left) part and the guard as the right (second) part.
		PrimitiveValueExpression guard = (PrimitiveValueExpression) reaction.getCheck().getCondition();
		assertBoolLiteral(false, guard.getValue());
	}

	/**
	 * If a entry trigger is combined with a guard condition then the entry
	 * action is executed conditionally with this trigger.
	 */
	@Test
	public void testEntryActionWithGuard() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction entryAction = _createEntryAction(s2);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) entryAction.getEffect());
		((ReactionTrigger) entryAction.getTrigger()).setGuard(createGuardExpression(_createValue(true)));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());

		Sequence _entrySeq = (Sequence) _s2.getEntryAction();

		assertClass(If.class, _entrySeq.getSteps().get(0));
		assertClass(PrimitiveValueExpression.class, ((If) _entrySeq.getSteps().get(0)).getCheck().getCondition());
		assertAssignment(((Sequence) ((If) _entrySeq.getSteps().get(0)).getThenStep()).getSteps().get(0), "v1",
				AssignmentOperator.ASSIGN, "42");

	}

	/**
	 * If a entry trigger is combined with a guard condition then the entry
	 * action is executed conditionally with this trigger.
	 */
	@Test
	public void testEntryActionWithoutGuard() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction entryAction = _createEntryAction(s2);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) entryAction.getEffect());
		// ((ReactionTrigger)entryAction.getTrigger()).setGuardExpression(_createValue(true));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());

		Sequence _entrySeq = (Sequence) _s2.getEntryAction();

		assertClass(Sequence.class, _entrySeq.getSteps().get(0));
		assertAssignment(((Sequence) _entrySeq.getSteps().get(0)).getSteps().get(0), "v1", AssignmentOperator.ASSIGN,
				"42");

	}

	/**
	 * If a entry trigger is combined with a guard condition then the entry
	 * action is executed conditionally with this trigger.
	 */
	@Test
	public void testExitActionWithGuard() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction exitAction = _createExitAction(s2);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) exitAction.getEffect());
		((ReactionTrigger) exitAction.getTrigger()).setGuard(createGuardExpression(_createValue(true)));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());

		Sequence _exitSeq = (Sequence) _s2.getExitAction();

		assertClass(If.class, _exitSeq.getSteps().get(0));
		assertClass(PrimitiveValueExpression.class, ((If) _exitSeq.getSteps().get(0)).getCheck().getCondition());
		assertAssignment(((Sequence) ((If) _exitSeq.getSteps().get(0)).getThenStep()).getSteps().get(0), "v1",
				AssignmentOperator.ASSIGN, "42");

	}

	/**
	 * If a entry trigger is combined with a guard condition then the entry
	 * action is executed conditionally with this trigger.
	 */
	@Test
	public void testExitActionWithoutGuard() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction exitAction = _createExitAction(s2);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) exitAction.getEffect());
		// ((ReactionTrigger)entryAction.getTrigger()).setGuardExpression(_createValue(true));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());

		Sequence _exitSeq = (Sequence) _s2.getExitAction();

		assertClass(Sequence.class, _exitSeq.getSteps().get(0));
		assertAssignment(((Sequence) _exitSeq.getSteps().get(0)).getSteps().get(0), "v1", AssignmentOperator.ASSIGN,
				"42");

	}

	/**
	 * If a time trigger is defined for a transition then an event must be
	 * introduced into the execution flow.
	 */
	@Test
	public void testSingleTransitionTimeTrigger() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		Transition t = _createTransition(s, s);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createTimeEventSpec(TimeEventType.AFTER, _createValue(1), TimeUnit.SECOND, tr1);

		AssignmentExpression assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
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
		If _if = (If) SCTTestUtil.flattenSequenceStepsAsList(flow.getStates().get(0).getReactSequence()).get(0);

		ElementReferenceExpression _ere = (ElementReferenceExpression) _if.getCheck().getCondition();
		assertSame(te, _ere.getReference());

		// assert the scheduling of the time event during state entry
		assertNotNull(_s.getEntryAction());
		Sequence entryAction = (Sequence) _s.getEntryAction();
		ScheduleTimeEvent ste = (ScheduleTimeEvent) entryAction.getSteps().get(0);
		assertSame(te, ste.getTimeEvent());
		NumericalMultiplyDivideExpression multiply = (NumericalMultiplyDivideExpression) ste.getTimeValue();
		assertIntLiteral(1, ((PrimitiveValueExpression) multiply.getLeftOperand()).getValue());
		assertIntLiteral(1000, ((PrimitiveValueExpression) multiply.getRightOperand()).getValue());
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
	@Test
	public void testSingleLocalTimeTrigger() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		LocalReaction timeTriggeredReaction = _createTimeTriggeredReaction(s, TimeEventType.AFTER, _createValue(2),
				TimeUnit.MILLISECOND);
		AssignmentExpression assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
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
		ScheduleTimeEvent ste = (ScheduleTimeEvent) entryAction.getSteps().get(0);
		assertSame(te, ste.getTimeEvent());
		PrimitiveValueExpression value = (PrimitiveValueExpression) ste.getTimeValue();
		assertIntLiteral(2, value.getValue());
		assertNotNull(_s.getExitAction());
		Sequence exitAction = (Sequence) _s.getExitAction();
		UnscheduleTimeEvent ute = (UnscheduleTimeEvent) exitAction.getSteps().get(0);
		assertSame(te, ute.getTimeEvent());

	}

	/**
	 * Local reactions must be created for behavior with 'always' trigger
	 */
	@Test
	public void testAlwaysLocalReaction() {

		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		State s = _createState("s", r);

		LocalReaction timeTriggeredReaction = _createLocalReaction(s, StextFactory.eINSTANCE.createAlwaysEvent());
		AssignmentExpression assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) timeTriggeredReaction.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = flow.getStates().get(0);

		// assert that a local reaction is created
		Reaction reaction = _s.getReactions().get(0);
		PrimitiveValueExpression pve = (PrimitiveValueExpression) reaction.getCheck().getCondition();
		assertBoolLiteral(true, pve.getValue());

	}

}
