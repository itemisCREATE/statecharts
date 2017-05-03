/** 
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.test.util

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.util.TypesTestFactory
import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.scoping.STextScopeProvider

import static org.yakindu.base.types.typesystem.ITypeSystem.*

/** 
 * @author andreas muelder - Initial contribution and API
 */
class STextTestScopeProvider extends STextScopeProvider {
	
	@Inject 
	protected IQualifiedNameProvider qfnProvider
	@Inject
	protected DefaultResourceDescriptionStrategy descriptionStrategy
	@Inject
	protected extension TypesTestFactory = TypesTestFactory.INSTANCE
	protected extension SGraphFactory sgraphfactory = SGraphFactory.eINSTANCE
	protected extension TypesFactory factory = TypesFactory.eINSTANCE;
	
	protected ComplexType cmplxParamType

	override IScope getScope(EObject context, EReference reference) {
		var IScope parentScope = super.getScope(context, reference)
		var List<IEObjectDescription> descriptions = Lists.newArrayList(parentScope.getAllElements())
		
		addToIndex(descriptions, createDummyModel)
		addToIndex(descriptions, createComplexType)
		addToIndex(descriptions, createEnumType)
		cmplxParamType = createComplexParameterizedType()
		addToIndex(descriptions, cmplxParamType)
		addToIndex(descriptions, createParameterizedMethodOwner)
		
		val simpleTemplate = createPackageWithTemplateFunction()
		addToIndex(descriptions, simpleTemplate)
		addToIndex(descriptions, simpleTemplate.member.head)
		
		val intTemplate = createPackageWithTemplateFunctionInt()
		addToIndex(descriptions, intTemplate)
		addToIndex(descriptions, intTemplate.member.head)

		val boolTemplate = createPackageWithTemplateFunctionBool()
		addToIndex(descriptions, boolTemplate)
		addToIndex(descriptions, boolTemplate.member.head)
		
		val mixedTemplate = createPackageWithTemplateFunctionTwoParams()
		addToIndex(descriptions, mixedTemplate)
		addToIndex(descriptions, mixedTemplate.member.head)
		
		val cptTemplate = createComplexParameterizedTypeTemplateTest()
		addToIndex(descriptions, cptTemplate)
		addToIndex(descriptions, cptTemplate.member.head)
		
		
		val nestedTemplate = createPackageWithNestedComplexTypeFunction()
		addToIndex(descriptions, nestedTemplate)
		addToIndex(descriptions, nestedTemplate.member.head)
		
		val nestedNestedTemplate = createPackageWithNestedNestedComplexTypeFunction()
		addToIndex(descriptions, nestedNestedTemplate)
		addToIndex(descriptions, nestedNestedTemplate.member.head)
		
		return new SimpleScope(descriptions)
	}
	
	def protected void addToIndex(List<IEObjectDescription> descriptions, EObject element) {
		descriptionStrategy.createEObjectDescriptions(element, [descriptions+=it])
		if (element instanceof ComplexType) {
			for (Declaration feature : element.features) {
				descriptionStrategy.createEObjectDescriptions(element, [descriptions+=it])
			}
		}
	}

	def protected State createDummyModel() {
		val stateA = createState => [
			name = "A"
		]
		createStatechart => [
			name = "chart"
			regions += createRegion => [
				name = "r1"
				vertices += stateA
			]
		]
		stateA
	}

	def protected ComplexType createComplexType() {
		val complexType = factory.createComplexType => [
			name = "ComplexType"
			features += createProperty("x", INTEGER)
		]
		complexType.addToResource
		complexType
	}

	def protected EnumerationType createEnumType() {
		val enumType = createEnumerationType => [
			name = "EnumType"
			enumerator += createEnumerator("A")
			enumerator += createEnumerator("B")
			enumerator += createEnumerator("C")
		]
		enumType.addToResource
		enumType
	}
	
	// TODO: check if needed to add into resource
	def protected addToResource(EObject element) {
		val resource = new ResourceImpl(URI.createURI("types2"))
		resource.contents += element
	}

	/** 
	 * ComplexParameterizedType&lt;T1,T2&gt; {
	 * <ul>
	 * <li>T1 prop1;
	 * <li>T2 prop2;
	 * <li>ComplexParameterizedType&lt;T2,T1&gt; prop3;
	 * <li>T1 op(T1 param1, T2 param2);
	 * <li>T2 op2();
	 * </ul>
	 * }
	 * @return
	 */
	def protected ComplexType createComplexParameterizedType() {
		val complexType = createComplexType => [ct |
			ct.name = "ComplexParameterizedType"
			ct.typeParameters += createTypeParameter("T1")
			ct.typeParameters += createTypeParameter("T2")
			ct.features += createProperty("prop1", ct.typeParameters.get(0))
			ct.features += createProperty("prop2", ct.typeParameters.get(1))
			ct.features += createProperty("prop3", ct.toTypeSpecifier => [
				typeArguments+=ct.typeParameters.get(1).toTypeSpecifier
				typeArguments+=ct.typeParameters.get(0).toTypeSpecifier
			])
			ct.features += createOperation => [op |
				op.name = "op"
				op.typeSpecifier = ct.typeParameters.get(0).toTypeSpecifier
				op.parameters += createParameter("param1", ct.typeParameters.get(0).toTypeSpecifier)
				op.parameters += createParameter("param2", ct.typeParameters.get(1).toTypeSpecifier)
			]
			ct.features += createOperation => [op |
				op.name = "op2"
				op.typeSpecifier = ct.typeParameters.get(1).toTypeSpecifier
			]
		]
		complexType.addToResource
		complexType
	}
	
	/**
	 * ParameterizedMethodOwner {
	 * 	T1 genericOp<T1, T2>(T1 p1, T2 p1);
	 * }
	 */
	def protected ComplexType createParameterizedMethodOwner() {
		val complexType = createComplexType => [ct |
	 		ct.name = "ParameterizedMethodOwner"
	 		ct.features += createOperation => [op |
	 			op.name = "genericOp"
	 			op.typeParameters += createTypeParameter("T1")
	 			op.typeParameters += createTypeParameter("T2")
	 			op.typeSpecifier = op.typeParameters.get(0).toTypeSpecifier
	 			op.parameters += createParameter("p1", op.typeParameters.get(0).toTypeSpecifier)
	 			op.parameters += createParameter("p2", op.typeParameters.get(1).toTypeSpecifier)
	 		]
	 	]
		complexType
	}
	
	/**
	 * Returns a model of the following function:
	 * 
	 * template <typename T>
	 * T genericOp(T a, T b) {
	 * 		return a > b ? a : b;
	 * }
	 */
	def Package createPackageWithTemplateFunction() {
		createRootPackage("simpleTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "genericOp"
				op.typeParameters += createTypeParameter("T")
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = op.typeParameters.head.toTypeSpecifier
				]
				op.parameters += factory.createParameter => [
					name = "b"
					typeSpecifier = op.typeParameters.head.toTypeSpecifier
				]
				op.typeSpecifier = op.typeParameters.head.toTypeSpecifier
			]
		]
	}
	
	/**
	 * Returns a model of the following function:
	 * 
	 * template <typename T>
	 * int intGenericOp(T a, T b) {
	 * 		return a > b ? a : b;
	 * }
	 */
	def Package createPackageWithTemplateFunctionInt() {
		createRootPackage("intTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "intGenericOp"
				op.typeParameters += createTypeParameter("T")
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = op.typeParameters.head.toTypeSpecifier
				]
				op.parameters += factory.createParameter => [
					name = "b"
					typeSpecifier = op.typeParameters.head.toTypeSpecifier
				]
				op.typeSpecifier = factory.createTypeSpecifier => [
					type = ts.getType(INTEGER)
				]
			]
		]
	}
	
	/**
	 * Returns a model of the following function:
	 * 
	 * template <typename T>
	 * T boolGenericOp(T a, T b, bool c) {
	 * 		if(c) return a > b ? a : b;
	 * 		return a < b ? a : b;
	 * }
	 */
	def Package createPackageWithTemplateFunctionBool() {
		createRootPackage("boolTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "boolGenericOp"
				op.typeParameters += createTypeParameter("T")
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = op.typeParameters.head.toTypeSpecifier
				]
				op.parameters += factory.createParameter => [
					name = "b"
					typeSpecifier = op.typeParameters.head.toTypeSpecifier
				]
				op.parameters += factory.createParameter => [
					name = "c"
					typeSpecifier = BOOLEAN.toTypeSpecifier
				]
				op.typeSpecifier = op.typeParameters.head.toTypeSpecifier
			]
		]
	}
	
	/**
	 * Returns a model of the following function:
	 * 
	 * template <typename T, typename T2>
	 * T2 mixedGenericOp(T a, T2 b, bool c) {
	 * 		if(c) return a > b ? a : b;
	 * 		return a < b ? a : b;
	 * }
	 */
	def Package createPackageWithTemplateFunctionTwoParams() {
		createRootPackage("mixedTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "mixedGenericOp"
				op.typeParameters += createTypeParameter("T")
				op.typeParameters += createTypeParameter("T2")
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = op.typeParameters.get(0).toTypeSpecifier
				]
				op.parameters += factory.createParameter => [
					name = "b"
					typeSpecifier = op.typeParameters.get(1).toTypeSpecifier
				]
				op.parameters += factory.createParameter => [
					name = "c"
					typeSpecifier = BOOLEAN.toTypeSpecifier
				]
				op.typeSpecifier = op.typeParameters.get(1).toTypeSpecifier
			]
		]
	}
	
	/**
	 * Returns a model of the following function:
	 * 
	 * template <typename T, typename T2>
	 * T2 nestedOp(ComplexParameterizedType<T, T2> a) {
	 * 		return a.prop1.prop2;
	 * }
	 */
	def Package createPackageWithNestedComplexTypeFunction() {
		createRootPackage("nestedTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "nestedOp"
				op.typeParameters += createTypeParameter("T")
				op.typeParameters += createTypeParameter("T2")
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = cmplxParamType.toTypeSpecifier => [
						typeArguments += op.typeParameters.get(0).toTypeSpecifier
						typeArguments += op.typeParameters.get(1).toTypeSpecifier
					]
				]
				op.typeSpecifier = op.typeParameters.get(1).toTypeSpecifier
			]
		]
	}
	
	/**
	 * Returns a model of the following function:
	 * 
	 * template <typename T>
	 * T nestedNestedReturn(ComplexParameterizedType<ComplexParameterizedType<boolean, T>, integer> a) {
	 * 		return a.prop1.prop2;
	 * }
	 */
	def Package createPackageWithNestedNestedComplexTypeFunction() {
		createRootPackage("nestedNestedTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "nestedNestedOp"
				op.typeParameters += createTypeParameter("T")
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = cmplxParamType.toTypeSpecifier => [
						typeArguments += cmplxParamType.toTypeSpecifier => [
							typeArguments += BOOLEAN.toTypeSpecifier
							typeArguments += op.typeParameters.head.toTypeSpecifier
						]
						typeArguments += INTEGER.toTypeSpecifier
					]
				]
				op.typeSpecifier = op.typeParameters.head.toTypeSpecifier
			]
		]
	}
	


	/**
	 * Returns a model of the following function:
	 * 
	 * template<typename T, typename T2>
	 * T getProp(ComplexParameterizedType<T,T2> cpt) {
	 * 	   return ctp.prop1;
	 * }
	 */
	def createComplexParameterizedTypeTemplateTest() { 
		createRootPackage("cptTemplate") => [ types |
			types.member += factory.createOperation => [ op |
				op.name = "getProp"
				op.typeParameters += createTypeParameter("T")
				op.typeParameters += createTypeParameter("T2")
				
				op.parameters += factory.createParameter => [
					name = "cpt"
					typeSpecifier = factory.createTypeSpecifier => [
						type = cmplxParamType
						typeArguments += op.typeParameters.get(0).toTypeSpecifier
						typeArguments += op.typeParameters.get(1).toTypeSpecifier
					]
				]
				op.typeSpecifier = op.typeParameters.head.toTypeSpecifier
			]
		]
	}

}
