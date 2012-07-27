package org.yakindu.sct.simulation.core.runtime.impl;

public class ExecutionOperation extends AbstractSlot {

	protected Class<?>[] paramTypes;
	
	public ExecutionOperation(String name, Object value, Class<?> type, Class<?>... paramTypes) {
		super(name, type, value);
		this.paramTypes = paramTypes;
	}


}
