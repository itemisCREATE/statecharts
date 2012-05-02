package org.yakindu.sct.runtime.java.trafficlightwaiting;

import org.yakindu.sct.runtime.java.Event;

public interface IDefaultInterfaceImpl extends DefaultInterface {

	public Event<Events> getEventPedestrianRequest();

	public Event<Events> getEventOnOff();

}
