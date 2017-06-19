/**
 * Copyright (c) 2016 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Thomas Kutz - itemis AG
 */
package org.yakindu.sct.model.stext.test.util;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.ITypeSystem;

@SuppressWarnings("all")
public class TypesTestFactory {
  public final static TypesTestFactory INSTANCE = new TypesTestFactory();
  
  @Inject
  protected ITypeSystem ts;
  
  protected TypesFactory factory = TypesFactory.eINSTANCE;
  
  public org.yakindu.base.types.Package createRootPackage(final String filename) {
    org.yakindu.base.types.Package _createPackage = this.factory.createPackage();
    final Procedure1<org.yakindu.base.types.Package> _function = new Procedure1<org.yakindu.base.types.Package>() {
      @Override
      public void apply(final org.yakindu.base.types.Package it) {
        it.setName(filename);
      }
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createPackage, _function);
  }
  
  public Parameter createParameter(final String name, final String typeName) {
    Type _type = this.ts.getType(typeName);
    TypeSpecifier _typeSpecifier = this.toTypeSpecifier(_type);
    return this.createParameter(name, _typeSpecifier);
  }
  
  public Parameter createParameter(final String name, final Type type) {
    TypeSpecifier _typeSpecifier = this.toTypeSpecifier(type);
    return this.createParameter(name, _typeSpecifier);
  }
  
  public Parameter createParameter(final String name, final TypeSpecifier typeSpec) {
    Parameter _createParameter = this.factory.createParameter();
    final Procedure1<Parameter> _function = new Procedure1<Parameter>() {
      @Override
      public void apply(final Parameter it) {
        it.setName(name);
        it.setTypeSpecifier(typeSpec);
      }
    };
    return ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function);
  }
  
  public Property createProperty(final String name, final String typeName) {
    return this.createProperty(name, typeName, false);
  }
  
  public Property createProperty(final String name, final String typeName, final boolean isConst) {
    Type _type = this.ts.getType(typeName);
    Property _createProperty = this.createProperty(name, _type);
    final Procedure1<Property> _function = new Procedure1<Property>() {
      @Override
      public void apply(final Property it) {
        it.setConst(isConst);
      }
    };
    return ObjectExtensions.<Property>operator_doubleArrow(_createProperty, _function);
  }
  
  public Property createProperty(final String name, final Type type) {
    TypeSpecifier _typeSpecifier = this.toTypeSpecifier(type);
    return this.createProperty(name, _typeSpecifier);
  }
  
  public Property createProperty(final String name, final TypeSpecifier typeSpec) {
    Property _createProperty = this.factory.createProperty();
    final Procedure1<Property> _function = new Procedure1<Property>() {
      @Override
      public void apply(final Property it) {
        it.setName(name);
        it.setTypeSpecifier(typeSpec);
      }
    };
    return ObjectExtensions.<Property>operator_doubleArrow(_createProperty, _function);
  }
  
  public Operation createOperation(final String name, final String returnType) {
    Type _type = this.ts.getType(returnType);
    return this.createOperation(name, _type);
  }
  
  public Operation createOperation(final String name, final Type returnType) {
    Operation _createOperation = this.factory.createOperation();
    final Procedure1<Operation> _function = new Procedure1<Operation>() {
      @Override
      public void apply(final Operation it) {
        it.setName(name);
        TypeSpecifier _typeSpecifier = TypesTestFactory.this.toTypeSpecifier(returnType);
        it.setTypeSpecifier(_typeSpecifier);
      }
    };
    return ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function);
  }
  
  public TypeSpecifier toTypeSpecifier(final String typeName) {
    Type _type = this.ts.getType(typeName);
    return this.toTypeSpecifier(_type);
  }
  
  public TypeSpecifier toTypeSpecifier(final Type type) {
    TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
    final Procedure1<TypeSpecifier> _function = new Procedure1<TypeSpecifier>() {
      @Override
      public void apply(final TypeSpecifier it) {
        it.setType(type);
      }
    };
    return ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function);
  }
  
  public TypeParameter createTypeParameter(final String name) {
    TypeParameter _createTypeParameter = this.factory.createTypeParameter();
    final Procedure1<TypeParameter> _function = new Procedure1<TypeParameter>() {
      @Override
      public void apply(final TypeParameter it) {
        it.setName(name);
      }
    };
    return ObjectExtensions.<TypeParameter>operator_doubleArrow(_createTypeParameter, _function);
  }
  
  public Enumerator createEnumerator(final String name) {
    Enumerator _createEnumerator = this.factory.createEnumerator();
    final Procedure1<Enumerator> _function = new Procedure1<Enumerator>() {
      @Override
      public void apply(final Enumerator it) {
        it.setName(name);
      }
    };
    return ObjectExtensions.<Enumerator>operator_doubleArrow(_createEnumerator, _function);
  }
}
