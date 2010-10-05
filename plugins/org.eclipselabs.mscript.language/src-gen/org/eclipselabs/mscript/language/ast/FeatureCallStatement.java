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
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getAssignedValue <em>Assigned Value</em>}</li>
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
   * @see #setFeatureCall(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCallStatement_FeatureCall()
   * @model containment="true"
   * @generated
   */
  Expression getFeatureCall();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getFeatureCall <em>Feature Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature Call</em>' containment reference.
   * @see #getFeatureCall()
   * @generated
   */
  void setFeatureCall(Expression value);

  /**
   * Returns the value of the '<em><b>Assigned Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assigned Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assigned Value</em>' containment reference.
   * @see #setAssignedValue(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCallStatement_AssignedValue()
   * @model containment="true"
   * @generated
   */
  Expression getAssignedValue();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getAssignedValue <em>Assigned Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assigned Value</em>' containment reference.
   * @see #getAssignedValue()
   * @generated
   */
  void setAssignedValue(Expression value);

} // FeatureCallStatement
