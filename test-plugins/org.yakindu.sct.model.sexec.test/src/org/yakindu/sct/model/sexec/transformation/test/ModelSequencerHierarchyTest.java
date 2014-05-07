package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createExitAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;

import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class ModelSequencerHierarchyTest extends ModelSequencerTest {

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParentEntryDeep() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createEntryAssignment(v1, s1, 1);

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
		}

		_createTransition(findState(sc, "s6"), findState(sc, "s4"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getEntryAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getEntryAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getEntryAction());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());
		assertNull(_s6.getEntryAction());

		Reaction _t = _s6.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(4, _effect.getSteps().size());

		assertCall(_effect, 3, _s4.getEnterSequences().get(0));
		assertCall(_effect, 2, _s3.getEntryAction());
		assertCall(_effect, 1, _s1.getEntryAction());

	}

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition. A parent state may have no exit
	 * action.
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParentEntryPartial() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createEntryAssignment(v1, s1, 1);

					Region r_s1 = _createRegion("r", s1);
					{
						State s3 = _createState("s3", r_s1);
						{

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
		}

		_createTransition(findState(sc, "s6"), findState(sc, "s4"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getEntryAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNull(_s3.getEntryAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getEntryAction());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());
		assertNull(_s6.getEntryAction());

		Reaction _t = _s6.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(3, _effect.getSteps().size());

		assertCall(_effect, 2, _s4.getEnterSequences().get(0));
		assertCall(_effect, 1, _s1.getEntryAction());
	}

	/**
	 * Transitions to sibling state must nut invoke parent exit actions.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParentEntryExclusionForSiblingTransitions() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createEntryAssignment(v1, s1, 1);

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
		}

		_createTransition(findState(sc, "s5"), findState(sc, "s4"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getEntryAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getEntryAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getEntryAction());

		ExecutionState _s5 = flow.getStates().get(3);
		assertEquals("sc.r.s1.r.s3.r.s5", _s5.getName());
		assertNull(_s5.getEntryAction());

		Reaction _t = _s5.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertCall(_effect, 1, _s4.getEnterSequences().get(0));
	}

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParentExitDeep() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

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
		}

		_createTransition(findState(sc, "s4"), findState(sc, "s6"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getExitAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getExitAction());

		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());

		Reaction _t = _s4.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertCall(_effect, 0, _s1.getExitSequence());
		assertCall(_effect, 1, _s6.getEnterSequences().get(0));

		assertCall(_s1.getExitSequence(), 0, _s1.getSubScopes().get(0)
				.getExitSequence());
		StateSwitch _switch = (StateSwitch) _s1.getSubScopes().get(0)
				.getExitSequence().getSteps().get(0);

		StateCase _s4_case = assertedStateCase(_switch, _s4);
		assertCall(assertedSequence(_s4_case.getStep()), 0,
				_s4.getExitSequence());
		assertCall(assertedSequence(_s4_case.getStep()), 1, _s3.getExitAction());

		assertCall(_s1.getExitSequence(), 1, _s1.getExitAction());
	}

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition. A parent state may have no exit
	 * action.
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParentExitPartial() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createExitAssignment(v1, s1, 1);

					Region r_s1 = _createRegion("r", s1);
					{
						State s3 = _createState("s3", r_s1);
						{

							Region r_s3 = _createRegion("r", s3);
							{
								State s4 = _createState("s4", r_s3);
								_createExitAssignment(v1, s4, 3);

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
		}

		_createTransition(findState(sc, "s4"), findState(sc, "s6"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNull(_s3.getExitAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getExitAction());

		Reaction _t = _s4.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertCall(_effect, 0, _s1.getExitSequence());
		// assertCall(_effect, 0, _s4.getExitSequence());
		// assertCall(_effect, 1, _s1.getExitAction());
	}

	/**
	 * Transitions to sibling state must nut invoke parent exit actions.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParentExitExclusionForSiblingTransitions() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

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
		}

		_createTransition(findState(sc, "s4"), findState(sc, "s5"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getExitAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getExitAction());

		Reaction _t = _s4.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertSequenceSize(2, _effect);

		assertCall(_effect, 0, _s4.getExitSequence());

	}

	
	/**
	 * The transition sequence of a self transition must include the exit and entry sequences of the state.
	 * 
	 */
	@Test
	public void testExitEntryOnSelfTransition() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					_createExitAssignment(v1, s1, 1);
				}
			}
		}

		_createTransition(findState(sc, "s1"), findState(sc, "s1"));

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		Reaction _t = _s1.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertCall(_effect, 0, _s1.getExitSequence());
		assertCall(_effect, 1, _s1.getEnterSequences().get(0));
	}

}
