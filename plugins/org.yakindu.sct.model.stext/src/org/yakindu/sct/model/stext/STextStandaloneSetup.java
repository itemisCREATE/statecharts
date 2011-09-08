
package org.yakindu.sct.model.stext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class STextStandaloneSetup extends STextStandaloneSetupGenerated{

	public static void doSetup() {
		new STextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
}

