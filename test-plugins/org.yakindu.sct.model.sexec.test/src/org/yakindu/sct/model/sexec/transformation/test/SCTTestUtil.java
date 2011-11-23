package org.yakindu.sct.model.sexec.transformation.test;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

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
	
	public static Region _createRegion(String name, State state) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName(name);
		if (state != null ) state.getSubRegions().add(region);
		return region;
	}
	
	public static State _createState(String name, Region r) {
		State state = SGraphFactory.eINSTANCE.createState();
		state.setName(name);
		if (r!=null) r.getVertices().add(state);
		return state;
	}
	
	public static Entry _createEntry(EntryKind kind, String name, Region r) {
		Entry entry = SGraphFactory.eINSTANCE.createEntry();
		if (kind != null) entry.setKind(kind);  
			else entry.setKind(EntryKind.INITIAL);
		entry.setName(name);
		if (r!=null) r.getVertices().add(entry);
		return entry;
	}
	
	public static Transition _createTransition(Vertex source, Vertex target) {
		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setSource(source);
		t.setTarget(target);
		return t;
	}
	
	public static ReactionEffect _createReactionEffect(Reaction reaction) {
		ReactionEffect effect = StextFactory.eINSTANCE.createReactionEffect();
		if (reaction != null) reaction.setEffect(effect);
		return effect;
	}
	
		
	
	public static TimeEventSpec _createTimeEventSpec(TimeEventType type, int value, TimeUnit unit, ReactionTrigger rt) {
		TimeEventSpec timeTrigger = StextFactory.eINSTANCE.createTimeEventSpec();
		timeTrigger.setType(type);
		timeTrigger.setValue(value);
		timeTrigger.setUnit(unit);

		if (rt!=null) rt.getTriggers().add(timeTrigger);
		return timeTrigger;
	}

	
	public static LocalReaction _createEntryAction(State parent) {
		return _createLocalReaction(parent, StextFactory.eINSTANCE.createEntryEvent() );
	}
	
	
	public static LocalReaction _createExitAction(State parent) {
		return _createLocalReaction(parent, StextFactory.eINSTANCE.createExitEvent() );
	}
	
	public static LocalReaction _createTimeTriggeredReaction(State parent, TimeEventType type, int value, TimeUnit unit) {
//		TimeEventSpec timeTrigger = StextFactory.eINSTANCE.createTimeEventSpec();
//		timeTrigger.setType(type);
//		timeTrigger.setValue(value);
//		timeTrigger.setUnit(unit);
		return _createLocalReaction(parent, _createTimeEventSpec(type, value, unit, null) );
	}
	

	public static LocalReaction _createLocalReaction(State parent, EventSpec triggerEvent) {
		LocalReaction reaction = StextFactory.eINSTANCE.createLocalReaction();
		ReactionTrigger trigger = StextFactory.eINSTANCE.createReactionTrigger();
		_createReactionEffect(reaction);
		
		if (triggerEvent != null) trigger.getTriggers().add(triggerEvent);
		reaction.setTrigger(trigger);

		Scope scope = null;
		if (parent != null) {
			if (parent.getScopes().size() > 0 ) {
				scope = parent.getScopes().get(0);
			} else {
				scope = StextFactory.eINSTANCE.createSimpleScope();
				parent.getScopes().add(scope);
			}
		}
		
		scope.getDeclarations().add(reaction);
		
		return reaction;
	}
	
	
	public static void _createExitAssignemnt(VariableDefinition v1, State s1, String value) {
		LocalReaction exitAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(value), (ReactionEffect) exitAction.getEffect());
	}


	public static void _createEntryAssignemnt(VariableDefinition v1, State s1, String value) {
		LocalReaction entryAction = _createEntryAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue(value), (ReactionEffect) entryAction.getEffect());
	}



	
	public static Assignment _createVariableAssignment(VariableDefinition v, AssignmentOperator op, Expression expression, ReactionEffect e) {
		Assignment assignment = StextFactory.eINSTANCE.createAssignment();
		assignment.setVarRef(v);
		assignment.setOperator(op);
		assignment.setExpression(expression);
		if(e != null) e.getActions().add(assignment);
		return assignment;
	}
	
	public static PrimitiveValueExpression _createValue(String s) {
		PrimitiveValueExpression assignment = StextFactory.eINSTANCE.createPrimitiveValueExpression();
		assignment.setValue(s);
		return assignment;
	}
	

	
	public static State findState(Statechart sc, final String name) {
		Collection<EObject> states = Collections2.filter(EcoreUtil2.eAllContentsAsList(sc), new Predicate<Object>() {

			public boolean apply(Object obj) {
				// TODO Auto-generated method stub
				return obj != null && obj instanceof State && name.equals(((State)obj).getName());
			}
		});
		
		return (states.size() > 0) ? (State) states.iterator().next() : null;
	}
	
	
	public static class MinimalTSC {
		
		public Statechart sc = _createStatechart("test");
		public InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		public EventDefinition e1 = _createEventDefinition("e1", s_scope);
		public Region r = _createRegion("main", sc);
		public Entry entry = _createEntry(EntryKind.INITIAL, null, r);
		public State s1 = _createState("S1", r);
		public Transition t0 = _createTransition(entry, s1);
		
		public MinimalTSC() {
		}

	}

	
	public static class SimpleFlatTSC {
		
		public Statechart sc = _createStatechart("test");
		public InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		public EventDefinition e1 = _createEventDefinition("e1", s_scope);
		public Region r = _createRegion("main", sc);
		public Entry entry = _createEntry(EntryKind.INITIAL, null, r);
		public State s1 = _createState("S1", r);
		public State s2 = _createState("S2", r);
		public Transition t0 = _createTransition(entry, s1);
		public Transition t1 = _createTransition(s1, s2);
		public ReactionTrigger tr1 = _createReactionTrigger(t1);
		
		public SimpleFlatTSC() {
			_createRegularEventSpec(e1, tr1);
		}

	}
	

	public static class OrthogonalFlatTSC {
		
		public Statechart sc = _createStatechart("test");
		public InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		public EventDefinition e1 = _createEventDefinition("e1", s_scope);
		public EventDefinition e2 = _createEventDefinition("e2", s_scope);
		
		public Region r1 = _createRegion("first", sc);
		public Entry entry_r1 = _createEntry(EntryKind.INITIAL, null, r1);
		public State s1 = _createState("S1", r1);
		public State s2 = _createState("S2", r1);
		public Transition t0 = _createTransition(entry_r1, s1);
		public Transition t1 = _createTransition(s1, s2);
		public ReactionTrigger r1_tr1 = _createReactionTrigger(t1);
		
		public Region r2 = _createRegion("second", sc);
		public Entry entry_r2 = _createEntry(EntryKind.INITIAL, null, r2);
		public State s3 = _createState("S3", r2);
		public State s4 = _createState("S4", r2);
		public Transition t0_r2 = _createTransition(entry_r2, s3);
		public Transition t1_r2 = _createTransition(s3, s4);
		public Transition t2_r2 = _createTransition(s3, s4);
		public ReactionTrigger r2_tr1 = _createReactionTrigger(t1_r2);
		public ReactionTrigger r2_tr2 = _createReactionTrigger(t2_r2);

		public OrthogonalFlatTSC() {
			_createRegularEventSpec(e1, r1_tr1);
			
			_createRegularEventSpec(e1, r2_tr1);
			_createRegularEventSpec(e2, r2_tr2);
		}

	}
	

}
