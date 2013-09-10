/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.yakindu.base.types.Enumerator;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
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
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.StringLiteral;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.simulation.core.sexec.interpreter.AbstractStatementInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.CoreFunction;
import org.yakindu.sct.simulation.core.sexec.interpreter.IOperationMockup;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable;

/**
 * @author andreas muelder - Initial contribution and API
 * @authos axel terfloth - additions
 */
@SuppressWarnings("all")
public class StextStatementInterpreter extends AbstractStatementInterpreter {
  @Inject
  @Extension
  private IQualifiedNameProvider provider;
  
  @Inject
  private IOperationMockup operationDelegate;
  
  protected ExecutionContext context;
  
  public Object evaluateStatement(final Statement statement, final ExecutionContext context) {
    Object _xblockexpression = null;
    {
      this.context = context;
      Object _execute = this.execute(statement);
      _xblockexpression = (_execute);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Statement statement) {
    return null;
  }
  
  protected Object _execute(final AssignmentExpression assignment) {
    Object _xblockexpression = null;
    {
      Expression _varRef = assignment.getVarRef();
      EObject _variable = this.variable(_varRef);
      QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_variable);
      String _string = _fullyQualifiedName.toString();
      ExecutionVariable scopeVariable = this.context.getVariable(_string);
      Expression _expression = assignment.getExpression();
      Object result = this.execute(_expression);
      AssignmentOperator _operator = assignment.getOperator();
      boolean _equals = Objects.equal(_operator, AssignmentOperator.ASSIGN);
      if (_equals) {
        String _name = scopeVariable.getName();
        ExecutionVariable _variable_1 = this.context.getVariable(_name);
        _variable_1.setValue(result);
      } else {
        AssignmentOperator _operator_1 = assignment.getOperator();
        String _name_1 = _operator_1.getName();
        String operator = AbstractStatementInterpreter.assignFunctionMap.get(_name_1);
        String _name_2 = scopeVariable.getName();
        ExecutionVariable _variable_2 = this.context.getVariable(_name_2);
        Object _value = scopeVariable.getValue();
        Object _evaluate = this.evaluate(operator, _value, result);
        _variable_2.setValue(_evaluate);
      }
      String _name_3 = scopeVariable.getName();
      ExecutionVariable _variable_3 = this.context.getVariable(_name_3);
      Object _value_1 = _variable_3.getValue();
      _xblockexpression = (_value_1);
    }
    return _xblockexpression;
  }
  
  protected EObject _variable(final ElementReferenceExpression e) {
    EObject _xifexpression = null;
    EObject _reference = e.getReference();
    if ((_reference instanceof VariableDefinition)) {
      EObject _reference_1 = e.getReference();
      _xifexpression = _reference_1;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected EObject _variable(final FeatureCall e) {
    EObject _xifexpression = null;
    EObject _feature = e.getFeature();
    if ((_feature instanceof VariableDefinition)) {
      EObject _feature_1 = e.getFeature();
      _xifexpression = _feature_1;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected EObject _variable(final AssignmentExpression e) {
    Expression _varRef = e.getVarRef();
    EObject _variable = this.variable(_varRef);
    return ((EObject) _variable);
  }
  
  protected EObject _event(final ElementReferenceExpression e) {
    EObject _xifexpression = null;
    EObject _reference = e.getReference();
    if ((_reference instanceof EventDefinition)) {
      EObject _reference_1 = e.getReference();
      _xifexpression = _reference_1;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected EObject _event(final FeatureCall e) {
    EObject _xifexpression = null;
    EObject _feature = e.getFeature();
    if ((_feature instanceof EventDefinition)) {
      EObject _feature_1 = e.getFeature();
      _xifexpression = _feature_1;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected Object _execute(final EventRaisingExpression eventRaising) {
    Object _xblockexpression = null;
    {
      Expression _event = eventRaising.getEvent();
      EObject _event_1 = this.event(_event);
      QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_event_1);
      String _string = _fullyQualifiedName.toString();
      ExecutionEvent event = this.context.getEvent(_string);
      Expression _value = eventRaising.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
      if (_notEquals) {
        Expression _value_1 = eventRaising.getValue();
        Object _execute = this.execute(_value_1);
        event.setValue(_execute);
      }
      event.setRaised(true);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final ConditionalExpression expression) {
    Expression _condition = expression.getCondition();
    Object _execute = this.execute(_condition);
    if ((((Boolean) _execute)).booleanValue()) {
      Expression _trueCase = expression.getTrueCase();
      return this.execute(_trueCase);
    } else {
      Expression _falseCase = expression.getFalseCase();
      return this.execute(_falseCase);
    }
  }
  
  protected Object _execute(final ElementReferenceExpression expression) {
    EList<Expression> _args = expression.getArgs();
    final Function1<Expression,Object> _function = new Function1<Expression,Object>() {
        public Object apply(final Expression it) {
          Object _execute = StextStatementInterpreter.this.execute(it);
          return _execute;
        }
      };
    List<Object> parameter = ListExtensions.<Expression, Object>map(_args, _function);
    boolean _isOperationCall = expression.isOperationCall();
    if (_isOperationCall) {
      EObject _reference = expression.getReference();
      Object[] _array = parameter.toArray();
      boolean _canExecute = this.operationDelegate.canExecute(((OperationDefinition) _reference), _array);
      if (_canExecute) {
        EObject _reference_1 = expression.getReference();
        Object[] _array_1 = parameter.toArray();
        return this.operationDelegate.execute(((OperationDefinition) _reference_1), _array_1);
      }
    }
    EObject _reference_2 = expression.getReference();
    QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_reference_2);
    String _string = _fullyQualifiedName.toString();
    ExecutionVariable variableRef = this.context.getVariable(_string);
    boolean _notEquals = (!Objects.equal(variableRef, null));
    if (_notEquals) {
      return variableRef.getValue();
    }
    EObject _reference_3 = expression.getReference();
    QualifiedName _fullyQualifiedName_1 = this.provider.getFullyQualifiedName(_reference_3);
    String _string_1 = _fullyQualifiedName_1.toString();
    ExecutionEvent _event = this.context.getEvent(_string_1);
    return Boolean.valueOf(_event.isRaised());
  }
  
  protected Object _execute(final EventValueReferenceExpression expression) {
    Object _xblockexpression = null;
    {
      List<ExecutionEvent> _raisedEvents = this.context.getRaisedEvents();
      for (final ExecutionEvent event : _raisedEvents) {
        String _name = event.getName();
        Expression _value = expression.getValue();
        String _qname = this.qname(_value);
        boolean _equals = _name.equals(_qname);
        if (_equals) {
          return event.getValue();
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public String name(final EObject e) {
    return SimpleAttributeResolver.NAME_RESOLVER.apply(e);
  }
  
  protected String _qname(final FeatureCall e) {
    EObject _feature = e.getFeature();
    QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_feature);
    return _fullyQualifiedName.toString();
  }
  
  protected String _qname(final ElementReferenceExpression e) {
    EObject _reference = e.getReference();
    QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_reference);
    String _string = _fullyQualifiedName.toString();
    return _string;
  }
  
  protected Object _execute(final ActiveStateReferenceExpression expression) {
    List<RegularState> _allActiveStates = this.context.getAllActiveStates();
    State _value = expression.getValue();
    return Boolean.valueOf(_allActiveStates.contains(_value));
  }
  
  protected Object _execute(final LogicalAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Object leftResult = this.execute(_leftOperand);
    boolean _not = (!(((Boolean) leftResult)).booleanValue());
    if (_not) {
      return Boolean.valueOf(false);
    }
    Expression _rightOperand = expression.getRightOperand();
    Object rightResult = this.execute(_rightOperand);
    boolean _and = false;
    if (!(((Boolean) leftResult)).booleanValue()) {
      _and = false;
    } else {
      _and = ((((Boolean) leftResult)).booleanValue() && (((Boolean) rightResult)).booleanValue());
    }
    return Boolean.valueOf(_and);
  }
  
  protected Object _execute(final LogicalOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Object leftResult = this.execute(_leftOperand);
    if ((((Boolean) leftResult)).booleanValue()) {
      return Boolean.valueOf(true);
    }
    Expression _rightOperand = expression.getRightOperand();
    Object rightResult = this.execute(_rightOperand);
    boolean _or = false;
    if ((((Boolean) leftResult)).booleanValue()) {
      _or = true;
    } else {
      _or = ((((Boolean) leftResult)).booleanValue() || (((Boolean) rightResult)).booleanValue());
    }
    return Boolean.valueOf(_or);
  }
  
  protected Object _execute(final LogicalNotExpression expression) {
    Expression _operand = expression.getOperand();
    Object _execute = this.execute(_operand);
    return Boolean.valueOf((!(((Boolean) _execute)).booleanValue()));
  }
  
  protected Object _execute(final BitwiseAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, CoreFunction.BIT_AND);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, CoreFunction.BIT_OR);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, CoreFunction.BIT_XOR);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final LogicalRelationExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    RelationalOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    AdditiveOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _literal);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    MultiplicativeOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final ShiftExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    ShiftOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalUnaryExpression expression) {
    Expression _operand = expression.getOperand();
    UnaryOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeUnaryCoreFunction = this.executeUnaryCoreFunction(_operand, _name);
    return _executeUnaryCoreFunction;
  }
  
  public Object executeBinaryCoreFunction(final Statement leftStatement, final Statement rightStatement, final String operator) {
    Object leftResult = this.execute(leftStatement);
    Object rightResult = this.execute(rightStatement);
    return this.evaluate(operator, leftResult, rightResult);
  }
  
  public Object executeUnaryCoreFunction(final Statement statement, final String operator) {
    Object result = this.execute(statement);
    return this.evaluate(operator, result);
  }
  
  protected Object _execute(final FeatureCall call) {
    Object _xifexpression = null;
    boolean _isOperationCall = call.isOperationCall();
    if (_isOperationCall) {
      Object _xblockexpression = null;
      {
        EList<Expression> _args = call.getArgs();
        final Function1<Expression,Object> _function = new Function1<Expression,Object>() {
            public Object apply(final Expression it) {
              Object _execute = StextStatementInterpreter.this.execute(it);
              return _execute;
            }
          };
        List<Object> parameter = ListExtensions.<Expression, Object>map(_args, _function);
        EObject _feature = call.getFeature();
        OperationDefinition operation = ((OperationDefinition) _feature);
        Object _xifexpression_1 = null;
        boolean _canExecute = this.operationDelegate.canExecute(operation, parameter);
        if (_canExecute) {
          return this.operationDelegate.execute(operation, parameter);
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    } else {
      EObject _feature = call.getFeature();
      if ((_feature instanceof Enumerator)) {
        return call.getFeature();
      } else {
        EObject _feature_1 = call.getFeature();
        String fqn = this.fqn(_feature_1);
        ExecutionVariable variableRef = this.context.getVariable(fqn);
        boolean _notEquals = (!Objects.equal(variableRef, null));
        if (_notEquals) {
          return variableRef.getValue();
        }
        ExecutionEvent _event = this.context.getEvent(fqn);
        return Boolean.valueOf(_event.isRaised());
      }
    }
    return _xifexpression;
  }
  
  public String fqn(final EObject obj) {
    QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(obj);
    String _string = _fullyQualifiedName.toString();
    return _string;
  }
  
  protected Object _execute(final ParenthesizedExpression e) {
    Expression _expression = e.getExpression();
    Object _execute = this.execute(_expression);
    return _execute;
  }
  
  protected Object _execute(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    return this.valueLiteral(_value);
  }
  
  protected Object _valueLiteral(final IntLiteral literal) {
    return literal.getValue();
  }
  
  protected Object _valueLiteral(final HexLiteral literal) {
    return literal.getValue();
  }
  
  protected Object _valueLiteral(final BoolLiteral bool) {
    return bool.isValue();
  }
  
  protected Object _valueLiteral(final RealLiteral literal) {
    return literal.getValue();
  }
  
  protected Object _valueLiteral(final StringLiteral literal) {
    return literal.getValue();
  }
  
  public Object execute(final Statement expression) {
    if (expression instanceof ActiveStateReferenceExpression) {
      return _execute((ActiveStateReferenceExpression)expression);
    } else if (expression instanceof AssignmentExpression) {
      return _execute((AssignmentExpression)expression);
    } else if (expression instanceof BitwiseAndExpression) {
      return _execute((BitwiseAndExpression)expression);
    } else if (expression instanceof BitwiseOrExpression) {
      return _execute((BitwiseOrExpression)expression);
    } else if (expression instanceof BitwiseXorExpression) {
      return _execute((BitwiseXorExpression)expression);
    } else if (expression instanceof ConditionalExpression) {
      return _execute((ConditionalExpression)expression);
    } else if (expression instanceof ElementReferenceExpression) {
      return _execute((ElementReferenceExpression)expression);
    } else if (expression instanceof EventRaisingExpression) {
      return _execute((EventRaisingExpression)expression);
    } else if (expression instanceof EventValueReferenceExpression) {
      return _execute((EventValueReferenceExpression)expression);
    } else if (expression instanceof FeatureCall) {
      return _execute((FeatureCall)expression);
    } else if (expression instanceof LogicalAndExpression) {
      return _execute((LogicalAndExpression)expression);
    } else if (expression instanceof LogicalNotExpression) {
      return _execute((LogicalNotExpression)expression);
    } else if (expression instanceof LogicalOrExpression) {
      return _execute((LogicalOrExpression)expression);
    } else if (expression instanceof LogicalRelationExpression) {
      return _execute((LogicalRelationExpression)expression);
    } else if (expression instanceof NumericalAddSubtractExpression) {
      return _execute((NumericalAddSubtractExpression)expression);
    } else if (expression instanceof NumericalMultiplyDivideExpression) {
      return _execute((NumericalMultiplyDivideExpression)expression);
    } else if (expression instanceof NumericalUnaryExpression) {
      return _execute((NumericalUnaryExpression)expression);
    } else if (expression instanceof ParenthesizedExpression) {
      return _execute((ParenthesizedExpression)expression);
    } else if (expression instanceof PrimitiveValueExpression) {
      return _execute((PrimitiveValueExpression)expression);
    } else if (expression instanceof ShiftExpression) {
      return _execute((ShiftExpression)expression);
    } else if (expression != null) {
      return _execute(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
  
  public EObject variable(final Expression e) {
    if (e instanceof AssignmentExpression) {
      return _variable((AssignmentExpression)e);
    } else if (e instanceof ElementReferenceExpression) {
      return _variable((ElementReferenceExpression)e);
    } else if (e instanceof FeatureCall) {
      return _variable((FeatureCall)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public EObject event(final Expression e) {
    if (e instanceof ElementReferenceExpression) {
      return _event((ElementReferenceExpression)e);
    } else if (e instanceof FeatureCall) {
      return _event((FeatureCall)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public String qname(final Expression e) {
    if (e instanceof ElementReferenceExpression) {
      return _qname((ElementReferenceExpression)e);
    } else if (e instanceof FeatureCall) {
      return _qname((FeatureCall)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public Object valueLiteral(final Literal bool) {
    if (bool instanceof BoolLiteral) {
      return _valueLiteral((BoolLiteral)bool);
    } else if (bool instanceof HexLiteral) {
      return _valueLiteral((HexLiteral)bool);
    } else if (bool instanceof IntLiteral) {
      return _valueLiteral((IntLiteral)bool);
    } else if (bool instanceof RealLiteral) {
      return _valueLiteral((RealLiteral)bool);
    } else if (bool instanceof StringLiteral) {
      return _valueLiteral((StringLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bool).toString());
    }
  }
}
