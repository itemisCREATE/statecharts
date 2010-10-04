/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableModifier#getAuto <em>Auto</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableModifier#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableModifier#getStatic <em>Static</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableModifier()
 * @model
 * @generated
 */
public interface VariableModifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Auto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auto</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auto</em>' attribute.
   * @see #setAuto(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableModifier_Auto()
   * @model
   * @generated
   */
  String getAuto();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableModifier#getAuto <em>Auto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Auto</em>' attribute.
   * @see #getAuto()
   * @generated
   */
  void setAuto(String value);

  /**
   * Returns the value of the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' attribute.
   * @see #setConstant(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableModifier_Constant()
   * @model
   * @generated
   */
  String getConstant();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableModifier#getConstant <em>Constant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constant</em>' attribute.
   * @see #getConstant()
   * @generated
   */
  void setConstant(String value);

  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Static</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableModifier_Static()
   * @model
   * @generated
   */
  String getStatic();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableModifier#getStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #getStatic()
   * @generated
   */
  void setStatic(String value);

} // VariableModifier
