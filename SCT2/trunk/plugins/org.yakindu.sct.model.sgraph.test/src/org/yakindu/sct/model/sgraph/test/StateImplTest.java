package org.yakindu.sct.model.sgraph.test;

import static org.junit.Assert.*;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.SGraphValidator;
import org.yakindu.sct.model.stext.stext.StextFactory;

import junit.framework.TestCase;

public class StateImplTest extends TestCase {
	protected SGraphFactory factory;

	protected Statechart statechart;
	protected Region region;
	private State state;

	@Before
	public void setUp() throws Exception {
		factory = SGraphFactory.eINSTANCE;
		statechart = factory.createStatechart();
		statechart.setName("SC");

		region = factory.createRegion();
		statechart.getRegions().add(region);
		state = factory.createState();
		state.setName(getClass().getSimpleName());
		region.getVertices().add(state);
	}

	@Test
	public void testIsSimple() {
		assertTrue(state.isSimple());

		Region region2 = factory.createRegion();
		state.getRegions().add(region2);
		assertTrue(state.isSimple());

		region2.getVertices().add(factory.createState());
		assertFalse(state.isSimple());

		state.getRegions().add(factory.createRegion());
		assertFalse(state.isSimple());

		region2.getVertices().clear();
		assertTrue(state.isSimple());

		state.setSubstatechart(factory.createStatechart());
		assertFalse(state.isSimple());

		state.getRegions().clear();
		state.setSubstatechart(factory.createStatechart());
		assertFalse(state.isSimple());
	}
}
