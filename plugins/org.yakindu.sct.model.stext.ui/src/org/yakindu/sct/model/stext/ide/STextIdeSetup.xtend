/*
 * (c) by committers of YAKINDU */
package org.yakindu.sct.model.stext.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.yakindu.sct.model.stext.STextRuntimeModule
import org.yakindu.sct.model.stext.STextStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class STextIdeSetup extends STextStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new STextRuntimeModule, new STextIdeModule))
	}
	
}
