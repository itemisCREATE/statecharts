package org.yakindu.sct.simulation.runtime.sgraph;

public interface TimingService {

	public void requestTimeEvent(TimeEvent timeEvent);

	public void cancelTimeEvent(TimeEvent timeEvent);

}
