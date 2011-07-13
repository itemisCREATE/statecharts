/**
 * Copyright (c) 2010 committers of YAKINDU and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.impl.EventImpl;
import org.yakindu.sct.model.sgraph.impl.FinalStateImpl;
import org.yakindu.sct.model.sgraph.impl.PseudostateImpl;
import org.yakindu.sct.model.sgraph.impl.RegionImpl;
import org.yakindu.sct.model.sgraph.impl.StateImpl;
import org.yakindu.sct.model.sgraph.impl.TransitionImpl;
import org.yakindu.sct.model.sgraph.impl.VariableImpl;
import org.yakindu.sct.simulation.runtime.sgraph.Action;
import org.yakindu.sct.simulation.runtime.sgraph.ActionStatement;
import org.yakindu.sct.simulation.runtime.sgraph.CompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.FinalState;
import org.yakindu.sct.simulation.runtime.sgraph.Guard;
import org.yakindu.sct.simulation.runtime.sgraph.GuardExpression;
import org.yakindu.sct.simulation.runtime.sgraph.Node;
import org.yakindu.sct.simulation.runtime.sgraph.Pseudostate;
import org.yakindu.sct.simulation.runtime.sgraph.PseudostateKind;
import org.yakindu.sct.simulation.runtime.sgraph.Region;
import org.yakindu.sct.simulation.runtime.sgraph.SignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.SimpleState;
import org.yakindu.sct.simulation.runtime.sgraph.State;
import org.yakindu.sct.simulation.runtime.sgraph.Statechart;
import org.yakindu.sct.simulation.runtime.sgraph.TimeEvent;
import org.yakindu.sct.simulation.runtime.sgraph.TimeEventExpression;
import org.yakindu.sct.simulation.runtime.sgraph.Transition;
import org.yakindu.sct.simulation.runtime.stext.Expression;
import org.yakindu.sct.simulation.runtime.stext.Function;
import org.yakindu.sct.simulation.runtime.stext.FunctionMethod;
import org.yakindu.sct.simulation.runtime.stext.Trigger;
import org.yakindu.sct.simulation.runtime.stext.Variable;
import org.yakindu.sct.simulation.runtime.stext.builder.BuilderException;
import org.yakindu.sct.simulation.runtime.stext.builder.ExpressionBuilder;

public class StatechartBuilder extends Function {
	
	
	protected static Comparator<Region> regionComparator = new Comparator<Region>(){
		public int compare(Region o1, Region o2) {
			return o1.getPriority() - o2.getPriority();
		}
	};
	
	protected static Map<PseudoTypes, PseudostateKind> pseudotypeMap;
	
	static {
		pseudotypeMap = new HashMap<statemachine.PseudoTypes, PseudostateKind>();
		pseudotypeMap.put(statemachine.PseudoTypes.CHOICE, PseudostateKind.CHOICE);
		pseudotypeMap.put(statemachine.PseudoTypes.DEEP_HISTORY, PseudostateKind.DEEPHISTORY);
		pseudotypeMap.put(statemachine.PseudoTypes.INITIAL, PseudostateKind.INITIAL);
		pseudotypeMap.put(statemachine.PseudoTypes.JUNCTION, PseudostateKind.JUNCTION);
		pseudotypeMap.put(statemachine.PseudoTypes.SHALLOW_HISTORY, PseudostateKind.SHALLOWHISTORY);
	}
	
	public Statechart build(org.yakindu.sct.model.sgraph.Statechart source) {
		Statechart sc = new Statechart(source.getUUID());
		build(sc, source.eContents());		
		
		return sc;
	}

	
	@FunctionMethod("")
	public Object build(Statechart tParent, VariableImpl sChild) {
		Variable var = new Variable(sChild.getName());
		tParent.addVariable(var);
		tParent.defineAlias(sChild, var);

		if (sChild.getgetDataType() == statemachine.DataTypes.BOOLEAN) {
			var.setType(Boolean.class);
			var.setValue(false);
		}
		else if (sChild.getDataType() == statemachine.DataTypes.INT) {
			var.setType(Integer.class);
			var.setValue(0);
		}
		else if (sChild.getDataType() == statemachine.DataTypes.DOUBLE) {
			var.setType(Float.class);
			var.setValue(0.0f);
		}
			
		return var;
	}
	
	
	@FunctionMethod("")
	public Object build(Statechart tParent, EventImpl sChild) {
		SignalEvent event = new SignalEvent(sChild.getName());
		tParent.addSignalEvent(event);
		tParent.defineAlias(sChild, event);
		return event;
	}
	
	
	@FunctionMethod("")
	public Object build(Statechart tParent, RegionImpl sChild) {
		Region region = new Region("" + sChild.getPriority(), sChild.getPriority(), tParent);
		Collections.sort(tParent.getRegions(), regionComparator);
		
		build(region, sChild.eContents());		

		return region;
	}
	
	
	@FunctionMethod("")
	public Object build(Statechart tParent, TransitionImpl sTrans) {
		
		Node fromNode = (Node) tParent.getElementByAlias(sTrans.getSourceNode()); 
		Node toNode = (Node) tParent.getElementByAlias(sTrans.getTargetNode());
		String expression = sTrans.getExpression();

		String transitionId = "t@" + sTrans.getId();
		TimeEvent timeTrigger = null;
		Set<SignalEvent> signalTriggers = new HashSet<SignalEvent>();
		Guard  guard  = null;
		Action action = null;
		
		
		if (expression != null && expression.trim().length()>0) {
			ExpressionBuilder builder = new ExpressionBuilder();
			
			String triggerExpression = JavaExtensions.extractTriggerExpressionString(expression);
			if (triggerExpression != null && triggerExpression.trim().length() >0) {
				List<Trigger> triggers = builder.buildTriggerExpression(triggerExpression);
				for (Trigger trigger : triggers) {
					if (trigger instanceof Trigger.SignalEvent) {
						SignalEvent event = tParent.getSignalEvent(((Trigger.SignalEvent) trigger).getSignal());
						if (event != null) signalTriggers.add(event);
					} else if (trigger instanceof Trigger.TimeEvent) {
						timeTrigger = new TimeEventExpression(transitionId + ".timer", 
								(Trigger.TimeEvent)trigger, 
								tParent);
					}
				}
			}
			
			String guardExpression = JavaExtensions.extractGuardExpressionString(expression);
			guard = (guardExpression != null && guardExpression .trim().length() > 0 ) 
			? new GuardExpression(builder.buildGuardExpression(guardExpression), tParent) 
			: null;

			String actionExpresion = JavaExtensions.extractActionExpressionString(expression);
			action = (actionExpresion != null && actionExpresion.trim().length() > 0 ) 
					? new ActionStatement(builder.buildActionExpression(actionExpresion), tParent) 
					: null;

		}
		
		Transition tTrans = new Transition(
				"t@" + sTrans.getId(), 
				sTrans.getPriority(), 
				timeTrigger,
				signalTriggers,
				guard,
				action, 
				fromNode,
				toNode);
		
		tParent.defineAlias(sTrans, tTrans);

		return tTrans;
	}
	
	
	@FunctionMethod("")
	public Object build(CompoundState tParent, RegionImpl sChild) {
		Region region = new Region("" + sChild.getPriority(), sChild.getPriority(), tParent);
		Collections.sort(tParent.getRegions(), regionComparator);
		
		build(region, sChild.eContents());		

		return region;
	}
	
	
	@FunctionMethod("")
	public Object build(Region tParent, PseudostateImpl sChild) {
		Pseudostate pseudoState = new Pseudostate(tParent.getId() + "." + sChild.getId(), tParent, pseudotypeMap.get(sChild.getPseudoType()) );
		((Statechart)tParent.getStatechart()).defineAlias(sChild, pseudoState);
		return pseudoState;
	}
	
	
	@FunctionMethod("")
	public Object build(Region tParent, StateImpl sChild) {
		ExpressionBuilder builder = new ExpressionBuilder();
		
		ActionStatement entryAction = (sChild.getEntry() != null && sChild.getEntry().trim().length()>0) ? 
				new ActionStatement(builder.buildActionExpression(sChild.getEntry()), (Statechart) tParent.getStatechart()) : null;
		ActionStatement doAction = (sChild.getDo() != null && sChild.getDo().trim().length()>0) ? 
				new ActionStatement(builder.buildActionExpression(sChild.getDo()), (Statechart) tParent.getStatechart()) : null;
		ActionStatement exitAction = (sChild.getExit() != null && sChild.getExit().trim().length()>0) ? 
				new ActionStatement(builder.buildActionExpression(sChild.getExit()), (Statechart) tParent.getStatechart()) : null;
		
		State state = null;
		if ( sChild.getRegion().size() > 0 ) {
			state = new CompoundState(tParent.getId() + "." + sChild.getName(), sChild.getName(), tParent, entryAction, exitAction );
			build(state, sChild.eContents());
			
		} else {
			state = new SimpleState(tParent.getId() + "." + sChild.getName(), sChild.getName(), tParent, entryAction, doAction, exitAction );
		}
		
		((Statechart)tParent.getStatechart()).defineAlias(sChild, state);

		return state;
	}
	
	
	
	@FunctionMethod("")
	public Object build(Region tParent, FinalStateImpl sChild) {		
		FinalState state = new FinalState(tParent.getId() + ".<final>", tParent );
		((Statechart)tParent.getStatechart()).defineAlias(sChild, state);
		return state;
	}
	
	
	
	protected void build(Object targetParent, EList<EObject> sourceChildren) {
		for (EObject source : sourceChildren) {
			build(targetParent, source);
		}
	}
	
	
	/**
	 * Internal build method that performs the dynamic dispatch to the appropriate (correctly named) 
	 * builder function. The parameter is always a EObject and since we have use dynamic EMF we match by 
	 * naming conventions.
	 * 
	 * @param sourceChild
	 * @return
	 */
	protected Object build(Object targetParent, EObject sourceChild) {
		if ( sourceChild == null ) return null;
		
		Object[] params = new Object[]{targetParent, sourceChild};
		
		Function f = ExpressionBuilder.lookup(this.getClass(), "build", params);
		if (f != null) 
			return f.execute(params);
		
		throw new BuilderException("No function  build(" + targetParent.getClass().getName() + ", " + sourceChild.eClass().getName() + ") !");
	}

}
