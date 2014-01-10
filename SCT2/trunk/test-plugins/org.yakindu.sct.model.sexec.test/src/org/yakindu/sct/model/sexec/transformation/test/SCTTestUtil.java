package org.yakindu.sct.model.sexec.transformation.test;

import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createEntry;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createBooleanType;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEventDefinition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createIntegerType;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionTrigger;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createRealType;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createRegularEventSpec;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createStringType;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createValue;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class SCTTestUtil {

	public static Type TYPE_INTEGER = _createIntegerType("integer");

	public static List<Step> flattenSequenceStepsAsList(Step step) {
		return flattenSequenceStepsAsList(step, new LinkedList<Step>());
	}

	public static List<Step> flattenSequenceStepsAsList(Step step,
			List<Step> result) {
		if (step instanceof Sequence) {
			Sequence sequence = (Sequence) step;
			for (Step s : sequence.getSteps()) {
				flattenSequenceStepsAsList(s, result);
			}
		} else {
			result.add(step);
		}
		return result;
	}

	public static State findState(Statechart sc, final String name) {
		Collection<EObject> states = Collections2.filter(
				EcoreUtil2.eAllContentsAsList(sc), new Predicate<Object>() {

					public boolean apply(Object obj) {
						// TODO Auto-generated method stub
						return obj != null && obj instanceof State
								&& name.equals(((State) obj).getName());
					}
				});

		return (states.size() > 0) ? (State) states.iterator().next() : null;
	}

	public static State findStateFullyQualified(Statechart sc, final String name) {

		Collection<EObject> states = Collections2.filter(
				EcoreUtil2.eAllContentsAsList(sc), new Predicate<Object>() {

					public boolean apply(Object obj) {
						// TODO Auto-generated method stub
						return obj != null && obj instanceof State
								&& name.equals(fqn((State) obj));
					}
				});

		return (states.size() > 0) ? (State) states.iterator().next() : null;
	}

	public static final String fqn(State state) {
		return fqn(state.getParentRegion()) + "." + state.getName();
	}

	public static final String fqn(Region region) {
		if (region.getComposite() instanceof State)
			return fqn((State) region.getComposite()) + "." + region.getName();

		return ((Statechart) region.getComposite()).getName() + "."
				+ region.getName();

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

	public static class InitializingTSC {
		public Statechart sc = _createStatechart("test");
		public InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		public VariableDefinition e1 = _createVariableDefinition("e1",
				_createBooleanType("boolean"), s_scope, _createValue(true));

		public InitializingTSC() {
		}

	}

	public static class InitializingWithoutDefaultTSC {
		public Statechart sc = _createStatechart("test");
		public InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		public VariableDefinition b = _createVariableDefinition("b",
				_createBooleanType("boolean"), s_scope, null);
		
		public VariableDefinition i = _createVariableDefinition("i",
				_createIntegerType("integer"), s_scope, null);
		
		public VariableDefinition r = _createVariableDefinition("r",
				_createRealType("real"), s_scope, null);

		public VariableDefinition s = _createVariableDefinition("s",
				_createStringType("string"), s_scope, null);

		public InitializingWithoutDefaultTSC() {
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
