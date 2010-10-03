/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureReference#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureReference()
 * @model
 * @generated
 */
public interface FeatureReference extends FeatureCallPart
{
  /**
   * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature Name</em>' attribute.
   * @see #setFeatureName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureReference_FeatureName()
   * @model
   * @generated
   */
  String getFeatureName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureReference#getFeatureName <em>Feature Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature Name</em>' attribute.
   * @see #getFeatureName()
   * @generated
   */
  void setFeatureName(String value);

} // FeatureReference
