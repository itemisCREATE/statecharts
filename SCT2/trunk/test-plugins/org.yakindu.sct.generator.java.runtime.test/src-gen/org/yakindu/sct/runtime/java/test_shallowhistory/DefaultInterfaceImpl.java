/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_shallowhistory;

import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class DefaultInterfaceImpl implements IDefaultInterfaceImpl {
	protected Map<String, Event<Events>> inEventMap;

	protected Test_ShallowHistoryCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_ShallowHistoryCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;

		inEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event1", new Event<Events>(Events.Event1, 0));
		inEventMap.put("event2", new Event<Events>(Events.Event2, 0));
		inEventMap.put("event3", new Event<Events>(Events.Event3, 0));
		inEventMap.put("event4", new Event<Events>(Events.Event4, 0));
		inEventMap.put("event5", new Event<Events>(Events.Event5, 0));
		inEventMap.put("event6", new Event<Events>(Events.Event6, 0));
		inEventMap.put("event7", new Event<Events>(Events.Event7, 0));
		inEventMap.put("event8", new Event<Events>(Events.Event8, 0));
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	public Event<Events> getEventEvent1() {
		return inEventMap.get("event1");
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(getEventEvent2());
	}

	public Event<Events> getEventEvent2() {
		return inEventMap.get("event2");
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return inEventMap.get("event3");
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(getEventEvent4());
	}

	public Event<Events> getEventEvent4() {
		return inEventMap.get("event4");
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(getEventEvent5());
	}

	public Event<Events> getEventEvent5() {
		return inEventMap.get("event5");
	}

	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(getEventEvent6());
	}

	public Event<Events> getEventEvent6() {
		return inEventMap.get("event6");
	}

	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(getEventEvent7());
	}

	public Event<Events> getEventEvent7() {
		return inEventMap.get("event7");
	}

	public void raiseEvent8() {
		statemachine.getOccuredEvents().add(getEventEvent8());
	}

	public Event<Events> getEventEvent8() {
		return inEventMap.get("event8");
	}

	public boolean raiseEvent(String name) {
		if (inEventMap.get(name) != null) {
			return statemachine.getOccuredEvents().add(inEventMap.get(name));
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean raiseEvent(String name, Object value) {
		if (inEventMap.get(name) != null
				&& inEventMap.get(name) instanceof ValuedEvent) {
			ValuedEvent<?, ?> event = (ValuedEvent<?, ?>) inEventMap.get(name);
			if (event.getValue().getClass() == value.getClass()) {
				((ValuedEvent<Events, Object>) event).setValue(value);
				return statemachine.getOccuredEvents()
						.add(inEventMap.get(name));
			}
		}
		return false;
	}

	public boolean setVariable(String name, Object value) {
		return false;
	}

	public Object getVariable(String name) {
		return null;
	}
}
