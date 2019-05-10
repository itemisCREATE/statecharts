/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.cpp.naming.CppClassNaming

class CppConstructorGenerator {
	@Inject extension CppExpressions
	@Inject extension CppTypesGenerator
	@Inject protected extension CppClassNaming

	def protected generateConstructor(Operation it) {
		if (isDefaultConstructor) {
			if (!isStatic) {
				return '''«access»«it.name»(«FOR p : parameters SEPARATOR ', '»«p.typeSpecifier.code» «p.name»«ENDFOR»)«IF body !== null» : «it.body.initializationList»«ENDIF»{}'''
			} else {
				return '''«it.name»(«FOR p : parameters SEPARATOR ', '»«p.typeSpecifier.code» «p.name»«ENDFOR»);'''
			}
		} else if (isDefaultDestructor) {
			if (!isStatic) {
				return '''«access»~«it.name»(){}'''
			} else {
				return '''~«it.name»();'''
			}
		} else if (isInnerConstructor) {
			'''«it.name»(«FOR p : parameters SEPARATOR ', '»«p.typeSpecifier.code» «p.name»«ENDFOR»)«IF body !== null» : «it.body.initializationList»«IF !(it.body.initializationList.toString.isEmpty)», «ENDIF»«parentParameter»(«parentParameter»)«ENDIF»{}'''
		} else if (isOCBDestructor) {
			return '''virtual ~«it.name»(){}'''
		}
	}

	def isOCBDestructor(Operation it) {
		return getAnnotationOfType("OCBDeconstructor") !== null
	}

	def protected isConstructorOrDeconstructor(Operation it) {
		return isDefaultConstructor || isDefaultDestructor || isInnerConstructor || isOCBDestructor
	}

	def dispatch protected getInitializationList(BlockExpression it) {
		val propExpressions = expressions.filter(Property)
		'''«FOR property : propExpressions SEPARATOR ','»
		«property.name»«IF (property.type !== null && ITypeSystem.ARRAY.equals(property.type.name))»{/*TODO*/}«ELSE»(«initialCode(property)»)«ENDIF»
		«ENDFOR»'''
	}

	def dispatch protected getInitializationList(Expression it) {
		'''Cannot create initialization list for: «it»'''
	}

	def protected String initialCode(Property property) {
		property.initialValue.code ?: getThis
	}

	def isDefaultConstructor(Operation it) {
		getAnnotationOfType(defaultConstructor) !== null
	}

	def isDefaultDestructor(Operation it) {
		getAnnotationOfType(defaultDestructor) !== null
	}

	def isInnerConstructor(Operation it) {
		getAnnotationOfType(innerConstructor) !== null
	}

}
