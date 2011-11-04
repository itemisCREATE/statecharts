package org.yakindu.sct.generator.java;

import org.yakindu.sct.generator.base.AbstractSCTGenerator;
import org.yakindu.sct.model.sgen.GeneratorModel;

public class JavaSCTGenerator extends AbstractSCTGenerator<GeneratorModel> {

	private static final String GENMODEL_EXTENSION = "javagen";

	@Override
	public void generate(GeneratorModel genmodel) {
		System.out.println("------------------------");
		System.out.println("JavaSCTGenerator.generate() " + genmodel);
		System.out.println("------------------------");
	}

}
