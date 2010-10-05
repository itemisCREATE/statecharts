/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RangeExpression#getBegin <em>Begin</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RangeExpression#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RangeExpression#getIncrement <em>Increment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeExpression()
 * @model
 * @generated
 */
public interface RangeExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Begin</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Begin</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Begin</em>' containment reference.
   * @see #setBegin(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeExpression_Begin()
   * @model containment="true"
   * @generated
   */
  Expression getBegin();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getBegin <em>Begin</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Begin</em>' containment reference.
   * @see #getBegin()
   * @generated
   */
  void setBegin(Expression value);

  /**
   * Returns the value of the '<em><b>End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' containment reference.
   * @see #setEnd(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeExpression_End()
   * @model containment="true"
   * @generated
   */
  Expression getEnd();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getEnd <em>End</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' containment reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Expression value);

  /**
   * Returns the value of the '<em><b>Increment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Increment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Increment</em>' containment reference.
   * @see #setIncrement(RangeExpression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeExpression_Increment()
   * @model containment="true"
   * @generated
   */
  RangeExpression getIncrement();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getIncrement <em>Increment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Increment</em>' containment reference.
   * @see #getIncrement()
   * @generated
   */
  void setIncrement(RangeExpression value);

} // RangeExpression
