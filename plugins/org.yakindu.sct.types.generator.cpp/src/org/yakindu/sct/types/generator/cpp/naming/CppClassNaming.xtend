/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp.naming

class CppClassNaming {
	def getDefaultConstructor() {
		"DefaultConstructor"
	}

	def getDefaultDestructor() {
		"DefaultDestructor"
	}

	def getInnerConstructor() {
		"InnerDestructor"
	}

	def getParentParameter() {
		"parent"
	}

	def getThis() {
		"this"
	}
}
