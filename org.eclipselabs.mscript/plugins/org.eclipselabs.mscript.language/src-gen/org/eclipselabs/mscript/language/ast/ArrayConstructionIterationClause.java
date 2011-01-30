/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Construction Iteration Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getCollectionExpression <em>Collection Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayConstructionIterationClause()
 * @model
 * @generated
 */
public interface ArrayConstructionIterationClause extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Name</em>' attribute.
   * @see #setVariableName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayConstructionIterationClause_VariableName()
   * @model
   * @generated
   */
  String getVariableName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getVariableName <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Name</em>' attribute.
   * @see #getVariableName()
   * @generated
   */
  void setVariableName(String value);

  /**
   * Returns the value of the '<em><b>Collection Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collection Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collection Expression</em>' containment reference.
   * @see #setCollectionExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayConstructionIterationClause_CollectionExpression()
   * @model containment="true"
   * @generated
   */
  Expression getCollectionExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getCollectionExpression <em>Collection Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collection Expression</em>' containment reference.
   * @see #getCollectionExpression()
   * @generated
   */
  void setCollectionExpression(Expression value);

} // ArrayConstructionIterationClause
