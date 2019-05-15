package org.yakindu.sct.generator.csharp.eventdriven

import org.yakindu.sct.generator.core.extensions.GeneratorPredicate

class EventDrivenPredicate extends GeneratorPredicate{
	override useInEventQueue() {
		false
	}
}