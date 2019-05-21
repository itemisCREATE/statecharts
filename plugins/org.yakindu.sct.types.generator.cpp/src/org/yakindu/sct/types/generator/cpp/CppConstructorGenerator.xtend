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
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Constructor
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.c.CLiterals
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.generator.cpp.annotation.CoreCppGeneratorAnnotationLibrary
import org.yakindu.sct.types.generator.cpp.naming.CppClassNaming

class CppConstructorGenerator {
	@Inject extension CppExpressions
	@Inject extension CppTypesGenerator
	@Inject protected extension CppClassNaming
	@Inject protected extension CLiterals
	@Inject protected extension CoreCppGeneratorAnnotationLibrary
	
	val ts = CTypeSystem.instance

	def generateConstructor(Operation it) {
		if(isConstructor) {
			doGenerateConstructor
		} else if(isDeconstructor) {
			doGenerateDestructor
		}
	}
	
	def protected doGenerateConstructor(Operation it) {
		if (isDefaultConstructor) {
			if (!isStatic) {
				return '''«access»«constructorName»«generateParameters»«body.initializationList»{}'''
			} else {
				return '''«constructorName»«generateParameters»;'''
			}
		} else if (isInnerConstructor) {
			'''«constructorName»«generateParameters»«body.initializationList»{}'''
		} 
	}
	
	def protected doGenerateDestructor(Operation it) {
		if (isDefaultDestructor) {
			if (!isStatic) {
				return '''virtual «access»«constructorName»(){}'''
			} else {
				return '''virtual «constructorName»();'''
			}
		} else if (isOcbDestructor) {
			return '''virtual «constructorName»(){}'''
		}
	}

	def isConstructorOrDeconstructor(Operation it) {
		return isConstructor || isDeconstructor
	}
	
	def protected isConstructor(Operation it) {
		return (it instanceof Constructor) || isDefaultConstructor || defaultDestructor
	}
	
	def protected isDeconstructor(Operation it) {
		return isDefaultDestructor || isOcbDestructor
	}

	def dispatch protected getInitializationList(BlockExpression it) {
		if(it === null) {
			""
		} else {
			val propExpressions = expressions.filter(Property)
			
			// The "\t" was the only way to get the correct indentation.
			'''
			 :
			«FOR property : propExpressions SEPARATOR ','»
			«"\t"»«property.name»(«initialCode(property)»)
			«ENDFOR»
			'''
		}
	}

	def dispatch protected getInitializationList(Expression it) {
		'''Cannot create initialization list for: «it»'''
	}

	def protected String initialCode(Property property) {
		if(property.initialValue === null) {
			if (ts.isSame(property.typeSpecifier.type, ts.getType(CTypeSystem.POINTER))) {
				return NULL_LITERAL
			}
			if( ts.getType(ITypeSystem.ARRAY) == property.type.name) {
				return ""
			}
			return "this"
		}
		property.initialValue.code ?: getThis
	}
	
	def protected String constructorName(Operation it) {
		val cT = eContainer
		if(cT instanceof ComplexType) {
			if((it instanceof Constructor) || isDefaultConstructor || isInnerConstructor) {
				return cT.name
			}
			if(isDefaultDestructor || isOcbDestructor) {
				return "~" + cT.name
			}
		}
	}

}
