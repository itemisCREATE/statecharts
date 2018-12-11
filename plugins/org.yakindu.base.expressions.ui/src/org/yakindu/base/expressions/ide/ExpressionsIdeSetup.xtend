/*
 * (c) by committers of YAKINDU */
package org.yakindu.base.expressions.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.yakindu.base.expressions.ExpressionsRuntimeModule
import org.yakindu.base.expressions.ExpressionsStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class ExpressionsIdeSetup extends ExpressionsStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new ExpressionsRuntimeModule, new ExpressionsIdeModule))
	}
	
}
