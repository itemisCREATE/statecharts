package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class SelfTransitionTest extends ModelSequencerTest {

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
						Entry e = _createEntry(EntryKind.INITIAL, null, r2);
						State s3 = _createState("s3", r2);
						_createTransition(e, s3);
					}
				}
				_createTransition(s2, s2);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionNode e = flow.getNodes().get(1);

		EList<Reaction> _t = _s2.getReactions();

		Reaction tr0 = _t.get(0);
		assertCall(assertedSequence(tr0.getEffect()), 0, _s2.getExitSequence());
		assertCall(assertedSequence(tr0.getEffect()), 1, _s2.getEnterSequences().get(0));
	}
}
