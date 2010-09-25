/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression Exponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent#isNegative <em>Negative</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnitExpressionExponent()
 * @model
 * @generated
 */
public interface UnitExpressionExponent extends EObject
{
  /**
   * Returns the value of the '<em><b>Negative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Negative</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negative</em>' attribute.
   * @see #setNegative(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnitExpressionExponent_Negative()
   * @model
   * @generated
   */
  boolean isNegative();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent#isNegative <em>Negative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Negative</em>' attribute.
   * @see #isNegative()
   * @generated
   */
  void setNegative(boolean value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(long)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnitExpressionExponent_Value()
   * @model
   * @generated
   */
  long getValue();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(long value);

} // UnitExpressionExponent
