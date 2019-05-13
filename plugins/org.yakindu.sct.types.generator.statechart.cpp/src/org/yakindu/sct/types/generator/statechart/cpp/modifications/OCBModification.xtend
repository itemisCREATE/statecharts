/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.statechart.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionsHelper
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.generator.cpp.annotation.CoreCppGeneratorAnnotationLibrary
import org.yakindu.sct.types.generator.cpp.modifications.ConstructorModification
import org.yakindu.sct.types.generator.modification.library.ReferenceExtension
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class OCBModification implements IModification {
	@Inject protected extension TypeBuilder
	@Inject protected extension ITypeSystem
	@Inject protected extension CTypeSystem cts
	@Inject protected extension ExpressionsHelper
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ReferenceExtension
	extension TypesFactory factory = TypesFactory.eINSTANCE
	@Inject protected extension CoreCppGeneratorAnnotationLibrary
	@Inject protected extension SCTGeneratorAnnotationLibrary
	@Inject protected extension ConstructorModification

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val outerClass = p.member.head as ComplexType
		val ocbClasses = newArrayList
		val ocbSetters = newArrayList
		outerClass.features.filter(ComplexType).filter[!(it instanceof EnumerationType)].toList.forEach [ cT |
			val operationDefinitions = cT.features.filter(OperationDefinition).toList
			if (!operationDefinitions.nullOrEmpty) {
				ocbClasses += createComplexType => [ iface |
					iface._annotateWith(interfaceGroupAnnotation)
					iface.name = cT.name + "_OCB"
					val prop = iface.createOCBVariable
					outerClass.features += prop
					operationDefinitions.forEach [ operationDef |
						operationDef.visibility = Visibility.PUBLIC
						operationDef.references.forEach[qualifyWithFc(prop)]
						operationDef._annotateWith(virtualAnnotation)
					]
					iface.features += iface.createOperation(ocbDestructorAnnotation, null)
					iface.features += operationDefinitions
					ocbSetters += iface.createOCBSetter(prop)
				]
			}
		]
		outerClass.features += ocbClasses
		outerClass.features += ocbSetters
		return p
	}

	def protected createOCBSetter(ComplexType cT, Property prop) {
		_op("set" + cT.name, ITypeSystem.VOID)._param("operationCallback", cT.createPointerType) => [
			body = _block(
				prop._ref._assign(parameters.head._ref)
			)
		]
	}

	def protected createOCBVariable(ComplexType type) {
		createProperty => [ prop |
			prop.name = "iface" + type.name
			prop.typeSpecifier = type.createPointerType
			prop.visibility = Visibility.PROTECTED
		]
	}

	def protected createPointerType(ComplexType cT) {
		createTypeSpecifier => [ ts |
			ts.type = cts.getType(CTypeSystem.POINTER)
			ts.typeArguments += cT.typeSpecifier
		]
	}

	def dispatch qualifyWithFc(EObject oldRef, Declaration owner) {
		throw new IllegalStateException("Could not qualify reference " + oldRef)
	}

	/**
	 * Transforms a reference expression b into a feature call owner.b
	 */
	def dispatch qualifyWithFc(ElementReferenceExpression oldRef, Declaration owner) {
		val newRef = owner._ref._fc(oldRef.reference as Declaration)._with(oldRef.arguments.map[it.value])
		EcoreUtil.replace(oldRef, newRef)
	}

	/**
	 * Transforms a feature call, A.b into A.owner.b
	 */
	def dispatch qualifyWithFc(FeatureCall oldFc, Declaration owner) {
		val newFc = owner._ref._fc(oldFc.feature)._with(oldFc.arguments.map[it.value])
		EcoreUtil.replace(oldFc, newFc)
	}

}
