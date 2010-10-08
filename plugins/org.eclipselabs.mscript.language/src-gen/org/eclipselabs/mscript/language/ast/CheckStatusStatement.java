/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Status Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckStatusStatement()
 * @model
 * @generated
 */
public interface CheckStatusStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.CheckStatusKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.CheckStatusKind
   * @see #setKind(CheckStatusKind)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckStatusStatement_Kind()
   * @model
   * @generated
   */
  CheckStatusKind getKind();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.CheckStatusKind
   * @see #getKind()
   * @generated
   */
  void setKind(CheckStatusKind value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' containment reference.
   * @see #setMessage(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckStatusStatement_Message()
   * @model containment="true"
   * @generated
   */
  Expression getMessage();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' containment reference.
   * @see #getMessage()
   * @generated
   */
  void setMessage(Expression value);

} // CheckStatusStatement
