/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression Numerator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getOne <em>One</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpressionNumerator()
 * @model
 * @generated
 */
public interface UnitExpressionNumerator extends EObject
{
  /**
   * Returns the value of the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>One</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>One</em>' attribute.
   * @see #setOne(long)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpressionNumerator_One()
   * @model
   * @generated
   */
  long getOne();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getOne <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>One</em>' attribute.
   * @see #getOne()
   * @generated
   */
  void setOne(long value);

  /**
   * Returns the value of the '<em><b>Factors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factors</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpressionNumerator_Factors()
   * @model containment="true"
   * @generated
   */
  EList<UnitExpressionFactor> getFactors();

} // UnitExpressionNumerator
