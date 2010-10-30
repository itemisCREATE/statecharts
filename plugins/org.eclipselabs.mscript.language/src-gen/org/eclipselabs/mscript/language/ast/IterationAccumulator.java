/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration Accumulator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationAccumulator#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationAccumulator#getInitialExpression <em>Initial Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationAccumulator()
 * @model
 * @generated
 */
public interface IterationAccumulator extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationAccumulator_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IterationAccumulator#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Initial Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Expression</em>' containment reference.
   * @see #setInitialExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationAccumulator_InitialExpression()
   * @model containment="true"
   * @generated
   */
  Expression getInitialExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IterationAccumulator#getInitialExpression <em>Initial Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Expression</em>' containment reference.
   * @see #getInitialExpression()
   * @generated
   */
  void setInitialExpression(Expression value);

} // IterationAccumulator
