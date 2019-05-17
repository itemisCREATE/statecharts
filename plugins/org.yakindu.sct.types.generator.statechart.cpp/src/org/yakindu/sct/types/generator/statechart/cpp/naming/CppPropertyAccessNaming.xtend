/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.statechart.cpp.naming

import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.statechart.naming.IPropertyAccessNaming

class CppPropertyAccessNaming implements IPropertyAccessNaming {

	override nameReadAccess(Property prop) {
		"get_" + prop.name
	}

	override nameWriteAccess(Property prop) {
		"set_" + prop.name
	}

	override nameAssign(Property prop) {
		"assign_" + prop.name
	}

}
