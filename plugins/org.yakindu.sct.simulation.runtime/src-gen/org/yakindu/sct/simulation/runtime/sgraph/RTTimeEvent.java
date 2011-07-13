package org.yakindu.sct.simulation.runtime.sgraph;

public abstract class RTTimeEvent extends RTEvent {

	public RTTimeEvent(String id) {
		super(id);
	}

	public abstract long getDuration();
}
