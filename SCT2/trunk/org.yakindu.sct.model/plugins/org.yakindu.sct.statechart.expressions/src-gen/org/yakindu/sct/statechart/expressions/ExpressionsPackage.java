/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.statechart.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "expressions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.org/sct/statechart/Expressions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "expressions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionsPackage eINSTANCE = org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StatementModelImpl <em>Statement Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StatementModelImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatementModel()
   * @generated
   */
  int STATEMENT_MODEL = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_MODEL__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Statement Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StatementImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 1;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionDefinitionImpl <em>Transition Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.TransitionDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionDefinition()
   * @generated
   */
  int TRANSITION_DEFINITION = 2;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DEFINITION__TRIGGERS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DEFINITION__GUARD_EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Transition Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__TYPE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ActionDefinitionImpl <em>Action Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ActionDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getActionDefinition()
   * @generated
   */
  int ACTION_DEFINITION = 4;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_DEFINITION__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Action Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EventImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__DIRECTION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__TIME = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.TimeConstantImpl <em>Time Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.TimeConstantImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeConstant()
   * @generated
   */
  int TIME_CONSTANT = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_CONSTANT__VALUE = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_CONSTANT__UNIT = 1;

  /**
   * The number of structural features of the '<em>Time Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_CONSTANT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl <em>Expression Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpressionRule()
   * @generated
   */
  int EXPRESSION_RULE = 7;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_RULE__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Expression Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl <em>Raise Event Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRaiseEventExpression()
   * @generated
   */
  int RAISE_EVENT_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RAISE_EVENT_EXPRESSION__EVENT = 0;

  /**
   * The number of structural features of the '<em>Raise Event Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RAISE_EVENT_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 9;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Logical Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Logical And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalNotExpression()
   * @generated
   */
  int LOGICAL_NOT_EXPRESSION = 12;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_NOT_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalRelationExpression()
   * @generated
   */
  int LOGICAL_RELATION_EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Logical Relation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalAddSubtractExpression()
   * @generated
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION = 14;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Numerical Add Subtract Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalMultiplyDivideExpression()
   * @generated
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Numerical Multiply Divide Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalUnaryExpression()
   * @generated
   */
  int NUMERICAL_UNARY_EXPRESSION = 16;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numerical Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPrimitiveValueExpression()
   * @generated
   */
  int PRIMITIVE_VALUE_EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_VALUE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Primitive Value Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl <em>Property Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPropertyReferenceExpression()
   * @generated
   */
  int PROPERTY_REFERENCE_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 19;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 20;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 21;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.RelationalOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 22;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.DirectionKind <em>Direction Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.DirectionKind
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirectionKind()
   * @generated
   */
  int DIRECTION_KIND = 23;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.TimeUnit
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeUnit()
   * @generated
   */
  int TIME_UNIT = 24;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getType()
   * @generated
   */
  int TYPE = 25;


  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StatementModel <em>Statement Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement Model</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatementModel
   * @generated
   */
  EClass getStatementModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.StatementModel#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatementModel#getStatements()
   * @see #getStatementModel()
   * @generated
   */
  EReference getStatementModel_Statements();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.yakindu.sct.statechart.expressions.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.TransitionDefinition <em>Transition Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionDefinition
   * @generated
   */
  EClass getTransitionDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.TransitionDefinition#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionDefinition#getTriggers()
   * @see #getTransitionDefinition()
   * @generated
   */
  EReference getTransitionDefinition_Triggers();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.TransitionDefinition#getGuardExpression <em>Guard Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionDefinition#getGuardExpression()
   * @see #getTransitionDefinition()
   * @generated
   */
  EReference getTransitionDefinition_GuardExpression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#getName()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#getType()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Type();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ActionDefinition <em>Action Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.ActionDefinition
   * @generated
   */
  EClass getActionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.ActionDefinition#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ActionDefinition#getExpression()
   * @see #getActionDefinition()
   * @generated
   */
  EReference getActionDefinition_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Event#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.Event#getName()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Name();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Event#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.yakindu.sct.statechart.expressions.Event#getDirection()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Direction();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.Event#getTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Time</em>'.
   * @see org.yakindu.sct.statechart.expressions.Event#getTime()
   * @see #getEvent()
   * @generated
   */
  EReference getEvent_Time();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.TimeConstant <em>Time Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Constant</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeConstant
   * @generated
   */
  EClass getTimeConstant();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.TimeConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeConstant#getValue()
   * @see #getTimeConstant()
   * @generated
   */
  EAttribute getTimeConstant_Value();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.TimeConstant#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeConstant#getUnit()
   * @see #getTimeConstant()
   * @generated
   */
  EAttribute getTimeConstant_Unit();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ExpressionRule <em>Expression Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Rule</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExpressionRule
   * @generated
   */
  EClass getExpressionRule();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.ExpressionRule#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExpressionRule#getExpression()
   * @see #getExpressionRule()
   * @generated
   */
  EReference getExpressionRule_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.RaiseEventExpression <em>Raise Event Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Raise Event Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.RaiseEventExpression
   * @generated
   */
  EClass getRaiseEventExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.RaiseEventExpression#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.RaiseEventExpression#getEvent()
   * @see #getRaiseEventExpression()
   * @generated
   */
  EReference getRaiseEventExpression_Event();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalOrExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalOrExpression#getLeftOperand()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalOrExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalOrExpression#getRightOperand()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalAndExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalAndExpression#getLeftOperand()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalAndExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalAndExpression#getRightOperand()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalNotExpression <em>Logical Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Not Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalNotExpression
   * @generated
   */
  EClass getLogicalNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalNotExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalNotExpression#getOperand()
   * @see #getLogicalNotExpression()
   * @generated
   */
  EReference getLogicalNotExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression <em>Logical Relation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Relation Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression
   * @generated
   */
  EClass getLogicalRelationExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getLeftOperand()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EReference getLogicalRelationExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getOperator()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EAttribute getLogicalRelationExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getRightOperand()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EReference getLogicalRelationExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression <em>Numerical Add Subtract Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Add Subtract Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression
   * @generated
   */
  EClass getNumericalAddSubtractExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getLeftOperand()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EReference getNumericalAddSubtractExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getOperator()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EAttribute getNumericalAddSubtractExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getRightOperand()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EReference getNumericalAddSubtractExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression <em>Numerical Multiply Divide Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Multiply Divide Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression
   * @generated
   */
  EClass getNumericalMultiplyDivideExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getLeftOperand()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EReference getNumericalMultiplyDivideExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getOperator()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EAttribute getNumericalMultiplyDivideExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getRightOperand()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EReference getNumericalMultiplyDivideExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.NumericalUnaryExpression <em>Numerical Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Unary Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalUnaryExpression
   * @generated
   */
  EClass getNumericalUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperator()
   * @see #getNumericalUnaryExpression()
   * @generated
   */
  EAttribute getNumericalUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperand()
   * @see #getNumericalUnaryExpression()
   * @generated
   */
  EReference getNumericalUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Value Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.PrimitiveValueExpression
   * @generated
   */
  EClass getPrimitiveValueExpression();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.PrimitiveValueExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.PrimitiveValueExpression#getValue()
   * @see #getPrimitiveValueExpression()
   * @generated
   */
  EAttribute getPrimitiveValueExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.PropertyReferenceExpression <em>Property Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Reference Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.PropertyReferenceExpression
   * @generated
   */
  EClass getPropertyReferenceExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.PropertyReferenceExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.PropertyReferenceExpression#getValue()
   * @see #getPropertyReferenceExpression()
   * @generated
   */
  EReference getPropertyReferenceExpression_Value();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Additive Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @generated
   */
  EEnum getAdditiveOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplicative Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
   * @generated
   */
  EEnum getMultiplicativeOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @generated
   */
  EEnum getUnaryOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.DirectionKind <em>Direction Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Direction Kind</em>'.
   * @see org.yakindu.sct.statechart.expressions.DirectionKind
   * @generated
   */
  EEnum getDirectionKind();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Time Unit</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeUnit
   * @generated
   */
  EEnum getTimeUnit();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Type</em>'.
   * @see org.yakindu.sct.statechart.expressions.Type
   * @generated
   */
  EEnum getType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExpressionsFactory getExpressionsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StatementModelImpl <em>Statement Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StatementModelImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatementModel()
     * @generated
     */
    EClass STATEMENT_MODEL = eINSTANCE.getStatementModel();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT_MODEL__STATEMENTS = eINSTANCE.getStatementModel_Statements();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StatementImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionDefinitionImpl <em>Transition Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.TransitionDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionDefinition()
     * @generated
     */
    EClass TRANSITION_DEFINITION = eINSTANCE.getTransitionDefinition();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DEFINITION__TRIGGERS = eINSTANCE.getTransitionDefinition_Triggers();

    /**
     * The meta object literal for the '<em><b>Guard Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DEFINITION__GUARD_EXPRESSION = eINSTANCE.getTransitionDefinition_GuardExpression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getVariableDefinition()
     * @generated
     */
    EClass VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__NAME = eINSTANCE.getVariableDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__TYPE = eINSTANCE.getVariableDefinition_Type();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ActionDefinitionImpl <em>Action Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ActionDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getActionDefinition()
     * @generated
     */
    EClass ACTION_DEFINITION = eINSTANCE.getActionDefinition();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_DEFINITION__EXPRESSION = eINSTANCE.getActionDefinition_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EventImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__DIRECTION = eINSTANCE.getEvent_Direction();

    /**
     * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT__TIME = eINSTANCE.getEvent_Time();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.TimeConstantImpl <em>Time Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.TimeConstantImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeConstant()
     * @generated
     */
    EClass TIME_CONSTANT = eINSTANCE.getTimeConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_CONSTANT__VALUE = eINSTANCE.getTimeConstant_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_CONSTANT__UNIT = eINSTANCE.getTimeConstant_Unit();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl <em>Expression Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpressionRule()
     * @generated
     */
    EClass EXPRESSION_RULE = eINSTANCE.getExpressionRule();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_RULE__EXPRESSION = eINSTANCE.getExpressionRule_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl <em>Raise Event Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRaiseEventExpression()
     * @generated
     */
    EClass RAISE_EVENT_EXPRESSION = eINSTANCE.getRaiseEventExpression();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RAISE_EVENT_EXPRESSION__EVENT = eINSTANCE.getRaiseEventExpression_Event();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
     * @generated
     */
    EClass LOGICAL_OR_EXPRESSION = eINSTANCE.getLogicalOrExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__LEFT_OPERAND = eINSTANCE.getLogicalOrExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getLogicalOrExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalAndExpression()
     * @generated
     */
    EClass LOGICAL_AND_EXPRESSION = eINSTANCE.getLogicalAndExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__LEFT_OPERAND = eINSTANCE.getLogicalAndExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getLogicalAndExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalNotExpression()
     * @generated
     */
    EClass LOGICAL_NOT_EXPRESSION = eINSTANCE.getLogicalNotExpression();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_NOT_EXPRESSION__OPERAND = eINSTANCE.getLogicalNotExpression_Operand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalRelationExpression()
     * @generated
     */
    EClass LOGICAL_RELATION_EXPRESSION = eINSTANCE.getLogicalRelationExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND = eINSTANCE.getLogicalRelationExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_RELATION_EXPRESSION__OPERATOR = eINSTANCE.getLogicalRelationExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getLogicalRelationExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalAddSubtractExpression()
     * @generated
     */
    EClass NUMERICAL_ADD_SUBTRACT_EXPRESSION = eINSTANCE.getNumericalAddSubtractExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND = eINSTANCE.getNumericalAddSubtractExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR = eINSTANCE.getNumericalAddSubtractExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getNumericalAddSubtractExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalMultiplyDivideExpression()
     * @generated
     */
    EClass NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = eINSTANCE.getNumericalMultiplyDivideExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getNumericalMultiplyDivideExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR = eINSTANCE.getNumericalMultiplyDivideExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getNumericalMultiplyDivideExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalUnaryExpression()
     * @generated
     */
    EClass NUMERICAL_UNARY_EXPRESSION = eINSTANCE.getNumericalUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_UNARY_EXPRESSION__OPERATOR = eINSTANCE.getNumericalUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_UNARY_EXPRESSION__OPERAND = eINSTANCE.getNumericalUnaryExpression_Operand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPrimitiveValueExpression()
     * @generated
     */
    EClass PRIMITIVE_VALUE_EXPRESSION = eINSTANCE.getPrimitiveValueExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_VALUE_EXPRESSION__VALUE = eINSTANCE.getPrimitiveValueExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl <em>Property Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPropertyReferenceExpression()
     * @generated
     */
    EClass PROPERTY_REFERENCE_EXPRESSION = eINSTANCE.getPropertyReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_REFERENCE_EXPRESSION__VALUE = eINSTANCE.getPropertyReferenceExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
     * @generated
     */
    EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
     * @generated
     */
    EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.UnaryOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
     * @generated
     */
    EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.RelationalOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.DirectionKind <em>Direction Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.DirectionKind
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirectionKind()
     * @generated
     */
    EEnum DIRECTION_KIND = eINSTANCE.getDirectionKind();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.TimeUnit
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeUnit()
     * @generated
     */
    EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.Type
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getType()
     * @generated
     */
    EEnum TYPE = eINSTANCE.getType();

  }

} //ExpressionsPackage
