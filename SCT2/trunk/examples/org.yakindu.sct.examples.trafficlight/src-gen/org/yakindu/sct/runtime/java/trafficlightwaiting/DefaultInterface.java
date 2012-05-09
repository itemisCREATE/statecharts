package org.yakindu.sct.runtime.java.trafficlightwaiting;

public interface DefaultInterface {

	public enum Events {
		PedestrianRequest, OnOff,
	}

	public void raisePedestrianRequest();

	public void raiseOnOff();

}
