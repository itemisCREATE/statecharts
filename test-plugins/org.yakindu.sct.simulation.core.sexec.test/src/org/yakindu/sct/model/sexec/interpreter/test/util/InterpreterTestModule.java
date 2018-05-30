package org.yakindu.sct.model.sexec.interpreter.test.util;

import org.yakindu.base.expressions.interpreter.IOperationMockup;
import org.yakindu.sct.domain.generic.simulation.GenericSimulationModule;
import org.yakindu.sct.simulation.core.sexec.interpreter.DefaultOperationMockup;

public class InterpreterTestModule extends GenericSimulationModule{
	
	@Override
	public Class<? extends IOperationMockup> bindIOperationMockup() {
		return DefaultOperationMockup.class;
	}
}
