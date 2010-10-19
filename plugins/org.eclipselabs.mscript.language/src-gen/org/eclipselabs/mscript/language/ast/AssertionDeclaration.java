/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assertion Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AssertionDeclaration#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AssertionDeclaration#getStatusKind <em>Status Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AssertionDeclaration#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssertionDeclaration()
 * @model
 * @generated
 */
public interface AssertionDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate</em>' containment reference.
   * @see #setPredicate(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssertionDeclaration_Predicate()
   * @model containment="true"
   * @generated
   */
  Expression getPredicate();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AssertionDeclaration#getPredicate <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate</em>' containment reference.
   * @see #getPredicate()
   * @generated
   */
  void setPredicate(Expression value);

  /**
   * Returns the value of the '<em><b>Status Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.AssertionStatusKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status Kind</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.AssertionStatusKind
   * @see #setStatusKind(AssertionStatusKind)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssertionDeclaration_StatusKind()
   * @model
   * @generated
   */
  AssertionStatusKind getStatusKind();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AssertionDeclaration#getStatusKind <em>Status Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status Kind</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.AssertionStatusKind
   * @see #getStatusKind()
   * @generated
   */
  void setStatusKind(AssertionStatusKind value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssertionDeclaration_Message()
   * @model containment="true"
   * @generated
   */
  Expression getMessage();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AssertionDeclaration#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' containment reference.
   * @see #getMessage()
   * @generated
   */
  void setMessage(Expression value);

} // AssertionDeclaration
