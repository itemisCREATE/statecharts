package org.yakindu.sct.simulation.runtime.sgraph;

public class RTSignalEvent extends RTEvent {

	private Object value;

	public RTSignalEvent(String id, Object value) {
		super(id);
		this.value = value;
	}

	public RTSignalEvent(String id) {
		super(id);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
