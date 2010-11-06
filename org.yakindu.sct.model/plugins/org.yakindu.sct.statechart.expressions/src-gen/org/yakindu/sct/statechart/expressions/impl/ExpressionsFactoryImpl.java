/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.statechart.expressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionsFactory init()
  {
    try
    {
      ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.org/sct/statechart/Expressions"); 
      if (theExpressionsFactory != null)
      {
        return theExpressionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExpressionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ExpressionsPackage.EXPRESSION: return createExpression();
      case ExpressionsPackage.TRIGGER_EXPRESSION: return createTriggerExpression();
      case ExpressionsPackage.GUARD_EXPRESSION: return createGuardExpression();
      case ExpressionsPackage.ACTION_EXPRESSION: return createActionExpression();
      case ExpressionsPackage.TRIGGER: return createTrigger();
      case ExpressionsPackage.EVENT: return createEvent();
      case ExpressionsPackage.SIGNAL_EVENT: return createSignalEvent();
      case ExpressionsPackage.TIME_EVENT: return createTimeEvent();
      case ExpressionsPackage.TIME_EXPRESSION: return createTimeExpression();
      case ExpressionsPackage.VARIABLE_REFERENCE: return createVariableReference();
      case ExpressionsPackage.VARIABLE: return createVariable();
      case ExpressionsPackage.TIME_CONSTANT: return createTimeConstant();
      case ExpressionsPackage.STATEMENT: return createStatement();
      case ExpressionsPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
      case ExpressionsPackage.PROCEDURE_CALL: return createProcedureCall();
      case ExpressionsPackage.PROCEDURE: return createProcedure();
      case ExpressionsPackage.EVENT_RAISING: return createEventRaising();
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION: return createBooleanOrExpression();
      case ExpressionsPackage.BOOLEAN_AND_EXPRESSION: return createBooleanAndExpression();
      case ExpressionsPackage.BITWISE_XOR_EXPRESSION: return createBitwiseXorExpression();
      case ExpressionsPackage.BITWISE_OR_EXPRESSION: return createBitwiseOrExpression();
      case ExpressionsPackage.BITWISE_AND_EXPRESSION: return createBitwiseAndExpression();
      case ExpressionsPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case ExpressionsPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case ExpressionsPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case ExpressionsPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case ExpressionsPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case ExpressionsPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case ExpressionsPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case ExpressionsPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case ExpressionsPackage.NESTED_EXPRESSION: return createNestedExpression();
      case ExpressionsPackage.LITERAL_VALUE: return createLiteralValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ExpressionsPackage.TIME_UNIT:
        return createTimeUnitFromString(eDataType, initialValue);
      case ExpressionsPackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.SHIFT_OPERATOR:
        return createShiftOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.UNARY_OPERATOR:
        return createUnaryOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ExpressionsPackage.TIME_UNIT:
        return convertTimeUnitToString(eDataType, instanceValue);
      case ExpressionsPackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.SHIFT_OPERATOR:
        return convertShiftOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.UNARY_OPERATOR:
        return convertUnaryOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerExpression createTriggerExpression()
  {
    TriggerExpressionImpl triggerExpression = new TriggerExpressionImpl();
    return triggerExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardExpression createGuardExpression()
  {
    GuardExpressionImpl guardExpression = new GuardExpressionImpl();
    return guardExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionExpression createActionExpression()
  {
    ActionExpressionImpl actionExpression = new ActionExpressionImpl();
    return actionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalEvent createSignalEvent()
  {
    SignalEventImpl signalEvent = new SignalEventImpl();
    return signalEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEvent createTimeEvent()
  {
    TimeEventImpl timeEvent = new TimeEventImpl();
    return timeEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeExpression createTimeExpression()
  {
    TimeExpressionImpl timeExpression = new TimeExpressionImpl();
    return timeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableReference createVariableReference()
  {
    VariableReferenceImpl variableReference = new VariableReferenceImpl();
    return variableReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeConstant createTimeConstant()
  {
    TimeConstantImpl timeConstant = new TimeConstantImpl();
    return timeConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableAssignment createVariableAssignment()
  {
    VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
    return variableAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcedureCall createProcedureCall()
  {
    ProcedureCallImpl procedureCall = new ProcedureCallImpl();
    return procedureCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Procedure createProcedure()
  {
    ProcedureImpl procedure = new ProcedureImpl();
    return procedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventRaising createEventRaising()
  {
    EventRaisingImpl eventRaising = new EventRaisingImpl();
    return eventRaising;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOrExpression createBooleanOrExpression()
  {
    BooleanOrExpressionImpl booleanOrExpression = new BooleanOrExpressionImpl();
    return booleanOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAndExpression createBooleanAndExpression()
  {
    BooleanAndExpressionImpl booleanAndExpression = new BooleanAndExpressionImpl();
    return booleanAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseXorExpression createBitwiseXorExpression()
  {
    BitwiseXorExpressionImpl bitwiseXorExpression = new BitwiseXorExpressionImpl();
    return bitwiseXorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseOrExpression createBitwiseOrExpression()
  {
    BitwiseOrExpressionImpl bitwiseOrExpression = new BitwiseOrExpressionImpl();
    return bitwiseOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseAndExpression createBitwiseAndExpression()
  {
    BitwiseAndExpressionImpl bitwiseAndExpression = new BitwiseAndExpressionImpl();
    return bitwiseAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedExpression createNestedExpression()
  {
    NestedExpressionImpl nestedExpression = new NestedExpressionImpl();
    return nestedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralValue createLiteralValue()
  {
    LiteralValueImpl literalValue = new LiteralValueImpl();
    return literalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeUnit createTimeUnitFromString(EDataType eDataType, String initialValue)
  {
    TimeUnit result = TimeUnit.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTimeUnitToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue)
  {
    ShiftOperator result = ShiftOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOperator result = AdditiveOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    UnaryOperator result = UnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsPackage getExpressionsPackage()
  {
    return (ExpressionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExpressionsPackage getPackage()
  {
    return ExpressionsPackage.eINSTANCE;
  }

} //ExpressionsFactoryImpl
