package org.yakindu.sct.generator.c;

import static org.yakindu.sct.generator.core.util.GeneratorUtils.isDumpSexec;

import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

public class CCodeGenerator extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart statechart, GeneratorEntry entry) {
		CSCTGenerator delegate = getInjector(entry).getInstance(CSCTGenerator.class);
		
		ExecutionFlow flow = createExecutionFlow(statechart, entry);
		
		if (isDumpSexec(entry)) {
			dumpSexec(entry, flow);
		}
		delegate.generate(flow, entry, getFileSystemAccess(entry));
	}
}
