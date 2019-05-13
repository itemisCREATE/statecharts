/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionsHelper
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.generator.cpp.CppSlangTypeValueProvider
import org.yakindu.sct.types.generator.cpp.naming.CppClassNaming
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.types.generator.cpp.annotation.CoreCppGeneratorAnnotationLibrary

class ConstructorModification implements IModification {
	@Inject protected extension CTypeSystem cts
	@Inject protected extension ExpressionsHelper
	@Inject protected extension ExpressionBuilder
	@Inject protected extension CppSlangTypeValueProvider
	@Inject protected extension CppClassNaming
	@Inject protected extension CoreCppGeneratorAnnotationLibrary

	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	@Inject protected extension TypeBuilder

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package it) {
		val outerClass = (member.head as ComplexType)
		eAllContents.filter(ComplexType).filter[!(it instanceof EnumerationType)].toList.forEach [ cT |
			if (cT.eContainer instanceof Package) {
				// create constructor and destructor
				cT.features += cT.createOperation(defaultConstructorAnnotation, null)
				cT.features += cT.createOperation(defaultDestructorAnnotation, null)
			} else {
				// create constructor only with initialization list, if not abstract
				if(cT.features.filter(OperationDefinition).nullOrEmpty) {
					val parameter = createParentParameter(outerClass)
					cT.features += cT.createOperation(innerConstructorAnnotation, parameter)
					cT.features += outerClass.createParentProperty
				}

			}
		]
		return it
	}

	protected def Property createParentProperty(ComplexType outerClass) {
		typesFactory.createProperty => [ prop |
			prop.visibility = Visibility.PROTECTED
			prop.typeSpecifier = outerClass.createPointerType
			prop.name = parentParameter
		]
	}

	def protected createParentParameter(ComplexType cT) {
		typesFactory.createParameter => [
			it.name = "parent"
			typeSpecifier = typesFactory.createTypeSpecifier => [ ts |
				ts.type = cts.getType(CTypeSystem.POINTER)
				ts.typeArguments += cT.typeSpecifier
			]
		]
	}

	def protected createPointerType(ComplexType cT) {
		typesFactory.createTypeSpecifier => [ ts |
			ts.type = cts.getType(CTypeSystem.POINTER)
			ts.typeArguments += cT.typeSpecifier
		]
	}

	def createOperation(ComplexType cT, AnnotationType annotationType, Parameter param) {
		val privateVariables = EcoreUtil.copyAll(cT.features.filter(Property).filter [
			visibility == Visibility.PROTECTED && const == false
		].toList)
		privateVariables.forEach [ prop |
			if (prop.initialValue === null) {
				prop.initialValue = prop.type.defaultValue.value
			}
		]

		typesFactory.createOperation => [ op |
			op.name = cT.name
			op._annotateWith(annotationType)
			if (!op.isDefaultDestructor) {
				op.body = _block => [
					expressions += privateVariables
				]
			}
			if (param !== null) {
				op.parameters += param
			}
		]
	}

}
