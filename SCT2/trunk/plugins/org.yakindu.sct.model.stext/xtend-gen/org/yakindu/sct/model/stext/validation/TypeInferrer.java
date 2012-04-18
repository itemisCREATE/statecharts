package org.yakindu.sct.model.stext.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.scope.TypeLibraryLocation.Registry;
import org.yakindu.sct.model.sgraph.Statement;
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
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.StringLiteral;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;
import org.yakindu.sct.model.stext.validation.TypeInferrerCache;
import org.yakindu.sct.model.stext.validation.TypeInferrerCache.ICacheableTypeAnalyzer;

@SuppressWarnings("all")
public class TypeInferrer implements ITypeInferrer, ICacheableTypeAnalyzer {
  
  @Inject
  private Registry libraries;
  
  @Inject
  private ITypeSystemAccess ts;
  
  @Inject
  private TypeInferrerCache cache;
  
  public Type getType(final Statement stmt) {
    Type _get = this.cache.get(stmt, this);
    return _get;
  }
  
  protected Type _inferType(final Statement statement) {
    return null;
  }
  
  public Type check(final Statement stmt) {
    Type _type = this.getType(stmt);
    return _type;
  }
  
  protected Type _inferType(final AssignmentExpression assignment) throws TypeCheckException {
    {
      Expression _expression = assignment.getExpression();
      Type _type = this.getType(_expression);
      Type valueType = _type;
      Expression _varRef = assignment.getVarRef();
      Type _type_1 = this.getType(_varRef);
      Type type = _type_1;
      boolean _isAssignable = this.ts.isAssignable(type, valueType);
      boolean _operator_not = BooleanExtensions.operator_not(_isAssignable);
      if (_operator_not) {
        {
          String _name = valueType==null?(String)null:valueType.getName();
          String _operator_plus = StringExtensions.operator_plus("Can not assign a value of type ", _name);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " to a variable of type ");
          String _name_1 = type==null?(String)null:type.getName();
          String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _name_1);
          this.error(_operator_plus_2);
          return null;
        }
      }
      return type;
    }
  }
  
  protected Type _inferType(final EventRaisingExpression eventRaising) throws TypeCheckException {
    {
      Expression _value = eventRaising.getValue();
      Type _type = this.getType(_value);
      Type valueType = _type;
      Expression _event = eventRaising.getEvent();
      Type _type_1 = this.getType(_event);
      Type type = _type_1;
      boolean _isAssignable = this.ts.isAssignable(type, valueType);
      boolean _operator_not = BooleanExtensions.operator_not(_isAssignable);
      if (_operator_not) {
        {
          String _name = valueType==null?(String)null:valueType.getName();
          String _operator_plus = StringExtensions.operator_plus("Can not assign a value of type ", _name);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " to a variable of type ");
          String _name_1 = type==null?(String)null:type.getName();
          String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _name_1);
          this.error(_operator_plus_2);
          return null;
        }
      }
      return type;
    }
  }
  
  protected Type _inferType(final LogicalAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    Type _assertBooleanTypes = this.assertBooleanTypes(_type, _type_1, "&&");
    return _assertBooleanTypes;
  }
  
  protected Type _inferType(final LogicalOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    Type _assertBooleanTypes = this.assertBooleanTypes(_type, _type_1, "||");
    return _assertBooleanTypes;
  }
  
  public Type assertBooleanTypes(final Type left, final Type right, final String literal) throws TypeCheckException {
    {
      boolean _operator_and = false;
      Type _assertIsBoolean = this.assertIsBoolean(left, literal);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_assertIsBoolean, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Type _assertIsBoolean_1 = this.assertIsBoolean(right, literal);
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_assertIsBoolean_1, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        Type _combine = this.ts.combine(left, right);
        return _combine;
      }
      return null;
    }
  }
  
  protected Type _inferType(final LogicalNotExpression expression) {
    {
      Expression _operand = expression.getOperand();
      Type _type = this.getType(_operand);
      final Type type = _type;
      Type _assertIsBoolean = this.assertIsBoolean(type, "!");
      return _assertIsBoolean;
    }
  }
  
  protected Type _inferType(final BitwiseAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    Type _assertNumericalTypes = this.assertNumericalTypes(_type, _type_1, "&");
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    Type _assertNumericalTypes = this.assertNumericalTypes(_type, _type_1, "|");
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    Type _assertNumericalTypes = this.assertNumericalTypes(_type, _type_1, "^");
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final LogicalRelationExpression expression) throws TypeCheckException {
    {
      Expression _leftOperand = expression.getLeftOperand();
      Type _type = this.getType(_leftOperand);
      final Type leftType = _type;
      Expression _rightOperand = expression.getRightOperand();
      Type _type_1 = this.getType(_rightOperand);
      final Type rightType = _type_1;
      boolean _operator_and = false;
      boolean _isBoolean = this.ts.isBoolean(leftType);
      if (!_isBoolean) {
        _operator_and = false;
      } else {
        boolean _isBoolean_1 = this.ts.isBoolean(rightType);
        _operator_and = BooleanExtensions.operator_and(_isBoolean, _isBoolean_1);
      }
      if (_operator_and) {
        boolean _operator_and_1 = false;
        RelationalOperator _operator = expression.getOperator();
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_operator, RelationalOperator.EQUALS);
        if (!_operator_notEquals) {
          _operator_and_1 = false;
        } else {
          RelationalOperator _operator_1 = expression.getOperator();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_operator_1, RelationalOperator.NOT_EQUALS);
          _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
        }
        if (_operator_and_1) {
          {
            RelationalOperator _operator_2 = expression.getOperator();
            String _literal = _operator_2==null?(String)null:_operator_2.getLiteral();
            String _operator_plus = StringExtensions.operator_plus("operator \'", _literal);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' can not be applied to boolean values!");
            this.error(_operator_plus_1);
            return null;
          }
        }
      } else {
        {
          Type _combine = this.ts.combine(leftType, rightType);
          final Type combined = _combine;
          boolean _operator_equals = ObjectExtensions.operator_equals(combined, null);
          if (_operator_equals) {
            String _name = leftType==null?(String)null:leftType.getName();
            String _operator_plus_2 = StringExtensions.operator_plus("Incompatible operands ", _name);
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, " and ");
            String _name_1 = rightType==null?(String)null:rightType.getName();
            String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, _name_1);
            String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, " for operator \'");
            RelationalOperator _operator_3 = expression.getOperator();
            String _literal_1 = _operator_3.getLiteral();
            String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, _literal_1);
            String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, "\'");
            this.error(_operator_plus_7);
          }
        }
      }
      Type _boolean = this.ts.getBoolean();
      return _boolean;
    }
  }
  
  public Type assertNumericalTypes(final Type left, final Type right, final String literal) throws TypeCheckException {
    {
      boolean _operator_and = false;
      Type _assertIsNumber = this.assertIsNumber(left, literal);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_assertIsNumber, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Type _assertIsNumber_1 = this.assertIsNumber(right, literal);
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_assertIsNumber_1, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        Type _combine = this.ts.combine(left, right);
        return _combine;
      }
      return null;
    }
  }
  
  protected Type _inferType(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    AdditiveOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    Type _assertNumericalTypes = this.assertNumericalTypes(_type, _type_1, _literal);
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _type = this.getType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _type_1 = this.getType(_rightOperand);
    MultiplicativeOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    Type _assertNumericalTypes = this.assertNumericalTypes(_type, _type_1, _literal);
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final NumericalUnaryExpression expression) {
    {
      Expression _operand = expression.getOperand();
      Type _type = this.getType(_operand);
      final Type type = _type;
      UnaryOperator _operator = expression.getOperator();
      String _literal = _operator.getLiteral();
      Type _assertIsNumber = this.assertIsNumber(type, _literal);
      return _assertIsNumber;
    }
  }
  
  protected Type _inferType(final PrimitiveValueExpression expression) {
    {
      Literal _value = expression.getValue();
      Type _type = this.getType(_value);
      final Type t = _type;
      return t;
    }
  }
  
  protected Type _inferType(final ShiftExpression expression) {
    return null;
  }
  
  protected Type _inferType(final ConditionalExpression expression) throws TypeCheckException {
    {
      Expression _condition = expression.getCondition();
      Type _type = this.getType(_condition);
      final Type condType = _type;
      boolean _isBoolean = this.ts.isBoolean(condType);
      boolean _operator_not = BooleanExtensions.operator_not(_isBoolean);
      if (_operator_not) {
        {
          this.error("Condition type have to be boolean");
          return null;
        }
      }
      Expression _trueCase = expression.getTrueCase();
      Type _type_1 = this.getType(_trueCase);
      final Type trueType = _type_1;
      Expression _falseCase = expression.getFalseCase();
      Type _type_2 = this.getType(_falseCase);
      final Type falseType = _type_2;
      Type _combine = this.ts.combine(trueType, falseType);
      return _combine;
    }
  }
  
  protected Type _inferType(final FeatureCall featureCall) {
    EObject _feature = featureCall.getFeature();
    Type _type = ((Feature) _feature)==null?(Type)null:((Feature) _feature).getType();
    return _type;
  }
  
  protected Type _inferType(final ElementReferenceExpression expression) {
    Type _xblockexpression = null;
    {
      EObject _reference = expression.getReference();
      EObject reference = _reference;
      if ((reference instanceof org.yakindu.sct.model.stext.stext.VariableDefinition)) {
        Type _type = ((VariableDefinition) reference).getType();
        return _type;
      }
      if ((reference instanceof org.yakindu.sct.model.stext.stext.EventDefinition)) {
        boolean _operator_or = false;
        EObject _eContainer = expression.eContainer();
        if ((_eContainer instanceof org.yakindu.sct.model.stext.stext.EventRaisingExpression)) {
          _operator_or = true;
        } else {
          EObject _eContainer_1 = expression.eContainer();
          _operator_or = BooleanExtensions.operator_or((_eContainer instanceof org.yakindu.sct.model.stext.stext.EventRaisingExpression), (_eContainer_1 instanceof org.yakindu.sct.model.stext.stext.EventValueReferenceExpression));
        }
        if (_operator_or) {
          Type _type_1 = ((EventDefinition) reference).getType();
          return _type_1;
        } else {
          Type _boolean = this.ts.getBoolean();
          return _boolean;
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Type _inferType(final EventValueReferenceExpression expression) {
    Expression _value = expression.getValue();
    Type _type = this.getType(_value);
    return _type;
  }
  
  protected Type _getType(final IntLiteral literal) {
    Type _integer = this.ts.getInteger();
    return _integer;
  }
  
  protected Type _getType(final BoolLiteral bool) {
    Type _boolean = this.ts.getBoolean();
    return _boolean;
  }
  
  protected Type _getType(final RealLiteral literal) {
    Type _real = this.ts.getReal();
    return _real;
  }
  
  protected Type _getType(final StringLiteral literal) {
    Type _string = this.ts.getString();
    return _string;
  }
  
  public Type assertIsNumber(final Type object, final String operator) throws TypeCheckException {
    {
      boolean _operator_and = false;
      boolean _isReal = this.ts.isReal(object);
      boolean _operator_not = BooleanExtensions.operator_not(_isReal);
      if (!_operator_not) {
        _operator_and = false;
      } else {
        boolean _isInteger = this.ts.isInteger(object);
        boolean _operator_not_1 = BooleanExtensions.operator_not(_isInteger);
        _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_not_1);
      }
      if (_operator_and) {
        {
          String _operator_plus = StringExtensions.operator_plus("operator \'", operator);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' can only be applied to numbers!");
          this.error(_operator_plus_1);
          return null;
        }
      }
      return object;
    }
  }
  
  public Type assertIsBoolean(final Type object, final String operator) throws TypeCheckException {
    {
      boolean _isBoolean = this.ts.isBoolean(object);
      boolean _operator_not = BooleanExtensions.operator_not(_isBoolean);
      if (_operator_not) {
        String _operator_plus = StringExtensions.operator_plus("operator \'", operator);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' can only be applied to boolean values!");
        this.error(_operator_plus_1);
      }
      return object;
    }
  }
  
  public void error(final String msg) throws TypeCheckException {
    TypeCheckException _typeCheckException = new TypeCheckException(msg);
    throw _typeCheckException;
  }
  
  protected Type _inferType(final Expression expr) {
    return null;
  }
  
  public Type inferType(final Statement assignment) throws TypeCheckException {
    if ((assignment instanceof AssignmentExpression)) {
      return _inferType((AssignmentExpression)assignment);
    } else if ((assignment instanceof BitwiseAndExpression)) {
      return _inferType((BitwiseAndExpression)assignment);
    } else if ((assignment instanceof BitwiseOrExpression)) {
      return _inferType((BitwiseOrExpression)assignment);
    } else if ((assignment instanceof BitwiseXorExpression)) {
      return _inferType((BitwiseXorExpression)assignment);
    } else if ((assignment instanceof ConditionalExpression)) {
      return _inferType((ConditionalExpression)assignment);
    } else if ((assignment instanceof ElementReferenceExpression)) {
      return _inferType((ElementReferenceExpression)assignment);
    } else if ((assignment instanceof EventRaisingExpression)) {
      return _inferType((EventRaisingExpression)assignment);
    } else if ((assignment instanceof EventValueReferenceExpression)) {
      return _inferType((EventValueReferenceExpression)assignment);
    } else if ((assignment instanceof FeatureCall)) {
      return _inferType((FeatureCall)assignment);
    } else if ((assignment instanceof LogicalAndExpression)) {
      return _inferType((LogicalAndExpression)assignment);
    } else if ((assignment instanceof LogicalNotExpression)) {
      return _inferType((LogicalNotExpression)assignment);
    } else if ((assignment instanceof LogicalOrExpression)) {
      return _inferType((LogicalOrExpression)assignment);
    } else if ((assignment instanceof LogicalRelationExpression)) {
      return _inferType((LogicalRelationExpression)assignment);
    } else if ((assignment instanceof NumericalAddSubtractExpression)) {
      return _inferType((NumericalAddSubtractExpression)assignment);
    } else if ((assignment instanceof NumericalMultiplyDivideExpression)) {
      return _inferType((NumericalMultiplyDivideExpression)assignment);
    } else if ((assignment instanceof NumericalUnaryExpression)) {
      return _inferType((NumericalUnaryExpression)assignment);
    } else if ((assignment instanceof PrimitiveValueExpression)) {
      return _inferType((PrimitiveValueExpression)assignment);
    } else if ((assignment instanceof ShiftExpression)) {
      return _inferType((ShiftExpression)assignment);
    } else if ((assignment instanceof Expression)) {
      return _inferType((Expression)assignment);
    } else if ((assignment instanceof Statement)) {
      return _inferType((Statement)assignment);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(assignment).toString());
    }
  }
  
  public Type getType(final Literal bool) {
    if ((bool instanceof BoolLiteral)) {
      return _getType((BoolLiteral)bool);
    } else if ((bool instanceof IntLiteral)) {
      return _getType((IntLiteral)bool);
    } else if ((bool instanceof RealLiteral)) {
      return _getType((RealLiteral)bool);
    } else if ((bool instanceof StringLiteral)) {
      return _getType((StringLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(bool).toString());
    }
  }
}