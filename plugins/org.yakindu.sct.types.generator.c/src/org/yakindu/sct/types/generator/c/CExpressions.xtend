/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c

import javax.inject.Inject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.Expressions
import org.yakindu.sct.types.generator.c.extensions.PointerExtensions
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary

class CExpressions extends Expressions {

	@Inject protected extension PointerExtensions
	@Inject protected extension CoreCGeneratorAnnotationLibrary

	val ts = CTypeSystem.instance

	override dispatch String code(Property it) {
		return if (it.type !== null && ITypeSystem.ARRAY.equals(it.type.name)) {
			array
		} else if(isDefine) {
			'''#define «name» «initialValue.code»'''
		} else
			super._code(it).toString
	}

	def array(Property it) {
		'''
			«IF static»static«ENDIF»«typeSpecifier.typeArguments.head.type.name» «name»[«IF initialValue !== null»«initialValue.size»«ENDIF»]«terminator»
		'''.toString
	}

	def dispatch size(Expression it) '''0'''

	def dispatch size(FeatureCall it) '''«arguments.head.value.code»'''

	override dispatch code(TypeSpecifier typeSpecifier) {
		if (ts.isSame(typeSpecifier.type, ts.getType(CTypeSystem.POINTER))) {
			return '''«typeSpecifier.typeArguments.head.type.name»*'''

		}
		return super._code(typeSpecifier)
	}

	override dispatch String code(FeatureCall it) {
		if (!(it.feature instanceof Property)) {
			return super._code(it)
		}
		val target = it.feature as Property
		if (ts.isExtensionProperty(target)) {
			switch (target.name) {
				case CTypeSystem.POINTER_PROPERTY:
					return '''&(«it.owner.code»)'''
			}
		}

		if (isValueOnPointer) {
			return '''(*(«it.owner.code»))'''
		}
		propertyCode(target).toString
	}

	def propertyCode(FeatureCall it, Property target) {
		val owner = it.owner
		if (owner instanceof FeatureCall) {
			if (owner.isValueOnPointer) {
				return '''(«it.owner.code»).«target.name»«FOR arrSel : arraySelector»[«arrSel.code»]«ENDFOR»'''
			}
		}
		val accessor = {
			if (isFeatureOnComplexTypePointer) {
				"->"
			} else {
				"."
			}
		}
		'''«it.owner.code»«accessor»«target.name»«FOR arrSel : arraySelector»[«arrSel.code»]«ENDFOR»'''
	}

	def protected isValueOnPointer(FeatureCall call) {
		return ts.isSame(call.owner.infer.type, ts.getType(CTypeSystem.POINTER)) &&
			call.definition.name == CTypeSystem.VALUE_PROPERTY
	}

	def protected isFeatureOnComplexTypePointer(FeatureCall call) {
		val owner = call.owner
		if (owner instanceof ElementReferenceExpression) {
			val ref = owner.reference
			if (ref instanceof TypedElement) {
				return ref.pointerTarget?.type instanceof ComplexType
			}
		}
		false
	}

	def dispatch definition(ElementReferenceExpression it) {
		if(reference instanceof Declaration) reference as Declaration
	}

	def dispatch definition(FeatureCall it) {
		feature
	}

	def dispatch definition(Expression it) {
		null
	}
	
	override dispatch String code(StringLiteral it) 
		'''(sc_string)"«value.escaped»"'''

}
