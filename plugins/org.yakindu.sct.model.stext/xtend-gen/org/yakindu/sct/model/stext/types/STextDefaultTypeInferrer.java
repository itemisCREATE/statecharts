package org.yakindu.sct.model.stext.types;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystem.ITypeSystemOperator;
import org.yakindu.base.types.ITypeSystem.InferenceIssue;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypedElement;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalNotExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem.BinaryOperators;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem.TernaryOperators;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem.UnaryOperators;

/**
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Complete revision of API
 */
@Singleton
@SuppressWarnings("all")
public class STextDefaultTypeInferrer implements ISTextTypeInferrer {
  @Inject
  protected ISTextTypeSystem ts;
  
  public InferenceResult inferType(final Expression e) {
    boolean _equals = Objects.equal(e, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Expression may not be null");
      throw _illegalArgumentException;
    } else {
      return this.doInferType(e);
    }
  }
  
  public InferenceResult inferType(final VariableDefinition definition) {
    InferenceResult _xifexpression = null;
    boolean _equals = Objects.equal(definition, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Definition may not be null");
      throw _illegalArgumentException;
    } else {
      InferenceResult _doInferType = this.doInferType(definition);
      _xifexpression = _doInferType;
    }
    return _xifexpression;
  }
  
  public InferenceResult inferType(final EventDefinition definition) {
    InferenceResult _xifexpression = null;
    boolean _equals = Objects.equal(definition, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Definition may not be null");
      throw _illegalArgumentException;
    } else {
      InferenceResult _doInferType = this.doInferType(definition);
      _xifexpression = _doInferType;
    }
    return _xifexpression;
  }
  
  protected InferenceResult _doInferType(final VariableDefinition definition) {
    Type _type = definition.getType();
    boolean _equals = Objects.equal(_type, null);
    if (_equals) {
      String _name = definition.getName();
      String _plus = ("Could not infer type of variable: " + _name);
      InferenceIssue _inferenceIssue = new InferenceIssue(_plus, IStatus.ERROR);
      InferenceResult _inferenceResult = new InferenceResult(null, _inferenceIssue);
      return _inferenceResult;
    } else {
      Type _type_1 = definition.getType();
      InferredType _inferredType = new InferredType(_type_1);
      InferenceResult _inferenceResult_1 = new InferenceResult(_inferredType);
      InferenceResult varType = _inferenceResult_1;
      Expression _initialValue = definition.getInitialValue();
      boolean _notEquals = (!Objects.equal(_initialValue, null));
      if (_notEquals) {
        Expression _initialValue_1 = definition.getInitialValue();
        final InferenceResult valueType = this.doInferType(_initialValue_1);
        InferredType _type_2 = valueType.getType();
        boolean _equals_1 = Objects.equal(_type_2, null);
        if (_equals_1) {
          Expression _initialValue_2 = definition.getInitialValue();
          String _plus_1 = ("Could not infer type of initial value expression: " + _initialValue_2);
          InferenceIssue _inferenceIssue_1 = new InferenceIssue(_plus_1, IStatus.ERROR);
          InferenceResult _inferenceResult_2 = new InferenceResult(null, _inferenceIssue_1);
          return _inferenceResult_2;
        }
        final InferenceResult result = this.inferResult(varType, valueType, BinaryOperators.ASSIGN);
        InferredType _type_3 = result.getType();
        boolean _equals_2 = Objects.equal(_type_3, null);
        if (_equals_2) {
          InferredType _type_4 = valueType.getType();
          Type _type_5 = _type_4.getType();
          String _name_1 = _type_5.getName();
          String _plus_2 = ("Cannot assign a value of type " + _name_1);
          String _plus_3 = (_plus_2 + " to a variable of type ");
          InferredType _type_6 = varType.getType();
          Type _type_7 = _type_6.getType();
          String _name_2 = _type_7.getName();
          String _plus_4 = (_plus_3 + _name_2);
          String _plus_5 = (_plus_4 + ".");
          InferenceIssue _inferenceIssue_2 = new InferenceIssue(_plus_5, IStatus.ERROR);
          InferenceResult _inferenceResult_3 = new InferenceResult(null, _inferenceIssue_2);
          return _inferenceResult_3;
        }
      }
      return varType;
    }
  }
  
  protected InferenceResult _doInferType(final EventDefinition definition) {
    boolean _equals = Objects.equal(definition, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("EventDefinition may not be null");
      throw _illegalArgumentException;
    }
    Type _type = definition.getType();
    boolean _equals_1 = Objects.equal(_type, null);
    if (_equals_1) {
      Type _voidType = this.ts.getVoidType();
      InferredType _inferredType = new InferredType(_voidType);
      InferenceResult _inferenceResult = new InferenceResult(_inferredType);
      return _inferenceResult;
    }
    Type _type_1 = definition.getType();
    InferredType _inferredType_1 = new InferredType(_type_1);
    InferenceResult _inferenceResult_1 = new InferenceResult(_inferredType_1);
    return _inferenceResult_1;
  }
  
  protected InferenceResult _doInferType(final OperationDefinition definition) {
    boolean _equals = Objects.equal(definition, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("EventDefinition may not be null");
      throw _illegalArgumentException;
    }
    Type _type = definition.getType();
    boolean _equals_1 = Objects.equal(_type, null);
    if (_equals_1) {
      Type _voidType = this.ts.getVoidType();
      InferredType _inferredType = new InferredType(_voidType);
      InferenceResult _inferenceResult = new InferenceResult(_inferredType);
      return _inferenceResult;
    }
    Type _type_1 = definition.getType();
    InferredType _inferredType_1 = new InferredType(_type_1);
    InferenceResult _inferenceResult_1 = new InferenceResult(_inferredType_1);
    return _inferenceResult_1;
  }
  
  protected InferenceResult _doInferType(final Type type) {
    InferredType _inferredType = new InferredType(type);
    InferenceResult _inferenceResult = new InferenceResult(_inferredType);
    return _inferenceResult;
  }
  
  protected InferenceResult _doInferType(final TypedElement typedElement) {
    Type _type = typedElement.getType();
    InferredType _inferredType = new InferredType(_type);
    InferenceResult _inferenceResult = new InferenceResult(_inferredType);
    return _inferenceResult;
  }
  
  protected InferenceResult _doInferType(final Enumerator enumerator) {
    EnumerationType _owningEnumeration = enumerator.getOwningEnumeration();
    InferredType _inferredType = new InferredType(_owningEnumeration);
    InferenceResult _inferenceResult = new InferenceResult(_inferredType);
    return _inferenceResult;
  }
  
  protected InferenceResult _doInferType(final EObject e) {
    Type _voidType = this.ts.getVoidType();
    InferredType _inferredType = new InferredType(_voidType);
    InferenceResult _inferenceResult = new InferenceResult(_inferredType);
    return _inferenceResult;
  }
  
  protected InferenceResult _doInferType(final Expression e) {
    String _plus = ("Unsupported expression type " + e);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_plus);
    throw _unsupportedOperationException;
  }
  
  public InferenceResult inferResult(final InferenceResult operand, final ITypeSystemOperator unaryOperator) {
    InferredType _type = operand.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      InferredType _type_1 = operand.getType();
      return this.ts.inferType(_type_1, unaryOperator);
    }
    Collection<InferenceIssue> _issues = operand.getIssues();
    InferenceResult _inferenceResult = new InferenceResult(null, _issues);
    return _inferenceResult;
  }
  
  public InferenceResult inferResult(final InferenceResult firstOperand, final InferenceResult secondOperand, final ITypeSystemOperator binaryOperator) {
    boolean _and = false;
    InferredType _type = firstOperand.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (!_notEquals) {
      _and = false;
    } else {
      InferredType _type_1 = secondOperand.getType();
      boolean _notEquals_1 = (!Objects.equal(_type_1, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      InferredType _type_2 = firstOperand.getType();
      InferredType _type_3 = secondOperand.getType();
      final InferenceResult result = this.ts.inferType(_type_2, _type_3, binaryOperator);
      Collection<InferenceIssue> _issues = result.getIssues();
      Collection<InferenceIssue> _issues_1 = firstOperand.getIssues();
      _issues.addAll(_issues_1);
      Collection<InferenceIssue> _issues_2 = result.getIssues();
      Collection<InferenceIssue> _issues_3 = secondOperand.getIssues();
      _issues_2.addAll(_issues_3);
      return result;
    }
    Collection<InferenceIssue> _issues_4 = firstOperand.getIssues();
    Collection<InferenceIssue> _issues_5 = secondOperand.getIssues();
    Iterable<InferenceIssue> _concat = Iterables.<InferenceIssue>concat(_issues_4, _issues_5);
    List<InferenceIssue> _list = IterableExtensions.<InferenceIssue>toList(_concat);
    InferenceResult _inferenceResult = new InferenceResult(null, _list);
    return _inferenceResult;
  }
  
  public InferenceResult inferResult(final InferenceResult firstOperand, final InferenceResult secondOperand, final InferenceResult thirdOperand, final ITypeSystemOperator ternaryOperator) {
    boolean _and = false;
    boolean _and_1 = false;
    InferredType _type = firstOperand.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      InferredType _type_1 = secondOperand.getType();
      boolean _notEquals_1 = (!Objects.equal(_type_1, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      InferredType _type_2 = thirdOperand.getType();
      boolean _notEquals_2 = (!Objects.equal(_type_2, null));
      _and = (_and_1 && _notEquals_2);
    }
    if (_and) {
      InferredType _type_3 = firstOperand.getType();
      InferredType _type_4 = secondOperand.getType();
      InferredType _type_5 = thirdOperand.getType();
      final InferenceResult result = this.ts.inferType(_type_3, _type_4, _type_5, ternaryOperator);
      Collection<InferenceIssue> _issues = result.getIssues();
      Collection<InferenceIssue> _issues_1 = firstOperand.getIssues();
      _issues.addAll(_issues_1);
      Collection<InferenceIssue> _issues_2 = result.getIssues();
      Collection<InferenceIssue> _issues_3 = secondOperand.getIssues();
      _issues_2.addAll(_issues_3);
      Collection<InferenceIssue> _issues_4 = result.getIssues();
      Collection<InferenceIssue> _issues_5 = thirdOperand.getIssues();
      _issues_4.addAll(_issues_5);
      return result;
    }
    Collection<InferenceIssue> _issues_6 = firstOperand.getIssues();
    Collection<InferenceIssue> _issues_7 = secondOperand.getIssues();
    Iterable<InferenceIssue> _concat = Iterables.<InferenceIssue>concat(_issues_6, _issues_7);
    List<InferenceIssue> _list = IterableExtensions.<InferenceIssue>toList(_concat);
    InferenceResult _inferenceResult = new InferenceResult(null, _list);
    return _inferenceResult;
  }
  
  protected InferenceResult _doInferType(final AssignmentExpression expression) {
    Expression _varRef = expression.getVarRef();
    InferenceResult _doInferType = this.doInferType(_varRef);
    Expression _expression = expression.getExpression();
    InferenceResult _doInferType_1 = this.doInferType(_expression);
    AssignmentOperator _operator = expression.getOperator();
    ITypeSystemOperator _typeSystemOperator = this.getTypeSystemOperator(_operator);
    return this.inferResult(_doInferType, _doInferType_1, _typeSystemOperator);
  }
  
  protected InferenceResult _doInferType(final LogicalAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    return this.inferResult(_doInferType, _doInferType_1, BinaryOperators.LOGICAL_AND);
  }
  
  protected InferenceResult _doInferType(final LogicalOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    return this.inferResult(_doInferType, _doInferType_1, BinaryOperators.LOGICAL_OR);
  }
  
  protected InferenceResult _doInferType(final LogicalNotExpression expression) {
    Expression _operand = expression.getOperand();
    InferenceResult _doInferType = this.doInferType(_operand);
    return this.inferResult(_doInferType, UnaryOperators.LOGICAL_NOT);
  }
  
  protected InferenceResult _doInferType(final BitwiseAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    return this.inferResult(_doInferType, _doInferType_1, BinaryOperators.BITWISE_AND);
  }
  
  protected InferenceResult _doInferType(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    return this.inferResult(_doInferType, _doInferType_1, BinaryOperators.BITWISE_OR);
  }
  
  protected InferenceResult _doInferType(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    return this.inferResult(_doInferType, _doInferType_1, BinaryOperators.BITWISE_XOR);
  }
  
  protected InferenceResult _doInferType(final LogicalRelationExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    RelationalOperator _operator = expression.getOperator();
    ITypeSystemOperator _typeSystemOperator = this.getTypeSystemOperator(_operator);
    return this.inferResult(_doInferType, _doInferType_1, _typeSystemOperator);
  }
  
  protected InferenceResult _doInferType(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    AdditiveOperator _operator = expression.getOperator();
    ITypeSystemOperator _typeSystemOperator = this.getTypeSystemOperator(_operator);
    return this.inferResult(_doInferType, _doInferType_1, _typeSystemOperator);
  }
  
  protected InferenceResult _doInferType(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    MultiplicativeOperator _operator = expression.getOperator();
    ITypeSystemOperator _typeSystemOperator = this.getTypeSystemOperator(_operator);
    return this.inferResult(_doInferType, _doInferType_1, _typeSystemOperator);
  }
  
  protected InferenceResult _doInferType(final NumericalUnaryExpression expression) {
    Expression _operand = expression.getOperand();
    InferenceResult _doInferType = this.doInferType(_operand);
    UnaryOperator _operator = expression.getOperator();
    ITypeSystemOperator _typeSystemOperator = this.getTypeSystemOperator(_operator);
    return this.inferResult(_doInferType, _typeSystemOperator);
  }
  
  protected InferenceResult _doInferType(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    return this.doInferType(_value);
  }
  
  protected InferenceResult _doInferType(final ShiftExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    InferenceResult _doInferType = this.doInferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    InferenceResult _doInferType_1 = this.doInferType(_rightOperand);
    ShiftOperator _operator = expression.getOperator();
    ITypeSystemOperator _typeSystemOperator = this.getTypeSystemOperator(_operator);
    return this.inferResult(_doInferType, _doInferType_1, _typeSystemOperator);
  }
  
  protected InferenceResult _doInferType(final ConditionalExpression expression) {
    Expression _condition = expression.getCondition();
    InferenceResult _doInferType = this.doInferType(_condition);
    Expression _trueCase = expression.getTrueCase();
    InferenceResult _doInferType_1 = this.doInferType(_trueCase);
    Expression _falseCase = expression.getFalseCase();
    InferenceResult _doInferType_2 = this.doInferType(_falseCase);
    return this.inferResult(_doInferType, _doInferType_1, _doInferType_2, TernaryOperators.CONDITIONAL);
  }
  
  protected InferenceResult _doInferType(final EventRaisingExpression eventRaising) {
    Expression _event = eventRaising.getEvent();
    final InferenceResult eventType = this.doInferType(_event);
    InferredType _type = eventType.getType();
    boolean _equals = Objects.equal(_type, null);
    if (_equals) {
      Expression _event_1 = eventRaising.getEvent();
      String _plus = ("Could not infer type of event expression: " + _event_1);
      InferenceIssue _inferenceIssue = new InferenceIssue(_plus, IStatus.ERROR);
      InferenceResult _inferenceResult = new InferenceResult(null, _inferenceIssue);
      return _inferenceResult;
    } else {
      Expression _value = eventRaising.getValue();
      boolean _equals_1 = Objects.equal(_value, null);
      if (_equals_1) {
        InferredType _type_1 = eventType.getType();
        boolean _isVoidType = this.ts.isVoidType(_type_1);
        boolean _not = (!_isVoidType);
        if (_not) {
          InferredType _type_2 = eventType.getType();
          Type _type_3 = _type_2.getType();
          String _name = _type_3.getName();
          String _plus_1 = ("Need to assign a value to an event of type " + _name);
          String _plus_2 = (_plus_1 + ".");
          InferenceIssue _inferenceIssue_1 = new InferenceIssue(_plus_2, IStatus.ERROR);
          InferenceResult _inferenceResult_1 = new InferenceResult(null, _inferenceIssue_1);
          return _inferenceResult_1;
        }
        return eventType;
      } else {
        Expression _value_1 = eventRaising.getValue();
        final InferenceResult valueType = this.doInferType(_value_1);
        InferredType _type_4 = valueType.getType();
        boolean _equals_2 = Objects.equal(_type_4, null);
        if (_equals_2) {
          Expression _value_2 = eventRaising.getValue();
          String _plus_3 = ("Could not infer type of value expression: " + _value_2);
          InferenceIssue _inferenceIssue_2 = new InferenceIssue(_plus_3, IStatus.ERROR);
          InferenceResult _inferenceResult_2 = new InferenceResult(null, _inferenceIssue_2);
          return _inferenceResult_2;
        }
        final InferenceResult result = this.inferResult(eventType, valueType, BinaryOperators.ASSIGN);
        InferredType _type_5 = result.getType();
        boolean _equals_3 = Objects.equal(_type_5, null);
        if (_equals_3) {
          InferredType _type_6 = valueType.getType();
          Type _type_7 = _type_6.getType();
          String _name_1 = _type_7.getName();
          String _plus_4 = ("Cannot assign a value of type " + _name_1);
          String _plus_5 = (_plus_4 + " to an event of type ");
          InferredType _type_8 = eventType.getType();
          Type _type_9 = _type_8.getType();
          String _name_2 = _type_9.getName();
          String _plus_6 = (_plus_5 + _name_2);
          String _plus_7 = (_plus_6 + ".");
          InferenceIssue _inferenceIssue_3 = new InferenceIssue(_plus_7, IStatus.ERROR);
          InferenceResult _inferenceResult_3 = new InferenceResult(null, _inferenceIssue_3);
          return _inferenceResult_3;
        } else {
          return result;
        }
      }
    }
  }
  
  protected InferenceResult _doInferType(final FeatureCall featureCall) {
    boolean _and = false;
    boolean _and_1 = false;
    EObject _feature = featureCall.getFeature();
    if (!(_feature instanceof Event)) {
      _and_1 = false;
    } else {
      EObject _eContainer = featureCall.eContainer();
      boolean _not = (!(_eContainer instanceof EventRaisingExpression));
      _and_1 = ((_feature instanceof Event) && _not);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _eContainer_1 = featureCall.eContainer();
      boolean _not_1 = (!(_eContainer_1 instanceof EventValueReferenceExpression));
      _and = (_and_1 && _not_1);
    }
    if (_and) {
      Type _booleanType = this.ts.getBooleanType();
      InferenceResult _inferenceResult = new InferenceResult(_booleanType);
      return _inferenceResult;
    }
    EObject _feature_1 = featureCall.getFeature();
    if ((_feature_1 instanceof Feature)) {
      EObject _feature_2 = featureCall.getFeature();
      final Type type = ((Feature) _feature_2).getType();
      boolean _notEquals = (!Objects.equal(type, null));
      if (_notEquals) {
        InferredType _inferredType = new InferredType(type);
        InferenceResult _inferenceResult_1 = new InferenceResult(_inferredType);
        return _inferenceResult_1;
      }
      Type _voidType = this.ts.getVoidType();
      InferenceResult _inferenceResult_2 = new InferenceResult(_voidType);
      return _inferenceResult_2;
    }
    EObject _feature_3 = featureCall.getFeature();
    return this.doInferType(_feature_3);
  }
  
  protected InferenceResult _doInferType(final ActiveStateReferenceExpression expression) {
    Type _booleanType = this.ts.getBooleanType();
    InferenceResult _inferenceResult = new InferenceResult(_booleanType);
    return _inferenceResult;
  }
  
  protected InferenceResult _doInferType(final ElementReferenceExpression expression) {
    boolean _and = false;
    EObject _reference = expression.getReference();
    if (!(_reference instanceof EventDefinition)) {
      _and = false;
    } else {
      boolean _or = false;
      EObject _eContainer = expression.eContainer();
      if ((_eContainer instanceof EventRaisingExpression)) {
        _or = true;
      } else {
        EObject _eContainer_1 = expression.eContainer();
        _or = ((_eContainer instanceof EventRaisingExpression) || (_eContainer_1 instanceof EventValueReferenceExpression));
      }
      boolean _not = (!_or);
      _and = ((_reference instanceof EventDefinition) && _not);
    }
    if (_and) {
      Type _booleanType = this.ts.getBooleanType();
      InferenceResult _inferenceResult = new InferenceResult(_booleanType);
      return _inferenceResult;
    } else {
      EObject _reference_1 = expression.getReference();
      return this.doInferType(_reference_1);
    }
  }
  
  protected InferenceResult _doInferType(final EventValueReferenceExpression expression) {
    Expression _value = expression.getValue();
    return this.doInferType(_value);
  }
  
  protected InferenceResult _doInferType(final ParenthesizedExpression expression) {
    Expression _expression = expression.getExpression();
    return this.doInferType(_expression);
  }
  
  protected InferenceResult _doInferType(final Literal literal) {
    return this.ts.inferType(literal);
  }
  
  protected ITypeSystemOperator _getTypeSystemOperator(final UnaryOperator operator) {
    UnaryOperators _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,UnaryOperator.COMPLEMENT)) {
        _matched=true;
        _switchResult = UnaryOperators.COMPLEMENT;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,UnaryOperator.NEGATIVE)) {
        _matched=true;
        _switchResult = UnaryOperators.NEGATIVE;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,UnaryOperator.POSITIVE)) {
        _matched=true;
        _switchResult = UnaryOperators.POSITIVE;
      }
    }
    if (!_matched) {
      String _plus = ("Unsupported operator" + operator);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  protected ITypeSystemOperator _getTypeSystemOperator(final AssignmentOperator operator) {
    BinaryOperators _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.ADD_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_ADD;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.AND_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_BITWISE_AND;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.DIV_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_DIV;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.LEFT_SHIFT_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_LEFT_SHIFT;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.MOD_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_MOD;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.MULT_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_MULTIPLY;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.OR_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_BITWISE_OR;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.RIGHT_SHIFT_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_RIGHT_SHIFT;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.SUB_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_SUBTRACT;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AssignmentOperator.XOR_ASSIGN)) {
        _matched=true;
        _switchResult = BinaryOperators.ASSIGN_BITWISE_XOR;
      }
    }
    if (!_matched) {
      String _plus = ("Unsupported operator" + operator);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  protected ITypeSystemOperator _getTypeSystemOperator(final ShiftOperator operator) {
    BinaryOperators _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,ShiftOperator.LEFT)) {
        _matched=true;
        _switchResult = BinaryOperators.LEFT_SHIFT;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,ShiftOperator.RIGHT)) {
        _matched=true;
        _switchResult = BinaryOperators.RIGHT_SHIFT;
      }
    }
    if (!_matched) {
      String _plus = ("Unsupported operator" + operator);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  protected ITypeSystemOperator _getTypeSystemOperator(final AdditiveOperator operator) {
    BinaryOperators _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,AdditiveOperator.PLUS)) {
        _matched=true;
        _switchResult = BinaryOperators.ADD;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,AdditiveOperator.MINUS)) {
        _matched=true;
        _switchResult = BinaryOperators.SUBTRACT;
      }
    }
    if (!_matched) {
      String _plus = ("Unsupported operator" + operator);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  protected ITypeSystemOperator _getTypeSystemOperator(final MultiplicativeOperator operator) {
    BinaryOperators _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,MultiplicativeOperator.DIV)) {
        _matched=true;
        _switchResult = BinaryOperators.DIV;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,MultiplicativeOperator.MOD)) {
        _matched=true;
        _switchResult = BinaryOperators.MOD;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,MultiplicativeOperator.MUL)) {
        _matched=true;
        _switchResult = BinaryOperators.MULTIPLY;
      }
    }
    if (!_matched) {
      String _plus = ("Unsupported operator" + operator);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  protected ITypeSystemOperator _getTypeSystemOperator(final RelationalOperator operator) {
    BinaryOperators _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,RelationalOperator.EQUALS)) {
        _matched=true;
        _switchResult = BinaryOperators.EQUAL;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,RelationalOperator.NOT_EQUALS)) {
        _matched=true;
        _switchResult = BinaryOperators.NOT_EQUAL;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,RelationalOperator.GREATER)) {
        _matched=true;
        _switchResult = BinaryOperators.GREATER;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,RelationalOperator.GREATER_EQUAL)) {
        _matched=true;
        _switchResult = BinaryOperators.GREATER_EQUAL;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,RelationalOperator.SMALLER)) {
        _matched=true;
        _switchResult = BinaryOperators.SMALLER;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,RelationalOperator.SMALLER_EQUAL)) {
        _matched=true;
        _switchResult = BinaryOperators.SMALLER_EQUAL;
      }
    }
    if (!_matched) {
      String _plus = ("Unsupported operator" + operator);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  public InferenceResult doInferType(final EObject definition) {
    if (definition instanceof EventDefinition) {
      return _doInferType((EventDefinition)definition);
    } else if (definition instanceof OperationDefinition) {
      return _doInferType((OperationDefinition)definition);
    } else if (definition instanceof VariableDefinition) {
      return _doInferType((VariableDefinition)definition);
    } else if (definition instanceof ActiveStateReferenceExpression) {
      return _doInferType((ActiveStateReferenceExpression)definition);
    } else if (definition instanceof AssignmentExpression) {
      return _doInferType((AssignmentExpression)definition);
    } else if (definition instanceof BitwiseAndExpression) {
      return _doInferType((BitwiseAndExpression)definition);
    } else if (definition instanceof BitwiseOrExpression) {
      return _doInferType((BitwiseOrExpression)definition);
    } else if (definition instanceof BitwiseXorExpression) {
      return _doInferType((BitwiseXorExpression)definition);
    } else if (definition instanceof ConditionalExpression) {
      return _doInferType((ConditionalExpression)definition);
    } else if (definition instanceof ElementReferenceExpression) {
      return _doInferType((ElementReferenceExpression)definition);
    } else if (definition instanceof EventRaisingExpression) {
      return _doInferType((EventRaisingExpression)definition);
    } else if (definition instanceof EventValueReferenceExpression) {
      return _doInferType((EventValueReferenceExpression)definition);
    } else if (definition instanceof FeatureCall) {
      return _doInferType((FeatureCall)definition);
    } else if (definition instanceof LogicalAndExpression) {
      return _doInferType((LogicalAndExpression)definition);
    } else if (definition instanceof LogicalNotExpression) {
      return _doInferType((LogicalNotExpression)definition);
    } else if (definition instanceof LogicalOrExpression) {
      return _doInferType((LogicalOrExpression)definition);
    } else if (definition instanceof LogicalRelationExpression) {
      return _doInferType((LogicalRelationExpression)definition);
    } else if (definition instanceof NumericalAddSubtractExpression) {
      return _doInferType((NumericalAddSubtractExpression)definition);
    } else if (definition instanceof NumericalMultiplyDivideExpression) {
      return _doInferType((NumericalMultiplyDivideExpression)definition);
    } else if (definition instanceof NumericalUnaryExpression) {
      return _doInferType((NumericalUnaryExpression)definition);
    } else if (definition instanceof ParenthesizedExpression) {
      return _doInferType((ParenthesizedExpression)definition);
    } else if (definition instanceof PrimitiveValueExpression) {
      return _doInferType((PrimitiveValueExpression)definition);
    } else if (definition instanceof ShiftExpression) {
      return _doInferType((ShiftExpression)definition);
    } else if (definition instanceof Enumerator) {
      return _doInferType((Enumerator)definition);
    } else if (definition instanceof Type) {
      return _doInferType((Type)definition);
    } else if (definition instanceof Expression) {
      return _doInferType((Expression)definition);
    } else if (definition instanceof TypedElement) {
      return _doInferType((TypedElement)definition);
    } else if (definition instanceof Literal) {
      return _doInferType((Literal)definition);
    } else if (definition != null) {
      return _doInferType(definition);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(definition).toString());
    }
  }
  
  public ITypeSystemOperator getTypeSystemOperator(final Object operator) {
    if (operator instanceof AdditiveOperator) {
      return _getTypeSystemOperator((AdditiveOperator)operator);
    } else if (operator instanceof AssignmentOperator) {
      return _getTypeSystemOperator((AssignmentOperator)operator);
    } else if (operator instanceof MultiplicativeOperator) {
      return _getTypeSystemOperator((MultiplicativeOperator)operator);
    } else if (operator instanceof RelationalOperator) {
      return _getTypeSystemOperator((RelationalOperator)operator);
    } else if (operator instanceof ShiftOperator) {
      return _getTypeSystemOperator((ShiftOperator)operator);
    } else if (operator instanceof UnaryOperator) {
      return _getTypeSystemOperator((UnaryOperator)operator);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(operator).toString());
    }
  }
}
