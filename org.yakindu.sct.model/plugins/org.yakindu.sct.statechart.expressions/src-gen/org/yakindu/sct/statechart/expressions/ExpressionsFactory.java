/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionsFactory eINSTANCE = org.yakindu.sct.statechart.expressions.impl.ExpressionsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Statement Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement Model</em>'.
   * @generated
   */
  StatementModel createStatementModel();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Transition Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Definition</em>'.
   * @generated
   */
  TransitionDefinition createTransitionDefinition();

  /**
   * Returns a new object of class '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Definition</em>'.
   * @generated
   */
  VariableDefinition createVariableDefinition();

  /**
   * Returns a new object of class '<em>Action Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action Definition</em>'.
   * @generated
   */
  ActionDefinition createActionDefinition();

  /**
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>Time Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Constant</em>'.
   * @generated
   */
  TimeConstant createTimeConstant();

  /**
   * Returns a new object of class '<em>Expression Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Rule</em>'.
   * @generated
   */
  ExpressionRule createExpressionRule();

  /**
   * Returns a new object of class '<em>Raise Event Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Raise Event Expression</em>'.
   * @generated
   */
  RaiseEventExpression createRaiseEventExpression();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Or Expression</em>'.
   * @generated
   */
  LogicalOrExpression createLogicalOrExpression();

  /**
   * Returns a new object of class '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical And Expression</em>'.
   * @generated
   */
  LogicalAndExpression createLogicalAndExpression();

  /**
   * Returns a new object of class '<em>Logical Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Not Expression</em>'.
   * @generated
   */
  LogicalNotExpression createLogicalNotExpression();

  /**
   * Returns a new object of class '<em>Logical Relation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Relation Expression</em>'.
   * @generated
   */
  LogicalRelationExpression createLogicalRelationExpression();

  /**
   * Returns a new object of class '<em>Numerical Add Subtract Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Add Subtract Expression</em>'.
   * @generated
   */
  NumericalAddSubtractExpression createNumericalAddSubtractExpression();

  /**
   * Returns a new object of class '<em>Numerical Multiply Divide Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Multiply Divide Expression</em>'.
   * @generated
   */
  NumericalMultiplyDivideExpression createNumericalMultiplyDivideExpression();

  /**
   * Returns a new object of class '<em>Numerical Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Unary Expression</em>'.
   * @generated
   */
  NumericalUnaryExpression createNumericalUnaryExpression();

  /**
   * Returns a new object of class '<em>Primitive Value Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Value Expression</em>'.
   * @generated
   */
  PrimitiveValueExpression createPrimitiveValueExpression();

  /**
   * Returns a new object of class '<em>Property Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Reference Expression</em>'.
   * @generated
   */
  PropertyReferenceExpression createPropertyReferenceExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
