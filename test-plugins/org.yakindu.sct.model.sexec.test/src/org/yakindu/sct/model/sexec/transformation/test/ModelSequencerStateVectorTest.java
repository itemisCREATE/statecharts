package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;

import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

public class ModelSequencerStateVectorTest extends ModelSequencerTest {

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0
	 * and a size that is the maximum orthogonality of the statechart.
	 */
	@Test
	public void testSCStateVectorFlatNonOrthopgonal() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		assertNotNull(flow.getStateVector());
		assertEquals(1, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0
	 * and a size that is the maximum orthogonality of the statechart.
	 */
	@Test
	public void testSCStateVectorFlatOrthopgonal() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();

		ExecutionFlow flow = sequencer.transform(tsc.sc);

		assertNotNull(flow.getStateVector());
		assertEquals(2, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0
	 * and a size that is the maximum orthogonality of the statechart.
	 */
	@Test
	public void testSCStateVectorDeepNonOrthopgonal() {
		Statechart sc = _createStatechart("test");
		Region r = _createRegion("r", sc);
		_createState("s1", r);
		State s2 = _createState("s2", r);
		Region s2_r = _createRegion("r", s2);
		State s2_1 = _createState("s2_1", s2_r);
		Region s2_1_r = _createRegion("r", s2_1);
		_createState("s2_1_1", s2_1_r);
		_createState("s2_1_2", s2_1_r);
		_createState("s2_2", s2_r);

		ExecutionFlow flow = sequencer.transform(sc);

		assertNotNull(flow.getStateVector());
		assertStateVector(0, 1, flow.getStateVector());

		assertStateVector(0, 1, getAssertedExState(flow, 0, "test.r.s1")
				.getStateVector());
		assertStateVector(0, 1, getAssertedExState(flow, 1, "test.r.s2")
				.getStateVector());
		assertStateVector(0, 1, getAssertedExState(flow, 2, "test.r.s2.r.s2_1")
				.getStateVector());
		assertStateVector(0, 1,
				getAssertedExState(flow, 3, "test.r.s2.r.s2_1.r.s2_1_1")
						.getStateVector());
		assertStateVector(0, 1,
				getAssertedExState(flow, 4, "test.r.s2.r.s2_1.r.s2_1_2")
						.getStateVector());
		assertStateVector(0, 1, getAssertedExState(flow, 5, "test.r.s2.r.s2_2")
				.getStateVector());

	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0
	 * and a size that is the maximum orthogonality of the statechart.
	 */
	@Test
	public void testSCStateVectorDeepOrthopgonal() {
		Statechart sc = _createStatechart("test");

		{ // first top region
			Region r = _createRegion("r1", sc);
			_createState("s1", r);
			State s2 = _createState("s2", r);
			{ // first sub region
				Region s2_r = _createRegion("r", s2);
				State s2_1 = _createState("s2_1", s2_r);
				{ // first sub sub region
					Region s2_1_r = _createRegion("r1", s2_1);
					_createState("s2_1_1", s2_1_r);
					_createState("s2_1_2", s2_1_r);
				}
				{ // second sub sub region
					Region s2_2_r = _createRegion("r2", s2_1);
					_createState("s2_1_3", s2_2_r);
					_createState("s2_1_4", s2_2_r);
				}
				_createState("s2_2", s2_r);
			}
		}
		{ // second top region
			Region r = _createRegion("r2", sc);
			_createState("s3", r);
			_createState("s4", r);
		}

		ExecutionFlow flow = sequencer.transform(sc);

		assertNotNull(flow.getStateVector());
		assertStateVector(0, 3, flow.getStateVector());

		assertStateVector(0, 1, getAssertedExState(flow, 0, "test.r1.s1")
				.getStateVector());
		assertStateVector(0, 2, getAssertedExState(flow, 1, "test.r1.s2")
				.getStateVector());
		assertStateVector(0, 2,
				getAssertedExState(flow, 2, "test.r1.s2.r.s2_1")
						.getStateVector());
		assertStateVector(0, 1,
				getAssertedExState(flow, 3, "test.r1.s2.r.s2_1.r1.s2_1_1")
						.getStateVector());
		assertStateVector(0, 1,
				getAssertedExState(flow, 4, "test.r1.s2.r.s2_1.r1.s2_1_2")
						.getStateVector());
		assertStateVector(1, 1,
				getAssertedExState(flow, 5, "test.r1.s2.r.s2_1.r2.s2_1_3")
						.getStateVector());
		assertStateVector(1, 1,
				getAssertedExState(flow, 6, "test.r1.s2.r.s2_1.r2.s2_1_4")
						.getStateVector());
		assertStateVector(0, 1,
				getAssertedExState(flow, 7, "test.r1.s2.r.s2_2")
						.getStateVector());
		assertStateVector(2, 1, getAssertedExState(flow, 8, "test.r2.s3")
				.getStateVector());
		assertStateVector(2, 1, getAssertedExState(flow, 9, "test.r2.s4")
				.getStateVector());

	}

	public ExecutionState getAssertedExState(ExecutionFlow flow, int offset,
			String name) {
		ExecutionState s = flow.getStates().get(offset);
		assertEquals(name, s.getName());

		return s;
	}

	public void assertStateVector(int offset, int size, StateVector sv) {
		assertNotNull("state vector is null", sv);
		assertEquals("wrong state vector offset -", offset, sv.getOffset());
		assertEquals("wrong state vector size -", size, sv.getSize());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0
	 * and a size that is the maximum orthogonality of the statechart.
	 */
	@Test
	public void testSCStateVectorEmptyRegion() {
		Statechart sc = _createStatechart("test");

		{ // first top region
			_createRegion("sc_r1", sc);
		}

		ExecutionFlow flow = sequencer.transform(sc);

		assertNotNull(flow.getStateVector());
		assertEquals(0, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0
	 * and a size that is the maximum orthogonality of the statechart.
	 */
	@Test
	public void testSCStateVectorPseudoStates() {
		Statechart sc = _createStatechart("test");

		{ // first top region
			Region r = _createRegion("sc_r1", sc);
			Entry e = _createEntry(EntryKind.INITIAL, null, r);
			Entry s = _createEntry(null, "s", r);
			_createTransition(e, s);
		}

		ExecutionFlow flow = sequencer.transform(sc);

		assertNotNull(flow.getStateVector());
		assertEquals(0, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

}
