package org.yakindu.sct.generator.c.subscriber;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.yakindu.sct.generator.base.util.AbstractXpandCodeGeneratorSubscriber;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CCodeGeneratorSubscriber extends
		AbstractXpandCodeGeneratorSubscriber {

	@Override
	public String getTemplatePath() {
		return "org::yakindu::sct::generator::c::templates::Main::main";
	}

	@Override
	public String getOutletPath(IResource resource) {
		return "src-gen-c" + File.separator
				+ resource.getName().replaceAll(" ", "");
	}

}
