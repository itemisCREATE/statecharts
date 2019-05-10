/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Package

class CppNamespaceGenerator {

	def namespaceStart(Object it) {
		if (!namespace.nullOrEmpty) {
			'''namespace «namespace» {'''
		}
	}

	def namespaceEnd(Object it) {
		if (!namespace.nullOrEmpty) {
			'''}'''
		}
	}

	def dispatch String namespace(Object it) {
		null
	}

	def dispatch String namespace(ArrayList<?> list) {
		val head = list.head
		if (head instanceof EObject) {
			val package = EcoreUtil.getRootContainer(head) as Package
			val namespace = package.name
			if (namespace !== "default") {
				return namespace
			}
		}
		return null
	}
}
