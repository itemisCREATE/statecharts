/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getAccumulatorName <em>Accumulator Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getElementDeclaration()
 * @model
 * @generated
 */
public interface ElementDeclaration extends IteratorCall
{
  /**
   * Returns the value of the '<em><b>Element Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Name</em>' attribute.
   * @see #setElementName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getElementDeclaration_ElementName()
   * @model
   * @generated
   */
  String getElementName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getElementName <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element Name</em>' attribute.
   * @see #getElementName()
   * @generated
   */
  void setElementName(String value);

  /**
   * Returns the value of the '<em><b>Accumulator Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accumulator Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Accumulator Name</em>' attribute.
   * @see #setAccumulatorName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getElementDeclaration_AccumulatorName()
   * @model
   * @generated
   */
  String getAccumulatorName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getAccumulatorName <em>Accumulator Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accumulator Name</em>' attribute.
   * @see #getAccumulatorName()
   * @generated
   */
  void setAccumulatorName(String value);

  /**
   * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Value</em>' containment reference.
   * @see #setInitialValue(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getElementDeclaration_InitialValue()
   * @model containment="true"
   * @generated
   */
  Expression getInitialValue();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getInitialValue <em>Initial Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Value</em>' containment reference.
   * @see #getInitialValue()
   * @generated
   */
  void setInitialValue(Expression value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getElementDeclaration_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ElementDeclaration#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // ElementDeclaration
