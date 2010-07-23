/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpressionFactor()
 * @model
 * @generated
 */
public interface UnitExpressionFactor extends EObject
{
  /**
   * Returns the value of the '<em><b>Operand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' attribute.
   * @see #setOperand(String)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpressionFactor_Operand()
   * @model
   * @generated
   */
  String getOperand();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getOperand <em>Operand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' attribute.
   * @see #getOperand()
   * @generated
   */
  void setOperand(String value);

  /**
   * Returns the value of the '<em><b>Exponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exponent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exponent</em>' containment reference.
   * @see #setExponent(UnitExpressionExponent)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getUnitExpressionFactor_Exponent()
   * @model containment="true"
   * @generated
   */
  UnitExpressionExponent getExponent();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getExponent <em>Exponent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exponent</em>' containment reference.
   * @see #getExponent()
   * @generated
   */
  void setExponent(UnitExpressionExponent value);

} // UnitExpressionFactor
