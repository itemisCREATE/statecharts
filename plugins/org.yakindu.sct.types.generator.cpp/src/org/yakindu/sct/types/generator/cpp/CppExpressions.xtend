/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.c.CExpressions

class CppExpressions extends CExpressions {

	override dispatch String code(Void it) {
		null
	}

	override dispatch String code(Property it) {
		if (it.type !== null && ITypeSystem.ARRAY.equals(it.type.name)) {
			return super._code(it)
		}
		'''«IF static»static «ENDIF»«IF const»const «ENDIF»«typeSpecifier.code» «name»«IF initialValue !== null» = «initialValue.code»«ENDIF»«terminator»'''
	}

	override protected argumentCall(ArgumentExpression it, EObject reference) {
		if (reference !== null) {
			if (reference instanceof Property) {
				if (reference.getAnnotationOfType("PointerEleRef") !== null) {
					if (!(eContainer instanceof FeatureCall)) {
						return '''&«((reference as NamedElement).name)»'''
					}
				}
			}
		}
		return super.argumentCall(it, reference)
	}

	def access(Property it) {
		var namespaces = newArrayList
		var cT = it.eContainer
		while (cT instanceof ComplexType) {
			namespaces.add(0, cT.name.toFirstUpper)
			cT = cT.eContainer
		}
		return namespaces.join("", "::", "::", [it.toString])
	}

	override dispatch String code(FeatureCall it) {
		if (feature instanceof Property) {
			val prop = feature as Property
			if (prop.static) {
				return '''«prop.access»«prop.name»'''
			}
		}
		if (!(it.feature instanceof Property)) {
			if (featureOrReference instanceof Enumerator) {
				return '''«feature.code»'''
			} else {
				val accessor = {
					if (isFeatureOnComplexTypePointer) {
						"->"
					} else {
						"."
					}
				}
				return '''«it.owner.code»«accessor»«it.argumentCall(feature)»«FOR arrSel : arraySelector»[«arrSel.code»]«ENDFOR»'''
			}
		}
		return super._code(it)

	}

	def opCode(FeatureCall it, Operation target) {
		val accessor = {
			if (isFeatureOnComplexTypePointer) {
				"->"
			} else {
				"."
			}
		}
		'''«it.owner.code»«accessor»«target.name»(«FOR p : target.parameters SEPARATOR ', '»«ENDFOR»)'''
	}

}
