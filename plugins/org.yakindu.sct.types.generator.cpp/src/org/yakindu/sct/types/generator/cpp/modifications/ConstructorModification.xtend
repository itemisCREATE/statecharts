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
import org.yakindu.base.types.Constructor
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.generator.cpp.CppSlangTypeValueProvider
import org.yakindu.sct.types.generator.cpp.annotation.CoreCppGeneratorAnnotationLibrary
import org.yakindu.sct.types.generator.cpp.naming.CppClassNaming
import org.yakindu.sct.types.modification.IModification
import org.yakindu.base.types.EnumerationType

class ConstructorModification implements IModification {
	@Inject protected extension CTypeSystem cts
	@Inject protected extension ExpressionsHelper
	@Inject protected extension ExpressionBuilder
	@Inject protected extension CppSlangTypeValueProvider
	@Inject protected extension CppClassNaming
	@Inject protected extension CoreCppGeneratorAnnotationLibrary
	@Inject protected extension TypeBuilder

	protected TypesFactory typesFactory = TypesFactory.eINSTANCE

	override modify(Collection<Package> packages) {
		packages.map[eAllContents.toList].flatten.filter(ComplexType).filter[!(it instanceof EnumerationType)].forEach[modify]
		packages
	}

	def modify(ComplexType cT) {
		val constructors = cT.features.filter(Constructor).toList
		val container = cT.eContainer
		if (container instanceof Package) {
			// create constructor and destructor
			if (constructors.empty) {
				cT.features += cT.createOperation(defaultConstructorAnnotation, null)
			} else {
				constructors.forEach[modify]
			}
			cT.features += cT.createOperation(defaultDestructorAnnotation, null)
		} else if(container instanceof ComplexType) {
			// create constructor only with initialization list, if not abstract
			cT.features += container.createParentProperty
			val parameter = createParentParameter(container)
			if (constructors.empty) {
				cT.features += cT.createOperation(innerConstructorAnnotation, parameter)
			} else {
				constructors.forEach[modify(parameter)]
			}

		}
	}

	protected def modify(Constructor ctor, Parameter... parameters) {
		val cT = ctor.eContainer
		if (cT instanceof ComplexType) {

			ctor.parameters += parameters
			if (cT.eContainer instanceof Package) {
				ctor._annotateWith(defaultConstructorAnnotation)
			} else {
				ctor._annotateWith(innerConstructorAnnotation)
			}
			
			val variables = EcoreUtil.copyAll(cT.features.filter(Property).filter [ feature |
				feature.const == false || (feature.const == true && feature.static == false)
			].toList)
			variables.forEach [ prop |
				prop.initialValue = {
					if(prop.initialValue !== null) {
						prop.initialValue
					} else {
						val param = ctor.parameters.findFirst[ p | p.name == prop.name]
						if(param !== null) {
							param._ref
						} else {
							prop.type.defaultValue.value
						}
					}
				}
				if (prop.initialValue === null) {
					prop.initialValue = prop.type.defaultValue.value
				}
			]
			ctor.body = _block => [
					expressions += variables
				]
		}
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
