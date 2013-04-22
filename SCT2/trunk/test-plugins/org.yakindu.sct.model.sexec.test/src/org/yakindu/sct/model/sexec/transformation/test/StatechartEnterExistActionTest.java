package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.flattenSequenceStepsAsList;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory.*;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.*;

import java.util.List;

import org.junit.Test;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.transformation.test.Assert.StepLeaf;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.collect.Lists;

public class StatechartEnterExistActionTest extends ModelSequencerTest {

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition.
	 */
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
