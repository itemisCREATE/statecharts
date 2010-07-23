/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.BooleanLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.damos.scripting.mscript.BooleanKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see org.eclipselabs.damos.scripting.mscript.BooleanKind
   * @see #setValue(BooleanKind)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getBooleanLiteral_Value()
   * @model
   * @generated
   */
  BooleanKind getValue();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.BooleanLiteral#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see org.eclipselabs.damos.scripting.mscript.BooleanKind
   * @see #getValue()
   * @generated
   */
  void setValue(BooleanKind value);

} // BooleanLiteral
