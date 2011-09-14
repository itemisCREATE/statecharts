package org.yakindu.sct.simulation.runtime.sgraph;

public abstract class RTEvent {

	protected String id;

	public RTEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
