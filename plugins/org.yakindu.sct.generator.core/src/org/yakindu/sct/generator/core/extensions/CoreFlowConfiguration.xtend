package org.yakindu.sct.generator.core.extensions

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sexec.transformation.config.DefaultFlowConfiguration
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper

@Singleton
class CoreFlowConfiguration extends DefaultFlowConfiguration {
	
	@Inject GeneratorEntry entry
	@Inject extension ICoreLibraryHelper 
	
	override takeConfigurationfromStatechart(Statechart sc) {
		super.takeConfigurationfromStatechart(sc)
		
		_applyOutgoingEventBuffer = entry.outEventGettersUsed		
	}
}