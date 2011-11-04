
package org.yakindu.sct.generator.model.java;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class JavaGenStandaloneSetup extends JavaGenStandaloneSetupGenerated{

	public static void doSetup() {
		new JavaGenStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

