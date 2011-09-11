package org.yakindu.sct.model.sexec.transformation.test;

import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class SCTTestUtil {

	public static EventDefinition _createEventDefinition(String name, Scope scope) {
		EventDefinition e = StextFactory.eINSTANCE.createEventDefinition();
		e.setName(name);
		if (scope!=null) scope.getDeclarations().add(e);
		return e;
	}

	public static VariableDefinition _createVariableDefinition(String name, Type type, Scope scope) {
		VariableDefinition v = StextFactory.eINSTANCE.createVariableDefinition();
		v.setName(name);
		v.setType(type);
		if (scope!=null) scope.getDeclarations().add(v);
		return v;
	}

	public static RegularEventSpec _createRegularEventSpec(EventDefinition e1, ReactionTrigger rt) {
		RegularEventSpec e1Spec = StextFactory.eINSTANCE.createRegularEventSpec();
		e1Spec.setEvent(e1);
		if (rt!=null) rt.getTriggers().add(e1Spec);
		return e1Spec;
	}

	public static ReactionTrigger _createReactionTrigger(Reaction reaction) {
		ReactionTrigger rt = StextFactory.eINSTANCE.createReactionTrigger();
		if (reaction != null) reaction.setTrigger(rt);
		return rt;
	}


	public static Statechart _createStatechart(String name) {
		Statechart sc = SGraphFactory.eINSTANCE.createStatechart();
		sc.setName(name);
		return sc;
	}
	

	public static InterfaceScope _createInterfaceScope(String name, ScopedElement owner) {
		InterfaceScope scope = StextFactory.eINSTANCE.createInterfaceScope();
		scope.setName(name);
		if (owner != null) owner.getScopes().add(scope);
		return scope;
	}
	

	public static InternalScope _createInternalScope(ScopedElement owner) {
		InternalScope scope = StextFactory.eINSTANCE.createInternalScope();
		if (owner != null) owner.getScopes().add(scope);
		return scope;
	}
	

	public static Region _createRegion(String name, Statechart sc) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName(name);
		if (sc != null ) sc.getRegions().add(region);
		return region;
	}
	
	public static State _createState(String name, Region r) {
		State state = SGraphFactory.eINSTANCE.createState();
		state.setName(name);
		if (r!=null) r.getVertices().add(state);
		return state;
	}
	
	public static Transition _createTransition(Vertex source, Vertex target) {
		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setSource(source);
		t.setTarget(target);
		return t;
	}
	
	

}
