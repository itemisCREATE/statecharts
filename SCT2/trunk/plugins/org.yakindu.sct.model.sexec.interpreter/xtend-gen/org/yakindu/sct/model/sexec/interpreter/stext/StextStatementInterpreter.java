package org.yakindu.sct.model.sexec.interpreter.stext;

import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.yakindu.sct.model.sexec.interpreter.stext.AbstractStatementInterpreter;
import org.yakindu.sct.model.sexec.interpreter.stext.CoreFunction;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventRaising;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
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
import org.yakindu.sct.model.stext.stext.Operation;
import org.yakindu.sct.model.stext.stext.OperationCall;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

@SuppressWarnings("all")
public class StextStatementInterpreter extends AbstractStatementInterpreter {
  
  @Inject
  private StextNameProvider provider;
  
  private IExecutionContext context;
  
  public Object evaluateStatement(final Statement statement, final IExecutionContext context) throws ExecutionException {
    Object _xblockexpression = null;
    {
      this.context = context;
      Object _execute = this.execute(statement);
      _xblockexpression = (_execute);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Assignment assignment) throws ExecutionException {
    Object _xblockexpression = null;
    {
      Variable _varRef = assignment.getVarRef();
      QualifiedName _qualifiedName = this.provider.qualifiedName(_varRef);
      String _string = _qualifiedName.toString();
      ExecutionVariable _variable = this.context.getVariable(_string);
      ExecutionVariable scopeVariable = _variable;
      Expression _expression = assignment.getExpression();
      Object _execute = this.execute(_expression);
      Object result = _execute;
      AssignmentOperator _operator = assignment.getOperator();
      boolean _operator_equals = ObjectExtensions.operator_equals(_operator, AssignmentOperator.ASSIGN);
      if (_operator_equals) {
        String _name = scopeVariable.getName();
        this.context.setVariableValue(_name, result);
      } else {
        {
          AssignmentOperator _operator_1 = assignment.getOperator();
          String _name_1 = _operator_1.getName();
          String _get = AbstractStatementInterpreter.assignFunctionMap.get(_name_1);
          String operator = _get;
          String _name_2 = scopeVariable.getName();
          Object _value = scopeVariable.getValue();
          Object _evaluate = this.evaluate(operator, _value, result);
          this.context.setVariableValue(_name_2, _evaluate);
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final EventRaising eventRaising) throws ExecutionException {
    Object _xblockexpression = null;
    {
      Expression _value = eventRaising.getValue();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_value, null);
      if (_operator_notEquals) {
        Event _event = eventRaising.getEvent();
        QualifiedName _qualifiedName = this.provider.qualifiedName(_event);
        String _string = _qualifiedName.toString();
        Expression _value_1 = eventRaising.getValue();
        Object _execute = this.execute(_value_1);
        this.context.raiseEvent(_string, _execute);
      } else {
        Event _event_1 = eventRaising.getEvent();
        QualifiedName _qualifiedName_1 = this.provider.qualifiedName(_event_1);
        String _string_1 = _qualifiedName_1.toString();
        this.context.raiseEvent(_string_1, null);
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final ConditionalExpression expression) throws ExecutionException {
    Expression _condition = expression.getCondition();
    Object _execute = this.execute(_condition);
    if (((Boolean) _execute)) {
      Expression _trueCase = expression.getTrueCase();
      Object _execute_1 = this.execute(_trueCase);
      return _execute_1;
    } else {
      Expression _falseCase = expression.getFalseCase();
      Object _execute_2 = this.execute(_falseCase);
      return _execute_2;
    }
  }
  
  protected Object _execute(final ElementReferenceExpression expression) {
    {
      Declaration _value = expression.getValue();
      QualifiedName _qualifiedName = this.provider.qualifiedName(_value);
      String _string = _qualifiedName.toString();
      ExecutionVariable _variable = this.context.getVariable(_string);
      ExecutionVariable variableRef = _variable;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(variableRef, null);
      if (_operator_notEquals) {
        Object _value_1 = variableRef.getValue();
        return _value_1;
      }
      Declaration _value_2 = expression.getValue();
      QualifiedName _qualifiedName_1 = this.provider.qualifiedName(_value_2);
      String _string_1 = _qualifiedName_1.toString();
      boolean _isEventRaised = this.context.isEventRaised(_string_1);
      return ((Boolean)_isEventRaised);
    }
  }
  
  protected Object _execute(final EventValueReferenceExpression expression) {
    Object _xblockexpression = null;
    {
      List<ExecutionEvent> _raisedEvents = this.context.getRaisedEvents();
      for (final ExecutionEvent event : _raisedEvents) {
        String _name = event.getName();
        Event _value = expression.getValue();
        String _name_1 = _value.getName();
        Boolean _equals = this.equals(_name, _name_1);
        if (_equals) {
          Object _value_1 = event.getValue();
          return _value_1;
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final ActiveStateReferenceExpression expression) {
    {
      Set<RegularState> _allActiveStates = this.context.getAllActiveStates();
      for (final RegularState activeState : _allActiveStates) {
        RegularState _value = expression.getValue();
        boolean _operator_equals = ObjectExtensions.operator_equals(activeState, _value);
        if (_operator_equals) {
          return true;
        }
      }
      return false;
    }
  }
  
  protected Object _execute(final LogicalAndExpression expression) throws ExecutionException {
    {
      Expression _leftOperand = expression.getLeftOperand();
      Object _execute = this.execute(_leftOperand);
      Object leftResult = _execute;
      boolean _operator_not = BooleanExtensions.operator_not(((Boolean) leftResult));
      if (_operator_not) {
        return false;
      }
      Expression _rightOperand = expression.getRightOperand();
      Object _execute_1 = this.execute(_rightOperand);
      Object rightResult = _execute_1;
      boolean _operator_and = false;
      if (!((Boolean) leftResult)) {
        _operator_and = false;
      } else {
        _operator_and = BooleanExtensions.operator_and(((Boolean) leftResult), ((Boolean) rightResult));
      }
      return _operator_and;
    }
  }
  
  protected Object _execute(final LogicalOrExpression expression) throws ExecutionException {
    {
      Expression _leftOperand = expression.getLeftOperand();
      Object _execute = this.execute(_leftOperand);
      Object leftResult = _execute;
      if (((Boolean) leftResult)) {
        return true;
      }
      Expression _rightOperand = expression.getRightOperand();
      Object _execute_1 = this.execute(_rightOperand);
      Object rightResult = _execute_1;
      boolean _operator_or = false;
      if (((Boolean) leftResult)) {
        _operator_or = true;
      } else {
        _operator_or = BooleanExtensions.operator_or(((Boolean) leftResult), ((Boolean) rightResult));
      }
      return _operator_or;
    }
  }
  
  protected Object _execute(final LogicalNotExpression expression) {
    Expression _operand = expression.getOperand();
    Object _execute = this.execute(_operand);
    boolean _operator_not = BooleanExtensions.operator_not(((Boolean) _execute));
    return _operator_not;
  }
  
  protected Object _execute(final BitwiseAndExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, CoreFunction.BIT_AND);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final BitwiseOrExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, CoreFunction.BIT_OR);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final BitwiseXorExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, CoreFunction.BIT_XOR);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final LogicalRelationExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    RelationalOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalAddSubtractExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    AdditiveOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalMultiplyDivideExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    MultiplicativeOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final ShiftExpression expression) throws ExecutionException {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    ShiftOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalUnaryExpression expression) throws ExecutionException {
    Expression _operand = expression.getOperand();
    UnaryOperator _operator = expression.getOperator();
    String _name = _operator.getName();
    Object _executeUnaryCoreFunction = this.executeUnaryCoreFunction(_operand, _name);
    return _executeUnaryCoreFunction;
  }
  
  public Object executeBinaryCoreFunction(final Statement leftStatement, final Statement rightStatement, final String operator) throws ExecutionException {
    {
      Object _execute = this.execute(leftStatement);
      Object leftResult = _execute;
      Object _execute_1 = this.execute(rightStatement);
      Object rightResult = _execute_1;
      Object _evaluate = this.evaluate(operator, leftResult, rightResult);
      return _evaluate;
    }
  }
  
  public Object executeUnaryCoreFunction(final Statement statement, final String operator) throws ExecutionException {
    {
      Object _execute = this.execute(statement);
      Object result = _execute;
      Object _evaluate = this.evaluate(operator, result);
      return _evaluate;
    }
  }
  
  protected Object _execute(final OperationCall call) {
    Object _xblockexpression = null;
    {
      Operation _operation = call.getOperation();
      String _name = _operation.getName();
      this.context.call(_name);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    Comparable<? extends Object> _valueLiteral = this.valueLiteral(_value);
    return _valueLiteral;
  }
  
  protected Comparable<? extends Object> _valueLiteral(final IntLiteral literal) {
    int _value = literal.getValue();
    return _value;
  }
  
  protected Comparable<? extends Object> _valueLiteral(final HexLiteral literal) {
    int _value = literal.getValue();
    return _value;
  }
  
  protected Comparable<? extends Object> _valueLiteral(final BoolLiteral bool) {
    boolean _isValue = bool.isValue();
    return _isValue;
  }
  
  protected Comparable<? extends Object> _valueLiteral(final RealLiteral literal) {
    float _value = literal.getValue();
    return _value;
  }
  
  public Object execute(final Statement expression) throws ExecutionException {
    if ((expression instanceof ActiveStateReferenceExpression)) {
      return _execute((ActiveStateReferenceExpression)expression);
    } else if ((expression instanceof BitwiseAndExpression)) {
      return _execute((BitwiseAndExpression)expression);
    } else if ((expression instanceof BitwiseOrExpression)) {
      return _execute((BitwiseOrExpression)expression);
    } else if ((expression instanceof BitwiseXorExpression)) {
      return _execute((BitwiseXorExpression)expression);
    } else if ((expression instanceof ConditionalExpression)) {
      return _execute((ConditionalExpression)expression);
    } else if ((expression instanceof ElementReferenceExpression)) {
      return _execute((ElementReferenceExpression)expression);
    } else if ((expression instanceof EventValueReferenceExpression)) {
      return _execute((EventValueReferenceExpression)expression);
    } else if ((expression instanceof LogicalAndExpression)) {
      return _execute((LogicalAndExpression)expression);
    } else if ((expression instanceof LogicalNotExpression)) {
      return _execute((LogicalNotExpression)expression);
    } else if ((expression instanceof LogicalOrExpression)) {
      return _execute((LogicalOrExpression)expression);
    } else if ((expression instanceof LogicalRelationExpression)) {
      return _execute((LogicalRelationExpression)expression);
    } else if ((expression instanceof NumericalAddSubtractExpression)) {
      return _execute((NumericalAddSubtractExpression)expression);
    } else if ((expression instanceof NumericalMultiplyDivideExpression)) {
      return _execute((NumericalMultiplyDivideExpression)expression);
    } else if ((expression instanceof NumericalUnaryExpression)) {
      return _execute((NumericalUnaryExpression)expression);
    } else if ((expression instanceof OperationCall)) {
      return _execute((OperationCall)expression);
    } else if ((expression instanceof PrimitiveValueExpression)) {
      return _execute((PrimitiveValueExpression)expression);
    } else if ((expression instanceof ShiftExpression)) {
      return _execute((ShiftExpression)expression);
    } else if ((expression instanceof Assignment)) {
      return _execute((Assignment)expression);
    } else if ((expression instanceof EventRaising)) {
      return _execute((EventRaising)expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(expression).toString());
    }
  }
  
  public Comparable<? extends Object> valueLiteral(final Literal bool) {
    if ((bool instanceof BoolLiteral)) {
      return _valueLiteral((BoolLiteral)bool);
    } else if ((bool instanceof HexLiteral)) {
      return _valueLiteral((HexLiteral)bool);
    } else if ((bool instanceof IntLiteral)) {
      return _valueLiteral((IntLiteral)bool);
    } else if ((bool instanceof RealLiteral)) {
      return _valueLiteral((RealLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(bool).toString());
    }
  }
}