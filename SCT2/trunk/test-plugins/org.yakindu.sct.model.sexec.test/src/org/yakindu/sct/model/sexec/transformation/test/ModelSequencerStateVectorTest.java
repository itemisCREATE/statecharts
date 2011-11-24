package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEntry;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createRegion;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createStatechart;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createTransition;

import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

public class ModelSequencerStateVectorTest extends ModelSequencerTest {

	

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorFlatNonOrthopgonal() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(1, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorFlatOrthopgonal() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(2, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	
	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorDeepNonOrthopgonal() {
		Statechart sc = _createStatechart("test");
		Region r = _createRegion("sc_r", sc);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		Region s2_r = _createRegion("s2_r", s2);
		State s2_1 = _createState("s2_1", s2_r);
		State s2_2 = _createState("s2_2", s2_r);
		Region s2_1_r = _createRegion("s2_1_r", s2_1);
		State s2_1_1 = _createState("s2_1_1", s2_1_r);
		State s2_1_2 = _createState("s2_1_2", s2_1_r);

		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(1, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	
	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorDeepOrthopgonal() {
		Statechart sc = _createStatechart("test");
		
		{  // first top region 
			Region r = _createRegion("sc_r1", sc);
			State s1 = _createState("s1", r);
			State s2 = _createState("s2", r);
			{ // first sub region 
				Region s2_r = _createRegion("s2_r", s2);
				State s2_1 = _createState("s2_1", s2_r);
				State s2_2 = _createState("s2_2", s2_r);
				{ // first sub sub region
					Region s2_1_r = _createRegion("s2_1_r", s2_1);
					State s2_1_1 = _createState("s2_1_1", s2_1_r);
					State s2_1_2 = _createState("s2_1_2", s2_1_r);
				}
				{ // second sub sub region
					Region s2_2_r = _createRegion("s2_1_r2", s2_1);
					State s2_1_3 = _createState("s2_1_3", s2_2_r);
					State s2_1_4 = _createState("s2_2_4", s2_2_r);
				}
			}
		}
		{  // second top region 
			Region r = _createRegion("sc_r2", sc);
			State s1 = _createState("r2_s1", r);
			State s2 = _createState("r2_s2", r);
		}


		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(3, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	
	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorEmptyRegion() {
		Statechart sc = _createStatechart("test");
		
		{  // first top region 
			Region r = _createRegion("sc_r1", sc);
		}
	
		ExecutionFlow flow = sequencer.transform(sc);
		
		assertNotNull(flow.getStateVector());
		assertEquals(0, flow.getStateVector().getSize());
		assertEquals(0, flow.getStateVector().getOffset());
	}

	/**
	 * The state vector descriptor of the ExecutionFlow must have an offset of 0 and a size that is 
	 * the maximum orthogonality of the statechart.
	 */
	@Test public void testSCStateVectorPseudoStates() {
		Statechart sc = _createStatechart("test");
		
		{  // first top region 
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
