/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression Denominator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.UnitExpressionDenominator#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnitExpressionDenominator()
 * @model
 * @generated
 */
public interface UnitExpressionDenominator extends EObject
{
  /**
   * Returns the value of the '<em><b>Factors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.UnitExpressionFactor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factors</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnitExpressionDenominator_Factors()
   * @model containment="true"
   * @generated
   */
  EList<UnitExpressionFactor> getFactors();

} // UnitExpressionDenominator
