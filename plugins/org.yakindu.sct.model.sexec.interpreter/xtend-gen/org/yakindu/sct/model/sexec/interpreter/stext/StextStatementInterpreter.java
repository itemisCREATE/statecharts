package org.yakindu.sct.model.sexec.interpreter.stext;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.yakindu.sct.model.sexec.interpreter.stext.AbstractStatementInterpreter;
import org.yakindu.sct.model.sexec.interpreter.stext.CoreFunction;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
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
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.StringLiteral;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

/**
 * @author andreas muelder - Initial contribution and API
 * @authos axel terfloth - additions
 */
@SuppressWarnings("all")
public class StextStatementInterpreter extends AbstractStatementInterpreter {
  @Inject
  private StextNameProvider provider;
  
  private IExecutionContext context;
  
  public Object evaluateStatement(final Statement statement, final IExecutionContext context) {
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
        this.context.setVariableValue(_name, result);
      } else {
        AssignmentOperator _operator_1 = assignment.getOperator();
        String _name_1 = _operator_1.name();
        String operator = AbstractStatementInterpreter.assignFunctionMap.get(_name_1);
        String _name_2 = scopeVariable.getName();
        Object _value = scopeVariable.getValue();
        Object _evaluate = this.evaluate(operator, _value, result);
        this.context.setVariableValue(_name_2, _evaluate);
      }
      _xblockexpression = (null);
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
      Expression _value = eventRaising.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
      if (_notEquals) {
        Expression _event = eventRaising.getEvent();
        EObject _event_1 = this.event(_event);
        QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_event_1);
        String _string = _fullyQualifiedName.toString();
        Expression _value_1 = eventRaising.getValue();
        Object _execute = this.execute(_value_1);
        this.context.raiseEvent(_string, _execute);
      } else {
        Expression _event_2 = eventRaising.getEvent();
        EObject _event_3 = this.event(_event_2);
        QualifiedName _fullyQualifiedName_1 = this.provider.getFullyQualifiedName(_event_3);
        String _string_1 = _fullyQualifiedName_1.toString();
        this.context.raiseEvent(_string_1, null);
      }
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
    EObject _reference = expression.getReference();
    QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_reference);
    String _string = _fullyQualifiedName.toString();
    ExecutionVariable variableRef = this.context.getVariable(_string);
    boolean _notEquals = (!Objects.equal(variableRef, null));
    if (_notEquals) {
      return variableRef.getValue();
    }
    EObject _reference_1 = expression.getReference();
    QualifiedName _fullyQualifiedName_1 = this.provider.getFullyQualifiedName(_reference_1);
    String _string_1 = _fullyQualifiedName_1.toString();
    return Boolean.valueOf(this.context.isEventRaised(_string_1));
  }
  
  protected Object _execute(final EventValueReferenceExpression expression) {
    Object _xblockexpression = null;
    {
      List<ExecutionEvent> _raisedEvents = this.context.getRaisedEvents();
      for (final ExecutionEvent event : _raisedEvents) {
        String _name = event.getName();
        Expression _value = expression.getValue();
        String _qname = this.qname(_value);
        Boolean _equals = this.equals(_name, _qname);
        if ((_equals).booleanValue()) {
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
    Set<RegularState> _allActiveStates = this.context.getAllActiveStates();
    for (final RegularState activeState : _allActiveStates) {
      State _value = expression.getValue();
      boolean _equals = Objects.equal(activeState, _value);
      if (_equals) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected Object _execute(final LogicalAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Object leftResult = this.execute(_leftOperand);
    boolean _not = (!((Boolean) leftResult));
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
    return Boolean.valueOf((!((Boolean) _execute)));
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
    String _name = _operator.name();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    AdditiveOperator _operator = expression.getOperator();
    String _name = _operator.name();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    MultiplicativeOperator _operator = expression.getOperator();
    String _name = _operator.name();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final ShiftExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Expression _rightOperand = expression.getRightOperand();
    ShiftOperator _operator = expression.getOperator();
    String _name = _operator.name();
    Object _executeBinaryCoreFunction = this.executeBinaryCoreFunction(_leftOperand, _rightOperand, _name);
    return _executeBinaryCoreFunction;
  }
  
  protected Object _execute(final NumericalUnaryExpression expression) {
    Expression _operand = expression.getOperand();
    UnaryOperator _operator = expression.getOperator();
    String _name = _operator.name();
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
    Object _xblockexpression = null;
    {
      boolean _isOperationCall = call.isOperationCall();
      if (_isOperationCall) {
        EObject _feature = call.getFeature();
        String _name = this.name(_feature);
        this.context.call(_name);
      } else {
        EObject _feature_1 = call.getFeature();
        QualifiedName _fullyQualifiedName = this.provider.getFullyQualifiedName(_feature_1);
        String _string = _fullyQualifiedName.toString();
        ExecutionVariable variableRef = this.context.getVariable(_string);
        boolean _notEquals = (!Objects.equal(variableRef, null));
        if (_notEquals) {
          return variableRef.getValue();
        }
        EObject _feature_2 = call.getFeature();
        QualifiedName _fullyQualifiedName_1 = this.provider.getFullyQualifiedName(_feature_2);
        String _string_1 = _fullyQualifiedName_1.toString();
        return Boolean.valueOf(this.context.isEventRaised(_string_1));
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    return ((Comparable<Object>)this.valueLiteral(_value));
  }
  
  protected Object _valueLiteral(final IntLiteral literal) {
    return Integer.valueOf(literal.getValue());
  }
  
  protected Object _valueLiteral(final HexLiteral literal) {
    return Integer.valueOf(literal.getValue());
  }
  
  protected Object _valueLiteral(final BoolLiteral bool) {
    return Boolean.valueOf(bool.isValue());
  }
  
  protected Object _valueLiteral(final RealLiteral literal) {
    return Float.valueOf(literal.getValue());
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
    if (e instanceof ElementReferenceExpression) {
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
