package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

public class CCodeGenerator2 extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart flow, GeneratorEntry entry) {
		CSCTGenerator delegate = getInjector(entry).getInstance(CSCTGenerator.class);		
		delegate.generate(createExecutionFlow(flow, entry), entry, getFileSystemAccess(entry));
	}

	
}
