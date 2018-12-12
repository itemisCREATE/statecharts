/*
 * (c) by committers of YAKINDU */
package org.yakindu.sct.model.stext.ide

import com.google.inject.Guice
import org.yakindu.sct.model.stext.STextRuntimeModule
import org.yakindu.sct.model.stext.STextStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class STextIdeSetup extends STextStandaloneSetup {

	override createInjector() {
		Guice.createInjector(new STextRuntimeModule)
	}
	
}
