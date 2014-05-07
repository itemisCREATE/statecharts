package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createExitAction;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionEffect;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createValue;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.getOrCreateInternalScope;

import org.junit.Test;
import org.yakindu.base.expressions.expressions.AssignmentOperator;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.collect.Lists;

public class StatechartEnterExistActionTest extends ModelSequencerTest {

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSCLocalReaction() {

		Statechart sc = _createStatechart("sc");
		{
			VariableDefinition v = _createVariableDefinition("v", TYPE_INTEGER,
					getOrCreateInternalScope(sc));
			LocalReaction entryAction = _createEntryAction(sc);
			ReactionEffect effect = _createReactionEffect(entryAction);
			_createVariableAssignment(v, AssignmentOperator.ADD_ASSIGN,
					_createValue(1), effect);
			LocalReaction exitAction = _createExitAction(sc);
			effect = _createReactionEffect(exitAction);
			_createVariableAssignment(v, AssignmentOperator.ADD_ASSIGN,
					_createValue(1), effect);

			Region r = _createRegion("r", sc);
			{
				Entry e = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				
				Transition t = _createTransition(e, s1); 
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionRegion region = flow.getRegions().get(0);

		assertEquals(0, flow.getReactions().size());

		assertedOrder(flow.getEnterSequences().get(0), null, Lists.newArrayList(
				new StepLeaf(flow.getEntryAction()),
				new StepLeaf(region.getEnterSequences().get(0))));

		assertedOrder(flow.getExitSequence(), null, Lists.newArrayList(
				new StepLeaf(region.getExitSequence()),
				new StepLeaf(flow.getExitAction())));

	}

}
