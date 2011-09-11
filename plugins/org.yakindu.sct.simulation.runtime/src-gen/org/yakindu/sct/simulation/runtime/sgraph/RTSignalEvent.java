package org.yakindu.sct.simulation.runtime.sgraph;

public class RTSignalEvent extends RTEvent {

	protected Class<?> type;
	private Object value;

	public RTSignalEvent(String id, Class<Object> type) {
		super(id);
		this.type = type;
	}

	public RTSignalEvent(String id) {
		super(id);
	}

	public RTSignalEvent() {
		this(null);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Class<?> getType() {
		return type;
	}
	
	
	
	

}
