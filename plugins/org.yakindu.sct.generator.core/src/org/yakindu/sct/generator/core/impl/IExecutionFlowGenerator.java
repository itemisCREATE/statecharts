package org.yakindu.sct.generator.core.impl;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public interface IExecutionFlowGenerator {

	abstract void generate(ExecutionFlow flow, GeneratorEntry entry);
}
