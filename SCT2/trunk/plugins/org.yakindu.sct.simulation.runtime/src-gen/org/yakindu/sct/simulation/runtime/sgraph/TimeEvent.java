package org.yakindu.sct.simulation.runtime.sgraph;

public abstract class TimeEvent extends Event {

	public TimeEvent(String id) {
		super(id);
	}

	public abstract long getDuration();
}
