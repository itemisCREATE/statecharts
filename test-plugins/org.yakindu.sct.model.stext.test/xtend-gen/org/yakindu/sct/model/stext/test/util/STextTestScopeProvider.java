/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.test.util;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.scoping.STextScopeProvider;
import org.yakindu.sct.model.stext.test.util.TypesTestFactory;

/**
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class STextTestScopeProvider extends STextScopeProvider {
  @Inject
  protected IQualifiedNameProvider qfnProvider;
  
  @Inject
  protected DefaultResourceDescriptionStrategy descriptionStrategy;
  
  @Inject
  @Extension
  protected TypesTestFactory _typesTestFactory = TypesTestFactory.INSTANCE;
  
  @Extension
  protected SGraphFactory sgraphfactory = SGraphFactory.eINSTANCE;
  
  @Extension
  protected TypesFactory factory = TypesFactory.eINSTANCE;
  
  protected ComplexType cmplxParamType;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope parentScope = super.getScope(context, reference);
    Iterable<IEObjectDescription> _allElements = parentScope.getAllElements();
    List<IEObjectDescription> descriptions = Lists.<IEObjectDescription>newArrayList(_allElements);
    State _createDummyModel = this.createDummyModel();
    this.addToIndex(descriptions, _createDummyModel);
    ComplexType _createComplexType = this.createComplexType();
    this.addToIndex(descriptions, _createComplexType);
    EnumerationType _createEnumType = this.createEnumType();
    this.addToIndex(descriptions, _createEnumType);
    ComplexType _createComplexParameterizedType = this.createComplexParameterizedType();
    this.cmplxParamType = _createComplexParameterizedType;
    this.addToIndex(descriptions, this.cmplxParamType);
    ComplexType _createParameterizedMethodOwner = this.createParameterizedMethodOwner();
    this.addToIndex(descriptions, _createParameterizedMethodOwner);
    final org.yakindu.base.types.Package simpleTemplate = this.createPackageWithTemplateFunction();
    this.addToIndex(descriptions, simpleTemplate);
    EList<PackageMember> _member = simpleTemplate.getMember();
    PackageMember _head = IterableExtensions.<PackageMember>head(_member);
    this.addToIndex(descriptions, _head);
    final org.yakindu.base.types.Package intTemplate = this.createPackageWithTemplateFunctionInt();
    this.addToIndex(descriptions, intTemplate);
    EList<PackageMember> _member_1 = intTemplate.getMember();
    PackageMember _head_1 = IterableExtensions.<PackageMember>head(_member_1);
    this.addToIndex(descriptions, _head_1);
    final org.yakindu.base.types.Package boolTemplate = this.createPackageWithTemplateFunctionBool();
    this.addToIndex(descriptions, boolTemplate);
    EList<PackageMember> _member_2 = boolTemplate.getMember();
    PackageMember _head_2 = IterableExtensions.<PackageMember>head(_member_2);
    this.addToIndex(descriptions, _head_2);
    final org.yakindu.base.types.Package mixedTemplate = this.createPackageWithTemplateFunctionTwoParams();
    this.addToIndex(descriptions, mixedTemplate);
    EList<PackageMember> _member_3 = mixedTemplate.getMember();
    PackageMember _head_3 = IterableExtensions.<PackageMember>head(_member_3);
    this.addToIndex(descriptions, _head_3);
    final org.yakindu.base.types.Package cptTemplate = this.createComplexParameterizedTypeTemplateTest();
    this.addToIndex(descriptions, cptTemplate);
    EList<PackageMember> _member_4 = cptTemplate.getMember();
    PackageMember _head_4 = IterableExtensions.<PackageMember>head(_member_4);
    this.addToIndex(descriptions, _head_4);
    final org.yakindu.base.types.Package nestedTemplate = this.createPackageWithNestedComplexTypeFunction();
    this.addToIndex(descriptions, nestedTemplate);
    EList<PackageMember> _member_5 = nestedTemplate.getMember();
    PackageMember _head_5 = IterableExtensions.<PackageMember>head(_member_5);
    this.addToIndex(descriptions, _head_5);
    final org.yakindu.base.types.Package nestedNestedTemplate = this.createPackageWithNestedNestedComplexTypeFunction();
    this.addToIndex(descriptions, nestedNestedTemplate);
    EList<PackageMember> _member_6 = nestedNestedTemplate.getMember();
    PackageMember _head_6 = IterableExtensions.<PackageMember>head(_member_6);
    this.addToIndex(descriptions, _head_6);
    return new SimpleScope(descriptions);
  }
  
  protected void addToIndex(final List<IEObjectDescription> descriptions, final EObject element) {
    final IAcceptor<IEObjectDescription> _function = new IAcceptor<IEObjectDescription>() {
      @Override
      public void accept(final IEObjectDescription it) {
        descriptions.add(it);
      }
    };
    this.descriptionStrategy.createEObjectDescriptions(element, _function);
    if ((element instanceof ComplexType)) {
      EList<Declaration> _features = ((ComplexType)element).getFeatures();
      for (final Declaration feature : _features) {
        final IAcceptor<IEObjectDescription> _function_1 = new IAcceptor<IEObjectDescription>() {
          @Override
          public void accept(final IEObjectDescription it) {
            descriptions.add(it);
          }
        };
        this.descriptionStrategy.createEObjectDescriptions(element, _function_1);
      }
    }
  }
  
  protected State createDummyModel() {
    State _xblockexpression = null;
    {
      State _createState = this.sgraphfactory.createState();
      final Procedure1<State> _function = new Procedure1<State>() {
        @Override
        public void apply(final State it) {
          it.setName("A");
        }
      };
      final State stateA = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
      Statechart _createStatechart = this.sgraphfactory.createStatechart();
      final Procedure1<Statechart> _function_1 = new Procedure1<Statechart>() {
        @Override
        public void apply(final Statechart it) {
          it.setName("chart");
          EList<Region> _regions = it.getRegions();
          Region _createRegion = STextTestScopeProvider.this.sgraphfactory.createRegion();
          final Procedure1<Region> _function = new Procedure1<Region>() {
            @Override
            public void apply(final Region it) {
              it.setName("r1");
              EList<Vertex> _vertices = it.getVertices();
              _vertices.add(stateA);
            }
          };
          Region _doubleArrow = ObjectExtensions.<Region>operator_doubleArrow(_createRegion, _function);
          _regions.add(_doubleArrow);
        }
      };
      ObjectExtensions.<Statechart>operator_doubleArrow(_createStatechart, _function_1);
      _xblockexpression = stateA;
    }
    return _xblockexpression;
  }
  
  protected ComplexType createComplexType() {
    ComplexType _xblockexpression = null;
    {
      ComplexType _createComplexType = this.factory.createComplexType();
      final Procedure1<ComplexType> _function = new Procedure1<ComplexType>() {
        @Override
        public void apply(final ComplexType it) {
          it.setName("ComplexType");
          EList<Declaration> _features = it.getFeatures();
          Property _createProperty = STextTestScopeProvider.this._typesTestFactory.createProperty("x", ITypeSystem.INTEGER);
          _features.add(_createProperty);
        }
      };
      final ComplexType complexType = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType, _function);
      this.addToResource(complexType);
      _xblockexpression = complexType;
    }
    return _xblockexpression;
  }
  
  protected EnumerationType createEnumType() {
    EnumerationType _xblockexpression = null;
    {
      EnumerationType _createEnumerationType = this.factory.createEnumerationType();
      final Procedure1<EnumerationType> _function = new Procedure1<EnumerationType>() {
        @Override
        public void apply(final EnumerationType it) {
          it.setName("EnumType");
          EList<Enumerator> _enumerator = it.getEnumerator();
          Enumerator _createEnumerator = STextTestScopeProvider.this._typesTestFactory.createEnumerator("A");
          _enumerator.add(_createEnumerator);
          EList<Enumerator> _enumerator_1 = it.getEnumerator();
          Enumerator _createEnumerator_1 = STextTestScopeProvider.this._typesTestFactory.createEnumerator("B");
          _enumerator_1.add(_createEnumerator_1);
          EList<Enumerator> _enumerator_2 = it.getEnumerator();
          Enumerator _createEnumerator_2 = STextTestScopeProvider.this._typesTestFactory.createEnumerator("C");
          _enumerator_2.add(_createEnumerator_2);
        }
      };
      final EnumerationType enumType = ObjectExtensions.<EnumerationType>operator_doubleArrow(_createEnumerationType, _function);
      this.addToResource(enumType);
      _xblockexpression = enumType;
    }
    return _xblockexpression;
  }
  
  protected boolean addToResource(final EObject element) {
    boolean _xblockexpression = false;
    {
      URI _createURI = URI.createURI("types2");
      final ResourceImpl resource = new ResourceImpl(_createURI);
      EList<EObject> _contents = resource.getContents();
      _xblockexpression = _contents.add(element);
    }
    return _xblockexpression;
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
  protected ComplexType createComplexParameterizedType() {
    ComplexType _xblockexpression = null;
    {
      ComplexType _createComplexType = this.createComplexType();
      final Procedure1<ComplexType> _function = new Procedure1<ComplexType>() {
        @Override
        public void apply(final ComplexType ct) {
          ct.setName("ComplexParameterizedType");
          EList<TypeParameter> _typeParameters = ct.getTypeParameters();
          TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T1");
          _typeParameters.add(_createTypeParameter);
          EList<TypeParameter> _typeParameters_1 = ct.getTypeParameters();
          TypeParameter _createTypeParameter_1 = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T2");
          _typeParameters_1.add(_createTypeParameter_1);
          EList<Declaration> _features = ct.getFeatures();
          EList<TypeParameter> _typeParameters_2 = ct.getTypeParameters();
          TypeParameter _get = _typeParameters_2.get(0);
          Property _createProperty = STextTestScopeProvider.this._typesTestFactory.createProperty("prop1", _get);
          _features.add(_createProperty);
          EList<Declaration> _features_1 = ct.getFeatures();
          EList<TypeParameter> _typeParameters_3 = ct.getTypeParameters();
          TypeParameter _get_1 = _typeParameters_3.get(1);
          Property _createProperty_1 = STextTestScopeProvider.this._typesTestFactory.createProperty("prop2", _get_1);
          _features_1.add(_createProperty_1);
          EList<Declaration> _features_2 = ct.getFeatures();
          TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(ct);
          final Procedure1<TypeSpecifier> _function = new Procedure1<TypeSpecifier>() {
            @Override
            public void apply(final TypeSpecifier it) {
              EList<TypeSpecifier> _typeArguments = it.getTypeArguments();
              EList<TypeParameter> _typeParameters = ct.getTypeParameters();
              TypeParameter _get = _typeParameters.get(1);
              TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
              _typeArguments.add(_typeSpecifier);
              EList<TypeSpecifier> _typeArguments_1 = it.getTypeArguments();
              EList<TypeParameter> _typeParameters_1 = ct.getTypeParameters();
              TypeParameter _get_1 = _typeParameters_1.get(0);
              TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_1);
              _typeArguments_1.add(_typeSpecifier_1);
            }
          };
          TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_typeSpecifier, _function);
          Property _createProperty_2 = STextTestScopeProvider.this._typesTestFactory.createProperty("prop3", _doubleArrow);
          _features_2.add(_createProperty_2);
          EList<Declaration> _features_3 = ct.getFeatures();
          Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
          final Procedure1<Operation> _function_1 = new Procedure1<Operation>() {
            @Override
            public void apply(final Operation op) {
              op.setName("op");
              EList<TypeParameter> _typeParameters = ct.getTypeParameters();
              TypeParameter _get = _typeParameters.get(0);
              TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
              op.setTypeSpecifier(_typeSpecifier);
              EList<Parameter> _parameters = op.getParameters();
              EList<TypeParameter> _typeParameters_1 = ct.getTypeParameters();
              TypeParameter _get_1 = _typeParameters_1.get(0);
              TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_1);
              Parameter _createParameter = STextTestScopeProvider.this._typesTestFactory.createParameter("param1", _typeSpecifier_1);
              _parameters.add(_createParameter);
              EList<Parameter> _parameters_1 = op.getParameters();
              EList<TypeParameter> _typeParameters_2 = ct.getTypeParameters();
              TypeParameter _get_2 = _typeParameters_2.get(1);
              TypeSpecifier _typeSpecifier_2 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_2);
              Parameter _createParameter_1 = STextTestScopeProvider.this._typesTestFactory.createParameter("param2", _typeSpecifier_2);
              _parameters_1.add(_createParameter_1);
            }
          };
          Operation _doubleArrow_1 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function_1);
          _features_3.add(_doubleArrow_1);
          EList<Declaration> _features_4 = ct.getFeatures();
          Operation _createOperation_1 = STextTestScopeProvider.this.factory.createOperation();
          final Procedure1<Operation> _function_2 = new Procedure1<Operation>() {
            @Override
            public void apply(final Operation op) {
              op.setName("op2");
              EList<TypeParameter> _typeParameters = ct.getTypeParameters();
              TypeParameter _get = _typeParameters.get(1);
              TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
              op.setTypeSpecifier(_typeSpecifier);
            }
          };
          Operation _doubleArrow_2 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_1, _function_2);
          _features_4.add(_doubleArrow_2);
        }
      };
      final ComplexType complexType = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType, _function);
      this.addToResource(complexType);
      _xblockexpression = complexType;
    }
    return _xblockexpression;
  }
  
  /**
   * ParameterizedMethodOwner {
   * 	T1 genericOp<T1, T2>(T1 p1, T2 p1);
   * }
   */
  protected ComplexType createParameterizedMethodOwner() {
    ComplexType _xblockexpression = null;
    {
      ComplexType _createComplexType = this.createComplexType();
      final Procedure1<ComplexType> _function = new Procedure1<ComplexType>() {
        @Override
        public void apply(final ComplexType ct) {
          ct.setName("ParameterizedMethodOwner");
          EList<Declaration> _features = ct.getFeatures();
          Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
          final Procedure1<Operation> _function = new Procedure1<Operation>() {
            @Override
            public void apply(final Operation op) {
              op.setName("genericOp");
              EList<TypeParameter> _typeParameters = op.getTypeParameters();
              TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T1");
              _typeParameters.add(_createTypeParameter);
              EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
              TypeParameter _createTypeParameter_1 = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T2");
              _typeParameters_1.add(_createTypeParameter_1);
              EList<TypeParameter> _typeParameters_2 = op.getTypeParameters();
              TypeParameter _get = _typeParameters_2.get(0);
              TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
              op.setTypeSpecifier(_typeSpecifier);
              EList<Parameter> _parameters = op.getParameters();
              EList<TypeParameter> _typeParameters_3 = op.getTypeParameters();
              TypeParameter _get_1 = _typeParameters_3.get(0);
              TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_1);
              Parameter _createParameter = STextTestScopeProvider.this._typesTestFactory.createParameter("p1", _typeSpecifier_1);
              _parameters.add(_createParameter);
              EList<Parameter> _parameters_1 = op.getParameters();
              EList<TypeParameter> _typeParameters_4 = op.getTypeParameters();
              TypeParameter _get_2 = _typeParameters_4.get(1);
              TypeSpecifier _typeSpecifier_2 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_2);
              Parameter _createParameter_1 = STextTestScopeProvider.this._typesTestFactory.createParameter("p2", _typeSpecifier_2);
              _parameters_1.add(_createParameter_1);
            }
          };
          Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
          _features.add(_doubleArrow);
        }
      };
      final ComplexType complexType = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType, _function);
      _xblockexpression = complexType;
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a model of the following function:
   * 
   * template <typename T>
   * T genericOp(T a, T b) {
   * 		return a > b ? a : b;
   * }
   */
  public org.yakindu.base.types.Package createPackageWithTemplateFunction() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("simpleTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("genericOp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("a");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<Parameter> _parameters_1 = op.getParameters();
            Parameter _createParameter_1 = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function_1 = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("b");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow_1 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter_1, _function_1);
            _parameters_1.add(_doubleArrow_1);
            EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
            TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters_1);
            TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
            op.setTypeSpecifier(_typeSpecifier);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
  }
  
  /**
   * Returns a model of the following function:
   * 
   * template <typename T>
   * int intGenericOp(T a, T b) {
   * 		return a > b ? a : b;
   * }
   */
  public org.yakindu.base.types.Package createPackageWithTemplateFunctionInt() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("intTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("intGenericOp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("a");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<Parameter> _parameters_1 = op.getParameters();
            Parameter _createParameter_1 = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function_1 = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("b");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow_1 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter_1, _function_1);
            _parameters_1.add(_doubleArrow_1);
            TypeSpecifier _createTypeSpecifier = STextTestScopeProvider.this.factory.createTypeSpecifier();
            final Procedure1<TypeSpecifier> _function_2 = new Procedure1<TypeSpecifier>() {
              @Override
              public void apply(final TypeSpecifier it) {
                Type _type = STextTestScopeProvider.this._typesTestFactory.ts.getType(ITypeSystem.INTEGER);
                it.setType(_type);
              }
            };
            TypeSpecifier _doubleArrow_2 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_2);
            op.setTypeSpecifier(_doubleArrow_2);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
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
  public org.yakindu.base.types.Package createPackageWithTemplateFunctionBool() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("boolTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("boolGenericOp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("a");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<Parameter> _parameters_1 = op.getParameters();
            Parameter _createParameter_1 = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function_1 = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("b");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow_1 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter_1, _function_1);
            _parameters_1.add(_doubleArrow_1);
            EList<Parameter> _parameters_2 = op.getParameters();
            Parameter _createParameter_2 = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function_2 = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("c");
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(ITypeSystem.BOOLEAN);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow_2 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter_2, _function_2);
            _parameters_2.add(_doubleArrow_2);
            EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
            TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters_1);
            TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
            op.setTypeSpecifier(_typeSpecifier);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
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
  public org.yakindu.base.types.Package createPackageWithTemplateFunctionTwoParams() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("mixedTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("mixedGenericOp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
            TypeParameter _createTypeParameter_1 = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T2");
            _typeParameters_1.add(_createTypeParameter_1);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("a");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _get = _typeParameters.get(0);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<Parameter> _parameters_1 = op.getParameters();
            Parameter _createParameter_1 = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function_1 = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("b");
                EList<TypeParameter> _typeParameters = op.getTypeParameters();
                TypeParameter _get = _typeParameters.get(1);
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow_1 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter_1, _function_1);
            _parameters_1.add(_doubleArrow_1);
            EList<Parameter> _parameters_2 = op.getParameters();
            Parameter _createParameter_2 = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function_2 = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("c");
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(ITypeSystem.BOOLEAN);
                it.setTypeSpecifier(_typeSpecifier);
              }
            };
            Parameter _doubleArrow_2 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter_2, _function_2);
            _parameters_2.add(_doubleArrow_2);
            EList<TypeParameter> _typeParameters_2 = op.getTypeParameters();
            TypeParameter _get = _typeParameters_2.get(1);
            TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
            op.setTypeSpecifier(_typeSpecifier);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
  }
  
  /**
   * Returns a model of the following function:
   * 
   * template <typename T, typename T2>
   * T2 nestedOp(ComplexParameterizedType<T, T2> a) {
   * 		return a.prop1.prop2;
   * }
   */
  public org.yakindu.base.types.Package createPackageWithNestedComplexTypeFunction() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("nestedTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("nestedOp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
            TypeParameter _createTypeParameter_1 = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T2");
            _typeParameters_1.add(_createTypeParameter_1);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("a");
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(STextTestScopeProvider.this.cmplxParamType);
                final Procedure1<TypeSpecifier> _function = new Procedure1<TypeSpecifier>() {
                  @Override
                  public void apply(final TypeSpecifier it) {
                    EList<TypeSpecifier> _typeArguments = it.getTypeArguments();
                    EList<TypeParameter> _typeParameters = op.getTypeParameters();
                    TypeParameter _get = _typeParameters.get(0);
                    TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
                    _typeArguments.add(_typeSpecifier);
                    EList<TypeSpecifier> _typeArguments_1 = it.getTypeArguments();
                    EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
                    TypeParameter _get_1 = _typeParameters_1.get(1);
                    TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_1);
                    _typeArguments_1.add(_typeSpecifier_1);
                  }
                };
                TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_typeSpecifier, _function);
                it.setTypeSpecifier(_doubleArrow);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<TypeParameter> _typeParameters_2 = op.getTypeParameters();
            TypeParameter _get = _typeParameters_2.get(1);
            TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
            op.setTypeSpecifier(_typeSpecifier);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
  }
  
  /**
   * Returns a model of the following function:
   * 
   * template <typename T>
   * T nestedNestedReturn(ComplexParameterizedType<ComplexParameterizedType<boolean, T>, integer> a) {
   * 		return a.prop1.prop2;
   * }
   */
  public org.yakindu.base.types.Package createPackageWithNestedNestedComplexTypeFunction() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("nestedNestedTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("nestedNestedOp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("a");
                TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(STextTestScopeProvider.this.cmplxParamType);
                final Procedure1<TypeSpecifier> _function = new Procedure1<TypeSpecifier>() {
                  @Override
                  public void apply(final TypeSpecifier it) {
                    EList<TypeSpecifier> _typeArguments = it.getTypeArguments();
                    TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(STextTestScopeProvider.this.cmplxParamType);
                    final Procedure1<TypeSpecifier> _function = new Procedure1<TypeSpecifier>() {
                      @Override
                      public void apply(final TypeSpecifier it) {
                        EList<TypeSpecifier> _typeArguments = it.getTypeArguments();
                        TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(ITypeSystem.BOOLEAN);
                        _typeArguments.add(_typeSpecifier);
                        EList<TypeSpecifier> _typeArguments_1 = it.getTypeArguments();
                        EList<TypeParameter> _typeParameters = op.getTypeParameters();
                        TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters);
                        TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
                        _typeArguments_1.add(_typeSpecifier_1);
                      }
                    };
                    TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_typeSpecifier, _function);
                    _typeArguments.add(_doubleArrow);
                    EList<TypeSpecifier> _typeArguments_1 = it.getTypeArguments();
                    TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(ITypeSystem.INTEGER);
                    _typeArguments_1.add(_typeSpecifier_1);
                  }
                };
                TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_typeSpecifier, _function);
                it.setTypeSpecifier(_doubleArrow);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
            TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters_1);
            TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
            op.setTypeSpecifier(_typeSpecifier);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
  }
  
  /**
   * Returns a model of the following function:
   * 
   * template<typename T, typename T2>
   * T getProp(ComplexParameterizedType<T,T2> cpt) {
   * 	   return ctp.prop1;
   * }
   */
  public org.yakindu.base.types.Package createComplexParameterizedTypeTemplateTest() {
    org.yakindu.base.types.Package _createRootPackage = this._typesTestFactory.createRootPackage("cptTemplate");
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package types) {
        EList<PackageMember> _member = types.getMember();
        Operation _createOperation = STextTestScopeProvider.this.factory.createOperation();
        final Procedure1<Operation> _function = new Procedure1<Operation>() {
          @Override
          public void apply(final Operation op) {
            op.setName("getProp");
            EList<TypeParameter> _typeParameters = op.getTypeParameters();
            TypeParameter _createTypeParameter = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T");
            _typeParameters.add(_createTypeParameter);
            EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
            TypeParameter _createTypeParameter_1 = STextTestScopeProvider.this._typesTestFactory.createTypeParameter("T2");
            _typeParameters_1.add(_createTypeParameter_1);
            EList<Parameter> _parameters = op.getParameters();
            Parameter _createParameter = STextTestScopeProvider.this.factory.createParameter();
            final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
              @Override
              public void apply(final Parameter it) {
                it.setName("cpt");
                TypeSpecifier _createTypeSpecifier = STextTestScopeProvider.this.factory.createTypeSpecifier();
                final Procedure1<TypeSpecifier> _function = new Procedure1<TypeSpecifier>() {
                  @Override
                  public void apply(final TypeSpecifier it) {
                    it.setType(STextTestScopeProvider.this.cmplxParamType);
                    EList<TypeSpecifier> _typeArguments = it.getTypeArguments();
                    EList<TypeParameter> _typeParameters = op.getTypeParameters();
                    TypeParameter _get = _typeParameters.get(0);
                    TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get);
                    _typeArguments.add(_typeSpecifier);
                    EList<TypeSpecifier> _typeArguments_1 = it.getTypeArguments();
                    EList<TypeParameter> _typeParameters_1 = op.getTypeParameters();
                    TypeParameter _get_1 = _typeParameters_1.get(1);
                    TypeSpecifier _typeSpecifier_1 = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_get_1);
                    _typeArguments_1.add(_typeSpecifier_1);
                  }
                };
                TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function);
                it.setTypeSpecifier(_doubleArrow);
              }
            };
            Parameter _doubleArrow = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
            _parameters.add(_doubleArrow);
            EList<TypeParameter> _typeParameters_2 = op.getTypeParameters();
            TypeParameter _head = IterableExtensions.<TypeParameter>head(_typeParameters_2);
            TypeSpecifier _typeSpecifier = STextTestScopeProvider.this._typesTestFactory.toTypeSpecifier(_head);
            op.setTypeSpecifier(_typeSpecifier);
          }
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
        _member.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createRootPackage, _function);
  }
}
