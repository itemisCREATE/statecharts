package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.collect.Lists;

public class ModelSequencerHistoryTest extends ModelSequencerTest {

	@SuppressWarnings("unused")
	@Test
	public void testFlowName() {
		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				State s2 = _createState("s2", r);
				{

					Region r2 = _createRegion("r2", s2);
					{
						Entry r2_entry1 = _createEntry(
								EntryKind.SHALLOW_HISTORY, null, r2);
						Entry r2_entry2 = _createEntry(EntryKind.INITIAL,
								"Unused_Backup", r2);
						State s3 = _createState("s3", r2);
						State s4 = _createState("s4", r2);
						_createTransition(r2_entry1, s3);
						_createTransition(r2_entry2, s4);
						_createTransition(s1, r2_entry1);
					}

				}
				_createTransition(s1, s2);
				Transition _t = _createTransition(s1, s2);
				_createTransition(r_entry, s1);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r2.s4", _s4.getName());
		ExecutionNode r2_history_entry = flow.getNodes().get(1);

		EList<Reaction> _t1 = _s1.getReactions();
		Sequence reactSequence_history = flow.getNodes().get(1)
				.getReactSequence();
		HistoryEntry historyStep = (HistoryEntry) reactSequence_history
				.getSteps().get(0);
		assertFalse(historyStep.isDeep());
		assertCall(((Sequence) historyStep.getInitialStep()).getSteps().get(0),
				_s3.getEnterSequences().get(0));
		Reaction reaction_history = _t1.get(0);
		assertCall(assertedSequence(reaction_history.getEffect()), 1,
				reactSequence_history);

		Sequence reactSequence_initial = flow.getNodes().get(2)
				.getReactSequence();
		assertCall(((Sequence) reactSequence_initial.getSteps().get(0)), 0, _s4
				.getEnterSequences().get(0));
		Reaction reaction = _t1.get(1);
		assertCall(assertedSequence(reaction.getEffect()), 1, _s2
				.getEnterSequences().get(0));

		assertCall(_s3.getSuperScope().getEnterSequences().get(0), 0,
				r2_history_entry.getReactSequence());

		Step saveStep = _s3.getEnterSequences().get(0).getSteps().get(1);
		assertTrue(saveStep.eClass().toString(),
				saveStep instanceof SaveHistory);

		saveStep = _s4.getEnterSequences().get(0).getSteps().get(1);
		assertTrue(saveStep.eClass().toString(),
				saveStep instanceof SaveHistory);
	}

	@Test
	public void testDeepHistorySave() {
		Statechart sc = _createStatechart("sc");
		{
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);
			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.DEEP_HISTORY, null, r);
				State s1 = _createState("s1", r);
				State s2 = _createState("s2", r);
				{
					_createEntryAssignment(v1, s2, 3);
					Region r2 = _createRegion("r2", s2);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r2);
						Entry history = _createEntry(EntryKind.SHALLOW_HISTORY,
								"history", r2);

						State s3 = _createState("s3", r2);
						{
							_createEntryAssignment(v1, s3, 4);
						}
						State s4 = _createState("s4", r2);
						{
							Region r4 = _createRegion("r4", s4);
							{
								Entry e4 = _createEntry(EntryKind.INITIAL,
										null, r2);
								State s5 = _createState("s5", r4);
								_createTransition(e4, s5);
								_createTransition(s5, s1);
							}
						}
						_createTransition(e, s3);
						_createTransition(history, s3);
						_createTransition(s3, s4);
						_createTransition(s1, history);
					}
				}
				_createTransition(r_entry, s1);
				_createTransition(s1, s2);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r2.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("sc.r.s2.r2.s4.r4.s5", _s5.getName());

		// get the transition effect from s5 to s1
		Step effect = _s5.getReactions().get(0).getEffect();

		assertedOrder(effect, Lists.newArrayList(_s5), Lists.newArrayList(
				// new StepSaveHistory((ExecutionRegion) _s5.getSuperScope()),
				new StepLeaf(_s5.getExitSequence().getSteps().get(0)),
				new StepLeaf(_s1.getEnterSequences().get(0).getSteps().get(0)),
				new StepSaveHistory((ExecutionRegion) _s1.getSuperScope())));

		// get the transition effect from s3 to s4(s5)
		effect = _s3.getReactions().get(0).getEffect();

		assertedOrder(effect, Lists.newArrayList(_s5), Lists.newArrayList(
				new StepLeaf(_s3.getExitSequence().getSteps().get(0)),
				new StepSaveHistory((ExecutionRegion) _s4.getSuperScope())
		// , new StepLeaf(_s5.getEnterSequences().get(0).getSteps().get(0))
		// , new StepSaveHistory((ExecutionRegion) _s5.getSuperScope())
				));
	}

}
