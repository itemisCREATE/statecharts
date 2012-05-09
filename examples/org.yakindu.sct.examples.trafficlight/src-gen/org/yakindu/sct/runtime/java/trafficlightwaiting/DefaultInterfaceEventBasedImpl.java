package org.yakindu.sct.runtime.java.trafficlightwaiting;

public class DefaultInterfaceEventBasedImpl extends DefaultInterfaceImpl {

	public DefaultInterfaceEventBasedImpl(
			TrafficLightWaitingCycleBasedStatemachine statemachine) {
		super(statemachine);
	}

	public void raisePedestrianRequest() {
		super.raisePedestrianRequest();
		statemachine.runCycle();
	}
	public void raiseOnOff() {
		super.raiseOnOff();
		statemachine.runCycle();
	}

}
