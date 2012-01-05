package org.yakindu.sct.model.stext.validation;

import java.io.Serializable;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaising;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
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
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.validation.TypeCheckException;

@SuppressWarnings("all")
public class StaticTypeAnalyzer {
  
  public boolean isBoolean(final Type type) {
    boolean _operator_and = false;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(type, null);
    if (!_operator_notEquals) {
      _operator_and = false;
    } else {
      String _name = type.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "boolean");
      _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
    }
    return _operator_and;
  }
  
  public boolean isInteger(final Type type) {
    boolean _operator_and = false;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(type, null);
    if (!_operator_notEquals) {
      _operator_and = false;
    } else {
      String _name = type.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "integer");
      _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
    }
    return _operator_and;
  }
  
  public boolean isReal(final Type type) {
    boolean _operator_and = false;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(type, null);
    if (!_operator_notEquals) {
      _operator_and = false;
    } else {
      String _name = type.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "real");
      _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
    }
    return _operator_and;
  }
  
  protected Class<? extends Object> _check(final Assignment assignment) throws TypeCheckException {
    {
      Expression _expression = assignment.getExpression();
      Class<? extends Object> _check = this.check(_expression);
      Class<? extends Object> valueType = _check;
      Variable _varRef = assignment.getVarRef();
      Variable ref = _varRef;
      Type _type = ((VariableDefinition) ref).getType();
      Type type = _type;
      boolean _operator_and = false;
      boolean _isBoolean = this.isBoolean(type);
      if (!_isBoolean) {
        _operator_and = false;
      } else {
        boolean _operator_equals = ObjectExtensions.operator_equals(valueType, java.lang.Boolean.class);
        boolean _operator_not = BooleanExtensions.operator_not(_operator_equals);
        _operator_and = BooleanExtensions.operator_and(_isBoolean, _operator_not);
      }
      if (_operator_and) {
        String _simpleName = valueType.getSimpleName();
        String _operator_plus = StringExtensions.operator_plus("Can not assign a value of type ", _simpleName);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " to a variable of type ");
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, type);
        this.error(_operator_plus_2);
      } else {
        boolean _operator_and_1 = false;
        boolean _isInteger = this.isInteger(type);
        if (!_isInteger) {
          _operator_and_1 = false;
        } else {
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(valueType, java.lang.Number.class);
          boolean _operator_not_1 = BooleanExtensions.operator_not(_operator_equals_1);
          _operator_and_1 = BooleanExtensions.operator_and(_isInteger, _operator_not_1);
        }
        if (_operator_and_1) {
          String _simpleName_1 = valueType.getSimpleName();
          String _operator_plus_3 = StringExtensions.operator_plus("Can not assign a value of type ", _simpleName_1);
          String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, " to a variable of type ");
          String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, type);
          this.error(_operator_plus_5);
        } else {
          boolean _operator_and_2 = false;
          boolean _isReal = this.isReal(type);
          if (!_isReal) {
            _operator_and_2 = false;
          } else {
            boolean _operator_equals_2 = ObjectExtensions.operator_equals(valueType, java.lang.Number.class);
            boolean _operator_not_2 = BooleanExtensions.operator_not(_operator_equals_2);
            _operator_and_2 = BooleanExtensions.operator_and(_isReal, _operator_not_2);
          }
          if (_operator_and_2) {
            String _simpleName_2 = valueType.getSimpleName();
            String _operator_plus_6 = StringExtensions.operator_plus("Can not assign a value of type ", _simpleName_2);
            String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, " to a variable of type ");
            String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, type);
            this.error(_operator_plus_8);
          }
        }
      }
      return null;
    }
  }
  
  protected Class<? extends Object> _check(final EventRaising eventRaising) throws TypeCheckException {
    {
      Expression _value = eventRaising.getValue();
      Class<? extends Object> _check = this.check(_value);
      Class<? extends Object> valueType = _check;
      Event _event = eventRaising.getEvent();
      Event ref = _event;
      Type _type = ((EventDefinition) ref).getType();
      Type type = _type;
      boolean _operator_and = false;
      boolean _isBoolean = this.isBoolean(type);
      if (!_isBoolean) {
        _operator_and = false;
      } else {
        boolean _operator_equals = ObjectExtensions.operator_equals(valueType, java.lang.Boolean.class);
        boolean _operator_not = BooleanExtensions.operator_not(_operator_equals);
        _operator_and = BooleanExtensions.operator_and(_isBoolean, _operator_not);
      }
      if (_operator_and) {
        String _simpleName = valueType.getSimpleName();
        String _operator_plus = StringExtensions.operator_plus("Can not assign a value of type ", _simpleName);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " to an event of type ");
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, type);
        this.error(_operator_plus_2);
      } else {
        boolean _operator_and_1 = false;
        boolean _isInteger = this.isInteger(type);
        if (!_isInteger) {
          _operator_and_1 = false;
        } else {
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(valueType, java.lang.Number.class);
          boolean _operator_not_1 = BooleanExtensions.operator_not(_operator_equals_1);
          _operator_and_1 = BooleanExtensions.operator_and(_isInteger, _operator_not_1);
        }
        if (_operator_and_1) {
          String _simpleName_1 = valueType.getSimpleName();
          String _operator_plus_3 = StringExtensions.operator_plus("Can not assign a value of type ", _simpleName_1);
          String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, " to an event of type ");
          String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, type);
          this.error(_operator_plus_5);
        } else {
          boolean _operator_and_2 = false;
          boolean _isReal = this.isReal(type);
          if (!_isReal) {
            _operator_and_2 = false;
          } else {
            boolean _operator_equals_2 = ObjectExtensions.operator_equals(valueType, java.lang.Number.class);
            boolean _operator_not_2 = BooleanExtensions.operator_not(_operator_equals_2);
            _operator_and_2 = BooleanExtensions.operator_and(_isReal, _operator_not_2);
          }
          if (_operator_and_2) {
            String _simpleName_2 = valueType.getSimpleName();
            String _operator_plus_6 = StringExtensions.operator_plus("Can not assign a value of type ", _simpleName_2);
            String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, " to an event  type ");
            String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, type);
            this.error(_operator_plus_8);
          }
        }
      }
      return null;
    }
  }
  
  protected Class<? extends Object> _check(final LogicalAndExpression expression) throws TypeCheckException {
    Class<Boolean> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsBoolean(_check, "&&");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsBoolean(_check_1, "&&");
      _xblockexpression = (java.lang.Boolean.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final LogicalOrExpression expression) throws TypeCheckException {
    Class<Boolean> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsBoolean(_check, "||");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsBoolean(_check_1, "||");
      _xblockexpression = (java.lang.Boolean.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final LogicalNotExpression expression) throws TypeCheckException {
    Class<Boolean> _xblockexpression = null;
    {
      Expression _operand = expression.getOperand();
      Class<? extends Object> _check = this.check(_operand);
      this.assertIsBoolean(_check, "!");
      _xblockexpression = (java.lang.Boolean.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final BitwiseAndExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsNumber(_check, "&");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsNumber(_check_1, "&");
      _xblockexpression = (java.lang.Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final BitwiseOrExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsNumber(_check, "|");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsNumber(_check_1, "|");
      _xblockexpression = (java.lang.Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final BitwiseXorExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsNumber(_check, "^");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsNumber(_check_1, "^");
      _xblockexpression = (java.lang.Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final LogicalRelationExpression expression) throws TypeCheckException {
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      Class<? extends Object> leftType = _check;
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      Class<? extends Object> rightType = _check_1;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(leftType, rightType);
      if (_operator_notEquals) {
        String _name = leftType.getName();
        String _operator_plus = StringExtensions.operator_plus("Incompatible operands ", _name);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " and ");
        String _name_1 = rightType.getName();
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _name_1);
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, " for operator \'");
        RelationalOperator _operator = expression.getOperator();
        String _literal = _operator.getLiteral();
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, _literal);
        String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, "\'");
        this.error(_operator_plus_5);
      }
      boolean _operator_and = false;
      boolean _operator_equals = ObjectExtensions.operator_equals(leftType, java.lang.Boolean.class);
      if (!_operator_equals) {
        _operator_and = false;
      } else {
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(rightType, java.lang.Boolean.class);
        _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
      }
      if (_operator_and) {
        boolean _operator_and_1 = false;
        RelationalOperator _operator_1 = expression.getOperator();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_operator_1, RelationalOperator.EQUALS);
        if (!_operator_notEquals_1) {
          _operator_and_1 = false;
        } else {
          RelationalOperator _operator_2 = expression.getOperator();
          boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_operator_2, RelationalOperator.NOT_EQUALS);
          _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_1, _operator_notEquals_2);
        }
        if (_operator_and_1) {
          RelationalOperator _operator_3 = expression.getOperator();
          String _literal_1 = _operator_3.getLiteral();
          String _operator_plus_6 = StringExtensions.operator_plus("operator \'", _literal_1);
          String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, "\' can not be applied to boolean values!");
          this.error(_operator_plus_7);
        }
      }
      return java.lang.Boolean.class;
    }
  }
  
  protected Class<? extends Object> _check(final NumericalAddSubtractExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      AdditiveOperator _operator = expression.getOperator();
      String _literal = _operator.getLiteral();
      this.assertIsNumber(_check, _literal);
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      AdditiveOperator _operator_1 = expression.getOperator();
      String _literal_1 = _operator_1.getLiteral();
      this.assertIsNumber(_check_1, _literal_1);
      _xblockexpression = (java.lang.Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final NumericalMultiplyDivideExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      MultiplicativeOperator _operator = expression.getOperator();
      String _literal = _operator.getLiteral();
      this.assertIsNumber(_check, _literal);
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      MultiplicativeOperator _operator_1 = expression.getOperator();
      String _literal_1 = _operator_1.getLiteral();
      this.assertIsNumber(_check_1, _literal_1);
      _xblockexpression = (java.lang.Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final NumericalUnaryExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _operand = expression.getOperand();
      Class<? extends Object> _check = this.check(_operand);
      UnaryOperator _operator = expression.getOperator();
      String _literal = _operator.getLiteral();
      this.assertIsNumber(_check, _literal);
      _xblockexpression = (java.lang.Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    Class<? extends Serializable> _type = this.type(_value);
    return _type;
  }
  
  protected Class<? extends Object> _check(final ShiftExpression expression) {
    return null;
  }
  
  protected Class<? extends Object> _check(final ConditionalExpression expression) {
    return null;
  }
  
  protected Class<? extends Object> _check(final ElementReferenceExpression expression) {
    {
      Declaration _value = expression.getValue();
      Declaration declaration = _value;
      if ((declaration instanceof org.yakindu.sct.model.stext.stext.VariableDefinition)) {
        Type _type = ((VariableDefinition) declaration).getType();
        Class<? extends Object> _javaType = this.toJavaType(_type);
        return _javaType;
      }
      return null;
    }
  }
  
  protected Class<? extends Object> _check(final EventValueReferenceExpression expression) {
    return null;
  }
  
  protected Class<? extends Serializable> _type(final IntLiteral literal) {
    return java.lang.Number.class;
  }
  
  protected Class<? extends Serializable> _type(final BoolLiteral bool) {
    return java.lang.Boolean.class;
  }
  
  protected Class<? extends Serializable> _type(final RealLiteral literal) {
    return java.lang.Number.class;
  }
  
  public Class<? extends Object> toJavaType(final Type type) {
    {
      boolean _isBoolean = this.isBoolean(type);
      if (_isBoolean) {
        return java.lang.Boolean.class;
      } else {
        boolean _isInteger = this.isInteger(type);
        if (_isInteger) {
          return java.lang.Number.class;
        } else {
          boolean _isReal = this.isReal(type);
          if (_isReal) {
            return java.lang.Number.class;
          }
        }
      }
      return java.lang.Void.class;
    }
  }
  
  public Object assertIsNumber(final Object object, final String operator) throws TypeCheckException {
    Object _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(object, java.lang.Number.class);
    boolean _operator_not = BooleanExtensions.operator_not(_operator_equals);
    if (_operator_not) {
      String _operator_plus = StringExtensions.operator_plus("operator \'", operator);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' can only be applied to numbers!");
      this.error(_operator_plus_1);
    }
    return _xifexpression;
  }
  
  public Object assertIsBoolean(final Object object, final String operator) throws TypeCheckException {
    Object _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(object, java.lang.Boolean.class);
    boolean _operator_not = BooleanExtensions.operator_not(_operator_equals);
    if (_operator_not) {
      String _operator_plus = StringExtensions.operator_plus("operator \'", operator);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' can only ne applied to boolean values!");
      this.error(_operator_plus_1);
    }
    return _xifexpression;
  }
  
  public void error(final String msg) throws TypeCheckException {
    TypeCheckException _typeCheckException = new TypeCheckException(msg);
    throw _typeCheckException;
  }
  
  public Class<? extends Object> check(final Statement expression) throws TypeCheckException {
    if ((expression instanceof BitwiseAndExpression)) {
      return _check((BitwiseAndExpression)expression);
    } else if ((expression instanceof BitwiseOrExpression)) {
      return _check((BitwiseOrExpression)expression);
    } else if ((expression instanceof BitwiseXorExpression)) {
      return _check((BitwiseXorExpression)expression);
    } else if ((expression instanceof ConditionalExpression)) {
      return _check((ConditionalExpression)expression);
    } else if ((expression instanceof ElementReferenceExpression)) {
      return _check((ElementReferenceExpression)expression);
    } else if ((expression instanceof EventValueReferenceExpression)) {
      return _check((EventValueReferenceExpression)expression);
    } else if ((expression instanceof LogicalAndExpression)) {
      return _check((LogicalAndExpression)expression);
    } else if ((expression instanceof LogicalNotExpression)) {
      return _check((LogicalNotExpression)expression);
    } else if ((expression instanceof LogicalOrExpression)) {
      return _check((LogicalOrExpression)expression);
    } else if ((expression instanceof LogicalRelationExpression)) {
      return _check((LogicalRelationExpression)expression);
    } else if ((expression instanceof NumericalAddSubtractExpression)) {
      return _check((NumericalAddSubtractExpression)expression);
    } else if ((expression instanceof NumericalMultiplyDivideExpression)) {
      return _check((NumericalMultiplyDivideExpression)expression);
    } else if ((expression instanceof NumericalUnaryExpression)) {
      return _check((NumericalUnaryExpression)expression);
    } else if ((expression instanceof PrimitiveValueExpression)) {
      return _check((PrimitiveValueExpression)expression);
    } else if ((expression instanceof ShiftExpression)) {
      return _check((ShiftExpression)expression);
    } else if ((expression instanceof Assignment)) {
      return _check((Assignment)expression);
    } else if ((expression instanceof EventRaising)) {
      return _check((EventRaising)expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(expression).toString());
    }
  }
  
  public Class<? extends Serializable> type(final Literal bool) {
    if ((bool instanceof BoolLiteral)) {
      return _type((BoolLiteral)bool);
    } else if ((bool instanceof IntLiteral)) {
      return _type((IntLiteral)bool);
    } else if ((bool instanceof RealLiteral)) {
      return _type((RealLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(bool).toString());
    }
  }
}