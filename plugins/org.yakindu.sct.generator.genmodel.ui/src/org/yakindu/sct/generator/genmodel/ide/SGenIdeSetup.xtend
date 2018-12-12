/*
 * (c) by committers of YAKINDU */
package org.yakindu.sct.generator.genmodel.ide

import com.google.inject.Guice
import org.yakindu.sct.generator.genmodel.SGenRuntimeModule
import org.yakindu.sct.generator.genmodel.SGenStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class SGenIdeSetup extends SGenStandaloneSetup {

	override createInjector() {
		Guice.createInjector(new SGenRuntimeModule)
	}
	
}
