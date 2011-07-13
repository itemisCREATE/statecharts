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
package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.sgraph.AbstractStatechart;
import org.yakindu.sct.simulation.runtime.sgraph.CompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.Event;
import org.yakindu.sct.simulation.runtime.sgraph.Node;
import org.yakindu.sct.simulation.runtime.sgraph.Region;
import org.yakindu.sct.simulation.runtime.sgraph.SignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.State;
import org.yakindu.sct.simulation.runtime.sgraph.TimingService;
import org.yakindu.sct.simulation.runtime.sgraph.Transition;
import org.yakindu.sct.simulation.runtime.stext.Variable;


public class Statechart extends AbstractStatechart implements ExecutionScope {


	protected Map<Object, Object> aliasToElementMap = new HashMap<Object, Object>();
	protected Map<Object, Object> elementToAliasMap = new HashMap<Object, Object>();

	protected List<SignalEvent> events = new ArrayList<SignalEvent>(); 
	protected Map<String, SignalEvent> eventMap = new HashMap<String, SignalEvent>();

	protected List<Variable> variables = new ArrayList<Variable>(); 
	protected Map<String, Variable> variableMap = new HashMap<String, Variable>();
		
	protected Set<State> currentStateConfigurartion = new HashSet<State>();
	
	protected StatechartListener listener;
	
	
	public Statechart(String id) {
		super(id);
	}

	public Statechart(String id, TimingService timingService) {
		super(id, timingService);
	}

	
	public TimingService getTimingService() {
		return timingService;
	}
	
	public void setTimingService(TimingService ts) {
		timingService = ts;
	}
	
	
	public StatechartListener getListener() {
		return listener;
	}

	public void setListener(StatechartListener listener) {
		this.listener = listener;
	}

	/**
	 * Adds a signal event definition to the interface of the statechart. 
	 * only those events, that are registered should be used during operation.
	 *  
	 * @param event
	 */
	public void addSignalEvent(SignalEvent event) {
		events.add(event);
		eventMap.put(event.getId(), event);
	}
	
	/**
	 * Gets a signal event by its id.
	 * 
	 * @param id
	 * @return the signal event
	 */
	public SignalEvent getSignalEvent(String id) {
		return eventMap.get(id);
	}
	
	public Set<Event> getRaisedEvents() {
		return Collections.unmodifiableSet(raisedEvents);
	}

	/**
	 * @return The list of all defined signal events of this statechart.
	 */
	public List<SignalEvent> getSignalEvents() {
		return Collections.unmodifiableList(events);
	}
	
	
	public void addVariable(Variable var) {
		variables.add(var);
		variableMap.put(var.getName(), var);
	}

	
	public Object getValue(String varName) {
		Variable var = getVariable(varName);
		return (var != null) ? var.getValue() : null ;		
	}

	
	public Variable getVariable(String varName) {
		return variableMap.get(varName);
	}
	
	public List<Variable>  getVariables() {
		return Collections.unmodifiableList(variables);
	}

	
	protected void stateLeft(State state) {
		currentStateConfigurartion.remove(state);
		if (listener != null) listener.stateLeft(state);
	}
	
	protected void stateEntered(State state) {
		currentStateConfigurartion.add(state);
		if (listener != null) listener.stateEntered(state);
	}
	
	protected void transitionFired(Transition trans) {
		if (listener != null) listener.transitionFired(trans);
	}
	
	public Set<State> getCurrentStateConfiguration() {
		return Collections.unmodifiableSet(currentStateConfigurartion);
	}
	
	
	public void raise(String signal) {
		setEvent(eventMap.get(signal));
	}

	public void reset(String signal) {
		raisedEvents.remove(eventMap.get(signal));
	}

	
	public void call(String procedureId) {
		// TODO Auto-generated method stub		
	}

	
	/**
	 * If a node is registered with a key then it can be accessed by the key using this method.
	 * Before a node can be accessed this way it must be registered using {@link #registerNode}. 
	 * @param alias
	 * @return the node object that is registered for the given key.
	 */
	public Object getElementByAlias(Object alias) {
		return aliasToElementMap.get(alias);
	}
	
	/**
	 * If a node is registered with a key then it can be accessed by the key using this method.
	 * Before a node can be accessed this way it must be registered using {@link #registerNode}. 
	 * @param element
	 * @return the node object that is registered for the given key.
	 */
	public Object getAliasByElement(Object element) {
		return elementToAliasMap.get(element);
	}
	
	/**
	 * Nodes can optionally be regitered with a key for later lookup.
	 * 
	 * @param key the key object
	 * @param element the node
	 */
	public void defineAlias(Object alias, Object element) {
		aliasToElementMap.put(alias, element);
		elementToAliasMap.put(element, alias);
	}

	
	public List<Region> getAllRegions() {
		List<Region> allRegions = new ArrayList<Region>();
		
		allRegions.addAll(getRegions());
		for (Region region : getRegions()) {
			addAllRegions(allRegions, region);
		}

		
		return allRegions;
	}

	
	protected void addAllRegions(List<Region> regions, Region region) {
		for (Node node : region.getNodes()) {
			if (node instanceof CompoundState) addAllRegions(regions, (CompoundState) node);
		}
	}
	
	protected void addAllRegions(List<Region> regions, CompoundState cState) {
		regions.addAll(cState.getRegions());
		
		for (Region region : cState.getRegions()) {
			addAllRegions(regions, region);
		}
	}
	
	
}
