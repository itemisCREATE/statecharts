/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.NumericLiteral#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.NumericLiteral#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getNumericLiteral()
 * @model
 * @generated
 */
public interface NumericLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' attribute.
   * @see #setModifier(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getNumericLiteral_Modifier()
   * @model
   * @generated
   */
  String getModifier();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.NumericLiteral#getModifier <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier</em>' attribute.
   * @see #getModifier()
   * @generated
   */
  void setModifier(String value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getNumericLiteral_Unit()
   * @model containment="true"
   * @generated
   */
  UnitExpression getUnit();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.NumericLiteral#getUnit <em>Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' containment reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitExpression value);

} // NumericLiteral
