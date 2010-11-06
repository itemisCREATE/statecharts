/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.sct.statechart.expressions.ActionExpression;
import org.yakindu.sct.statechart.expressions.AdditiveExpression;
import org.yakindu.sct.statechart.expressions.AdditiveOperator;
import org.yakindu.sct.statechart.expressions.AssignmentOperator;
import org.yakindu.sct.statechart.expressions.BitwiseAndExpression;
import org.yakindu.sct.statechart.expressions.BitwiseOrExpression;
import org.yakindu.sct.statechart.expressions.BitwiseXorExpression;
import org.yakindu.sct.statechart.expressions.BooleanAndExpression;
import org.yakindu.sct.statechart.expressions.BooleanOrExpression;
import org.yakindu.sct.statechart.expressions.ConditionalExpression;
import org.yakindu.sct.statechart.expressions.EqualityExpression;
import org.yakindu.sct.statechart.expressions.EqualityOperator;
import org.yakindu.sct.statechart.expressions.Event;
import org.yakindu.sct.statechart.expressions.EventRaising;
import org.yakindu.sct.statechart.expressions.Expression;
import org.yakindu.sct.statechart.expressions.ExpressionsFactory;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.GuardExpression;
import org.yakindu.sct.statechart.expressions.LiteralValue;
import org.yakindu.sct.statechart.expressions.MultiplicativeExpression;
import org.yakindu.sct.statechart.expressions.MultiplicativeOperator;
import org.yakindu.sct.statechart.expressions.NestedExpression;
import org.yakindu.sct.statechart.expressions.PrimaryExpression;
import org.yakindu.sct.statechart.expressions.Procedure;
import org.yakindu.sct.statechart.expressions.ProcedureCall;
import org.yakindu.sct.statechart.expressions.RelationalExpression;
import org.yakindu.sct.statechart.expressions.RelationalOperator;
import org.yakindu.sct.statechart.expressions.ShiftExpression;
import org.yakindu.sct.statechart.expressions.ShiftOperator;
import org.yakindu.sct.statechart.expressions.SignalEvent;
import org.yakindu.sct.statechart.expressions.Statement;
import org.yakindu.sct.statechart.expressions.TimeConstant;
import org.yakindu.sct.statechart.expressions.TimeEvent;
import org.yakindu.sct.statechart.expressions.TimeExpression;
import org.yakindu.sct.statechart.expressions.TimeUnit;
import org.yakindu.sct.statechart.expressions.Trigger;
import org.yakindu.sct.statechart.expressions.TriggerExpression;
import org.yakindu.sct.statechart.expressions.UnaryExpression;
import org.yakindu.sct.statechart.expressions.UnaryOperator;
import org.yakindu.sct.statechart.expressions.Variable;
import org.yakindu.sct.statechart.expressions.VariableAssignment;
import org.yakindu.sct.statechart.expressions.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggerExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass procedureCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass procedureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventRaisingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseXorExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additiveExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicativeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum timeUnitEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum assignmentOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum equalityOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relationalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum shiftOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum additiveOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum multiplicativeOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum unaryOperatorEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ExpressionsPackageImpl()
  {
    super(eNS_URI, ExpressionsFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ExpressionsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ExpressionsPackage init()
  {
    if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

    // Obtain or create and register package
    ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionsPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theExpressionsPackage.createPackageContents();

    // Initialize created meta-data
    theExpressionsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theExpressionsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, theExpressionsPackage);
    return theExpressionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTriggerExpression()
  {
    return triggerExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTriggerExpression_Triggers()
  {
    return (EReference)triggerExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuardExpression()
  {
    return guardExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuardExpression_Expression()
  {
    return (EReference)guardExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActionExpression()
  {
    return actionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActionExpression_Statement()
  {
    return (EReference)actionExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrigger()
  {
    return triggerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrigger_Event()
  {
    return (EReference)triggerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvent()
  {
    return eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalEvent()
  {
    return signalEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignalEvent_Identifier()
  {
    return (EAttribute)signalEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeEvent()
  {
    return timeEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeEvent_Duration()
  {
    return (EReference)timeEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeExpression()
  {
    return timeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableReference()
  {
    return variableReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableReference_Variable()
  {
    return (EReference)variableReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariable_Identifier()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeConstant()
  {
    return timeConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeConstant_Value()
  {
    return (EAttribute)timeConstantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeConstant_Unit()
  {
    return (EAttribute)timeConstantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableAssignment()
  {
    return variableAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableAssignment_VariableReference()
  {
    return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableAssignment_Operator()
  {
    return (EAttribute)variableAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableAssignment_Value()
  {
    return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcedureCall()
  {
    return procedureCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcedureCall_Procedure()
  {
    return (EReference)procedureCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcedure()
  {
    return procedureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcedure_Identifier()
  {
    return (EAttribute)procedureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventRaising()
  {
    return eventRaisingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventRaising_Event()
  {
    return (EReference)eventRaisingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanOrExpression()
  {
    return booleanOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanOrExpression_Operand1()
  {
    return (EReference)booleanOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanOrExpression_Operand2()
  {
    return (EReference)booleanOrExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanAndExpression()
  {
    return booleanAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanAndExpression_Operand1()
  {
    return (EReference)booleanAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanAndExpression_Operand2()
  {
    return (EReference)booleanAndExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseXorExpression()
  {
    return bitwiseXorExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseXorExpression_Operand1()
  {
    return (EReference)bitwiseXorExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseXorExpression_Operand2()
  {
    return (EReference)bitwiseXorExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseOrExpression()
  {
    return bitwiseOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseOrExpression_Operand1()
  {
    return (EReference)bitwiseOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseOrExpression_Operand2()
  {
    return (EReference)bitwiseOrExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseAndExpression()
  {
    return bitwiseAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseAndExpression_Operand1()
  {
    return (EReference)bitwiseAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseAndExpression_Operand2()
  {
    return (EReference)bitwiseAndExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpression()
  {
    return equalityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_Operand1()
  {
    return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityExpression_Operator()
  {
    return (EAttribute)equalityExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_Operand2()
  {
    return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Operand1()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_Operator()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Operand2()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpression()
  {
    return conditionalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_Operand1()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_Operand2()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_Operand3()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpression()
  {
    return shiftExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_Operand1()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpression_Operator()
  {
    return (EAttribute)shiftExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_Operand2()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdditiveExpression()
  {
    return additiveExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpression_Operand1()
  {
    return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAdditiveExpression_Operator()
  {
    return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpression_Operand2()
  {
    return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicativeExpression()
  {
    return multiplicativeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpression_Operand1()
  {
    return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicativeExpression_Operator()
  {
    return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpression_Operand2()
  {
    return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpression()
  {
    return unaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_Operator()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpression_Operand()
  {
    return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpression()
  {
    return primaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedExpression()
  {
    return nestedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedExpression_Expression()
  {
    return (EReference)nestedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralValue()
  {
    return literalValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralValue_Value()
  {
    return (EAttribute)literalValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTimeUnit()
  {
    return timeUnitEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAssignmentOperator()
  {
    return assignmentOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEqualityOperator()
  {
    return equalityOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelationalOperator()
  {
    return relationalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getShiftOperator()
  {
    return shiftOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAdditiveOperator()
  {
    return additiveOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMultiplicativeOperator()
  {
    return multiplicativeOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUnaryOperator()
  {
    return unaryOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsFactory getExpressionsFactory()
  {
    return (ExpressionsFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    expressionEClass = createEClass(EXPRESSION);

    triggerExpressionEClass = createEClass(TRIGGER_EXPRESSION);
    createEReference(triggerExpressionEClass, TRIGGER_EXPRESSION__TRIGGERS);

    guardExpressionEClass = createEClass(GUARD_EXPRESSION);
    createEReference(guardExpressionEClass, GUARD_EXPRESSION__EXPRESSION);

    actionExpressionEClass = createEClass(ACTION_EXPRESSION);
    createEReference(actionExpressionEClass, ACTION_EXPRESSION__STATEMENT);

    triggerEClass = createEClass(TRIGGER);
    createEReference(triggerEClass, TRIGGER__EVENT);

    eventEClass = createEClass(EVENT);

    signalEventEClass = createEClass(SIGNAL_EVENT);
    createEAttribute(signalEventEClass, SIGNAL_EVENT__IDENTIFIER);

    timeEventEClass = createEClass(TIME_EVENT);
    createEReference(timeEventEClass, TIME_EVENT__DURATION);

    timeExpressionEClass = createEClass(TIME_EXPRESSION);

    variableReferenceEClass = createEClass(VARIABLE_REFERENCE);
    createEReference(variableReferenceEClass, VARIABLE_REFERENCE__VARIABLE);

    variableEClass = createEClass(VARIABLE);
    createEAttribute(variableEClass, VARIABLE__IDENTIFIER);

    timeConstantEClass = createEClass(TIME_CONSTANT);
    createEAttribute(timeConstantEClass, TIME_CONSTANT__VALUE);
    createEAttribute(timeConstantEClass, TIME_CONSTANT__UNIT);

    statementEClass = createEClass(STATEMENT);

    variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
    createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE);
    createEAttribute(variableAssignmentEClass, VARIABLE_ASSIGNMENT__OPERATOR);
    createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VALUE);

    procedureCallEClass = createEClass(PROCEDURE_CALL);
    createEReference(procedureCallEClass, PROCEDURE_CALL__PROCEDURE);

    procedureEClass = createEClass(PROCEDURE);
    createEAttribute(procedureEClass, PROCEDURE__IDENTIFIER);

    eventRaisingEClass = createEClass(EVENT_RAISING);
    createEReference(eventRaisingEClass, EVENT_RAISING__EVENT);

    booleanOrExpressionEClass = createEClass(BOOLEAN_OR_EXPRESSION);
    createEReference(booleanOrExpressionEClass, BOOLEAN_OR_EXPRESSION__OPERAND1);
    createEReference(booleanOrExpressionEClass, BOOLEAN_OR_EXPRESSION__OPERAND2);

    booleanAndExpressionEClass = createEClass(BOOLEAN_AND_EXPRESSION);
    createEReference(booleanAndExpressionEClass, BOOLEAN_AND_EXPRESSION__OPERAND1);
    createEReference(booleanAndExpressionEClass, BOOLEAN_AND_EXPRESSION__OPERAND2);

    bitwiseXorExpressionEClass = createEClass(BITWISE_XOR_EXPRESSION);
    createEReference(bitwiseXorExpressionEClass, BITWISE_XOR_EXPRESSION__OPERAND1);
    createEReference(bitwiseXorExpressionEClass, BITWISE_XOR_EXPRESSION__OPERAND2);

    bitwiseOrExpressionEClass = createEClass(BITWISE_OR_EXPRESSION);
    createEReference(bitwiseOrExpressionEClass, BITWISE_OR_EXPRESSION__OPERAND1);
    createEReference(bitwiseOrExpressionEClass, BITWISE_OR_EXPRESSION__OPERAND2);

    bitwiseAndExpressionEClass = createEClass(BITWISE_AND_EXPRESSION);
    createEReference(bitwiseAndExpressionEClass, BITWISE_AND_EXPRESSION__OPERAND1);
    createEReference(bitwiseAndExpressionEClass, BITWISE_AND_EXPRESSION__OPERAND2);

    equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);
    createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERAND1);
    createEAttribute(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERATOR);
    createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERAND2);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERAND1);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATOR);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERAND2);

    conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__OPERAND1);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__OPERAND2);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__OPERAND3);

    shiftExpressionEClass = createEClass(SHIFT_EXPRESSION);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__OPERAND1);
    createEAttribute(shiftExpressionEClass, SHIFT_EXPRESSION__OPERATOR);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__OPERAND2);

    additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
    createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERAND1);
    createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERATOR);
    createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERAND2);

    multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
    createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERAND1);
    createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERATOR);
    createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERAND2);

    unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);
    createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);

    primaryExpressionEClass = createEClass(PRIMARY_EXPRESSION);

    nestedExpressionEClass = createEClass(NESTED_EXPRESSION);
    createEReference(nestedExpressionEClass, NESTED_EXPRESSION__EXPRESSION);

    literalValueEClass = createEClass(LITERAL_VALUE);
    createEAttribute(literalValueEClass, LITERAL_VALUE__VALUE);

    // Create enums
    timeUnitEEnum = createEEnum(TIME_UNIT);
    assignmentOperatorEEnum = createEEnum(ASSIGNMENT_OPERATOR);
    equalityOperatorEEnum = createEEnum(EQUALITY_OPERATOR);
    relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
    shiftOperatorEEnum = createEEnum(SHIFT_OPERATOR);
    additiveOperatorEEnum = createEEnum(ADDITIVE_OPERATOR);
    multiplicativeOperatorEEnum = createEEnum(MULTIPLICATIVE_OPERATOR);
    unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    triggerExpressionEClass.getESuperTypes().add(this.getExpression());
    guardExpressionEClass.getESuperTypes().add(this.getExpression());
    actionExpressionEClass.getESuperTypes().add(this.getExpression());
    signalEventEClass.getESuperTypes().add(this.getEvent());
    timeEventEClass.getESuperTypes().add(this.getEvent());
    variableReferenceEClass.getESuperTypes().add(this.getTimeExpression());
    variableReferenceEClass.getESuperTypes().add(this.getPrimaryExpression());
    timeConstantEClass.getESuperTypes().add(this.getTimeExpression());
    variableAssignmentEClass.getESuperTypes().add(this.getStatement());
    procedureCallEClass.getESuperTypes().add(this.getStatement());
    eventRaisingEClass.getESuperTypes().add(this.getStatement());
    nestedExpressionEClass.getESuperTypes().add(this.getPrimaryExpression());
    literalValueEClass.getESuperTypes().add(this.getPrimaryExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(triggerExpressionEClass, TriggerExpression.class, "TriggerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTriggerExpression_Triggers(), this.getTrigger(), null, "triggers", null, 0, -1, TriggerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardExpressionEClass, GuardExpression.class, "GuardExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuardExpression_Expression(), this.getBooleanOrExpression(), null, "expression", null, 0, 1, GuardExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actionExpressionEClass, ActionExpression.class, "ActionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActionExpression_Statement(), this.getStatement(), null, "statement", null, 0, -1, ActionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrigger_Event(), this.getEvent(), null, "event", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(signalEventEClass, SignalEvent.class, "SignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSignalEvent_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, SignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeEventEClass, TimeEvent.class, "TimeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimeEvent_Duration(), this.getTimeExpression(), null, "duration", null, 0, 1, TimeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeExpressionEClass, TimeExpression.class, "TimeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableReferenceEClass, VariableReference.class, "VariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableReference_Variable(), this.getVariable(), null, "variable", null, 0, 1, VariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariable_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeConstantEClass, TimeConstant.class, "TimeConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeConstant_Value(), ecorePackage.getEInt(), "value", null, 0, 1, TimeConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeConstant_Unit(), this.getTimeUnit(), "unit", null, 0, 1, TimeConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableAssignment_VariableReference(), this.getVariableReference(), null, "variableReference", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableAssignment_Operator(), this.getAssignmentOperator(), "operator", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableAssignment_Value(), this.getConditionalExpression(), null, "value", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(procedureCallEClass, ProcedureCall.class, "ProcedureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProcedureCall_Procedure(), this.getProcedure(), null, "procedure", null, 0, 1, ProcedureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(procedureEClass, Procedure.class, "Procedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProcedure_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventRaisingEClass, EventRaising.class, "EventRaising", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventRaising_Event(), this.getSignalEvent(), null, "event", null, 0, 1, EventRaising.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanOrExpressionEClass, BooleanOrExpression.class, "BooleanOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBooleanOrExpression_Operand1(), this.getBooleanAndExpression(), null, "operand1", null, 0, 1, BooleanOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBooleanOrExpression_Operand2(), this.getBooleanAndExpression(), null, "operand2", null, 0, 1, BooleanOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanAndExpressionEClass, BooleanAndExpression.class, "BooleanAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBooleanAndExpression_Operand1(), this.getBitwiseXorExpression(), null, "operand1", null, 0, 1, BooleanAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBooleanAndExpression_Operand2(), this.getBitwiseXorExpression(), null, "operand2", null, 0, 1, BooleanAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseXorExpressionEClass, BitwiseXorExpression.class, "BitwiseXorExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseXorExpression_Operand1(), this.getBitwiseOrExpression(), null, "operand1", null, 0, 1, BitwiseXorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseXorExpression_Operand2(), this.getBitwiseOrExpression(), null, "operand2", null, 0, 1, BitwiseXorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseOrExpressionEClass, BitwiseOrExpression.class, "BitwiseOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseOrExpression_Operand1(), this.getBitwiseAndExpression(), null, "operand1", null, 0, 1, BitwiseOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseOrExpression_Operand2(), this.getBitwiseAndExpression(), null, "operand2", null, 0, 1, BitwiseOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseAndExpressionEClass, BitwiseAndExpression.class, "BitwiseAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseAndExpression_Operand1(), this.getEqualityExpression(), null, "operand1", null, 0, 1, BitwiseAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseAndExpression_Operand2(), this.getEqualityExpression(), null, "operand2", null, 0, 1, BitwiseAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityExpression_Operand1(), this.getRelationalExpression(), null, "operand1", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEqualityExpression_Operator(), this.getEqualityOperator(), "operator", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEqualityExpression_Operand2(), this.getRelationalExpression(), null, "operand2", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_Operand1(), this.getShiftExpression(), null, "operand1", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_Operator(), this.getRelationalOperator(), "operator", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalExpression_Operand2(), this.getShiftExpression(), null, "operand2", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpression_Operand1(), this.getBooleanOrExpression(), null, "operand1", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_Operand2(), this.getShiftExpression(), null, "operand2", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_Operand3(), this.getShiftExpression(), null, "operand3", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shiftExpressionEClass, ShiftExpression.class, "ShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShiftExpression_Operand1(), this.getAdditiveExpression(), null, "operand1", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShiftExpression_Operator(), this.getShiftOperator(), "operator", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShiftExpression_Operand2(), this.getAdditiveExpression(), null, "operand2", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdditiveExpression_Operand1(), this.getMultiplicativeExpression(), null, "operand1", null, 0, 1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdditiveExpression_Operator(), this.getAdditiveOperator(), "operator", null, 0, 1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdditiveExpression_Operand2(), this.getMultiplicativeExpression(), null, "operand2", null, 0, 1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicativeExpression_Operand1(), this.getUnaryExpression(), null, "operand1", null, 0, 1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicativeExpression_Operator(), this.getMultiplicativeOperator(), "operator", null, 0, 1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultiplicativeExpression_Operand2(), this.getUnaryExpression(), null, "operand2", null, 0, 1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryExpression_Operator(), this.getUnaryOperator(), "operator", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpression_Operand(), this.getPrimaryExpression(), null, "operand", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primaryExpressionEClass, PrimaryExpression.class, "PrimaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nestedExpressionEClass, NestedExpression.class, "NestedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedExpression_Expression(), this.getConditionalExpression(), null, "expression", null, 0, 1, NestedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalValueEClass, LiteralValue.class, "LiteralValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteralValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(timeUnitEEnum, TimeUnit.class, "TimeUnit");
    addEEnumLiteral(timeUnitEEnum, TimeUnit.SECOND);
    addEEnumLiteral(timeUnitEEnum, TimeUnit.MILLISECOND);
    addEEnumLiteral(timeUnitEEnum, TimeUnit.NANOSECOND);

    initEEnum(assignmentOperatorEEnum, AssignmentOperator.class, "AssignmentOperator");
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MULT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.DIV_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MOD_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ADD_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.SUB_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.LEFT_SHIFT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.RIGHT_SHIFT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.AND_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.XOR_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.OR_ASSIGN);

    initEEnum(equalityOperatorEEnum, EqualityOperator.class, "EqualityOperator");
    addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.EQUALS);
    addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.NOT_EQUALS);

    initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.SMALLER);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.SMALLER_EQUAL);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_EQUAL);

    initEEnum(shiftOperatorEEnum, ShiftOperator.class, "ShiftOperator");
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.LEFT);
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.RIGHT);

    initEEnum(additiveOperatorEEnum, AdditiveOperator.class, "AdditiveOperator");
    addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.PLUS);
    addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.MINUS);

    initEEnum(multiplicativeOperatorEEnum, MultiplicativeOperator.class, "MultiplicativeOperator");
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MUL);
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.DIV);
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MOD);

    initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.POSITIVE);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NEGATIVE);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.COMPLEMENT);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NOT);

    // Create resource
    createResource(eNS_URI);
  }

} //ExpressionsPackageImpl
