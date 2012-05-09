package org.yakindu.sct.runtime.java.trafficlightwaiting;

import java.util.LinkedList;

import org.yakindu.sct.runtime.java.Event;

import org.yakindu.sct.runtime.java.TimeEvent;

public class TrafficLightWaitingEventBasedStatemachine
		extends
			TrafficLightWaitingCycleBasedStatemachine {

	private LinkedList<Event<? extends Enum<?>>> eventQueue;

	private DefaultInterfaceEventBasedImpl defaultInterface;

	public TrafficLightWaitingEventBasedStatemachine() {
		eventQueue = new LinkedList<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceEventBasedImpl(this);
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	protected IDefaultInterfaceImpl getDefaultInterfaceImpl() {
		return defaultInterface;
	}

	public void onTimeEventRaised(TimeEvent<? extends Enum<?>> timeEvent) {
		super.onTimeEventRaised(timeEvent);
		runCycle();
	}

	@Override
	protected LinkedList<Event<? extends Enum<?>>> getOccuredEvents() {
		return eventQueue;
	}

	@Override
	protected boolean eventOccured() {
		return !eventQueue.isEmpty();
	}

	@Override
	public void runCycle() {
		if (eventOccured()) {
			Event<? extends Enum<?>> event = getOccuredEvents().poll();
			super.getOccuredEvents().add(event);
			super.runCycle();
		}
	}
}
