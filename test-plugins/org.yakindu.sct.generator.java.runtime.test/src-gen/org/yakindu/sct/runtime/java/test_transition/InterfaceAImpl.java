/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_transition;

import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceAImpl extends NotificationSender
		implements
			IInterfaceAImpl {
	protected Map<String, Event<Events>> outEventMap;
	protected Map<String, Event<Events>> inEventMap;

	protected Test_TransitionCycleBasedStatemachine statemachine;

	public InterfaceAImpl(Test_TransitionCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;

		inEventMap = new HashMap<String, Event<Events>>();

		outEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event1", new ValuedEvent<Events, Integer>(
				Events.Event1, 0, 1));
		inEventMap.put("event2", new Event<Events>(Events.Event2, 0));
		inEventMap.put("event3", new Event<Events>(Events.Event3, 0));
		inEventMap.put("event4", new Event<Events>(Events.Event4, 0));
		outEventMap.put("event5", new Event<Events>(Events.Event5, 0));
	}

	public void raiseEvent1(int value) {
		getEventEvent1().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	@SuppressWarnings("unchecked")
	public ValuedEvent<Events, Integer> getEventEvent1() {
		return (ValuedEvent<Events, Integer>) inEventMap.get("event1");
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
		statemachine.getOutEvents().add(getEventEvent5());
		notifyListeners(new EventNotification(getEventEvent5()));
	}

	public Event<Events> getEventEvent5() {
		return outEventMap.get("event5");
	}

	public boolean isRaisedEvent5() {
		return statemachine.getOutEvents().contains(getEventEvent5());
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
