/*
 * (c) by committers of YAKINDU */
package org.yakindu.base.expressions.ide

import com.google.inject.Guice
import org.yakindu.base.expressions.ExpressionsRuntimeModule
import org.yakindu.base.expressions.ExpressionsStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class ExpressionsIdeSetup extends ExpressionsStandaloneSetup {

	override createInjector() {
		Guice.createInjector(new ExpressionsRuntimeModule)
	}
	
}
