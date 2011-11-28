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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
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
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.simulation.core.ISGraphExecutionBuilder;
import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.sgraph.GuardExpression;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.RTAction;
import org.yakindu.sct.simulation.runtime.sgraph.RTActionStatement;
import org.yakindu.sct.simulation.runtime.sgraph.RTCompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.RTFinalState;
import org.yakindu.sct.simulation.runtime.sgraph.RTGuard;
import org.yakindu.sct.simulation.runtime.sgraph.RTNode;
import org.yakindu.sct.simulation.runtime.sgraph.RTPseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.RTReaction;
import org.yakindu.sct.simulation.runtime.sgraph.RTRegion;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTSimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.RTState;
import org.yakindu.sct.simulation.runtime.sgraph.RTStatechart;
import org.yakindu.sct.simulation.runtime.sgraph.RTTimeEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTTransition;
import org.yakindu.sct.simulation.runtime.stext.Function;
import org.yakindu.sct.simulation.runtime.stext.FunctionMethod;
import org.yakindu.sct.simulation.runtime.stext.RTExpression;
import org.yakindu.sct.simulation.runtime.stext.RTStatement;
import org.yakindu.sct.simulation.runtime.stext.RTTrigger;
import org.yakindu.sct.simulation.runtime.stext.RTVariable;
import org.yakindu.sct.simulation.runtime.stext.builder.STextBuilder;

/**
 * 
 * @author axel terfloth
 * @author andreas muelder
 * 
 */
public class SGraphBuilder extends Function implements ISGraphExecutionBuilder {

	private STextBuilder textBuilder;

	public SGraphBuilder() {
		textBuilder = new STextBuilder();
	}

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
		RTSignalEvent signalEvent = (RTSignalEvent) textBuilder.build(event);
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
	public Object build(RTStatechart statechart, Variable definition) {
		RTVariable var = (RTVariable) textBuilder.build(definition);
		statechart.addVariable(var);
		statechart.defineAlias(definition, var);
		return var;
	}

	@FunctionMethod("")
	public Object build(RTRegion parent, State state) {
		RTState runtimeState = null;

		LocalReaction entryReaction = getReactionByTriggerEventType(state,
				EntryEvent.class);
		LocalReaction exitReaction = getReactionByTriggerEventType(state,
				ExitEvent.class);

		List<LocalReaction> localReactions = getLocalReactions(state);
		if (entryReaction != null)
			localReactions.remove(entryReaction);
		if (exitReaction != null)
			localReactions.remove(exitReaction);

		// Build the transition action
		RTAction entryAction = buildAction(
				(RTStatechart) parent.getStatechart(), entryReaction);
		RTAction exitAction = buildAction(
				(RTStatechart) parent.getStatechart(), exitReaction);

		if (state.isSubmachine()) {
			runtimeState = new RTCompoundState(parent.getId() + "."
					+ state.getName(), state.getName(), parent, entryAction,
					exitAction);

			EList<Region> regions = state.getSubstatechart().getRegions();
			EList<EObject> contents = new BasicEList<EObject>();
			contents.addAll(regions);
			build(runtimeState, contents);

			// Build the scopes
			EList<EObject> scopes = new BasicEList<EObject>();
			scopes.addAll(state.getSubstatechart().getScopes());
			build(parent.getStatechart(), scopes);
			// Build the transitions
			EList<EObject> transitions = new BasicEList<EObject>(
					EcoreUtil2.getAllContentsOfType(state.getSubstatechart(),
							Transition.class));
			build(parent.getStatechart(), transitions);

		} else if (state.isComposite()) {
			runtimeState = new RTCompoundState(parent.getId() + "."
					+ state.getName(), state.getName(), parent, entryAction,
					exitAction);
			build(runtimeState, state.eContents());

		} else if (state.isSimple()) {
			runtimeState = new RTSimpleState(parent.getId() + "."
					+ state.getName(), state.getName(), parent, entryAction,
					null, exitAction);
		}

		for (LocalReaction reaction : localReactions) {
			runtimeState.addLocalReaction(buildReaction(
					(RTStatechart) parent.getStatechart(), reaction));
		}

		((RTStatechart) parent.getStatechart())
				.defineAlias(state, runtimeState);

		return runtimeState;
	}

	private RTReaction buildReaction(RTStatechart context,
			LocalReaction reaction) {
		Trigger trigger = reaction.getTrigger();
		RTTrigger rtTrigger = buildTrigger(context, trigger);

		RTAction action = buildAction(context, reaction.getEffect());

		return new RTReaction(rtTrigger, action);
	}

	protected RTAction buildAction(ExecutionScope scope,
			LocalReaction entryReaction) {
		if (entryReaction != null) {
			Effect effect = entryReaction.getEffect();
			RTStatement statement = (RTStatement) textBuilder.build(effect);
			if (statement != null) {
				return new RTActionStatement(statement, scope);
			}
		}
		return null;
	}

	protected <T extends EObject> LocalReaction getReactionByTriggerEventType(
			State state, Class<T> triggerType) {

		// TODO: derive localReactions from scope.
		for (Scope declarationScope : state.getScopes()) {
			EList<EObject> entryEvents = new BasicEList<EObject>(
					EcoreUtil2.getAllContentsOfType(declarationScope,
							triggerType));

			if (!entryEvents.isEmpty()) {
				return (LocalReaction) entryEvents.get(0).eContainer()
						.eContainer();
			}
		}
		return null;
	}

	protected List<LocalReaction> getLocalReactions(State state) {

		// TODO: derive localReactions from scope.
		for (Scope declarationScope : state.getScopes()) {
			return EcoreUtil2.getAllContentsOfType(declarationScope,
					LocalReaction.class);
		}
		return null;
	}

	protected LocalReaction getExitReaction(State state) {
		return null;
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
	public Object build(RTCompoundState compound, Transition transition) {
		// TODO
		return null;
	}

	@FunctionMethod("")
	public Object build(RTCompoundState compound, Scope scope) {
		// TODO
		return null;
	}

	@FunctionMethod("")
	public Object build(RTStatechart tParent, Transition transition) {
		RTNode fromNode = (RTNode) tParent.getElementByAlias(transition
				.getSource());
		RTNode toNode = (RTNode) tParent.getElementByAlias(transition
				.getTarget());

		if (fromNode == null || toNode == null)
			return null; // >>>>>>>>> exit here on false precondition

		Trigger trigger = transition.getTrigger();
		RTTrigger rtTrigger = buildTrigger(tParent, trigger);

		RTAction action = buildAction(tParent, transition.getEffect());

		String id = "t@"
				+ transition.getSource().getOutgoingTransitions()
						.indexOf(transition);
		RTReaction tTrans = new RTTransition(id, transition.getPriority(),
				rtTrigger, action, fromNode, toNode);
		tParent.defineAlias(transition, tTrans);

		return tTrans;
	}

	protected RTAction buildAction(RTStatechart tParent, Effect effect) {
		// Build the transition action
		RTAction action = null;
		RTStatement statement = (RTStatement) textBuilder.build(effect);
		if (statement != null) {
			action = new RTActionStatement(statement, tParent);
		}
		return action;
	}

	protected RTTrigger buildTrigger(RTStatechart tParent,

	Trigger trigger) {

		RTTrigger rtTrigger = null;
		RTTimeEvent timeTrigger = null;
		Set<RTSignalEvent> signalTriggers = new HashSet<RTSignalEvent>();
		RTGuard guard = null;

		// // TODO: Das muss hier raus:
		if (trigger instanceof ReactionTrigger) {
			EList<EventSpec> triggers = ((ReactionTrigger) trigger)
					.getTriggers();
			for (EventSpec eventSpec : triggers) {
				if (eventSpec instanceof RegularEventSpec) {
					Event event = ((RegularEventSpec) eventSpec).getEvent();
					String name = event.getName();
					RTSignalEvent signalEvent = tParent.getSignalEvent(name);
					if (signalEvent != null) {
						signalTriggers.add(signalEvent);
					}
				}
				if (eventSpec instanceof TimeEventSpec) {
					final TimeUnit unit = ((TimeEventSpec) eventSpec).getUnit();

					final long value = ((TimeEventSpec) eventSpec).getValue();
					timeTrigger = new RTTimeEvent("id") {
						@Override
						public long getDuration() {
							if (unit == TimeUnit.SECOND) {
								return value * 1000;
							} else if (unit == TimeUnit.MILLISECOND) {
								return value;
							} else if (unit == TimeUnit.NANOSECOND) {
								return value / 1000;
							}
							return value;
						}
					};

				}
				// TODO: TimeEvent
			}

			// Build the transition action
			Expression guardExp = ((ReactionTrigger) trigger)
					.getGuardExpression();
			RTExpression rtGuardExp = (RTExpression) textBuilder
					.build(guardExp);
			if (rtGuardExp != null) {
				guard = new GuardExpression(rtGuardExp, tParent);
			}

			rtTrigger = new RTTrigger(timeTrigger, signalTriggers, guard);
		}
		return rtTrigger;
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

	public boolean isBuilderFor(EObject context) {
		String resourceExtension = context.eResource().getURI().lastSegment();
		return resourceExtension.endsWith("sct");
	}

}
