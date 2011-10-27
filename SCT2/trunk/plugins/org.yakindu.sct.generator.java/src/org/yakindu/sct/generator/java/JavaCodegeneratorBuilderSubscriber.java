package org.yakindu.sct.generator.java;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.yakindu.sct.generator.base.util.AbstractXpandCodeGeneratorSubscriber;

public class JavaCodegeneratorBuilderSubscriber extends AbstractXpandCodeGeneratorSubscriber{

	@Override
	public String getTemplatePath() {
		return "org::yakindu::sct::generator::java::templates::Main::main";
	}

	@Override
	public String getOutletPath(IResource resource) {
		return "src-gen" + File.separator
				+ resource.getName().replaceAll(" ", "");
	}

}
