package org.yakindu.sct.model.stext.validation;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.scope.TypeLibraryLocation.Registry;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
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
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.validation.ITypeAnalyzer;
import org.yakindu.sct.model.stext.validation.ITypeCheckErrorAcceptor;

@SuppressWarnings("all")
public class StaticTypeAnalyzer implements ITypeAnalyzer {
  
  @Inject
  private Registry libraries;
  
  @Inject
  private ITypeCheckErrorAcceptor acceptor;
  
  protected Type _inferType(final Statement statement) {
    return null;
  }
  
  public Type check(final Statement stmt) {
    Type _inferType = this.inferType(stmt);
    return _inferType;
  }
  
  protected Type _inferType(final AssignmentExpression assignment) {
    {
      Expression _expression = assignment.getExpression();
      Type _inferType = this.inferType(_expression);
      Type valueType = _inferType;
      Expression _varRef = assignment.getVarRef();
      Type _inferType_1 = this.inferType(_varRef);
      Type type = _inferType_1;
      boolean _isAssignable = this.isAssignable(type, valueType);
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
  
  protected Type _inferType(final EventRaisingExpression eventRaising) {
    {
      Expression _value = eventRaising.getValue();
      Type _inferType = this.inferType(_value);
      Type valueType = _inferType;
      Expression _event = eventRaising.getEvent();
      Type _inferType_1 = this.inferType(_event);
      Type type = _inferType_1;
      boolean _isAssignable = this.isAssignable(type, valueType);
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
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    Type _assertBooleanTypes = this.assertBooleanTypes(_inferType, _inferType_1, "&&");
    return _assertBooleanTypes;
  }
  
  protected Type _inferType(final LogicalOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    Type _assertBooleanTypes = this.assertBooleanTypes(_inferType, _inferType_1, "||");
    return _assertBooleanTypes;
  }
  
  public Type assertBooleanTypes(final Type left, final Type right, final String literal) {
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
        Type _combine = this.combine(left, right);
        return _combine;
      }
      return null;
    }
  }
  
  protected Type _inferType(final LogicalNotExpression expression) {
    {
      Expression _operand = expression.getOperand();
      Type _inferType = this.inferType(_operand);
      final Type type = _inferType;
      Type _assertIsBoolean = this.assertIsBoolean(type, "!");
      return _assertIsBoolean;
    }
  }
  
  protected Type _inferType(final BitwiseAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    Type _assertNumericalTypes = this.assertNumericalTypes(_inferType, _inferType_1, "&");
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    Type _assertNumericalTypes = this.assertNumericalTypes(_inferType, _inferType_1, "|");
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    Type _assertNumericalTypes = this.assertNumericalTypes(_inferType, _inferType_1, "^");
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final LogicalRelationExpression expression) {
    {
      Expression _leftOperand = expression.getLeftOperand();
      Type _inferType = this.inferType(_leftOperand);
      final Type leftType = _inferType;
      Expression _rightOperand = expression.getRightOperand();
      Type _inferType_1 = this.inferType(_rightOperand);
      final Type rightType = _inferType_1;
      boolean _operator_and = false;
      boolean _isBoolean = this.isBoolean(leftType);
      if (!_isBoolean) {
        _operator_and = false;
      } else {
        boolean _isBoolean_1 = this.isBoolean(rightType);
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
          Type _combine = this.combine(leftType, rightType);
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
      Type _createBoolean = this.createBoolean();
      return _createBoolean;
    }
  }
  
  public Type assertNumericalTypes(final Type left, final Type right, final String literal) {
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
        Type _combine = this.combine(left, right);
        return _combine;
      }
      return null;
    }
  }
  
  protected Type _inferType(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    AdditiveOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    Type _assertNumericalTypes = this.assertNumericalTypes(_inferType, _inferType_1, _literal);
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Type _inferType = this.inferType(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Type _inferType_1 = this.inferType(_rightOperand);
    MultiplicativeOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    Type _assertNumericalTypes = this.assertNumericalTypes(_inferType, _inferType_1, _literal);
    return _assertNumericalTypes;
  }
  
  protected Type _inferType(final NumericalUnaryExpression expression) {
    {
      Expression _operand = expression.getOperand();
      Type _inferType = this.inferType(_operand);
      final Type type = _inferType;
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
  
  protected Type _inferType(final ConditionalExpression expression) {
    {
      Expression _condition = expression.getCondition();
      Type _inferType = this.inferType(_condition);
      final Type condType = _inferType;
      boolean _isBoolean = this.isBoolean(condType);
      boolean _operator_not = BooleanExtensions.operator_not(_isBoolean);
      if (_operator_not) {
        {
          this.error("Condition type have to be boolean");
          return null;
        }
      }
      Expression _trueCase = expression.getTrueCase();
      Type _inferType_1 = this.inferType(_trueCase);
      final Type trueType = _inferType_1;
      Expression _falseCase = expression.getFalseCase();
      Type _inferType_2 = this.inferType(_falseCase);
      final Type falseType = _inferType_2;
      Type _combine = this.combine(trueType, falseType);
      return _combine;
    }
  }
  
  protected Type _inferType(final FeatureCall featureCall) {
    Feature _feature = featureCall.getFeature();
    Type _type = _feature==null?(Type)null:_feature.getType();
    return _type;
  }
  
  protected Type _inferType(final TypedElementReferenceExpression expression) {
    Type _xblockexpression = null;
    {
      NamedElement _reference = expression.getReference();
      NamedElement reference = _reference;
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
          Type _createBoolean = this.createBoolean();
          return _createBoolean;
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public Type createBoolean() {
    {
      Type _createType = TypesFactory.eINSTANCE.createType();
      final Type type = _createType;
      type.setName("boolean");
      return type;
    }
  }
  
  protected Type _inferType(final EventValueReferenceExpression expression) {
    Expression _value = expression.getValue();
    Type _inferType = this.inferType(_value);
    return _inferType;
  }
  
  protected Type _getType(final IntLiteral literal) {
    Type _createInteger = this.createInteger();
    return _createInteger;
  }
  
  public Type createInteger() {
    {
      Type _createType = TypesFactory.eINSTANCE.createType();
      final Type type = _createType;
      type.setName("integer");
      return type;
    }
  }
  
  protected Type _getType(final BoolLiteral bool) {
    Type _createBoolean = this.createBoolean();
    return _createBoolean;
  }
  
  protected Type _getType(final RealLiteral literal) {
    Type _createReal = this.createReal();
    return _createReal;
  }
  
  protected Type _getType(final StringLiteral literal) {
    Type _createString = this.createString();
    return _createString;
  }
  
  public Type createReal() {
    {
      Type _createType = TypesFactory.eINSTANCE.createType();
      final Type type = _createType;
      type.setName("real");
      return type;
    }
  }
  
  public Type createString() {
    {
      Type _createType = TypesFactory.eINSTANCE.createType();
      final Type type = _createType;
      type.setName("string");
      return type;
    }
  }
  
  public Type assertIsNumber(final Type object, final String operator) {
    {
      boolean _operator_and = false;
      boolean _isReal = this.isReal(object);
      boolean _operator_not = BooleanExtensions.operator_not(_isReal);
      if (!_operator_not) {
        _operator_and = false;
      } else {
        boolean _isInteger = this.isInteger(object);
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
  
  public Type assertIsBoolean(final Type object, final String operator) {
    {
      boolean _isBoolean = this.isBoolean(object);
      boolean _operator_not = BooleanExtensions.operator_not(_isBoolean);
      if (_operator_not) {
        String _operator_plus = StringExtensions.operator_plus("operator \'", operator);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' can only be applied to boolean values!");
        this.error(_operator_plus_1);
      }
      return object;
    }
  }
  
  public Object error(final String msg) {
    Object _xifexpression = null;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(this.acceptor, null);
    if (_operator_notEquals) {
      this.acceptor.acceptError(msg);
    }
    return _xifexpression;
  }
  
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
      boolean _operator_or = false;
      String _name = type.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "integer");
      if (_operator_equals) {
        _operator_or = true;
      } else {
        String _name_1 = type.getName();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, "int");
        _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_or);
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
  
  public boolean isString(final Type type) {
    boolean _operator_and = false;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(type, null);
    if (!_operator_notEquals) {
      _operator_and = false;
    } else {
      String _name = type.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "string");
      _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
    }
    return _operator_and;
  }
  
  protected Type _inferType(final Expression expr) {
    return null;
  }
  
  public boolean isAssignable(final Type expected, final Type actual) {
    {
      Type _combine = this.combine(expected, actual);
      boolean _equals = expected==null?false:expected.equals(_combine);
      if (_equals) {
        return true;
      }
      boolean _operator_and = false;
      boolean _operator_or = false;
      boolean _isInteger = this.isInteger(expected);
      if (_isInteger) {
        _operator_or = true;
      } else {
        boolean _isReal = this.isReal(expected);
        _operator_or = BooleanExtensions.operator_or(_isInteger, _isReal);
      }
      if (!_operator_or) {
        _operator_and = false;
      } else {
        boolean _operator_or_1 = false;
        boolean _isInteger_1 = this.isInteger(actual);
        if (_isInteger_1) {
          _operator_or_1 = true;
        } else {
          boolean _isReal_1 = this.isReal(actual);
          _operator_or_1 = BooleanExtensions.operator_or(_isInteger_1, _isReal_1);
        }
        _operator_and = BooleanExtensions.operator_and(_operator_or, _operator_or_1);
      }
      if (_operator_and) {
        return true;
      }
      return false;
    }
  }
  
  public Type combine(final Type typeOne, final Type typeTwo) {
    {
      boolean _operator_or = false;
      boolean _operator_equals = ObjectExtensions.operator_equals(typeOne, null);
      if (_operator_equals) {
        _operator_or = true;
      } else {
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(typeTwo, null);
        _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or) {
        return null;
      }
      boolean _operator_or_1 = false;
      boolean _equals = typeOne.equals(typeTwo);
      if (_equals) {
        _operator_or_1 = true;
      } else {
        String _name = typeOne.getName();
        String _name_1 = typeTwo.getName();
        boolean _equals_1 = _name.equals(_name_1);
        _operator_or_1 = BooleanExtensions.operator_or(_equals, _equals_1);
      }
      if (_operator_or_1) {
        return typeOne;
      }
      boolean _operator_and = false;
      boolean _isInteger = this.isInteger(typeOne);
      if (!_isInteger) {
        _operator_and = false;
      } else {
        boolean _isReal = this.isReal(typeTwo);
        _operator_and = BooleanExtensions.operator_and(_isInteger, _isReal);
      }
      if (_operator_and) {
        return typeTwo;
      }
      boolean _operator_and_1 = false;
      boolean _isReal_1 = this.isReal(typeOne);
      if (!_isReal_1) {
        _operator_and_1 = false;
      } else {
        boolean _isInteger_1 = this.isInteger(typeTwo);
        _operator_and_1 = BooleanExtensions.operator_and(_isReal_1, _isInteger_1);
      }
      if (_operator_and_1) {
        return typeOne;
      }
      LinkedHashSet<Type> _allSuperTypes = this.allSuperTypes(typeOne);
      final LinkedHashSet<Type> typesOne = _allSuperTypes;
      LinkedHashSet<Type> _allSuperTypes_1 = this.allSuperTypes(typeTwo);
      final LinkedHashSet<Type> typesTwo = _allSuperTypes_1;
      final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
          public Boolean apply(final Type t) {
            boolean _contains = typesTwo.contains(t);
            return ((Boolean)_contains);
          }
        };
      Type _findFirst = IterableExtensions.<Type>findFirst(typesOne, _function);
      final Type superType = _findFirst;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(superType, null);
      if (_operator_notEquals) {
        return superType;
      }
      return null;
    }
  }
  
  public LinkedHashSet<Type> allSuperTypes(final Type type) {
    {
      LinkedHashSet<Type> _newLinkedHashSet = CollectionLiterals.<Type>newLinkedHashSet();
      final LinkedHashSet<Type> types = _newLinkedHashSet;
      types.add(type);
      ArrayList<Type> _newArrayList = CollectionLiterals.<Type>newArrayList();
      ArrayList<Type> newSuperTypes = _newArrayList;
      EList<Type> _superTypes = type.getSuperTypes();
      newSuperTypes.addAll(_superTypes);
      boolean _isEmpty = newSuperTypes.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      Boolean _xwhileexpression = _operator_not;
      while (_xwhileexpression) {
        {
          final ArrayList<Type> oldSuperTypes = newSuperTypes;
          ArrayList<Type> _newArrayList_1 = CollectionLiterals.<Type>newArrayList();
          newSuperTypes = _newArrayList_1;
          for (final Type superType : oldSuperTypes) {
            boolean _contains = types.contains(superType);
            boolean _operator_not_1 = BooleanExtensions.operator_not(_contains);
            if (_operator_not_1) {
              {
                types.add(superType);
                EList<Type> _superTypes_1 = superType.getSuperTypes();
                newSuperTypes.addAll(_superTypes_1);
              }
            }
          }
        }
        boolean _isEmpty_1 = newSuperTypes.isEmpty();
        boolean _operator_not_2 = BooleanExtensions.operator_not(_isEmpty_1);
        _xwhileexpression = _operator_not_2;
      }
      return types;
    }
  }
  
  public Type inferType(final Statement assignment) {
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
    } else if ((assignment instanceof TypedElementReferenceExpression)) {
      return _inferType((TypedElementReferenceExpression)assignment);
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