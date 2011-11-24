package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createStatechart;

import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Statechart;

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
				.getEnterSequence());
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
				.getEnterSequence());
		assertCall(flow.getEnterSequence(), 1, flow.getStates().get(2)
				.getEnterSequence());

	}

}
