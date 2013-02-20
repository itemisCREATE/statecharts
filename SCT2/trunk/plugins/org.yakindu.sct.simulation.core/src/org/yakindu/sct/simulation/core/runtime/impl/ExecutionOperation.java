package org.yakindu.sct.simulation.core.runtime.impl;

import org.yakindu.base.types.ITypeSystem.InferredType;

public class ExecutionOperation extends AbstractSlot {

	protected InferredType[] paramTypes;
	
	public ExecutionOperation(String name, Object value, InferredType type, InferredType... paramTypes) {
		super(name, type, value);
		this.paramTypes = paramTypes;
	}


}
