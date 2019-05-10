/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.types.generator.java

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.Expressions
import org.yakindu.sct.types.generator.java.modifications.ConstructorBuilder
import org.yakindu.sct.types.generator.modification.library.ContainmentExtensions

class JavaExpressions extends Expressions {
	
	@Inject protected extension ConstructorBuilder
	@Inject protected extension ContainmentExtensions
	
	override dispatch String code(Property it) {
		return if (type.isArray) {
			array
		} else
			'''«IF static»static«ENDIF»«typeSpecifier.code» «name»«IF initialValue !== null»= «initialValue.code»«ENDIF»«terminator»'''
	}
	
	def array(Property it) {
		'''
			«IF static»static«ENDIF»«arrayType.name»[] «name»«IF initialValue !== null» = new «arrayType.name»[«initialValue.size»]«ENDIF»«terminator»
		'''.toString
	}

	def protected arrayType(Property it) {
		typeSpecifier.typeArguments.head.type
	}

	def dispatch size(FeatureCall it) '''«arguments.head.value.code»'''

	def dispatch size(Expression it) '''0'''

	override dispatch String code(FeatureCall it) {
		if (isConstructorCall) {
			'''new «it.owner.code»«argumentList(feature as Operation)»'''
		} else {
			'''«it.owner.code».«it.argumentCall(feature)»'''
		}
	}

	override dispatch code(TypeSpecifier it) {
		if(ITypeSystem.ARRAY.equals(it.type.name)) it.typeArguments.head.type.name + '[]' else type.name
	}
	
	def dispatch String code(LogicalRelationExpression it) {
		switch(operator) {
			case SMALLER,
			case SMALLER_EQUAL,
			case GREATER, 
			case GREATER_EQUAL: {
				
				var leftSide = '''«leftOperand.code.toString.trim»'''
				if (leftOperand.infer.type instanceof EnumerationType) leftSide += '''.ordinal()'''
				
				var rightSide = '''«rightOperand.code»'''
				if (rightOperand.infer.type instanceof EnumerationType) rightSide += '''.ordinal()'''
				
				return '''(«leftSide» «operator.literal.toString.trim» «rightSide»)'''
			}
				
			default:
				return super._code(it)
		}
	}
	
	override protected argumentCall(ArgumentExpression it, EObject reference){
		if (reference instanceof Property && 
			reference.eContainer instanceof ComplexType && 
			it.containedIn(reference.eContainer)
		) {
			return '''this.'''+super.argumentCall(it,reference)
		}
		return super.argumentCall(it,reference)
	}
	
}
