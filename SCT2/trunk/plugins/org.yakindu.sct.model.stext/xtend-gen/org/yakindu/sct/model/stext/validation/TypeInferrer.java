package org.yakindu.sct.model.stext.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.HexLiteral;
import org.yakindu.sct.model.stext.stext.IntLiteral;
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
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.StringLiteral;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;
import org.yakindu.sct.model.stext.validation.TypeInferrerCache;
import org.yakindu.sct.model.stext.validation.TypeInferrerCache.ICacheableTypeAnalyzer;

/**
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeInferrer implements ITypeInferrer, ICacheableTypeAnalyzer {
  @Inject
  private ITypeSystemAccess ts;
  
  @Inject
  private TypeInferrerCache cache;
  
  public Type getType(final Statement stmt) {
    Type _xblockexpression = null;
    {
      boolean _equals = Objects.equal(stmt, null);
      if (_equals) {
        return null;
      }
      Type _get = this.cache.get(stmt, this);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  protected Type _inferType(final Statement statement) {
    return null;
  }
  
  public Type check(final Statement stmt) {
    Type _type = this.getType(stmt);
    return _type;
  }
  
  /**
   * Check Variable assignments
   */
  protected Type _inferType(final AssignmentExpression assignment) {
    Expression _expression = assignment.getExpression();
    Type valueType = this.getType(_expression);
    Expression _varRef = assignment.getVarRef();
    Type type = this.getType(_varRef);
    boolean _isAssignable = this.ts.isAssignable(type, valueType);
    boolean _not = (!_isAssignable);
    if (_not) {
      String _name = valueType==null?(String)null:valueType.getName();
      String _plus = ("Can not assign a value of type " + _name);
      String _plus_1 = (_plus + " to a variable of type ");
      String _name_1 = type==null?(String)null:type.getName();
      String _plus_2 = (_plus_1 + _name_1);
      this.error(_plus_2);
      return null;
    }
    return type;
  }
  
  /**
   * Check Event value assignments
   */
  protected Type _inferType(final EventRaisingExpression eventRaising) {
    Expression _value = eventRaising.getValue();
    Type valueType = this.getType(_value);
    Expression _event = eventRaising.getEvent();
    Type type = this.getType(_event);
    boolean _isAssignable = this.ts.isAssignable(type, valueType);
    boolean _not = (!_isAssignable);
    if (_not) {
      String _name = valueType==null?(String)null:valueType.getName();
      String _plus = ("Can not assign a value of type " + _name);
      String _plus_1 = (_plus + " to a variable of type ");
      String _name_1 = type==null?(String)null:type.getName();
      String _plus_2 = (_plus_1 + _name_1);
      this.error(_plus_2);
      return null;
    }
    return type;
  }
  
  protected Type _inferType(final LogicalAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    return this.assertBooleanTypes(_type, _type_1, "&&");
  }
  
  protected Type _inferType(final LogicalOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    return this.assertBooleanTypes(_type, _type_1, "||");
  }
  
  public Type assertBooleanTypes(final Type left, final Type right, final String literal) {
    boolean _and = false;
    Type _assertIsBoolean = this.assertIsBoolean(left, literal);
    boolean _notEquals = (!Objects.equal(_assertIsBoolean, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Type _assertIsBoolean_1 = this.assertIsBoolean(right, literal);
      boolean _notEquals_1 = (!Objects.equal(_assertIsBoolean_1, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      return this.ts.combine(left, right);
    }
    return null;
  }
  
  protected Type _inferType(final LogicalNotExpression expression) {
    Expression _operand = expression.getOperand();
    final Type type = this.getType(_operand);
    return this.assertIsBoolean(type, "!");
  }
  
  protected Type _inferType(final BitwiseAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    this.assertIsInteger(_type, "&");
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    this.assertIsInteger(_type_1, "&");
    return this.ts.getInteger();
  }
  
  protected Type _inferType(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    this.assertIsInteger(_type, "|");
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    this.assertIsInteger(_type_1, "|");
    return this.ts.getInteger();
  }
  
  protected Type _inferType(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    this.assertIsInteger(_type, "^");
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    this.assertIsInteger(_type_1, "^");
    return this.ts.getInteger();
  }
  
  protected Type _inferType(final LogicalRelationExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    final Type leftType = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    final Type rightType = this.getType(_rightOperand);
    boolean _and = false;
    boolean _isBoolean = this.ts.isBoolean(leftType);
    if (!_isBoolean) {
      _and = false;
    } else {
      boolean _isBoolean_1 = this.ts.isBoolean(rightType);
      _and = (_isBoolean && _isBoolean_1);
    }
    if (_and) {
      boolean _and_1 = false;
      RelationalOperator _operator = expression.getOperator();
      boolean _notEquals = (!Objects.equal(_operator, RelationalOperator.EQUALS));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        RelationalOperator _operator_1 = expression.getOperator();
        boolean _notEquals_1 = (!Objects.equal(_operator_1, RelationalOperator.NOT_EQUALS));
        _and_1 = (_notEquals && _notEquals_1);
      }
      if (_and_1) {
        RelationalOperator _operator_2 = expression.getOperator();
        String _literal = _operator_2==null?(String)null:_operator_2.getLiteral();
        String _plus = ("operator \'" + _literal);
        String _plus_1 = (_plus + "\' can not be applied to boolean values!");
        this.error(_plus_1);
        return null;
      }
    } else {
      final Type combined = this.ts.combine(leftType, rightType);
      boolean _equals = Objects.equal(combined, null);
      if (_equals) {
        String _name = leftType==null?(String)null:leftType.getName();
        String _plus_2 = ("Incompatible operands " + _name);
        String _plus_3 = (_plus_2 + " and ");
        String _name_1 = rightType==null?(String)null:rightType.getName();
        String _plus_4 = (_plus_3 + _name_1);
        String _plus_5 = (_plus_4 + " for operator \'");
        RelationalOperator _operator_3 = expression.getOperator();
        String _literal_1 = _operator_3.getLiteral();
        String _plus_6 = (_plus_5 + _literal_1);
        String _plus_7 = (_plus_6 + "\'");
        this.error(_plus_7);
      }
    }
    return this.ts.getBoolean();
  }
  
  public Type assertNumericalTypes(final Type left, final Type right, final String operator) {
    boolean _and = false;
    Type _assertIsNumber = this.assertIsNumber(left, operator);
    boolean _notEquals = (!Objects.equal(_assertIsNumber, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Type _assertIsNumber_1 = this.assertIsNumber(right, operator);
      boolean _notEquals_1 = (!Objects.equal(_assertIsNumber_1, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      return this.ts.combine(left, right);
    }
    return null;
  }
  
  protected Type _inferType(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    AdditiveOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    return this.assertNumericalTypes(_type, _type_1, _literal);
  }
  
  protected Type _inferType(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    MultiplicativeOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    return this.assertNumericalTypes(_type, _type_1, _literal);
  }
  
  protected Type _inferType(final NumericalUnaryExpression expression) {
    Expression _operand = expression.getOperand();
    final Type type = this.getType(_operand);
    UnaryOperator _operator = expression.getOperator();
    boolean _equals = Objects.equal(_operator, UnaryOperator.COMPLEMENT);
    if (_equals) {
      UnaryOperator _operator_1 = expression.getOperator();
      String _literal = _operator_1.getLiteral();
      return this.assertIsInteger(type, _literal);
    }
    UnaryOperator _operator_2 = expression.getOperator();
    String _literal_1 = _operator_2.getLiteral();
    return this.assertIsNumber(type, _literal_1);
  }
  
  protected Type _inferType(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    final Type t = this.getLiteralType(_value);
    return t;
  }
  
  protected Type _inferType(final ActiveStateReferenceExpression expression) {
    return this.ts.getBoolean();
  }
  
  protected Type _inferType(final ShiftExpression expression) {
    Type _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Type _type = this.getType(_leftOperand);
      ShiftOperator _operator = expression.getOperator();
      String _literal = _operator.getLiteral();
      this.assertIsInteger(_type, _literal);
      Expression _rightOperand = expression.getRightOperand();
      Type _type_1 = this.getType(_rightOperand);
      ShiftOperator _operator_1 = expression.getOperator();
      String _literal_1 = _operator_1.getLiteral();
      Type _assertIsInteger = this.assertIsInteger(_type_1, _literal_1);
      _xblockexpression = (_assertIsInteger);
    }
    return _xblockexpression;
  }
  
  protected Type _inferType(final ConditionalExpression expression) {
    Expression _condition = expression.getCondition();
    final Type condType = this.getType(_condition);
    boolean _isBoolean = this.ts.isBoolean(condType);
    boolean _not = (!_isBoolean);
    if (_not) {
      this.error("Condition type have to be boolean");
      return null;
    }
    Expression _trueCase = expression.getTrueCase();
    final Type trueType = this.getType(_trueCase);
    Expression _falseCase = expression.getFalseCase();
    final Type falseType = this.getType(_falseCase);
    return this.ts.combine(trueType, falseType);
  }
  
  protected Type _inferType(final FeatureCall featureCall) {
    EObject _feature = featureCall.getFeature();
    if ((_feature instanceof Feature)) {
      EObject _feature_1 = featureCall.getFeature();
      return ((Feature) _feature_1)==null?(Type)null:((Feature) _feature_1).getType();
    } else {
      EObject _feature_2 = featureCall.getFeature();
      boolean _notEquals = (!Objects.equal(_feature_2, null));
      if (_notEquals) {
        String _plus = ("Type of FeatureCall is unknown: " + featureCall);
        this.error(_plus);
        return null;
      } else {
        return null;
      }
    }
  }
  
  protected Type _inferType(final ElementReferenceExpression expression) {
    EObject _reference = expression.getReference();
    return this.inferType(_reference, expression);
  }
  
  protected Type _inferType(final EObject object, final ElementReferenceExpression expression) {
    return null;
  }
  
  protected Type _inferType(final VariableDefinition definition, final ElementReferenceExpression expression) {
    return definition.getType();
  }
  
  protected Type _inferType(final EventDefinition definition, final ElementReferenceExpression expression) {
    boolean _or = false;
    EObject _eContainer = expression.eContainer();
    if ((_eContainer instanceof EventRaisingExpression)) {
      _or = true;
    } else {
      EObject _eContainer_1 = expression.eContainer();
      _or = ((_eContainer instanceof EventRaisingExpression) || (_eContainer_1 instanceof EventValueReferenceExpression));
    }
    if (_or) {
      return definition.getType();
    }
    return this.ts.getBoolean();
  }
  
  protected Type _inferType(final OperationDefinition definition, final ElementReferenceExpression expression) {
    return definition.getType();
  }
  
  protected Type _inferType(final EventValueReferenceExpression expression) {
    Expression _value = expression.getValue();
    return this.getType(_value);
  }
  
  protected Type _getLiteralType(final HexLiteral literal) {
    return this.ts.getInteger();
  }
  
  protected Type _getLiteralType(final IntLiteral literal) {
    return this.ts.getInteger();
  }
  
  protected Type _getLiteralType(final BoolLiteral bool) {
    return this.ts.getBoolean();
  }
  
  protected Type _getLiteralType(final RealLiteral literal) {
    return this.ts.getReal();
  }
  
  protected Type _getLiteralType(final StringLiteral literal) {
    return this.ts.getString();
  }
  
  public Type assertIsInteger(final Type object, final String operator) {
    boolean _isInteger = this.ts.isInteger(object);
    boolean _not = (!_isInteger);
    if (_not) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to integers!");
      this.error(_plus_1);
      return null;
    }
    return object;
  }
  
  public Type assertIsNumber(final Type object, final String operator) {
    boolean _and = false;
    boolean _isReal = this.ts.isReal(object);
    boolean _not = (!_isReal);
    if (!_not) {
      _and = false;
    } else {
      boolean _isInteger = this.ts.isInteger(object);
      boolean _not_1 = (!_isInteger);
      _and = (_not && _not_1);
    }
    if (_and) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to numbers!");
      this.error(_plus_1);
      return null;
    }
    return object;
  }
  
  public Type assertIsBoolean(final Type object, final String operator) {
    boolean _isBoolean = this.ts.isBoolean(object);
    boolean _not = (!_isBoolean);
    if (_not) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to boolean values!");
      this.error(_plus_1);
    }
    return object;
  }
  
  public void error(final String msg) {
    TypeCheckException _typeCheckException = new TypeCheckException(msg);
    throw _typeCheckException;
  }
  
  protected Type _inferType(final Expression expr) {
    return null;
  }
  
  public Type inferType(final Statement expression) {
    if (expression instanceof ActiveStateReferenceExpression) {
      return _inferType((ActiveStateReferenceExpression)expression);
    } else if (expression instanceof AssignmentExpression) {
      return _inferType((AssignmentExpression)expression);
    } else if (expression instanceof BitwiseAndExpression) {
      return _inferType((BitwiseAndExpression)expression);
    } else if (expression instanceof BitwiseOrExpression) {
      return _inferType((BitwiseOrExpression)expression);
    } else if (expression instanceof BitwiseXorExpression) {
      return _inferType((BitwiseXorExpression)expression);
    } else if (expression instanceof ConditionalExpression) {
      return _inferType((ConditionalExpression)expression);
    } else if (expression instanceof ElementReferenceExpression) {
      return _inferType((ElementReferenceExpression)expression);
    } else if (expression instanceof EventRaisingExpression) {
      return _inferType((EventRaisingExpression)expression);
    } else if (expression instanceof EventValueReferenceExpression) {
      return _inferType((EventValueReferenceExpression)expression);
    } else if (expression instanceof FeatureCall) {
      return _inferType((FeatureCall)expression);
    } else if (expression instanceof LogicalAndExpression) {
      return _inferType((LogicalAndExpression)expression);
    } else if (expression instanceof LogicalNotExpression) {
      return _inferType((LogicalNotExpression)expression);
    } else if (expression instanceof LogicalOrExpression) {
      return _inferType((LogicalOrExpression)expression);
    } else if (expression instanceof LogicalRelationExpression) {
      return _inferType((LogicalRelationExpression)expression);
    } else if (expression instanceof NumericalAddSubtractExpression) {
      return _inferType((NumericalAddSubtractExpression)expression);
    } else if (expression instanceof NumericalMultiplyDivideExpression) {
      return _inferType((NumericalMultiplyDivideExpression)expression);
    } else if (expression instanceof NumericalUnaryExpression) {
      return _inferType((NumericalUnaryExpression)expression);
    } else if (expression instanceof PrimitiveValueExpression) {
      return _inferType((PrimitiveValueExpression)expression);
    } else if (expression instanceof ShiftExpression) {
      return _inferType((ShiftExpression)expression);
    } else if (expression instanceof Expression) {
      return _inferType((Expression)expression);
    } else if (expression != null) {
      return _inferType(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
  
  public Type inferType(final EObject definition, final ElementReferenceExpression expression) {
    if (definition instanceof EventDefinition) {
      return _inferType((EventDefinition)definition, expression);
    } else if (definition instanceof OperationDefinition) {
      return _inferType((OperationDefinition)definition, expression);
    } else if (definition instanceof VariableDefinition) {
      return _inferType((VariableDefinition)definition, expression);
    } else if (definition != null) {
      return _inferType(definition, expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(definition, expression).toString());
    }
  }
  
  public Type getLiteralType(final Literal bool) {
    if (bool instanceof BoolLiteral) {
      return _getLiteralType((BoolLiteral)bool);
    } else if (bool instanceof HexLiteral) {
      return _getLiteralType((HexLiteral)bool);
    } else if (bool instanceof IntLiteral) {
      return _getLiteralType((IntLiteral)bool);
    } else if (bool instanceof RealLiteral) {
      return _getLiteralType((RealLiteral)bool);
    } else if (bool instanceof StringLiteral) {
      return _getLiteralType((StringLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bool).toString());
    }
  }
}
