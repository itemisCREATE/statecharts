/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getTrueCase <em>True Case</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getFalseCase <em>False Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends Expression
{
  /**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getConditionalExpression_Condition()
	 * @model containment="true"
	 * @generated
	 */
  Expression getCondition();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
  void setCondition(Expression value);

  /**
	 * Returns the value of the '<em><b>True Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>True Case</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>True Case</em>' containment reference.
	 * @see #setTrueCase(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getConditionalExpression_TrueCase()
	 * @model containment="true"
	 * @generated
	 */
  Expression getTrueCase();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getTrueCase <em>True Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Case</em>' containment reference.
	 * @see #getTrueCase()
	 * @generated
	 */
  void setTrueCase(Expression value);

  /**
	 * Returns the value of the '<em><b>False Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>False Case</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>False Case</em>' containment reference.
	 * @see #setFalseCase(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getConditionalExpression_FalseCase()
	 * @model containment="true"
	 * @generated
	 */
  Expression getFalseCase();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getFalseCase <em>False Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Case</em>' containment reference.
	 * @see #getFalseCase()
	 * @generated
	 */
  void setFalseCase(Expression value);

} // ConditionalExpression
