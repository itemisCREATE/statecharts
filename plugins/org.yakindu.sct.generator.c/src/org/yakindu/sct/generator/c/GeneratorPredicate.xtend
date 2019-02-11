package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.GenmodelEntries

class GeneratorPredicate extends org.yakindu.sct.generator.core.extensions.GeneratorPredicate {
	@Inject protected GenmodelEntries entries
		
	override useInEventQueue() {
		entries.getInEventQueueUsed(entry)
	}
	
}