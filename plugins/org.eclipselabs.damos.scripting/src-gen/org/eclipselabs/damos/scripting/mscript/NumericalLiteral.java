/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.NumericalLiteral#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getNumericalLiteral()
 * @model
 * @generated
 */
public interface NumericalLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' containment reference.
   * @see #setUnit(UnitExpression)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getNumericalLiteral_Unit()
   * @model containment="true"
   * @generated
   */
  UnitExpression getUnit();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.NumericalLiteral#getUnit <em>Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' containment reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitExpression value);

} // NumericalLiteral
