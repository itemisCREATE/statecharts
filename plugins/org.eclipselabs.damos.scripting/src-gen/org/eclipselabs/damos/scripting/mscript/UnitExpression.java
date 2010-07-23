/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.UnitExpression#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.UnitExpression#getDenominator <em>Denominator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpression()
 * @model
 * @generated
 */
public interface UnitExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Numerator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Numerator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Numerator</em>' containment reference.
   * @see #setNumerator(UnitExpressionNumerator)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpression_Numerator()
   * @model containment="true"
   * @generated
   */
  UnitExpressionNumerator getNumerator();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.UnitExpression#getNumerator <em>Numerator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Numerator</em>' containment reference.
   * @see #getNumerator()
   * @generated
   */
  void setNumerator(UnitExpressionNumerator value);

  /**
   * Returns the value of the '<em><b>Denominator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Denominator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Denominator</em>' containment reference.
   * @see #setDenominator(UnitExpressionDenominator)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpression_Denominator()
   * @model containment="true"
   * @generated
   */
  UnitExpressionDenominator getDenominator();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.UnitExpression#getDenominator <em>Denominator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Denominator</em>' containment reference.
   * @see #getDenominator()
   * @generated
   */
  void setDenominator(UnitExpressionDenominator value);

} // UnitExpression
