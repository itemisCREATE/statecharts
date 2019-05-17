/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.java.naming

import org.yakindu.sct.types.generator.statechart.naming.IEventNaming

class JavaEventNaming implements IEventNaming {
	
	override nameEventRaised(CharSequence s) {
		s + "Raised"
	}
	
	override nameEventRaiser(CharSequence s) {
		"raise" + s.toString.toFirstUpper
	}
	
	override nameEventIsRaised(CharSequence s) {
		"isRaised"+s.toString.toFirstUpper
	}
	
	override nameEventValue(CharSequence s) {
		return '''«s»Value'''
	}
	
	override nameEventValueGetter(CharSequence s) {
		return '''get«s»Value'''
	}
	
}
