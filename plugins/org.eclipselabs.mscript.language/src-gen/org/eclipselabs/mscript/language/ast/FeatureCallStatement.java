/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getFeatureCall <em>Feature Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#isAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCallStatement()
 * @model
 * @generated
 */
public interface FeatureCallStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Feature Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature Call</em>' containment reference.
   * @see #setFeatureCall(FeatureCall)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCallStatement_FeatureCall()
   * @model containment="true"
   * @generated
   */
  FeatureCall getFeatureCall();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getFeatureCall <em>Feature Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature Call</em>' containment reference.
   * @see #getFeatureCall()
   * @generated
   */
  void setFeatureCall(FeatureCall value);

  /**
   * Returns the value of the '<em><b>Assignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment</em>' attribute.
   * @see #setAssignment(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCallStatement_Assignment()
   * @model
   * @generated
   */
  boolean isAssignment();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#isAssignment <em>Assignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignment</em>' attribute.
   * @see #isAssignment()
   * @generated
   */
  void setAssignment(boolean value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCallStatement_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // FeatureCallStatement
