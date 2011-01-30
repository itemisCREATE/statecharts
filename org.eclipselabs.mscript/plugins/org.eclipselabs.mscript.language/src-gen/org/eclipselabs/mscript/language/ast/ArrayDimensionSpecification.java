/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Dimension Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification()
 * @model
 * @generated
 */
public interface ArrayDimensionSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference.
   * @see #setSize(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification_Size()
   * @model containment="true"
   * @generated
   */
  Expression getSize();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getSize <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' containment reference.
   * @see #getSize()
   * @generated
   */
  void setSize(Expression value);

} // ArrayDimensionSpecification
