/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.container;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;
import org.yakindu.sct.simulation.core.sexec.container.IExecutionContextInitializer;
import org.yakindu.sct.simulation.core.sruntime.EventDirection;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionEventImpl;
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionSlotImpl;
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionVariableImpl;

/**
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultExecutionContextInitializer implements IExecutionContextInitializer {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private ISTextTypeSystem _iSTextTypeSystem;
  
  @Inject
  @Extension
  private ISTextTypeInferrer _iSTextTypeInferrer;
  
  public void initialize(final ExecutionContext context, final ExecutionFlow flow) {
    EList<Scope> _scopes = flow.getScopes();
    final Procedure1<Scope> _function = new Procedure1<Scope>() {
        public void apply(final Scope it) {
          EList<Declaration> _declarations = it.getDeclarations();
          final Procedure1<Declaration> _function = new Procedure1<Declaration>() {
              public void apply(final Declaration it) {
                List<ExecutionSlot> _slots = context.getSlots();
                ExecutionSlotImpl _transform = DefaultExecutionContextInitializer.this.transform(it);
                _slots.add(_transform);
              }
            };
          IterableExtensions.<Declaration>forEach(_declarations, _function);
        }
      };
    IterableExtensions.<Scope>forEach(_scopes, _function);
  }
  
  protected ExecutionSlotImpl _transform(final VariableDefinition variable) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(variable);
    final ExecutionVariableImpl _result;
    synchronized (_createCache_transform) {
      if (_createCache_transform.containsKey(_cacheKey)) {
        return _createCache_transform.get(_cacheKey);
      }
      ExecutionVariableImpl _executionVariableImpl = new ExecutionVariableImpl();
      _result = _executionVariableImpl;
      _createCache_transform.put(_cacheKey, _result);
    }
    _init_transform(_result, variable);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,ExecutionSlotImpl> _createCache_transform = CollectionLiterals.newHashMap();
  
  private void _init_transform(final ExecutionVariableImpl it, final VariableDefinition variable) {
    QualifiedName qualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(variable);
    qualifiedName.getSegments();
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(variable);
    String _string = _fullyQualifiedName.toString();
    it.setName(_string);
    InferenceResult _inferType = this._iSTextTypeInferrer.inferType(variable);
    InferredType _type = _inferType.getType();
    it.setType(_type);
    InferredType _type_1 = it.getType();
    Object _defaultValue = this.defaultValue(_type_1);
    it.setValue(_defaultValue);
  }
  
  protected ExecutionSlotImpl _transform(final EventDefinition event) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(event);
    final ExecutionEventImpl _result;
    synchronized (_createCache_transform_1) {
      if (_createCache_transform_1.containsKey(_cacheKey)) {
        return _createCache_transform_1.get(_cacheKey);
      }
      ExecutionEventImpl _executionEventImpl = new ExecutionEventImpl();
      _result = _executionEventImpl;
      _createCache_transform_1.put(_cacheKey, _result);
    }
    _init_transform_1(_result, event);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,ExecutionSlotImpl> _createCache_transform_1 = CollectionLiterals.newHashMap();
  
  private void _init_transform_1(final ExecutionEventImpl it, final EventDefinition event) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(event);
    String _string = _fullyQualifiedName.toString();
    it.setName(_string);
    InferenceResult _inferType = this._iSTextTypeInferrer.inferType(event);
    InferredType _type = _inferType.getType();
    it.setType(_type);
    InferredType _type_1 = it.getType();
    Object _defaultValue = this.defaultValue(_type_1);
    it.setValue(_defaultValue);
    Direction _direction = event.getDirection();
    int _value = _direction.getValue();
    EventDirection _get = EventDirection.get(_value);
    it.setDirection(_get);
  }
  
  protected ExecutionSlotImpl _transform(final OperationDefinition op) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(op);
    final ExecutionVariableImpl _result;
    synchronized (_createCache_transform_2) {
      if (_createCache_transform_2.containsKey(_cacheKey)) {
        return _createCache_transform_2.get(_cacheKey);
      }
      ExecutionVariableImpl _executionVariableImpl = new ExecutionVariableImpl();
      _result = _executionVariableImpl;
      _createCache_transform_2.put(_cacheKey, _result);
    }
    _init_transform_2(_result, op);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,ExecutionSlotImpl> _createCache_transform_2 = CollectionLiterals.newHashMap();
  
  private void _init_transform_2(final ExecutionVariableImpl it, final OperationDefinition op) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(op);
    String _string = _fullyQualifiedName.toString();
    it.setName(_string);
    Type _type = op.getType();
    InferredType _inferredType = new InferredType(_type);
    it.setType(_inferredType);
    InferredType _type_1 = it.getType();
    Object _defaultValue = this.defaultValue(_type_1);
    it.setValue(_defaultValue);
  }
  
  protected ExecutionSlotImpl _transform(final TimeEvent event) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(event);
    final ExecutionEventImpl _result;
    synchronized (_createCache_transform_3) {
      if (_createCache_transform_3.containsKey(_cacheKey)) {
        return _createCache_transform_3.get(_cacheKey);
      }
      ExecutionEventImpl _executionEventImpl = new ExecutionEventImpl();
      _result = _executionEventImpl;
      _createCache_transform_3.put(_cacheKey, _result);
    }
    _init_transform_3(_result, event);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,ExecutionSlotImpl> _createCache_transform_3 = CollectionLiterals.newHashMap();
  
  private void _init_transform_3(final ExecutionEventImpl it, final TimeEvent event) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(event);
    String _string = _fullyQualifiedName.toString();
    it.setName(_string);
    Type _integerType = this._iSTextTypeSystem.getIntegerType();
    InferredType _inferredType = new InferredType(_integerType);
    it.setType(_inferredType);
    InferredType _type = it.getType();
    Object _defaultValue = this.defaultValue(_type);
    it.setValue(_defaultValue);
  }
  
  public Object defaultValue(final InferredType type) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      boolean _isBooleanType = this._iSTextTypeSystem.isBooleanType(type);
      if (_isBooleanType) {
        _matched=true;
        _switchResult = Boolean.valueOf(true);
      }
    }
    if (!_matched) {
      boolean _isIntegerType = this._iSTextTypeSystem.isIntegerType(type);
      if (_isIntegerType) {
        _matched=true;
        _switchResult = Integer.valueOf(0);
      }
    }
    if (!_matched) {
      boolean _isRealType = this._iSTextTypeSystem.isRealType(type);
      if (_isRealType) {
        _matched=true;
        _switchResult = Double.valueOf(0.0);
      }
    }
    if (!_matched) {
      boolean _isVoidType = this._iSTextTypeSystem.isVoidType(type);
      if (_isVoidType) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      boolean _isStringType = this._iSTextTypeSystem.isStringType(type);
      if (_isStringType) {
        _matched=true;
        _switchResult = "";
      }
    }
    if (!_matched) {
      if ((type instanceof EnumerationType)) {
        _matched=true;
        EList<Enumerator> _enumerator = ((EnumerationType) type).getEnumerator();
        Enumerator _head = IterableExtensions.<Enumerator>head(_enumerator);
        _switchResult = _head;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public ExecutionSlotImpl transform(final Declaration event) {
    if (event instanceof TimeEvent) {
      return _transform((TimeEvent)event);
    } else if (event instanceof EventDefinition) {
      return _transform((EventDefinition)event);
    } else if (event instanceof OperationDefinition) {
      return _transform((OperationDefinition)event);
    } else if (event instanceof VariableDefinition) {
      return _transform((VariableDefinition)event);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(event).toString());
    }
  }
}
