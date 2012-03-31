package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sgraph.test.util.SgraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SgraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SgraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SgraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SgraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEntryAssignment;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.InitializingTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.MinimalTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class ModelSequencerSCTest extends ModelSequencerTest {

	/**
	 * The name of the execution flow must be equal to the statechart name.
	 */
	@Test
	public void testFlowName() {
		Statechart sc = _createStatechart("Test");
		assertEquals(sc.getName(), sequencer.transform(sc).getName());
	}

	/**
	 * In the simplest case the a state without an actions will be entered.
	 */
	@Test
	public void testSCEnterSequence_SimpleFlatTSC() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		assertNotNull(flow.getEnterSequence());
		assertEquals(1, flow.getEnterSequence().getSteps().size());

		assertCall(flow.getEnterSequence(), 0, flow.getStates().get(0)
				.getSuperScope().getEnterSequence());

		assertCall(flow.getStates().get(0).getSuperScope().getEnterSequence(),
				0, flow.getNodes().get(0).getReactSequence());
		assertCall(flow.getNodes().get(0).getReactSequence(), 0, flow
				.getStates().get(0).getEnterSequence());
	}

	/**
	 * For each top level region a EnterState step must be performed.
	 */
	@Test
	public void testSCEnterSequence_OrthogonalFlatTSC() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		assertNotNull(flow.getEnterSequence());
		assertEquals(2, flow.getEnterSequence().getSteps().size());

		assertCall(flow.getEnterSequence(), 0, flow.getStates().get(0)
				.getSuperScope().getEnterSequence());
		assertCall(flow.getStates().get(0).getSuperScope().getEnterSequence(),
				0, flow.getNodes().get(0).getReactSequence());
		assertCall(flow.getNodes().get(0).getReactSequence(), 0, flow
				.getStates().get(0).getEnterSequence());

		assertCall(flow.getEnterSequence(), 1, flow.getStates().get(2)
				.getSuperScope().getEnterSequence());
		assertCall(flow.getStates().get(2).getSuperScope().getEnterSequence(),
				0, flow.getNodes().get(1).getReactSequence());
		assertCall(flow.getNodes().get(1).getReactSequence(), 0, flow
				.getStates().get(2).getEnterSequence());

	}

	/**
	 * The enter step must contain variable initialization.
	 */
	@Test
	public void testSCEnterSequence_Variables() {
		InitializingTSC tsc = new InitializingTSC();

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		assertNotNull(flow.getEnterSequence());
		assertEquals(1, flow.getEnterSequence().getSteps().size());

		assertAssignment(flow.getEnterSequence(), 0, "e1",
				AssignmentOperator.ASSIGN, "true");
	}

	@Test
	public void testSCExitSequence() {
		MinimalTSC sc = new MinimalTSC();

		ExecutionFlow flow = sequencer.transform(sc.sc);

		assertNotNull(flow.getExitSequence());
		assertCall(flow.getExitSequence(), 0, flow.getSubScopes().get(0)
				.getExitSequence());
	}

	@Test
	public void testNoNullCall() {
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

		TreeIterator<EObject> iter = flow.eAllContents();
		while (iter.hasNext()) {
			EObject child = iter.next();
			if (child instanceof Call) {
				Call childCall = (Call) child;
				if (childCall.getStep() == null) {
					Sequence sequence = assertedSequence((Step) childCall
							.eContainer());
					fail(sequence.getName() + ": " + sequence.getComment());
				}
			}
		}
	}
}
