package org.yakindu.sct.runtime.java.trafficlightwaiting;

import org.yakindu.sct.runtime.java.Event;

public class DefaultInterfaceImpl implements IDefaultInterfaceImpl {
	protected final Event<Events> PedestrianRequest = new Event<Events>(
			Events.PedestrianRequest, 0);
	protected final Event<Events> OnOff = new Event<Events>(Events.OnOff, 0);

	protected TrafficLightWaitingCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			TrafficLightWaitingCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
	}

	public void raisePedestrianRequest() {
		statemachine.getOccuredEvents().add(getEventPedestrianRequest());
	}

	public Event<Events> getEventPedestrianRequest() {
		return PedestrianRequest;
	}

	public void raiseOnOff() {
		statemachine.getOccuredEvents().add(getEventOnOff());
	}

	public Event<Events> getEventOnOff() {
		return OnOff;
	}

}
