package org.yakindu.sct.types.generator.c.naming

import org.yakindu.sct.types.generator.statechart.core.naming.IEventNaming

class CEventNaming implements IEventNaming {
	override String nameEventRaiser(CharSequence s) {
		return '''raise_«s»'''
	}

	override String nameEventRaised(CharSequence s) {
		return '''«s»_raised'''
	}

	override String nameEventIsRaised(CharSequence s) {
		return '''«s»isRaised'''
	}
	
	override nameEventValue(CharSequence s) {
		return '''«s»_value'''
	}
	
	override nameEventValueGetter(CharSequence s) {
		return '''get_«s»_value'''
	}
}
