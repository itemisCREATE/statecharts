package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.flattenSequenceStepsAsList;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory.*;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.*;

import java.util.List;

import org.junit.Test;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class LocalReactionTest extends ModelSequencerTest {

	/**
	 * The transition sequence must contain all exit actions for parent states
	 * that will be left by a transition.
	 */
	@Test
	public void testSCLocalReaction() {

		Statechart sc = _createStatechart("sc");
		{
			LocalReaction lr0 = _createLocalReaction(sc,
					_createAlwaysEventSpec(null));
			VariableDefinition v = _createVariableDefinition("v", TYPE_INTEGER,
					getOrCreateInternalScope(sc));
			_createVariableAssignment(v, AssignmentOperator.ADD_ASSIGN,
					_createValue(1), (ReactionEffect) lr0.getEffect());

			Region r = _createRegion("r", sc);
			{
				State s1 = _createState("s1", r);
				{
					LocalReaction lr1 = _createLocalReaction(s1,
							_createAlwaysEventSpec(null));
					_createVariableAssignment(v, AssignmentOperator.ADD_ASSIGN,
							_createValue(2), (ReactionEffect) lr1.getEffect());
					_createEntryAssignment(v, s1, 1);

					Region r_s1 = _createRegion("r", s1);
					{
						_createState("s3", r_s1);
					}
				}
				State s2 = _createState("s2", r);
				{
					_createEntryAssignment(v, s2, 1);
					Region r_s2 = _createRegion("r", s2);
					{
						_createState("s6", r_s2);
					}
				}
			}
		}

		Transition t = _createTransition(findState(sc, "s3"), findState(sc, "s6"));
		ReactionTrigger tr = _createReactionTrigger(t);
		tr.setGuard(createGuardExpression(_createValue(true)));

		ExecutionFlow flow = sequencer.transform(sc);

		assertEquals(1, flow.getReactions().size());

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		// assertEquals(1, _s1.getReactions().size());
		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());

		ExecutionState _s2 = flow.getStates().get(2);
		assertEquals("sc.r.s2", _s2.getName());
		// assertEquals(1, _s2.getReactions().size());
		ExecutionState _s6 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r.s6", _s6.getName());

		Reaction _t = _s3.getReactions().get(0);
		assertTrue(_t.isTransition());

		// Check Stateswitch in flow
		StateSwitch sSwitch = assertedSwitch(flow.getReactSequence().getSteps()
				.get(0));
		assertStateSwitch(sSwitch, _s3, _s6);
		assertCall(assertedStateCase(sSwitch, _s3).getStep(),
				_s3.getReactSequence());

		// Check reactSequence of leaf state
		Sequence _effect = (Sequence) _t.getEffect();

		assertCall(_effect, 0, _s1.getExitSequence());
		assertCall(_effect, 1, _s2.getEntryAction());
		assertCall(_effect, 2, _s6.getEnterSequences().get(0));
		assertEquals(3, _effect.getSteps().size());

		List<Step> steps = flattenSequenceStepsAsList(_s3.getReactSequence());
		If _if = assertClass(If.class, steps.get(0));
		assertEquals(flow.getReactions().get(0).getCheck(),
				assertClass(CheckRef.class, _if.getCheck()).getCheck());

		_if = assertClass(If.class, steps.get(1));
		assertEquals(_s1.getReactions().get(0).getCheck(),
				assertClass(CheckRef.class, _if.getCheck()).getCheck());

		_if = assertClass(If.class, steps.get(2));
		assertNotNull(assertClass(CheckRef.class, _if.getCheck()).getCheck());
		assertCall(_if.getThenStep(), _effect);
	}

}
