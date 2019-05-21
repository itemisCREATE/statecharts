/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp.naming

import org.yakindu.sct.types.generator.naming.IEventNaming

class CppEventNaming implements IEventNaming {

	override String nameEventRaiser(CharSequence s) {
		return '''raise_«s.toString.toFirstLower»'''
	}

	override String nameEventRaised(CharSequence s) {
		return '''«s.toString.toFirstLower»_raised'''
	}

	override String nameEventIsRaised(CharSequence s) {
		return '''isRaised_«s.toString.toFirstLower»'''
	}

	override nameEventValue(CharSequence s) {
		return '''«s.toString.toFirstLower»_value'''
	}

	override nameEventValueGetter(CharSequence s) {
		return '''get_«s.toString.toFirstLower»_value'''
	}
}
