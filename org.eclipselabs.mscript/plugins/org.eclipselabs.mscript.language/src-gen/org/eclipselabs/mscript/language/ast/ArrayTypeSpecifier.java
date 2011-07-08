/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayTypeSpecifier#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayTypeSpecifier#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayTypeSpecifier()
 * @model
 * @generated
 */
public interface ArrayTypeSpecifier extends DataTypeSpecifier
{
  /**
   * Returns the value of the '<em><b>Element Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Type</em>' containment reference.
   * @see #setElementType(ScalarTypeSpecifier)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayTypeSpecifier_ElementType()
   * @model containment="true"
   * @generated
   */
  ScalarTypeSpecifier getElementType();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayTypeSpecifier#getElementType <em>Element Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element Type</em>' containment reference.
   * @see #getElementType()
   * @generated
   */
  void setElementType(ScalarTypeSpecifier value);

  /**
   * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dimensions</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayTypeSpecifier_Dimensions()
   * @model containment="true"
   * @generated
   */
  EList<ArrayDimensionSpecification> getDimensions();

} // ArrayTypeSpecifier
