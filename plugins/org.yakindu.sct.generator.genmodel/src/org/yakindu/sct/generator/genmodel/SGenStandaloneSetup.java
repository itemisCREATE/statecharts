
package org.yakindu.sct.generator.genmodel;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SGenStandaloneSetup extends SGenStandaloneSetupGenerated{

	public static void doSetup() {
		new SGenStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

