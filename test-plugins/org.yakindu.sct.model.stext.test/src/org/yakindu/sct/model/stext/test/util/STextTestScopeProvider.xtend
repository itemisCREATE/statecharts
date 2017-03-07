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

import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.scoping.STextScopeProvider
import com.google.common.collect.Lists
import com.google.inject.Inject
import org.yakindu.base.types.Package

/** 
 * @author andreas muelder - Initial contribution and API
 */
class STextTestScopeProvider extends STextScopeProvider { 
	static final SGraphFactory sgraphfactory = SGraphFactory.eINSTANCE
	@Inject IQualifiedNameProvider qfnProvider
	@Inject ITypeSystem typeSystem
	protected ComplexType cmplxParamType
	
	protected TypesFactory factory = TypesFactory.eINSTANCE;

	override IScope getScope(EObject context, EReference reference) {
		var IScope parentScope = super.getScope(context, reference)
		var List<IEObjectDescription> descriptions = Lists.newArrayList(parentScope.getAllElements())
		var State dummyState = createDummyModel()
		descriptions.add(createEObjectDesc(dummyState))
		var ComplexType complexType = createComplexType()
		descriptions.add(createEObjectDesc(complexType))
		var Type enumType = createEnumType()
		descriptions.add(createEObjectDesc(enumType))
		for (Declaration feature : complexType.getFeatures()) {
			descriptions.add(createEObjectDesc(feature))
		}
		cmplxParamType = createComplexParameterizedType()
		descriptions.add(createEObjectDesc(cmplxParamType))
		for (Declaration feature : cmplxParamType.getFeatures()) {
			descriptions.add(createEObjectDesc(feature))
		}
		
		val simpleTemplate = createPackageWithTemplateFunction()
		addToIndex(descriptions, simpleTemplate)
		addToIndex(descriptions, simpleTemplate.member.head)
		
		val nestedTemplate = createPackageWithNestedComplexTypeFunction()
		addToIndex(descriptions, nestedTemplate)
		addToIndex(descriptions, nestedTemplate.member.head)
		
		val nestedNestedTemplate = createPackageWithNestedNestedComplexTypeFunction()
		addToIndex(descriptions, nestedNestedTemplate)
		addToIndex(descriptions, nestedNestedTemplate.member.head)
		
		return new SimpleScope(descriptions)
	}
	
	def protected void addToIndex(List<IEObjectDescription> descriptions, EObject element) {
		descriptions.add(createEObjectDesc(element));
		if (element instanceof ComplexType) {
			for (Declaration feature : (element as ComplexType).getFeatures()) {
				descriptions.add(createEObjectDesc(feature));
			}
		}
	}

	def protected IEObjectDescription createEObjectDesc(EObject object) {
		return new EObjectDescription(qfnProvider.getFullyQualifiedName(object), object, new HashMap<String, String>())
	}

	def protected State createDummyModel() {
		var Statechart statechart = sgraphfactory.createStatechart()
		statechart.setName("chart")
		var Region region = sgraphfactory.createRegion()
		region.setName("r1")
		statechart.getRegions().add(region)
		var State state = sgraphfactory.createState()
		state.setName("A")
		region.getVertices().add(state)
		return state
	}

	def protected ComplexType createComplexType() {
		var ComplexType complexType = TypesFactory.eINSTANCE.createComplexType()
		complexType.setName("ComplexType")
		var Property featureX = TypesFactory.eINSTANCE.createProperty()
		featureX.setName("x")
		var TypeSpecifier typeSpec = TypesFactory.eINSTANCE.createTypeSpecifier()
		typeSpec.setType(typeSystem.getType(GenericTypeSystem.INTEGER))
		featureX.setTypeSpecifier(typeSpec)
		complexType.getFeatures().add(featureX)
		var Resource resource = new ResourceImpl(URI.createURI("types2"))
		resource.getContents().add(complexType)
		return complexType
	}

	def protected EnumerationType createEnumType() {
		var EnumerationType enumType = TypesFactory.eINSTANCE.createEnumerationType()
		enumType.setName("EnumType")
		enumType.getEnumerator().add(createEnumerator("A"))
		enumType.getEnumerator().add(createEnumerator("B"))
		enumType.getEnumerator().add(createEnumerator("C"))
		var Resource resource = new ResourceImpl(URI.createURI("types2"))
		resource.getContents().add(enumType)
		return enumType
	}

	def protected Enumerator createEnumerator(String name) {
		var Enumerator enumerator = TypesFactory.eINSTANCE.createEnumerator()
		enumerator.setName(name)
		return enumerator
	}

	/** 
	 * ComplexParameterizedType<T1,T2> {
	 * T1 prop1;
	 * T2 prop2;
	 * T1 op(T1 param1, T2 param2);
	 * }
	 * @return
	 */
	def protected ComplexType createComplexParameterizedType() {
		var ComplexType complexType = TypesFactory.eINSTANCE.createComplexType()
		complexType.setName("ComplexParameterizedType")
		var TypeParameter typeParam1 = TypesFactory.eINSTANCE.createTypeParameter()
		typeParam1.setName("T1")
		complexType.getTypeParameters().add(typeParam1)
		var TypeParameter typeParam2 = TypesFactory.eINSTANCE.createTypeParameter()
		typeParam2.setName("T2")
		complexType.getTypeParameters().add(typeParam2)
		var Property prop1 = TypesFactory.eINSTANCE.createProperty()
		prop1.setName("prop1")
		var TypeSpecifier prop1typeSpec = TypesFactory.eINSTANCE.createTypeSpecifier()
		prop1typeSpec.setType(typeParam1)
		prop1.setTypeSpecifier(prop1typeSpec)
		complexType.getFeatures().add(prop1)
		var Property prop2 = TypesFactory.eINSTANCE.createProperty()
		prop2.setName("prop2")
		var TypeSpecifier prop2typeSpec = TypesFactory.eINSTANCE.createTypeSpecifier()
		prop2typeSpec.setType(typeParam2)
		prop2.setTypeSpecifier(prop2typeSpec)
		complexType.getFeatures().add(prop2)
		var Operation operation = TypesFactory.eINSTANCE.createOperation()
		operation.setName("op")
		var TypeSpecifier returnTypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier()
		returnTypeSpec.setType(typeParam1)
		operation.setTypeSpecifier(returnTypeSpec)
		var Parameter opParam1 = TypesFactory.eINSTANCE.createParameter()
		opParam1.setName("param1")
		var TypeSpecifier param1TypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier()
		param1TypeSpec.setType(typeParam1)
		opParam1.setTypeSpecifier(param1TypeSpec)
		operation.getParameters().add(opParam1)
		var Parameter opParam2 = TypesFactory.eINSTANCE.createParameter()
		opParam2.setName("param2")
		var TypeSpecifier param2TypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier()
		param2TypeSpec.setType(typeParam2)
		opParam2.setTypeSpecifier(param2TypeSpec)
		operation.getParameters().add(opParam2)
		complexType.getFeatures().add(operation)
		var Resource resource = new ResourceImpl(URI.createURI("types2"))
		resource.getContents().add(complexType)
		return complexType
	}
	
	/*
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
				op.typeParameters += factory.createTypeParameter => [
					name = "T"
				]
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = factory.createTypeSpecifier => [
						type = op.typeParameters.head
					]
				]
				op.parameters += factory.createParameter => [
					name = "b"
					typeSpecifier = factory.createTypeSpecifier => [
						type = op.typeParameters.head
					]
				]
				op.typeSpecifier = factory.createTypeSpecifier => [
					type = op.typeParameters.head
				]
			]
		]
	}
	
		/*
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
				op.typeParameters += factory.createTypeParameter => [
					name = "T"
				]
				op.typeParameters += factory.createTypeParameter => [
					name = "T2"
				]
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = factory.createTypeSpecifier => [
						type = cmplxParamType
						typeArguments += factory.createTypeSpecifier => [
							type = op.typeParameters.get(0)
						]
						typeArguments += factory.createTypeSpecifier => [
							type = op.typeParameters.get(1)
						]
					]
				]
				op.typeSpecifier = factory.createTypeSpecifier => [
					type = op.typeParameters.get(1)
				]
			]
		]
	}
	
	/*
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
				op.typeParameters += factory.createTypeParameter => [
					name = "T"
				]
				op.parameters += factory.createParameter => [
					name = "a"
					typeSpecifier = factory.createTypeSpecifier => [
						type = cmplxParamType
						typeArguments += factory.createTypeSpecifier => [
							type = cmplxParamType
							typeArguments += factory.createTypeSpecifier => [
								type = typeSystem.getType(GenericTypeSystem.BOOLEAN) 
							]
							typeArguments += factory.createTypeSpecifier => [
								type = op.typeParameters.head
							]
						]
						typeArguments += factory.createTypeSpecifier => [
							type = typeSystem.getType(GenericTypeSystem.INTEGER)
						]
					]
				]
				op.typeSpecifier = factory.createTypeSpecifier => [
					type = op.typeParameters.head
				]
			]
		]
	}
	
	def Package createRootPackage(String filename) {
		TypesFactory.eINSTANCE.createPackage => [
			it.name = filename
		]
	}
}
