package org.yakindu.sct.model.sgraph.test.util;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.impl.SGraphFactoryImpl;

public class SgraphTestFactory extends SGraphFactoryImpl {
	public static SgraphTestFactory eInstance = new SgraphTestFactory();

	public static Statechart _createStatechart(String name) {
		Statechart sc = SGraphFactory.eINSTANCE.createStatechart();
		sc.setName(name);
		return sc;
	}

	public static Region _createRegion(String name, Statechart sc) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName(name);
		if (sc != null)
			sc.getRegions().add(region);
		return region;
	}

	public static Region _createRegion(String name, State state) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName(name);
		if (state != null)
			state.getRegions().add(region);
		return region;
	}

	public static State _createState(String name, Region r) {
		State state = SGraphFactory.eINSTANCE.createState();
		state.setName(name);
		if (r != null)
			r.getVertices().add(state);
		return state;
	}

	public static FinalState _createFinalState(Region r) {
		FinalState state = SGraphFactory.eINSTANCE.createFinalState();
		if (r != null)
			r.getVertices().add(state);
		return state;
	}

	public static Entry _createEntry(EntryKind kind, String name, Region r) {
		Entry entry = SGraphFactory.eINSTANCE.createEntry();
		if (kind != null)
			entry.setKind(kind);
		else
			entry.setKind(EntryKind.INITIAL);
		entry.setName(name);
		if (r != null)
			r.getVertices().add(entry);
		return entry;
	}

	public static Transition _createTransition(Vertex source, Vertex target) {
		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setSource(source);
		t.setTarget(target);
		return t;
	}
}
