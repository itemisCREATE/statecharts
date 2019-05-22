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
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionsHelper
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Constructor
import org.yakindu.base.types.EnumerationType
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

class ConstructorModification implements IModification {
	@Inject protected extension CTypeSystem cts
	@Inject protected extension ExpressionsHelper
	@Inject protected extension ExpressionBuilder
	@Inject protected extension CppSlangTypeValueProvider
	@Inject protected extension CppClassNaming
	@Inject protected extension CoreCppGeneratorAnnotationLibrary
	@Inject protected extension TypeBuilder

	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	protected ExpressionsFactory expFactory = ExpressionsFactory.eINSTANCE

	override modify(Collection<Package> packages) {
		packages.map[eAllContents.toList].flatten.filter(ComplexType).filter[!(it instanceof EnumerationType)].forEach[
			modify
		]
		packages.map[eAllContents.toList].flatten.filter(ElementReferenceExpression).filter[reference instanceof Constructor].forEach[
			updateConstructorCall
		]
		packages
	}
	
	def updateConstructorCall(ElementReferenceExpression ctorCall) {
		val ctor = ctorCall.reference as Constructor
		val args = ctorCall.arguments
		val params = ctor.parameters
		params.forEach[param, index | 
			if (index >= args.size()) {
				args.add(argument(ctorCall, param))
			}
		]
	}
	
	def argument(ElementReferenceExpression call, Parameter parameter) {
		if(parameter.isPointer) {
			val ts = parameter.pointsTo
			val callOwner = EcoreUtil2.getContainerOfType(call, ComplexType) {
				if(ts.type == callOwner) {
					expFactory.createArgument => [
						value = callOwner.thisProperty._ref
					]
				}
			}
		}
	}
	
	def Property create _variable("this", cT) thisProperty(ComplexType cT) {
		cT.features += it
		_annotateWith(invisibleAnnotation)
	}

	def modify(ComplexType cT) {
		val constructors = cT.features.filter(Constructor).toList
		val container = cT.eContainer
		if (container instanceof Package) {
			// create constructor and destructor
			constructors.forEach[createInitializer]
			cT.createDestructor
		} else if(container instanceof ComplexType) {
			// create constructor only with initialization list, if not abstract
			cT.createParentProperty
			val parameter = createParentParameter(cT)
			constructors.forEach[createInitializer(parameter)]

		}
	}

	protected def createInitializer(Constructor ctor, Parameter... parameters) {
		val cT = ctor.eContainer
		if (cT instanceof ComplexType) {
			
			if(!parameters.nullOrEmpty) {
				ctor.parameters += parameters
			}
			if (cT.eContainer instanceof Package) {
				ctor._annotateWith(defaultConstructorAnnotation)
			} else {
				ctor._annotateWith(innerConstructorAnnotation)
			}
			val variables = cT.features.filter(Property).filter [ feature |
				feature.const == false || (feature.const == true && feature.static == false)
			].toList
			val properties = EcoreUtil.copyAll(variables)
			properties.forEach [ prop |
				prop.initialValue = prop.initialValue?: {
					val param = ctor.parameters.findFirst[ p | p.name == prop.name]
					if(param !== null) {
						param._ref
					} else {
						prop.type.defaultValue.value
					}
				}
				if (prop.initialValue === null) {
					prop.initialValue = prop.type.defaultValue.value
				}
			]
			ctor.body = _block => [
					expressions += properties
				]
		}
	}

	protected def createParentProperty(ComplexType it) {
		val outerType = eContainer
		if(outerType instanceof ComplexType) {
			features += typesFactory.createProperty => [ prop |
				prop.visibility = Visibility.PROTECTED
				prop.typeSpecifier = outerType.createPointerType
				prop.name = parentParameter
			]
		}
	}

	def protected createParentParameter(ComplexType it) {
		val outerType = eContainer
		if(outerType instanceof ComplexType) {
			return typesFactory.createParameter => [
				it.name = "parent"
				typeSpecifier = typesFactory.createTypeSpecifier => [ ts |
						ts.type = cts.getType(CTypeSystem.POINTER)
						ts.typeArguments += outerType.typeSpecifier
				]
			]
		}
	}

	def protected createPointerType(ComplexType cT) {
		typesFactory.createTypeSpecifier => [ ts |
			ts.type = cts.getType(CTypeSystem.POINTER)
			ts.typeArguments += cT.typeSpecifier
		]
	}

	def createDestructor(ComplexType it) {
		it.features += typesFactory.createOperation => [ op |
			op.name = "~" + it.name
			op._annotateWith(defaultDestructorAnnotation)
			op._annotateWith(virtualAnnotation)
			op.body = _block => [
				
			]
			_annotateWith(virtualAnnotation)
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
