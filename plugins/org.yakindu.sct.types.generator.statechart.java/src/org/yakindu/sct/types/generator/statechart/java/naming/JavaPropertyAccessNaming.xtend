/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.java.naming

import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.statechart.naming.IPropertyAccessNaming

class JavaPropertyAccessNaming implements IPropertyAccessNaming {
	
	override nameReadAccess(Property prop) {
		"get" + prop.name.toFirstUpper
	}
	
	override nameWriteAccess(Property prop) {
		"set" + prop.name.toFirstUpper
	}
	
	override nameAssign(Property prop) {
		"assign" + prop.name.toFirstUpper
	}
	
}
