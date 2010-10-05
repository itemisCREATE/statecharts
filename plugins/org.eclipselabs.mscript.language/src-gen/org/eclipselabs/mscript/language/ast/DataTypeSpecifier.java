/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getDataTypeSpecifier()
 * @model
 * @generated
 */
public interface DataTypeSpecifier extends TypeSpecifier
{
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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getDataTypeSpecifier_Dimensions()
   * @model containment="true"
   * @generated
   */
  EList<ArrayDimensionSpecification> getDimensions();

} // DataTypeSpecifier
