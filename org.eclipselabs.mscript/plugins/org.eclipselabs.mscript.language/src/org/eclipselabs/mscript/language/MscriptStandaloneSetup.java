
package org.eclipselabs.mscript.language;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MscriptStandaloneSetup extends MscriptStandaloneSetupGenerated{

	public static void doSetup() {
		new MscriptStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

