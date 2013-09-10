/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getVarRef <em>Var Ref</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getAssignmentExpression()
 * @model
 * @generated
 */
public interface AssignmentExpression extends Expression
{
  /**
	 * Returns the value of the '<em><b>Var Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Ref</em>' containment reference.
	 * @see #setVarRef(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getAssignmentExpression_VarRef()
	 * @model containment="true"
	 * @generated
	 */
  Expression getVarRef();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getVarRef <em>Var Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Ref</em>' containment reference.
	 * @see #getVarRef()
	 * @generated
	 */
  void setVarRef(Expression value);

  /**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.AssignmentOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.AssignmentOperator
	 * @see #setOperator(AssignmentOperator)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getAssignmentExpression_Operator()
	 * @model
	 * @generated
	 */
  AssignmentOperator getOperator();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.AssignmentOperator
	 * @see #getOperator()
	 * @generated
	 */
  void setOperator(AssignmentOperator value);

  /**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getAssignmentExpression_Expression()
	 * @model containment="true"
	 * @generated
	 */
  Expression getExpression();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
  void setExpression(Expression value);

} // AssignmentExpression
