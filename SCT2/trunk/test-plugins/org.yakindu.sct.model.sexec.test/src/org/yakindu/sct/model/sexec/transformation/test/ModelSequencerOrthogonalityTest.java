package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findStateFullyQualified;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createExitAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;

import org.junit.Test;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ModelSequencerOrthogonalityTest extends ModelSequencerTest {

	/**
	 * The entry sequence of an and state must perform a entry for all sub
	 * regions.
	 */
	@Test
	public void testAndStateEntry() {

		Statechart sc = _createStatechart("sc");
		{

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						_createTransition(r3_entry, s3);
					}
				}
				_createTransition(r_entry, s1);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());

		Sequence s1EnterSeq = _s1.getEnterSequences().get(0);
		assertNotNull(s1EnterSeq);
		assertEquals(2, s1EnterSeq.getSteps().size());

		assertCall(s1EnterSeq, 0, flow.getStates().get(1).getSuperScope()
				.getEnterSequences().get(0));
		assertCall(s1EnterSeq, 1, flow.getStates().get(2).getSuperScope()
				.getEnterSequences().get(0));

	}

	/**
	 * The transition to a leaf state with orthogonal siblings must invoke the
	 * entry sequence of the orthogonal sibling regions.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSiblingRegionEntryOnTargetState() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				_createTransition(s5, findState(sc, "s3"));
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s5.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong sequence: " + stepListAsString(_effect), 4, _effect
				.getSteps().size());

		assertCall(_effect, 0, _s5.getExitSequence());
		assertCall(_effect, 1, _s2.getSuperScope().getEnterSequences().get(0));
		assertCall(_s2.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes()
				.get(1).getReactSequence());
		assertCall(_effect, 2, _s3.getEnterSequences().get(0));
		assertCall(_effect, 3, _s4.getSuperScope().getEnterSequences().get(0));
		assertCall(_s4.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes()
				.get(3).getReactSequence());
	}

	/**
	 * For all and-states that a on the entry path of a transition the enter
	 * sequences for all orthogonal parts must be called.
	 */
	@Test
	public void testSiblingRegionEntryOnComposite() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						{
							Region r3a = _createRegion("r3a", s3);
							{
								Entry r3a_entry = _createEntry(
										EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3);
							{
								Entry r3b_entry = _createEntry(
										EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3);
							{
								Entry r3c_entry = _createEntry(
										EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);

				_createTransition(s5, findState(sc, "s3b"));
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3c = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s4 = flow.getStates().get(6);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(7);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s5.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong sequence: " + stepListAsString(_effect), 7, _effect
				.getSteps().size());

		assertCall(_effect, 0, _s5.getExitSequence());
		assertCall(_effect, 1, _s2.getSuperScope().getEnterSequences().get(0));
		assertCall(_s2.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes()
				.get(1).getReactSequence());
		assertCall(_effect, 2, _s3.getEntryAction());
		assertCall(_effect, 3, _s3a.getSuperScope().getEnterSequences().get(0));
		assertCall(_s3a.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes()
				.get(3).getReactSequence());
		assertCall(_effect, 4, _s3b.getEnterSequences().get(0));
		assertCall(_effect, 5, _s3c.getSuperScope().getEnterSequences().get(0));
		assertCall(_s3c.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes()
				.get(5).getReactSequence());
		assertCall(_effect, 6, _s4.getSuperScope().getEnterSequences().get(0));
		assertCall(_s4.getSuperScope().getEnterSequences().get(0), 0, flow.getNodes()
				.get(6).getReactSequence());
	}

	/**
	 * Local transition within a region with orthogonal siblings does not have
	 * to invoke sibling region entries or exists.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSiblingStateTransition() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						{
							Region r3a = _createRegion("r3a", s3);
							{
								Entry r3a_entry = _createEntry(
										EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3);
							{
								Entry r3b_entry = _createEntry(
										EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								State s3b2 = _createState("s3b2", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3);
							{
								Entry r3c_entry = _createEntry(
										EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);

				_createTransition(findState(sc, "s3b"), findState(sc, "s3b2"));
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3b2 = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b2", _s3b2.getName());
		ExecutionState _s3c = flow.getStates().get(6);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s4 = flow.getStates().get(7);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(8);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s3b.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertCall(_effect, 0, _s3b.getExitSequence());
		assertCall(_effect, 1, _s3b2.getEnterSequences().get(0));
	}

	/**
	 * A transition from a state with orthogonal siblings that dives into a non
	 * orthogonal sibling state must exclude the source state sibling entry
	 * behavior.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSourceSiblingEnterExclusion() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						{
							Region r3a = _createRegion("r3a", s3);
							{
								Entry r3a_entry = _createEntry(
										EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3);
							{
								Entry r3b_entry = _createEntry(
										EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								State s3b2 = _createState("s3b2", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3);
							{
								Entry r3c_entry = _createEntry(
										EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						State s3z = _createState("s3z", r3);
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);

				_createTransition(findState(sc, "s3z"), findState(sc, "s3b2"));
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3b2 = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b2", _s3b2.getName());
		ExecutionState _s3c = flow.getStates().get(6);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s3z = flow.getStates().get(7);
		assertEquals("sc.r.s1.r3.s3z", _s3z.getName());
		ExecutionState _s4 = flow.getStates().get(8);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(9);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s3z.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong sequence: " + stepListAsString(_effect), 5, _effect
				.getSteps().size());

		assertCall(_effect, 0, _s3z.getExitSequence());
		assertCall(_effect, 1, _s3.getEntryAction());
		assertCall(_effect, 2, _s3a.getSuperScope().getEnterSequences().get(0));
		Sequence r3a_entryReactSequence = flow.getNodes().get(3).getReactSequence();
		assertCall(_s3a.getSuperScope().getEnterSequences().get(0), 0, r3a_entryReactSequence);
		assertCall(((Sequence) r3a_entryReactSequence.getSteps().get(0)), 0,
				_s3a.getEnterSequences().get(0));
		assertCall(_effect, 3, _s3b2.getEnterSequences().get(0));
		assertCall(_effect, 4, _s3c.getSuperScope().getEnterSequences().get(0));
		Sequence r3c_entryReactSequence = flow.getNodes().get(5).getReactSequence();
		assertCall(_s3c.getSuperScope().getEnterSequences().get(0), 0, r3c_entryReactSequence);
		assertCall(((Sequence) r3c_entryReactSequence.getSteps().get(0)), 0,
				_s3c.getEnterSequences().get(0));
		assertTrue(_s3c.getEnterSequences().get(0).getSteps().get(0).getClass()
				.getSimpleName(),
				_s3c.getEnterSequences().get(0).getSteps().get(0) instanceof EnterState);
	}

	/*
	 * --------------------------------------------------------------------------
	 * ----------------- Exit behavior tests
	 * ------------------------------------
	 * -------------------------------------------------------
	 */

	/**
	 * The transition from a leaf state with orthogonal siblings must invoke the
	 * exit sequence of the orthogonal sibling regions.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSiblingRegionExitFromSourceState() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
						State s2b = _createState("s2b", r2);

					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
						State s4b = _createState("s4b", r4);

					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				_createTransition(findState(sc, "s3"), s5);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s2b = flow.getStates().get(2);
		assertEquals("sc.r.s1.r2.s2b", _s2b.getName());
		ExecutionState _s3 = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(4);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s4b = flow.getStates().get(5);
		assertEquals("sc.r.s1.r4.s4b", _s4b.getName());
		ExecutionState _s5 = flow.getStates().get(6);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s3.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertedOrder(_effect, Lists.newArrayList(_s2b, _s3, _s4b),
				Lists.newArrayList(new StepLeaf(_s2b.getExitSequence()),
						new StepLeaf(_s3.getExitSequence()),
						new StepLeaf(_s4b.getExitSequence())));

		assertCall(_effect, 1, _s5.getEnterSequences().get(0));
	}

	/**
	 * For a transition all composite state with orthogonal siblings on the exit
	 * path must invoke the exit sequence of the orthogonal sibling regions.
	 */
	@Test
	public void testSiblingRegionExitOnComposite() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						{
							Region r3a = _createRegion("r3a", s3);
							{
								Entry r3a_entry = _createEntry(
										EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3);
							{
								Entry r3b_entry = _createEntry(
										EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3);
							{
								Entry r3c_entry = _createEntry(
										EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);

				_createTransition(findState(sc, "s3b"), s5);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3c = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s4 = flow.getStates().get(6);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(7);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s3b.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());

		assertedOrder(_effect, Lists.newArrayList(_s2, _s3a, _s3b, _s3c, _s4),
				Lists.newArrayList(new StepLeaf(_s2.getExitSequence()),
						new StepLeaf(_s3a.getExitSequence()),
						new StepLeaf(_s3b.getExitSequence()),
						new StepLeaf(_s3c.getExitSequence()),
						new StepLeaf(_s4.getExitSequence())));
		// Step _switch = _effect.getSteps().get(0);
		// assertStateSwitch(_switch, _s2);
		// assertCall(assertedSequence(assertedStateCase(_switch,
		// _s2).getStep()),
		// 0, _s2.getExitSequence());
		//
		// _switch = _effect.getSteps().get(1);
		// assertStateSwitch(_switch, _s3a);
		// assertCall(
		// assertedSequence(assertedStateCase(_switch, _s3a).getStep()),
		// 0, _s3a.getExitSequence());
		//
		// assertCall(_effect, 2, _s3b.getExitSequence());
		//
		// _switch = _effect.getSteps().get(3);
		// assertStateSwitch(_switch, _s3c);
		// assertCall(
		// assertedSequence(assertedStateCase(_switch, _s3c).getStep()),
		// 0, _s3c.getExitSequence());
		//
		// _switch = _effect.getSteps().get(4);
		// assertStateSwitch(_switch, _s4);
		// assertCall(assertedSequence(assertedStateCase(_switch,
		// _s4).getStep()),
		// 0, _s4.getExitSequence());

		assertCall(_effect, 1, _s5.getEnterSequences().get(0));
	}

	/**
	 * A transition to a state with orthogonal siblings that comes out of a non
	 * orthogonal sibling state must exclude the source state sibling exit or
	 * enter behavior.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSourceSiblingExitExclusion() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				{

					Region r2 = _createRegion("r2", s1);
					{
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null,
								r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}

					Region r3 = _createRegion("r3", s1);
					{
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null,
								r3);
						State s3 = _createState("s3", r3);
						{
							Region r3a = _createRegion("r3a", s3);
							{
								Entry r3a_entry = _createEntry(
										EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3);
							{
								Entry r3b_entry = _createEntry(
										EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								State s3b2 = _createState("s3b2", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3);
							{
								Entry r3c_entry = _createEntry(
										EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						State s3z = _createState("s3z", r3);
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1);
					{
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null,
								r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);

				_createTransition(findState(sc, "s3b2"), findState(sc, "s3z"));
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3b2 = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b2", _s3b2.getName());
		ExecutionState _s3c = flow.getStates().get(6);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s3z = flow.getStates().get(7);
		assertEquals("sc.r.s1.r3.s3z", _s3z.getName());
		ExecutionState _s4 = flow.getStates().get(8);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(9);
		assertEquals("sc.r.s5", _s5.getName());

		Reaction _t = _s3b2.getReactions().get(0);
		assertTrue(_t.isTransition());

		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong steps: " + stepListAsString(_effect), 2, _effect
				.getSteps().size());

		assertedOrder(_effect, Lists.newArrayList(_s3a, _s3b2, _s3c),
				Lists.newArrayList(new StepLeaf(_s3a.getExitSequence()),
						new StepLeaf(_s3b2.getExitSequence()), new StepLeaf(
								_s3c.getExitSequence()),
						new StepLeaf(_s3z.getEnterSequences().get(0))));

		assertCall(_effect, 1, _s3z.getEnterSequences().get(0));

	}

	/**
	 * When exiting an orthogonal state exits must be performed in a well
	 * defined order bottom up with highest priority/order states first.
	 */
	@Test
	public void testBottomUpExitSequence_TwoLevels() {

		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s = _createState("s", r);
				{
					_createExitAssignment(v1, s, 42);

					Region r2 = _createRegion("r2", s);
					{
						State s2 = _createState("s2", r2);
						{
							_createExitAssignment(v1, s2, 42);
							Region r2a = _createRegion("r2a", s2);
							{
								_createState("s2a1", r2a);
								_createState("s2a2", r2a);
							}
							Region r2b = _createRegion("r2b", s2);
							{
								_createState("s2b1", r2b);
								_createState("s2b2", r2b);
							}
							Region r2c = _createRegion("r2c", s2);
							{
								_createState("s2c1", r2c);
								_createState("s2c2", r2c);
							}
						}
					}

					Region r3 = _createRegion("r3", s);
					{
						State s3 = _createState("s3", r3);
						{
							_createExitAssignment(v1, s3, 42);
							Region r3a = _createRegion("r3a", s3);
							{
								_createState("s3a1", r3a);
								_createState("s3a2", r3a);
							}
							Region r3b = _createRegion("r3b", s3);
							{
								_createState("s3b1", r3b);
								_createState("s3b2", r3b);
							}
						}
					}

					Region r4 = _createRegion("r4", s);
					{
						State s4 = _createState("s4", r4);
						{
							_createExitAssignment(v1, s4, 42);

							Region r4a = _createRegion("r4a", s4);
							{
								_createState("s4a1", r4a);
								_createState("s4a2", r4a);
							}
							Region r4b = _createRegion("r4b", s4);
							{
								_createState("s4b1", r4b);
								_createState("s4b2", r4b);
							}
						}
					}
				}
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = assertedState(flow, 0, "sc.r.s");

		ExecutionState _s2 = assertedState(flow, 1, "sc.r.s.r2.s2");
		ExecutionState _s2a1 = assertedState(flow, 2, "sc.r.s.r2.s2.r2a.s2a1");
		ExecutionState _s2a2 = assertedState(flow, 3, "sc.r.s.r2.s2.r2a.s2a2");
		ExecutionState _s2b1 = assertedState(flow, 4, "sc.r.s.r2.s2.r2b.s2b1");
		ExecutionState _s2b2 = assertedState(flow, 5, "sc.r.s.r2.s2.r2b.s2b2");
		ExecutionState _s2c1 = assertedState(flow, 6, "sc.r.s.r2.s2.r2c.s2c1");
		ExecutionState _s2c2 = assertedState(flow, 7, "sc.r.s.r2.s2.r2c.s2c2");

		ExecutionState _s3 = assertedState(flow, 8, "sc.r.s.r3.s3");
		ExecutionState _s3a1 = assertedState(flow, 9, "sc.r.s.r3.s3.r3a.s3a1");
		ExecutionState _s3a2 = assertedState(flow, 10, "sc.r.s.r3.s3.r3a.s3a2");
		ExecutionState _s3b1 = assertedState(flow, 11, "sc.r.s.r3.s3.r3b.s3b1");
		ExecutionState _s3b2 = assertedState(flow, 12, "sc.r.s.r3.s3.r3b.s3b2");

		ExecutionState _s4 = assertedState(flow, 13, "sc.r.s.r4.s4");
		ExecutionState _s4a1 = assertedState(flow, 14, "sc.r.s.r4.s4.r4a.s4a1");
		ExecutionState _s4a2 = assertedState(flow, 15, "sc.r.s.r4.s4.r4a.s4a2");
		ExecutionState _s4b1 = assertedState(flow, 16, "sc.r.s.r4.s4.r4b.s4b1");
		ExecutionState _s4b2 = assertedState(flow, 17, "sc.r.s.r4.s4.r4b.s4b2");

		// check the exit sequence of _s
		Sequence _exit = _s.getExitSequence();
		assertEquals("wrong steps: " + stepListAsString(_exit), 4, _exit
				.getSteps().size());
		assertCall(_exit, 0, _s2.getSuperScope().getExitSequence());
		assertCall(_exit, 1, _s3.getSuperScope().getExitSequence());
		assertCall(_exit, 2, _s4.getSuperScope().getExitSequence());

		StateSwitch _switch0 = assertedSwitch(_s2.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch0, _s2a1, _s2a2);
		assertSequenceSize(1, assertedStateCase(_switch0, _s2a1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch0, _s2a1)
				.getStep()), 0, _s2a1.getExitSequence());
		assertSequenceSize(1, assertedStateCase(_switch0, _s2a2).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch0, _s2a2)
				.getStep()), 0, _s2a2.getExitSequence());

		StateSwitch _switch1 = assertedSwitch(_s2b1.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch1, _s2b1, _s2b2);
		assertSequenceSize(1, assertedStateCase(_switch1, _s2b1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch1, _s2b1)
				.getStep()), 0, _s2b1.getExitSequence());
		assertSequenceSize(1, assertedStateCase(_switch1, _s2b2).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch1, _s2b2)
				.getStep()), 0, _s2b2.getExitSequence());

		StateSwitch _switch2 = assertedSwitch(_s2c1.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch2, _s2c1, _s2c2);
		assertSequenceSize(1, assertedStateCase(_switch2, _s2c1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch2, _s2c1)
				.getStep()), 0, _s2c1.getExitSequence());

		assertSequenceSize(4, _s2.getExitSequence());
		assertCall(_s2.getExitSequence(), 3, _s2.getExitAction());

		assertSequenceSize(1, assertedStateCase(_switch2, _s2c2).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch2, _s2c2)
				.getStep()), 0, _s2c2.getExitSequence());

		StateSwitch _switch3 = assertedSwitch(_s3a1.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch3, _s3a1, _s3a2);
		assertSequenceSize(1, assertedStateCase(_switch3, _s3a1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch3, _s3a1)
				.getStep()), 0, _s3a1.getExitSequence());
		assertSequenceSize(1, assertedStateCase(_switch3, _s3a2).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch3, _s3a2)
				.getStep()), 0, _s3a2.getExitSequence());

		StateSwitch _switch4 = assertedSwitch(_s3b1.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch4, _s3b1, _s3b2);
		assertSequenceSize(1, assertedStateCase(_switch4, _s3b1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch4, _s3b1)
				.getStep()), 0, _s3b1.getExitSequence());

		assertCall(
				assertedSequence(assertedStateCase(
						_s3.getSuperScope().getExitSequence().getSteps().get(1),
						_s3b1).getStep()), 1, _s3.getExitAction());
		assertSequenceSize(1, assertedStateCase(_switch4, _s3b2).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch4, _s3b2)
				.getStep()), 0, _s3b2.getExitSequence());
		assertCall(
				assertedSequence(assertedStateCase(
						_s3.getSuperScope().getExitSequence().getSteps().get(1),
						_s3b2).getStep()), 1, _s3.getExitAction());

		StateSwitch _switch5 = assertedSwitch(_s4a1.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch5, _s4a1, _s4a2);
		assertSequenceSize(1, assertedStateCase(_switch5, _s4a1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch5, _s4a1)
				.getStep()), 0, _s4a1.getExitSequence());
		assertSequenceSize(1, assertedStateCase(_switch5, _s4a2).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch5, _s4a2)
				.getStep()), 0, _s4a2.getExitSequence());

		StateSwitch _switch6 = assertedSwitch(_s4b1.getSuperScope()
				.getExitSequence().getSteps().get(0));
		assertStateSwitch(_switch6, _s4b1, _s4b2);
		assertSequenceSize(1, assertedStateCase(_switch6, _s4b1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch6, _s4b1)
				.getStep()), 0, _s4b1.getExitSequence());
		assertCall(
				assertedSequence(assertedStateCase(
						_s4.getSuperScope().getExitSequence().getSteps().get(1),
						_s4b1).getStep()), 1, _s4.getExitAction());
		assertSequenceSize(1, assertedStateCase(_switch6, _s4b1).getStep());
		assertCall(assertedSequence(assertedStateCase(_switch6, _s4b2)
				.getStep()), 0, _s4b2.getExitSequence());
		assertCall(_s4.getExitSequence(), 2, _s4.getExitAction());

		assertCall(_exit, 3, _s.getExitAction());

	}

	/**
	 * When exiting an orthogonal state exits must be performed in a well
	 * defined order bottom up with highest priority/order states first.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testBottomUpExitSequence_ThreeLevels() {

		Statechart sc = setUpDeepExitSC();

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = assertedState(flow, 0, "sc.r.s");

		ExecutionState _s1a = assertedState(flow, 1, "sc.r.s._1.a");
		ExecutionState _s1a1a = assertedState(flow, 2, "sc.r.s._1.a._1.a");
		ExecutionState _s1a1a1a = assertedState(flow, 3,
				"sc.r.s._1.a._1.a._1.a");
		ExecutionState _s1a1a2a = assertedState(flow, 4,
				"sc.r.s._1.a._1.a._2.a");
		ExecutionState _s1a2a = assertedState(flow, 5, "sc.r.s._1.a._2.a");
		ExecutionState _s1a2a1a = assertedState(flow, 6,
				"sc.r.s._1.a._2.a._1.a");
		ExecutionState _s1a2a2a = assertedState(flow, 7,
				"sc.r.s._1.a._2.a._2.a");

		ExecutionState _s2a = assertedState(flow, 8, "sc.r.s._2.a");
		ExecutionState _s2a1a = assertedState(flow, 9, "sc.r.s._2.a._1.a");
		ExecutionState _s2a1a1a = assertedState(flow, 10,
				"sc.r.s._2.a._1.a._1.a");
		ExecutionState _s2a1a2a = assertedState(flow, 11,
				"sc.r.s._2.a._1.a._2.a");
		ExecutionState _s2a2a = assertedState(flow, 12, "sc.r.s._2.a._2.a");
		ExecutionState _s2a2a1a = assertedState(flow, 13,
				"sc.r.s._2.a._2.a._1.a");
		ExecutionState _s2a2a2a = assertedState(flow, 14,
				"sc.r.s._2.a._2.a._2.a");

		ExecutionState _b = assertedState(flow, 15, "sc.r.b");

		// check the exit sequence of _s
		Sequence _exit = _s.getExitSequence();
		assertEquals("wrong steps: " + stepListAsString(_exit), 3, _exit
				.getSteps().size());

		assertCall(_exit, 0, _s1a.getSuperScope().getExitSequence());
		assertCall(_exit, 1, _s2a.getSuperScope().getExitSequence());
		assertCall(_exit, 2, _s.getExitAction());

		// Recursive Test made at TwoLevels already
		// StateSwitch _switch0 = assertedSwitch(_exit.getSteps().get(0));
		// assertStateSwitch(_switch0, _s1a1a1a);
		// assertSequenceSize(1, assertedStateCase(_switch0,
		// _s1a1a1a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch0, _s1a1a1a)
		// .getStep()), 0, _s1a1a1a.getExitSequence());
		//
		// StateSwitch _switch1 = assertedSwitch(_exit.getSteps().get(1));
		// assertStateSwitch(_switch1, _s1a1a2a);
		// assertSequenceSize(2, assertedStateCase(_switch1,
		// _s1a1a2a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch1, _s1a1a2a)
		// .getStep()), 0, _s1a1a2a.getExitSequence());
		// assertCall(assertedSequence(assertedStateCase(_switch1, _s1a1a2a)
		// .getStep()), 1, _s1a1a.getExitAction());
		//
		// StateSwitch _switch2 = assertedSwitch(_exit.getSteps().get(2));
		// assertStateSwitch(_switch2, _s1a2a1a);
		// assertSequenceSize(1, assertedStateCase(_switch2,
		// _s1a2a1a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch2, _s1a2a1a)
		// .getStep()), 0, _s1a2a1a.getExitSequence());
		//
		// StateSwitch _switch3 = assertedSwitch(_exit.getSteps().get(3));
		// assertStateSwitch(_switch3, _s1a2a2a);
		// assertSequenceSize(3, assertedStateCase(_switch3,
		// _s1a2a2a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch3, _s1a2a2a)
		// .getStep()), 0, _s1a2a2a.getExitSequence());
		// assertCall(assertedSequence(assertedStateCase(_switch3, _s1a2a2a)
		// .getStep()), 1, _s1a2a.getExitAction());
		// assertCall(assertedSequence(assertedStateCase(_switch3, _s1a2a2a)
		// .getStep()), 2, _s1a.getExitAction());
		//
		// StateSwitch _switch4 = assertedSwitch(_exit.getSteps().get(4));
		// assertStateSwitch(_switch4, _s2a1a1a);
		// assertSequenceSize(1, assertedStateCase(_switch4,
		// _s2a1a1a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch4, _s2a1a1a)
		// .getStep()), 0, _s2a1a1a.getExitSequence());
		//
		// StateSwitch _switch5 = assertedSwitch(_exit.getSteps().get(5));
		// assertStateSwitch(_switch5, _s2a1a2a);
		// assertSequenceSize(2, assertedStateCase(_switch5,
		// _s2a1a2a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch5, _s2a1a2a)
		// .getStep()), 0, _s2a1a2a.getExitSequence());
		// assertCall(assertedSequence(assertedStateCase(_switch5, _s2a1a2a)
		// .getStep()), 1, _s2a1a.getExitAction());
		//
		// StateSwitch _switch6 = assertedSwitch(_exit.getSteps().get(6));
		// assertStateSwitch(_switch6, _s2a2a1a);
		// assertSequenceSize(1, assertedStateCase(_switch6,
		// _s2a2a1a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch6, _s2a2a1a)
		// .getStep()), 0, _s2a2a1a.getExitSequence());
		//
		// StateSwitch _switch7 = assertedSwitch(_exit.getSteps().get(7));
		// assertStateSwitch(_switch7, _s2a2a2a);
		// assertSequenceSize(3, assertedStateCase(_switch7,
		// _s2a2a2a).getStep());
		// assertCall(assertedSequence(assertedStateCase(_switch7, _s2a2a2a)
		// .getStep()), 0, _s2a2a2a.getExitSequence());
		// assertCall(assertedSequence(assertedStateCase(_switch7, _s2a2a2a)
		// .getStep()), 1, _s2a2a.getExitAction());
		// assertCall(assertedSequence(assertedStateCase(_switch7, _s2a2a2a)
		// .getStep()), 2, _s2a.getExitAction());
		//
		// assertCall(_exit, 8, _s.getExitAction());

	}

	/**
	 * A transition that exits from a deep orthogonal state structure should not
	 * contain multiple calls to exit actions
	 */
	@Test
	public void testBottomUpTransitionExitSequence_A() {

		Statechart sc = setUpDeepExitSC();

		_createTransition(findStateFullyQualified(sc, "sc.r.s.1.a.1.a.2.a"),
				findStateFullyQualified(sc, "sc.r.b"));
		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = assertedState(flow, 0, "sc.r.s");

		ExecutionState _s1a = assertedState(flow, 1, "sc.r.s._1.a");
		ExecutionState _s1a1a = assertedState(flow, 2, "sc.r.s._1.a._1.a");
		ExecutionState _s1a1a1a = assertedState(flow, 3,
				"sc.r.s._1.a._1.a._1.a");
		ExecutionState _s1a1a2a = assertedState(flow, 4,
				"sc.r.s._1.a._1.a._2.a");
		ExecutionState _s1a2a = assertedState(flow, 5, "sc.r.s._1.a._2.a");
		ExecutionState _s1a2a1a = assertedState(flow, 6,
				"sc.r.s._1.a._2.a._1.a");
		ExecutionState _s1a2a2a = assertedState(flow, 7,
				"sc.r.s._1.a._2.a._2.a");

		ExecutionState _s2a = assertedState(flow, 8, "sc.r.s._2.a");
		ExecutionState _s2a1a = assertedState(flow, 9, "sc.r.s._2.a._1.a");
		ExecutionState _s2a1a1a = assertedState(flow, 10,
				"sc.r.s._2.a._1.a._1.a");
		ExecutionState _s2a1a2a = assertedState(flow, 11,
				"sc.r.s._2.a._1.a._2.a");
		ExecutionState _s2a2a = assertedState(flow, 12, "sc.r.s._2.a._2.a");
		ExecutionState _s2a2a1a = assertedState(flow, 13,
				"sc.r.s._2.a._2.a._1.a");
		ExecutionState _s2a2a2a = assertedState(flow, 14,
				"sc.r.s._2.a._2.a._2.a");

		ExecutionState _b = assertedState(flow, 15, "sc.r.b");

		// check the transition reaction ...
		Reaction _t = _s1a1a2a.getReactions().get(0);
		assertTrue(_t.isTransition());

		// check the exit sequence of _s
		Sequence _exit = assertedSequence(_t.getEffect());
		assertEquals("wrong steps: " + stepListAsString(_exit), 2, _exit
				.getSteps().size());

		assertedOrder(_exit, Sets.newHashSet(_s1a1a1a, _s1a1a2a, _s1a2a1a,
				_s1a2a2a, _s2a1a1a, _s2a1a2a, _s2a2a1a, _s2a2a2a),
				Lists.newArrayList(new StepLeaf(_s1a1a1a.getExitSequence()),
						new StepLeaf(_s1a1a2a.getExitSequence()), //
						new StepLeaf(_s1a1a.getExitAction()), //
						new StepLeaf(_s1a2a1a.getExitSequence()), //
						new StepLeaf(_s1a2a2a.getExitSequence()), //
						new StepLeaf(_s1a2a.getExitAction()), //
						new StepLeaf(_s1a.getExitAction()), //
						new StepLeaf(_s2a1a1a.getExitSequence()), //
						new StepLeaf(_s2a1a2a.getExitSequence()), //
						new StepLeaf(_s2a1a.getExitAction()), //
						new StepLeaf(_s2a2a1a.getExitSequence()), //
						new StepLeaf(_s2a2a2a.getExitSequence()),//
						new StepLeaf(_s2a2a.getExitAction()), //
						new StepLeaf(_s2a.getExitAction()), //
						new StepLeaf(_s.getExitAction()), //
						new StepLeaf(_b.getEnterSequences().get(0))));

		assertCall(_exit, 1, _b.getEnterSequences().get(0));

	}

	/**
	 * A transition that exits from a deep orthogonal state structure should not
	 * contain multiple calls to exit actions
	 */
	@Test
	public void testBottomUpTransitionExitSequence_B() {

		Statechart sc = setUpDeepExitSC();

		_createTransition(findStateFullyQualified(sc, "sc.r.s.2.a.2.a.2.a"),
				findStateFullyQualified(sc, "sc.r.b"));
		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = assertedState(flow, 0, "sc.r.s");

		ExecutionState _s1a = assertedState(flow, 1, "sc.r.s._1.a");
		ExecutionState _s1a1a = assertedState(flow, 2, "sc.r.s._1.a._1.a");
		ExecutionState _s1a1a1a = assertedState(flow, 3,
				"sc.r.s._1.a._1.a._1.a");
		ExecutionState _s1a1a2a = assertedState(flow, 4,
				"sc.r.s._1.a._1.a._2.a");
		ExecutionState _s1a2a = assertedState(flow, 5, "sc.r.s._1.a._2.a");
		ExecutionState _s1a2a1a = assertedState(flow, 6,
				"sc.r.s._1.a._2.a._1.a");
		ExecutionState _s1a2a2a = assertedState(flow, 7,
				"sc.r.s._1.a._2.a._2.a");

		ExecutionState _s2a = assertedState(flow, 8, "sc.r.s._2.a");
		ExecutionState _s2a1a = assertedState(flow, 9, "sc.r.s._2.a._1.a");
		ExecutionState _s2a1a1a = assertedState(flow, 10,
				"sc.r.s._2.a._1.a._1.a");
		ExecutionState _s2a1a2a = assertedState(flow, 11,
				"sc.r.s._2.a._1.a._2.a");
		ExecutionState _s2a2a = assertedState(flow, 12, "sc.r.s._2.a._2.a");
		ExecutionState _s2a2a1a = assertedState(flow, 13,
				"sc.r.s._2.a._2.a._1.a");
		ExecutionState _s2a2a2a = assertedState(flow, 14,
				"sc.r.s._2.a._2.a._2.a");

		ExecutionState _b = assertedState(flow, 15, "sc.r.b");

		// check the transition reaction ...
		Reaction _t = _s2a2a2a.getReactions().get(0);
		assertTrue(_t.isTransition());

		// check the exit sequence of _s
		Sequence _exit = assertedSequence(_t.getEffect());
		assertEquals("wrong steps: " + stepListAsString(_exit), 2, _exit
				.getSteps().size());

		assertedOrder(_exit, Lists.newArrayList(_s1a1a1a, _s1a1a2a, _s1a2a1a,
				_s1a2a2a, _s2a1a1a, _s2a1a2a, _s2a2a1a, _s2a2a2a),
				Lists.newArrayList(new StepLeaf(_s1a1a1a.getExitSequence()),
						new StepLeaf(_s1a1a2a.getExitSequence()), //
						new StepLeaf(_s1a1a.getExitAction()), //
						new StepLeaf(_s1a2a1a.getExitSequence()), //
						new StepLeaf(_s1a2a2a.getExitSequence()), //
						new StepLeaf(_s1a2a.getExitAction()), //
						new StepLeaf(_s1a.getExitAction()), //
						new StepLeaf(_s2a1a1a.getExitSequence()), //
						new StepLeaf(_s2a1a2a.getExitSequence()), //
						new StepLeaf(_s2a1a.getExitAction()), //
						new StepLeaf(_s2a2a1a.getExitSequence()), //
						new StepLeaf(_s2a2a2a.getExitSequence()),//
						new StepLeaf(_s2a2a.getExitAction()), //
						new StepLeaf(_s2a.getExitAction()), //
						new StepLeaf(_s.getExitAction()), //
						new StepLeaf(_b.getEnterSequences().get(0))));

		assertCall(_exit, 1, _b.getEnterSequences().get(0));

	}

	/**
	 * A transition that exits from a deep orthogonal state structure should not
	 * contain multiple calls to exit actions
	 */
	@Test
	public void testBottomUpTransitionExitSequence_C() {

		Statechart sc = setUpDeepExitSC();

		_createTransition(findStateFullyQualified(sc, "sc.r.s.1.a.2.a"),
				findStateFullyQualified(sc, "sc.r.b"));
		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s = assertedState(flow, 0, "sc.r.s");

		ExecutionState _s1a = assertedState(flow, 1, "sc.r.s._1.a");
		ExecutionState _s1a1a = assertedState(flow, 2, "sc.r.s._1.a._1.a");
		ExecutionState _s1a1a1a = assertedState(flow, 3,
				"sc.r.s._1.a._1.a._1.a");
		ExecutionState _s1a1a2a = assertedState(flow, 4,
				"sc.r.s._1.a._1.a._2.a");
		ExecutionState _s1a2a = assertedState(flow, 5, "sc.r.s._1.a._2.a");
		ExecutionState _s1a2a1a = assertedState(flow, 6,
				"sc.r.s._1.a._2.a._1.a");
		ExecutionState _s1a2a2a = assertedState(flow, 7,
				"sc.r.s._1.a._2.a._2.a");

		ExecutionState _s2a = assertedState(flow, 8, "sc.r.s._2.a");
		ExecutionState _s2a1a = assertedState(flow, 9, "sc.r.s._2.a._1.a");
		ExecutionState _s2a1a1a = assertedState(flow, 10,
				"sc.r.s._2.a._1.a._1.a");
		ExecutionState _s2a1a2a = assertedState(flow, 11,
				"sc.r.s._2.a._1.a._2.a");
		ExecutionState _s2a2a = assertedState(flow, 12, "sc.r.s._2.a._2.a");
		ExecutionState _s2a2a1a = assertedState(flow, 13,
				"sc.r.s._2.a._2.a._1.a");
		ExecutionState _s2a2a2a = assertedState(flow, 14,
				"sc.r.s._2.a._2.a._2.a");

		ExecutionState _b = assertedState(flow, 15, "sc.r.b");

		// check the transition reaction ...
		Reaction _t = _s1a2a.getReactions().get(0);
		assertTrue(_t.isTransition());

		// check the exit sequence of _s
		Sequence _exit = assertedSequence(_t.getEffect());
		assertEquals("wrong steps: " + stepListAsString(_exit), 2, _exit
				.getSteps().size());

		assertedOrder(_exit, Lists.newArrayList(_s1a1a1a, _s1a1a2a, _s1a2a1a,
				_s1a2a2a, _s2a1a1a, _s2a1a2a, _s2a2a1a, _s2a2a2a),
				Lists.newArrayList(new StepLeaf(_s1a1a1a.getExitSequence()),
						new StepLeaf(_s1a1a2a.getExitSequence()), //
						new StepLeaf(_s1a1a.getExitAction()), //
						new StepLeaf(_s1a2a1a.getExitSequence()), //
						new StepLeaf(_s1a2a2a.getExitSequence()), //
						new StepLeaf(_s1a2a.getExitAction()), //
						new StepLeaf(_s1a.getExitAction()), //
						new StepLeaf(_s2a1a1a.getExitSequence()), //
						new StepLeaf(_s2a1a2a.getExitSequence()), //
						new StepLeaf(_s2a1a.getExitAction()), //
						new StepLeaf(_s2a2a1a.getExitSequence()), //
						new StepLeaf(_s2a2a2a.getExitSequence()),//
						new StepLeaf(_s2a2a.getExitAction()), //
						new StepLeaf(_s2a.getExitAction()), //
						new StepLeaf(_s.getExitAction()), //
						new StepLeaf(_b.getEnterSequences().get(0))));

		assertCall(_exit, 1, _b.getEnterSequences().get(0));

	}

	@SuppressWarnings("unused")
	private Statechart setUpDeepExitSC() {
		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				State s = _createState("s", r);
				{
					_createExitAssignment(v1, s, 42);

					Region r1 = _createRegion("1", s);
					{
						State a = _createState("a", r1);
						{
							_createExitAssignment(v1, a, 42);
							Region a1 = _createRegion("1", a);
							{
								State a1a = _createState("a", a1);
								{
									_createExitAssignment(v1, a1a, 42);
									Region a11 = _createRegion("1", a1a);
									{
										_createState("a", a11);
									}
									Region a21 = _createRegion("2", a1a);
									{
										_createState("a", a21);
									}
								}
							}
							Region a2 = _createRegion("2", a);
							{
								State a2a = _createState("a", a2);
								{
									_createExitAssignment(v1, a2a, 42);
									Region a11 = _createRegion("1", a2a);
									{
										_createState("a", a11);
									}
									Region a21 = _createRegion("2", a2a);
									{
										_createState("a", a21);
									}
								}
							}
						}
					}

					Region r2 = _createRegion("2", s);
					{
						State a = _createState("a", r2);
						{
							_createExitAssignment(v1, a, 42);
							Region a1 = _createRegion("1", a);
							{
								State a1a = _createState("a", a1);
								{
									_createExitAssignment(v1, a1a, 42);
									Region a11 = _createRegion("1", a1a);
									{
										_createState("a", a11);
									}
									Region a21 = _createRegion("2", a1a);
									{
										_createState("a", a21);
									}
								}
							}
							Region a2 = _createRegion("2", a);
							{
								State a2a = _createState("a", a2);
								{
									_createExitAssignment(v1, a2a, 42);
									Region a11 = _createRegion("1", a2a);
									{
										_createState("a", a11);
									}
									Region a21 = _createRegion("2", a2a);
									{
										_createState("a", a21);
									}
								}
							}
						}
					}
				}

				State b = _createState("b", r);
			}
		}
		return sc;
	}

}
