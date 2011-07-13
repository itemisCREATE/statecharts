package org.yakindu.sct.simulation.runtime.sgraph;

public class RTConstantTimeEvent extends RTTimeEvent {
	private long duration = -1;

	public RTConstantTimeEvent(String id, long duration) {
		super(id);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}
}
