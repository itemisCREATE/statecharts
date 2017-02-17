/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test.util;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.scoping.STextScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextTestScopeProvider extends STextScopeProvider {

	private static final SGraphFactory factory = SGraphFactory.eINSTANCE;

	@Inject
	private IQualifiedNameProvider qfnProvider;

	@Inject
	private ITypeSystem typeSystem;

	public IScope getScope(EObject context, EReference reference) {
		IScope parentScope = super.getScope(context, reference);

		List<IEObjectDescription> descriptions = Lists.newArrayList(parentScope.getAllElements());

		State dummyState = createDummyModel();
		descriptions.add(createEObjectDesc(dummyState));

		ComplexType complexType = createComplexType();
		descriptions.add(createEObjectDesc(complexType));
		
		Type enumType = createEnumType();
		descriptions.add(createEObjectDesc(enumType));

		for (Declaration feature : complexType.getFeatures()) {
			descriptions.add(createEObjectDesc(feature));
		}
		
		ComplexType cmplxParamType = createComplexParameterizedType();
		descriptions.add(createEObjectDesc(cmplxParamType));
		
		for (Declaration feature : cmplxParamType.getFeatures()) {
			descriptions.add(createEObjectDesc(feature));
		}
		
		return new SimpleScope(descriptions);
	}

	protected IEObjectDescription createEObjectDesc(EObject object) {
		return new EObjectDescription(qfnProvider.getFullyQualifiedName(object), object, new HashMap<String, String>());
	}

	protected State createDummyModel() {
		Statechart statechart = factory.createStatechart();
		statechart.setName("chart");
		Region region = factory.createRegion();
		region.setName("r1");
		statechart.getRegions().add(region);
		State state = factory.createState();
		state.setName("A");
		region.getVertices().add(state);
		return state;
	}

	protected ComplexType createComplexType() {
		ComplexType complexType = TypesFactory.eINSTANCE.createComplexType();
		complexType.setName("ComplexType");

		Property featureX = TypesFactory.eINSTANCE.createProperty();
		featureX.setName("x");
		TypeSpecifier typeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		typeSpec.setType(typeSystem.getType(GenericTypeSystem.INTEGER));
		featureX.setTypeSpecifier(typeSpec);
		complexType.getFeatures().add(featureX);

		Resource resource = new ResourceImpl(URI.createURI("types2"));
		resource.getContents().add(complexType);

		return complexType;
	}
	
	protected EnumerationType createEnumType() {
		EnumerationType enumType = TypesFactory.eINSTANCE.createEnumerationType();
		enumType.setName("EnumType");
		
		enumType.getEnumerator().add(createEnumerator("A"));
		enumType.getEnumerator().add(createEnumerator("B"));
		enumType.getEnumerator().add(createEnumerator("C"));
		
		Resource resource = new ResourceImpl(URI.createURI("types2"));
		resource.getContents().add(enumType);
		
		return enumType;
	}
	
	protected Enumerator createEnumerator(String name) {
		Enumerator enumerator = TypesFactory.eINSTANCE.createEnumerator();
		enumerator.setName(name);
		return enumerator;
	}
	
	/**
	 * ComplexParameterizedType<T1,T2> {
	 * 		T1 prop1;
	 * 		T2 prop2;
	 * 		T1 op(T1 param1, T2 param2);
	 * }
	 * @return
	 */
	protected ComplexType createComplexParameterizedType() {
		ComplexType complexType = TypesFactory.eINSTANCE.createComplexType();
		complexType.setName("ComplexParameterizedType");
		
		TypeParameter typeParam1 = TypesFactory.eINSTANCE.createTypeParameter();
		typeParam1.setName("T1");
		complexType.getTypeParameters().add(typeParam1);
		TypeParameter typeParam2 = TypesFactory.eINSTANCE.createTypeParameter();
		typeParam2.setName("T2");
		complexType.getTypeParameters().add(typeParam2);

		Property prop1 = TypesFactory.eINSTANCE.createProperty();
		prop1.setName("prop1");
		TypeSpecifier prop1typeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		prop1typeSpec.setType(typeParam1);
		prop1.setTypeSpecifier(prop1typeSpec);
		complexType.getFeatures().add(prop1);
		
		Property prop2 = TypesFactory.eINSTANCE.createProperty();
		prop2.setName("prop2");
		TypeSpecifier prop2typeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		prop2typeSpec.setType(typeParam2);
		prop2.setTypeSpecifier(prop2typeSpec);
		complexType.getFeatures().add(prop2);
		
		Operation operation = TypesFactory.eINSTANCE.createOperation();
		operation.setName("op");
		TypeSpecifier returnTypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		returnTypeSpec.setType(typeParam1);
		operation.setTypeSpecifier(returnTypeSpec);

		Parameter opParam1 = TypesFactory.eINSTANCE.createParameter();
		opParam1.setName("param1");
		TypeSpecifier param1TypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		param1TypeSpec.setType(typeParam1);
		opParam1.setTypeSpecifier(param1TypeSpec);
		operation.getParameters().add(opParam1);
		
		Parameter opParam2 = TypesFactory.eINSTANCE.createParameter();
		opParam2.setName("param2");
		TypeSpecifier param2TypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		param2TypeSpec.setType(typeParam2);
		opParam2.setTypeSpecifier(param2TypeSpec);
		operation.getParameters().add(opParam2);
		
		complexType.getFeatures().add(operation);

		Resource resource = new ResourceImpl(URI.createURI("types2"));
		resource.getContents().add(complexType);

		return complexType;
	}

}
