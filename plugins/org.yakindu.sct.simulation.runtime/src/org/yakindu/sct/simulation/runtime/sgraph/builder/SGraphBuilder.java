/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.sgraph.builder;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.core.simulation.ISGraphExecutionBuilder;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.simulation.runtime.sgraph.GuardExpression;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.RTAction;
import org.yakindu.sct.simulation.runtime.sgraph.RTCompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.RTFinalState;
import org.yakindu.sct.simulation.runtime.sgraph.RTGuard;
import org.yakindu.sct.simulation.runtime.sgraph.RTNode;
import org.yakindu.sct.simulation.runtime.sgraph.RTPseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.RTRegion;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTSimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.RTState;
import org.yakindu.sct.simulation.runtime.sgraph.RTStatechart;
import org.yakindu.sct.simulation.runtime.sgraph.RTTimeEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTTransition;
import org.yakindu.sct.simulation.runtime.stext.Function;
import org.yakindu.sct.simulation.runtime.stext.FunctionMethod;
import org.yakindu.sct.simulation.runtime.stext.Variable;
import org.yakindu.sct.simulation.runtime.stext.builder.STextBuilder;

/**
 * 
 * @author axel terfloth
 * @author andreas muelder
 * 
 */
public class SGraphBuilder extends Function implements ISGraphExecutionBuilder {

	protected static Comparator<RTRegion> regionComparator = new Comparator<RTRegion>() {
		public int compare(RTRegion o1, RTRegion o2) {
			return o1.getPriority() - o2.getPriority();
		}
	};
	
	

	public RTStatechart build(Statechart source) {
		RTStatechart sc = new RTStatechart(source.getName());
		// Build the structure with states and regions
		build(sc, source.eContents());
		// Build the transitions
		EList<EObject> allContentsOfType = new BasicEList<EObject>(
				EcoreUtil2.getAllContentsOfType(source, Transition.class));
		build(sc, allContentsOfType);
		return sc;
	}

	@FunctionMethod("")
	public Object build(RTStatechart statechart, Scope scope) {
		build(statechart, new BasicEList<EObject>(scope.getDeclarations()));
		return statechart;
	}

	@FunctionMethod("")
	public Object build(RTStatechart tParent, Event event) {
		RTSignalEvent signalEvent = new RTSignalEvent(event.getName());
		tParent.addSignalEvent(signalEvent);
		tParent.defineAlias(event, signalEvent);
		return event;
	}

	@FunctionMethod("")
	public Object build(RTStatechart statechart, Region region) {
		RTRegion runtimeRegion = new RTRegion("" + region.getPriority(),
				region.getPriority(), statechart);
		Collections.sort(statechart.getRegions(), regionComparator);
		build(runtimeRegion, region.eContents());
		return runtimeRegion;
	}

	@FunctionMethod("")
	public Object build(RTCompoundState compoundState, Region region) {
		RTRegion runtimeRegion = new RTRegion("" + region.getPriority(),
				region.getPriority(), compoundState);
		Collections.sort(compoundState.getRegions(), regionComparator);
		build(runtimeRegion, region.eContents());
		return runtimeRegion;
	}

	@FunctionMethod("")
	public Object build(RTRegion region, Choice choice) {
		RTPseudostate runtimeChoice = new RTPseudostate("", region,
				PseudostateKind.CHOICE);
		((RTStatechart) region.getStatechart()).defineAlias(choice,
				runtimeChoice);
		return runtimeChoice;
	}

	@FunctionMethod("")
	public Object build(RTRegion runtimeRegion, Entry entry) {
		PseudostateKind kind = null;
		switch (entry.getKind()) {
		case INITIAL:
			kind = PseudostateKind.INITIAL;
			break;
		case DEEP_HISTORY:
			kind = PseudostateKind.DEEPHISTORY;
			break;
		case SHALLOW_HISTORY:
			kind = PseudostateKind.SHALLOWHISTORY;
			break;
		default:
			throw new IllegalStateException("Unknown Entry kind "
					+ entry.getKind());
		}
		RTPseudostate pseudoState = new RTPseudostate(runtimeRegion.getId()
				+ "." + "TODO", runtimeRegion, kind);
		((RTStatechart) runtimeRegion.getStatechart()).defineAlias(entry,
				pseudoState);
		return pseudoState;
	}

	@FunctionMethod("")
	public Object build(RTRegion parent, State state) {
		RTState runtimeState = null;
		if (state.getSubRegions().size() > 0) {
			runtimeState = new RTCompoundState(parent.getId() + "."
					+ state.getName(), state.getName(), parent, null, null);
			build(runtimeState, state.eContents());

		} else {
			runtimeState = new RTSimpleState(parent.getId() + "."
					+ state.getName(), state.getName(), parent, null, null,
					null);
		}

		((RTStatechart) parent.getStatechart())
				.defineAlias(state, runtimeState);

		return runtimeState;
	}

	@FunctionMethod("")
	public Object build(RTRegion runtimeRegion, FinalState finalState) {
		RTFinalState state = new RTFinalState(runtimeRegion.getId()
				+ ".<final>", runtimeRegion);
		((RTStatechart) runtimeRegion.getStatechart()).defineAlias(finalState,
				state);
		return state;
	}

	@FunctionMethod("")
	public Object build(RTStatechart tParent, Transition transition) {
		RTNode fromNode = (RTNode) tParent.getElementByAlias(transition
				.getSource());
		RTNode toNode = (RTNode) tParent.getElementByAlias(transition
				.getTarget());

		RTTimeEvent timeTrigger = null;
		Set<RTSignalEvent> signalTriggers = new HashSet<RTSignalEvent>();
		RTGuard guard = null;
		RTAction action = null;

		Trigger trigger = transition.getTrigger();
//		// TODO: Das muss hier raus:
		if (trigger instanceof ReactionTrigger) {
			EList<EventSpec> triggers = ((ReactionTrigger) trigger)
					.getTriggers();
			for (EventSpec eventSpec : triggers) {
				if (eventSpec instanceof RegularEventSpec) {
					Event event = ((RegularEventSpec) eventSpec).getEvent();
					String name = event
							.getName();
					RTSignalEvent signalEvent = tParent
							.getSignalEvent(name);
					if (signalEvent != null) {
						signalTriggers.add(signalEvent);
					}
				}
				if(eventSpec instanceof TimeEventSpec){
					TimeUnit unit = ((TimeEventSpec) eventSpec).getUnit();
					final int value = ((TimeEventSpec) eventSpec).getValue();
					timeTrigger = new RTTimeEvent("id") {
						@Override
						public long getDuration() {
							//TODO unit
							return value;
						}
					};
					
				}
				// TODO: TimeEvent
			}
//			//TODO
		}

//		Effect effect = transition.getEffect();
//		action = new ActionStatement(
//				sTextBuilder.buildActionExpression(effect), tParent);

		RTTransition tTrans = new RTTransition("t@", transition.getPriority(),
				null, signalTriggers, guard, action, fromNode, toNode);
		tParent.defineAlias(transition, tTrans);
		return tTrans;
	}

	protected void build(Object targetParent, EList<EObject> sourceChildren) {
		for (EObject source : sourceChildren) {
			build(targetParent, source);
		}
	}

	protected Object build(Object targetParent, EObject sourceChild) {
		if (sourceChild == null)
			return null;

		Object[] params = new Object[] { targetParent, sourceChild };

		Function f = lookup(this.getClass(), "build", params);
		if (f != null)
			return f.execute(params);

		throw new IllegalStateException("No function  build("
				+ targetParent.getClass().getName() + ", "
				+ sourceChild.eClass().getName() + ") !");
	}

}
