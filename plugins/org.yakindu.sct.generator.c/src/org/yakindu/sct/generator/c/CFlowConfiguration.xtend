package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.core.extensions.CoreFlowConfiguration
import org.yakindu.sct.model.sgraph.Statechart
import com.google.inject.Singleton

@Singleton
class CFlowConfiguration extends CoreFlowConfiguration {
	
	@Inject protected GeneratorPredicate gp

	override takeConfigurationfromStatechart(Statechart sc) {
		super.takeConfigurationfromStatechart(sc)
		
		_applyIncomingEventQueue = gp.useInEventQueue		
	}
	
}