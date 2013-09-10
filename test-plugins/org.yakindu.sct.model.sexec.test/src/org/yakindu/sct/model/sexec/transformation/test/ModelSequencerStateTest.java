package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createFinalState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEventDefinition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createExitAction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createExitAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createLocalReaction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionEffect;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionTrigger;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createRegularEventSpec;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createValue;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.*;

import java.util.List;

import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.MinimalTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class ModelSequencerStateTest extends ModelSequencerTest {

	/**
	 * if a state defines a entry action then the execution state must have a
	 * entryAction.
	 */
	@Test
	public void testStateEntryAction() {
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

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());

		assertNotNull(_s2.getEntryAction());
		assertNull(_s1.getEntryAction());
	}

	/**
	 * entry actions of a substate must not be included in a states entry action
	 * list
	 */
	@Test
	public void testSubStateEntryActionExclusion() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		// Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s2 = _createState("s2", r);

		Region s2_r = _createRegion("sub", s2);
		State s2_1 = _createState("s2_1", s2_r);
		LocalReaction entryAction = _createEntryAction(s2_1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) entryAction.getEffect());
		LocalReaction exitAction = _createExitAction(s2_1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(43),
				(ReactionEffect) exitAction.getEffect());

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
	 * if a state defines a exit action then the execution state must have a
	 * exitAction.
	 */
	@Test
	public void testStateExitAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction exitAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(21),
				(ReactionEffect) exitAction.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());

		assertNotNull(_s1.getExitAction());
		assertNull(_s2.getExitAction());
	}

	/**
	 * A leaf state must have a enter sequence. This enter sequence consists of
	 * an entry action call and a state enter step.
	 */
	@Test
	public void testFinalStateEnterSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("r", sc);
		FinalState fs = _createFinalState(r);

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _fs = flow.getStates().get(0);
		assertEquals("_final_0", _fs.getSimpleName());
		assertSame(fs, _fs.getSourceElement());

		assertNull(_fs.getEntryAction());
		assertNotNull(_fs.getEnterSequences().get(0));

		assertEquals(1, _fs.getEnterSequences().get(0).getSteps().size());
		assertClass(EnterState.class, _fs.getEnterSequences().get(0).getSteps().get(0));
	}

	/**
	 * A leaf state must have a enter sequence. This enter sequence consists of
	 * an entry action call and a state enter step.
	 */
	@Test
	public void testLeafStateEnterSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("r", sc);
		State s1 = _createState("s1", r);
		LocalReaction entryAction = _createEntryAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) entryAction.getEffect());

		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		Transition t = _createTransition(e, s1);

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals(s1.getName(), _s1.getSimpleName());

		assertNotNull(_s1.getEntryAction());
		assertNotNull(_s1.getEnterSequences().get(0));
		assertEquals(2, _s1.getEnterSequences().get(0).getSteps().size());

		assertCall(_s1.getEnterSequences().get(0), 0, _s1.getEntryAction());

		assertClass(EnterState.class, _s1.getEnterSequences().get(0).getSteps().get(1));
	}

	/**
	 * A composite state must have a enter sequence. This enter sequence
	 * consists of an entry action call and a enter sequence call for each sub
	 * region.
	 */
	@Test
	public void testCompositeStateEnterSequence() {
		Statechart sc = _createStatechart("cs");
		{
			Scope scope = _createInterfaceScope("interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createEntryAssignment(v1, s1, 1);
					Region r1_s1 = _createRegion("r1", s1);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r1_s1);
						State s2 = _createState("s2", r1_s1);
						_createTransition(e, s2);
					}
					Region r2_s1 = _createRegion("r2", s1);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r2_s1);
						State s3 = _createState("s3", r2_s1);
						_createTransition(e, s3);
					}
				}

				Entry e = _createEntry(EntryKind.INITIAL, null, r);
				_createTransition(e, s1);

			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("s1", _s1.getSimpleName());

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("s2", _s2.getSimpleName());

		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("s3", _s3.getSimpleName());

		assertNotNull(_s1.getEntryAction());
		assertNotNull(_s1.getEnterSequences().get(0));
		assertEquals(3, _s1.getEnterSequences().get(0).getSteps().size());

		assertCall(_s1.getEnterSequences().get(0), 0, _s1.getEntryAction());
		assertCall(_s1.getEnterSequences().get(0), 1, _s2.getSuperScope().getEnterSequences().get(0));
		assertCall(_s2.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes().get(0).getReactSequence());
		assertCall(flow.getNodes().get(0).getReactSequence(), 0, _s2.getEnterSequences().get(0));

		assertCall(_s1.getEnterSequences().get(0), 2, _s3.getSuperScope().getEnterSequences().get(0));
		assertCall(_s3.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes().get(1).getReactSequence());
		assertCall(flow.getNodes().get(1).getReactSequence(), 0, _s3.getEnterSequences().get(0));
	}

	/**
	 * A leaf state must have a exit sequence. This exit sequence consists of an
	 * exit action call and a state exit step.
	 */
	@Test
	public void testLeafStateExitSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);
		Region r = _createRegion("r", sc);
		State s1 = _createState("s1", r);
		LocalReaction entryAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				(ReactionEffect) entryAction.getEffect());

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals(s1.getName(), _s1.getSimpleName());

		assertNotNull(_s1.getExitAction());
		assertNotNull(_s1.getExitSequence());
		assertEquals(2, _s1.getExitSequence().getSteps().size());

		assertClass(ExitState.class, _s1.getExitSequence().getSteps().get(0));

		assertCall(_s1.getExitSequence(), 1, _s1.getExitAction());

	}

	/**
	 * A final state must have a exit sequence. This exit sequence consists of a
	 * state exit step.
	 */
	@Test
	public void testFinalStateExitSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		Region r = _createRegion("r", sc);
		FinalState fs = _createFinalState(r);

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _fs = flow.getStates().get(0);
		assertEquals("_final_0", _fs.getSimpleName());

		assertNull(_fs.getExitAction());
		assertNotNull(_fs.getExitSequence());
		assertEquals(1, _fs.getExitSequence().getSteps().size());

		assertClass(ExitState.class, _fs.getExitSequence().getSteps().get(0));

	}

	/**
	 * A composite state must have a exit sequence. This exit sequence consists
	 * of an exit action call and a state switch for all leaf states.
	 */
	@Test
	public void testCompositeStateExitSequence() {
		Statechart sc = _createStatechart("cs");
		{
			Scope scope = _createInterfaceScope("interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createExitAssignment(v1, s1, 1);
					Region r1_s1 = _createRegion("r1", s1);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r1_s1);
						State s2 = _createState("s2", r1_s1);
						State s3 = _createState("s3", r1_s1);
						_createTransition(e, s2);
						_createTransition(s2, s3);
					}
					Region r2_s1 = _createRegion("r2", s1);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r2_s1);
						State s4 = _createState("s4", r2_s1);
						State s5 = _createState("s5", r2_s1);
						State s6 = _createState("s6", r2_s1);
						_createTransition(e, s4);
					}
				}
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("s1", _s1.getSimpleName());

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("s2", _s2.getSimpleName());

		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("s3", _s3.getSimpleName());

		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("s4", _s4.getSimpleName());

		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("s5", _s5.getSimpleName());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("s6", _s6.getSimpleName());

		assertNotNull(_s1.getExitAction());
		assertNotNull(_s1.getExitSequence());
		assertEquals(3, _s1.getExitSequence().getSteps().size());

		Sequence _r1_s1 = _s2.getSuperScope().getExitSequence();
		assertCall(assertedSequence(_s1.getExitSequence()), 0, _r1_s1);
		Sequence _r2_s1 = _s4.getSuperScope().getExitSequence();
		assertCall(assertedSequence(_s1.getExitSequence()), 1, _r2_s1);

		Step _switch = _r1_s1.getSteps().get(0);
		assertStateSwitch(_switch, _s2, _s3);
		assertCall(assertedSequence(assertedStateCase(_switch, _s2).getStep()), 0, _s2.getExitSequence());
		assertCall(assertedSequence(assertedStateCase(_switch, _s3).getStep()), 0, _s3.getExitSequence());

		_switch = _r2_s1.getSteps().get(0);
		assertStateSwitch(_switch, _s4, _s5, _s6);
		assertCall(assertedSequence(assertedStateCase(_switch, _s4).getStep()), 0, _s4.getExitSequence());
		assertCall(assertedSequence(assertedStateCase(_switch, _s5).getStep()), 0, _s5.getExitSequence());
		assertCall(assertedSequence(assertedStateCase(_switch, _s6).getStep()), 0, _s6.getExitSequence());

		assertCall(_s1.getExitSequence(), 2, _s1.getExitAction());
	}

	/**
	 * A composite state must have a exit sequence. This exit sequence consists
	 * of an exit action call and a state switch for all leaf states.
	 */
	@Test
	public void testCompositeStateExitSequence_Deep() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);
			EventDefinition e1 = _createEventDefinition("e1", s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createExitAssignment(v1, s1, 1);

					Region r_s1 = _createRegion("r", s1);
					{
						State s3 = _createState("s3", r_s1);
						{
							_createExitAssignment(v1, s3, 2);

							Region r_s3 = _createRegion("r", s3);
							{
								State s4 = _createState("s4", r_s3);
								_createExitAssignment(v1, s4, 3);

								FinalState fs = _createFinalState(r_s3);

							}
						}
					}
				}
				State s2 = _createState("s2", r);
				{
					Region r_s1 = _createRegion("r", s2);
					{
						_createState("s6", r_s1);
					}
				}
			}

		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());

		ExecutionState _fs = flow.getStates().get(3);
		assertEquals("sc.r.s1.r.s3.r._final_", _fs.getName());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());

		assertNull(_fs.getEntryAction());
		assertNull(_fs.getExitAction());
		assertNotNull(_fs.getExitSequence());
		assertEquals(2, _s1.getExitSequence().getSteps().size());

		ExecutionScope _r_s1 = _s1.getSubScopes().get(0);

		assertCall(_s1.getExitSequence(), 0, _r_s1.getExitSequence());
		Step _switch = _r_s1.getExitSequence().getSteps().get(0);
		assertStateSwitch(_switch, _s4, _fs);
		assertCall(assertedSequence(assertedStateCase(_switch, _s4).getStep()), 0, _s4.getExitSequence());
		assertCall(assertedSequence(assertedStateCase(_switch, _s4).getStep()), 1, _s3.getExitAction());
		assertCall(assertedSequence(assertedStateCase(_switch, _fs).getStep()), 0, _fs.getExitSequence());
		assertCall(assertedSequence(assertedStateCase(_switch, _fs).getStep()), 1, _s3.getExitAction());

		assertCall(_s1.getExitSequence(), 1, _s1.getExitAction());

	}

	@Test
	public void testStateReaction_SimpleFlatTSC() {
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

		assertCall(seq, 0, s1.getExitSequence());
		assertCall(seq, 1, s2.getEnterSequences().get(0));
	}

	/**
	 * The transition action must be part of the reaction effect sequence
	 */
	@Test
	public void testStateReaction_WithTransitionAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);
		ReactionEffect effect = _createReactionEffect(tsc.t1);
		AssignmentExpression assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42), effect);

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

		assertCall(seq, 0, s1.getExitSequence());

		assertClass(Sequence.class, seq.getSteps().get(1));
		Execution _exec = (Execution) ((Sequence) seq.getSteps().get(1)).getSteps().get(0);
		AssignmentExpression _assign = (AssignmentExpression) _exec.getStatement();
		assertNotSame(_assign, assign);
		assertNotSame(_assign.getVarRef(), assign.getVarRef());
		assertNotSame(_assign.getVarRef(), v1);

		assertCall(seq, 2, s2.getEnterSequences().get(0));
	}

	/**
	 * The exit action must be part of the reaction effect sequence
	 */
	@Test
	public void testStateReaction_WithExitAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);
		LocalReaction exitAction = _createExitAction(tsc.s1);
		AssignmentExpression assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(21),
				(ReactionEffect) exitAction.getEffect());

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

		assertCall(seq, 0, _s1.getExitSequence());
		assertCall(_s1.getExitSequence(), 1, _s1.getExitAction());
	}

	/**
	 * The exit action must be part of the reaction effect sequence
	 */
	@Test
	public void testStateReaction_WithEntryAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);
		LocalReaction entryAction = _createEntryAction(tsc.s2);
		AssignmentExpression assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(21),
				(ReactionEffect) entryAction.getEffect());

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
		assertEquals(2, seq.getSteps().size());

		assertCall(seq, 0, _s1.getExitSequence());
		assertCall(seq, 1, _s2.getEnterSequences().get(0));
		assertCall(_s2.getEnterSequences().get(0), 0, _s2.getEntryAction());
	}

	@Test
	public void testStateCycle() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());
		assertNotNull(s1.getReactSequence());

		Step step = s1.getReactSequence().getSteps().get(0);
		If _if = (If) assertedSequence(assertedSequence(step).getSteps().get(0)).getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertClass(Call.class, _if.getThenStep());
		assertNull(_if.getElseStep());

		Call seq = (Call) _if.getThenStep();
		assertEquals(s1.getReactions().get(0).getEffect(), seq.getStep());

		// assertTrue(seq.getSteps().get(0) instanceof ExitState);
		// assertEquals(s1, ((ExitState)seq.getSteps().get(0)).getState());
		// assertTrue(seq.getSteps().get(1) instanceof EnterState);
		// assertEquals(s2, ((EnterState)seq.getSteps().get(1)).getState());
		//

		// test state with two outgoing transitions
		ExecutionState s3 = flow.getStates().get(2);
		assertEquals(tsc.s3.getName(), s3.getSimpleName());
		assertNotNull(s3.getReactSequence());

		step = s3.getReactSequence().getSteps().get(0);
		_if = (If) step;
		assertNotNull(_if.getThenStep());
		assertClass(Call.class, _if.getThenStep());
		assertNotNull(_if.getElseStep());
		assertClass(If.class, _if.getElseStep());

	}

	@Test
	public void testStateCycle_WithLocalReactions() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);

		// the first local reaction conforms to "e1 / x=42;"
		LocalReaction lr1 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr1.getTrigger());
		ReactionEffect lr1_eff = _createReactionEffect(lr1);
		AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				lr1_eff);

		// the secont local reaction conforms to "e1 [x==42] / x=0;"
		LocalReaction lr2 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr2.getTrigger());
		LogicalRelationExpression lr2_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr2_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr2_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr2_varRef.setReference(v1);
		PrimitiveValueExpression lr2_value = _createValue(42);
		lr2_equals.setLeftOperand(lr2_varRef);
		lr2_equals.setRightOperand(lr2_value);
		((ReactionTrigger) lr2.getTrigger()).setGuard(createGuardExpression(lr2_equals));
		ReactionEffect lr2_eff = _createReactionEffect(lr2);
		AssignmentExpression assign2 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(0),
				lr2_eff);

		// the third local reaction conforms to: "[x==0] / x=1;"
		LocalReaction lr3 = _createLocalReaction(tsc.s1, null);
		LogicalRelationExpression lr3_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr3_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr3_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr3_varRef.setReference(v1);
		PrimitiveValueExpression lr3_value = _createValue(0);
		lr3_equals.setLeftOperand(lr3_varRef);
		lr3_equals.setRightOperand(lr3_value);
		((ReactionTrigger) lr3.getTrigger()).setGuard(createGuardExpression(lr3_equals));
		ReactionEffect lr3_eff = _createReactionEffect(lr3);
		AssignmentExpression assign3 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(1),
				lr3_eff);

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());

		assertEquals(4, s1.getReactions().size());

		assertNotNull(s1.getReactSequence());

		Step step = s1.getReactSequence().getSteps().get(0);
		If _if = (If) assertedSequence(assertedSequence(step).getSteps().get(0)).getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertClass(Call.class, _if.getThenStep());
		assertNotNull(_if.getElseStep());

		Sequence _seq = (Sequence) _if.getElseStep();
		assertEquals(3, _seq.getSteps().size());

		// check first local reaction
		If _lr1 = (If) _seq.getSteps().get(0);
		assertClass(ElementReferenceExpression.class, _lr1.getCheck().getCondition());
		assertSame(s1.getReactions().get(1).getCheck().getCondition(), _lr1.getCheck().getCondition());
		Call _lr1_eff_call = (Call) _lr1.getThenStep();
		assertSame(s1.getReactions().get(1).getEffect(), _lr1_eff_call.getStep());

		// check second local reaction
		If _lr2 = (If) _seq.getSteps().get(1);
		assertClass(LogicalAndExpression.class, _lr2.getCheck().getCondition());
		assertSame(s1.getReactions().get(2).getCheck().getCondition(), _lr2.getCheck().getCondition());
		Call _lr2_eff_call = (Call) _lr2.getThenStep();
		assertSame(s1.getReactions().get(2).getEffect(), _lr2_eff_call.getStep());

		// check the third local reaction
		If _lr3 = (If) _seq.getSteps().get(2);
		assertClass(LogicalRelationExpression.class, _lr3.getCheck().getCondition());
		assertSame(s1.getReactions().get(3).getCheck().getCondition(), _lr3.getCheck().getCondition());
		Call _lr3_eff_call = (Call) _lr3.getThenStep();
		assertSame(s1.getReactions().get(3).getEffect(), _lr3_eff_call.getStep());

	}

	/**
	 * The cycle sequence of a state that only consists of local reactions
	 * includes sequential processing of the local reactions.
	 */
	@Test
	public void testStateCycle_WithLocalReactionsOnly() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);

		// the first local reaction conforms to "e1 / x=42;"
		LocalReaction lr1 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr1.getTrigger());
		ReactionEffect lr1_eff = _createReactionEffect(lr1);
		AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				lr1_eff);

		// the secont local reaction conforms to "e1 [x==42] / x=0;"
		LocalReaction lr2 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr2.getTrigger());
		LogicalRelationExpression lr2_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr2_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr2_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr2_varRef.setReference(v1);
		PrimitiveValueExpression lr2_value = _createValue(42);
		lr2_equals.setLeftOperand(lr2_varRef);
		lr2_equals.setRightOperand(lr2_value);
		((ReactionTrigger) lr2.getTrigger()).setGuard(createGuardExpression(lr2_equals));
		ReactionEffect lr2_eff = _createReactionEffect(lr2);
		AssignmentExpression assign2 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(0),
				lr2_eff);

		// the third local reaction conforms to: "[x==0] / x=1;"
		LocalReaction lr3 = _createLocalReaction(tsc.s1, null);
		LogicalRelationExpression lr3_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr3_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr3_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr3_varRef.setReference(v1);
		PrimitiveValueExpression lr3_value = _createValue(0);
		lr3_equals.setLeftOperand(lr3_varRef);
		lr3_equals.setRightOperand(lr3_value);
		((ReactionTrigger) lr3.getTrigger()).setGuard(createGuardExpression(lr3_equals));
		ReactionEffect lr3_eff = _createReactionEffect(lr3);
		AssignmentExpression assign3 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(1),
				lr3_eff);

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());

		assertEquals(3, s1.getReactions().size());

		assertNotNull(s1.getReactSequence());

		Step step = s1.getReactSequence().getSteps().get(0);
		Sequence _seq = (Sequence) assertedSequence(assertedSequence(step).getSteps().get(0)).getSteps().get(0);
		assertEquals(3, _seq.getSteps().size());

		// check first local reaction
		If _lr1 = (If) _seq.getSteps().get(0);
		assertClass(ElementReferenceExpression.class, _lr1.getCheck().getCondition());
		assertSame(s1.getReactions().get(0).getCheck().getCondition(), _lr1.getCheck().getCondition());
		Call _lr1_eff_call = (Call) _lr1.getThenStep();
		assertSame(s1.getReactions().get(0).getEffect(), _lr1_eff_call.getStep());

		// check second local reaction
		If _lr2 = (If) _seq.getSteps().get(1);
		assertClass(LogicalAndExpression.class, _lr2.getCheck().getCondition());
		assertSame(s1.getReactions().get(1).getCheck().getCondition(), _lr2.getCheck().getCondition());
		Call _lr2_eff_call = (Call) _lr2.getThenStep();
		assertSame(s1.getReactions().get(1).getEffect(), _lr2_eff_call.getStep());

		// check the third local reaction
		If _lr3 = (If) _seq.getSteps().get(2);
		assertClass(LogicalRelationExpression.class, _lr3.getCheck().getCondition());
		assertSame(s1.getReactions().get(2).getCheck().getCondition(), _lr3.getCheck().getCondition());
		Call _lr3_eff_call = (Call) _lr3.getThenStep();
		assertSame(s1.getReactions().get(2).getEffect(), _lr3_eff_call.getStep());

	}

	/** Entry action behaviors are not directly part of the states cycle steps */
	@Test
	public void testStateCycle_EntryActionExclusion() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);

		// add a simple entry action: "entry / x=42;"
		LocalReaction lr = _createEntryAction(tsc.s1);
		ReactionEffect lr_eff = _createReactionEffect(lr);
		AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				lr_eff);

		// TRANSFORM
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);

		assertEquals(0, s1.getReactions().size());
		assertNotNull(s1.getReactSequence());
		assertEquals(1, s1.getReactSequence().getSteps().size());
	}

	/** Exit action behaviors are not directly part of the states cycle steps */
	@Test
	public void testStateCycle_ExitActionExclusion() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);

		// add a simple entry action: "entry / x=42;"
		LocalReaction lr = _createExitAction(tsc.s1);
		ReactionEffect lr_eff = _createReactionEffect(lr);
		AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				lr_eff);

		// TRANSFORM
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);

		assertEquals(0, s1.getReactions().size());
		assertNotNull(s1.getReactSequence());
		assertEquals(1, s1.getReactSequence().getSteps().size());
	}

	/**
	 * Local reactions that define regular and entry triggers side by side must
	 * also be part of the cycle steps.
	 */
	@Test
	public void testStateCycle_LocalReactionWithMixedRegularAndEntryTrigger() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, tsc.s_scope);

		// add a simple entry action: "entry / x=42;"
		LocalReaction lr = _createEntryAction(tsc.s1);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr.getTrigger());
		ReactionEffect lr_eff = _createReactionEffect(lr);
		AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(42),
				lr_eff);

		// TRANSFORM
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);

		assertEquals(1, s1.getReactions().size());
		assertNotNull(s1.getReactSequence());
		assertEquals(1, s1.getReactSequence().getSteps().size());

		Sequence _seq = (Sequence) s1.getReactSequence().getSteps().get(0);

		If _lr1 = (If) assertedSequence(assertedSequence(_seq.getSteps().get(0)).getSteps().get(0)).getSteps().get(0);
		assertClass(ElementReferenceExpression.class, _lr1.getCheck().getCondition());
		assertSame(s1.getReactions().get(0).getCheck().getCondition(), _lr1.getCheck().getCondition());
		Call _lr1_eff_call = (Call) _lr1.getThenStep();
		assertSame(s1.getReactions().get(0).getEffect(), _lr1_eff_call.getStep());

	}

	/**
	 * The state cycle must contain all reactions of parent states.
	 */
	@Test
	public void testStateCycle_WithParent() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);
			EventDefinition e1 = _createEventDefinition("e1", s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					// a local reaction: "e1 / x=42;"
					LocalReaction lr1 = _createLocalReaction(s1, null);
					_createRegularEventSpec(e1, (ReactionTrigger) lr1.getTrigger());
					ReactionEffect lr1_eff = _createReactionEffect(lr1);
					AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN,
							_createValue(42), lr1_eff);

					Region r_s1 = _createRegion("r", s1);
					{
						State s3 = _createState("s3", r_s1);
						{
							_createEntryAssignment(v1, s3, 2);

							Region r_s3 = _createRegion("r", s3);
							{
								State s4 = _createState("s4", r_s3);
								_createEntryAssignment(v1, s4, 3);

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}
				State s2 = _createState("s2", r);
				{
					Region r_s1 = _createRegion("r", s2);
					{
						_createState("s6", r_s1);
					}
				}
			}

			Transition t_s4_s5 = _createTransition(findState(sc, "s4"), findState(sc, "s5"));
			_createReactionTrigger(t_s4_s5);
			_createRegularEventSpec(e1, (ReactionTrigger) t_s4_s5.getTrigger());

			Transition t_s3_s6 = _createTransition(findState(sc, "s3"), findState(sc, "s6"));
			_createReactionTrigger(t_s3_s6);
			_createRegularEventSpec(e1, (ReactionTrigger) t_s3_s6.getTrigger());

		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());

		Sequence cycle = _s4.getReactSequence();

		Sequence _seq = (Sequence) cycle.getSteps().get(0);

		// first entry is the s1 local reaction
		List<Step> steps = SCTTestUtil.flattenSequenceStepsAsList(_seq);
		If _if = (If) steps.get(0);
		assertCall(_if.getThenStep(), _s1.getReactions().get(0).getEffect());

		// second entry is the s3 cycle with the transition reaction
		_if = (If) steps.get(1);
		assertCall(_if.getThenStep(), _s3.getReactions().get(0).getEffect());
		assertTrue(_s3.getReactions().get(0).isTransition());

		// third is the s4 cycle with the transition reaction
		_seq = (Sequence) _if.getElseStep();
		cycle = (Sequence) _seq.getSteps().get(0);
		_if = (If) cycle.getSteps().get(0);
		assertCall(_if.getThenStep(), _s4.getReactions().get(0).getEffect());
		assertTrue(_s4.getReactions().get(0).isTransition());
		assertNull(_if.getElseStep());
		assertEquals(1, cycle.getSteps().size());

	}

	/**
	 * A final state must be transformed into a execution state with name
	 * '_final_'. and must include parent reactions.
	 */
	@Test
	public void testFinalState() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);
			EventDefinition e1 = _createEventDefinition("e1", s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					// a local reaction: "e1 / x=42;"
					LocalReaction lr1 = _createLocalReaction(s1, null);
					_createRegularEventSpec(e1, (ReactionTrigger) lr1.getTrigger());
					ReactionEffect lr1_eff = _createReactionEffect(lr1);
					AssignmentExpression assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN,
							_createValue(42), lr1_eff);

					Region r_s1 = _createRegion("r", s1);
					{
						State s3 = _createState("s3", r_s1);
						{
							_createEntryAssignment(v1, s3, 2);

							Region r_s3 = _createRegion("r", s3);
							{
								State s4 = _createState("s4", r_s3);
								// _createEntryAssignment(v1, s4, 3);

								FinalState fs = _createFinalState(r_s3);

								Transition t_s4_fs = _createTransition(findState(sc, "s4"), fs);
								_createReactionTrigger(t_s4_fs);
								_createRegularEventSpec(e1, (ReactionTrigger) t_s4_fs.getTrigger());

							}
						}
					}
				}
				State s2 = _createState("s2", r);
				{
					Region r_s1 = _createRegion("r", s2);
					{
						_createState("s6", r_s1);
					}
				}
			}

			Transition t_s3_s6 = _createTransition(findState(sc, "s3"), findState(sc, "s6"));
			_createReactionTrigger(t_s3_s6);
			_createRegularEventSpec(e1, (ReactionTrigger) t_s3_s6.getTrigger());

		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());

		ExecutionState _fs = flow.getStates().get(3);
		assertEquals("sc.r.s1.r.s3.r._final_", _fs.getName());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());

		assertNull(_fs.getEntryAction());
		assertNull(_fs.getExitAction());

		Sequence cycle = _fs.getReactSequence();

		Sequence _seq = (Sequence) cycle.getSteps().get(0);

		// first entry is the s1 local reaction
		List<Step> steps = SCTTestUtil.flattenSequenceStepsAsList(_seq);
		If _if = (If) steps.get(0);
		assertCall(_if.getThenStep(), _s1.getReactions().get(0).getEffect());

		// second entry is the s3 cycle with the transition reaction
		_if = (If) steps.get(1);
		assertCall(_if.getThenStep(), _s3.getReactions().get(0).getEffect());
		assertTrue(_s3.getReactions().get(0).isTransition());
		assertNotNull(_if.getElseStep());

	}

	/**
	 * The enter sequence must be called withnin incoming transitions.
	 */
	@Test
	public void testFinalStateEnterSequenceCall() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);
			EventDefinition e1 = _createEventDefinition("e1", s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);

				FinalState fs = _createFinalState(r);

				Transition t_s1_fs = _createTransition(s1, fs);
				_createReactionTrigger(t_s1_fs);
				_createRegularEventSpec(e1, (ReactionTrigger) t_s1_fs.getTrigger());

			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());

		ExecutionState _fs = flow.getStates().get(1);
		assertEquals("sc.r._final_", _fs.getName());

		assertNull(_fs.getEntryAction());
		assertNull(_fs.getExitAction());

		// the transition s1 -> fs must includes the fs exit sequence call
		Sequence cycle = _s1.getReactSequence();
		If _if = (If) SCTTestUtil.flattenSequenceStepsAsList(cycle).get(0);
		assertCall(_if.getThenStep(), _s1.getReactions().get(0).getEffect());

		Sequence _seq = (Sequence) _s1.getReactions().get(0).getEffect();
		assertCall(_seq, 1, _fs.getEnterSequences().get(0));

	}

}
