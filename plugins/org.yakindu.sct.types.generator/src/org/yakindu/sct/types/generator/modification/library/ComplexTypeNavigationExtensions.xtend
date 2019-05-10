/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.modification.library

import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.Visibility

class ComplexTypeNavigationExtensions {
		
	def allComplexTypes(ComplexType ct) {
		ct.eAllContents.filter(ComplexType).toList
	}
	
	def complexTypes(ComplexType ct) {
		ct.features.filter(ComplexType).toList
	}
	
	def publicProperties(ComplexType ct) {
		ct.features.filter(Property).filter[visibility == Visibility.PUBLIC]
	}
	
	def properties(ComplexType ct) {
		ct.features.filter(Property)
	}
	
	def operations(ComplexType ct) {
		ct.features.filter(Operation)
	}
	
}
