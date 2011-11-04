
package org.yakindu.sct.generator.model.base;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BaseGenStandaloneSetup extends BaseGenStandaloneSetupGenerated{

	public static void doSetup() {
		new BaseGenStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

