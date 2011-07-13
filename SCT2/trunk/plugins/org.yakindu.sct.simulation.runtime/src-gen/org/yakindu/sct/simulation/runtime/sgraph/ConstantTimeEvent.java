package org.yakindu.sct.simulation.runtime.sgraph;

public class ConstantTimeEvent extends TimeEvent {
	private long duration = -1;

	public ConstantTimeEvent(String id, long duration) {
		super(id);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}
}
