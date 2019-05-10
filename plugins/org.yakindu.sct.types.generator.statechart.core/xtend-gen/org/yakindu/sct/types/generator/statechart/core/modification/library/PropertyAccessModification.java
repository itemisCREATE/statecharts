/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 */
package org.yakindu.sct.types.generator.statechart.core.modification.library;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BlockExpression;
import org.yakindu.base.expressions.util.ExpressionBuilder;
import org.yakindu.base.expressions.util.ExpressionExtensions;
import org.yakindu.base.expressions.util.PackageNavigationExtensions;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.TypeBuilder;
import org.yakindu.base.types.Visibility;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.types.generator.modification.library.ComplexTypeNavigationExtensions;
import org.yakindu.sct.types.generator.statechart.core.naming.IPropertyAccessNaming;
import org.yakindu.sct.types.modification.IModification;

/**
 * Creates getter and setter operations for all properties in interface types
 */
@Singleton
@SuppressWarnings("all")
public class PropertyAccessModification implements IModification {
  @Inject
  @Extension
  protected PackageNavigationExtensions _packageNavigationExtensions;
  
  @Inject
  @Extension
  protected ComplexTypeNavigationExtensions _complexTypeNavigationExtensions;
  
  @Inject
  @Extension
  protected ExpressionBuilder _expressionBuilder;
  
  @Inject
  @Extension
  protected TypeBuilder _typeBuilder;
  
  @Inject
  @Extension
  protected IPropertyAccessNaming _iPropertyAccessNaming;
  
  @Inject
  @Extension
  protected ExpressionExtensions _expressionExtensions;
  
  @Inject
  protected ITypeSystem ts;
  
  @Override
  public Collection<org.yakindu.base.types.Package> modify(final Collection<org.yakindu.base.types.Package> packages) {
    Collection<org.yakindu.base.types.Package> _xblockexpression = null;
    {
      final Consumer<org.yakindu.base.types.Package> _function = (org.yakindu.base.types.Package it) -> {
        this.modify(it);
      };
      packages.forEach(_function);
      _xblockexpression = packages;
    }
    return _xblockexpression;
  }
  
  public org.yakindu.base.types.Package modify(final org.yakindu.base.types.Package p) {
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      Annotation _annotationOfType = it.getAnnotationOfType("InterfaceGroup");
      return Boolean.valueOf((_annotationOfType != null));
    };
    final Iterable<ComplexType> interfaceTypes = IterableExtensions.<ComplexType>filter(this._packageNavigationExtensions.allComplexTypes(p), _function);
    final Consumer<ComplexType> _function_1 = (ComplexType iface) -> {
      final Procedure1<Property> _function_2 = (Property prop) -> {
        boolean _isConst = prop.isConst();
        boolean _not = (!_isConst);
        if (_not) {
          EList<Declaration> _features = iface.getFeatures();
          Operation _writeAccess = this.writeAccess(prop);
          _features.add(_writeAccess);
        }
        boolean _needsAssignMethod = this.needsAssignMethod(prop, p);
        if (_needsAssignMethod) {
          EList<Declaration> _features_1 = iface.getFeatures();
          Operation _assign = this.assign(prop);
          _features_1.add(_assign);
        }
        EList<Declaration> _features_2 = iface.getFeatures();
        Operation _readAccess = this.readAccess(prop);
        _features_2.add(_readAccess);
        prop.setVisibility(Visibility.PROTECTED);
      };
      IteratorExtensions.<Property>forEach(Iterators.<Property>filter(iface.eAllContents(), Property.class), _function_2);
    };
    interfaceTypes.forEach(_function_1);
    return p;
  }
  
  protected Operation readAccess(final Property prop) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(prop);
    final Operation _result;
    synchronized (_createCache_readAccess) {
      if (_createCache_readAccess.containsKey(_cacheKey)) {
        return _createCache_readAccess.get(_cacheKey);
      }
      Operation __op = this._typeBuilder._op();
      _result = __op;
      _createCache_readAccess.put(_cacheKey, _result);
    }
    _init_readAccess(_result, prop);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Operation> _createCache_readAccess = CollectionLiterals.newHashMap();
  
  private void _init_readAccess(final Operation it, final Property prop) {
    it.setName(this._iPropertyAccessNaming.nameReadAccess(prop));
    this._typeBuilder._type(it, prop.getTypeSpecifier());
    it.setBody(this._expressionBuilder._block(this._expressionBuilder._return(this._expressionBuilder._ref(prop))));
    it.setVisibility(prop.getVisibility());
  }
  
  protected Operation writeAccess(final Property prop) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(prop);
    final Operation _result;
    synchronized (_createCache_writeAccess) {
      if (_createCache_writeAccess.containsKey(_cacheKey)) {
        return _createCache_writeAccess.get(_cacheKey);
      }
      Operation __op = this._typeBuilder._op();
      _result = __op;
      _createCache_writeAccess.put(_cacheKey, _result);
    }
    _init_writeAccess(_result, prop);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Operation> _createCache_writeAccess = CollectionLiterals.newHashMap();
  
  private void _init_writeAccess(final Operation it, final Property prop) {
    it.setName(this._iPropertyAccessNaming.nameWriteAccess(prop));
    this._typeBuilder._type(it, this.ts.getType(ITypeSystem.VOID));
    this._typeBuilder._param(it, "value", prop.getTypeSpecifier());
    it.setBody(this._expressionBuilder._block(this._expressionBuilder._assign(this._expressionBuilder._ref(prop), this._expressionBuilder._ref(IterableExtensions.<Parameter>head(it.getParameters())))));
    it.setVisibility(prop.getVisibility());
  }
  
  protected Operation assign(final Property prop) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(prop);
    final Operation _result;
    synchronized (_createCache_assign) {
      if (_createCache_assign.containsKey(_cacheKey)) {
        return _createCache_assign.get(_cacheKey);
      }
      Operation __op = this._typeBuilder._op();
      _result = __op;
      _createCache_assign.put(_cacheKey, _result);
    }
    _init_assign(_result, prop);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Operation> _createCache_assign = CollectionLiterals.newHashMap();
  
  private void _init_assign(final Operation it, final Property prop) {
    it.setName(this._iPropertyAccessNaming.nameAssign(prop));
    this._typeBuilder._type(it, prop.getTypeSpecifier());
    this._typeBuilder._param(it, "value", prop.getTypeSpecifier());
    it.setBody(this._expressionBuilder._block(this._expressionBuilder._return(this._expressionBuilder._assign(this._expressionBuilder._ref(prop), this._expressionBuilder._ref(IterableExtensions.<Parameter>head(it.getParameters()))))));
    it.setVisibility(prop.getVisibility());
  }
  
  protected boolean needsAssignMethod(final Property prop, final org.yakindu.base.types.Package p) {
    final Function1<AssignmentExpression, Boolean> _function = (AssignmentExpression it) -> {
      return Boolean.valueOf(prop.equals(this._expressionExtensions.featureOrReference(it.getVarRef())));
    };
    final Function1<AssignmentExpression, Boolean> _function_1 = (AssignmentExpression it) -> {
      return Boolean.valueOf(this.needsAssignMethod(it));
    };
    return IteratorExtensions.<AssignmentExpression>exists(IteratorExtensions.<AssignmentExpression>filter(Iterators.<AssignmentExpression>filter(p.eAllContents(), AssignmentExpression.class), _function), _function_1);
  }
  
  protected boolean needsAssignMethod(final AssignmentExpression it) {
    return ((it.eContainer() instanceof Expression) && (!(it.eContainer() instanceof BlockExpression)));
  }
}
