package org.yakindu.sct.simulation.runtime.sgraph;

public interface RTTimingService {

	public void requestTimeEvent(RTTimeEvent timeEvent);

	public void cancelTimeEvent(RTTimeEvent timeEvent);

}
